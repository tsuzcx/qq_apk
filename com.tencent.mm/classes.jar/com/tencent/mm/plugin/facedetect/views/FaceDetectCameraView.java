package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;

public class FaceDetectCameraView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static a sVu = null;
  private ActivityManager aJf;
  private int height;
  private boolean lPD;
  private SurfaceTexture mSurfaceTexture;
  private boolean pfT;
  private long sQK;
  b sVg;
  private long sVh;
  private long sVi;
  private int sVj;
  private boolean sVk;
  private boolean sVl;
  private final Object sVm;
  private boolean sVn;
  private boolean sVo;
  private final Object sVp;
  private final Object sVq;
  private Rect sVr;
  private c sVs;
  private boolean sVt;
  public b sVv;
  private byte[] sVw;
  private boolean sVx;
  private long sVy;
  private int width;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104113);
    this.sVg = null;
    this.mSurfaceTexture = null;
    this.sVh = FaceDetectView.sWf;
    this.sVi = -1L;
    this.sQK = -1L;
    this.sVj = 1;
    this.lPD = false;
    this.sVk = false;
    this.sVl = false;
    this.sVm = new Object();
    this.sVn = false;
    this.sVo = false;
    this.pfT = false;
    this.sVp = new Object();
    this.sVq = new Object();
    this.sVr = null;
    this.width = 324;
    this.height = 576;
    this.sVs = null;
    this.sVt = false;
    this.sVv = null;
    this.sVw = null;
    this.sVx = false;
    this.sVy = -1L;
    this.aJf = ((ActivityManager)getContext().getSystemService("activity"));
    Log.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.sVt) });
    this.sVv = new c((byte)0);
    sVu = new a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(104113);
  }
  
  private static void cTJ()
  {
    AppMethodBeat.i(104117);
    Log.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.cSU();
    AppMethodBeat.o(104117);
  }
  
  /* Error */
  private void cTM()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 422
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 166
    //   10: ldc_w 424
    //   13: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:sQM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cSY	()I
    //   22: pop
    //   23: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:sQM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   26: getfield 284	com/tencent/mm/plugin/facedetect/model/f:sQN	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   29: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:sSO	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 303	com/tencent/mm/plugin/facedetect/model/g:sQQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   39: ifnonnull +59 -> 98
    //   42: ldc_w 292
    //   45: ldc_w 429
    //   48: invokestatic 308	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:sQM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   54: invokevirtual 432	com/tencent/mm/plugin/facedetect/model/f:cSZ	()I
    //   57: istore_1
    //   58: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   61: lstore_2
    //   62: ldc 166
    //   64: ldc_w 439
    //   67: iconst_1
    //   68: anewarray 116	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: lload_2
    //   74: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: aastore
    //   78: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic 360	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:cTe	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   84: iload_1
    //   85: lload_2
    //   86: invokevirtual 442	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:ad	(IJ)V
    //   89: ldc_w 422
    //   92: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 292
    //   101: ldc_w 444
    //   104: invokestatic 417	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: getfield 303	com/tencent/mm/plugin/facedetect/model/g:sQQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   112: invokevirtual 447	com/tencent/mm/plugin/facedetect/FaceProNative:engineGetCurrMotion	()I
    //   115: pop
    //   116: goto -65 -> 51
    //   119: astore 4
    //   121: aload_0
    //   122: monitorexit
    //   123: aload 4
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	FaceDetectCameraView
    //   57	28	1	i	int
    //   61	25	2	l	long
    //   32	76	4	localg	g
    //   119	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	51	119	finally
    //   51	95	119	finally
    //   98	116	119	finally
  }
  
  public final void a(Rect paramRect, long paramLong)
  {
    try
    {
      AppMethodBeat.i(104116);
      cTJ();
      this.sVr = paramRect;
      cTM();
      this.sVv.DG(paramLong);
      AppMethodBeat.o(104116);
      return;
    }
    finally
    {
      paramRect = finally;
      throw paramRect;
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(104115);
    this.sVv.a(paramc);
    this.sQK = -1L;
    AppMethodBeat.o(104115);
  }
  
  public final void cTK()
  {
    AppMethodBeat.i(104119);
    cTL();
    f.sQM.sQN.sSO.cTc();
    AppMethodBeat.o(104119);
  }
  
  public final void cTL()
  {
    AppMethodBeat.i(104120);
    this.pfT = false;
    this.sVv.cTP();
    cTJ();
    int i = f.sQM.cSZ();
    long l = System.currentTimeMillis();
    Log.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.cTe().ae(i, l);
    AppMethodBeat.o(104120);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult cTN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 504
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 420	com/tencent/mm/plugin/facedetect/model/f:cSU	()V
    //   11: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:sQM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   14: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cSY	()I
    //   17: istore_2
    //   18: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:sQM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   21: getfield 284	com/tencent/mm/plugin/facedetect/model/f:sQN	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   24: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:sSO	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   27: invokevirtual 507	com/tencent/mm/plugin/facedetect/model/g:cTb	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +44 -> 76
    //   35: aload_3
    //   36: getfield 510	com/tencent/mm/plugin/facedetect/FaceProNative$FaceResult:result	I
    //   39: istore_1
    //   40: ldc 166
    //   42: ldc_w 512
    //   45: iconst_2
    //   46: anewarray 116	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: iload_1
    //   59: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 504
    //   69: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: areturn
    //   76: sipush -10000
    //   79: istore_1
    //   80: goto -40 -> 40
    //   83: astore_3
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_3
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	FaceDetectCameraView
    //   39	41	1	i	int
    //   17	35	2	j	int
    //   30	45	3	localFaceResult	com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult
    //   83	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	31	83	finally
    //   35	40	83	finally
    //   40	72	83	finally
  }
  
  public final int getCameraRotation()
  {
    AppMethodBeat.i(104128);
    int i = this.sVv.getRotation();
    AppMethodBeat.o(104128);
    return i;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    AppMethodBeat.i(104114);
    Point localPoint = this.sVv.cTQ();
    AppMethodBeat.o(104114);
    return localPoint;
  }
  
  public final Bitmap getPreviewBm()
  {
    AppMethodBeat.i(104126);
    Bitmap localBitmap = getBitmap();
    AppMethodBeat.o(104126);
    return localBitmap;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(104130);
    int i = this.sVv.getPreviewHeight();
    AppMethodBeat.o(104130);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(104129);
    int i = this.sVv.getPreviewWidth();
    AppMethodBeat.o(104129);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(104124);
    super.onAttachedToWindow();
    Log.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    AppMethodBeat.o(104124);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104127);
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    Log.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    AppMethodBeat.o(104127);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104118);
    Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
    gLi();
    this.lPD = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.sVo) {
      a(this.sVs);
    }
    AppMethodBeat.o(104118);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104123);
    Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.lPD = false;
    AppMethodBeat.o(104123);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104122);
    Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(104122);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  final void setCallback(b paramb)
  {
    this.sVg = paramb;
  }
  
  static final class a
    extends MMHandler
  {
    private WeakReference<FaceDetectCameraView> Rd;
    
    private a(FaceDetectCameraView paramFaceDetectCameraView)
    {
      super();
      AppMethodBeat.i(104093);
      this.Rd = new WeakReference(paramFaceDetectCameraView);
      AppMethodBeat.o(104093);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(104094);
      super.handleMessage(paramMessage);
      if ((this.Rd == null) || (this.Rd.get() == null))
      {
        Log.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        AppMethodBeat.o(104094);
        return;
      }
      if (paramMessage.what == 1)
      {
        paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
        if (FaceCharacteristicsResult.HI(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()).d(paramMessage);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceCharacteristicsResult.HH(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()).a(paramMessage.errCode, paramMessage.errMsg);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()) != null) {
          FaceDetectCameraView.a((FaceDetectCameraView)this.Rd.get()).c(paramMessage);
        }
      }
      AppMethodBeat.o(104094);
    }
  }
  
  public static abstract interface b
  {
    public abstract void DG(long paramLong);
    
    public abstract void a(c paramc);
    
    public abstract void cTO();
    
    public abstract void cTP();
    
    public abstract Point cTQ();
    
    public abstract int getPreviewHeight();
    
    public abstract int getPreviewWidth();
    
    public abstract int getRotation();
    
    public abstract void stopPreview();
  }
  
  final class c
    implements FaceDetectCameraView.b
  {
    n sVD;
    Camera.PreviewCallback sVE;
    private d.b sVF;
    
    private c()
    {
      AppMethodBeat.i(104103);
      this.sVD = null;
      this.sVE = new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(104100);
          Log.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
          d.cSR().bB(paramAnonymousArrayOfByte);
          AppMethodBeat.o(104100);
        }
      };
      this.sVF = new d.b()
      {
        public final void bC(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(104102);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this))
          {
            if (FaceDetectCameraView.o(FaceDetectCameraView.this) == null) {
              FaceDetectCameraView.a(FaceDetectCameraView.this, com.tencent.mm.plugin.facedetect.model.c.sQB.h(Integer.valueOf(paramAnonymousArrayOfByte.length)));
            }
            if ((FaceDetectCameraView.o(FaceDetectCameraView.this) == null) || (FaceDetectCameraView.o(FaceDetectCameraView.this).length < paramAnonymousArrayOfByte.length))
            {
              AppMethodBeat.o(104102);
              return;
            }
            System.arraycopy(paramAnonymousArrayOfByte, 0, FaceDetectCameraView.o(FaceDetectCameraView.this), 0, paramAnonymousArrayOfByte.length);
            FaceDetectCameraView.a(FaceDetectCameraView.this, paramAnonymousArrayOfByte);
          }
          com.tencent.mm.plugin.facedetect.model.c.sQB.k(paramAnonymousArrayOfByte);
          f.cSV().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104101);
              Log.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
              long l1 = Util.currentTicks();
              long l2 = l1 - FaceDetectCameraView.p(FaceDetectCameraView.this);
              if (FaceDetectCameraView.p(FaceDetectCameraView.this) >= 0L) {
                Log.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[] { Long.valueOf(l2) });
              }
              if ((FaceDetectCameraView.p(FaceDetectCameraView.this) < 0L) || (l2 > FaceDetectCameraView.c(FaceDetectCameraView.this)))
              {
                FaceDetectCameraView.a(FaceDetectCameraView.this, l1);
                FaceDetectCameraView.b(FaceDetectCameraView.this, FaceDetectCameraView.o(FaceDetectCameraView.this));
              }
              AppMethodBeat.o(104101);
            }
          });
          AppMethodBeat.o(104102);
        }
        
        public final a<byte[]> cSS()
        {
          return com.tencent.mm.plugin.facedetect.model.c.sQB;
        }
      };
      this.sVD = new n(FaceDetectCameraView.this.getContext());
      FaceDetectCameraView.a(FaceDetectCameraView.this, -1L);
      FaceDetectCameraView.d(FaceDetectCameraView.this);
      AppMethodBeat.o(104103);
    }
    
    public final void DG(long paramLong)
    {
      AppMethodBeat.i(104110);
      for (;;)
      {
        synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
        {
          if (this.sVD == null)
          {
            Log.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            AppMethodBeat.o(104110);
            return;
          }
          Log.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
          FaceDetectCameraView.b(FaceDetectCameraView.this, paramLong);
          if (!FaceDetectCameraView.q(FaceDetectCameraView.this))
          {
            if ((this.sVD != null) && (this.sVD.sRE))
            {
              Log.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
              FaceDetectCameraView.a(FaceDetectCameraView.this, false);
              d.cSR().a(this.sVF);
              FaceDetectCameraView.r(FaceDetectCameraView.this);
              AppMethodBeat.o(104110);
              return;
            }
            Log.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
            FaceDetectCameraView.a(FaceDetectCameraView.this, true);
          }
        }
        Log.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
      }
    }
    
    public final void a(c arg1)
    {
      AppMethodBeat.i(104104);
      FaceDetectCameraView.a(FaceDetectCameraView.this, ???);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if (this.sVD == null)
        {
          Log.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          AppMethodBeat.o(104104);
          return;
        }
        if (this.sVD.sRE)
        {
          Log.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
          FaceDetectCameraView.f(FaceDetectCameraView.this);
          AppMethodBeat.o(104104);
          return;
        }
        FaceDetectCameraView.g(FaceDetectCameraView.this);
        if (FaceDetectCameraView.h(FaceDetectCameraView.this)) {
          break label172;
        }
        if (FaceDetectCameraView.this.isAvailable())
        {
          Log.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
          FaceDetectCameraView.this.onSurfaceTextureAvailable(FaceDetectCameraView.this.getSurfaceTexture(), FaceDetectCameraView.this.getWidth(), FaceDetectCameraView.this.getHeight());
          AppMethodBeat.o(104104);
          return;
        }
      }
      Log.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
      AppMethodBeat.o(104104);
      return;
      label172:
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          int i = 1;
          AppMethodBeat.i(104098);
          synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
          {
            Log.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(Util.ticksToNow(this.sVG)) });
            long l1 = Util.currentTicks();
            if (FaceDetectCameraView.c.this.sVD == null)
            {
              Log.e("MicroMsg.FaceDetectCameraView", "hy: already released");
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104095);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).HR(1);
                    AppMethodBeat.o(104095);
                  }
                });
              }
              AppMethodBeat.o(104098);
              return;
            }
            try
            {
              FaceDetectCameraView.c.this.sVD.pbD = new Point(FaceDetectCameraView.j(FaceDetectCameraView.this), FaceDetectCameraView.k(FaceDetectCameraView.this));
              Object localObject2 = FaceDetectCameraView.c.this.sVD;
              if ((((n)localObject2).gGr != null) && (((n)localObject2).jyo)) {}
              for (;;)
              {
                if (i == 0) {
                  FaceDetectCameraView.c.this.sVD.i(FaceDetectCameraView.l(FaceDetectCameraView.this));
                }
                localObject2 = FaceDetectCameraView.c.this.sVD.sRF;
                FaceDetectCameraView.a(FaceDetectCameraView.this, (Point)localObject2);
                localObject2 = FaceDetectCameraView.c.this.sVD;
                SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(FaceDetectCameraView.this);
                long l2 = Util.currentTicks();
                if ((((n)localObject2).gGr != null) && (!((n)localObject2).sRE))
                {
                  if (localSurfaceTexture != null)
                  {
                    Log.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
                    ((n)localObject2).gGr.setPreviewTexture(localSurfaceTexture);
                  }
                  com.tencent.mm.plugin.facedetect.model.c.dj(((n)localObject2).getPreviewWidth(), ((n)localObject2).getPreviewHeight());
                  ((n)localObject2).gGr.startPreview();
                  ((n)localObject2).sRE = true;
                  Log.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
                }
                FaceDetectCameraView.c.this.sVD.setPreviewCallback(FaceDetectCameraView.c.this.sVE);
                if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(104096);
                      FaceDetectCameraView.i(FaceDetectCameraView.this).HR(0);
                      AppMethodBeat.o(104096);
                    }
                  });
                }
                Log.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
                FaceDetectCameraView.f(FaceDetectCameraView.this);
                AppMethodBeat.o(104098);
                return;
                i = 0;
              }
              localObject3 = finally;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.FaceDetectCameraView", localException, "hy: exception caused", new Object[0]);
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104097);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).HR(2);
                    AppMethodBeat.o(104097);
                  }
                });
              }
              AppMethodBeat.o(104098);
              return;
            }
          }
        }
      }, "FaceDetectCameraView_Camera");
      AppMethodBeat.o(104104);
    }
    
    public final void cTO()
    {
      AppMethodBeat.i(104106);
      if (!FaceDetectCameraView.m(FaceDetectCameraView.this))
      {
        FaceDetectCameraView.b(FaceDetectCameraView.this, true);
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104099);
            synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
            {
              if (FaceDetectCameraView.c.this.sVD == null)
              {
                AppMethodBeat.o(104099);
                return;
              }
              Log.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
              FaceDetectCameraView.c.this.sVD.setPreviewCallback(null);
              d.cSR().clear();
              if (FaceDetectCameraView.l(FaceDetectCameraView.this) != null) {
                FaceDetectCameraView.l(FaceDetectCameraView.this).release();
              }
              FaceDetectCameraView.c.this.sVD.release();
              FaceDetectCameraView.c.this.sVD = null;
              Log.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
              FaceDetectCameraView.b(FaceDetectCameraView.this, false);
              AppMethodBeat.o(104099);
              return;
            }
          }
        }, "FaceDetectCameraView_Camera");
      }
      AppMethodBeat.o(104106);
    }
    
    public final void cTP()
    {
      AppMethodBeat.i(104111);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.sVD != null) && (this.sVD.sRE))
        {
          d.cSR().b(this.sVF);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this)) {
            FaceDetectCameraView.a(FaceDetectCameraView.this, null);
          }
        }
        AppMethodBeat.o(104111);
        return;
      }
    }
    
    public final Point cTQ()
    {
      AppMethodBeat.i(104112);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        Point localPoint = this.sVD.sRK;
        AppMethodBeat.o(104112);
        return localPoint;
      }
    }
    
    public final int getPreviewHeight()
    {
      AppMethodBeat.i(104108);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.sVD.getPreviewHeight();
        AppMethodBeat.o(104108);
        return i;
      }
    }
    
    public final int getPreviewWidth()
    {
      AppMethodBeat.i(104107);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.sVD.getPreviewWidth();
        AppMethodBeat.o(104107);
        return i;
      }
    }
    
    public final int getRotation()
    {
      AppMethodBeat.i(104109);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.sVD.sRI;
        AppMethodBeat.o(104109);
        return i;
      }
    }
    
    public final void stopPreview()
    {
      AppMethodBeat.i(104105);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.sVD != null) && (this.sVD.sRE))
        {
          n localn = this.sVD;
          if (localn.gGr != null)
          {
            localn.gGr.stopPreview();
            localn.sRE = false;
            com.tencent.mm.plugin.facedetect.model.c.sQB.aRR();
          }
        }
        AppMethodBeat.o(104105);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */