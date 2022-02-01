package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class bc
{
  public static final int VERSION;
  public static final String[] qGk;
  static final a qGl;
  private static Boolean qGm;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = cgH();
      i = j;
      if (!Util.isNullOrNil(str))
      {
        i = j;
        if (y.ZC(str)) {
          i = new JSONObject(y.bEn(str)).optInt("version");
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
      qGk = a.exw;
    }
    for (qGl = a.qGp;; qGl = a.qGp)
    {
      qGm = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 594;
      qGk = a.exw;
    }
  }
  
  public static InputStream Lh(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = t.as(paramString, true);
    switch (1.qGn[qGl.ordinal()])
    {
    default: 
      paramString = Vn("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = Vn("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  private static InputStream Vn(String paramString)
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
  
  public static void cgG()
  {
    AppMethodBeat.i(139829);
    y.deleteFile(cgH());
    AppMethodBeat.o(139829);
  }
  
  static String cgH()
  {
    AppMethodBeat.i(139830);
    String str = ah.v(new u(MMApplicationContext.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").jKT());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean cgI()
  {
    AppMethodBeat.i(139831);
    if (qGm == null) {
      qGm = Boolean.FALSE;
    }
    boolean bool = qGm.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo cgJ()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.qHQ = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void ik(boolean paramBoolean)
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
      qGo = new a("DEVELOP", 0);
      qGp = new a("STABLE", 1);
      qGq = new a[] { qGo, qGp };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bc
 * JD-Core Version:    0.7.0.1
 */