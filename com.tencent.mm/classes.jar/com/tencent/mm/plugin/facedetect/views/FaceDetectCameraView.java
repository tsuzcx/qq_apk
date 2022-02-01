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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;
import java.util.List;

public class FaceDetectCameraView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static a rvx = null;
  private ActivityManager aJm;
  private int height;
  private boolean kKW;
  private SurfaceTexture mSurfaceTexture;
  private boolean nUW;
  private long rpm;
  private boolean rvA;
  private long rvB;
  b rvj;
  private long rvk;
  private long rvl;
  private int rvm;
  private boolean rvn;
  private boolean rvo;
  private final Object rvp;
  private boolean rvq;
  private boolean rvr;
  private final Object rvs;
  private final Object rvt;
  private Rect rvu;
  private c rvv;
  private boolean rvw;
  public b rvy;
  private byte[] rvz;
  private int width;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104113);
    this.rvj = null;
    this.mSurfaceTexture = null;
    this.rvk = FaceDetectView.rwi;
    this.rvl = -1L;
    this.rpm = -1L;
    this.rvm = 1;
    this.kKW = false;
    this.rvn = false;
    this.rvo = false;
    this.rvp = new Object();
    this.rvq = false;
    this.rvr = false;
    this.nUW = false;
    this.rvs = new Object();
    this.rvt = new Object();
    this.rvu = null;
    this.width = 324;
    this.height = 576;
    this.rvv = null;
    this.rvw = false;
    this.rvy = null;
    this.rvz = null;
    this.rvA = false;
    this.rvB = -1L;
    this.aJm = ((ActivityManager)getContext().getSystemService("activity"));
    ae.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.rvw) });
    this.rvy = new c((byte)0);
    rvx = new a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(104113);
  }
  
  private static void cvA()
  {
    AppMethodBeat.i(104117);
    ae.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.cuy();
    AppMethodBeat.o(104117);
  }
  
  /* Error */
  private void cvD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 421
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 166
    //   10: ldc_w 423
    //   13: invokestatic 416	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rpo	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: invokevirtual 426	com/tencent/mm/plugin/facedetect/model/f:cuB	()I
    //   22: pop
    //   23: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rpo	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   26: getfield 284	com/tencent/mm/plugin/facedetect/model/f:rpp	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   29: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:rrr	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 303	com/tencent/mm/plugin/facedetect/model/g:rps	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   39: ifnonnull +59 -> 98
    //   42: ldc_w 292
    //   45: ldc_w 428
    //   48: invokestatic 308	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rpo	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   54: invokevirtual 431	com/tencent/mm/plugin/facedetect/model/f:cuC	()I
    //   57: istore_1
    //   58: invokestatic 436	java/lang/System:currentTimeMillis	()J
    //   61: lstore_2
    //   62: ldc 166
    //   64: ldc_w 438
    //   67: iconst_1
    //   68: anewarray 116	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: lload_2
    //   74: invokestatic 375	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: aastore
    //   78: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic 360	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:cuI	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   84: iload_1
    //   85: lload_2
    //   86: invokevirtual 441	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:aa	(IJ)V
    //   89: ldc_w 421
    //   92: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 292
    //   101: ldc_w 443
    //   104: invokestatic 416	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: getfield 303	com/tencent/mm/plugin/facedetect/model/g:rps	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   112: invokevirtual 446	com/tencent/mm/plugin/facedetect/FaceProNative:engineGetCurrMotion	()I
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
      cvA();
      this.rvu = paramRect;
      cvD();
      this.rvy.vC(paramLong);
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
    this.rvy.a(paramc);
    this.rpm = -1L;
    AppMethodBeat.o(104115);
  }
  
  public final void cvB()
  {
    AppMethodBeat.i(104119);
    cvC();
    f.rpo.rpp.rrr.cuG();
    AppMethodBeat.o(104119);
  }
  
  public final void cvC()
  {
    AppMethodBeat.i(104120);
    this.nUW = false;
    this.rvy.cvr();
    cvA();
    int i = f.rpo.cuC();
    long l = System.currentTimeMillis();
    ae.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.cuI().ab(i, l);
    AppMethodBeat.o(104120);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult cvE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 502
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 419	com/tencent/mm/plugin/facedetect/model/f:cuy	()V
    //   11: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rpo	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   14: invokevirtual 426	com/tencent/mm/plugin/facedetect/model/f:cuB	()I
    //   17: istore_2
    //   18: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rpo	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   21: getfield 284	com/tencent/mm/plugin/facedetect/model/f:rpp	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   24: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:rrr	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   27: invokevirtual 505	com/tencent/mm/plugin/facedetect/model/g:cuF	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +44 -> 76
    //   35: aload_3
    //   36: getfield 508	com/tencent/mm/plugin/facedetect/FaceProNative$FaceResult:result	I
    //   39: istore_1
    //   40: ldc 166
    //   42: ldc_w 510
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
    //   63: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: ldc_w 502
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
    int i = this.rvy.getRotation();
    AppMethodBeat.o(104128);
    return i;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    AppMethodBeat.i(104114);
    Point localPoint = this.rvy.cvG();
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
    int i = this.rvy.getPreviewHeight();
    AppMethodBeat.o(104130);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(104129);
    int i = this.rvy.getPreviewWidth();
    AppMethodBeat.o(104129);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(104124);
    super.onAttachedToWindow();
    ae.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    AppMethodBeat.o(104124);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104127);
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    ae.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    AppMethodBeat.o(104127);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104118);
    ae.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
    fDh();
    this.kKW = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.rvr) {
      a(this.rvv);
    }
    AppMethodBeat.o(104118);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104123);
    ae.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.kKW = false;
    AppMethodBeat.o(104123);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104122);
    ae.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(104122);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  final void setCallback(b paramb)
  {
    this.rvj = paramb;
  }
  
  static final class a
    extends aq
  {
    private WeakReference<FaceDetectCameraView> QQ;
    
    private a(FaceDetectCameraView paramFaceDetectCameraView)
    {
      super();
      AppMethodBeat.i(104093);
      this.QQ = new WeakReference(paramFaceDetectCameraView);
      AppMethodBeat.o(104093);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(104094);
      super.handleMessage(paramMessage);
      if ((this.QQ == null) || (this.QQ.get() == null))
      {
        ae.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        AppMethodBeat.o(104094);
        return;
      }
      if (paramMessage.what == 1)
      {
        paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
        if (FaceCharacteristicsResult.DW(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()).d(paramMessage);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceCharacteristicsResult.DV(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()).a(paramMessage.errCode, paramMessage.errMsg);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()) != null) {
          FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()).c(paramMessage);
        }
      }
      AppMethodBeat.o(104094);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc);
    
    public abstract void cvF();
    
    public abstract Point cvG();
    
    public abstract void cvr();
    
    public abstract int getPreviewHeight();
    
    public abstract int getPreviewWidth();
    
    public abstract int getRotation();
    
    public abstract void stopPreview();
    
    public abstract void vC(long paramLong);
  }
  
  final class c
    implements FaceDetectCameraView.b
  {
    n rvG;
    Camera.PreviewCallback rvH;
    private d.b rvI;
    
    private c()
    {
      AppMethodBeat.i(104103);
      this.rvG = null;
      this.rvH = new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(104100);
          ae.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
          d.cup().bk(paramAnonymousArrayOfByte);
          AppMethodBeat.o(104100);
        }
      };
      this.rvI = new d.b()
      {
        public final void bl(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(104102);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this))
          {
            if (FaceDetectCameraView.o(FaceDetectCameraView.this) == null) {
              FaceDetectCameraView.a(FaceDetectCameraView.this, com.tencent.mm.plugin.facedetect.model.c.rpd.h(Integer.valueOf(paramAnonymousArrayOfByte.length)));
            }
            if ((FaceDetectCameraView.o(FaceDetectCameraView.this) == null) || (FaceDetectCameraView.o(FaceDetectCameraView.this).length < paramAnonymousArrayOfByte.length))
            {
              AppMethodBeat.o(104102);
              return;
            }
            System.arraycopy(paramAnonymousArrayOfByte, 0, FaceDetectCameraView.o(FaceDetectCameraView.this), 0, paramAnonymousArrayOfByte.length);
            FaceDetectCameraView.a(FaceDetectCameraView.this, paramAnonymousArrayOfByte);
          }
          com.tencent.mm.plugin.facedetect.model.c.rpd.k(paramAnonymousArrayOfByte);
          f.cuz().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104101);
              ae.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
              long l1 = bu.HQ();
              long l2 = l1 - FaceDetectCameraView.p(FaceDetectCameraView.this);
              if (FaceDetectCameraView.p(FaceDetectCameraView.this) >= 0L) {
                ae.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[] { Long.valueOf(l2) });
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
        
        public final a<byte[]> cuq()
        {
          return com.tencent.mm.plugin.facedetect.model.c.rpd;
        }
      };
      this.rvG = new n(FaceDetectCameraView.this.getContext());
      FaceDetectCameraView.a(FaceDetectCameraView.this, -1L);
      FaceDetectCameraView.d(FaceDetectCameraView.this);
      AppMethodBeat.o(104103);
    }
    
    public final void a(c arg1)
    {
      AppMethodBeat.i(104104);
      FaceDetectCameraView.a(FaceDetectCameraView.this, ???);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if (this.rvG == null)
        {
          ae.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          AppMethodBeat.o(104104);
          return;
        }
        if (this.rvG.rqh)
        {
          ae.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
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
          ae.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
          FaceDetectCameraView.this.onSurfaceTextureAvailable(FaceDetectCameraView.this.getSurfaceTexture(), FaceDetectCameraView.this.getWidth(), FaceDetectCameraView.this.getHeight());
          AppMethodBeat.o(104104);
          return;
        }
      }
      ae.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
      AppMethodBeat.o(104104);
      return;
      label172:
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          int i = 1;
          AppMethodBeat.i(104098);
          synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
          {
            ae.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(bu.aO(this.rvJ)) });
            long l1 = bu.HQ();
            if (FaceDetectCameraView.c.this.rvG == null)
            {
              ae.e("MicroMsg.FaceDetectCameraView", "hy: already released");
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104095);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).Eg(1);
                    AppMethodBeat.o(104095);
                  }
                });
              }
              AppMethodBeat.o(104098);
              return;
            }
            try
            {
              FaceDetectCameraView.c.this.rvG.nQL = new Point(FaceDetectCameraView.j(FaceDetectCameraView.this), FaceDetectCameraView.k(FaceDetectCameraView.this));
              Object localObject2 = FaceDetectCameraView.c.this.rvG;
              if ((((n)localObject2).gaZ != null) && (((n)localObject2).iCY)) {}
              for (;;)
              {
                if (i == 0) {
                  FaceDetectCameraView.c.this.rvG.i(FaceDetectCameraView.l(FaceDetectCameraView.this));
                }
                localObject2 = FaceDetectCameraView.c.this.rvG.rqi;
                FaceDetectCameraView.a(FaceDetectCameraView.this, (Point)localObject2);
                localObject2 = FaceDetectCameraView.c.this.rvG;
                SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(FaceDetectCameraView.this);
                long l2 = bu.HQ();
                if ((((n)localObject2).gaZ != null) && (!((n)localObject2).rqh))
                {
                  if (localSurfaceTexture != null)
                  {
                    ae.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
                    ((n)localObject2).gaZ.setPreviewTexture(localSurfaceTexture);
                  }
                  com.tencent.mm.plugin.facedetect.model.c.da(((n)localObject2).getPreviewWidth(), ((n)localObject2).getPreviewHeight());
                  ((n)localObject2).gaZ.startPreview();
                  ((n)localObject2).rqh = true;
                  ae.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bu.aO(l2)) });
                }
                FaceDetectCameraView.c.this.rvG.setPreviewCallback(FaceDetectCameraView.c.this.rvH);
                if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                  ar.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(104096);
                      FaceDetectCameraView.i(FaceDetectCameraView.this).Eg(0);
                      AppMethodBeat.o(104096);
                    }
                  });
                }
                ae.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(bu.aO(l1)) });
                FaceDetectCameraView.f(FaceDetectCameraView.this);
                AppMethodBeat.o(104098);
                return;
                i = 0;
              }
              localObject3 = finally;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.FaceDetectCameraView", localException, "hy: exception caused", new Object[0]);
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104097);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).Eg(2);
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
    
    public final void cvF()
    {
      AppMethodBeat.i(104106);
      if (!FaceDetectCameraView.m(FaceDetectCameraView.this))
      {
        FaceDetectCameraView.b(FaceDetectCameraView.this, true);
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(104099);
            synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
            {
              if (FaceDetectCameraView.c.this.rvG == null)
              {
                AppMethodBeat.o(104099);
                return;
              }
              ae.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
              FaceDetectCameraView.c.this.rvG.setPreviewCallback(null);
              d locald = d.cup();
              synchronized (d.mLock)
              {
                if (locald.rpf != null) {
                  locald.rpf.clear();
                }
                if (FaceDetectCameraView.l(FaceDetectCameraView.this) != null) {
                  FaceDetectCameraView.l(FaceDetectCameraView.this).release();
                }
                FaceDetectCameraView.c.this.rvG.release();
                FaceDetectCameraView.c.this.rvG = null;
                ae.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                FaceDetectCameraView.b(FaceDetectCameraView.this, false);
                AppMethodBeat.o(104099);
                return;
              }
            }
          }
        }, "FaceDetectCameraView_Camera");
      }
      AppMethodBeat.o(104106);
    }
    
    public final Point cvG()
    {
      AppMethodBeat.i(104112);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        Point localPoint = this.rvG.rqn;
        AppMethodBeat.o(104112);
        return localPoint;
      }
    }
    
    public final void cvr()
    {
      AppMethodBeat.i(104111);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.rvG != null) && (this.rvG.rqh))
        {
          d.cup().b(this.rvI);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this)) {
            FaceDetectCameraView.a(FaceDetectCameraView.this, null);
          }
        }
        AppMethodBeat.o(104111);
        return;
      }
    }
    
    public final int getPreviewHeight()
    {
      AppMethodBeat.i(104108);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rvG.getPreviewHeight();
        AppMethodBeat.o(104108);
        return i;
      }
    }
    
    public final int getPreviewWidth()
    {
      AppMethodBeat.i(104107);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rvG.getPreviewWidth();
        AppMethodBeat.o(104107);
        return i;
      }
    }
    
    public final int getRotation()
    {
      AppMethodBeat.i(104109);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rvG.rql;
        AppMethodBeat.o(104109);
        return i;
      }
    }
    
    public final void stopPreview()
    {
      AppMethodBeat.i(104105);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.rvG != null) && (this.rvG.rqh))
        {
          n localn = this.rvG;
          if (localn.gaZ != null)
          {
            localn.gaZ.stopPreview();
            localn.rqh = false;
            com.tencent.mm.plugin.facedetect.model.c.rpd.ayL();
          }
        }
        AppMethodBeat.o(104105);
        return;
      }
    }
    
    public final void vC(long paramLong)
    {
      AppMethodBeat.i(104110);
      for (;;)
      {
        synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
        {
          if (this.rvG == null)
          {
            ae.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            AppMethodBeat.o(104110);
            return;
          }
          ae.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
          FaceDetectCameraView.b(FaceDetectCameraView.this, paramLong);
          if (!FaceDetectCameraView.q(FaceDetectCameraView.this))
          {
            if ((this.rvG != null) && (this.rvG.rqh))
            {
              ae.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
              FaceDetectCameraView.a(FaceDetectCameraView.this, false);
              d.cup().a(this.rvI);
              FaceDetectCameraView.r(FaceDetectCameraView.this);
              AppMethodBeat.o(104110);
              return;
            }
            ae.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
            FaceDetectCameraView.a(FaceDetectCameraView.this, true);
          }
        }
        ae.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */