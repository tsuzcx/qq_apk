package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class aw
{
  public static final int VERSION;
  public static final String[] iNs;
  static final a iNt;
  private static Boolean iNu;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = aQb();
      i = j;
      if (!bt.isNullOrNil(str))
      {
        i = j;
        if (i.eK(str)) {
          i = new JSONObject(i.aMP(str)).optInt("version");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = j;
      }
    }
    if (i > 0)
    {
      VERSION = i;
      iNs = a.cjx;
    }
    for (iNt = a.iNy;; iNt = a.iNy)
    {
      iNu = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 407;
      iNs = a.cjx;
    }
  }
  
  private static InputStream DY(String paramString)
  {
    AppMethodBeat.i(139834);
    Object localObject = aj.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      AppMethodBeat.o(139834);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      AppMethodBeat.o(139834);
    }
    return null;
  }
  
  public static void aQa()
  {
    AppMethodBeat.i(139829);
    i.deleteFile(aQb());
    AppMethodBeat.o(139829);
  }
  
  static String aQb()
  {
    AppMethodBeat.i(139830);
    String str = q.B(new e(aj.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").fhU());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean aQc()
  {
    AppMethodBeat.i(139831);
    if (iNu == null) {
      iNu = Boolean.FALSE;
    }
    boolean bool = iNu.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo aQd()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.iOS = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void fn(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    ax.aFC("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = m.EV(paramString);
    switch (1.iNv[iNt.ordinal()])
    {
    default: 
      paramString = DY("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = DY("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = DY("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      iNw = new a("CUSTOM", 0);
      iNx = new a("DEVELOP", 1);
      iNy = new a("STABLE", 2);
      iNz = new a[] { iNw, iNx, iNy };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */