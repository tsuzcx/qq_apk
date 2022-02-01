package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.model.v;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aho;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements f, com.tencent.mm.bi.b
{
  public boolean cYg;
  public b.a fHp;
  public com.tencent.mm.modelgeo.d hTg;
  public boolean isStart;
  aq mHandler;
  private int phB;
  private String vlA;
  public double vlC;
  public double vlD;
  public int vlE;
  private int vmM;
  private int vmN;
  public k vmO;
  public HashSet<WeakReference<b>> vmP;
  public int vmQ;
  public duy vmR;
  public LocationInfo vmS;
  public boolean vmT;
  public boolean vmU;
  public int vmV;
  public String vmW;
  boolean vmX;
  public a vmY;
  public int vmZ;
  public boolean vna;
  public long vnb;
  long vnc;
  public k.a vnd;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.vmM = 0;
    this.vmN = 1000;
    this.vmP = new HashSet();
    this.vmQ = 1;
    this.vmS = new LocationInfo((byte)0);
    this.vmT = false;
    this.vmU = false;
    this.isStart = false;
    this.vmV = this.vmQ;
    this.vmW = "";
    this.cYg = false;
    this.vmX = false;
    this.vmY = null;
    this.vmZ = -1;
    this.vna = true;
    this.vnb = 0L;
    this.vnc = 0L;
    this.vlC = -1000.0D;
    this.vlD = -1000.0D;
    this.vlE = -1;
    this.mHandler = new aq(Looper.getMainLooper())
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
          localq.djp();
        }
      }
    };
    this.fHp = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55759);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55759);
          return false;
        }
        ae.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1) });
        if (q.this.vna)
        {
          q.this.vna = false;
          q.this.vnc = System.currentTimeMillis();
          long l = q.this.vnc - q.this.vnb;
          ae.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.this.vmR != null) && (q.this.vmR.IaJ != null))
        {
          q.this.vmR.IaJ.Gay = paramAnonymousFloat2;
          q.this.vmR.IaJ.Gax = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.vnd = new k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        if (q.this.vmR != null) {
          q.this.vmR.IaJ.HxW = paramAnonymousDouble;
        }
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void djl()
  {
    AppMethodBeat.i(55765);
    ae.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (djq())
    {
      ae.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.hTg = com.tencent.mm.modelgeo.d.aIh();
      this.hTg.b(this.fHp, true);
      if (this.vmO == null) {
        this.vmO = n.dji();
      }
      this.vmO.a(this.vnd);
      djp();
    }
    AppMethodBeat.o(55765);
  }
  
  private void ef(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    ae.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((aho)paramString.rr.hQD.hQJ).Scene = paramInt;
    com.tencent.mm.kernel.g.ajj().a(paramString, 0);
    this.vlA = "";
    AppMethodBeat.o(55763);
  }
  
  public final void Jv(int paramInt)
  {
    AppMethodBeat.i(55764);
    ae.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (djq()) {
      ef(this.vlA, paramInt);
    }
    if (!bu.isNullOrNil(this.vmW))
    {
      com.tencent.mm.plugin.location.a.a locala = n.djh().apG(this.vmW);
      if (locala != null)
      {
        locala.dBp.remove(v.aAC());
        n.djh().a(this.vmW, locala.dBp, locala.latitude, locala.longitude, locala.vly, null, null);
      }
    }
    n.djh().apH("");
    this.vlA = "";
    this.vmW = "";
    this.vmT = false;
    this.vmU = false;
    this.vlC = -1000.0D;
    this.vlD = -1000.0D;
    this.vlE = -1;
    this.vmZ = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String aMK()
  {
    return this.vmW;
  }
  
  public final boolean djk()
  {
    AppMethodBeat.i(55762);
    if ((djq()) && (this.vmT))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void djm()
  {
    AppMethodBeat.i(55766);
    ae.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.vmX = false;
    djl();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> djn()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.djh().Hl(this.vmW);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void djo()
  {
    if (this.vmQ == 1) {
      this.vmQ = 3;
    }
    while (this.vmQ != 3) {
      return;
    }
    this.vmQ = 2;
  }
  
  public final void djp()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.vmT) || (this.vmS == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.vmT).append(" ");
      if (this.vmS == null) {}
      for (;;)
      {
        ae.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.vmR == null) || (this.vmR.IaJ.Gay == -1000.0D) || (this.vmR.IaJ.Gax == -1000.0D))
    {
      ae.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.vmN);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = v.aAC();
    Object localObject1 = new dpk();
    ((dpk)localObject1).HtG = this.vmS.vlF;
    ((dpk)localObject1).Gay = this.vmS.vlC;
    ((dpk)localObject1).Gax = this.vmS.vlD;
    ((dpk)localObject1).Name = ((String)localObject2);
    this.vmR.Username = ((String)localObject2);
    this.vmR.IaJ.HxW = n.dji().dja();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.vlA + "]");
    switch (this.vmQ)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.vmR.IaJ.Gay + " " + this.vmR.IaJ.Gax + " " + this.vmR.IaJ.HxW + " ]");
      ae.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.vlA;
      int i = this.vmQ;
      duy localduy = this.vmR;
      int j = this.phB + 1;
      this.phB = j;
      localObject1 = new c((String)localObject2, i, localduy, j, (dpk)localObject1);
      com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((dpk)localObject1).Gay + " " + ((dpk)localObject1).Gax + " ]");
    }
  }
  
  public final boolean djq()
  {
    AppMethodBeat.i(55769);
    if (!bu.isNullOrNil(this.vlA))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(55770);
    ae.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramn.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.vlA = ((com.tencent.mm.plugin.location.model.a.b)paramn).vlA;
        n.djh().apH(this.vlA);
        if (djq())
        {
          ae.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.vlA });
          paramString = com.tencent.mm.bi.d.iuo.Hl(this.vmW);
          paramString.add(v.aAC());
          if (this.vmS != null) {
            com.tencent.mm.bi.d.iuo.a(this.vmW, paramString, this.vmS.vlC, this.vmS.vlD, this.vmS.vlF, "", "");
          }
          while (this.vmP != null)
          {
            paramString = this.vmP.iterator();
            while (paramString.hasNext())
            {
              paramn = (WeakReference)paramString.next();
              if ((paramn != null) && (paramn.get() != null)) {
                ((b)paramn.get()).djr();
              }
            }
            com.tencent.mm.bi.d.iuo.a(this.vmW, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          djp();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.vmP != null))
        {
          paramString = this.vmP.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).djs();
            }
          }
        }
        if (this.vmP != null)
        {
          paramString = this.vmP.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramn).kuP);
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
        this.vmM += 1;
        this.mHandler.removeMessages(1);
        if (this.vmM >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.vmP != null)
          {
            paramString = this.vmP.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramn).kuP);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((djq()) && (!this.vmX))
        {
          paramString = ((c)paramn).vnn;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.cYg = true;
            if (this.vmY != null) {
              this.vmY.bxH();
            }
          }
          for (;;)
          {
            ae.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cYg), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.cYg) {
              this.mHandler.sendEmptyMessageDelayed(1, this.vmN);
            }
            AppMethodBeat.o(55770);
            return;
            label696:
            this.cYg = false;
          }
        }
      }
    }
    else
    {
      if (paramn.getType() == 492)
      {
        paramString = ((c)paramn).vnn;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.cYg = true;
          if (this.vmY != null) {
            this.vmY.bxH();
          }
        }
        for (;;)
        {
          ae.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cYg), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.vmM > 0) {
            com.tencent.mm.plugin.report.service.g.yxI.f(10997, new Object[] { "9", "", Integer.valueOf(this.vmM), Integer.valueOf(0) });
          }
          this.vmM = 0;
          this.vmN = ((c)paramn).vnk;
          paramInt1 = ((c)paramn).vno;
          if ((this.vmP == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.vmP.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramn).vnn);
            }
          }
          label964:
          this.cYg = false;
        }
        if (this.vmQ == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            djo();
          }
          this.mHandler.removeMessages(1);
          if ((djq()) && (!this.vmX) && (!this.cYg)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.vmN);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramn.getType() == 491) {
        n.djh().apH("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    ae.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    if (this.vmO != null) {
      this.vmO.b(this.vnd);
    }
    com.tencent.mm.kernel.g.ajj().b(492, this);
    com.tencent.mm.kernel.g.ajj().b(490, this);
    com.tencent.mm.kernel.g.ajj().b(491, this);
    this.vmQ = 1;
    this.isStart = false;
    this.vmZ = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void bxH();
  }
  
  public static abstract interface b
  {
    public abstract void a(ctl paramctl);
    
    public abstract void djr();
    
    public abstract void djs();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */