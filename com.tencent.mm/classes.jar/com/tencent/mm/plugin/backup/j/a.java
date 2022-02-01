package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements aw
{
  private static a neh;
  private c nei;
  private c nej;
  private c nek;
  private c nel;
  private cc.a nem;
  private cc.a nen;
  private c neo;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.nei = new a.1(this);
    this.nej = new a.2(this);
    this.nek = new c() {};
    this.nel = new a.4(this);
    this.nem = new a.5(this);
    this.nen = new a.6(this);
    this.neo = new a.7(this);
    ac.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.bCW())
    {
      AppMethodBeat.o(22156);
      return;
    }
    neh = null;
    com.tencent.mm.plugin.backup.b.a.bCJ();
    d.bCX();
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
    b localb = b.bFE();
    ac.i("MicroMsg.BackupEventListener", "init addListener");
    localb.jdField_new = new b.1(localb);
    com.tencent.mm.sdk.b.a.GpY.c(localb.jdField_new);
    localb.nex = new b.2(localb);
    com.tencent.mm.sdk.b.a.GpY.c(localb.nex);
    localb.ney = new b.3(localb);
    com.tencent.mm.sdk.b.a.GpY.c(localb.ney);
    az.getSysCmdMsgExtension().a("MMBakChatNotify", this.nem, true);
    az.getSysCmdMsgExtension().a("ChatSync", this.nen, true);
    com.tencent.mm.sdk.b.a.GpY.b(this.nei);
    com.tencent.mm.sdk.b.a.GpY.b(this.nej);
    com.tencent.mm.sdk.b.a.GpY.b(this.nek);
    com.tencent.mm.sdk.b.a.GpY.b(this.nel);
    com.tencent.mm.sdk.b.a.GpY.b(this.neo);
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.bFE();
    com.tencent.mm.sdk.b.a.GpY.d(localb.jdField_new);
    com.tencent.mm.sdk.b.a.GpY.d(localb.nex);
    com.tencent.mm.sdk.b.a.GpY.d(localb.ney);
    az.getSysCmdMsgExtension().b("MMBakChatNotify", this.nem, true);
    az.getSysCmdMsgExtension().b("ChatSync", this.nen, true);
    com.tencent.mm.sdk.b.a.GpY.d(this.nei);
    com.tencent.mm.sdk.b.a.GpY.d(this.nej);
    com.tencent.mm.sdk.b.a.GpY.d(this.nek);
    com.tencent.mm.sdk.b.a.GpY.d(this.nel);
    com.tencent.mm.sdk.b.a.GpY.d(this.neo);
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a
 * JD-Core Version:    0.7.0.1
 */