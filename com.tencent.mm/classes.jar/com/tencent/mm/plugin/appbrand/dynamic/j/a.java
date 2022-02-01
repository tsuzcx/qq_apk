package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.widget.q;
import com.tencent.mm.plugin.appbrand.widget.r;
import com.tencent.mm.protocal.protobuf.fmh;
import com.tencent.mm.protocal.protobuf.fmj;
import com.tencent.mm.protocal.protobuf.fqc;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public final class a
{
  private static String Q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121473);
    paramString = paramString + "#" + paramInt1 + "#" + paramInt2;
    AppMethodBeat.o(121473);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(121471);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    localBundle.putInt("pkgType", paramInt1);
    localBundle.putInt("pkgVersion", paramInt2);
    localBundle.putString("searchId", paramString3);
    localBundle.putString("preload_download_data", paramString4);
    if (paramInt1 == 10102)
    {
      paramString1 = com.tencent.mm.plugin.appbrand.dynamic.b.e.agi(Q(paramString2, paramInt1, paramInt2));
      if (paramString1 != null)
      {
        u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
        AppMethodBeat.o(121471);
        return paramString1;
      }
    }
    paramString1 = (WxaPkgWrappingInfo)j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.a.class);
    if (paramString1 != null) {
      com.tencent.mm.plugin.appbrand.dynamic.b.e.b(Q(paramString2, paramInt1, paramInt2), paramString1);
    }
    AppMethodBeat.o(121471);
    return paramString1;
  }
  
  public static d a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(121472);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("appId", paramString1);
    ((Bundle)localObject).putInt("pkgType", paramInt1);
    ((Bundle)localObject).putInt("pkgVersion", paramInt2);
    ((Bundle)localObject).putInt("widgetType", paramInt3);
    ((Bundle)localObject).putInt("scene", paramInt4);
    ((Bundle)localObject).putString("preloadLaunchData", paramString2);
    paramString2 = (Bundle)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, c.class);
    if (paramString2 == null)
    {
      AppMethodBeat.o(121472);
      return null;
    }
    localObject = new d();
    ((d)localObject).appId = paramString1;
    ((d)localObject).okc = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).okg = new yw();
    }
    try
    {
      ((d)localObject).okg.parseFrom(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).okf = new fmh();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).okf.parseFrom(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        ((d)localObject).okh = new fmj();
        if (paramString1 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).okh.parseFrom(paramString1);
            ((d)localObject).okd = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).oke = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).oke == null) {
              ((d)localObject).oke = new WidgetRuntimeConfig();
            }
            AppMethodBeat.o(121472);
            return localObject;
            paramString1 = paramString1;
            Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(121470);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, 0, null);
    AppMethodBeat.o(121470);
    return paramString1;
  }
  
  static class c
    implements com.tencent.mm.ipcinvoker.m<Bundle, Bundle>
  {
    private static Bundle P(Bundle paramBundle)
    {
      boolean bool2 = true;
      AppMethodBeat.i(121466);
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
        localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).bND();
        if (localObject4 == null)
        {
          AppMethodBeat.o(121466);
          return paramBundle;
        }
        if (((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_jsApiInfo != null) {
          paramBundle.putByteArray("jsApiInfo", ((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_jsApiInfo.toByteArray());
        }
        if (((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_launchAction != null) {
          paramBundle.putByteArray("launchAction", ((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_launchAction.toByteArray());
        }
        if (((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_versionInfo != null) {
          paramBundle.putByteArray("versionInfo", ((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_versionInfo.toByteArray());
        }
        localObject2 = new WidgetRuntimeConfig();
        ((WidgetRuntimeConfig)localObject2).appId = ((String)localObject1);
        ((WidgetRuntimeConfig)localObject2).ojq = m;
        localObject4 = ((com.tencent.mm.plugin.appbrand.widget.m)localObject4).field_widgetSetting;
        if (localObject4 != null)
        {
          ((WidgetRuntimeConfig)localObject2).ojH = ((fqc)localObject4).UNS;
          ((WidgetRuntimeConfig)localObject2).ojJ = ((fqc)localObject4).UNU;
          ((WidgetRuntimeConfig)localObject2).ojI = ((fqc)localObject4).UNT;
        }
        paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
        }
        localObject3 = localException.bFL().anA((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.agj((String)localObject1);
        localObject4 = new DebuggerInfo();
        if (localObject3 == null) {
          break label452;
        }
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.plugin.appbrand.dynamic.k.a.az(com.tencent.mm.plugin.appbrand.widget.a.b.class);
      if (localObject2 == null)
      {
        AppMethodBeat.o(121466);
        return paramBundle;
      }
      Object localObject3;
      if (((q)localObject3).field_openDebug)
      {
        bool1 = true;
        ((DebuggerInfo)localObject4).ohO = bool1;
        if ((!j.a.vB(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).ohN))) {
          break label458;
        }
        bool1 = true;
        label354:
        ((DebuggerInfo)localObject4).ohN = bool1;
        if ((localObject1 == null) || (!((DebuggerInfo)localObject1).ohP)) {
          break label464;
        }
      }
      label452:
      label458:
      label464:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((DebuggerInfo)localObject4).ohP = bool1;
        paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
        localObject1 = AppBrandGlobalSystemConfig.bLe();
        localObject3 = new WidgetSysConfig();
        ((WidgetSysConfig)localObject3).nXh = ((AppBrandGlobalSystemConfig)localObject1).nXh;
        ((WidgetSysConfig)localObject3).nXi = ((AppBrandGlobalSystemConfig)localObject1).nXi;
        ((WidgetSysConfig)localObject3).nXj = ((AppBrandGlobalSystemConfig)localObject1).nXj;
        paramBundle.putParcelable("sysConfig", (Parcelable)localObject3);
        AppMethodBeat.o(121466);
        return paramBundle;
        bool1 = false;
        break;
        bool1 = false;
        break label354;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */