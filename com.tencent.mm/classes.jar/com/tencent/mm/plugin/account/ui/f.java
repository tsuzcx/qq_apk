package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f joA = null;
  public String account = null;
  public String jfn = null;
  public byte[] jfo = null;
  public String jfp = null;
  public String jfq = null;
  public String joy = null;
  public int joz = 0;
  
  public static void a(f paramf)
  {
    joA = paramf;
  }
  
  public static String aUx()
  {
    if (joA != null) {
      return joA.account;
    }
    return null;
  }
  
  public static String aUy()
  {
    if (joA != null) {
      return joA.jfn;
    }
    return null;
  }
  
  public final void aSU()
  {
    AppMethodBeat.i(128184);
    if (!bu.isNullOrNil(this.joy))
    {
      localt = new t(this.account, this.joy, this.JCQ.getSecCodeType(), "", "", "", 0, "", false, true);
      g.ajj().a(localt, 0);
      AppMethodBeat.o(128184);
      return;
    }
    t localt = new t(this.account, this.jfn, this.JCQ.getSecCodeType(), "", "", "", 0, "", false, false);
    g.ajj().a(localt, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */