package com.tencent.mm.plugin.appbrand.widget.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.HalfPage;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenManger;", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "controller", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "getController", "()Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;", "setController", "(Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenGestureController;)V", "animateFullScreen", "", "canRespondToPageNavigation", "", "type", "Lcom/tencent/mm/plugin/appbrand/page/PageOpenType;", "findSingleCloseCapsuleBar", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandSingleCloseCapsuleBar;", "getFirstPageNavigationStyleConfig", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "interceptTapToFullScreen", "ev", "Landroid/view/MotionEvent;", "isFirstPageForCurrentLaunch", "isFullScreen", "onDragStatusChanged", "dragState", "Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/HalfScreenDragStatus;", "onEnterFullScreen", "onEnterHalfScreen", "onForeground", "onNavigateStart", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "onPageSwitchCancel", "oldPage", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPage;", "newPage", "onPageSwitchEnd", "onPageSwitchProgress", "percent", "", "onPageSwitchStart", "setStatusBarStyle", "trySetupHalfScreenCapsuleBar", "tryShowCustomNavigateStyle", "wantAnimateHeader", "Lkotlin/Pair;", "Companion", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e.a rtb;
  public final t nAH;
  public i rta;
  
  static
  {
    AppMethodBeat.i(276818);
    rtb = new e.a((byte)0);
    AppMethodBeat.o(276818);
  }
  
  public e(t paramt)
  {
    AppMethodBeat.i(276817);
    this.nAH = paramt;
    AppMethodBeat.o(276817);
  }
  
  public static void a(ah paramah, ca paramca)
  {
    AppMethodBeat.i(276806);
    kotlin.g.b.p.k(paramah, "pageView");
    Object localObject2 = paramah.getRuntime();
    kotlin.g.b.p.j(localObject2, "runtime");
    AppBrandInitConfigWC localAppBrandInitConfigWC = ((t)localObject2).bDy();
    kotlin.g.b.p.j(localAppBrandInitConfigWC, "runtime.initConfig");
    b localb = paramah.cdY();
    if (localAppBrandInitConfigWC.nBE.isEnable())
    {
      Log.i("MicroMsg.HalfScreenManger", "[trySetupHalfScreenCapsuleBar]  PageOpenType[" + paramca + "]  capsuleType[" + localAppBrandInitConfigWC.nBE.nZD + ']');
      com.tencent.mm.plugin.appbrand.page.capsulebar.e locale = ((t)localObject2).bCD();
      kotlin.g.b.p.j(locale, "runtime.capsuleBarManager");
      paramah = localAppBrandInitConfigWC.nBE.nZD;
      switch (f.$EnumSwitchMapping$0[paramah.ordinal()])
      {
      default: 
        AppMethodBeat.o(276806);
        return;
      case 1: 
        localb.hk(false);
        locale.Cx(au.f.half_screen_single_close_capsule_bar);
        AppMethodBeat.o(276806);
        return;
      case 2: 
        localb.hk(true);
        locale.Cx(au.f.half_screen_single_close_capsule_bar);
        AppMethodBeat.o(276806);
        return;
      }
      boolean bool = a(paramca, (t)localObject2);
      Object localObject1 = ((t)localObject2).bCD().findViewById(au.f.half_screen_single_close_capsule_bar);
      paramah = (ah)localObject1;
      if (!(localObject1 instanceof AppBrandSingleCloseCapsuleBar))
      {
        kotlin.g.b.p.j(localb, "actionBar");
        paramah = localb.getContext();
        kotlin.g.b.p.j(paramah, "actionBar.context");
        paramah = (View)new AppBrandSingleCloseCapsuleBar(paramah);
      }
      locale.Cx(au.f.half_screen_single_close_capsule_bar);
      ((AppBrandSingleCloseCapsuleBar)paramah).setId(au.f.half_screen_single_close_capsule_bar);
      ((AppBrandSingleCloseCapsuleBar)paramah).setCloseBtnListener((View.OnClickListener)new e.c((t)localObject2));
      localObject1 = (AppBrandSingleCloseCapsuleBar)paramah;
      localObject2 = localAppBrandInitConfigWC.fzM;
      kotlin.g.b.p.j(localObject2, "initConfig.brandName");
      ((AppBrandSingleCloseCapsuleBar)localObject1).setTitle((String)localObject2);
      localObject1 = (AppBrandSingleCloseCapsuleBar)paramah;
      localObject2 = localAppBrandInitConfigWC.iconUrl;
      kotlin.g.b.p.j(localObject2, "initConfig.iconUrl");
      ((AppBrandSingleCloseCapsuleBar)localObject1).setWxaIconUrl((String)localObject2);
      if (!localAppBrandInitConfigWC.nBE.nZF) {
        ((AppBrandSingleCloseCapsuleBar)paramah).B(false, false);
      }
      for (;;)
      {
        kotlin.g.b.p.k(paramah, "view");
        paramca = locale.qxd;
        if (paramca == null) {
          kotlin.g.b.p.bGy("capsuleBarContainerLayout");
        }
        paramca.addView(paramah);
        localb.hk(false);
        AppMethodBeat.o(276806);
        return;
        if ((bool) && (paramca != ca.qwE)) {
          ((AppBrandSingleCloseCapsuleBar)paramah).B(true, false);
        }
      }
    }
    paramah = ((t)localObject2).bCD();
    kotlin.g.b.p.j(paramah, "runtime.capsuleBarManager");
    paramah.Cx(au.f.half_screen_single_close_capsule_bar);
    AppMethodBeat.o(276806);
  }
  
  public static boolean a(ca paramca, t paramt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(276807);
    y localy;
    boolean bool1;
    if (paramca == null)
    {
      localy = paramt.bDz();
      kotlin.g.b.p.j(localy, "runtime.pageContainer");
      if (localy.getPageCount() != 1) {
        break label267;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      paramca = new StringBuilder("[isFirstPage]  PageOpenType[").append(paramca).append("]  isFirstPage[").append(bool1).append("]  pageCount[");
      localy = paramt.bDz();
      kotlin.g.b.p.j(localy, "runtime.pageContainer");
      paramca = paramca.append(localy.getPageCount()).append("]  actualPageStackSize[");
      paramt = paramt.bDz();
      kotlin.g.b.p.j(paramt, "runtime.pageContainer");
      Log.i("MicroMsg.HalfScreenManger", paramt.getActualPageStackSize() + ']');
      AppMethodBeat.o(276807);
      return bool1;
      bool1 = bool2;
      switch (f.jLJ[paramca.ordinal()])
      {
      case 9: 
      case 10: 
      default: 
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
        localy = paramt.bDz();
        kotlin.g.b.p.j(localy, "runtime.pageContainer");
        bool1 = bool2;
        if (localy.getPageCount() != 1) {
          bool1 = false;
        }
        break;
      case 7: 
      case 8: 
        localy = paramt.bDz();
        kotlin.g.b.p.j(localy, "runtime.pageContainer");
        bool1 = bool2;
        if (localy.getActualPageStackSize() != 1)
        {
          bool1 = false;
          continue;
          label267:
          bool1 = false;
        }
        break;
      }
    }
  }
  
  public static boolean a(t paramt, ca paramca)
  {
    AppMethodBeat.i(276809);
    if (paramca != ca.qwE)
    {
      paramt = paramt.bDy().nBE;
      if ((paramt.isEnable()) && (paramt.nZF))
      {
        AppMethodBeat.o(276809);
        return true;
      }
    }
    AppMethodBeat.o(276809);
    return false;
  }
  
  private static String l(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(276815);
    Object localObject = c.rsW;
    if (c.cnL())
    {
      Log.d("MicroMsg.HalfScreenManger", "[getFirstPageNavigationStyleConfig] DEBUG force firstPageNavigationStyleCustom");
      AppMethodBeat.o(276815);
      return "custom";
    }
    if (paramAppBrandInitConfigWC != null)
    {
      paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.cwY;
      if (paramAppBrandInitConfigWC != null)
      {
        paramAppBrandInitConfigWC = paramAppBrandInitConfigWC.obM;
        if (paramAppBrandInitConfigWC != null)
        {
          localObject = paramAppBrandInitConfigWC.oaT;
          paramAppBrandInitConfigWC = (AppBrandInitConfigWC)localObject;
          if (localObject != null) {
            break label71;
          }
        }
      }
    }
    paramAppBrandInitConfigWC = "default";
    label71:
    AppMethodBeat.o(276815);
    return paramAppBrandInitConfigWC;
  }
  
  public final boolean QT()
  {
    AppMethodBeat.i(276816);
    Object localObject = this.rta;
    if (localObject != null) {}
    for (localObject = ((i)localObject).cmX(); localObject == com.tencent.mm.plugin.appbrand.widget.p.roc; localObject = null)
    {
      AppMethodBeat.o(276816);
      return true;
    }
    AppMethodBeat.o(276816);
    return false;
  }
  
  public final o<Boolean, Boolean> a(u paramu1, u paramu2, AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    int j = 0;
    AppMethodBeat.i(276810);
    boolean bool1;
    if (this.nAH.bDz().j(paramu1) == 0)
    {
      bool1 = true;
      Log.i("MicroMsg.HalfScreenManger", "wantAnimateHeader navigateToNewPageFromStackBottomPage[" + bool1 + ']');
      if (this.nAH.bDz().j(paramu2) != 0) {
        break label137;
      }
    }
    label137:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.HalfScreenManger", "wantAnimateHeader backToStackBottomPage[" + bool2 + ']');
      if ((bool2) || (bool1)) {
        break label143;
      }
      paramu1 = Boolean.FALSE;
      paramu1 = new o(paramu1, paramu1);
      AppMethodBeat.o(276810);
      return paramu1;
      bool1 = false;
      break;
    }
    label143:
    int i = j;
    if (kotlin.g.b.p.h(l(paramAppBrandInitConfigWC), "custom"))
    {
      i = j;
      if (paramAppBrandInitConfigWC.nBE.nZI)
      {
        paramu1 = this.rta;
        if (paramu1 == null) {
          break label236;
        }
      }
    }
    label236:
    for (paramu1 = paramu1.cmX();; paramu1 = null)
    {
      i = j;
      if (paramu1 == com.tencent.mm.plugin.appbrand.widget.p.roc) {
        i = 1;
      }
      if ((!bool2) || (i == 0)) {
        break;
      }
      paramu1 = Boolean.FALSE;
      paramu1 = new o(paramu1, paramu1);
      AppMethodBeat.o(276810);
      return paramu1;
    }
    if ((!bool2) && (i != 0))
    {
      paramu1 = cnN();
      if ((paramu1 != null) && (paramu1.cfA() == true))
      {
        paramu1 = Boolean.FALSE;
        paramu1 = new o(paramu1, paramu1);
        AppMethodBeat.o(276810);
        return paramu1;
      }
    }
    paramu1 = new o(Boolean.TRUE, Boolean.valueOf(bool2));
    AppMethodBeat.o(276810);
    return paramu1;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(276812);
    kotlin.g.b.p.k(paramd, "dragState");
    if (paramd == d.rsX)
    {
      paramd = this.rta;
      if (paramd == null) {
        break label54;
      }
    }
    label54:
    for (paramd = paramd.cmX();; paramd = null)
    {
      if (paramd == com.tencent.mm.plugin.appbrand.widget.p.roc) {
        cnM();
      }
      AppMethodBeat.o(276812);
      return;
    }
  }
  
  final void cnM()
  {
    AppMethodBeat.i(276808);
    AppBrandSingleCloseCapsuleBar localAppBrandSingleCloseCapsuleBar = cnN();
    AppBrandInitConfigWC localAppBrandInitConfigWC = this.nAH.bDy();
    if ((localAppBrandSingleCloseCapsuleBar instanceof AppBrandSingleCloseCapsuleBar))
    {
      if (localAppBrandInitConfigWC == null) {
        break label73;
      }
      HalfScreenConfig localHalfScreenConfig = localAppBrandInitConfigWC.nBE;
      if (localHalfScreenConfig == null) {
        break label73;
      }
      if ((localHalfScreenConfig.nZI == true) && (kotlin.g.b.p.h(l(localAppBrandInitConfigWC), "custom"))) {
        localAppBrandSingleCloseCapsuleBar.B(false, true);
      }
    }
    AppMethodBeat.o(276808);
    return;
    label73:
    AppMethodBeat.o(276808);
  }
  
  public final AppBrandSingleCloseCapsuleBar cnN()
  {
    AppMethodBeat.i(276813);
    Object localObject = this.nAH.bCD().findViewById(au.f.half_screen_single_close_capsule_bar);
    if (localObject != null)
    {
      if ((localObject instanceof AppBrandSingleCloseCapsuleBar))
      {
        localObject = (AppBrandSingleCloseCapsuleBar)localObject;
        AppMethodBeat.o(276813);
        return localObject;
      }
      AppMethodBeat.o(276813);
      return null;
    }
    AppMethodBeat.o(276813);
    return null;
  }
  
  public final void cnO()
  {
    AppMethodBeat.i(276814);
    HalfScreenConfig localHalfScreenConfig = this.nAH.bDy().nBE;
    if ((localHalfScreenConfig.isEnable()) && (localHalfScreenConfig.nZE)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        MMHandlerThread.postToMainThread((Runnable)new b(this));
      }
      AppMethodBeat.o(276814);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(273550);
      Object localObject = e.a(this.rtc).bDv();
      if (localObject != null)
      {
        localObject = ((ah)localObject).cdZ();
        if (localObject != null)
        {
          if (!this.rtc.QT()) {}
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.d)localObject).setStatusBarForegroundStyle(bool);
            AppMethodBeat.o(273550);
            return;
          }
        }
      }
      AppMethodBeat.o(273550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.e
 * JD-Core Version:    0.7.0.1
 */