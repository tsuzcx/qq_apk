package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
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
import com.tencent.liteav.basic.util.TXCBuild;
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
  private Surface A;
  private int B;
  private int C;
  private com.tencent.liteav.basic.opengl.g D;
  private com.tencent.liteav.basic.structs.b E;
  private int F;
  private boolean G;
  private boolean H;
  private volatile boolean I;
  private long J;
  private long K;
  private int L;
  private WeakReference<o> M;
  private boolean N;
  private WeakReference<a> O;
  private j P;
  private j Q;
  private j R;
  private com.tencent.liteav.beauty.b.k S;
  private int T;
  private boolean U;
  private boolean V;
  private boolean W;
  private final com.tencent.liteav.beauty.b X;
  private boolean Y;
  private WeakReference<m> Z;
  b a;
  private com.tencent.liteav.basic.opengl.f aa;
  private WeakReference<com.tencent.liteav.basic.c.b> ab;
  private int ac;
  private int ad;
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
  private int r;
  private int s;
  private int t;
  private boolean u;
  private int v;
  private int w;
  private boolean x;
  private TXCloudVideoView y;
  private final Object z;
  
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
    this.r = 0;
    this.s = 0;
    this.t = 0;
    this.u = false;
    this.v = 0;
    this.w = 0;
    this.x = false;
    this.y = null;
    this.z = new Object();
    this.A = null;
    this.B = 0;
    this.C = 0;
    this.D = null;
    this.F = 0;
    this.G = false;
    this.H = false;
    this.I = false;
    this.J = 0L;
    this.K = 0L;
    this.L = 2;
    this.N = false;
    this.O = null;
    this.P = null;
    this.T = -1;
    this.U = false;
    this.V = false;
    this.W = false;
    this.Y = true;
    this.aa = null;
    this.ac = 0;
    this.ad = 0;
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
      this.X = new com.tencent.liteav.beauty.b(new com.tencent.liteav.basic.license.g(this.p));
      this.X.setPreprocessor(this.f);
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
    AppMethodBeat.i(229424);
    try
    {
      com.tencent.liteav.videoencoder.b localb = this.n;
      this.n = null;
      if (localb != null)
      {
        localb.a();
        localb.a(null);
      }
      AppMethodBeat.o(229424);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", localException);
      AppMethodBeat.o(229424);
    }
  }
  
  private void B()
  {
    AppMethodBeat.i(229429);
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
      this.V = true;
      AppMethodBeat.o(229429);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", localException);
      AppMethodBeat.o(229429);
    }
  }
  
  private void C()
  {
    AppMethodBeat.i(229438);
    if (this.e != null) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229382);
          d.a(d.this, d.c(d.this).width, d.c(d.this).height);
          AppMethodBeat.o(229382);
        }
      });
    }
    AppMethodBeat.o(229438);
  }
  
  private void D()
  {
    AppMethodBeat.i(229444);
    if (this.f != null)
    {
      if (this.q.V)
      {
        this.f.a(d.d.a);
        AppMethodBeat.o(229444);
        return;
      }
      if (this.q.U)
      {
        this.f.a(d.d.b);
        AppMethodBeat.o(229444);
        return;
      }
      this.f.a(d.d.c);
    }
    AppMethodBeat.o(229444);
  }
  
  private int a(int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(229414);
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
      AppMethodBeat.o(229414);
      return -1;
    }
    if (this.q.N)
    {
      B();
      AppMethodBeat.o(229414);
      return -1000;
    }
    b(paramInt2, paramInt1, paramObject);
    AppMethodBeat.o(229414);
    return 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(229408);
    if (paramLong == 0L) {
      paramLong = TXCTimeUtil.generatePtsMS();
    }
    for (;;)
    {
      b(paramInt2, paramInt3, this.f.a());
      com.tencent.liteav.videoencoder.b localb = this.j;
      if (localb != null)
      {
        localb.b(this.Y);
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      localb = this.n;
      if (localb != null)
      {
        localb.b(this.Y);
        localb.a(paramInt1, paramInt2, paramInt3, paramLong);
      }
      AppMethodBeat.o(229408);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(229395);
    TXCLog.i("TXCCaptureAndEnc", "New encode size width = " + paramInt1 + " height = " + paramInt2 + " encType = " + paramInt3 + " eglContext: " + paramObject);
    B();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt3);
    TXCStatus.a(getID(), 4005, this.F, Integer.valueOf(paramInt3));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt3 == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", this.F);
      this.V = false;
      this.i.encodeType = paramInt3;
      this.i.width = paramInt1;
      this.i.height = paramInt2;
      this.i.fps = paramInt4;
      this.i.gop = this.q.j;
      this.i.encoderProfile = this.q.o;
      localTXSVideoEncoderParam = this.i;
      if (paramObject == null) {
        break label582;
      }
    }
    for (;;)
    {
      localTXSVideoEncoderParam.glContext = paramObject;
      this.i.realTime = paramBoolean;
      this.i.streamType = this.F;
      this.i.annexb = this.H;
      this.i.bMultiRef = this.G;
      this.i.baseFrameIndex = (this.J + 20L);
      this.i.baseGopIndex = ((this.K + 1L) % 255L + 1L);
      this.i.bLimitFps = this.h;
      this.i.record = this.W;
      this.i.encFmt = this.q.Z;
      this.i.isH265EncoderEnabled = this.I;
      this.i.bitrate = this.q.c;
      localb.a(this);
      localb.a(this);
      localb.a(this.i);
      localb.c(this.q.c);
      localb.d(this.k);
      localb.setID(getID());
      localb.a(this.ac);
      this.j = localb;
      TXCStatus.a(getID(), 4003, this.F, Integer.valueOf(this.i.width << 16 | this.i.height));
      TXCStatus.a(getID(), 13003, this.F, Integer.valueOf(this.i.gop * 1000));
      TXCEventRecorderProxy.a(getID(), 4003, this.i.width, this.i.height, "", this.F);
      TXCKeyPointReportProxy.a(40036, this.i.encodeType, this.F);
      TXCKeyPointReportProxy.a(40037, this.i.width << 16 | this.i.height, this.F);
      AppMethodBeat.o(229395);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", this.F);
      break;
      label582:
      paramObject = localb.a(paramInt1, paramInt2);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(229374);
    Bundle localBundle = new Bundle();
    localBundle.putString("EVT_USERID", getID());
    localBundle.putInt("EVT_ID", paramInt);
    localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
    if (paramString != null) {
      localBundle.putCharSequence("EVT_MSG", paramString);
    }
    com.tencent.liteav.basic.util.h.a(this.ab, paramInt, localBundle);
    int i1;
    if (paramInt == -1314)
    {
      paramString = getID();
      i1 = 2002;
      l1 = 5L;
      TXCEventRecorderProxy.a(paramString, i1, l1, -1L, "", this.F);
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
      TXCEventRecorderProxy.a(paramString, 4002, l1, paramInt, "", this.F);
      AppMethodBeat.o(229374);
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
    AppMethodBeat.i(229378);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.t == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(229378);
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
        AppMethodBeat.o(229378);
        return;
        paramb.g = this.q.a;
        paramb.h = this.q.b;
        continue;
        paramb = finally;
        AppMethodBeat.o(229378);
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
    AppMethodBeat.i(229460);
    e(paramb.e, paramb.f);
    this.E = paramb;
    if (this.y != null)
    {
      if (this.e != null)
      {
        this.e.a(paramb);
        AppMethodBeat.o(229460);
      }
    }
    else {
      synchronized (this.z)
      {
        if ((this.A != null) && (this.D == null) && (this.e != null) && (this.e.f() != null))
        {
          this.D = new com.tencent.liteav.basic.opengl.g();
          this.D.a(this.e.f(), this.A);
          this.D.a(this.w);
          this.D.b(this.ad);
        }
        if ((this.D != null) && (this.e != null)) {
          this.D.a(paramb.a, paramb.i, this.v, this.B, this.C, paramb.e, paramb.f, paramBoolean, this.e.l());
        }
        AppMethodBeat.o(229460);
        return;
      }
    }
    AppMethodBeat.o(229460);
  }
  
  private void a(Object paramObject, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(229400);
    A();
    com.tencent.liteav.videoencoder.b localb = new com.tencent.liteav.videoencoder.b(paramInt);
    TXCStatus.a(getID(), 4005, 3, Integer.valueOf(paramInt));
    TXSVideoEncoderParam localTXSVideoEncoderParam;
    if (paramInt == 1)
    {
      TXCEventRecorderProxy.a(getID(), 4004, 1L, -1L, "", 3);
      localTXSVideoEncoderParam = this.m;
      if (paramObject == null) {
        break label253;
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
      localb.a(this.ac);
      this.n = localb;
      TXCStatus.a(getID(), 4003, 3, Integer.valueOf(this.m.width << 16 | this.m.height));
      TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.m.gop * 1000));
      AppMethodBeat.o(229400);
      return;
      TXCEventRecorderProxy.a(getID(), 4004, 0L, -1L, "", 3);
      break;
      label253:
      paramObject = localb.a(this.m.width, this.m.height);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(229478);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.d.a(paramRunnable);
      AppMethodBeat.o(229478);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(229478);
  }
  
  private void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int i2 = 2;
    AppMethodBeat.i(229418);
    int i1 = i2;
    switch (this.q.k)
    {
    default: 
      i1 = i2;
    case 0: 
      if ((this.r == 1) && (this.s == 0)) {
        i1 = 1;
      }
      break;
    }
    for (;;)
    {
      i2 = this.q.j;
      if ((this.j == null) || (this.V) || (this.i.width != paramInt1) || (this.i.height != paramInt2) || (this.i.encodeType != i1) || (this.i.gop != i2) || (this.I != this.i.isH265EncoderEnabled)) {
        a(paramInt1, paramInt2, i1, paramObject, this.q.i, this.q.Q);
      }
      if (((this.n == null) || (this.m.encodeType != i1)) && (this.l)) {
        a(paramObject, i1, this.q.Q);
      }
      AppMethodBeat.o(229418);
      return;
      i1 = 1;
      break;
      i1 = 3;
      break;
    }
  }
  
  private int c(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(229469);
    if (this.N)
    {
      i1 = paramb.a;
      AppMethodBeat.o(229469);
      return i1;
    }
    int i1 = paramb.a;
    int i7;
    j localj;
    if (this.ad == 1)
    {
      i7 = 1;
      if (i7 == paramb.i) {
        break label398;
      }
      if (this.Q == null)
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
        this.Q = localj;
      }
      localj = this.Q;
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
      if (this.v != 0)
      {
        if (this.R == null)
        {
          localj = new j();
          localj.a();
          localj.a(true);
          localj.a(paramb.e, paramb.f);
          this.R = localj;
        }
        localj = this.R;
        i2 = i1;
        if (localj != null)
        {
          GLES20.glViewport(0, 0, paramb.e, paramb.f);
          i4 = paramb.e;
          i5 = paramb.f;
          arrayOfFloat = localj.a(i4, i5, null, com.tencent.liteav.basic.util.h.a(i4, i5, paramb.e, paramb.f), 0);
          i6 = (720 - this.v) % 360;
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
        AppMethodBeat.o(229469);
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
    AppMethodBeat.i(229442);
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
        AppMethodBeat.o(229442);
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
    AppMethodBeat.i(229447);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(229447);
  }
  
  private void d(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(229475);
    Object localObject1 = this.M;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (o)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(229475);
      return;
    }
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = paramb.e;
    localTXSVideoFrame.height = paramb.f;
    localTXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
    int i1 = c(paramb);
    if (this.L == 5)
    {
      localTXSVideoFrame.textureId = i1;
      localTXSVideoFrame.eglContext = this.f.a();
      if (this.T == -1)
      {
        this.T = TXCOpenGlUtils.d();
        TXCLog.i("TXCCaptureAndEnc", "create FrameBuffer: %d", new Object[] { Integer.valueOf(this.T) });
      }
      TXCOpenGlUtils.a(localTXSVideoFrame.textureId, this.T);
      GLES20.glBindFramebuffer(36160, this.T);
      ((o)localObject1).onRenderVideoFrame(getID(), this.F, localTXSVideoFrame);
      TXCOpenGlUtils.d(this.T);
      if (this.N)
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
          if ((this.N) && (this.y != null))
          {
            paramb = this.y.getGLSurfaceView();
            if (paramb != null) {
              paramb.d();
            }
          }
          AppMethodBeat.o(229475);
          return;
          localObject1 = localTXSVideoFrame.buffer;
          break;
          if (this.L != 2) {
            break label344;
          }
          localTXSVideoFrame.textureId = i1;
          localTXSVideoFrame.eglContext = this.f.a();
          ((o)localObject1).onRenderVideoFrame(getID(), this.F, localTXSVideoFrame);
          if (this.N) {
            paramb.a = localTXSVideoFrame.textureId;
          }
        }
      } while ((this.L != 1) && (this.L != 4));
      if (this.P == null)
      {
        if (this.L != 1) {
          break label634;
        }
        localObject2 = new com.tencent.liteav.beauty.b.o(1);
        ((j)localObject2).a(true);
        if (!((j)localObject2).a()) {
          break label647;
        }
        ((j)localObject2).a(paramb.e, paramb.f);
        this.P = ((j)localObject2);
      }
      localObject2 = this.P;
      if (localObject2 != null)
      {
        GLES20.glViewport(0, 0, paramb.e, paramb.f);
        ((j)localObject2).a(paramb.e, paramb.f);
        ((j)localObject2).b(i1);
        GLES20.glBindFramebuffer(36160, ((j)localObject2).m());
        ((o)localObject1).onRenderVideoFrame(getID(), this.F, localTXSVideoFrame);
      }
    } while ((!this.N) || ((localTXSVideoFrame.data == null) && (localTXSVideoFrame.buffer == null)));
    if (this.L == 1) {
      i1 = 1;
    }
    for (;;)
    {
      label522:
      if (this.S == null)
      {
        localObject1 = new com.tencent.liteav.beauty.b.k(i1);
        ((com.tencent.liteav.beauty.b.k)localObject1).a(true);
        if (!((com.tencent.liteav.beauty.b.k)localObject1).a()) {
          TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
        }
        ((com.tencent.liteav.beauty.b.k)localObject1).a(paramb.e, paramb.f);
        this.S = ((com.tencent.liteav.beauty.b.k)localObject1);
      }
      localObject1 = this.S;
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
        this.P = null;
        break label418;
        if (this.L != 4) {
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
    AppMethodBeat.i(229454);
    if (!this.x)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("EVT_USERID", getID());
      localBundle.putInt("EVT_ID", 2003);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      localBundle.putCharSequence("EVT_MSG", "Renders the first video frame");
      localBundle.putInt("EVT_PARAM1", paramInt1);
      localBundle.putInt("EVT_PARAM2", paramInt2);
      com.tencent.liteav.basic.util.h.a(this.ab, 2003, localBundle);
      TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.F);
      this.x = true;
    }
    AppMethodBeat.o(229454);
  }
  
  private void l(final boolean paramBoolean)
  {
    AppMethodBeat.i(229366);
    if (this.e == null)
    {
      AppMethodBeat.o(229366);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229364);
        if (d.m(d.this) != null) {
          d.m(d.this).b();
        }
        AppMethodBeat.o(229364);
      }
    });
    u();
    this.e.a(paramBoolean);
    this.e = null;
    TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
    ??? = this.y;
    this.d.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229367);
        if (this.a != null) {
          this.a.stop(paramBoolean);
        }
        AppMethodBeat.o(229367);
      }
    });
    this.y = null;
    synchronized (this.z)
    {
      this.A = null;
      if (this.D != null)
      {
        this.D.a();
        this.D = null;
      }
      if (this.a.a()) {
        this.a.b();
      }
      if (this.u) {
        x();
      }
      AppMethodBeat.o(229366);
      return;
    }
  }
  
  private void m(final boolean paramBoolean)
  {
    AppMethodBeat.i(229432);
    if (this.e != null) {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229398);
          k localk = d.f(d.this);
          if (localk == null)
          {
            AppMethodBeat.o(229398);
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
          AppMethodBeat.o(229398);
        }
      });
    }
    AppMethodBeat.o(229432);
  }
  
  private void x()
  {
    AppMethodBeat.i(229353);
    TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
    if (this.b == null) {
      this.b = new b(this);
    }
    this.b.a(10, -1, null, 64, 64);
    AppMethodBeat.o(229353);
  }
  
  private void y()
  {
    AppMethodBeat.i(229358);
    TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.u);
    if (this.b != null) {
      this.b.b();
    }
    AppMethodBeat.o(229358);
  }
  
  private void z()
  {
    m localm = null;
    AppMethodBeat.i(229384);
    if (this.T != -1)
    {
      TXCLog.i("TXCCaptureAndEnc", "destroy FrameBuffer: %d", new Object[] { Integer.valueOf(this.T) });
      TXCOpenGlUtils.b(this.T);
      this.T = -1;
    }
    if (this.aa != null)
    {
      this.aa.e();
      this.aa = null;
    }
    if (this.Z != null) {
      localm = (m)this.Z.get();
    }
    if (localm != null) {
      localm.onGLContextReadyToDestory();
    }
    AppMethodBeat.o(229384);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(229680);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.t == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(229680);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, paramObject);
        if (i1 != 0)
        {
          AppMethodBeat.o(229680);
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
          AppMethodBeat.o(229680);
          return 0;
        }
      }
    }
  }
  
  public int a(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(229686);
    if (this.Z != null) {}
    for (m localm = (m)this.Z.get();; localm = null)
    {
      if (localm != null)
      {
        if ((this.aa == null) || (this.aa.c() != paramb.e) || (this.aa.d() != paramb.f))
        {
          if (this.aa != null) {
            this.aa.e();
          }
          this.aa = new com.tencent.liteav.basic.opengl.f(paramb.e, paramb.f);
          this.aa.a();
        }
        paramb.a = localm.onProcessVideoFrame(paramb.a, paramb.e, paramb.f, this.aa.b());
        GLES20.glDisable(3042);
        GLES20.glDisable(2929);
      }
      d(paramb);
      a(paramb, false);
      int i1 = paramb.a;
      AppMethodBeat.o(229686);
      return i1;
    }
  }
  
  public int a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(229635);
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
            AppMethodBeat.i(229383);
            d.i(d.this);
            AppMethodBeat.o(229383);
          }
        });
      }
    }
    for (;;)
    {
      this.l = paramBoolean;
      AppMethodBeat.o(229635);
      return 0;
      i1 = 0;
      break;
      label186:
      A();
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(229677);
    for (;;)
    {
      synchronized (this.o)
      {
        if ((this.t == 2) || ((this.b != null) && (this.b.a())))
        {
          AppMethodBeat.o(229677);
          return 0;
        }
        int i1 = a(paramInt2, paramInt3, null);
        if (i1 != 0)
        {
          AppMethodBeat.o(229677);
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
          AppMethodBeat.o(229677);
          return 0;
        }
      }
    }
  }
  
  public void a()
  {
    AppMethodBeat.i(14386);
    TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
    if (this.O == null)
    {
      AppMethodBeat.o(14386);
      return;
    }
    a locala = (a)this.O.get();
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
    AppMethodBeat.i(229669);
    if (this.e == null)
    {
      AppMethodBeat.o(229669);
      return;
    }
    this.e.a(paramFloat);
    AppMethodBeat.o(229669);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(229718);
    if ((this.e != null) && (this.q.L)) {
      this.e.a(paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(229718);
  }
  
  public void a(final int paramInt)
  {
    AppMethodBeat.i(229592);
    TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(paramInt)));
    this.ac = paramInt;
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
      AppMethodBeat.o(229592);
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
    AppMethodBeat.o(229592);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(229640);
    synchronized (this.z)
    {
      if (this.D != null)
      {
        this.D.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(229360);
            d.b(d.this, paramInt1);
            d.c(d.this, paramInt2);
            if ((d.k(d.this) != null) && (d.l(d.this) != null)) {
              d.a(d.this, d.k(d.this), true);
            }
            AppMethodBeat.o(229360);
          }
        });
        AppMethodBeat.o(229640);
        return;
      }
      this.B = paramInt1;
      this.C = paramInt2;
    }
  }
  
  public void a(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(229625);
    if (this.e == null)
    {
      AppMethodBeat.o(229625);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229422);
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
        AppMethodBeat.o(229422);
      }
    });
    AppMethodBeat.o(229625);
  }
  
  public void a(int paramInt1, final int paramInt2, final int paramInt3, final int paramInt4, final int paramInt5, int paramInt6, int paramInt7, final boolean paramBoolean)
  {
    AppMethodBeat.i(229620);
    if (paramInt1 == 2)
    {
      if ((this.i.width != 0) && (this.i.height != 0) && ((paramInt2 != this.i.width) || (paramInt3 != this.i.height) || (paramInt4 > this.i.fps) || (paramBoolean != this.I))) {
        if (this.e != null) {
          this.e.a(new Runnable()
          {
            public void run()
            {
              AppMethodBeat.i(229372);
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
                AppMethodBeat.o(229372);
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
        AppMethodBeat.o(229620);
        return;
        if (this.I != paramBoolean)
        {
          localObject1 = this.o;
          if (!paramBoolean) {}
          try
          {
            if (this.I) {
              this.I = false;
            }
            continue;
          }
          finally
          {
            AppMethodBeat.o(229620);
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
          AppMethodBeat.i(229387);
          TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", new Object[] { Integer.valueOf(d.h(d.this).width), Integer.valueOf(d.h(d.this).height), Integer.valueOf(d.h(d.this).fps), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
          d.h(d.this).width = paramInt2;
          d.h(d.this).height = paramInt3;
          d.i(d.this);
          AppMethodBeat.o(229387);
        }
      });
    }
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt5, paramInt6);
      ((com.tencent.liteav.videoencoder.b)localObject1).b(paramInt4);
    }
    AppMethodBeat.o(229620);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 2)
    {
      this.K = paramLong1;
      this.J = paramLong2;
    }
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(229657);
    this.q.F = paramBitmap;
    this.q.I = paramFloat1;
    this.q.J = paramFloat2;
    this.q.K = paramFloat3;
    C();
    AppMethodBeat.o(229657);
  }
  
  public void a(final Bitmap paramBitmap, final ByteBuffer paramByteBuffer, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(229706);
    paramBitmap = new Runnable()
    {
      public void run()
      {
        int i = 1;
        AppMethodBeat.i(229375);
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
              AppMethodBeat.o(229375);
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
                  AppMethodBeat.o(229375);
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
            AppMethodBeat.o(229375);
            return;
          }
        }
      }
    };
    paramByteBuffer = this.e;
    if (paramByteBuffer != null)
    {
      paramByteBuffer.a(paramBitmap);
      AppMethodBeat.o(229706);
      return;
    }
    paramBitmap.run();
    AppMethodBeat.o(229706);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(229709);
    if (this.f != null) {
      this.f.b();
    }
    if (this.Z != null) {}
    for (paramSurfaceTexture = (m)this.Z.get();; paramSurfaceTexture = null)
    {
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.onGLContextCreated();
      }
      AppMethodBeat.o(229709);
      return;
    }
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(229697);
    if (this.O == null)
    {
      AppMethodBeat.o(229697);
      return;
    }
    a locala = (a)this.O.get();
    if (locala != null) {
      locala.onEncVideoFormat(paramMediaFormat);
    }
    AppMethodBeat.o(229697);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(229639);
    if (this.y != null)
    {
      TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
      AppMethodBeat.o(229639);
      return;
    }
    synchronized (this.z)
    {
      if (this.A != paramSurface)
      {
        TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
        this.A = paramSurface;
        if (this.D != null)
        {
          this.D.a();
          this.D = null;
        }
        AppMethodBeat.o(229639);
        return;
      }
      TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface the same".concat(String.valueOf(paramSurface)));
    }
  }
  
  public void a(com.tencent.liteav.basic.c.b paramb)
  {
    AppMethodBeat.i(229567);
    this.ab = new WeakReference(paramb);
    AppMethodBeat.o(229567);
  }
  
  public void a(final p paramp)
  {
    AppMethodBeat.i(229641);
    if (this.y != null)
    {
      TXCGLSurfaceView localTXCGLSurfaceView = this.y.getGLSurfaceView();
      if (localTXCGLSurfaceView != null)
      {
        localTXCGLSurfaceView.a(new p()
        {
          public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(229351);
            if (paramp != null) {
              paramp.onTakePhotoComplete(paramAnonymousBitmap);
            }
            AppMethodBeat.o(229351);
          }
        });
        AppMethodBeat.o(229641);
        return;
      }
      if (paramp != null) {
        paramp.onTakePhotoComplete(null);
      }
      AppMethodBeat.o(229641);
      return;
    }
    if (this.D != null)
    {
      this.D.a(new p()
      {
        public void onTakePhotoComplete(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(229368);
          if (paramp != null) {
            paramp.onTakePhotoComplete(paramAnonymousBitmap);
          }
          AppMethodBeat.o(229368);
        }
      });
      AppMethodBeat.o(229641);
      return;
    }
    if (paramp != null) {
      paramp.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(229641);
  }
  
  public void a(TXSNALPacket arg1, int paramInt)
  {
    int i1 = 1;
    AppMethodBeat.i(229694);
    Object localObject1;
    if (paramInt == 0)
    {
      if (???.streamType == 2)
      {
        this.K = ???.gopIndex;
        this.J = ???.frameIndex;
      }
      if (this.O == null)
      {
        AppMethodBeat.o(229694);
        return;
      }
      localObject1 = (a)this.O.get();
      if (localObject1 != null) {
        ((a)localObject1).onEncVideo(???);
      }
      AppMethodBeat.o(229694);
      return;
    }
    if (((paramInt == 10000004) || (paramInt == 10000005) || (paramInt == 10000006)) && (this.i.encodeType == 1))
    {
      TXCLog.i("TXCCaptureAndEnc", "onEncodeNal mEnableHEVCEncode " + this.I + " errCode= " + paramInt);
      if (this.I)
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
              AppMethodBeat.i(229362);
              d.a(d.this, false);
              d.g(d.this);
              d.i(d.this);
              AppMethodBeat.o(229362);
            }
          });
        }
        for (;;)
        {
          com.tencent.liteav.basic.util.h.a(this.ab, -2310, getID());
          AppMethodBeat.o(229694);
          return;
          i1 = 0;
          break;
          label267:
          synchronized (this.o)
          {
            this.I = false;
            B();
            A();
          }
        }
      }
      Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", new Object[] { Integer.valueOf(paramInt) }), "", 0);
      u();
      this.s += 1;
      this.q.k = 0;
      a(1103, "Failed to enable hardware encoder, use software encoder");
    }
    AppMethodBeat.o(229694);
  }
  
  public void a(com.tencent.liteav.basic.structs.b paramb, long paramLong)
  {
    AppMethodBeat.i(229689);
    a(paramb.a, paramb.e, paramb.f, paramLong);
    AppMethodBeat.o(229689);
  }
  
  public void a(a parama)
  {
    AppMethodBeat.i(229551);
    this.O = new WeakReference(parama);
    AppMethodBeat.o(229551);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(229559);
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
        AppMethodBeat.o(229559);
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
    AppMethodBeat.i(229570);
    this.Z = new WeakReference(paramm);
    AppMethodBeat.o(229570);
  }
  
  public void a(o paramo, int paramInt)
  {
    AppMethodBeat.i(229554);
    this.L = paramInt;
    if (paramo != null)
    {
      this.M = new WeakReference(paramo);
      AppMethodBeat.o(229554);
      return;
    }
    this.M = null;
    AppMethodBeat.o(229554);
  }
  
  public void a(a.a parama)
  {
    AppMethodBeat.i(229642);
    if (TXCBuild.VersionInt() < 21)
    {
      parama = new Bundle();
      parama.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
      onNotifyEvent(-1309, parama);
      TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + TXCBuild.VersionInt());
      AppMethodBeat.o(229642);
      return;
    }
    this.r = 1;
    if (this.e == null)
    {
      this.e = new i(this.p, this.q, parama);
      TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
    }
    this.X.a(false);
    j(this.F);
    this.e.a(this);
    this.e.a(this);
    this.e.a();
    this.e.a(getID());
    TXCDRApi.txReportDAU(this.p, com.tencent.liteav.basic.datareport.a.aH);
    AppMethodBeat.o(229642);
  }
  
  public void a(final TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(229631);
    if (this.q.N)
    {
      TXCLog.e("TXCCaptureAndEnc", "enable pure audio push , so can not start preview!");
      AppMethodBeat.o(229631);
      return;
    }
    if (this.a != null) {
      this.a.b();
    }
    this.x = false;
    boolean bool = this.q.X;
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      final TXCGLSurfaceView[] arrayOfTXCGLSurfaceView = new TXCGLSurfaceView[1];
      a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229401);
          arrayOfTXCGLSurfaceView[0] = new TXCGLSurfaceView(paramTXCloudVideoView.getContext());
          paramTXCloudVideoView.addVideoView(arrayOfTXCGLSurfaceView[0]);
          AppMethodBeat.o(229401);
        }
      });
      localObject = arrayOfTXCGLSurfaceView[0];
      arrayOfTXCGLSurfaceView[0].setNotifyListener(this);
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with GLSurfaceView");
    }
    for (;;)
    {
      this.r = 0;
      this.e = new c(this.p, this.q, (n)localObject, bool);
      y();
      j(this.F);
      this.e.a(getID());
      this.e.a(this);
      this.e.a(this);
      this.e.a();
      this.e.b(this.v);
      this.e.c(this.w);
      this.e.d(this.ad);
      this.y = paramTXCloudVideoView;
      this.d.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229386);
          if (paramTXCloudVideoView != null) {
            paramTXCloudVideoView.start(d.e(d.this).L, d.e(d.this).M, d.f(d.this));
          }
          AppMethodBeat.o(229386);
        }
      });
      this.x = false;
      TXCKeyPointReportProxy.a(30003);
      AppMethodBeat.o(229631);
      return;
      localObject = new com.tencent.liteav.basic.opengl.h();
      TXCLog.i("TXCCaptureAndEnc", "start camera preview with SurfaceTexture");
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(229682);
    com.tencent.liteav.basic.structs.b localb = new com.tencent.liteav.basic.structs.b();
    localb.a = paramInt1;
    localb.b = 0;
    a(localb, paramInt2, paramInt3, paramObject, paramLong);
    AppMethodBeat.o(229682);
    return 0;
  }
  
  public TXBeautyManager b()
  {
    return this.X;
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(229596);
    TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(paramInt)));
    this.ad = paramInt;
    if (this.e != null) {
      this.e.d(this.ad);
    }
    if (this.D != null) {
      this.D.b(this.ad);
    }
    AppMethodBeat.o(229596);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229667);
    if (this.e == null)
    {
      AppMethodBeat.o(229667);
      return;
    }
    this.e.a(paramInt1, paramInt2);
    AppMethodBeat.o(229667);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(229651);
    this.X.setBeautyLevel(paramInt1);
    this.X.setWhitenessLevel(paramInt2);
    this.X.setRuddyLevel(paramInt3);
    AppMethodBeat.o(229651);
  }
  
  public void b(com.tencent.liteav.basic.structs.b paramb)
  {
    AppMethodBeat.i(229710);
    this.c.a();
    if (!this.U)
    {
      this.U = true;
      TXCKeyPointReportProxy.b(30003, 0);
    }
    if (this.t == 2)
    {
      AppMethodBeat.o(229710);
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
    AppMethodBeat.o(229710);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(14405);
    this.Y = paramBoolean;
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
    AppMethodBeat.i(229624);
    if (this.e == null)
    {
      AppMethodBeat.o(229624);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229403);
        if (d.a(d.this) != null) {
          d.a(d.this).d(paramInt);
        }
        d.a(d.this, paramInt);
        AppMethodBeat.o(229403);
      }
    });
    AppMethodBeat.o(229624);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(229618);
    TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(paramBoolean)));
    this.u = paramBoolean;
    if (this.u)
    {
      if (this.e == null)
      {
        x();
        AppMethodBeat.o(229618);
      }
    }
    else {
      y();
    }
    AppMethodBeat.o(229618);
  }
  
  public int d()
  {
    return this.i.width;
  }
  
  public void d(final int paramInt)
  {
    AppMethodBeat.i(229628);
    if (this.e == null)
    {
      AppMethodBeat.o(229628);
      return;
    }
    this.e.a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229405);
        if (d.a(d.this) != null) {
          d.a(d.this).e(paramInt);
        }
        AppMethodBeat.o(229405);
      }
    });
    AppMethodBeat.o(229628);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(229632);
    l(paramBoolean);
    AppMethodBeat.o(229632);
  }
  
  public int e()
  {
    return this.i.height;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(229637);
    if (this.q.i == paramInt)
    {
      AppMethodBeat.o(229637);
      return;
    }
    this.q.i = paramInt;
    if ((this.e != null) && (this.e.g() < paramInt)) {
      switch (this.r)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229637);
      return;
      m(true);
      u();
      AppMethodBeat.o(229637);
      return;
      this.e.f(paramInt);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public int f()
  {
    AppMethodBeat.i(229601);
    if (k())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.t);
      AppMethodBeat.o(229601);
      return -2;
    }
    TXCDRApi.initCrashReport(this.p);
    this.t = 1;
    TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
    D();
    AppMethodBeat.o(229601);
    return 0;
  }
  
  public void f(int paramInt)
  {
    AppMethodBeat.i(229645);
    TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(paramInt)));
    this.w = paramInt;
    if (this.e != null) {
      this.e.c(paramInt);
    }
    if (this.D != null) {
      this.D.a(this.w);
    }
    AppMethodBeat.o(229645);
  }
  
  public boolean f(boolean paramBoolean)
  {
    AppMethodBeat.i(229650);
    if (this.e == null)
    {
      AppMethodBeat.o(229650);
      return false;
    }
    paramBoolean = this.e.d(paramBoolean);
    AppMethodBeat.o(229650);
    return paramBoolean;
  }
  
  public void g()
  {
    AppMethodBeat.i(229605);
    if (!k())
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.t);
      AppMethodBeat.o(229605);
      return;
    }
    TXCLog.i("TXCCaptureAndEnc", "stop");
    this.t = 0;
    u();
    this.q.Q = false;
    if (this.a != null) {
      this.a.b();
    }
    c(false);
    this.E = null;
    AppMethodBeat.o(229605);
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(229646);
    if (this.v != paramInt) {
      TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(paramInt)));
    }
    this.v = paramInt;
    if (this.e == null)
    {
      AppMethodBeat.o(229646);
      return;
    }
    this.e.b(paramInt);
    AppMethodBeat.o(229646);
  }
  
  public boolean g(boolean paramBoolean)
  {
    AppMethodBeat.i(229668);
    this.q.T = paramBoolean;
    if (this.e == null)
    {
      AppMethodBeat.o(229668);
      return false;
    }
    this.e.c(paramBoolean);
    AppMethodBeat.o(229668);
    return true;
  }
  
  public void h()
  {
    AppMethodBeat.i(229610);
    if (this.t != 1)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.t);
      AppMethodBeat.o(229610);
      return;
    }
    this.t = 2;
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
    AppMethodBeat.o(229610);
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(229653);
    this.X.setBeautyStyle(paramInt);
    AppMethodBeat.o(229653);
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(229672);
    if (this.I)
    {
      TXCLog.i("TXCCaptureAndEnc", "enableRPS when mEnableHEVCEncode = true");
      AppMethodBeat.o(229672);
      return;
    }
    if (this.G == paramBoolean)
    {
      AppMethodBeat.o(229672);
      return;
    }
    this.G = paramBoolean;
    TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.G);
    if (this.G) {
      this.q.k = 0;
    }
    u();
    AppMethodBeat.o(229672);
  }
  
  public void i()
  {
    AppMethodBeat.i(14394);
    if (this.t != 2)
    {
      TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.t);
      AppMethodBeat.o(14394);
      return;
    }
    this.t = 1;
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
    AppMethodBeat.i(229665);
    if (this.e == null)
    {
      AppMethodBeat.o(229665);
      return false;
    }
    boolean bool = this.e.a(paramInt);
    AppMethodBeat.o(229665);
    return bool;
  }
  
  public void j(int paramInt)
  {
    AppMethodBeat.i(229670);
    this.F = paramInt;
    if (this.e != null) {
      this.e.g(this.F);
    }
    AppMethodBeat.o(229670);
  }
  
  public void j(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public boolean j()
  {
    return this.u;
  }
  
  public void k(int paramInt)
  {
    AppMethodBeat.i(229674);
    com.tencent.liteav.videoencoder.b localb = null;
    if (paramInt == 2) {
      localb = this.j;
    }
    for (;;)
    {
      if (localb != null) {
        localb.b();
      }
      AppMethodBeat.o(229674);
      return;
      if (paramInt == 3) {
        localb = this.n;
      }
    }
  }
  
  public void k(final boolean paramBoolean)
  {
    AppMethodBeat.i(229676);
    TXCLog.i("TXCCaptureAndEnc", "mEnableHEVCEncode = ".concat(String.valueOf(paramBoolean)));
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229426);
          d.a(d.this, paramBoolean);
          AppMethodBeat.o(229426);
        }
      });
      AppMethodBeat.o(229676);
      return;
    }
    synchronized (this.o)
    {
      this.I = paramBoolean;
      AppMethodBeat.o(229676);
      return;
    }
  }
  
  public boolean k()
  {
    return this.t != 0;
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
        AppMethodBeat.i(229409);
        if (d.f(d.this) != null) {
          d.f(d.this).b(true);
        }
        d.a(d.this, d.c(d.this).width, d.c(d.this).height);
        d.this.a(d.j(d.this));
        AppMethodBeat.o(229409);
      }
    });
    AppMethodBeat.o(14397);
  }
  
  public void l(int paramInt)
  {
    AppMethodBeat.i(229700);
    if (!this.I) {
      if (this.i.width * this.i.height >= 518400) {
        break label58;
      }
    }
    for (this.q.k = 0; paramInt == 3; this.q.k = 0)
    {
      label42:
      w();
      AppMethodBeat.o(229700);
      return;
      label58:
      if ((this.i.width * this.i.height >= 921600) || (!this.g)) {
        break label42;
      }
    }
    if (this.I) {
      com.tencent.liteav.basic.util.h.a(this.ab, -2310, getID());
    }
    for (;;)
    {
      k(false);
      v();
      AppMethodBeat.o(229700);
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
    this.X.a(true);
    l(true);
    AppMethodBeat.o(14398);
  }
  
  public void m(int paramInt) {}
  
  public void n(final int paramInt)
  {
    int i1 = 2;
    AppMethodBeat.i(229721);
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
            AppMethodBeat.i(229380);
            if (d.c(d.this).encoderMode == paramInt)
            {
              AppMethodBeat.o(229380);
              return;
            }
            d.c(d.this).encoderMode = paramInt;
            d.h(d.this).encoderMode = paramInt;
            d.g(d.this);
            d.i(d.this);
            AppMethodBeat.o(229380);
          }
        };
        if (this.e == null)
        {
          local18.run();
          AppMethodBeat.o(229721);
          return;
        }
        this.e.a(local18);
        AppMethodBeat.o(229721);
        return;
      }
    }
  }
  
  public boolean n()
  {
    AppMethodBeat.i(229660);
    if (this.e != null)
    {
      boolean bool = this.e.h();
      AppMethodBeat.o(229660);
      return bool;
    }
    AppMethodBeat.o(229660);
    return false;
  }
  
  public boolean o()
  {
    AppMethodBeat.i(229661);
    if (this.e != null)
    {
      boolean bool = this.e.i();
      AppMethodBeat.o(229661);
      return bool;
    }
    AppMethodBeat.o(229661);
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(229704);
    if (paramBundle != null) {
      paramBundle.putString("EVT_USERID", getID());
    }
    if (paramInt == -2311) {
      k(false);
    }
    com.tencent.liteav.basic.util.h.a(this.ab, paramInt, paramBundle);
    if (paramInt == -1314)
    {
      TXCEventRecorderProxy.a(getID(), 2002, 5L, -1L, "", this.F);
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
      TXCEventRecorderProxy.a(paramBundle, 4002, l1, paramInt, "", this.F);
      AppMethodBeat.o(229704);
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
          TXCEventRecorderProxy.a(paramBundle, 4001, l1, -1L, "", this.F);
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
    AppMethodBeat.i(229662);
    if (this.e != null)
    {
      boolean bool = this.e.j();
      AppMethodBeat.o(229662);
      return bool;
    }
    AppMethodBeat.o(229662);
    return false;
  }
  
  public boolean q()
  {
    AppMethodBeat.i(229663);
    if (this.e != null)
    {
      boolean bool = this.e.k();
      AppMethodBeat.o(229663);
      return bool;
    }
    AppMethodBeat.o(229663);
    return false;
  }
  
  public int r()
  {
    AppMethodBeat.i(229664);
    if (this.e == null)
    {
      AppMethodBeat.o(229664);
      return 0;
    }
    int i1 = this.e.e();
    AppMethodBeat.o(229664);
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
      if (this.P != null)
      {
        this.P.d();
        this.P = null;
      }
      if (this.R != null)
      {
        this.R.d();
        this.R = null;
      }
      if (this.Q != null)
      {
        this.Q.d();
        this.Q = null;
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
    AppMethodBeat.i(229587);
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
    AppMethodBeat.o(229587);
  }
  
  public void t()
  {
    AppMethodBeat.i(14407);
    TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
    if (this.f != null) {
      this.f.b();
    }
    if (this.P != null)
    {
      this.P.d();
      this.P = null;
    }
    if (this.R != null)
    {
      this.R.d();
      this.R = null;
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
    B();
    A();
    z();
    AppMethodBeat.o(14407);
  }
  
  public void u()
  {
    AppMethodBeat.i(229713);
    Runnable local13 = new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229394);
        d.g(d.this);
        d.i(d.this);
        AppMethodBeat.o(229394);
      }
    };
    ??? = this.e;
    if (??? != null)
    {
      ((k)???).a(local13);
      AppMethodBeat.o(229713);
      return;
    }
    synchronized (this.o)
    {
      local13.run();
      AppMethodBeat.o(229713);
      return;
    }
  }
  
  public void v()
  {
    AppMethodBeat.i(229715);
    if (this.j == null)
    {
      AppMethodBeat.o(229715);
      return;
    }
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229389);
          d.g(d.this);
          AppMethodBeat.o(229389);
        }
      });
      AppMethodBeat.o(229715);
      return;
    }
    B();
    AppMethodBeat.o(229715);
  }
  
  public void w()
  {
    AppMethodBeat.i(229716);
    if (this.n == null)
    {
      AppMethodBeat.o(229716);
      return;
    }
    if (this.e != null)
    {
      this.e.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229392);
          d.i(d.this);
          AppMethodBeat.o(229392);
        }
      });
      AppMethodBeat.o(229716);
      return;
    }
    A();
    AppMethodBeat.o(229716);
  }
  
  public static abstract interface a
  {
    public abstract void onBackgroudPushStop();
    
    public abstract void onEncVideo(TXSNALPacket paramTXSNALPacket);
    
    public abstract void onEncVideoFormat(MediaFormat paramMediaFormat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.d
 * JD-Core Version:    0.7.0.1
 */