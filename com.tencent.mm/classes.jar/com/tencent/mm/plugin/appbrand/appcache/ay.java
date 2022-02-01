package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class ay
{
  public static final int VERSION;
  public static final String[] kMx;
  static final a kMy;
  private static Boolean kMz;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = bwd();
      i = j;
      if (!Util.isNullOrNil(str))
      {
        i = j;
        if (s.YS(str)) {
          i = new JSONObject(s.boY(str)).optInt("version");
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
      kMx = a.cDE;
    }
    for (kMy = a.kMD;; kMy = a.kMD)
    {
      kMz = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 491;
      kMx = a.cDE;
    }
  }
  
  private static InputStream Vf(String paramString)
  {
    AppMethodBeat.i(139834);
    Object localObject = MMApplicationContext.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      AppMethodBeat.o(139834);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      AppMethodBeat.o(139834);
    }
    return null;
  }
  
  public static void bwc()
  {
    AppMethodBeat.i(139829);
    s.deleteFile(bwd());
    AppMethodBeat.o(139829);
  }
  
  static String bwd()
  {
    AppMethodBeat.i(139830);
    String str = aa.z(new o(MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").her());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean bwe()
  {
    AppMethodBeat.i(139831);
    if (kMz == null) {
      kMz = Boolean.FALSE;
    }
    boolean bool = kMz.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo bwf()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.kNY = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void gI(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    MultiProcessMMKV.getMMKV("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = n.We(paramString);
    switch (1.kMA[kMy.ordinal()])
    {
    default: 
      paramString = Vf("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = Vf("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = Vf("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      kMB = new a("CUSTOM", 0);
      kMC = new a("DEVELOP", 1);
      kMD = new a("STABLE", 2);
      kME = new a[] { kMB, kMC, kMD };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */