package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;

class a$c
  implements i<Bundle, Bundle>
{
  private static Bundle x(Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(10985);
    Object localObject1 = paramBundle.getString("appId");
    int i = paramBundle.getInt("pkgType");
    int j = paramBundle.getInt("pkgVersion");
    int k = paramBundle.getInt("scene");
    int m = paramBundle.getInt("widgetType");
    Object localObject2 = paramBundle.getString("preloadLaunchData", "");
    paramBundle = new Bundle();
    Object localObject4;
    try
    {
      localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).azX();
      if (localObject4 == null)
      {
        AppMethodBeat.o(10985);
        return paramBundle;
      }
      if (((k)localObject4).field_jsApiInfo != null) {
        paramBundle.putByteArray("jsApiInfo", ((k)localObject4).field_jsApiInfo.toByteArray());
      }
      if (((k)localObject4).field_launchAction != null) {
        paramBundle.putByteArray("launchAction", ((k)localObject4).field_launchAction.toByteArray());
      }
      if (((k)localObject4).field_versionInfo != null) {
        paramBundle.putByteArray("versionInfo", ((k)localObject4).field_versionInfo.toByteArray());
      }
      localObject2 = new WidgetRuntimeConfig();
      ((WidgetRuntimeConfig)localObject2).appId = ((String)localObject1);
      ((WidgetRuntimeConfig)localObject2).hpZ = m;
      localObject4 = ((k)localObject4).field_widgetSetting;
      if (localObject4 != null)
      {
        ((WidgetRuntimeConfig)localObject2).hqq = ((dbu)localObject4).yhZ;
        ((WidgetRuntimeConfig)localObject2).hqs = ((dbu)localObject4).yib;
        ((WidgetRuntimeConfig)localObject2).hqr = ((dbu)localObject4).yia;
      }
      paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
      }
      localObject3 = localException.auI().FC((String)localObject1);
      localObject1 = b.Bg((String)localObject1);
      localObject4 = new DebuggerInfo();
      if (localObject3 == null) {
        break label456;
      }
    }
    localObject2 = (com.tencent.mm.plugin.appbrand.widget.a.a)com.tencent.mm.plugin.appbrand.dynamic.k.a.Z(com.tencent.mm.plugin.appbrand.widget.a.a.class);
    if (localObject2 == null)
    {
      AppMethodBeat.o(10985);
      return paramBundle;
    }
    Object localObject3;
    if (((n)localObject3).field_openDebug)
    {
      bool1 = true;
      ((DebuggerInfo)localObject4).hoy = bool1;
      if ((!j.a.kQ(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).hox))) {
        break label462;
      }
      bool1 = true;
      label357:
      ((DebuggerInfo)localObject4).hox = bool1;
      if ((localObject1 == null) || (!((DebuggerInfo)localObject1).hoz)) {
        break label468;
      }
    }
    label456:
    label462:
    label468:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((DebuggerInfo)localObject4).hoz = bool1;
      paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
      localObject1 = AppBrandGlobalSystemConfig.ayt();
      localObject3 = new WidgetSysConfig();
      ((WidgetSysConfig)localObject3).hhN = ((AppBrandGlobalSystemConfig)localObject1).hhN;
      ((WidgetSysConfig)localObject3).hhO = ((AppBrandGlobalSystemConfig)localObject1).hhO;
      ((WidgetSysConfig)localObject3).hhP = ((AppBrandGlobalSystemConfig)localObject1).hhP;
      paramBundle.putParcelable("sysConfig", (Parcelable)localObject3);
      AppMethodBeat.o(10985);
      return paramBundle;
      bool1 = false;
      break;
      bool1 = false;
      break label357;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.c
 * JD-Core Version:    0.7.0.1
 */