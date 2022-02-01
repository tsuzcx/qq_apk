package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.nearby.f.a;
import com.tencent.mm.plugin.finder.nearby.f.d;
import com.tencent.mm.plugin.finder.nearby.f.e;
import com.tencent.mm.plugin.finder.nearby.f.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "finishEvent", "", "isForceNightMode", "nearbyLiveSquareMoreFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "adapteNightMode", "", "finish", "getLayoutId", "", "getReportTag", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "showNearbyLiveSquareFragment", "Companion", "plugin-finder-nearby_release"})
public final class NearbyLiveMoreUI
  extends MMFinderUI
{
  public static final a zGx;
  private HashMap _$_findViewCache;
  private boolean xPt;
  private boolean xnL;
  private final NearbyLiveSquareMoreFragment zGw;
  
  static
  {
    AppMethodBeat.i(202241);
    zGx = new a((byte)0);
    AppMethodBeat.o(202241);
  }
  
  public NearbyLiveMoreUI()
  {
    AppMethodBeat.i(202239);
    this.zGw = new NearbyLiveSquareMoreFragment();
    this.xnL = true;
    AppMethodBeat.o(202239);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(202245);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(202245);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202244);
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
    AppMethodBeat.o(202244);
    return localView1;
  }
  
  public final String dvl()
  {
    return "NearbyLiveMoreUI";
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202231);
    this.xPt = true;
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.dMB();
    super.finish();
    AppMethodBeat.o(202231);
  }
  
  public final int getLayoutId()
  {
    return f.e.zDi;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202229);
    super.onCreate(paramBundle);
    setMMTitle(f.h.nearby_more_live);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    if (this.xnL)
    {
      paramBundle = getController();
      localObject = getContext();
      p.j(localObject, "context");
      paramBundle.setActionbarColor(((AppCompatActivity)localObject).getResources().getColor(f.a.Dark_0));
      setBackGroundColorResource(f.a.Dark_0);
      paramBundle = getContext();
      p.j(paramBundle, "context");
      setActionbarColor(paramBundle.getResources().getColor(f.a.Dark_0));
      findViewById(f.d.root_scroll).setBackgroundColor(getResources().getColor(f.a.Dark_0));
    }
    Object localObject = this.zGw;
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      ((NearbyLiveSquareMoreFragment)localObject).setArguments(paramBundle);
      paramBundle = this.zGw.getArguments();
      if (paramBundle != null) {
        if (!this.xnL) {
          break label223;
        }
      }
    }
    label223:
    for (int i = 1;; i = 0)
    {
      paramBundle.putInt("key_use_dark_style", i);
      getSupportFragmentManager().beginTransaction().a(f.d.fl_container, (Fragment)this.zGw).c((Fragment)this.zGw).ip();
      this.xPt = false;
      AppMethodBeat.o(202229);
      return;
      paramBundle = null;
      break;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(202218);
    super.onNewIntent(paramIntent);
    NearbyLiveSquareMoreFragment localNearbyLiveSquareMoreFragment = this.zGw;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      localNearbyLiveSquareMoreFragment.setArguments(paramIntent);
      AppMethodBeat.o(202218);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(202236);
    super.onPause();
    if (this.xPt)
    {
      c.a locala = c.wkV;
      c.nq(false);
    }
    AppMethodBeat.o(202236);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(202234);
    c.a locala = c.wkV;
    c.nq(true);
    super.onResume();
    AppMethodBeat.o(202234);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreUI$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(NearbyLiveMoreUI paramNearbyLiveMoreUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(199543);
      this.zGy.finish();
      AppMethodBeat.o(199543);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUI
 * JD-Core Version:    0.7.0.1
 */