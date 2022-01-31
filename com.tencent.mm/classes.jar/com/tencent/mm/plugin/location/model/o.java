package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfb;
import com.tencent.mm.protocal.c.bka;
import com.tencent.mm.protocal.c.byn;
import com.tencent.mm.protocal.c.ccg;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class o
  implements f, com.tencent.mm.bg.b
{
  public boolean bSr = false;
  public boolean byT = false;
  public a.a dig = new o.2(this);
  public com.tencent.mm.modelgeo.c egs;
  private String lCH;
  public double lCJ = -1000.0D;
  public double lCK = -1000.0D;
  public int lCL = -1;
  private int lDS = 0;
  private int lDT = 1000;
  public i lDU;
  public HashSet<WeakReference<o.b>> lDV = new HashSet();
  public int lDW = 1;
  public ccg lDX;
  public LocationInfo lDY = new LocationInfo((byte)0);
  public boolean lDZ = false;
  public boolean lEa = false;
  public int lEb = this.lDW;
  public String lEc = "";
  boolean lEd = false;
  public o.a lEe = null;
  public int lEf = -1;
  public boolean lEg = true;
  public long lEh = 0L;
  long lEi = 0L;
  public i.a lEj = new o.3(this);
  ah mHandler = new o.1(this, Looper.getMainLooper());
  private int timestamp;
  
  public final String RW()
  {
    return this.lEc;
  }
  
  public final boolean bec()
  {
    return (beh()) && (this.lDZ);
  }
  
  public final void bed()
  {
    y.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.lEd = false;
    y.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (beh())
    {
      y.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.egs = com.tencent.mm.modelgeo.c.Ob();
      this.egs.b(this.dig, true);
      if (this.lDU == null) {
        this.lDU = l.bdZ();
      }
      this.lDU.a(this.lEj);
      beg();
    }
  }
  
  public final List<String> bee()
  {
    return l.bdY().nz(this.lEc);
  }
  
  public final void bef()
  {
    if (this.lDW == 1) {
      this.lDW = 3;
    }
    while (this.lDW != 3) {
      return;
    }
    this.lDW = 2;
  }
  
  public final void beg()
  {
    boolean bool = true;
    if ((!this.bSr) || (!this.lDZ) || (this.lDY == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.bSr).append(" isShared: ").append(this.lDZ).append(" ");
      if (this.lDY == null) {}
      for (;;)
      {
        y.e("MicorMsg.TrackRefreshManager", bool);
        return;
        bool = false;
      }
    }
    if ((this.lDX == null) || (this.lDX.tRA.sDn == -1000.0D) || (this.lDX.tRA.sDm == -1000.0D))
    {
      y.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.lDT);
      return;
    }
    Object localObject2 = q.Gj();
    Object localObject1 = new byn();
    ((byn)localObject1).txR = this.lDY.lCM;
    ((byn)localObject1).sDn = this.lDY.lCJ;
    ((byn)localObject1).sDm = this.lDY.lCK;
    ((byn)localObject1).kRZ = ((String)localObject2);
    this.lDX.sxM = ((String)localObject2);
    this.lDX.tRA.tzO = l.bdZ().bdQ();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.lCH + "]");
    switch (this.lDW)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.lDX.tRA.sDn + " " + this.lDX.tRA.sDm + " " + this.lDX.tRA.tzO + " ]");
      y.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.lCH;
      int i = this.lDW;
      ccg localccg = this.lDX;
      int j = this.timestamp + 1;
      this.timestamp = j;
      localObject1 = new com.tencent.mm.plugin.location.model.a.c((String)localObject2, i, localccg, j, (byn)localObject1);
      g.Dk().a((com.tencent.mm.ah.m)localObject1, 0);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((byn)localObject1).sDn + " " + ((byn)localObject1).sDm + " ]");
    }
  }
  
  public final boolean beh()
  {
    return !bk.bl(this.lCH);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramm.getType() == 490) {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.lCH = ((com.tencent.mm.plugin.location.model.a.b)paramm).lCH;
        l.bdY().Gy(this.lCH);
        if (beh())
        {
          y.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.lCH });
          paramString = d.eEX.nz(this.lEc);
          paramString.add(q.Gj());
          if (this.lDY != null) {
            d.eEX.a(this.lEc, paramString, this.lDY.lCJ, this.lDY.lCK, this.lDY.lCM, "", "");
          }
          while (this.lDV != null)
          {
            paramString = this.lDV.iterator();
            while (paramString.hasNext())
            {
              paramm = (WeakReference)paramString.next();
              if ((paramm != null) && (paramm.get() != null)) {
                ((o.b)paramm.get()).bej();
              }
            }
            d.eEX.a(this.lEc, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          beg();
        }
      }
    }
    label664:
    label672:
    label932:
    do
    {
      WeakReference localWeakReference;
      do
      {
        for (;;)
        {
          return;
          if ((paramInt2 == 17) && (this.lDV != null))
          {
            paramString = this.lDV.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((o.b)localWeakReference.get()).bek();
              }
            }
          }
          if (this.lDV != null)
          {
            paramString = this.lDV.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((o.b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramm).gfH);
              }
            }
            continue;
            if ((paramInt1 == 0) && (paramInt2 == 0)) {
              break label672;
            }
            if (paramm.getType() == 492)
            {
              this.lDS += 1;
              this.mHandler.removeMessages(1);
              if (this.lDS < 10) {
                break;
              }
              this.mHandler.removeMessages(1);
              if (this.lDV != null)
              {
                paramString = this.lDV.iterator();
                while (paramString.hasNext())
                {
                  localWeakReference = (WeakReference)paramString.next();
                  if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                    ((o.b)localWeakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c)paramm).gfH);
                  }
                }
              }
            }
          }
        }
      } while ((!beh()) || (this.lEd));
      paramString = ((com.tencent.mm.plugin.location.model.a.c)paramm).lEt;
      if ((paramString != null) && (paramString.tFx != null))
      {
        if (paramString.tFx.sze != 12) {
          break label664;
        }
        this.byT = true;
        if (this.lEe != null) {
          this.lEe.bei();
        }
      }
      for (;;)
      {
        y.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.byT), Integer.valueOf(paramString.tFx.sze) });
        if (this.byT) {
          break;
        }
        this.mHandler.sendEmptyMessageDelayed(1, this.lDT);
        return;
        this.byT = false;
      }
      if (paramm.getType() == 492)
      {
        paramString = ((com.tencent.mm.plugin.location.model.a.c)paramm).lEt;
        if ((paramString != null) && (paramString.tFx != null))
        {
          if (paramString.tFx.sze != 12) {
            break label932;
          }
          this.byT = true;
          if (this.lEe != null) {
            this.lEe.bei();
          }
        }
        for (;;)
        {
          y.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.byT), Integer.valueOf(paramString.tFx.sze) });
          if (this.lDS > 0) {
            h.nFQ.f(10997, new Object[] { "9", "", Integer.valueOf(this.lDS), Integer.valueOf(0) });
          }
          this.lDS = 0;
          this.lDT = ((com.tencent.mm.plugin.location.model.a.c)paramm).lEq;
          paramInt1 = ((com.tencent.mm.plugin.location.model.a.c)paramm).lEu;
          if ((this.lDV == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.lDV.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((o.b)localWeakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c)paramm).lEt);
            }
          }
          this.byT = false;
        }
        if (this.lDW == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            bef();
          }
          this.mHandler.removeMessages(1);
          if ((!beh()) || (this.lEd) || (this.byT)) {
            break;
          }
          this.mHandler.sendEmptyMessageDelayed(1, this.lDT);
          return;
        }
      }
    } while (paramm.getType() != 491);
    l.bdY().Gy("");
  }
  
  public final void sY(int paramInt)
  {
    y.i("MicorMsg.TrackRefreshManager", "track endTrack");
    Object localObject;
    if (beh())
    {
      localObject = this.lCH;
      y.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
      localObject = new com.tencent.mm.plugin.location.model.a.a((String)localObject);
      ((wc)((com.tencent.mm.plugin.location.model.a.a)localObject).dmK.ecE.ecN).pyo = paramInt;
      g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      this.lCH = "";
    }
    if (!bk.bl(this.lEc))
    {
      localObject = l.bdY().Gx(this.lEc);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.location.a.a)localObject).bSX.remove(q.Gj());
        l.bdY().a(this.lEc, ((com.tencent.mm.plugin.location.a.a)localObject).bSX, ((com.tencent.mm.plugin.location.a.a)localObject).latitude, ((com.tencent.mm.plugin.location.a.a)localObject).longitude, ((com.tencent.mm.plugin.location.a.a)localObject).lCF, null, null);
      }
    }
    l.bdY().Gy("");
    this.lCH = "";
    this.lEc = "";
    this.lDZ = false;
    this.lEa = false;
    this.lCJ = -1000.0D;
    this.lCK = -1000.0D;
    this.lCL = -1;
    this.lEf = -1;
  }
  
  public final void stop()
  {
    y.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
    if (this.lDU != null) {
      this.lDU.b(this.lEj);
    }
    g.Dk().b(492, this);
    g.Dk().b(490, this);
    g.Dk().b(491, this);
    this.lDW = 1;
    this.bSr = false;
    this.lEf = -1;
    m localm = l.bea();
    y.d("MicroMsg.TrackAvatarCacheService", "clearCache");
    Iterator localIterator = localm.lDR.snapshot().keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (Bitmap)localm.lDR.get(localObject);
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        ((Bitmap)localObject).recycle();
      }
    }
    localm.lDR.trimToSize(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */