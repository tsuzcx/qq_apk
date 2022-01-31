package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;

public final class c
{
  String eHR;
  public com.tencent.mm.cg.h eHS = null;
  z jGm;
  bd jGn;
  com.tencent.mm.plugin.messenger.foundation.a.a.h jGo;
  be jGp;
  com.tencent.mm.at.g jGq;
  d jGr;
  public com.tencent.mm.plugin.messenger.foundation.a.a.k jGs;
  t jGt;
  ag jGu;
  public com.tencent.mm.pluginsdk.model.app.k jGv;
  public i jGw;
  com.tencent.mm.pluginsdk.model.app.c jGx;
  bs jJc;
  com.tencent.mm.cg.g jJd = null;
  Boolean jJe = null;
  public int uin = 0;
  
  public final z Ru()
  {
    AppMethodBeat.i(18025);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18025);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGm;
    AppMethodBeat.o(18025);
    return localObject;
  }
  
  public final bd YA()
  {
    AppMethodBeat.i(18026);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18026);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGn;
    AppMethodBeat.o(18026);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.h YC()
  {
    AppMethodBeat.i(18027);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18027);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGo;
    AppMethodBeat.o(18027);
    return localObject;
  }
  
  public final be YF()
  {
    AppMethodBeat.i(18028);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18028);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGp;
    AppMethodBeat.o(18028);
    return localObject;
  }
  
  public final ag YJ()
  {
    AppMethodBeat.i(18031);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18031);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGu;
    AppMethodBeat.o(18031);
    return localObject;
  }
  
  public final String YM()
  {
    AppMethodBeat.i(18034);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18034);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "voice2/";
    AppMethodBeat.o(18034);
    return localObject;
  }
  
  public final String YP()
  {
    AppMethodBeat.i(18035);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18035);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "emoji/";
    AppMethodBeat.o(18035);
    return localObject;
  }
  
  public final com.tencent.mm.at.g aUH()
  {
    AppMethodBeat.i(18029);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18029);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGq;
    AppMethodBeat.o(18029);
    return localObject;
  }
  
  public final d aUI()
  {
    AppMethodBeat.i(18030);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18030);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGr;
    AppMethodBeat.o(18030);
    return localObject;
  }
  
  public final com.tencent.mm.pluginsdk.model.app.c aUJ()
  {
    AppMethodBeat.i(18036);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18036);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGx;
    AppMethodBeat.o(18036);
    return localObject;
  }
  
  public final void aVy()
  {
    AppMethodBeat.i(18037);
    ab.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.jJe, this.eHS, this.jJd, bo.dtY() });
    if ((this.jJe != null) && (!this.jJe.booleanValue()))
    {
      this.jJe = null;
      AppMethodBeat.o(18037);
      return;
    }
    if (this.eHS != null)
    {
      ab.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.eHS });
      this.eHS.closeDB();
      this.eHS = null;
    }
    if (this.jJd != null)
    {
      this.jJd.closeDB();
      this.jJd = null;
    }
    this.jJe = null;
    AppMethodBeat.o(18037);
  }
  
  public final t alE()
  {
    AppMethodBeat.i(18032);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18032);
      throw ((Throwable)localObject);
    }
    Object localObject = this.jGt;
    AppMethodBeat.o(18032);
    return localObject;
  }
  
  public final String amy()
  {
    AppMethodBeat.i(18033);
    if (this.uin == 0)
    {
      localObject = new b();
      AppMethodBeat.o(18033);
      throw ((Throwable)localObject);
    }
    Object localObject = this.eHR + "voice/";
    AppMethodBeat.o(18033);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */