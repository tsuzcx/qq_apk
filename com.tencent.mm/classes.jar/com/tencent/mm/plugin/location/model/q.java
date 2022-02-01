package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cno;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dok;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements com.tencent.mm.ak.g, com.tencent.mm.bi.b
{
  public boolean cLV;
  public b.a fnd;
  public com.tencent.mm.modelgeo.d hxT;
  public boolean isStart;
  ao mHandler;
  private int oxC;
  private String tWG;
  public double tWI;
  public double tWJ;
  public int tWK;
  private int tXS;
  private int tXT;
  public k tXU;
  public HashSet<WeakReference<b>> tXV;
  public int tXW;
  public dok tXX;
  public LocationInfo tXY;
  public boolean tXZ;
  public boolean tYa;
  public int tYb;
  public String tYc;
  boolean tYd;
  public a tYe;
  public int tYf;
  public boolean tYg;
  public long tYh;
  long tYi;
  public k.a tYj;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.tXS = 0;
    this.tXT = 1000;
    this.tXV = new HashSet();
    this.tXW = 1;
    this.tXY = new LocationInfo((byte)0);
    this.tXZ = false;
    this.tYa = false;
    this.isStart = false;
    this.tYb = this.tXW;
    this.tYc = "";
    this.cLV = false;
    this.tYd = false;
    this.tYe = null;
    this.tYf = -1;
    this.tYg = true;
    this.tYh = 0L;
    this.tYi = 0L;
    this.tWI = -1000.0D;
    this.tWJ = -1000.0D;
    this.tWK = -1;
    this.mHandler = new ao(Looper.getMainLooper())
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
          localq.cXe();
        }
      }
    };
    this.fnd = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55759);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55759);
          return false;
        }
        ac.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1) });
        if (q.this.tYg)
        {
          q.this.tYg = false;
          q.this.tYi = System.currentTimeMillis();
          long l = q.this.tYi - q.this.tYh;
          ac.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          h.wUl.f(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.this.tXX != null) && (q.this.tXX.FWg != null))
        {
          q.this.tXX.FWg.Ecg = paramAnonymousFloat2;
          q.this.tXX.FWg.Ecf = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.tYj = new k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        if (q.this.tXX != null) {
          q.this.tXX.FWg.Fur = paramAnonymousDouble;
        }
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void cXa()
  {
    AppMethodBeat.i(55765);
    ac.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (cXf())
    {
      ac.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.hxT = com.tencent.mm.modelgeo.d.aEL();
      this.hxT.b(this.fnd, true);
      if (this.tXU == null) {
        this.tXU = n.cWX();
      }
      this.tXU.a(this.tYj);
      cXe();
    }
    AppMethodBeat.o(55765);
  }
  
  private void dH(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    ac.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((aev)paramString.rr.hvr.hvw).Scene = paramInt;
    com.tencent.mm.kernel.g.agi().a(paramString, 0);
    this.tWG = "";
    AppMethodBeat.o(55763);
  }
  
  public final void HA(int paramInt)
  {
    AppMethodBeat.i(55764);
    ac.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (cXf()) {
      dH(this.tWG, paramInt);
    }
    if (!bs.isNullOrNil(this.tYc))
    {
      com.tencent.mm.plugin.location.a.a locala = n.cWW().ajO(this.tYc);
      if (locala != null)
      {
        locala.dow.remove(u.axw());
        n.cWW().a(this.tYc, locala.dow, locala.latitude, locala.longitude, locala.tWE, null, null);
      }
    }
    n.cWW().ajP("");
    this.tWG = "";
    this.tYc = "";
    this.tXZ = false;
    this.tYa = false;
    this.tWI = -1000.0D;
    this.tWJ = -1000.0D;
    this.tWK = -1;
    this.tYf = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String aJc()
  {
    return this.tYc;
  }
  
  public final boolean cWZ()
  {
    AppMethodBeat.i(55762);
    if ((cXf()) && (this.tXZ))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void cXb()
  {
    AppMethodBeat.i(55766);
    ac.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.tYd = false;
    cXa();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> cXc()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.cWW().DE(this.tYc);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void cXd()
  {
    if (this.tXW == 1) {
      this.tXW = 3;
    }
    while (this.tXW != 3) {
      return;
    }
    this.tXW = 2;
  }
  
  public final void cXe()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.tXZ) || (this.tXY == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.tXZ).append(" ");
      if (this.tXY == null) {}
      for (;;)
      {
        ac.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.tXX == null) || (this.tXX.FWg.Ecg == -1000.0D) || (this.tXX.FWg.Ecf == -1000.0D))
    {
      ac.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.tXT);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = u.axw();
    Object localObject1 = new diy();
    ((diy)localObject1).Fqw = this.tXY.tWL;
    ((diy)localObject1).Ecg = this.tXY.tWI;
    ((diy)localObject1).Ecf = this.tXY.tWJ;
    ((diy)localObject1).Name = ((String)localObject2);
    this.tXX.Username = ((String)localObject2);
    this.tXX.FWg.Fur = n.cWX().cWP();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.tWG + "]");
    switch (this.tXW)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.tXX.FWg.Ecg + " " + this.tXX.FWg.Ecf + " " + this.tXX.FWg.Fur + " ]");
      ac.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.tWG;
      int i = this.tXW;
      dok localdok = this.tXX;
      int j = this.oxC + 1;
      this.oxC = j;
      localObject1 = new c((String)localObject2, i, localdok, j, (diy)localObject1);
      com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((diy)localObject1).Ecg + " " + ((diy)localObject1).Ecf + " ]");
    }
  }
  
  public final boolean cXf()
  {
    AppMethodBeat.i(55769);
    if (!bs.isNullOrNil(this.tWG))
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
    ac.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramn.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.tWG = ((com.tencent.mm.plugin.location.model.a.b)paramn).tWG;
        n.cWW().ajP(this.tWG);
        if (cXf())
        {
          ac.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.tWG });
          paramString = com.tencent.mm.bi.d.hXY.DE(this.tYc);
          paramString.add(u.axw());
          if (this.tXY != null) {
            com.tencent.mm.bi.d.hXY.a(this.tYc, paramString, this.tXY.tWI, this.tXY.tWJ, this.tXY.tWL, "", "");
          }
          while (this.tXV != null)
          {
            paramString = this.tXV.iterator();
            while (paramString.hasNext())
            {
              paramn = (WeakReference)paramString.next();
              if ((paramn != null) && (paramn.get() != null)) {
                ((b)paramn.get()).cXg();
              }
            }
            com.tencent.mm.bi.d.hXY.a(this.tYc, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          cXe();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.tXV != null))
        {
          paramString = this.tXV.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).cXh();
            }
          }
        }
        if (this.tXV != null)
        {
          paramString = this.tXV.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramn).jXd);
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
        this.tXS += 1;
        this.mHandler.removeMessages(1);
        if (this.tXS >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.tXV != null)
          {
            paramString = this.tXV.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramn).jXd);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((cXf()) && (!this.tYd))
        {
          paramString = ((c)paramn).tYt;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.cLV = true;
            if (this.tYe != null) {
              this.tYe.bsL();
            }
          }
          for (;;)
          {
            ac.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cLV), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.cLV) {
              this.mHandler.sendEmptyMessageDelayed(1, this.tXT);
            }
            AppMethodBeat.o(55770);
            return;
            label696:
            this.cLV = false;
          }
        }
      }
    }
    else
    {
      if (paramn.getType() == 492)
      {
        paramString = ((c)paramn).tYt;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.cLV = true;
          if (this.tYe != null) {
            this.tYe.bsL();
          }
        }
        for (;;)
        {
          ac.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.cLV), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.tXS > 0) {
            h.wUl.f(10997, new Object[] { "9", "", Integer.valueOf(this.tXS), Integer.valueOf(0) });
          }
          this.tXS = 0;
          this.tXT = ((c)paramn).tYq;
          paramInt1 = ((c)paramn).tYu;
          if ((this.tXV == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.tXV.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramn).tYt);
            }
          }
          label964:
          this.cLV = false;
        }
        if (this.tXW == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            cXd();
          }
          this.mHandler.removeMessages(1);
          if ((cXf()) && (!this.tYd) && (!this.cLV)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.tXT);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramn.getType() == 491) {
        n.cWW().ajP("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    ac.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    if (this.tXU != null) {
      this.tXU.b(this.tYj);
    }
    com.tencent.mm.kernel.g.agi().b(492, this);
    com.tencent.mm.kernel.g.agi().b(490, this);
    com.tencent.mm.kernel.g.agi().b(491, this);
    this.tXW = 1;
    this.isStart = false;
    this.tYf = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void bsL();
  }
  
  public static abstract interface b
  {
    public abstract void a(cno paramcno);
    
    public abstract void cXg();
    
    public abstract void cXh();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */