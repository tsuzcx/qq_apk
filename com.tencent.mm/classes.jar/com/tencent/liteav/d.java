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
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.basic.opengl.n;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.d.d;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class d
  extends com.tencent.liteav.basic.module.a
  implements b.b, com.tencent.liteav.basic.c.b, com.tencent.liteav.beauty.f, l, e
{
  private final Object A;
  private Surface B;
  private int C;
  private int D;
  private com.tencent.liteav.basic.opengl.g E;
  private com.tencent.liteav.basic.structs.b F;
  private int G;
  private boolean H;
  private boolean I;
  private volatile boolean J;
  private long K;
  private long L;
  private int M;
  private WeakReference<o> N;
  private boolean O;
  private WeakReference<a> P;
  private j Q;
  private j R;
  private j S;
  private com.tencent.liteav.beauty.b.k T;
  private int U;
  private boolean V;
  private boolean W;
  private boolean X;
  private final com.tencent.liteav.beauty.b Y;
  private boolean Z;
  b a;
  private WeakReference<m> aa;
  private com.tencent.liteav.basic.opengl.f ab;
  private WeakReference<com.tencent.liteav.basic.c.b> ac;
  private int ad;
  private int ae;
  b b;
  private final com.tencent.liteav.basic.util.c c;
  private final com.tencent.liteav.basic.util.f d;
  private k e;
  private com.tencent.liteav.beauty.d f;
  private boolean g;
  private boolean h;
  private TXSVideoEncoderParam i;
  private com.tencent.liteav.videoencoder.b j;
  private int k;
  private boolean l;
  private TXSVideoEncoderParam m;
  private com.tencent.liteav.videoencoder.b n;
  private final Object o;
  private Context p;
  private g q;
  private com.tencent.liteav.basic.structs.c r;
  private int s;
  private int t;
  private int u;
  private boolean v;
  private int w;
  private int x;
  private boolean y;
  private TXCloudVideoView z;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(14385);
    this.c = new com.tencent.liteav.basic.util.c("capturer", (int)TimeUnit.SECONDS.toMillis(5L));
    this.d = new com.tencent.liteav.basic.util.f(Looper.getMainLooper());
    this.e = null;
    this.f = null;
    this.g = false;
    this.h = false;
    this.i = null;
    this.j = null;
    this.k = 8;
    this.l = false;
    this.m = null;
    this.n = null;
    this.o = new Object();
    this.p = null;
    this.q = null;
    this.r = com.tencent.liteav.basic.structs.c.b;
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = false;
    this.w = 0;
    this.x = 0;
    this.y = false;
    this.z = null;
    this.A = new Object();
    this.B = null;
    this.C = 0;
    this.D = 0;
    this.E = null;
    this.G = 0;
    this.H = false;
    this.I = false;
    this.J = false;
    this.K = 0L;
    this.L = 0L;
    this.M = 2;
    this.O = false;
    this.P = null;
    this.Q = null;
    this.U = -1;
    this.V = false;
    this.W = false;
    this.X = false;
    this.Z = true;
    this.ab = null;
    this.ad = 0;
    this.ae = 0;
    this.p = paramContext.getApplicationContext();
    this.q = new g();
    this.f = new com.tencent.liteav.beauty.d(this.p, true);
    this.f.a(this);
    this.f.a(this);
    if (this.q.V) {
      this.f.a(d.d.a);
    }
    for (;;)
    {
      this.i = new TXSVideoEncoderParam();
      this.i.encoderMode = 1;
      this.j = null;
      this.m = new TXSVideoEncoderParam();
      this.m.encoderMode = 1;
      this.a = new b(this);
      this.Y = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.license.g(this.p));
      this.Y.setPreprocessor(this.f);
      com.tencent.liteav.basic.d.c.a().a(this.p);
      AppMethodBeat.o(14385);
      return;
      if (this.q.U) {
        this.f.a(d.d.b);
      } else {
        this.f.a(d.d.c);
      }
    }
  }
  
  private void A()
  {
    AppMethodBeat.i(245926);
    try
    {
      com.tencent.liteav.videoencoder.b localb = this.n;
      this.n = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      AppMethodBeat.o(245926);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", localException);
      AppMethodBeat.o(245926);
    }
  }
  
  private void B()
  {
    AppMethodBeat.i(245927);
    try
    {
      TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
      com.tencent.liteav.videoencoder.b localb = this.j;
      this.j = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      this.W = true;
      AppMethodBeat.o(245927);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", localException);
      AppMethodBeat.o(245927);
    }
  }
  
  private void C()
  {
    AppMethodBeat.i(245929);
    if (this.e != null) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(242645);
          d.a(d.this, d.c(d.this).width, d.c(d.this).height);
          AppMethodBeat.o(242645);
        }
      });
    }
    AppMethodBeat.o(245929);
  }
  
  private void D()
  {
    AppMethodBeat.i(245931);
    if (this.f != null)
    {
      if (this.q.V)
      {
        this.f.a(d.d.a);
        AppMethodBeat.o(245931);
        return;
      }
      if (this.q.U)
      {
        this.f.a(d.d.b);
        AppMethodBeat.o(245931);
        return;
      }
      this.f.a(d.d.c);
    }
    AppMethodBeat.o(245931);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(245921);
    paramInt2 = this.q.a;
    paramInt1 = this.q.b;
    if ((this.q.m == 0) || (this.q.m == 2))
    {
      paramInt2 = this.q.b;
      paramInt1 = this.q.a;
    }
    if ((paramInt2 <= 0) || (paramInt1 <= 0))
    {
      TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
      AppMethodBeat.o(245921);
      return -1;
    }
    if (this.q.N)
    {
      B();
      AppMethodBeat.o(245921);
      return -1000;
    }
    b(paramInt2, paramInt1, paramObject);
    AppMethodBeat.o(245921);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(245920);
    if (paramLong == 0L) {
      paramLong = TXCTimeUtil.generatePtsMS();
    }
    for (;;)
    {
      b(paramInt2, paramInt3, this.f.a());
      com.tencent.liteav.videoencoder.b localb = this.j;
      if (localb != null)
      {
        localb.b(this.Z);
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      localb = this.n;
      if (localb != null)
      {
        localb.b(this.Z);
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      AppMethodBeat.o(245920);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(245918);
    TXCLog.i("TXCCaptureAndEnc", "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3 + " eglContext: " + paramObject);
    B();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.G, Integer.valueOf(paramInt3));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt3 == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.G);
      this.W = false;
      this.i.encodeType = paramInt3;
      this.i.width = paramInt1;
      this.i.height = paramInt2;
      this.i.fps = paramInt4;
      this.i.gop = this.q.j;
      this.i.encoderProfile = this.q.o;
      localTXSVideoEncoderParam = this.i;
      if (paramObject == null) {
        break label591;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.i.realTime = paramBoolean;
      this.i.streamType = this.G;
      this.i.annexb = this.I;
      this.i.bMultiRef = this.H;
      this.i.baseFrameIndex = (this.K + 20L);
      this.i.baseGopIndex = ((this.L + 1L) % 255L + 1L);
      this.i.bLimitFps = this.h;
      this.i.record = this.X;
      this.i.encFmt = this.q.Z;
      this.i.isH265EncoderEnabled = this.J;
      this.i.bitrate = this.q.c;
      localb.a(this);
      localb.a(this);
      localb.a(this.i);
      localb.c(this.q.c);
      localb.d(this.k);
      localb.setID(getID());
      localb.a(this.ad);
      localb.a(this.r);
      this.j = localb;
      TXCStatus.a(getID(), 4003, this.G, Integer.valueOf(this.i.width << 16 | this.i.height));
      TXCStatus.a(getID(), 13003, this.G, Integer.valueOf(this.i.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.i.width, this.i.height, "", this.G);
      TXCKeyPointReportProxy.a(40036, this.i.encodeType, this.G);
      TXCKeyPointReportProxy.a(40037, this.i.width << 16 | this.i.height, this.G);
      AppMethodBeat.o(245918);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.G);
      break;
      label591:
      paramObject = localb.a(paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(245902);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.h.a(this.ac, paramInt, localBundle);
    int i1;
    if (paramInt == -1314)
    {
      paramString = getID();
      i1 = 2002;
      l1 = 5L;
      TXCEventRecorderProxy.a(paramString, i1, l1, -1L, "", this.G);
      label119:
      if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
      {
        TXCKeyPointReportProxy.b(30003, paramInt);
        if (this.e != null)
        {
          paramString = getID();
          if (!this.e.l()) {
            break label253;
          }
        }
      }
    }
    label253:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.G);
      AppMethodBeat.o(245902);
      return;
      if ((paramInt != 1003) || (this.e == null)) {
        break label119;
      }
      paramString = getID();
      i1 = 4001;
      if (this.e.l())
      {
        l1 = 0L;
        break;
      }
      l1 = 1L;
      break;
    }
  }
  
  private void a(com.tencent.liteav.basic.structs.b paramb, int paramInt1, int paramInt2, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(245907);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.u == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(245907);
          return;
        }
        paramb.e = paramInt1;
        paramb.f = paramInt2;
        paramb.i = this.q.T;
        if (this.q.m == 0)
        {
          paramb.g = this.q.b;
          paramb.h = this.q.a;
          paramb.l = com.tencent.liteav.basic.util.h.a(paramb.e, paramb.f, paramb.g, paramb.h);
        }
      }
      try
      {
        this.f.a(this.q.m);
        this.f.a(paramObject);
        this.f.a(paramb, paramb.b, 0, paramLong);
        AppMethodBeat.o(245907);
        return;
        paramb.g = this.q.a;
        paramb.h = this.q.b;
        continue;
        paramb = finally;
        AppMethodBeat.o(245907);
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
    AppMethodBeat.i(245934);
    e(paramb.e, paramb.f);
    this.F = paramb;
    if (this.z != null)
    {
      if (this.e != null)
      {
        this.e.a(paramb);
        AppMethodBeat.o(245934);
      }
    }
    else {
      synchronized (this.A)
      {
        if ((this.B != null) && (this.E == null) && (this.e != null) && (this.e.f() != null))
        {
          this.E = new com.tencent.liteav.basic.opengl.g();
          this.E.a(this.e.f(), this.B);
          this.E.a(this.x);
          this.E.b(this.ae);
        }
        if ((this.E != null) && (this.e != null)) {
          this.E.a(paramb.a, paramb.i, this.w, this.C, this.D, paramb.e, paramb.f, paramBoolean, this.e.l());
        }
        AppMethodBeat.o(245934);
        return;
      }
    }
    AppMethodBeat.o(245934);
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(245919);
    A();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
      localTXSVideoEncoderParam = this.m;
      if (paramObject == null) {
        break label262;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.m.encodeType = paramInt;
      this.m.realTime = paramBoolean;
      this.m.isH265EncoderEnabled = false;
      TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
      localb.a(this);
      localb.a(this);
      localb.a(this.m);
      localb.c(this.m.bitrate);
      localb.setID(getID());
      localb.a(this.ad);
      localb.a(this.r);
      this.n = localb;
      TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.m.width << 16 | this.m.height));
      TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.m.gop * 1000));
      AppMethodBeat.o(245919);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
      break;
      label262:
      paramObject = localb.a(this.m.width, this.m.height);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(245939);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.a(paramRunnable);
      AppMethodBeat.o(245939);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(245939);
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i2 = 2;
    AppMethodBeat.i(245922);
    int i1 = i2;
    switch (this.q.k)
    {
    default: 
      i1 = i2;
    case 0: 
      if ((this.s == 1) && (this.t == 0)) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      i2 = this.q.j;
      if ((this.j == null) || (this.W) || (this.i.width != paramInt1) || (this.i.height != paramInt2) || (this.i.encodeType != i1) || (this.i.gop != i2) || (this.J != this.i.isH265EncoderEnabled)) {
        a(paramInt1, paramInt2, i1, paramObject, this.q.i, this.q.Q);
      }
      if (((this.n == null) || (this.m.encodeType != i1)) && (this.l)) {
        a(paramObject, i1, this.q.Q);
      }
      AppMethodBeat.o(245922);
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(245935);
    if (this.O)
    {
      i1 = paramb.a;
      AppMethodBeat.o(245935);
      return i1;
    }
    int i1 = paramb.a;
    int i7;
    j localj;
    if (this.ae == 1)
    {
      i7 = 1;
      if (i7 == paramb.i) {
        break label398;
      }
      if (this.R == null)
      {
        localj = new j();
        localj.a();
        localj.a(true);
        localj.a(paramb.e, paramb.f);
        if (paramb.e <= paramb.f) {
          break label373;
        }
        localj.h();
        label108:
        this.R = localj;
      }
      localj = this.R;
      if (localj == null) {
        break label398;
      }
      localj.a(paramb.e, paramb.f);
      i1 = localj.b(paramb.a);
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
      if (this.w != 0)
      {
        if (this.S == null)
        {
          localj = new j();
          localj.a();
          localj.a(true);
          localj.a(paramb.e, paramb.f);
          this.S = localj;
        }
        localj = this.S;
        i2 = i1;
        if (localj != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          i4 = paramb.e;
          i5 = paramb.f;
          arrayOfFloat = localj.a(i4, i5, null, com.tencent.liteav.basic.util.h.a(i4, i5, paramb.e, paramb.f), 0);
          i6 = (720 - this.w) % 360;
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
        localj.a(i4, i5, i6, arrayOfFloat, i2 / i3, false, false);
        localj.b(i1);
        i2 = localj.l();
        AppMethodBeat.o(245935);
        return i2;
        i7 = 0;
        break;
        label373:
        localj.g();
        break label108;
        label381:
        i2 = paramb.e;
        break label304;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245930);
    com.tencent.liteav.beauty.d locald;
    Bitmap localBitmap;
    float f3;
    float f2;
    float f1;
    if (this.q.K != -1.0F) {
      if (this.f != null)
      {
        locald = this.f;
        localBitmap = this.q.F;
        f3 = this.q.I;
        f2 = this.q.J;
        f1 = this.q.K;
      }
    }
    for (;;)
    {
      locald.a(localBitmap, f3, f2, f1);
      do
      {
        AppMethodBeat.o(245930);
        return;
      } while ((this.f == null) || (paramInt1 == 0) || (paramInt2 == 0));
      locald = this.f;
      localBitmap = this.q.F;
      f3 = this.q.G / paramInt1;
      f2 = this.q.H / paramInt2;
      if (this.q.F == null) {
        f1 = 0.0F;
      } else {
        f1 = this.q.F.getWidth() / paramInt1;
      }
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245932);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(245932);
  }
  
  private void d(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(245936);
    Object localObject1 = this.N;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (o)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(245936);
      return;
    }
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = paramb.e;
    localTXSVideoFrame.height = paramb.f;
    localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
    int i1 = c(paramb);
    if (this.M == 5)
    {
      localTXSVideoFrame.textureId = i1;
      localTXSVideoFrame.eglContext = this.f.a();
      if (this.U == -1)
      {
        this.U = TXCOpenGlUtils.d();
        TXCLog.i("TXCCaptureAndEnc", "create FrameBuffer: %d", new Object[] { Integer.valueOf(this.U) });
      }
      TXCOpenGlUtils.a(localTXSVideoFrame.textureId, this.U);
      GLES20.glBindFramebuffer(36160, this.U);
      ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
      TXCOpenGlUtils.d(this.U);
      if (this.O)
      {
        if (localTXSVideoFrame.data == null) {
          break label274;
        }
        localObject1 = ByteBuffer.wrap(localTXSVideoFrame.data);
        ((ByteBuffer)localObject1).position(0);
        paramb.a = TXCOpenGlUtils.a((ByteBuffer)localObject1, paramb.e, paramb.f, i1);
      }
    }
    label274:
    label344:
    Object localObject2;
    label385:
    label418:
    do
    {
      do
      {
        for (;;)
        {
          if ((this.O) && (this.z != null))
          {
            paramb = this.z.getGLSurfaceView();
            if (paramb != null) {
              paramb.d();
            }
          }
          AppMethodBeat.o(245936);
          return;
          localObject1 = localTXSVideoFrame.buffer;
          break;
          if (this.M != 2) {
            break label344;
          }
          localTXSVideoFrame.textureId = i1;
          localTXSVideoFrame.eglContext = this.f.a();
          ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
          if (this.O) {
            paramb.a = localTXSVideoFrame.textureId;
          }
        }
      } while ((this.M != 1) && (this.M != 4));
      if (this.Q == null)
      {
        if (this.M != 1) {
          break label634;
        }
        localObject2 = new com.tencent.liteav.beauty.b.o(1);
        ((j)localObject2).a(true);
        if (!((j)localObject2).a()) {
          break label647;
        }
        ((j)localObject2).a(paramb.e, paramb.f);
        this.Q = ((j)localObject2);
      }
      localObject2 = this.Q;
      if (localObject2 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((j)localObject2).a(paramb.e, paramb.f);
        ((j)localObject2).b(i1);
        GLES20.glBindFramebuffer(36160, ((j)localObject2).m());
        ((o)localObject1).onRenderVideoFrame(getID(), this.G, localTXSVideoFrame);
      }
    } while ((!this.O) || ((localTXSVideoFrame.data == null) && (localTXSVideoFrame.buffer == null)));
    if (this.M == 1) {
      i1 = 1;
    }
    for (;;)
    {
      label522:
      if (this.T == null)
      {
        localObject1 = new com.tencent.liteav.beauty.b.k(i1);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
        if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
          TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
        }
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        this.T = ((com.tencent.liteav.beauty.b.k)localObject1);
      }
      localObject1 = this.T;
      GLES20.glViewport(0, 0, paramb.e, paramb.f);
      ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
      if (localTXSVideoFrame.data != null) {
        ((com.tencent.liteav.beauty.b.k)localObject1).a(localTXSVideoFrame.data);
      }
      for (;;)
      {
        paramb.a = ((com.tencent.liteav.beauty.b.k)localObject1).r();
        break;
        label634:
        localObject2 = new com.tencent.liteav.beauty.b.o(3);
        break label385;
        label647:
        TXCLog.i("TXCCaptureAndEnc", "init filter error ");
        this.Q = null;
        break label418;
        if (this.M != 4) {
          break label689;
        }
        i1 = 3;
        break label522;
        ((com.tencent.liteav.beauty.b.k)localObject1).a(localTXSVideoFrame.buffer);
      }
      label689:
      i1 = 1;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245933);
    if (!this.y)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", getID());
      localBundle.putInt("EVT_ID", 2003);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      localBundle.putCharSequence("EVT_MSG", "Renders the first video frame");
      localBundle.putInt("EVT_PARAM1", paramInt1);
      localBundle.putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.h.a(this.ac, 2003, localBundle);
      TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.G);
      this.y = true;
    }
    AppMethodBeat.o(245933);
  }
  
  private void l(final boolean paramBoolean)
  {
    AppMethodBeat.i(245880);
    if (this.e == null)
    {
      AppMethodBeat.o(245880);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(219881);
        if (d.m(d.this) != null) {
          d.m(d.this).b();
        }
        AppMethodBeat.o(219881);
      }
    });
    u();
    this.e.a(paramBoolean);
    this.e = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.z;
    this.d.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(231172);
        if (this.a != null) {
          this.a.stop(paramBoolean);
        }
        AppMethodBeat.o(231172);
      }
    });
    this.z = null;
    synchronized (this.A)
    {
      this.B = null;
      if (this.E != null)
      {
        this.E.a();
        this.E = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.v) {
        x();
      }
      AppMethodBeat.o(245880);
      return;
    }
  }
  
  private void m(final boolean paramBoolean)
  {
    AppMethodBeat.i(245928);
    if (this.e != null) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(242690);
          k localk = d.f(d.this);
          if (localk == null)
          {
            AppMethodBeat.o(242690);
            return;
          }
          localk.f(d.e(d.this).i);
          localk.e(d.e(d.this).m);
          localk.a(d.e(d.this).l);
          localk.b(d.e(d.this).a, d.e(d.this).b);
          localk.e(d.e(d.this).V);
          if ((paramBoolean) && (localk.d())) {
            localk.b(false);
          }
          AppMethodBeat.o(242690);
        }
      });
    }
    AppMethodBeat.o(245928);
  }
  
  private void x()
  {
    AppMethodBeat.i(245860);
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new b(this);
    }
    this.b.a(10, -1, null, 64, 64);
    AppMethodBeat.o(245860);
  }
  
  private void y()
  {
    AppMethodBeat.i(245862);
    TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.v);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(245862);
  }
  
  private void z()
  {
    m localm = null;
    AppMethodBeat.i(245917);
    if (this.U != -1)
    {
      TXCLog.i("TXCCaptureAndEnc", "destroy FrameBuffer: %d", new Object[] { Integer.valueOf(this.U) });
      TXCOpenGlUtils.b(this.U);
      this.U = -1;
    }
    if (this.ab != null)
    {
      this.ab.e();
      this.ab = null;
    }
    if (this.aa != null) {
      localm = (m)this.aa.get();
    }
    if (localm != null) {
      localm.onGLContextReadyToDestory();
    }
    AppMethodBeat.o(245917);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(245905);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.u == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(245905);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, paramObject);
        if (i1 != 0)
        {
          AppMethodBeat.o(245905);
          return i1;
        }
        if (paramLong == 0L)
        {
          paramLong = TXCTimeUtil.generatePtsMS();
          paramObject = this.j;
          if (paramObject != null)
          {
            paramObject.a(this.q.T);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
          paramObject = this.n;
          if (paramObject != null)
          {
            paramObject.a(this.q.T);
            paramObject.a(paramInt1, paramInt2, paramInt3, paramLong);
          }
          AppMethodBeat.o(245905);
          return 0;
        }
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(245906);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.a = paramInt1;
    localb.b = 0;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(245906);
    return 0;
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(245908);
    if (this.aa != null) {}
    for (m localm = (m)this.aa.get();; localm = null)
    {
      if (localm != null)
      {
        if ((this.ab == null) || (this.ab.c() != paramb.e) || (this.ab.d() != paramb.f))
        {
          if (this.ab != null) {
            this.ab.e();
          }
          this.ab = new com.tencent.liteav.basic.opengl.f(paramb.e, paramb.f);
          this.ab.a();
        }
        paramb.a = localm.onProcessVideoFrame(paramb.a, paramb.e, paramb.f, this.ab.b());
        GLES20.glDisable(3042);
        GLES20.glDisable(2929);
      }
      d(paramb);
      a(paramb, false);
      int i1 = paramb.a;
      AppMethodBeat.o(245908);
      return i1;
    }
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(245872);
    int i1;
    if ((this.m.width != paramInt1) || (this.m.height != paramInt2))
    {
      i1 = 1;
      this.m.width = paramInt1;
      this.m.height = paramInt2;
      this.m.fps = paramInt3;
      this.m.gop = paramInt5;
      this.m.encoderProfile = 1;
      this.m.realTime = this.q.Q;
      this.m.streamType = 3;
      this.m.bitrate = paramInt4;
      this.m.annexb = true;
      this.m.bMultiRef = false;
      if ((this.n != null) && ((i1 != 0) || ((this.l) && (!paramBoolean))))
      {
        if (this.e == null) {
          break label186;
        }
        this.e.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(219803);
            d.i(d.this);
            AppMethodBeat.o(219803);
          }
        });
      }
    }
    for (;;)
    {
      this.l = paramBoolean;
      AppMethodBeat.o(245872);
      return 0;
      i1 = 0;
      break;
      label186:
      A();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(245903);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.u == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(245903);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, null);
        if (i1 != 0)
        {
          AppMethodBeat.o(245903);
          return i1;
        }
        com.tencent.liteav.videoencoder.b localb = this.j;
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
          AppMethodBeat.o(245903);
          return 0;
        }
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(245904);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.m = paramArrayOfByte;
    localb.b = paramInt1;
    localb.d = true;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(245904);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(14386);
    TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
    if (this.P == null)
    {
      AppMethodBeat.o(14386);
      return;
    }
    a locala = (a)this.P.get();
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
    AppMethodBeat.i(245896);
    if (this.e == null)
    {
      AppMethodBeat.o(245896);
      return;
    }
    this.e.a(paramFloat);
    AppMethodBeat.o(245896);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(245937);
    if ((this.e != null) && (this.q.L)) {
      this.e.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(245937);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(245849);
    TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(paramInt)));
    this.ad = paramInt;
    if (this.e != null)
    {
      this.e.a(new Runnable()
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
      AppMethodBeat.o(245849);
      return;
    }
    com.tencent.liteav.videoencoder.b localb = this.j;
    if (localb != null) {
      localb.a(paramInt);
    }
    localb = this.n;
    if (localb != null) {
      localb.a(paramInt);
    }
    AppMethodBeat.o(245849);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(245875);
    synchronized (this.A)
    {
      if (this.E != null)
      {
        this.E.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(230856);
            d.b(d.this, paramInt1);
            d.c(d.this, paramInt2);
            if ((d.k(d.this) != null) && (d.l(d.this) != null)) {
              d.a(d.this, d.k(d.this), true);
            }
            AppMethodBeat.o(230856);
          }
        });
        AppMethodBeat.o(245875);
        return;
      }
      this.C = paramInt1;
      this.D = paramInt2;
    }
  }
  
  public void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(245867);
    if (this.e == null)
    {
      AppMethodBeat.o(245867);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(230035);
        if ((paramInt2 != 0) && (paramInt3 != 0))
        {
          d.e(d.this).a = paramInt2;
          d.e(d.this).b = paramInt3;
          if (d.f(d.this) != null)
          {
            d.f(d.this).a(com.tencent.liteav.basic.b.c.a);
            d.f(d.this).b(paramInt2, paramInt3);
          }
        }
        if ((paramInt1 != 0) && (d.a(d.this) != null))
        {
          d.e(d.this).c = paramInt1;
          d.a(d.this).c(paramInt1);
        }
        AppMethodBeat.o(230035);
      }
    });
    AppMethodBeat.o(245867);
  }
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, int paramInt7, final boolean paramBoolean)
  {
    AppMethodBeat.i(245864);
    if (paramInt1 == 2)
    {
      if ((this.i.width != 0) && (this.i.height != 0) && ((paramInt2 != this.i.width) || (paramInt3 != this.i.height) || (paramInt4 > this.i.fps) || (paramBoolean != this.J))) {
        if (this.e != null) {
          this.e.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(222081);
              label130:
              Object localObject;
              if ((paramInt2 != d.c(d.this).width) || (paramInt3 != d.c(d.this).height) || (paramInt4 > d.c(d.this).fps))
              {
                i = 1;
                int j = i;
                if (!paramBoolean)
                {
                  j = i;
                  if (d.d(d.this))
                  {
                    TXCLog.i("TXCCaptureAndEnc", "disable h265 encoder from QoS. prepare to restart.");
                    d.a(d.this, false);
                    j = 1;
                  }
                }
                if (j != 0)
                {
                  TXCLog.i("TXCCaptureAndEnc", "restart encoder when QoS changed.");
                  if (paramInt2 <= paramInt3) {
                    break label390;
                  }
                  d.e(d.this).m = 0;
                  localObject = d.e(d.this);
                  if (paramInt2 <= paramInt3) {
                    break label415;
                  }
                  i = paramInt3;
                  label154:
                  ((g)localObject).a = i;
                  localObject = d.e(d.this);
                  if (paramInt2 <= paramInt3) {
                    break label423;
                  }
                }
              }
              label390:
              label415:
              label423:
              for (int i = paramInt2;; i = paramInt3)
              {
                ((g)localObject).b = i;
                localObject = d.f(d.this);
                if (localObject != null)
                {
                  ((k)localObject).a(com.tencent.liteav.basic.b.c.a);
                  ((k)localObject).b(paramInt2, paramInt3);
                  ((k)localObject).e(d.e(d.this).m);
                }
                d.e(d.this).c = paramInt5;
                d.e(d.this).i = paramInt4;
                d.g(d.this);
                TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.c(d.this).width), Integer.valueOf(d.c(d.this).height), Integer.valueOf(d.c(d.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
                AppMethodBeat.o(222081);
                return;
                i = 0;
                break;
                if (paramInt2 >= paramInt3) {
                  break label130;
                }
                d.e(d.this).m = 1;
                break label130;
                i = paramInt2;
                break label154;
              }
            }
          });
        }
      }
      for (;;)
      {
        d(paramInt7);
        AppMethodBeat.o(245864);
        return;
        if (this.J != paramBoolean)
        {
          localObject1 = this.o;
          if (!paramBoolean) {}
          try
          {
            if (this.J) {
              this.J = false;
            }
            continue;
          }
          finally
          {
            AppMethodBeat.o(245864);
          }
          localObject1 = this.j;
          if (localObject1 != null)
          {
            ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt5, paramInt6);
            ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt4);
          }
        }
      }
    }
    if ((this.m != null) && ((paramInt2 != this.m.width) || (paramInt3 != this.m.height)) && (this.e != null)) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(245114);
          TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.h(d.this).width), Integer.valueOf(d.h(d.this).height), Integer.valueOf(d.h(d.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
          d.h(d.this).width = paramInt2;
          d.h(d.this).height = paramInt3;
          d.i(d.this);
          AppMethodBeat.o(245114);
        }
      });
    }
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt5, paramInt6);
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt4);
    }
    AppMethodBeat.o(245864);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 2)
    {
      this.L = paramLong1;
      this.K = paramLong2;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(245887);
    this.q.F = paramBitmap;
    this.q.I = paramFloat1;
    this.q.J = paramFloat2;
    this.q.K = paramFloat3;
    C();
    AppMethodBeat.o(245887);
  }
  
  public void a(final Bitmap paramBitmap, final ByteBuffer paramByteBuffer, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(245914);
    paramBitmap = new Runnable()
    {
      public void run()
      {
        int i = 1;
        AppMethodBeat.i(244782);
        for (;;)
        {
          try
          {
            Object localObject;
            if (((d.n(d.this) == 2) || (d.o(d.this))) && (paramBitmap != null))
            {
              localObject = paramByteBuffer;
              if (localObject != null) {}
            }
            else
            {
              AppMethodBeat.o(244782);
              return;
            }
            if (!d.c(d.this).isH265EncoderEnabled)
            {
              if (d.c(d.this).encodeType != 2)
              {
                if ((d.a(d.this) == null) || (d.p(d.this)) || (d.c(d.this).width != paramInt1) || (d.c(d.this).height != paramInt2) || (i != 0) || (d.c(d.this).gop != d.e(d.this).j) || (d.d(d.this) != d.c(d.this).isH265EncoderEnabled))
                {
                  if (d.c(d.this).isH265EncoderEnabled) {
                    d.a(d.this, paramInt1, paramInt2, d.c(d.this).encodeType, null, d.e(d.this).D, true);
                  }
                }
                else
                {
                  if (((d.b(d.this) == null) || (d.h(d.this).encodeType != 2)) && (d.q(d.this))) {
                    d.a(d.this, null, 2, true);
                  }
                  i = paramBitmap.getWidth();
                  int j = paramBitmap.getHeight();
                  localObject = d.a(d.this);
                  if (localObject != null) {
                    ((com.tencent.liteav.videoencoder.b)localObject).a(paramByteBuffer.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
                  }
                  localObject = d.b(d.this);
                  if (localObject != null) {
                    ((com.tencent.liteav.videoencoder.b)localObject).a(paramByteBuffer.array(), 2, i, j, TXCTimeUtil.generatePtsMS());
                  }
                  AppMethodBeat.o(244782);
                }
              }
              else
              {
                i = 0;
                continue;
              }
              d.a(d.this, paramInt1, paramInt2, 2, null, d.e(d.this).D, true);
              continue;
            }
            i = 0;
          }
          catch (Exception localException)
          {
            TXCLog.e("TXCCaptureAndEnc", "onPushBitmap failed." + localException.getMessage());
            AppMethodBeat.o(244782);
            return;
          }
        }
      }
    };
    paramByteBuffer = this.e;
    if (paramByteBuffer != null)
    {
      paramByteBuffer.a(paramBitmap);
      AppMethodBeat.o(245914);
      return;
    }
    paramBitmap.run();
    AppMethodBeat.o(245914);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(245915);
    if (this.f != null) {
      this.f.b();
    }
    if (this.aa != null) {}
    for (paramSurfaceTexture = (m)this.aa.get();; paramSurfaceTexture = null)
    {
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.onGLContextCreated();
      }
      AppMethodBeat.o(245915);
      return;
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(245911);
    if (this.P == null)
    {
      AppMethodBeat.o(245911);
      return;
    }
    a locala = (a)this.P.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(245911);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(245874);
    if (this.z != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      AppMethodBeat.o(245874);
      return;
    }
    synchronized (this.A)
    {
      if (this.B != paramSurface)
      {
        TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
        this.B = paramSurface;
        if (this.E != null)
        {
          this.E.a();
          this.E = null;
        }
        AppMethodBeat.o(245874);
        return;
      }
      TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface the same".concat(String.valueOf(paramSurface)));
    }
  }
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(245845);
    this.ac = new WeakReference(paramb);
    AppMethodBeat.o(245845);
  }
  
  public void a(final p paramp)
  {
    AppMethodBeat.i(245876);
    if (this.z != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.z.getGLSurfaceView();
      if (localTXCGLSurfaceView != null)
      {
        localTXCGLSurfaceView.a(new p()
        {
          public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(242210);
            if (paramp != null) {
              paramp.onTakePhotoComplete(paramAnonymousBitmap);
            }
            AppMethodBeat.o(242210);
          }
        });
        AppMethodBeat.o(245876);
        return;
      }
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
      }
      AppMethodBeat.o(245876);
      return;
    }
    if (this.E != null)
    {
      this.E.a(new p()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(221776);
          if (paramp != null) {
            paramp.onTakePhotoComplete(paramAnonymousBitmap);
          }
          AppMethodBeat.o(221776);
        }
      });
      AppMethodBeat.o(245876);
      return;
    }
    if (paramp != null) {
      paramp.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(245876);
  }
  
  public void a(TXSNALPacket arg1, int paramInt)
  {
    int i1 = 1;
    AppMethodBeat.i(245910);
    Object localObject1;
    if (paramInt == 0)
    {
      if (???.streamType == 2)
      {
        this.L = ???.gopIndex;
        this.K = ???.frameIndex;
      }
      if (this.P == null)
      {
        AppMethodBeat.o(245910);
        return;
      }
      localObject1 = (a)this.P.get();
      if (localObject1 != null) {
        ((a)localObject1).onEncVideo(???);
      }
      AppMethodBeat.o(245910);
      return;
    }
    if (((paramInt == 10000004) || (paramInt == 10000005) || (paramInt == 10000006)) && (this.i.encodeType == 1))
    {
      TXCLog.i("TXCCaptureAndEnc", "onEncodeNal mEnableHEVCEncode " + this.J + " errCode= " + paramInt);
      if (this.J)
      {
        ??? = Locale.getDefault();
        localObject1 = TXCCommonUtil.getDeviceInfo();
        if (com.tencent.liteav.videoencoder.c.a(1920, 1080, 20))
        {
          Monitor.a(2, String.format(???, "VideoEncoder: h265 hardware encoder error %d, switch to 264 encoder. %s, %d", new Object[] { Integer.valueOf(paramInt), localObject1, Integer.valueOf(i1) }), "", 0);
          ??? = this.e;
          if (??? == null) {
            break label267;
          }
          ???.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(221784);
              d.a(d.this, false);
              d.g(d.this);
              d.i(d.this);
              AppMethodBeat.o(221784);
            }
          });
        }
        for (;;)
        {
          com.tencent.liteav.basic.util.h.a(this.ac, -2310, getID());
          AppMethodBeat.o(245910);
          return;
          i1 = 0;
          break;
          label267:
          synchronized (this.o)
          {
            this.J = false;
            B();
            A();
          }
        }
      }
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      u();
      this.t += 1;
      this.q.k = 0;
      a(1103, "Failed to enable hardware encoder, use software encoder");
    }
    AppMethodBeat.o(245910);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    AppMethodBeat.i(245909);
    a(paramb.a, paramb.e, paramb.f, paramLong);
    AppMethodBeat.o(245909);
  }
  
  public void a(com.tencent.liteav.basic.structs.c paramc)
  {
    AppMethodBeat.i(245838);
    this.r = paramc;
    com.tencent.liteav.videoencoder.b localb = this.j;
    if (localb != null) {
      localb.a(paramc);
    }
    localb = this.n;
    if (localb != null) {
      localb.a(paramc);
    }
    AppMethodBeat.o(245838);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(245839);
    this.P = new WeakReference(parama);
    AppMethodBeat.o(245839);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(245844);
    int i1;
    boolean bool1;
    label133:
    boolean bool2;
    if ((paramg != null) && ((this.q.F != paramg.F) || (this.q.G != paramg.G) || (this.q.H != paramg.H) || (this.q.K != paramg.K) || (this.q.I != paramg.I) || (this.q.J != paramg.J)))
    {
      i1 = 1;
      if ((paramg == null) || ((this.q.a == paramg.a) && (this.q.b == paramg.b))) {
        break label353;
      }
      bool1 = true;
      if ((paramg == null) || (this.q.a <= 0) || (this.q.b <= 0) || (paramg.a <= 0) || (paramg.b <= 0) || (Math.abs(this.q.a / this.q.b - paramg.a / paramg.b) <= 0.1D)) {
        break label358;
      }
      bool2 = true;
      if (paramg == null) {
        break label379;
      }
    }
    for (;;)
    {
      try
      {
        this.q = ((g)paramg.clone());
        TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", new Object[] { Integer.valueOf(this.q.a), Integer.valueOf(this.q.b), Integer.valueOf(this.q.m) }));
        if (this.e != null) {
          this.e.e(this.q.m);
        }
        D();
        if (!this.q.U) {
          break label393;
        }
        bool1 = false;
        m(bool1);
        if ((k()) && (i1 != 0)) {
          C();
        }
        AppMethodBeat.o(245844);
        return;
        i1 = 0;
        break;
        label353:
        bool1 = false;
        break label133;
        label358:
        bool2 = false;
      }
      catch (CloneNotSupportedException paramg)
      {
        this.q = new g();
        continue;
      }
      label379:
      this.q = new g();
      continue;
      label393:
      if (!this.q.V) {
        bool1 = bool2;
      }
    }
  }
  
  public void a(m paramm)
  {
    AppMethodBeat.i(245846);
    this.aa = new WeakReference(paramm);
    AppMethodBeat.o(245846);
  }
  
  public void a(o paramo, int paramInt)
  {
    AppMethodBeat.i(245842);
    this.M = paramInt;
    if (paramo != null)
    {
      this.N = new WeakReference(paramo);
      AppMethodBeat.o(245842);
      return;
    }
    this.N = null;
    AppMethodBeat.o(245842);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(245877);
    if (Build.VERSION.SDK_INT < 21)
    {
      parama = new Bundle();
      parama.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
      onNotifyEvent(-1309, parama);
      TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(245877);
      return;
    }
    this.s = 1;
    if (this.e == null)
    {
      this.e = new i(this.p, this.q, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.Y.a(false);
    j(this.G);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.a(getID());
    TXCDRApi.txReportDAU(this.p, com.tencent.liteav.basic.datareport.a.aH);
    AppMethodBeat.o(245877);
  }
  
  public void a(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(245870);
    if (this.q.N)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(245870);
      return;
    }
    if (this.a != null) {
      this.a.b();
    }
    this.y = false;
    boolean bool = this.q.X;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      final TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(242588);
          arrayOfTXCGLSurfaceView[0] = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
          paramTXCloudVideoView.addVideoView(arrayOfTXCGLSurfaceView[0]);
          AppMethodBeat.o(242588);
        }
      });
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    for (;;)
    {
      this.s = 0;
      this.e = new c(this.p, this.q, (n)localObject, bool);
      y();
      j(this.G);
      this.e.a(getID());
      this.e.a(this);
      this.e.a(this);
      this.e.a();
      this.e.b(this.w);
      this.e.c(this.x);
      this.e.d(this.ae);
      this.z = paramTXCloudVideoView;
      this.d.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(221752);
          if (paramTXCloudVideoView != null) {
            paramTXCloudVideoView.start(d.e(d.this).L, d.e(d.this).M, d.f(d.this));
          }
          AppMethodBeat.o(221752);
        }
      });
      this.y = false;
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(245870);
      return;
      localObject = new com.tencent.liteav.basic.opengl.h();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public TXBeautyManager b()
  {
    return this.Y;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(245850);
    TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(paramInt)));
    this.ae = paramInt;
    if (this.e != null) {
      this.e.d(this.ae);
    }
    if (this.E != null) {
      this.E.b(this.ae);
    }
    AppMethodBeat.o(245850);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(245894);
    if (this.e == null)
    {
      AppMethodBeat.o(245894);
      return;
    }
    this.e.a(paramInt1, paramInt2);
    AppMethodBeat.o(245894);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(245885);
    this.Y.setBeautyLevel(paramInt1);
    this.Y.setWhitenessLevel(paramInt2);
    this.Y.setRuddyLevel(paramInt3);
    AppMethodBeat.o(245885);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(245916);
    this.c.a();
    if (!this.V)
    {
      this.V = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.u == 2)
    {
      AppMethodBeat.o(245916);
      return;
    }
    k localk = this.e;
    if ((this.f != null) && (!this.q.N) && (localk != null))
    {
      if ((this.i.height != paramb.h) || (this.i.width != paramb.g)) {
        d(paramb.g, paramb.h);
      }
      this.f.a(localk.f());
      this.f.a(this.q.m);
      this.f.a(paramb, paramb.b, 0, 0L);
    }
    AppMethodBeat.o(245916);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(14405);
    this.Z = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "Is encoder need texture after glFinish: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(14405);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public g c()
  {
    return this.q;
  }
  
  public void c(final int paramInt)
  {
    AppMethodBeat.i(245866);
    if (this.e == null)
    {
      AppMethodBeat.o(245866);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245010);
        if (d.a(d.this) != null) {
          d.a(d.this).d(paramInt);
        }
        d.a(d.this, paramInt);
        AppMethodBeat.o(245010);
      }
    });
    AppMethodBeat.o(245866);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(245858);
    TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(paramBoolean)));
    this.v = paramBoolean;
    if (this.v)
    {
      if (this.e == null)
      {
        x();
        AppMethodBeat.o(245858);
      }
    }
    else {
      y();
    }
    AppMethodBeat.o(245858);
  }
  
  public int d()
  {
    return this.i.width;
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(245869);
    if (this.e == null)
    {
      AppMethodBeat.o(245869);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(242747);
        if (d.a(d.this) != null) {
          d.a(d.this).e(paramInt);
        }
        AppMethodBeat.o(242747);
      }
    });
    AppMethodBeat.o(245869);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(245871);
    l(paramBoolean);
    AppMethodBeat.o(245871);
  }
  
  public int e()
  {
    return this.i.height;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(245873);
    if (this.q.i == paramInt)
    {
      AppMethodBeat.o(245873);
      return;
    }
    this.q.i = paramInt;
    if ((this.e != null) && (this.e.g() < paramInt)) {
      switch (this.s)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(245873);
      return;
      m(true);
      u();
      AppMethodBeat.o(245873);
      return;
      this.e.f(paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public int f()
  {
    AppMethodBeat.i(245852);
    if (k())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.u);
      AppMethodBeat.o(245852);
      return -2;
    }
    TXCDRApi.initCrashReport(this.p);
    this.u = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    D();
    AppMethodBeat.o(245852);
    return 0;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(245882);
    TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(paramInt)));
    this.x = paramInt;
    if (this.e != null) {
      this.e.c(paramInt);
    }
    if (this.E != null) {
      this.E.a(this.x);
    }
    AppMethodBeat.o(245882);
  }
  
  public boolean f(boolean paramBoolean)
  {
    AppMethodBeat.i(245884);
    if (this.e == null)
    {
      AppMethodBeat.o(245884);
      return false;
    }
    paramBoolean = this.e.d(paramBoolean);
    AppMethodBeat.o(245884);
    return paramBoolean;
  }
  
  public void g()
  {
    AppMethodBeat.i(245854);
    if (!k())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.u);
      AppMethodBeat.o(245854);
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.u = 0;
    u();
    this.q.Q = false;
    if (this.a != null) {
      this.a.b();
    }
    c(false);
    this.F = null;
    AppMethodBeat.o(245854);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(245883);
    if (this.w != paramInt) {
      TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    }
    this.w = paramInt;
    if (this.e == null)
    {
      AppMethodBeat.o(245883);
      return;
    }
    this.e.b(paramInt);
    AppMethodBeat.o(245883);
  }
  
  public boolean g(boolean paramBoolean)
  {
    AppMethodBeat.i(245895);
    this.q.T = paramBoolean;
    if (this.e == null)
    {
      AppMethodBeat.o(245895);
      return false;
    }
    this.e.c(paramBoolean);
    AppMethodBeat.o(245895);
    return true;
  }
  
  public void h()
  {
    AppMethodBeat.i(245856);
    if (this.u != 1)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.u);
      AppMethodBeat.o(245856);
      return;
    }
    this.u = 2;
    TXCLog.i("TXCCaptureAndEnc", "pausePusher");
    if ((this.q.E & 0x1) == 1)
    {
      u();
      if ((this.a != null) && (!this.q.N))
      {
        int i1 = this.i.width;
        int i3 = this.i.height;
        int i2;
        if (i1 != 0)
        {
          i2 = i3;
          if (i3 != 0) {}
        }
        else
        {
          i1 = this.q.a;
          i2 = this.q.b;
          if ((this.q.m == 0) || (this.q.m == 2))
          {
            i1 = this.q.b;
            i2 = this.q.a;
          }
        }
        this.a.a(this.q.D, this.q.C, this.q.B, i1, i2);
      }
      if (this.e != null) {
        this.e.c();
      }
    }
    AppMethodBeat.o(245856);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(245886);
    this.Y.setBeautyStyle(paramInt);
    AppMethodBeat.o(245886);
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(245899);
    if (this.J)
    {
      TXCLog.i("TXCCaptureAndEnc", "enableRPS when mEnableHEVCEncode = true");
      AppMethodBeat.o(245899);
      return;
    }
    if (this.H == paramBoolean)
    {
      AppMethodBeat.o(245899);
      return;
    }
    this.H = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.H);
    if (this.H) {
      this.q.k = 0;
    }
    u();
    AppMethodBeat.o(245899);
  }
  
  public void i()
  {
    AppMethodBeat.i(14394);
    if (this.u != 2)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.u);
      AppMethodBeat.o(14394);
      return;
    }
    this.u = 1;
    TXCLog.i("TXCCaptureAndEnc", "resumePusher");
    if ((this.q.E & 0x1) == 1)
    {
      if ((this.a != null) && (!this.q.N)) {
        this.a.b();
      }
      u();
      if (this.e != null) {
        this.e.b();
      }
      C();
    }
    AppMethodBeat.o(14394);
  }
  
  public void i(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean i(int paramInt)
  {
    AppMethodBeat.i(245893);
    if (this.e == null)
    {
      AppMethodBeat.o(245893);
      return false;
    }
    boolean bool = this.e.a(paramInt);
    AppMethodBeat.o(245893);
    return bool;
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(245897);
    this.G = paramInt;
    if (this.e != null) {
      this.e.g(this.G);
    }
    AppMethodBeat.o(245897);
  }
  
  public void j(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public boolean j()
  {
    return this.v;
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(245900);
    com.tencent.liteav.videoencoder.b localb = null;
    if (paramInt == 2) {
      localb = this.j;
    }
    for (;;)
    {
      if (localb != null) {
        localb.b();
      }
      AppMethodBeat.o(245900);
      return;
      if (paramInt == 3) {
        localb = this.n;
      }
    }
  }
  
  public void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(245901);
    TXCLog.i("TXCCaptureAndEnc", "mEnableHEVCEncode = ".concat(String.valueOf(paramBoolean)));
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(231136);
          d.a(d.this, paramBoolean);
          AppMethodBeat.o(231136);
        }
      });
      AppMethodBeat.o(245901);
      return;
    }
    synchronized (this.o)
    {
      this.J = paramBoolean;
      AppMethodBeat.o(245901);
      return;
    }
  }
  
  public boolean k()
  {
    return this.u != 0;
  }
  
  public void l()
  {
    AppMethodBeat.i(14397);
    if (this.e == null)
    {
      AppMethodBeat.o(14397);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(222048);
        if (d.f(d.this) != null) {
          d.f(d.this).b(true);
        }
        d.a(d.this, d.c(d.this).width, d.c(d.this).height);
        d.this.a(d.j(d.this));
        AppMethodBeat.o(222048);
      }
    });
    AppMethodBeat.o(14397);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(245912);
    if (!this.J) {
      if (this.i.width * this.i.height >= 518400) {
        break label58;
      }
    }
    for (this.q.k = 0; paramInt == 3; this.q.k = 0)
    {
      label42:
      w();
      AppMethodBeat.o(245912);
      return;
      label58:
      if ((this.i.width * this.i.height >= 921600) || (!this.g)) {
        break label42;
      }
    }
    if (this.J) {
      com.tencent.liteav.basic.util.h.a(this.ac, -2310, getID());
    }
    for (;;)
    {
      k(false);
      v();
      AppMethodBeat.o(245912);
      return;
      this.g = true;
    }
  }
  
  public void m()
  {
    AppMethodBeat.i(14398);
    if (this.e == null)
    {
      AppMethodBeat.o(14398);
      return;
    }
    this.Y.a(true);
    l(true);
    AppMethodBeat.o(14398);
  }
  
  public void m(int paramInt) {}
  
  public void n(final int paramInt)
  {
    int i1 = 2;
    AppMethodBeat.i(245938);
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
        Runnable local18 = new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(242706);
            if (d.c(d.this).encoderMode == paramInt)
            {
              AppMethodBeat.o(242706);
              return;
            }
            d.c(d.this).encoderMode = paramInt;
            d.h(d.this).encoderMode = paramInt;
            d.g(d.this);
            d.i(d.this);
            AppMethodBeat.o(242706);
          }
        };
        if (this.e == null)
        {
          local18.run();
          AppMethodBeat.o(245938);
          return;
        }
        this.e.a(local18);
        AppMethodBeat.o(245938);
        return;
      }
    }
  }
  
  public boolean n()
  {
    AppMethodBeat.i(245888);
    if (this.e != null)
    {
      boolean bool = this.e.h();
      AppMethodBeat.o(245888);
      return bool;
    }
    AppMethodBeat.o(245888);
    return false;
  }
  
  public boolean o()
  {
    AppMethodBeat.i(245889);
    if (this.e != null)
    {
      boolean bool = this.e.i();
      AppMethodBeat.o(245889);
      return bool;
    }
    AppMethodBeat.o(245889);
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(245913);
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    if (paramInt == -2311) {
      k(false);
    }
    com.tencent.liteav.basic.util.h.a(this.ac, paramInt, paramBundle);
    if (paramInt == -1314)
    {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.G);
      if ((paramInt == -1301) || (paramInt == -1314) || (paramInt == -1315) || (paramInt == -1316))
      {
        TXCKeyPointReportProxy.b(30003, paramInt);
        if (this.e != null)
        {
          paramBundle = getID();
          if (!this.e.l()) {
            break label230;
          }
        }
      }
    }
    label230:
    for (long l1 = 0L;; l1 = 1L)
    {
      TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.G);
      AppMethodBeat.o(245913);
      return;
      if (paramInt == 1003)
      {
        if (this.e == null) {
          break;
        }
        paramBundle = getID();
        if (this.e.l()) {}
        for (l1 = 0L;; l1 = 1L)
        {
          TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.G);
          break;
        }
      }
      if (paramInt != -1308) {
        break;
      }
      m();
      break;
    }
  }
  
  public boolean p()
  {
    AppMethodBeat.i(245890);
    if (this.e != null)
    {
      boolean bool = this.e.j();
      AppMethodBeat.o(245890);
      return bool;
    }
    AppMethodBeat.o(245890);
    return false;
  }
  
  public boolean q()
  {
    AppMethodBeat.i(245891);
    if (this.e != null)
    {
      boolean bool = this.e.k();
      AppMethodBeat.o(245891);
      return bool;
    }
    AppMethodBeat.o(245891);
    return false;
  }
  
  public int r()
  {
    AppMethodBeat.i(245892);
    if (this.e == null)
    {
      AppMethodBeat.o(245892);
      return 0;
    }
    int i1 = this.e.e();
    AppMethodBeat.o(245892);
    return i1;
  }
  
  public void s()
  {
    AppMethodBeat.i(14406);
    try
    {
      if (this.f != null) {
        this.f.b();
      }
      if (this.Q != null)
      {
        this.Q.d();
        this.Q = null;
      }
      if (this.S != null)
      {
        this.S.d();
        this.S = null;
      }
      if (this.R != null)
      {
        this.R.d();
        this.R = null;
      }
      B();
      A();
      z();
      AppMethodBeat.o(14406);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", localException);
      AppMethodBeat.o(14406);
    }
  }
  
  public void setID(String paramString)
  {
    AppMethodBeat.i(245848);
    super.setID(paramString);
    if (this.j != null) {
      this.j.setID(paramString);
    }
    if (this.n != null) {
      this.n.setID(paramString);
    }
    if (this.f != null) {
      this.f.setID(paramString);
    }
    if (this.e != null) {
      this.e.a(getID());
    }
    TXCLog.w("TXCCaptureAndEnc", "setID:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(245848);
  }
  
  public void t()
  {
    AppMethodBeat.i(14407);
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    if (this.f != null) {
      this.f.b();
    }
    if (this.Q != null)
    {
      this.Q.d();
      this.Q = null;
    }
    if (this.S != null)
    {
      this.S.d();
      this.S = null;
    }
    if (this.R != null)
    {
      this.R.d();
      this.R = null;
    }
    if (this.T != null)
    {
      this.T.d();
      this.T = null;
    }
    B();
    A();
    z();
    AppMethodBeat.o(14407);
  }
  
  public void u()
  {
    AppMethodBeat.i(245923);
    Runnable local13 = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(245746);
        d.g(d.this);
        d.i(d.this);
        AppMethodBeat.o(245746);
      }
    };
    ??? = this.e;
    if (??? != null)
    {
      ((k)???).a(local13);
      AppMethodBeat.o(245923);
      return;
    }
    synchronized (this.o)
    {
      local13.run();
      AppMethodBeat.o(245923);
      return;
    }
  }
  
  public void v()
  {
    AppMethodBeat.i(245924);
    if (this.j == null)
    {
      AppMethodBeat.o(245924);
      return;
    }
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(245055);
          d.g(d.this);
          AppMethodBeat.o(245055);
        }
      });
      AppMethodBeat.o(245924);
      return;
    }
    B();
    AppMethodBeat.o(245924);
  }
  
  public void w()
  {
    AppMethodBeat.i(245925);
    if (this.n == null)
    {
      AppMethodBeat.o(245925);
      return;
    }
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230952);
          d.i(d.this);
          AppMethodBeat.o(230952);
        }
      });
      AppMethodBeat.o(245925);
      return;
    }
    A();
    AppMethodBeat.o(245925);
  }
  
  public static abstract interface a
  {
    public abstract void onBackgroudPushStop();
    
    public abstract void onEncVideo(TXSNALPacket paramTXSNALPacket);
    
    public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */