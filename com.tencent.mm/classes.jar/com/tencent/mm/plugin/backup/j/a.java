package com.tencent.mm.plugin.backup.j;

import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public class a
  implements ar
{
  private static a hRq;
  private c hRr = new a.1(this);
  private c hRs = new a.2(this);
  private c hRt = new a.3(this);
  private c hRu = new a.4(this);
  private bx.a hRv = new a.5(this);
  private bx.a hRw = new a.6(this);
  
  public a()
  {
    y.i("MicroMsg.BackupCore", "BackupCore init");
  }
  
  public static void reset()
  {
    if (d.atu()) {
      return;
    }
    hRq = null;
    com.tencent.mm.plugin.backup.b.a.ath();
    d.atv();
  }
  
  public final void bh(boolean paramBoolean)
  {
    b localb = b.avW();
    y.i("MicroMsg.BackupEventListener", "init addListener");
    localb.hRC = new b.1(localb);
    com.tencent.mm.sdk.b.a.udP.c(localb.hRC);
    localb.hRD = new b.2(localb);
    com.tencent.mm.sdk.b.a.udP.c(localb.hRD);
    localb.fAU = new b.3(localb);
    com.tencent.mm.sdk.b.a.udP.c(localb.fAU);
    au.getSysCmdMsgExtension().a("MMBakChatNotify", this.hRv, true);
    au.getSysCmdMsgExtension().a("ChatSync", this.hRw, true);
    com.tencent.mm.sdk.b.a.udP.b(this.hRr);
    com.tencent.mm.sdk.b.a.udP.b(this.hRs);
    com.tencent.mm.sdk.b.a.udP.b(this.hRt);
    com.tencent.mm.sdk.b.a.udP.b(this.hRu);
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    b localb = b.avW();
    com.tencent.mm.sdk.b.a.udP.d(localb.hRC);
    com.tencent.mm.sdk.b.a.udP.d(localb.hRD);
    com.tencent.mm.sdk.b.a.udP.d(localb.fAU);
    au.getSysCmdMsgExtension().b("MMBakChatNotify", this.hRv, true);
    au.getSysCmdMsgExtension().b("ChatSync", this.hRw, true);
    com.tencent.mm.sdk.b.a.udP.d(this.hRr);
    com.tencent.mm.sdk.b.a.udP.d(this.hRs);
    com.tencent.mm.sdk.b.a.udP.d(this.hRt);
    com.tencent.mm.sdk.b.a.udP.d(this.hRu);
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */