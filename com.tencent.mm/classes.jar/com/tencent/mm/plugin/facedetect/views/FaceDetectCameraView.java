package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public class FaceDetectCameraView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static FaceDetectCameraView.a moo = null;
  private boolean hIO;
  private int height;
  private boolean jNf;
  private SurfaceTexture mSurfaceTexture;
  private long mhW;
  b mnZ;
  private ActivityManager moa;
  private long mob;
  private long moc;
  private int mod;
  private boolean moe;
  private boolean mof;
  private final Object mog;
  private boolean moh;
  private boolean moi;
  private final Object moj;
  private final Object mok;
  private Rect mol;
  private c mom;
  private boolean mon;
  public FaceDetectCameraView.b mop;
  private byte[] moq;
  private boolean mor;
  private long mos;
  private int width;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(594);
    this.mnZ = null;
    this.mSurfaceTexture = null;
    this.mob = FaceDetectView.moZ;
    this.moc = -1L;
    this.mhW = -1L;
    this.mod = 1;
    this.hIO = false;
    this.moe = false;
    this.mof = false;
    this.mog = new Object();
    this.moh = false;
    this.moi = false;
    this.jNf = false;
    this.moj = new Object();
    this.mok = new Object();
    this.mol = null;
    this.width = 324;
    this.height = 576;
    this.mom = null;
    this.mon = false;
    this.mop = null;
    this.moq = null;
    this.mor = false;
    this.mos = -1L;
    this.moa = ((ActivityManager)getContext().getSystemService("activity"));
    ab.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.mon) });
    this.mop = new FaceDetectCameraView.c(this, (byte)0);
    moo = new FaceDetectCameraView.a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(594);
  }
  
  private static void bvs()
  {
    AppMethodBeat.i(598);
    ab.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.bur();
    AppMethodBeat.o(598);
  }
  
  /* Error */
  private void bvv()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 602
    //   5: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 144
    //   10: ldc_w 398
    //   13: invokestatic 392	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: getstatic 248	com/tencent/mm/plugin/facedetect/model/f:mhY	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: invokevirtual 401	com/tencent/mm/plugin/facedetect/model/f:buu	()I
    //   22: pop
    //   23: getstatic 248	com/tencent/mm/plugin/facedetect/model/f:mhY	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   26: getfield 262	com/tencent/mm/plugin/facedetect/model/f:mhZ	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   29: getfield 268	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:mkf	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   32: astore 4
    //   34: aload 4
    //   36: getfield 281	com/tencent/mm/plugin/facedetect/model/g:mic	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   39: ifnonnull +59 -> 98
    //   42: ldc_w 270
    //   45: ldc_w 403
    //   48: invokestatic 286	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 248	com/tencent/mm/plugin/facedetect/model/f:mhY	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   54: invokevirtual 406	com/tencent/mm/plugin/facedetect/model/f:buv	()I
    //   57: istore_1
    //   58: invokestatic 411	java/lang/System:currentTimeMillis	()J
    //   61: lstore_2
    //   62: ldc 144
    //   64: ldc_w 413
    //   67: iconst_1
    //   68: anewarray 94	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: lload_2
    //   74: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: aastore
    //   78: invokestatic 157	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: invokestatic 338	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:buB	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   84: iload_1
    //   85: lload_2
    //   86: invokevirtual 416	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:M	(IJ)V
    //   89: sipush 602
    //   92: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 270
    //   101: ldc_w 418
    //   104: invokestatic 392	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload 4
    //   109: getfield 281	com/tencent/mm/plugin/facedetect/model/g:mic	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   112: invokevirtual 421	com/tencent/mm/plugin/facedetect/FaceProNative:engineGetCurrMotion	()I
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
      AppMethodBeat.i(597);
      bvs();
      this.mol = paramRect;
      bvv();
      this.mop.jJ(paramLong);
      AppMethodBeat.o(597);
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
    AppMethodBeat.i(596);
    this.mop.a(paramc);
    this.mhW = -1L;
    AppMethodBeat.o(596);
  }
  
  public final void bvt()
  {
    AppMethodBeat.i(600);
    bvu();
    f.mhY.mhZ.mkf.buz();
    AppMethodBeat.o(600);
  }
  
  public final void bvu()
  {
    AppMethodBeat.i(601);
    this.jNf = false;
    this.mop.bvj();
    bvs();
    int i = f.mhY.buv();
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.buB().N(i, l);
    AppMethodBeat.o(601);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult bvw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 606
    //   5: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 395	com/tencent/mm/plugin/facedetect/model/f:bur	()V
    //   11: getstatic 248	com/tencent/mm/plugin/facedetect/model/f:mhY	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   14: invokevirtual 401	com/tencent/mm/plugin/facedetect/model/f:buu	()I
    //   17: istore_2
    //   18: getstatic 248	com/tencent/mm/plugin/facedetect/model/f:mhY	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   21: getfield 262	com/tencent/mm/plugin/facedetect/model/f:mhZ	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   24: getfield 268	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:mkf	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   27: invokevirtual 479	com/tencent/mm/plugin/facedetect/model/g:buy	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
    //   30: astore_3
    //   31: aload_3
    //   32: ifnull +44 -> 76
    //   35: aload_3
    //   36: getfield 482	com/tencent/mm/plugin/facedetect/FaceProNative$FaceResult:result	I
    //   39: istore_1
    //   40: ldc 144
    //   42: ldc_w 484
    //   45: iconst_2
    //   46: anewarray 94	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: iload_1
    //   59: invokestatic 202	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 157	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: sipush 606
    //   69: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(609);
    int i = this.mop.getRotation();
    AppMethodBeat.o(609);
    return i;
  }
  
  public final Point getEncodeVideoBestSize()
  {
    AppMethodBeat.i(595);
    Point localPoint = this.mop.bvy();
    AppMethodBeat.o(595);
    return localPoint;
  }
  
  public final Bitmap getPreviewBm()
  {
    AppMethodBeat.i(607);
    Bitmap localBitmap = getBitmap();
    AppMethodBeat.o(607);
    return localBitmap;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(611);
    int i = this.mop.getPreviewHeight();
    AppMethodBeat.o(611);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(610);
    int i = this.mop.getPreviewWidth();
    AppMethodBeat.o(610);
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(605);
    super.onAttachedToWindow();
    ab.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    AppMethodBeat.o(605);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(608);
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    ab.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
    AppMethodBeat.o(608);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(599);
    ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
    dEs();
    this.hIO = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.moi) {
      a(this.mom);
    }
    AppMethodBeat.o(599);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(604);
    ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.hIO = false;
    AppMethodBeat.o(604);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(603);
    ab.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(603);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  final void setCallback(b paramb)
  {
    this.mnZ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */