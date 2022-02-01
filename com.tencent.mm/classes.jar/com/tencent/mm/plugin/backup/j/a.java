package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.g.a.mb.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements ax
{
  private static a nEE;
  private c nEF;
  private c nEG;
  private c nEH;
  private c nEI;
  private cd.a nEJ;
  private cd.a nEK;
  private c nEL;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.nEF = new a.1(this);
    this.nEG = new a.2(this);
    this.nEH = new c() {};
    this.nEI = new c() {};
    this.nEJ = new a.5(this);
    this.nEK = new a.6(this);
    this.nEL = new a.7(this);
    ad.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.bHe())
    {
      AppMethodBeat.o(22156);
      return;
    }
    nEE = null;
    com.tencent.mm.plugin.backup.b.a.bGR();
    d.bHf();
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
    b localb = b.bJO();
    ad.i("MicroMsg.BackupEventListener", "init addListener");
    localb.nES = new b.1(localb);
    com.tencent.mm.sdk.b.a.IbL.c(localb.nES);
    localb.nET = new b.2(localb);
    com.tencent.mm.sdk.b.a.IbL.c(localb.nET);
    localb.nEU = new b.3(localb);
    com.tencent.mm.sdk.b.a.IbL.c(localb.nEU);
    ba.getSysCmdMsgExtension().a("MMBakChatNotify", this.nEJ, true);
    ba.getSysCmdMsgExtension().a("ChatSync", this.nEK, true);
    com.tencent.mm.sdk.b.a.IbL.b(this.nEF);
    com.tencent.mm.sdk.b.a.IbL.b(this.nEG);
    com.tencent.mm.sdk.b.a.IbL.b(this.nEH);
    com.tencent.mm.sdk.b.a.IbL.b(this.nEI);
    com.tencent.mm.sdk.b.a.IbL.b(this.nEL);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.bJO();
    com.tencent.mm.sdk.b.a.IbL.d(localb.nES);
    com.tencent.mm.sdk.b.a.IbL.d(localb.nET);
    com.tencent.mm.sdk.b.a.IbL.d(localb.nEU);
    ba.getSysCmdMsgExtension().b("MMBakChatNotify", this.nEJ, true);
    ba.getSysCmdMsgExtension().b("ChatSync", this.nEK, true);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEF);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEG);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEH);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEI);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEL);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */