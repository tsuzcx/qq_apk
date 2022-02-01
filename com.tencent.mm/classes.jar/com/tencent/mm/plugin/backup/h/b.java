package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.emotion.f;

public final class b
{
  public String kcB;
  public com.tencent.mm.storagebase.h kcF = null;
  private aq rSA;
  public com.tencent.mm.pluginsdk.model.app.l rSB;
  public j rSC;
  private d rSD;
  com.tencent.mm.plugin.messenger.foundation.a.a.c rSE;
  private ao rSs;
  private bv rSt;
  private com.tencent.mm.plugin.messenger.foundation.a.a.i rSu;
  private bw rSv;
  private com.tencent.mm.ay.i rSw;
  private f rSx;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l rSy;
  private x rSz;
  public int uin = 0;
  
  public final ao aHp()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSs;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final bv bbL()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSt;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i bbO()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSu;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final bw bbR()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSv;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final aq bbV()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSA;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String bbY()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.kcB + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final x bqB()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSz;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String brH()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.kcB + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final void cS(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    Log.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), Util.getStack() });
    this.uin = paramInt;
    this.kcB = paramString;
    bh.beI();
    this.kcF = com.tencent.mm.model.c.getDataDB();
    bh.beI();
    this.rSs = com.tencent.mm.model.c.aHp();
    bh.beI();
    this.rSt = com.tencent.mm.model.c.bbL();
    bh.beI();
    this.rSv = com.tencent.mm.model.c.bbR();
    bh.beI();
    this.rSu = com.tencent.mm.model.c.bbO();
    bh.beI();
    this.rSy = com.tencent.mm.model.c.bbU();
    this.rSw = q.bmh();
    this.rSx = p.getEmojiStorageMgr().VFH;
    this.rSA = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    this.rSz = s.bqB();
    this.rSB = a.fmA();
    this.rSC = a.fmz();
    this.rSD = a.ctZ();
    bh.beI();
    this.rSE = com.tencent.mm.model.c.bco();
    AppMethodBeat.o(21745);
  }
  
  public final com.tencent.mm.ay.i ctX()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSw;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f ctY()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSx;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d ctZ()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSD;
    AppMethodBeat.o(21756);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */