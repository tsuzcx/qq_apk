package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c
{
  String gBm;
  public h gBq = null;
  ai nAd;
  bp nAe;
  com.tencent.mm.plugin.messenger.foundation.a.a.i nAf;
  bq nAg;
  com.tencent.mm.aw.i nAh;
  com.tencent.mm.storage.emotion.f nAi;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l nAj;
  t nAk;
  ak nAl;
  public com.tencent.mm.pluginsdk.model.app.l nAm;
  public j nAn;
  d nAo;
  cc nCQ;
  g nCR = null;
  Boolean nCS = null;
  public int uin = 0;
  
  public final t aMJ()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAk;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String aNE()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gBm + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final ai ajl()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAd;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final String azC()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gBm + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String azF()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gBm + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final bp azp()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAe;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i azs()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAf;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final bq azv()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAg;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final ak azz()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAl;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final com.tencent.mm.aw.i bIV()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAh;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final com.tencent.mm.storage.emotion.f bIW()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAi;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d bIX()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.nAo;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void bJN()
  {
    AppMethodBeat.i(22094);
    ad.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.nCS, this.gBq, this.nCR, bt.flS() });
    if ((this.nCS != null) && (!this.nCS.booleanValue()))
    {
      this.nCS = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.gBq != null)
    {
      ad.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.gBq });
      this.gBq.closeDB();
      this.gBq = null;
    }
    if (this.nCR != null)
    {
      this.nCR.closeDB();
      this.nCR = null;
    }
    this.nCS = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */