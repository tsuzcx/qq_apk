package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a.a.b;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.basic.a.b;
import com.tencent.liteav.basic.d.o;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.lang.ref.WeakReference;

public class e
  extends m
  implements TXCRenderAndDec.a, TXCRenderAndDec.b, c, com.tencent.liteav.audio.d, com.tencent.liteav.basic.c.a, com.tencent.liteav.network.f, com.tencent.liteav.renderer.a.a, com.tencent.liteav.renderer.g
{
  private h A;
  private h B;
  private float[] C;
  private float[] D;
  private String E;
  private int F;
  private boolean G;
  private b H;
  private Object I;
  private TXLivePlayer.ITXAudioRawDataListener J;
  private String K;
  private boolean L;
  private long M;
  private long N;
  private a O;
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
  private d x;
  private int y;
  private int z;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(16559);
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
    this.H = b.a;
    this.I = null;
    this.K = "";
    this.L = false;
    this.M = 0L;
    this.N = 0L;
    this.O = null;
    com.tencent.liteav.audio.a.a(paramContext);
    this.h = new Handler(Looper.getMainLooper());
    this.f = new com.tencent.liteav.renderer.a();
    this.f.a(this);
    this.O = new a(this);
    AppMethodBeat.o(16559);
  }
  
  private void a(final int paramInt, String paramString)
  {
    AppMethodBeat.i(16597);
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
            AppMethodBeat.i(15534);
            com.tencent.liteav.basic.util.f.a(e.this.d, paramInt, localBundle);
            AppMethodBeat.o(15534);
          }
        });
      }
    }
    AppMethodBeat.o(16597);
  }
  
  private int b(String paramString, int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(16587);
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
      this.g.setID(this.K);
      this.g.setListener(this);
      this.g.setNotifyListener(this);
      this.g.setHeaders(this.a.o);
      if (paramInt == 5) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label184;
      }
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    for (;;)
    {
      paramInt = this.g.start(paramString, this.a.i, this.a.l, this.a.j, this.a.k);
      AppMethodBeat.o(16587);
      return paramInt;
      if (paramInt == 5)
      {
        this.g = new TXCStreamDownloader(this.b, 4);
        break;
      }
      this.g = new TXCStreamDownloader(this.b, 0);
      break;
      label184:
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(16591);
    this.K = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.e != null) {
      this.e.setID(this.K);
    }
    if (this.f != null) {
      this.f.setID(this.K);
    }
    if (this.g != null) {
      this.g.setID(this.K);
    }
    if (this.x != null) {
      this.x.d(this.K);
    }
    AppMethodBeat.o(16591);
  }
  
  private void f(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(16583);
    if (this.i != null) {
      this.i.setVisibility(0);
    }
    this.e = new TXCRenderAndDec(this.b);
    this.e.setNotifyListener(this);
    this.e.setVideoRender(this.f);
    this.e.setDecListener(this);
    this.e.setRenderAndDecDelegate(this);
    this.e.setConfig(this.a);
    this.e.setID(this.K);
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (paramInt == 5) {
      bool = true;
    }
    localTXCRenderAndDec.start(bool);
    this.e.setRenderMode(this.n);
    this.e.setRenderRotation(this.m);
    AppMethodBeat.o(16583);
  }
  
  private void j()
  {
    AppMethodBeat.i(16581);
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
          AppMethodBeat.i(16613);
          TXRecordCommon.TXRecordResult localTXRecordResult;
          if (e.a(e.this) != null)
          {
            localTXRecordResult = new TXRecordCommon.TXRecordResult();
            if (paramAnonymousInt != 0) {
              break label97;
            }
          }
          label97:
          for (localTXRecordResult.retCode = 0;; localTXRecordResult.retCode = -1)
          {
            localTXRecordResult.descMsg = paramAnonymousString1;
            localTXRecordResult.videoPath = paramAnonymousString2;
            localTXRecordResult.coverPath = paramAnonymousString3;
            e.a(e.this).onRecordComplete(localTXRecordResult);
            e.b(e.this).a(null);
            e.b(e.this).a(null);
            AppMethodBeat.o(16613);
            return;
          }
        }
        
        public void a(long paramAnonymousLong)
        {
          AppMethodBeat.i(16614);
          if (e.a(e.this) != null) {
            e.a(e.this).onRecordProgress(paramAnonymousLong);
          }
          AppMethodBeat.o(16614);
        }
      });
    }
    if (this.A == null)
    {
      this.A = new h(Boolean.TRUE);
      this.A.b();
      this.A.b(this.y, this.z);
      this.A.a(this.y, this.z);
    }
    if (this.B == null)
    {
      this.B = new h(Boolean.FALSE);
      this.B.b();
      this.B.b(this.f.g(), this.f.h());
      this.B.a(this.f.g(), this.f.h());
      Matrix.setIdentityM(this.D, 0);
    }
    AppMethodBeat.o(16581);
  }
  
  private void k()
  {
    AppMethodBeat.i(182276);
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
    AppMethodBeat.o(182276);
  }
  
  private com.tencent.liteav.a.a.a l()
  {
    AppMethodBeat.i(182277);
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
    AppMethodBeat.o(182277);
    return locala;
  }
  
  private void m()
  {
    AppMethodBeat.i(16585);
    if (this.e != null)
    {
      this.e.stop();
      this.e.setVideoRender(null);
      this.e.setDecListener(null);
      this.e.setNotifyListener(null);
      this.e = null;
    }
    AppMethodBeat.o(16585);
  }
  
  private void n()
  {
    AppMethodBeat.i(16586);
    com.tencent.liteav.audio.a.a().b(this.K);
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.a(this.G);
    a(this.J);
    if (this.F == 5)
    {
      com.tencent.liteav.audio.a.a().a(this.K, true);
      com.tencent.liteav.audio.a.a().a(this.K, com.tencent.liteav.basic.a.a.b);
      com.tencent.liteav.audio.a.a().c(this.K, com.tencent.liteav.basic.a.a.b);
      com.tencent.liteav.audio.a.a().b(this.K, com.tencent.liteav.basic.a.a.c);
      com.tencent.liteav.audio.a.a().b(this.K, this.a.g);
    }
    for (;;)
    {
      com.tencent.liteav.audio.a.a().c(this.K, this.j);
      com.tencent.liteav.audio.a.a().d(this.K, this.k);
      com.tencent.liteav.audio.a.a().a(this.K, this.l);
      com.tencent.liteav.audio.a.a().a(this.K, this);
      w();
      com.tencent.liteav.audio.a.a().c(this.K);
      AppMethodBeat.o(16586);
      return;
      com.tencent.liteav.audio.a.a().a(this.K, false);
      com.tencent.liteav.audio.a.a().a(this.K, this.a.a);
      com.tencent.liteav.audio.a.a().c(this.K, this.a.c);
      com.tencent.liteav.audio.a.a().b(this.K, this.a.b);
      com.tencent.liteav.audio.a.a().b(this.K, this.a.g);
    }
  }
  
  private void o()
  {
    AppMethodBeat.i(16588);
    com.tencent.liteav.audio.a.a().a(this.K, null);
    com.tencent.liteav.audio.a.a().a(this.K, null);
    com.tencent.liteav.audio.a.a().d(this.K);
    AppMethodBeat.o(16588);
  }
  
  private void p()
  {
    AppMethodBeat.i(16589);
    if (this.g != null)
    {
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
    AppMethodBeat.o(16589);
  }
  
  private void q()
  {
    AppMethodBeat.i(16590);
    this.x = new d(this.b);
    this.x.a(this.E);
    d locald = this.x;
    if (this.F == 5) {}
    for (boolean bool = true;; bool = false)
    {
      locald.a(bool);
      this.x.d(this.K);
      this.x.a();
      AppMethodBeat.o(16590);
      return;
    }
  }
  
  private void r()
  {
    AppMethodBeat.i(16593);
    if (this.x != null)
    {
      this.x.c();
      this.x = null;
    }
    AppMethodBeat.o(16593);
  }
  
  private void s()
  {
    AppMethodBeat.i(16594);
    this.L = false;
    w();
    AppMethodBeat.o(16594);
  }
  
  private void t()
  {
    AppMethodBeat.i(16595);
    if (this.M > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_PLAY_PROGRESS", (int)(this.M / 1000L));
      localBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.M);
      onNotifyEvent(2005, localBundle);
    }
    if ((this.h != null) && (this.L)) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14781);
          if (e.c(e.this)) {
            e.d(e.this);
          }
          AppMethodBeat.o(14781);
        }
      }, 1000L);
    }
    AppMethodBeat.o(16595);
  }
  
  private void u()
  {
    AppMethodBeat.i(182278);
    if (this.h != null) {
      this.h.postDelayed(this.O, 2000L);
    }
    AppMethodBeat.o(182278);
  }
  
  private void v()
  {
    AppMethodBeat.i(16596);
    if (this.h != null) {
      this.h.removeCallbacks(this.O);
    }
    AppMethodBeat.o(16596);
  }
  
  private void w()
  {
    AppMethodBeat.i(16598);
    if ((this.t) || (this.J != null) || (this.L)) {
      com.tencent.liteav.audio.a.a().a(this.K, this);
    }
    if ((!this.t) && (this.J == null) && (!this.L)) {
      com.tencent.liteav.audio.a.a().a(this.K, null);
    }
    AppMethodBeat.o(16598);
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(16601);
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
      AppMethodBeat.o(16601);
      return paramInt;
      k();
    }
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(16566);
    if ((c()) && (this.g != null))
    {
      boolean bool = this.g.switchStream(paramString);
      if (this.e != null) {
        TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.e.getVideoCacheDuration() + " audio cache " + TXCStatus.c(this.K, 2007));
      }
      if (bool)
      {
        this.E = paramString;
        AppMethodBeat.o(16566);
        return 0;
      }
      AppMethodBeat.o(16566);
      return -2;
    }
    AppMethodBeat.o(16566);
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(16564);
    if (c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
      AppMethodBeat.o(16564);
      return -2;
    }
    if ((this.a != null) && (this.a.c > this.a.b))
    {
      TXCLog.e("TXCLivePlayer", "play: can not start play while invalid cache config [minAutoAdjustCacheTime(" + this.a.c + ") > maxAutoAdjustCacheTime(" + this.a.b + ")]!!!!!!");
      AppMethodBeat.o(16564);
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
      AppMethodBeat.o(16564);
      return paramInt;
      a(this.p);
      q();
      u();
      if ((this.H == b.c) && (this.i == null) && (this.f != null)) {
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
    AppMethodBeat.i(16565);
    if (!c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
      AppMethodBeat.o(16565);
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
    AppMethodBeat.o(16565);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(16567);
    a(false);
    AppMethodBeat.o(16567);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16569);
    this.n = paramInt;
    if (this.e != null) {
      this.e.setRenderMode(paramInt);
    }
    AppMethodBeat.o(16569);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16562);
    if (this.f != null) {
      this.f.c(paramInt1, paramInt2);
    }
    AppMethodBeat.o(16562);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(16574);
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.c(paramInt);
    AppMethodBeat.o(16574);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16603);
    k();
    d();
    AppMethodBeat.o(16603);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(16561);
    this.p = paramSurface;
    if (this.f != null) {
      this.f.a(paramSurface);
    }
    AppMethodBeat.o(16561);
  }
  
  public void a(o paramo)
  {
    AppMethodBeat.i(221340);
    if (this.f != null) {
      this.f.a(paramo);
    }
    AppMethodBeat.o(221340);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(16563);
    super.a(paramg);
    if (this.e != null) {
      this.e.setConfig(paramg);
    }
    AppMethodBeat.o(16563);
  }
  
  public void a(n paramn, b paramb, Object paramObject)
  {
    AppMethodBeat.i(221339);
    this.H = paramb;
    this.I = paramObject;
    if ((c()) && (this.H == b.c) && (this.i == null) && (paramn != null) && (this.f != null)) {
      this.f.c(this.I);
    }
    if (this.e != null)
    {
      this.e.setVideoFrameListener(paramn, paramb);
      AppMethodBeat.o(221339);
      return;
    }
    TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
    AppMethodBeat.o(221339);
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(16576);
    this.J = paramITXAudioRawDataListener;
    w();
    AppMethodBeat.o(16576);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(16560);
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
    AppMethodBeat.o(16560);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.w = paramITXVideoRecordListener;
  }
  
  public void b()
  {
    AppMethodBeat.i(16568);
    a(this.E, this.F);
    AppMethodBeat.o(16568);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(16570);
    this.m = paramInt;
    if (this.e != null) {
      this.e.setRenderRotation(paramInt);
    }
    AppMethodBeat.o(16570);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16571);
    this.j = paramBoolean;
    com.tencent.liteav.audio.a.a().c(this.K, this.j);
    AppMethodBeat.o(16571);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16573);
    this.l = paramInt;
    com.tencent.liteav.audio.a.a().a(this.K, this.l);
    AppMethodBeat.o(16573);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(16572);
    this.k = paramBoolean;
    com.tencent.liteav.audio.a.a().d(this.K, paramBoolean);
    AppMethodBeat.o(16572);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public int d()
  {
    AppMethodBeat.i(16577);
    if (!this.t)
    {
      TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
      AppMethodBeat.o(16577);
      return -1;
    }
    this.t = false;
    w();
    if (this.v != null)
    {
      this.v.a();
      this.v = null;
    }
    AppMethodBeat.o(16577);
    return 0;
  }
  
  public int d(int paramInt)
  {
    AppMethodBeat.i(16575);
    if (this.t)
    {
      TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
      AppMethodBeat.o(16575);
      return -1;
    }
    this.t = true;
    this.f.a(this);
    this.f.a(this);
    w();
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.av);
    AppMethodBeat.o(16575);
    return 0;
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(16606);
    this.G = paramBoolean;
    com.tencent.liteav.audio.a.a();
    com.tencent.liteav.audio.a.a(paramBoolean);
    AppMethodBeat.o(16606);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    AppMethodBeat.i(16592);
    this.N = 0L;
    if (this.L)
    {
      AppMethodBeat.o(16592);
      return;
    }
    this.L = true;
    w();
    if (this.h != null) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15552);
          if (e.c(e.this)) {
            e.d(e.this);
          }
          AppMethodBeat.o(15552);
        }
      }, 1000L);
    }
    AppMethodBeat.o(16592);
  }
  
  public void g()
  {
    AppMethodBeat.i(182279);
    Object localObject = com.tencent.liteav.basic.util.f.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    int i3 = TXCStatus.c(this.K, 7102);
    int i4 = TXCStatus.c(this.K, 7101);
    String str = TXCStatus.b(this.K, 7110);
    i2 = (int)TXCStatus.d(this.K, 6002);
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
        break label554;
      }
    }
    label554:
    for (i1 = 15;; i1 = i2)
    {
      localBundle.putInt("VIDEO_GOP", (int)(TXCStatus.c(this.K, 7120) * 10 / i1 / 10.0F + 0.5D));
      i1 = com.tencent.liteav.audio.a.a().h();
      int i5 = TXCStatus.c(this.K, 2019);
      int i6 = TXCStatus.c(this.K, 2020);
      int i7 = com.tencent.liteav.audio.a.a().f();
      int i8 = com.tencent.liteav.audio.a.a().g();
      localBundle.putString("AUDIO_PLAY_INFO", i1 + " | " + i5 + "," + i6 + " | " + i7 + "," + i8);
      localBundle.putInt("AUDIO_CACHE", TXCStatus.c(this.K, 2007));
      localBundle.putInt("NET_JITTER", TXCStatus.c(this.K, 2018));
      localBundle.putFloat("AUDIO_CACHE_THRESHOLD", (float)TXCStatus.d(this.K, 2021));
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
      AppMethodBeat.o(182279);
      return;
    }
  }
  
  public int h()
  {
    AppMethodBeat.i(182280);
    int i1 = com.tencent.liteav.audio.a.a().e(this.K);
    AppMethodBeat.o(182280);
    return i1;
  }
  
  public void onAudioJitterBufferError(String paramString1, int paramInt, String paramString2) {}
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(16605);
    onNotifyEvent(paramInt, null);
    AppMethodBeat.o(16605);
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16604);
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
    if ((this.N <= 0L) && (this.J != null)) {
      this.J.onAudioInfoChanged(paramInt1, paramInt2, 16);
    }
    if (this.J != null) {
      this.J.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    if (this.N <= 0L)
    {
      this.N = l1;
      AppMethodBeat.o(16604);
      return;
    }
    this.M = (l1 - this.N);
    AppMethodBeat.o(16604);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(16600);
    if (((2003 == paramInt) || (2026 == paramInt)) && (this.u))
    {
      a(2004, "视频播放开始");
      this.u = false;
      if (2026 == paramInt)
      {
        AppMethodBeat.o(16600);
        return;
      }
    }
    if (2025 == paramInt)
    {
      a(2004, "视频播放开始");
      AppMethodBeat.o(16600);
      return;
    }
    if ((2023 == paramInt) || (2024 == paramInt))
    {
      a(2007, "视频播放 loading");
      AppMethodBeat.o(16600);
      return;
    }
    if (this.h != null) {
      this.h.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16063);
          com.tencent.liteav.basic.util.f.a(e.this.d, paramInt, paramBundle);
          if ((paramInt == 2103) && (e.f(e.this) != null)) {
            e.f(e.this).restartDecoder();
          }
          AppMethodBeat.o(16063);
        }
      });
    }
    AppMethodBeat.o(16600);
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama) {}
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(16599);
    if (!this.o)
    {
      AppMethodBeat.o(16599);
      return;
    }
    try
    {
      if (this.e != null) {
        this.e.decVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(16599);
      return;
    }
    catch (Exception paramTXSNALPacket)
    {
      AppMethodBeat.o(16599);
    }
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt)
  {
    AppMethodBeat.i(16608);
    if ((this.o) && (this.g != null)) {
      this.g.requestKeyFrame(this.E);
    }
    AppMethodBeat.o(16608);
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(16602);
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
      AppMethodBeat.o(16602);
      return;
    }
    k();
    AppMethodBeat.o(16602);
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<e> a;
    
    a(e parame)
    {
      AppMethodBeat.i(182417);
      this.a = new WeakReference(parame);
      AppMethodBeat.o(182417);
    }
    
    public void run()
    {
      AppMethodBeat.i(182418);
      e locale = (e)this.a.get();
      if (locale == null)
      {
        AppMethodBeat.o(182418);
        return;
      }
      locale.g();
      e.e(locale);
      AppMethodBeat.o(182418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */