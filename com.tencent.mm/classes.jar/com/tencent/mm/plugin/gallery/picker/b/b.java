package com.tencent.mm.plugin.gallery.picker.b;

import android.content.res.Resources;
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
import com.tencent.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.n.n;
import d.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"})
public final class b
{
  public static final a rDt;
  public a<String, f> Lmn;
  private a<String, f> rDq;
  private a<String, f> rDr;
  private final com.tencent.e.b rDs;
  
  static
  {
    AppMethodBeat.i(164890);
    rDt = new a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(164889);
    this.rDq = ((a)new e(paramb));
    this.rDr = ((a)new c(paramb));
    this.Lmn = ((a)new c(paramb));
    this.rDs = new com.tencent.e.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), (e)g.rDG);
    AppMethodBeat.o(164889);
  }
  
  public final void a(a<String, f> parama)
  {
    AppMethodBeat.i(164887);
    k.h(parama, "<set-?>");
    this.rDr = parama;
    AppMethodBeat.o(164887);
  }
  
  public final void a(String paramString, int paramInt1, Matrix paramMatrix, Rect paramRect1, Rect paramRect2, Rect paramRect3, int paramInt2, boolean paramBoolean, m<? super Boolean, ? super f, y> paramm)
  {
    AppMethodBeat.i(200785);
    k.h(paramString, "input");
    k.h(paramMatrix, "matrix");
    k.h(paramRect1, "clipRect");
    k.h(paramRect2, "contentRect");
    k.h(paramRect3, "viewRect");
    k.h(paramm, "callback");
    if (paramBoolean) {
      paramm = new d(this.Lmn, paramInt2, paramm);
    }
    for (;;)
    {
      paramm.m(paramRect1);
      paramm.n(paramRect3);
      paramm.o(paramRect2);
      paramm.abD(paramString);
      paramm.setMatrix(paramMatrix);
      paramm.mediaType = paramInt1;
      this.rDs.execute((Runnable)paramm);
      AppMethodBeat.o(200785);
      return;
      if (paramInt1 == 1) {
        paramm = new d(this.rDq, paramInt2, paramm);
      } else {
        paramm = new d(this.rDr, paramInt2, paramm);
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(186739);
    this.rDs.shutdownNow();
    AppMethodBeat.o(186739);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Companion;", "", "()V", "TAG", "", "decodeBitmap", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "limitW", "", "limitH", "isRotate", "", "isClose", "inputPath", "plugin-gallery_release"})
  public static final class a
  {
    public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(164869);
      k.h(paramInputStream, "inputStream");
      if (paramInt1 > paramInt2) {}
      for (;;)
      {
        BitmapFactory.Options localOptions = f.b(paramInputStream, false);
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
            Object localObject2 = f.a(paramInputStream, 0.0F, i, j);
            localObject1 = localObject2;
            if (paramBoolean1)
            {
              paramInputStream.reset();
              localObject1 = Exif.fromStream(paramInputStream);
              k.g(localObject1, "Exif.fromStream(inputStream)");
              i = ((Exif)localObject1).getOrientationInDegree();
              ad.i("MediaTailor", "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
              localObject1 = f.a((Bitmap)localObject2, i * 1.0F);
            }
            if (paramBoolean2) {
              paramInputStream.close();
            }
            localObject2 = new StringBuilder("[decodeBitmap] [").append(localOptions.outWidth).append(':').append(localOptions.outHeight).append("]->[");
            if (localObject1 == null) {
              break label423;
            }
            paramInputStream = Integer.valueOf(((Bitmap)localObject1).getWidth());
            label244:
            localObject2 = ((StringBuilder)localObject2).append(paramInputStream).append(':');
            if (localObject1 == null) {
              break label428;
            }
            paramInputStream = Integer.valueOf(((Bitmap)localObject1).getHeight());
            label271:
            ad.i("MediaTailor", paramInputStream + "] scale=" + f1 + " limit[" + paramInt2 + ':' + paramInt1 + "] decode bitmap done!");
            if (localObject1 != null) {
              break label433;
            }
            paramInputStream = f.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            ad.e("MediaTailor", "bitmap is null. " + bt.eGN());
          }
        }
        for (;;)
        {
          k.g(paramInputStream, "bitmap");
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
          label423:
          paramInputStream = null;
          break label244;
          label428:
          paramInputStream = null;
          break label271;
          label433:
          paramInputStream = (InputStream)localObject1;
        }
        int i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"})
  public static final class b
  {
    public String filePath;
    public String filename;
    int hci;
    public int maxHeight;
    public int maxWidth;
    public String rDu;
    public int rDv;
    public int rDw;
    boolean rDx;
    
    public b()
    {
      AppMethodBeat.i(164871);
      this.rDu = "";
      this.hci = 480;
      this.maxHeight = ((int)aj.getResources().getDimension(2131166395));
      this.maxWidth = this.maxHeight;
      this.rDv = 80;
      AppMethodBeat.o(164871);
    }
    
    public final void abC(String paramString)
    {
      AppMethodBeat.i(164870);
      k.h(paramString, "value");
      String str = paramString;
      if (n.aJ((CharSequence)paramString) != '/') {
        str = paramString + '/';
      }
      this.rDu = str;
      AppMethodBeat.o(164870);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$DefaultVideoMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "onInput", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "plugin-gallery_release"})
  public static final class c
    implements a<String, b.f>
  {
    private final b.b qTP;
    
    public c(b.b paramb)
    {
      AppMethodBeat.i(164873);
      this.qTP = paramb;
      AppMethodBeat.o(164873);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"})
  public final class d
    implements Runnable
  {
    public Matrix dY;
    private final m<Boolean, b.f, y> fLT;
    int mediaType;
    public Rect oSt;
    b.f rDB;
    private final a<String, b.f> rDC;
    public String rDy;
    public Rect rDz;
    private final int token;
    public Rect viewRect;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, y> paramm)
    {
      AppMethodBeat.i(164881);
      this.rDC = paramInt;
      this.token = paramm;
      this.fLT = localObject;
      this.rDB = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    public final void abD(String paramString)
    {
      AppMethodBeat.i(164875);
      k.h(paramString, "<set-?>");
      this.rDy = paramString;
      AppMethodBeat.o(164875);
    }
    
    public final void m(Rect paramRect)
    {
      AppMethodBeat.i(164877);
      k.h(paramRect, "<set-?>");
      this.rDz = paramRect;
      AppMethodBeat.o(164877);
    }
    
    public final void n(Rect paramRect)
    {
      AppMethodBeat.i(164878);
      k.h(paramRect, "<set-?>");
      this.viewRect = paramRect;
      AppMethodBeat.o(164878);
    }
    
    public final void o(Rect paramRect)
    {
      AppMethodBeat.i(164879);
      k.h(paramRect, "<set-?>");
      this.oSt = paramRect;
      AppMethodBeat.o(164879);
    }
    
    public final void run()
    {
      AppMethodBeat.i(164880);
      try
      {
        long l = System.currentTimeMillis();
        a locala = this.rDC;
        String str = this.rDy;
        if (str == null) {
          k.aPZ("input");
        }
        int i = this.mediaType;
        Matrix localMatrix = this.dY;
        if (localMatrix == null) {
          k.aPZ("matrix");
        }
        Rect localRect1 = this.rDz;
        if (localRect1 == null) {
          k.aPZ("clipRect");
        }
        Rect localRect2 = this.oSt;
        if (localRect2 == null) {
          k.aPZ("contentRect");
        }
        Rect localRect3 = this.viewRect;
        if (localRect3 == null) {
          k.aPZ("viewRect");
        }
        this.rDB = ((b.f)locala.a(str, i, localMatrix, localRect1, localRect2, localRect3));
        ad.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MediaTailor", (Throwable)localException, "", new Object[0]);
        return;
      }
      catch (Error localError)
      {
        ad.printErrStackTrace("MediaTailor", (Throwable)localError, "", new Object[0]);
        return;
      }
      finally
      {
        this.rDB.token = this.token;
        c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(164880);
      }
    }
    
    public final void setMatrix(Matrix paramMatrix)
    {
      AppMethodBeat.i(164876);
      k.h(paramMatrix, "<set-?>");
      this.dY = paramMatrix;
      AppMethodBeat.o(164876);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(b.d paramd)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "calculateInSampleSize", "", "originWidth", "originHeight", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getRotation", "", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "Landroid/graphics/Point;", "x", "y", "degree", "plugin-gallery_release"})
  public static final class e
    implements a<String, b.f>
  {
    private final b.b qTP;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.qTP = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(186738);
      Object localObject1 = new float[9];
      paramMatrix.getValues((float[])localObject1);
      label1188:
      for (;;)
      {
        try
        {
          Object localObject2 = i.k(paramString, false);
          BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance((String)localObject2, false);
          localObject2 = Exif.fromFile((String)localObject2);
          k.g(localObject2, "Exif.fromFile(vfsPath)");
          float f1 = ((Exif)localObject2).getOrientationInDegree();
          float f2 = (float)Math.round(Math.atan2(localObject1[1], localObject1[0]) * 57.295779513082323D);
          float f3 = f2 - f1;
          int j;
          int i;
          float f4;
          float f5;
          float f6;
          float f7;
          if (f3 % 180.0F != 0.0F)
          {
            k.g(localBitmapRegionDecoder, "regionDecoder");
            j = localBitmapRegionDecoder.getWidth();
            i = localBitmapRegionDecoder.getHeight();
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
            localObject1 = c(localBitmapRegionDecoder.getWidth(), localBitmapRegionDecoder.getHeight(), (Rect)localObject1);
            localObject2 = new BitmapFactory.Options();
            i = (int)(f7 - f5);
            j = (int)(f4 - f6);
            int k = this.qTP.maxWidth;
            int m = this.qTP.maxHeight;
            f3 = Math.max(i / k, j / m);
            if (f3 <= 1.0F) {
              break label1188;
            }
            i = (int)f3;
            ((BitmapFactory.Options)localObject2).inSampleSize = i;
            localObject2 = localBitmapRegionDecoder.decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject2);
            if (localObject2 == null) {
              continue;
            }
            f3 = ((Bitmap)localObject2).getHeight() / ((Bitmap)localObject2).getWidth();
            f4 = this.qTP.maxHeight / this.qTP.maxWidth;
            if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.qTP.maxHeight))
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, d.h.a.bU(this.qTP.maxHeight / f3), this.qTP.maxHeight, false);
              if (localObject1 == null) {
                continue;
              }
              localObject2 = localObject1;
              if (f1 - f2 != 0.0F) {
                localObject2 = f.a((Bitmap)localObject1, f1 - f2);
              }
              localBitmapRegionDecoder.recycle();
              AppMethodBeat.o(186738);
              return localObject2;
            }
          }
          else
          {
            k.g(localBitmapRegionDecoder, "regionDecoder");
            j = localBitmapRegionDecoder.getHeight();
            i = localBitmapRegionDecoder.getWidth();
            continue;
          }
          localObject1 = localObject2;
          if (f3 <= f4)
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getWidth() > this.qTP.maxWidth)
            {
              f4 = this.qTP.maxWidth;
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.qTP.maxWidth, d.h.a.bU(f3 * f4), false);
              continue;
              localObject2 = null;
              continue;
              BitmapFactory.Options localOptions;
              i = 1;
            }
          }
        }
        catch (IOException localIOException)
        {
          ad.i("MediaTailor", localIOException.getMessage());
          localObject2 = new float[9];
          paramMatrix.getValues((float[])localObject2);
          localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          f.decodeFile(paramString, localOptions);
          paramMatrix.getValues((float[])localObject2);
          f1 = (float)Math.round(Math.atan2(localObject2[1], localObject2[0]) * 57.295779513082323D);
          paramMatrix = Exif.fromFile(paramString);
          k.g(paramMatrix, "Exif.fromFile(input)");
          f2 = paramMatrix.getOrientationInDegree();
          if (f2 % 180.0F != 0.0F)
          {
            i = localOptions.outHeight;
            localOptions.outHeight = localOptions.outWidth;
            localOptions.outWidth = i;
          }
          paramMatrix = b.rDt;
          i = this.qTP.maxWidth;
          j = this.qTP.maxHeight;
          k.h(paramString, "inputPath");
          paramString = i.openRead(paramString);
          k.g(paramString, "VFSFileOp.openRead(inputPath)");
          paramMatrix = b.a.a(paramString, i, j, false, true);
          ad.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
          paramString = paramMatrix;
          if (f2 - f1 != 0.0F)
          {
            paramString = f.a(paramMatrix, f2 - f1);
            k.g(paramString, "BitmapUtil.rotate(source…rawRotate - cropRotation)");
          }
          f3 = 1.0F * paramString.getHeight() / paramRect2.height();
          f4 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
          f5 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
          f4 *= 1.0F * paramString.getWidth();
          f5 *= 1.0F * paramString.getHeight();
          f6 = paramRect1.width();
          f7 = paramRect1.height();
          paramMatrix = c(paramString.getWidth(), paramString.getHeight(), new Rect(d.h.a.bU(f4), d.h.a.bU(f5), d.h.a.bU(f6 * f3 + f4), d.h.a.bU(f7 * f3 + f5)));
          ad.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
          paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
          AppMethodBeat.o(186738);
          return paramString;
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(186737);
      paramFloat1 -= paramInt1 / 2;
      paramFloat2 -= paramInt2 / 2;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      int i = d.h.a.M(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Point localPoint = new Point(i, d.h.a.M(paramFloat2 * d2 + d1 * d3));
      if (paramFloat3 % 180.0F != 0.0F)
      {
        localPoint = new Point(localPoint.x + paramInt2 / 2, localPoint.y + paramInt1 / 2);
        AppMethodBeat.o(186737);
        return localPoint;
      }
      localPoint = new Point(localPoint.x + paramInt1 / 2, localPoint.y + paramInt2 / 2);
      AppMethodBeat.o(186737);
      return localPoint;
    }
    
    private static Rect c(int paramInt1, int paramInt2, Rect paramRect)
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
      AppMethodBeat.i(200783);
      k.h(paramString, "input");
      k.h(paramMatrix, "matrix");
      k.h(paramRect1, "clipRect");
      k.h(paramRect2, "contentRect");
      k.h(paramRect3, "viewRect");
      new com.tencent.mm.ad.b("MediaTailor");
      paramMatrix = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str1 = (String)j.iA(n.a((CharSequence)paramString, new String[] { "/" }));
      Object localObject1;
      int i;
      if (paramMatrix != null)
      {
        if (this.qTP.rDx)
        {
          paramRect2 = Bitmap.createBitmap(paramMatrix.getWidth(), paramMatrix.getHeight(), Bitmap.Config.ARGB_8888);
          paramRect3 = new Canvas(paramRect2);
          paramRect3.save();
          localObject1 = new Path();
          ((Path)localObject1).addCircle(paramMatrix.getWidth() / 2.0F, paramMatrix.getHeight() / 2.0F, paramMatrix.getWidth() / 2, Path.Direction.CCW);
          paramRect3.clipPath((Path)localObject1);
          paramRect3.drawBitmap(paramMatrix, 0.0F, 0.0F, null);
          paramRect3.restore();
          if (paramRect2 == null) {
            break label558;
          }
          if (((k.g(paramRect2, paramMatrix) ^ true)) && (!paramMatrix.isRecycled())) {
            paramMatrix.recycle();
          }
          paramRect3 = this.qTP.filePath;
          paramMatrix = paramRect3;
          if (paramRect3 == null)
          {
            paramRect3 = new StringBuilder().append(this.qTP.rDu);
            if (this.qTP.filename != null) {
              break label397;
            }
          }
        }
        int j;
        boolean bool;
        label397:
        for (paramMatrix = SystemClock.currentThreadTimeMillis() + '_' + str1;; paramMatrix = this.qTP.filename)
        {
          paramMatrix = paramMatrix;
          j = this.qTP.rDv;
          bool = f.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
          i = 0;
          while ((this.qTP.rDw > 0) && (i.aMN(paramMatrix) > this.qTP.rDw) && (j > 0))
          {
            j -= 5;
            bool = f.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
          }
          paramRect2 = paramMatrix;
          break;
        }
        ad.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.qTP.rDw + " tryCount=" + i + ' ' + "compressQuality=" + j + " isCircle=" + this.qTP.rDx + " size=" + bt.mK(i.aMN(paramMatrix)));
        if (!paramRect2.isRecycled()) {
          paramRect2.recycle();
        }
        if (!bool) {
          break label960;
        }
        paramRect2 = paramMatrix;
        if (paramMatrix != null) {
          break label563;
        }
      }
      label558:
      paramRect2 = "";
      label563:
      label577:
      float f;
      if (!TextUtils.isEmpty((CharSequence)paramRect2))
      {
        i = 0;
        paramMatrix = new b.f(i);
        paramMatrix.abE(paramRect2);
        if (paramMatrix.ret == 0)
        {
          Object localObject2 = new androidx.a.a.a(i.k(paramString, false));
          paramString = ((androidx.a.a.a)localObject2).getAttribute("GPSLongitude");
          paramRect3 = ((androidx.a.a.a)localObject2).getAttribute("GPSLatitude");
          localObject1 = ((androidx.a.a.a)localObject2).getAttribute("GPSLongitudeRef");
          String str2 = ((androidx.a.a.a)localObject2).getAttribute("GPSLatitudeRef");
          String str3 = ((androidx.a.a.a)localObject2).getAttribute("GPSDestLongitude");
          localObject2 = ((androidx.a.a.a)localObject2).getAttribute("GPSDestLongitudeRef");
          androidx.a.a.a locala = new androidx.a.a.a(i.k(paramRect2, false));
          locala.setAttribute("GPSLongitude", paramString);
          locala.setAttribute("GPSLatitude", paramRect3);
          locala.setAttribute("GPSLongitudeRef", (String)localObject1);
          locala.setAttribute("GPSLatitudeRef", str2);
          locala.setAttribute("GPSDestLongitude", str3);
          locala.setAttribute("GPSDestLongitudeRef", (String)localObject2);
          locala.saveAttributes();
          f = Math.max(1.0F * this.qTP.hci / paramRect1.height(), 1.0F * this.qTP.hci / paramRect1.width());
          paramRect3 = new StringBuilder().append(this.qTP.rDu);
          if (this.qTP.filename != null) {
            break label971;
          }
        }
      }
      label960:
      label971:
      for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str1;; paramString = "thumb_" + this.qTP.filename)
      {
        paramString = paramString;
        paramMatrix.ru(paramString);
        f.a(paramRect2, d.h.a.bU(paramRect1.height() * f), d.h.a.bU(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.qTP.rDv, paramString);
        ad.i("MediaTailor", "createThumbNail: " + d.h.a.bU(paramRect1.height() * f) + ", " + d.h.a.bU(paramRect1.width() * f));
        AppMethodBeat.o(200783);
        return paramMatrix;
        paramMatrix = null;
        break;
        i = -1;
        break label577;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "getRet", "()I", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"})
  public static class f
  {
    public String rDF;
    public int ret;
    public String thumbPath;
    public int token;
    
    public f(int paramInt)
    {
      this.ret = paramInt;
      this.rDF = "";
      this.thumbPath = "";
    }
    
    public final void abE(String paramString)
    {
      AppMethodBeat.i(164884);
      k.h(paramString, "<set-?>");
      this.rDF = paramString;
      AppMethodBeat.o(164884);
    }
    
    public final void ru(String paramString)
    {
      AppMethodBeat.i(164885);
      k.h(paramString, "<set-?>");
      this.thumbPath = paramString;
      AppMethodBeat.o(164885);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "threadPool", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "rejectedExecution"})
  static final class g
    implements e
  {
    public static final g rDG;
    
    static
    {
      AppMethodBeat.i(164886);
      rDG = new g();
      AppMethodBeat.o(164886);
    }
    
    public final void a(Runnable paramRunnable, com.tencent.e.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */