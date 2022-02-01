package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/RemoteLoader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getKey", "", "run", "", "Companion", "plugin-appbrand-integration_release"})
final class at
  implements h
{
  @Deprecated
  public static final a kFo;
  private final AppBrandStatObject kEH;
  private final int kEI;
  private final f kEZ;
  private final AppBrandInitConfigWC kFn;
  
  static
  {
    AppMethodBeat.i(227949);
    kFo = new a((byte)0);
    AppMethodBeat.o(227949);
  }
  
  public at(BindRemoteServiceData paramBindRemoteServiceData, f paramf)
  {
    this(paramBindRemoteServiceData.kEG, paramBindRemoteServiceData.kEH, paramBindRemoteServiceData.kEI, paramf);
    AppMethodBeat.i(227948);
    AppMethodBeat.o(227948);
  }
  
  private at(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt, f paramf)
  {
    AppMethodBeat.i(227947);
    this.kFn = paramAppBrandInitConfigWC;
    this.kEH = paramAppBrandStatObject;
    this.kEI = paramInt;
    this.kEZ = paramf;
    AppMethodBeat.o(227947);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(227945);
    String str = "AppBrandPreRenderColdStartService.RemoteLoader-" + this.kEI;
    AppMethodBeat.o(227945);
    return str;
  }
  
  public final void run()
  {
    boolean bool3 = false;
    AppMethodBeat.i(227946);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run()-start, id:" + this.kEI + ", appId:" + this.kFn.appId + ", instanceId:" + this.kFn.NC());
    final q localq = a.TQ(this.kFn.appId);
    boolean bool1;
    boolean bool2;
    if ((localq == null) || (localq.isDestroyed()))
    {
      bool1 = true;
      localObject1 = new StringBuilder("run()-shouldReRender:").append(bool1).append(", existedRt:").append(localq).append(", initialized:");
      if (localq == null) {
        break label570;
      }
      bool2 = localq.brt();
      label130:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isResumed:");
      if (localq == null) {
        break label575;
      }
      bool2 = localq.isResumed();
      label154:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isFinishing:");
      if (localq == null) {
        break label580;
      }
      bool2 = localq.isFinishing();
      label178:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", destroyed:");
      bool2 = bool3;
      if (localq != null) {
        bool2 = localq.isDestroyed();
      }
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", versionType:");
      if (localq == null) {
        break label585;
      }
    }
    label570:
    label575:
    label580:
    label585:
    for (int i = localq.brf();; i = -1)
    {
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", i + ", stashed:" + k.d(localq));
      if (bool1) {
        break label596;
      }
      localObject1 = this.kEZ;
      if (localObject1 == null) {
        break label590;
      }
      f.a.a((f)localObject1, -2);
      AppMethodBeat.o(227946);
      return;
      if ((k.d(localq)) || (!localq.isInBackStack()))
      {
        bool1 = true;
        break;
      }
      if (localq.isInBackStack())
      {
        localObject1 = localq.bri();
        if (localObject1 == null) {
          p.hyc();
        }
        p.g(localObject1, "existedRt.runtimeContainer!!");
        if (((ak)localObject1).getStackSize() > 1) {}
      }
      else
      {
        if (localq.isInBackStack())
        {
          localObject2 = localq.bri();
          localObject1 = localObject2;
          if (!(localObject2 instanceof AppBrandRuntimeContainerWC)) {
            localObject1 = null;
          }
          localObject1 = (AppBrandRuntimeContainerWC)localObject1;
          if ((localObject1 != null) && (((AppBrandRuntimeContainerWC)localObject1).bsd() == true))
          {
            bool1 = false;
            break;
          }
        }
        if (!k.d(localq))
        {
          ak localak = localq.bri();
          if (localq.isResumed()) {
            localq.dispatchPause();
          }
          if (localak != null) {
            localak.A((AppBrandRuntime)localq);
          }
          localObject1 = localq.brj();
          p.g(localObject1, "existedRt.contentView");
          localObject2 = ((com.tencent.mm.plugin.appbrand.widget.c)localObject1).getParent();
          localObject1 = localObject2;
          if (!(localObject2 instanceof ViewGroup)) {
            localObject1 = null;
          }
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localq.brj());
          }
          localq.bsA();
          k.c(localq);
          if ((localak instanceof AppBrandRuntimeContainerWC))
          {
            localObject1 = ((AppBrandRuntimeContainerWC)localak).getActivity();
            if ((localObject1 == null) || (((Activity)localObject1).isFinishing() != true)) {
              ((AppBrandRuntimeContainerWC)localak).OH();
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
    label590:
    AppMethodBeat.o(227946);
    return;
    label596:
    com.tencent.mm.plugin.appbrand.keepalive.b.c(AppBrandPluginUI.class.getName(), (Runnable)b.kFp);
    this.kFn.a(this.kEH);
    Object localObject1 = new c(this);
    Object localObject2 = new d(this, (c)localObject1);
    if ((localq != null) && (!localq.isDestroyed()) && (localq.brt()) && (localq.brf() == this.kFn.bzS()))
    {
      localq.a((com.tencent.mm.plugin.appbrand.platform.window.c)new com.tencent.mm.plugin.appbrand.platform.window.b.a());
      localq.d((AppBrandInitConfig)this.kFn);
      bool1 = localq.brF();
      bool2 = localq.brD();
      localq.dispatchResume();
      if (bool2)
      {
        if (localq.isDestroyed())
        {
          localObject1 = this.kEZ;
          if (localObject1 != null)
          {
            f.a.a((f)localObject1, -6);
            AppMethodBeat.o(227946);
            return;
          }
          AppMethodBeat.o(227946);
          return;
        }
        ((d)localObject2).q(localq);
        AppMethodBeat.o(227946);
        return;
      }
      if (bool1)
      {
        localObject2 = localq.bsz();
        if (localObject2 != null)
        {
          ((ag)localObject2).a((i.f)new e((c)localObject1, localq));
          AppMethodBeat.o(227946);
          return;
        }
        AppMethodBeat.o(227946);
        return;
      }
      MMHandlerThread.postToMainThread((Runnable)new f((c)localObject1, localq));
      AppMethodBeat.o(227946);
      return;
    }
    localObject1 = new q((com.tencent.mm.plugin.appbrand.platform.window.c)new com.tencent.mm.plugin.appbrand.platform.window.b.a());
    ((q)localObject1).c((AppBrandInitConfig)this.kFn);
    ((d)localObject2).q((q)localObject1);
    AppMethodBeat.o(227946);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/RemoteLoader$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b kFp;
    
    static
    {
      AppMethodBeat.i(227935);
      kFp = new b();
      AppMethodBeat.o(227935);
    }
    
    public final void run() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"callbackOnPreRenderComplete", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<q, x>
  {
    c(at paramat)
    {
      super();
    }
    
    public final void q(q paramq)
    {
      AppMethodBeat.i(227937);
      p.h(paramq, "$this$callbackOnPreRenderComplete");
      Object localObject2 = paramq.bri();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof AppBrandRuntimeContainerWC)) {
        localObject1 = null;
      }
      localObject1 = (AppBrandRuntimeContainerWC)localObject1;
      if ((localObject1 != null) && (((AppBrandRuntimeContainerWC)localObject1).bsd() == true)) {}
      for (boolean bool = true;; bool = false)
      {
        at.bts();
        localObject1 = new StringBuilder("run() callbackOnPreRenderComplete id:").append(at.a(this.kFq)).append(", appId:").append(paramq.getAppId()).append(", instanceId:");
        localObject2 = paramq.bsC();
        p.g(localObject2, "rt.initConfig");
        Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", ((AppBrandInitConfigWC)localObject2).NC() + ", hasResumedContainer:" + bool);
        if (!bool) {
          break label168;
        }
        paramq = at.b(this.kFq);
        if (paramq == null) {
          break;
        }
        f.a.a(paramq, -2);
        AppMethodBeat.o(227937);
        return;
      }
      AppMethodBeat.o(227937);
      return;
      label168:
      paramq.dispatchPause();
      k.c(paramq);
      paramq = at.b(this.kFq);
      if (paramq != null)
      {
        paramq.onSuccess();
        AppMethodBeat.o(227937);
        return;
      }
      AppMethodBeat.o(227937);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"waitForRuntimeInitReady", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<q, x>
  {
    d(at paramat, at.c paramc)
    {
      super();
    }
    
    public final void q(final q paramq)
    {
      AppMethodBeat.i(227941);
      p.h(paramq, "$this$waitForRuntimeInitReady");
      at.bts();
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run() waitForRuntimeInitReady id:" + at.a(this.kFq) + ", appId:" + paramq.getAppId() + ", instanceId:" + at.c(this.kFq).NC());
      paramq.a((aq)new aq()
      {
        public final void btr()
        {
          AppMethodBeat.i(227938);
          this.kFs.kFr.q(paramq);
          AppMethodBeat.o(227938);
        }
      });
      paramq.a((aw)new aw()
      {
        public final void Uu(String paramAnonymousString)
        {
          AppMethodBeat.i(227939);
          paramAnonymousString = at.b(this.kFs.kFq);
          if (paramAnonymousString != null)
          {
            f.a.a(paramAnonymousString, -7);
            AppMethodBeat.o(227939);
            return;
          }
          AppMethodBeat.o(227939);
        }
        
        public final void bru() {}
        
        public final void btt() {}
        
        public final void btu() {}
      });
      paramq.brd();
      Object localObject = paramq.getWindowAndroid();
      if (localObject == null)
      {
        paramq = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.platform.window.fake.PreRenderCustomWindowAndroid");
        AppMethodBeat.o(227941);
        throw paramq;
      }
      localObject = ((com.tencent.mm.plugin.appbrand.platform.window.b.a)localObject).getVDisplayMetrics();
      paramq.brj().measure(View.MeasureSpec.makeMeasureSpec(((DisplayMetrics)localObject).widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(((DisplayMetrics)localObject).heightPixels, -2147483648));
      AppMethodBeat.o(227941);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onReady"})
  static final class e
    implements i.f
  {
    e(at.c paramc, q paramq) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(227943);
      MMHandlerThread.postToMainThread((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227942);
          this.kFv.kFr.q(this.kFv.kFu);
          AppMethodBeat.o(227942);
        }
      });
      AppMethodBeat.o(227943);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(at.c paramc, q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(227944);
      this.kFr.q(localq);
      AppMethodBeat.o(227944);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.at
 * JD-Core Version:    0.7.0.1
 */