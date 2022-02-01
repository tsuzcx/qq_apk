package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.openapi.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.emotion.f;

public final class b
{
  public String mCJ;
  public com.tencent.mm.storagebase.h mCN = null;
  private bx psc;
  public int uin = 0;
  private aq vdI;
  private i vdJ;
  private by vdK;
  private com.tencent.mm.modelimage.j vdL;
  private f vdM;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l vdN;
  private aa vdO;
  private ar vdP;
  public com.tencent.mm.pluginsdk.model.app.l vdQ;
  public com.tencent.mm.pluginsdk.model.app.j vdR;
  private d vdS;
  com.tencent.mm.plugin.messenger.foundation.a.a.c vdT;
  
  public final aa bOh()
  {
    AppMethodBeat.i(21753);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21753);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdO;
    AppMethodBeat.o(21753);
    return localObject;
  }
  
  public final String bPn()
  {
    AppMethodBeat.i(21754);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21754);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mCJ + "voice/";
    AppMethodBeat.o(21754);
    return localObject;
  }
  
  public final aq ban()
  {
    AppMethodBeat.i(21746);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21746);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdI;
    AppMethodBeat.o(21746);
    return localObject;
  }
  
  public final bx bzA()
  {
    AppMethodBeat.i(21747);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21747);
      throw ((Throwable)localObject);
    }
    Object localObject = this.psc;
    AppMethodBeat.o(21747);
    return localObject;
  }
  
  public final i bzD()
  {
    AppMethodBeat.i(21748);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21748);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdJ;
    AppMethodBeat.o(21748);
    return localObject;
  }
  
  public final by bzG()
  {
    AppMethodBeat.i(21749);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21749);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdK;
    AppMethodBeat.o(21749);
    return localObject;
  }
  
  public final ar bzK()
  {
    AppMethodBeat.i(21752);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21752);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdP;
    AppMethodBeat.o(21752);
    return localObject;
  }
  
  public final String bzN()
  {
    AppMethodBeat.i(21755);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21755);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mCJ + "voice2/";
    AppMethodBeat.o(21755);
    return localObject;
  }
  
  public final com.tencent.mm.modelimage.j cWH()
  {
    AppMethodBeat.i(21750);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21750);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdL;
    AppMethodBeat.o(21750);
    return localObject;
  }
  
  public final f cWI()
  {
    AppMethodBeat.i(21751);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21751);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdM;
    AppMethodBeat.o(21751);
    return localObject;
  }
  
  public final d cWJ()
  {
    AppMethodBeat.i(21756);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(21756);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdS;
    AppMethodBeat.o(21756);
    return localObject;
  }
  
  public final void du(String paramString, int paramInt)
  {
    AppMethodBeat.i(21745);
    Log.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), Util.getStack() });
    this.uin = paramInt;
    this.mCJ = paramString;
    bh.bCz();
    this.mCN = com.tencent.mm.model.c.getDataDB();
    bh.bCz();
    this.vdI = com.tencent.mm.model.c.ban();
    bh.bCz();
    this.psc = com.tencent.mm.model.c.bzA();
    bh.bCz();
    this.vdK = com.tencent.mm.model.c.bzG();
    bh.bCz();
    this.vdJ = com.tencent.mm.model.c.bzD();
    bh.bCz();
    this.vdN = com.tencent.mm.model.c.bzJ();
    this.vdL = r.bKa();
    this.vdM = s.getEmojiStorageMgr().adju;
    this.vdP = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    this.vdO = v.bOh();
    this.vdQ = a.gxo();
    this.vdR = a.gxn();
    this.vdS = a.cWJ();
    bh.bCz();
    this.vdT = com.tencent.mm.model.c.bAd();
    AppMethodBeat.o(21745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */