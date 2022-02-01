package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "commitFragment", "", "finish", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "setOrUnsetFullScreen", "orientation", "plugin-finder-live_release"})
public final class FinderLiveVisitorWithoutAffinityUI
  extends MMFinderUI
{
  private final String TAG = "FinderLiveVisitorWithoutAffinityUI";
  private HashMap _$_findViewCache;
  private int lastOrientation = -1;
  public boolean xOB;
  private FinderLiveVisitorFragment xQu;
  
  private final void dvk()
  {
    AppMethodBeat.i(233717);
    this.xQu = new FinderLiveVisitorFragment();
    FinderLiveVisitorFragment localFinderLiveVisitorFragment = this.xQu;
    if (localFinderLiveVisitorFragment != null)
    {
      i locali = getSupportFragmentManager().beginTransaction();
      p.j(locali, "supportFragmentManager.beginTransaction()");
      locali.b(b.f.fragment_container, (Fragment)localFinderLiveVisitorFragment);
      locali.iq();
      AppMethodBeat.o(233717);
      return;
    }
    AppMethodBeat.o(233717);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233721);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233721);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233720);
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
    AppMethodBeat.o(233720);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(233714);
    Object localObject = this.xQu;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    overridePendingTransition(b.a.anim_not_change, b.a.sight_slide_bottom_out);
    AppMethodBeat.o(233714);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_visitor_fragment_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(233697);
    Set localSet = ak.setOf(an.class);
    AppMethodBeat.o(233697);
    return localSet;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(233710);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      dvk();
      m.yCt.O(true, paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(233710);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(233695);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    Object localObject3 = getIntent().getStringExtra("key_context_id");
    Object localObject2 = getIntent().getStringExtra("key_click_tab_context_id");
    Object localObject1 = getIntent().getStringExtra("key_click_sub_tab_context_id");
    paramBundle = getIntent().getStringExtra("key_chnl_extra");
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      g localg = g.Xox;
      ((aj)g.b((AppCompatActivity)this).i(aj.class)).wmL = ((String)localObject3);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = g.Xox;
      ((aj)g.b((AppCompatActivity)this).i(aj.class)).wmz = ((String)localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = g.Xox;
      ((aj)g.b((AppCompatActivity)this).i(aj.class)).yAU = ((String)localObject1);
    }
    if (!TextUtils.isEmpty((CharSequence)paramBundle))
    {
      localObject1 = g.Xox;
      ((aj)g.b((AppCompatActivity)this).i(aj.class)).yAV = paramBundle;
    }
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    dvk();
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(233695);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(233706);
    super.onDestroy();
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    com.tencent.mm.plugin.finder.live.utils.a.T(true, false);
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(233706);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233700);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(233700);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233699);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    AppMethodBeat.o(233699);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(233698);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(233698);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(233704);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(233704);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(233712);
    super.onSwipeBack();
    this.xOB = true;
    AppMethodBeat.o(233712);
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