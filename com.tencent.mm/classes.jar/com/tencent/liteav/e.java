package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a.a.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.f;
import com.tencent.liteav.renderer.b.a;
import com.tencent.liteav.renderer.j;
import com.tencent.liteav.renderer.k;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;

public class e
  extends n
  implements com.tencent.liteav.basic.c.a, h.a, f, b.a, j
{
  private int A;
  private TXLivePlayer.ITXAudioRawDataListener B;
  private String C = "";
  private boolean D = false;
  private long E = 0L;
  private long F = 0L;
  private boolean G = false;
  private h e = null;
  private com.tencent.liteav.renderer.b f = null;
  private TXCStreamDownloader g = null;
  private Handler h = new Handler(Looper.getMainLooper());
  private TextureView i;
  private Surface j;
  private boolean k = false;
  private boolean l = false;
  private int m = 0;
  private int n = 0;
  private int o = 16;
  private boolean p = false;
  private com.tencent.liteav.a.a q;
  private TXRecordCommon.ITXVideoRecordListener r;
  private d s;
  private int t = 0;
  private int u = 0;
  private k v = null;
  private k w = null;
  private float[] x = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private float[] y = new float[16];
  private String z = "";
  
  public e(Context paramContext)
  {
    super(paramContext);
    this.f.a(this);
  }
  
  private int b(String paramString, int paramInt)
  {
    int i1 = 0;
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
      this.g.setID(this.C);
      this.g.setListener(this);
      this.g.setNotifyListener(this);
      this.g.setHeaders(this.a.o);
      if (paramInt == 5) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label163;
      }
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    for (;;)
    {
      return this.g.start(paramString, this.a.j, this.a.l, this.a.k);
      if (paramInt == 5)
      {
        this.g = new TXCStreamDownloader(this.b, 4);
        break;
      }
      this.g = new TXCStreamDownloader(this.b, 0);
      break;
      label163:
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
  }
  
  private void b(String paramString)
  {
    this.C = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.e != null) {
      this.e.setID(this.C);
    }
    if (this.f != null) {
      this.f.setID(this.C);
    }
    if (this.g != null) {
      this.g.setID(this.C);
    }
    if (this.s != null) {
      this.s.b(this.C);
    }
  }
  
  private void f(int paramInt)
  {
    boolean bool = true;
    if (this.i != null) {
      this.i.setVisibility(0);
    }
    this.e = new h(this.b, 1);
    this.e.a(this);
    this.e.a(this.f);
    this.e.a(this);
    this.e.a(this.a);
    this.e.setID(this.C);
    h localh = this.e;
    if (paramInt == 5) {}
    for (;;)
    {
      localh.a(bool);
      if (this.j != null) {
        this.e.a(this.j);
      }
      this.e.b(this.k);
      return;
      bool = false;
    }
  }
  
  private void i()
  {
    if (this.q == null)
    {
      this.t = this.f.j();
      this.u = this.f.k();
      a.a locala = k();
      this.q = new com.tencent.liteav.a.a(this.b);
      this.q.a(locala);
      this.q.a(new e.1(this));
    }
    if (this.v == null)
    {
      this.v = new k(Boolean.valueOf(true));
      this.v.a();
      this.v.b(this.t, this.u);
      this.v.a(this.t, this.u);
    }
    if (this.w == null)
    {
      this.w = new k(Boolean.valueOf(false));
      this.w.a();
      this.w.b(this.f.i().getWidth(), this.f.i().getHeight());
      this.w.a(this.f.i().getWidth(), this.f.i().getHeight());
      Matrix.setIdentityM(this.y, 0);
    }
  }
  
  private void j()
  {
    if (this.v != null)
    {
      this.v.b();
      this.v = null;
    }
    if (this.w != null)
    {
      this.w.b();
      this.w = null;
    }
  }
  
  private a.a k()
  {
    int i3 = 480;
    int i4 = 640;
    int i2 = i4;
    int i1 = i3;
    if (this.t > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.u > 0)
      {
        i1 = this.t;
        i2 = this.u;
      }
    }
    a.a locala = new a.a();
    locala.a = i1;
    locala.b = i2;
    locala.c = 20;
    double d = i1 * i1;
    locala.d = ((int)(Math.sqrt(i2 * i2 + d * 1.0D) * 1.2D));
    locala.h = this.m;
    locala.i = this.n;
    locala.j = this.o;
    locala.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
    locala.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
    locala.e = this.f.b();
    TXCLog.d("TXCLivePlayer", "record config: " + locala);
    return locala;
  }
  
  private void l()
  {
    if (this.e != null)
    {
      this.e.a();
      this.e.a(null);
      this.e.a(null);
      this.e.a(null);
      this.e = null;
    }
  }
  
  private void m()
  {
    if (this.g != null)
    {
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
  }
  
  private void n()
  {
    this.s = new d(this.b);
    this.s.a(this.z);
    d locald = this.s;
    if (this.A == 5) {}
    for (boolean bool = true;; bool = false)
    {
      locald.a(bool);
      this.s.b(this.C);
      this.s.a();
      return;
    }
  }
  
  private void o()
  {
    if (this.s != null)
    {
      this.s.c();
      this.s = null;
    }
  }
  
  private void p()
  {
    this.D = false;
  }
  
  private void q()
  {
    if (this.E > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_PLAY_PROGRESS", (int)(this.E / 1000L));
      localBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.E);
      onNotifyEvent(2005, localBundle);
    }
    if ((this.h != null) && (this.D)) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          if (e.c(e.this)) {
            e.d(e.this);
          }
        }
      }, 1000L);
    }
  }
  
  private void r()
  {
    this.G = true;
    if (this.h != null) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          if (e.e(e.this)) {
            e.f(e.this);
          }
        }
      }, 2000L);
    }
  }
  
  private void s()
  {
    this.G = false;
  }
  
  private void t()
  {
    Object localObject = com.tencent.liteav.basic.util.a.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    int i3 = TXCStatus.d(this.C, 7102);
    int i4 = TXCStatus.d(this.C, 7101);
    String str = TXCStatus.c(this.C, 7110);
    i2 = (int)TXCStatus.e(this.C, 6002);
    Bundle localBundle = new Bundle();
    if (this.f != null)
    {
      localBundle.putInt("VIDEO_WIDTH", this.f.j());
      localBundle.putInt("VIDEO_HEIGHT", this.f.k());
    }
    if (this.e != null)
    {
      localBundle.putInt("CACHE_SIZE", (int)this.e.c());
      localBundle.putInt("CODEC_CACHE", (int)this.e.b());
      localBundle.putInt("VIDEO_CACHE_SIZE", (int)this.e.d());
      localBundle.putInt("V_DEC_CACHE_SIZE", this.e.e());
      localBundle.putInt("AV_PLAY_INTERVAL", (int)this.e.f());
      localBundle.putString("AUDIO_PLAY_INFO", this.e.k());
      localBundle.putInt("NET_JITTER", this.e.g());
      localBundle.putInt("AV_RECV_INTERVAL", (int)this.e.h());
      localBundle.putFloat("AUDIO_PLAY_SPEED", this.e.i());
      if (i2 != 0) {
        break label465;
      }
    }
    label465:
    for (i1 = 15;; i1 = i2)
    {
      localBundle.putInt("VIDEO_GOP", (int)(this.e.j() * 10 / i1 / 10.0F + 0.5D));
      localBundle.putInt("NET_SPEED", i4 + i3);
      localBundle.putInt("VIDEO_FPS", i2);
      localBundle.putInt("VIDEO_BITRATE", i4);
      localBundle.putInt("AUDIO_BITRATE", i3);
      localBundle.putCharSequence("SERVER_IP", str);
      localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
      com.tencent.liteav.basic.util.a.a(this.d, 15001, localBundle);
      if (this.e != null) {
        this.e.l();
      }
      if (this.s != null) {
        this.s.e();
      }
      if ((this.h != null) && (this.G)) {
        this.h.postDelayed(new Runnable()
        {
          public void run()
          {
            if (e.e(e.this)) {
              e.f(e.this);
            }
          }
        }, 2000L);
      }
      return;
    }
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = this.q;
    if ((this.p) && (paramArrayOfFloat != null) && (this.v != null))
    {
      int i1 = this.v.b(paramInt);
      paramArrayOfFloat.a(i1, TXCTimeUtil.getTimeTick());
      this.f.a(i1, this.t, this.u, false, 0);
    }
    if (this.p)
    {
      i();
      return paramInt;
    }
    j();
    return paramInt;
  }
  
  public int a(String paramString)
  {
    if ((c()) && (this.g != null))
    {
      boolean bool = this.g.switchStream(paramString);
      if (this.e != null) {
        TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.e.c() + " audio cache " + this.e.b());
      }
      if (bool)
      {
        this.z = paramString;
        return 0;
      }
      return -2;
    }
    return -1;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
      paramInt = -2;
    }
    int i1;
    do
    {
      return paramInt;
      this.z = paramString;
      this.A = paramInt;
      b(paramString);
      this.l = true;
      f(paramInt);
      i1 = b(paramString, paramInt);
      if (i1 == 0) {
        break;
      }
      this.l = false;
      m();
      l();
      paramInt = i1;
    } while (this.i == null);
    this.i.setVisibility(8);
    return i1;
    n();
    r();
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bp);
    return i1;
  }
  
  public int a(boolean paramBoolean)
  {
    if (!c())
    {
      TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
      return -2;
    }
    TXCLog.v("TXCLivePlayer", "play: stop");
    this.l = false;
    m();
    l();
    if ((this.i != null) && (paramBoolean)) {
      this.i.setVisibility(8);
    }
    o();
    s();
    p();
    return 0;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(int paramInt)
  {
    if (this.e != null) {
      this.e.a(paramInt);
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(Context paramContext, int paramInt)
  {
    h.a(paramContext, paramInt);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    j();
    e();
  }
  
  public void a(Surface paramSurface)
  {
    this.j = paramSurface;
    if (this.e != null) {
      this.e.a(paramSurface);
    }
  }
  
  public void a(com.tencent.liteav.basic.f.a parama)
  {
    TXCLog.d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + parama.a + ", channels=" + parama.b + ", bits=" + parama.c);
    this.m = parama.b;
    this.n = parama.a;
    if (parama.c > 1) {
      this.o = parama.c;
    }
    if (this.B != null) {
      this.B.onAudioInfoChanged(parama.a, parama.b, parama.c);
    }
  }
  
  public void a(g paramg)
  {
    super.a(paramg);
    if (this.e != null) {
      this.e.a(paramg);
    }
  }
  
  public void a(o paramo)
  {
    if (this.e != null) {
      this.e.a(paramo);
    }
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    this.B = paramITXAudioRawDataListener;
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
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
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.r = paramITXVideoRecordListener;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    long l1 = paramLong;
    if (this.q != null)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = TXCTimeUtil.getTimeTick();
      }
      this.q.a(paramArrayOfByte, l1);
    }
    if (this.B != null) {
      this.B.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    if (this.F <= 0L)
    {
      this.F = l1;
      return;
    }
    this.E = (l1 - this.F);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.e != null) {
      return this.e.a(paramArrayOfByte);
    }
    return false;
  }
  
  public void b()
  {
    a(this.z, this.A);
  }
  
  public void b(int paramInt)
  {
    if (this.e != null) {
      this.e.b(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (this.e != null) {
      this.e.b(this.k);
    }
  }
  
  public int c(int paramInt)
  {
    if (this.p)
    {
      TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
      return -1;
    }
    this.p = true;
    this.f.a(this);
    this.f.a(this);
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.av);
    return 0;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public TextureView d()
  {
    return this.i;
  }
  
  public void d(int paramInt)
  {
    com.tencent.liteav.a.a locala = this.q;
    if ((this.p) && (locala != null) && (this.w != null))
    {
      this.w.a(this.x);
      locala.a(this.w.b(paramInt), TXCTimeUtil.getTimeTick());
      this.w.a(this.y);
      this.w.a(paramInt);
    }
    if (this.p)
    {
      i();
      return;
    }
    j();
  }
  
  public int e()
  {
    int i1 = 0;
    if (!this.p)
    {
      TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
      i1 = -1;
    }
    do
    {
      return i1;
      this.p = false;
    } while (this.q == null);
    this.q.a();
    this.q = null;
    return 0;
  }
  
  public boolean f()
  {
    return true;
  }
  
  public void g()
  {
    this.F = 0L;
    if (this.D) {}
    do
    {
      return;
      this.D = true;
    } while (this.h == null);
    this.h.postDelayed(new e.2(this), 1000L);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    if ((-2302 == paramInt) && (this.e != null)) {
      this.e.c((int)com.tencent.liteav.basic.e.b.a().a("Audio", "SmoothModeAdjust"));
    }
    if (this.h != null) {
      this.h.post(new Runnable()
      {
        public void run()
        {
          com.tencent.liteav.basic.util.a.a(e.this.d, paramInt, paramBundle);
          if ((paramInt == 2103) && (e.g(e.this) != null)) {
            e.g(e.this).m();
          }
        }
      });
    }
  }
  
  public void onPullAudio(com.tencent.liteav.basic.f.a parama)
  {
    if (!this.l) {}
    while (this.e == null) {
      return;
    }
    this.e.a(parama);
  }
  
  public void onPullNAL(com.tencent.liteav.basic.f.b paramb)
  {
    if (!this.l) {}
    for (;;)
    {
      return;
      try
      {
        if (this.e != null)
        {
          this.e.a(paramb);
          return;
        }
      }
      catch (Exception paramb) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.e
 * JD-Core Version:    0.7.0.1
 */