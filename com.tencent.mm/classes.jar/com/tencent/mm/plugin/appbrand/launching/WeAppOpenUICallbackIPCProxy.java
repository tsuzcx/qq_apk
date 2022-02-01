package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCWrapper;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onUIEnterInvokeProxy", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onUIExitInvokeProxy", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "(Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;)V", "isUIExitInvokeIgnored", "", "describeContents", "", "onUIEnter", "", "onUIExit", "isFinish", "setIgnoreUIExitInvoke", "ignore", "writeToParcel", "dest", "flags", "Companion", "MM", "plugin-appbrand-integration_release"})
public final class WeAppOpenUICallbackIPCProxy
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppOpenUICallbackIPCProxy> CREATOR;
  public static final a mXz;
  public boolean mXw;
  public a<IPCVoid> mXx;
  private a<IPCBoolean> mXy;
  
  static
  {
    AppMethodBeat.i(228740);
    mXz = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(228740);
  }
  
  public WeAppOpenUICallbackIPCProxy(Parcel paramParcel)
  {
    this(locala, paramParcel);
    AppMethodBeat.i(228739);
    AppMethodBeat.o(228739);
  }
  
  public WeAppOpenUICallbackIPCProxy(a<IPCVoid> parama, a<IPCBoolean> parama1)
  {
    AppMethodBeat.i(228738);
    this.mXx = parama;
    this.mXy = parama1;
    AppMethodBeat.o(228738);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void hY(boolean paramBoolean)
  {
    AppMethodBeat.i(228736);
    if (this.mXw)
    {
      AppMethodBeat.o(228736);
      return;
    }
    this.mXy.b((Parcelable)new IPCBoolean(paramBoolean));
    AppMethodBeat.o(228736);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(228737);
    p.h(paramParcel, "dest");
    OnWXAppResultXPCWrapper.a(this.mXx, paramParcel);
    OnWXAppResultXPCWrapper.a(this.mXy, paramParcel);
    AppMethodBeat.o(228737);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"})
  public static final class b
    implements Parcelable.Creator<WeAppOpenUICallbackIPCProxy>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM;", "", "()V", "TAG", "", "mReleasedUICallbacks", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "", "mUICallbackHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "beforeStartAppBrandUI", "", "initConfig", "targetProcess", "isUICallbackReleased", "uiCallback", "markUICallbackReleased", "stashUICallback", "launchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
  public static final class c
  {
    private static final ConcurrentHashMap<AppBrandInitConfigWC, i> mXA;
    private static final WeakHashMap<i, Boolean> mXB;
    public static final c mXC;
    
    static
    {
      AppMethodBeat.i(228734);
      mXC = new c();
      mXA = new ConcurrentHashMap();
      mXB = new WeakHashMap();
      AppMethodBeat.o(228734);
    }
    
    public static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, LaunchParcel paramLaunchParcel)
    {
      AppMethodBeat.i(228732);
      p.h(paramAppBrandInitConfigWC, "initConfig");
      p.h(paramLaunchParcel, "launchParcel");
      Object localObject = u.mTD;
      localObject = u.yi(paramLaunchParcel.mYS);
      boolean bool;
      if (localObject != null)
      {
        paramLaunchParcel = ((g)localObject).kHN;
        if ((paramLaunchParcel != null) && (!c(paramLaunchParcel))) {
          ((Map)mXA).put(paramAppBrandInitConfigWC, paramLaunchParcel);
        }
        if (localObject == null) {
          break label102;
        }
        bool = ((g)localObject).kHO;
        label72:
        paramAppBrandInitConfigWC.lei = bool;
        if (localObject == null) {
          break label107;
        }
      }
      label102:
      label107:
      for (paramLaunchParcel = ((g)localObject).kHP;; paramLaunchParcel = null)
      {
        paramAppBrandInitConfigWC.kHP = paramLaunchParcel;
        AppMethodBeat.o(228732);
        return;
        paramLaunchParcel = null;
        break;
        bool = false;
        break label72;
      }
    }
    
    public static final void a(final AppBrandInitConfigWC paramAppBrandInitConfigWC, final String paramString)
    {
      AppMethodBeat.i(228733);
      p.h(paramAppBrandInitConfigWC, "initConfig");
      if (paramString == null)
      {
        com.tencent.mm.plugin.report.service.h.CyF.dN(915, 35);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WeAppOpenUICallbackIPCProxy", "beforeStartAppBrandUI: [%s]", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
        AppMethodBeat.o(228733);
        return;
      }
      Object localObject = (i)mXA.remove(paramAppBrandInitConfigWC);
      if (localObject != null)
      {
        localObject = new AtomicReference(localObject);
        final a locala = new a((AtomicReference)localObject, paramString, paramAppBrandInitConfigWC);
        com.tencent.mm.ipcinvoker.h.b(paramString, (m)locala);
        paramAppBrandInitConfigWC.leh = new WeAppOpenUICallbackIPCProxy((a)new c((AtomicReference)localObject), (a)new b((AtomicReference)localObject, locala, paramString, paramAppBrandInitConfigWC));
        AppMethodBeat.o(228733);
        return;
      }
      AppMethodBeat.o(228733);
    }
    
    public static final void b(i parami)
    {
      AppMethodBeat.i(228730);
      p.h(parami, "uiCallback");
      synchronized (mXB)
      {
        ((Map)mXB).put(parami, Boolean.TRUE);
        parami = x.SXb;
        AppMethodBeat.o(228730);
        return;
      }
    }
    
    private static boolean c(i parami)
    {
      AppMethodBeat.i(228731);
      synchronized (mXB)
      {
        boolean bool = mXB.containsKey(parami);
        AppMethodBeat.o(228731);
        return bool;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$processDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"})
    public static final class a
      implements m
    {
      a(AtomicReference paramAtomicReference, String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
      
      public final void aye()
      {
        AppMethodBeat.i(228727);
        com.tencent.mm.ipcinvoker.h.a(paramString, (m)this);
        i locali = (i)this.mXD.get();
        if (locali != null)
        {
          WeAppOpenUICallbackIPCProxy.c localc = WeAppOpenUICallbackIPCProxy.c.mXC;
          if (!WeAppOpenUICallbackIPCProxy.c.d(locali)) {}
        }
        else
        {
          this.mXD.set(null);
          AppMethodBeat.o(228727);
          return;
        }
        locali.buf();
        this.mXD.set(null);
        AppMethodBeat.o(228727);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$2"})
    static final class b<R extends Parcelable>
      implements a<IPCBoolean>
    {
      b(AtomicReference paramAtomicReference, WeAppOpenUICallbackIPCProxy.c.a parama, String paramString, AppBrandInitConfigWC paramAppBrandInitConfigWC) {}
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onWXAppResult"})
    static final class c<R extends Parcelable>
      implements a<IPCVoid>
    {
      c(AtomicReference paramAtomicReference) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy
 * JD-Core Version:    0.7.0.1
 */