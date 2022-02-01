package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class g
  extends SecurityImage.b
{
  private static g kmK = null;
  public String account = null;
  public String kdq = null;
  public byte[] kdr = null;
  public String kds = null;
  public String kdt = null;
  public String kmI = null;
  public int kmJ = 0;
  
  public static void a(g paramg)
  {
    kmK = paramg;
  }
  
  public static String bpk()
  {
    if (kmK != null) {
      return kmK.account;
    }
    return null;
  }
  
  public static String bpl()
  {
    if (kmK != null) {
      return kmK.kdq;
    }
    return null;
  }
  
  public final void bnH()
  {
    AppMethodBeat.i(128184);
    if (!Util.isNullOrNil(this.kmI))
    {
      localt = new com.tencent.mm.modelsimple.t(this.account, this.kmI, this.ONI.getSecCodeType(), "", "", "", 0, "", false, true);
      com.tencent.mm.kernel.g.azz().a(localt, 0);
      AppMethodBeat.o(128184);
      return;
    }
    com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.account, this.kdq, this.ONI.getSecCodeType(), "", "", "", 0, "", false, false);
    com.tencent.mm.kernel.g.azz().a(localt, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */