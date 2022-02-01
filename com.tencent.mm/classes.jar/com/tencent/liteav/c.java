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
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class c
  extends com.tencent.liteav.basic.module.a
  implements a.b, com.tencent.liteav.basic.c.a, com.tencent.liteav.beauty.e, k, com.tencent.liteav.videoencoder.d
{
  private com.tencent.liteav.basic.structs.b A;
  private int B;
  private boolean C;
  private boolean D;
  private long E;
  private long F;
  private int G;
  private WeakReference<n> H;
  private boolean I;
  private WeakReference<a> J;
  private com.tencent.liteav.basic.d.h K;
  private com.tencent.liteav.basic.d.h L;
  private com.tencent.liteav.basic.d.h M;
  private com.tencent.liteav.beauty.b.k N;
  private byte[] O;
  private boolean P;
  private boolean Q;
  private boolean R;
  private TXBeautyManager S;
  private WeakReference<com.tencent.liteav.basic.c.a> T;
  private WeakReference<l> U;
  private int V;
  private int W;
  a a;
  a b;
  private j c;
  private com.tencent.liteav.beauty.c d;
  private boolean e;
  private boolean f;
  private TXSVideoEncoderParam g;
  private com.tencent.liteav.videoencoder.b h;
  private int i;
  private boolean j;
  private TXSVideoEncoderParam k;
  private com.tencent.liteav.videoencoder.b l;
  private Context m;
  private f n;
  private int o;
  private int p;
  private boolean q;
  private int r;
  private int s;
  private boolean t;
  private TXCloudVideoView u;
  private Object v;
  private Surface w;
  private int x;
  private int y;
  private com.tencent.liteav.basic.d.e z;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(16100);
    this.c = null;
    this.d = null;
    this.e = false;
    this.f = false;
    this.g = null;
    this.h = null;
    this.i = 15;
    this.j = false;
    this.k = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = 0;
    this.p = 0;
    this.q = false;
    this.r = 0;
    this.s = 0;
    this.t = false;
    this.u = null;
    this.v = new Object();
    this.w = null;
    this.x = 0;
    this.y = 0;
    this.z = null;
    this.B = 0;
    this.C = false;
    this.D = false;
    this.E = 0L;
    this.F = 0L;
    this.G = 2;
    this.I = false;
    this.J = null;
    this.K = null;
    this.P = false;
    this.Q = false;
    this.R = false;
    this.V = 0;
    this.W = 0;
    this.m = paramContext.getApplicationContext();
    this.n = new f();
    this.d = new com.tencent.liteav.beauty.c(this.m, true);
    this.d.a(this);
    this.d.a(this);
    this.d.b(this.n.U);
    this.g = new TXSVideoEncoderParam();
    this.h = null;
    this.k = new TXSVideoEncoderParam();
    this.a = new a(this);
    this.S = new TXBeautyManager(new com.tencent.liteav.basic.b.h());
    this.S.setPreprocessor(this.d);
    com.tencent.liteav.basic.e.b.a().a(this.m);
    AppMethodBeat.o(16100);
  }
  
  private void A()
  {
    AppMethodBeat.i(16186);
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      if (this.h != null)
      {
        this.h.a();
        this.h.a(null);
        this.h = null;
      }
      this.Q = true;
      AppMethodBeat.o(16186);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16186);
    }
  }
  
  private void B()
  {
    AppMethodBeat.i(16188);
    if (this.c != null) {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(182274);
          c.a(c.this, c.c(c.this).width, c.c(c.this).height);
          AppMethodBeat.o(182274);
        }
      });
    }
    AppMethodBeat.o(16188);
  }
  
  private void C()
  {
    AppMethodBeat.i(16190);
    if (this.d != null)
    {
      this.d.b(this.n.U);
      if (this.n.P)
      {
        this.d.g(0);
        AppMethodBeat.o(16190);
        return;
      }
      this.d.g(3);
    }
    AppMethodBeat.o(16190);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(16180);
    paramInt2 = this.n.a;
    paramInt1 = this.n.b;
    if ((this.n.l == 0) || (this.n.l == 2))
    {
      paramInt2 = this.n.b;
      paramInt1 = this.n.a;
    }
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
      AppMethodBeat.o(16180);
      return -1;
    }
    if (this.n.M)
    {
      A();
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
      b(paramInt2, paramInt3, this.d.a());
      com.tencent.liteav.videoencoder.b localb = this.h;
      if (localb != null) {
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      localb = this.l;
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
    A();
    this.h = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.B, Integer.valueOf(paramInt3));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt3 == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.B);
      this.Q = false;
      this.g.encodeType = paramInt3;
      this.g.width = paramInt1;
      this.g.height = paramInt2;
      this.g.fps = this.n.h;
      this.g.gop = this.n.i;
      this.g.encoderProfile = this.n.n;
      this.g.encoderMode = 1;
      localTXSVideoEncoderParam = this.g;
      if (paramObject == null) {
        break label525;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.g.realTime = this.n.P;
      this.g.streamType = this.B;
      this.g.annexb = this.D;
      this.g.bMultiRef = this.C;
      this.g.baseFrameIndex = (this.E + 20L);
      this.g.baseGopIndex = (this.F + 2L);
      this.g.bLimitFps = this.f;
      this.g.record = this.R;
      this.g.encFmt = this.n.Y;
      this.h.a(this);
      this.h.a(this);
      this.h.a(this.g);
      this.h.c(this.n.c);
      this.h.d(this.i);
      this.h.setID(getID());
      this.h.a(this.V);
      TXCStatus.a(getID(), 4003, this.B, Integer.valueOf(this.g.width << 16 | this.g.height));
      TXCStatus.a(getID(), 13003, this.B, Integer.valueOf(this.g.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.g.width, this.g.height, "", this.B);
      AppMethodBeat.o(16177);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.B);
      break;
      label525:
      paramObject = this.h.a(paramInt1, paramInt2);
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
    com.tencent.liteav.basic.util.d.a(this.T, paramInt, localBundle);
    if (paramInt == -1317)
    {
      paramString = getID();
      l1 = 4L;
    }
    for (;;)
    {
      TXCEventRecorderProxy.a(paramString, i1, l1, -1L, "", this.B);
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
      } while ((paramInt != 1003) || (this.c == null));
      paramString = getID();
      i1 = 4001;
      if (this.c.l()) {
        l1 = 0L;
      } else {
        l1 = 1L;
      }
    }
    label217:
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.c != null)
      {
        paramString = getID();
        if (!this.c.l()) {
          break label304;
        }
      }
    }
    label304:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.B);
      AppMethodBeat.o(16158);
      return;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(16164);
    paramb.e = paramInt1;
    paramb.f = paramInt2;
    paramb.i = this.n.S;
    if (this.n.l == 0) {
      paramb.g = this.n.b;
    }
    for (paramb.h = this.n.a;; paramb.h = this.n.b)
    {
      paramb.l = com.tencent.liteav.basic.util.d.a(paramb.e, paramb.f, paramb.g, paramb.h);
      try
      {
        this.d.b(this.n.l);
        this.d.a(paramObject);
        this.d.a(paramb, paramb.b, 0, paramLong);
        AppMethodBeat.o(16164);
        return;
      }
      catch (Exception paramb)
      {
        AppMethodBeat.o(16164);
      }
      paramb.g = this.n.a;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(16193);
    e(paramb.e, paramb.f);
    this.A = paramb;
    if (this.u != null)
    {
      if (this.c != null)
      {
        this.c.a(paramb);
        AppMethodBeat.o(16193);
      }
    }
    else {
      synchronized (this.v)
      {
        if ((this.w != null) && (this.z == null) && (this.c != null) && (this.c.f() != null))
        {
          this.z = new com.tencent.liteav.basic.d.e();
          this.z.a(this.c.f(), this.w);
          this.z.a(this.s);
          this.z.b(this.W);
        }
        if ((this.z != null) && (this.c != null)) {
          this.z.a(paramb.a, paramb.i, this.r, this.x, this.y, paramb.e, paramb.f, paramBoolean, this.c.l());
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
    z();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
      localTXSVideoEncoderParam = this.k;
      if (paramObject == null) {
        break label229;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.k.encodeType = paramInt;
      TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
      localb.a(this);
      localb.a(this);
      localb.a(this.k);
      localb.c(this.k.bitrate);
      localb.setID(getID());
      localb.a(this.V);
      this.l = localb;
      TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.k.width << 16 | this.k.height));
      TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.k.gop * 1000));
      AppMethodBeat.o(16178);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
      break;
      label229:
      paramObject = localb.a(this.k.width, this.k.height);
    }
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i3 = 2;
    int i2 = 1;
    AppMethodBeat.i(16181);
    int i1 = i3;
    switch (this.n.j)
    {
    default: 
      i1 = i3;
    case 0: 
      if (this.o == 1) {
        i1 = i2;
      }
      break;
    }
    for (;;)
    {
      i2 = this.n.i;
      if ((this.h == null) || (this.Q) || (this.g.width != paramInt1) || (this.g.height != paramInt2) || (this.g.encodeType != i1) || (this.g.gop != i2)) {
        a(paramInt1, paramInt2, i1, paramObject);
      }
      if (((this.l == null) || (this.k.encodeType != i1)) && (this.j)) {
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
    if (this.I)
    {
      i1 = paramb.a;
      AppMethodBeat.o(16194);
      return i1;
    }
    int i1 = paramb.a;
    int i7;
    com.tencent.liteav.basic.d.h localh;
    if (this.W == 1)
    {
      i7 = 1;
      if (i7 == paramb.i) {
        break label398;
      }
      if (this.L == null)
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
        this.L = localh;
      }
      localh = this.L;
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
      if (this.r != 0)
      {
        if (this.M == null)
        {
          localh = new com.tencent.liteav.basic.d.h();
          localh.a();
          localh.a(true);
          localh.a(paramb.e, paramb.f);
          this.M = localh;
        }
        localh = this.M;
        i2 = i1;
        if (localh != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          i4 = paramb.e;
          i5 = paramb.f;
          arrayOfFloat = localh.a(i4, i5, null, com.tencent.liteav.basic.util.d.a(i4, i5, paramb.e, paramb.f), 0);
          i6 = (720 - this.r) % 360;
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
    com.tencent.liteav.beauty.c localc;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.n.J != -1.0F) {
      if (this.d != null)
      {
        localc = this.d;
        localBitmap = this.n.E;
        f3 = this.n.H;
        f2 = this.n.I;
        f1 = this.n.J;
      }
    }
    for (;;)
    {
      localc.a(localBitmap, f3, f2, f1);
      do
      {
        AppMethodBeat.o(16189);
        return;
      } while ((this.d == null) || (paramInt1 == 0) || (paramInt2 == 0));
      localc = this.d;
      localBitmap = this.n.E;
      f3 = this.n.F / paramInt1;
      f2 = this.n.G / paramInt2;
      if (this.n.E == null) {
        f1 = 0.0F;
      } else {
        f1 = this.n.E.getWidth() / paramInt1;
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
    Object localObject2 = this.H;
    if (localObject2 == null)
    {
      AppMethodBeat.o(16195);
      return;
    }
    int i1 = c(paramb);
    Object localObject1;
    if (this.G == 2)
    {
      localObject1 = (n)((WeakReference)localObject2).get();
      if (localObject1 != null)
      {
        localObject2 = new TXSVideoFrame();
        ((TXSVideoFrame)localObject2).width = paramb.e;
        ((TXSVideoFrame)localObject2).height = paramb.f;
        ((TXSVideoFrame)localObject2).textureId = i1;
        ((TXSVideoFrame)localObject2).eglContext = this.d.a();
        ((TXSVideoFrame)localObject2).pts = TXCTimeUtil.generatePtsMS();
        ((n)localObject1).onRenderVideoFrame(getID(), this.B, (TXSVideoFrame)localObject2);
        if (this.I) {
          paramb.a = ((TXSVideoFrame)localObject2).textureId;
        }
      }
    }
    label214:
    do
    {
      do
      {
        if ((this.I) && (this.u != null))
        {
          paramb = this.u.getGLSurfaceView();
          if (paramb != null) {
            paramb.d();
          }
        }
        AppMethodBeat.o(16195);
        return;
      } while ((this.G != 1) && (this.G != 4));
      if (this.K == null)
      {
        if (this.G != 1) {
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
            AppMethodBeat.i(182275);
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
            AppMethodBeat.o(182275);
          }
        });
        this.K = ((com.tencent.liteav.basic.d.h)localObject1);
      }
      localObject1 = this.K;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.basic.d.h)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.basic.d.h)localObject1).b(i1);
      }
    } while ((!this.I) || (this.O == null));
    label257:
    if (this.G == 1) {
      i1 = 1;
    }
    for (;;)
    {
      if (this.N == null)
      {
        localObject1 = new com.tencent.liteav.beauty.b.k(i1);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
        if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
          TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
        }
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        this.N = ((com.tencent.liteav.beauty.b.k)localObject1);
      }
      localObject1 = this.N;
      if (localObject1 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(this.O);
        paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).q();
      }
      this.O = null;
      break;
      localObject1 = new com.tencent.liteav.beauty.b.o(3);
      break label214;
      label445:
      TXCLog.i("TXCCaptureAndEnc", "init filter error ");
      this.K = null;
      break label257;
      if (this.G == 4) {
        i1 = 3;
      } else {
        i1 = 1;
      }
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16192);
    if (!this.t)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", getID());
      localBundle.putInt("EVT_ID", 2003);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putCharSequence("EVT_MSG", "渲染首帧视频");
      localBundle.putInt("EVT_PARAM1", paramInt1);
      localBundle.putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.d.a(this.T, 2003, localBundle);
      TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.B);
      this.t = true;
    }
    AppMethodBeat.o(16192);
  }
  
  private void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(182269);
    if (this.c != null) {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15502);
          if (c.e(c.this) != null)
          {
            c.e(c.this).f(c.d(c.this).h);
            c.e(c.this).e(c.d(c.this).l);
            c.e(c.this).b(c.d(c.this).a, c.d(c.this).b);
            if ((paramBoolean) && (c.e(c.this).d())) {
              c.e(c.this).b(false);
            }
          }
          AppMethodBeat.o(15502);
        }
      });
    }
    AppMethodBeat.o(182269);
  }
  
  private void x()
  {
    AppMethodBeat.i(16114);
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new a(this);
    }
    this.b.a(10, -1, null, 64, 64);
    AppMethodBeat.o(16114);
  }
  
  private void y()
  {
    AppMethodBeat.i(16115);
    TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.q);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(16115);
  }
  
  private void z()
  {
    AppMethodBeat.i(16185);
    try
    {
      if (this.l != null)
      {
        this.l.a();
        this.l.a(null);
        this.l = null;
      }
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
    paramObject = this.h;
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
    if (this.U != null)
    {
      l locall = (l)this.U.get();
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
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(16123);
    int i1;
    if ((this.k.width != paramInt1) || (this.k.height != paramInt2))
    {
      i1 = 1;
      this.k.width = paramInt1;
      this.k.height = paramInt2;
      this.k.fps = paramInt3;
      this.k.gop = 1;
      this.k.encoderProfile = 1;
      this.k.encoderMode = 1;
      this.k.realTime = this.n.P;
      this.k.streamType = 3;
      this.k.bitrate = paramInt4;
      this.k.annexb = true;
      this.k.bMultiRef = false;
      if ((this.l != null) && ((i1 != 0) || ((this.j) && (!paramBoolean))))
      {
        if (this.c == null) {
          break label193;
        }
        this.c.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(15501);
            c.h(c.this);
            AppMethodBeat.o(15501);
          }
        });
      }
    }
    for (;;)
    {
      this.j = paramBoolean;
      AppMethodBeat.o(16123);
      return 0;
      i1 = 0;
      break;
      label193:
      z();
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
    com.tencent.liteav.videoencoder.b localb = this.h;
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
    if (this.J == null)
    {
      AppMethodBeat.o(16173);
      return;
    }
    a locala = (a)this.J.get();
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
    if (this.d != null) {
      this.d.a(paramFloat);
    }
    AppMethodBeat.o(16142);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(16196);
    if ((this.c != null) && (this.n.K)) {
      this.c.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(16196);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(16169);
    if (this.g.width * this.g.height < 518400) {}
    for (this.n.j = 0; paramInt == 3; this.n.j = 0)
    {
      label35:
      w();
      AppMethodBeat.o(16169);
      return;
      if ((this.g.width * this.g.height >= 921600) || (!this.e)) {
        break label35;
      }
    }
    this.e = true;
    v();
    AppMethodBeat.o(16169);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(16126);
    synchronized (this.v)
    {
      if (this.z != null)
      {
        this.z.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(182289);
            c.b(c.this, paramInt1);
            c.c(c.this, paramInt2);
            if ((c.j(c.this) != null) && (c.k(c.this) != null)) {
              c.a(c.this, c.j(c.this), true);
            }
            AppMethodBeat.o(182289);
          }
        });
        AppMethodBeat.o(16126);
        return;
      }
      this.x = paramInt1;
      this.y = paramInt2;
    }
  }
  
  public void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(16118);
    if (this.c == null)
    {
      AppMethodBeat.o(16118);
      return;
    }
    this.c.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15500);
        if ((paramInt2 != 0) && (paramInt3 != 0))
        {
          c.d(c.this).a = paramInt2;
          c.d(c.this).b = paramInt3;
          if (c.e(c.this) != null) {
            c.e(c.this).b(paramInt2, paramInt3);
          }
        }
        if ((paramInt1 != 0) && (c.a(c.this) != null))
        {
          c.d(c.this).c = paramInt1;
          c.a(c.this).c(paramInt1);
        }
        AppMethodBeat.o(15500);
      }
    });
    AppMethodBeat.o(16118);
  }
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, int paramInt7)
  {
    AppMethodBeat.i(16116);
    if (paramInt1 == 2)
    {
      if ((this.g.width != 0) && (this.g.height != 0) && ((paramInt2 != this.g.width) || (paramInt3 != this.g.height) || (paramInt4 > this.g.fps))) {
        if (this.c != null) {
          this.c.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(16611);
              Object localObject;
              if ((paramInt2 != c.c(c.this).width) || (paramInt3 != c.c(c.this).height) || (paramInt4 > c.c(c.this).fps))
              {
                if (paramInt2 <= paramInt3) {
                  break label326;
                }
                c.d(c.this).l = 0;
                localObject = c.d(c.this);
                if (paramInt2 <= paramInt3) {
                  break label351;
                }
                i = paramInt3;
                label103:
                ((f)localObject).a = i;
                localObject = c.d(c.this);
                if (paramInt2 <= paramInt3) {
                  break label359;
                }
              }
              label326:
              label351:
              label359:
              for (int i = paramInt2;; i = paramInt3)
              {
                ((f)localObject).b = i;
                localObject = c.e(c.this);
                if (localObject != null)
                {
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
        localb = this.h;
        if (localb != null)
        {
          localb.b(paramInt5, paramInt6);
          localb.b(paramInt4);
        }
      }
    }
    if ((this.k != null) && ((paramInt2 != this.k.width) || (paramInt3 != this.k.height)) && (this.c != null)) {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15533);
          TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(c.g(c.this).width), Integer.valueOf(c.g(c.this).height), Integer.valueOf(c.g(c.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
          c.g(c.this).width = paramInt2;
          c.g(c.this).height = paramInt3;
          c.h(c.this);
          AppMethodBeat.o(15533);
        }
      });
    }
    com.tencent.liteav.videoencoder.b localb = this.l;
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
    this.F = paramLong2;
    this.E = paramLong3;
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(16135);
    if (this.d != null) {
      this.d.a(paramBitmap);
    }
    AppMethodBeat.o(16135);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(16136);
    this.n.E = paramBitmap;
    this.n.H = paramFloat1;
    this.n.I = paramFloat2;
    this.n.J = paramFloat3;
    B();
    AppMethodBeat.o(16136);
  }
  
  public void a(final Bitmap paramBitmap, final ByteBuffer paramByteBuffer, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(16171);
    j localj = this.c;
    if (localj != null)
    {
      localj.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15554);
          try
          {
            int i = c.l(c.this);
            if (i != 2)
            {
              AppMethodBeat.o(15554);
              return;
            }
            i = paramBitmap.getWidth();
            int j = paramBitmap.getHeight();
            com.tencent.liteav.basic.d.a locala = com.tencent.liteav.basic.util.d.a(i, j, paramInt1, paramInt2);
            c.i(c.this).a(locala);
            c.i(c.this).c(false);
            if (c.d(c.this).W) {
              c.i(c.this).a(false);
            }
            c.i(c.this).a(paramInt1, paramInt2);
            c.i(c.this).a(0);
            c.i(c.this).a(paramByteBuffer.array(), i, j, 0, 2, 0);
            AppMethodBeat.o(15554);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(15554);
          }
        }
      });
      AppMethodBeat.o(16171);
      return;
    }
    if ((this.h == null) || (this.Q) || (this.g.width != paramInt1) || (this.g.height != paramInt2) || (this.g.encodeType != 2) || (this.g.gop != this.n.i)) {
      a(paramInt1, paramInt2, 2, null);
    }
    paramBitmap = this.h;
    if (paramBitmap != null) {
      paramBitmap.a(paramByteBuffer.array(), 2, paramInt1, paramInt2, TXCTimeUtil.generatePtsMS());
    }
    AppMethodBeat.o(16171);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16174);
    if (this.d != null) {
      this.d.b();
    }
    AppMethodBeat.o(16174);
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(16168);
    if (this.J == null)
    {
      AppMethodBeat.o(16168);
      return;
    }
    a locala = (a)this.J.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(16168);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(16125);
    if (this.u != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      AppMethodBeat.o(16125);
      return;
    }
    synchronized (this.v)
    {
      if (this.w != paramSurface)
      {
        TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
        this.w = paramSurface;
        if (this.z != null)
        {
          this.z.a();
          this.z = null;
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
    this.T = new WeakReference(parama);
    AppMethodBeat.o(16104);
  }
  
  public void a(final com.tencent.liteav.basic.d.o paramo)
  {
    AppMethodBeat.i(193041);
    if (this.u != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.u.getGLSurfaceView();
      if (localTXCGLSurfaceView != null)
      {
        localTXCGLSurfaceView.a(new com.tencent.liteav.basic.d.o()
        {
          public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(182434);
            if (paramo != null) {
              paramo.onTakePhotoComplete(paramAnonymousBitmap);
            }
            AppMethodBeat.o(182434);
          }
        });
        AppMethodBeat.o(193041);
        return;
      }
      if (paramo != null) {
        paramo.onTakePhotoComplete(null);
      }
      AppMethodBeat.o(193041);
      return;
    }
    if (this.z != null)
    {
      this.z.a(new com.tencent.liteav.basic.d.o()
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
      AppMethodBeat.o(193041);
      return;
    }
    if (paramo != null) {
      paramo.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(193041);
  }
  
  public void a(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    AppMethodBeat.i(16167);
    if (paramInt == 0)
    {
      this.F = paramTXSNALPacket.gopIndex;
      this.E = paramTXSNALPacket.frameIndex;
      if (this.J == null)
      {
        AppMethodBeat.o(16167);
        return;
      }
      a locala = (a)this.J.get();
      if (locala != null) {
        locala.onEncVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(16167);
      return;
    }
    if (((paramInt == 10000004) || (paramInt == 10000005)) && (this.g.encodeType == 1))
    {
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      this.n.j = 0;
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
    this.J = new WeakReference(parama);
    AppMethodBeat.o(16101);
  }
  
  public void a(f paramf)
  {
    AppMethodBeat.i(16103);
    int i1;
    int i2;
    if ((paramf != null) && ((this.n.E != paramf.E) || (this.n.F != paramf.F) || (this.n.G != paramf.G) || (this.n.J != paramf.J) || (this.n.H != paramf.H) || (this.n.I != paramf.I)))
    {
      i1 = 1;
      if ((paramf == null) || ((this.n.a == paramf.a) && (this.n.b == paramf.b))) {
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
        this.n = ((f)paramf.clone());
        TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.n.a), Integer.valueOf(this.n.b), Integer.valueOf(this.n.l) }));
        if (this.c != null) {
          this.c.e(this.n.l);
        }
        if ((i2 == 0) || (this.n.T)) {
          break label314;
        }
        bool = true;
        k(bool);
        if (j())
        {
          C();
          if (i1 != 0) {
            B();
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
        this.n = new f();
        continue;
      }
      label300:
      this.n = new f();
      continue;
      label314:
      boolean bool = false;
    }
  }
  
  public void a(l paraml)
  {
    AppMethodBeat.i(16105);
    this.U = new WeakReference(paraml);
    AppMethodBeat.o(16105);
  }
  
  public void a(n paramn, int paramInt)
  {
    AppMethodBeat.i(16102);
    this.G = paramInt;
    if (paramn != null)
    {
      this.H = new WeakReference(paramn);
      AppMethodBeat.o(16102);
      return;
    }
    this.H = null;
    AppMethodBeat.o(16102);
  }
  
  public void a(final com.tencent.liteav.videoencoder.b paramb)
  {
    AppMethodBeat.i(16172);
    j localj = this.c;
    if (localj != null)
    {
      localj.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15535);
          try
          {
            if (paramb != null)
            {
              paramb.a();
              paramb.a(null);
            }
            AppMethodBeat.o(15535);
            return;
          }
          catch (Exception localException)
          {
            AppMethodBeat.o(15535);
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
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(16121);
    if (this.n.M)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(16121);
      return;
    }
    if (this.a != null) {
      this.a.b();
    }
    this.t = false;
    boolean bool = this.n.W;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      paramTXCloudVideoView.getGLSurfaceView();
      localObject = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
      paramTXCloudVideoView.addVideoView((TXCGLSurfaceView)localObject);
      ((TXCGLSurfaceView)localObject).setNotifyListener(this);
    }
    for (;;)
    {
      this.o = 0;
      this.c = new b(this.m, this.n, (m)localObject, bool);
      y();
      q(this.B);
      this.c.a(getID());
      this.c.a(this);
      this.c.a(this);
      this.c.a();
      this.c.b(this.r);
      this.c.c(this.s);
      this.c.d(this.W);
      this.u = paramTXCloudVideoView;
      if (this.u != null) {
        this.u.start(this.n.K, this.n.L, this.c);
      }
      this.t = false;
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(16121);
      return;
      localObject = new com.tencent.liteav.basic.d.f();
      bool = false;
    }
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(16137);
    this.S.setMotionTmpl(paramString);
    AppMethodBeat.o(16137);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16113);
    this.I = paramBoolean;
    AppMethodBeat.o(16113);
  }
  
  public TXBeautyManager b()
  {
    return this.S;
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(16155);
    if (this.c == null)
    {
      AppMethodBeat.o(16155);
      return;
    }
    this.c.a(paramFloat);
    AppMethodBeat.o(16155);
  }
  
  public void b(final int paramInt)
  {
    AppMethodBeat.i(16107);
    TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(paramInt)));
    this.V = paramInt;
    if (this.c != null)
    {
      this.c.a(new Runnable()
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
    com.tencent.liteav.videoencoder.b localb = this.h;
    if (localb != null) {
      localb.a(paramInt);
    }
    localb = this.l;
    if (localb != null) {
      localb.a(paramInt);
    }
    AppMethodBeat.o(16107);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16153);
    if (this.c == null)
    {
      AppMethodBeat.o(16153);
      return;
    }
    this.c.a(paramInt1, paramInt2);
    AppMethodBeat.o(16153);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16133);
    this.S.setBeautyLevel(paramInt1);
    this.S.setWhitenessLevel(paramInt2);
    this.S.setRuddyLevel(paramInt3);
    AppMethodBeat.o(16133);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(16175);
    if (!this.P)
    {
      this.P = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.p == 2)
    {
      AppMethodBeat.o(16175);
      return;
    }
    j localj = this.c;
    if ((this.d != null) && (!this.n.M) && (localj != null))
    {
      if ((this.g.height != paramb.h) || (this.g.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.d.a(localj.f());
      this.d.b(this.n.l);
      this.d.a(paramb, paramb.b, 0, 0L);
    }
    AppMethodBeat.o(16175);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(16122);
    TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(paramBoolean)));
    this.q = paramBoolean;
    if (this.q)
    {
      if (this.c == null)
      {
        x();
        AppMethodBeat.o(16122);
      }
    }
    else {
      y();
    }
    AppMethodBeat.o(16122);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  @TargetApi(18)
  public boolean b(String paramString)
  {
    AppMethodBeat.i(16139);
    if (this.d != null)
    {
      boolean bool = this.d.a(paramString, true);
      AppMethodBeat.o(16139);
      return bool;
    }
    AppMethodBeat.o(16139);
    return false;
  }
  
  public int c()
  {
    return this.g.width;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16108);
    TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(paramInt)));
    this.W = paramInt;
    if (this.c != null) {
      this.c.d(this.W);
    }
    if (this.z != null) {
      this.z.b(this.W);
    }
    AppMethodBeat.o(16108);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(182264);
    if (this.c == null)
    {
      AppMethodBeat.o(182264);
      return;
    }
    this.c.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(182419);
        if (c.i(c.this) != null) {
          c.i(c.this).b();
        }
        AppMethodBeat.o(182419);
      }
    });
    u();
    this.c.a(paramBoolean);
    this.c = null;
    if (this.u != null)
    {
      this.u.stop(paramBoolean);
      this.u = null;
    }
    synchronized (this.v)
    {
      this.w = null;
      if (this.z != null)
      {
        this.z.a();
        this.z = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.q) {
        x();
      }
      AppMethodBeat.o(182264);
      return;
    }
  }
  
  public int d()
  {
    return this.g.height;
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(16117);
    if (this.c == null)
    {
      AppMethodBeat.o(16117);
      return;
    }
    this.c.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15528);
        if (c.a(c.this) != null) {
          c.a(c.this).d(paramInt);
        }
        c.a(c.this, paramInt);
        AppMethodBeat.o(15528);
      }
    });
    AppMethodBeat.o(16117);
  }
  
  public void d(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }
  
  public int e()
  {
    AppMethodBeat.i(16109);
    if (j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.p);
      AppMethodBeat.o(16109);
      return -2;
    }
    TXCDRApi.initCrashReport(this.m);
    this.p = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    C();
    TXCDRApi.txReportDAU(this.m, com.tencent.liteav.basic.datareport.a.bu);
    AppMethodBeat.o(16109);
    return 0;
  }
  
  public void e(final int paramInt)
  {
    AppMethodBeat.i(16119);
    if (this.c == null)
    {
      AppMethodBeat.o(16119);
      return;
    }
    this.c.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16689);
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramInt);
        }
        AppMethodBeat.o(16689);
      }
    });
    AppMethodBeat.o(16119);
  }
  
  public boolean e(boolean paramBoolean)
  {
    AppMethodBeat.i(182265);
    if (this.c == null)
    {
      AppMethodBeat.o(182265);
      return false;
    }
    paramBoolean = this.c.d(paramBoolean);
    AppMethodBeat.o(182265);
    return paramBoolean;
  }
  
  public void f()
  {
    AppMethodBeat.i(16110);
    if (!j())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.p);
      AppMethodBeat.o(16110);
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.p = 0;
    u();
    this.n.P = false;
    if (this.a != null) {
      this.a.b();
    }
    b(false);
    this.A = null;
    AppMethodBeat.o(16110);
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(16124);
    this.n.h = paramInt;
    if ((this.c != null) && (this.c.g() < paramInt)) {
      switch (this.o)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(16124);
      return;
      k(true);
      u();
      AppMethodBeat.o(16124);
      return;
      m();
      l();
    }
  }
  
  public void f(boolean paramBoolean)
  {
    AppMethodBeat.i(182266);
    this.S.setMotionMute(paramBoolean);
    AppMethodBeat.o(182266);
  }
  
  public void g()
  {
    AppMethodBeat.i(16111);
    if (this.p != 1)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.p);
      AppMethodBeat.o(16111);
      return;
    }
    this.p = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.n.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.n.M) && (this.c != null)) {
        this.a.a(this.n.C, this.n.B, this.n.A, this.g.width, this.g.height);
      }
      if (this.c != null) {
        this.c.c();
      }
    }
    AppMethodBeat.o(16111);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(16130);
    TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(paramInt)));
    this.s = paramInt;
    if (this.c != null) {
      this.c.c(paramInt);
    }
    if (this.z != null) {
      this.z.a(this.s);
    }
    AppMethodBeat.o(16130);
  }
  
  public boolean g(boolean paramBoolean)
  {
    AppMethodBeat.i(182267);
    this.n.S = paramBoolean;
    if (this.c == null)
    {
      AppMethodBeat.o(182267);
      return false;
    }
    this.c.c(paramBoolean);
    AppMethodBeat.o(182267);
    return true;
  }
  
  public void h()
  {
    AppMethodBeat.i(16112);
    if (this.p != 2)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.p);
      AppMethodBeat.o(16112);
      return;
    }
    this.p = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.n.D & 0x1) == 1)
    {
      if ((this.a != null) && (!this.n.M)) {
        this.a.b();
      }
      if (this.c != null) {
        this.c.b();
      }
      B();
    }
    AppMethodBeat.o(16112);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(16131);
    if (this.r != paramInt) {
      TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    }
    this.r = paramInt;
    if (this.c == null)
    {
      AppMethodBeat.o(16131);
      return;
    }
    this.c.b(paramInt);
    AppMethodBeat.o(16131);
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(182268);
    if (this.C == paramBoolean)
    {
      AppMethodBeat.o(182268);
      return;
    }
    this.C = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.C);
    if (this.C) {
      this.n.j = 0;
    }
    u();
    AppMethodBeat.o(182268);
  }
  
  public void i(int paramInt)
  {
    AppMethodBeat.i(16134);
    this.S.setBeautyStyle(paramInt);
    AppMethodBeat.o(16134);
  }
  
  public void i(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean i()
  {
    return this.q;
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(16140);
    this.S.setEyeScaleLevel(paramInt);
    AppMethodBeat.o(16140);
  }
  
  public void j(boolean paramBoolean)
  {
    AppMethodBeat.i(16187);
    this.D = paramBoolean;
    AppMethodBeat.o(16187);
  }
  
  public boolean j()
  {
    return this.p != 0;
  }
  
  public void k()
  {
    AppMethodBeat.i(16120);
    if (this.c == null)
    {
      AppMethodBeat.o(16120);
      return;
    }
    this.c.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16499);
        if (c.e(c.this) != null) {
          c.e(c.this).b(true);
        }
        c.a(c.this, c.c(c.this).width, c.c(c.this).height);
        AppMethodBeat.o(16499);
      }
    });
    AppMethodBeat.o(16120);
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(16141);
    this.S.setFaceSlimLevel(paramInt);
    AppMethodBeat.o(16141);
  }
  
  public void l()
  {
    AppMethodBeat.i(16128);
    if (Build.VERSION.SDK_INT < 21)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_MSG", "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
      onNotifyEvent(-1309, localBundle);
      TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(16128);
      return;
    }
    this.o = 1;
    if (this.c == null) {
      this.c = new h(this.m, this.n);
    }
    this.c.a(this);
    this.c.a(this);
    this.c.a();
    this.c.a(getID());
    TXCDRApi.txReportDAU(this.m, com.tencent.liteav.basic.datareport.a.aG);
    AppMethodBeat.o(16128);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(16143);
    this.S.setFaceVLevel(paramInt);
    AppMethodBeat.o(16143);
  }
  
  public void m()
  {
    AppMethodBeat.i(16129);
    if (this.c == null)
    {
      AppMethodBeat.o(16129);
      return;
    }
    u();
    this.c.a(false);
    this.c = null;
    AppMethodBeat.o(16129);
  }
  
  public void m(int paramInt)
  {
    AppMethodBeat.i(16144);
    this.S.setFaceShortLevel(paramInt);
    AppMethodBeat.o(16144);
  }
  
  public void n(int paramInt)
  {
    AppMethodBeat.i(16145);
    this.S.setChinLevel(paramInt);
    AppMethodBeat.o(16145);
  }
  
  public boolean n()
  {
    AppMethodBeat.i(16147);
    if (this.c != null)
    {
      boolean bool = this.c.h();
      AppMethodBeat.o(16147);
      return bool;
    }
    AppMethodBeat.o(16147);
    return false;
  }
  
  public void o(int paramInt)
  {
    AppMethodBeat.i(16146);
    this.S.setNoseSlimLevel(paramInt);
    AppMethodBeat.o(16146);
  }
  
  public boolean o()
  {
    AppMethodBeat.i(16148);
    if (this.c != null)
    {
      boolean bool = this.c.i();
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
    com.tencent.liteav.basic.util.d.a(this.T, paramInt, paramBundle);
    if (paramInt == -1317) {
      TXCEventRecorderProxy.a(getID(), 2002, 4L, -1L, "", this.B);
    }
    while ((paramInt == -1302) || (paramInt == -1317) || (paramInt == -1318) || (paramInt == -1319))
    {
      TXCKeyPointReportProxy.b(30002, paramInt);
      AppMethodBeat.o(16170);
      return;
      if (paramInt == -1314) {
        TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.B);
      } else if (paramInt == 1003)
      {
        if (this.c != null)
        {
          paramBundle = getID();
          if (this.c.l()) {}
          for (l1 = 0L;; l1 = 1L)
          {
            TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.B);
            break;
          }
        }
      }
      else if (paramInt == -1308) {
        m();
      }
    }
    if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
    {
      TXCKeyPointReportProxy.b(30003, paramInt);
      if (this.c != null)
      {
        paramBundle = getID();
        if (!this.c.l()) {
          break label293;
        }
      }
    }
    label293:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.B);
      AppMethodBeat.o(16170);
      return;
    }
  }
  
  public boolean p()
  {
    AppMethodBeat.i(16149);
    if (this.c != null)
    {
      boolean bool = this.c.j();
      AppMethodBeat.o(16149);
      return bool;
    }
    AppMethodBeat.o(16149);
    return false;
  }
  
  public boolean p(int paramInt)
  {
    AppMethodBeat.i(16152);
    if (this.c == null)
    {
      AppMethodBeat.o(16152);
      return false;
    }
    boolean bool = this.c.a(paramInt);
    AppMethodBeat.o(16152);
    return bool;
  }
  
  public void q(int paramInt)
  {
    AppMethodBeat.i(16156);
    this.B = paramInt;
    if ((this.c != null) && ((this.c instanceof b))) {
      ((b)this.c).g(this.B);
    }
    AppMethodBeat.o(16156);
  }
  
  public boolean q()
  {
    AppMethodBeat.i(16150);
    if (this.c != null)
    {
      boolean bool = this.c.k();
      AppMethodBeat.o(16150);
      return bool;
    }
    AppMethodBeat.o(16150);
    return false;
  }
  
  public int r()
  {
    AppMethodBeat.i(16151);
    if (this.c == null)
    {
      AppMethodBeat.o(16151);
      return 0;
    }
    int i1 = this.c.e();
    AppMethodBeat.o(16151);
    return i1;
  }
  
  public void s()
  {
    AppMethodBeat.i(16161);
    try
    {
      if (this.d != null) {
        this.d.b();
      }
      if (this.K != null)
      {
        this.K.d();
        this.K = null;
      }
      if (this.M != null)
      {
        this.M.d();
        this.M = null;
      }
      if (this.L != null)
      {
        this.L.d();
        this.L = null;
      }
      A();
      z();
      AppMethodBeat.o(16161);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(16161);
    }
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(16106);
    super.setID(paramString);
    if (this.h != null) {
      this.h.setID(paramString);
    }
    if (this.l != null) {
      this.l.setID(paramString);
    }
    if (this.d != null) {
      this.d.setID(paramString);
    }
    if (this.c != null) {
      this.c.a(getID());
    }
    TXCLog.w("TXCCaptureAndEnc", "setID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(16106);
  }
  
  public void t()
  {
    AppMethodBeat.i(16176);
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    if (this.d != null) {
      this.d.b();
    }
    if (this.K != null)
    {
      this.K.d();
      this.K = null;
    }
    if (this.M != null)
    {
      this.M.d();
      this.M = null;
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
    A();
    z();
    if (this.U != null)
    {
      l locall = (l)this.U.get();
      if (locall != null) {
        locall.a();
      }
    }
    AppMethodBeat.o(16176);
  }
  
  public void u()
  {
    AppMethodBeat.i(16182);
    if (this.h == null)
    {
      AppMethodBeat.o(16182);
      return;
    }
    if (this.c != null)
    {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15527);
          c.f(c.this);
          c.h(c.this);
          AppMethodBeat.o(15527);
        }
      });
      AppMethodBeat.o(16182);
      return;
    }
    A();
    z();
    AppMethodBeat.o(16182);
  }
  
  public void v()
  {
    AppMethodBeat.i(16183);
    if (this.h == null)
    {
      AppMethodBeat.o(16183);
      return;
    }
    if (this.c != null)
    {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(15555);
          c.f(c.this);
          AppMethodBeat.o(15555);
        }
      });
      AppMethodBeat.o(16183);
      return;
    }
    A();
    AppMethodBeat.o(16183);
  }
  
  public void w()
  {
    AppMethodBeat.i(16184);
    if (this.l == null)
    {
      AppMethodBeat.o(16184);
      return;
    }
    if (this.c != null)
    {
      this.c.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16729);
          c.h(c.this);
          AppMethodBeat.o(16729);
        }
      });
      AppMethodBeat.o(16184);
      return;
    }
    z();
    AppMethodBeat.o(16184);
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