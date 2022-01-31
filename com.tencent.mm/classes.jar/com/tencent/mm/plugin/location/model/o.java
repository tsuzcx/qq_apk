package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aah;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.clf;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements f, com.tencent.mm.bh.b
{
  public boolean caV;
  public b.a dZA;
  public com.tencent.mm.modelgeo.d fwu;
  public boolean isStart;
  ak mHandler;
  private String nZT;
  public double nZV;
  public double nZW;
  public int nZX;
  private int obe;
  private int obf;
  public i obg;
  public HashSet<WeakReference<o.b>> obh;
  public int obi;
  public cpm obk;
  public LocationInfo obl;
  public boolean obm;
  public boolean obn;
  public int obo;
  public String obp;
  boolean obq;
  public o.a obr;
  public int obs;
  public boolean obt;
  public long obu;
  long obv;
  public i.a obw;
  private int timestamp;
  
  public o()
  {
    AppMethodBeat.i(113385);
    this.obe = 0;
    this.obf = 1000;
    this.obh = new HashSet();
    this.obi = 1;
    this.obl = new LocationInfo((byte)0);
    this.obm = false;
    this.obn = false;
    this.isStart = false;
    this.obo = this.obi;
    this.obp = "";
    this.caV = false;
    this.obq = false;
    this.obr = null;
    this.obs = -1;
    this.obt = true;
    this.obu = 0L;
    this.obv = 0L;
    this.nZV = -1000.0D;
    this.nZW = -1000.0D;
    this.nZX = -1;
    this.mHandler = new o.1(this, Looper.getMainLooper());
    this.dZA = new o.2(this);
    this.obw = new o.3(this);
    AppMethodBeat.o(113385);
  }
  
  private void bLw()
  {
    AppMethodBeat.i(113390);
    ab.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (bLB())
    {
      ab.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.fwu = com.tencent.mm.modelgeo.d.agQ();
      this.fwu.b(this.dZA, true);
      if (this.obg == null) {
        this.obg = l.bLt();
      }
      this.obg.a(this.obw);
      bLA();
    }
    AppMethodBeat.o(113390);
  }
  
  private void cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(113388);
    ab.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((aah)paramString.rr.fsV.fta).Scene = paramInt;
    g.Rc().a(paramString, 0);
    this.nZT = "";
    AppMethodBeat.o(113388);
  }
  
  public final String alg()
  {
    return this.obp;
  }
  
  public final void bLA()
  {
    boolean bool = true;
    AppMethodBeat.i(113393);
    if ((!this.isStart) || (!this.obm) || (this.obl == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.obm).append(" ");
      if (this.obl == null) {}
      for (;;)
      {
        ab.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(113393);
        return;
        bool = false;
      }
    }
    if ((this.obk == null) || (this.obk.xYw.wyP == -1000.0D) || (this.obk.xYw.wyO == -1000.0D))
    {
      ab.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.obf);
      AppMethodBeat.o(113393);
      return;
    }
    Object localObject2 = r.Zn();
    Object localObject1 = new clf();
    ((clf)localObject1).xyb = this.obl.nZY;
    ((clf)localObject1).wyP = this.obl.nZV;
    ((clf)localObject1).wyO = this.obl.nZW;
    ((clf)localObject1).Name = ((String)localObject2);
    this.obk.Username = ((String)localObject2);
    this.obk.xYw.xBh = l.bLt().bLk();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.nZT + "]");
    switch (this.obi)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.obk.xYw.wyP + " " + this.obk.xYw.wyO + " " + this.obk.xYw.xBh + " ]");
      ab.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.nZT;
      int i = this.obi;
      cpm localcpm = this.obk;
      int j = this.timestamp + 1;
      this.timestamp = j;
      localObject1 = new c((String)localObject2, i, localcpm, j, (clf)localObject1);
      g.Rc().a((m)localObject1, 0);
      AppMethodBeat.o(113393);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((clf)localObject1).wyP + " " + ((clf)localObject1).wyO + " ]");
    }
  }
  
  public final boolean bLB()
  {
    AppMethodBeat.i(113394);
    if (!bo.isNullOrNil(this.nZT))
    {
      AppMethodBeat.o(113394);
      return true;
    }
    AppMethodBeat.o(113394);
    return false;
  }
  
  public final boolean bLv()
  {
    AppMethodBeat.i(113387);
    if ((bLB()) && (this.obm))
    {
      AppMethodBeat.o(113387);
      return true;
    }
    AppMethodBeat.o(113387);
    return false;
  }
  
  public final void bLx()
  {
    AppMethodBeat.i(113391);
    ab.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.obq = false;
    bLw();
    AppMethodBeat.o(113391);
  }
  
  public final List<String> bLy()
  {
    AppMethodBeat.i(113392);
    LinkedList localLinkedList = l.bLs().uN(this.obp);
    AppMethodBeat.o(113392);
    return localLinkedList;
  }
  
  public final void bLz()
  {
    if (this.obi == 1) {
      this.obi = 3;
    }
    while (this.obi != 3) {
      return;
    }
    this.obi = 2;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(113395);
    ab.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramm.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.nZT = ((com.tencent.mm.plugin.location.model.a.b)paramm).nZT;
        l.bLs().Sb(this.nZT);
        if (bLB())
        {
          ab.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.nZT });
          paramString = com.tencent.mm.bh.d.fUO.uN(this.obp);
          paramString.add(r.Zn());
          if (this.obl != null) {
            com.tencent.mm.bh.d.fUO.a(this.obp, paramString, this.obl.nZV, this.obl.nZW, this.obl.nZY, "", "");
          }
          while (this.obh != null)
          {
            paramString = this.obh.iterator();
            while (paramString.hasNext())
            {
              paramm = (WeakReference)paramString.next();
              if ((paramm != null) && (paramm.get() != null)) {
                ((o.b)paramm.get()).bLC();
              }
            }
            com.tencent.mm.bh.d.fUO.a(this.obp, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          bLA();
          AppMethodBeat.o(113395);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.obh != null))
        {
          paramString = this.obh.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((o.b)localWeakReference.get()).bLD();
            }
          }
        }
        if (this.obh != null)
        {
          paramString = this.obh.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((o.b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramm).hxt);
            }
          }
          AppMethodBeat.o(113395);
        }
      }
    }
    else if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramm.getType() == 492)
      {
        this.obe += 1;
        this.mHandler.removeMessages(1);
        if (this.obe >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.obh != null)
          {
            paramString = this.obh.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((o.b)localWeakReference.get()).onError(1, ((c)paramm).hxt);
              }
            }
            AppMethodBeat.o(113395);
          }
        }
        else if ((bLB()) && (!this.obq))
        {
          paramString = ((c)paramm).obG;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.caV = true;
            if (this.obr != null) {
              this.obr.ayM();
            }
          }
          for (;;)
          {
            ab.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.caV), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.caV) {
              this.mHandler.sendEmptyMessageDelayed(1, this.obf);
            }
            AppMethodBeat.o(113395);
            return;
            label696:
            this.caV = false;
          }
        }
      }
    }
    else
    {
      if (paramm.getType() == 492)
      {
        paramString = ((c)paramm).obG;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.caV = true;
          if (this.obr != null) {
            this.obr.ayM();
          }
        }
        for (;;)
        {
          ab.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.caV), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.obe > 0) {
            h.qsU.e(10997, new Object[] { "9", "", Integer.valueOf(this.obe), Integer.valueOf(0) });
          }
          this.obe = 0;
          this.obf = ((c)paramm).obD;
          paramInt1 = ((c)paramm).obH;
          if ((this.obh == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.obh.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((o.b)localWeakReference.get()).a(((c)paramm).obG);
            }
          }
          label964:
          this.caV = false;
        }
        if (this.obi == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            bLz();
          }
          this.mHandler.removeMessages(1);
          if ((bLB()) && (!this.obq) && (!this.caV)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.obf);
          }
          AppMethodBeat.o(113395);
          return;
        }
      }
      if (paramm.getType() == 491) {
        l.bLs().Sb("");
      }
    }
    AppMethodBeat.o(113395);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(113386);
    ab.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.fwu != null) {
      this.fwu.c(this.dZA);
    }
    if (this.obg != null) {
      this.obg.b(this.obw);
    }
    g.Rc().b(492, this);
    g.Rc().b(490, this);
    g.Rc().b(491, this);
    this.obi = 1;
    this.isStart = false;
    this.obs = -1;
    AppMethodBeat.o(113386);
  }
  
  public final void yb(int paramInt)
  {
    AppMethodBeat.i(113389);
    ab.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (bLB()) {
      cz(this.nZT, paramInt);
    }
    if (!bo.isNullOrNil(this.obp))
    {
      com.tencent.mm.plugin.location.a.a locala = l.bLs().Sa(this.obp);
      if (locala != null)
      {
        locala.cAC.remove(r.Zn());
        l.bLs().a(this.obp, locala.cAC, locala.latitude, locala.longitude, locala.nZR, null, null);
      }
    }
    l.bLs().Sb("");
    this.nZT = "";
    this.obp = "";
    this.obm = false;
    this.obn = false;
    this.nZV = -1000.0D;
    this.nZW = -1000.0D;
    this.nZX = -1;
    this.obs = -1;
    AppMethodBeat.o(113389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */