package com.tencent.mm.plugin.appbrand.launching;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.SparseArray;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation;", "", "()V", "TAG", "", "value", "", "isForcedOpenWxaAppForTypedDemo", "()Z", "setForcedOpenWxaAppForTypedDemo", "(Z)V", "mWeAppOpenBundleHashMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "executeStartAppForResult", "", "context", "Landroid/content/Context;", "openBundle", "pollOpenBundle", "hash", "", "assertValid", "toInternalParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "plugin-appbrand-integration_release"})
public final class t
{
  private static boolean pUC;
  private static final SparseArray<g> pUD;
  public static final t pUE;
  
  static
  {
    AppMethodBeat.i(50758);
    pUE = new t();
    pUD = new SparseArray();
    AppMethodBeat.o(50758);
  }
  
  public static g BI(int paramInt)
  {
    AppMethodBeat.i(280076);
    synchronized (pUD)
    {
      paramInt = pUD.indexOfKey(paramInt);
      if (paramInt >= 0)
      {
        localObject1 = (g)pUD.valueAt(paramInt);
        if (localObject1 != null) {
          pUD.removeAt(paramInt);
        }
        for (;;)
        {
          AppMethodBeat.o(280076);
          return localObject1;
          localObject1 = null;
        }
      }
      Object localObject1 = x.aazN;
      AppMethodBeat.o(280076);
      return null;
    }
  }
  
  public static void a(g paramg)
  {
    AppMethodBeat.i(280077);
    if (paramg == null)
    {
      paramg = (Throwable)new IllegalArgumentException((Throwable)new NullPointerException());
      AppMethodBeat.o(280077);
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
      AppMethodBeat.o(280077);
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
      p.j(localObject, "username");
      if (n.pu((String)localObject, "@app")) {
        break;
      }
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp username " + paramg.username);
      AppMethodBeat.o(280077);
      throw paramg;
    }
    if ((!j.a.za(paramg.cBU)) && (!j.a.vB(paramg.cBU)))
    {
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp versionType " + paramg.cBU);
      AppMethodBeat.o(280077);
      throw paramg;
    }
    if (paramg.scene <= 1000)
    {
      paramg = (Throwable)new IllegalArgumentException("Invalid weapp enter scene " + paramg.scene);
      AppMethodBeat.o(280077);
      throw paramg;
    }
    AppMethodBeat.o(280077);
  }
  
  public static LaunchParcel b(g paramg)
  {
    AppMethodBeat.i(280078);
    p.k(paramg, "$this$toInternalParcel");
    if (paramg.nBE.isEnable()) {
      paramg.launchMode = 2;
    }
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramg.username;
    localLaunchParcel.appId = paramg.appId;
    localLaunchParcel.version = paramg.version;
    localLaunchParcel.cBU = paramg.cBU;
    localLaunchParcel.nBq = paramg.nBq;
    int i = paramg.scene;
    if (e.contains(new Integer[] { Integer.valueOf(1176), Integer.valueOf(1177) }, Integer.valueOf(i))) {
      localLaunchParcel.nBq = LaunchParcel.ake(localLaunchParcel.nBq);
    }
    ??? = paramg.nBr;
    if (??? != null)
    {
      ??? = ((d)???).bFa();
      localLaunchParcel.nYf = ((String)???);
      localLaunchParcel.nYe = paramg.nBs;
      ??? = new AppBrandStatObject();
      ((AppBrandStatObject)???).scene = paramg.scene;
      ((AppBrandStatObject)???).fvd = paramg.fvd;
      ((AppBrandStatObject)???).fXa = paramg.nBt;
      ((AppBrandStatObject)???).fXb = paramg.nBu;
      localLaunchParcel.pdk = ((AppBrandStatObject)???);
      localLaunchParcel.cwV = paramg.nBz;
      if (paramg.nBv == null) {
        break label507;
      }
      ??? = (a)new a(paramg);
      localLaunchParcel.pZl = ((a)???);
      localLaunchParcel.nBw = paramg.nBw;
      localLaunchParcel.fWY = paramg.fWY;
      localLaunchParcel.launchMode = paramg.launchMode;
      ??? = new PersistableBundle();
      ((PersistableBundle)???).putString("KEY_OPENSDK_AD_TRACE_KEY", paramg.nBy);
      localLaunchParcel.pZn = ((PersistableBundle)???);
      localLaunchParcel.nBB = paramg.nBB;
      localLaunchParcel.pZo = ((Parcelable)paramg.nBC);
      localLaunchParcel.nBE = paramg.nBE;
      localLaunchParcel.nBF = paramg.nBF;
      localLaunchParcel.nBJ = paramg.nBJ;
      localLaunchParcel.pdk.chatType = paramg.chatType;
      localLaunchParcel.pZq = paramg.hashCode();
    }
    for (;;)
    {
      synchronized (pUD)
      {
        pUD.put(localLaunchParcel.pZq, paramg);
        x localx = x.aazN;
        localLaunchParcel.pZj = new LaunchParamsOptional();
        ??? = (CharSequence)paramg.cwU;
        if ((??? == null) || (((CharSequence)???).length() == 0))
        {
          i = 1;
          if (i != 0)
          {
            ??? = (CharSequence)paramg.cwT;
            if ((??? != null) && (((CharSequence)???).length() != 0)) {
              break label527;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            localLaunchParcel.pZj.cwU = paramg.cwU;
            localLaunchParcel.pZj.cwT = paramg.cwT;
          }
          localLaunchParcel.pZj.lyw = paramg.lyw;
          if (paramg.lyw != 0) {
            localLaunchParcel.launchMode = 1;
          }
          paramg = paramg.nBD;
          if (paramg != null) {
            localLaunchParcel.nBD.addAll((Collection)paramg);
          }
          AppMethodBeat.o(280078);
          return localLaunchParcel;
          ??? = null;
          break;
          label507:
          ??? = null;
        }
      }
      label527:
      i = 0;
    }
  }
  
  public static boolean bZQ()
  {
    AppMethodBeat.i(280073);
    com.tencent.mm.plugin.appbrand.service.t localt = (com.tencent.mm.plugin.appbrand.service.t)h.ae(com.tencent.mm.plugin.appbrand.service.t.class);
    if ((localt != null) && (localt.bFs() == true))
    {
      boolean bool = PluginAppBrand.getProcessSharedPrefs().getBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedOpenWxaAppForTypedDemo", false);
      AppMethodBeat.o(280073);
      return bool;
    }
    AppMethodBeat.o(280073);
    return false;
  }
  
  public static void iQ(boolean paramBoolean)
  {
    AppMethodBeat.i(280074);
    pUC = paramBoolean;
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("com.tencent.mm.plugin.appbrand.launching.isForcedOpenWxaAppForTypedDemo", paramBoolean).apply();
    AppMethodBeat.o(280074);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onWXAppResult", "com/tencent/mm/plugin/appbrand/launching/ExportWxaInstrumentation$toInternalParcel$1$2"})
  static final class a<R extends Parcelable>
    implements a<IPCString>
  {
    a(g paramg) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t
 * JD-Core Version:    0.7.0.1
 */