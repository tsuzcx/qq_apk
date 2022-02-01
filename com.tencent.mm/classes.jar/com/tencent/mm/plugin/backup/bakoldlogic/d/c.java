package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.a;

public final class c
{
  String kcB;
  public h kcF = null;
  aq rSA;
  public com.tencent.mm.pluginsdk.model.app.l rSB;
  public j rSC;
  d rSD;
  ao rSs;
  bv rSt;
  com.tencent.mm.plugin.messenger.foundation.a.a.i rSu;
  bw rSv;
  com.tencent.mm.ay.i rSw;
  f rSx;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l rSy;
  x rSz;
  cl rVf;
  g rVg = null;
  Boolean rVh = null;
  public int uin = 0;
  
  public final ao aHp()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSs;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final bv bbL()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSt;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i bbO()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSu;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final bw bbR()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSv;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final aq bbV()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSA;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String bbY()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.kcB + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String bcb()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.kcB + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final x bqB()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSz;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String brH()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.kcB + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final com.tencent.mm.ay.i ctX()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSw;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final f ctY()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSx;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d ctZ()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.rSD;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void cuP()
  {
    AppMethodBeat.i(22094);
    Log.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.rVh, this.kcF, this.rVg, Util.getStack() });
    if ((this.rVh != null) && (!this.rVh.booleanValue()))
    {
      this.rVh = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.kcF != null)
    {
      Log.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.kcF });
      this.kcF.closeDB();
      this.kcF = null;
    }
    if (this.rVg != null)
    {
      AppMethodBeat.o(22094);
      throw null;
    }
    this.rVh = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */