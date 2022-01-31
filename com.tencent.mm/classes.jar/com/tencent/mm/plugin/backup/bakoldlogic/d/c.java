package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.cf.f;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.z;

public final class c
{
  String dKt;
  public h dKu = null;
  z hMK;
  bd hML;
  com.tencent.mm.plugin.messenger.foundation.a.a.g hMM;
  be hMN;
  com.tencent.mm.as.g hMO;
  d hMP;
  public j hMQ;
  t hMR;
  af hMS;
  public k hMT;
  public i hMU;
  com.tencent.mm.pluginsdk.model.app.c hMV;
  bs hPA;
  com.tencent.mm.cf.g hPB = null;
  Boolean hPC = null;
  public int uin = 0;
  
  public final z Dz()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMK;
  }
  
  public final be FB()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMN;
  }
  
  public final String FL()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.dKt + "emoji/";
  }
  
  public final bd Fw()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hML;
  }
  
  public final com.tencent.mm.plugin.messenger.foundation.a.a.g Fy()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMM;
  }
  
  public final t Sr()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMR;
  }
  
  public final void avV()
  {
    y.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", new Object[] { this.hPC, this.dKu, this.hPB, bk.csb() });
    if ((this.hPC != null) && (!this.hPC.booleanValue()))
    {
      this.hPC = null;
      return;
    }
    if (this.dKu != null)
    {
      y.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", new Object[] { this.dKu });
      this.dKu.closeDB();
      this.dKu = null;
    }
    if (this.hPB != null)
    {
      com.tencent.mm.cf.g localg = this.hPB;
      com.tencent.mm.cf.g.uEd = bk.csb().toString();
      if (localg.uDC != null)
      {
        localg.uDC.close();
        localg.uDC = null;
      }
      this.hPB = null;
    }
    this.hPC = null;
  }
  
  public final com.tencent.mm.as.g avf()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMO;
  }
  
  public final d avg()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMP;
  }
  
  public final com.tencent.mm.pluginsdk.model.app.c avh()
  {
    if (this.uin == 0) {
      throw new b();
    }
    return this.hMV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.c
 * JD-Core Version:    0.7.0.1
 */