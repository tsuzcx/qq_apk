package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.db;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.shortlink.d;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
  extends com.tencent.mm.plugin.appbrand.menu.a.a<com.tencent.mm.plugin.appbrand.page.ah>
{
  private final b qeW;
  
  public e()
  {
    super(w.qgi.ordinal());
    AppMethodBeat.i(284311);
    this.qeW = new b((byte)0);
    AppMethodBeat.o(284311);
  }
  
  public static a g(com.tencent.mm.plugin.appbrand.page.ah paramah)
  {
    AppMethodBeat.i(284312);
    AppBrandSysConfigWC localAppBrandSysConfigWC = paramah.getRuntime().bDx();
    if (localAppBrandSysConfigWC != null) {}
    for (int i = com.tencent.mm.plugin.appbrand.config.a.nVN.a(localAppBrandSysConfigWC);; i = 0)
    {
      d locald = d.qQm;
      if ((((Boolean)d.ciI().invoke()).booleanValue()) && (i != 1))
      {
        if (((!q.h(paramah)) || (i != 0)) && (localAppBrandSysConfigWC != null) && (localAppBrandSysConfigWC.nYR.nHY == 0))
        {
          paramah = a.qfa;
          AppMethodBeat.o(284312);
          return paramah;
        }
        paramah = a.qeZ;
        AppMethodBeat.o(284312);
        return paramah;
      }
      paramah = a.qeY;
      AppMethodBeat.o(284312);
      return paramah;
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(284609);
      qeY = new a("HIDDEN", 0);
      qeZ = new a("SHOW_CLICKABLE", 1);
      qfa = new a("SHOW_UNCLICKABLE", 2);
      qfb = new a[] { qeY, qeZ, qfa };
      AppMethodBeat.o(284609);
    }
    
    private a() {}
  }
  
  static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.ah
  {
    public String appId = "";
    public com.tencent.mm.plugin.appbrand.page.ah ppq;
    public String qeV = "";
    
    public final void agV(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(271304);
      Log.i("MicroMsg.MenuDelegate_CopyShortLink", "onReturnUrl %s", new Object[] { paramString });
      Object localObject = this.appId;
      String str = this.qeV;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      j.a((String)localObject, str, 47, "", l, i, 0);
      localObject = db.oyi;
      db.b(ac.osP, this);
      if (!paramString.isEmpty())
      {
        localObject = com.tencent.mm.plugin.appbrand.shortlink.e.qQp;
        com.tencent.mm.plugin.appbrand.shortlink.e.b(this.ppq, paramString);
      }
      AppMethodBeat.o(271304);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e
 * JD-Core Version:    0.7.0.1
 */