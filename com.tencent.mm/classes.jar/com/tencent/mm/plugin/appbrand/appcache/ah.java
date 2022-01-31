package com.tencent.mm.plugin.appbrand.appcache;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.InputStream;
import org.json.JSONObject;

public final class ah
{
  public static final int VERSION;
  public static final String[] fDn;
  static final ah.a fDo;
  private static Boolean fDp;
  
  static
  {
    j = -1;
    i = j;
    try
    {
      if (ae.cqV())
      {
        String str = abU();
        i = j;
        if (!bk.bl(str))
        {
          i = j;
          if (e.bK(str)) {
            i = new JSONObject(e.bP(str)).optInt("version");
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i > 0)
    {
      VERSION = i;
      fDn = com.tencent.luggage.k.a.bjW;
    }
    for (fDo = ah.a.fDt;; fDo = ah.a.fDt)
    {
      fDp = null;
      return;
      VERSION = 170;
      fDn = com.tencent.luggage.k.a.bjW;
    }
  }
  
  public static void abT()
  {
    e.deleteFile(abU());
  }
  
  static String abU()
  {
    return j.n(new b(aj.abZ() + "/MockLibInfo.json").cLr());
  }
  
  public static boolean abV()
  {
    if (fDp == null)
    {
      ae.cqS();
      fDp = Boolean.valueOf(false);
    }
    return fDp.booleanValue();
  }
  
  public static WxaPkgWrappingInfo abW()
  {
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    localWxaPkgWrappingInfo.fEN = VERSION;
    localWxaPkgWrappingInfo.fEP = true;
    return localWxaPkgWrappingInfo;
  }
  
  public static InputStream openRead(String paramString)
  {
    paramString = a.qR(paramString);
    switch (ah.1.fDq[fDo.ordinal()])
    {
    default: 
      return qZ("wxa_library" + paramString);
    case 1: 
      return qZ("wxa_library/local" + paramString);
    }
    return qZ("wxa_library/develop" + paramString);
  }
  
  private static InputStream qZ(String paramString)
  {
    Object localObject = ae.getContext().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
      return localObject;
    }
    catch (Exception localException)
    {
      y.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ah
 * JD-Core Version:    0.7.0.1
 */