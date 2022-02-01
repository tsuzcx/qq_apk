package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveSquareMoreFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI12;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "nearbyLiveSquareMoreFragment", "Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "showNearbyLiveSquareFragment", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI12
  extends MMFinderUI
{
  public static final a ueb;
  private HashMap _$_findViewCache;
  private final NearbyLiveSquareMoreFragment uea;
  
  static
  {
    AppMethodBeat.i(245669);
    ueb = new a((byte)0);
    AppMethodBeat.o(245669);
  }
  
  public OccupyFinderUI12()
  {
    AppMethodBeat.i(245668);
    this.uea = new NearbyLiveSquareMoreFragment();
    AppMethodBeat.o(245668);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245671);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245671);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245670);
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
    AppMethodBeat.o(245670);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245667);
    d locald = d.uTq;
    d.dlC();
    super.finish();
    AppMethodBeat.o(245667);
  }
  
  public final int getLayoutId()
  {
    return 2131495826;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245666);
    super.onCreate(paramBundle);
    setMMTitle(2131763474);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    NearbyLiveSquareMoreFragment localNearbyLiveSquareMoreFragment = this.uea;
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getExtras();; paramBundle = null)
    {
      localNearbyLiveSquareMoreFragment.setArguments(paramBundle);
      getSupportFragmentManager().beginTransaction().a(2131301565, (Fragment)this.uea).b((Fragment)this.uea).commitAllowingStateLoss();
      AppMethodBeat.o(245666);
      return;
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(245665);
    super.onNewIntent(paramIntent);
    NearbyLiveSquareMoreFragment localNearbyLiveSquareMoreFragment = this.uea;
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getExtras();; paramIntent = null)
    {
      localNearbyLiveSquareMoreFragment.setArguments(paramIntent);
      AppMethodBeat.o(245665);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI12$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(OccupyFinderUI12 paramOccupyFinderUI12) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245664);
      this.uec.finish();
      AppMethodBeat.o(245664);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI12
 * JD-Core Version:    0.7.0.1
 */