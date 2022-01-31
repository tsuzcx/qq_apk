package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.bv.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.protocal.c.clk;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class WxaWidgetInitializer
{
  static WxaWidgetInitializer.WxaWidgetContextImpl a(String paramString1, String paramString2, WxaPkgWrappingInfo paramWxaPkgWrappingInfo, d paramd)
  {
    i = 1;
    y.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    u.i("MicroMsg.WxaWidgetInitializer", "prepare(%s)", new Object[] { paramString1 });
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = WxaCommLibRuntimeReader.abQ();
    if (localWxaPkgWrappingInfo == null)
    {
      y.e("MicroMsg.WxaWidgetInitializer", "getLibPkgInfo return null.");
      return null;
    }
    paramWxaPkgWrappingInfo = new WxaWidgetInitializer.WxaWidgetContextImpl(localWxaPkgWrappingInfo, paramWxaPkgWrappingInfo);
    paramWxaPkgWrappingInfo.dIX = paramString1;
    paramWxaPkgWrappingInfo.mAppId = paramString2;
    paramWxaPkgWrappingInfo.fUq = paramd.fXl;
    if (paramWxaPkgWrappingInfo.fUq == null) {
      paramWxaPkgWrappingInfo.fUq = new DebuggerInfo();
    }
    paramWxaPkgWrappingInfo.fUr = paramd.fXm;
    paramWxaPkgWrappingInfo.fUs = paramd.fXn;
    for (;;)
    {
      try
      {
        if ((paramd.fXp == null) || (paramd.fXp.sMN == null)) {
          continue;
        }
        paramString2 = paramd.fXp.sMN.toByteArray();
        paramWxaPkgWrappingInfo.fUo = paramString2;
      }
      catch (Exception paramString2)
      {
        y.e("MicroMsg.WxaWidgetInitializer", bk.j(paramString2));
        continue;
        if (paramd.fXo == null) {
          continue;
        }
        i = paramd.fXo.ssy;
        paramWxaPkgWrappingInfo.fUp = i;
        continue;
      }
      if (!paramWxaPkgWrappingInfo.fUq.fUX) {
        continue;
      }
      paramWxaPkgWrappingInfo.fUp = 2;
      f.aeW().aH(paramString1, 2101);
      j.aeZ().C(paramString1, 626, 5);
      return paramWxaPkgWrappingInfo;
      paramString2 = new byte[0];
    }
  }
  
  public static String bn(String paramString1, String paramString2)
  {
    return paramString1 + "#" + paramString2 + "#" + System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer
 * JD-Core Version:    0.7.0.1
 */