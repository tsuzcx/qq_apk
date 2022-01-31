package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.b.e;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.c.clk;
import com.tencent.mm.protocal.c.cll;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class a
{
  private static String D(String paramString, int paramInt1, int paramInt2)
  {
    return paramString + "#" + paramInt1 + "#" + paramInt2;
  }
  
  public static WxaPkgWrappingInfo a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    localBundle.putInt("pkgType", paramInt1);
    localBundle.putInt("pkgVersion", paramInt2);
    localBundle.putString("searchId", paramString3);
    localBundle.putString("preload_download_data", paramString4);
    if (paramInt1 == 10102)
    {
      paramString1 = e.td(D(paramString2, paramInt1, paramInt2));
      if (paramString1 != null) {
        u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
      }
    }
    do
    {
      return paramString1;
      paramString3 = (WxaPkgWrappingInfo)f.a("com.tencent.mm", localBundle, a.a.class);
      paramString1 = paramString3;
    } while (paramString3 == null);
    e.a(D(paramString2, paramInt1, paramInt2), paramString3);
    return paramString3;
  }
  
  public static d a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("appId", paramString1);
    ((Bundle)localObject).putInt("pkgType", paramInt1);
    ((Bundle)localObject).putInt("pkgVersion", paramInt2);
    ((Bundle)localObject).putInt("widgetType", paramInt3);
    ((Bundle)localObject).putInt("scene", paramInt4);
    ((Bundle)localObject).putString("preloadLaunchData", paramString2);
    paramString2 = (Bundle)f.a("com.tencent.mm", (Parcelable)localObject, a.c.class);
    if (paramString2 == null) {
      return null;
    }
    localObject = new d();
    ((d)localObject).appId = paramString1;
    ((d)localObject).fXl = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).fXp = new pc();
    }
    try
    {
      ((d)localObject).fXp.aH(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).fXo = new clk();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).fXo.aH(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        if (paramString1 != null) {
          ((d)localObject).fXq = new cll();
        }
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).fXq.aH(paramString1);
            ((d)localObject).fXm = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).fXn = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).fXn == null) {
              ((d)localObject).fXn = new WidgetRuntimeConfig();
            }
            return localObject;
            paramString1 = paramString1;
            y.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          y.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            y.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramInt, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */