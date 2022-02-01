package com.tencent.mm.plugin.appbrand.launching;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.SparseArray;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.config.AppBrandInitWindowConfig;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.config.j.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation;", "", "()V", "TAG", "", "value", "", "isForcedCloseDemoCheckForWarmLaunchWxaApp", "()Z", "setForcedCloseDemoCheckForWarmLaunchWxaApp", "(Z)V", "isForcedOpenWxaAppForTypedDemo", "setForcedOpenWxaAppForTypedDemo", "mWeAppOpenBundleHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "executeStartAppForResult", "", "context", "Landroid/content/Context;", "openBundle", "pollOpenBundle", "hash", "", "assertValid", "toInternalParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  private static final SparseArray<g> sZA;
  public static final v sZx;
  private static boolean sZy;
  private static boolean sZz;
  
  static
  {
    AppMethodBeat.i(50758);
    sZx = new v();
    sZA = new SparseArray();
    AppMethodBeat.o(50758);
  }
  
  public static g BX(int paramInt)
  {
    AppMethodBeat.i(320811);
    synchronized (sZA)
    {
      paramInt = sZA.indexOfKey(paramInt);
      if (paramInt >= 0)
      {
        g localg = (g)sZA.valueAt(paramInt);
        if (localg == null)
        {
          localg = null;
          AppMethodBeat.o(320811);
          return localg;
        }
        sZA.removeAt(paramInt);
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(320811);
    return null;
  }
  
  private static final void a(g paramg, IPCInteger paramIPCInteger)
  {
    AppMethodBeat.i(320827);
    s.u(paramg, "$this_toInternalParcel");
    ValueCallback localValueCallback = paramg.qAK;
    if (paramIPCInteger == null) {}
    for (paramg = null;; paramg = Integer.valueOf(paramIPCInteger.value))
    {
      localValueCallback.onReceiveValue(paramg);
      AppMethodBeat.o(320827);
      return;
    }
  }
  
  private static final void a(g paramg, IPCString paramIPCString)
  {
    AppMethodBeat.i(320823);
    s.u(paramg, "$this_toInternalParcel");
    ValueCallback localValueCallback = paramg.idh;
    if (paramIPCString == null) {}
    for (paramg = null;; paramg = paramIPCString.value)
    {
      localValueCallback.onReceiveValue(paramg);
      AppMethodBeat.o(320823);
      return;
    }
  }
  
  public static void b(g paramg)
  {
    AppMethodBeat.i(320815);
    if (paramg == null)
    {
      paramg = new IllegalArgumentException((Throwable)new NullPointerException());
      AppMethodBeat.o(320815);
      throw paramg;
    }
    Object localObject = (CharSequence)paramg.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      localObject = (CharSequence)paramg.appId;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label115;
      }
      paramg = new IllegalArgumentException("Both username & appId is EMPTY");
      AppMethodBeat.o(320815);
      throw paramg;
      i = 0;
      break;
    }
    label115:
    localObject = (CharSequence)paramg.username;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (i = 1; i == 0; i = 0)
    {
      localObject = paramg.username;
      s.s(localObject, "username");
      if (n.rs((String)localObject, "@app")) {
        break;
      }
      paramg = new IllegalArgumentException(s.X("Invalid weapp username ", paramg.username));
      AppMethodBeat.o(320815);
      throw paramg;
    }
    if ((!k.a.zn(paramg.euz)) && (!k.a.vK(paramg.euz)))
    {
      paramg = new IllegalArgumentException(s.X("Invalid weapp versionType ", Integer.valueOf(paramg.euz)));
      AppMethodBeat.o(320815);
      throw paramg;
    }
    if (paramg.scene <= 1000)
    {
      paramg = new IllegalArgumentException(s.X("Invalid weapp enter scene ", Integer.valueOf(paramg.scene)));
      AppMethodBeat.o(320815);
      throw paramg;
    }
    AppMethodBeat.o(320815);
  }
  
  public static LaunchParcel c(g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(320820);
    s.u(paramg, "<this>");
    ??? = j.qYD;
    paramg.launchMode = j.a.a(paramg.qAT, paramg.launchMode);
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramg.username;
    localLaunchParcel.appId = paramg.appId;
    localLaunchParcel.version = paramg.version;
    localLaunchParcel.euz = paramg.euz;
    localLaunchParcel.qAF = paramg.qAF;
    localLaunchParcel.eoR = paramg.eoR;
    int i = paramg.scene;
    if (k.contains(new Integer[] { Integer.valueOf(1176), Integer.valueOf(1177) }, Integer.valueOf(i))) {
      localLaunchParcel.qAF = LaunchParcel.adj(localLaunchParcel.qAF);
    }
    ??? = paramg.qAG;
    if (??? == null)
    {
      ??? = null;
      localLaunchParcel.qYh = ((String)???);
      localLaunchParcel.qYg = paramg.qAH;
      ??? = new AppBrandStatObject();
      ((AppBrandStatObject)???).scene = paramg.scene;
      ((AppBrandStatObject)???).hzx = paramg.hzx;
      ((AppBrandStatObject)???).icZ = paramg.qAI;
      ((AppBrandStatObject)???).ida = paramg.qAJ;
      Object localObject3 = ah.aiuX;
      localLaunchParcel.siB = ((AppBrandStatObject)???);
      localLaunchParcel.eoV = paramg.qAO;
      if (paramg.idh == null) {
        break label689;
      }
      ??? = new v..ExternalSyntheticLambda1(paramg);
      localLaunchParcel.tdY = ((b)???);
      ??? = localObject2;
      if (paramg.qAK != null) {
        ??? = new v..ExternalSyntheticLambda0(paramg);
      }
      localLaunchParcel.tdZ = ((b)???);
      localLaunchParcel.qAL = paramg.qAL;
      localLaunchParcel.icX = paramg.icX;
      localLaunchParcel.launchMode = paramg.launchMode;
      ??? = new PersistableBundle();
      ((PersistableBundle)???).putString("KEY_OPENSDK_AD_TRACE_KEY", paramg.qAN);
      localObject2 = ah.aiuX;
      localLaunchParcel.teb = ((PersistableBundle)???);
      localLaunchParcel.qAQ = paramg.qAQ;
      localLaunchParcel.tec = ((Parcelable)paramg.qAR);
      localLaunchParcel.qAT = paramg.qAT;
      localLaunchParcel.epe = paramg.qAY;
      localLaunchParcel.epf = paramg.epf;
      ??? = paramg.epq;
      localObject2 = paramg.epr;
      boolean bool = paramg.eps;
      localObject3 = paramg.ept;
      s.s(localObject3, "this.enterAnimation");
      y localy = paramg.epu;
      s.s(localy, "this.exitAnimation");
      localLaunchParcel.epj = new AppBrandInitWindowConfig((z)???, (String)localObject2, bool, (y)localObject3, localy, 3);
      localLaunchParcel.qAX = paramg.qAX;
      localLaunchParcel.siB.chatType = paramg.chatType;
      localLaunchParcel.tee = paramg.hashCode();
    }
    for (;;)
    {
      synchronized (sZA)
      {
        sZA.put(localLaunchParcel.tee, paramg);
        localObject2 = ah.aiuX;
        localLaunchParcel.tdW = new LaunchParamsOptional();
        ??? = (CharSequence)paramg.eoU;
        if ((??? == null) || (((CharSequence)???).length() == 0))
        {
          i = 1;
          if (i != 0)
          {
            ??? = (CharSequence)paramg.eoT;
            if ((??? != null) && (((CharSequence)???).length() != 0)) {
              break label709;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            localLaunchParcel.tdW.eoU = paramg.eoU;
            localLaunchParcel.tdW.eoT = paramg.eoT;
          }
          localLaunchParcel.tdW.opX = paramg.opX;
          if (paramg.opX != 0) {
            localLaunchParcel.launchMode = 1;
          }
          ??? = paramg.qAS;
          if (??? != null) {
            localLaunchParcel.qAS.addAll((Collection)???);
          }
          if (paramg.qAZ != null)
          {
            localLaunchParcel.qYy = paramg.qAZ.getName();
            localLaunchParcel.qBa = paramg.qBa;
          }
          AppMethodBeat.o(320820);
          return localLaunchParcel;
          ??? = ((d)???).toJsonString();
          break;
          label689:
          ??? = null;
        }
      }
      label709:
      i = 0;
    }
  }
  
  public static boolean cAb()
  {
    AppMethodBeat.i(320797);
    com.tencent.mm.plugin.appbrand.service.v localv = (com.tencent.mm.plugin.appbrand.service.v)h.ax(com.tencent.mm.plugin.appbrand.service.v.class);
    if ((localv != null) && (localv.ceP() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      boolean bool = PluginAppBrand.getProcessSharedPrefs().getBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedOpenWxaAppForTypedDemo", false);
      AppMethodBeat.o(320797);
      return bool;
    }
    AppMethodBeat.o(320797);
    return false;
  }
  
  public static boolean cAc()
  {
    AppMethodBeat.i(320803);
    com.tencent.mm.plugin.appbrand.service.v localv = (com.tencent.mm.plugin.appbrand.service.v)h.ax(com.tencent.mm.plugin.appbrand.service.v.class);
    if ((localv != null) && (localv.ceP() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      boolean bool = PluginAppBrand.getProcessSharedPrefs().getBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedCloseDemoCheckForWarmLaunchWxaApp", false);
      AppMethodBeat.o(320803);
      return bool;
    }
    AppMethodBeat.o(320803);
    return false;
  }
  
  public static void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(320802);
    sZy = paramBoolean;
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedOpenWxaAppForTypedDemo", paramBoolean).apply();
    AppMethodBeat.o(320802);
  }
  
  public static void jX(boolean paramBoolean)
  {
    AppMethodBeat.i(320806);
    sZz = paramBoolean;
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedCloseDemoCheckForWarmLaunchWxaApp", paramBoolean).apply();
    AppMethodBeat.o(320806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.v
 * JD-Core Version:    0.7.0.1
 */