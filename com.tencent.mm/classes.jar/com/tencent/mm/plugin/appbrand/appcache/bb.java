package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.m.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class bb
{
  public static final int VERSION;
  public static final String[] nGr;
  static final a nGs;
  private static Boolean nGt;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = bHk();
      i = j;
      if (!Util.isNullOrNil(str))
      {
        i = j;
        if (u.agG(str)) {
          i = new JSONObject(u.bBS(str)).optInt("version");
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
      nGr = a.cEl;
    }
    for (nGs = a.nGx;; nGs = a.nGx)
    {
      nGt = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 536;
      nGr = a.cEl;
    }
  }
  
  public static InputStream Tf(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = o.adS(paramString);
    switch (1.nGu[nGs.ordinal()])
    {
    default: 
      paramString = acP("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = acP("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = acP("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  private static InputStream acP(String paramString)
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
  
  public static void bHj()
  {
    AppMethodBeat.i(139829);
    u.deleteFile(bHk());
    AppMethodBeat.o(139829);
  }
  
  static String bHk()
  {
    AppMethodBeat.i(139830);
    String str = new q(MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").bOF();
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean bHl()
  {
    AppMethodBeat.i(139831);
    if (nGt == null) {
      nGt = Boolean.FALSE;
    }
    boolean bool = nGt.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo bHm()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.nIa = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void ht(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    MultiProcessMMKV.getMMKV("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      nGv = new a("CUSTOM", 0);
      nGw = new a("DEVELOP", 1);
      nGx = new a("STABLE", 2);
      nGy = new a[] { nGv, nGw, nGx };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bb
 * JD-Core Version:    0.7.0.1
 */