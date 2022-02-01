package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.da;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends a<ag>
{
  private static final b jdField_new;
  
  static
  {
    AppMethodBeat.i(227155);
    jdField_new = new b();
    AppMethodBeat.o(227155);
  }
  
  public d()
  {
    super(u.neV.ordinal());
    AppMethodBeat.i(47623);
    AppMethodBeat.o(47623);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(227153);
      ney = new a("HIDDEN", 0);
      nez = new a("SHOW_CLICKABLE", 1);
      neA = new a("SHOW_UNCLICKABLE", 2);
      neB = new a[] { ney, nez, neA };
      AppMethodBeat.o(227153);
    }
    
    private a() {}
  }
  
  public static final class b
    implements ah
  {
    public String appId = "";
    public String neC = "";
    
    public final void Zi(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(227154);
      Log.i("MicroMsg.MenuDelegate_CopyPath", "onReturnUrl %s", new Object[] { paramString });
      String str1 = this.appId;
      String str2 = this.neC;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      i.a(str1, str2, 26, "", l, i, 0);
      paramString = da.lCI;
      da.b(ad.lyd, this);
      AppMethodBeat.o(227154);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d
 * JD-Core Version:    0.7.0.1
 */