package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f iSy = null;
  public String account = null;
  public String iJl = null;
  public byte[] iJm = null;
  public String iJn = null;
  public String iJo = null;
  public String iSw = null;
  public int iSx = 0;
  
  public static void a(f paramf)
  {
    iSy = paramf;
  }
  
  public static String aQM()
  {
    if (iSy != null) {
      return iSy.account;
    }
    return null;
  }
  
  public static String aQN()
  {
    if (iSy != null) {
      return iSy.iJl;
    }
    return null;
  }
  
  public final void aPj()
  {
    AppMethodBeat.i(128184);
    if (!bs.isNullOrNil(this.iSw))
    {
      locals = new s(this.account, this.iSw, this.Hup.getSecCodeType(), "", "", "", 0, "", false, true);
      g.agi().a(locals, 0);
      AppMethodBeat.o(128184);
      return;
    }
    s locals = new s(this.account, this.iJl, this.Hup.getSecCodeType(), "", "", "", 0, "", false, false);
    g.agi().a(locals, 0);
    AppMethodBeat.o(128184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */