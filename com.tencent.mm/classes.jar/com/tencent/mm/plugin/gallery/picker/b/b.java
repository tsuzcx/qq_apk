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
import com.tencent.mm.ae.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"})
public final class b
{
  public static final a BXq;
  private a<String, f> BXm;
  private a<String, f> BXn;
  public a<String, f> BXo;
  private final com.tencent.e.b BXp;
  
  static
  {
    AppMethodBeat.i(164890);
    BXq = new a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(164889);
    this.BXm = ((a)new e(paramb));
    this.BXn = ((a)new c(paramb));
    this.BXo = ((a)new c(paramb));
    this.BXp = new com.tencent.e.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), (e)g.BXD);
    AppMethodBeat.o(164889);
  }
  
  public final void a(a<String, f> parama)
  {
    AppMethodBeat.i(164887);
    p.k(parama, "<set-?>");
    this.BXn = parama;
    AppMethodBeat.o(164887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(243442);
    this.BXp.shutdownNow();
    AppMethodBeat.o(243442);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Companion;", "", "()V", "TAG", "", "decodeBitmap", "Landroid/graphics/Bitmap;", "inputStream", "Ljava/io/InputStream;", "limitW", "", "limitH", "isRotate", "", "isClose", "inputPath", "plugin-gallery_release"})
  public static final class a
  {
    public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(164869);
      p.k(paramInputStream, "inputStream");
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
              localObject1 = Exif.fromStream(paramInputStream);
              p.j(localObject1, "Exif.fromStream(inputStream)");
              i = ((Exif)localObject1).getOrientationInDegree();
              Log.i("MediaTailor", "read exif rotate degree %d", new Object[] { Integer.valueOf(i) });
              localObject1 = BitmapUtil.rotate((Bitmap)localObject2, i * 1.0F);
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
            Log.i("MediaTailor", paramInputStream + "] scale=" + f1 + " limit[" + paramInt2 + ':' + paramInt1 + "] decode bitmap done!");
            if (localObject1 != null) {
              break label433;
            }
            paramInputStream = BitmapUtil.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            Log.e("MediaTailor", "bitmap is null. " + Util.getStack());
          }
        }
        for (;;)
        {
          p.j(paramInputStream, "bitmap");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"})
  public static final class b
  {
    public String BXr;
    public int BXs;
    public int BXt;
    boolean BXu;
    public String filePath;
    public String filename;
    int lJy;
    public int maxHeight;
    public int maxWidth;
    
    public b()
    {
      AppMethodBeat.i(164871);
      this.BXr = "";
      this.lJy = 480;
      this.maxHeight = ((int)MMApplicationContext.getResources().getDimension(com.tencent.mm.plugin.gallery.b.c.gallery_crop_image_limit));
      this.maxWidth = this.maxHeight;
      this.BXs = 80;
      AppMethodBeat.o(164871);
    }
    
    public final void aIu(String paramString)
    {
      AppMethodBeat.i(164870);
      p.k(paramString, "value");
      String str = paramString;
      if (n.bi((CharSequence)paramString) != '/') {
        str = paramString + '/';
      }
      this.BXr = str;
      AppMethodBeat.o(164870);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$DefaultVideoMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "onInput", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "plugin-gallery_release"})
  public static final class c
    implements a<String, b.f>
  {
    private final b.b ANu;
    
    public c(b.b paramb)
    {
      AppMethodBeat.i(164873);
      this.ANu = paramb;
      AppMethodBeat.o(164873);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"})
  public final class d
    implements Runnable
  {
    public Rect BXv;
    b.f BXw;
    private final a<String, b.f> BXx;
    public Matrix aHZ;
    public String input;
    private final m<Boolean, b.f, x> jHk;
    private final int kPS;
    int mediaType;
    public Rect vcr;
    public Rect viewRect;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, x> paramm)
    {
      AppMethodBeat.i(164881);
      this.BXx = paramInt;
      this.kPS = paramm;
      this.jHk = localObject;
      this.BXw = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    public final void run()
    {
      AppMethodBeat.i(164880);
      try
      {
        long l = System.currentTimeMillis();
        a locala = this.BXx;
        String str = this.input;
        if (str == null) {
          p.bGy("input");
        }
        int i = this.mediaType;
        Matrix localMatrix = this.aHZ;
        if (localMatrix == null) {
          p.bGy("matrix");
        }
        Rect localRect1 = this.BXv;
        if (localRect1 == null) {
          p.bGy("clipRect");
        }
        Rect localRect2 = this.vcr;
        if (localRect2 == null) {
          p.bGy("contentRect");
        }
        Rect localRect3 = this.viewRect;
        if (localRect3 == null) {
          p.bGy("viewRect");
        }
        this.BXw = ((b.f)locala.a(str, i, localMatrix, localRect1, localRect2, localRect3));
        Log.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        this.BXw.ret = -1;
        Log.printErrStackTrace("MediaTailor", (Throwable)localException, "", new Object[0]);
        return;
      }
      catch (Error localError)
      {
        this.BXw.ret = -1;
        Log.printErrStackTrace("MediaTailor", (Throwable)localError, "", new Object[0]);
        return;
      }
      finally
      {
        this.BXw.kPS = this.kPS;
        d.uiThread((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(164880);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(b.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "originHeight", "", "originWidth", "calculateInSampleSize", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getDefaultClipBitmap", "getDefaultContent", "Lkotlin/Pair;", "", "getRotation", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "x", "y", "degree", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class e
    implements a<String, b.f>
  {
    private final b.b ANu;
    private int BXA;
    private int BXB;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.ANu = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(242900);
      Object localObject1 = new float[9];
      paramMatrix.getValues((float[])localObject1);
      label1207:
      for (;;)
      {
        try
        {
          Object localObject2 = u.n(paramString, false);
          BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance((String)localObject2, false);
          localObject2 = Exif.fromFile((String)localObject2);
          p.j(localObject2, "Exif.fromFile(vfsPath)");
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
            p.j(localBitmapRegionDecoder, "regionDecoder");
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
            this.BXA = ((Rect)localObject1).width();
            this.BXB = ((Rect)localObject1).height();
            localObject1 = k(localBitmapRegionDecoder.getWidth(), localBitmapRegionDecoder.getHeight(), (Rect)localObject1);
            localObject2 = new BitmapFactory.Options();
            i = (int)(f7 - f5);
            j = (int)(f4 - f6);
            int k = this.ANu.maxWidth;
            int m = this.ANu.maxHeight;
            f3 = Math.max(i / k, j / m);
            if (f3 <= 1.0F) {
              break label1207;
            }
            i = (int)f3;
            ((BitmapFactory.Options)localObject2).inSampleSize = i;
            localObject2 = localBitmapRegionDecoder.decodeRegion((Rect)localObject1, (BitmapFactory.Options)localObject2);
            if (localObject2 == null) {
              continue;
            }
            f3 = ((Bitmap)localObject2).getHeight() / ((Bitmap)localObject2).getWidth();
            f4 = this.ANu.maxHeight / this.ANu.maxWidth;
            if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.ANu.maxHeight))
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, kotlin.h.a.dm(this.ANu.maxHeight / f3), this.ANu.maxHeight, false);
              if (localObject1 == null) {
                continue;
              }
              localObject2 = localObject1;
              if (f1 - f2 != 0.0F) {
                localObject2 = BitmapUtil.rotate((Bitmap)localObject1, f1 - f2);
              }
              localBitmapRegionDecoder.recycle();
              AppMethodBeat.o(242900);
              return localObject2;
            }
          }
          else
          {
            p.j(localBitmapRegionDecoder, "regionDecoder");
            j = localBitmapRegionDecoder.getHeight();
            i = localBitmapRegionDecoder.getWidth();
            continue;
          }
          localObject1 = localObject2;
          if (f3 <= f4)
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getWidth() > this.ANu.maxWidth)
            {
              f4 = this.ANu.maxWidth;
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.ANu.maxWidth, kotlin.h.a.dm(f3 * f4), false);
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
          Log.i("MediaTailor", localIOException.getMessage());
          localObject2 = new float[9];
          paramMatrix.getValues((float[])localObject2);
          localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapUtil.decodeFile(paramString, localOptions);
          paramMatrix.getValues((float[])localObject2);
          f1 = (float)Math.round(Math.atan2(localObject2[1], localObject2[0]) * 57.295779513082323D);
          paramMatrix = Exif.fromFile(paramString);
          p.j(paramMatrix, "Exif.fromFile(input)");
          f2 = paramMatrix.getOrientationInDegree();
          if (f2 % 180.0F != 0.0F)
          {
            i = localOptions.outHeight;
            localOptions.outHeight = localOptions.outWidth;
            localOptions.outWidth = i;
          }
          paramMatrix = b.BXq;
          i = this.ANu.maxWidth;
          j = this.ANu.maxHeight;
          p.k(paramString, "inputPath");
          paramString = u.Tf(paramString);
          p.j(paramString, "VFSFileOp.openRead(inputPath)");
          paramMatrix = b.a.a(paramString, i, j, false, true);
          Log.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
          paramString = paramMatrix;
          if (f2 - f1 != 0.0F)
          {
            paramString = BitmapUtil.rotate(paramMatrix, f2 - f1);
            p.j(paramString, "BitmapUtil.rotate(source…rawRotate - cropRotation)");
          }
          f3 = 1.0F * paramString.getHeight() / paramRect2.height();
          f4 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
          f5 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
          f4 *= 1.0F * paramString.getWidth();
          f5 *= 1.0F * paramString.getHeight();
          f6 = paramRect1.width();
          f7 = paramRect1.height();
          paramMatrix = k(paramString.getWidth(), paramString.getHeight(), new Rect(kotlin.h.a.dm(f4), kotlin.h.a.dm(f5), kotlin.h.a.dm(f6 * f3 + f4), kotlin.h.a.dm(f7 * f3 + f5)));
          Log.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
          paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
          AppMethodBeat.o(242900);
          return paramString;
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(242899);
      paramFloat1 -= paramInt1 / 2.0F;
      paramFloat2 -= paramInt2 / 2.0F;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      float f = (float)(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Object localObject = new o(Float.valueOf(f), Float.valueOf((float)(paramFloat2 * d2 + d1 * d3)));
      if (paramFloat3 % 180.0F != 0.0F)
      {
        localObject = new Point(kotlin.h.a.dm(((Number)((o)localObject).Mx).floatValue() + paramInt2 / 2.0F), kotlin.h.a.dm(((Number)((o)localObject).My).floatValue() + paramInt1 / 2.0F));
        AppMethodBeat.o(242899);
        return localObject;
      }
      localObject = new Point(kotlin.h.a.dm(((Number)((o)localObject).Mx).floatValue() + paramInt1 / 2.0F), kotlin.h.a.dm(((Number)((o)localObject).My).floatValue() + paramInt2 / 2.0F));
      AppMethodBeat.o(242899);
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
      AppMethodBeat.i(242896);
      p.k(paramString, "input");
      p.k(paramMatrix, "matrix");
      p.k(paramRect1, "clipRect");
      p.k(paramRect2, "contentRect");
      p.k(paramRect3, "viewRect");
      new com.tencent.mm.ae.c("MediaTailor");
      if ((paramRect2.width() == 0) || (paramRect2.height() == 0) || (paramRect1.width() == 0) || (paramRect1.height() == 0))
      {
        Log.e("MediaTailor", "Rect width or height contains zero. contentRect: " + paramRect2 + " clipRect: " + paramRect1);
        paramString = new b.f(-1);
        paramString.aIv("");
        AppMethodBeat.o(242896);
        return paramString;
      }
      paramRect3 = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str = (String)j.lq(n.b((CharSequence)paramString, new String[] { "/" }));
      b.f localf = new b.f(0);
      if (paramRect3 != null) {
        if (this.ANu.BXu)
        {
          paramRect2 = Bitmap.createBitmap(paramRect3.getWidth(), paramRect3.getHeight(), Bitmap.Config.ARGB_8888);
          paramMatrix = new Canvas(paramRect2);
          paramMatrix.save();
          Object localObject = new Path();
          ((Path)localObject).addCircle(paramRect3.getWidth() / 2.0F, paramRect3.getHeight() / 2.0F, paramRect3.getWidth() / 2, Path.Direction.CCW);
          paramMatrix.clipPath((Path)localObject);
          paramMatrix.drawBitmap(paramRect3, 0.0F, 0.0F, null);
          paramMatrix.restore();
          if (paramRect2 == null) {
            break label748;
          }
          if (((p.h(paramRect2, paramRect3) ^ true)) && (!paramRect3.isRecycled())) {
            paramRect3.recycle();
          }
          paramMatrix = this.ANu.filePath;
          if (paramMatrix != null) {
            break label1066;
          }
          localObject = new StringBuilder().append(this.ANu.BXr);
          if (this.ANu.filename != null) {
            break label496;
          }
          paramMatrix = SystemClock.currentThreadTimeMillis() + '_' + str;
          label393:
          paramMatrix = paramMatrix;
        }
      }
      label1028:
      label1033:
      label1039:
      label1066:
      for (;;)
      {
        int j = this.ANu.BXs;
        boolean bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
        int i = 0;
        for (;;)
        {
          if ((this.ANu.BXt > 0) && (u.bBQ(paramMatrix) > this.ANu.BXt) && (j > 0))
          {
            j -= 5;
            bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
            continue;
            paramRect2 = paramRect3;
            break;
            label496:
            paramMatrix = this.ANu.filename;
            break label393;
          }
        }
        Log.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.ANu.BXt + " tryCount=" + i + ' ' + "compressQuality=" + j + " isCircle=" + this.ANu.BXu + " size=" + Util.getSizeKB(u.bBQ(paramMatrix)));
        if ((this.BXA == 0) || (this.BXB == 0))
        {
          this.BXA = paramRect3.getWidth();
          this.BXB = paramRect3.getHeight();
        }
        label741:
        label748:
        label767:
        float f;
        if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vLj, 1) == 1)
        {
          i = AdaptiveAdjustBitrate.getOrignalImageQuality(this.BXA, this.BXB, paramRect2.getWidth(), paramRect2.getHeight(), j / 100.0F);
          localf.quality = i;
          if (!paramRect2.isRecycled()) {
            paramRect2.recycle();
          }
          if (!bool) {
            break label1028;
          }
          paramRect2 = paramMatrix;
          if (paramMatrix == null) {
            paramRect2 = "";
          }
          if (TextUtils.isEmpty((CharSequence)paramRect2)) {
            break label1033;
          }
          i = 0;
          localf.ret = i;
          paramMatrix = com.tencent.mm.plugin.recordvideo.d.c.HUw;
          com.tencent.mm.plugin.recordvideo.d.c.fN("KEY_IMAGE_QUALITY_INT_ARRAY", localf.quality);
          localf.aIv(paramRect2);
          if (localf.ret == 0)
          {
            paramMatrix = c.BXE;
            c.hL(paramString, paramRect2);
            f = Math.max(1.0F * this.ANu.lJy / paramRect1.height(), 1.0F * this.ANu.lJy / paramRect1.width());
            paramMatrix = new StringBuilder().append(this.ANu.BXr);
            if (this.ANu.filename != null) {
              break label1039;
            }
          }
        }
        for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str;; paramString = "thumb_" + this.ANu.filename)
        {
          paramString = paramString;
          localf.ON(paramString);
          BitmapUtil.createThumbNail(paramRect2, kotlin.h.a.dm(paramRect1.height() * f), kotlin.h.a.dm(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.ANu.BXs, paramString);
          Log.i("MediaTailor", "createThumbNail: " + kotlin.h.a.dm(paramRect1.height() * f) + ", " + kotlin.h.a.dm(paramRect1.width() * f));
          AppMethodBeat.o(242896);
          return localf;
          i = 0;
          break;
          paramMatrix = null;
          break label741;
          i = -1;
          break label767;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "quality", "getQuality", "()I", "setQuality", "getRet", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"})
  public static class f
  {
    public String BXC;
    public int kPS;
    int quality;
    public int ret;
    public String thumbPath;
    
    public f(int paramInt)
    {
      this.ret = paramInt;
      this.BXC = "";
      this.thumbPath = "";
    }
    
    public final void ON(String paramString)
    {
      AppMethodBeat.i(164885);
      p.k(paramString, "<set-?>");
      this.thumbPath = paramString;
      AppMethodBeat.o(164885);
    }
    
    public final void aIv(String paramString)
    {
      AppMethodBeat.i(164884);
      p.k(paramString, "<set-?>");
      this.BXC = paramString;
      AppMethodBeat.o(164884);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "threadPool", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "rejectedExecution"})
  static final class g
    implements e
  {
    public static final g BXD;
    
    static
    {
      AppMethodBeat.i(164886);
      BXD = new g();
      AppMethodBeat.o(164886);
    }
    
    public final void a(Runnable paramRunnable, com.tencent.e.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */