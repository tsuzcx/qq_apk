package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.live.square.operation.FinderLiveOperationFragment;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLiveFindPageFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/operation/FinderLiveOperationFragment;", "finishEvent", "", "isForceNightMode", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"})
public final class FinderLiveOperationUI
  extends MMFinderUI
{
  public static final a xPu;
  private HashMap _$_findViewCache;
  private final FinderLiveOperationFragment xPs;
  private boolean xPt;
  private boolean xnL;
  
  static
  {
    AppMethodBeat.i(203986);
    xPu = new a((byte)0);
    AppMethodBeat.o(203986);
  }
  
  public FinderLiveOperationUI()
  {
    AppMethodBeat.i(203983);
    this.xPs = new FinderLiveOperationFragment();
    AppMethodBeat.o(203983);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(203988);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(203988);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203987);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(203987);
    return localView1;
  }
  
  public final String dvl()
  {
    return "FinderLiveOperationUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203978);
    this.xPt = true;
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMB();
    super.finish();
    AppMethodBeat.o(203978);
  }
  
  public final int getLayoutId()
  {
    if (this.xnL) {
      return f.e.zDe;
    }
    return f.e.zDd;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    boolean bool = true;
    AppMethodBeat.i(203977);
    Object localObject;
    if (getIntent().getIntExtra("key_use_dark_style", 1) == 1)
    {
      this.xnL = bool;
      super.onCreate(paramBundle);
      paramBundle = getSupportActionBar();
      if (paramBundle != null) {
        paramBundle.hide();
      }
      if (this.xnL)
      {
        paramBundle = getController();
        localObject = getContext();
        p.j(localObject, "context");
        paramBundle.setActionbarColor(((AppCompatActivity)localObject).getResources().getColor(f.a.Dark_0));
        setBackGroundColorResource(f.a.Dark_0);
      }
      findViewById(f.d.zCT).setOnClickListener((View.OnClickListener)new FinderLiveOperationUI.b(this));
      paramBundle = (TextView)findViewById(f.d.zCY);
      float f = a.aZ((Context)getContext(), a.e.ActionBarTextSize);
      paramBundle.setTextSize(0, a.km((Context)getContext()) * f);
      paramBundle = getIntent().getStringExtra("key_page_title");
      if (!TextUtils.isEmpty((CharSequence)paramBundle))
      {
        localObject = findViewById(f.d.zCY);
        p.j(localObject, "findViewById<TextView>(R.id.finder_live_title)");
        ((TextView)localObject).setText((CharSequence)paramBundle);
      }
      paramBundle = findViewById(f.d.searchEntrance);
      p.j(paramBundle, "findViewById<View>(R.id.searchEntrance)");
      paramBundle.setVisibility(4);
      localObject = this.xPs;
      paramBundle = getIntent();
      if (paramBundle == null) {
        break label300;
      }
    }
    label300:
    for (paramBundle = paramBundle.getExtras();; paramBundle = null)
    {
      ((FinderLiveOperationFragment)localObject).setArguments(paramBundle);
      getSupportFragmentManager().beginTransaction().a(f.d.fl_container, (Fragment)this.xPs).c((Fragment)this.xPs).ip();
      this.xPt = false;
      AppMethodBeat.o(203977);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(203974);
    super.onNewIntent(paramIntent);
    FinderLiveOperationFragment localFinderLiveOperationFragment = this.xPs;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      localFinderLiveOperationFragment.setArguments(paramIntent);
      AppMethodBeat.o(203974);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(203980);
    super.onPause();
    if (this.xPt)
    {
      c.a locala = c.wkV;
      c.nq(false);
    }
    AppMethodBeat.o(203980);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203979);
    c.a locala = c.wkV;
    c.nq(true);
    super.onResume();
    AppMethodBeat.o(203979);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveOperationUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveOperationUI
 * JD-Core Version:    0.7.0.1
 */