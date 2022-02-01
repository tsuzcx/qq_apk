package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.emotion.f;

public final class b
{
  public String gcW;
  public com.tencent.mm.storagebase.h gda = null;
  private ab mxF;
  private bg mxG;
  private com.tencent.mm.plugin.messenger.foundation.a.a.h mxH;
  private bh mxI;
  private com.tencent.mm.aw.g mxJ;
  private f mxK;
  public com.tencent.mm.plugin.messenger.foundation.a.a.k mxL;
  private t mxM;
  private aj mxN;
  public l mxO;
  public j mxP;
  private d mxQ;
  com.tencent.mm.plugin.messenger.foundation.a.a.c mxR;
  public int uin = 0;
  
  public final t aCI()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxM;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String aDE()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gcW + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final ab afk()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxF;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final bg apM()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxG;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h apO()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxH;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final bh apR()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxI;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final aj apV()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxN;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String apY()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gcW + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final com.tencent.mm.aw.g bxQ()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxJ;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f bxR()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxK;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d bxS()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxQ;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void ce(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    ad.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), bt.eGN() });
    this.uin = paramInt;
    this.gcW = paramString;
    az.arV();
    this.gda = com.tencent.mm.model.c.afg();
    az.arV();
    this.mxF = com.tencent.mm.model.c.afk();
    az.arV();
    this.mxG = com.tencent.mm.model.c.apM();
    az.arV();
    this.mxI = com.tencent.mm.model.c.apR();
    az.arV();
    this.mxH = com.tencent.mm.model.c.apO();
    az.arV();
    this.mxL = com.tencent.mm.model.c.apU();
    this.mxJ = com.tencent.mm.aw.o.ayF();
    this.mxK = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY;
    this.mxN = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV();
    this.mxM = com.tencent.mm.modelvideo.o.aCI();
    this.mxO = a.cZR();
    this.mxP = a.cZQ();
    this.mxQ = a.bxS();
    az.arV();
    this.mxR = com.tencent.mm.model.c.aqo();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */