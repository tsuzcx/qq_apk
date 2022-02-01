package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.emotion.f;

public final class c
{
  String ghC;
  public com.tencent.mm.storagebase.h ghG = null;
  ae mZG;
  bj mZH;
  com.tencent.mm.plugin.messenger.foundation.a.a.h mZI;
  bk mZJ;
  com.tencent.mm.av.g mZK;
  f mZL;
  public k mZM;
  t mZN;
  aj mZO;
  public l mZP;
  public j mZQ;
  d mZR;
  bw nct;
  com.tencent.mm.storagebase.g ncu = null;
  Boolean ncv = null;
  public int uin = 0;
  
  public final t aJy()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZN;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String aKv()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ghC + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final ae agA()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZG;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final bj awB()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZH;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h awD()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZI;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final bk awG()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZJ;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final aj awK()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZO;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String awN()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ghC + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String awQ()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.ghC + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final com.tencent.mm.av.g bEM()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZK;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final f bEN()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZL;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d bEO()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mZR;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void bFD()
  {
    AppMethodBeat.i(22094);
    ac.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.ncv, this.ghG, this.ncu, bs.eWi() });
    if ((this.ncv != null) && (!this.ncv.booleanValue()))
    {
      this.ncv = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.ghG != null)
    {
      ac.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.ghG });
      this.ghG.closeDB();
      this.ghG = null;
    }
    if (this.ncu != null)
    {
      this.ncu.closeDB();
      this.ncu = null;
    }
    this.ncv = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */