package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class an
{
  public static final int VERSION;
  public static final String[] gVC;
  static final an.a gVD;
  private static Boolean gVE;
  
  static
  {
    j = -1;
    AppMethodBeat.i(114316);
    try
    {
      String str = avL();
      i = j;
      if (!bo.isNullOrNil(str))
      {
        i = j;
        if (e.cN(str)) {
          i = new JSONObject(e.cS(str)).optInt("version");
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
      gVC = a.bFN;
    }
    for (gVD = an.a.gVI;; gVD = an.a.gVI)
    {
      gVE = null;
      AppMethodBeat.o(114316);
      return;
      VERSION = 254;
      gVC = a.bFN;
    }
  }
  
  public static void avK()
  {
    AppMethodBeat.i(114309);
    e.deleteFile(avL());
    AppMethodBeat.o(114309);
  }
  
  static String avL()
  {
    AppMethodBeat.i(114310);
    String str = j.p(new b(ah.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").dQJ());
    AppMethodBeat.o(114310);
    return str;
  }
  
  public static boolean avM()
  {
    AppMethodBeat.i(114311);
    if (gVE == null) {
      gVE = Boolean.FALSE;
    }
    boolean bool = gVE.booleanValue();
    AppMethodBeat.o(114311);
    return bool;
  }
  
  public static WxaPkgWrappingInfo avN()
  {
    AppMethodBeat.i(114315);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.gXf = VERSION;
    localWxaPkgWrappingInfo.gXh = true;
    AppMethodBeat.o(114315);
    return localWxaPkgWrappingInfo;
  }
  
  public static void dK(boolean paramBoolean)
  {
    AppMethodBeat.i(114312);
    as.apq("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(114312);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(114313);
    paramString = k.zl(paramString);
    switch (an.1.gVF[gVD.ordinal()])
    {
    default: 
      paramString = yu("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114313);
      return paramString;
    case 1: 
      paramString = yu("wxa_library/local".concat(String.valueOf(paramString)));
      AppMethodBeat.o(114313);
      return paramString;
    }
    paramString = yu("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(114313);
    return paramString;
  }
  
  private static InputStream yu(String paramString)
  {
    AppMethodBeat.i(114314);
    Object localObject = ah.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      AppMethodBeat.o(114314);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      AppMethodBeat.o(114314);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.an
 * JD-Core Version:    0.7.0.1
 */