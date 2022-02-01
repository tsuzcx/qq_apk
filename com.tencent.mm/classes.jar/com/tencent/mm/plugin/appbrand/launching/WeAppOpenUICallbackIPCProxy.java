package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onUIEnterInvokeProxy", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onUIExitInvokeProxy", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "(Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;)V", "isUIExitInvokeIgnored", "", "describeContents", "", "onUIEnter", "", "onUIExit", "isFinish", "setIgnoreUIExitInvoke", "ignore", "writeToParcel", "dest", "flags", "Companion", "MM", "plugin-appbrand-integration_release"})
public final class WeAppOpenUICallbackIPCProxy
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppOpenUICallbackIPCProxy> CREATOR;
  public static final WeAppOpenUICallbackIPCProxy.a pXT;
  public boolean pXQ;
  public a<IPCVoid> pXR;
  private a<IPCBoolean> pXS;
  
  static
  {
    AppMethodBeat.i(281680);
    pXT = new WeAppOpenUICallbackIPCProxy.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(281680);
  }
  
  public WeAppOpenUICallbackIPCProxy(Parcel paramParcel)
  {
    this(locala, paramParcel);
    AppMethodBeat.i(281678);
    AppMethodBeat.o(281678);
  }
  
  public WeAppOpenUICallbackIPCProxy(a<IPCVoid> parama, a<IPCBoolean> parama1)
  {
    AppMethodBeat.i(281676);
    this.pXR = parama;
    this.pXS = parama1;
    AppMethodBeat.o(281676);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(281671);
    if (this.pXQ)
    {
      AppMethodBeat.o(281671);
      return;
    }
    this.pXS.b((Parcelable)new IPCBoolean(paramBoolean));
    AppMethodBeat.o(281671);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(281674);
    p.k(paramParcel, "dest");
    OnWXAppResultXPCWrapper.a(this.pXR, paramParcel);
    OnWXAppResultXPCWrapper.a(this.pXS, paramParcel);
    AppMethodBeat.o(281674);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<WeAppOpenUICallbackIPCProxy>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM;", "", "()V", "TAG", "", "mReleasedUICallbacks", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "", "mUICallbackHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "beforeStartAppBrandUI", "", "initConfig", "targetProcess", "isUICallbackReleased", "uiCallback", "markUICallbackReleased", "stashUICallback", "launchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
  public static final class c
  {
    private static final ConcurrentHashMap<AppBrandInitConfigWC, i> pXU;
    private static final WeakHashMap<i, Boolean> pXV;
    public static final c pXW;
    
    static
    {
      AppMethodBeat.i(279408);
      pXW = new c();
      pXU = new ConcurrentHashMap();
      pXV = new WeakHashMap();
      AppMethodBeat.o(279408);
    }
    
    public static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, LaunchParcel paramLaunchParcel)
    {
      AppMethodBeat.i(279403);
      p.k(paramAppBrandInitConfigWC, "initConfig");
      p.k(paramLaunchParcel, "launchParcel");
      Object localObject = t.pUE;
      localObject = t.BI(paramLaunchParcel.pZq);
      boolean bool;
      if (localObject != null)
      {
        paramLaunchParcel = ((g)localObject).nBG;
        if ((paramLaunchParcel != null) && (!c(paramLaunchParcel))) {
          ((Map)pXU).put(paramAppBrandInitConfigWC, paramLaunchParcel);
        }
        if (localObject == null) {
          break label102;
        }
        bool = ((g)localObject).nBH;
        label72:
        paramAppBrandInitConfigWC.nYw = bool;
        if (localObject == null) {
          break label107;
        }
      }
      label102:
      label107:
      for (paramLaunchParcel = ((g)localObject).nBI;; paramLaunchParcel = null)
      {
        paramAppBrandInitConfigWC.nBI = paramLaunchParcel;
        AppMethodBeat.o(279403);
        return;
        paramLaunchParcel = null;
        break;
        bool = false;
        break label72;
      }
    }
    
    public static final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final String paramString)
    {
      AppMethodBeat.i(279404);
      p.k(paramAppBrandInitConfigWC, "initConfig");
      if (paramString == null)
      {
        h.IzE.el(915, 35);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WeAppOpenUICallbackIPCProxy", "beforeStartAppBrandUI: [%s]", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
        AppMethodBeat.o(279404);
        return;
      }
      Object localObject = (i)pXU.remove(paramAppBrandInitConfigWC);
      if (localObject != null)
      {
        localObject = new AtomicReference(localObject);
        final a locala = new a((AtomicReference)localObject, paramString, paramAppBrandInitConfigWC);
        j.b(paramString, (o)locala);
        paramAppBrandInitConfigWC.nYv = new WeAppOpenUICallbackIPCProxy((a)new c((AtomicReference)localObject), (a)new b((AtomicReference)localObject, locala, paramString, paramAppBrandInitConfigWC));
        AppMethodBeat.o(279404);
        return;
      }
      AppMethodBeat.o(279404);
    }
    
    public static final void b(i parami)
    {
      AppMethodBeat.i(279398);
      p.k(parami, "uiCallback");
      synchronized (pXV)
      {
        ((Map)pXV).put(parami, Boolean.TRUE);
        parami = x.aazN;
        AppMethodBeat.o(279398);
        return;
      }
    }
    
    private static boolean c(i parami)
    {
      AppMethodBeat.i(279400);
      synchronized (pXV)
      {
        boolean bool = pXV.containsKey(parami);
        AppMethodBeat.o(279400);
        return bool;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$processDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
    public static final class a
      implements o
    {
      a(AtomicReference paramAtomicReference, String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
      
      public final void RQ()
      {
        AppMethodBeat.i(263911);
        j.a(paramString, (o)this);
        i locali = (i)this.pXX.get();
        if (locali != null)
        {
          WeAppOpenUICallbackIPCProxy.c localc = WeAppOpenUICallbackIPCProxy.c.pXW;
          if (!WeAppOpenUICallbackIPCProxy.c.d(locali)) {}
        }
        else
        {
          this.pXX.set(null);
          AppMethodBeat.o(263911);
          return;
        }
        locali.bFf();
        this.pXX.set(null);
        AppMethodBeat.o(263911);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$2"})
    static final class b<R extends Parcelable>
      implements a<IPCBoolean>
    {
      b(AtomicReference paramAtomicReference, WeAppOpenUICallbackIPCProxy.c.a parama, String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onWXAppResult"})
    static final class c<R extends Parcelable>
      implements a<IPCVoid>
    {
      c(AtomicReference paramAtomicReference) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy
 * JD-Core Version:    0.7.0.1
 */