package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class c
  extends com.tencent.liteav.basic.module.a
  implements a.b, com.tencent.liteav.audio.e, com.tencent.liteav.basic.c.a, com.tencent.liteav.beauty.e, l, com.tencent.liteav.videoencoder.d
{
  private static final String d = c.class.getSimpleName();
  a a;
  com.tencent.liteav.audio.f b = null;
  TXLivePusher.OnBGMNotify c = null;
  private k e = null;
  private com.tencent.liteav.beauty.c f = null;
  private int g = -1;
  private TXSVideoEncoderParam h = null;
  private com.tencent.liteav.videoencoder.b i = null;
  private Context j = null;
  private f k = null;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private float o = 1.0F;
  private int p = 0;
  private float q = 0.0F;
  private long r = 0L;
  private c.a s = null;
  private WeakReference<com.tencent.liteav.basic.c.a> t;
  private WeakReference<m> u;
  private boolean v = false;
  private int w = -1;
  private int x = -1;
  
  public c(Context paramContext)
  {
    this.j = paramContext.getApplicationContext();
    this.k = new f();
    this.f = new com.tencent.liteav.beauty.c(this.j, true);
    this.f.a(this);
    this.f.a(this);
    this.h = new TXSVideoEncoderParam();
    this.i = null;
    this.a = new a(this);
    com.tencent.liteav.basic.e.b.a().a(this.j);
  }
  
  private int a(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    if (this.k == null) {
      return -5;
    }
    int i1;
    int i2;
    switch (this.k.k)
    {
    default: 
      TXCLog.e(d, "sendCustomYUVData: invalid video_resolution");
      return -1;
    case 0: 
      i1 = 640;
      i2 = 368;
    }
    while ((i2 > paramInt1) || (i1 > paramInt2))
    {
      return -4;
      i1 = 960;
      i2 = 544;
      continue;
      i1 = 1280;
      i2 = 720;
      continue;
      i1 = 368;
      i2 = 640;
      continue;
      i1 = 544;
      i2 = 960;
      continue;
      i1 = 720;
      i2 = 1280;
    }
    if (this.k.F)
    {
      s();
      return -1000;
    }
    b(i2, i1, paramEGLContext);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, EGLContext paramEGLContext)
  {
    TXCLog.d(d, "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3);
    s();
    this.g = paramInt3;
    this.i = new com.tencent.liteav.videoencoder.b(this.g);
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if ((this.k.K & 0x2) == 2) {
      if (paramEGLContext != null)
      {
        this.h.width = paramInt1;
        this.h.height = paramInt2;
        this.h.fps = this.k.h;
        this.h.gop = this.k.i;
        localTXSVideoEncoderParam = this.h;
        if (this.k.n != true) {
          break label277;
        }
      }
    }
    label277:
    for (paramInt1 = 3;; paramInt1 = 1)
    {
      localTXSVideoEncoderParam.encoderProfile = paramInt1;
      this.h.encoderMode = 1;
      this.h.glContext = paramEGLContext;
      this.h.realTime = this.k.I;
      this.i.a(this);
      this.i.a(this);
      this.i.a(this.h);
      this.i.a(this.k.c);
      this.i.setID(getID());
      return;
      paramEGLContext = this.i.a(paramInt1, paramInt2);
      break;
      if (this.e != null) {}
      for (paramEGLContext = this.e.f();; paramEGLContext = null) {
        break;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    com.tencent.liteav.beauty.c localc;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.k.C != -1.0F) {
      if (this.f != null)
      {
        localc = this.f;
        localBitmap = this.k.x;
        f3 = this.k.A;
        f2 = this.k.B;
        f1 = this.k.C;
      }
    }
    for (;;)
    {
      localc.a(localBitmap, f3, f2, f1);
      do
      {
        return;
      } while ((this.f == null) || (paramInt1 == 0) || (paramInt2 == 0));
      localc = this.f;
      localBitmap = this.k.x;
      f3 = this.k.y / paramInt1;
      f2 = this.k.z / paramInt2;
      if (this.k.x == null) {
        f1 = 0.0F;
      } else {
        f1 = this.k.x.getWidth() / paramInt1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    int i3 = 2;
    int i2 = 1;
    int i1 = i3;
    switch (this.k.j)
    {
    default: 
      i1 = i3;
    case 0: 
      if (this.l == 1) {
        i1 = i2;
      }
      break;
    }
    for (;;)
    {
      i2 = this.k.i;
      if ((this.i == null) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.g != i1) || (this.h.gop != i2)) {
        a(paramInt1, paramInt2, i1, paramEGLContext);
      }
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("EVT_USERID", this.r);
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.a.a(this.t, paramInt, localBundle);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt2, paramInt3, null);
    if (this.i != null) {
      this.i.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
  }
  
  private void k(int paramInt)
  {
    if ((this.e != null) && (this.e.d()) && (paramInt != this.k.k) && (!this.k.M) && (this.l == 0)) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          c.a(c.this).a();
          if (c.b(c.this) != null)
          {
            c.b(c.this).d(c.a(c.this).k);
            c.b(c.this).b(false);
          }
        }
      });
    }
    do
    {
      return;
      this.k.a();
    } while ((this.e == null) || (!this.e.d()));
    this.e.a(new Runnable()
    {
      public void run()
      {
        if (c.b(c.this) != null)
        {
          c.b(c.this).a(c.a(c.this).a, c.a(c.this).b);
          c.b(c.this).d(c.a(c.this).k);
        }
      }
    });
  }
  
  private void s()
  {
    try
    {
      if (this.i != null)
      {
        this.i.a();
        this.i.a(null);
        this.i = null;
      }
      this.h.width = 0;
      this.h.height = 0;
      return;
    }
    catch (Exception localException) {}
  }
  
  private void t()
  {
    if ((this.k.K & 0x1) != 0)
    {
      com.tencent.liteav.audio.c.a().a(true);
      com.tencent.liteav.audio.c.a().c(this.k.r);
      com.tencent.liteav.audio.c.a().a(this.k.q);
    }
    for (;;)
    {
      com.tencent.liteav.audio.c.a().a(this.k.s, this.j);
      com.tencent.liteav.audio.c.a().c(this.v);
      TXCLiveBGMPlayer.getInstance().switchAecType(com.tencent.liteav.audio.c.a().f());
      TXCLiveBGMPlayer.getInstance().setPitch(this.q);
      return;
      com.tencent.liteav.audio.c.a().c(1);
      com.tencent.liteav.audio.c.a().a(this.k.q);
    }
  }
  
  private void u()
  {
    if ((this.k.t != null) && (this.e != null)) {
      this.e.a(new c.2(this));
    }
  }
  
  private void v()
  {
    if (this.e != null) {
      this.e.a(new c.3(this));
    }
  }
  
  private void w()
  {
    if (this.f != null)
    {
      if (this.k.I) {
        this.f.f(0);
      }
    }
    else {
      return;
    }
    this.f.f(3);
  }
  
  public int a(com.tencent.liteav.basic.f.c paramc)
  {
    if (this.u != null)
    {
      m localm = (m)this.u.get();
      if (localm != null) {
        paramc.a = localm.onTextureCustomProcess(paramc.a, paramc.d, paramc.e);
      }
    }
    if (this.e != null) {
      this.e.a(paramc);
    }
    return paramc.a;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = a(paramInt2, paramInt3, null);
    if (i1 != 0) {
      return i1;
    }
    if (this.i != null) {
      this.i.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    return 0;
  }
  
  public void a()
  {
    com.tencent.liteav.audio.c.a().b();
    com.tencent.liteav.audio.c.a().a(null);
  }
  
  public void a(float paramFloat)
  {
    if (this.f != null) {
      this.f.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
    if (this.e == null) {
      return;
    }
    this.e.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.w = paramInt1;
    this.x = paramInt2;
    com.tencent.liteav.audio.c.a().a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.e == null) {
      return;
    }
    this.e.a(new c.1(this, paramInt2, paramInt3, paramInt1));
  }
  
  public void a(int paramInt, String paramString)
  {
    TXCLog.e(d, "onRecordError code = " + paramInt + ":" + paramString);
    if (paramInt == TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT) {
      b(-1302, "打开麦克风失败");
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.f != null) {
      this.f.a(paramBitmap);
    }
  }
  
  public void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    if (this.e != null) {
      this.e.a(new c.7(this, paramBitmap, paramInt1, paramInt2, paramByteBuffer));
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if (this.f != null) {
      this.f.a();
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    c.a locala = this.s;
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.t = new WeakReference(parama);
  }
  
  public void a(com.tencent.liteav.basic.f.b paramb, int paramInt)
  {
    if (paramInt == 0)
    {
      locala = this.s;
      if ((locala != null) && (paramb != null)) {
        locala.onEncVideo(paramb);
      }
    }
    while ((paramInt != 10000004) || (this.g != 1))
    {
      c.a locala;
      return;
    }
    this.k.j = 0;
    b(1103, "硬编码启动失败,采用软编码");
  }
  
  public void a(com.tencent.liteav.basic.f.c paramc, long paramLong)
  {
    d(paramc.a, paramc.d, paramc.e);
  }
  
  public void a(c.a parama)
  {
    this.s = parama;
  }
  
  public void a(f paramf)
  {
    int i3 = 0;
    int i4 = this.k.k;
    int i1;
    int i2;
    if ((paramf != null) && ((this.k.t != paramf.t) || (this.k.u != paramf.u) || (this.k.v != paramf.v)))
    {
      i1 = 1;
      i2 = i3;
      if (paramf != null) {
        if ((this.k.x == paramf.x) && (this.k.y == paramf.y) && (this.k.z == paramf.z) && (this.k.C == paramf.C) && (this.k.A == paramf.A))
        {
          i2 = i3;
          if (this.k.B == paramf.B) {}
        }
        else
        {
          i2 = 1;
        }
      }
      if (paramf == null) {
        break label255;
      }
    }
    for (;;)
    {
      try
      {
        this.k = ((f)paramf.clone());
        k(i4);
        if (i())
        {
          t();
          w();
          if (this.e != null) {
            this.e.c(this.k.l);
          }
          if (i1 != 0) {
            u();
          }
          if (i2 != 0) {
            v();
          }
        }
        return;
        i1 = 0;
      }
      catch (CloneNotSupportedException paramf)
      {
        this.k = new f();
        continue;
      }
      label255:
      this.k = new f();
    }
  }
  
  public void a(m paramm)
  {
    this.u = new WeakReference(paramm);
  }
  
  public void a(com.tencent.liteav.videoencoder.b paramb)
  {
    if (this.e != null) {
      this.e.a(new c.8(this, paramb));
    }
    while (paramb == null) {
      return;
    }
    try
    {
      paramb.a();
      paramb.a(null);
      return;
    }
    catch (Exception paramb) {}
  }
  
  public void a(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    if (paramOnBGMNotify == null)
    {
      this.b = null;
      this.c = null;
      TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
      return;
    }
    this.c = paramOnBGMNotify;
    if (this.b == null) {
      this.b = new c.6(this);
    }
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.b);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    if (this.k.F)
    {
      TXCLog.e(d, "enable pure audio push , so can not start preview!");
      return;
    }
    if (paramTXCloudVideoView.getGLSurfaceView() == null) {
      paramTXCloudVideoView.addVideoView(new com.tencent.liteav.renderer.d(paramTXCloudVideoView.getContext()));
    }
    this.l = 0;
    this.e = new b(this.j, this.k, paramTXCloudVideoView);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.b(this.n);
  }
  
  public void a(String paramString)
  {
    if (this.f != null) {
      this.f.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.e == null) {
      return;
    }
    this.e.a(new c.5(this));
    this.e.a(paramBoolean);
    this.e.a(null);
    this.e = null;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    com.tencent.liteav.audio.c.a().a(paramArrayOfByte);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    c.a locala = this.s;
    if (locala != null) {
      locala.onRecordPcm(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    c.a locala = this.s;
    if (locala != null) {
      locala.onRecordRawPcm(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
  }
  
  public int b()
  {
    return this.h.width;
  }
  
  public void b(float paramFloat)
  {
    this.q = paramFloat;
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
  }
  
  public void b(int paramInt)
  {
    if (this.f != null) {
      this.f.b(paramInt);
    }
  }
  
  public void b(com.tencent.liteav.basic.f.c paramc)
  {
    if ((this.f != null) && (!this.k.F) && (this.e != null))
    {
      if ((this.h.height != paramc.g) || (this.h.width != paramc.f)) {
        c(paramc.f, paramc.g);
      }
      this.f.a(paramc, paramc.b, 0);
    }
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    c.a locala = this.s;
    if (locala != null) {
      locala.onEncAudio(paramArrayOfByte, paramLong, paramInt1, paramInt2);
    }
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.f != null)
    {
      this.f.c(paramInt1);
      this.f.d(paramInt2);
      this.f.e(paramInt3);
    }
    return true;
  }
  
  @TargetApi(18)
  public boolean b(String paramString)
  {
    if (this.f != null) {
      return this.f.a(paramString, true);
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (this.e == null) {
      return false;
    }
    return this.e.d(paramBoolean);
  }
  
  public int c()
  {
    return this.h.height;
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = a(paramInt2, paramInt3, ((EGL10)EGLContext.getEGL()).eglGetCurrentContext());
    if (i1 != 0) {
      return i1;
    }
    if (this.i != null) {
      this.i.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    return 0;
  }
  
  public void c(float paramFloat)
  {
    if (this.e == null) {
      return;
    }
    this.e.a(paramFloat);
  }
  
  public void c(int paramInt)
  {
    if (this.f != null) {
      this.f.g(paramInt);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.v = paramBoolean;
    com.tencent.liteav.audio.c.a().c(paramBoolean);
  }
  
  public boolean c(String paramString)
  {
    if (!com.tencent.liteav.audio.c.a().c()) {
      return false;
    }
    TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aA);
    return TXCLiveBGMPlayer.getInstance().startPlay(paramString, com.tencent.liteav.audio.c.a().f());
  }
  
  public int d(String paramString)
  {
    return (int)TXCLiveBGMPlayer.getInstance().getMusicDuration(paramString);
  }
  
  public String d()
  {
    return com.tencent.liteav.audio.c.a().f() + " | " + com.tencent.liteav.audio.c.a().e() + "," + com.tencent.liteav.audio.c.a().d();
  }
  
  public void d(int paramInt)
  {
    if (this.f != null) {
      this.f.h(paramInt);
    }
  }
  
  public boolean d(float paramFloat)
  {
    this.o = paramFloat;
    com.tencent.liteav.audio.c.a().a(paramFloat);
    return true;
  }
  
  public boolean d(boolean paramBoolean)
  {
    if (this.e == null) {
      return false;
    }
    this.e.c(paramBoolean);
    return true;
  }
  
  public int e()
  {
    if (i())
    {
      TXCLog.w(d, "ignore startPush when pushing, status:" + this.m);
      return -2;
    }
    TXCDRApi.initCrashReport(this.j);
    this.m = 1;
    TXCLog.d(d, "startPusher");
    t();
    com.tencent.liteav.audio.c.a().a(this);
    if (((this.k != null) && (this.k.F)) || (this.l == 1) || (this.e == null) || (this.e.d())) {
      com.tencent.liteav.audio.c.a().a(this.j);
    }
    for (;;)
    {
      w();
      TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.bq);
      return 0;
      if (this.e != null) {
        this.e.e(true);
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (this.f != null) {
      this.f.i(paramInt);
    }
  }
  
  public boolean e(float paramFloat)
  {
    TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
    return true;
  }
  
  public void f()
  {
    if (!i()) {
      TXCLog.w(d, "ignore stopPush when not pushing, status:" + this.m);
    }
    do
    {
      return;
      TXCLog.d(d, "stopPusher");
      this.m = 0;
      com.tencent.liteav.audio.c.a().b();
      com.tencent.liteav.audio.c.a().a(null);
      r();
      this.q = 0.0F;
      this.k.I = false;
    } while (this.a == null);
    this.a.a();
  }
  
  public void f(int paramInt)
  {
    if (this.f != null) {
      this.f.j(paramInt);
    }
  }
  
  public void g()
  {
    if (this.m != 1) {
      TXCLog.w(d, "ignore pause push when is not pushing, status:" + this.m);
    }
    do
    {
      return;
      this.m = 2;
      TXCLog.d(d, "pausePusher");
      if ((this.k.w & 0x1) == 1)
      {
        if ((this.a != null) && (!this.k.F) && (this.e != null)) {
          this.a.a(this.k.v, this.k.u, this.k.t, this.h.width, this.h.height);
        }
        if (this.e != null) {
          this.e.c();
        }
      }
    } while ((this.k.w & 0x2) != 2);
    com.tencent.liteav.audio.c.a().c(true);
  }
  
  public void g(int paramInt)
  {
    if (this.f != null) {
      this.f.k(paramInt);
    }
  }
  
  public void h()
  {
    if (this.m != 2) {
      TXCLog.w(d, "ignore resume push when is not pause, status:" + this.m);
    }
    do
    {
      do
      {
        return;
        this.m = 1;
        TXCLog.d(d, "resumePusher");
        if ((this.k.w & 0x1) == 1)
        {
          if ((this.a != null) && (!this.k.F)) {
            this.a.a();
          }
          if (this.e != null) {
            this.e.b();
          }
        }
      } while ((this.k.w & 0x2) != 2);
      com.tencent.liteav.audio.c.a().c(this.v);
    } while ((this.k.K & 0x1) != 0);
    com.tencent.liteav.audio.c.a().b();
    com.tencent.liteav.audio.c.a().a(this.k.q);
    com.tencent.liteav.audio.c.a().a(this.k.s, this.j);
    com.tencent.liteav.audio.c.a().d(this.p);
    com.tencent.liteav.audio.c.a().a(this.w, this.x);
    com.tencent.liteav.audio.c.a().a(this.o);
    com.tencent.liteav.audio.c.a().c(this.v);
    com.tencent.liteav.audio.c.a().a(this);
    com.tencent.liteav.audio.c.a().a(this.j);
  }
  
  public void h(int paramInt)
  {
    if (this.f != null) {
      this.f.l(paramInt);
    }
  }
  
  public boolean i()
  {
    return this.m != 0;
  }
  
  public boolean i(int paramInt)
  {
    if (this.e == null) {
      return false;
    }
    return this.e.a(paramInt);
  }
  
  public void j()
  {
    if (this.e == null) {
      return;
    }
    this.e.a(new c.4(this));
  }
  
  public void j(int paramInt)
  {
    this.p = paramInt;
    com.tencent.liteav.audio.c.a().d(paramInt);
    TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.az);
  }
  
  public void k()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
      onNotifyEvent(-1309, localBundle);
      TXLog.e(d, "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      return;
    }
    this.l = 1;
    this.e = new i(this.j, this.k);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aG);
  }
  
  public void l()
  {
    if (this.e == null) {
      return;
    }
    r();
    this.e.a(false);
    this.e = null;
  }
  
  public int m()
  {
    if (this.e == null) {
      return 0;
    }
    return this.e.e();
  }
  
  public boolean n()
  {
    TXCLiveBGMPlayer.getInstance().stopPlay();
    return true;
  }
  
  public boolean o()
  {
    TXCLiveBGMPlayer.getInstance().pause();
    return true;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putLong("EVT_USERID", this.r);
    }
    com.tencent.liteav.basic.util.a.a(this.t, paramInt, paramBundle);
  }
  
  public boolean p()
  {
    TXCLiveBGMPlayer.getInstance().resume();
    return true;
  }
  
  public void q()
  {
    if (this.f != null) {
      this.f.a();
    }
    s();
    if (this.u != null)
    {
      m localm = (m)this.u.get();
      if (localm != null) {
        localm.onTextureDestoryed();
      }
    }
  }
  
  public void r()
  {
    if (this.i == null) {
      return;
    }
    if (this.e != null)
    {
      this.e.a(new c.9(this));
      return;
    }
    s();
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    if (this.i != null) {
      this.i.setID(paramString);
    }
    if (this.f != null) {
      this.f.setID(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.c
 * JD-Core Version:    0.7.0.1
 */