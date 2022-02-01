package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f qbp = null;
  public String account = null;
  public String pRA = null;
  public String pRx = null;
  public byte[] pRy = null;
  public String pRz = null;
  public String qbn = null;
  public int qbo = 0;
  
  public static void a(f paramf)
  {
    qbp = paramf;
  }
  
  public static String bYd()
  {
    if (qbp != null) {
      return qbp.account;
    }
    return null;
  }
  
  public static String bYe()
  {
    if (qbp != null) {
      return qbp.pRx;
    }
    return null;
  }
  
  public final void bWF()
  {
    AppMethodBeat.i(128184);
    if (!Util.isNullOrNil(this.qbn))
    {
      localu = new u(this.account, this.qbn, this.adNR.getSecCodeType(), "", "", "", 0, "", false, true);
      h.aZW().a(localu, 0);
      AppMethodBeat.o(128184);
      return;
    }
    u localu = new u(this.account, this.pRx, this.adNR.getSecCodeType(), "", "", "", 0, "", false, false);
    h.aZW().a(localu, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */