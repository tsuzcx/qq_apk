package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.da;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.shortlink.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends com.tencent.mm.plugin.appbrand.menu.a.a<ag>
{
  private final b neD;
  
  public e()
  {
    super(u.nfA.ordinal());
    AppMethodBeat.i(227161);
    this.neD = new b((byte)0);
    AppMethodBeat.o(227161);
  }
  
  public static a f(ag paramag)
  {
    AppMethodBeat.i(227162);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramag.getRuntime().bsB();
    if (localAppBrandSysConfigWC != null) {}
    for (int i = com.tencent.mm.plugin.appbrand.config.a.lbF.a(localAppBrandSysConfigWC);; i = 0)
    {
      d locald = d.nNQ;
      if ((((Boolean)d.bVB().invoke()).booleanValue()) && (i != 1))
      {
        if (((!o.g(paramag)) || (i != 0)) && (localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.leE.kNW == 0))
        {
          paramag = a.neH;
          AppMethodBeat.o(227162);
          return paramag;
        }
        paramag = a.neG;
        AppMethodBeat.o(227162);
        return paramag;
      }
      paramag = a.neF;
      AppMethodBeat.o(227162);
      return paramag;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(227159);
      neF = new a("HIDDEN", 0);
      neG = new a("SHOW_CLICKABLE", 1);
      neH = new a("SHOW_UNCLICKABLE", 2);
      neI = new a[] { neF, neG, neH };
      AppMethodBeat.o(227159);
    }
    
    private a() {}
  }
  
  static final class b
    implements ah
  {
    public String appId = "";
    public ag mri;
    public String neC = "";
    
    public final void Zi(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(227160);
      Log.i("MicroMsg.MenuDelegate_CopyShortLink", "onReturnUrl %s", new Object[] { paramString });
      Object localObject = this.appId;
      String str = this.neC;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      i.a((String)localObject, str, 47, "", l, i, 0);
      localObject = da.lCI;
      da.b(ad.lyc, this);
      if (!paramString.isEmpty())
      {
        localObject = com.tencent.mm.plugin.appbrand.shortlink.e.nNT;
        com.tencent.mm.plugin.appbrand.shortlink.e.b(this.mri, paramString);
      }
      AppMethodBeat.o(227160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e
 * JD-Core Version:    0.7.0.1
 */