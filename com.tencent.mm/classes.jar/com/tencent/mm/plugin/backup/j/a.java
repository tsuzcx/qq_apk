package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.mc;
import com.tencent.mm.g.a.mc.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements az
{
  private static a nJZ;
  private c nKa;
  private c nKb;
  private c nKc;
  private c nKd;
  private cf.a nKe;
  private cf.a nKf;
  private c nKg;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.nKa = new a.1(this);
    this.nKb = new a.2(this);
    this.nKc = new c() {};
    this.nKd = new c() {};
    this.nKe = new a.5(this);
    this.nKf = new a.6(this);
    this.nKg = new a.7(this);
    ae.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.bIc())
    {
      AppMethodBeat.o(22156);
      return;
    }
    nJZ = null;
    com.tencent.mm.plugin.backup.b.a.bHP();
    d.bId();
    AppMethodBeat.o(22156);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22157);
    b localb = b.bKM();
    ae.i("MicroMsg.BackupEventListener", "init addListener");
    localb.nKn = new b.1(localb);
    com.tencent.mm.sdk.b.a.IvT.c(localb.nKn);
    localb.nKo = new b.2(localb);
    com.tencent.mm.sdk.b.a.IvT.c(localb.nKo);
    localb.nKp = new b.3(localb);
    com.tencent.mm.sdk.b.a.IvT.c(localb.nKp);
    bc.getSysCmdMsgExtension().a("MMBakChatNotify", this.nKe, true);
    bc.getSysCmdMsgExtension().a("ChatSync", this.nKf, true);
    com.tencent.mm.sdk.b.a.IvT.b(this.nKa);
    com.tencent.mm.sdk.b.a.IvT.b(this.nKb);
    com.tencent.mm.sdk.b.a.IvT.b(this.nKc);
    com.tencent.mm.sdk.b.a.IvT.b(this.nKd);
    com.tencent.mm.sdk.b.a.IvT.b(this.nKg);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.bKM();
    com.tencent.mm.sdk.b.a.IvT.d(localb.nKn);
    com.tencent.mm.sdk.b.a.IvT.d(localb.nKo);
    com.tencent.mm.sdk.b.a.IvT.d(localb.nKp);
    bc.getSysCmdMsgExtension().b("MMBakChatNotify", this.nKe, true);
    bc.getSysCmdMsgExtension().b("ChatSync", this.nKf, true);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKa);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKb);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKc);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKd);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKg);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */