package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ak;
import com.tencent.mm.plugin.appbrand.jsapi.dl;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends a<ah>
{
  private static final a tjD;
  
  static
  {
    AppMethodBeat.i(323831);
    tjD = new a();
    AppMethodBeat.o(323831);
  }
  
  public d()
  {
    super(x.tkh.ordinal());
    AppMethodBeat.i(47623);
    AppMethodBeat.o(47623);
  }
  
  public static final class a
    implements ak
  {
    public String appId = "";
    public String tjF = "";
    
    public final void ZS(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(323891);
      Log.i("MicroMsg.MenuDelegate_CopyPath", "onReturnUrl %s", new Object[] { paramString });
      String str1 = this.appId;
      String str2 = this.tjF;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      j.a(str1, str2, 26, "", l, i, 0);
      paramString = dl.rBE;
      dl.b(ad.rwN, this);
      AppMethodBeat.o(323891);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d
 * JD-Core Version:    0.7.0.1
 */