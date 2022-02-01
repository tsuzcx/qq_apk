package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.h;

public final class b
{
  public String hqG;
  public h hqK = null;
  private f oQA;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l oQB;
  private t oQC;
  private ap oQD;
  public com.tencent.mm.pluginsdk.model.app.l oQE;
  public j oQF;
  private d oQG;
  com.tencent.mm.plugin.messenger.foundation.a.a.c oQH;
  private ao oQv;
  private bv oQw;
  private com.tencent.mm.plugin.messenger.foundation.a.a.i oQx;
  private bw oQy;
  private com.tencent.mm.av.i oQz;
  public int uin = 0;
  
  public final bv aSN()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQw;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQx;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final bw aST()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQy;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final ap aSX()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQD;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String aTa()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hqG + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final ao azQ()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQv;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final t bhj()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQC;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String bij()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hqG + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final com.tencent.mm.av.i cgM()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQz;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f cgN()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQA;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d cgO()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQG;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    Log.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), Util.getStack() });
    this.uin = paramInt;
    this.hqG = paramString;
    bg.aVF();
    this.hqK = com.tencent.mm.model.c.getDataDB();
    bg.aVF();
    this.oQv = com.tencent.mm.model.c.azQ();
    bg.aVF();
    this.oQw = com.tencent.mm.model.c.aSN();
    bg.aVF();
    this.oQy = com.tencent.mm.model.c.aST();
    bg.aVF();
    this.oQx = com.tencent.mm.model.c.aSQ();
    bg.aVF();
    this.oQB = com.tencent.mm.model.c.aSW();
    this.oQz = q.bcR();
    this.oQA = k.getEmojiStorageMgr().OpN;
    this.oQD = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    this.oQC = o.bhj();
    this.oQE = a.eAT();
    this.oQF = a.eAS();
    this.oQG = a.cgO();
    bg.aVF();
    this.oQH = com.tencent.mm.model.c.aTq();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */