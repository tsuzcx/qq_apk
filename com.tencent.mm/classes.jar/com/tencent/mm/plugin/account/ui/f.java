package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f jlG = null;
  public String account = null;
  public String jcu = null;
  public byte[] jcv = null;
  public String jcw = null;
  public String jcx = null;
  public String jlE = null;
  public int jlF = 0;
  
  public static void a(f paramf)
  {
    jlG = paramf;
  }
  
  public static String aTY()
  {
    if (jlG != null) {
      return jlG.account;
    }
    return null;
  }
  
  public static String aTZ()
  {
    if (jlG != null) {
      return jlG.jcu;
    }
    return null;
  }
  
  public final void aSv()
  {
    AppMethodBeat.i(128184);
    if (!bt.isNullOrNil(this.jlE))
    {
      locals = new s(this.account, this.jlE, this.Jif.getSecCodeType(), "", "", "", 0, "", false, true);
      g.aiU().a(locals, 0);
      AppMethodBeat.o(128184);
      return;
    }
    s locals = new s(this.account, this.jcu, this.Jif.getSecCodeType(), "", "", "", 0, "", false, false);
    g.aiU().a(locals, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */