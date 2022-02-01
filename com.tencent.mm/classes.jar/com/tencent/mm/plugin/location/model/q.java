package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.location.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  implements i, com.tencent.mm.bi.b
{
  public b.a gmA;
  public com.tencent.mm.modelgeo.d iOv;
  public boolean isStart;
  public boolean isTimeout;
  MMHandler mHandler;
  private int qwL;
  public String rgD;
  private String yFs;
  public double yFu;
  public double yFv;
  public int yFw;
  private int yGE;
  private int yGF;
  public k yGG;
  public HashSet<WeakReference<b>> yGH;
  public int yGI;
  public eox yGJ;
  public LocationInfo yGK;
  public boolean yGL;
  public boolean yGM;
  public int yGN;
  boolean yGO;
  public a yGP;
  public int yGQ;
  public boolean yGR;
  public long yGS;
  long yGT;
  public k.a yGU;
  
  public q()
  {
    AppMethodBeat.i(55760);
    this.yGE = 0;
    this.yGF = 1000;
    this.yGH = new HashSet();
    this.yGI = 1;
    this.yGK = new LocationInfo((byte)0);
    this.yGL = false;
    this.yGM = false;
    this.isStart = false;
    this.yGN = this.yGI;
    this.rgD = "";
    this.isTimeout = false;
    this.yGO = false;
    this.yGP = null;
    this.yGQ = -1;
    this.yGR = true;
    this.yGS = 0L;
    this.yGT = 0L;
    this.yFu = -1000.0D;
    this.yFv = -1000.0D;
    this.yFw = -1;
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
        q localq = q.this;
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(55758);
          return;
          localq.eda();
        }
      }
    };
    this.gmA = new b.a()
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
        if (q.this.yGR)
        {
          q.this.yGR = false;
          q.this.yGT = System.currentTimeMillis();
          long l = q.this.yGT - q.this.yGS;
          Log.d("MicorMsg.TrackRefreshManager", "locate time:%d", new Object[] { Long.valueOf(l) });
          h.CyF.a(10997, new Object[] { "10", "", Integer.valueOf(0), Long.valueOf(l) });
        }
        if ((q.this.yGJ != null) && (q.this.yGJ.NmV != null))
        {
          q.this.yGJ.NmV.KUu = paramAnonymousFloat2;
          q.this.yGJ.NmV.KUt = paramAnonymousFloat1;
        }
        AppMethodBeat.o(55759);
        return true;
      }
    };
    this.yGU = new k.a()
    {
      public final void w(double paramAnonymousDouble)
      {
        if (q.this.yGJ != null) {
          q.this.yGJ.NmV.MIv = paramAnonymousDouble;
        }
      }
    };
    AppMethodBeat.o(55760);
  }
  
  private void ecW()
  {
    AppMethodBeat.i(55765);
    Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
    if (edb())
    {
      Log.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
      this.iOv = com.tencent.mm.modelgeo.d.bca();
      this.iOv.b(this.gmA, true);
      if (this.yGG == null) {
        this.yGG = n.ecT();
      }
      this.yGG.a(this.yGU);
      eda();
    }
    AppMethodBeat.o(55765);
  }
  
  private void et(String paramString, int paramInt)
  {
    AppMethodBeat.i(55763);
    Log.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[] { Integer.valueOf(paramInt) });
    paramString = new com.tencent.mm.plugin.location.model.a.a(paramString);
    ((aka)paramString.rr.iLK.iLR).Scene = paramInt;
    g.azz().a(paramString, 0);
    this.yFs = "";
    AppMethodBeat.o(55763);
  }
  
  public final void Px(int paramInt)
  {
    AppMethodBeat.i(55764);
    Log.i("MicorMsg.TrackRefreshManager", "track endTrack");
    if (edb()) {
      et(this.yFs, paramInt);
    }
    if (!Util.isNullOrNil(this.rgD))
    {
      com.tencent.mm.plugin.location.a.a locala = n.ecS().aCZ(this.rgD);
      if (locala != null)
      {
        locala.dTe.remove(z.aTY());
        n.ecS().a(this.rgD, locala.dTe, locala.latitude, locala.longitude, locala.yFq, null, null);
      }
    }
    n.ecS().aDa("");
    this.yFs = "";
    this.rgD = "";
    this.yGL = false;
    this.yGM = false;
    this.yFu = -1000.0D;
    this.yFv = -1000.0D;
    this.yFw = -1;
    this.yGQ = -1;
    AppMethodBeat.o(55764);
  }
  
  public final String bgL()
  {
    return this.rgD;
  }
  
  public final boolean ecV()
  {
    AppMethodBeat.i(55762);
    if ((edb()) && (this.yGL))
    {
      AppMethodBeat.o(55762);
      return true;
    }
    AppMethodBeat.o(55762);
    return false;
  }
  
  public final void ecX()
  {
    AppMethodBeat.i(55766);
    Log.d("MicorMsg.TrackRefreshManager", "resume refresh");
    this.yGO = false;
    ecW();
    AppMethodBeat.o(55766);
  }
  
  public final List<String> ecY()
  {
    AppMethodBeat.i(55767);
    LinkedList localLinkedList = n.ecS().PY(this.rgD);
    AppMethodBeat.o(55767);
    return localLinkedList;
  }
  
  public final void ecZ()
  {
    if (this.yGI == 1) {
      this.yGI = 3;
    }
    while (this.yGI != 3) {
      return;
    }
    this.yGI = 2;
  }
  
  public final void eda()
  {
    boolean bool = true;
    AppMethodBeat.i(55768);
    if ((!this.isStart) || (!this.yGL) || (this.yGK == null))
    {
      localObject1 = new StringBuilder("error to exit refresh isStart: ").append(this.isStart).append(" isShared: ").append(this.yGL).append(" ");
      if (this.yGK == null) {}
      for (;;)
      {
        Log.e("MicorMsg.TrackRefreshManager", bool);
        AppMethodBeat.o(55768);
        return;
        bool = false;
      }
    }
    if ((this.yGJ == null) || (this.yGJ.NmV.KUu == -1000.0D) || (this.yGJ.NmV.KUt == -1000.0D))
    {
      Log.e("MicorMsg.TrackRefreshManager", "error to get my location ");
      this.mHandler.sendEmptyMessageDelayed(1, this.yGF);
      AppMethodBeat.o(55768);
      return;
    }
    Object localObject2 = z.aTY();
    Object localObject1 = new ejg();
    ((ejg)localObject1).MCE = this.yGK.yFx;
    ((ejg)localObject1).KUu = this.yGK.yFu;
    ((ejg)localObject1).KUt = this.yGK.yFv;
    ((ejg)localObject1).Name = ((String)localObject2);
    this.yGJ.Username = ((String)localObject2);
    this.yGJ.NmV.MIv = n.ecT().ecL();
    localObject2 = new StringBuffer();
    ((StringBuffer)localObject2).append("refreshLoopImpl, [trackRoomId:" + this.yFs + "]");
    switch (this.yGI)
    {
    }
    for (;;)
    {
      ((StringBuffer)localObject2).append("[ mMyPosiItem " + this.yGJ.NmV.KUu + " " + this.yGJ.NmV.KUt + " " + this.yGJ.NmV.MIv + " ]");
      Log.d("MicorMsg.TrackRefreshManager", ((StringBuffer)localObject2).toString());
      localObject2 = this.yFs;
      int i = this.yGI;
      eox localeox = this.yGJ;
      int j = this.qwL + 1;
      this.qwL = j;
      localObject1 = new c((String)localObject2, i, localeox, j, (ejg)localObject1);
      g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      AppMethodBeat.o(55768);
      return;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUpload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomDownload ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
      continue;
      ((StringBuffer)localObject2).append("track upload_status  MMRefreshTrackRoomFirstUpload ");
      ((StringBuffer)localObject2).append("[ trackItem " + ((ejg)localObject1).KUu + " " + ((ejg)localObject1).KUt + " ]");
    }
  }
  
  public final boolean edb()
  {
    AppMethodBeat.i(55769);
    if (!Util.isNullOrNil(this.yFs))
    {
      AppMethodBeat.o(55769);
      return true;
    }
    AppMethodBeat.o(55769);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(55770);
    Log.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    WeakReference localWeakReference;
    if (paramq.getType() == 490)
    {
      if ((paramInt2 == 0) || (paramInt2 >= 1000))
      {
        this.yFs = ((com.tencent.mm.plugin.location.model.a.b)paramq).yFs;
        n.ecS().aDa(this.yFs);
        if (edb())
        {
          Log.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[] { this.yFs });
          paramString = com.tencent.mm.bi.d.jpA.PY(this.rgD);
          paramString.add(z.aTY());
          if (this.yGK != null) {
            com.tencent.mm.bi.d.jpA.a(this.rgD, paramString, this.yGK.yFu, this.yGK.yFv, this.yGK.yFx, "", "");
          }
          while (this.yGH != null)
          {
            paramString = this.yGH.iterator();
            while (paramString.hasNext())
            {
              paramq = (WeakReference)paramString.next();
              if ((paramq != null) && (paramq.get() != null)) {
                ((b)paramq.get()).edc();
              }
            }
            com.tencent.mm.bi.d.jpA.a(this.rgD, paramString, -1000.0D, -1000.0D, "", "", "");
          }
          eda();
          AppMethodBeat.o(55770);
        }
      }
      else
      {
        if ((paramInt2 == 17) && (this.yGH != null))
        {
          paramString = this.yGH.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).edd();
            }
          }
        }
        if (this.yGH != null)
        {
          paramString = this.yGH.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b)paramq).qwG);
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
        this.yGE += 1;
        this.mHandler.removeMessages(1);
        if (this.yGE >= 10)
        {
          this.mHandler.removeMessages(1);
          if (this.yGH != null)
          {
            paramString = this.yGH.iterator();
            while (paramString.hasNext())
            {
              localWeakReference = (WeakReference)paramString.next();
              if ((localWeakReference != null) && (localWeakReference.get() != null)) {
                ((b)localWeakReference.get()).onError(1, ((c)paramq).qwG);
              }
            }
            AppMethodBeat.o(55770);
          }
        }
        else if ((edb()) && (!this.yGO))
        {
          paramString = ((c)paramq).yHe;
          if ((paramString != null) && (paramString.BaseResponse != null))
          {
            if (paramString.BaseResponse.Ret != 12) {
              break label696;
            }
            this.isTimeout = true;
            if (this.yGP != null) {
              this.yGP.bTS();
            }
          }
          for (;;)
          {
            Log.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.Ret) });
            if (!this.isTimeout) {
              this.mHandler.sendEmptyMessageDelayed(1, this.yGF);
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
        paramString = ((c)paramq).yHe;
        if ((paramString != null) && (paramString.BaseResponse != null))
        {
          if (paramString.BaseResponse.Ret != 12) {
            break label964;
          }
          this.isTimeout = true;
          if (this.yGP != null) {
            this.yGP.bTS();
          }
        }
        for (;;)
        {
          Log.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[] { Boolean.valueOf(this.isTimeout), Integer.valueOf(paramString.BaseResponse.Ret) });
          if (this.yGE > 0) {
            h.CyF.a(10997, new Object[] { "9", "", Integer.valueOf(this.yGE), Integer.valueOf(0) });
          }
          this.yGE = 0;
          this.yGF = ((c)paramq).yHb;
          paramInt1 = ((c)paramq).yHf;
          if ((this.yGH == null) || ((paramInt1 != 2) && (paramInt1 != 1) && (paramInt1 != 3))) {
            break;
          }
          paramString = this.yGH.iterator();
          while (paramString.hasNext())
          {
            localWeakReference = (WeakReference)paramString.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((b)localWeakReference.get()).a(((c)paramq).yHe);
            }
          }
          label964:
          this.isTimeout = false;
        }
        if (this.yGI == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            ecZ();
          }
          this.mHandler.removeMessages(1);
          if ((edb()) && (!this.yGO) && (!this.isTimeout)) {
            this.mHandler.sendEmptyMessageDelayed(1, this.yGF);
          }
          AppMethodBeat.o(55770);
          return;
        }
      }
      if (paramq.getType() == 491) {
        n.ecS().aDa("");
      }
    }
    AppMethodBeat.o(55770);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(55761);
    Log.i("MicorMsg.TrackRefreshManager", "stop location");
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    if (this.yGG != null) {
      this.yGG.b(this.yGU);
    }
    g.azz().b(492, this);
    g.azz().b(490, this);
    g.azz().b(491, this);
    this.yGI = 1;
    this.isStart = false;
    this.yGQ = -1;
    AppMethodBeat.o(55761);
  }
  
  public static abstract interface a
  {
    public abstract void bTS();
  }
  
  public static abstract interface b
  {
    public abstract void a(dmb paramdmb);
    
    public abstract void edc();
    
    public abstract void edd();
    
    public abstract void onError(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.q
 * JD-Core Version:    0.7.0.1
 */