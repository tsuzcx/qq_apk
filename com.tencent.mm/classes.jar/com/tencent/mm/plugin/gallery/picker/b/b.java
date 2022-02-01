package com.tencent.mm.plugin.gallery.picker.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a HJz;
  private a<String, f> HJA;
  public a<String, f> HJB;
  public a<String, f> HJC;
  private final com.tencent.threadpool.b HJD;
  
  static
  {
    AppMethodBeat.i(164890);
    HJz = new a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(164889);
    this.HJA = ((a)new e(paramb));
    this.HJB = ((a)new c(paramb));
    this.HJC = ((a)new c(paramb));
    this.HJD = new com.tencent.threadpool.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), b..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(164889);
  }
  
  private static final void a(Runnable paramRunnable, com.tencent.threadpool.b paramb) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(289337);
    this.HJD.shutdownNow();
    AppMethodBeat.o(289337);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Companion;", "", "()V", "TAG", "", "decodeBitmap", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "limitW", "", "limitH", "isRotate", "", "isClose", "inputPath", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(164869);
      s.u(paramInputStream, "inputStream");
      if (paramInt1 > paramInt2) {}
      for (;;)
      {
        BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramInputStream, false);
        float f1;
        float f2;
        Object localObject1;
        if (localOptions.outWidth <= localOptions.outHeight)
        {
          f1 = 1.0F * paramInt2 / localOptions.outWidth;
          f2 = 1.0F * paramInt1 / localOptions.outHeight;
          if (f1 > f2)
          {
            f1 = f2;
            f1 = Math.min(1.0F, f1);
            i = (int)(localOptions.outWidth * f1);
            int j = (int)(localOptions.outHeight * f1);
            paramInputStream.reset();
            Object localObject2 = BitmapUtil.decodeStream(paramInputStream, 0.0F, i, j);
            localObject1 = localObject2;
            if (paramBoolean1)
            {
              paramInputStream.reset();
              i = Exif.fromStream(paramInputStream).getOrientationInDegree();
              Log.i("MediaTailor", "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
              localObject1 = BitmapUtil.rotate((Bitmap)localObject2, i * 1.0F);
            }
            if (paramBoolean2) {
              paramInputStream.close();
            }
            localObject2 = new StringBuilder("[decodeBitmap] [").append(localOptions.outWidth).append(':').append(localOptions.outHeight).append("]->[");
            if (localObject1 != null) {
              break label388;
            }
            paramInputStream = null;
            label226:
            localObject2 = ((StringBuilder)localObject2).append(paramInputStream).append(':');
            if (localObject1 != null) {
              break label400;
            }
            paramInputStream = null;
            label246:
            Log.i("MediaTailor", paramInputStream + "] scale=" + f1 + " limit[" + paramInt2 + ':' + paramInt1 + "] decode bitmap done!");
            if (localObject1 != null) {
              break label412;
            }
            paramInputStream = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            Log.e("MediaTailor", s.X("bitmap is null. ", Util.getStack()));
          }
        }
        for (;;)
        {
          s.s(paramInputStream, "bitmap");
          AppMethodBeat.o(164869);
          return paramInputStream;
          break;
          f1 = 1.0F * paramInt2 / localOptions.outHeight;
          f2 = 1.0F * paramInt1 / localOptions.outWidth;
          if (f1 > f2) {
            f1 = f2;
          }
          for (;;)
          {
            f1 = Math.min(1.0F, f1);
            break;
          }
          label388:
          paramInputStream = Integer.valueOf(((Bitmap)localObject1).getWidth());
          break label226;
          label400:
          paramInputStream = Integer.valueOf(((Bitmap)localObject1).getHeight());
          break label246;
          label412:
          paramInputStream = (InputStream)localObject1;
        }
        int i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$DefaultVideoMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "onInput", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a<String, b.f>
  {
    private final b.b GpU;
    
    public c(b.b paramb)
    {
      AppMethodBeat.i(164873);
      this.GpU = paramb;
      AppMethodBeat.o(164873);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    implements Runnable
  {
    private final a<String, b.f> HJI;
    public Rect HJJ;
    b.f HJK;
    public String input;
    public Matrix matrix;
    int mediaType;
    private final m<Boolean, b.f, ah> mgM;
    private final int nrw;
    public Rect viewRect;
    public Rect yok;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, ah> paramm)
    {
      AppMethodBeat.i(164881);
      this.HJI = paramInt;
      this.nrw = paramm;
      this.mgM = localObject;
      this.HJK = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 132
      //   2: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: invokestatic 138	java/lang/System:currentTimeMillis	()J
      //   8: lstore_2
      //   9: aload_0
      //   10: getfield 109	com/tencent/mm/plugin/gallery/picker/b/b$d:HJI	Lcom/tencent/mm/plugin/gallery/picker/b/a;
      //   13: astore 9
      //   15: aload_0
      //   16: getfield 140	com/tencent/mm/plugin/gallery/picker/b/b$d:input	Ljava/lang/String;
      //   19: astore 4
      //   21: aload 4
      //   23: ifnull +126 -> 149
      //   26: aload_0
      //   27: getfield 142	com/tencent/mm/plugin/gallery/picker/b/b$d:mediaType	I
      //   30: istore_1
      //   31: aload_0
      //   32: getfield 144	com/tencent/mm/plugin/gallery/picker/b/b$d:matrix	Landroid/graphics/Matrix;
      //   35: astore 5
      //   37: aload 5
      //   39: ifnull +121 -> 160
      //   42: aload_0
      //   43: getfield 146	com/tencent/mm/plugin/gallery/picker/b/b$d:HJJ	Landroid/graphics/Rect;
      //   46: astore 6
      //   48: aload 6
      //   50: ifnull +121 -> 171
      //   53: aload_0
      //   54: getfield 148	com/tencent/mm/plugin/gallery/picker/b/b$d:yok	Landroid/graphics/Rect;
      //   57: astore 7
      //   59: aload 7
      //   61: ifnull +121 -> 182
      //   64: aload_0
      //   65: getfield 150	com/tencent/mm/plugin/gallery/picker/b/b$d:viewRect	Landroid/graphics/Rect;
      //   68: astore 8
      //   70: aload 8
      //   72: ifnull +121 -> 193
      //   75: aload_0
      //   76: aload 9
      //   78: aload 4
      //   80: iload_1
      //   81: aload 5
      //   83: aload 6
      //   85: aload 7
      //   87: aload 8
      //   89: invokeinterface 155 7 0
      //   94: checkcast 115	com/tencent/mm/plugin/gallery/picker/b/b$f
      //   97: putfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   100: ldc 157
      //   102: ldc 159
      //   104: invokestatic 138	java/lang/System:currentTimeMillis	()J
      //   107: lload_2
      //   108: lsub
      //   109: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   112: invokestatic 169	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
      //   115: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   118: aload_0
      //   119: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   122: aload_0
      //   123: getfield 111	com/tencent/mm/plugin/gallery/picker/b/b$d:nrw	I
      //   126: putfield 175	com/tencent/mm/plugin/gallery/picker/b/b$f:nrw	I
      //   129: new 11	com/tencent/mm/plugin/gallery/picker/b/b$d$a
      //   132: dup
      //   133: aload_0
      //   134: invokespecial 178	com/tencent/mm/plugin/gallery/picker/b/b$d$a:<init>	(Lcom/tencent/mm/plugin/gallery/picker/b/b$d;)V
      //   137: checkcast 180	kotlin/g/a/a
      //   140: invokestatic 186	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
      //   143: ldc 132
      //   145: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: return
      //   149: ldc 187
      //   151: invokestatic 190	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
      //   154: aconst_null
      //   155: astore 4
      //   157: goto -131 -> 26
      //   160: ldc 191
      //   162: invokestatic 190	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
      //   165: aconst_null
      //   166: astore 5
      //   168: goto -126 -> 42
      //   171: ldc 192
      //   173: invokestatic 190	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
      //   176: aconst_null
      //   177: astore 6
      //   179: goto -126 -> 53
      //   182: ldc 193
      //   184: invokestatic 190	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
      //   187: aconst_null
      //   188: astore 7
      //   190: goto -126 -> 64
      //   193: ldc 194
      //   195: invokestatic 190	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
      //   198: aconst_null
      //   199: astore 8
      //   201: goto -126 -> 75
      //   204: astore 4
      //   206: aload_0
      //   207: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   210: iconst_m1
      //   211: putfield 197	com/tencent/mm/plugin/gallery/picker/b/b$f:ret	I
      //   214: ldc 157
      //   216: aload 4
      //   218: checkcast 199	java/lang/Throwable
      //   221: ldc 200
      //   223: iconst_0
      //   224: anewarray 4	java/lang/Object
      //   227: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   230: aload_0
      //   231: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   234: aload_0
      //   235: getfield 111	com/tencent/mm/plugin/gallery/picker/b/b$d:nrw	I
      //   238: putfield 175	com/tencent/mm/plugin/gallery/picker/b/b$f:nrw	I
      //   241: new 11	com/tencent/mm/plugin/gallery/picker/b/b$d$a
      //   244: dup
      //   245: aload_0
      //   246: invokespecial 178	com/tencent/mm/plugin/gallery/picker/b/b$d$a:<init>	(Lcom/tencent/mm/plugin/gallery/picker/b/b$d;)V
      //   249: checkcast 180	kotlin/g/a/a
      //   252: invokestatic 186	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
      //   255: ldc 132
      //   257: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: return
      //   261: astore 4
      //   263: aload_0
      //   264: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   267: iconst_m1
      //   268: putfield 197	com/tencent/mm/plugin/gallery/picker/b/b$f:ret	I
      //   271: ldc 157
      //   273: aload 4
      //   275: checkcast 199	java/lang/Throwable
      //   278: ldc 200
      //   280: iconst_0
      //   281: anewarray 4	java/lang/Object
      //   284: invokestatic 204	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   287: aload_0
      //   288: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   291: aload_0
      //   292: getfield 111	com/tencent/mm/plugin/gallery/picker/b/b$d:nrw	I
      //   295: putfield 175	com/tencent/mm/plugin/gallery/picker/b/b$f:nrw	I
      //   298: new 11	com/tencent/mm/plugin/gallery/picker/b/b$d$a
      //   301: dup
      //   302: aload_0
      //   303: invokespecial 178	com/tencent/mm/plugin/gallery/picker/b/b$d$a:<init>	(Lcom/tencent/mm/plugin/gallery/picker/b/b$d;)V
      //   306: checkcast 180	kotlin/g/a/a
      //   309: invokestatic 186	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
      //   312: ldc 132
      //   314: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   317: return
      //   318: astore 4
      //   320: aload_0
      //   321: getfield 119	com/tencent/mm/plugin/gallery/picker/b/b$d:HJK	Lcom/tencent/mm/plugin/gallery/picker/b/b$f;
      //   324: aload_0
      //   325: getfield 111	com/tencent/mm/plugin/gallery/picker/b/b$d:nrw	I
      //   328: putfield 175	com/tencent/mm/plugin/gallery/picker/b/b$f:nrw	I
      //   331: new 11	com/tencent/mm/plugin/gallery/picker/b/b$d$a
      //   334: dup
      //   335: aload_0
      //   336: invokespecial 178	com/tencent/mm/plugin/gallery/picker/b/b$d$a:<init>	(Lcom/tencent/mm/plugin/gallery/picker/b/b$d;)V
      //   339: checkcast 180	kotlin/g/a/a
      //   342: invokestatic 186	com/tencent/mm/ae/d:uiThread	(Lkotlin/g/a/a;)V
      //   345: ldc 132
      //   347: invokestatic 122	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   350: aload 4
      //   352: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	353	0	this	d
      //   30	51	1	i	int
      //   8	100	2	l	long
      //   19	137	4	str	String
      //   204	13	4	localException	java.lang.Exception
      //   261	13	4	localError	java.lang.Error
      //   318	33	4	localObject	Object
      //   35	132	5	localMatrix	Matrix
      //   46	132	6	localRect1	Rect
      //   57	132	7	localRect2	Rect
      //   68	132	8	localRect3	Rect
      //   13	64	9	locala	a
      // Exception table:
      //   from	to	target	type
      //   5	21	204	java/lang/Exception
      //   26	37	204	java/lang/Exception
      //   42	48	204	java/lang/Exception
      //   53	59	204	java/lang/Exception
      //   64	70	204	java/lang/Exception
      //   75	118	204	java/lang/Exception
      //   149	154	204	java/lang/Exception
      //   160	165	204	java/lang/Exception
      //   171	176	204	java/lang/Exception
      //   182	187	204	java/lang/Exception
      //   193	198	204	java/lang/Exception
      //   5	21	261	java/lang/Error
      //   26	37	261	java/lang/Error
      //   42	48	261	java/lang/Error
      //   53	59	261	java/lang/Error
      //   64	70	261	java/lang/Error
      //   75	118	261	java/lang/Error
      //   149	154	261	java/lang/Error
      //   160	165	261	java/lang/Error
      //   171	176	261	java/lang/Error
      //   182	187	261	java/lang/Error
      //   193	198	261	java/lang/Error
      //   5	21	318	finally
      //   26	37	318	finally
      //   42	48	318	finally
      //   53	59	318	finally
      //   64	70	318	finally
      //   75	118	318	finally
      //   149	154	318	finally
      //   160	165	318	finally
      //   171	176	318	finally
      //   182	187	318	finally
      //   193	198	318	finally
      //   206	230	318	finally
      //   263	287	318	finally
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(b.d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "originHeight", "", "originWidth", "calculateInSampleSize", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getDefaultClipBitmap", "getDefaultContent", "Lkotlin/Pair;", "", "getRotation", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "x", "y", "degree", "Landroid/graphics/Point;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements a<String, b.f>
  {
    private final b.b GpU;
    private int HJN;
    private int HJO;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.GpU = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(289330);
      Object localObject1 = new float[9];
      paramMatrix.getValues((float[])localObject1);
      try
      {
        localObject2 = y.n(paramString, false);
        s.checkNotNull(localObject2);
        s.s(localObject2, "exportExternalPath(input, false)!!");
        localBitmapRegionDecoder = BitmapRegionDecoder.newInstance((String)localObject2, false);
        f1 = Exif.fromFile((String)localObject2).getOrientationInDegree();
        f2 = (float)Math.round(Math.atan2(localObject1[1], localObject1[0]) * 57.295779513082323D);
        f3 = f2 - f1;
        if (f3 % 180.0F != 0.0F) {
          break label1226;
        }
        i = 1;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          BitmapRegionDecoder localBitmapRegionDecoder;
          float f3;
          int j;
          float f4;
          float f5;
          float f6;
          float f7;
          Log.i("MediaTailor", localIOException.getMessage());
          Object localObject2 = new float[9];
          paramMatrix.getValues((float[])localObject2);
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapUtil.decodeFile(paramString, localOptions);
          paramMatrix.getValues((float[])localObject2);
          float f1 = (float)Math.round(Math.atan2(localObject2[1], localObject2[0]) * 57.295779513082323D);
          float f2 = Exif.fromFile(paramString).getOrientationInDegree();
          if (f2 % 180.0F == 0.0F)
          {
            i = 1;
            if (i == 0)
            {
              i = localOptions.outHeight;
              localOptions.outHeight = localOptions.outWidth;
              localOptions.outWidth = i;
            }
            paramMatrix = b.HJz;
            i = this.GpU.maxWidth;
            j = this.GpU.maxHeight;
            s.u(paramString, "inputPath");
            paramString = y.Lh(paramString);
            s.s(paramString, "openRead(inputPath)");
            paramMatrix = b.a.a(paramString, i, j, false, true);
            Log.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
            if (f2 - f1 != 0.0F) {
              break label1220;
            }
          }
          for (int i = 1;; i = 0)
          {
            paramString = paramMatrix;
            if (i == 0)
            {
              paramString = BitmapUtil.rotate(paramMatrix, f2 - f1);
              s.s(paramString, "rotate(source, rawRotate - cropRotation)");
            }
            f3 = 1.0F * paramString.getHeight() / paramRect2.height();
            f4 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
            f5 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
            f4 *= 1.0F * paramString.getWidth();
            f5 *= 1.0F * paramString.getHeight();
            f6 = paramRect1.width();
            f7 = paramRect1.height();
            paramMatrix = k(paramString.getWidth(), paramString.getHeight(), new Rect(kotlin.h.a.eH(f4), kotlin.h.a.eH(f5), kotlin.h.a.eH(f6 * f3 + f4), kotlin.h.a.eH(f7 * f3 + f5)));
            Log.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
            paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
            AppMethodBeat.o(289330);
            return paramString;
            i = 0;
            break;
          }
          i = 0;
          continue;
          i = 1;
          continue;
          if (localOptions == null) {
            localObject2 = null;
          } else if (f1 - f2 == 0.0F) {
            i = 1;
          }
        }
      }
      if (i == 0) {
        j = localBitmapRegionDecoder.getWidth();
      }
      for (i = localBitmapRegionDecoder.getHeight();; i = localBitmapRegionDecoder.getWidth())
      {
        f4 = 1.0F * j / paramRect2.height();
        f5 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
        f6 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
        f5 *= 1.0F * i;
        f6 *= 1.0F * j;
        f7 = paramRect1.width() * f4 + f5;
        f4 = f4 * paramRect1.height() + f6;
        localObject1 = a(f5, f6, i, j, f3);
        localObject2 = a(f7, f4, i, j, f3);
        localObject1 = new Rect(Math.min(((Point)localObject1).x, ((Point)localObject2).x), Math.min(((Point)localObject1).y, ((Point)localObject2).y), Math.max(((Point)localObject1).x, ((Point)localObject2).x), Math.max(((Point)localObject1).y, ((Point)localObject2).y));
        this.HJN = ((Rect)localObject1).width();
        this.HJO = ((Rect)localObject1).height();
        localObject1 = k(localBitmapRegionDecoder.getWidth(), localBitmapRegionDecoder.getHeight(), (Rect)localObject1);
        localObject2 = new BitmapFactory.Options();
        i = (int)(f7 - f5);
        j = (int)(f4 - f6);
        int k = this.GpU.maxWidth;
        int m = this.GpU.maxHeight;
        f3 = Math.max(i / k, j / m);
        if (f3 <= 1.0F) {
          break label1232;
        }
        i = (int)f3;
        ((BitmapFactory.Options)localObject2).inSampleSize = i;
        ah localah = ah.aiuX;
        localObject2 = localBitmapRegionDecoder.decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject2);
        if (localObject2 != null) {
          break;
        }
        localObject2 = null;
        localBitmapRegionDecoder.recycle();
        AppMethodBeat.o(289330);
        return localObject2;
        j = localBitmapRegionDecoder.getHeight();
      }
      f3 = ((Bitmap)localObject2).getHeight() / ((Bitmap)localObject2).getWidth();
      f4 = this.GpU.maxHeight / this.GpU.maxWidth;
      if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.GpU.maxHeight))
      {
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, kotlin.h.a.eH(this.GpU.maxHeight / f3), this.GpU.maxHeight, false);
      }
      else
      {
        localObject1 = localObject2;
        if (f3 <= f4)
        {
          localObject1 = localObject2;
          if (((Bitmap)localObject2).getWidth() > this.GpU.maxWidth)
          {
            f4 = this.GpU.maxWidth;
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.GpU.maxWidth, kotlin.h.a.eH(f3 * f4), false);
            break label1238;
            for (;;)
            {
              localObject2 = localObject1;
              if (i != 0) {
                break;
              }
              localObject2 = BitmapUtil.rotate((Bitmap)localObject1, f1 - f2);
              break;
              i = 0;
            }
          }
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(289323);
      paramFloat1 -= paramInt1 / 2.0F;
      paramFloat2 -= paramInt2 / 2.0F;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      float f = (float)(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Object localObject = new r(Float.valueOf(f), Float.valueOf((float)(paramFloat2 * d2 + d1 * d3)));
      if (paramFloat3 % 180.0F == 0.0F) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new Point(kotlin.h.a.eH(((Number)((r)localObject).bsC).floatValue() + paramInt2 / 2.0F), kotlin.h.a.eH(((Number)((r)localObject).bsD).floatValue() + paramInt1 / 2.0F));
        AppMethodBeat.o(289323);
        return localObject;
      }
      localObject = new Point(kotlin.h.a.eH(((Number)((r)localObject).bsC).floatValue() + paramInt1 / 2.0F), kotlin.h.a.eH(((Number)((r)localObject).bsD).floatValue() + paramInt2 / 2.0F));
      AppMethodBeat.o(289323);
      return localObject;
    }
    
    private static Rect k(int paramInt1, int paramInt2, Rect paramRect)
    {
      if (paramRect.left < 0) {
        paramRect.left = 0;
      }
      if (paramRect.top < 0) {
        paramRect.top = 0;
      }
      if (paramRect.bottom < 0) {
        paramRect.bottom = 0;
      }
      if (paramRect.right < 0) {
        paramRect.right = 0;
      }
      if (paramRect.bottom > paramInt2) {
        paramRect.bottom = paramInt2;
      }
      if (paramRect.right > paramInt1) {
        paramRect.right = paramInt1;
      }
      return paramRect;
    }
    
    public final b.f a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2, Rect paramRect3)
    {
      AppMethodBeat.i(289347);
      s.u(paramString, "input");
      s.u(paramMatrix, "matrix");
      s.u(paramRect1, "clipRect");
      s.u(paramRect2, "contentRect");
      s.u(paramRect3, "viewRect");
      new com.tencent.mm.ae.c("MediaTailor");
      if ((paramRect2.width() == 0) || (paramRect2.height() == 0) || (paramRect1.width() == 0) || (paramRect1.height() == 0))
      {
        Log.e("MediaTailor", "Rect width or height contains zero. contentRect: " + paramRect2 + " clipRect: " + paramRect1);
        paramString = new b.f(-1);
        paramString.aET("");
        AppMethodBeat.o(289347);
        return paramString;
      }
      paramRect3 = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str = (String)p.oM(n.b((CharSequence)paramString, new String[] { "/" }));
      b.f localf = new b.f(0);
      int i;
      label208:
      float f;
      if (paramRect3 == null)
      {
        paramMatrix = "";
        if (TextUtils.isEmpty((CharSequence)paramMatrix)) {
          break label1021;
        }
        i = 0;
        localf.ret = i;
        paramRect2 = com.tencent.mm.plugin.recordvideo.f.c.NRf;
        com.tencent.mm.plugin.recordvideo.f.c.gF("KEY_IMAGE_QUALITY_INT_ARRAY", localf.quality);
        localf.aET(paramMatrix);
        if (localf.ret == 0)
        {
          paramRect2 = c.HJQ;
          c.iN(paramString, paramMatrix);
          f = Math.max(1.0F * this.GpU.oCa / paramRect1.height(), 1.0F * this.GpU.oCa / paramRect1.width());
          paramRect2 = this.GpU.HJE;
          if (this.GpU.filename != null) {
            break label1027;
          }
        }
      }
      label1027:
      for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str;; paramString = s.X("thumb_", this.GpU.filename))
      {
        paramString = s.X(paramRect2, paramString);
        localf.Hd(paramString);
        BitmapUtil.createThumbNail(paramMatrix, kotlin.h.a.eH(paramRect1.height() * f), kotlin.h.a.eH(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.GpU.HJF, paramString);
        Log.i("MediaTailor", "createThumbNail: " + kotlin.h.a.eH(paramRect1.height() * f) + ", " + kotlin.h.a.eH(paramRect1.width() * f));
        AppMethodBeat.o(289347);
        return localf;
        Object localObject;
        if (this.GpU.HJH)
        {
          paramRect2 = Bitmap.createBitmap(paramRect3.getWidth(), paramRect3.getHeight(), Bitmap.Config.ARGB_8888);
          paramMatrix = new Canvas(paramRect2);
          paramMatrix.save();
          localObject = new Path();
          ((Path)localObject).addCircle(paramRect3.getWidth() / 2.0F, paramRect3.getHeight() / 2.0F, paramRect3.getWidth() / 2, Path.Direction.CCW);
          paramMatrix.clipPath((Path)localObject);
          paramMatrix.drawBitmap(paramRect3, 0.0F, 0.0F, null);
          paramMatrix.restore();
        }
        for (;;)
        {
          if (paramRect2 != null) {
            break label574;
          }
          paramMatrix = "";
          break;
          paramRect2 = paramRect3;
        }
        label574:
        if ((!s.p(paramRect2, paramRect3)) && (!paramRect3.isRecycled())) {
          paramRect3.recycle();
        }
        paramMatrix = this.GpU.filePath;
        if (paramMatrix == null)
        {
          localObject = this.GpU.HJE;
          if (this.GpU.filename == null)
          {
            paramMatrix = SystemClock.currentThreadTimeMillis() + '_' + str;
            paramMatrix = s.X((String)localObject, paramMatrix);
          }
        }
        int j;
        boolean bool;
        for (;;)
        {
          j = this.GpU.HJF;
          bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
          i = 0;
          while ((this.GpU.HJG > 0) && (y.bEl(paramMatrix) > this.GpU.HJG) && (j > 0))
          {
            j -= 5;
            bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
          }
          paramMatrix = this.GpU.filename;
          break;
        }
        Log.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.GpU.HJG + " tryCount=" + i + " compressQuality=" + j + " isCircle=" + this.GpU.HJH + " size=" + Util.getSizeKB(y.bEl(paramMatrix)));
        if ((this.HJN == 0) || (this.HJO == 0))
        {
          this.HJN = paramRect3.getWidth();
          this.HJO = paramRect3.getHeight();
        }
        if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zbJ, 1) == 1)
        {
          i = AdaptiveAdjustBitrate.getOrignalImageQuality(this.HJN, this.HJO, paramRect2.getWidth(), paramRect2.getHeight(), j / 100.0F);
          label966:
          localf.quality = i;
          if (!paramRect2.isRecycled()) {
            paramRect2.recycle();
          }
          if (!bool) {
            break label1015;
          }
        }
        label1015:
        for (paramRect2 = paramMatrix;; paramRect2 = null)
        {
          paramMatrix = paramRect2;
          if (paramRect2 != null) {
            break;
          }
          paramMatrix = "";
          break;
          i = 0;
          break label966;
        }
        label1021:
        i = -1;
        break label208;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "quality", "getQuality", "()I", "setQuality", "getRet", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class f
  {
    public String HJP;
    public int nrw;
    int quality;
    public int ret;
    public String thumbPath;
    
    public f(int paramInt)
    {
      this.ret = paramInt;
      this.HJP = "";
      this.thumbPath = "";
    }
    
    public final void Hd(String paramString)
    {
      AppMethodBeat.i(164885);
      s.u(paramString, "<set-?>");
      this.thumbPath = paramString;
      AppMethodBeat.o(164885);
    }
    
    public final void aET(String paramString)
    {
      AppMethodBeat.i(164884);
      s.u(paramString, "<set-?>");
      this.HJP = paramString;
      AppMethodBeat.o(164884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */