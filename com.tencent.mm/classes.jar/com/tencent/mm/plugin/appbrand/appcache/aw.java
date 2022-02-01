package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import com.tencent.luggage.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class aw
{
  public static final int VERSION;
  public static final String[] jnA;
  static final a jnB;
  private static Boolean jnC;
  
  static
  {
    j = -1;
    AppMethodBeat.i(139836);
    try
    {
      String str = aWT();
      i = j;
      if (!bs.isNullOrNil(str))
      {
        i = j;
        if (i.eA(str)) {
          i = new JSONObject(i.aSr(str)).optInt("version");
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
      jnA = a.cgt;
    }
    for (jnB = a.jnG;; jnB = a.jnG)
    {
      jnC = null;
      AppMethodBeat.o(139836);
      return;
      VERSION = 407;
      jnA = a.cgt;
    }
  }
  
  private static InputStream Ib(String paramString)
  {
    AppMethodBeat.i(139834);
    Object localObject = ai.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString, 3);
      AppMethodBeat.o(139834);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      AppMethodBeat.o(139834);
    }
    return null;
  }
  
  public static void aWS()
  {
    AppMethodBeat.i(139829);
    i.deleteFile(aWT());
    AppMethodBeat.o(139829);
  }
  
  static String aWT()
  {
    AppMethodBeat.i(139830);
    String str = q.B(new e(ai.getContext().getCacheDir().getAbsolutePath() + "/MockLibInfo.json").fxV());
    AppMethodBeat.o(139830);
    return str;
  }
  
  public static boolean aWU()
  {
    AppMethodBeat.i(139831);
    if (jnC == null) {
      jnC = Boolean.FALSE;
    }
    boolean bool = jnC.booleanValue();
    AppMethodBeat.o(139831);
    return bool;
  }
  
  public static WxaPkgWrappingInfo aWV()
  {
    AppMethodBeat.i(139835);
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.pkgVersion = VERSION;
    localWxaPkgWrappingInfo.jpc = true;
    AppMethodBeat.o(139835);
    return localWxaPkgWrappingInfo;
  }
  
  public static void fJ(boolean paramBoolean)
  {
    AppMethodBeat.i(139832);
    com.tencent.mm.sdk.platformtools.aw.aKT("__appbrand_comm_lib__prefs").putBoolean("disable_develop_lib", paramBoolean).commit();
    AppMethodBeat.o(139832);
  }
  
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(139833);
    paramString = m.IY(paramString);
    switch (1.jnD[jnB.ordinal()])
    {
    default: 
      paramString = Ib("wxa_library".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    case 1: 
      paramString = Ib("wxa_library/custom".concat(String.valueOf(paramString)));
      AppMethodBeat.o(139833);
      return paramString;
    }
    paramString = Ib("wxa_library/develop".concat(String.valueOf(paramString)));
    AppMethodBeat.o(139833);
    return paramString;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(139828);
      jnE = new a("CUSTOM", 0);
      jnF = new a("DEVELOP", 1);
      jnG = new a("STABLE", 2);
      jnH = new a[] { jnE, jnF, jnG };
      AppMethodBeat.o(139828);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */