package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

public class FaceDetectCameraView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static FaceDetectCameraView.a jTV = null;
  private boolean hTl = false;
  private int height = 576;
  private long jNK = -1L;
  b jTF = null;
  private ActivityManager jTG = (ActivityManager)getContext().getSystemService("activity");
  private long jTH = FaceDetectView.jUG;
  private long jTI = -1L;
  private int jTJ = 1;
  private boolean jTK = false;
  private boolean jTL = false;
  private boolean jTM = false;
  private final Object jTN = new Object();
  private boolean jTO = false;
  private boolean jTP = false;
  private final Object jTQ = new Object();
  private final Object jTR = new Object();
  private Rect jTS = null;
  private c jTT = null;
  private boolean jTU = false;
  public FaceDetectCameraView.b jTW = null;
  private byte[] jTX = null;
  private boolean jTY = false;
  private long jTZ = -1L;
  private SurfaceTexture mSurfaceTexture = null;
  private int width = 324;
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    y.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[] { Boolean.valueOf(this.jTU) });
    this.jTW = new FaceDetectCameraView.c(this, (byte)0);
    jTV = new FaceDetectCameraView.a(this, (byte)0);
    setOpaque(false);
    setSurfaceTextureListener(this);
  }
  
  private static void aPn()
  {
    y.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
    f.aOo();
  }
  
  /* Error */
  private void aPp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: ldc 239
    //   6: invokestatic 231	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: getstatic 243	com/tencent/mm/plugin/facedetect/model/f:jNM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   12: invokevirtual 247	com/tencent/mm/plugin/facedetect/model/f:aOs	()I
    //   15: pop
    //   16: getstatic 243	com/tencent/mm/plugin/facedetect/model/f:jNM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   19: getfield 251	com/tencent/mm/plugin/facedetect/model/f:jNN	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   22: getfield 257	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:jPP	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   25: astore 4
    //   27: aload 4
    //   29: getfield 263	com/tencent/mm/plugin/facedetect/model/g:jNQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   32: ifnonnull +53 -> 85
    //   35: ldc_w 265
    //   38: ldc_w 267
    //   41: invokestatic 270	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 243	com/tencent/mm/plugin/facedetect/model/f:jNM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   47: invokevirtual 273	com/tencent/mm/plugin/facedetect/model/f:aOt	()I
    //   50: istore_1
    //   51: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   54: lstore_2
    //   55: ldc 138
    //   57: ldc_w 281
    //   60: iconst_1
    //   61: anewarray 88	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: lload_2
    //   67: invokestatic 286	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: invokestatic 152	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   74: invokestatic 292	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:aOy	()Lcom/tencent/mm/plugin/facedetect/model/FaceDetectReporter;
    //   77: iload_1
    //   78: lload_2
    //   79: invokevirtual 295	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:v	(IJ)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: ldc_w 265
    //   88: ldc_w 297
    //   91: invokestatic 231	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload 4
    //   96: getfield 263	com/tencent/mm/plugin/facedetect/model/g:jNQ	Lcom/tencent/mm/plugin/facedetect/FaceProNative;
    //   99: invokevirtual 302	com/tencent/mm/plugin/facedetect/FaceProNative:engineGetCurrMotion	()I
    //   102: pop
    //   103: goto -59 -> 44
    //   106: astore 4
    //   108: aload_0
    //   109: monitorexit
    //   110: aload 4
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	FaceDetectCameraView
    //   50	28	1	i	int
    //   54	25	2	l	long
    //   25	70	4	localg	com.tencent.mm.plugin.facedetect.model.g
    //   106	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	106	finally
    //   44	82	106	finally
    //   85	103	106	finally
  }
  
  public final void a(Rect paramRect, long paramLong)
  {
    try
    {
      aPn();
      this.jTS = paramRect;
      aPp();
      this.jTW.em(paramLong);
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
    this.jTW.a(paramc);
    this.jNK = -1L;
  }
  
  public final void aPo()
  {
    this.hTl = false;
    this.jTW.aPs();
    aPn();
    int i = f.jNM.aOt();
    long l = System.currentTimeMillis();
    y.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[] { Long.valueOf(l) });
    FaceDetectReporter.aOy().w(i, l);
  }
  
  /* Error */
  final com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult aPq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 236	com/tencent/mm/plugin/facedetect/model/f:aOo	()V
    //   5: getstatic 243	com/tencent/mm/plugin/facedetect/model/f:jNM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   8: invokevirtual 247	com/tencent/mm/plugin/facedetect/model/f:aOs	()I
    //   11: istore_2
    //   12: getstatic 243	com/tencent/mm/plugin/facedetect/model/f:jNM	Lcom/tencent/mm/plugin/facedetect/model/f;
    //   15: getfield 251	com/tencent/mm/plugin/facedetect/model/f:jNN	Lcom/tencent/mm/plugin/facedetect/service/FaceDetectProcessService;
    //   18: getfield 257	com/tencent/mm/plugin/facedetect/service/FaceDetectProcessService:jPP	Lcom/tencent/mm/plugin/facedetect/model/g;
    //   21: invokevirtual 492	com/tencent/mm/plugin/facedetect/model/g:aOv	()Lcom/tencent/mm/plugin/facedetect/FaceProNative$FaceResult;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +38 -> 64
    //   29: aload_3
    //   30: getfield 495	com/tencent/mm/plugin/facedetect/FaceProNative$FaceResult:result	I
    //   33: istore_1
    //   34: ldc 138
    //   36: ldc_w 497
    //   39: iconst_2
    //   40: anewarray 88	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload_2
    //   46: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: iload_1
    //   53: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   56: aastore
    //   57: invokestatic 152	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_3
    //   63: areturn
    //   64: sipush -10000
    //   67: istore_1
    //   68: goto -34 -> 34
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	FaceDetectCameraView
    //   33	35	1	i	int
    //   11	35	2	j	int
    //   24	39	3	localFaceResult	com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult
    //   71	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	71	finally
    //   29	34	71	finally
    //   34	60	71	finally
  }
  
  public final int getCameraRotation()
  {
    return this.jTW.getRotation();
  }
  
  public final Point getEncodeVideoBestSize()
  {
    return this.jTW.aPt();
  }
  
  public final Bitmap getPreviewBm()
  {
    return getBitmap();
  }
  
  public final int getPreviewHeight()
  {
    return this.jTW.getPreviewHeight();
  }
  
  public final int getPreviewWidth()
  {
    return this.jTW.getPreviewWidth();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    y.i("MicroMsg.FaceDetectCameraView", "hy: attached");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.width = getMeasuredWidth();
    this.height = getMeasuredHeight();
    y.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[] { Integer.valueOf(this.width), Integer.valueOf(this.height) });
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
    cBe();
    this.jTK = true;
    this.mSurfaceTexture = paramSurfaceTexture;
    if (this.jTP) {
      a(this.jTT);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
    this.jTK = false;
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
    this.mSurfaceTexture = paramSurfaceTexture;
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  final void setCallback(b paramb)
  {
    this.jTF = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView
 * JD-Core Version:    0.7.0.1
 */