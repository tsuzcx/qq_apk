package com.tencent.mm.plugin.account.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f gEM = null;
  public String account = null;
  public String gEK = null;
  public int gEL = 0;
  public String gwh = null;
  public byte[] gwi = null;
  public String gwj = null;
  public String gwk = null;
  
  public static void a(f paramf)
  {
    gEM = paramf;
  }
  
  public static String arv()
  {
    if (gEM != null) {
      return gEM.account;
    }
    return null;
  }
  
  public static String arw()
  {
    if (gEM != null) {
      return gEM.gwh;
    }
    return null;
  }
  
  public final void apW()
  {
    AppMethodBeat.i(125006);
    if (!bo.isNullOrNil(this.gEK))
    {
      locals = new s(this.account, this.gEK, this.zgW.getSecCodeType(), "", "", "", 0, "", false, true);
      g.Rc().a(locals, 0);
      AppMethodBeat.o(125006);
      return;
    }
    s locals = new s(this.account, this.gwh, this.zgW.getSecCodeType(), "", "", "", 0, "", false, false);
    g.Rc().a(locals, 0);
    AppMethodBeat.o(125006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */