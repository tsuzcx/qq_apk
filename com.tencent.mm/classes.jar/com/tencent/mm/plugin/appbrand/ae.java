package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class ae
{
  private static volatile Boolean gSg = null;
  
  public static boolean aum()
  {
    AppMethodBeat.i(129142);
    boolean bool1;
    boolean bool2;
    if (gSg == null)
    {
      Object localObject = a.b.eEW;
      localObject = a.me("100400");
      if ((localObject == null) || (!((c)localObject).isValid())) {
        break label153;
      }
      if (bo.getInt((String)((c)localObject).dvN().get("openIsolateContext"), 0) <= 0) {
        break label143;
      }
      bool1 = true;
      int i = bo.getInt((String)((c)localObject).dvN().get("isolateContextLibVersion"), 2147483647);
      if ((!bool1) || (i > WxaCommLibRuntimeReader.avI().gXf)) {
        break label148;
      }
      bool2 = true;
      label91:
      gSg = Boolean.valueOf(bool2);
      ab.i("MicroMsg.AppBrand.MultiContextABTests", "openLibraryIsolateContext exp(%b, %d), result %b", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), gSg });
    }
    for (;;)
    {
      bool1 = gSg.booleanValue();
      AppMethodBeat.o(129142);
      return bool1;
      label143:
      bool1 = false;
      break;
      label148:
      bool2 = false;
      break label91;
      label153:
      gSg = Boolean.FALSE;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae
 * JD-Core Version:    0.7.0.1
 */