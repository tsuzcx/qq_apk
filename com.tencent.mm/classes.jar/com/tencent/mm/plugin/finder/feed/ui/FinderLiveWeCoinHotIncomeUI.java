package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveWeCoinHotFragment;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveWeCoinHotIncomeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveWeCoinHotFragment;)V", "lastOrientation", "", "commitFragment", "", "finish", "getLayoutId", "getReportTag", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveWeCoinHotIncomeUI
  extends MMFinderUI
{
  private FinderLiveWeCoinHotFragment BpU;
  private final String TAG = "FinderLiveWeCoinHotIncomeUI";
  private int lastOrientation = -1;
  
  private final void efd()
  {
    AppMethodBeat.i(364229);
    this.BpU = new FinderLiveWeCoinHotFragment();
    FinderLiveWeCoinHotFragment localFinderLiveWeCoinHotFragment = this.BpU;
    if (localFinderLiveWeCoinHotFragment != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)localFinderLiveWeCoinHotFragment);
      localr.FY();
    }
    AppMethodBeat.o(364229);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(364305);
    Object localObject = this.BpU;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    AppMethodBeat.o(364305);
  }
  
  public final int getLayoutId()
  {
    return p.f.CfY;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(364291);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      Intent localIntent = getIntent();
      Parcelable localParcelable = getIntent().getParcelableExtra("KEY_PARAMS_CONFIG");
      if (localParcelable == null)
      {
        paramConfiguration = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveBundle");
        AppMethodBeat.o(364291);
        throw paramConfiguration;
      }
      localIntent.putExtra("KEY_PARAMS_CONFIG", (Parcelable)localParcelable);
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      efd();
      k.Doi.N(true, paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(364291);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364239);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    efd();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(364239);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364277);
    super.onDestroy();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(364277);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364261);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(364261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364254);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(364254);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(364246);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(364246);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(364269);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(364269);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveWeCoinHotIncomeUI
 * JD-Core Version:    0.7.0.1
 */