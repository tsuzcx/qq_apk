package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.accessibility.j;
import com.tencent.mm.plugin.finder.live.fragment.FinderLiveVisitorFragment;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.i;
import com.tencent.mm.plugin.finder.live.plugin.ct;
import com.tencent.mm.plugin.finder.live.viewmodel.component.b;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.report.av;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bx;
import com.tencent.mm.plugin.findersdk.a.by;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.k.b;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(32)
@com.tencent.mm.ui.widget.pulldown.c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveVisitorWithoutAffinityUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "fragment", "Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "getFragment", "()Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;", "setFragment", "(Lcom/tencent/mm/plugin/finder/live/fragment/FinderLiveVisitorFragment;)V", "lastOrientation", "", "swipeBack", "", "getSwipeBack", "()Z", "setSwipeBack", "(Z)V", "appendCommentSceneExta", "chnlExtra", "commitFragment", "", "convertActivityFromTranslucent", "finish", "getCurrentFragment", "getForceOrientation", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initActivityCloseAnimation", "launchWithAnim", "onBusinessPermissionDenied", "permission", "onBusinessPermissionGranted", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onPause", "onResume", "onStart", "onStop", "onSwipeBack", "resetFragment", "setOrUnsetFullScreen", "orientation", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderLiveVisitorWithoutAffinityUI
  extends MMFinderUI
{
  public boolean BoA;
  public FinderLiveVisitorFragment BpT;
  private final String TAG = "FinderLiveVisitorWithoutAffinityUI";
  private int lastOrientation = -1;
  
  private final String awf(String paramString)
  {
    AppMethodBeat.i(365082);
    String str1 = com.tencent.mm.plugin.expt.hellhound.a.dIJ();
    String str2;
    if (str1 == null)
    {
      str1 = "";
      if (!TextUtils.isEmpty((CharSequence)paramString)) {
        break label166;
      }
      paramString = new JSONObject();
      if (!TextUtils.isEmpty((CharSequence)paramString.optString("enter_immerse_type"))) {
        break label190;
      }
      str2 = paramString;
      label51:
      if (str2 != null) {
        str2.put("enter_immerse_type", str1);
      }
      str2 = getIntent().getStringExtra("KEY_ENTER_LIVE_PARAM_APP_PUSH_TASK_ID");
      if (str2 != null) {
        break label195;
      }
      str2 = "";
      label80:
      if (!Util.isNullOrNil(str2)) {
        if (!TextUtils.isEmpty((CharSequence)paramString.optString("taskid"))) {
          break label198;
        }
      }
    }
    label166:
    label190:
    label195:
    label198:
    for (String str3 = paramString;; str3 = null)
    {
      for (;;)
      {
        if (str3 != null) {
          str3.put("taskid", str2);
        }
        Log.i(this.TAG, "appendCommentSceneExta currentScene: " + str1 + " data: " + paramString);
        paramString = paramString.toString();
        AppMethodBeat.o(365082);
        return paramString;
        break;
        try
        {
          paramString = new JSONObject(paramString);
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString = new JSONObject();
          }
        }
      }
      str2 = null;
      break label51;
      break label80;
    }
  }
  
  private final void efd()
  {
    AppMethodBeat.i(365103);
    this.BpT = new FinderLiveVisitorFragment();
    FinderLiveVisitorFragment localFinderLiveVisitorFragment = this.BpT;
    if (localFinderLiveVisitorFragment != null)
    {
      androidx.fragment.app.r localr = getSupportFragmentManager().beginTransaction();
      s.s(localr, "supportFragmentManager.beginTransaction()");
      localr.b(p.e.fragment_container, (Fragment)localFinderLiveVisitorFragment);
      localr.FY();
    }
    AppMethodBeat.o(365103);
  }
  
  private final boolean efz()
  {
    AppMethodBeat.i(365094);
    boolean bool = getIntent().getBooleanExtra("LAUNCH_WITH_ANIM", false);
    AppMethodBeat.o(365094);
    return bool;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public boolean convertActivityFromTranslucent()
  {
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(365255);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    if (((b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(b.class)).sh(isSwiping()))
    {
      AppMethodBeat.o(365255);
      return;
    }
    localObject = this.BpT;
    if (localObject != null)
    {
      localObject = ((Iterable)((UIComponentFragment)localObject).uiComponents).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((UIComponent)((Iterator)localObject).next()).onBeforeFinish(getIntent());
      }
    }
    super.finish();
    if (efz()) {}
    for (int i = p.a.alpha_out;; i = p.a.sight_slide_bottom_out)
    {
      overridePendingTransition(p.a.anim_not_change, i);
      AppMethodBeat.o(365255);
      return;
    }
  }
  
  public int getForceOrientation()
  {
    AppMethodBeat.i(365266);
    Object localObject = aj.CGT;
    localObject = aj.elr();
    if (localObject != null)
    {
      localObject = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject).business(e.class);
      if ((localObject == null) || (((e)localObject).Edf != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      i = this.lastOrientation;
      AppMethodBeat.o(365266);
      return i;
    }
    i = super.getForceOrientation();
    AppMethodBeat.o(365266);
    return i;
  }
  
  public int getLayoutId()
  {
    return p.f.CfY;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365162);
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.ui.component.l.a(ai.cz(by.class)), com.tencent.mm.ui.component.l.a(ai.cz(bx.class)), j.class, b.class, com.tencent.mm.plugin.finder.accessibility.l.class, com.tencent.mm.plugin.finder.live.sidebar.d.class });
    AppMethodBeat.o(365162);
    return localSet;
  }
  
  public void initActivityCloseAnimation()
  {
    AppMethodBeat.i(365134);
    if (efz())
    {
      AppMethodBeat.o(365134);
      return;
    }
    super.initActivityCloseAnimation();
    AppMethodBeat.o(365134);
  }
  
  public void onBusinessPermissionDenied(String paramString) {}
  
  public void onBusinessPermissionGranted(String paramString)
  {
    int j = 0;
    int i = 1;
    AppMethodBeat.i(365282);
    if (s.p(paramString, d.c.actx.value))
    {
      paramString = aj.CGT;
      paramString = aj.getLiveCore();
      if (paramString != null)
      {
        paramString = paramString.mRB;
        if ((paramString == null) || (paramString.beq())) {}
      }
      while (i != 0)
      {
        paramString = aj.CGT;
        paramString = aj.elk();
        if (paramString == null) {
          break;
        }
        paramString = (ct)paramString.getPlugin(ct.class);
        if (paramString == null) {
          break;
        }
        paramString.aPz();
        AppMethodBeat.o(365282);
        return;
        i = 0;
      }
    }
    if (s.p(paramString, d.c.acty.value))
    {
      paramString = aj.CGT;
      paramString = aj.getLiveCore();
      i = j;
      if (paramString != null)
      {
        paramString = paramString.mRB;
        i = j;
        if (paramString != null)
        {
          i = j;
          if (!paramString.beq()) {
            i = 1;
          }
        }
      }
      if (i != 0)
      {
        paramString = aj.CGT;
        paramString = aj.getLiveCore();
        if (!(paramString instanceof com.tencent.mm.live.core.core.f.d)) {
          break label187;
        }
      }
    }
    label187:
    for (paramString = (com.tencent.mm.live.core.core.f.d)paramString;; paramString = null)
    {
      if (paramString != null) {
        paramString.startLocalAudio(true);
      }
      AppMethodBeat.o(365282);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(365222);
    s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Log.i(this.TAG, "[onConfigurationChanged] lastOrientation：" + this.lastOrientation + ",newConfig.orientation:" + paramConfiguration.orientation);
    if (this.lastOrientation != paramConfiguration.orientation)
    {
      this.lastOrientation = paramConfiguration.orientation;
      getIntent().putExtra("KEY_PARAMS_RESET_LIVE", true);
      FinderLiveVisitorFragment localFinderLiveVisitorFragment = this.BpT;
      if (localFinderLiveVisitorFragment != null)
      {
        androidx.fragment.app.r localr = getSupportFragmentManager().beginTransaction();
        s.s(localr, "supportFragmentManager.beginTransaction()");
        localr.a((Fragment)localFinderLiveVisitorFragment);
        localr.FY();
      }
      efd();
      com.tencent.mm.plugin.finder.live.report.k.Doi.N(true, paramConfiguration.orientation);
    }
    LocaleUtil.initLanguage(MMApplicationContext.getContext());
    AppMethodBeat.o(365222);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365153);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.live.fluent.i.CCI;
    com.tencent.mm.plugin.finder.live.fluent.i.ejv().aDn("onCreate before");
    Object localObject3 = getIntent().getStringExtra("key_context_id");
    Object localObject2 = getIntent().getStringExtra("key_click_tab_context_id");
    Object localObject1 = getIntent().getStringExtra("key_click_sub_tab_context_id");
    paramBundle = awf(getIntent().getStringExtra("key_chnl_extra"));
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cq(bn.class)).aCN((String)localObject3);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = com.tencent.mm.ui.component.k.aeZF;
      ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cq(bn.class)).aCO((String)localObject2);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cq(bn.class)).aCP((String)localObject1);
    }
    if (!TextUtils.isEmpty((CharSequence)paramBundle))
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((bn)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).cq(bn.class)).aCQ(paramBundle);
    }
    getIntent().putExtra("KEY_PARAMS_RESET_LIVE", false);
    efd();
    paramBundle = com.tencent.mm.plugin.finder.live.fluent.i.CCI;
    com.tencent.mm.plugin.finder.live.fluent.i.ejv().aDn("onCreate after");
    if (!efz())
    {
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getDecorView();
        if (paramBundle != null) {
          paramBundle.setBackgroundColor(-16777216);
        }
      }
    }
    Log.i(this.TAG, "[onCreate]");
    AppMethodBeat.o(365153);
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(365113);
    super.onCreateBeforeSetContentView();
    if (efz())
    {
      aw.isDarkMode();
      setTheme(p.i.MMTheme_FullTranslucent);
    }
    AppMethodBeat.o(365113);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(365210);
    super.onDestroy();
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.ad(true, false);
    localObject = com.tencent.mm.plugin.finder.report.r.Fqi;
    com.tencent.mm.plugin.finder.report.r.clearData();
    Log.i(this.TAG, "[onDestroy]");
    AppMethodBeat.o(365210);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(365187);
    super.onPause();
    Log.i(this.TAG, "[onPause]");
    AppMethodBeat.o(365187);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(365176);
    super.onResume();
    Log.i(this.TAG, "[onResume]");
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.i.CCI;
    com.tencent.mm.plugin.finder.live.fluent.i.ejv().aDn("onResume after");
    localObject = av.Fui;
    av.notifyResume();
    AppMethodBeat.o(365176);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(365169);
    super.onStart();
    Log.i(this.TAG, "[onStart]");
    AppMethodBeat.o(365169);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(365196);
    super.onStop();
    Log.i(this.TAG, "[onStop]");
    AppMethodBeat.o(365196);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(365236);
    super.onSwipeBack();
    this.BoA = true;
    AppMethodBeat.o(365236);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI
 * JD-Core Version:    0.7.0.1
 */