package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;

public final class b
{
  private String eHR;
  public com.tencent.mm.cg.h eHS = null;
  private z jGm;
  private bd jGn;
  private com.tencent.mm.plugin.messenger.foundation.a.a.h jGo;
  private be jGp;
  private com.tencent.mm.at.g jGq;
  private d jGr;
  public com.tencent.mm.plugin.messenger.foundation.a.a.k jGs;
  private t jGt;
  private ag jGu;
  public com.tencent.mm.pluginsdk.model.app.k jGv;
  public com.tencent.mm.pluginsdk.model.app.i jGw;
  private com.tencent.mm.pluginsdk.model.app.c jGx;
  com.tencent.mm.plugin.messenger.foundation.a.a.c jGy;
  public int uin = 0;
  
  public final z Ru()
  {
    AppMethodBeat.i(17688);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17688);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGm;
    AppMethodBeat.o(17688);
    return localObject;
  }
  
  public final bd YA()
  {
    AppMethodBeat.i(17689);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17689);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGn;
    AppMethodBeat.o(17689);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h YC()
  {
    AppMethodBeat.i(17690);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17690);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGo;
    AppMethodBeat.o(17690);
    return localObject;
  }
  
  public final be YF()
  {
    AppMethodBeat.i(17691);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17691);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGp;
    AppMethodBeat.o(17691);
    return localObject;
  }
  
  public final ag YJ()
  {
    AppMethodBeat.i(17694);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17694);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGu;
    AppMethodBeat.o(17694);
    return localObject;
  }
  
  public final String YM()
  {
    AppMethodBeat.i(17697);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17697);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "voice2/";
    AppMethodBeat.o(17697);
    return localObject;
  }
  
  public final String YP()
  {
    AppMethodBeat.i(17698);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17698);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "emoji/";
    AppMethodBeat.o(17698);
    return localObject;
  }
  
  public final com.tencent.mm.at.g aUH()
  {
    AppMethodBeat.i(17692);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17692);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGq;
    AppMethodBeat.o(17692);
    return localObject;
  }
  
  public final d aUI()
  {
    AppMethodBeat.i(17693);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17693);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGr;
    AppMethodBeat.o(17693);
    return localObject;
  }
  
  public final com.tencent.mm.pluginsdk.model.app.c aUJ()
  {
    AppMethodBeat.i(17699);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17699);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGx;
    AppMethodBeat.o(17699);
    return localObject;
  }
  
  public final t alE()
  {
    AppMethodBeat.i(17695);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17695);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGt;
    AppMethodBeat.o(17695);
    return localObject;
  }
  
  public final String amy()
  {
    AppMethodBeat.i(17696);
    if (this.uin == 0)
    {
      localObject = new com.tencent.mm.model.b();
      AppMethodBeat.o(17696);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "voice/";
    AppMethodBeat.o(17696);
    return localObject;
  }
  
  public final void bH(String paramString, int paramInt)
  {
    AppMethodBeat.i(17687);
    ab.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[] { paramString, Integer.valueOf(paramInt), bo.dtY() });
    this.uin = paramInt;
    this.eHR = paramString;
    aw.aaz();
    this.eHS = com.tencent.mm.model.c.Rq();
    aw.aaz();
    this.jGm = com.tencent.mm.model.c.Ru();
    aw.aaz();
    this.jGn = com.tencent.mm.model.c.YA();
    aw.aaz();
    this.jGp = com.tencent.mm.model.c.YF();
    aw.aaz();
    this.jGo = com.tencent.mm.model.c.YC();
    aw.aaz();
    this.jGs = com.tencent.mm.model.c.YI();
    this.jGq = com.tencent.mm.at.o.ahC();
    this.jGr = com.tencent.mm.plugin.emoji.model.i.getEmojiStorageMgr().yNn;
    this.jGu = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.chatroom.a.c.class)).YJ();
    this.jGt = com.tencent.mm.modelvideo.o.alE();
    this.jGv = a.cad();
    this.jGw = a.cac();
    this.jGx = a.aUJ();
    aw.aaz();
    this.jGy = com.tencent.mm.model.c.Zc();
    AppMethodBeat.o(17687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.b
 * JD-Core Version:    0.7.0.1
 */