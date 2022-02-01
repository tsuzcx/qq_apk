package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.emotion.f;

public final class b
{
  public String ghC;
  public com.tencent.mm.storagebase.h ghG = null;
  private ae mZG;
  private bj mZH;
  private com.tencent.mm.plugin.messenger.foundation.a.a.h mZI;
  private bk mZJ;
  private com.tencent.mm.av.g mZK;
  private f mZL;
  public com.tencent.mm.plugin.messenger.foundation.a.a.k mZM;
  private t mZN;
  private aj mZO;
  public l mZP;
  public j mZQ;
  private d mZR;
  com.tencent.mm.plugin.messenger.foundation.a.a.c mZS;
  public int uin = 0;
  
  public final t aJy()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZN;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String aKv()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ghC + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final ae agA()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZG;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final bj awB()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZH;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h awD()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZI;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final bk awG()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZJ;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final aj awK()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZO;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String awN()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ghC + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final com.tencent.mm.av.g bEM()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZK;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f bEN()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZL;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d bEO()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZR;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    ac.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), bs.eWi() });
    this.uin = paramInt;
    this.ghC = paramString;
    com.tencent.mm.model.az.ayM();
    this.ghG = com.tencent.mm.model.c.agw();
    com.tencent.mm.model.az.ayM();
    this.mZG = com.tencent.mm.model.c.agA();
    com.tencent.mm.model.az.ayM();
    this.mZH = com.tencent.mm.model.c.awB();
    com.tencent.mm.model.az.ayM();
    this.mZJ = com.tencent.mm.model.c.awG();
    com.tencent.mm.model.az.ayM();
    this.mZI = com.tencent.mm.model.c.awD();
    com.tencent.mm.model.az.ayM();
    this.mZM = com.tencent.mm.model.c.awJ();
    this.mZK = com.tencent.mm.av.o.aFx();
    this.mZL = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ;
    this.mZO = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK();
    this.mZN = com.tencent.mm.modelvideo.o.aJy();
    this.mZP = a.dnz();
    this.mZQ = a.dny();
    this.mZR = a.bEO();
    com.tencent.mm.model.az.ayM();
    this.mZS = com.tencent.mm.model.c.axd();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */