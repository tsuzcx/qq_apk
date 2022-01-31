package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.f;
import com.tencent.liteav.renderer.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class e
  extends m
  implements TXCRenderAndDec.a, com.tencent.liteav.basic.c.a, f, com.tencent.liteav.renderer.a.a, com.tencent.liteav.renderer.g
{
  private float[] A;
  private String B;
  private int C;
  private TXLivePlayer.ITXAudioRawDataListener D;
  private String E;
  private boolean F;
  private long G;
  private long H;
  private boolean I;
  private TXCRenderAndDec e;
  private com.tencent.liteav.renderer.a f;
  private TXCStreamDownloader g;
  private Handler h;
  private TextureView i;
  private boolean j;
  private int k;
  private int l;
  private boolean m;
  private Surface n;
  private int o;
  private int p;
  private int q;
  private boolean r;
  private com.tencent.liteav.a.a s;
  private TXRecordCommon.ITXVideoRecordListener t;
  private d u;
  private int v;
  private int w;
  private h x;
  private h y;
  private float[] z;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66322);
    this.e = null;
    this.f = null;
    this.g = null;
    this.j = false;
    this.k = 0;
    this.l = 0;
    this.m = false;
    this.o = 0;
    this.p = 0;
    this.q = 16;
    this.r = false;
    this.v = 0;
    this.w = 0;
    this.x = null;
    this.y = null;
    this.z = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.A = new float[16];
    this.B = "";
    this.E = "";
    this.F = false;
    this.G = 0L;
    this.H = 0L;
    this.I = false;
    this.h = new Handler(Looper.getMainLooper());
    this.f = new com.tencent.liteav.renderer.a();
    this.f.a(this);
    AppMethodBeat.o(66322);
  }
  
  private int b(String paramString, int paramInt)
  {
    int i1 = 0;
    AppMethodBeat.i(66345);
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
      this.g.setID(this.E);
      this.g.setListener(this);
      this.g.setNotifyListener(this);
      this.g.setHeaders(this.a.o);
      if (paramInt == 5) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label175;
      }
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    for (;;)
    {
      paramInt = this.g.start(paramString, this.a.j, this.a.l, this.a.k);
      AppMethodBeat.o(66345);
      return paramInt;
      if (paramInt == 5)
      {
        this.g = new TXCStreamDownloader(this.b, 4);
        break;
      }
      this.g = new TXCStreamDownloader(this.b, 0);
      break;
      label175:
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(66349);
    this.E = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.e != null) {
      this.e.setID(this.E);
    }
    if (this.f != null) {
      this.f.setID(this.E);
    }
    if (this.g != null) {
      this.g.setID(this.E);
    }
    if (this.u != null) {
      this.u.d(this.E);
    }
    AppMethodBeat.o(66349);
  }
  
  private void e(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(146793);
    if (this.i != null) {
      this.i.setVisibility(0);
    }
    this.e = new TXCRenderAndDec(this.b);
    this.e.setNotifyListener(this);
    this.e.setVideoRender(this.f);
    this.e.setDecListener(this);
    this.e.setConfig(this.a);
    this.e.setID(this.E);
    TXCRenderAndDec localTXCRenderAndDec;
    if (paramInt == 0)
    {
      this.e.setStreamFormat(2);
      localTXCRenderAndDec = this.e;
      if (paramInt != 5) {
        break label179;
      }
    }
    for (;;)
    {
      localTXCRenderAndDec.start(bool);
      this.e.setMute(this.j);
      this.e.setRenderMode(this.l);
      this.e.setRenderRotation(this.k);
      AppMethodBeat.o(146793);
      return;
      if (paramInt == 5)
      {
        this.e.setStreamFormat(5);
        break;
      }
      this.e.setStreamFormat(1);
      break;
      label179:
      bool = false;
    }
  }
  
  private void i()
  {
    AppMethodBeat.i(66340);
    if (this.s == null)
    {
      this.v = this.f.m();
      this.w = this.f.n();
      com.tencent.liteav.a.a.a locala = k();
      this.s = new com.tencent.liteav.a.a(this.b);
      this.s.a(locala);
      this.s.a(new e.1(this));
    }
    if (this.x == null)
    {
      this.x = new h(Boolean.TRUE);
      this.x.b();
      this.x.b(this.v, this.w);
      this.x.a(this.v, this.w);
    }
    if (this.y == null)
    {
      this.y = new h(Boolean.FALSE);
      this.y.b();
      this.y.b(this.f.k(), this.f.l());
      this.y.a(this.f.k(), this.f.l());
      Matrix.setIdentityM(this.A, 0);
    }
    AppMethodBeat.o(66340);
  }
  
  private void j()
  {
    AppMethodBeat.i(66341);
    if (this.x != null)
    {
      this.x.c();
      this.x = null;
    }
    if (this.y != null)
    {
      this.y.c();
      this.y = null;
    }
    AppMethodBeat.o(66341);
  }
  
  private com.tencent.liteav.a.a.a k()
  {
    AppMethodBeat.i(66342);
    int i3 = 480;
    int i4 = 640;
    int i2 = i4;
    int i1 = i3;
    if (this.v > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.w > 0)
      {
        i1 = this.v;
        i2 = this.w;
      }
    }
    com.tencent.liteav.a.a.a locala = new com.tencent.liteav.a.a.a();
    locala.a = i1;
    locala.b = i2;
    locala.c = 20;
    double d = i1 * i1;
    locala.d = ((int)(Math.sqrt(i2 * i2 + d * 1.0D) * 1.2D));
    locala.h = this.o;
    locala.i = this.p;
    locala.j = this.q;
    locala.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
    locala.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
    locala.e = this.f.b();
    TXCLog.d("TXCLivePlayer", "record config: ".concat(String.valueOf(locala)));
    AppMethodBeat.o(66342);
    return locala;
  }
  
  private void l()
  {
    AppMethodBeat.i(66344);
    if (this.e != null)
    {
      this.e.stop();
      this.e.setVideoRender(null);
      this.e.setDecListener(null);
      this.e.setNotifyListener(null);
      this.e = null;
    }
    AppMethodBeat.o(66344);
  }
  
  private void m()
  {
    AppMethodBeat.i(66346);
    if (this.g != null)
    {
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
    AppMethodBeat.o(66346);
  }
  
  private void n()
  {
    AppMethodBeat.i(66347);
    this.u = new d(this.b);
    this.u.a(this.B);
    d locald = this.u;
    if (this.C == 5) {}
    for (boolean bool = true;; bool = false)
    {
      locald.a(bool);
      this.u.d(this.E);
      this.u.a();
      AppMethodBeat.o(66347);
      return;
    }
  }
  
  private void o()
  {
    AppMethodBeat.i(66348);
    if (this.u != null)
    {
      this.u.c();
      this.u = null;
    }
    AppMethodBeat.o(66348);
  }
  
  private void p()
  {
    this.F = false;
  }
  
  private void q()
  {
    AppMethodBeat.i(66351);
    if (this.G > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_PLAY_PROGRESS", (int)(this.G / 1000L));
      localBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.G);
      onNotifyEvent(2005, localBundle);
    }
    if ((this.h != null) && (this.F)) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(67357);
          if (e.c(e.this)) {
            e.d(e.this);
          }
          AppMethodBeat.o(67357);
        }
      }, 1000L);
    }
    AppMethodBeat.o(66351);
  }
  
  private void r()
  {
    AppMethodBeat.i(66352);
    this.I = true;
    if (this.h != null) {
      this.h.postDelayed(new e.4(this), 2000L);
    }
    AppMethodBeat.o(66352);
  }
  
  private void s()
  {
    this.I = false;
  }
  
  private void t()
  {
    AppMethodBeat.i(66353);
    Object localObject = com.tencent.liteav.basic.util.b.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    int i3 = TXCStatus.c(this.E, 7102);
    int i4 = TXCStatus.c(this.E, 7101);
    String str = TXCStatus.b(this.E, 7110);
    i2 = (int)TXCStatus.d(this.E, 6002);
    Bundle localBundle = new Bundle();
    if (this.f != null)
    {
      localBundle.putInt("VIDEO_WIDTH", this.f.m());
      localBundle.putInt("VIDEO_HEIGHT", this.f.n());
    }
    if (this.e != null)
    {
      localBundle.putInt("VIDEO_CACHE", (int)this.e.getVideoCacheDuration());
      localBundle.putInt("AUDIO_CACHE", (int)this.e.getAudioCacheDuration());
      localBundle.putInt("V_SUM_CACHE_SIZE", (int)this.e.getVideoCacheFrameCount());
      localBundle.putInt("V_DEC_CACHE_SIZE", this.e.getVideoDecCacheFrameCount());
      localBundle.putInt("AV_PLAY_INTERVAL", (int)this.e.getAVPlayInterval());
      localBundle.putString("AUDIO_PLAY_INFO", this.e.getAudioInfo());
      localBundle.putInt("NET_JITTER", this.e.getAudioJitter());
      localBundle.putInt("AV_RECV_INTERVAL", (int)this.e.getAVNetRecvInterval());
      localBundle.putFloat("AUDIO_CACHE_THRESHOLD", this.e.getAudioCacheThreshold());
      if (i2 != 0) {
        break label480;
      }
    }
    label480:
    for (i1 = 15;; i1 = i2)
    {
      localBundle.putInt("VIDEO_GOP", (int)(TXCStatus.c(this.E, 7120) * 10 / i1 / 10.0F + 0.5D));
      localBundle.putInt("NET_SPEED", i4 + i3);
      localBundle.putInt("VIDEO_FPS", i2);
      localBundle.putInt("VIDEO_BITRATE", i4);
      localBundle.putInt("AUDIO_BITRATE", i3);
      localBundle.putCharSequence("SERVER_IP", str);
      localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
      com.tencent.liteav.basic.util.b.a(this.d, 15001, localBundle);
      if (this.e != null) {
        this.e.updateLoadInfo();
      }
      if (this.u != null) {
        this.u.f();
      }
      if ((this.h != null) && (this.I)) {
        this.h.postDelayed(new e.5(this), 2000L);
      }
      AppMethodBeat.o(66353);
      return;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(66357);
    paramArrayOfFloat = this.s;
    if ((this.r) && (paramArrayOfFloat != null) && (this.x != null))
    {
      int i1 = this.x.d(paramInt);
      paramArrayOfFloat.a(i1, TXCTimeUtil.getTimeTick());
      this.f.a(i1, this.v, this.w, false, 0);
    }
    if (this.r) {
      i();
    }
    for (;;)
    {
      AppMethodBeat.o(66357);
      return paramInt;
      j();
    }
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(66329);
    if ((c()) && (this.g != null))
    {
      boolean bool = this.g.switchStream(paramString);
      if (this.e != null) {
        TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.e.getVideoCacheDuration() + " audio cache " + this.e.getAudioCacheDuration());
      }
      if (bool)
      {
        this.B = paramString;
        AppMethodBeat.o(66329);
        return 0;
      }
      AppMethodBeat.o(66329);
      return -2;
    }
    AppMethodBeat.o(66329);
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(66327);
    if (c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
      AppMethodBeat.o(66327);
      return -2;
    }
    this.B = paramString;
    this.C = paramInt;
    b(paramString);
    this.m = true;
    e(paramInt);
    paramInt = b(paramString, paramInt);
    if (paramInt != 0)
    {
      this.m = false;
      m();
      l();
      if (this.i != null) {
        this.i.setVisibility(8);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66327);
      return paramInt;
      a(this.n);
      n();
      r();
      TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bq);
      try
      {
        if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
          TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bB);
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public int a(boolean paramBoolean)
  {
    AppMethodBeat.i(66328);
    if (!c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
      AppMethodBeat.o(66328);
      return -2;
    }
    TXCLog.v("TXCLivePlayer", "play: stop");
    this.m = false;
    m();
    l();
    if ((this.i != null) && (paramBoolean)) {
      this.i.setVisibility(8);
    }
    if (this.f != null) {
      this.f.a(null);
    }
    o();
    s();
    p();
    AppMethodBeat.o(66328);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(66330);
    a(false);
    AppMethodBeat.o(66330);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(66332);
    this.l = paramInt;
    if (this.e != null) {
      this.e.setRenderMode(paramInt);
    }
    AppMethodBeat.o(66332);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66325);
    if (this.f != null) {
      this.f.c(paramInt1, paramInt2);
    }
    AppMethodBeat.o(66325);
  }
  
  public void a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66335);
    TXCRenderAndDec.setAudioMode(paramContext, paramInt);
    AppMethodBeat.o(66335);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(66359);
    j();
    e();
    AppMethodBeat.o(66359);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(66324);
    this.n = paramSurface;
    if (this.f != null) {
      this.f.a(paramSurface);
    }
    AppMethodBeat.o(66324);
  }
  
  public void a(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146798);
    TXCLog.d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + parama.a + ", channels=" + parama.b + ", bits=" + parama.c);
    this.o = parama.b;
    this.p = parama.a;
    if (parama.c > 1) {
      this.q = parama.c;
    }
    if (this.D != null) {
      this.D.onAudioInfoChanged(parama.a, parama.b, parama.c);
    }
    AppMethodBeat.o(146798);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(66326);
    super.a(paramg);
    if (this.e != null) {
      this.e.setConfig(paramg);
    }
    AppMethodBeat.o(66326);
  }
  
  public void a(n paramn)
  {
    AppMethodBeat.i(146792);
    if (this.e != null)
    {
      this.e.setVideoFrameListener(paramn);
      AppMethodBeat.o(146792);
      return;
    }
    TXCLog.w("TXCLivePlayer", "setVideoFrameListener->enter with renderAndDec is empty");
    AppMethodBeat.o(146792);
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    this.D = paramITXAudioRawDataListener;
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(66323);
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
    AppMethodBeat.o(66323);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.t = paramITXVideoRecordListener;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146797);
    long l1 = paramLong;
    if (this.s != null)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = TXCTimeUtil.getTimeTick();
      }
      this.s.a(paramArrayOfByte, l1);
    }
    if (this.D != null) {
      this.D.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    if (this.H <= 0L)
    {
      this.H = l1;
      paramArrayOfByte = new com.tencent.liteav.basic.structs.a();
      paramArrayOfByte.a = paramInt1;
      paramArrayOfByte.b = paramInt2;
      paramArrayOfByte.c = 16;
      a(paramArrayOfByte);
      AppMethodBeat.o(146797);
      return;
    }
    this.G = (l1 - this.H);
    AppMethodBeat.o(146797);
  }
  
  public void b()
  {
    AppMethodBeat.i(66331);
    a(this.B, this.C);
    AppMethodBeat.o(66331);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(66333);
    this.k = paramInt;
    if (this.e != null) {
      this.e.setRenderRotation(paramInt);
    }
    AppMethodBeat.o(66333);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(66334);
    this.j = paramBoolean;
    if (this.e != null) {
      this.e.setMute(this.j);
    }
    AppMethodBeat.o(66334);
  }
  
  public int c(int paramInt)
  {
    AppMethodBeat.i(66336);
    if (this.r)
    {
      TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
      AppMethodBeat.o(66336);
      return -1;
    }
    this.r = true;
    this.f.a(this);
    this.f.a(this);
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.av);
    AppMethodBeat.o(66336);
    return 0;
  }
  
  public boolean c()
  {
    return this.m;
  }
  
  public TextureView d()
  {
    return this.i;
  }
  
  public int e()
  {
    AppMethodBeat.i(66337);
    if (!this.r)
    {
      TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
      AppMethodBeat.o(66337);
      return -1;
    }
    this.r = false;
    if (this.s != null)
    {
      this.s.a();
      this.s = null;
    }
    AppMethodBeat.o(66337);
    return 0;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public void g()
  {
    AppMethodBeat.i(66350);
    this.H = 0L;
    if (this.F)
    {
      AppMethodBeat.o(66350);
      return;
    }
    this.F = true;
    if (this.h != null) {
      this.h.postDelayed(new e.2(this), 1000L);
    }
    AppMethodBeat.o(66350);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66356);
    if ((-2302 == paramInt) && (this.e != null)) {
      this.e.setSmoothMode((int)com.tencent.liteav.basic.e.b.a().a("Audio", "SmoothModeAdjust"));
    }
    if (this.h != null) {
      this.h.post(new e.6(this, paramInt, paramBundle));
    }
    AppMethodBeat.o(66356);
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146794);
    if (!this.m)
    {
      AppMethodBeat.o(146794);
      return;
    }
    if (this.e != null) {
      this.e.decAudio(parama);
    }
    AppMethodBeat.o(146794);
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(146795);
    if (!this.m)
    {
      AppMethodBeat.o(146795);
      return;
    }
    try
    {
      if (this.e != null) {
        this.e.decVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(146795);
      return;
    }
    catch (Exception paramTXSNALPacket)
    {
      AppMethodBeat.o(146795);
    }
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146796);
    com.tencent.liteav.a.a locala = this.s;
    if ((this.r) && (locala != null) && (this.y != null))
    {
      this.y.a(this.z);
      locala.a(this.y.d(paramInt1), TXCTimeUtil.getTimeTick());
      this.y.a(this.A);
      this.y.c(paramInt1);
    }
    if (this.r)
    {
      i();
      AppMethodBeat.o(146796);
      return;
    }
    j();
    AppMethodBeat.o(146796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */