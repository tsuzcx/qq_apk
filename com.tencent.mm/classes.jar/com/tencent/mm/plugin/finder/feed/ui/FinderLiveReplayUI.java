package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.replay.fragment.FinderLiveReplayFragment;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveReplayUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "fragment", "Lcom/tencent/mm/plugin/finder/replay/fragment/FinderLiveReplayFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/replay/fragment/FinderLiveReplayFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/replay/fragment/FinderLiveReplayFragment;)V", "lastOrientation", "", "sourceType", "getSourceType", "()I", "setSourceType", "(I)V", "checkSourceType", "", "commitFragment", "", "finish", "getLayoutId", "lockScreenRecord", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "resetFragment", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveReplayUI
  extends MMFinderUI
{
  public static final FinderLiveReplayUI.a BpD;
  private FinderLiveReplayFragment BpE;
  private int lastOrientation = -1;
  public int sourceType;
  
  static
  {
    AppMethodBeat.i(365010);
    BpD = new FinderLiveReplayUI.a((byte)0);
    AppMethodBeat.o(365010);
  }
  
  private final void efd()
  {
    AppMethodBeat.i(365008);
    this.BpE = new FinderLiveReplayFragment();
    FinderLiveReplayFragment localFinderLiveReplayFragment = this.BpE;
    if (localFinderLiveReplayFragment != null)
    {
      r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)localFinderLiveReplayFragment);
      localr.FY();
    }
    AppMethodBeat.o(365008);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(365062);
    setResult(-1);
    super.finish();
    Object localObject = this.BpE;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    overridePendingTransition(p.a.anim_not_change, p.a.sight_slide_bottom_out);
    AppMethodBeat.o(365062);
  }
  
  public final int getLayoutId()
  {
    return p.f.Cfs;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(365073);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i("FinderLiveReplayUI", "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      paramConfiguration = this.BpE;
      if (paramConfiguration != null)
      {
        r localr = getSupportFragmentManager().beginTransaction();
        s.s(localr, "supportFragmentManager.beginTransaction()");
        localr.a((Fragment)paramConfiguration);
        localr.FY();
      }
      efd();
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(365073);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365023);
    this.sourceType = getIntent().getIntExtra("KEY_PARAMS_SOURCE_TYPE", 0);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    int i = this.sourceType;
    paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
    if ((((Number)com.tencent.d.a.a.a.a.a.jUR().bmg()).intValue() == 1) && (i != 3)) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        getWindow().setFlags(8192, 8192);
      }
      Object localObject3 = getIntent().getStringExtra("key_context_id");
      Object localObject2 = getIntent().getStringExtra("key_click_tab_context_id");
      Object localObject1 = getIntent().getStringExtra("key_click_sub_tab_context_id");
      paramBundle = getIntent().getStringExtra("key_chnl_extra");
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        k localk = k.aeZF;
        ((bn)k.d((AppCompatActivity)this).cq(bn.class)).aCN((String)localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = k.aeZF;
        ((bn)k.d((AppCompatActivity)this).cq(bn.class)).aCO((String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = k.aeZF;
        ((bn)k.d((AppCompatActivity)this).cq(bn.class)).aCP((String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)paramBundle))
      {
        localObject1 = k.aeZF;
        ((bn)k.d((AppCompatActivity)this).cq(bn.class)).aCQ(paramBundle);
      }
      efd();
      Log.i("FinderLiveReplayUI", "[onCreate]");
      AppMethodBeat.o(365023);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365051);
    super.onDestroy();
    Log.i("FinderLiveReplayUI", "[onDestroy]");
    AppMethodBeat.o(365051);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365038);
    super.onPause();
    Log.i("FinderLiveReplayUI", "[onPause]");
    AppMethodBeat.o(365038);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365031);
    super.onResume();
    Log.i("FinderLiveReplayUI", "[onResume]");
    AppMethodBeat.o(365031);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(365028);
    super.onStart();
    Log.i("FinderLiveReplayUI", "[onStart]");
    AppMethodBeat.o(365028);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(365047);
    super.onStop();
    Log.i("FinderLiveReplayUI", "[onStop]");
    AppMethodBeat.o(365047);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveReplayUI
 * JD-Core Version:    0.7.0.1
 */