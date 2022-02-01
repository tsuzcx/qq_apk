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
  private static f ist = null;
  public String account = null;
  public String ije = null;
  public byte[] ijf = null;
  public String ijg = null;
  public String ijh = null;
  public String isr = null;
  public int iss = 0;
  
  public static void a(f paramf)
  {
    ist = paramf;
  }
  
  public static String aJV()
  {
    if (ist != null) {
      return ist.account;
    }
    return null;
  }
  
  public static String aJW()
  {
    if (ist != null) {
      return ist.ije;
    }
    return null;
  }
  
  public final void aIs()
  {
    AppMethodBeat.i(128184);
    if (!bt.isNullOrNil(this.isr))
    {
      locals = new s(this.account, this.isr, this.FUA.getSecCodeType(), "", "", "", 0, "", false, true);
      g.aeS().a(locals, 0);
      AppMethodBeat.o(128184);
      return;
    }
    s locals = new s(this.account, this.ije, this.FUA.getSecCodeType(), "", "", "", 0, "", false, false);
    g.aeS().a(locals, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */