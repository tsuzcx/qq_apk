package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.ezh;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements i, com.tencent.mm.bk.b
{
  private String Ejl;
  public double Ejn;
  public double Ejo;
  public int Ejp;
  public k EkA;
  public HashSet<WeakReference<b>> EkB;
  public int EkC;
  public ezh EkD;
  public LocationInfo EkE;
  public boolean EkF;
  public boolean EkG;
  public int EkH;
  boolean EkI;
  public a EkJ;
  public int EkK;
  public boolean EkL;
  public long EkM;
  private long EkN;
  public k.a EkO;
  private int Eky;
  private int Ekz;
  private int dXr;
  public b.a iQJ;
  public boolean isStart;
  public boolean isTimeout;
  public com.tencent.mm.modelgeo.d lEL;
  MMHandler mHandler;
  public String uJM;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.Eky = 0;
    this.Ekz = 1000;
    this.EkB = new HashSet();
    this.EkC = 1;
    this.EkE = new LocationInfo((byte)0);
    this.EkF = false;
    this.EkG = false;
    this.isStart = false;
    this.EkH = this.EkC;
    this.uJM = "";
    this.isTimeout = false;
    this.EkI = false;
    this.EkJ = null;
    this.EkK = -1;
    this.EkL = true;
    this.EkM = 0L;
    this.EkN = 0L;
    this.Ejn = -1000.0D;
    this.Ejo = -1000.0D;
    this.Ejp = -1;
    this.mHandler = new MMHandler(Looper.getMainLooper())
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
        q.a(q.this, paramAnonymousMessage);
        AppMethodBeat.o(55758);
      }
    };
    this.iQJ = new b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(55759);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(55759);
          return false;
        }
        Log.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1) });
        if (q.a(q.this))
        {
          q.b(q.this);
          q.a(q.this, System.currentTimeMillis());
          long l = q.c(q.this) - q.d(q.this);
          Log.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.e(q.this) != null) && (q.e(q.this).UzK != null))
        {
          q.e(q.this).UzK.RVz = paramAnonymousFloat2;
          q.e(q.this).UzK.RVy = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.EkO = new k.a()
    {
      public final void x(double paramAnonymousDouble)
      {
        AppMethodBeat.i(245347);
        if (q.e(q.this) != null) {
          q.e(q.this).UzK.TUj = paramAnonymousDouble;
        }
        AppMethodBeat.o(245347);
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void eMp()
  {
    AppMethodBeat.i(55765);
    Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (eMu())
    {
      Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.lEL = com.tencent.mm.modelgeo.d.blq();
      this.lEL.b(this.iQJ, true);
      if (this.EkA == null) {
        this.EkA = n.eMl();
      }
      this.EkA.a(this.EkO);
      eMt();
    }
    AppMethodBeat.o(55765);
  }
  
  private void eU(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    Log.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((ald)d.b.b(paramString.rr.lBR)).CPw = paramInt;
    com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    this.Ejl = "";
    AppMethodBeat.o(55763);
  }
  
  public final void VG(int paramInt)
  {
    AppMethodBeat.i(55764);
    Log.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (eMu()) {
      eU(this.Ejl, paramInt);
    }
    if (!Util.isNullOrNil(this.uJM))
    {
      com.tencent.mm.plugin.location.a.a locala = n.eMk().aNj(this.uJM);
      if (locala != null)
      {
        locala.fMA.remove(z.bcZ());
        n.eMk().a(this.uJM, locala.fMA, locala.latitude, locala.longitude, locala.Ejj, null, null);
      }
    }
    n.eMk().aNk("");
    this.Ejl = "";
    this.uJM = "";
    this.EkF = false;
    this.EkG = false;
    this.Ejn = -1000.0D;
    this.Ejo = -1000.0D;
    this.Ejp = -1;
    this.EkK = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String bqa()
  {
    return this.uJM;
  }
  
  public final boolean eMo()
  {
    AppMethodBeat.i(55762);
    if ((eMu()) && (this.EkF))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void eMq()
  {
    AppMethodBeat.i(55766);
    Log.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.EkI = false;
    eMp();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> eMr()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.eMk().Xv(this.uJM);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void eMs()
  {
    if (this.EkC == 1) {
      this.EkC = 3;
    }
    while (this.EkC != 3) {
      return;
    }
    this.EkC = 2;
  }
  
  public final void eMt()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.EkF) || (this.EkE == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.EkF).append(" ");
      if (this.EkE == null) {}
      for (;;)
      {
        Log.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.EkD == null) || (this.EkD.UzK.RVz == -1000.0D) || (this.EkD.UzK.RVy == -1000.0D))
    {
      Log.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.Ekz);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = z.bcZ();
    Object localObject1 = new eti();
    ((eti)localObject1).TOk = this.EkE.Ejq;
    ((eti)localObject1).RVz = this.EkE.Ejn;
    ((eti)localObject1).RVy = this.EkE.Ejo;
    ((eti)localObject1).CMP = ((String)localObject2);
    this.EkD.Username = ((String)localObject2);
    this.EkD.UzK.TUj = n.eMl().eMd();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.Ejl + "]");
    switch (this.EkC)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.EkD.UzK.RVz + " " + this.EkD.UzK.RVy + " " + this.EkD.UzK.TUj + " ]");
      Log.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.Ejl;
      int i = this.EkC;
      ezh localezh = this.EkD;
      int j = this.dXr + 1;
      this.dXr = j;
      localObject1 = new c((String)localObject2, i, localezh, j, (eti)localObject1);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((eti)localObject1).RVz + " " + ((eti)localObject1).RVy + " ]");
    }
  }
  
  public final boolean eMu()
  {
    AppMethodBeat.i(55769);
    if (!Util.isNullOrNil(this.Ejl))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(55770);
    Log.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramq.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.Ejl = ((com.tencent.mm.plugin.location.model.a.b)paramq).Ejl;
        n.eMk().aNk(this.Ejl);
        if (eMu())
        {
          Log.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.Ejl });
          paramString = com.tencent.mm.bk.d.meV.Xv(this.uJM);
          paramString.add(z.bcZ());
          if (this.EkE != null) {
            com.tencent.mm.bk.d.meV.a(this.uJM, paramString, this.EkE.Ejn, this.EkE.Ejo, this.EkE.Ejq, "", "");
          }
          while (this.EkB != null)
          {
            paramString = this.EkB.iterator();
            while (paramString.hasNext())
            {
              paramq = (WeakReference)paramString.next();
              if ((paramq != null) && (paramq.get() != null)) {
                ((b)paramq.get()).eMv();
              }
            }
            com.tencent.mm.bk.d.meV.a(this.uJM, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          eMt();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.EkB != null))
        {
          paramString = this.EkB.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).eMw();
            }
          }
        }
        if (this.EkB != null)
        {
          paramString = this.EkB.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramq).tVH);
            }
          }
          AppMethodBeat.o(55770);
        }
      }
    }
    else if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramq.getType() == 492)
      {
        this.Eky += 1;
        this.mHandler.removeMessages(1);
        if (this.Eky >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.EkB != null)
          {
            paramString = this.EkB.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramq).tVH);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((eMu()) && (!this.EkI))
        {
          paramString = ((c)paramq).EkY;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.CqV != 12) {
              break label696;
            }
            this.isTimeout = true;
            if (this.EkJ != null) {
              this.EkJ.onTimeout();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.CqV) });
            if (!this.isTimeout) {
              this.mHandler.sendEmptyMessageDelayed(1, this.Ekz);
            }
            AppMethodBeat.o(55770);
            return;
            label696:
            this.isTimeout = false;
          }
        }
      }
    }
    else
    {
      if (paramq.getType() == 492)
      {
        paramString = ((c)paramq).EkY;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.CqV != 12) {
            break label964;
          }
          this.isTimeout = true;
          if (this.EkJ != null) {
            this.EkJ.onTimeout();
          }
        }
        for (;;)
        {
          Log.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.CqV) });
          if (this.Eky > 0) {
            com.tencent.mm.plugin.report.service.h.IzE.a(10997, new Object[] { "9", "", Integer.valueOf(this.Eky), Integer.valueOf(0) });
          }
          this.Eky = 0;
          this.Ekz = ((c)paramq).EkV;
          paramInt1 = ((c)paramq).EkZ;
          if ((this.EkB == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.EkB.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramq).EkY);
            }
          }
          label964:
          this.isTimeout = false;
        }
        if (this.EkC == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            eMs();
          }
          this.mHandler.removeMessages(1);
          if ((eMu()) && (!this.EkI) && (!this.isTimeout)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.Ekz);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramq.getType() == 491) {
        n.eMk().aNk("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    Log.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    if (this.EkA != null) {
      this.EkA.b(this.EkO);
    }
    com.tencent.mm.kernel.h.aGY().b(492, this);
    com.tencent.mm.kernel.h.aGY().b(490, this);
    com.tencent.mm.kernel.h.aGY().b(491, this);
    this.EkC = 1;
    this.isStart = false;
    this.EkK = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void onTimeout();
  }
  
  public static abstract interface b
  {
    public abstract void a(dvt paramdvt);
    
    public abstract void eMv();
    
    public abstract void eMw();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */