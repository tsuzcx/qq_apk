package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.e.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.platform.window.b.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/RemoteLoader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getKey", "", "run", "", "Companion", "plugin-appbrand-integration_release"})
final class av
  implements h
{
  @Deprecated
  public static final av.a nyU;
  private final f nyF;
  private final AppBrandInitConfigWC nyT;
  private final AppBrandStatObject nyh;
  private final int nyi;
  
  static
  {
    AppMethodBeat.i(265664);
    nyU = new av.a((byte)0);
    AppMethodBeat.o(265664);
  }
  
  public av(BindRemoteServiceData paramBindRemoteServiceData, f paramf)
  {
    this(paramBindRemoteServiceData.nyg, paramBindRemoteServiceData.nyh, paramBindRemoteServiceData.nyi, paramf);
    AppMethodBeat.i(265663);
    AppMethodBeat.o(265663);
  }
  
  private av(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt, f paramf)
  {
    AppMethodBeat.i(265662);
    this.nyT = paramAppBrandInitConfigWC;
    this.nyh = paramAppBrandStatObject;
    this.nyi = paramInt;
    this.nyF = paramf;
    AppMethodBeat.o(265662);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(265658);
    String str = "AppBrandPreRenderColdStartService.RemoteLoader-" + this.nyi;
    AppMethodBeat.o(265658);
    return str;
  }
  
  public final void run()
  {
    boolean bool3 = false;
    AppMethodBeat.i(265661);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run()-start, id:" + this.nyi + ", appId:" + this.nyT.appId + ", instanceId:" + this.nyT.Qx());
    final t localt = d.abA(this.nyT.appId);
    boolean bool1;
    boolean bool2;
    if ((localt == null) || (localt.isDestroyed()))
    {
      bool1 = true;
      localObject1 = new StringBuilder("run()-shouldReRender:").append(bool1).append(", existedRt:").append(localt).append(", initialized:");
      if (localt == null) {
        break label569;
      }
      bool2 = localt.bCj();
      label130:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isResumed:");
      if (localt == null) {
        break label574;
      }
      bool2 = localt.isResumed();
      label154:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isFinishing:");
      if (localt == null) {
        break label579;
      }
      bool2 = localt.isFinishing();
      label178:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", destroyed:");
      bool2 = bool3;
      if (localt != null) {
        bool2 = localt.isDestroyed();
      }
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", versionType:");
      if (localt == null) {
        break label584;
      }
    }
    label569:
    label574:
    label579:
    label584:
    for (int i = localt.bBV();; i = -1)
    {
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", i + ", stashed:" + n.d(localt));
      if (bool1) {
        break label595;
      }
      localObject1 = this.nyF;
      if (localObject1 == null) {
        break label589;
      }
      f.a.a((f)localObject1, -2);
      AppMethodBeat.o(265661);
      return;
      if ((n.d(localt)) || (!localt.isInBackStack()))
      {
        bool1 = true;
        break;
      }
      if (localt.isInBackStack())
      {
        localObject1 = localt.bBY();
        if (localObject1 == null) {
          p.iCn();
        }
        p.j(localObject1, "existedRt.runtimeContainer!!");
        if (((ak)localObject1).getStackSize() > 1) {}
      }
      else
      {
        if (localt.isInBackStack())
        {
          localObject2 = localt.bBY();
          localObject1 = localObject2;
          if (!(localObject2 instanceof AppBrandRuntimeContainerWC)) {
            localObject1 = null;
          }
          localObject1 = (AppBrandRuntimeContainerWC)localObject1;
          if ((localObject1 != null) && (((AppBrandRuntimeContainerWC)localObject1).bCT() == true))
          {
            bool1 = false;
            break;
          }
        }
        if (!n.d(localt))
        {
          ak localak = localt.bBY();
          if (localt.isResumed()) {
            localt.dispatchPause();
          }
          if (localak != null) {
            localak.C((AppBrandRuntime)localt);
          }
          localObject1 = localt.bBZ();
          p.j(localObject1, "existedRt.contentView");
          localObject2 = ((com.tencent.mm.plugin.appbrand.widget.d)localObject1).getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ViewGroup)) {
            localObject1 = null;
          }
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localt.bBZ());
          }
          localt.bDw();
          n.c(localt);
          if ((localak instanceof AppBrandRuntimeContainerWC))
          {
            localObject1 = ((AppBrandRuntimeContainerWC)localak).getActivity();
            if ((localObject1 == null) || (((Activity)localObject1).isFinishing() != true)) {
              ((AppBrandRuntimeContainerWC)localak).Se();
            }
          }
          bool1 = true;
          break;
        }
      }
      bool1 = false;
      break;
      bool2 = false;
      break label130;
      bool2 = false;
      break label154;
      bool2 = false;
      break label178;
    }
    label589:
    AppMethodBeat.o(265661);
    return;
    label595:
    com.tencent.mm.plugin.appbrand.keepalive.b.ad((Runnable)av.b.nyV);
    this.nyT.a(this.nyh);
    Object localObject1 = new c(this);
    Object localObject2 = new d(this, (c)localObject1);
    if ((localt != null) && (!localt.isDestroyed()) && (localt.bCj()) && (localt.bBV() == this.nyT.bLh()))
    {
      localt.a((c)new a());
      localt.d((AppBrandInitConfig)this.nyT);
      bool1 = localt.bCv();
      bool2 = localt.bCt();
      localt.dispatchResume();
      if (bool2)
      {
        if (localt.isDestroyed())
        {
          localObject1 = this.nyF;
          if (localObject1 != null)
          {
            f.a.a((f)localObject1, -6);
            AppMethodBeat.o(265661);
            return;
          }
          AppMethodBeat.o(265661);
          return;
        }
        ((d)localObject2).r(localt);
        AppMethodBeat.o(265661);
        return;
      }
      if (bool1)
      {
        localObject2 = localt.bDv();
        if (localObject2 != null)
        {
          ((ah)localObject2).a((h.f)new e((c)localObject1, localt));
          AppMethodBeat.o(265661);
          return;
        }
        AppMethodBeat.o(265661);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new f((c)localObject1, localt));
      AppMethodBeat.o(265661);
      return;
    }
    localObject1 = new t((c)new a());
    ((t)localObject1).c((AppBrandInitConfig)this.nyT);
    ((d)localObject2).r((t)localObject1);
    AppMethodBeat.o(265661);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"callbackOnPreRenderComplete", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<t, x>
  {
    c(av paramav)
    {
      super();
    }
    
    public final void r(t paramt)
    {
      AppMethodBeat.i(277496);
      p.k(paramt, "$this$callbackOnPreRenderComplete");
      Object localObject2 = paramt.bBY();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof AppBrandRuntimeContainerWC)) {
        localObject1 = null;
      }
      localObject1 = (AppBrandRuntimeContainerWC)localObject1;
      if ((localObject1 != null) && (((AppBrandRuntimeContainerWC)localObject1).bCT() == true)) {}
      for (boolean bool = true;; bool = false)
      {
        av.bEp();
        localObject1 = new StringBuilder("run() callbackOnPreRenderComplete id:").append(av.a(this.nyW)).append(", appId:").append(paramt.getAppId()).append(", instanceId:");
        localObject2 = paramt.bDy();
        p.j(localObject2, "rt.initConfig");
        Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", ((AppBrandInitConfigWC)localObject2).Qx() + ", hasResumedContainer:" + bool);
        if (!bool) {
          break label168;
        }
        paramt = av.b(this.nyW);
        if (paramt == null) {
          break;
        }
        f.a.a(paramt, -2);
        AppMethodBeat.o(277496);
        return;
      }
      AppMethodBeat.o(277496);
      return;
      label168:
      paramt.dispatchPause();
      n.c(paramt);
      paramt = av.b(this.nyW);
      if (paramt != null)
      {
        paramt.onSuccess();
        AppMethodBeat.o(277496);
        return;
      }
      AppMethodBeat.o(277496);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"waitForRuntimeInitReady", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<t, x>
  {
    d(av paramav, av.c paramc)
    {
      super();
    }
    
    public final void r(final t paramt)
    {
      AppMethodBeat.i(282197);
      p.k(paramt, "$this$waitForRuntimeInitReady");
      av.bEp();
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run() waitForRuntimeInitReady id:" + av.a(this.nyW) + ", appId:" + paramt.getAppId() + ", instanceId:" + av.c(this.nyW).Qx());
      paramt.a((ar)new ar()
      {
        public final void bEo()
        {
          AppMethodBeat.i(271294);
          this.nyY.nyX.r(paramt);
          AppMethodBeat.o(271294);
        }
      });
      paramt.a((ay)new ay()
      {
        public final void ace(String paramAnonymousString)
        {
          AppMethodBeat.i(275513);
          paramAnonymousString = av.b(this.nyY.nyW);
          if (paramAnonymousString != null)
          {
            f.a.a(paramAnonymousString, -7);
            AppMethodBeat.o(275513);
            return;
          }
          AppMethodBeat.o(275513);
        }
        
        public final void bCk() {}
        
        public final void bEq() {}
        
        public final void bEr() {}
      });
      paramt.bBT();
      Object localObject = paramt.getWindowAndroid();
      if (localObject == null)
      {
        paramt = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.platform.window.fake.PreRenderCustomWindowAndroid");
        AppMethodBeat.o(282197);
        throw paramt;
      }
      localObject = ((a)localObject).getVDisplayMetrics();
      paramt.bBZ().measure(View.MeasureSpec.makeMeasureSpec(((DisplayMetrics)localObject).widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(((DisplayMetrics)localObject).heightPixels, -2147483648));
      AppMethodBeat.o(282197);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onReady"})
  static final class e
    implements h.f
  {
    e(av.c paramc, t paramt) {}
    
    public final void NR()
    {
      AppMethodBeat.i(263583);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(272279);
          this.nzb.nyX.r(this.nzb.nza);
          AppMethodBeat.o(272279);
        }
      });
      AppMethodBeat.o(263583);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(av.c paramc, t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(259064);
      this.nyX.r(localt);
      AppMethodBeat.o(259064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.av
 * JD-Core Version:    0.7.0.1
 */