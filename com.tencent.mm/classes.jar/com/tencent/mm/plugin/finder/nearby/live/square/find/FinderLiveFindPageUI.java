package com.tencent.mm.plugin.finder.nearby.live.square.find;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.nearby.b;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finderLiveFindPageFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageFragment;", "finishEvent", "", "isForceNightMode", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"})
public final class FinderLiveFindPageUI
  extends MMFinderUI
{
  public static final a zGu;
  private HashMap _$_findViewCache;
  private boolean xPt;
  private final boolean xnL;
  private final FinderLiveFindPageFragment zGt;
  
  static
  {
    AppMethodBeat.i(200369);
    zGu = new a((byte)0);
    AppMethodBeat.o(200369);
  }
  
  public FinderLiveFindPageUI()
  {
    AppMethodBeat.i(200368);
    this.zGt = new FinderLiveFindPageFragment();
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    this.xnL = com.tencent.mm.plugin.finder.nearby.abtest.a.dLo();
    AppMethodBeat.o(200368);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(200374);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(200374);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(200372);
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
    AppMethodBeat.o(200372);
    return localView1;
  }
  
  public final String dvl()
  {
    return "FinderLiveFindPageUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(200365);
    this.xPt = true;
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMB();
    super.finish();
    AppMethodBeat.o(200365);
  }
  
  public final int getLayoutId()
  {
    if (this.xnL) {
      return f.e.zDe;
    }
    return f.e.zDd;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(200356);
    Set localSet = ak.setOf(b.class);
    AppMethodBeat.o(200356);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200361);
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
    findViewById(f.d.zCT).setOnClickListener((View.OnClickListener)new FinderLiveFindPageUI.b(this));
    paramBundle = (TextView)findViewById(f.d.zCY);
    float f = com.tencent.mm.ci.a.aZ((Context)getContext(), a.e.ActionBarTextSize);
    paramBundle.setTextSize(0, com.tencent.mm.ci.a.km((Context)getContext()) * f);
    Object localObject = this.zGt;
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      ((FinderLiveFindPageFragment)localObject).setArguments(paramBundle);
      paramBundle = this.zGt.getArguments();
      if (paramBundle != null) {
        if (!this.xnL) {
          break label277;
        }
      }
    }
    label277:
    for (int i = 1;; i = 0)
    {
      paramBundle.putInt("key_use_dark_style", i);
      getSupportFragmentManager().beginTransaction().a(f.d.fl_container, (Fragment)this.zGt).c((Fragment)this.zGt).ip();
      this.zGt.ar((Activity)this);
      paramBundle = h.ag(PluginFinder.class);
      p.j(paramBundle, "MMKernel.plugin(PluginFinder::class.java)");
      ((PluginFinder)paramBundle).getRedDotManager().aBd("FinderLiveEntrance");
      this.xPt = false;
      AppMethodBeat.o(200361);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(200354);
    super.onNewIntent(paramIntent);
    FinderLiveFindPageFragment localFinderLiveFindPageFragment = this.zGt;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      localFinderLiveFindPageFragment.setArguments(paramIntent);
      AppMethodBeat.o(200354);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(200367);
    super.onPause();
    if (this.xPt)
    {
      c.a locala = c.wkV;
      c.nq(false);
    }
    AppMethodBeat.o(200367);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(200366);
    c.a locala = c.wkV;
    c.nq(true);
    super.onResume();
    AppMethodBeat.o(200366);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/find/FinderLiveFindPageUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI
 * JD-Core Version:    0.7.0.1
 */