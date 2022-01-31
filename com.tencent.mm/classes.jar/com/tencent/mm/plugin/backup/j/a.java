package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class a
  implements at
{
  private static a jKR;
  private c jKS;
  private c jKT;
  private c jKU;
  private c jKV;
  private bz.a jKW;
  private bz.a jKX;
  
  public a()
  {
    AppMethodBeat.i(18097);
    this.jKS = new a.1(this);
    this.jKT = new a.2(this);
    this.jKU = new a.3(this);
    this.jKV = new a.4(this);
    this.jKW = new a.5(this);
    this.jKX = new a.6(this);
    ab.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(18097);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(18098);
    if (d.aSS())
    {
      AppMethodBeat.o(18098);
      return;
    }
    jKR = null;
    com.tencent.mm.plugin.backup.b.a.aSF();
    d.aST();
    AppMethodBeat.o(18098);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(18099);
    b localb = b.aVz();
    ab.i("MicroMsg.BackupEventListener", "init addListener");
    localb.jLd = new b.1(localb);
    com.tencent.mm.sdk.b.a.ymk.c(localb.jLd);
    localb.jLe = new b.2(localb);
    com.tencent.mm.sdk.b.a.ymk.c(localb.jLe);
    localb.gSJ = new b.3(localb);
    com.tencent.mm.sdk.b.a.ymk.c(localb.gSJ);
    aw.getSysCmdMsgExtension().a("MMBakChatNotify", this.jKW, true);
    aw.getSysCmdMsgExtension().a("ChatSync", this.jKX, true);
    com.tencent.mm.sdk.b.a.ymk.b(this.jKS);
    com.tencent.mm.sdk.b.a.ymk.b(this.jKT);
    com.tencent.mm.sdk.b.a.ymk.b(this.jKU);
    com.tencent.mm.sdk.b.a.ymk.b(this.jKV);
    AppMethodBeat.o(18099);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(18100);
    b localb = b.aVz();
    com.tencent.mm.sdk.b.a.ymk.d(localb.jLd);
    com.tencent.mm.sdk.b.a.ymk.d(localb.jLe);
    com.tencent.mm.sdk.b.a.ymk.d(localb.gSJ);
    aw.getSysCmdMsgExtension().b("MMBakChatNotify", this.jKW, true);
    aw.getSysCmdMsgExtension().b("ChatSync", this.jKX, true);
    com.tencent.mm.sdk.b.a.ymk.d(this.jKS);
    com.tencent.mm.sdk.b.a.ymk.d(this.jKT);
    com.tencent.mm.sdk.b.a.ymk.d(this.jKU);
    com.tencent.mm.sdk.b.a.ymk.d(this.jKV);
    AppMethodBeat.o(18100);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */