package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ck;
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
  String hqG;
  public h hqK = null;
  com.tencent.mm.storage.emotion.f oQA;
  public com.tencent.mm.plugin.messenger.foundation.a.a.l oQB;
  t oQC;
  ap oQD;
  public com.tencent.mm.pluginsdk.model.app.l oQE;
  public j oQF;
  d oQG;
  ao oQv;
  bv oQw;
  com.tencent.mm.plugin.messenger.foundation.a.a.i oQx;
  bw oQy;
  com.tencent.mm.av.i oQz;
  ck oTh;
  g oTi = null;
  Boolean oTj = null;
  public int uin = 0;
  
  public final bv aSN()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQw;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQx;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final bw aST()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQy;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final ap aSX()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQD;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String aTa()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hqG + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String aTd()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hqG + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final ao azQ()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQv;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final t bhj()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQC;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String bij()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.hqG + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final com.tencent.mm.av.i cgM()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQz;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final com.tencent.mm.storage.emotion.f cgN()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQA;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d cgO()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.oQG;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void chE()
  {
    AppMethodBeat.i(22094);
    Log.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.oTj, this.hqK, this.oTi, Util.getStack() });
    if ((this.oTj != null) && (!this.oTj.booleanValue()))
    {
      this.oTj = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.hqK != null)
    {
      Log.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.hqK });
      this.hqK.closeDB();
      this.hqK = null;
    }
    if (this.oTi != null)
    {
      this.oTi.closeDB();
      this.oTi = null;
    }
    this.oTj = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */