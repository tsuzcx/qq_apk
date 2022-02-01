package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.SparseArray;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.Collection;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation;", "", "()V", "TAG", "", "mWeAppOpenBundleHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "executeStartAppForResult", "", "context", "Landroid/content/Context;", "openBundle", "pollOpenBundle", "hash", "", "assertValid", "toInternalParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class u
{
  private static final SparseArray<g> mTC;
  public static final u mTD;
  
  static
  {
    AppMethodBeat.i(50758);
    mTD = new u();
    mTC = new SparseArray();
    AppMethodBeat.o(50758);
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(228649);
    if (paramg == null)
    {
      paramg = (Throwable)new IllegalArgumentException((Throwable)new NullPointerException());
      AppMethodBeat.o(228649);
      throw paramg;
    }
    Object localObject = (CharSequence)paramg.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label121;
      }
      localObject = (CharSequence)paramg.appId;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label116;
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label121;
      }
      paramg = (Throwable)new IllegalArgumentException("Both username & appId is EMPTY");
      AppMethodBeat.o(228649);
      throw paramg;
      i = 0;
      break;
    }
    label121:
    localObject = (CharSequence)paramg.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = paramg.username;
      p.g(localObject, "username");
      if (n.K((String)localObject, "@app", false)) {
        break;
      }
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp username " + paramg.username);
      AppMethodBeat.o(228649);
      throw paramg;
    }
    if ((!j.a.vP(paramg.iOo)) && (!j.a.sE(paramg.iOo)))
    {
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp versionType " + paramg.iOo);
      AppMethodBeat.o(228649);
      throw paramg;
    }
    if (paramg.scene <= 1000)
    {
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp enter scene " + paramg.scene);
      AppMethodBeat.o(228649);
      throw paramg;
    }
    AppMethodBeat.o(228649);
  }
  
  public static LaunchParcel b(g paramg)
  {
    AppMethodBeat.i(228650);
    p.h(paramg, "$this$toInternalParcel");
    if (paramg.kHL.isEnable()) {
      paramg.launchMode = 2;
    }
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramg.username;
    localLaunchParcel.appId = paramg.appId;
    localLaunchParcel.version = paramg.version;
    localLaunchParcel.iOo = paramg.iOo;
    localLaunchParcel.kHw = paramg.kHw;
    int i = paramg.scene;
    if (e.contains(new Integer[] { Integer.valueOf(1176), Integer.valueOf(1177) }, Integer.valueOf(i))) {
      localLaunchParcel.kHw = LaunchParcel.ack(localLaunchParcel.kHw);
    }
    ??? = paramg.kHx;
    if (??? != null)
    {
      ??? = ((d)???).bua();
      localLaunchParcel.ldR = ((String)???);
      localLaunchParcel.ldQ = paramg.kHy;
      ??? = new AppBrandStatObject();
      ((AppBrandStatObject)???).scene = paramg.scene;
      ((AppBrandStatObject)???).dCw = paramg.dCw;
      ((AppBrandStatObject)???).ecU = paramg.kHz;
      ((AppBrandStatObject)???).ecV = paramg.kHA;
      localLaunchParcel.mYK = ((AppBrandStatObject)???);
      localLaunchParcel.cys = paramg.kHF;
      if (paramg.kHB == null) {
        break label480;
      }
      ??? = (a)new a(paramg);
      localLaunchParcel.mYN = ((a)???);
      localLaunchParcel.kHC = paramg.kHC;
      localLaunchParcel.kHG = paramg.kHG;
      localLaunchParcel.launchMode = paramg.launchMode;
      ??? = new PersistableBundle();
      ((PersistableBundle)???).putString("KEY_OPENSDK_AD_TRACE_KEY", paramg.kHE);
      localLaunchParcel.mYP = ((PersistableBundle)???);
      localLaunchParcel.kHI = paramg.kHI;
      localLaunchParcel.mYQ = ((Parcelable)paramg.kHJ);
      localLaunchParcel.kHL = paramg.kHL;
      localLaunchParcel.kHM = paramg.kHM;
      localLaunchParcel.kHQ = paramg.kHQ;
      localLaunchParcel.mYS = paramg.hashCode();
    }
    for (;;)
    {
      synchronized (mTC)
      {
        mTC.put(localLaunchParcel.mYS, paramg);
        x localx = x.SXb;
        ??? = (CharSequence)paramg.cyr;
        if ((??? == null) || (((CharSequence)???).length() == 0))
        {
          i = 1;
          if (i != 0)
          {
            ??? = (CharSequence)paramg.cyq;
            if ((??? != null) && (((CharSequence)???).length() != 0)) {
              break label500;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            if (localLaunchParcel.mYL == null) {
              localLaunchParcel.mYL = new LaunchParamsOptional();
            }
            localLaunchParcel.mYL.cyr = paramg.cyr;
            localLaunchParcel.mYL.cyq = paramg.cyq;
          }
          paramg = paramg.kHK;
          if (paramg != null) {
            localLaunchParcel.kHK.addAll((Collection)paramg);
          }
          AppMethodBeat.o(228650);
          return localLaunchParcel;
          ??? = null;
          break;
          label480:
          ??? = null;
        }
      }
      label500:
      i = 0;
    }
  }
  
  public static g yi(int paramInt)
  {
    AppMethodBeat.i(228648);
    synchronized (mTC)
    {
      paramInt = mTC.indexOfKey(paramInt);
      if (paramInt >= 0)
      {
        localObject1 = (g)mTC.valueAt(paramInt);
        if (localObject1 != null) {
          mTC.removeAt(paramInt);
        }
        for (;;)
        {
          AppMethodBeat.o(228648);
          return localObject1;
          localObject1 = null;
        }
      }
      Object localObject1 = x.SXb;
      AppMethodBeat.o(228648);
      return null;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation$toInternalParcel$1$2"})
  static final class a<R extends Parcelable>
    implements a<IPCString>
  {
    a(g paramg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.u
 * JD-Core Version:    0.7.0.1
 */