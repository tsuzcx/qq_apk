package com.tencent.mm.plugin.appbrand.widget.d;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.ShareActionConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.c;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.config.WeAppHalfScreenStatusChangeListener;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.HalfPage;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.k.a.a.a;
import com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.BaseAppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.page.capsulebar.e;
import com.tencent.mm.plugin.appbrand.page.capsulebar.g;
import com.tencent.mm.plugin.appbrand.page.capsulebar.j;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.AppBrandGlobalNativeWidgetContainerView.a;
import com.tencent.mm.plugin.appbrand.widget.d.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "backgroundRenderer", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "getBackgroundRenderer", "()Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;", "setBackgroundRenderer", "(Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/bg/IHalfScreenBackgroundRenderer;)V", "controller", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "getController", "()Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "setController", "(Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;)V", "value", "", "showingHeader", "getShowingHeader", "()Z", "setShowingHeader", "(Z)V", "animateFullScreen", "", "animateHalfScreenBackgroundAlpha", "Landroid/animation/ValueAnimator;", "toAlpha", "", "duration", "", "canRespondToPageNavigation", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "findSingleCloseCapsuleBar", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar;", "getFirstPageNavigationStyleConfig", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getHalfScreenConfig", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "interceptTapToFullScreen", "ev", "Landroid/view/MotionEvent;", "isBackToStackBottomPage", "newPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPage;", "isFirstPageForCurrentLaunch", "isFullScreen", "isNativeFunctionalized", "isNavigateToNewPageFromStackBottomPage", "oldPage", "onBackground", "onDragStatusChanged", "dragState", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "onDrawBackground", "canvas", "Landroid/graphics/Canvas;", "view", "Landroid/view/View;", "scene", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger$SceneDrawBg;", "onEnterFullScreen", "onEnterHalfScreen", "onForeground", "onNavigateStartAfterLoadUrl", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "onPageSwitchCancel", "onPageSwitchEnd", "onPageSwitchProgress", "percent", "", "onPageSwitchStart", "onRuntimeDestroy", "onRuntimeLaunch", "onRuntimePause", "onRuntimeResume", "refreshCapsuleBarBgWhiteColor", "refreshStatusBarStyle", "resetCapsuleBar", "capsuleBarManager", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "resetState", "restoreHalfScreenBackgroundAlpha", "setCapsuleBarBackgroundRenderer", "renderer", "Lcom/tencent/mm/plugin/appbrand/widget/AppBrandGlobalNativeWidgetContainerView$CapsuleBarBackgroundRenderer;", "showHeader", "show", "animate", "trySetupEmbedModeBgrRendererForHost", "trySetupHalfScreenCapsuleBar", "tryShowCustomNavigateStyle", "wantAnimateHeader", "Lkotlin/Pair;", "wantGestureControllerEnable", "wantShowCoverWidget", "Companion", "SceneDrawBg", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d.a uDD;
  public final w qxC;
  public l uDE;
  public com.tencent.mm.plugin.appbrand.widget.d.a.c uDF;
  private boolean uDG;
  
  static
  {
    AppMethodBeat.i(324398);
    uDD = new d.a((byte)0);
    AppMethodBeat.o(324398);
  }
  
  public d(w paramw)
  {
    AppMethodBeat.i(324307);
    this.qxC = paramw;
    paramw = com.tencent.mm.plugin.appbrand.widget.d.a.c.uEw;
    this.uDF = c.a.cQv();
    AppMethodBeat.o(324307);
  }
  
  private static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, View paramView)
  {
    AppMethodBeat.i(324361);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAppBrandInitConfigWC);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramAppBrandInitConfigWC, "$initConfig");
    paramView = paramAppBrandInitConfigWC.qYw;
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.qAT.qZW.token;
    kotlin.g.b.s.u(paramAppBrandInitConfigWC, "token");
    paramView.tcK.onWXAppResult((Parcelable)new IPCString(paramAppBrandInitConfigWC));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324361);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.page.ah paramah, w paramw, AppBrandInitConfigWC paramAppBrandInitConfigWC, View paramView)
  {
    AppMethodBeat.i(324373);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramah);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramw);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAppBrandInitConfigWC);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramah, "$pageView");
    kotlin.g.b.s.u(paramAppBrandInitConfigWC, "$initConfig");
    localObject1 = com.tencent.mm.plugin.appbrand.e.a.b(paramah);
    paramView = new WxaExposedParams.a();
    localObject2 = paramw.ccM();
    com.tencent.mm.plugin.appbrand.page.ah localah = paramw.ccK();
    kotlin.g.b.s.checkNotNull(localah);
    kotlin.g.b.s.s(localah, "runtime.currentPageView!!");
    a.a locala = com.tencent.mm.plugin.appbrand.k.a.a.ruh;
    kotlin.g.b.s.s(paramw, "runtime");
    paramw = a.a.H(paramw);
    paramView.appId = ((AppBrandSysConfigWC)localObject2).appId;
    if (paramw == null)
    {
      paramw = "";
      paramView.rcL = paramw;
      paramView.from = 3;
      if (localah.tti != null) {
        break label286;
      }
    }
    label286:
    for (paramw = "";; paramw = localah.cgR())
    {
      paramView.hUf = paramw;
      paramView.qHO = ((AppBrandSysConfigWC)localObject2).qYY.qHO;
      paramView.pkgVersion = ((AppBrandSysConfigWC)localObject2).qYY.pkgVersion;
      paramView.rcO = ((String)localObject1);
      paramw = new Bundle();
      paramw.putBoolean("key_is_embed_wxa", true);
      AppBrandProfileUI.a(paramah.getContext(), paramAppBrandInitConfigWC.username, 11, "", true, paramView.cll(), paramw, ActivityStarterIpcDelegate.bq(paramah.getContext()));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(324373);
      return;
      paramw = paramw.mAppId;
      break;
    }
  }
  
  private static final void a(w paramw, BaseAppBrandSingleCloseCapsuleBar paramBaseAppBrandSingleCloseCapsuleBar, View paramView)
  {
    AppMethodBeat.i(324354);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramw);
    localb.cH(paramBaseAppBrandSingleCloseCapsuleBar);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramBaseAppBrandSingleCloseCapsuleBar, "$singleCloseCapsuleBar");
    paramw.close();
    paramBaseAppBrandSingleCloseCapsuleBar.setCloseBtnListener(null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324354);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(324382);
    kotlin.g.b.s.u(paramd, "this$0");
    Object localObject = paramd.qxC.ccK();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.appbrand.page.ah)localObject).cED();
      if (localObject != null) {
        if (paramd.isFullScreen()) {
          break label55;
        }
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.appbrand.widget.actionbar.d)localObject).setStatusBarForegroundStyle(bool);
      AppMethodBeat.o(324382);
      return;
    }
  }
  
  private static final void a(d paramd, Canvas paramCanvas, View paramView)
  {
    AppMethodBeat.i(324390);
    kotlin.g.b.s.u(paramd, "this$0");
    kotlin.g.b.s.s(paramView, "child");
    paramd.a(paramCanvas, paramView, d.b.uDI);
    AppMethodBeat.o(324390);
  }
  
  public static boolean a(cb paramcb, w paramw)
  {
    boolean bool2 = true;
    AppMethodBeat.i(324322);
    int i;
    boolean bool1;
    if (paramcb == null)
    {
      i = -1;
      bool1 = bool2;
      switch (i)
      {
      default: 
        if (paramw.ccN().getPageCount() == 1) {
          bool1 = bool2;
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.HalfScreenManger", "[isFirstPage]  PageOpenType[" + paramcb + "]  isFirstPage[" + bool1 + "]  pageCount[" + paramw.ccN().getPageCount() + "]  actualPageStackSize[" + paramw.ccN().getActualPageStackSize() + ']');
      AppMethodBeat.o(324322);
      return bool1;
      i = c.avl[paramcb.ordinal()];
      break;
      bool1 = bool2;
      if (paramw.ccN().getPageCount() != 1)
      {
        bool1 = false;
        continue;
        bool1 = bool2;
        if (paramw.ccN().getActualPageStackSize() != 1)
        {
          bool1 = false;
          continue;
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(w paramw, cb paramcb)
  {
    AppMethodBeat.i(324342);
    if (paramcb != cb.tBt)
    {
      paramw = paramw.getInitConfig().qAT;
      if ((paramw.isEnable()) && (paramw.qZP))
      {
        AppMethodBeat.o(324342);
        return true;
      }
    }
    AppMethodBeat.o(324342);
    return false;
  }
  
  private final boolean cPX()
  {
    AppMethodBeat.i(324315);
    if ((this.uDG) && (cQc().isEnable()))
    {
      AppMethodBeat.o(324315);
      return true;
    }
    AppMethodBeat.o(324315);
    return false;
  }
  
  private final void cPY()
  {
    AppMethodBeat.i(324330);
    Object localObject = cPZ();
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.qxC.getInitConfig();
    if (localObject != null)
    {
      if (localAppBrandInitConfigWC == null) {
        break label76;
      }
      localObject = localAppBrandInitConfigWC.qAT;
      if ((localObject == null) || (((HalfScreenConfig)localObject).qZS != true)) {
        break label76;
      }
    }
    label76:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (kotlin.g.b.s.p(o(localAppBrandInitConfigWC), "custom"))) {
        I(false, true);
      }
      AppMethodBeat.o(324330);
      return;
    }
  }
  
  private static String o(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(324349);
    b localb = b.uDz;
    if (b.cPW())
    {
      Log.d("MicroMsg.HalfScreenManger", "[getFirstPageNavigationStyleConfig] DEBUG force firstPageNavigationStyleCustom");
      AppMethodBeat.o(324349);
      return "custom";
    }
    if (paramAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(324349);
      return "default";
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.epa;
    if (paramAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(324349);
      return "default";
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.rcz;
    if (paramAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(324349);
      return "default";
    }
    paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.rbF;
    if (paramAppBrandInitConfigWC == null)
    {
      AppMethodBeat.o(324349);
      return "default";
    }
    AppMethodBeat.o(324349);
    return paramAppBrandInitConfigWC;
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(324465);
    BaseAppBrandSingleCloseCapsuleBar localBaseAppBrandSingleCloseCapsuleBar = cPZ();
    if (localBaseAppBrandSingleCloseCapsuleBar != null)
    {
      ly(paramBoolean1);
      localBaseAppBrandSingleCloseCapsuleBar.a(paramBoolean1, paramBoolean2, (j)new d(localBaseAppBrandSingleCloseCapsuleBar, this));
    }
    AppMethodBeat.o(324465);
  }
  
  public final ValueAnimator M(int paramInt, long paramLong)
  {
    AppMethodBeat.i(324496);
    ValueAnimator localValueAnimator = this.uDF.h(this.uDF.cQq(), paramInt, paramLong);
    AppMethodBeat.o(324496);
    return localValueAnimator;
  }
  
  public final r<Boolean, Boolean> a(u paramu1, u paramu2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(324446);
    boolean bool1 = w(paramu1);
    boolean bool2 = v(paramu2);
    if ((!bool2) && (!bool1))
    {
      paramu1 = Boolean.FALSE;
      paramu1 = new r(paramu1, paramu1);
      AppMethodBeat.o(324446);
      return paramu1;
    }
    if ((kotlin.g.b.s.p(o(paramAppBrandInitConfigWC), "custom")) && (paramAppBrandInitConfigWC.qAT.qZS))
    {
      paramu1 = this.uDE;
      if (paramu1 == null)
      {
        paramu1 = null;
        if (paramu1 != com.tencent.mm.plugin.appbrand.widget.s.uxX) {
          break label138;
        }
      }
    }
    label138:
    for (int i = 1;; i = 0)
    {
      if ((!bool2) || (i == 0)) {
        break label144;
      }
      paramu1 = Boolean.FALSE;
      paramu1 = new r(paramu1, paramu1);
      AppMethodBeat.o(324446);
      return paramu1;
      paramu1 = paramu1.cOP();
      break;
    }
    label144:
    if ((!bool2) && (i != 0))
    {
      paramu1 = cPZ();
      if ((paramu1 != null) && (paramu1.cGo() == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramu1 = Boolean.FALSE;
        paramu1 = new r(paramu1, paramu1);
        AppMethodBeat.o(324446);
        return paramu1;
      }
    }
    paramu1 = new r(Boolean.TRUE, Boolean.valueOf(bool2));
    AppMethodBeat.o(324446);
    return paramu1;
  }
  
  public final void a(Canvas paramCanvas, View paramView, d.b paramb)
  {
    AppMethodBeat.i(324499);
    kotlin.g.b.s.u(paramView, "view");
    kotlin.g.b.s.u(paramb, "scene");
    HalfScreenConfig localHalfScreenConfig = cQc();
    if ((localHalfScreenConfig.isEnable()) && ((localHalfScreenConfig.qZV) || (localHalfScreenConfig.qZO)))
    {
      if ((localHalfScreenConfig.rac == HalfScreenConfig.g.raA) && (paramb != d.b.uDI))
      {
        AppMethodBeat.o(324499);
        return;
      }
      if (kotlin.g.b.s.p(this.uDF.cQt(), paramView)) {
        this.uDF.a(paramCanvas, paramView);
      }
    }
    AppMethodBeat.o(324499);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.page.ah paramah, cb paramcb)
  {
    AppMethodBeat.i(324441);
    kotlin.g.b.s.u(paramah, "pageView");
    w localw = paramah.getRuntime();
    AppBrandInitConfigWC localAppBrandInitConfigWC = localw.getInitConfig();
    kotlin.g.b.s.s(localAppBrandInitConfigWC, "runtime.initConfig");
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = paramah.cEC();
    if (localAppBrandInitConfigWC.qAT.isEnable())
    {
      Log.i("MicroMsg.HalfScreenManger", "[trySetupHalfScreenCapsuleBar]  PageOpenType[" + paramcb + "]  capsuleType[" + localAppBrandInitConfigWC.qAT.qZN + ']');
      Object localObject1 = localw.qsp;
      kotlin.g.b.s.s(localObject1, "runtime.capsuleBarManager");
      kotlin.g.b.s.s(localw, "runtime");
      ((e)localObject1).CN(ba.f.half_screen_single_close_capsule_bar);
      Object localObject2 = localw.ccN().getRootView().findViewById(ba.f.app_brand_activity_container_view);
      if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.ui.wxa_container.a))
      {
        localObject2 = (com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject2;
        if (((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject2).upQ != null) {
          ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject2).removeView((View)((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject2).upQ);
        }
        ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject2).upR = null;
      }
      localObject2 = localAppBrandInitConfigWC.qAT.qZN;
      switch (c.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        AppMethodBeat.o(324441);
        return;
      case 1: 
        localb.hZ(false);
        AppMethodBeat.o(324441);
        return;
      case 2: 
        localb.hZ(true);
        AppMethodBeat.o(324441);
        return;
      }
      boolean bool = a(paramcb, localw);
      localObject2 = g.tCv;
      localObject2 = localb.getContext();
      kotlin.g.b.s.s(localObject2, "actionBar.context");
      localObject2 = g.a(localw, (Context)localObject2);
      ((BaseAppBrandSingleCloseCapsuleBar)localObject2).getView().setId(ba.f.half_screen_single_close_capsule_bar);
      ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setCloseBtnListener(new d..ExternalSyntheticLambda2(localw, (BaseAppBrandSingleCloseCapsuleBar)localObject2));
      if ((localAppBrandInitConfigWC.qYw != null) && (localAppBrandInitConfigWC.qAT.qZW.hTH))
      {
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).kz(true);
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setShareBtnListener(new d..ExternalSyntheticLambda0(localAppBrandInitConfigWC));
        label366:
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setTitle(localAppBrandInitConfigWC.hEy);
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setWxaIconUrl(localAppBrandInitConfigWC.iconUrl);
        if (localAppBrandInitConfigWC.qAT.rac != HalfScreenConfig.g.raA) {
          break label560;
        }
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setTitleClickListener(new d..ExternalSyntheticLambda1(paramah, localw, localAppBrandInitConfigWC));
        localObject1 = localw.ccN().getRootView().findViewById(ba.f.app_brand_activity_container_view);
        if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.ui.wxa_container.a))
        {
          Object localObject3 = localw.ccx();
          paramah = paramah.getContext();
          kotlin.g.b.s.s(paramah, "pageView.context");
          paramah = (com.tencent.mm.plugin.appbrand.page.capsulebar.c)((f)localObject3).e(paramah, com.tencent.mm.plugin.appbrand.page.capsulebar.c.class);
          localObject3 = (com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject1;
          kotlin.g.b.s.checkNotNull(paramah);
          ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject3).setExternalHeaderContainer(paramah);
          ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject1).setExternalHeader(((BaseAppBrandSingleCloseCapsuleBar)localObject2).getView());
          ((com.tencent.mm.plugin.appbrand.ui.wxa_container.a)localObject1).setExternalHeaderAnchor((View)localw.qsk);
        }
        label519:
        if (localAppBrandInitConfigWC.qAT.qZP) {
          break label585;
        }
        I(false, false);
      }
      for (;;)
      {
        localb.hZ(false);
        break;
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).kz(false);
        ((BaseAppBrandSingleCloseCapsuleBar)localObject2).setShareBtnListener(null);
        break label366;
        label560:
        paramah = ((BaseAppBrandSingleCloseCapsuleBar)localObject2).getView();
        kotlin.g.b.s.u(paramah, "view");
        ((e)localObject1).cGi().addView(paramah);
        break label519;
        label585:
        if ((bool) && (paramcb != cb.tBt)) {
          I(true, false);
        } else if (!bool) {
          I(false, false);
        }
      }
    }
    paramah = localw.qsp;
    kotlin.g.b.s.s(paramah, "runtime.capsuleBarManager");
    paramah.CN(ba.f.half_screen_single_close_capsule_bar);
    AppMethodBeat.o(324441);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.d.a.c paramc)
  {
    AppMethodBeat.i(324427);
    kotlin.g.b.s.u(paramc, "<set-?>");
    this.uDF = paramc;
    AppMethodBeat.o(324427);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(324459);
    kotlin.g.b.s.u(paramc, "dragState");
    if (paramc == c.uDA)
    {
      paramc = this.uDE;
      if (paramc != null) {
        break label49;
      }
    }
    label49:
    for (paramc = null;; paramc = paramc.cOP())
    {
      if (paramc == com.tencent.mm.plugin.appbrand.widget.s.uxX) {
        cPY();
      }
      AppMethodBeat.o(324459);
      return;
    }
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(324475);
    kotlin.g.b.s.u(paramc, "dragState");
    if (paramc == c.uDA) {
      cPY();
    }
    paramc = cQc().qZQ;
    if (paramc != null)
    {
      paramc = paramc.ett;
      if (paramc != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("Status", 1);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramc.send(0, localBundle);
      }
    }
    cQb();
    AppMethodBeat.o(324475);
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(324478);
    kotlin.g.b.s.u(paramc, "dragState");
    paramc = cQc().qZQ;
    if (paramc != null)
    {
      paramc = paramc.ett;
      if (paramc != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("Status", 0);
        kotlin.ah localah = kotlin.ah.aiuX;
        paramc.send(0, localBundle);
      }
    }
    cQb();
    AppMethodBeat.o(324478);
  }
  
  public final BaseAppBrandSingleCloseCapsuleBar cPZ()
  {
    AppMethodBeat.i(324468);
    Object localObject = this.qxC.qsp.findViewById(ba.f.half_screen_single_close_capsule_bar);
    if ((localObject != null) && ((localObject instanceof BaseAppBrandSingleCloseCapsuleBar)))
    {
      localObject = (BaseAppBrandSingleCloseCapsuleBar)localObject;
      AppMethodBeat.o(324468);
      return localObject;
    }
    AppMethodBeat.o(324468);
    return null;
  }
  
  public final void cQa()
  {
    AppMethodBeat.i(324484);
    if ((cQc().height == -1) && (!cQc().qZO) && (cQc().qZP)) {}
    for (int i = 1;; i = 0)
    {
      if ((this.qxC.qsp != null) && ((cPX()) || (i != 0)))
      {
        BaseAppBrandSingleCloseCapsuleBar localBaseAppBrandSingleCloseCapsuleBar = cPZ();
        if (localBaseAppBrandSingleCloseCapsuleBar != null)
        {
          i = localBaseAppBrandSingleCloseCapsuleBar.getContext().getResources().getColor(localBaseAppBrandSingleCloseCapsuleBar.CO(ba.c.white));
          this.qxC.qsp.setBackgroundColor(i);
        }
      }
      AppMethodBeat.o(324484);
      return;
    }
  }
  
  public final void cQb()
  {
    AppMethodBeat.i(324488);
    HalfScreenConfig localHalfScreenConfig = cQc();
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.qZO)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        MMHandlerThread.postToMainThread(new d..ExternalSyntheticLambda4(this));
      }
      AppMethodBeat.o(324488);
      return;
    }
  }
  
  public final HalfScreenConfig cQc()
  {
    AppMethodBeat.i(324500);
    HalfScreenConfig localHalfScreenConfig = this.qxC.getInitConfig().qAT;
    kotlin.g.b.s.s(localHalfScreenConfig, "runtime.initConfig.halfScreenConfig");
    AppMethodBeat.o(324500);
    return localHalfScreenConfig;
  }
  
  public final boolean cQd()
  {
    AppMethodBeat.i(324502);
    if (this.qxC.getInitConfig().qAT.qZO)
    {
      AppMethodBeat.o(324502);
      return true;
    }
    if (cQc().height != -1)
    {
      AppMethodBeat.o(324502);
      return true;
    }
    AppMethodBeat.o(324502);
    return false;
  }
  
  public final boolean cQe()
  {
    AppMethodBeat.i(324503);
    if ((cQc().qZN == HalfScreenConfig.c.rao) && (cQc().qZP))
    {
      AppMethodBeat.o(324503);
      return true;
    }
    AppMethodBeat.o(324503);
    return false;
  }
  
  public final void cQf()
  {
    AppMethodBeat.i(324504);
    HalfScreenConfig localHalfScreenConfig = cQc();
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.rac == HalfScreenConfig.g.raA)) {}
    for (int i = 1; i != 0; i = 0)
    {
      setCapsuleBarBackgroundRenderer(new d..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(324504);
      return;
    }
    setCapsuleBarBackgroundRenderer(null);
    AppMethodBeat.o(324504);
  }
  
  public final boolean isFullScreen()
  {
    AppMethodBeat.i(324493);
    Object localObject = this.uDE;
    if (localObject == null) {}
    for (localObject = null; localObject == com.tencent.mm.plugin.appbrand.widget.s.uxX; localObject = ((l)localObject).cOP())
    {
      AppMethodBeat.o(324493);
      return true;
    }
    AppMethodBeat.o(324493);
    return false;
  }
  
  public final ValueAnimator jW(long paramLong)
  {
    AppMethodBeat.i(324497);
    ValueAnimator localValueAnimator = this.uDF.h(this.uDF.cQq(), this.uDF.cQr(), paramLong);
    AppMethodBeat.o(324497);
    return localValueAnimator;
  }
  
  final void ly(boolean paramBoolean)
  {
    AppMethodBeat.i(324431);
    if ((paramBoolean) && (cQc().isEnable())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.uDG = paramBoolean;
      AppMethodBeat.o(324431);
      return;
    }
  }
  
  public final void setCapsuleBarBackgroundRenderer(AppBrandGlobalNativeWidgetContainerView.a parama)
  {
    AppMethodBeat.i(324507);
    for (;;)
    {
      try
      {
        localObject1 = this.qxC.qsc;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = null;
      }
      finally
      {
        Object localObject1;
        Object localObject3 = null;
        continue;
      }
      if ((localObject1 instanceof w)) {
        ((w)localObject1).setCapsuleBarBackgroundRenderer(parama);
      }
      AppMethodBeat.o(324507);
      return;
      localObject1 = ((ap)localObject1).y((AppBrandRuntime)this.qxC);
    }
  }
  
  public final boolean v(u paramu)
  {
    AppMethodBeat.i(324450);
    if (this.qxC.ccN().j(paramu) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.HalfScreenManger", "wantAnimateHeader backToStackBottomPage[" + bool + ']');
      AppMethodBeat.o(324450);
      return bool;
    }
  }
  
  public final boolean w(u paramu)
  {
    AppMethodBeat.i(324454);
    if (this.qxC.ccN().j(paramu) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.HalfScreenManger", "wantAnimateHeader navigateToNewPageFromStackBottomPage[" + bool + ']');
      AppMethodBeat.o(324454);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger$showHeader$1", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CallBack;", "callback", "", "alpha", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends j
  {
    d(BaseAppBrandSingleCloseCapsuleBar paramBaseAppBrandSingleCloseCapsuleBar, d paramd) {}
    
    public final void bT(float paramFloat)
    {
      AppMethodBeat.i(324277);
      int i = this.uDK.getContext().getResources().getColor(this.uDK.CO(ba.c.white));
      d.b(jdField_this).qsp.setBackgroundColor(Color.argb((int)(255.0F * paramFloat), Color.red(i), Color.green(i), Color.blue(i)));
      AppMethodBeat.o(324277);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.d
 * JD-Core Version:    0.7.0.1
 */