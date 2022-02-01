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
  private static a rns = null;
  private ActivityManager aJm;
  private int height;
  private boolean kHH;
  private SurfaceTexture mSurfaceTexture;
  private boolean nPq;
  private long rhi;
  b rne;
  private long rnf;
  private long rng;
  private int rnh;
  private boolean rni;
  private boolean rnj;
  private final Object rnk;
  private boolean rnl;
  private boolean rnm;
  private final Object rnn;
  private final Object rno;
  private Rect rnp;
  private c rnq;
  private boolean rnr;
  public b rnt;
  private byte[] rnu;
  private boolean rnv;
  private long rnw;
  private int width;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104113);
    this.rne = null;
    this.mSurfaceTexture = null;
    this.rnf = FaceDetectView.rod;
    this.rng = -1L;
    this.rhi = -1L;
    this.rnh = 1;
    this.kHH = false;
    this.rni = false;
    this.rnj = false;
    this.rnk = new Object();
    this.rnl = false;
    this.rnm = false;
    this.nPq = false;
    this.rnn = new Object();
    this.rno = new Object();
    this.rnp = null;
    this.width = 324;
    this.height = 576;
    this.rnq = null;
    this.rnr = false;
    this.rnt = null;
    this.rnu = null;
    this.rnv = false;
    this.rnw = -1L;
    this.aJm = ((ActivityManager)getContext().getSystemService("activity"));
    ad.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.rnr) });
    this.rnt = new c((byte)0);
    rns = new a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(104113);
  }
  
  private static void ctZ()
  {
    AppMethodBeat.i(104117);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.csX();
    AppMethodBeat.o(104117);
  }
  
  /* Error */
  private void cuc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 422
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 166
    //   10: ldc_w 424
    //   13: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rhk	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cta	()I
    //   22: pop
    //   23: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rhk	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   26: getfield 284	com/tencent/mm/plugin/facedetect/model/f:rhl	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   29: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:rjn	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 303	com/tencent/mm/plugin/facedetect/model/g:rho	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   39: ifnonnull +59 -> 98
    //   42: ldc_w 292
    //   45: ldc_w 429
    //   48: invokestatic 308	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rhk	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   54: invokevirtual 432	com/tencent/mm/plugin/facedetect/model/f:ctb	()I
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
    //   81: invokestatic 360	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:cth	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   84: iload_1
    //   85: lload_2
    //   86: invokevirtual 442	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:ab	(IJ)V
    //   89: ldc_w 422
    //   92: invokestatic 194	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 292
    //   101: ldc_w 444
    //   104: invokestatic 417	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: getfield 303	com/tencent/mm/plugin/facedetect/model/g:rho	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
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
      ctZ();
      this.rnp = paramRect;
      cuc();
      this.rnt.vm(paramLong);
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
    this.rnt.a(paramc);
    this.rhi = -1L;
    AppMethodBeat.o(104115);
  }
  
  public final void cua()
  {
    AppMethodBeat.i(104119);
    cub();
    f.rhk.rhl.rjn.ctf();
    AppMethodBeat.o(104119);
  }
  
  public final void cub()
  {
    AppMethodBeat.i(104120);
    this.nPq = false;
    this.rnt.ctQ();
    ctZ();
    int i = f.rhk.ctb();
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.cth().ac(i, l);
    AppMethodBeat.o(104120);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult cud()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 503
    //   5: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 420	com/tencent/mm/plugin/facedetect/model/f:csX	()V
    //   11: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rhk	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   14: invokevirtual 427	com/tencent/mm/plugin/facedetect/model/f:cta	()I
    //   17: istore_2
    //   18: getstatic 270	com/tencent/mm/plugin/facedetect/model/f:rhk	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   21: getfield 284	com/tencent/mm/plugin/facedetect/model/f:rhl	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   24: getfield 290	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:rjn	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   27: invokevirtual 506	com/tencent/mm/plugin/facedetect/model/g:cte	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +44 -> 76
    //   35: aload_3
    //   36: getfield 509	com/tencent/mm/plugin/facedetect/FaceProNative$FaceResult:result	I
    //   39: istore_1
    //   40: ldc 166
    //   42: ldc_w 511
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
    //   66: ldc_w 503
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
    int i = this.rnt.getRotation();
    AppMethodBeat.o(104128);
    return i;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    AppMethodBeat.i(104114);
    Point localPoint = this.rnt.cuf();
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
    int i = this.rnt.getPreviewHeight();
    AppMethodBeat.o(104130);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(104129);
    int i = this.rnt.getPreviewWidth();
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
    fzf();
    this.kHH = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.rnm) {
      a(this.rnq);
    }
    AppMethodBeat.o(104118);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(104123);
    ad.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.kHH = false;
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
    this.rne = paramb;
  }
  
  static final class a
    extends ap
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
        ad.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
        AppMethodBeat.o(104094);
        return;
      }
      if (paramMessage.what == 1)
      {
        paramMessage = (FaceCharacteristicsResult)paramMessage.obj;
        if (FaceCharacteristicsResult.DJ(paramMessage.errCode))
        {
          if (FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()) != null)
          {
            FaceDetectCameraView.a((FaceDetectCameraView)this.QQ.get()).d(paramMessage);
            AppMethodBeat.o(104094);
          }
        }
        else if (FaceCharacteristicsResult.DI(paramMessage.errCode))
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
    
    public abstract void ctQ();
    
    public abstract void cue();
    
    public abstract Point cuf();
    
    public abstract int getPreviewHeight();
    
    public abstract int getPreviewWidth();
    
    public abstract int getRotation();
    
    public abstract void stopPreview();
    
    public abstract void vm(long paramLong);
  }
  
  final class c
    implements FaceDetectCameraView.b
  {
    n rnB;
    Camera.PreviewCallback rnC;
    private d.b rnD;
    
    private c()
    {
      AppMethodBeat.i(104103);
      this.rnB = null;
      this.rnC = new Camera.PreviewCallback()
      {
        public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
        {
          AppMethodBeat.i(104100);
          ad.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
          d.csO().bl(paramAnonymousArrayOfByte);
          AppMethodBeat.o(104100);
        }
      };
      this.rnD = new d.b()
      {
        public final void bm(byte[] paramAnonymousArrayOfByte)
        {
          AppMethodBeat.i(104102);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this))
          {
            if (FaceDetectCameraView.o(FaceDetectCameraView.this) == null) {
              FaceDetectCameraView.a(FaceDetectCameraView.this, com.tencent.mm.plugin.facedetect.model.c.rgZ.g(Integer.valueOf(paramAnonymousArrayOfByte.length)));
            }
            if ((FaceDetectCameraView.o(FaceDetectCameraView.this) == null) || (FaceDetectCameraView.o(FaceDetectCameraView.this).length < paramAnonymousArrayOfByte.length))
            {
              AppMethodBeat.o(104102);
              return;
            }
            System.arraycopy(paramAnonymousArrayOfByte, 0, FaceDetectCameraView.o(FaceDetectCameraView.this), 0, paramAnonymousArrayOfByte.length);
            FaceDetectCameraView.a(FaceDetectCameraView.this, paramAnonymousArrayOfByte);
          }
          com.tencent.mm.plugin.facedetect.model.c.rgZ.k(paramAnonymousArrayOfByte);
          f.csY().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104101);
              ad.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
              long l1 = bt.HI();
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
        
        public final a<byte[]> csP()
        {
          return com.tencent.mm.plugin.facedetect.model.c.rgZ;
        }
      };
      this.rnB = new n(FaceDetectCameraView.this.getContext());
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
        if (this.rnB == null)
        {
          ad.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
          AppMethodBeat.o(104104);
          return;
        }
        if (this.rnB.rid)
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
            ad.i("MicroMsg.FaceDetectCameraView", "hy: enter worker thread. using %d ms", new Object[] { Long.valueOf(bt.aO(this.rnE)) });
            long l1 = bt.HI();
            if (FaceDetectCameraView.c.this.rnB == null)
            {
              ad.e("MicroMsg.FaceDetectCameraView", "hy: already released");
              if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                aq.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(104095);
                    FaceDetectCameraView.i(FaceDetectCameraView.this).DT(1);
                    AppMethodBeat.o(104095);
                  }
                });
              }
              AppMethodBeat.o(104098);
              return;
            }
            try
            {
              FaceDetectCameraView.c.this.rnB.nLi = new Point(FaceDetectCameraView.j(FaceDetectCameraView.this), FaceDetectCameraView.k(FaceDetectCameraView.this));
              Object localObject2 = FaceDetectCameraView.c.this.rnB;
              if ((((n)localObject2).fYS != null) && (((n)localObject2).iAf)) {}
              for (;;)
              {
                if (i == 0) {
                  FaceDetectCameraView.c.this.rnB.i(FaceDetectCameraView.l(FaceDetectCameraView.this));
                }
                localObject2 = FaceDetectCameraView.c.this.rnB.rie;
                FaceDetectCameraView.a(FaceDetectCameraView.this, (Point)localObject2);
                localObject2 = FaceDetectCameraView.c.this.rnB;
                SurfaceTexture localSurfaceTexture = FaceDetectCameraView.l(FaceDetectCameraView.this);
                long l2 = bt.HI();
                if ((((n)localObject2).fYS != null) && (!((n)localObject2).rid))
                {
                  if (localSurfaceTexture != null)
                  {
                    ad.i("MicroMsg.FaceScanCamera", "hy: SurfaceTexture is not null");
                    ((n)localObject2).fYS.setPreviewTexture(localSurfaceTexture);
                  }
                  com.tencent.mm.plugin.facedetect.model.c.da(((n)localObject2).getPreviewWidth(), ((n)localObject2).getPreviewHeight());
                  ((n)localObject2).fYS.startPreview();
                  ((n)localObject2).rid = true;
                  ad.d("MicroMsg.FaceScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bt.aO(l2)) });
                }
                FaceDetectCameraView.c.this.rnB.setPreviewCallback(FaceDetectCameraView.c.this.rnC);
                if (FaceDetectCameraView.i(FaceDetectCameraView.this) != null) {
                  aq.f(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(104096);
                      FaceDetectCameraView.i(FaceDetectCameraView.this).DT(0);
                      AppMethodBeat.o(104096);
                    }
                  });
                }
                ad.i("MicroMsg.FaceDetectCameraView", "hy: opened and start preview. use: %d ms", new Object[] { Long.valueOf(bt.aO(l1)) });
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
                    FaceDetectCameraView.i(FaceDetectCameraView.this).DT(2);
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
    
    public final void ctQ()
    {
      AppMethodBeat.i(104111);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.rnB != null) && (this.rnB.rid))
        {
          d.csO().b(this.rnD);
          if (!FaceDetectCameraView.n(FaceDetectCameraView.this)) {
            FaceDetectCameraView.a(FaceDetectCameraView.this, null);
          }
        }
        AppMethodBeat.o(104111);
        return;
      }
    }
    
    public final void cue()
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
              if (FaceDetectCameraView.c.this.rnB == null)
              {
                AppMethodBeat.o(104099);
                return;
              }
              ad.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
              FaceDetectCameraView.c.this.rnB.setPreviewCallback(null);
              d locald = d.csO();
              synchronized (d.mLock)
              {
                if (locald.rhb != null) {
                  locald.rhb.clear();
                }
                if (FaceDetectCameraView.l(FaceDetectCameraView.this) != null) {
                  FaceDetectCameraView.l(FaceDetectCameraView.this).release();
                }
                FaceDetectCameraView.c.this.rnB.release();
                FaceDetectCameraView.c.this.rnB = null;
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
    
    public final Point cuf()
    {
      AppMethodBeat.i(104112);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        Point localPoint = this.rnB.rij;
        AppMethodBeat.o(104112);
        return localPoint;
      }
    }
    
    public final int getPreviewHeight()
    {
      AppMethodBeat.i(104108);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rnB.getPreviewHeight();
        AppMethodBeat.o(104108);
        return i;
      }
    }
    
    public final int getPreviewWidth()
    {
      AppMethodBeat.i(104107);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rnB.getPreviewWidth();
        AppMethodBeat.o(104107);
        return i;
      }
    }
    
    public final int getRotation()
    {
      AppMethodBeat.i(104109);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        int i = this.rnB.rih;
        AppMethodBeat.o(104109);
        return i;
      }
    }
    
    public final void stopPreview()
    {
      AppMethodBeat.i(104105);
      synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
      {
        if ((this.rnB != null) && (this.rnB.rid))
        {
          n localn = this.rnB;
          if (localn.fYS != null)
          {
            localn.fYS.stopPreview();
            localn.rid = false;
            com.tencent.mm.plugin.facedetect.model.c.rgZ.ayw();
          }
        }
        AppMethodBeat.o(104105);
        return;
      }
    }
    
    public final void vm(long paramLong)
    {
      AppMethodBeat.i(104110);
      for (;;)
      {
        synchronized (FaceDetectCameraView.e(FaceDetectCameraView.this))
        {
          if (this.rnB == null)
          {
            ad.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
            AppMethodBeat.o(104110);
            return;
          }
          ad.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", new Object[] { Long.valueOf(paramLong) });
          FaceDetectCameraView.b(FaceDetectCameraView.this, paramLong);
          if (!FaceDetectCameraView.q(FaceDetectCameraView.this))
          {
            if ((this.rnB != null) && (this.rnB.rid))
            {
              ad.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
              FaceDetectCameraView.a(FaceDetectCameraView.this, false);
              d.csO().a(this.rnD);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */