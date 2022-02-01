package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class ay
{
  public static final int VERSION;
  private static Boolean jKA;
  public static final String[] jKy;
  static final a jKz;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = baP();
      i = j;
      if (!bu.isNullOrNil(str))
      {
        i = j;
        if (o.fB(str)) {
          i = new JSONObject(o.aZT(str)).optInt("version");
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
      jKy = a.cro;
    }
    for (jKz = a.jKE;; jKz = a.jKE)
    {
      jKA = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 426;
      jKy = a.cro;
    }
  }
  
  private static InputStream LW(String paramString)
  {
    AppMethodBeat.i(139834);
    Object localObject = ak.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      AppMethodBeat.o(139834);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      AppMethodBeat.o(139834);
    }
    return null;
  }
  
  public static void baO()
  {
    AppMethodBeat.i(139829);
    o.deleteFile(baP());
    AppMethodBeat.o(139829);
  }
  
  static String baP()
  {
    AppMethodBeat.i(139830);
    String str = w.B(new k(ak.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").fTh());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean baQ()
  {
    AppMethodBeat.i(139831);
    if (jKA == null) {
      jKA = Boolean.FALSE;
    }
    boolean bool = jKA.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo baR()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.jLX = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void fM(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    com.tencent.mm.sdk.platformtools.ay.aRW("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = n.MV(paramString);
    switch (1.jKB[jKz.ordinal()])
    {
    default: 
      paramString = LW("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = LW("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = LW("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      jKC = new a("CUSTOM", 0);
      jKD = new a("DEVELOP", 1);
      jKE = new a("STABLE", 2);
      jKF = new a[] { jKC, jKD, jKE };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ay
 * JD-Core Version:    0.7.0.1
 */