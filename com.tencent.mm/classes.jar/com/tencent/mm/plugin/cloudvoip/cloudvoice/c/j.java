package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;
import java.util.Timer;

public enum j
{
  private String gxM = null;
  private final e iEs = new e();
  private f.a iFA;
  private f.a iFB;
  private f.a iFC;
  private f.a iFD;
  private boolean iFE;
  private PhoneStateListener iFF = new j.11(this);
  private boolean iFG = false;
  private boolean iFH = false;
  private boolean iFI = false;
  public Runnable iFJ = new j.7(this);
  private final l iFm = new l();
  private final f iFn = new f();
  private final c iFo = new c(this.iEs);
  private final ai iFp = new ai("openvoice_voip_worker");
  j.c iFq = j.c.iGt;
  private j.a iFr;
  private String iFs;
  private a<j.a> iFt;
  private a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> iFu;
  private a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> iFv;
  private f.a iFw;
  private f.a iFx;
  private f.a iFy;
  private f.a iFz;
  private boolean mIsInit;
  
  private j()
  {
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, j.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      y.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      q.fa((String)localObject);
    }
    for (;;)
    {
      this.iFE = false;
      this.mIsInit = false;
      return;
      y.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    }
  }
  
  static int N(byte[] paramArrayOfByte, int paramInt)
  {
    return g.M(paramArrayOfByte, paramInt);
  }
  
  private int a(j.a parama)
  {
    int j = 0;
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    if (this.iFq == j.c.iGt)
    {
      y.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: Not in room! just a hint and check where goes wrong");
      return 0;
    }
    this.iFr = parama;
    int i = j;
    switch (j.10.gyX[parama.ordinal()])
    {
    default: 
      i = j;
    }
    for (;;)
    {
      i = g.pr(i);
      parama = this.iFJ;
      this.iFp.k(parama, 180000L);
      return i;
      i = 1;
      continue;
      i = 6;
      continue;
      i = 8;
      continue;
      i = 7;
    }
  }
  
  private void a(a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> parama)
  {
    int k = 1;
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.iFG), Boolean.valueOf(this.iFH), Boolean.valueOf(this.iFI) });
    Object localObject;
    int i;
    boolean bool;
    if ((this.iFG) && (this.iFI) && (this.iFH))
    {
      this.iFq = j.c.iGu;
      localObject = this.iFo;
      if (((c)localObject).iEu == 2) {
        break label191;
      }
      y.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
      i = 0;
      bool = this.iFo.uq();
      j = k;
      if (i != 0)
      {
        j = k;
        if (bool) {
          j = 0;
        }
      }
      i.iFc = j;
      if (i != 0) {
        break label242;
      }
      localObject = this.iFo.iEp;
      if (((d)localObject).iEF == null) {
        break label242;
      }
      j = ((d)localObject).iEF.bPG();
      label156:
      i.iFe = j;
      if (!bool) {
        break label247;
      }
    }
    label191:
    label242:
    label247:
    for (int j = 0;; j = this.iFo.iEq.bCt)
    {
      i.iFd = j;
      if ((i == 0) || (!bool)) {
        break label261;
      }
      a(parama, 0, 0, "ok");
      return;
      if (((c)localObject).iEp.a(new c.2((c)localObject), ((c)localObject).mSampleRate, ((c)localObject).mChannels, ((c)localObject).iEC) <= 0)
      {
        ((c)localObject).iEy = 1;
        i = 0;
        break;
      }
      i = 1;
      break;
      j = 0;
      break label156;
    }
    label261:
    a(j.a.iGn);
    a(parama, -10086, -7, "start audio device failed");
  }
  
  private void a(a<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a>> parama, int paramInt1, int paramInt2, String paramString)
  {
    this.iFE = false;
    synchronized (this.iFn)
    {
      this.iFn.b(1, this.iFA);
      this.iFn.b(2, this.iFB);
      this.iFn.b(4, this.iFC);
      this.iFn.b(5, this.iFD);
      this.iFA = null;
      this.iFB = null;
      this.iFC = null;
      this.iFD = null;
      ??? = this.iEs.iEN;
      if (parama != null) {
        parama.a(paramInt1, paramInt2, paramString, ???);
      }
      return;
    }
  }
  
  static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a parama)
  {
    return g.pq(parama.iEo) == 1;
  }
  
  private void aEn()
  {
    this.iFG = false;
    this.iFH = false;
    this.iFI = false;
  }
  
  private void aEo()
  {
    this.iEs.iEN.clear();
    Object localObject2 = this.iEs;
    synchronized (((e)localObject2).iEP)
    {
      ((e)localObject2).iEP.clear();
      if (((e)localObject2).iEQ != null) {
        ((e)localObject2).iEQ.cancel();
      }
      localObject2 = this.iFo;
      d locald;
      if (((c)localObject2).iEp != null) {
        locald = ((c)localObject2).iEp;
      }
      synchronized (locald.iEG)
      {
        y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlay, isStart: %s %s", new Object[] { Boolean.valueOf(locald.bSr), Integer.valueOf(locald.hashCode()) });
        if (locald.bSr)
        {
          com.tencent.mm.plugin.voip.model.b localb = locald.iEF;
          if (localb != null)
          {
            locald.iEL.dzS = SystemClock.elapsedRealtime();
            localb.bPF();
            y.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "stopPlaying cost: " + locald.iEL.zJ());
            localb.bPC();
            locald.bSr = false;
            locald.iEF = null;
          }
        }
        ((c)localObject2).iEB = false;
        if (((c)localObject2).iEq != null)
        {
          ((c)localObject2).iEq.uh();
          ((c)localObject2).iEq = null;
          y.i("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "finish pauseRecord");
        }
        ((c)localObject2).iEu = c.iEt;
        ??? = ((c)localObject2).iEp;
        com.tencent.mm.compatible.b.f.yi().yx();
        com.tencent.mm.compatible.b.f.yi().setMode(0);
        ((d)???).iEH.ek(ae.getContext());
        com.tencent.mm.compatible.b.f.yi().yl();
        com.tencent.mm.compatible.b.f.yi().b((com.tencent.mm.compatible.b.f.a)???);
        ((d)???).eLi.zE();
        this.iFt = null;
        this.iFu = null;
        this.iFv = null;
      }
    }
    synchronized (this.iFn)
    {
      this.iFn.b(6, this.iFw);
      this.iFn.b(7, this.iFx);
      this.iFn.b(3, this.iFy);
      this.iFn.b(8, this.iFz);
      this.iFw = null;
      this.iFx = null;
      this.iFy = null;
      this.iFz = null;
      return;
      localObject3 = finally;
      throw localObject3;
      localObject4 = finally;
      throw localObject4;
    }
  }
  
  static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    return g.d(paramInt1, paramArrayOfByte, paramInt2);
  }
  
  private int eJ(boolean paramBoolean)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iFm.reset(this.gxM);
    i.iFc = 0;
    i.iFd = 0;
    i.iFe = 0;
    i.iFf = 0;
    i.iFg = 0;
    i.iFh = 0;
    i.iFi = 0;
    i.iFj = 0;
    i.iFk = 0;
    this.gxM = null;
    this.iFs = null;
    aEo();
    this.mIsInit = false;
    Object localObject = h.iEY;
    y.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    h.pt(1);
    this.iFn.eI(false);
    if (paramBoolean) {
      return g.aEm();
    }
    localObject = (TelephonyManager)ae.getContext().getSystemService("phone");
    if (localObject != null) {
      ((TelephonyManager)localObject).listen(this.iFF, 0);
    }
    return 0;
  }
  
  static void pv(int paramInt)
  {
    g.ps(paramInt);
  }
  
  static void q(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    g.p(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private int zv(String paramString)
  {
    IConfCallBack localIConfCallBack = this.iFn.eI(true);
    int i = g.a(this.iFs, paramString, localIConfCallBack);
    this.iFz = new j.13(this);
    this.iFn.a(8, this.iFz);
    return i;
  }
  
  public final void H(Runnable paramRunnable)
  {
    if (Thread.currentThread() == this.iFp.mnU.getLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    this.iFp.O(paramRunnable);
  }
  
  public final void a(a<String> parama, j.a parama1)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    H(new j.6(this, parama1, parama));
  }
  
  public final void a(boolean paramBoolean, a<String> parama)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    H(new j.8(this, parama, paramBoolean));
  }
  
  public final void b(boolean paramBoolean, a<String> parama)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    H(new j.9(this, parama, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j
 * JD-Core Version:    0.7.0.1
 */