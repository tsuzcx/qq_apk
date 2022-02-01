package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.luggage.sdk.launching.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.o;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.api.ParcelableMultiTaskData;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "onUIEnterInvokeProxy", "Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onUIExitInvokeProxy", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "onShareClickInHalfScreenMode", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "(Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;Lcom/tencent/luggage/sdk/launching/OnWXAppResultListener;)V", "isUIExitInvokeIgnored", "", "describeContents", "", "", "token", "", "onUIEnter", "onUIExit", "isFinish", "releaseSenderReferences", "setIgnoreUIExitInvoke", "ignore", "writeToParcel", "dest", "flags", "Companion", "MM", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeAppOpenUICallbackIPCProxy
  implements Parcelable
{
  public static final Parcelable.Creator<WeAppOpenUICallbackIPCProxy> CREATOR;
  public static final WeAppOpenUICallbackIPCProxy.a tcH;
  public b<IPCVoid> tcI;
  private b<IPCBoolean> tcJ;
  public b<IPCString> tcK;
  public boolean tcL;
  
  static
  {
    AppMethodBeat.i(320782);
    tcH = new WeAppOpenUICallbackIPCProxy.a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(320782);
  }
  
  public WeAppOpenUICallbackIPCProxy(Parcel paramParcel)
  {
    this(localb1, localb2, paramParcel);
    AppMethodBeat.i(320780);
    AppMethodBeat.o(320780);
  }
  
  public WeAppOpenUICallbackIPCProxy(b<IPCVoid> paramb, b<IPCBoolean> paramb1, b<IPCString> paramb2)
  {
    AppMethodBeat.i(320776);
    this.tcI = paramb;
    this.tcJ = paramb1;
    this.tcK = paramb2;
    AppMethodBeat.o(320776);
  }
  
  public final void cAB()
  {
    AppMethodBeat.i(320787);
    d.a(this.tcI);
    d.a(this.tcJ);
    d.a(this.tcK);
    AppMethodBeat.o(320787);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void ka(boolean paramBoolean)
  {
    AppMethodBeat.i(320785);
    if (this.tcL)
    {
      AppMethodBeat.o(320785);
      return;
    }
    this.tcJ.onWXAppResult((Parcelable)new IPCBoolean(paramBoolean));
    AppMethodBeat.o(320785);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(320795);
    s.u(paramParcel, "dest");
    d.a(this.tcI, paramParcel);
    d.a(this.tcJ, paramParcel);
    d.a(this.tcK, paramParcel);
    AppMethodBeat.o(320795);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<WeAppOpenUICallbackIPCProxy>
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM;", "", "()V", "TAG", "", "mReleasedUICallbacks", "Ljava/util/WeakHashMap;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "", "mUICallbackHashMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "beforeStartAppBrandUI", "", "initConfig", "targetProcess", "isUICallbackReleased", "uiCallback", "markUICallbackReleased", "stashUICallback", "launchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final c tcM;
    private static final ConcurrentHashMap<AppBrandInitConfigWC, i> tcN;
    private static final WeakHashMap<i, Boolean> tcO;
    
    static
    {
      AppMethodBeat.i(320665);
      tcM = new c();
      tcN = new ConcurrentHashMap();
      tcO = new WeakHashMap();
      AppMethodBeat.o(320665);
    }
    
    public static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, LaunchParcel paramLaunchParcel)
    {
      AppMethodBeat.i(320635);
      s.u(paramAppBrandInitConfigWC, "initConfig");
      s.u(paramLaunchParcel, "launchParcel");
      Object localObject = v.sZx;
      g localg = v.BX(paramLaunchParcel.tee);
      boolean bool;
      if (localg == null)
      {
        localObject = null;
        if ((localObject != null) && (!c((i)localObject))) {
          ((Map)tcN).put(paramAppBrandInitConfigWC, localObject);
        }
        if (localg != null) {
          break label105;
        }
        bool = false;
        label69:
        paramAppBrandInitConfigWC.qYx = bool;
        if (localg != null) {
          break label114;
        }
      }
      label105:
      label114:
      for (localObject = null;; localObject = localg.qAW)
      {
        paramAppBrandInitConfigWC.qAW = ((ParcelableMultiTaskData)localObject);
        paramLaunchParcel.cAN();
        AppMethodBeat.o(320635);
        return;
        localObject = localg.qAU;
        break;
        bool = localg.qAV;
        break label69;
      }
    }
    
    public static final void a(AppBrandInitConfigWC paramAppBrandInitConfigWC, String paramString)
    {
      AppMethodBeat.i(320644);
      s.u(paramAppBrandInitConfigWC, "initConfig");
      if (paramString == null)
      {
        h.OAn.kJ(915, 35);
        com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.WeAppOpenUICallbackIPCProxy", "beforeStartAppBrandUI: [%s]", new Object[] { android.util.Log.getStackTraceString(new Throwable()) });
        AppMethodBeat.o(320644);
        return;
      }
      Object localObject = (i)tcN.remove(paramAppBrandInitConfigWC);
      if (localObject != null)
      {
        localObject = new AtomicReference(localObject);
        a locala = new a(paramString, (AtomicReference)localObject);
        j.b(paramString, (o)locala);
        paramAppBrandInitConfigWC.qYw = new WeAppOpenUICallbackIPCProxy(new WeAppOpenUICallbackIPCProxy.c..ExternalSyntheticLambda1((AtomicReference)localObject), new WeAppOpenUICallbackIPCProxy.c..ExternalSyntheticLambda2((AtomicReference)localObject, paramString, locala), new WeAppOpenUICallbackIPCProxy.c..ExternalSyntheticLambda0((AtomicReference)localObject));
      }
      AppMethodBeat.o(320644);
    }
    
    private static final void a(AtomicReference paramAtomicReference, IPCString paramIPCString)
    {
      AppMethodBeat.i(320656);
      s.u(paramAtomicReference, "$mutableRef");
      i locali = (i)paramAtomicReference.get();
      if ((locali == null) || (c(locali)))
      {
        paramAtomicReference.set(null);
        AppMethodBeat.o(320656);
        return;
      }
      if (paramIPCString == null) {
        paramAtomicReference = "";
      }
      for (;;)
      {
        locali.UP(paramAtomicReference);
        AppMethodBeat.o(320656);
        return;
        paramIPCString = paramIPCString.value;
        paramAtomicReference = paramIPCString;
        if (paramIPCString == null) {
          paramAtomicReference = "";
        }
      }
    }
    
    private static final void a(AtomicReference paramAtomicReference, IPCVoid paramIPCVoid)
    {
      AppMethodBeat.i(320648);
      s.u(paramAtomicReference, "$mutableRef");
      paramIPCVoid = (i)paramAtomicReference.get();
      if ((paramIPCVoid == null) || (c(paramIPCVoid)))
      {
        paramAtomicReference.set(null);
        AppMethodBeat.o(320648);
        return;
      }
      paramIPCVoid.cer();
      AppMethodBeat.o(320648);
    }
    
    private static final void a(AtomicReference paramAtomicReference, String paramString, a parama, IPCBoolean paramIPCBoolean)
    {
      boolean bool = true;
      AppMethodBeat.i(320651);
      s.u(paramAtomicReference, "$mutableRef");
      s.u(parama, "$processDiedListener");
      i locali = (i)paramAtomicReference.get();
      if ((locali == null) || (c(locali)))
      {
        paramAtomicReference.set(null);
        j.a(paramString, (o)parama);
        AppMethodBeat.o(320651);
        return;
      }
      if ((paramIPCBoolean != null) && (paramIPCBoolean.value == true)) {}
      for (;;)
      {
        locali.ie(bool);
        paramAtomicReference.set(null);
        break;
        bool = false;
      }
    }
    
    public static final void b(i parami)
    {
      AppMethodBeat.i(320626);
      s.u(parami, "uiCallback");
      synchronized (tcO)
      {
        ((Map)tcO).put(parami, Boolean.TRUE);
        parami = ah.aiuX;
        AppMethodBeat.o(320626);
        return;
      }
    }
    
    private static boolean c(i parami)
    {
      AppMethodBeat.i(320629);
      synchronized (tcO)
      {
        boolean bool = tcO.containsKey(parami);
        AppMethodBeat.o(320629);
        return bool;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/launching/WeAppOpenUICallbackIPCProxy$MM$beforeStartAppBrandUI$1$processDiedListener$1", "Lcom/tencent/mm/ipcinvoker/IRemoteProcDied;", "onDied", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements o
    {
      a(String paramString, AtomicReference<i> paramAtomicReference) {}
      
      public final void onDied()
      {
        AppMethodBeat.i(320941);
        j.a(this.tcP, (o)this);
        i locali = (i)this.tcQ.get();
        if (locali != null)
        {
          WeAppOpenUICallbackIPCProxy.c localc = WeAppOpenUICallbackIPCProxy.c.tcM;
          if (!WeAppOpenUICallbackIPCProxy.c.d(locali)) {}
        }
        else
        {
          this.tcQ.set(null);
          AppMethodBeat.o(320941);
          return;
        }
        locali.ces();
        this.tcQ.set(null);
        AppMethodBeat.o(320941);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.WeAppOpenUICallbackIPCProxy
 * JD-Core Version:    0.7.0.1
 */