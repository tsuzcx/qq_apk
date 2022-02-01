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
import com.tencent.liteav.basic.d.h.a;
import com.tencent.liteav.basic.d.m;
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

public class c
  extends com.tencent.liteav.basic.module.a
  implements a.b, com.tencent.liteav.basic.c.a, com.tencent.liteav.beauty.f, k, com.tencent.liteav.videoencoder.d
{
  private com.tencent.liteav.basic.d.e A;
  private com.tencent.liteav.basic.structs.b B;
  private int C;
  private boolean D;
  private boolean E;
  private long F;
  private long G;
  private int H;
  private WeakReference<n> I;
  private boolean J;
  private WeakReference<a> K;
  private com.tencent.liteav.basic.d.h L;
  private com.tencent.liteav.basic.d.h M;
  private com.tencent.liteav.basic.d.h N;
  private com.tencent.liteav.beauty.b.k O;
  private byte[] P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private final com.tencent.liteav.beauty.b T;
  private WeakReference<com.tencent.liteav.basic.c.a> U;
  private WeakReference<l> V;
  private int W;
  private int X;
  a a;
  a b;
  private final com.tencent.liteav.basic.util.e c;
  private j d;
  private com.tencent.liteav.beauty.d e;
  private boolean f;
  private boolean g;
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
  private boolean r;
  private int s;
  private int t;
  private boolean u;
  private TXCloudVideoView v;
  private final Object w;
  private Surface x;
  private int y;
  private int z;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(16100);
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
    this.n = null;
    this.o = null;
    this.p = 0;
    this.q = 0;
    this.r = false;
    this.s = 0;
    this.t = 0;
    this.u = false;
    this.v = null;
    this.w = new Object();
    this.x = null;
    this.y = 0;
    this.z = 0;
    this.A = null;
    this.C = 0;
    this.D = false;
    this.E = false;
    this.F = 0L;
    this.G = 0L;
    this.H = 2;
    this.J = false;
    this.K = null;
    this.L = null;
    this.Q = false;
    this.R = false;
    this.S = false;
    this.W = 0;
    this.X = 0;
    this.n = paramContext.getApplicationContext();
    this.o = new f();
    this.e = new com.tencent.liteav.beauty.d(this.n, true);
    this.e.a(this);
    this.e.a(this);
    if (this.o.U) {
      this.e.a(d.d.a);
    }
    for (;;)
    {
      this.h = new TXSVideoEncoderParam();
      this.i = null;
      this.l = new TXSVideoEncoderParam();
      this.a = new a(this);
      this.T = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.b.h(paramContext));
      this.T.setPreprocessor(this.e);
      com.tencent.liteav.basic.e.b.a().a(this.n);
      AppMethodBeat.o(16100);
      return;
      if (this.o.T) {
        this.e.a(d.d.b);
      } else {
        this.e.a(d.d.c);
      }
    }
  }
  
  private void A()
  {
    AppMethodBeat.i(16186);
    if (this.d != null) {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15528);
          c.a(c.this, c.c(c.this).width, c.c(c.this).height);
          AppMethodBeat.o(15528);
        }
      });
    }
    AppMethodBeat.o(16186);
  }
  
  private void B()
  {
    AppMethodBeat.i(16188);
    if (this.e != null)
    {
      if (this.o.U)
      {
        this.e.a(d.d.a);
        AppMethodBeat.o(16188);
        return;
      }
      if (this.o.T)
      {
        this.e.a(d.d.b);
        AppMethodBeat.o(16188);
        return;
      }
      this.e.a(d.d.c);
    }
    AppMethodBeat.o(16188);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(16180);
    paramInt2 = this.o.a;
    paramInt1 = this.o.b;
    if ((this.o.l == 0) || (this.o.l == 2))
    {
      paramInt2 = this.o.b;
      paramInt1 = this.o.a;
    }
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
      AppMethodBeat.o(16180);
      return -1;
    }
    if (this.o.M)
    {
      z();
      AppMethodBeat.o(16180);
      return -1000;
    }
    b(paramInt2, paramInt1, paramObject);
    AppMethodBeat.o(16180);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(16179);
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
      AppMethodBeat.o(16179);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(16177);
    TXCLog.i("TXCCaptureAndEnc", "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3);
    z();
    this.i = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.C, Integer.valueOf(paramInt3));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt3 == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.C);
      this.R = false;
      this.h.encodeType = paramInt3;
      this.h.width = paramInt1;
      this.h.height = paramInt2;
      this.h.fps = this.o.h;
      this.h.gop = this.o.i;
      this.h.encoderProfile = this.o.n;
      this.h.encoderMode = 1;
      localTXSVideoEncoderParam = this.h;
      if (paramObject == null) {
        break label525;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.h.realTime = this.o.P;
      this.h.streamType = this.C;
      this.h.annexb = this.E;
      this.h.bMultiRef = this.D;
      this.h.baseFrameIndex = (this.F + 20L);
      this.h.baseGopIndex = (this.G + 2L);
      this.h.bLimitFps = this.g;
      this.h.record = this.S;
      this.h.encFmt = this.o.Y;
      this.i.a(this);
      this.i.a(this);
      this.i.a(this.h);
      this.i.c(this.o.c);
      this.i.d(this.j);
      this.i.setID(getID());
      this.i.a(this.W);
      TXCStatus.a(getID(), 4003, this.C, Integer.valueOf(this.h.width << 16 | this.h.height));
      TXCStatus.a(getID(), 13003, this.C, Integer.valueOf(this.h.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.h.width, this.h.height, "", this.C);
      AppMethodBeat.o(16177);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.C);
      break;
      label525:
      paramObject = this.i.a(paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    int i1 = 2002;
    AppMethodBeat.i(16158);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.f.a(this.U, paramInt, localBundle);
    if (paramInt == -1317)
    {
      paramString = getID();
      l1 = 4L;
    }
    for (;;)
    {
      TXCEventRecorderProxy.a(paramString, i1, l1, -1L, "", this.C);
      do
      {
        if ((paramInt != -1302) && (paramInt != -1317) && (paramInt != -1318) && (paramInt != -1319)) {
          break label217;
        }
        TXCKeyPointReportProxy.b(30002, paramInt);
        AppMethodBeat.o(16158);
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
      TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.C);
      AppMethodBeat.o(16158);
      return;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(16164);
    paramb.e = paramInt1;
    paramb.f = paramInt2;
    paramb.i = this.o.S;
    if (this.o.l == 0) {
      paramb.g = this.o.b;
    }
    for (paramb.h = this.o.a;; paramb.h = this.o.b)
    {
      paramb.l = com.tencent.liteav.basic.util.f.a(paramb.e, paramb.f, paramb.g, paramb.h);
      try
      {
        this.e.a(this.o.l);
        this.e.a(paramObject);
        this.e.a(paramb, paramb.b, 0, paramLong);
        AppMethodBeat.o(16164);
        return;
      }
      catch (Exception paramb)
      {
        AppMethodBeat.o(16164);
      }
      paramb.g = this.o.a;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(16193);
    e(paramb.e, paramb.f);
    this.B = paramb;
    if (this.v != null)
    {
      if (this.d != null)
      {
        this.d.a(paramb);
        AppMethodBeat.o(16193);
      }
    }
    else {
      synchronized (this.w)
      {
        if ((this.x != null) && (this.A == null) && (this.d != null) && (this.d.f() != null))
        {
          this.A = new com.tencent.liteav.basic.d.e();
          this.A.a(this.d.f(), this.x);
          this.A.a(this.t);
          this.A.b(this.X);
        }
        if ((this.A != null) && (this.d != null)) {
          this.A.a(paramb.a, paramb.i, this.s, this.y, this.z, paramb.e, paramb.f, paramBoolean, this.d.l());
        }
        AppMethodBeat.o(16193);
        return;
      }
    }
    AppMethodBeat.o(16193);
  }
  
  private void a(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(16178);
    y();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
      localTXSVideoEncoderParam = this.l;
      if (paramObject == null) {
        break label229;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.l.encodeType = paramInt;
      TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
      localb.a(this);
      localb.a(this);
      localb.a(this.l);
      localb.c(this.l.bitrate);
      localb.setID(getID());
      localb.a(this.W);
      this.m = localb;
      TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.l.width << 16 | this.l.height));
      TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.l.gop * 1000));
      AppMethodBeat.o(16178);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
      break;
      label229:
      paramObject = localb.a(this.l.width, this.l.height);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(221338);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.c.a(paramRunnable);
      AppMethodBeat.o(221338);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(221338);
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i3 = 2;
    int i2 = 1;
    AppMethodBeat.i(16181);
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
      if ((this.i == null) || (this.R) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.h.encodeType != i1) || (this.h.gop != i2)) {
        a(paramInt1, paramInt2, i1, paramObject);
      }
      if (((this.m == null) || (this.l.encodeType != i1)) && (this.k)) {
        a(paramObject, i1);
      }
      AppMethodBeat.o(16181);
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16194);
    if (this.J)
    {
      i1 = paramb.a;
      AppMethodBeat.o(16194);
      return i1;
    }
    int i1 = paramb.a;
    int i7;
    com.tencent.liteav.basic.d.h localh;
    if (this.X == 1)
    {
      i7 = 1;
      if (i7 == paramb.i) {
        break label398;
      }
      if (this.M == null)
      {
        localh = new com.tencent.liteav.basic.d.h();
        localh.a();
        localh.a(true);
        localh.a(paramb.e, paramb.f);
        if (paramb.e <= paramb.f) {
          break label373;
        }
        localh.h();
        label108:
        this.M = localh;
      }
      localh = this.M;
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
      if (this.s != 0)
      {
        if (this.N == null)
        {
          localh = new com.tencent.liteav.basic.d.h();
          localh.a();
          localh.a(true);
          localh.a(paramb.e, paramb.f);
          this.N = localh;
        }
        localh = this.N;
        i2 = i1;
        if (localh != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          i4 = paramb.e;
          i5 = paramb.f;
          arrayOfFloat = localh.a(i4, i5, null, com.tencent.liteav.basic.util.f.a(i4, i5, paramb.e, paramb.f), 0);
          i6 = (720 - this.s) % 360;
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
        AppMethodBeat.o(16194);
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
    AppMethodBeat.i(16189);
    com.tencent.liteav.beauty.d locald;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.o.J != -1.0F) {
      if (this.e != null)
      {
        locald = this.e;
        localBitmap = this.o.E;
        f3 = this.o.H;
        f2 = this.o.I;
        f1 = this.o.J;
      }
    }
    for (;;)
    {
      locald.a(localBitmap, f3, f2, f1);
      do
      {
        AppMethodBeat.o(16189);
        return;
      } while ((this.e == null) || (paramInt1 == 0) || (paramInt2 == 0));
      locald = this.e;
      localBitmap = this.o.E;
      f3 = this.o.F / paramInt1;
      f2 = this.o.G / paramInt2;
      if (this.o.E == null) {
        f1 = 0.0F;
      } else {
        f1 = this.o.E.getWidth() / paramInt1;
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16191);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(16191);
  }
  
  private void d(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16195);
    Object localObject2 = this.I;
    if (localObject2 == null)
    {
      AppMethodBeat.o(16195);
      return;
    }
    int i1 = c(paramb);
    Object localObject1;
    if (this.H == 2)
    {
      localObject1 = (n)((WeakReference)localObject2).get();
      if (localObject1 != null)
      {
        localObject2 = new TXSVideoFrame();
        ((TXSVideoFrame)localObject2).width = paramb.e;
        ((TXSVideoFrame)localObject2).height = paramb.f;
        ((TXSVideoFrame)localObject2).textureId = i1;
        ((TXSVideoFrame)localObject2).eglContext = this.e.a();
        ((TXSVideoFrame)localObject2).pts = TXCTimeUtil.generatePtsMS();
        ((n)localObject1).onRenderVideoFrame(getID(), this.C, (TXSVideoFrame)localObject2);
        if (this.J) {
          paramb.a = ((TXSVideoFrame)localObject2).textureId;
        }
      }
    }
    label214:
    do
    {
      do
      {
        if ((this.J) && (this.v != null))
        {
          paramb = this.v.getGLSurfaceView();
          if (paramb != null) {
            paramb.d();
          }
        }
        AppMethodBeat.o(16195);
        return;
      } while ((this.H != 1) && (this.H != 4));
      if (this.L == null)
      {
        if (this.H != 1) {
          break;
        }
        localObject1 = new com.tencent.liteav.beauty.b.o(1);
        ((com.tencent.liteav.basic.d.h)localObject1).a(true);
        if (!((com.tencent.liteav.basic.d.h)localObject1).a()) {
          break label445;
        }
        ((com.tencent.liteav.basic.d.h)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.basic.d.h)localObject1).a(new h.a()
        {
          public void a(int paramAnonymousInt)
          {
            AppMethodBeat.i(221348);
            com.tencent.liteav.basic.d.h localh = c.m(c.this);
            n localn = (n)this.a.get();
            if ((localh != null) && (localn != null))
            {
              TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
              localTXSVideoFrame.width = localh.n();
              localTXSVideoFrame.height = localh.o();
              localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
              localn.onRenderVideoFrame(c.this.getID(), c.n(c.this), localTXSVideoFrame);
              c.a(c.this, localTXSVideoFrame.data);
            }
            AppMethodBeat.o(221348);
          }
        });
        this.L = ((com.tencent.liteav.basic.d.h)localObject1);
      }
      localObject1 = this.L;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.basic.d.h)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.basic.d.h)localObject1).b(i1);
      }
    } while ((!this.J) || (this.P == null));
    label257:
    if (this.H == 1) {
      i1 = 1;
    }
    for (;;)
    {
      if (this.O == null)
      {
        localObject1 = new com.tencent.liteav.beauty.b.k(i1);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
        if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
          TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
        }
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        this.O = ((com.tencent.liteav.beauty.b.k)localObject1);
      }
      localObject1 = this.O;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(this.P);
        paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).q();
      }
      this.P = null;
      break;
      localObject1 = new com.tencent.liteav.beauty.b.o(3);
      break label214;
      label445:
      TXCLog.i("TXCCaptureAndEnc", "init filter error ");
      this.L = null;
      break label257;
      if (this.H == 4) {
        i1 = 3;
      } else {
        i1 = 1;
      }
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16192);
    if (!this.u)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", getID());
      localBundle.putInt("EVT_ID", 2003);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putCharSequence("EVT_MSG", "渲染首帧视频");
      localBundle.putInt("EVT_PARAM1", paramInt1);
      localBundle.putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.f.a(this.U, 2003, localBundle);
      TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.C);
      this.u = true;
    }
    AppMethodBeat.o(16192);
  }
  
  private void j(final boolean paramBoolean)
  {
    AppMethodBeat.i(16187);
    if (this.d == null)
    {
      AppMethodBeat.o(16187);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15535);
        if (c.k(c.this) != null) {
          c.k(c.this).b();
        }
        AppMethodBeat.o(15535);
      }
    });
    t();
    this.d.a(paramBoolean);
    this.d = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.v;
    this.c.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15527);
        if (this.a != null) {
          this.a.stop(paramBoolean);
        }
        AppMethodBeat.o(15527);
      }
    });
    this.v = null;
    synchronized (this.w)
    {
      this.x = null;
      if (this.A != null)
      {
        this.A.a();
        this.A = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.r) {
        w();
      }
      AppMethodBeat.o(16187);
      return;
    }
  }
  
  private void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(182269);
    if (this.d != null) {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15533);
          if (c.e(c.this) != null)
          {
            c.e(c.this).f(c.d(c.this).h);
            c.e(c.this).e(c.d(c.this).l);
            c.e(c.this).a(c.d(c.this).k);
            c.e(c.this).b(c.d(c.this).a, c.d(c.this).b);
            c.e(c.this).e(c.d(c.this).U);
            if ((paramBoolean) && (c.e(c.this).d())) {
              c.e(c.this).b(false);
            }
          }
          AppMethodBeat.o(15533);
        }
      });
    }
    AppMethodBeat.o(182269);
  }
  
  private void w()
  {
    AppMethodBeat.i(16184);
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new a(this);
    }
    this.b.a(10, -1, null, 64, 64);
    AppMethodBeat.o(16184);
  }
  
  private void x()
  {
    AppMethodBeat.i(16114);
    TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.r);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(16114);
  }
  
  private void y()
  {
    AppMethodBeat.i(16115);
    try
    {
      if (this.m != null)
      {
        this.m.a();
        this.m.a(null);
        this.m = null;
      }
      AppMethodBeat.o(16115);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16115);
    }
  }
  
  private void z()
  {
    AppMethodBeat.i(16185);
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      if (this.i != null)
      {
        this.i.a();
        this.i.a(null);
        this.i = null;
      }
      this.R = true;
      AppMethodBeat.o(16185);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16185);
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(16162);
    int i1 = a(paramInt2, paramInt3, paramObject);
    if (i1 != 0)
    {
      AppMethodBeat.o(16162);
      return i1;
    }
    paramObject = this.i;
    if (paramObject != null)
    {
      if (paramLong != 0L) {
        break label72;
      }
      paramLong = TXCTimeUtil.generatePtsMS();
    }
    label72:
    for (;;)
    {
      paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
      AppMethodBeat.o(16162);
      return 0;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(16163);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.a = paramInt1;
    localb.b = 0;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(16163);
    return 0;
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16165);
    if (this.V != null)
    {
      l locall = (l)this.V.get();
      if (locall != null) {
        paramb.a = locall.a(paramb.a, paramb.e, paramb.f);
      }
    }
    d(paramb);
    a(paramb, false);
    int i1 = paramb.a;
    AppMethodBeat.o(16165);
    return i1;
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(221331);
    int i1;
    if ((this.l.width != paramInt1) || (this.l.height != paramInt2))
    {
      i1 = 1;
      this.l.width = paramInt1;
      this.l.height = paramInt2;
      this.l.fps = paramInt3;
      this.l.gop = paramInt5;
      this.l.encoderProfile = 1;
      this.l.encoderMode = 1;
      this.l.realTime = this.o.P;
      this.l.streamType = 3;
      this.l.bitrate = paramInt4;
      this.l.annexb = true;
      this.l.bMultiRef = false;
      if ((this.m != null) && ((i1 != 0) || ((this.k) && (!paramBoolean))))
      {
        if (this.d == null) {
          break label194;
        }
        this.d.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(182289);
            c.h(c.this);
            AppMethodBeat.o(182289);
          }
        });
      }
    }
    for (;;)
    {
      this.k = paramBoolean;
      AppMethodBeat.o(221331);
      return 0;
      i1 = 0;
      break;
      label194:
      y();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(16159);
    int i1 = a(paramInt2, paramInt3, null);
    if (i1 != 0)
    {
      AppMethodBeat.o(16159);
      return i1;
    }
    com.tencent.liteav.videoencoder.b localb = this.i;
    if (localb != null)
    {
      if (paramLong != 0L) {
        break label74;
      }
      paramLong = TXCTimeUtil.generatePtsMS();
    }
    label74:
    for (;;)
    {
      localb.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramLong);
      AppMethodBeat.o(16159);
      return 0;
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(16160);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.m = paramArrayOfByte;
    localb.b = paramInt1;
    localb.d = true;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(16160);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(16173);
    if (this.K == null)
    {
      AppMethodBeat.o(16173);
      return;
    }
    a locala = (a)this.K.get();
    if (locala == null)
    {
      AppMethodBeat.o(16173);
      return;
    }
    locala.onBackgroudPushStop();
    AppMethodBeat.o(16173);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(16142);
    if (this.d == null)
    {
      AppMethodBeat.o(16142);
      return;
    }
    this.d.a(paramFloat);
    AppMethodBeat.o(16142);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(16196);
    if ((this.d != null) && (this.o.K)) {
      this.d.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(16196);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16169);
    if (this.h.width * this.h.height < 518400) {}
    for (this.o.j = 0; paramInt == 3; this.o.j = 0)
    {
      label35:
      v();
      AppMethodBeat.o(16169);
      return;
      if ((this.h.width * this.h.height >= 921600) || (!this.f)) {
        break label35;
      }
    }
    this.f = true;
    u();
    AppMethodBeat.o(16169);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(16126);
    synchronized (this.w)
    {
      if (this.A != null)
      {
        this.A.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(221347);
            c.b(c.this, paramInt1);
            c.c(c.this, paramInt2);
            if ((c.i(c.this) != null) && (c.j(c.this) != null)) {
              c.a(c.this, c.i(c.this), true);
            }
            AppMethodBeat.o(221347);
          }
        });
        AppMethodBeat.o(16126);
        return;
      }
      this.y = paramInt1;
      this.z = paramInt2;
    }
  }
  
  public void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(16118);
    if (this.d == null)
    {
      AppMethodBeat.o(16118);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182419);
        if ((paramInt2 != 0) && (paramInt3 != 0))
        {
          c.d(c.this).a = paramInt2;
          c.d(c.this).b = paramInt3;
          if (c.e(c.this) != null)
          {
            c.e(c.this).a(com.tencent.liteav.basic.a.c.a);
            c.e(c.this).b(paramInt2, paramInt3);
          }
        }
        if ((paramInt1 != 0) && (c.a(c.this) != null))
        {
          c.d(c.this).c = paramInt1;
          c.a(c.this).c(paramInt1);
        }
        AppMethodBeat.o(182419);
      }
    });
    AppMethodBeat.o(16118);
  }
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(16116);
    if (paramInt1 == 2)
    {
      if ((this.h.width != 0) && (this.h.height != 0) && ((paramInt2 != this.h.width) || (paramInt3 != this.h.height) || (paramInt4 > this.h.fps))) {
        if (this.d != null) {
          this.d.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(16611);
              Object localObject;
              if ((paramInt2 != c.c(c.this).width) || (paramInt3 != c.c(c.this).height) || (paramInt4 > c.c(c.this).fps))
              {
                if (paramInt2 <= paramInt3) {
                  break label335;
                }
                c.d(c.this).l = 0;
                localObject = c.d(c.this);
                if (paramInt2 <= paramInt3) {
                  break label360;
                }
                i = paramInt3;
                label103:
                ((f)localObject).a = i;
                localObject = c.d(c.this);
                if (paramInt2 <= paramInt3) {
                  break label368;
                }
              }
              label335:
              label360:
              label368:
              for (int i = paramInt2;; i = paramInt3)
              {
                ((f)localObject).b = i;
                localObject = c.e(c.this);
                if (localObject != null)
                {
                  ((j)localObject).a(com.tencent.liteav.basic.a.c.a);
                  ((j)localObject).b(paramInt2, paramInt3);
                  ((j)localObject).e(c.d(c.this).l);
                }
                c.d(c.this).c = paramInt5;
                c.d(c.this).h = paramInt4;
                c.f(c.this);
                TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(c.c(c.this).width), Integer.valueOf(c.c(c.this).height), Integer.valueOf(c.c(c.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
                AppMethodBeat.o(16611);
                return;
                if (paramInt2 >= paramInt3) {
                  break;
                }
                c.d(c.this).l = 1;
                break;
                i = paramInt2;
                break label103;
              }
            }
          });
        }
      }
      for (;;)
      {
        e(paramInt7);
        AppMethodBeat.o(16116);
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
          AppMethodBeat.i(16689);
          TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(c.g(c.this).width), Integer.valueOf(c.g(c.this).height), Integer.valueOf(c.g(c.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
          c.g(c.this).width = paramInt2;
          c.g(c.this).height = paramInt3;
          c.h(c.this);
          AppMethodBeat.o(16689);
        }
      });
    }
    com.tencent.liteav.videoencoder.b localb = this.m;
    if (localb != null)
    {
      localb.b(paramInt5, paramInt6);
      localb.b(paramInt4);
    }
    AppMethodBeat.o(16116);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.G = paramLong2;
    this.F = paramLong3;
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(16136);
    this.o.E = paramBitmap;
    this.o.H = paramFloat1;
    this.o.I = paramFloat2;
    this.o.J = paramFloat3;
    A();
    AppMethodBeat.o(16136);
  }
  
  public void a(final Bitmap paramBitmap, final ByteBuffer paramByteBuffer, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(16171);
    j localj = this.d;
    if (localj != null)
    {
      localj.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15555);
          try
          {
            int i = c.l(c.this);
            if (i != 2)
            {
              AppMethodBeat.o(15555);
              return;
            }
            i = paramBitmap.getWidth();
            int j = paramBitmap.getHeight();
            com.tencent.liteav.basic.d.a locala = com.tencent.liteav.basic.util.f.a(i, j, paramInt1, paramInt2);
            c.k(c.this).a(locala);
            c.k(c.this).b(false);
            if (c.d(c.this).W) {
              c.k(c.this).a(false);
            }
            c.k(c.this).a(paramInt1, paramInt2);
            c.k(c.this).a(paramByteBuffer.array(), i, j, 0, 2, 0);
            AppMethodBeat.o(15555);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(15555);
          }
        }
      });
      AppMethodBeat.o(16171);
      return;
    }
    if ((this.i == null) || (this.R) || (this.h.width != paramInt1) || (this.h.height != paramInt2) || (this.h.encodeType != 2) || (this.h.gop != this.o.i)) {
      a(paramInt1, paramInt2, 2, null);
    }
    paramBitmap = this.i;
    if (paramBitmap != null) {
      paramBitmap.a(paramByteBuffer.array(), 2, paramInt1, paramInt2, TXCTimeUtil.generatePtsMS());
    }
    AppMethodBeat.o(16171);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16174);
    if (this.e != null) {
      this.e.b();
    }
    AppMethodBeat.o(16174);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(16168);
    if (this.K == null)
    {
      AppMethodBeat.o(16168);
      return;
    }
    a locala = (a)this.K.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(16168);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(16125);
    if (this.v != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      AppMethodBeat.o(16125);
      return;
    }
    synchronized (this.w)
    {
      if (this.x != paramSurface)
      {
        TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
        this.x = paramSurface;
        if (this.A != null)
        {
          this.A.a();
          this.A = null;
        }
        AppMethodBeat.o(16125);
        return;
      }
      TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface the same".concat(String.valueOf(paramSurface)));
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(16104);
    this.U = new WeakReference(parama);
    AppMethodBeat.o(16104);
  }
  
  public void a(final com.tencent.liteav.basic.d.o paramo)
  {
    AppMethodBeat.i(221332);
    if (this.v != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.v.getGLSurfaceView();
      if (localTXCGLSurfaceView != null)
      {
        localTXCGLSurfaceView.a(new com.tencent.liteav.basic.d.o()
        {
          public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(182273);
            if (paramo != null) {
              paramo.onTakePhotoComplete(paramAnonymousBitmap);
            }
            AppMethodBeat.o(182273);
          }
        });
        AppMethodBeat.o(221332);
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
      AppMethodBeat.o(221332);
      return;
    }
    if (this.A != null)
    {
      this.A.a(new com.tencent.liteav.basic.d.o()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(221667);
          if (paramo != null) {
            paramo.onTakePhotoComplete(paramAnonymousBitmap);
          }
          AppMethodBeat.o(221667);
        }
      });
      AppMethodBeat.o(221332);
      return;
    }
    if (paramo != null) {
      paramo.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(221332);
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(16167);
    if (paramInt == 0)
    {
      this.G = paramTXSNALPacket.gopIndex;
      this.F = paramTXSNALPacket.frameIndex;
      if (this.K == null)
      {
        AppMethodBeat.o(16167);
        return;
      }
      a locala = (a)this.K.get();
      if (locala != null) {
        locala.onEncVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(16167);
      return;
    }
    if (((paramInt == 10000004) || (paramInt == 10000005)) && (this.h.encodeType == 1))
    {
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      this.o.j = 0;
      a(1103, "硬编码启动失败,采用软编码");
    }
    AppMethodBeat.o(16167);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    AppMethodBeat.i(16166);
    a(paramb.a, paramb.e, paramb.f, paramLong);
    AppMethodBeat.o(16166);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(16101);
    this.K = new WeakReference(parama);
    AppMethodBeat.o(16101);
  }
  
  public void a(f paramf)
  {
    AppMethodBeat.i(16103);
    int i1;
    int i2;
    if ((paramf != null) && ((this.o.E != paramf.E) || (this.o.F != paramf.F) || (this.o.G != paramf.G) || (this.o.J != paramf.J) || (this.o.H != paramf.H) || (this.o.I != paramf.I)))
    {
      i1 = 1;
      if ((paramf == null) || ((this.o.a == paramf.a) && (this.o.b == paramf.b))) {
        break label280;
      }
      i2 = 1;
      if (paramf == null) {
        break label300;
      }
    }
    for (;;)
    {
      try
      {
        this.o = ((f)paramf.clone());
        TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.o.a), Integer.valueOf(this.o.b), Integer.valueOf(this.o.l) }));
        if (this.d != null) {
          this.d.e(this.o.l);
        }
        if ((i2 == 0) || (this.o.T)) {
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
        AppMethodBeat.o(16103);
        return;
        i1 = 0;
        break;
        label280:
        i2 = 0;
      }
      catch (CloneNotSupportedException paramf)
      {
        this.o = new f();
        continue;
      }
      label300:
      this.o = new f();
      continue;
      label314:
      boolean bool = false;
    }
  }
  
  public void a(l paraml)
  {
    AppMethodBeat.i(16105);
    this.V = new WeakReference(paraml);
    AppMethodBeat.o(16105);
  }
  
  public void a(n paramn, int paramInt)
  {
    AppMethodBeat.i(16102);
    this.H = paramInt;
    if (paramn != null)
    {
      this.I = new WeakReference(paramn);
      AppMethodBeat.o(16102);
      return;
    }
    this.I = null;
    AppMethodBeat.o(16102);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(221333);
    if (Build.VERSION.SDK_INT < 21)
    {
      parama = new Bundle();
      parama.putString("EVT_MSG", "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
      onNotifyEvent(-1309, parama);
      TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(221333);
      return;
    }
    this.p = 1;
    if (this.d == null)
    {
      this.d = new h(this.n, this.o, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.T.a(false);
    k(this.C);
    this.d.a(this);
    this.d.a(this);
    this.d.a();
    this.d.a(getID());
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.aG);
    AppMethodBeat.o(221333);
  }
  
  public void a(final com.tencent.liteav.videoencoder.b paramb)
  {
    AppMethodBeat.i(16172);
    j localj = this.d;
    if (localj != null)
    {
      localj.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16729);
          try
          {
            if (paramb != null)
            {
              paramb.a();
              paramb.a(null);
            }
            AppMethodBeat.o(16729);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(16729);
          }
        }
      });
      AppMethodBeat.o(16172);
      return;
    }
    if (paramb != null) {}
    try
    {
      paramb.a();
      paramb.a(null);
      AppMethodBeat.o(16172);
      return;
    }
    catch (Exception paramb)
    {
      AppMethodBeat.o(16172);
    }
  }
  
  public void a(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(16121);
    if (this.o.M)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(16121);
      return;
    }
    if (this.a != null) {
      this.a.b();
    }
    this.u = false;
    boolean bool = this.o.W;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      final TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221146);
          arrayOfTXCGLSurfaceView[0] = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
          paramTXCloudVideoView.addVideoView(arrayOfTXCGLSurfaceView[0]);
          AppMethodBeat.o(221146);
        }
      });
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    for (;;)
    {
      this.p = 0;
      this.d = new b(this.n, this.o, (m)localObject, bool);
      x();
      k(this.C);
      this.d.a(getID());
      this.d.a(this);
      this.d.a(this);
      this.d.a();
      this.d.b(this.s);
      this.d.c(this.t);
      this.d.d(this.X);
      this.v = paramTXCloudVideoView;
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15501);
          if (paramTXCloudVideoView != null) {
            paramTXCloudVideoView.start(c.d(c.this).K, c.d(c.this).L, c.e(c.this));
          }
          AppMethodBeat.o(15501);
        }
      });
      this.u = false;
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(16121);
      return;
      localObject = new com.tencent.liteav.basic.d.f();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16113);
    this.J = paramBoolean;
    AppMethodBeat.o(16113);
  }
  
  public TXBeautyManager b()
  {
    return this.T;
  }
  
  public void b(final int paramInt)
  {
    AppMethodBeat.i(16107);
    TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(paramInt)));
    this.W = paramInt;
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16669);
          if (c.a(c.this) != null) {
            c.a(c.this).a(paramInt);
          }
          if (c.b(c.this) != null) {
            c.b(c.this).a(paramInt);
          }
          AppMethodBeat.o(16669);
        }
      });
      AppMethodBeat.o(16107);
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
    AppMethodBeat.o(16107);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16153);
    if (this.d == null)
    {
      AppMethodBeat.o(16153);
      return;
    }
    this.d.a(paramInt1, paramInt2);
    AppMethodBeat.o(16153);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16133);
    this.T.setBeautyLevel(paramInt1);
    this.T.setWhitenessLevel(paramInt2);
    this.T.setRuddyLevel(paramInt3);
    AppMethodBeat.o(16133);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16175);
    if (!this.Q)
    {
      this.Q = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.q == 2)
    {
      AppMethodBeat.o(16175);
      return;
    }
    j localj = this.d;
    if ((this.e != null) && (!this.o.M) && (localj != null))
    {
      if ((this.h.height != paramb.h) || (this.h.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.e.a(localj.f());
      this.e.a(this.o.l);
      this.e.a(paramb, paramb.b, 0, 0L);
    }
    AppMethodBeat.o(16175);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16122);
    TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(paramBoolean)));
    this.r = paramBoolean;
    if (this.r)
    {
      if (this.d == null)
      {
        w();
        AppMethodBeat.o(16122);
      }
    }
    else {
      x();
    }
    AppMethodBeat.o(16122);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public int c()
  {
    return this.h.width;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16108);
    TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(paramInt)));
    this.X = paramInt;
    if (this.d != null) {
      this.d.d(this.X);
    }
    if (this.A != null) {
      this.A.b(this.X);
    }
    AppMethodBeat.o(16108);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(182264);
    j(paramBoolean);
    AppMethodBeat.o(182264);
  }
  
  public int d()
  {
    return this.h.height;
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(16117);
    if (this.d == null)
    {
      AppMethodBeat.o(16117);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16499);
        if (c.a(c.this) != null) {
          c.a(c.this).d(paramInt);
        }
        c.a(c.this, paramInt);
        AppMethodBeat.o(16499);
      }
    });
    AppMethodBeat.o(16117);
  }
  
  public void d(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(16109);
    if (j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.q);
      AppMethodBeat.o(16109);
      return -2;
    }
    TXCDRApi.initCrashReport(this.n);
    this.q = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    B();
    TXCDRApi.txReportDAU(this.n, com.tencent.liteav.basic.datareport.a.bu);
    AppMethodBeat.o(16109);
    return 0;
  }
  
  public void e(final int paramInt)
  {
    AppMethodBeat.i(16119);
    if (this.d == null)
    {
      AppMethodBeat.o(16119);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(221188);
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramInt);
        }
        AppMethodBeat.o(221188);
      }
    });
    AppMethodBeat.o(16119);
  }
  
  public boolean e(boolean paramBoolean)
  {
    AppMethodBeat.i(182265);
    if (this.d == null)
    {
      AppMethodBeat.o(182265);
      return false;
    }
    paramBoolean = this.d.d(paramBoolean);
    AppMethodBeat.o(182265);
    return paramBoolean;
  }
  
  public void f()
  {
    AppMethodBeat.i(16110);
    if (!j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.q);
      AppMethodBeat.o(16110);
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.q = 0;
    t();
    this.o.P = false;
    if (this.a != null) {
      this.a.b();
    }
    b(false);
    this.B = null;
    AppMethodBeat.o(16110);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(16124);
    if (this.o.h == paramInt)
    {
      AppMethodBeat.o(16124);
      return;
    }
    this.o.h = paramInt;
    if ((this.d != null) && (this.d.g() < paramInt)) {
      switch (this.p)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(16124);
      return;
      k(true);
      t();
      AppMethodBeat.o(16124);
      return;
      this.d.f(paramInt);
    }
  }
  
  public boolean f(boolean paramBoolean)
  {
    AppMethodBeat.i(16154);
    this.o.S = paramBoolean;
    if (this.d == null)
    {
      AppMethodBeat.o(16154);
      return false;
    }
    this.d.c(paramBoolean);
    AppMethodBeat.o(16154);
    return true;
  }
  
  public void g()
  {
    AppMethodBeat.i(16111);
    if (this.q != 1)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.q);
      AppMethodBeat.o(16111);
      return;
    }
    this.q = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.o.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.o.M) && (this.d != null)) {
        this.a.a(this.o.C, this.o.B, this.o.A, this.h.width, this.h.height);
      }
      if (this.d != null) {
        this.d.c();
      }
    }
    AppMethodBeat.o(16111);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(16130);
    TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(paramInt)));
    this.t = paramInt;
    if (this.d != null) {
      this.d.c(paramInt);
    }
    if (this.A != null) {
      this.A.a(this.t);
    }
    AppMethodBeat.o(16130);
  }
  
  public void g(boolean paramBoolean)
  {
    AppMethodBeat.i(16157);
    if (this.D == paramBoolean)
    {
      AppMethodBeat.o(16157);
      return;
    }
    this.D = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.D);
    if (this.D) {
      this.o.j = 0;
    }
    t();
    AppMethodBeat.o(16157);
  }
  
  public void h()
  {
    AppMethodBeat.i(16112);
    if (this.q != 2)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.q);
      AppMethodBeat.o(16112);
      return;
    }
    this.q = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.o.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.o.M)) {
        this.a.b();
      }
      if (this.d != null) {
        this.d.b();
      }
      A();
    }
    AppMethodBeat.o(16112);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(16131);
    if (this.s != paramInt) {
      TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    }
    this.s = paramInt;
    if (this.d == null)
    {
      AppMethodBeat.o(16131);
      return;
    }
    this.d.b(paramInt);
    AppMethodBeat.o(16131);
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(182268);
    this.g = paramBoolean;
    AppMethodBeat.o(182268);
  }
  
  public void i(int paramInt)
  {
    AppMethodBeat.i(16134);
    this.T.setBeautyStyle(paramInt);
    AppMethodBeat.o(16134);
  }
  
  public void i(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }
  
  public boolean i()
  {
    return this.r;
  }
  
  public boolean j()
  {
    return this.q != 0;
  }
  
  public boolean j(int paramInt)
  {
    AppMethodBeat.i(221336);
    if (this.d == null)
    {
      AppMethodBeat.o(221336);
      return false;
    }
    boolean bool = this.d.a(paramInt);
    AppMethodBeat.o(221336);
    return bool;
  }
  
  public void k()
  {
    AppMethodBeat.i(16120);
    if (this.d == null)
    {
      AppMethodBeat.o(16120);
      return;
    }
    this.d.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(221527);
        if (c.e(c.this) != null) {
          c.e(c.this).b(true);
        }
        c.a(c.this, c.c(c.this).width, c.c(c.this).height);
        AppMethodBeat.o(221527);
      }
    });
    AppMethodBeat.o(16120);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(16141);
    this.C = paramInt;
    if (this.d != null) {
      this.d.g(this.C);
    }
    AppMethodBeat.o(16141);
  }
  
  public void l()
  {
    AppMethodBeat.i(16128);
    if (this.d == null)
    {
      AppMethodBeat.o(16128);
      return;
    }
    this.T.a(true);
    j(true);
    AppMethodBeat.o(16128);
  }
  
  public boolean m()
  {
    AppMethodBeat.i(221334);
    if (this.d != null)
    {
      boolean bool = this.d.h();
      AppMethodBeat.o(221334);
      return bool;
    }
    AppMethodBeat.o(221334);
    return false;
  }
  
  public boolean n()
  {
    AppMethodBeat.i(16147);
    if (this.d != null)
    {
      boolean bool = this.d.i();
      AppMethodBeat.o(16147);
      return bool;
    }
    AppMethodBeat.o(16147);
    return false;
  }
  
  public boolean o()
  {
    AppMethodBeat.i(16148);
    if (this.d != null)
    {
      boolean bool = this.d.j();
      AppMethodBeat.o(16148);
      return bool;
    }
    AppMethodBeat.o(16148);
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(16170);
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    com.tencent.liteav.basic.util.f.a(this.U, paramInt, paramBundle);
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.C);
    }
    while ((paramInt == -1302) || (paramInt == -1317) || (paramInt == -1318) || (paramInt == -1319))
    {
      TXCKeyPointReportProxy.b(30002, paramInt);
      AppMethodBeat.o(16170);
      return;
      if (paramInt == -1314) {
        TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.C);
      } else if (paramInt == 1003)
      {
        if (this.d != null)
        {
          paramBundle = getID();
          if (this.d.l()) {}
          for (l1 = 0L;; l1 = 1L)
          {
            TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.C);
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
      TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.C);
      AppMethodBeat.o(16170);
      return;
    }
  }
  
  public boolean p()
  {
    AppMethodBeat.i(16149);
    if (this.d != null)
    {
      boolean bool = this.d.k();
      AppMethodBeat.o(16149);
      return bool;
    }
    AppMethodBeat.o(16149);
    return false;
  }
  
  public int q()
  {
    AppMethodBeat.i(221335);
    if (this.d == null)
    {
      AppMethodBeat.o(221335);
      return 0;
    }
    int i1 = this.d.e();
    AppMethodBeat.o(221335);
    return i1;
  }
  
  public void r()
  {
    AppMethodBeat.i(221337);
    try
    {
      if (this.e != null) {
        this.e.b();
      }
      if (this.L != null)
      {
        this.L.d();
        this.L = null;
      }
      if (this.N != null)
      {
        this.N.d();
        this.N = null;
      }
      if (this.M != null)
      {
        this.M.d();
        this.M = null;
      }
      z();
      y();
      AppMethodBeat.o(221337);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(221337);
    }
  }
  
  public void s()
  {
    AppMethodBeat.i(16161);
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    if (this.e != null) {
      this.e.b();
    }
    if (this.L != null)
    {
      this.L.d();
      this.L = null;
    }
    if (this.N != null)
    {
      this.N.d();
      this.N = null;
    }
    if (this.M != null)
    {
      this.M.d();
      this.M = null;
    }
    if (this.O != null)
    {
      this.O.d();
      this.O = null;
    }
    z();
    y();
    if (this.V != null)
    {
      l locall = (l)this.V.get();
      if (locall != null) {
        locall.a();
      }
    }
    AppMethodBeat.o(16161);
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(16106);
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
    AppMethodBeat.o(16106);
  }
  
  public void t()
  {
    AppMethodBeat.i(16176);
    if (this.i == null)
    {
      AppMethodBeat.o(16176);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15502);
          c.f(c.this);
          c.h(c.this);
          AppMethodBeat.o(15502);
        }
      });
      AppMethodBeat.o(16176);
      return;
    }
    z();
    y();
    AppMethodBeat.o(16176);
  }
  
  public void u()
  {
    AppMethodBeat.i(16182);
    if (this.i == null)
    {
      AppMethodBeat.o(16182);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(182274);
          c.f(c.this);
          AppMethodBeat.o(182274);
        }
      });
      AppMethodBeat.o(16182);
      return;
    }
    z();
    AppMethodBeat.o(16182);
  }
  
  public void v()
  {
    AppMethodBeat.i(16183);
    if (this.m == null)
    {
      AppMethodBeat.o(16183);
      return;
    }
    if (this.d != null)
    {
      this.d.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16612);
          c.h(c.this);
          AppMethodBeat.o(16612);
        }
      });
      AppMethodBeat.o(16183);
      return;
    }
    y();
    AppMethodBeat.o(16183);
  }
  
  public static abstract interface a
  {
    public abstract void onBackgroudPushStop();
    
    public abstract void onEncVideo(TXSNALPacket paramTXSNALPacket);
    
    public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.c
 * JD-Core Version:    0.7.0.1
 */