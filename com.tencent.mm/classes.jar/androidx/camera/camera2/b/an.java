package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.camera2.b.a.c.a;
import androidx.camera.camera2.b.a.i;
import androidx.camera.core.impl.a.b.d;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

class an
  extends am.a
  implements am, ap.b
{
  final ac AO;
  private final ScheduledExecutorService Ay;
  final Handler Ej;
  am.a Ek;
  androidx.camera.camera2.b.a.c El;
  com.google.b.b.a.f<Void> Em;
  b.a<Void> En;
  private com.google.b.b.a.f<List<Surface>> Eo;
  private List<ad> Ep;
  private boolean Eq;
  private boolean Er;
  private boolean mClosed;
  final Executor mExecutor;
  final Object mLock;
  
  an(ac paramac, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler)
  {
    AppMethodBeat.i(197358);
    this.mLock = new Object();
    this.Ep = null;
    this.mClosed = false;
    this.Eq = false;
    this.Er = false;
    this.AO = paramac;
    this.Ej = paramHandler;
    this.mExecutor = paramExecutor;
    this.Ay = paramScheduledExecutorService;
    AppMethodBeat.o(197358);
  }
  
  public com.google.b.b.a.f<Void> F(String paramString)
  {
    AppMethodBeat.i(197450);
    paramString = e.v(null);
    AppMethodBeat.o(197450);
    return paramString;
  }
  
  public int a(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197512);
    androidx.core.f.f.checkNotNull(this.El, "Need to call openCaptureSession before using this API.");
    androidx.camera.camera2.b.a.c localc = this.El;
    Executor localExecutor = this.mExecutor;
    int i = localc.EX.a(paramCaptureRequest, localExecutor, paramCaptureCallback);
    AppMethodBeat.o(197512);
    return i;
  }
  
  public final int a(List<CaptureRequest> paramList, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197509);
    androidx.core.f.f.checkNotNull(this.El, "Need to call openCaptureSession before using this API.");
    androidx.camera.camera2.b.a.c localc = this.El;
    Executor localExecutor = this.mExecutor;
    int i = localc.EX.a(paramList, localExecutor, paramCaptureCallback);
    AppMethodBeat.o(197509);
    return i;
  }
  
  public final g a(List<androidx.camera.camera2.b.a.a.b> paramList, am.a parama)
  {
    AppMethodBeat.i(197471);
    this.Ek = parama;
    paramList = new g(0, paramList, this.mExecutor, new CameraCaptureSession.StateCallback()
    {
      public final void onActive(CameraCaptureSession paramAnonymousCameraCaptureSession)
      {
        AppMethodBeat.i(197933);
        an.this.a(paramAnonymousCameraCaptureSession);
        an.this.g(an.this);
        AppMethodBeat.o(197933);
      }
      
      public final void onCaptureQueueEmpty(CameraCaptureSession paramAnonymousCameraCaptureSession)
      {
        AppMethodBeat.i(197939);
        an.this.a(paramAnonymousCameraCaptureSession);
        an.this.h(an.this);
        AppMethodBeat.o(197939);
      }
      
      public final void onClosed(CameraCaptureSession paramAnonymousCameraCaptureSession)
      {
        AppMethodBeat.i(197969);
        an.this.a(paramAnonymousCameraCaptureSession);
        an.this.i(an.this);
        AppMethodBeat.o(197969);
      }
      
      /* Error */
      public final void onConfigureFailed(CameraCaptureSession arg1)
      {
        // Byte code:
        //   0: ldc 48
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   9: aload_1
        //   10: invokevirtual 30	androidx/camera/camera2/b/an:a	(Landroid/hardware/camera2/CameraCaptureSession;)V
        //   13: aload_0
        //   14: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   17: aload_0
        //   18: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   21: invokevirtual 51	androidx/camera/camera2/b/an:d	(Landroidx/camera/camera2/b/am;)V
        //   24: aload_0
        //   25: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   28: getfield 55	androidx/camera/camera2/b/an:mLock	Ljava/lang/Object;
        //   31: astore_1
        //   32: aload_1
        //   33: monitorenter
        //   34: aload_0
        //   35: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   38: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   41: ldc 61
        //   43: invokestatic 67	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   46: pop
        //   47: aload_0
        //   48: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   51: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   54: astore_2
        //   55: aload_0
        //   56: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   59: aconst_null
        //   60: putfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   63: aload_1
        //   64: monitorexit
        //   65: aload_2
        //   66: new 69	java/lang/IllegalStateException
        //   69: dup
        //   70: ldc 70
        //   72: invokespecial 73	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   75: invokevirtual 78	androidx/c/a/b$a:h	(Ljava/lang/Throwable;)Z
        //   78: pop
        //   79: ldc 48
        //   81: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   84: return
        //   85: astore_2
        //   86: aload_1
        //   87: monitorexit
        //   88: ldc 48
        //   90: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   93: aload_2
        //   94: athrow
        //   95: astore_2
        //   96: aload_0
        //   97: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   100: getfield 55	androidx/camera/camera2/b/an:mLock	Ljava/lang/Object;
        //   103: astore_1
        //   104: aload_1
        //   105: monitorenter
        //   106: aload_0
        //   107: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   110: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   113: ldc 61
        //   115: invokestatic 67	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   118: pop
        //   119: aload_0
        //   120: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   123: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   126: astore_3
        //   127: aload_0
        //   128: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   131: aconst_null
        //   132: putfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   135: aload_1
        //   136: monitorexit
        //   137: aload_3
        //   138: new 69	java/lang/IllegalStateException
        //   141: dup
        //   142: ldc 70
        //   144: invokespecial 73	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
        //   147: invokevirtual 78	androidx/c/a/b$a:h	(Ljava/lang/Throwable;)Z
        //   150: pop
        //   151: ldc 48
        //   153: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   156: aload_2
        //   157: athrow
        //   158: astore_2
        //   159: aload_1
        //   160: monitorexit
        //   161: ldc 48
        //   163: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   166: aload_2
        //   167: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	168	0	this	2
        //   54	12	2	locala1	b.a
        //   85	9	2	localObject1	Object
        //   95	62	2	localObject2	Object
        //   158	9	2	localObject3	Object
        //   126	12	3	locala2	b.a
        // Exception table:
        //   from	to	target	type
        //   34	65	85	finally
        //   5	24	95	finally
        //   106	137	158	finally
      }
      
      /* Error */
      public final void onConfigured(CameraCaptureSession arg1)
      {
        // Byte code:
        //   0: ldc 80
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   9: aload_1
        //   10: invokevirtual 30	androidx/camera/camera2/b/an:a	(Landroid/hardware/camera2/CameraCaptureSession;)V
        //   13: aload_0
        //   14: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   17: aload_0
        //   18: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   21: invokevirtual 82	androidx/camera/camera2/b/an:a	(Landroidx/camera/camera2/b/am;)V
        //   24: aload_0
        //   25: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   28: getfield 55	androidx/camera/camera2/b/an:mLock	Ljava/lang/Object;
        //   31: astore_1
        //   32: aload_1
        //   33: monitorenter
        //   34: aload_0
        //   35: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   38: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   41: ldc 61
        //   43: invokestatic 67	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   46: pop
        //   47: aload_0
        //   48: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   51: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   54: astore_2
        //   55: aload_0
        //   56: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   59: aconst_null
        //   60: putfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   63: aload_1
        //   64: monitorexit
        //   65: aload_2
        //   66: aconst_null
        //   67: invokevirtual 86	androidx/c/a/b$a:ap	(Ljava/lang/Object;)Z
        //   70: pop
        //   71: ldc 80
        //   73: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: return
        //   77: astore_2
        //   78: aload_1
        //   79: monitorexit
        //   80: ldc 80
        //   82: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   85: aload_2
        //   86: athrow
        //   87: astore_2
        //   88: aload_0
        //   89: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   92: getfield 55	androidx/camera/camera2/b/an:mLock	Ljava/lang/Object;
        //   95: astore_1
        //   96: aload_1
        //   97: monitorenter
        //   98: aload_0
        //   99: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   102: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   105: ldc 61
        //   107: invokestatic 67	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   110: pop
        //   111: aload_0
        //   112: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   115: getfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   118: astore_3
        //   119: aload_0
        //   120: getfield 15	androidx/camera/camera2/b/an$2:Es	Landroidx/camera/camera2/b/an;
        //   123: aconst_null
        //   124: putfield 59	androidx/camera/camera2/b/an:En	Landroidx/c/a/b$a;
        //   127: aload_1
        //   128: monitorexit
        //   129: aload_3
        //   130: aconst_null
        //   131: invokevirtual 86	androidx/c/a/b$a:ap	(Ljava/lang/Object;)Z
        //   134: pop
        //   135: ldc 80
        //   137: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   140: aload_2
        //   141: athrow
        //   142: astore_2
        //   143: aload_1
        //   144: monitorexit
        //   145: ldc 80
        //   147: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   150: aload_2
        //   151: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	152	0	this	2
        //   54	12	2	locala1	b.a
        //   77	9	2	localObject1	Object
        //   87	54	2	localObject2	Object
        //   142	9	2	localObject3	Object
        //   118	12	3	locala2	b.a
        // Exception table:
        //   from	to	target	type
        //   34	65	77	finally
        //   5	24	87	finally
        //   98	129	142	finally
      }
      
      public final void onReady(CameraCaptureSession paramAnonymousCameraCaptureSession)
      {
        AppMethodBeat.i(197927);
        an.this.a(paramAnonymousCameraCaptureSession);
        an.this.b(an.this);
        AppMethodBeat.o(197927);
      }
      
      public final void onSurfacePrepared(CameraCaptureSession paramAnonymousCameraCaptureSession, Surface paramAnonymousSurface)
      {
        AppMethodBeat.i(197944);
        an.this.a(paramAnonymousCameraCaptureSession);
        an.this.a(an.this, paramAnonymousSurface);
        AppMethodBeat.o(197944);
      }
    });
    AppMethodBeat.o(197471);
    return paramList;
  }
  
  public com.google.b.b.a.f<Void> a(CameraDevice paramCameraDevice, g paramg, List<ad> paramList)
  {
    AppMethodBeat.i(197459);
    synchronized (this.mLock)
    {
      if (this.Eq)
      {
        paramCameraDevice = e.i(new CancellationException("Opener is disabled"));
        AppMethodBeat.o(197459);
        return paramCameraDevice;
      }
      ac localac = this.AO;
      synchronized (localac.mLock)
      {
        localac.CF.add(this);
        this.Em = androidx.c.a.b.a(new an..ExternalSyntheticLambda0(this, paramList, new i(paramCameraDevice, this.Ej), paramg));
        e.a(this.Em, new androidx.camera.core.impl.a.b.c()
        {
          public final void onFailure(Throwable paramAnonymousThrowable)
          {
            AppMethodBeat.i(197923);
            an.this.hJ();
            an.this.AO.f(an.this);
            AppMethodBeat.o(197923);
          }
        }, androidx.camera.core.impl.a.a.b.kP());
        paramCameraDevice = e.d(this.Em);
        AppMethodBeat.o(197459);
        return paramCameraDevice;
      }
    }
  }
  
  public com.google.b.b.a.f<List<Surface>> a(List<ad> paramList, long paramLong)
  {
    AppMethodBeat.i(197490);
    synchronized (this.mLock)
    {
      if (this.Eq)
      {
        paramList = e.i(new CancellationException("Opener is disabled"));
        AppMethodBeat.o(197490);
        return paramList;
      }
      this.Eo = d.c(ae.a(paramList, paramLong, this.mExecutor, this.Ay)).a(new an..ExternalSyntheticLambda1(this, paramList), this.mExecutor);
      paramList = e.d(this.Eo);
      AppMethodBeat.o(197490);
      return paramList;
    }
  }
  
  final void a(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197480);
    if (this.El == null) {
      this.El = new androidx.camera.camera2.b.a.c(paramCameraCaptureSession, this.Ej);
    }
    AppMethodBeat.o(197480);
  }
  
  public void a(am paramam)
  {
    AppMethodBeat.i(197552);
    ac localac = this.AO;
    synchronized (localac.mLock)
    {
      localac.CD.add(this);
      localac.CF.remove(this);
      localac.e(this);
      this.Ek.a(paramam);
      AppMethodBeat.o(197552);
      return;
    }
  }
  
  public final void a(am paramam, Surface paramSurface)
  {
    AppMethodBeat.i(197545);
    this.Ek.a(paramam, paramSurface);
    AppMethodBeat.o(197545);
  }
  
  public final void b(am paramam)
  {
    AppMethodBeat.i(197533);
    this.Ek.b(paramam);
    AppMethodBeat.o(197533);
  }
  
  final void c(am paramam)
  {
    AppMethodBeat.i(197574);
    com.google.b.b.a.f localf = null;
    synchronized (this.mLock)
    {
      if (!this.Er)
      {
        this.Er = true;
        androidx.core.f.f.checkNotNull(this.Em, "Need to call openCaptureSession before using this API.");
        localf = this.Em;
      }
      if (localf != null) {
        localf.a(new an..ExternalSyntheticLambda3(this, paramam), androidx.camera.core.impl.a.a.b.kP());
      }
      AppMethodBeat.o(197574);
      return;
    }
  }
  
  public void close()
  {
    AppMethodBeat.i(197526);
    androidx.core.f.f.checkNotNull(this.El, "Need to call openCaptureSession before using this API.");
    ac localac = this.AO;
    synchronized (localac.mLock)
    {
      localac.CE.add(this);
      this.El.hR().close();
      this.mExecutor.execute(new an..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(197526);
      return;
    }
  }
  
  public final void d(am paramam)
  {
    AppMethodBeat.i(197559);
    hJ();
    this.AO.f(this);
    this.Ek.d(paramam);
    AppMethodBeat.o(197559);
  }
  
  public final void g(am paramam)
  {
    AppMethodBeat.i(197535);
    this.Ek.g(paramam);
    AppMethodBeat.o(197535);
  }
  
  public final void gG()
  {
    AppMethodBeat.i(369502);
    hJ();
    AppMethodBeat.o(369502);
  }
  
  public final void h(am paramam)
  {
    AppMethodBeat.i(197540);
    this.Ek.h(paramam);
    AppMethodBeat.o(197540);
  }
  
  public final CameraDevice hC()
  {
    AppMethodBeat.i(197503);
    androidx.core.f.f.checkNotNull(this.El);
    CameraDevice localCameraDevice = this.El.hR().getDevice();
    AppMethodBeat.o(197503);
    return localCameraDevice;
  }
  
  public final am.a hD()
  {
    return this;
  }
  
  public final androidx.camera.camera2.b.a.c hE()
  {
    AppMethodBeat.i(197497);
    androidx.core.f.f.checkNotNull(this.El);
    androidx.camera.camera2.b.a.c localc = this.El;
    AppMethodBeat.o(197497);
    return localc;
  }
  
  public final void hF()
  {
    AppMethodBeat.i(197516);
    androidx.core.f.f.checkNotNull(this.El, "Need to call openCaptureSession before using this API.");
    this.El.hR().stopRepeating();
    AppMethodBeat.o(197516);
  }
  
  public final void hG()
  {
    AppMethodBeat.i(197521);
    androidx.core.f.f.checkNotNull(this.El, "Need to call openCaptureSession before using this API.");
    this.El.hR().abortCaptures();
    AppMethodBeat.o(197521);
  }
  
  final boolean hH()
  {
    synchronized (this.mLock)
    {
      if (this.Em != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  public final Executor hI()
  {
    return this.mExecutor;
  }
  
  final void hJ()
  {
    AppMethodBeat.i(197583);
    synchronized (this.mLock)
    {
      if (this.Ep != null)
      {
        ae.J(this.Ep);
        this.Ep = null;
      }
      AppMethodBeat.o(197583);
      return;
    }
  }
  
  public void i(am paramam)
  {
    AppMethodBeat.i(197570);
    com.google.b.b.a.f localf = null;
    synchronized (this.mLock)
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        androidx.core.f.f.checkNotNull(this.Em, "Need to call openCaptureSession before using this API.");
        localf = this.Em;
      }
      hJ();
      if (localf != null) {
        localf.a(new an..ExternalSyntheticLambda4(this, paramam), androidx.camera.core.impl.a.a.b.kP());
      }
      AppMethodBeat.o(197570);
      return;
    }
  }
  
  /* Error */
  public boolean stop()
  {
    // Byte code:
    //   0: ldc_w 444
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 6
    //   14: aconst_null
    //   15: astore 5
    //   17: aload 6
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 94	androidx/camera/camera2/b/an:mLock	Ljava/lang/Object;
    //   24: astore 7
    //   26: aload 6
    //   28: astore_3
    //   29: aload 7
    //   31: monitorenter
    //   32: aload_2
    //   33: astore_3
    //   34: aload 4
    //   36: astore_2
    //   37: aload_0
    //   38: getfield 100	androidx/camera/camera2/b/an:Eq	Z
    //   41: ifne +31 -> 72
    //   44: aload 5
    //   46: astore_3
    //   47: aload 4
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 344	androidx/camera/camera2/b/an:Eo	Lcom/google/b/b/a/f;
    //   54: ifnull +11 -> 65
    //   57: aload 4
    //   59: astore_2
    //   60: aload_0
    //   61: getfield 344	androidx/camera/camera2/b/an:Eo	Lcom/google/b/b/a/f;
    //   64: astore_3
    //   65: aload_3
    //   66: astore_2
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 100	androidx/camera/camera2/b/an:Eq	Z
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: invokevirtual 446	androidx/camera/camera2/b/an:hH	()Z
    //   78: ifne +30 -> 108
    //   81: iconst_1
    //   82: istore_1
    //   83: aload_3
    //   84: astore_2
    //   85: aload 7
    //   87: monitorexit
    //   88: aload_3
    //   89: ifnull +11 -> 100
    //   92: aload_3
    //   93: iconst_1
    //   94: invokeinterface 450 2 0
    //   99: pop
    //   100: ldc_w 444
    //   103: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iload_1
    //   107: ireturn
    //   108: iconst_0
    //   109: istore_1
    //   110: goto -27 -> 83
    //   113: astore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload 7
    //   119: monitorexit
    //   120: aload_2
    //   121: astore_3
    //   122: ldc_w 444
    //   125: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_2
    //   129: astore_3
    //   130: aload 4
    //   132: athrow
    //   133: astore_2
    //   134: aload_3
    //   135: ifnull +11 -> 146
    //   138: aload_3
    //   139: iconst_1
    //   140: invokeinterface 450 2 0
    //   145: pop
    //   146: ldc_w 444
    //   149: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	an
    //   82	28	1	bool	boolean
    //   7	122	2	localObject1	Object
    //   133	20	2	localObject2	Object
    //   19	120	3	localObject3	Object
    //   9	49	4	localObject4	Object
    //   113	18	4	localObject5	Object
    //   15	30	5	localObject6	Object
    //   12	15	6	localObject7	Object
    //   24	94	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   37	44	113	finally
    //   50	57	113	finally
    //   60	65	113	finally
    //   67	72	113	finally
    //   74	81	113	finally
    //   85	88	113	finally
    //   20	26	133	finally
    //   29	32	133	finally
    //   117	120	133	finally
    //   122	128	133	finally
    //   130	133	133	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.an
 * JD-Core Version:    0.7.0.1
 */