package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.b.e;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.czb;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class a
{
  private static String P(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10992);
    paramString = paramString + "#" + paramInt1 + "#" + paramInt2;
    AppMethodBeat.o(10992);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(10990);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    localBundle.putInt("pkgType", paramInt1);
    localBundle.putInt("pkgVersion", paramInt2);
    localBundle.putString("searchId", paramString3);
    localBundle.putString("preload_download_data", paramString4);
    if (paramInt1 == 10102)
    {
      paramString1 = e.Bf(P(paramString2, paramInt1, paramInt2));
      if (paramString1 != null)
      {
        u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
        AppMethodBeat.o(10990);
        return paramString1;
      }
    }
    paramString1 = (WxaPkgWrappingInfo)f.a("com.tencent.mm", localBundle, a.a.class);
    if (paramString1 != null) {
      e.a(P(paramString2, paramInt1, paramInt2), paramString1);
    }
    AppMethodBeat.o(10990);
    return paramString1;
  }
  
  public static d a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(10991);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("appId", paramString1);
    ((Bundle)localObject).putInt("pkgType", paramInt1);
    ((Bundle)localObject).putInt("pkgVersion", paramInt2);
    ((Bundle)localObject).putInt("widgetType", paramInt3);
    ((Bundle)localObject).putInt("scene", paramInt4);
    ((Bundle)localObject).putString("preloadLaunchData", paramString2);
    paramString2 = (Bundle)f.a("com.tencent.mm", (Parcelable)localObject, a.c.class);
    if (paramString2 == null)
    {
      AppMethodBeat.o(10991);
      return null;
    }
    localObject = new d();
    ((d)localObject).appId = paramString1;
    ((d)localObject).hqL = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).hqP = new se();
    }
    try
    {
      ((d)localObject).hqP.parseFrom(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).hqO = new cza();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).hqO.parseFrom(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        ((d)localObject).hqQ = new czb();
        if (paramString1 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).hqQ.parseFrom(paramString1);
            ((d)localObject).hqM = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).hqN = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).hqN == null) {
              ((d)localObject).hqN = new WidgetRuntimeConfig();
            }
            AppMethodBeat.o(10991);
            return localObject;
            paramString1 = paramString1;
            ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            ab.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(10989);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, 0, null);
    AppMethodBeat.o(10989);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */