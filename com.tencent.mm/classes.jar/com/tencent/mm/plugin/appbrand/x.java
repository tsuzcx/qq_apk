package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class x
{
  private static volatile Boolean fAx = null;
  
  public static boolean aaF()
  {
    boolean bool1;
    boolean bool2;
    if (fAx == null)
    {
      Object localObject = a.b.dHs;
      localObject = a.fJ("100400");
      if ((localObject == null) || (!((c)localObject).isValid())) {
        break label141;
      }
      if (bk.getInt((String)((c)localObject).ctr().get("openIsolateContext"), 0) <= 0) {
        break label131;
      }
      bool1 = true;
      int i = bk.getInt((String)((c)localObject).ctr().get("isolateContextLibVersion"), 2147483647);
      if ((!bool1) || (i > WxaCommLibRuntimeReader.abQ().fEN)) {
        break label136;
      }
      bool2 = true;
      label86:
      fAx = Boolean.valueOf(bool2);
      y.i("MicroMsg.AppBrand.MultiContextABTests", "openLibraryIsolateContext exp(%b, %d), result %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), fAx });
    }
    for (;;)
    {
      return fAx.booleanValue();
      label131:
      bool1 = false;
      break;
      label136:
      bool2 = false;
      break label86;
      label141:
      fAx = Boolean.valueOf(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.x
 * JD-Core Version:    0.7.0.1
 */