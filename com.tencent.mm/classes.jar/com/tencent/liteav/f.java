package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a.a.b;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class f
  extends n
  implements TXCRenderAndDec.a, TXCRenderAndDec.b, com.tencent.liteav.audio.c, d, com.tencent.liteav.basic.b.b, com.tencent.liteav.network.f, com.tencent.liteav.renderer.a.a, g
{
  private com.tencent.liteav.renderer.h A;
  private com.tencent.liteav.renderer.h B;
  private float[] C;
  private float[] D;
  private String E;
  private int F;
  private boolean G;
  private com.tencent.liteav.basic.a.b H;
  private Object I;
  private com.tencent.liteav.basic.b.a J;
  private TXLivePlayer.ITXAudioRawDataListener K;
  private String L;
  private boolean M;
  private long N;
  private long O;
  private a P;
  private TXCRenderAndDec e;
  private com.tencent.liteav.renderer.a f;
  private TXCStreamDownloader g;
  private Handler h;
  private TextureView i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private Surface p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private com.tencent.liteav.a.a v;
  private TXRecordCommon.ITXVideoRecordListener w;
  private e x;
  private int y;
  private int z;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(221703);
    this.e = null;
    this.f = null;
    this.g = null;
    this.j = false;
    this.k = false;
    this.l = 100;
    this.m = 0;
    this.n = 0;
    this.o = false;
    this.q = 2;
    this.r = 48000;
    this.s = 16;
    this.t = false;
    this.u = false;
    this.y = 0;
    this.z = 0;
    this.A = null;
    this.B = null;
    this.C = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.D = new float[16];
    this.E = "";
    this.G = false;
    this.H = com.tencent.liteav.basic.a.b.a;
    this.I = null;
    this.J = new com.tencent.liteav.basic.b.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(221382);
        TXCLog.e("TXCLivePlayer", "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        paramAnonymousString1 = f.this.d;
        if (paramAnonymousString1 == null)
        {
          paramAnonymousString1 = null;
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1 = new Bundle();
            paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
            paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (paramAnonymousString2 != null)
            {
              paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
              if (paramAnonymousString3 == null) {
                break label158;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          f.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(221382);
          return;
          paramAnonymousString1 = (com.tencent.liteav.basic.b.b)paramAnonymousString1.get();
          break;
          label158:
          paramAnonymousString3 = "";
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(221381);
        TXCLog.i("TXCLivePlayer", "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        paramAnonymousString1 = f.this.d;
        if (paramAnonymousString1 == null)
        {
          paramAnonymousString1 = null;
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1 = new Bundle();
            paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
            paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (paramAnonymousString2 != null)
            {
              paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
              if (paramAnonymousString3 == null) {
                break label158;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          f.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(221381);
          return;
          paramAnonymousString1 = (com.tencent.liteav.basic.b.b)paramAnonymousString1.get();
          break;
          label158:
          paramAnonymousString3 = "";
        }
      }
    };
    this.L = "";
    this.M = false;
    this.N = 0L;
    this.O = 0L;
    this.P = null;
    com.tencent.liteav.basic.d.c.a().a(paramContext);
    TXCAudioEngine.CreateInstance(paramContext, com.tencent.liteav.basic.d.c.a().c());
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.J));
    long l1 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.h = new Handler(Looper.getMainLooper());
    this.f = new com.tencent.liteav.renderer.a();
    this.f.a(this);
    this.P = new a(this);
    AppMethodBeat.o(221703);
  }
  
  private void a(final int paramInt, String paramString)
  {
    AppMethodBeat.i(221743);
    if (this.d != null)
    {
      final Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      if (paramString != null) {
        localBundle.putCharSequence("EVT_MSG", paramString);
      }
      if (this.h != null) {
        this.h.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(221435);
            com.tencent.liteav.basic.util.f.a(f.this.d, paramInt, localBundle);
            AppMethodBeat.o(221435);
          }
        });
      }
    }
    AppMethodBeat.o(221743);
  }
  
  private int b(String paramString, int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(221731);
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
      this.g.setID(this.L);
      this.g.setListener(this);
      this.g.setNotifyListener(this);
      this.g.setHeaders(this.a.p);
      if (paramInt == 5) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label211;
      }
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    for (;;)
    {
      paramInt = this.g.start(paramString, this.a.i, this.a.m, this.a.j, this.a.k);
      AppMethodBeat.o(221731);
      return paramInt;
      if (paramInt == 5)
      {
        this.g = new TXCStreamDownloader(this.b, 4);
        break;
      }
      this.g = new TXCStreamDownloader(this.b, 0);
      if (TextUtils.isEmpty(this.a.l)) {
        break;
      }
      this.g.setFlvSessionKey(this.a.l);
      break;
      label211:
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(221735);
    this.L = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.e != null) {
      this.e.setID(this.L);
    }
    if (this.f != null) {
      this.f.setID(this.L);
    }
    if (this.g != null) {
      this.g.setID(this.L);
    }
    if (this.x != null) {
      this.x.d(this.L);
    }
    AppMethodBeat.o(221735);
  }
  
  private void f(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(221727);
    if (this.i != null) {
      this.i.setVisibility(0);
    }
    this.e = new TXCRenderAndDec(this.b);
    this.e.setNotifyListener(this);
    this.e.setVideoRender(this.f);
    this.e.setDecListener(this);
    this.e.setRenderAndDecDelegate(this);
    this.e.setConfig(this.a);
    this.e.setID(this.L);
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (paramInt == 5) {
      bool = true;
    }
    localTXCRenderAndDec.start(bool);
    this.e.setRenderMode(this.n);
    this.e.setRenderRotation(this.m);
    AppMethodBeat.o(221727);
  }
  
  private void j()
  {
    AppMethodBeat.i(221724);
    if (this.v == null)
    {
      this.y = this.f.i();
      this.z = this.f.j();
      com.tencent.liteav.a.a.a locala = l();
      this.v = new com.tencent.liteav.a.a(this.b);
      this.v.a(locala);
      this.v.a(new a.b()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(222586);
          TXRecordCommon.TXRecordResult localTXRecordResult;
          if (f.a(f.this) != null)
          {
            localTXRecordResult = new TXRecordCommon.TXRecordResult();
            if (paramAnonymousInt != 0) {
              break label95;
            }
          }
          label95:
          for (localTXRecordResult.retCode = 0;; localTXRecordResult.retCode = -1)
          {
            localTXRecordResult.descMsg = paramAnonymousString1;
            localTXRecordResult.videoPath = paramAnonymousString2;
            localTXRecordResult.coverPath = paramAnonymousString3;
            f.a(f.this).onRecordComplete(localTXRecordResult);
            f.b(f.this).a(null);
            f.b(f.this).a(null);
            AppMethodBeat.o(222586);
            return;
          }
        }
        
        public void a(long paramAnonymousLong)
        {
          AppMethodBeat.i(222587);
          if (f.a(f.this) != null) {
            f.a(f.this).onRecordProgress(paramAnonymousLong);
          }
          AppMethodBeat.o(222587);
        }
      });
    }
    if (this.A == null)
    {
      this.A = new com.tencent.liteav.renderer.h(Boolean.TRUE);
      this.A.b();
      this.A.b(this.y, this.z);
      this.A.a(this.y, this.z);
    }
    if (this.B == null)
    {
      this.B = new com.tencent.liteav.renderer.h(Boolean.FALSE);
      this.B.b();
      this.B.b(this.f.g(), this.f.h());
      this.B.a(this.f.g(), this.f.h());
      Matrix.setIdentityM(this.D, 0);
    }
    AppMethodBeat.o(221724);
  }
  
  private void k()
  {
    AppMethodBeat.i(221725);
    if (this.A != null)
    {
      this.A.c();
      this.A = null;
    }
    if (this.B != null)
    {
      this.B.c();
      this.B = null;
    }
    AppMethodBeat.o(221725);
  }
  
  private com.tencent.liteav.a.a.a l()
  {
    AppMethodBeat.i(221726);
    int i3 = 480;
    int i4 = 640;
    int i2 = i4;
    int i1 = i3;
    if (this.y > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.z > 0)
      {
        i1 = this.y;
        i2 = this.z;
      }
    }
    com.tencent.liteav.a.a.a locala = new com.tencent.liteav.a.a.a();
    locala.a = i1;
    locala.b = i2;
    locala.c = 20;
    double d = i1 * i1;
    locala.d = ((int)(Math.sqrt(i2 * i2 + d * 1.0D) * 1.2D));
    locala.h = this.q;
    locala.i = this.r;
    locala.j = this.s;
    locala.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
    locala.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
    locala.e = this.f.b();
    TXCLog.d("TXCLivePlayer", "record config: ".concat(String.valueOf(locala)));
    AppMethodBeat.o(221726);
    return locala;
  }
  
  private void m()
  {
    AppMethodBeat.i(221728);
    if (this.e != null)
    {
      this.e.stop();
      this.e.setVideoRender(null);
      this.e.setDecListener(null);
      this.e.setNotifyListener(null);
      this.e = null;
    }
    AppMethodBeat.o(221728);
  }
  
  private void n()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(221729);
    boolean bool1;
    if (this.F == 5)
    {
      bool1 = true;
      TXCAudioEngine.getInstance();
      TXCAudioEngine.enableAudioVolumeEvaluation(this.G, 300);
      a(this.K);
      if (this.F != 5) {
        break label189;
      }
      localTXCAudioEngine = TXCAudioEngine.getInstance();
      str = this.L;
      if (this.a.g) {
        break label184;
      }
    }
    for (;;)
    {
      localTXCAudioEngine.setRemoteAudioCacheParams(str, bool2, (int)(com.tencent.liteav.basic.a.a.b * 1000.0F), (int)(com.tencent.liteav.basic.a.a.b * 1000.0F), (int)(com.tencent.liteav.basic.a.a.c * 1000.0F));
      TXCAudioEngine.getInstance().muteRemoteAudio(this.L, this.j);
      TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.L, this.k);
      TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.L, this.l);
      TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.L, this);
      x();
      TXCAudioEngine.getInstance().startRemoteAudio(this.L, bool1);
      AppMethodBeat.o(221729);
      return;
      bool1 = false;
      break;
      label184:
      bool2 = false;
    }
    label189:
    TXCAudioEngine localTXCAudioEngine = TXCAudioEngine.getInstance();
    String str = this.L;
    if (!this.a.g) {}
    for (bool2 = bool3;; bool2 = false)
    {
      localTXCAudioEngine.setRemoteAudioCacheParams(str, bool2, (int)(this.a.a * 1000.0F), (int)(this.a.c * 1000.0F), (int)(this.a.b * 1000.0F));
      break;
    }
  }
  
  private void o()
  {
    AppMethodBeat.i(221730);
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.L, null);
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.L, null);
    TXCAudioEngine.getInstance().stopRemoteAudio(this.L);
    AppMethodBeat.o(221730);
  }
  
  private void p()
  {
    AppMethodBeat.i(221732);
    if (this.g != null)
    {
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
    AppMethodBeat.o(221732);
  }
  
  private void q()
  {
    AppMethodBeat.i(221733);
    this.x = new e(this.b);
    this.x.a(this.E);
    e locale = this.x;
    if (this.F == 5) {}
    for (boolean bool = true;; bool = false)
    {
      locale.a(bool);
      this.x.d(this.L);
      this.x.e(this.g.getRTMPProxyUserId());
      this.x.a();
      AppMethodBeat.o(221733);
      return;
    }
  }
  
  private void r()
  {
    AppMethodBeat.i(221734);
    if (this.x != null)
    {
      this.x.c();
      this.x = null;
    }
    AppMethodBeat.o(221734);
  }
  
  private void s()
  {
    AppMethodBeat.i(221737);
    this.M = false;
    x();
    AppMethodBeat.o(221737);
  }
  
  private void t()
  {
    AppMethodBeat.i(221738);
    if (this.N > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_PLAY_PROGRESS", (int)(this.N / 1000L));
      localBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.N);
      onNotifyEvent(2005, localBundle);
    }
    if ((this.h != null) && (this.M)) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222017);
          if (f.c(f.this)) {
            f.d(f.this);
          }
          AppMethodBeat.o(222017);
        }
      }, 1000L);
    }
    AppMethodBeat.o(221738);
  }
  
  private void u()
  {
    AppMethodBeat.i(221739);
    if (this.h != null) {
      this.h.postDelayed(this.P, 2000L);
    }
    AppMethodBeat.o(221739);
  }
  
  private void v()
  {
    AppMethodBeat.i(221740);
    if (this.h != null) {
      this.h.removeCallbacks(this.P);
    }
    AppMethodBeat.o(221740);
  }
  
  private void w()
  {
    AppMethodBeat.i(221742);
    ArrayList localArrayList = new ArrayList();
    if (this.L != null) {
      localArrayList.add(this.L);
    }
    a.a("18446744073709551615", localArrayList);
    AppMethodBeat.o(221742);
  }
  
  private void x()
  {
    AppMethodBeat.i(221744);
    if ((this.t) || (this.K != null) || (this.M)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.L, this);
    }
    if ((!this.t) && (this.K == null) && (!this.M)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.L, null);
    }
    AppMethodBeat.o(221744);
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(221747);
    paramArrayOfFloat = this.v;
    if ((this.t) && (paramArrayOfFloat != null) && (this.A != null))
    {
      int i1 = this.A.d(paramInt);
      paramArrayOfFloat.a(i1, TXCTimeUtil.getTimeTick());
      this.f.a(i1, this.y, this.z, false, 0);
    }
    if (this.t) {
      j();
    }
    for (;;)
    {
      AppMethodBeat.o(221747);
      return paramInt;
      k();
    }
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(221710);
    if ((c()) && (this.g != null))
    {
      boolean bool = this.g.switchStream(paramString);
      if (this.e != null) {
        TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.e.getVideoCacheDuration() + " audio cache " + TXCStatus.c(this.L, 2007));
      }
      if (bool)
      {
        this.E = paramString;
        AppMethodBeat.o(221710);
        return 0;
      }
      AppMethodBeat.o(221710);
      return -2;
    }
    AppMethodBeat.o(221710);
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(221708);
    if (c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
      AppMethodBeat.o(221708);
      return -2;
    }
    if ((this.a != null) && (this.a.c > this.a.b))
    {
      TXCLog.e("TXCLivePlayer", "play: can not start play while invalid cache config [minAutoAdjustCacheTime(" + this.a.c + ") > maxAutoAdjustCacheTime(" + this.a.b + ")]!!!!!!");
      AppMethodBeat.o(221708);
      return -1;
    }
    if ((this.a.a > this.a.b) || (this.a.a < this.a.c))
    {
      TXCLog.w("TXCLivePlayer", "play: invalid cacheTime " + this.a.a + ", need between minAutoAdjustCacheTime " + this.a.c + " and maxAutoAdjustCacheTime " + this.a.b + " , fix to maxAutoAdjustCacheTime");
      this.a.a = this.a.b;
    }
    this.E = paramString;
    this.F = paramInt;
    b(paramString);
    this.o = true;
    this.u = true;
    f(paramInt);
    n();
    paramInt = b(paramString, paramInt);
    if (paramInt != 0)
    {
      this.o = false;
      p();
      m();
      o();
      if (this.i != null) {
        this.i.setVisibility(8);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(221708);
      return paramInt;
      a(this.p);
      q();
      u();
      if ((this.H == com.tencent.liteav.basic.a.b.c) && (this.i == null) && (this.f != null)) {
        this.f.c(this.I);
      }
      TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bt);
      try
      {
        if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
          TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bE);
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public int a(boolean paramBoolean)
  {
    AppMethodBeat.i(221709);
    if (!c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
      AppMethodBeat.o(221709);
      return -2;
    }
    TXCLog.v("TXCLivePlayer", "play: stop");
    this.o = false;
    p();
    m();
    if ((this.i != null) && (paramBoolean)) {
      this.i.setVisibility(8);
    }
    if (this.f != null) {
      this.f.a(null);
    }
    if ((this.i == null) && (this.f != null)) {
      this.f.e();
    }
    o();
    r();
    v();
    s();
    AppMethodBeat.o(221709);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(221711);
    a(false);
    AppMethodBeat.o(221711);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(221713);
    this.n = paramInt;
    if (this.e != null) {
      this.e.setRenderMode(paramInt);
    }
    AppMethodBeat.o(221713);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221706);
    if (this.f != null) {
      this.f.c(paramInt1, paramInt2);
    }
    AppMethodBeat.o(221706);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(221718);
    TXCAudioEngine.getInstance();
    TXCAudioEngine.setAudioRoute(paramInt);
    AppMethodBeat.o(221718);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(221749);
    k();
    d();
    AppMethodBeat.o(221749);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(221705);
    this.p = paramSurface;
    if (this.f != null) {
      this.f.a(paramSurface);
    }
    AppMethodBeat.o(221705);
  }
  
  public void a(com.tencent.liteav.basic.c.o paramo)
  {
    AppMethodBeat.i(221723);
    if (this.f != null) {
      this.f.a(paramo);
    }
    AppMethodBeat.o(221723);
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(221707);
    super.a(paramh);
    if (this.e != null) {
      this.e.setConfig(paramh);
    }
    AppMethodBeat.o(221707);
  }
  
  public void a(o paramo, com.tencent.liteav.basic.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(221722);
    this.H = paramb;
    this.I = paramObject;
    if ((c()) && (this.H == com.tencent.liteav.basic.a.b.c) && (this.i == null) && (paramo != null) && (this.f != null)) {
      this.f.c(this.I);
    }
    if (this.e != null)
    {
      this.e.setVideoFrameListener(paramo, paramb);
      AppMethodBeat.o(221722);
      return;
    }
    TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
    AppMethodBeat.o(221722);
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(221720);
    this.K = paramITXAudioRawDataListener;
    x();
    AppMethodBeat.o(221720);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(221704);
    if ((this.c != null) && (this.c != paramTXCloudVideoView))
    {
      TextureView localTextureView = this.c.getVideoView();
      if (localTextureView != null) {
        this.c.removeView(localTextureView);
      }
    }
    super.a(paramTXCloudVideoView);
    if (this.c != null)
    {
      this.i = this.c.getVideoView();
      if (this.i == null) {
        this.i = new TextureView(this.c.getContext());
      }
      this.c.addVideoView(this.i);
    }
    if (this.f != null) {
      this.f.a(this.i);
    }
    AppMethodBeat.o(221704);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.w = paramITXVideoRecordListener;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(221752);
    this.G = paramBoolean;
    TXCAudioEngine.getInstance();
    TXCAudioEngine.enableAudioVolumeEvaluation(paramBoolean, paramInt);
    AppMethodBeat.o(221752);
  }
  
  public void b()
  {
    AppMethodBeat.i(221712);
    a(this.E, this.F);
    AppMethodBeat.o(221712);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(221714);
    this.m = paramInt;
    if (this.e != null) {
      this.e.setRenderRotation(paramInt);
    }
    AppMethodBeat.o(221714);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(221715);
    this.j = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudio(this.L, this.j);
    AppMethodBeat.o(221715);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(221717);
    this.l = paramInt;
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.L, this.l);
    AppMethodBeat.o(221717);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(221716);
    this.k = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.L, paramBoolean);
    AppMethodBeat.o(221716);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public int d()
  {
    AppMethodBeat.i(221721);
    if (!this.t)
    {
      TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
      AppMethodBeat.o(221721);
      return -1;
    }
    this.t = false;
    x();
    if (this.v != null)
    {
      this.v.a();
      this.v = null;
    }
    AppMethodBeat.o(221721);
    return 0;
  }
  
  public int d(int paramInt)
  {
    AppMethodBeat.i(221719);
    if (this.t)
    {
      TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
      AppMethodBeat.o(221719);
      return -1;
    }
    this.t = true;
    this.f.a(this);
    this.f.a(this);
    x();
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.av);
    AppMethodBeat.o(221719);
    return 0;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    AppMethodBeat.i(221736);
    this.O = 0L;
    if (this.M)
    {
      AppMethodBeat.o(221736);
      return;
    }
    this.M = true;
    x();
    if (this.h != null) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222646);
          if (f.c(f.this)) {
            f.d(f.this);
          }
          AppMethodBeat.o(222646);
        }
      }, 1000L);
    }
    AppMethodBeat.o(221736);
  }
  
  public void g()
  {
    AppMethodBeat.i(221741);
    w();
    Object localObject = com.tencent.liteav.basic.util.f.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    int i3 = TXCStatus.c(this.L, 7102);
    int i4 = TXCStatus.c(this.L, 7101);
    String str = TXCStatus.b(this.L, 7110);
    i2 = (int)TXCStatus.d(this.L, 6002);
    Bundle localBundle = new Bundle();
    if (this.f != null)
    {
      localBundle.putInt("VIDEO_WIDTH", this.f.i());
      localBundle.putInt("VIDEO_HEIGHT", this.f.j());
    }
    if (this.e != null)
    {
      localBundle.putInt("VIDEO_CACHE", (int)this.e.getVideoCacheDuration());
      localBundle.putInt("V_SUM_CACHE_SIZE", (int)this.e.getVideoCacheFrameCount());
      localBundle.putInt("V_DEC_CACHE_SIZE", this.e.getVideoDecCacheFrameCount());
      localBundle.putInt("AV_PLAY_INTERVAL", (int)this.e.getAVPlayInterval());
      localBundle.putInt("AV_RECV_INTERVAL", (int)this.e.getAVNetRecvInterval());
      if (i2 != 0) {
        break label562;
      }
    }
    label562:
    for (i1 = 15;; i1 = i2)
    {
      localBundle.putInt("VIDEO_GOP", (int)(TXCStatus.c(this.L, 7120) * 10 / i1 / 10.0F + 0.5D));
      i1 = TXCAudioEngine.getInstance().getPlayAECType();
      int i5 = TXCStatus.c(this.L, 2019);
      int i6 = TXCStatus.c(this.L, 2020);
      int i7 = TXCAudioEngine.getInstance().getPlaySampleRate();
      int i8 = TXCAudioEngine.getInstance().getPlayChannels();
      localBundle.putString("AUDIO_PLAY_INFO", i1 + " | " + i5 + "," + i6 + " | " + i7 + "," + i8);
      localBundle.putInt("AUDIO_CACHE", TXCStatus.c(this.L, 2007));
      localBundle.putInt("NET_JITTER", TXCStatus.c(this.L, 2018));
      localBundle.putFloat("AUDIO_CACHE_THRESHOLD", TXCStatus.c(this.L, 2021) / 1000.0F);
      localBundle.putInt("NET_SPEED", i4 + i3);
      localBundle.putInt("VIDEO_FPS", i2);
      localBundle.putInt("VIDEO_BITRATE", i4);
      localBundle.putInt("AUDIO_BITRATE", i3);
      localBundle.putCharSequence("SERVER_IP", str);
      localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
      com.tencent.liteav.basic.util.f.a(this.d, 15001, localBundle);
      if (this.e != null) {
        this.e.updateLoadInfo();
      }
      if (this.x != null) {
        this.x.f();
      }
      AppMethodBeat.o(221741);
      return;
    }
  }
  
  public int h()
  {
    AppMethodBeat.i(221753);
    int i1 = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(this.L);
    AppMethodBeat.o(221753);
    return i1;
  }
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(221751);
    onNotifyEvent(paramInt, null);
    AppMethodBeat.o(221751);
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221750);
    this.r = paramInt1;
    this.q = paramInt2;
    long l1 = paramLong;
    if (this.v != null)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = TXCTimeUtil.getTimeTick();
      }
      this.v.a(paramArrayOfByte, l1);
    }
    if ((this.O <= 0L) && (this.K != null)) {
      this.K.onAudioInfoChanged(paramInt1, paramInt2, 16);
    }
    if (this.K != null) {
      this.K.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    if (this.O <= 0L)
    {
      this.O = l1;
      AppMethodBeat.o(221750);
      return;
    }
    this.N = (l1 - this.O);
    AppMethodBeat.o(221750);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(221746);
    if ((2003 == paramInt) || (2026 == paramInt))
    {
      if (this.u)
      {
        a(2004, "Video play started");
        this.u = false;
      }
      if (2026 == paramInt)
      {
        TXCStatus.a(this.L, 2033, Long.valueOf(TXCTimeUtil.getTimeTick()));
        AppMethodBeat.o(221746);
        return;
      }
    }
    if (2025 == paramInt)
    {
      a(2004, "Video play started");
      AppMethodBeat.o(221746);
      return;
    }
    if ((2023 == paramInt) || (2024 == paramInt))
    {
      a(2007, "Video play loading");
      AppMethodBeat.o(221746);
      return;
    }
    if (this.h != null) {
      this.h.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221380);
          com.tencent.liteav.basic.util.f.a(f.this.d, paramInt, paramBundle);
          if ((paramInt == 2103) && (f.f(f.this) != null)) {
            f.f(f.this).restartDecoder();
          }
          AppMethodBeat.o(221380);
        }
      });
    }
    AppMethodBeat.o(221746);
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama) {}
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(221745);
    if (!this.o)
    {
      AppMethodBeat.o(221745);
      return;
    }
    try
    {
      if (this.e != null) {
        this.e.decVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(221745);
      return;
    }
    catch (Exception paramTXSNALPacket)
    {
      TXCLog.e("TXCLivePlayer", "decode video failed." + paramTXSNALPacket.getMessage());
      AppMethodBeat.o(221745);
    }
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt)
  {
    AppMethodBeat.i(221754);
    if ((this.o) && (this.g != null)) {
      this.g.requestKeyFrame(this.E);
    }
    AppMethodBeat.o(221754);
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221748);
    com.tencent.liteav.a.a locala = this.v;
    if ((this.t) && (locala != null) && (this.B != null))
    {
      this.B.a(this.C);
      locala.a(this.B.d(paramInt1), TXCTimeUtil.getTimeTick());
      this.B.a(this.D);
      this.B.c(paramInt1);
    }
    if (this.t)
    {
      j();
      AppMethodBeat.o(221748);
      return;
    }
    k();
    AppMethodBeat.o(221748);
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<f> a;
    
    a(f paramf)
    {
      AppMethodBeat.i(221778);
      this.a = new WeakReference(paramf);
      AppMethodBeat.o(221778);
    }
    
    public void run()
    {
      AppMethodBeat.i(221779);
      f localf = (f)this.a.get();
      if (localf == null)
      {
        AppMethodBeat.o(221779);
        return;
      }
      localf.g();
      f.e(localf);
      AppMethodBeat.o(221779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.f
 * JD-Core Version:    0.7.0.1
 */