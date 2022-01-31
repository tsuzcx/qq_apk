package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.protocal.protobuf.cza;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class WxaWidgetInitializer
{
  static WxaWidgetInitializer.WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    AppMethodBeat.i(10724);
    ab.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.avI();
    if (localWxaPkgWrappingInfo == null)
    {
      ab.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      AppMethodBeat.o(10724);
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetInitializer.WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.equ = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.hnS = paramd.hqL;
    if (paramWxaPkgWrappingInfo.hnS == null) {
      paramWxaPkgWrappingInfo.hnS = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.hnT = paramd.hqM;
    paramWxaPkgWrappingInfo.hnU = paramd.hqN;
    for (;;)
    {
      try
      {
        if ((paramd.hqP == null) || (paramd.hqP.wKA == null)) {
          continue;
        }
        paramString2 = paramd.hqP.wKA.toByteArray();
        paramWxaPkgWrappingInfo.hnQ = paramString2;
      }
      catch (Exception paramString2)
      {
        ab.e("MicroMsg.WxaWidgetInitializer", bo.l(paramString2));
        continue;
        if (paramd.hqO == null) {
          continue;
        }
        i = paramd.hqO.wld;
        paramWxaPkgWrappingInfo.hnR = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.hnS.hoz) {
        continue;
      }
      paramWxaPkgWrappingInfo.hnR = 2;
      f.azz().aZ(paramString1, 2101);
      j.azD().O(paramString1, 626, 5);
      AppMethodBeat.o(10724);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String bO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10725);
    paramString1 = paramString1 + "#" + paramString2 + "#" + System.currentTimeMillis();
    AppMethodBeat.o(10725);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */