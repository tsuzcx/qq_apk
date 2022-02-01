package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class g
  extends SecurityImage.b
{
  private static g neC = null;
  public String account = null;
  public String mUQ = null;
  public byte[] mUR = null;
  public String mUS = null;
  public String mUT = null;
  public String neA = null;
  public int neB = 0;
  
  public static void a(g paramg)
  {
    neC = paramg;
  }
  
  public static String bzw()
  {
    if (neC != null) {
      return neC.account;
    }
    return null;
  }
  
  public static String bzx()
  {
    if (neC != null) {
      return neC.mUQ;
    }
    return null;
  }
  
  public final void bxQ()
  {
    AppMethodBeat.i(128184);
    if (!Util.isNullOrNil(this.neA))
    {
      localt = new com.tencent.mm.modelsimple.t(this.account, this.neA, this.WgV.getSecCodeType(), "", "", "", 0, "", false, true);
      h.aGY().a(localt, 0);
      AppMethodBeat.o(128184);
      return;
    }
    com.tencent.mm.modelsimple.t localt = new com.tencent.mm.modelsimple.t(this.account, this.mUQ, this.WgV.getSecCodeType(), "", "", "", 0, "", false, false);
    h.aGY().a(localt, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g
 * JD-Core Version:    0.7.0.1
 */