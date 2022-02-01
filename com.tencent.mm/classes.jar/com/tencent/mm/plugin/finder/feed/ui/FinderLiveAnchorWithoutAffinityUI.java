package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment;
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
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;)V", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "plugin-finder-live_release"})
public final class FinderLiveAnchorWithoutAffinityUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveAnchorWithoutAffinityUI";
  private HashMap _$_findViewCache;
  public boolean xOB;
  private FinderLiveAnchorFragment xOC;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233143);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233143);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233141);
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
    AppMethodBeat.o(233141);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(233140);
    Object localObject = this.xOC;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.sight_slide_bottom_out);
    AppMethodBeat.o(233140);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_anchor_fragment_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233135);
    Set localSet = ak.setOf(com.tencent.mm.plugin.finder.live.viewmodel.i.class);
    AppMethodBeat.o(233135);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233127);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    this.xOC = new FinderLiveAnchorFragment();
    paramBundle = this.xOC;
    if (paramBundle != null) {
      paramBundle.yda = false;
    }
    paramBundle = this.xOC;
    if (paramBundle != null)
    {
      androidx.fragment.app.i locali = getSupportFragmentManager().beginTransaction();
      p.j(locali, "supportFragmentManager.beginTransaction()");
      locali.b(b.f.fragment_container, (Fragment)paramBundle);
      locali.iq();
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(233127);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233133);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(233133);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233131);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(233131);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233130);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(233130);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233128);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(233128);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233132);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(233132);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(233137);
    super.onSwipeBack();
    this.xOB = true;
    AppMethodBeat.o(233137);
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