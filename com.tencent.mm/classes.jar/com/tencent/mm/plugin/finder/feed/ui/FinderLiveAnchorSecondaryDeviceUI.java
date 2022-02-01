package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorSecondaryDeviceUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "getReportTag", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "plugin-finder-live_release"})
public final class FinderLiveAnchorSecondaryDeviceUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveAnchorSecondaryDeviceUI";
  private HashMap _$_findViewCache;
  private int lastOrientation = -1;
  private boolean xOB;
  private FinderLiveAnchorFragment xOC;
  
  private final void dvk()
  {
    AppMethodBeat.i(233773);
    this.xOC = new FinderLiveAnchorFragment();
    FinderLiveAnchorFragment localFinderLiveAnchorFragment = this.xOC;
    if (localFinderLiveAnchorFragment != null) {
      localFinderLiveAnchorFragment.yda = true;
    }
    localFinderLiveAnchorFragment = this.xOC;
    if (localFinderLiveAnchorFragment != null)
    {
      i locali = getSupportFragmentManager().beginTransaction();
      p.j(locali, "supportFragmentManager.beginTransaction()");
      locali.b(b.f.fragment_container, (Fragment)localFinderLiveAnchorFragment);
      locali.iq();
      AppMethodBeat.o(233773);
      return;
    }
    AppMethodBeat.o(233773);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233776);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233776);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233774);
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
    AppMethodBeat.o(233774);
    return localView1;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(233771);
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
    AppMethodBeat.o(233771);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_visitor_fragment_ui;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(233766);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      Intent localIntent = getIntent();
      Parcelable localParcelable2 = getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      Parcelable localParcelable1 = localParcelable2;
      if (!(localParcelable2 instanceof FinderLiveBundle)) {
        localParcelable1 = null;
      }
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)localParcelable1);
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      dvk();
      m.yCt.O(true, paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(233766);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233758);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    dvk();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(233758);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233765);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(233765);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233762);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(233762);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233760);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(233760);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233759);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(233759);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233763);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(233763);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(233768);
    super.onSwipeBack();
    this.xOB = true;
    AppMethodBeat.o(233768);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceUI
 * JD-Core Version:    0.7.0.1
 */