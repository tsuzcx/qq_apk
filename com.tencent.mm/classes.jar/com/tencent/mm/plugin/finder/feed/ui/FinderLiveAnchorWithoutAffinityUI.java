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
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment;
import com.tencent.mm.plugin.finder.live.viewmodel.FinderLivePostUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;)V", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "plugin-finder_release"})
public final class FinderLiveAnchorWithoutAffinityUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveAnchorWithoutAffinityUI";
  private HashMap _$_findViewCache;
  public boolean ubn;
  private FinderLiveAnchorFragment ubq;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245347);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245347);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245346);
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
    AppMethodBeat.o(245346);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245345);
    Object localObject = this.ubq;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(245345);
  }
  
  public final int getLayoutId()
  {
    return 2131494366;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245343);
    Set localSet = ak.setOf(FinderLivePostUIC.class);
    AppMethodBeat.o(245343);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245337);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.ubq = new FinderLiveAnchorFragment();
    paramBundle = this.ubq;
    if (paramBundle != null) {
      paramBundle.uhI = false;
    }
    paramBundle = this.ubq;
    if (paramBundle != null)
    {
      k localk = getSupportFragmentManager().beginTransaction();
      p.g(localk, "supportFragmentManager.beginTransaction()");
      localk.b(2131301711, (Fragment)paramBundle);
      localk.commitNow();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(245337);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245342);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(245342);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245340);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(245340);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245339);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(245339);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245338);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(245338);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245341);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(245341);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(245344);
    super.onSwipeBack();
    this.ubn = true;
    AppMethodBeat.o(245344);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI
 * JD-Core Version:    0.7.0.1
 */