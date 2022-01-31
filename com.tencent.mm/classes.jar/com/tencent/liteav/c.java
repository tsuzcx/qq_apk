package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class c
  extends com.tencent.liteav.basic.module.a
  implements a.b, com.tencent.liteav.audio.d, com.tencent.liteav.basic.c.a, com.tencent.liteav.beauty.e, k, com.tencent.liteav.videoencoder.d
{
  private static final String c;
  private com.tencent.liteav.basic.d.d A;
  private int B;
  private com.tencent.liteav.basic.structs.b C;
  private int D;
  private boolean E;
  private boolean F;
  private long G;
  private long H;
  private int I;
  private byte[] J;
  private WeakReference<n> K;
  private WeakReference<c.a> L;
  private g M;
  private g N;
  private boolean O;
  private boolean P;
  private boolean Q;
  private WeakReference<com.tencent.liteav.basic.c.a> R;
  private WeakReference<l> S;
  private int T;
  private int U;
  private boolean V;
  private int W;
  private int X;
  private int Y;
  a a;
  boolean b;
  private j d;
  private com.tencent.liteav.beauty.c e;
  private boolean f;
  private int g;
  private TXSVideoEncoderParam h;
  private com.tencent.liteav.videoencoder.b i;
  private int j;
  private boolean k;
  private TXSVideoEncoderParam l;
  private com.tencent.liteav.videoencoder.b m;
  private Context n;
  private f o;
  private int p;
  private int q;
  private int r;
  private int s;
  private float t;
  private int u;
  private float v;
  private TXCloudVideoView w;
  private Surface x;
  private int y;
  private int z;
  
  static
  {
    AppMethodBeat.i(66474);
    c = c.class.getSimpleName();
    AppMethodBeat.o(66474);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(66387);
    this.d = null;
    this.e = null;
    this.f = false;
    this.g = -1;
    this.h = null;
    this.i = null;
    this.j = 15;
    this.k = false;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = 1.0F;
    this.u = 0;
    this.v = 0.0F;
    this.b = false;
    this.w = null;
    this.x = null;
    this.y = 0;
    this.z = 0;
    this.A = null;
    this.B = 0;
    this.D = 0;
    this.E = false;
    this.F = false;
    this.G = 0L;
    this.H = 0L;
    this.I = 0;
    this.L = null;
    this.M = null;
    this.O = false;
    this.P = false;
    this.Q = false;
    this.T = 0;
    this.U = 0;
    this.V = false;
    this.W = -1;
    this.X = -1;
    this.Y = 10;
    this.n = paramContext.getApplicationContext();
    this.o = new f();
    this.e = new com.tencent.liteav.beauty.c(this.n, true);
    this.e.a(this);
    this.e.a(this);
    this.h = new TXSVideoEncoderParam();
    this.i = null;
    this.l = new TXSVideoEncoderParam();
    this.a = new a(this);
    com.tencent.liteav.basic.e.b.a().a(this.n);
    AppMethodBeat.o(66387);
  }
  
  private void A()
  {
    AppMethodBeat.i(146447);
    if (this.e != null)
    {
      if (this.o.J)
      {
        this.e.f(0);
        AppMethodBeat.o(146447);
        return;
      }
      this.e.f(3);
    }
    AppMethodBeat.o(146447);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(146442);
    paramInt2 = this.o.a;
    paramInt1 = this.o.b;
    if ((this.o.l == 0) || (this.o.l == 2))
    {
      paramInt2 = this.o.b;
      paramInt1 = this.o.a;
    }
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      TXCLog.e(c, "sendCustomYUVData: invalid video encode resolution");
      AppMethodBeat.o(146442);
      return -1;
    }
    if (this.o.G)
    {
      x();
      AppMethodBeat.o(146442);
      return -1000;
    }
    b(paramInt2, paramInt1, paramObject);
    AppMethodBeat.o(146442);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(146440);
    TXCLog.d(c, "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3);
    x();
    this.g = paramInt3;
    this.i = new com.tencent.liteav.videoencoder.b(this.g);
    TXCStatus.a(getID(), 4005, this.D, Integer.valueOf(this.g));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (this.g == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1, -1, "", this.D);
      this.Q = false;
      this.h.width = paramInt1;
      this.h.height = paramInt2;
      this.h.fps = this.o.h;
      this.h.gop = this.o.i;
      localTXSVideoEncoderParam = this.h;
      if (this.o.n != true) {
        break label511;
      }
      paramInt3 = 3;
      label190:
      localTXSVideoEncoderParam.encoderProfile = paramInt3;
      this.h.encoderMode = 1;
      localTXSVideoEncoderParam = this.h;
      if (paramObject == null) {
        break label516;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.h.realTime = this.o.J;
      this.h.streamType = this.D;
      this.h.annexb = this.F;
      this.h.bMultiRef = this.E;
      this.h.baseFrameIndex = (this.G + 20L);
      this.h.baseGopIndex = (this.H + 2L);
      this.h.bLimitFps = this.f;
      this.i.a(this);
      this.i.a(this);
      this.i.a(this.h);
      this.i.b(this.o.c);
      this.i.c(this.j);
      this.i.setID(getID());
      this.i.a(this.T);
      TXCStatus.a(getID(), 4003, this.D, Integer.valueOf(this.h.width << 16 | this.h.height));
      TXCStatus.a(getID(), 13003, this.D, Integer.valueOf(this.h.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.h.width, this.h.height, "", this.D);
      AppMethodBeat.o(146440);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0, -1, "", this.D);
      break;
      label511:
      paramInt3 = 1;
      break label190;
      label516:
      paramObject = this.i.a(paramInt1, paramInt2);
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(146448);
    this.C = paramb;
    if (this.w != null)
    {
      if (this.d != null)
      {
        this.d.a(paramb);
        AppMethodBeat.o(146448);
      }
    }
    else
    {
      if (this.x == null) {
        break label189;
      }
      if ((this.A != null) && (this.A.b() != this.x))
      {
        this.A.a();
        this.A = null;
      }
      if ((this.A == null) && (this.d != null) && (this.d.f() != null))
      {
        this.A = new com.tencent.liteav.basic.d.d();
        this.A.a(this.d.f(), this.x);
      }
    }
    for (;;)
    {
      if (this.A != null) {
        this.A.a(paramb.a, paramb.i, this.B, this.y, this.z, paramb.e, paramb.f, paramBoolean);
      }
      AppMethodBeat.o(146448);
      return;
      label189:
      if (this.A != null)
      {
        this.A.a();
        this.A = null;
      }
    }
  }
  
  private void a(Object paramObject)
  {
    AppMethodBeat.i(146441);
    TXSVideoEncoderParam localTXSVideoEncoderParam = this.l;
    if (localTXSVideoEncoderParam == null)
    {
      AppMethodBeat.o(146441);
      return;
    }
    w();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(this.g);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(this.g));
    if (this.g == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1, -1, "", 3);
      if (paramObject == null) {
        break label170;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      TXCLog.d(c, "start small video encoder");
      localb.a(this);
      localb.a(this);
      localb.a(localTXSVideoEncoderParam);
      localb.b(localTXSVideoEncoderParam.bitrate);
      localb.setID(getID());
      localb.a(this.T);
      this.m = localb;
      AppMethodBeat.o(146441);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0, -1, "", 3);
      break;
      label170:
      paramObject = this.i.a(localTXSVideoEncoderParam.width, localTXSVideoEncoderParam.height);
    }
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i3 = 2;
    int i2 = 1;
    AppMethodBeat.i(146443);
    int i1 = i3;
    switch (this.o.j)
    {
    default: 
      i1 = i3;
    case 0: 
      if (this.p == 1) {
        i1 = i2;
      }
      break;
    }
    for (;;)
    {
      i2 = this.o.i;
      if ((this.i == null) || (this.Q) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.g != i1) || (this.h.gop != i2)) {
        a(paramInt1, paramInt2, i1, paramObject);
      }
      if ((this.m == null) && (this.k)) {
        a(paramObject);
      }
      AppMethodBeat.o(146443);
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    AppMethodBeat.i(66430);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.b.a(this.R, paramInt, localBundle);
    int i2;
    if (paramInt == -1317)
    {
      paramString = getID();
      i2 = 2002;
      i1 = 4;
    }
    for (;;)
    {
      TXCEventRecorderProxy.a(paramString, i2, i1, -1, "", this.D);
      do
      {
        if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319)) {
          break label214;
        }
        TXCKeyPointReportProxy.a(30002, paramInt);
        AppMethodBeat.o(66430);
        return;
        if (paramInt == -1314)
        {
          paramString = getID();
          i2 = 2002;
          i1 = 5;
          break;
        }
      } while ((paramInt != 1003) || (this.d == null));
      paramString = getID();
      i2 = 4001;
      if (this.d.g()) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    label214:
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.a(30003, paramInt);
      if (this.d != null)
      {
        paramString = getID();
        if (!this.d.g()) {
          break label298;
        }
      }
    }
    label298:
    for (int i1 = 0;; i1 = 1)
    {
      TXCEventRecorderProxy.a(paramString, 4002, i1, paramInt, "", this.D);
      AppMethodBeat.o(66430);
      return;
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66466);
    com.tencent.liteav.beauty.c localc;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.o.D != -1.0F) {
      if (this.e != null)
      {
        localc = this.e;
        localBitmap = this.o.y;
        f3 = this.o.B;
        f2 = this.o.C;
        f1 = this.o.D;
      }
    }
    for (;;)
    {
      localc.a(localBitmap, f3, f2, f1);
      do
      {
        AppMethodBeat.o(66466);
        return;
      } while ((this.e == null) || (paramInt1 == 0) || (paramInt2 == 0));
      localc = this.e;
      localBitmap = this.o.y;
      f3 = this.o.z / paramInt1;
      f2 = this.o.A / paramInt2;
      if (this.o.y == null) {
        f1 = 0.0F;
      } else {
        f1 = this.o.y.getWidth() / paramInt1;
      }
    }
  }
  
  private void c(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(146449);
    Object localObject = this.K;
    if (localObject == null)
    {
      AppMethodBeat.o(146449);
      return;
    }
    if (this.I == 3)
    {
      localObject = (n)((WeakReference)localObject).get();
      if (localObject != null)
      {
        TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
        localTXSVideoFrame.width = paramb.e;
        localTXSVideoFrame.height = paramb.f;
        localTXSVideoFrame.textureId = paramb.a;
        localTXSVideoFrame.eglContext = this.e.a();
        localTXSVideoFrame.pts = TXCTimeUtil.getTimeTick();
        ((n)localObject).onRenderVideoFrame(getID(), this.D, localTXSVideoFrame);
      }
      AppMethodBeat.o(146449);
      return;
    }
    if (this.M == null)
    {
      this.M = new o(1);
      this.M.a(true);
      if (!this.M.a()) {
        break label353;
      }
      this.M.a(paramb.e, paramb.f);
      this.M.a(new c.9(this, (WeakReference)localObject));
    }
    for (;;)
    {
      if (this.N == null)
      {
        this.N = new g();
        this.N.a();
        this.N.a(true);
        this.N.a(paramb.e, paramb.f);
        this.N.g();
      }
      if (this.M != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        this.M.a(paramb.e, paramb.f);
        int i2 = paramb.a;
        int i1 = i2;
        if (paramb.i)
        {
          i1 = i2;
          if (this.N != null)
          {
            this.N.a(paramb.e, paramb.f);
            i1 = this.N.b(paramb.a);
          }
        }
        this.M.b(i1);
      }
      AppMethodBeat.o(146449);
      return;
      label353:
      TXCLog.i(c, "throwVideoFrame->release mVideoFrameFilter");
      this.M = null;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66468);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(66468);
  }
  
  private void d(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66457);
    b(paramInt2, paramInt3, this.e.a());
    com.tencent.liteav.videoencoder.b localb = this.i;
    if (localb != null) {
      localb.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    localb = this.m;
    if (localb != null) {
      localb.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    AppMethodBeat.o(66457);
  }
  
  private void f(boolean paramBoolean)
  {
    AppMethodBeat.i(146445);
    if ((this.d != null) && (this.d.d())) {
      this.d.a(new c.7(this, paramBoolean));
    }
    AppMethodBeat.o(146445);
  }
  
  private void w()
  {
    AppMethodBeat.i(66465);
    try
    {
      if (this.m != null)
      {
        this.m.a();
        this.m.a(null);
        this.m = null;
      }
      AppMethodBeat.o(66465);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(66465);
    }
  }
  
  private void x()
  {
    AppMethodBeat.i(66467);
    try
    {
      TXCLog.d(c, "stopVideoEncoderInGLThread");
      if (this.i != null)
      {
        this.i.a();
        this.i.a(null);
        this.i = null;
      }
      this.Q = true;
      w();
      AppMethodBeat.o(66467);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(66467);
    }
  }
  
  private void y()
  {
    AppMethodBeat.i(146444);
    if ((this.o.L & 0x1) != 0)
    {
      com.tencent.liteav.audio.b.a().a(true);
      com.tencent.liteav.audio.b.a().b(this.o.r);
      com.tencent.liteav.audio.b.a().a(this.o.q);
      com.tencent.liteav.audio.b.a().a(false, this.n);
    }
    for (;;)
    {
      com.tencent.liteav.audio.b.a().c(this.V);
      com.tencent.liteav.audio.b.a().f(this.Y);
      TXCLiveBGMPlayer.getInstance().switchAecType(com.tencent.liteav.audio.b.a().f());
      TXCLiveBGMPlayer.getInstance().setPitch(this.v);
      AppMethodBeat.o(146444);
      return;
      com.tencent.liteav.audio.b.a().b(1);
      com.tencent.liteav.audio.b.a().a(this.o.q);
      com.tencent.liteav.audio.b.a().a(this.o.s, this.n);
    }
  }
  
  private void z()
  {
    AppMethodBeat.i(146446);
    if (this.d != null) {
      this.d.a(new c.8(this));
    }
    AppMethodBeat.o(146446);
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(146436);
    if (this.S != null)
    {
      l locall = (l)this.S.get();
      if (locall != null) {
        paramb.a = locall.onTextureCustomProcess(paramb.a, paramb.e, paramb.f);
      }
    }
    c(paramb);
    a(paramb, false);
    int i1 = paramb.a;
    AppMethodBeat.o(146436);
    return i1;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(146435);
    int i1 = a(paramInt2, paramInt3, null);
    if (i1 != 0)
    {
      AppMethodBeat.o(146435);
      return i1;
    }
    if (this.i != null)
    {
      if (paramLong != 0L) {
        break label72;
      }
      paramLong = TXCTimeUtil.getTimeTick();
    }
    label72:
    for (;;)
    {
      this.i.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
      AppMethodBeat.o(146435);
      return 0;
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(66452);
    com.tencent.liteav.audio.b.a().b();
    com.tencent.liteav.audio.b.a().a(null);
    this.b = false;
    AppMethodBeat.o(66452);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66417);
    if (this.e != null) {
      this.e.a(paramFloat);
    }
    AppMethodBeat.o(66417);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(66470);
    if ((this.d != null) && (this.o.E)) {
      this.d.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(66470);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(66407);
    this.r = paramInt;
    if (this.d == null)
    {
      AppMethodBeat.o(66407);
      return;
    }
    this.d.b(paramInt);
    AppMethodBeat.o(66407);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66403);
    if (this.A != null)
    {
      this.A.a(new c.1(this, paramInt1, paramInt2));
      AppMethodBeat.o(66403);
      return;
    }
    this.y = paramInt1;
    this.z = paramInt2;
    AppMethodBeat.o(66403);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66398);
    if (this.d == null)
    {
      AppMethodBeat.o(66398);
      return;
    }
    this.d.a(new c.10(this, paramInt2, paramInt3, paramInt1));
    AppMethodBeat.o(66398);
  }
  
  public void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(66444);
    TXCLog.e(c, "onRecordError code = " + paramInt + ":" + paramString);
    if (paramInt == -1) {
      b(-1302, "打开麦克风失败");
    }
    AppMethodBeat.o(66444);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.H = paramLong2;
    this.G = paramLong3;
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(66411);
    if (this.e != null) {
      this.e.a(paramBitmap);
    }
    AppMethodBeat.o(66411);
  }
  
  public void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66450);
    if (this.d != null) {
      this.d.a(new c.4(this, paramBitmap, paramInt1, paramInt2, paramByteBuffer));
    }
    AppMethodBeat.o(66450);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(66453);
    if (this.e != null) {
      this.e.b();
    }
    AppMethodBeat.o(66453);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(66448);
    if (this.L == null)
    {
      AppMethodBeat.o(66448);
      return;
    }
    c.a locala = (c.a)this.L.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(66448);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(66402);
    if (this.w != null)
    {
      TXCLog.w(c, "camera preview view is not null, can't set surface");
      AppMethodBeat.o(66402);
      return;
    }
    this.x = paramSurface;
    AppMethodBeat.o(66402);
  }
  
  public void a(com.tencent.liteav.audio.e parame)
  {
    AppMethodBeat.i(146434);
    TXCLiveBGMPlayer.getInstance().setOnPlayListener(parame);
    AppMethodBeat.o(146434);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146422);
    this.R = new WeakReference(parama);
    AppMethodBeat.o(146422);
  }
  
  public void a(com.tencent.liteav.basic.d.n paramn)
  {
    AppMethodBeat.i(146427);
    if (this.w != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.w.getGLSurfaceView();
      if (localTXCGLSurfaceView != null) {
        localTXCGLSurfaceView.a(new c.2(this, paramn));
      }
      AppMethodBeat.o(146427);
      return;
    }
    if (this.A != null) {
      this.A.a(new c.3(this, paramn));
    }
    AppMethodBeat.o(146427);
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(146438);
    if (paramInt == 0)
    {
      this.H = paramTXSNALPacket.gopIndex;
      this.G = paramTXSNALPacket.frameIndex;
      if (this.L == null)
      {
        AppMethodBeat.o(146438);
        return;
      }
      c.a locala = (c.a)this.L.get();
      if (locala != null) {
        locala.onEncVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(146438);
      return;
    }
    if ((paramInt == 10000004) && (this.g == 1))
    {
      this.o.j = 0;
      b(1103, "硬编码启动失败,采用软编码");
      paramTXSNALPacket = TXCStatus.b(getID(), 10003);
      TXCEventRecorderProxy.a(getID(), 4011, -1, -1, paramTXSNALPacket, this.D);
    }
    AppMethodBeat.o(146438);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    AppMethodBeat.i(146437);
    d(paramb.a, paramb.e, paramb.f);
    AppMethodBeat.o(146437);
  }
  
  public void a(c.a parama)
  {
    AppMethodBeat.i(146421);
    this.L = new WeakReference(parama);
    AppMethodBeat.o(146421);
  }
  
  public void a(f paramf)
  {
    AppMethodBeat.i(66388);
    int i1;
    int i2;
    if ((paramf != null) && ((this.o.y != paramf.y) || (this.o.z != paramf.z) || (this.o.A != paramf.A) || (this.o.D != paramf.D) || (this.o.B != paramf.B) || (this.o.C != paramf.C)))
    {
      i1 = 1;
      if ((paramf == null) || ((this.o.a == paramf.a) && (this.o.b == paramf.b))) {
        break label229;
      }
      i2 = 1;
      if (paramf == null) {
        break label249;
      }
    }
    for (;;)
    {
      try
      {
        this.o = ((f)paramf.clone());
        if ((i2 == 0) || (this.o.N)) {
          break label263;
        }
        bool = true;
        f(bool);
        if (l())
        {
          y();
          A();
          if (this.d != null) {
            this.d.e(this.o.l);
          }
          if (i1 != 0) {
            z();
          }
        }
        AppMethodBeat.o(66388);
        return;
        i1 = 0;
        break;
        label229:
        i2 = 0;
      }
      catch (CloneNotSupportedException paramf)
      {
        this.o = new f();
        continue;
      }
      label249:
      this.o = new f();
      continue;
      label263:
      boolean bool = false;
    }
  }
  
  public void a(l paraml)
  {
    AppMethodBeat.i(146423);
    this.S = new WeakReference(paraml);
    AppMethodBeat.o(146423);
  }
  
  public void a(com.tencent.liteav.videoencoder.b paramb)
  {
    AppMethodBeat.i(66451);
    if (this.d != null)
    {
      this.d.a(new c.5(this, paramb));
      AppMethodBeat.o(66451);
      return;
    }
    if (paramb != null) {}
    try
    {
      paramb.a();
      paramb.a(null);
      AppMethodBeat.o(66451);
      return;
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(66451);
    }
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(66400);
    if (this.o.G)
    {
      TXCLog.e(c, "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(66400);
      return;
    }
    boolean bool = this.o.P;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      paramTXCloudVideoView.getGLSurfaceView();
      localObject = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
      paramTXCloudVideoView.addVideoView((TXCGLSurfaceView)localObject);
    }
    for (;;)
    {
      this.p = 0;
      this.d = new b(this.n, this.o, (com.tencent.liteav.basic.d.l)localObject, bool);
      k(this.D);
      this.d.a(getID());
      this.d.a(this);
      this.d.a(this);
      this.d.a();
      this.d.b(this.r);
      this.d.c(this.s);
      this.d.d(this.U);
      this.w = paramTXCloudVideoView;
      if (this.w != null) {
        this.w.start(this.o.E, this.o.F, this.d);
      }
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(66400);
      return;
      localObject = new com.tencent.liteav.basic.d.e();
      bool = false;
    }
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(66412);
    if (this.e != null) {
      this.e.a(paramString);
    }
    AppMethodBeat.o(66412);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(66401);
    if (this.d == null)
    {
      AppMethodBeat.o(66401);
      return;
    }
    this.d.a(paramBoolean);
    this.d = null;
    if (this.w != null)
    {
      this.w.stop(paramBoolean);
      this.w = null;
    }
    this.x = null;
    if (this.A != null)
    {
      this.A.a();
      this.A = null;
    }
    AppMethodBeat.o(66401);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(66390);
    com.tencent.liteav.audio.b.a().a(paramArrayOfByte);
    AppMethodBeat.o(66390);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66442);
    if (this.L == null)
    {
      AppMethodBeat.o(66442);
      return;
    }
    c.a locala = (c.a)this.L.get();
    if (locala != null) {
      locala.onRecordPcm(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(66442);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(66441);
    if (!this.O)
    {
      this.O = true;
      TXCKeyPointReportProxy.a(30002, 0);
    }
    if (this.L == null)
    {
      AppMethodBeat.o(66441);
      return;
    }
    c.a locala = (c.a)this.L.get();
    if (locala != null) {
      locala.onRecordRawPcm(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3, paramBoolean);
    }
    AppMethodBeat.o(66441);
  }
  
  public int b()
  {
    return this.h.width;
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(66424);
    this.v = paramFloat;
    TXCLiveBGMPlayer.getInstance().setPitch(paramFloat);
    AppMethodBeat.o(66424);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(66410);
    if (this.e != null) {
      this.e.b(paramInt);
    }
    AppMethodBeat.o(66410);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66423);
    this.W = paramInt1;
    this.X = paramInt2;
    com.tencent.liteav.audio.b.a().a(paramInt1, paramInt2);
    AppMethodBeat.o(66423);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(146439);
    if (!this.P)
    {
      this.P = true;
      TXCKeyPointReportProxy.a(30003, 0);
    }
    j localj = this.d;
    if ((this.e != null) && (!this.o.G) && (localj != null))
    {
      if ((this.h.height != paramb.h) || (this.h.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.B = paramb.k;
      this.e.a(localj.f());
      this.e.a(paramb, paramb.b, 0, 0L);
    }
    AppMethodBeat.o(146439);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66443);
    if (this.L == null)
    {
      AppMethodBeat.o(66443);
      return;
    }
    c.a locala = (c.a)this.L.get();
    if (locala != null) {
      locala.onEncAudio(paramArrayOfByte, paramLong, paramInt1, paramInt2);
    }
    AppMethodBeat.o(66443);
  }
  
  public boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66409);
    if (this.e != null)
    {
      this.e.c(paramInt1);
      this.e.d(paramInt2);
      this.e.e(paramInt3);
    }
    AppMethodBeat.o(66409);
    return true;
  }
  
  @TargetApi(18)
  public boolean b(String paramString)
  {
    AppMethodBeat.i(66414);
    if (this.e != null)
    {
      boolean bool = this.e.a(paramString, true);
      AppMethodBeat.o(66414);
      return bool;
    }
    AppMethodBeat.o(66414);
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    AppMethodBeat.i(66408);
    if (this.d == null)
    {
      AppMethodBeat.o(66408);
      return false;
    }
    paramBoolean = this.d.d(paramBoolean);
    AppMethodBeat.o(66408);
    return paramBoolean;
  }
  
  public int c()
  {
    return this.h.height;
  }
  
  public int c(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66440);
    int i1 = a(paramInt2, paramInt3, ((EGL10)EGLContext.getEGL()).eglGetCurrentContext());
    if (i1 != 0)
    {
      AppMethodBeat.o(66440);
      return i1;
    }
    if (this.i != null) {
      this.i.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
    AppMethodBeat.o(66440);
    return 0;
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(66428);
    if (this.d == null)
    {
      AppMethodBeat.o(66428);
      return;
    }
    this.d.a(paramFloat);
    AppMethodBeat.o(66428);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(66415);
    if (this.e != null) {
      this.e.g(paramInt);
    }
    AppMethodBeat.o(66415);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(66413);
    if (this.e != null) {
      this.e.c(paramBoolean);
    }
    AppMethodBeat.o(66413);
  }
  
  public boolean c(String paramString)
  {
    AppMethodBeat.i(66431);
    if (!com.tencent.liteav.audio.b.a().c())
    {
      AppMethodBeat.o(66431);
      return false;
    }
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.aA);
    boolean bool = TXCLiveBGMPlayer.getInstance().startPlay(paramString, com.tencent.liteav.audio.b.a().f());
    AppMethodBeat.o(66431);
    return bool;
  }
  
  public int d(String paramString)
  {
    AppMethodBeat.i(66437);
    int i1 = (int)TXCLiveBGMPlayer.getInstance().getMusicDuration(paramString);
    AppMethodBeat.o(66437);
    return i1;
  }
  
  public String d()
  {
    AppMethodBeat.i(66393);
    String str = com.tencent.liteav.audio.b.a().f() + " | " + com.tencent.liteav.audio.b.a().e() + "," + com.tencent.liteav.audio.b.a().d();
    AppMethodBeat.o(66393);
    return str;
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(66416);
    if (this.e != null) {
      this.e.h(paramInt);
    }
    AppMethodBeat.o(66416);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(66422);
    this.V = paramBoolean;
    com.tencent.liteav.audio.b.a().c(paramBoolean);
    AppMethodBeat.o(66422);
  }
  
  public boolean d(float paramFloat)
  {
    AppMethodBeat.i(66435);
    this.t = paramFloat;
    com.tencent.liteav.audio.b.a().a(paramFloat);
    AppMethodBeat.o(66435);
    return true;
  }
  
  public int e()
  {
    AppMethodBeat.i(66394);
    int i1 = f();
    if (i1 == 0) {
      h();
    }
    AppMethodBeat.o(66394);
    return i1;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(66418);
    if (this.e != null) {
      this.e.i(paramInt);
    }
    AppMethodBeat.o(66418);
  }
  
  public boolean e(float paramFloat)
  {
    AppMethodBeat.i(66436);
    TXCLiveBGMPlayer.getInstance().setVolume(paramFloat);
    AppMethodBeat.o(66436);
    return true;
  }
  
  public boolean e(boolean paramBoolean)
  {
    AppMethodBeat.i(66427);
    this.o.M = paramBoolean;
    if (this.d == null)
    {
      AppMethodBeat.o(66427);
      return false;
    }
    this.d.c(paramBoolean);
    AppMethodBeat.o(66427);
    return true;
  }
  
  public int f()
  {
    AppMethodBeat.i(146424);
    if (l())
    {
      TXCLog.w(c, "ignore startPush when pushing, status:" + this.q);
      AppMethodBeat.o(146424);
      return -2;
    }
    TXCDRApi.initCrashReport(this.n);
    this.q = 1;
    TXCLog.d(c, "startWithoutAudio");
    A();
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.br);
    AppMethodBeat.o(146424);
    return 0;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(66419);
    if (this.e != null) {
      this.e.j(paramInt);
    }
    AppMethodBeat.o(66419);
  }
  
  public void g()
  {
    AppMethodBeat.i(66396);
    if (!l())
    {
      TXCLog.w(c, "ignore stopPush when not pushing, status:" + this.q);
      AppMethodBeat.o(66396);
      return;
    }
    TXCLog.d(c, "stop");
    this.q = 0;
    i();
    v();
    this.o.J = false;
    if (this.a != null) {
      this.a.a();
    }
    this.C = null;
    AppMethodBeat.o(66396);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(66420);
    if (this.e != null) {
      this.e.k(paramInt);
    }
    AppMethodBeat.o(66420);
  }
  
  public void h()
  {
    AppMethodBeat.i(66397);
    y();
    com.tencent.liteav.audio.b.a().a(this);
    this.O = false;
    TXCKeyPointReportProxy.a(30002);
    if (((this.o != null) && (this.o.G)) || (this.p == 1) || (this.d == null) || (this.d.d()))
    {
      if (com.tencent.liteav.audio.b.a().a(this.n) == 0) {
        b(2027, "打开麦克风成功");
      }
      AppMethodBeat.o(66397);
      return;
    }
    if (this.d != null) {
      this.d.e(true);
    }
    AppMethodBeat.o(66397);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(66421);
    if (this.e != null) {
      this.e.l(paramInt);
    }
    AppMethodBeat.o(66421);
  }
  
  public void i()
  {
    AppMethodBeat.i(146425);
    TXCKeyPointReportProxy.a(31003);
    TXCLog.d(c, "stopAudioRecord");
    TXCKeyPointReportProxy.a(31003, com.tencent.liteav.audio.b.a().b());
    com.tencent.liteav.audio.b.a().a(null);
    this.v = 0.0F;
    this.b = false;
    AppMethodBeat.o(146425);
  }
  
  public boolean i(int paramInt)
  {
    AppMethodBeat.i(66426);
    if (this.d == null)
    {
      AppMethodBeat.o(66426);
      return false;
    }
    boolean bool = this.d.a(paramInt);
    AppMethodBeat.o(66426);
    return bool;
  }
  
  public void j()
  {
    AppMethodBeat.i(66399);
    if (this.q != 1)
    {
      TXCLog.w(c, "ignore pause push when is not pushing, status:" + this.q);
      AppMethodBeat.o(66399);
      return;
    }
    this.q = 2;
    TXCLog.d(c, "pausePusher");
    if ((this.o.x & 0x1) == 1)
    {
      if ((this.a != null) && (!this.o.G) && (this.d != null)) {
        this.a.a(this.o.w, this.o.v, this.o.u, this.h.width, this.h.height);
      }
      if (this.d != null) {
        this.d.c();
      }
    }
    if ((this.o.x & 0x2) == 2) {
      com.tencent.liteav.audio.b.a().c(true);
    }
    AppMethodBeat.o(66399);
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(66429);
    this.u = paramInt;
    com.tencent.liteav.audio.b.a().d(paramInt);
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.az);
    AppMethodBeat.o(66429);
  }
  
  public void k()
  {
    AppMethodBeat.i(66405);
    if (this.q != 2)
    {
      TXCLog.w(c, "ignore resume push when is not pause, status:" + this.q);
      AppMethodBeat.o(66405);
      return;
    }
    this.q = 1;
    TXCLog.d(c, "resumePusher");
    if ((this.o.x & 0x1) == 1)
    {
      if ((this.a != null) && (!this.o.G)) {
        this.a.a();
      }
      if (this.d != null) {
        this.d.b();
      }
      z();
    }
    if ((this.o.x & 0x2) == 2)
    {
      com.tencent.liteav.audio.b.a().c(this.V);
      if ((this.o.L & 0x1) == 0)
      {
        com.tencent.liteav.audio.b.a().b();
        com.tencent.liteav.audio.b.a().a(this.o.q);
        com.tencent.liteav.audio.b.a().a(this.o.s, this.n);
        com.tencent.liteav.audio.b.a().d(this.u);
        com.tencent.liteav.audio.b.a().a(this.W, this.X);
        com.tencent.liteav.audio.b.a().a(this.t);
        com.tencent.liteav.audio.b.a().c(this.V);
        com.tencent.liteav.audio.b.a().f(this.Y);
        com.tencent.liteav.audio.b.a().a(this);
        com.tencent.liteav.audio.b.a().d(this.b);
        com.tencent.liteav.audio.b.a().a(this.n);
      }
    }
    AppMethodBeat.o(66405);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(66463);
    this.D = paramInt;
    if ((this.d != null) && ((this.d instanceof b))) {
      ((b)this.d).g(this.D);
    }
    AppMethodBeat.o(66463);
  }
  
  public boolean l()
  {
    return this.q != 0;
  }
  
  public void m()
  {
    AppMethodBeat.i(146426);
    if (this.d == null)
    {
      AppMethodBeat.o(146426);
      return;
    }
    this.d.a(new c.11(this));
    AppMethodBeat.o(146426);
  }
  
  public void n()
  {
    AppMethodBeat.i(146428);
    if (Build.VERSION.SDK_INT < 21)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
      onNotifyEvent(-1309, localBundle);
      TXLog.e(c, "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(146428);
      return;
    }
    this.p = 1;
    this.d = new h(this.n, this.o);
    this.d.a(this);
    this.d.a(this);
    this.d.a();
    this.d.a(getID());
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.aG);
    AppMethodBeat.o(146428);
  }
  
  public void o()
  {
    AppMethodBeat.i(146429);
    if (this.d == null)
    {
      AppMethodBeat.o(146429);
      return;
    }
    v();
    this.d.a(false);
    this.d = null;
    AppMethodBeat.o(146429);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(66449);
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    com.tencent.liteav.basic.util.b.a(this.R, paramInt, paramBundle);
    int i2;
    if (paramInt == -1317)
    {
      paramBundle = getID();
      i2 = 2002;
      i1 = 4;
    }
    for (;;)
    {
      TXCEventRecorderProxy.a(paramBundle, i2, i1, -1, "", this.D);
      do
      {
        if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319)) {
          break label174;
        }
        TXCKeyPointReportProxy.a(30002, paramInt);
        AppMethodBeat.o(66449);
        return;
        if (paramInt == -1314)
        {
          paramBundle = getID();
          i2 = 2002;
          i1 = 5;
          break;
        }
      } while ((paramInt != 1003) || (this.d == null));
      paramBundle = getID();
      i2 = 4001;
      if (this.d.g()) {
        i1 = 0;
      } else {
        i1 = 1;
      }
    }
    label174:
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.a(30003, paramInt);
      if (this.d != null)
      {
        paramBundle = getID();
        if (!this.d.g()) {
          break label258;
        }
      }
    }
    label258:
    for (int i1 = 0;; i1 = 1)
    {
      TXCEventRecorderProxy.a(paramBundle, 4002, i1, paramInt, "", this.D);
      AppMethodBeat.o(66449);
      return;
    }
  }
  
  public boolean p()
  {
    AppMethodBeat.i(66433);
    boolean bool = this.V;
    AppMethodBeat.o(66433);
    return bool;
  }
  
  public int q()
  {
    AppMethodBeat.i(146430);
    if (this.d == null)
    {
      AppMethodBeat.o(146430);
      return 0;
    }
    int i1 = this.d.e();
    AppMethodBeat.o(146430);
    return i1;
  }
  
  public boolean r()
  {
    AppMethodBeat.i(146431);
    TXCLiveBGMPlayer.getInstance().stopPlay();
    AppMethodBeat.o(146431);
    return true;
  }
  
  public boolean s()
  {
    AppMethodBeat.i(146432);
    TXCLiveBGMPlayer.getInstance().pause();
    AppMethodBeat.o(146432);
    return true;
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(66392);
    super.setID(paramString);
    if (this.i != null) {
      this.i.setID(paramString);
    }
    if (this.m != null) {
      this.m.setID(paramString);
    }
    if (this.e != null) {
      this.e.setID(paramString);
    }
    if (this.d != null) {
      this.d.a(getID());
    }
    com.tencent.liteav.audio.b.a().a(paramString);
    AppMethodBeat.o(66392);
  }
  
  public boolean t()
  {
    AppMethodBeat.i(146433);
    TXCLiveBGMPlayer.getInstance().resume();
    AppMethodBeat.o(146433);
    return true;
  }
  
  public void u()
  {
    AppMethodBeat.i(66462);
    TXCLog.i(c, "onCaptureDestroy->enter with mVideoFrameFilter:" + this.M);
    if (this.e != null) {
      this.e.b();
    }
    if (this.M != null)
    {
      this.M.d();
      this.M = null;
    }
    if (this.N != null)
    {
      this.N.d();
      this.N = null;
    }
    x();
    if (this.S != null)
    {
      l locall = (l)this.S.get();
      if (locall != null) {
        locall.onTextureDestoryed();
      }
    }
    AppMethodBeat.o(66462);
  }
  
  public void v()
  {
    AppMethodBeat.i(66464);
    if (this.i == null)
    {
      AppMethodBeat.o(66464);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new c.6(this));
      AppMethodBeat.o(66464);
      return;
    }
    x();
    AppMethodBeat.o(66464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.c
 * JD-Core Version:    0.7.0.1
 */