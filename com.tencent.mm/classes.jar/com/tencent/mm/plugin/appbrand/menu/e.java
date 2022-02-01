package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.dl;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.shortlink.WxaShortLinkRiskManager;
import com.tencent.mm.plugin.appbrand.shortlink.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ah>
{
  private final a tjG;
  
  public e()
  {
    super(x.tkM.ordinal());
    AppMethodBeat.i(323818);
    this.tjG = new a((byte)0);
    AppMethodBeat.o(323818);
  }
  
  public static y a(ah paramah, Context paramContext)
  {
    AppMethodBeat.i(323826);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().ccM();
    if (localAppBrandSysConfigWC != null) {}
    for (int i = com.tencent.mm.plugin.appbrand.config.a.qVv.a(localAppBrandSysConfigWC);; i = 0)
    {
      c localc = c.tUX;
      if ((((Boolean)c.cJA().invoke()).booleanValue()) && (i != 1))
      {
        if (((q.g(paramah)) && (i == 0)) || (((localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.qYY.qHO == 0)) || (com.tencent.mm.plugin.appbrand.k.a.a.F(paramah.getRuntime())) || (com.tencent.mm.plugin.appbrand.ad.e.eu(paramContext))))
        {
          paramah = y.tkT;
          AppMethodBeat.o(323826);
          return paramah;
        }
        paramah = y.tkS;
        AppMethodBeat.o(323826);
        return paramah;
      }
      paramah = y.tkR;
      AppMethodBeat.o(323826);
      return paramah;
    }
  }
  
  static final class a
    implements ak
  {
    public String appId = "";
    public ah sue;
    public String tjF = "";
    
    public final void ZS(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(323861);
      Log.i("MicroMsg.MenuDelegate_CopyShortLink", "onReturnUrl %s", new Object[] { paramString });
      Object localObject = this.appId;
      String str = this.tjF;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      j.a((String)localObject, str, 47, "", l, i, 0);
      localObject = dl.rBE;
      dl.b(ad.rwM, this);
      if (!paramString.isEmpty())
      {
        localObject = WxaShortLinkRiskManager.tVc;
        WxaShortLinkRiskManager.c(this.sue, paramString);
      }
      AppMethodBeat.o(323861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e
 * JD-Core Version:    0.7.0.1
 */