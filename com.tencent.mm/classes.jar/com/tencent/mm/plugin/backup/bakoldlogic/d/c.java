package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.g.a;
import com.tencent.mm.storagebase.h.a;
import com.tencent.mm.storagebase.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c
{
  String gcW;
  public com.tencent.mm.storagebase.h gda = null;
  com.tencent.mm.storage.bt mAs;
  com.tencent.mm.storagebase.g mAt = null;
  Boolean mAu = null;
  ab mxF;
  bg mxG;
  com.tencent.mm.plugin.messenger.foundation.a.a.h mxH;
  bh mxI;
  com.tencent.mm.aw.g mxJ;
  com.tencent.mm.storage.emotion.f mxK;
  public k mxL;
  t mxM;
  aj mxN;
  public l mxO;
  public j mxP;
  d mxQ;
  public int uin = 0;
  
  public final t aCI()
  {
    AppMethodBeat.i(22089);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22089);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxM;
    AppMethodBeat.o(22089);
    return localObject;
  }
  
  public final String aDE()
  {
    AppMethodBeat.i(22090);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22090);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gcW + "voice/";
    AppMethodBeat.o(22090);
    return localObject;
  }
  
  public final ab afk()
  {
    AppMethodBeat.i(22082);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22082);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxF;
    AppMethodBeat.o(22082);
    return localObject;
  }
  
  public final bg apM()
  {
    AppMethodBeat.i(22083);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22083);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxG;
    AppMethodBeat.o(22083);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h apO()
  {
    AppMethodBeat.i(22084);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22084);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxH;
    AppMethodBeat.o(22084);
    return localObject;
  }
  
  public final bh apR()
  {
    AppMethodBeat.i(22085);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22085);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxI;
    AppMethodBeat.o(22085);
    return localObject;
  }
  
  public final aj apV()
  {
    AppMethodBeat.i(22088);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22088);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxN;
    AppMethodBeat.o(22088);
    return localObject;
  }
  
  public final String apY()
  {
    AppMethodBeat.i(22091);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22091);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gcW + "voice2/";
    AppMethodBeat.o(22091);
    return localObject;
  }
  
  public final String aqb()
  {
    AppMethodBeat.i(22092);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22092);
      throw ((Throwable)localObject);
    }
    Object localObject = this.gcW + "emoji/";
    AppMethodBeat.o(22092);
    return localObject;
  }
  
  public final com.tencent.mm.aw.g bxQ()
  {
    AppMethodBeat.i(22086);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22086);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxJ;
    AppMethodBeat.o(22086);
    return localObject;
  }
  
  public final com.tencent.mm.storage.emotion.f bxR()
  {
    AppMethodBeat.i(22087);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22087);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxK;
    AppMethodBeat.o(22087);
    return localObject;
  }
  
  public final d bxS()
  {
    AppMethodBeat.i(22093);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(22093);
      throw ((Throwable)localObject);
    }
    Object localObject = this.mxQ;
    AppMethodBeat.o(22093);
    return localObject;
  }
  
  public final void byH()
  {
    AppMethodBeat.i(22094);
    ad.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.mAu, this.gda, this.mAt, com.tencent.mm.sdk.platformtools.bt.eGN() });
    if ((this.mAu != null) && (!this.mAu.booleanValue()))
    {
      this.mAu = null;
      AppMethodBeat.o(22094);
      return;
    }
    if (this.gda != null)
    {
      ad.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.gda });
      this.gda.closeDB();
      this.gda = null;
    }
    if (this.mAt != null)
    {
      this.mAt.closeDB();
      this.mAt = null;
    }
    this.mAu = null;
    AppMethodBeat.o(22094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */