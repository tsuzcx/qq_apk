package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public final class f
  extends SecurityImage.b
{
  private static f fnt = null;
  public String account = null;
  public String feA = null;
  public String feB = null;
  public String fey = null;
  public byte[] fez = null;
  public String fnr = null;
  public int fns = 0;
  
  public static String XP()
  {
    if (fnt != null) {
      return fnt.account;
    }
    return null;
  }
  
  public static String XQ()
  {
    if (fnt != null) {
      return fnt.fey;
    }
    return null;
  }
  
  public static void a(f paramf)
  {
    fnt = paramf;
  }
  
  public final void Ws()
  {
    if (!bk.bl(this.fnr))
    {
      localq = new q(this.account, this.fnr, this.uSv.getSecCodeType(), "", "", "", 0, "", false, true);
      g.Dk().a(localq, 0);
      return;
    }
    q localq = new q(this.account, this.fey, this.uSv.getSecCodeType(), "", "", "", 0, "", false, false);
    g.Dk().a(localq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.f
 * JD-Core Version:    0.7.0.1
 */