package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.h;

public final class b
{
  public String gDT;
  public h gDX = null;
  private com.tencent.mm.plugin.messenger.foundation.a.a.i nFA;
  private br nFB;
  private com.tencent.mm.av.i nFC;
  private f nFD;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l nFE;
  private t nFF;
  private al nFG;
  public com.tencent.mm.pluginsdk.model.app.l nFH;
  public j nFI;
  private d nFJ;
  com.tencent.mm.plugin.messenger.foundation.a.a.c nFK;
  private aj nFy;
  private bq nFz;
  public int uin = 0;
  
  public final t aNh()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFF;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String aOc()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gDT + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final aj ajA()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFy;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final bq azF()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFz;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i azI()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFA;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final br azL()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFB;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final al azP()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFG;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String azS()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gDT + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final com.tencent.mm.av.i bJT()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFC;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f bJU()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFD;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d bJV()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFJ;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void cq(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    ae.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), bu.fpN() });
    this.uin = paramInt;
    this.gDT = paramString;
    bc.aCg();
    this.gDX = com.tencent.mm.model.c.getDataDB();
    bc.aCg();
    this.nFy = com.tencent.mm.model.c.ajA();
    bc.aCg();
    this.nFz = com.tencent.mm.model.c.azF();
    bc.aCg();
    this.nFB = com.tencent.mm.model.c.azL();
    bc.aCg();
    this.nFA = com.tencent.mm.model.c.azI();
    bc.aCg();
    this.nFE = com.tencent.mm.model.c.azO();
    this.nFC = q.aIX();
    this.nFD = k.getEmojiStorageMgr().JfU;
    this.nFG = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    this.nFF = o.aNh();
    this.nFH = a.dBh();
    this.nFI = a.dBg();
    this.nFJ = a.bJV();
    bc.aCg();
    this.nFK = com.tencent.mm.model.c.aAi();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */