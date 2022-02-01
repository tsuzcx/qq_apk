package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveTagFragment;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI7;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveTagFragment;)V", "commitFragment", "", "finish", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder_release"})
public final class OccupyFinderUI7
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLiveTagUI";
  private HashMap _$_findViewCache;
  private FinderLiveTagFragment ueS;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245760);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245760);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245759);
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
    AppMethodBeat.o(245759);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245758);
    Object localObject = this.ueS;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(245758);
  }
  
  public final int getLayoutId()
  {
    return 2131494475;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245752);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.ueS = new FinderLiveTagFragment();
    paramBundle = this.ueS;
    if (paramBundle != null)
    {
      k localk = getSupportFragmentManager().beginTransaction();
      p.g(localk, "supportFragmentManager.beginTransaction()");
      localk.b(2131301711, (Fragment)paramBundle);
      localk.commitNow();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(245752);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245757);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(245757);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245755);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(245755);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245754);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(245754);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245753);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(245753);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245756);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(245756);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI7
 * JD-Core Version:    0.7.0.1
 */