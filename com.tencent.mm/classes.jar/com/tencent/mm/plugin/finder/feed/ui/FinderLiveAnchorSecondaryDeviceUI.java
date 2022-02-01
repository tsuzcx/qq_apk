package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveAnchorFragment;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveAnchorSecondaryDeviceUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveAnchorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "getReportTag", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveAnchorSecondaryDeviceUI
  extends MMFinderUI
{
  private boolean BoA;
  private FinderLiveAnchorFragment BoB;
  private final String TAG = "FinderLiveAnchorSecondaryDeviceUI";
  private int lastOrientation = -1;
  
  private final void efd()
  {
    AppMethodBeat.i(364442);
    this.BoB = new FinderLiveAnchorFragment();
    FinderLiveAnchorFragment localFinderLiveAnchorFragment = this.BoB;
    if (localFinderLiveAnchorFragment != null) {
      localFinderLiveAnchorFragment.CDr = true;
    }
    localFinderLiveAnchorFragment = this.BoB;
    if (localFinderLiveAnchorFragment != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)localFinderLiveAnchorFragment);
      localr.FY();
    }
    AppMethodBeat.o(364442);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public void finish()
  {
    AppMethodBeat.i(364591);
    Object localObject = this.BoB;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    overridePendingTransition(p.a.anim_not_change, p.a.sight_slide_bottom_out);
    AppMethodBeat.o(364591);
  }
  
  public int getLayoutId()
  {
    return p.f.CfY;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(364559);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    Intent localIntent;
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      localIntent = getIntent();
      localObject = getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      if (!(localObject instanceof FinderLiveBundle)) {
        break label150;
      }
    }
    label150:
    for (Object localObject = (FinderLiveBundle)localObject;; localObject = null)
    {
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)localObject);
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      efd();
      k.Doi.N(true, paramConfiguration.orientation);
      LocaleUtil.initLanguage(MMApplicationContext.getContext());
      AppMethodBeat.o(364559);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364466);
    supportRequestWindowFeature(1);
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).checkFinishWhenDiffTask((Activity)this);
    }
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    efd();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(364466);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(364539);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(364539);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(364506);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(364506);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(364488);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(364488);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(364478);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(364478);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(364522);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(364522);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(364574);
    super.onSwipeBack();
    this.BoA = true;
    AppMethodBeat.o(364574);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceUI
 * JD-Core Version:    0.7.0.1
 */