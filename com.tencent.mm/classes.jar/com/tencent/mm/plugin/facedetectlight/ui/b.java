package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.memory.a;
import com.tencent.mm.plugin.facedetect.model.d.b;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionMask;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
  implements TextureView.SurfaceTextureListener
{
  public String eaX;
  private Bitmap faceBitmap;
  private d.a.a fau;
  private boolean isFrontCamera;
  public String mAppId;
  private Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  private boolean mIsCameraOpened;
  private Point miT;
  private Point miU;
  private Point miV;
  private boolean miW;
  private int miX;
  private Point mja;
  public boolean mlO;
  public byte[] mlk;
  private Camera.PreviewCallback moy;
  d.b moz;
  public FaceActionMask mqW;
  public int mqd;
  public String mqe;
  private FaceActionUI mqf;
  private a.a mqh;
  private MMTextureView mrA;
  private HandlerThread mrB;
  private ak mrC;
  public u mrD;
  public boolean mrE;
  public TextView mrF;
  public FaceReflectMask mrG;
  public PreviewFrameLayout mrH;
  private int mrI;
  public String mrJ;
  public ImageView mrK;
  public ImageView mrL;
  private boolean mrM;
  private int mrN;
  private al mrO;
  private com.tencent.mm.plugin.facedetectlight.ui.a.b mrP;
  
  public b(Context paramContext, com.tencent.mm.plugin.facedetectlight.ui.a.b paramb)
  {
    AppMethodBeat.i(772);
    this.miT = null;
    this.miU = null;
    this.miV = null;
    this.mja = null;
    this.mrI = 0;
    this.mrO = new al("mPreviewHandlerThread");
    this.moz = new d.b()
    {
      public final void aU(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(771);
        com.tencent.mm.plugin.facedetect.model.c.mhN.O(paramAnonymousArrayOfByte);
        AppMethodBeat.o(771);
      }
      
      public final a<byte[]> buj()
      {
        return com.tencent.mm.plugin.facedetect.model.c.mhN;
      }
    };
    this.moy = new b.2(this);
    this.mrP = paramb;
    this.mrN = 1;
    this.mContext = paramContext;
    this.mIsCameraOpened = false;
    this.mlO = false;
    this.mrB = null;
    this.mIsCameraOpened = false;
    AppMethodBeat.o(772);
  }
  
  public b(FaceActionUI paramFaceActionUI, a.a parama)
  {
    AppMethodBeat.i(773);
    this.miT = null;
    this.miU = null;
    this.miV = null;
    this.mja = null;
    this.mrI = 0;
    this.mrO = new al("mPreviewHandlerThread");
    this.moz = new d.b()
    {
      public final void aU(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(771);
        com.tencent.mm.plugin.facedetect.model.c.mhN.O(paramAnonymousArrayOfByte);
        AppMethodBeat.o(771);
      }
      
      public final a<byte[]> buj()
      {
        return com.tencent.mm.plugin.facedetect.model.c.mhN;
      }
    };
    this.moy = new b.2(this);
    this.mrN = 2;
    this.mqf = paramFaceActionUI;
    this.mIsCameraOpened = false;
    this.mlO = false;
    this.mrB = null;
    this.mIsCameraOpened = false;
    this.mrM = false;
    this.mqh = parama;
    AppMethodBeat.o(773);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    AppMethodBeat.i(782);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new b.a((byte)0));
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ab.d("MicroMsg.FaceReflectCam", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    long l = bo.hg(ah.getContext());
    ab.d("MicroMsg.FaceReflectCam", "systemAvailableMemInMB: %d", new Object[] { Long.valueOf(l) });
    int i = paramPoint.x;
    i = paramPoint.y;
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int j;
    label241:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      ab.i("MicroMsg.FaceReflectCam", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 983040))
      {
        if (i > j)
        {
          m = 1;
          if (m == 0) {
            break label348;
          }
          k = j;
          if (m == 0) {
            break label355;
          }
        }
        label348:
        label355:
        for (int m = i;; m = j)
        {
          ab.d("MicroMsg.FaceReflectCam", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y) || (!g(k, m, l))) {
            break label362;
          }
          paramParameters = new Point(i, j);
          ab.i("MicroMsg.FaceReflectCam", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(782);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label241;
        }
        label362:
        f2 = Math.abs(k / m - f3);
        if (i % 10 == 0)
        {
          if ((f2 >= f1) || (!g(i, j, l))) {
            break label547;
          }
          localPoint = new Point(i, j);
          f1 = f2;
        }
      }
    }
    label533:
    label547:
    for (;;)
    {
      ab.i("MicroMsg.FaceReflectCam", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        if (paramParameters == null) {
          break label533;
        }
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ab.i("MicroMsg.FaceReflectCam", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      for (;;)
      {
        ab.i("MicroMsg.FaceReflectCam", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
        AppMethodBeat.o(782);
        return paramPoint;
        ab.e("MicroMsg.FaceReflectCam", "hy: can not find default size!!");
        paramPoint = localPoint;
      }
    }
  }
  
  /* Error */
  private boolean bvN()
  {
    // Byte code:
    //   0: sipush 778
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 177
    //   8: ldc_w 356
    //   11: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 125	com/tencent/mm/plugin/facedetectlight/ui/b:mIsCameraOpened	Z
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 358	com/tencent/mm/plugin/facedetectlight/ui/b:isFrontCamera	Z
    //   24: invokestatic 364	android/hardware/Camera:getNumberOfCameras	()I
    //   27: istore 6
    //   29: iconst_0
    //   30: istore 5
    //   32: iload 5
    //   34: iload 6
    //   36: if_icmpge +1395 -> 1431
    //   39: new 366	android/hardware/Camera$CameraInfo
    //   42: dup
    //   43: invokespecial 367	android/hardware/Camera$CameraInfo:<init>	()V
    //   46: astore 10
    //   48: iload 5
    //   50: aload 10
    //   52: invokestatic 371	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   55: aload 10
    //   57: getfield 374	android/hardware/Camera$CameraInfo:facing	I
    //   60: iconst_1
    //   61: if_icmpne +162 -> 223
    //   64: aload_0
    //   65: getfield 358	com/tencent/mm/plugin/facedetectlight/ui/b:isFrontCamera	Z
    //   68: ifeq +155 -> 223
    //   71: ldc 177
    //   73: ldc_w 376
    //   76: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: invokestatic 382	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   82: lstore 7
    //   84: ldc 177
    //   86: new 300	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 384
    //   93: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   100: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   113: ifnonnull +41 -> 154
    //   116: ldc 177
    //   118: ldc_w 391
    //   121: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 121	com/tencent/mm/plugin/facedetectlight/ui/b:mrN	I
    //   128: iconst_1
    //   129: if_icmpne +139 -> 268
    //   132: ldc 177
    //   134: ldc_w 393
    //   137: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 123	com/tencent/mm/plugin/facedetectlight/ui/b:mContext	Landroid/content/Context;
    //   145: iload 5
    //   147: aconst_null
    //   148: invokestatic 398	com/tencent/mm/compatible/e/d:a	(Landroid/content/Context;ILandroid/os/Looper;)Lcom/tencent/mm/compatible/e/d$a$a;
    //   151: putfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   154: aload_0
    //   155: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   158: ifnonnull +138 -> 296
    //   161: ldc 177
    //   163: ldc_w 400
    //   166: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: new 296	java/io/IOException
    //   172: dup
    //   173: invokespecial 401	java/io/IOException:<init>	()V
    //   176: astore 10
    //   178: sipush 778
    //   181: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload 10
    //   186: athrow
    //   187: astore 10
    //   189: ldc 177
    //   191: new 300	java/lang/StringBuilder
    //   194: dup
    //   195: ldc_w 403
    //   198: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   201: aload 10
    //   203: invokevirtual 345	java/io/IOException:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: sipush 778
    //   218: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: iconst_0
    //   222: ireturn
    //   223: aload 10
    //   225: getfield 374	android/hardware/Camera$CameraInfo:facing	I
    //   228: ifne +21 -> 249
    //   231: aload_0
    //   232: getfield 358	com/tencent/mm/plugin/facedetectlight/ui/b:isFrontCamera	Z
    //   235: ifne +14 -> 249
    //   238: ldc 177
    //   240: ldc_w 376
    //   243: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -167 -> 79
    //   249: iload 5
    //   251: iconst_1
    //   252: iadd
    //   253: istore 5
    //   255: goto -223 -> 32
    //   258: astore 10
    //   260: sipush 778
    //   263: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iconst_0
    //   267: ireturn
    //   268: ldc 177
    //   270: ldc_w 405
    //   273: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload_0
    //   277: aload_0
    //   278: getfield 136	com/tencent/mm/plugin/facedetectlight/ui/b:mqf	Lcom/tencent/mm/plugin/facedetectaction/ui/FaceActionUI;
    //   281: invokevirtual 410	com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   284: iload 5
    //   286: aconst_null
    //   287: invokestatic 398	com/tencent/mm/compatible/e/d:a	(Landroid/content/Context;ILandroid/os/Looper;)Lcom/tencent/mm/compatible/e/d$a$a;
    //   290: putfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   293: goto -139 -> 154
    //   296: aload_0
    //   297: iload 5
    //   299: putfield 98	com/tencent/mm/plugin/facedetectlight/ui/b:mrI	I
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 125	com/tencent/mm/plugin/facedetectlight/ui/b:mIsCameraOpened	Z
    //   307: ldc 177
    //   309: ldc_w 412
    //   312: iconst_2
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: iload 5
    //   320: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: lload 7
    //   328: invokestatic 416	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   331: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   334: aastore
    //   335: invokestatic 196	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   343: getfield 421	com/tencent/mm/compatible/e/d$a$a:rotate	I
    //   346: putfield 423	com/tencent/mm/plugin/facedetectlight/ui/b:miX	I
    //   349: aload_0
    //   350: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   353: getfield 421	com/tencent/mm/compatible/e/d$a$a:rotate	I
    //   356: sipush 180
    //   359: irem
    //   360: ifeq +752 -> 1112
    //   363: iconst_1
    //   364: istore 9
    //   366: aload_0
    //   367: iload 9
    //   369: putfield 425	com/tencent/mm/plugin/facedetectlight/ui/b:miW	Z
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 386	com/tencent/mm/plugin/facedetectlight/ui/b:fau	Lcom/tencent/mm/compatible/e/d$a$a;
    //   377: getfield 428	com/tencent/mm/compatible/e/d$a$a:eoH	Lcom/tencent/mm/compatible/e/u;
    //   380: putfield 313	com/tencent/mm/plugin/facedetectlight/ui/b:mrD	Lcom/tencent/mm/compatible/e/u;
    //   383: aload_0
    //   384: getfield 313	com/tencent/mm/plugin/facedetectlight/ui/b:mrD	Lcom/tencent/mm/compatible/e/u;
    //   387: ifnonnull +71 -> 458
    //   390: ldc 177
    //   392: ldc_w 430
    //   395: iconst_1
    //   396: anewarray 4	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload_0
    //   402: getfield 425	com/tencent/mm/plugin/facedetectlight/ui/b:miW	Z
    //   405: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   408: aastore
    //   409: invokestatic 437	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   412: new 296	java/io/IOException
    //   415: dup
    //   416: invokespecial 401	java/io/IOException:<init>	()V
    //   419: astore 10
    //   421: sipush 778
    //   424: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: aload 10
    //   429: athrow
    //   430: astore 10
    //   432: ldc 177
    //   434: new 300	java/lang/StringBuilder
    //   437: dup
    //   438: ldc_w 439
    //   441: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   444: aload 10
    //   446: invokevirtual 345	java/io/IOException:getMessage	()Ljava/lang/String;
    //   449: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: aload_0
    //   459: getfield 313	com/tencent/mm/plugin/facedetectlight/ui/b:mrD	Lcom/tencent/mm/compatible/e/u;
    //   462: invokevirtual 443	com/tencent/mm/compatible/e/u:getParameters	()Landroid/hardware/Camera$Parameters;
    //   465: astore 12
    //   467: aload_0
    //   468: getfield 121	com/tencent/mm/plugin/facedetectlight/ui/b:mrN	I
    //   471: iconst_1
    //   472: if_icmpne +678 -> 1150
    //   475: aload_0
    //   476: getfield 123	com/tencent/mm/plugin/facedetectlight/ui/b:mContext	Landroid/content/Context;
    //   479: invokevirtual 449	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   482: invokevirtual 455	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   485: getfield 460	android/util/DisplayMetrics:widthPixels	I
    //   488: istore 6
    //   490: aload_0
    //   491: getfield 123	com/tencent/mm/plugin/facedetectlight/ui/b:mContext	Landroid/content/Context;
    //   494: invokevirtual 449	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   497: invokevirtual 455	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   500: getfield 463	android/util/DisplayMetrics:heightPixels	I
    //   503: istore 5
    //   505: aload_0
    //   506: new 169	android/graphics/Point
    //   509: dup
    //   510: iload 6
    //   512: iload 5
    //   514: invokespecial 255	android/graphics/Point:<init>	(II)V
    //   517: putfield 92	com/tencent/mm/plugin/facedetectlight/ui/b:miU	Landroid/graphics/Point;
    //   520: aload_0
    //   521: getfield 92	com/tencent/mm/plugin/facedetectlight/ui/b:miU	Landroid/graphics/Point;
    //   524: astore 14
    //   526: aload_0
    //   527: getfield 94	com/tencent/mm/plugin/facedetectlight/ui/b:miV	Landroid/graphics/Point;
    //   530: astore 13
    //   532: aload 12
    //   534: ldc_w 465
    //   537: invokevirtual 468	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   540: astore 11
    //   542: aload 11
    //   544: astore 10
    //   546: aload 11
    //   548: ifnonnull +13 -> 561
    //   551: aload 12
    //   553: ldc_w 470
    //   556: invokevirtual 468	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   559: astore 10
    //   561: aload 10
    //   563: ifnull +862 -> 1425
    //   566: ldc 177
    //   568: ldc_w 472
    //   571: aload 10
    //   573: invokestatic 262	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   576: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   579: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload 12
    //   584: aload 14
    //   586: invokestatic 474	com/tencent/mm/plugin/facedetectlight/ui/b:a	(Landroid/hardware/Camera$Parameters;Landroid/graphics/Point;)Landroid/graphics/Point;
    //   589: astore 10
    //   591: aload 10
    //   593: astore 11
    //   595: aload 10
    //   597: ifnonnull +30 -> 627
    //   600: new 169	android/graphics/Point
    //   603: dup
    //   604: aload 13
    //   606: getfield 172	android/graphics/Point:x	I
    //   609: iconst_3
    //   610: ishr
    //   611: iconst_3
    //   612: ishl
    //   613: aload 13
    //   615: getfield 175	android/graphics/Point:y	I
    //   618: iconst_3
    //   619: ishr
    //   620: iconst_3
    //   621: ishl
    //   622: invokespecial 255	android/graphics/Point:<init>	(II)V
    //   625: astore 11
    //   627: aload_0
    //   628: aload 11
    //   630: putfield 90	com/tencent/mm/plugin/facedetectlight/ui/b:miT	Landroid/graphics/Point;
    //   633: aload_0
    //   634: new 169	android/graphics/Point
    //   637: dup
    //   638: aload_0
    //   639: getfield 90	com/tencent/mm/plugin/facedetectlight/ui/b:miT	Landroid/graphics/Point;
    //   642: invokespecial 477	android/graphics/Point:<init>	(Landroid/graphics/Point;)V
    //   645: putfield 96	com/tencent/mm/plugin/facedetectlight/ui/b:mja	Landroid/graphics/Point;
    //   648: ldc 177
    //   650: new 300	java/lang/StringBuilder
    //   653: dup
    //   654: ldc_w 479
    //   657: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   660: aload_0
    //   661: getfield 92	com/tencent/mm/plugin/facedetectlight/ui/b:miU	Landroid/graphics/Point;
    //   664: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   667: ldc_w 481
    //   670: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_0
    //   674: getfield 90	com/tencent/mm/plugin/facedetectlight/ui/b:miT	Landroid/graphics/Point;
    //   677: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   680: ldc_w 483
    //   683: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_0
    //   687: getfield 96	com/tencent/mm/plugin/facedetectlight/ui/b:mja	Landroid/graphics/Point;
    //   690: invokevirtual 389	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 90	com/tencent/mm/plugin/facedetectlight/ui/b:miT	Landroid/graphics/Point;
    //   704: getfield 172	android/graphics/Point:x	I
    //   707: putfield 321	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewWidth	I
    //   710: aload_0
    //   711: aload_0
    //   712: getfield 90	com/tencent/mm/plugin/facedetectlight/ui/b:miT	Landroid/graphics/Point;
    //   715: getfield 175	android/graphics/Point:y	I
    //   718: putfield 323	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewHeight	I
    //   721: aload 12
    //   723: aload_0
    //   724: getfield 321	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewWidth	I
    //   727: aload_0
    //   728: getfield 323	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewHeight	I
    //   731: invokevirtual 486	android/hardware/Camera$Parameters:setPreviewSize	(II)V
    //   734: ldc 177
    //   736: new 300	java/lang/StringBuilder
    //   739: dup
    //   740: ldc_w 488
    //   743: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   746: aload_0
    //   747: getfield 321	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewWidth	I
    //   750: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   753: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   756: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: ldc 177
    //   761: new 300	java/lang/StringBuilder
    //   764: dup
    //   765: ldc_w 493
    //   768: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   771: aload_0
    //   772: getfield 323	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewHeight	I
    //   775: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: aload 12
    //   786: iconst_0
    //   787: invokevirtual 496	android/hardware/Camera$Parameters:setZoom	(I)V
    //   790: aload 12
    //   792: ldc_w 498
    //   795: invokevirtual 501	android/hardware/Camera$Parameters:setSceneMode	(Ljava/lang/String;)V
    //   798: aload 12
    //   800: invokevirtual 504	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   803: ifnull +380 -> 1183
    //   806: aload 12
    //   808: invokevirtual 504	android/hardware/Camera$Parameters:getSupportedFocusModes	()Ljava/util/List;
    //   811: ldc_w 498
    //   814: invokeinterface 508 2 0
    //   819: ifeq +364 -> 1183
    //   822: ldc 177
    //   824: ldc_w 510
    //   827: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 12
    //   832: ldc_w 498
    //   835: invokevirtual 513	android/hardware/Camera$Parameters:setFocusMode	(Ljava/lang/String;)V
    //   838: aload 12
    //   840: invokevirtual 516	android/hardware/Camera$Parameters:getSupportedPreviewFormats	()Ljava/util/List;
    //   843: astore 10
    //   845: aload 10
    //   847: invokeinterface 222 1 0
    //   852: astore 11
    //   854: iconst_0
    //   855: istore 5
    //   857: aload 11
    //   859: invokeinterface 228 1 0
    //   864: ifeq +555 -> 1419
    //   867: aload 11
    //   869: invokeinterface 232 1 0
    //   874: checkcast 181	java/lang/Integer
    //   877: invokevirtual 519	java/lang/Integer:intValue	()I
    //   880: istore 6
    //   882: ldc 177
    //   884: ldc_w 521
    //   887: iload 6
    //   889: invokestatic 524	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   892: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   895: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: iload 6
    //   900: bipush 17
    //   902: if_icmpne +317 -> 1219
    //   905: iconst_1
    //   906: istore 6
    //   908: iload 6
    //   910: ifeq +323 -> 1233
    //   913: aload 12
    //   915: bipush 17
    //   917: invokevirtual 527	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   920: aload_0
    //   921: getfield 425	com/tencent/mm/plugin/facedetectlight/ui/b:miW	Z
    //   924: ifeq +12 -> 936
    //   927: aload 12
    //   929: aload_0
    //   930: getfield 423	com/tencent/mm/plugin/facedetectlight/ui/b:miX	I
    //   933: invokevirtual 530	android/hardware/Camera$Parameters:setRotation	(I)V
    //   936: aload_0
    //   937: getfield 532	com/tencent/mm/plugin/facedetectlight/ui/b:mrH	Lcom/tencent/mm/plugin/facedetectlight/ui/PreviewFrameLayout;
    //   940: invokevirtual 538	com/tencent/mm/plugin/facedetectlight/ui/PreviewFrameLayout:getmAspectRatio	()D
    //   943: dstore_1
    //   944: ldc 177
    //   946: ldc_w 540
    //   949: dload_1
    //   950: invokestatic 543	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   953: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   956: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   959: aload_0
    //   960: getfield 321	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewWidth	I
    //   963: i2d
    //   964: aload_0
    //   965: getfield 323	com/tencent/mm/plugin/facedetectlight/ui/b:mDesiredPreviewHeight	I
    //   968: i2d
    //   969: ddiv
    //   970: dstore_3
    //   971: ldc 177
    //   973: ldc_w 545
    //   976: dload_3
    //   977: invokestatic 543	java/lang/String:valueOf	(D)Ljava/lang/String;
    //   980: invokevirtual 266	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   983: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   986: dload_1
    //   987: dload_3
    //   988: dcmpl
    //   989: ifne +313 -> 1302
    //   992: ldc 177
    //   994: ldc_w 547
    //   997: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: aload 12
    //   1002: invokestatic 550	com/tencent/mm/plugin/facedetectlight/ui/b:d	(Landroid/hardware/Camera$Parameters;)V
    //   1005: aload 12
    //   1007: invokevirtual 553	android/hardware/Camera$Parameters:getSupportedPreviewFpsRange	()Ljava/util/List;
    //   1010: astore 10
    //   1012: ldc 177
    //   1014: new 300	java/lang/StringBuilder
    //   1017: dup
    //   1018: ldc_w 555
    //   1021: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1024: aload 10
    //   1026: invokeinterface 558 1 0
    //   1031: invokevirtual 491	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: iconst_0
    //   1041: istore 5
    //   1043: iload 5
    //   1045: aload 10
    //   1047: invokeinterface 558 1 0
    //   1052: if_icmpge +282 -> 1334
    //   1055: aload 10
    //   1057: iload 5
    //   1059: invokeinterface 561 2 0
    //   1064: checkcast 563	[I
    //   1067: astore 11
    //   1069: iconst_0
    //   1070: istore 6
    //   1072: iload 6
    //   1074: aload 11
    //   1076: arraylength
    //   1077: if_icmpge +248 -> 1325
    //   1080: ldc 177
    //   1082: ldc_w 565
    //   1085: iconst_1
    //   1086: anewarray 4	java/lang/Object
    //   1089: dup
    //   1090: iconst_0
    //   1091: aload 11
    //   1093: iload 6
    //   1095: iaload
    //   1096: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1099: aastore
    //   1100: invokestatic 244	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1103: iload 6
    //   1105: iconst_1
    //   1106: iadd
    //   1107: istore 6
    //   1109: goto -37 -> 1072
    //   1112: iconst_0
    //   1113: istore 9
    //   1115: goto -749 -> 366
    //   1118: astore 10
    //   1120: ldc 177
    //   1122: aload 10
    //   1124: ldc_w 567
    //   1127: iconst_1
    //   1128: anewarray 4	java/lang/Object
    //   1131: dup
    //   1132: iconst_0
    //   1133: aload 10
    //   1135: invokevirtual 568	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1138: aastore
    //   1139: invokestatic 572	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1142: sipush 778
    //   1145: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1148: iconst_0
    //   1149: ireturn
    //   1150: aload_0
    //   1151: getfield 136	com/tencent/mm/plugin/facedetectlight/ui/b:mqf	Lcom/tencent/mm/plugin/facedetectaction/ui/FaceActionUI;
    //   1154: invokevirtual 573	com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI:getResources	()Landroid/content/res/Resources;
    //   1157: invokevirtual 455	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1160: getfield 460	android/util/DisplayMetrics:widthPixels	I
    //   1163: istore 6
    //   1165: aload_0
    //   1166: getfield 136	com/tencent/mm/plugin/facedetectlight/ui/b:mqf	Lcom/tencent/mm/plugin/facedetectaction/ui/FaceActionUI;
    //   1169: invokevirtual 573	com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI:getResources	()Landroid/content/res/Resources;
    //   1172: invokevirtual 455	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1175: getfield 463	android/util/DisplayMetrics:heightPixels	I
    //   1178: istore 5
    //   1180: goto -675 -> 505
    //   1183: ldc 177
    //   1185: ldc_w 575
    //   1188: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1191: goto -353 -> 838
    //   1194: astore 10
    //   1196: ldc 177
    //   1198: ldc_w 577
    //   1201: iconst_1
    //   1202: anewarray 4	java/lang/Object
    //   1205: dup
    //   1206: iconst_0
    //   1207: aload 10
    //   1209: invokevirtual 568	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1212: aastore
    //   1213: invokestatic 437	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1216: goto -378 -> 838
    //   1219: iload 6
    //   1221: ldc_w 578
    //   1224: if_icmpne +192 -> 1416
    //   1227: iconst_1
    //   1228: istore 5
    //   1230: goto -373 -> 857
    //   1233: iload 5
    //   1235: ifeq +22 -> 1257
    //   1238: ldc 177
    //   1240: ldc_w 580
    //   1243: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1246: aload 12
    //   1248: ldc_w 578
    //   1251: invokevirtual 527	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   1254: goto -334 -> 920
    //   1257: ldc 177
    //   1259: ldc_w 582
    //   1262: iconst_1
    //   1263: anewarray 4	java/lang/Object
    //   1266: dup
    //   1267: iconst_0
    //   1268: aload 10
    //   1270: iconst_0
    //   1271: invokeinterface 561 2 0
    //   1276: aastore
    //   1277: invokestatic 437	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1280: aload 12
    //   1282: aload 10
    //   1284: iconst_0
    //   1285: invokeinterface 561 2 0
    //   1290: checkcast 181	java/lang/Integer
    //   1293: invokevirtual 519	java/lang/Integer:intValue	()I
    //   1296: invokevirtual 527	android/hardware/Camera$Parameters:setPreviewFormat	(I)V
    //   1299: goto -379 -> 920
    //   1302: ldc 177
    //   1304: ldc_w 584
    //   1307: invokestatic 378	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1310: new 586	com/tencent/mm/plugin/facedetectlight/ui/b$6
    //   1313: dup
    //   1314: aload_0
    //   1315: dload_3
    //   1316: invokespecial 589	com/tencent/mm/plugin/facedetectlight/ui/b$6:<init>	(Lcom/tencent/mm/plugin/facedetectlight/ui/b;D)V
    //   1319: invokestatic 592	com/tencent/mm/sdk/platformtools/al:d	(Ljava/lang/Runnable;)V
    //   1322: goto -322 -> 1000
    //   1325: iload 5
    //   1327: iconst_1
    //   1328: iadd
    //   1329: istore 5
    //   1331: goto -288 -> 1043
    //   1334: ldc 177
    //   1336: new 300	java/lang/StringBuilder
    //   1339: dup
    //   1340: ldc_w 594
    //   1343: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1346: aload 12
    //   1348: ldc_w 596
    //   1351: invokevirtual 468	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   1354: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1360: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1363: ldc 177
    //   1365: new 300	java/lang/StringBuilder
    //   1368: dup
    //   1369: ldc_w 594
    //   1372: invokespecial 303	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1375: aload 12
    //   1377: ldc_w 598
    //   1380: invokevirtual 468	android/hardware/Camera$Parameters:get	(Ljava/lang/String;)Ljava/lang/String;
    //   1383: invokevirtual 348	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1389: invokestatic 269	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1392: aload_0
    //   1393: getfield 313	com/tencent/mm/plugin/facedetectlight/ui/b:mrD	Lcom/tencent/mm/compatible/e/u;
    //   1396: aload 12
    //   1398: invokevirtual 601	com/tencent/mm/compatible/e/u:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   1401: aload_0
    //   1402: getfield 125	com/tencent/mm/plugin/facedetectlight/ui/b:mIsCameraOpened	Z
    //   1405: istore 9
    //   1407: sipush 778
    //   1410: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1413: iload 9
    //   1415: ireturn
    //   1416: goto -186 -> 1230
    //   1419: iconst_0
    //   1420: istore 6
    //   1422: goto -514 -> 908
    //   1425: aconst_null
    //   1426: astore 10
    //   1428: goto -837 -> 591
    //   1431: iconst_m1
    //   1432: istore 5
    //   1434: goto -1355 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1437	0	this	b
    //   943	44	1	d1	double
    //   970	346	3	d2	double
    //   30	1403	5	i	int
    //   27	1394	6	j	int
    //   82	245	7	l	long
    //   364	1050	9	bool	boolean
    //   46	139	10	localObject1	Object
    //   187	37	10	localIOException1	java.io.IOException
    //   258	1	10	localException1	Exception
    //   419	9	10	localIOException2	java.io.IOException
    //   430	15	10	localIOException3	java.io.IOException
    //   544	512	10	localObject2	Object
    //   1118	16	10	localException2	Exception
    //   1194	89	10	localException3	Exception
    //   1426	1	10	localObject3	Object
    //   540	552	11	localObject4	Object
    //   465	932	12	localParameters	Camera.Parameters
    //   530	84	13	localPoint1	Point
    //   524	61	14	localPoint2	Point
    // Exception table:
    //   from	to	target	type
    //   169	187	187	java/io/IOException
    //   140	154	258	java/lang/Exception
    //   412	430	430	java/io/IOException
    //   458	467	1118	java/lang/Exception
    //   798	838	1194	java/lang/Exception
    //   1183	1191	1194	java/lang/Exception
  }
  
  private static void d(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(783);
    if (ac.eru.eoh > 0)
    {
      ab.i("MicroMsg.FaceReflectCam", "set frame rate > 0, do not try set preview fps range");
      AppMethodBeat.o(783);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(783);
      return;
    }
    int j = -2147483648;
    int i = -2147483648;
    int n = 0;
    int i6 = localList.size();
    int i3 = 0;
    int i2;
    int i1;
    int k;
    if (i3 < i6)
    {
      int[] arrayOfInt = (int[])localList.get(i3);
      i2 = i;
      i1 = j;
      if (arrayOfInt == null) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (arrayOfInt.length <= 1) {
        break label391;
      }
      int i5 = arrayOfInt[0];
      int i4 = arrayOfInt[1];
      ab.i("MicroMsg.FaceReflectCam", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(i4) });
      i2 = i;
      i1 = j;
      if (i5 < 0) {
        break label391;
      }
      i2 = i;
      i1 = j;
      if (i4 < i5) {
        break label391;
      }
      k = i;
      int m = j;
      if (i4 >= i)
      {
        k = i;
        m = j;
        if (n == 0)
        {
          k = i4;
          m = i5;
        }
      }
      i2 = k;
      i1 = m;
      if (i4 < 30000) {
        break label391;
      }
      n = 1;
      j = m;
      i = k;
      k = n;
    }
    for (;;)
    {
      i3 += 1;
      n = k;
      break;
      ab.i("MicroMsg.FaceReflectCam", "dkfps get fit  [%d %d], max target fps %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(30) });
      if ((j == 2147483647) || (i == 2147483647))
      {
        AppMethodBeat.o(783);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(j, i);
        ab.i("MicroMsg.FaceReflectCam", "set fps range %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(783);
        return;
      }
      catch (Exception paramParameters)
      {
        ab.i("MicroMsg.FaceReflectCam", "trySetPreviewFpsRangeParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramParameters.getMessage() });
        AppMethodBeat.o(783);
        return;
      }
      label391:
      k = n;
      i = i2;
      j = i1;
    }
  }
  
  private static boolean g(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(784);
    double d = paramInt1 * paramInt2 * 3.0D / 2.0D / 1024.0D / 1024.0D;
    ab.d("MicroMsg.FaceReflectCam", "dataSizeInMB: %f, availableMemInMb: %d", new Object[] { Double.valueOf(d), Long.valueOf(paramLong) });
    if (paramLong / d >= 5.0D)
    {
      AppMethodBeat.o(784);
      return true;
    }
    AppMethodBeat.o(784);
    return false;
  }
  
  private void i(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(775);
    ab.i("MicroMsg.FaceReflectCam", "openCameraForSurfaceTexture");
    if (this.mrN == 1) {
      this.mrG.setVisibility(0);
    }
    for (;;)
    {
      bvP();
      if (this.mrC == null) {
        break;
      }
      this.mrC.post(new b.3(this));
      this.mrC.post(new b.4(this, paramSurfaceTexture));
      AppMethodBeat.o(775);
      return;
      this.mqW.setVisibility(0);
    }
    ab.i("MicroMsg.FaceReflectCam", "back thread is not running");
    AppMethodBeat.o(775);
  }
  
  public final void a(MMTextureView paramMMTextureView)
  {
    AppMethodBeat.i(774);
    this.mrA = paramMMTextureView;
    if (this.mrA.isAvailable()) {
      i(paramMMTextureView.getSurfaceTexture());
    }
    this.mrA.setSurfaceTextureListener(this);
    this.mrA.setVisibility(0);
    this.mrA.setAlpha(0.0F);
    if ((this.mrN == 2) && (!this.mrM)) {
      al.p(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(758);
          b.a(b.this).setVisibility(8);
          b.b(b.this).setVisibility(8);
          b.c(b.this);
          AppMethodBeat.o(758);
        }
      }, 700L);
    }
    AppMethodBeat.o(774);
  }
  
  public final void bvO()
  {
    AppMethodBeat.i(780);
    ab.i("MicroMsg.FaceReflectCam", "closeCamera start");
    if (this.mrD != null) {}
    try
    {
      if (this.mlO)
      {
        this.mlO = false;
        this.mrD.stopPreview();
        this.mrD.setPreviewCallback(null);
        ab.i("MicroMsg.FaceReflectCam", "stop preview, not previewing");
      }
      try
      {
        this.mrD.release();
        this.mrD = null;
        this.mrD = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException2.getMessage());
          this.mrD = null;
        }
      }
      finally
      {
        this.mrD = null;
        AppMethodBeat.o(780);
      }
      ab.i("MicroMsg.FaceReflectCam", "closeCamera end");
      AppMethodBeat.o(780);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        ab.i("MicroMsg.FaceReflectCam", "Error setting camera preview: " + localException1.getMessage());
      }
    }
  }
  
  public final void bvP()
  {
    AppMethodBeat.i(781);
    if (this.mrB == null)
    {
      ab.i("MicroMsg.FaceReflectCam", "start camera thread");
      this.mrB = d.aqu("cameraBackground");
      this.mrB.start();
      this.mrC = new ak(this.mrB.getLooper());
    }
    AppMethodBeat.o(781);
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(777);
    ab.i("MicroMsg.FaceReflectCam", "onSurfaceTextureAvailable, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    i(paramSurfaceTexture);
    AppMethodBeat.o(777);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(776);
    ab.i("MicroMsg.FaceReflectCam", "surfaceDestroyed");
    if (this.mrC != null)
    {
      this.mrC.post(new b.5(this));
      if (this.mrB != null) {
        ab.i("MicroMsg.FaceReflectCam", "stop camera thread");
      }
    }
    for (;;)
    {
      try
      {
        Thread.sleep(500L, 0);
        if (Build.VERSION.SDK_INT >= 18) {
          this.mrB.quitSafely();
        }
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        try
        {
          this.mrB.join();
          this.mrB = null;
          this.mrC = null;
          ab.i("MicroMsg.FaceReflectCam", "stop camera thread finish");
          AppMethodBeat.o(776);
          return false;
          paramSurfaceTexture = paramSurfaceTexture;
          ab.i("MicroMsg.FaceReflectCam", "background thread sleep error：" + paramSurfaceTexture.getMessage());
          continue;
          this.mrB.quit();
          continue;
        }
        catch (InterruptedException paramSurfaceTexture)
        {
          ab.i("MicroMsg.FaceReflectCam", "stop background thread error：" + paramSurfaceTexture.getMessage());
          continue;
        }
      }
      ab.i("MicroMsg.FaceReflectCam", "back thread is not running");
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(779);
    ab.i("MicroMsg.FaceReflectCam", "stopPreview, isPreviewing: %s", new Object[] { Boolean.valueOf(this.mrE) });
    if (this.mrD != null)
    {
      this.mrD.stopPreview();
      this.mrE = false;
      com.tencent.mm.plugin.facedetect.model.c.mhN.XJ();
    }
    AppMethodBeat.o(779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b
 * JD-Core Version:    0.7.0.1
 */