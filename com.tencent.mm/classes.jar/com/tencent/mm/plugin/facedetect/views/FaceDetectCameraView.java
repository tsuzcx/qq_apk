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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MMTextureView;
import java.lang.ref.WeakReference;
import java.util.List;

public class FaceDetectCameraView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static a pUX = null;
  private ActivityManager aGF;
  private int height;
  private boolean jMg;
  private boolean mMi;
  private SurfaceTexture mSurfaceTexture;
  private long pOK;
  b pUJ;
  private long pUK;
  private long pUL;
  private int pUM;
  private boolean pUN;
  private boolean pUO;
  private final Object pUP;
  private boolean pUQ;
  private boolean pUR;
  private final Object pUS;
  private final Object pUT;
  private Rect pUU;
  private c pUV;
  private boolean pUW;
  public b pUY;
  private byte[] pUZ;
  private boolean pVa;
  private long pVb;
  private int width;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104113);
    this.pUJ = null;
    this.mSurfaceTexture = null;
    this.pUK = FaceDetectView.pVI;
    this.pUL = -1L;
    this.pOK = -1L;
    this.pUM = 1;
    this.jMg = false;
    this.pUN = false;
    this.pUO = false;
    this.pUP = new Object();
    this.pUQ = false;
    this.pUR = false;
    this.mMi = false;
    this.pUS = new Object();
    this.pUT = new Object();
    this.pUU = null;
    this.width = 324;
    this.height = 576;
    this.pUV = null;
    this.pUW = false;
    this.pUY = null;
    this.pUZ = null;
    this.pVa = false;
    this.pVb = -1L;
    this.aGF = ((ActivityManager)getContext().getSystemService("activity"));
    ad.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.pUW) });
    this.pUY = new c((byte)0);
    pUX = new a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(104113);
  }
  
  private static void cgN()
  {
    AppMethodBeat.i(104117);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.cfL();
    AppMethodBeat.o(104117);
  }
  
  /* Error */
  private void cgQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 422
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 166
    //   10: ldc_w 424
    //   13: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:pOM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cfO	()I
    //   22: pop
    //   23: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:pOM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   26: getfield 284	com/tencent/mm/plugin/facedetect/model/f:pON	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   29: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:pQQ	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 303	com/tencent/mm/plugin/facedetect/model/g:pOQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   39: ifnonnull +59 -> 98
    //   42: ldc_w 292
    //   45: ldc_w 429
    //   48: invokestatic 308	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:pOM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   54: invokevirtual 432	com/tencent/mm/plugin/facedetect/model/f:cfP	()I
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
    //   78: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic 360	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:cfV	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   84: iload_1
    //   85: lload_2
    //   86: invokevirtual 441	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:Z	(IJ)V
    //   89: ldc_w 422
    //   92: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 292
    //   101: ldc_w 443
    //   104: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: getfield 303	com/tencent/mm/plugin/facedetect/model/g:pOQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
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
      cgN();
      this.pUU = paramRect;
      cgQ();
      this.pUY.pA(paramLong);
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
    this.pUY.a(paramc);
    this.pOK = -1L;
    AppMethodBeat.o(104115);
  }
  
  public final void cgO()
  {
    AppMethodBeat.i(104119);
    cgP();
    f.pOM.pON.pQQ.cfT();
    AppMethodBeat.o(104119);
  }
  
  public final void cgP()
  {
    AppMethodBeat.i(104120);
    this.mMi = false;
    this.pUY.cgE();
    cgN();
    int i = f.pOM.cfP();
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.cfV().aa(i, l);
    AppMethodBeat.o(104120);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult cgR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 502
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 420	com/tencent/mm/plugin/facedetect/model/f:cfL	()V
    //   11: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:pOM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   14: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cfO	()I
    //   17: istore_2
    //   18: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:pOM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   21: getfield 284	com/tencent/mm/plugin/facedetect/model/f:pON	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   24: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:pQQ	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   27: invokevirtual 505	com/tencent/mm/plugin/facedetect/model/g:cfS	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
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
    //   63: invokestatic 179	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    int i = this.pUY.getRotation();
    AppMethodBeat.o(104128);
    return i;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    AppMethodBeat.i(104114);
    Point localPoint = this.pUY.cgT();
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
    int i = this.pUY.getPreviewHeight();
    AppMethodBeat.o(104130);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(104129);
    int i = this.pUY.getPreviewWidth();
    AppMethodBeat.o(104129);
    return i;
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(104124);
    super.onAttachedToWindow();
    ad.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    AppMethodBeat.o(104124);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104127);
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    ad.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    AppMethodBeat.o(104127);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104118);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
    eTg();
    this.jMg = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.pUR) {
      a(this.pUV);
    }
    AppMethodBeat.o(104118);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104123);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.jMg = false;
    AppMethodBeat.o(104123);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104122);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(104122);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  final void setCallback(b paramb)
  {
    this.pUJ = paramb;
  }
  
  static final class a
    extends ap
  {
    private WeakReference<FaceDetectCameraView> Oe;
    
    private a(FaceDetectCameraView paramFaceDetectCameraView)
    {
      super();
      AppMethodBeat.i(104093);
      this.Oe = new WeakReference(paramFaceDetectCameraView);
      AppMethodBeat.o(104093);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(104094);
      super.handleMessage(paramMessage);
      if ((this.Oe == null) || (this.Oe.get() == null))
      {
        ad.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        AppMethodBeat.o(104094);
        return;
      }
      if (paramMessage.what == 1)
      {
        paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
        if (FaceCharacteristicsResult.BW(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()).d(paramMessage);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceCharacteristicsResult.BV(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()).a(paramMessage.errCode, paramMessage.errMsg);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()) != null) {
          FaceDetectCameraView.a((FaceDetectCameraView)this.Oe.get()).c(paramMessage);
        }
      }
      AppMethodBeat.o(104094);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(c paramc);
    
    public abstract void cgE();
    
    public abstract void cgS();
    
    public abstract Point cgT();
    
    public abstract int getPreviewHeight();
    
    public abstract int getPreviewWidth();
    
    public abstract int getRotation();
    
    public abstract void pA(long paramLong);
    
    public abstract void stopPreview();
  }
  
  final class c
    implements FaceDetectCameraView.b
  {
    n pVg;
    Camera.PreviewCallback pVh;
    private d.b pVi;
    
    private c()
    {
      AppMethodBeat.i(104103);
      this.pVg = null;
      this.pVh = new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(104100);
          ad.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
          d.cfC().bj(paramAnonymousArrayOfByte);
          AppMethodBeat.o(104100);
        }
      };
      this.pVi = new d.b()
      {
        public final void bk(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(104102);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this))
          {
            if (FaceDetectCameraView.o(FaceDetectCameraView.this) == null) {
              FaceDetectCameraView.a(FaceDetectCameraView.this, com.tencent.mm.plugin.facedetect.model.c.pOB.g(Integer.valueOf(paramAnonymousArrayOfByte.length)));
            }
            if ((FaceDetectCameraView.o(FaceDetectCameraView.this) == null) || (FaceDetectCameraView.o(FaceDetectCameraView.this).length < paramAnonymousArrayOfByte.length))
            {
              AppMethodBeat.o(104102);
              return;
            }
            System.arraycopy(paramAnonymousArrayOfByte, 0, FaceDetectCameraView.o(FaceDetectCameraView.this), 0, paramAnonymousArrayOfByte.length);
            FaceDetectCameraView.a(FaceDetectCameraView.this, paramAnonymousArrayOfByte);
          }
          com.tencent.mm.plugin.facedetect.model.c.pOB.k(paramAnonymousArrayOfByte);
          f.cfM().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104101);
              ad.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
              long l1 = bt.GC();
              long l2 = l1 - FaceDetectCameraView.p(FaceDetectCameraView.this);
              if (FaceDetectCameraView.p(FaceDetectCameraView.this) >= 0L) {
                ad.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", new Object[] { Long.valueOf(l2) });
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
        
        public final a<byte[]> cfD()
        {
          return com.tencent.mm.plugin.facedetect.model.c.pOB;
        }
      };
      this.pVg = new n(FaceDetectCameraView.this.getContext());
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
        if (this.pVg == null)
        {
          ad.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          AppMethodBeat.o(104104);
          return;
        }
        if (this.pVg.pPF)
        {
          ad.w("MicroMsg.FaceDetectCameraView", "hy: already previewed. return");
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
          ad.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
          FaceDetectCameraView.this.onSurfaceTextureAvailable(FaceDetectCameraView.this.getSurfaceTexture(), FaceDetectCameraView.this.getWidth(), FaceDetectCameraView.this.getHeight());
          AppMethodBeat.o(104104);
          return;
        }
      }
      ad.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
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
            ad.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(bt.aS(this.pVj)) });
            long l1 = bt.GC();
            if (FaceDetectCameraView.c.this.pVg == null)
            {
              ad.e("MicroMsg.FaceDetectCameraView", "hy: already released");
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104095);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).Cg(1);
                    AppMethodBeat.o(104095);
                  }
                });
              }
              AppMethodBeat.o(104098);
              return;
            }
            try
            {
              FaceDetectCameraView.c.this.pVg.mII = new Point(FaceDetectCameraView.j(FaceDetectCameraView.this), FaceDetectCameraView.k(FaceDetectCameraView.this));
              Object localObject2 = FaceDetectCameraView.c.this.pVg;
              if ((((n)localObject2).fBM != null) && (((n)localObject2).hGj)) {}
              for (;;)
              {
                if (i == 0) {
                  FaceDetectCameraView.c.this.pVg.i(FaceDetectCameraView.l(FaceDetectCameraView.this));
                }
                localObject2 = FaceDetectCameraView.c.this.pVg.pPG;
                FaceDetectCameraView.a(FaceDetectCameraView.this, (Point)localObject2);
                localObject2 = FaceDetectCameraView.c.this.pVg;
                SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(FaceDetectCameraView.this);
                long l2 = bt.GC();
                if ((((n)localObject2).fBM != null) && (!((n)localObject2).pPF))
                {
                  if (localSurfaceTexture != null)
                  {
                    ad.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
                    ((n)localObject2).fBM.setPreviewTexture(localSurfaceTexture);
                  }
                  com.tencent.mm.plugin.facedetect.model.c.cY(((n)localObject2).getPreviewWidth(), ((n)localObject2).getPreviewHeight());
                  ((n)localObject2).fBM.startPreview();
                  ((n)localObject2).pPF = true;
                  ad.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bt.aS(l2)) });
                }
                FaceDetectCameraView.c.this.pVg.setPreviewCallback(FaceDetectCameraView.c.this.pVh);
                if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(104096);
                      FaceDetectCameraView.i(FaceDetectCameraView.this).Cg(0);
                      AppMethodBeat.o(104096);
                    }
                  });
                }
                ad.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(bt.aS(l1)) });
                FaceDetectCameraView.f(FaceDetectCameraView.this);
                AppMethodBeat.o(104098);
                return;
                i = 0;
              }
              localObject3 = finally;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.FaceDetectCameraView", localException, "hy: exception caused", new Object[0]);
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104097);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).Cg(2);
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
    
    public final void cgE()
    {
      AppMethodBeat.i(104111);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.pVg != null) && (this.pVg.pPF))
        {
          d.cfC().b(this.pVi);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this)) {
            FaceDetectCameraView.a(FaceDetectCameraView.this, null);
          }
        }
        AppMethodBeat.o(104111);
        return;
      }
    }
    
    public final void cgS()
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
              if (FaceDetectCameraView.c.this.pVg == null)
              {
                AppMethodBeat.o(104099);
                return;
              }
              ad.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
              FaceDetectCameraView.c.this.pVg.setPreviewCallback(null);
              d locald = d.cfC();
              synchronized (d.mLock)
              {
                if (locald.pOD != null) {
                  locald.pOD.clear();
                }
                if (FaceDetectCameraView.l(FaceDetectCameraView.this) != null) {
                  FaceDetectCameraView.l(FaceDetectCameraView.this).release();
                }
                FaceDetectCameraView.c.this.pVg.release();
                FaceDetectCameraView.c.this.pVg = null;
                ad.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
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
    
    public final Point cgT()
    {
      AppMethodBeat.i(104112);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        Point localPoint = this.pVg.pPL;
        AppMethodBeat.o(104112);
        return localPoint;
      }
    }
    
    public final int getPreviewHeight()
    {
      AppMethodBeat.i(104108);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.pVg.getPreviewHeight();
        AppMethodBeat.o(104108);
        return i;
      }
    }
    
    public final int getPreviewWidth()
    {
      AppMethodBeat.i(104107);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.pVg.getPreviewWidth();
        AppMethodBeat.o(104107);
        return i;
      }
    }
    
    public final int getRotation()
    {
      AppMethodBeat.i(104109);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.pVg.pPJ;
        AppMethodBeat.o(104109);
        return i;
      }
    }
    
    public final void pA(long paramLong)
    {
      AppMethodBeat.i(104110);
      for (;;)
      {
        synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
        {
          if (this.pVg == null)
          {
            ad.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            AppMethodBeat.o(104110);
            return;
          }
          ad.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
          FaceDetectCameraView.b(FaceDetectCameraView.this, paramLong);
          if (!FaceDetectCameraView.q(FaceDetectCameraView.this))
          {
            if ((this.pVg != null) && (this.pVg.pPF))
            {
              ad.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
              FaceDetectCameraView.a(FaceDetectCameraView.this, false);
              d.cfC().a(this.pVi);
              FaceDetectCameraView.r(FaceDetectCameraView.this);
              AppMethodBeat.o(104110);
              return;
            }
            ad.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
            FaceDetectCameraView.a(FaceDetectCameraView.this, true);
          }
        }
        ad.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
      }
    }
    
    public final void stopPreview()
    {
      AppMethodBeat.i(104105);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.pVg != null) && (this.pVg.pPF))
        {
          n localn = this.pVg;
          if (localn.fBM != null)
          {
            localn.fBM.stopPreview();
            localn.pPF = false;
            com.tencent.mm.plugin.facedetect.model.c.pOB.aoS();
          }
        }
        AppMethodBeat.o(104105);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */