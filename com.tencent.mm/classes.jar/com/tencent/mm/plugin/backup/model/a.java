package com.tencent.mm.plugin.backup.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class a
  implements be
{
  private static a vik;
  private IListener vil;
  private IListener vim;
  private IListener vin;
  private IListener vio;
  private cl.a vip;
  private cl.a viq;
  private IListener vir;
  
  public a()
  {
    AppMethodBeat.i(22155);
    this.vil = new BackupCore.1(this, f.hfK);
    this.vim = new BackupCore.2(this, f.hfK);
    this.vin = new BackupCore.3(this, f.hfK);
    this.vio = new BackupCore.4(this, f.hfK);
    this.vip = new a.1(this);
    this.viq = new a.2(this);
    this.vir = new BackupCore.7(this, f.hfK);
    Log.i("MicroMsg.BackupCore", "BackupCore init");
    AppMethodBeat.o(22155);
  }
  
  public static void reset()
  {
    AppMethodBeat.i(22156);
    if (d.cUQ())
    {
      AppMethodBeat.o(22156);
      return;
    }
    vik = null;
    com.tencent.mm.plugin.backup.b.a.cUD();
    d.cUR();
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
    b localb = b.cXA();
    Log.i("MicroMsg.BackupEventListener", "init addListener");
    localb.viy = new BackupEventListener.1(localb, f.hfK);
    localb.viy.alive();
    localb.viz = new BackupEventListener.2(localb, f.hfK);
    localb.viz.alive();
    localb.viA = new BackupEventListener.3(localb, f.hfK);
    localb.viA.alive();
    bh.getSysCmdMsgExtension().a("MMBakChatNotify", this.vip, true);
    bh.getSysCmdMsgExtension().a("ChatSync", this.viq, true);
    this.vil.alive();
    this.vim.alive();
    this.vin.alive();
    this.vio.alive();
    this.vir.alive();
    AppMethodBeat.o(22157);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22158);
    b localb = b.cXA();
    localb.viy.dead();
    localb.viz.dead();
    localb.viA.dead();
    bh.getSysCmdMsgExtension().b("MMBakChatNotify", this.vip, true);
    bh.getSysCmdMsgExtension().b("ChatSync", this.viq, true);
    this.vil.dead();
    this.vim.dead();
    this.vin.dead();
    this.vio.dead();
    this.vir.dead();
    AppMethodBeat.o(22158);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.a
 * JD-Core Version:    0.7.0.1
 */