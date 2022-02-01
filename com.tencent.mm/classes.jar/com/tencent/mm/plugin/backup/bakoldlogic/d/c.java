package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.a;

public final class c
{
  String mCJ;
  public h mCN = null;
  bx psc;
  public int uin = 0;
  aq vdI;
  i vdJ;
  by vdK;
  com.tencent.mm.modelimage.j vdL;
  f vdM;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l vdN;
  aa vdO;
  ar vdP;
  public com.tencent.mm.pluginsdk.model.app.l vdQ;
  public com.tencent.mm.pluginsdk.model.app.j vdR;
  d vdS;
  co vgu;
  g vgv = null;
  Boolean vgw = null;
  
  public final aa bOh()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdO;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String bPn()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mCJ + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final aq ban()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdI;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final bx bzA()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.psc;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final i bzD()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdJ;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final by bzG()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdK;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final ar bzK()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdP;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String bzN()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mCJ + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String bzQ()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mCJ + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final com.tencent.mm.modelimage.j cWH()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdL;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final f cWI()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdM;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d cWJ()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.vdS;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void cXz()
  {
    AppMethodBeat.i(22094);
    Log.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.vgw, this.mCN, this.vgv, Util.getStack() });
    if ((this.vgw != null) && (!this.vgw.booleanValue()))
    {
      this.vgw = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.mCN != null)
    {
      Log.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.mCN });
      this.mCN.closeDB();
      this.mCN = null;
    }
    if (this.vgv != null)
    {
      AppMethodBeat.o(22094);
      throw null;
    }
    this.vgw = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */