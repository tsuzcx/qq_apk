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
import com.tencent.mm.ac.c;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.n.n;
import d.o;
import d.y;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"})
public final class b
{
  public static final b.a sMm;
  private a<String, f> sMi;
  private a<String, f> sMj;
  public a<String, f> sMk;
  private final com.tencent.e.b sMl;
  
  static
  {
    AppMethodBeat.i(164890);
    sMm = new b.a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(164889);
    this.sMi = ((a)new e(paramb));
    this.sMj = ((a)new c(paramb));
    this.sMk = ((a)new c(paramb));
    this.sMl = new com.tencent.e.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), (e)g.sMy);
    AppMethodBeat.o(164889);
  }
  
  public final void a(a<String, f> parama)
  {
    AppMethodBeat.i(164887);
    k.h(parama, "<set-?>");
    this.sMj = parama;
    AppMethodBeat.o(164887);
  }
  
  public final void a(String paramString, int paramInt1, Matrix paramMatrix, Rect paramRect1, Rect paramRect2, Rect paramRect3, int paramInt2, boolean paramBoolean, m<? super Boolean, ? super f, y> paramm)
  {
    AppMethodBeat.i(198438);
    k.h(paramString, "input");
    k.h(paramMatrix, "matrix");
    k.h(paramRect1, "clipRect");
    k.h(paramRect2, "contentRect");
    k.h(paramRect3, "viewRect");
    k.h(paramm, "callback");
    if (paramBoolean) {
      paramm = new d(this.sMk, paramInt2, paramm);
    }
    for (;;)
    {
      paramm.l(paramRect1);
      paramm.m(paramRect3);
      paramm.n(paramRect2);
      paramm.agv(paramString);
      paramm.setMatrix(paramMatrix);
      paramm.mediaType = paramInt1;
      this.sMl.execute((Runnable)paramm);
      AppMethodBeat.o(198438);
      return;
      if (paramInt1 == 1) {
        paramm = new d(this.sMi, paramInt2, paramm);
      } else {
        paramm = new d(this.sMj, paramInt2, paramm);
      }
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(198440);
    this.sMl.shutdownNow();
    AppMethodBeat.o(198440);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"})
  public static final class b
  {
    public String filePath;
    public String filename;
    int hCK;
    public int maxHeight;
    public int maxWidth;
    public String sMn;
    public int sMo;
    public int sMp;
    boolean sMq;
    
    public b()
    {
      AppMethodBeat.i(164871);
      this.sMn = "";
      this.hCK = 480;
      this.maxHeight = ((int)ai.getResources().getDimension(2131166395));
      this.maxWidth = this.maxHeight;
      this.sMo = 80;
      AppMethodBeat.o(164871);
    }
    
    public final void agu(String paramString)
    {
      AppMethodBeat.i(164870);
      k.h(paramString, "value");
      String str = paramString;
      if (n.aK((CharSequence)paramString) != '/') {
        str = paramString + '/';
      }
      this.sMn = str;
      AppMethodBeat.o(164870);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$DefaultVideoMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "onInput", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "plugin-gallery_release"})
  public static final class c
    implements a<String, b.f>
  {
    private final b.b rSg;
    
    public c(b.b paramb)
    {
      AppMethodBeat.i(164873);
      this.rSg = paramb;
      AppMethodBeat.o(164873);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"})
  public final class d
    implements Runnable
  {
    public Matrix eY;
    private final m<Boolean, b.f, y> fPF;
    int mediaType;
    public Rect pvE;
    public String sMr;
    public Rect sMs;
    b.f sMt;
    private final a<String, b.f> sMu;
    private final int token;
    public Rect viewRect;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, y> paramm)
    {
      AppMethodBeat.i(164881);
      this.sMu = paramInt;
      this.token = paramm;
      this.fPF = localObject;
      this.sMt = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    public final void agv(String paramString)
    {
      AppMethodBeat.i(164875);
      k.h(paramString, "<set-?>");
      this.sMr = paramString;
      AppMethodBeat.o(164875);
    }
    
    public final void l(Rect paramRect)
    {
      AppMethodBeat.i(164877);
      k.h(paramRect, "<set-?>");
      this.sMs = paramRect;
      AppMethodBeat.o(164877);
    }
    
    public final void m(Rect paramRect)
    {
      AppMethodBeat.i(164878);
      k.h(paramRect, "<set-?>");
      this.viewRect = paramRect;
      AppMethodBeat.o(164878);
    }
    
    public final void n(Rect paramRect)
    {
      AppMethodBeat.i(164879);
      k.h(paramRect, "<set-?>");
      this.pvE = paramRect;
      AppMethodBeat.o(164879);
    }
    
    public final void run()
    {
      AppMethodBeat.i(164880);
      try
      {
        long l = System.currentTimeMillis();
        a locala = this.sMu;
        String str = this.sMr;
        if (str == null) {
          k.aVY("input");
        }
        int i = this.mediaType;
        Matrix localMatrix = this.eY;
        if (localMatrix == null) {
          k.aVY("matrix");
        }
        Rect localRect1 = this.sMs;
        if (localRect1 == null) {
          k.aVY("clipRect");
        }
        Rect localRect2 = this.pvE;
        if (localRect2 == null) {
          k.aVY("contentRect");
        }
        Rect localRect3 = this.viewRect;
        if (localRect3 == null) {
          k.aVY("viewRect");
        }
        this.sMt = ((b.f)locala.a(str, i, localMatrix, localRect1, localRect2, localRect3));
        ac.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        this.sMt.ret = -1;
        ac.printErrStackTrace("MediaTailor", (Throwable)localException, "", new Object[0]);
        return;
      }
      catch (Error localError)
      {
        this.sMt.ret = -1;
        ac.printErrStackTrace("MediaTailor", (Throwable)localError, "", new Object[0]);
        return;
      }
      finally
      {
        this.sMt.token = this.token;
        c.g((d.g.a.a)new a(this));
        AppMethodBeat.o(164880);
      }
    }
    
    public final void setMatrix(Matrix paramMatrix)
    {
      AppMethodBeat.i(164876);
      k.h(paramMatrix, "<set-?>");
      this.eY = paramMatrix;
      AppMethodBeat.o(164876);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "calculateInSampleSize", "", "originWidth", "originHeight", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getRotation", "", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "Lkotlin/Pair;", "x", "y", "degree", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class e
    implements a<String, b.f>
  {
    private final b.b rSg;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.rSg = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(198437);
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
            int k = this.rSg.maxWidth;
            int m = this.rSg.maxHeight;
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
            f4 = this.rSg.maxHeight / this.rSg.maxWidth;
            if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.rSg.maxHeight))
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, d.h.a.cj(this.rSg.maxHeight / f3), this.rSg.maxHeight, false);
              if (localObject1 == null) {
                continue;
              }
              localObject2 = localObject1;
              if (f1 - f2 != 0.0F) {
                localObject2 = f.a((Bitmap)localObject1, f1 - f2);
              }
              localBitmapRegionDecoder.recycle();
              AppMethodBeat.o(198437);
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
            if (((Bitmap)localObject2).getWidth() > this.rSg.maxWidth)
            {
              f4 = this.rSg.maxWidth;
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.rSg.maxWidth, d.h.a.cj(f3 * f4), false);
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
          ac.i("MediaTailor", localIOException.getMessage());
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
          paramMatrix = b.sMm;
          i = this.rSg.maxWidth;
          j = this.rSg.maxHeight;
          k.h(paramString, "inputPath");
          paramString = i.openRead(paramString);
          k.g(paramString, "VFSFileOp.openRead(inputPath)");
          paramMatrix = b.a.a(paramString, i, j, false, true);
          ac.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
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
          paramMatrix = c(paramString.getWidth(), paramString.getHeight(), new Rect(d.h.a.cj(f4), d.h.a.cj(f5), d.h.a.cj(f6 * f3 + f4), d.h.a.cj(f7 * f3 + f5)));
          ac.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
          paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
          AppMethodBeat.o(198437);
          return paramString;
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(198436);
      paramFloat1 -= paramInt1 / 2.0F;
      paramFloat2 -= paramInt2 / 2.0F;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      float f = (float)(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Object localObject = new o(Float.valueOf(f), Float.valueOf((float)(paramFloat2 * d2 + d1 * d3)));
      if (paramFloat3 % 180.0F != 0.0F)
      {
        localObject = new Point(d.h.a.cj(((Number)((o)localObject).first).floatValue() + paramInt2 / 2.0F), d.h.a.cj(((Number)((o)localObject).second).floatValue() + paramInt1 / 2.0F));
        AppMethodBeat.o(198436);
        return localObject;
      }
      localObject = new Point(d.h.a.cj(((Number)((o)localObject).first).floatValue() + paramInt1 / 2.0F), d.h.a.cj(((Number)((o)localObject).second).floatValue() + paramInt2 / 2.0F));
      AppMethodBeat.o(198436);
      return localObject;
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
      AppMethodBeat.i(198434);
      k.h(paramString, "input");
      k.h(paramMatrix, "matrix");
      k.h(paramRect1, "clipRect");
      k.h(paramRect2, "contentRect");
      k.h(paramRect3, "viewRect");
      new com.tencent.mm.ac.b("MediaTailor");
      paramMatrix = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str1 = (String)j.iQ(n.a((CharSequence)paramString, new String[] { "/" }));
      Object localObject1;
      int i;
      if (paramMatrix != null)
      {
        if (this.rSg.sMq)
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
          paramRect3 = this.rSg.filePath;
          paramMatrix = paramRect3;
          if (paramRect3 == null)
          {
            paramRect3 = new StringBuilder().append(this.rSg.sMn);
            if (this.rSg.filename != null) {
              break label397;
            }
          }
        }
        int j;
        boolean bool;
        label397:
        for (paramMatrix = SystemClock.currentThreadTimeMillis() + '_' + str1;; paramMatrix = this.rSg.filename)
        {
          paramMatrix = paramMatrix;
          j = this.rSg.sMo;
          bool = f.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
          i = 0;
          while ((this.rSg.sMp > 0) && (i.aSp(paramMatrix) > this.rSg.sMp) && (j > 0))
          {
            j -= 5;
            bool = f.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
          }
          paramRect2 = paramMatrix;
          break;
        }
        ac.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.rSg.sMp + " tryCount=" + i + ' ' + "compressQuality=" + j + " isCircle=" + this.rSg.sMq + " size=" + bs.qz(i.aSp(paramMatrix)));
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
        paramMatrix.agw(paramRect2);
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
          f = Math.max(1.0F * this.rSg.hCK / paramRect1.height(), 1.0F * this.rSg.hCK / paramRect1.width());
          paramRect3 = new StringBuilder().append(this.rSg.sMn);
          if (this.rSg.filename != null) {
            break label971;
          }
        }
      }
      label960:
      label971:
      for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str1;; paramString = "thumb_" + this.rSg.filename)
      {
        paramString = paramString;
        paramMatrix.vx(paramString);
        f.a(paramRect2, d.h.a.cj(paramRect1.height() * f), d.h.a.cj(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.rSg.sMo, paramString);
        ac.i("MediaTailor", "createThumbNail: " + d.h.a.cj(paramRect1.height() * f) + ", " + d.h.a.cj(paramRect1.width() * f));
        AppMethodBeat.o(198434);
        return paramMatrix;
        paramMatrix = null;
        break;
        i = -1;
        break label577;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "getRet", "()I", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"})
  public static class f
  {
    public int ret;
    public String sMx;
    public String thumbPath;
    public int token;
    
    public f(int paramInt)
    {
      this.ret = paramInt;
      this.sMx = "";
      this.thumbPath = "";
    }
    
    public final void agw(String paramString)
    {
      AppMethodBeat.i(164884);
      k.h(paramString, "<set-?>");
      this.sMx = paramString;
      AppMethodBeat.o(164884);
    }
    
    public final void vx(String paramString)
    {
      AppMethodBeat.i(164885);
      k.h(paramString, "<set-?>");
      this.thumbPath = paramString;
      AppMethodBeat.o(164885);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "threadPool", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "rejectedExecution"})
  static final class g
    implements e
  {
    public static final g sMy;
    
    static
    {
      AppMethodBeat.i(164886);
      sMy = new g();
      AppMethodBeat.o(164886);
    }
    
    public final void a(Runnable paramRunnable, com.tencent.e.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */