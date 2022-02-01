package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.cle;
import com.tencent.mm.protocal.protobuf.csr;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements f, com.tencent.mm.bj.b
{
  public boolean cXj;
  public b.a fFl;
  public com.tencent.mm.modelgeo.d hQo;
  public boolean isStart;
  ap mHandler;
  private int paX;
  private String uZp;
  public double uZr;
  public double uZs;
  public int uZt;
  private int vaB;
  private int vaC;
  public k vaD;
  public HashSet<WeakReference<b>> vaE;
  public int vaF;
  public dub vaG;
  public LocationInfo vaH;
  public boolean vaI;
  public boolean vaJ;
  public int vaK;
  public String vaL;
  boolean vaM;
  public a vaN;
  public int vaO;
  public boolean vaP;
  public long vaQ;
  long vaR;
  public k.a vaS;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.vaB = 0;
    this.vaC = 1000;
    this.vaE = new HashSet();
    this.vaF = 1;
    this.vaH = new LocationInfo((byte)0);
    this.vaI = false;
    this.vaJ = false;
    this.isStart = false;
    this.vaK = this.vaF;
    this.vaL = "";
    this.cXj = false;
    this.vaM = false;
    this.vaN = null;
    this.vaO = -1;
    this.vaP = true;
    this.vaQ = 0L;
    this.vaR = 0L;
    this.uZr = -1000.0D;
    this.uZs = -1000.0D;
    this.uZt = -1;
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
          localq.dgq();
        }
      }
    };
    this.fFl = new b.a()
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
        if (q.this.vaP)
        {
          q.this.vaP = false;
          q.this.vaR = System.currentTimeMillis();
          long l = q.this.vaR - q.this.vaQ;
          ad.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.this.vaG != null) && (q.this.vaG.HGW != null))
        {
          q.this.vaG.HGW.FIc = paramAnonymousFloat2;
          q.this.vaG.HGW.FIb = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.vaS = new k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        if (q.this.vaG != null) {
          q.this.vaG.HGW.Hew = paramAnonymousDouble;
        }
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void dY(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    ad.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((ahe)paramString.rr.hNK.hNQ).Scene = paramInt;
    com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    this.uZp = "";
    AppMethodBeat.o(55763);
  }
  
  private void dgm()
  {
    AppMethodBeat.i(55765);
    ad.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (dgr())
    {
      ad.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.hQo = com.tencent.mm.modelgeo.d.aHQ();
      this.hQo.b(this.fFl, true);
      if (this.vaD == null) {
        this.vaD = n.dgj();
      }
      this.vaD.a(this.vaS);
      dgq();
    }
    AppMethodBeat.o(55765);
  }
  
  public final void IW(int paramInt)
  {
    AppMethodBeat.i(55764);
    ad.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (dgr()) {
      dY(this.uZp, paramInt);
    }
    if (!bt.isNullOrNil(this.vaL))
    {
      com.tencent.mm.plugin.location.a.a locala = n.dgi().aoB(this.vaL);
      if (locala != null)
      {
        locala.dAk.remove(u.aAm());
        n.dgi().a(this.vaL, locala.dAk, locala.latitude, locala.longitude, locala.uZn, null, null);
      }
    }
    n.dgi().aoC("");
    this.uZp = "";
    this.vaL = "";
    this.vaI = false;
    this.vaJ = false;
    this.uZr = -1000.0D;
    this.uZs = -1000.0D;
    this.uZt = -1;
    this.vaO = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String aMm()
  {
    return this.vaL;
  }
  
  public final boolean dgl()
  {
    AppMethodBeat.i(55762);
    if ((dgr()) && (this.vaI))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void dgn()
  {
    AppMethodBeat.i(55766);
    ad.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.vaM = false;
    dgm();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> dgo()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.dgi().GJ(this.vaL);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void dgp()
  {
    if (this.vaF == 1) {
      this.vaF = 3;
    }
    while (this.vaF != 3) {
      return;
    }
    this.vaF = 2;
  }
  
  public final void dgq()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.vaI) || (this.vaH == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.vaI).append(" ");
      if (this.vaH == null) {}
      for (;;)
      {
        ad.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.vaG == null) || (this.vaG.HGW.FIc == -1000.0D) || (this.vaG.HGW.FIb == -1000.0D))
    {
      ad.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.vaC);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = u.aAm();
    Object localObject1 = new don();
    ((don)localObject1).Hag = this.vaH.uZu;
    ((don)localObject1).FIc = this.vaH.uZr;
    ((don)localObject1).FIb = this.vaH.uZs;
    ((don)localObject1).Name = ((String)localObject2);
    this.vaG.Username = ((String)localObject2);
    this.vaG.HGW.Hew = n.dgj().dgb();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.uZp + "]");
    switch (this.vaF)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.vaG.HGW.FIc + " " + this.vaG.HGW.FIb + " " + this.vaG.HGW.Hew + " ]");
      ad.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.uZp;
      int i = this.vaF;
      dub localdub = this.vaG;
      int j = this.paX + 1;
      this.paX = j;
      localObject1 = new c((String)localObject2, i, localdub, j, (don)localObject1);
      com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((don)localObject1).FIc + " " + ((don)localObject1).FIb + " ]");
    }
  }
  
  public final boolean dgr()
  {
    AppMethodBeat.i(55769);
    if (!bt.isNullOrNil(this.uZp))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
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
        this.uZp = ((com.tencent.mm.plugin.location.model.a.b)paramn).uZp;
        n.dgi().aoC(this.uZp);
        if (dgr())
        {
          ad.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.uZp });
          paramString = com.tencent.mm.bj.d.iru.GJ(this.vaL);
          paramString.add(u.aAm());
          if (this.vaH != null) {
            com.tencent.mm.bj.d.iru.a(this.vaL, paramString, this.vaH.uZr, this.vaH.uZs, this.vaH.uZu, "", "");
          }
          while (this.vaE != null)
          {
            paramString = this.vaE.iterator();
            while (paramString.hasNext())
            {
              paramn = (WeakReference)paramString.next();
              if ((paramn != null) && (paramn.get() != null)) {
                ((b)paramn.get()).dgs();
              }
            }
            com.tencent.mm.bj.d.iru.a(this.vaL, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          dgq();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.vaE != null))
        {
          paramString = this.vaE.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).dgt();
            }
          }
        }
        if (this.vaE != null)
        {
          paramString = this.vaE.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramn).krz);
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
        this.vaB += 1;
        this.mHandler.removeMessages(1);
        if (this.vaB >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.vaE != null)
          {
            paramString = this.vaE.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramn).krz);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((dgr()) && (!this.vaM))
        {
          paramString = ((c)paramn).vbc;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.cXj = true;
            if (this.vaN != null) {
              this.vaN.bwP();
            }
          }
          for (;;)
          {
            ad.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cXj), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.cXj) {
              this.mHandler.sendEmptyMessageDelayed(1, this.vaC);
            }
            AppMethodBeat.o(55770);
            return;
            label696:
            this.cXj = false;
          }
        }
      }
    }
    else
    {
      if (paramn.getType() == 492)
      {
        paramString = ((c)paramn).vbc;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.cXj = true;
          if (this.vaN != null) {
            this.vaN.bwP();
          }
        }
        for (;;)
        {
          ad.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cXj), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.vaB > 0) {
            com.tencent.mm.plugin.report.service.g.yhR.f(10997, new Object[] { "9", "", Integer.valueOf(this.vaB), Integer.valueOf(0) });
          }
          this.vaB = 0;
          this.vaC = ((c)paramn).vaZ;
          paramInt1 = ((c)paramn).vbd;
          if ((this.vaE == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.vaE.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramn).vbc);
            }
          }
          label964:
          this.cXj = false;
        }
        if (this.vaF == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            dgp();
          }
          this.mHandler.removeMessages(1);
          if ((dgr()) && (!this.vaM) && (!this.cXj)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.vaC);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramn.getType() == 491) {
        n.dgi().aoC("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    ad.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    if (this.vaD != null) {
      this.vaD.b(this.vaS);
    }
    com.tencent.mm.kernel.g.aiU().b(492, this);
    com.tencent.mm.kernel.g.aiU().b(490, this);
    com.tencent.mm.kernel.g.aiU().b(491, this);
    this.vaF = 1;
    this.isStart = false;
    this.vaO = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void bwP();
  }
  
  public static abstract interface b
  {
    public abstract void a(csr paramcsr);
    
    public abstract void dgs();
    
    public abstract void dgt();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */