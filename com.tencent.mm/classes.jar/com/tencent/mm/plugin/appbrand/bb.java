package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.f.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.keepalive.b;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.b.a;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.threadpool.i.h;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/RemoteLoader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getKey", "", "run", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bb
  implements h
{
  private static final bb.a qya;
  private final AppBrandStatObject qxv;
  private final int qxw;
  private final AppBrandInitConfigWC qyb;
  private final f qyc;
  
  static
  {
    AppMethodBeat.i(316681);
    qya = new bb.a((byte)0);
    AppMethodBeat.o(316681);
  }
  
  public bb(BindRemoteServiceData paramBindRemoteServiceData, f paramf)
  {
    this(paramBindRemoteServiceData.initConfig, paramBindRemoteServiceData.qxv, paramBindRemoteServiceData.qxw, paramf);
    AppMethodBeat.i(316619);
    AppMethodBeat.o(316619);
  }
  
  private bb(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject, int paramInt, f paramf)
  {
    AppMethodBeat.i(316614);
    this.qyb = paramAppBrandInitConfigWC;
    this.qxv = paramAppBrandStatObject;
    this.qxw = paramInt;
    this.qyc = paramf;
    AppMethodBeat.o(316614);
  }
  
  private static final void a(w paramw, bb parambb)
  {
    AppMethodBeat.i(316641);
    Object localObject = paramw.qsc;
    if ((localObject instanceof AppBrandRuntimeContainerWC))
    {
      localObject = (AppBrandRuntimeContainerWC)localObject;
      if ((localObject == null) || (((AppBrandRuntimeContainer)localObject).quf != true)) {
        break label126;
      }
    }
    label126:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run() callbackOnPreRenderComplete id:" + parambb.qxw + ", appId:" + paramw.mAppId + ", instanceId:" + paramw.getInitConfig().eoQ + ", hasResumedContainer:" + bool);
      if (!bool) {
        break label131;
      }
      paramw = parambb.qyc;
      if (paramw == null) {
        break label154;
      }
      f.a.a(paramw, -2);
      AppMethodBeat.o(316641);
      return;
      localObject = null;
      break;
    }
    label131:
    paramw.dispatchPause();
    n.c(paramw);
    paramw = parambb.qyc;
    if (paramw != null) {
      paramw.onSuccess();
    }
    label154:
    AppMethodBeat.o(316641);
  }
  
  private static final void b(w paramw, bb parambb)
  {
    AppMethodBeat.i(316645);
    s.u(paramw, "$preRenderRt");
    s.u(parambb, "this$0");
    a(paramw, parambb);
    AppMethodBeat.o(316645);
  }
  
  private static final void c(w paramw, bb parambb)
  {
    AppMethodBeat.i(316652);
    s.u(paramw, "$preRenderRt");
    s.u(parambb, "this$0");
    paramw.ccN().post(new bb..ExternalSyntheticLambda4(paramw, parambb));
    AppMethodBeat.o(316652);
  }
  
  private static final void cdy() {}
  
  private static final void d(w paramw, bb parambb)
  {
    AppMethodBeat.i(316654);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run() waitForRuntimeInitReady id:" + parambb.qxw + ", appId:" + paramw.mAppId + ", instanceId:" + parambb.qyb.eoQ);
    paramw.a(new bb..ExternalSyntheticLambda0(paramw, parambb));
    paramw.a((be)new b(parambb));
    paramw.cbq();
    parambb = ((a)paramw.getWindowAndroid()).getVDisplayMetrics();
    paramw.qsk.measure(View.MeasureSpec.makeMeasureSpec(parambb.widthPixels, -2147483648), View.MeasureSpec.makeMeasureSpec(parambb.heightPixels, -2147483648));
    AppMethodBeat.o(316654);
  }
  
  private static final void e(w paramw, bb parambb)
  {
    AppMethodBeat.i(316656);
    s.u(parambb, "this$0");
    a(paramw, parambb);
    AppMethodBeat.o(316656);
  }
  
  private static final void f(w paramw, bb parambb)
  {
    AppMethodBeat.i(316669);
    s.u(parambb, "this$0");
    MMHandlerThread.postToMainThread(new bb..ExternalSyntheticLambda3(paramw, parambb));
    AppMethodBeat.o(316669);
  }
  
  private static final void g(w paramw, bb parambb)
  {
    AppMethodBeat.i(316673);
    s.u(parambb, "this$0");
    a(paramw, parambb);
    AppMethodBeat.o(316673);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(316722);
    String str = s.X("AppBrandPreRenderColdStartService.RemoteLoader-", Integer.valueOf(this.qxw));
    AppMethodBeat.o(316722);
    return str;
  }
  
  public final void run()
  {
    Object localObject2 = null;
    boolean bool3 = false;
    AppMethodBeat.i(316740);
    Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run()-start, id:" + this.qxw + ", appId:" + this.qyb.appId + ", instanceId:" + this.qyb.eoQ + ", sessionId:" + this.qyb.eoP);
    w localw = d.Uc(this.qyb.appId);
    boolean bool1;
    Object localObject1;
    boolean bool2;
    if ((localw == null) || (localw.qsE.get()))
    {
      bool1 = true;
      localObject1 = new StringBuilder("run()-shouldReRender:").append(bool1).append(", existedRt:").append(localw).append(", initialized:");
      if (localw != null) {
        break label576;
      }
      bool2 = false;
      label153:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isResumed:");
      if (localw != null) {
        break label585;
      }
      bool2 = false;
      label174:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", isFinishing:");
      if (localw != null) {
        break label594;
      }
      bool2 = false;
      label195:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", destroyed:");
      if (localw != null) {
        break label603;
      }
      bool2 = bool3;
      label217:
      localObject1 = ((StringBuilder)localObject1).append(bool2).append(", versionType:");
      if (localw != null) {
        break label615;
      }
    }
    label393:
    label561:
    label566:
    label571:
    label576:
    label585:
    label594:
    label603:
    label615:
    for (int i = -1;; i = localw.qsh.eul)
    {
      Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", i + ", stashed:" + n.d(localw));
      if (bool1) {
        break label627;
      }
      localObject1 = this.qyc;
      if (localObject1 != null) {
        f.a.a((f)localObject1, -2);
      }
      AppMethodBeat.o(316740);
      return;
      if ((n.d(localw)) || (!localw.isInBackStack()))
      {
        bool1 = true;
        break;
      }
      if (localw.isInBackStack())
      {
        localObject1 = localw.qsc;
        s.checkNotNull(localObject1);
        if (((ap)localObject1).getStackSize() > 1) {}
      }
      else
      {
        label377:
        ap localap;
        if (localw.isInBackStack())
        {
          localObject1 = localw.qsc;
          if ((localObject1 instanceof AppBrandRuntimeContainerWC))
          {
            localObject1 = (AppBrandRuntimeContainerWC)localObject1;
            if ((localObject1 == null) || (((AppBrandRuntimeContainer)localObject1).quf != true)) {
              break label561;
            }
            i = 1;
            if (i != 0) {
              break label571;
            }
          }
        }
        else
        {
          if (n.d(localw)) {
            break label571;
          }
          localap = localw.qsc;
          if (localw.mResumed) {
            localw.dispatchPause();
          }
          if (localap != null) {
            localap.E((AppBrandRuntime)localw);
          }
          ViewParent localViewParent = localw.qsk.getParent();
          localObject1 = localObject2;
          if ((localViewParent instanceof ViewGroup)) {
            localObject1 = (ViewGroup)localViewParent;
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localw.qsk);
          }
          localw.hX(false);
          n.c(localw);
          if ((localap instanceof AppBrandRuntimeContainerWC))
          {
            localObject1 = AndroidContextUtil.castActivityOrNull(((AppBrandRuntimeContainerWC)localap).mContext);
            if ((localObject1 == null) || (((Activity)localObject1).isFinishing() != true)) {
              break label566;
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            ((AppBrandRuntimeContainerWC)localap).asv();
          }
          bool1 = true;
          break;
          localObject1 = null;
          break label377;
          i = 0;
          break label393;
        }
      }
      bool1 = false;
      break;
      bool2 = localw.mInitialized;
      break label153;
      bool2 = localw.mResumed;
      break label174;
      bool2 = localw.ccV;
      break label195;
      bool2 = localw.qsE.get();
      break label217;
    }
    label627:
    b.aj(bb..ExternalSyntheticLambda5.INSTANCE);
    this.qyb.epn = this.qxv;
    if ((localw != null) && (!localw.qsE.get()) && (localw.mInitialized) && (localw.qsh.eul == this.qyb.eul))
    {
      localw.qsd = ((c)new a());
      localw.d((AppBrandInitConfig)this.qyb);
      bool1 = localw.qsG;
      bool2 = localw.qsF;
      localw.dispatchResume();
      if (bool2)
      {
        if (localw.qsE.get())
        {
          localObject1 = this.qyc;
          if (localObject1 != null)
          {
            f.a.a((f)localObject1, -6);
            AppMethodBeat.o(316740);
          }
        }
        else
        {
          d(localw, this);
          AppMethodBeat.o(316740);
        }
      }
      else if (bool1)
      {
        localObject1 = localw.ccK();
        if (localObject1 != null)
        {
          ((ah)localObject1).a(new bb..ExternalSyntheticLambda1(localw, this));
          AppMethodBeat.o(316740);
        }
      }
      else
      {
        MMHandlerThread.postToMainThread(new bb..ExternalSyntheticLambda2(localw, this));
        AppMethodBeat.o(316740);
      }
    }
    else
    {
      localObject1 = new w((c)new a());
      ((w)localObject1).c((AppBrandInitConfig)this.qyb);
      d((w)localObject1, this);
    }
    AppMethodBeat.o(316740);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/RemoteLoader$run$waitForRuntimeInitReady$2", "Lcom/tencent/mm/plugin/appbrand/RuntimeInitResourcePrepareMonitor;", "onResourcePrepareComplete", "", "onResourcePrepareInterrupted", "reason", "", "onResourcePrepareStart", "onResourcePrepareTimeout", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements be
  {
    b(bb parambb) {}
    
    public final void UF(String paramString)
    {
      AppMethodBeat.i(316820);
      paramString = bb.a(this.qyd);
      if (paramString != null) {
        f.a.a(paramString, -7);
      }
      AppMethodBeat.o(316820);
    }
    
    public final void cbz() {}
    
    public final void cdA() {}
    
    public final void cdz() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bb
 * JD-Core Version:    0.7.0.1
 */