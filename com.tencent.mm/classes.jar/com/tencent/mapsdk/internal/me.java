package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class me
  extends mb
{
  private static volatile me b;
  private static final String c = "com.tencent.tencentmap.mapsdk.maps.offlinemap";
  
  private me(Context paramContext)
  {
    AppMethodBeat.i(223051);
    if (paramContext == null)
    {
      AppMethodBeat.o(223051);
      return;
    }
    this.a = paramContext.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
    if (b != null)
    {
      a(new String[] { "taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount", "rttConfigVersion", "rttConfigMd5", "closeRoadSytleNomalModeVersion", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeVersion", "closeRoadStyleTrafficModeMd5", "offlineCityListVersion", "offlineCityListMd5" });
      paramContext = a("sdkVersion");
      if ((paramContext != null) && (gw.b("4.1.0", paramContext) > 0)) {
        a();
      }
    }
    AppMethodBeat.o(223051);
  }
  
  public static me a(Context paramContext)
  {
    AppMethodBeat.i(223043);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new me(paramContext);
      }
      paramContext = b;
      AppMethodBeat.o(223043);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(223043);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(223061);
    if (b == null)
    {
      AppMethodBeat.o(223061);
      return;
    }
    a(new String[] { "taiwanClearCacheVersion", "taiwanStyle", "taiwanVersion", "mapPoiIcon", "worldTileCount", "rttConfigVersion", "rttConfigMd5", "closeRoadSytleNomalModeVersion", "closeRoadSytleNomalModeMd5", "closeRoadStyleTrafficModeVersion", "closeRoadStyleTrafficModeMd5", "offlineCityListVersion", "offlineCityListMd5" });
    String str = a("sdkVersion");
    if (str == null)
    {
      AppMethodBeat.o(223061);
      return;
    }
    if (gw.b("4.1.0", str) > 0) {
      a();
    }
    AppMethodBeat.o(223061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.me
 * JD-Core Version:    0.7.0.1
 */