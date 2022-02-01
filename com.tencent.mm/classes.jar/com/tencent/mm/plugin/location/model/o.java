package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.s;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fot;
import com.tencent.mm.protocal.protobuf.fvj;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o
  implements com.tencent.mm.am.h, com.tencent.mm.bd.b
{
  private String KbU;
  public double KbW;
  public double KbX;
  public int KbY;
  private int Kdh;
  private int Kdi;
  public k Kdj;
  public HashSet<WeakReference<b>> Kdk;
  public int Kdl;
  public fvj Kdm;
  public LocationInfo Kdn;
  public boolean Kdo;
  public boolean Kdp;
  public int Kdq;
  boolean Kdr;
  public a Kds;
  public int Kdt;
  public boolean Kdu;
  public long Kdv;
  private long Kdw;
  public k.a Kdx;
  private int fZW;
  public boolean isStart;
  public boolean isTimeout;
  public b.a lsF;
  MMHandler mHandler;
  public String mpr;
  public com.tencent.mm.modelgeo.d owr;
  
  public o()
  {
    AppMethodBeat.i(55760);
    this.Kdh = 0;
    this.Kdi = 1000;
    this.Kdk = new HashSet();
    this.Kdl = 1;
    this.Kdn = new LocationInfo((byte)0);
    this.Kdo = false;
    this.Kdp = false;
    this.isStart = false;
    this.Kdq = this.Kdl;
    this.mpr = "";
    this.isTimeout = false;
    this.Kdr = false;
    this.Kds = null;
    this.Kdt = -1;
    this.Kdu = true;
    this.Kdv = 0L;
    this.Kdw = 0L;
    this.KbW = -1000.0D;
    this.KbX = -1000.0D;
    this.KbY = -1;
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
        o.a(o.this, paramAnonymousMessage);
        AppMethodBeat.o(55758);
      }
    };
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(264937);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(264937);
          return false;
        }
        Log.d("MicorMsg.TrackRefreshManager", "onGetlocatoin fLongitude:%f, fLatitude:%f, locType:%d, speed:%f", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Integer.valueOf(paramAnonymousInt), Double.valueOf(paramAnonymousDouble1) });
        if (o.a(o.this))
        {
          o.b(o.this);
          o.a(o.this, System.currentTimeMillis());
          long l = o.c(o.this) - o.d(o.this);
          Log.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((o.e(o.this) != null) && (o.e(o.this).abTG != null))
        {
          o.e(o.this).abTG.YTd = paramAnonymousFloat2;
          o.e(o.this).abTG.YTc = paramAnonymousFloat1;
        }
        AppMethodBeat.o(264937);
        return true;
      }
    };
    this.Kdx = new k.a()
    {
      public final void Q(double paramAnonymousDouble)
      {
        AppMethodBeat.i(264935);
        if (o.e(o.this) != null) {
          o.e(o.this).abTG.abkT = paramAnonymousDouble;
        }
        AppMethodBeat.o(264935);
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void fM(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    Log.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((aoo)c.b.b(paramString.rr.otB)).IJG = paramInt;
    com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    this.KbU = "";
    AppMethodBeat.o(55763);
  }
  
  private void fUH()
  {
    AppMethodBeat.i(55765);
    Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (fUM())
    {
      Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.owr = com.tencent.mm.modelgeo.d.bJl();
      this.owr.a(this.lsF, true);
      if (this.Kdj == null) {
        this.Kdj = SubCoreLocation.fUD();
      }
      this.Kdj.a(this.Kdx);
      fUL();
    }
    AppMethodBeat.o(55765);
  }
  
  public final void ZC(int paramInt)
  {
    AppMethodBeat.i(55764);
    Log.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (fUM()) {
      fM(this.KbU, paramInt);
    }
    if (!Util.isNullOrNil(this.mpr))
    {
      com.tencent.mm.plugin.location.a.a locala = SubCoreLocation.fUC().aKe(this.mpr);
      if (locala != null)
      {
        locala.hSk.remove(z.bAM());
        SubCoreLocation.fUC().a(this.mpr, locala.hSk, locala.latitude, locala.longitude, locala.KbS, null, null);
      }
    }
    SubCoreLocation.fUC().aKf("");
    this.KbU = "";
    this.mpr = "";
    this.Kdo = false;
    this.Kdp = false;
    this.KbW = -1000.0D;
    this.KbX = -1000.0D;
    this.KbY = -1;
    this.Kdt = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String bNG()
  {
    return this.mpr;
  }
  
  public final boolean fUG()
  {
    AppMethodBeat.i(55762);
    if ((fUM()) && (this.Kdo))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void fUI()
  {
    AppMethodBeat.i(55766);
    Log.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.Kdr = false;
    fUH();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> fUJ()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = SubCoreLocation.fUC().Px(this.mpr);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void fUK()
  {
    if (this.Kdl == 1) {
      this.Kdl = 3;
    }
    while (this.Kdl != 3) {
      return;
    }
    this.Kdl = 2;
  }
  
  public final void fUL()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.Kdo) || (this.Kdn == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.Kdo).append(" ");
      if (this.Kdn == null) {}
      for (;;)
      {
        Log.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.Kdm == null) || (this.Kdm.abTG.YTd == -1000.0D) || (this.Kdm.abTG.YTc == -1000.0D))
    {
      Log.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.Kdi);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = z.bAM();
    Object localObject1 = new fot();
    ((fot)localObject1).abeG = this.Kdn.KbZ;
    ((fot)localObject1).YTd = this.Kdn.KbW;
    ((fot)localObject1).YTc = this.Kdn.KbX;
    ((fot)localObject1).IGU = ((String)localObject2);
    this.Kdm.Username = ((String)localObject2);
    this.Kdm.abTG.abkT = SubCoreLocation.fUD().fUv();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.KbU + "]");
    switch (this.Kdl)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.Kdm.abTG.YTd + " " + this.Kdm.abTG.YTc + " " + this.Kdm.abTG.abkT + " ]");
      Log.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.KbU;
      int i = this.Kdl;
      fvj localfvj = this.Kdm;
      int j = this.fZW + 1;
      this.fZW = j;
      localObject1 = new com.tencent.mm.plugin.location.model.a.c((String)localObject2, i, localfvj, j, (fot)localObject1);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((fot)localObject1).YTd + " " + ((fot)localObject1).YTc + " ]");
    }
  }
  
  public final boolean fUM()
  {
    AppMethodBeat.i(55769);
    if (!Util.isNullOrNil(this.KbU))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(55770);
    Log.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramp.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.KbU = ((com.tencent.mm.plugin.location.model.a.b)paramp).KbU;
        SubCoreLocation.fUC().aKf(this.KbU);
        if (fUM())
        {
          Log.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.KbU });
          paramString = com.tencent.mm.bd.d.oXN.Px(this.mpr);
          paramString.add(z.bAM());
          if (this.Kdn != null) {
            com.tencent.mm.bd.d.oXN.a(this.mpr, paramString, this.Kdn.KbW, this.Kdn.KbX, this.Kdn.KbZ, "", "");
          }
          while (this.Kdk != null)
          {
            paramString = this.Kdk.iterator();
            while (paramString.hasNext())
            {
              paramp = (WeakReference)paramString.next();
              if ((paramp != null) && (paramp.get() != null)) {
                ((b)paramp.get()).fUN();
              }
            }
            com.tencent.mm.bd.d.oXN.a(this.mpr, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          fUL();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.Kdk != null))
        {
          paramString = this.Kdk.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).fUO();
            }
          }
        }
        if (this.Kdk != null)
        {
          paramString = this.Kdk.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramp).wZb);
            }
          }
          AppMethodBeat.o(55770);
        }
      }
    }
    else if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if (paramp.getType() == 492)
      {
        this.Kdh += 1;
        this.mHandler.removeMessages(1);
        if (this.Kdh >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.Kdk != null)
          {
            paramString = this.Kdk.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c)paramp).wZb);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((fUM()) && (!this.Kdr))
        {
          paramString = ((com.tencent.mm.plugin.location.model.a.c)paramp).KdH;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Idd != 12) {
              break label696;
            }
            this.isTimeout = true;
            if (this.Kds != null) {
              this.Kds.onTimeout();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.Idd) });
            if (!this.isTimeout) {
              this.mHandler.sendEmptyMessageDelayed(1, this.Kdi);
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
      if (paramp.getType() == 492)
      {
        paramString = ((com.tencent.mm.plugin.location.model.a.c)paramp).KdH;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Idd != 12) {
            break label964;
          }
          this.isTimeout = true;
          if (this.Kds != null) {
            this.Kds.onTimeout();
          }
        }
        for (;;)
        {
          Log.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.Idd) });
          if (this.Kdh > 0) {
            com.tencent.mm.plugin.report.service.h.OAn.b(10997, new Object[] { "9", "", Integer.valueOf(this.Kdh), Integer.valueOf(0) });
          }
          this.Kdh = 0;
          this.Kdi = ((com.tencent.mm.plugin.location.model.a.c)paramp).KdE;
          paramInt1 = ((com.tencent.mm.plugin.location.model.a.c)paramp).KdI;
          if ((this.Kdk == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.Kdk.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c)paramp).KdH);
            }
          }
          label964:
          this.isTimeout = false;
        }
        if (this.Kdl == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            fUK();
          }
          this.mHandler.removeMessages(1);
          if ((fUM()) && (!this.Kdr) && (!this.isTimeout)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.Kdi);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramp.getType() == 491) {
        SubCoreLocation.fUC().aKf("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    Log.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    if (this.Kdj != null) {
      this.Kdj.b(this.Kdx);
    }
    com.tencent.mm.kernel.h.aZW().b(492, this);
    com.tencent.mm.kernel.h.aZW().b(490, this);
    com.tencent.mm.kernel.h.aZW().b(491, this);
    this.Kdl = 1;
    this.isStart = false;
    this.Kdt = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void onTimeout();
  }
  
  public static abstract interface b
  {
    public abstract void a(eor parameor);
    
    public abstract void fUN();
    
    public abstract void fUO();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.o
 * JD-Core Version:    0.7.0.1
 */