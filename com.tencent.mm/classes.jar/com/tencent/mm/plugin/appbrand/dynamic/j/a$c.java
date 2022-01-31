package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.widget.j;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.protocal.c.clk;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.protocal.c.cnm;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.y;

class a$c
  implements i<Bundle, Bundle>
{
  private static Bundle o(Bundle paramBundle)
  {
    boolean bool2 = true;
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
      localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).afs();
      if (localObject4 == null) {
        return paramBundle;
      }
      if (((j)localObject4).field_jsApiInfo != null) {
        paramBundle.putByteArray("jsApiInfo", ((j)localObject4).field_jsApiInfo.toByteArray());
      }
      if (((j)localObject4).field_launchAction != null) {
        paramBundle.putByteArray("launchAction", ((j)localObject4).field_launchAction.toByteArray());
      }
      if (((j)localObject4).field_versionInfo != null) {
        paramBundle.putByteArray("versionInfo", ((j)localObject4).field_versionInfo.toByteArray());
      }
      localObject2 = new WidgetRuntimeConfig();
      ((WidgetRuntimeConfig)localObject2).appId = ((String)localObject1);
      ((WidgetRuntimeConfig)localObject2).fWz = m;
      localObject4 = ((j)localObject4).field_widgetSetting;
      if (localObject4 != null)
      {
        ((WidgetRuntimeConfig)localObject2).fWQ = ((cnm)localObject4).uag;
        ((WidgetRuntimeConfig)localObject2).fWS = ((cnm)localObject4).uai;
        ((WidgetRuntimeConfig)localObject2).fWR = ((cnm)localObject4).uah;
      }
      paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
      }
      localObject3 = localException.aaW().wY((String)localObject1);
      localObject1 = b.te((String)localObject1);
      localObject4 = new DebuggerInfo();
      if (localObject3 == null) {
        break label432;
      }
    }
    localObject2 = (com.tencent.mm.plugin.appbrand.widget.a.a)com.tencent.mm.plugin.appbrand.dynamic.k.a.J(com.tencent.mm.plugin.appbrand.widget.a.a.class);
    if (localObject2 == null) {
      return paramBundle;
    }
    Object localObject3;
    if (((l)localObject3).field_openDebug)
    {
      bool1 = true;
      ((DebuggerInfo)localObject4).fUW = bool1;
      if ((!d.a.id(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).fUV))) {
        break label438;
      }
      bool1 = true;
      label339:
      ((DebuggerInfo)localObject4).fUV = bool1;
      if ((localObject1 == null) || (!((DebuggerInfo)localObject1).fUX)) {
        break label444;
      }
    }
    label432:
    label438:
    label444:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((DebuggerInfo)localObject4).fUX = bool1;
      paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
      localObject1 = AppBrandGlobalSystemConfig.aec();
      localObject3 = new WidgetSysConfig();
      ((WidgetSysConfig)localObject3).fON = ((AppBrandGlobalSystemConfig)localObject1).fON;
      ((WidgetSysConfig)localObject3).fOO = ((AppBrandGlobalSystemConfig)localObject1).fOO;
      ((WidgetSysConfig)localObject3).fOP = ((AppBrandGlobalSystemConfig)localObject1).fOP;
      paramBundle.putParcelable("sysConfig", (Parcelable)localObject3);
      return paramBundle;
      bool1 = false;
      break;
      bool1 = false;
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.c
 * JD-Core Version:    0.7.0.1
 */