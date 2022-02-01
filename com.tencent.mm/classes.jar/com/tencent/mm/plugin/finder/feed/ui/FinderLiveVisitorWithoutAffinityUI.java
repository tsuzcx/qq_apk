package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.at;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "setOrUnsetFullScreen", "orientation", "plugin-finder_release"})
public final class FinderLiveVisitorWithoutAffinityUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveVisitorWithoutAffinityUI";
  private HashMap _$_findViewCache;
  private int lastOrientation = -1;
  private FinderLiveVisitorFragment ubI;
  public boolean ubn;
  
  private final void dej()
  {
    AppMethodBeat.i(245407);
    this.ubI = new FinderLiveVisitorFragment();
    FinderLiveVisitorFragment localFinderLiveVisitorFragment = this.ubI;
    if (localFinderLiveVisitorFragment != null)
    {
      k localk = getSupportFragmentManager().beginTransaction();
      p.g(localk, "supportFragmentManager.beginTransaction()");
      localk.b(2131301711, (Fragment)localFinderLiveVisitorFragment);
      localk.commitNow();
      AppMethodBeat.o(245407);
      return;
    }
    AppMethodBeat.o(245407);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245409);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245409);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245408);
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
    AppMethodBeat.o(245408);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245406);
    Object localObject = this.ubI;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(245406);
  }
  
  public final int getLayoutId()
  {
    return 2131494475;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(245404);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      dej();
      m localm = m.vli;
      m.KJ(paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(245404);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245398);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("key_context_id");
    paramBundle = getIntent().getStringExtra("key_click_tab_context_id");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
      ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).sGQ = ((String)localObject);
    }
    if (!TextUtils.isEmpty((CharSequence)paramBundle))
    {
      localObject = com.tencent.mm.ui.component.a.PRN;
      ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).sGE = paramBundle;
    }
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    dej();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(245398);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245403);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    m.vli.a(s.at.vrK);
    AppMethodBeat.o(245403);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245401);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(245401);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245400);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(245400);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(245399);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(245399);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(245402);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(245402);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(245405);
    super.onSwipeBack();
    this.ubn = true;
    AppMethodBeat.o(245405);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI
 * JD-Core Version:    0.7.0.1
 */