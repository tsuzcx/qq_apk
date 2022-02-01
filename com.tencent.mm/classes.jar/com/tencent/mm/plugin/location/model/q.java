package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.div;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements com.tencent.mm.al.g, com.tencent.mm.bj.b
{
  public boolean cOA;
  public b.a fjJ;
  public com.tencent.mm.modelgeo.d gXu;
  public boolean isStart;
  ap mHandler;
  private int nUh;
  private String sOt;
  public double sOv;
  public double sOw;
  public int sOx;
  private int sPF;
  private int sPG;
  public k sPH;
  public HashSet<WeakReference<b>> sPI;
  public int sPJ;
  public div sPK;
  public LocationInfo sPL;
  public boolean sPM;
  public boolean sPN;
  public int sPO;
  public String sPP;
  boolean sPQ;
  public q.a sPR;
  public int sPS;
  public boolean sPT;
  public long sPU;
  long sPV;
  public k.a sPW;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.sPF = 0;
    this.sPG = 1000;
    this.sPI = new HashSet();
    this.sPJ = 1;
    this.sPL = new LocationInfo((byte)0);
    this.sPM = false;
    this.sPN = false;
    this.isStart = false;
    this.sPO = this.sPJ;
    this.sPP = "";
    this.cOA = false;
    this.sPQ = false;
    this.sPR = null;
    this.sPS = -1;
    this.sPT = true;
    this.sPU = 0L;
    this.sPV = 0L;
    this.sOv = -1000.0D;
    this.sOw = -1000.0D;
    this.sOx = -1;
    this.mHandler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(55758);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage == null)
        {
          AppMethodBeat.o(55758);
          return;
        }
        q localq = q.this;
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(55758);
          return;
          localq.cJz();
        }
      }
    };
    this.fjJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55759);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55759);
          return false;
        }
        ad.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1) });
        if (q.this.sPT)
        {
          q.this.sPT = false;
          q.this.sPV = System.currentTimeMillis();
          long l = q.this.sPV - q.this.sPU;
          ad.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          h.vKh.f(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.this.sPK != null) && (q.this.sPK.Eze != null))
        {
          q.this.sPK.Eze.CJE = paramAnonymousFloat2;
          q.this.sPK.Eze.CJD = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.sPW = new k.a()
    {
      public final void x(double paramAnonymousDouble)
      {
        if (q.this.sPK != null) {
          q.this.sPK.Eze.DXx = paramAnonymousDouble;
        }
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void cJv()
  {
    AppMethodBeat.i(55765);
    ad.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (cJA())
    {
      ad.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.gXu = com.tencent.mm.modelgeo.d.axT();
      this.gXu.b(this.fjJ, true);
      if (this.sPH == null) {
        this.sPH = n.cJs();
      }
      this.sPH.a(this.sPW);
      cJz();
    }
    AppMethodBeat.o(55765);
  }
  
  private void dB(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    ad.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((adw)paramString.rr.gUS.gUX).Scene = paramInt;
    com.tencent.mm.kernel.g.aeS().a(paramString, 0);
    this.sOt = "";
    AppMethodBeat.o(55763);
  }
  
  public final void FF(int paramInt)
  {
    AppMethodBeat.i(55764);
    ad.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (cJA()) {
      dB(this.sOt, paramInt);
    }
    if (!bt.isNullOrNil(this.sPP))
    {
      com.tencent.mm.plugin.location.a.a locala = n.cJr().aeU(this.sPP);
      if (locala != null)
      {
        locala.dqL.remove(u.aqG());
        n.cJr().a(this.sPP, locala.dqL, locala.latitude, locala.longitude, locala.sOr, null, null);
      }
    }
    n.cJr().aeV("");
    this.sOt = "";
    this.sPP = "";
    this.sPM = false;
    this.sPN = false;
    this.sOv = -1000.0D;
    this.sOw = -1000.0D;
    this.sOx = -1;
    this.sPS = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String aCm()
  {
    return this.sPP;
  }
  
  public final boolean cJA()
  {
    AppMethodBeat.i(55769);
    if (!bt.isNullOrNil(this.sOt))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
  }
  
  public final boolean cJu()
  {
    AppMethodBeat.i(55762);
    if ((cJA()) && (this.sPM))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void cJw()
  {
    AppMethodBeat.i(55766);
    ad.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.sPQ = false;
    cJv();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> cJx()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.cJr().zz(this.sPP);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void cJy()
  {
    if (this.sPJ == 1) {
      this.sPJ = 3;
    }
    while (this.sPJ != 3) {
      return;
    }
    this.sPJ = 2;
  }
  
  public final void cJz()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.sPM) || (this.sPL == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.sPM).append(" ");
      if (this.sPL == null) {}
      for (;;)
      {
        ad.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.sPK == null) || (this.sPK.Eze.CJE == -1000.0D) || (this.sPK.Eze.CJD == -1000.0D))
    {
      ad.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.sPG);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = u.aqG();
    Object localObject1 = new ddj();
    ((ddj)localObject1).DTI = this.sPL.sOy;
    ((ddj)localObject1).CJE = this.sPL.sOv;
    ((ddj)localObject1).CJD = this.sPL.sOw;
    ((ddj)localObject1).Name = ((String)localObject2);
    this.sPK.Username = ((String)localObject2);
    this.sPK.Eze.DXx = n.cJs().cJk();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.sOt + "]");
    switch (this.sPJ)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.sPK.Eze.CJE + " " + this.sPK.Eze.CJD + " " + this.sPK.Eze.DXx + " ]");
      ad.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.sOt;
      int i = this.sPJ;
      div localdiv = this.sPK;
      int j = this.nUh + 1;
      this.nUh = j;
      localObject1 = new c((String)localObject2, i, localdiv, j, (ddj)localObject1);
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((ddj)localObject1).CJE + " " + ((ddj)localObject1).CJD + " ]");
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(55770);
    ad.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramn.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.sOt = ((com.tencent.mm.plugin.location.model.a.b)paramn).sOt;
        n.cJr().aeV(this.sOt);
        if (cJA())
        {
          ad.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.sOt });
          paramString = com.tencent.mm.bj.d.hxx.zz(this.sPP);
          paramString.add(u.aqG());
          if (this.sPL != null) {
            com.tencent.mm.bj.d.hxx.a(this.sPP, paramString, this.sPL.sOv, this.sPL.sOw, this.sPL.sOy, "", "");
          }
          while (this.sPI != null)
          {
            paramString = this.sPI.iterator();
            while (paramString.hasNext())
            {
              paramn = (WeakReference)paramString.next();
              if ((paramn != null) && (paramn.get() != null)) {
                ((b)paramn.get()).cJB();
              }
            }
            com.tencent.mm.bj.d.hxx.a(this.sPP, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          cJz();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.sPI != null))
        {
          paramString = this.sPI.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).cJC();
            }
          }
        }
        if (this.sPI != null)
        {
          paramString = this.sPI.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramn).jwH);
            }
          }
          AppMethodBeat.o(55770);
        }
      }
    }
    else if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramn.getType() == 492)
      {
        this.sPF += 1;
        this.mHandler.removeMessages(1);
        if (this.sPF >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.sPI != null)
          {
            paramString = this.sPI.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramn).jwH);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((cJA()) && (!this.sPQ))
        {
          paramString = ((c)paramn).sQg;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.cOA = true;
            if (this.sPR != null) {
              this.sPR.blP();
            }
          }
          for (;;)
          {
            ad.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cOA), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.cOA) {
              this.mHandler.sendEmptyMessageDelayed(1, this.sPG);
            }
            AppMethodBeat.o(55770);
            return;
            label696:
            this.cOA = false;
          }
        }
      }
    }
    else
    {
      if (paramn.getType() == 492)
      {
        paramString = ((c)paramn).sQg;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.cOA = true;
          if (this.sPR != null) {
            this.sPR.blP();
          }
        }
        for (;;)
        {
          ad.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cOA), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.sPF > 0) {
            h.vKh.f(10997, new Object[] { "9", "", Integer.valueOf(this.sPF), Integer.valueOf(0) });
          }
          this.sPF = 0;
          this.sPG = ((c)paramn).sQd;
          paramInt1 = ((c)paramn).sQh;
          if ((this.sPI == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.sPI.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramn).sQg);
            }
          }
          label964:
          this.cOA = false;
        }
        if (this.sPJ == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            cJy();
          }
          this.mHandler.removeMessages(1);
          if ((cJA()) && (!this.sPQ) && (!this.cOA)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.sPG);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramn.getType() == 491) {
        n.cJr().aeV("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    ad.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    if (this.sPH != null) {
      this.sPH.b(this.sPW);
    }
    com.tencent.mm.kernel.g.aeS().b(492, this);
    com.tencent.mm.kernel.g.aeS().b(490, this);
    com.tencent.mm.kernel.g.aeS().b(491, this);
    this.sPJ = 1;
    this.isStart = false;
    this.sPS = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface b
  {
    public abstract void a(cii paramcii);
    
    public abstract void cJB();
    
    public abstract void cJC();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */