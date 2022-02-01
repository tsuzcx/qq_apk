package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.h;

public final class b
{
  public String gBm;
  public h gBq = null;
  private ai nAd;
  private bp nAe;
  private com.tencent.mm.plugin.messenger.foundation.a.a.i nAf;
  private bq nAg;
  private com.tencent.mm.aw.i nAh;
  private f nAi;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l nAj;
  private t nAk;
  private ak nAl;
  public com.tencent.mm.pluginsdk.model.app.l nAm;
  public j nAn;
  private d nAo;
  com.tencent.mm.plugin.messenger.foundation.a.a.c nAp;
  public int uin = 0;
  
  public final t aMJ()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAk;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String aNE()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gBm + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final ai ajl()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAd;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final String azC()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gBm + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final bp azp()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAe;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i azs()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAf;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final bq azv()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAg;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final ak azz()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAl;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final com.tencent.mm.aw.i bIV()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAh;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f bIW()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAi;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d bIX()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAo;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void cm(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    ad.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), bt.flS() });
    this.uin = paramInt;
    this.gBm = paramString;
    ba.aBQ();
    this.gBq = com.tencent.mm.model.c.getDataDB();
    ba.aBQ();
    this.nAd = com.tencent.mm.model.c.ajl();
    ba.aBQ();
    this.nAe = com.tencent.mm.model.c.azp();
    ba.aBQ();
    this.nAg = com.tencent.mm.model.c.azv();
    ba.aBQ();
    this.nAf = com.tencent.mm.model.c.azs();
    ba.aBQ();
    this.nAj = com.tencent.mm.model.c.azy();
    this.nAh = q.aIF();
    this.nAi = k.getEmojiStorageMgr().ILn;
    this.nAl = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azz();
    this.nAk = o.aMJ();
    this.nAm = a.dxR();
    this.nAn = a.dxQ();
    this.nAo = a.bIX();
    ba.aBQ();
    this.nAp = com.tencent.mm.model.c.azS();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */