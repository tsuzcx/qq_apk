package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;

public final class c
{
  String gDT;
  public h gDX = null;
  com.tencent.mm.plugin.messenger.foundation.a.a.i nFA;
  br nFB;
  com.tencent.mm.av.i nFC;
  f nFD;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l nFE;
  t nFF;
  al nFG;
  public com.tencent.mm.pluginsdk.model.app.l nFH;
  public j nFI;
  d nFJ;
  aj nFy;
  bq nFz;
  cd nIl;
  g nIm = null;
  Boolean nIn = null;
  public int uin = 0;
  
  public final t aNh()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFF;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String aOc()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gDT + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final aj ajA()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFy;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final bq azF()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFz;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i azI()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFA;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final br azL()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFB;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final al azP()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFG;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String azS()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gDT + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String azV()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gDT + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final com.tencent.mm.av.i bJT()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFC;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final f bJU()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFD;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d bJV()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nFJ;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void bKL()
  {
    AppMethodBeat.i(22094);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.nIn, this.gDX, this.nIm, bu.fpN() });
    if ((this.nIn != null) && (!this.nIn.booleanValue()))
    {
      this.nIn = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.gDX != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.gDX });
      this.gDX.closeDB();
      this.gDX = null;
    }
    if (this.nIm != null)
    {
      this.nIm.closeDB();
      this.nIm = null;
    }
    this.nIn = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */