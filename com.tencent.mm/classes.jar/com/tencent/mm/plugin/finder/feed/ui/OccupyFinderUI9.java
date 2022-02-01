package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveWeCoinHotFragment;
import com.tencent.mm.plugin.finder.report.live.m;
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
import kotlin.t;

@a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI9;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;)V", "lastOrientation", "", "commitFragment", "", "finish", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder_release"})
public final class OccupyFinderUI9
  extends MMFinderUI
{
  private final String TAG = "FinderLiveWeCoinHotIncomeUI";
  private HashMap _$_findViewCache;
  private int lastOrientation = -1;
  private FinderLiveWeCoinHotFragment ueT;
  
  private final void dej()
  {
    AppMethodBeat.i(245769);
    this.ueT = new FinderLiveWeCoinHotFragment();
    FinderLiveWeCoinHotFragment localFinderLiveWeCoinHotFragment = this.ueT;
    if (localFinderLiveWeCoinHotFragment != null)
    {
      k localk = getSupportFragmentManager().beginTransaction();
      p.g(localk, "supportFragmentManager.beginTransaction()");
      localk.b(2131301711, (Fragment)localFinderLiveWeCoinHotFragment);
      localk.commitNow();
      AppMethodBeat.o(245769);
      return;
    }
    AppMethodBeat.o(245769);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245771);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245771);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245770);
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
    AppMethodBeat.o(245770);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245768);
    Object localObject = this.ueT;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(245768);
  }
  
  public final int getLayoutId()
  {
    return 2131494475;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(245767);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      Object localObject = getIntent();
      Parcelable localParcelable = getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      if (localParcelable == null)
      {
        paramConfiguration = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveConfig");
        AppMethodBeat.o(245767);
        throw paramConfiguration;
      }
      ((Intent)localObject).putExtra("KEY_PARAMS_CONFIG", (Parcelable)localParcelable);
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      dej();
      localObject = m.vli;
      m.KJ(paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(245767);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245761);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    dej();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(245761);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245766);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(245766);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245764);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(245764);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245763);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(245763);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245762);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(245762);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245765);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(245765);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI9
 * JD-Core Version:    0.7.0.1
 */