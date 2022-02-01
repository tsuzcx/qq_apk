package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.db;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
  extends a<com.tencent.mm.plugin.appbrand.page.ah>
{
  private static final b qeP;
  
  static
  {
    AppMethodBeat.i(279700);
    qeP = new b();
    AppMethodBeat.o(279700);
  }
  
  public d()
  {
    super(w.qfD.ordinal());
    AppMethodBeat.i(47623);
    AppMethodBeat.o(47623);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(269642);
      qeR = new a("HIDDEN", 0);
      qeS = new a("SHOW_CLICKABLE", 1);
      qeT = new a("SHOW_UNCLICKABLE", 2);
      qeU = new a[] { qeR, qeS, qeT };
      AppMethodBeat.o(269642);
    }
    
    private a() {}
  }
  
  public static final class b
    implements com.tencent.mm.plugin.appbrand.jsapi.ah
  {
    public String appId = "";
    public String qeV = "";
    
    public final void agV(String paramString)
    {
      int i = 1;
      AppMethodBeat.i(257694);
      Log.i("MicroMsg.MenuDelegate_CopyPath", "onReturnUrl %s", new Object[] { paramString });
      String str1 = this.appId;
      String str2 = this.qeV;
      long l = Util.nowSecond();
      if (paramString.isEmpty()) {
        i = 2;
      }
      j.a(str1, str2, 26, "", l, i, 0);
      paramString = db.oyi;
      db.b(ac.osQ, this);
      AppMethodBeat.o(257694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d
 * JD-Core Version:    0.7.0.1
 */