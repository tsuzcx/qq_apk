package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class ax
{
  public static final int VERSION;
  public static final String[] jHx;
  static final a jHy;
  private static Boolean jHz;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = baq();
      i = j;
      if (!bt.isNullOrNil(str))
      {
        i = j;
        if (i.fv(str)) {
          i = new JSONObject(i.aYq(str)).optInt("version");
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
      jHx = a.cqK;
    }
    for (jHy = a.jHD;; jHy = a.jHD)
    {
      jHz = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 426;
      jHx = a.cqK;
    }
  }
  
  private static InputStream Lt(String paramString)
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
  
  public static void bap()
  {
    AppMethodBeat.i(139829);
    i.deleteFile(baq());
    AppMethodBeat.o(139829);
  }
  
  static String baq()
  {
    AppMethodBeat.i(139830);
    String str = q.B(new e(aj.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").fOK());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean bar()
  {
    AppMethodBeat.i(139831);
    if (jHz == null) {
      jHz = Boolean.FALSE;
    }
    boolean bool = jHz.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo bas()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.jIW = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    com.tencent.mm.sdk.platformtools.ax.aQz("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = m.Mp(paramString);
    switch (1.jHA[jHy.ordinal()])
    {
    default: 
      paramString = Lt("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = Lt("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = Lt("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      jHB = new a("CUSTOM", 0);
      jHC = new a("DEVELOP", 1);
      jHD = new a("STABLE", 2);
      jHE = new a[] { jHB, jHC, jHD };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */