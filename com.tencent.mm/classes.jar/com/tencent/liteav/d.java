package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.h.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.d.d;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class d
  extends com.tencent.liteav.basic.module.a
  implements b.b, com.tencent.liteav.basic.b.b, com.tencent.liteav.beauty.f, l, com.tencent.liteav.videoencoder.d
{
  private int A;
  private int B;
  private com.tencent.liteav.basic.c.e C;
  private com.tencent.liteav.basic.structs.b D;
  private int E;
  private boolean F;
  private boolean G;
  private long H;
  private long I;
  private int J;
  private WeakReference<o> K;
  private boolean L;
  private WeakReference<a> M;
  private h N;
  private h O;
  private h P;
  private com.tencent.liteav.beauty.b.k Q;
  private byte[] R;
  private boolean S;
  private boolean T;
  private boolean U;
  private final com.tencent.liteav.beauty.b V;
  private WeakReference<com.tencent.liteav.basic.b.b> W;
  private WeakReference<m> X;
  private int Y;
  private int Z;
  b a;
  b b;
  private final com.tencent.liteav.basic.util.e c;
  private k d;
  private com.tencent.liteav.beauty.d e;
  private boolean f;
  private boolean g;
  private TXSVideoEncoderParam h;
  private com.tencent.liteav.videoencoder.b i;
  private int j;
  private boolean k;
  private TXSVideoEncoderParam l;
  private com.tencent.liteav.videoencoder.b m;
  private final Object n;
  private Context o;
  private g p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private int u;
  private int v;
  private boolean w;
  private TXCloudVideoView x;
  private final Object y;
  private Surface z;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(14385);
    this.c = new com.tencent.liteav.basic.util.e(Looper.getMainLooper());
    this.d = null;
    this.e = null;
    this.f = false;
    this.g = false;
    this.h = null;
    this.i = null;
    this.j = 15;
    this.k = false;
    this.l = null;
    this.m = null;
    this.n = new Object();
    this.o = null;
    this.p = null;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.t = false;
    this.u = 0;
    this.v = 0;
    this.w = false;
    this.x = null;
    this.y = new Object();
    this.z = null;
    this.A = 0;
    this.B = 0;
    this.C = null;
    this.E = 0;
    this.F = false;
    this.G = false;
    this.H = 0L;
    this.I = 0L;
    this.J = 2;
    this.L = false;
    this.M = null;
    this.N = null;
    this.S = false;
    this.T = false;
    this.U = false;
    this.Y = 0;
    this.Z = 0;
    this.o = paramContext.getApplicationContext();
    this.p = new g();
    this.e = new com.tencent.liteav.beauty.d(this.o, true);
    this.e.a(this);
    this.e.a(this);
    if (this.p.U) {
      this.e.a(d.d.a);
    }
    for (;;)
    {
      this.h = new TXSVideoEncoderParam();
      this.h.encoderMode = 1;
      this.i = null;
      this.l = new TXSVideoEncoderParam();
      this.l.encoderMode = 1;
      this.a = new b(this);
      this.V = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.license.g(this.o));
      this.V.setPreprocessor(this.e);
      com.tencent.liteav.basic.d.c.a().a(this.o);
      AppMethodBeat.o(14385);
      return;
      if (this.p.T) {
        this.e.a(d.d.b);
      } else {
        this.e.a(d.d.c);
      }
    }
  }
  
  private void A()
  {
    AppMethodBeat.i(221685);
    if (this.d != null) {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221598);
          d.a(d.this, d.c(d.this).width, d.c(d.this).height);
          AppMethodBeat.o(221598);
        }
      });
    }
    AppMethodBeat.o(221685);
  }
  
  private void B()
  {
    AppMethodBeat.i(221687);
    if (this.e != null)
    {
      if (this.p.U)
      {
        this.e.a(d.d.a);
        AppMethodBeat.o(221687);
        return;
      }
      if (this.p.T)
      {
        this.e.a(d.d.b);
        AppMethodBeat.o(221687);
        return;
      }
      this.e.a(d.d.c);
    }
    AppMethodBeat.o(221687);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(221678);
    paramInt2 = this.p.a;
    paramInt1 = this.p.b;
    if ((this.p.l == 0) || (this.p.l == 2))
    {
      paramInt2 = this.p.b;
      paramInt1 = this.p.a;
    }
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
      AppMethodBeat.o(221678);
      return -1;
    }
    if (this.p.M)
    {
      z();
      AppMethodBeat.o(221678);
      return -1000;
    }
    b(paramInt2, paramInt1, paramObject);
    AppMethodBeat.o(221678);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(221677);
    if (paramLong == 0L) {
      paramLong = TXCTimeUtil.generatePtsMS();
    }
    for (;;)
    {
      b(paramInt2, paramInt3, this.e.a());
      com.tencent.liteav.videoencoder.b localb = this.i;
      if (localb != null) {
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      localb = this.m;
      if (localb != null) {
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      AppMethodBeat.o(221677);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(221675);
    TXCLog.i("TXCCaptureAndEnc", "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3 + " eglContext: " + paramObject);
    z();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.E, Integer.valueOf(paramInt3));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt3 == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.E);
      this.T = false;
      this.h.encodeType = paramInt3;
      this.h.width = paramInt1;
      this.h.height = paramInt2;
      this.h.fps = paramInt4;
      this.h.gop = this.p.i;
      this.h.encoderProfile = this.p.n;
      localTXSVideoEncoderParam = this.h;
      if (paramObject == null) {
        break label557;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.h.realTime = paramBoolean;
      this.h.streamType = this.E;
      this.h.annexb = this.G;
      this.h.bMultiRef = this.F;
      this.h.baseFrameIndex = (this.H + 20L);
      this.h.baseGopIndex = ((this.I + 1L) % 255L + 1L);
      this.h.bLimitFps = this.g;
      this.h.record = this.U;
      this.h.encFmt = this.p.Y;
      localb.a(this);
      localb.a(this);
      localb.a(this.h);
      localb.c(this.p.c);
      localb.d(this.j);
      localb.setID(getID());
      localb.a(this.Y);
      this.i = localb;
      TXCStatus.a(getID(), 4003, this.E, Integer.valueOf(this.h.width << 16 | this.h.height));
      TXCStatus.a(getID(), 13003, this.E, Integer.valueOf(this.h.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.h.width, this.h.height, "", this.E);
      TXCKeyPointReportProxy.a(40036, this.h.encodeType, this.E);
      TXCKeyPointReportProxy.a(40037, this.h.width << 16 | this.h.height, this.E);
      AppMethodBeat.o(221675);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.E);
      break;
      label557:
      paramObject = localb.a(paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    int i1 = 2002;
    AppMethodBeat.i(221660);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.f.a(this.W, paramInt, localBundle);
    if (paramInt == -1317)
    {
      paramString = getID();
      l1 = 4L;
    }
    for (;;)
    {
      TXCEventRecorderProxy.a(paramString, i1, l1, -1L, "", this.E);
      do
      {
        if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319)) {
          break label217;
        }
        TXCKeyPointReportProxy.b(30002, paramInt);
        AppMethodBeat.o(221660);
        return;
        if (paramInt == -1314)
        {
          paramString = getID();
          l1 = 5L;
          break;
        }
      } while ((paramInt != 1003) || (this.d == null));
      paramString = getID();
      i1 = 4001;
      if (this.d.l()) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
    }
    label217:
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.d != null)
      {
        paramString = getID();
        if (!this.d.l()) {
          break label304;
        }
      }
    }
    label304:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.E);
      AppMethodBeat.o(221660);
      return;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(221665);
    for (;;)
    {
      synchronized (this.n)
      {
        if (this.s == 2)
        {
          AppMethodBeat.o(221665);
          return;
        }
        paramb.e = paramInt1;
        paramb.f = paramInt2;
        paramb.i = this.p.S;
        if (this.p.l == 0)
        {
          paramb.g = this.p.b;
          paramb.h = this.p.a;
          paramb.l = com.tencent.liteav.basic.util.f.a(paramb.e, paramb.f, paramb.g, paramb.h);
        }
      }
      try
      {
        this.e.a(this.p.l);
        this.e.a(paramObject);
        this.e.a(paramb, paramb.b, 0, paramLong);
        AppMethodBeat.o(221665);
        return;
        paramb.g = this.p.a;
        paramb.h = this.p.b;
        continue;
        paramb = finally;
        AppMethodBeat.o(221665);
        throw paramb;
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          TXCLog.e("TXCCaptureAndEnc", "send custom video frame failed." + paramb.getMessage());
        }
      }
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(221690);
    e(paramb.e, paramb.f);
    this.D = paramb;
    if (this.x != null)
    {
      if (this.d != null)
      {
        this.d.a(paramb);
        AppMethodBeat.o(221690);
      }
    }
    else {
      synchronized (this.y)
      {
        if ((this.z != null) && (this.C == null) && (this.d != null) && (this.d.f() != null))
        {
          this.C = new com.tencent.liteav.basic.c.e();
          this.C.a(this.d.f(), this.z);
          this.C.a(this.v);
          this.C.b(this.Z);
        }
        if ((this.C != null) && (this.d != null)) {
          this.C.a(paramb.a, paramb.i, this.u, this.A, this.B, paramb.e, paramb.f, paramBoolean, this.d.l());
        }
        AppMethodBeat.o(221690);
        return;
      }
    }
    AppMethodBeat.o(221690);
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(221676);
    y();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
      localTXSVideoEncoderParam = this.l;
      if (paramObject == null) {
        break label245;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.l.encodeType = paramInt;
      this.l.realTime = paramBoolean;
      TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
      localb.a(this);
      localb.a(this);
      localb.a(this.l);
      localb.c(this.l.bitrate);
      localb.setID(getID());
      localb.a(this.Y);
      this.m = localb;
      TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.l.width << 16 | this.l.height));
      TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.l.gop * 1000));
      AppMethodBeat.o(221676);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
      break;
      label245:
      paramObject = localb.a(this.l.width, this.l.height);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(221695);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.c.a(paramRunnable);
      AppMethodBeat.o(221695);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(221695);
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i2 = 2;
    AppMethodBeat.i(221679);
    int i1 = i2;
    switch (this.p.j)
    {
    default: 
      i1 = i2;
    case 0: 
      if ((this.q == 1) && (this.r == 0)) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      i2 = this.p.i;
      if ((this.i == null) || (this.T) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.h.encodeType != i1) || (this.h.gop != i2)) {
        a(paramInt1, paramInt2, i1, paramObject, this.p.h, this.p.P);
      }
      if (((this.m == null) || (this.l.encodeType != i1)) && (this.k)) {
        a(paramObject, i1, this.p.P);
      }
      AppMethodBeat.o(221679);
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(221691);
    if (this.L)
    {
      i1 = paramb.a;
      AppMethodBeat.o(221691);
      return i1;
    }
    int i1 = paramb.a;
    int i7;
    h localh;
    if (this.Z == 1)
    {
      i7 = 1;
      if (i7 == paramb.i) {
        break label398;
      }
      if (this.O == null)
      {
        localh = new h();
        localh.a();
        localh.a(true);
        localh.a(paramb.e, paramb.f);
        if (paramb.e <= paramb.f) {
          break label373;
        }
        localh.h();
        label108:
        this.O = localh;
      }
      localh = this.O;
      if (localh == null) {
        break label398;
      }
      localh.a(paramb.e, paramb.f);
      i1 = localh.b(paramb.a);
    }
    label389:
    label398:
    for (;;)
    {
      int i2 = i1;
      int i4;
      int i5;
      float[] arrayOfFloat;
      int i6;
      if (this.u != 0)
      {
        if (this.P == null)
        {
          localh = new h();
          localh.a();
          localh.a(true);
          localh.a(paramb.e, paramb.f);
          this.P = localh;
        }
        localh = this.P;
        i2 = i1;
        if (localh != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          i4 = paramb.e;
          i5 = paramb.f;
          arrayOfFloat = localh.a(i4, i5, null, com.tencent.liteav.basic.util.f.a(i4, i5, paramb.e, paramb.f), 0);
          i6 = (720 - this.u) % 360;
          if ((i6 != 90) && (i6 != 270)) {
            break label381;
          }
          i2 = paramb.f;
          label304:
          if ((i6 != 90) && (i6 != 270)) {
            break label389;
          }
        }
      }
      for (int i3 = paramb.e;; i3 = paramb.f)
      {
        localh.a(i4, i5, i6, arrayOfFloat, i2 / i3, false, false);
        localh.b(i1);
        i2 = localh.l();
        AppMethodBeat.o(221691);
        return i2;
        i7 = 0;
        break;
        label373:
        localh.g();
        break label108;
        label381:
        i2 = paramb.e;
        break label304;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221686);
    com.tencent.liteav.beauty.d locald;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.p.J != -1.0F) {
      if (this.e != null)
      {
        locald = this.e;
        localBitmap = this.p.E;
        f3 = this.p.H;
        f2 = this.p.I;
        f1 = this.p.J;
      }
    }
    for (;;)
    {
      locald.a(localBitmap, f3, f2, f1);
      do
      {
        AppMethodBeat.o(221686);
        return;
      } while ((this.e == null) || (paramInt1 == 0) || (paramInt2 == 0));
      locald = this.e;
      localBitmap = this.p.E;
      f3 = this.p.F / paramInt1;
      f2 = this.p.G / paramInt2;
      if (this.p.E == null) {
        f1 = 0.0F;
      } else {
        f1 = this.p.E.getWidth() / paramInt1;
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221688);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(221688);
  }
  
  private void d(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(221692);
    Object localObject2 = this.K;
    if (localObject2 == null)
    {
      AppMethodBeat.o(221692);
      return;
    }
    int i1 = c(paramb);
    Object localObject1;
    if (this.J == 2)
    {
      localObject1 = (o)((WeakReference)localObject2).get();
      if (localObject1 != null)
      {
        localObject2 = new TXSVideoFrame();
        ((TXSVideoFrame)localObject2).width = paramb.e;
        ((TXSVideoFrame)localObject2).height = paramb.f;
        ((TXSVideoFrame)localObject2).textureId = i1;
        ((TXSVideoFrame)localObject2).eglContext = this.e.a();
        ((TXSVideoFrame)localObject2).pts = TXCTimeUtil.generatePtsMS();
        ((o)localObject1).onRenderVideoFrame(getID(), this.E, (TXSVideoFrame)localObject2);
        if (this.L) {
          paramb.a = ((TXSVideoFrame)localObject2).textureId;
        }
      }
    }
    label214:
    do
    {
      do
      {
        if ((this.L) && (this.x != null))
        {
          paramb = this.x.getGLSurfaceView();
          if (paramb != null) {
            paramb.d();
          }
        }
        AppMethodBeat.o(221692);
        return;
      } while ((this.J != 1) && (this.J != 4));
      if (this.N == null)
      {
        if (this.J != 1) {
          break;
        }
        localObject1 = new com.tencent.liteav.beauty.b.o(1);
        ((h)localObject1).a(true);
        if (!((h)localObject1).a()) {
          break label445;
        }
        ((h)localObject1).a(paramb.e, paramb.f);
        ((h)localObject1).a(new h.a()
        {
          public void a(int paramAnonymousInt)
          {
            AppMethodBeat.i(221597);
            h localh = d.q(d.this);
            o localo = (o)this.a.get();
            if ((localh != null) && (localo != null))
            {
              TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
              localTXSVideoFrame.width = localh.n();
              localTXSVideoFrame.height = localh.o();
              localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
              localo.onRenderVideoFrame(d.this.getID(), d.r(d.this), localTXSVideoFrame);
              d.a(d.this, localTXSVideoFrame.data);
            }
            AppMethodBeat.o(221597);
          }
        });
        this.N = ((h)localObject1);
      }
      localObject1 = this.N;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((h)localObject1).a(paramb.e, paramb.f);
        ((h)localObject1).b(i1);
      }
    } while ((!this.L) || (this.R == null));
    label257:
    if (this.J == 1) {
      i1 = 1;
    }
    for (;;)
    {
      if (this.Q == null)
      {
        localObject1 = new com.tencent.liteav.beauty.b.k(i1);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
        if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
          TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
        }
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        this.Q = ((com.tencent.liteav.beauty.b.k)localObject1);
      }
      localObject1 = this.Q;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(this.R);
        paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).q();
      }
      this.R = null;
      break;
      localObject1 = new com.tencent.liteav.beauty.b.o(3);
      break label214;
      label445:
      TXCLog.i("TXCCaptureAndEnc", "init filter error ");
      this.N = null;
      break label257;
      if (this.J == 4) {
        i1 = 3;
      } else {
        i1 = 1;
      }
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221689);
    if (!this.w)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", getID());
      localBundle.putInt("EVT_ID", 2003);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putCharSequence("EVT_MSG", "Renders the first video frame");
      localBundle.putInt("EVT_PARAM1", paramInt1);
      localBundle.putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.f.a(this.W, 2003, localBundle);
      TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.E);
      this.w = true;
    }
    AppMethodBeat.o(221689);
  }
  
  private void j(final boolean paramBoolean)
  {
    AppMethodBeat.i(221641);
    if (this.d == null)
    {
      AppMethodBeat.o(221641);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(221368);
        if (d.l(d.this) != null) {
          d.l(d.this).b();
        }
        AppMethodBeat.o(221368);
      }
    });
    t();
    this.d.a(paramBoolean);
    this.d = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.x;
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222645);
        if (this.a != null) {
          this.a.stop(paramBoolean);
        }
        AppMethodBeat.o(222645);
      }
    });
    this.x = null;
    synchronized (this.y)
    {
      this.z = null;
      if (this.C != null)
      {
        this.C.a();
        this.C = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.t) {
        w();
      }
      AppMethodBeat.o(221641);
      return;
    }
  }
  
  private void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(221684);
    if (this.d != null) {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222352);
          k localk = d.e(d.this);
          if (localk == null)
          {
            AppMethodBeat.o(222352);
            return;
          }
          localk.f(d.d(d.this).h);
          localk.e(d.d(d.this).l);
          localk.a(d.d(d.this).k);
          localk.b(d.d(d.this).a, d.d(d.this).b);
          localk.e(d.d(d.this).U);
          if ((paramBoolean) && (localk.d())) {
            localk.b(false);
          }
          AppMethodBeat.o(222352);
        }
      });
    }
    AppMethodBeat.o(221684);
  }
  
  private void w()
  {
    AppMethodBeat.i(221627);
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new b(this);
    }
    this.b.a(10, -1, null, 64, 64);
    AppMethodBeat.o(221627);
  }
  
  private void x()
  {
    AppMethodBeat.i(221628);
    TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.t);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(221628);
  }
  
  private void y()
  {
    AppMethodBeat.i(221682);
    try
    {
      com.tencent.liteav.videoencoder.b localb = this.m;
      this.m = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      AppMethodBeat.o(221682);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", localException);
      AppMethodBeat.o(221682);
    }
  }
  
  private void z()
  {
    AppMethodBeat.i(221683);
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      com.tencent.liteav.videoencoder.b localb = this.i;
      this.i = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      this.T = true;
      AppMethodBeat.o(221683);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", localException);
      AppMethodBeat.o(221683);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(221663);
    for (;;)
    {
      synchronized (this.n)
      {
        if (this.s == 2)
        {
          AppMethodBeat.o(221663);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, paramObject);
        if (i1 != 0)
        {
          AppMethodBeat.o(221663);
          return i1;
        }
        if (paramLong == 0L)
        {
          paramLong = TXCTimeUtil.generatePtsMS();
          paramObject = this.i;
          if (paramObject != null)
          {
            paramObject.a(this.p.S);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
          paramObject = this.m;
          if (paramObject != null)
          {
            paramObject.a(this.p.S);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
          AppMethodBeat.o(221663);
          return 0;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(221664);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.a = paramInt1;
    localb.b = 0;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(221664);
    return 0;
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(221666);
    if (this.X != null)
    {
      m localm = (m)this.X.get();
      if (localm != null) {
        paramb.a = localm.a(paramb.a, paramb.e, paramb.f);
      }
    }
    d(paramb);
    a(paramb, false);
    int i1 = paramb.a;
    AppMethodBeat.o(221666);
    return i1;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(221635);
    int i1;
    if ((this.l.width != paramInt1) || (this.l.height != paramInt2))
    {
      i1 = 1;
      this.l.width = paramInt1;
      this.l.height = paramInt2;
      this.l.fps = paramInt3;
      this.l.gop = paramInt5;
      this.l.encoderProfile = 1;
      this.l.realTime = this.p.P;
      this.l.streamType = 3;
      this.l.bitrate = paramInt4;
      this.l.annexb = true;
      this.l.bMultiRef = false;
      if ((this.m != null) && ((i1 != 0) || ((this.k) && (!paramBoolean))))
      {
        if (this.d == null) {
          break label186;
        }
        this.d.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(221428);
            d.h(d.this);
            AppMethodBeat.o(221428);
          }
        });
      }
    }
    for (;;)
    {
      this.k = paramBoolean;
      AppMethodBeat.o(221635);
      return 0;
      i1 = 0;
      break;
      label186:
      y();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(221661);
    for (;;)
    {
      synchronized (this.n)
      {
        if (this.s == 2)
        {
          AppMethodBeat.o(221661);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, null);
        if (i1 != 0)
        {
          AppMethodBeat.o(221661);
          return i1;
        }
        com.tencent.liteav.videoencoder.b localb = this.i;
        if (localb != null)
        {
          if (paramLong == 0L)
          {
            paramLong = TXCTimeUtil.generatePtsMS();
            localb.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
          }
        }
        else
        {
          AppMethodBeat.o(221661);
          return 0;
        }
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(221662);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.m = paramArrayOfByte;
    localb.b = paramInt1;
    localb.d = true;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(221662);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(14386);
    TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
    if (this.M == null)
    {
      AppMethodBeat.o(14386);
      return;
    }
    a locala = (a)this.M.get();
    if (locala == null)
    {
      AppMethodBeat.o(14386);
      return;
    }
    locala.onBackgroudPushStop();
    AppMethodBeat.o(14386);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(221656);
    if (this.d == null)
    {
      AppMethodBeat.o(221656);
      return;
    }
    this.d.a(paramFloat);
    AppMethodBeat.o(221656);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(221693);
    if ((this.d != null) && (this.p.K)) {
      this.d.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(221693);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(221622);
    TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(paramInt)));
    this.Y = paramInt;
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(14380);
          if (d.a(d.this) != null) {
            d.a(d.this).a(paramInt);
          }
          if (d.b(d.this) != null) {
            d.b(d.this).a(paramInt);
          }
          AppMethodBeat.o(14380);
        }
      });
      AppMethodBeat.o(221622);
      return;
    }
    com.tencent.liteav.videoencoder.b localb = this.i;
    if (localb != null) {
      localb.a(paramInt);
    }
    localb = this.m;
    if (localb != null) {
      localb.a(paramInt);
    }
    AppMethodBeat.o(221622);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(221638);
    synchronized (this.y)
    {
      if (this.C != null)
      {
        this.C.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222015);
            d.b(d.this, paramInt1);
            d.c(d.this, paramInt2);
            if ((d.j(d.this) != null) && (d.k(d.this) != null)) {
              d.a(d.this, d.j(d.this), true);
            }
            AppMethodBeat.o(222015);
          }
        });
        AppMethodBeat.o(221638);
        return;
      }
      this.A = paramInt1;
      this.B = paramInt2;
    }
  }
  
  public void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(221631);
    if (this.d == null)
    {
      AppMethodBeat.o(221631);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222588);
        if ((paramInt2 != 0) && (paramInt3 != 0))
        {
          d.d(d.this).a = paramInt2;
          d.d(d.this).b = paramInt3;
          if (d.e(d.this) != null)
          {
            d.e(d.this).a(com.tencent.liteav.basic.a.c.a);
            d.e(d.this).b(paramInt2, paramInt3);
          }
        }
        if ((paramInt1 != 0) && (d.a(d.this) != null))
        {
          d.d(d.this).c = paramInt1;
          d.a(d.this).c(paramInt1);
        }
        AppMethodBeat.o(222588);
      }
    });
    AppMethodBeat.o(221631);
  }
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(221629);
    if (paramInt1 == 2)
    {
      if ((this.h.width != 0) && (this.h.height != 0) && ((paramInt2 != this.h.width) || (paramInt3 != this.h.height) || (paramInt4 > this.h.fps))) {
        if (this.d != null) {
          this.d.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222382);
              Object localObject;
              if ((paramInt2 != d.c(d.this).width) || (paramInt3 != d.c(d.this).height) || (paramInt4 > d.c(d.this).fps))
              {
                if (paramInt2 <= paramInt3) {
                  break label333;
                }
                d.d(d.this).l = 0;
                localObject = d.d(d.this);
                if (paramInt2 <= paramInt3) {
                  break label358;
                }
                i = paramInt3;
                label102:
                ((g)localObject).a = i;
                localObject = d.d(d.this);
                if (paramInt2 <= paramInt3) {
                  break label366;
                }
              }
              label333:
              label358:
              label366:
              for (int i = paramInt2;; i = paramInt3)
              {
                ((g)localObject).b = i;
                localObject = d.e(d.this);
                if (localObject != null)
                {
                  ((k)localObject).a(com.tencent.liteav.basic.a.c.a);
                  ((k)localObject).b(paramInt2, paramInt3);
                  ((k)localObject).e(d.d(d.this).l);
                }
                d.d(d.this).c = paramInt5;
                d.d(d.this).h = paramInt4;
                d.f(d.this);
                TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.c(d.this).width), Integer.valueOf(d.c(d.this).height), Integer.valueOf(d.c(d.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
                AppMethodBeat.o(222382);
                return;
                if (paramInt2 >= paramInt3) {
                  break;
                }
                d.d(d.this).l = 1;
                break;
                i = paramInt2;
                break label102;
              }
            }
          });
        }
      }
      for (;;)
      {
        d(paramInt7);
        AppMethodBeat.o(221629);
        return;
        localb = this.i;
        if (localb != null)
        {
          localb.b(paramInt5, paramInt6);
          localb.b(paramInt4);
        }
      }
    }
    if ((this.l != null) && ((paramInt2 != this.l.width) || (paramInt3 != this.l.height)) && (this.d != null)) {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221379);
          TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.g(d.this).width), Integer.valueOf(d.g(d.this).height), Integer.valueOf(d.g(d.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
          d.g(d.this).width = paramInt2;
          d.g(d.this).height = paramInt3;
          d.h(d.this);
          AppMethodBeat.o(221379);
        }
      });
    }
    com.tencent.liteav.videoencoder.b localb = this.m;
    if (localb != null)
    {
      localb.b(paramInt5, paramInt6);
      localb.b(paramInt4);
    }
    AppMethodBeat.o(221629);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 2)
    {
      this.I = paramLong1;
      this.H = paramLong2;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(221647);
    this.p.E = paramBitmap;
    this.p.H = paramFloat1;
    this.p.I = paramFloat2;
    this.p.J = paramFloat3;
    A();
    AppMethodBeat.o(221647);
  }
  
  public void a(final Bitmap paramBitmap, final ByteBuffer paramByteBuffer, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(221672);
    paramBitmap = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222388);
        try
        {
          if (((d.m(d.this) == 2) || (d.n(d.this))) && (paramBitmap != null))
          {
            localObject = paramByteBuffer;
            if (localObject != null) {}
          }
          else
          {
            AppMethodBeat.o(222388);
            return;
          }
          if ((d.a(d.this) == null) || (d.o(d.this)) || (d.c(d.this).width != paramInt1) || (d.c(d.this).height != paramInt2) || (d.c(d.this).encodeType != 2) || (d.c(d.this).gop != d.d(d.this).i)) {
            d.a(d.this, paramInt1, paramInt2, 2, null, d.d(d.this).C, true);
          }
          if (((d.b(d.this) == null) || (d.g(d.this).encodeType != 2)) && (d.p(d.this))) {
            d.a(d.this, null, 2, true);
          }
          int i = paramBitmap.getWidth();
          int j = paramBitmap.getHeight();
          Object localObject = d.a(d.this);
          if (localObject != null) {
            ((com.tencent.liteav.videoencoder.b)localObject).a(paramByteBuffer.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
          }
          localObject = d.b(d.this);
          if (localObject != null) {
            ((com.tencent.liteav.videoencoder.b)localObject).a(paramByteBuffer.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
          }
          AppMethodBeat.o(222388);
          return;
        }
        catch (Exception localException)
        {
          TXCLog.e("TXCCaptureAndEnc", "onPushBitmap failed." + localException.getMessage());
          AppMethodBeat.o(222388);
        }
      }
    };
    paramByteBuffer = this.d;
    if (paramByteBuffer != null)
    {
      paramByteBuffer.a(paramBitmap);
      AppMethodBeat.o(221672);
      return;
    }
    paramBitmap.run();
    AppMethodBeat.o(221672);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(221673);
    if (this.e != null) {
      this.e.b();
    }
    AppMethodBeat.o(221673);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(221669);
    if (this.M == null)
    {
      AppMethodBeat.o(221669);
      return;
    }
    a locala = (a)this.M.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(221669);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(221637);
    if (this.x != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      AppMethodBeat.o(221637);
      return;
    }
    synchronized (this.y)
    {
      if (this.z != paramSurface)
      {
        TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
        this.z = paramSurface;
        if (this.C != null)
        {
          this.C.a();
          this.C = null;
        }
        AppMethodBeat.o(221637);
        return;
      }
      TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface the same".concat(String.valueOf(paramSurface)));
    }
  }
  
  public void a(com.tencent.liteav.basic.b.b paramb)
  {
    AppMethodBeat.i(221619);
    this.W = new WeakReference(paramb);
    AppMethodBeat.o(221619);
  }
  
  public void a(final com.tencent.liteav.basic.c.o paramo)
  {
    AppMethodBeat.i(221639);
    if (this.x != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.x.getGLSurfaceView();
      if (localTXCGLSurfaceView != null)
      {
        localTXCGLSurfaceView.a(new com.tencent.liteav.basic.c.o()
        {
          public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(221599);
            if (paramo != null) {
              paramo.onTakePhotoComplete(paramAnonymousBitmap);
            }
            AppMethodBeat.o(221599);
          }
        });
        AppMethodBeat.o(221639);
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
      AppMethodBeat.o(221639);
      return;
    }
    if (this.C != null)
    {
      this.C.a(new com.tencent.liteav.basic.c.o()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(222591);
          if (paramo != null) {
            paramo.onTakePhotoComplete(paramAnonymousBitmap);
          }
          AppMethodBeat.o(222591);
        }
      });
      AppMethodBeat.o(221639);
      return;
    }
    if (paramo != null) {
      paramo.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(221639);
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(221668);
    if (paramInt == 0)
    {
      if (paramTXSNALPacket.streamType == 2)
      {
        this.I = paramTXSNALPacket.gopIndex;
        this.H = paramTXSNALPacket.frameIndex;
      }
      if (this.M == null)
      {
        AppMethodBeat.o(221668);
        return;
      }
      a locala = (a)this.M.get();
      if (locala != null) {
        locala.onEncVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(221668);
      return;
    }
    if (((paramInt == 10000004) || (paramInt == 10000005)) && (this.h.encodeType == 1))
    {
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      t();
      this.r += 1;
      this.p.j = 0;
      a(1103, "Failed to enable hardware encoder, use software encoder");
    }
    AppMethodBeat.o(221668);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    AppMethodBeat.i(221667);
    a(paramb.a, paramb.e, paramb.f, paramLong);
    AppMethodBeat.o(221667);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(221616);
    this.M = new WeakReference(parama);
    AppMethodBeat.o(221616);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(221618);
    int i1;
    int i2;
    if ((paramg != null) && ((this.p.E != paramg.E) || (this.p.F != paramg.F) || (this.p.G != paramg.G) || (this.p.J != paramg.J) || (this.p.H != paramg.H) || (this.p.I != paramg.I)))
    {
      i1 = 1;
      if ((paramg == null) || ((this.p.a == paramg.a) && (this.p.b == paramg.b))) {
        break label280;
      }
      i2 = 1;
      if (paramg == null) {
        break label300;
      }
    }
    for (;;)
    {
      try
      {
        this.p = ((g)paramg.clone());
        TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.p.a), Integer.valueOf(this.p.b), Integer.valueOf(this.p.l) }));
        if (this.d != null) {
          this.d.e(this.p.l);
        }
        if ((i2 == 0) || (this.p.T)) {
          break label314;
        }
        bool = true;
        k(bool);
        if (j())
        {
          B();
          if (i1 != 0) {
            A();
          }
        }
        AppMethodBeat.o(221618);
        return;
        i1 = 0;
        break;
        label280:
        i2 = 0;
      }
      catch (CloneNotSupportedException paramg)
      {
        this.p = new g();
        continue;
      }
      label300:
      this.p = new g();
      continue;
      label314:
      boolean bool = false;
    }
  }
  
  public void a(m paramm)
  {
    AppMethodBeat.i(221620);
    this.X = new WeakReference(paramm);
    AppMethodBeat.o(221620);
  }
  
  public void a(o paramo, int paramInt)
  {
    AppMethodBeat.i(221617);
    this.J = paramInt;
    if (paramo != null)
    {
      this.K = new WeakReference(paramo);
      AppMethodBeat.o(221617);
      return;
    }
    this.K = null;
    AppMethodBeat.o(221617);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(221640);
    if (Build.VERSION.SDK_INT < 21)
    {
      parama = new Bundle();
      parama.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
      onNotifyEvent(-1309, parama);
      TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(221640);
      return;
    }
    this.q = 1;
    if (this.d == null)
    {
      this.d = new i(this.o, this.p, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.V.a(false);
    j(this.E);
    this.d.a(this);
    this.d.a(this);
    this.d.a();
    this.d.a(getID());
    TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.aG);
    AppMethodBeat.o(221640);
  }
  
  public void a(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(221633);
    if (this.p.M)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(221633);
      return;
    }
    if (this.a != null) {
      this.a.b();
    }
    this.w = false;
    boolean bool = this.p.W;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      final TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221383);
          arrayOfTXCGLSurfaceView[0] = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
          paramTXCloudVideoView.addVideoView(arrayOfTXCGLSurfaceView[0]);
          AppMethodBeat.o(221383);
        }
      });
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    for (;;)
    {
      this.q = 0;
      this.d = new c(this.o, this.p, (com.tencent.liteav.basic.c.m)localObject, bool);
      x();
      j(this.E);
      this.d.a(getID());
      this.d.a(this);
      this.d.a(this);
      this.d.a();
      this.d.b(this.u);
      this.d.c(this.v);
      this.d.d(this.Z);
      this.x = paramTXCloudVideoView;
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222351);
          if (paramTXCloudVideoView != null) {
            paramTXCloudVideoView.start(d.d(d.this).K, d.d(d.this).L, d.e(d.this));
          }
          AppMethodBeat.o(222351);
        }
      });
      this.w = false;
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(221633);
      return;
      localObject = new com.tencent.liteav.basic.c.f();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }
  
  public TXBeautyManager b()
  {
    return this.V;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(221623);
    TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(paramInt)));
    this.Z = paramInt;
    if (this.d != null) {
      this.d.d(this.Z);
    }
    if (this.C != null) {
      this.C.b(this.Z);
    }
    AppMethodBeat.o(221623);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221654);
    if (this.d == null)
    {
      AppMethodBeat.o(221654);
      return;
    }
    this.d.a(paramInt1, paramInt2);
    AppMethodBeat.o(221654);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(221645);
    this.V.setBeautyLevel(paramInt1);
    this.V.setWhitenessLevel(paramInt2);
    this.V.setRuddyLevel(paramInt3);
    AppMethodBeat.o(221645);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(221674);
    if (!this.S)
    {
      this.S = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.s == 2)
    {
      AppMethodBeat.o(221674);
      return;
    }
    k localk = this.d;
    if ((this.e != null) && (!this.p.M) && (localk != null))
    {
      if ((this.h.height != paramb.h) || (this.h.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.e.a(localk.f());
      this.e.a(this.p.l);
      this.e.a(paramb, paramb.b, 0, 0L);
    }
    AppMethodBeat.o(221674);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(14405);
    TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(paramBoolean)));
    this.t = paramBoolean;
    if (this.t)
    {
      if (this.d == null)
      {
        w();
        AppMethodBeat.o(14405);
      }
    }
    else {
      x();
    }
    AppMethodBeat.o(14405);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public int c()
  {
    return this.h.width;
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(221630);
    if (this.d == null)
    {
      AppMethodBeat.o(221630);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222389);
        if (d.a(d.this) != null) {
          d.a(d.this).d(paramInt);
        }
        d.a(d.this, paramInt);
        AppMethodBeat.o(222389);
      }
    });
    AppMethodBeat.o(221630);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(221634);
    j(paramBoolean);
    AppMethodBeat.o(221634);
  }
  
  public int d()
  {
    return this.h.height;
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(221632);
    if (this.d == null)
    {
      AppMethodBeat.o(221632);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(221429);
        if (d.a(d.this) != null) {
          d.a(d.this).e(paramInt);
        }
        AppMethodBeat.o(221429);
      }
    });
    AppMethodBeat.o(221632);
  }
  
  public void d(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(221624);
    if (j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.s);
      AppMethodBeat.o(221624);
      return -2;
    }
    TXCDRApi.initCrashReport(this.o);
    this.s = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    B();
    TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.bu);
    AppMethodBeat.o(221624);
    return 0;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(221636);
    if (this.p.h == paramInt)
    {
      AppMethodBeat.o(221636);
      return;
    }
    this.p.h = paramInt;
    if ((this.d != null) && (this.d.g() < paramInt)) {
      switch (this.q)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(221636);
      return;
      k(true);
      t();
      AppMethodBeat.o(221636);
      return;
      this.d.f(paramInt);
    }
  }
  
  public boolean e(boolean paramBoolean)
  {
    AppMethodBeat.i(221644);
    if (this.d == null)
    {
      AppMethodBeat.o(221644);
      return false;
    }
    paramBoolean = this.d.d(paramBoolean);
    AppMethodBeat.o(221644);
    return paramBoolean;
  }
  
  public void f()
  {
    AppMethodBeat.i(14393);
    if (!j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.s);
      AppMethodBeat.o(14393);
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.s = 0;
    t();
    this.p.P = false;
    if (this.a != null) {
      this.a.b();
    }
    b(false);
    this.D = null;
    AppMethodBeat.o(14393);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(221642);
    TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(paramInt)));
    this.v = paramInt;
    if (this.d != null) {
      this.d.c(paramInt);
    }
    if (this.C != null) {
      this.C.a(this.v);
    }
    AppMethodBeat.o(221642);
  }
  
  public boolean f(boolean paramBoolean)
  {
    AppMethodBeat.i(221655);
    this.p.S = paramBoolean;
    if (this.d == null)
    {
      AppMethodBeat.o(221655);
      return false;
    }
    this.d.c(paramBoolean);
    AppMethodBeat.o(221655);
    return true;
  }
  
  public void g()
  {
    AppMethodBeat.i(221625);
    if (this.s != 1)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.s);
      AppMethodBeat.o(221625);
      return;
    }
    this.s = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.p.D & 0x1) == 1)
    {
      t();
      if ((this.a != null) && (!this.p.M)) {
        this.a.a(this.p.C, this.p.B, this.p.A, this.h.width, this.h.height);
      }
      if (this.d != null) {
        this.d.c();
      }
    }
    AppMethodBeat.o(221625);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(221643);
    if (this.u != paramInt) {
      TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    }
    this.u = paramInt;
    if (this.d == null)
    {
      AppMethodBeat.o(221643);
      return;
    }
    this.d.b(paramInt);
    AppMethodBeat.o(221643);
  }
  
  public void g(boolean paramBoolean)
  {
    AppMethodBeat.i(221658);
    if (this.F == paramBoolean)
    {
      AppMethodBeat.o(221658);
      return;
    }
    this.F = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.F);
    if (this.F) {
      this.p.j = 0;
    }
    t();
    AppMethodBeat.o(221658);
  }
  
  public void h()
  {
    AppMethodBeat.i(221626);
    if (this.s != 2)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.s);
      AppMethodBeat.o(221626);
      return;
    }
    this.s = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.p.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.p.M)) {
        this.a.b();
      }
      t();
      if (this.d != null) {
        this.d.b();
      }
      A();
    }
    AppMethodBeat.o(221626);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(221646);
    this.V.setBeautyStyle(paramInt);
    AppMethodBeat.o(221646);
  }
  
  public void h(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void i(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  public boolean i()
  {
    return this.t;
  }
  
  public boolean i(int paramInt)
  {
    AppMethodBeat.i(221653);
    if (this.d == null)
    {
      AppMethodBeat.o(221653);
      return false;
    }
    boolean bool = this.d.a(paramInt);
    AppMethodBeat.o(221653);
    return bool;
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(221657);
    this.E = paramInt;
    if (this.d != null) {
      this.d.g(this.E);
    }
    AppMethodBeat.o(221657);
  }
  
  public boolean j()
  {
    return this.s != 0;
  }
  
  public void k()
  {
    AppMethodBeat.i(14396);
    if (this.d == null)
    {
      AppMethodBeat.o(14396);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222383);
        if (d.e(d.this) != null) {
          d.e(d.this).b(true);
        }
        d.a(d.this, d.c(d.this).width, d.c(d.this).height);
        d.this.a(d.i(d.this));
        AppMethodBeat.o(222383);
      }
    });
    AppMethodBeat.o(14396);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(221659);
    com.tencent.liteav.videoencoder.b localb = null;
    if (paramInt == 2) {
      localb = this.i;
    }
    for (;;)
    {
      if (localb != null) {
        localb.b();
      }
      AppMethodBeat.o(221659);
      return;
      if (paramInt == 3) {
        localb = this.m;
      }
    }
  }
  
  public void l()
  {
    AppMethodBeat.i(14397);
    if (this.d == null)
    {
      AppMethodBeat.o(14397);
      return;
    }
    this.V.a(true);
    j(true);
    AppMethodBeat.o(14397);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(221670);
    if (this.h.width * this.h.height < 518400) {}
    for (this.p.j = 0; paramInt == 3; this.p.j = 0)
    {
      label35:
      v();
      AppMethodBeat.o(221670);
      return;
      if ((this.h.width * this.h.height >= 921600) || (!this.f)) {
        break label35;
      }
    }
    this.f = true;
    u();
    AppMethodBeat.o(221670);
  }
  
  public void m(int paramInt) {}
  
  public boolean m()
  {
    AppMethodBeat.i(221648);
    if (this.d != null)
    {
      boolean bool = this.d.h();
      AppMethodBeat.o(221648);
      return bool;
    }
    AppMethodBeat.o(221648);
    return false;
  }
  
  public void n(final int paramInt)
  {
    int i1 = 2;
    AppMethodBeat.i(221694);
    if (paramInt <= 0) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt > 2) {
        paramInt = i1;
      }
      for (;;)
      {
        Runnable local17 = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(222016);
            if (d.c(d.this).encoderMode == paramInt)
            {
              AppMethodBeat.o(222016);
              return;
            }
            d.c(d.this).encoderMode = paramInt;
            d.g(d.this).encoderMode = paramInt;
            d.f(d.this);
            d.h(d.this);
            AppMethodBeat.o(222016);
          }
        };
        if (this.d == null)
        {
          local17.run();
          AppMethodBeat.o(221694);
          return;
        }
        this.d.a(local17);
        AppMethodBeat.o(221694);
        return;
      }
    }
  }
  
  public boolean n()
  {
    AppMethodBeat.i(221649);
    if (this.d != null)
    {
      boolean bool = this.d.i();
      AppMethodBeat.o(221649);
      return bool;
    }
    AppMethodBeat.o(221649);
    return false;
  }
  
  public boolean o()
  {
    AppMethodBeat.i(221650);
    if (this.d != null)
    {
      boolean bool = this.d.j();
      AppMethodBeat.o(221650);
      return bool;
    }
    AppMethodBeat.o(221650);
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(221671);
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    com.tencent.liteav.basic.util.f.a(this.W, paramInt, paramBundle);
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.E);
    }
    while ((paramInt == -1302) || (paramInt == -1317) || (paramInt == -1318) || (paramInt == -1319))
    {
      TXCKeyPointReportProxy.b(30002, paramInt);
      AppMethodBeat.o(221671);
      return;
      if (paramInt == -1314) {
        TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.E);
      } else if (paramInt == 1003)
      {
        if (this.d != null)
        {
          paramBundle = getID();
          if (this.d.l()) {}
          for (l1 = 0L;; l1 = 1L)
          {
            TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.E);
            break;
          }
        }
      }
      else if (paramInt == -1308) {
        l();
      }
    }
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.d != null)
      {
        paramBundle = getID();
        if (!this.d.l()) {
          break label293;
        }
      }
    }
    label293:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.E);
      AppMethodBeat.o(221671);
      return;
    }
  }
  
  public boolean p()
  {
    AppMethodBeat.i(221651);
    if (this.d != null)
    {
      boolean bool = this.d.k();
      AppMethodBeat.o(221651);
      return bool;
    }
    AppMethodBeat.o(221651);
    return false;
  }
  
  public int q()
  {
    AppMethodBeat.i(221652);
    if (this.d == null)
    {
      AppMethodBeat.o(221652);
      return 0;
    }
    int i1 = this.d.e();
    AppMethodBeat.o(221652);
    return i1;
  }
  
  public void r()
  {
    AppMethodBeat.i(14404);
    try
    {
      if (this.e != null) {
        this.e.b();
      }
      if (this.N != null)
      {
        this.N.d();
        this.N = null;
      }
      if (this.P != null)
      {
        this.P.d();
        this.P = null;
      }
      if (this.O != null)
      {
        this.O.d();
        this.O = null;
      }
      z();
      y();
      AppMethodBeat.o(14404);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", localException);
      AppMethodBeat.o(14404);
    }
  }
  
  public void s()
  {
    AppMethodBeat.i(14406);
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    if (this.e != null) {
      this.e.b();
    }
    if (this.N != null)
    {
      this.N.d();
      this.N = null;
    }
    if (this.P != null)
    {
      this.P.d();
      this.P = null;
    }
    if (this.O != null)
    {
      this.O.d();
      this.O = null;
    }
    if (this.Q != null)
    {
      this.Q.d();
      this.Q = null;
    }
    z();
    y();
    if (this.X != null)
    {
      m localm = (m)this.X.get();
      if (localm != null) {
        localm.a();
      }
    }
    AppMethodBeat.o(14406);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(221621);
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
    TXCLog.w("TXCCaptureAndEnc", "setID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(221621);
  }
  
  public void t()
  {
    AppMethodBeat.i(14407);
    Runnable local10 = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222381);
        d.f(d.this);
        d.h(d.this);
        AppMethodBeat.o(222381);
      }
    };
    ??? = this.d;
    if (??? != null)
    {
      ((k)???).a(local10);
      AppMethodBeat.o(14407);
      return;
    }
    synchronized (this.n)
    {
      local10.run();
      AppMethodBeat.o(14407);
      return;
    }
  }
  
  public void u()
  {
    AppMethodBeat.i(221680);
    if (this.i == null)
    {
      AppMethodBeat.o(221680);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222651);
          d.f(d.this);
          AppMethodBeat.o(222651);
        }
      });
      AppMethodBeat.o(221680);
      return;
    }
    z();
    AppMethodBeat.o(221680);
  }
  
  public void v()
  {
    AppMethodBeat.i(221681);
    if (this.m == null)
    {
      AppMethodBeat.o(221681);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(222650);
          d.h(d.this);
          AppMethodBeat.o(222650);
        }
      });
      AppMethodBeat.o(221681);
      return;
    }
    y();
    AppMethodBeat.o(221681);
  }
  
  public static abstract interface a
  {
    public abstract void onBackgroudPushStop();
    
    public abstract void onEncVideo(TXSNALPacket paramTXSNALPacket);
    
    public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */