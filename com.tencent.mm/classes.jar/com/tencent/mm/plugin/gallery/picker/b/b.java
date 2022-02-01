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
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.z;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"})
public final class b
{
  public static final b.a tTK;
  private a<String, f> tTG;
  private a<String, f> tTH;
  public a<String, f> tTI;
  private final com.tencent.e.b tTJ;
  
  static
  {
    AppMethodBeat.i(164890);
    tTK = new b.a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(164889);
    this.tTG = ((a)new e(paramb));
    this.tTH = ((a)new c(paramb));
    this.tTI = ((a)new c(paramb));
    this.tTJ = new com.tencent.e.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), (e)b.g.tTX);
    AppMethodBeat.o(164889);
  }
  
  public final void a(a<String, f> parama)
  {
    AppMethodBeat.i(164887);
    p.h(parama, "<set-?>");
    this.tTH = parama;
    AppMethodBeat.o(164887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(186211);
    this.tTJ.shutdownNow();
    AppMethodBeat.o(186211);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "", "()V", "compressQuality", "", "getCompressQuality", "()I", "setCompressQuality", "(I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "filename", "getFilename", "setFilename", "isCircle", "", "()Z", "setCircle", "(Z)V", "maxFileLength", "getMaxFileLength", "setMaxFileLength", "maxHeight", "getMaxHeight", "setMaxHeight", "maxWidth", "getMaxWidth", "setMaxWidth", "value", "outputDir", "getOutputDir", "setOutputDir", "thumbSize", "getThumbSize", "setThumbSize", "plugin-gallery_release"})
  public static final class b
  {
    public String filePath;
    public String filename;
    int hYh;
    public int maxHeight;
    public int maxWidth;
    public String tTL;
    public int tTM;
    public int tTN;
    boolean tTO;
    
    public b()
    {
      AppMethodBeat.i(164871);
      this.tTL = "";
      this.hYh = 480;
      this.maxHeight = ((int)ak.getResources().getDimension(2131166395));
      this.maxWidth = this.maxHeight;
      this.tTM = 80;
      AppMethodBeat.o(164871);
    }
    
    public final void alQ(String paramString)
    {
      AppMethodBeat.i(164870);
      p.h(paramString, "value");
      String str = paramString;
      if (n.aK((CharSequence)paramString) != '/') {
        str = paramString + '/';
      }
      this.tTL = str;
      AppMethodBeat.o(164870);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$DefaultVideoMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "onInput", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "plugin-gallery_release"})
  public static final class c
    implements a<String, b.f>
  {
    private final b.b sZV;
    
    public c(b.b paramb)
    {
      AppMethodBeat.i(164873);
      this.sZV = paramb;
      AppMethodBeat.o(164873);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"})
  public final class d
    implements Runnable
  {
    public String aWG;
    public Matrix gR;
    private final m<Boolean, b.f, z> glx;
    int mediaType;
    public Rect qfO;
    public Rect tTP;
    b.f tTQ;
    private final a<String, b.f> tTR;
    private final int token;
    public Rect viewRect;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, z> paramm)
    {
      AppMethodBeat.i(164881);
      this.tTR = paramInt;
      this.token = paramm;
      this.glx = localObject;
      this.tTQ = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    public final void run()
    {
      AppMethodBeat.i(164880);
      try
      {
        long l = System.currentTimeMillis();
        a locala = this.tTR;
        String str = this.aWG;
        if (str == null) {
          p.bdF("input");
        }
        int i = this.mediaType;
        Matrix localMatrix = this.gR;
        if (localMatrix == null) {
          p.bdF("matrix");
        }
        Rect localRect1 = this.tTP;
        if (localRect1 == null) {
          p.bdF("clipRect");
        }
        Rect localRect2 = this.qfO;
        if (localRect2 == null) {
          p.bdF("contentRect");
        }
        Rect localRect3 = this.viewRect;
        if (localRect3 == null) {
          p.bdF("viewRect");
        }
        this.tTQ = ((b.f)locala.a(str, i, localMatrix, localRect1, localRect2, localRect3));
        ae.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        this.tTQ.ret = -1;
        ae.printErrStackTrace("MediaTailor", (Throwable)localException, "", new Object[0]);
        return;
      }
      catch (Error localError)
      {
        this.tTQ.ret = -1;
        ae.printErrStackTrace("MediaTailor", (Throwable)localError, "", new Object[0]);
        return;
      }
      finally
      {
        this.tTQ.token = this.token;
        com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
        AppMethodBeat.o(164880);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(b.d paramd)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "originHeight", "", "originWidth", "calculateInSampleSize", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getRotation", "", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "Lkotlin/Pair;", "x", "y", "degree", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class e
    implements a<String, b.f>
  {
    private final b.b sZV;
    private int tTU;
    private int tTV;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.sZV = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(186209);
      Object localObject1 = new float[9];
      paramMatrix.getValues((float[])localObject1);
      label1207:
      for (;;)
      {
        try
        {
          Object localObject2 = com.tencent.mm.vfs.o.k(paramString, false);
          BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance((String)localObject2, false);
          localObject2 = Exif.fromFile((String)localObject2);
          p.g(localObject2, "Exif.fromFile(vfsPath)");
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
            p.g(localBitmapRegionDecoder, "regionDecoder");
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
            this.tTU = ((Rect)localObject1).width();
            this.tTV = ((Rect)localObject1).height();
            localObject1 = c(localBitmapRegionDecoder.getWidth(), localBitmapRegionDecoder.getHeight(), (Rect)localObject1);
            localObject2 = new BitmapFactory.Options();
            i = (int)(f7 - f5);
            j = (int)(f4 - f6);
            int k = this.sZV.maxWidth;
            int m = this.sZV.maxHeight;
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
            f4 = this.sZV.maxHeight / this.sZV.maxWidth;
            if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.sZV.maxHeight))
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, d.h.a.cm(this.sZV.maxHeight / f3), this.sZV.maxHeight, false);
              if (localObject1 == null) {
                continue;
              }
              localObject2 = localObject1;
              if (f1 - f2 != 0.0F) {
                localObject2 = h.a((Bitmap)localObject1, f1 - f2);
              }
              localBitmapRegionDecoder.recycle();
              AppMethodBeat.o(186209);
              return localObject2;
            }
          }
          else
          {
            p.g(localBitmapRegionDecoder, "regionDecoder");
            j = localBitmapRegionDecoder.getHeight();
            i = localBitmapRegionDecoder.getWidth();
            continue;
          }
          localObject1 = localObject2;
          if (f3 <= f4)
          {
            localObject1 = localObject2;
            if (((Bitmap)localObject2).getWidth() > this.sZV.maxWidth)
            {
              f4 = this.sZV.maxWidth;
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.sZV.maxWidth, d.h.a.cm(f3 * f4), false);
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
          ae.i("MediaTailor", localIOException.getMessage());
          localObject2 = new float[9];
          paramMatrix.getValues((float[])localObject2);
          localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          h.decodeFile(paramString, localOptions);
          paramMatrix.getValues((float[])localObject2);
          f1 = (float)Math.round(Math.atan2(localObject2[1], localObject2[0]) * 57.295779513082323D);
          paramMatrix = Exif.fromFile(paramString);
          p.g(paramMatrix, "Exif.fromFile(input)");
          f2 = paramMatrix.getOrientationInDegree();
          if (f2 % 180.0F != 0.0F)
          {
            i = localOptions.outHeight;
            localOptions.outHeight = localOptions.outWidth;
            localOptions.outWidth = i;
          }
          paramMatrix = b.tTK;
          i = this.sZV.maxWidth;
          j = this.sZV.maxHeight;
          p.h(paramString, "inputPath");
          paramString = com.tencent.mm.vfs.o.openRead(paramString);
          p.g(paramString, "VFSFileOp.openRead(inputPath)");
          paramMatrix = b.a.a(paramString, i, j, false, true);
          ae.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
          paramString = paramMatrix;
          if (f2 - f1 != 0.0F)
          {
            paramString = h.a(paramMatrix, f2 - f1);
            p.g(paramString, "BitmapUtil.rotate(source…rawRotate - cropRotation)");
          }
          f3 = 1.0F * paramString.getHeight() / paramRect2.height();
          f4 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
          f5 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
          f4 *= 1.0F * paramString.getWidth();
          f5 *= 1.0F * paramString.getHeight();
          f6 = paramRect1.width();
          f7 = paramRect1.height();
          paramMatrix = c(paramString.getWidth(), paramString.getHeight(), new Rect(d.h.a.cm(f4), d.h.a.cm(f5), d.h.a.cm(f6 * f3 + f4), d.h.a.cm(f7 * f3 + f5)));
          ae.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
          paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
          AppMethodBeat.o(186209);
          return paramString;
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(186208);
      paramFloat1 -= paramInt1 / 2.0F;
      paramFloat2 -= paramInt2 / 2.0F;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      float f = (float)(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Object localObject = new d.o(Float.valueOf(f), Float.valueOf((float)(paramFloat2 * d2 + d1 * d3)));
      if (paramFloat3 % 180.0F != 0.0F)
      {
        localObject = new Point(d.h.a.cm(((Number)((d.o)localObject).first).floatValue() + paramInt2 / 2.0F), d.h.a.cm(((Number)((d.o)localObject).second).floatValue() + paramInt1 / 2.0F));
        AppMethodBeat.o(186208);
        return localObject;
      }
      localObject = new Point(d.h.a.cm(((Number)((d.o)localObject).first).floatValue() + paramInt1 / 2.0F), d.h.a.cm(((Number)((d.o)localObject).second).floatValue() + paramInt2 / 2.0F));
      AppMethodBeat.o(186208);
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
      AppMethodBeat.i(186206);
      p.h(paramString, "input");
      p.h(paramMatrix, "matrix");
      p.h(paramRect1, "clipRect");
      p.h(paramRect2, "contentRect");
      p.h(paramRect3, "viewRect");
      new com.tencent.mm.ac.b("MediaTailor");
      if ((paramRect2.width() == 0) || (paramRect2.height() == 0) || (paramRect1.width() == 0) || (paramRect1.height() == 0))
      {
        ae.e("MediaTailor", "Rect width or height contains zero. contentRect: " + paramRect2 + " clipRect: " + paramRect1);
        paramString = new b.f(-1);
        paramString.alR("");
        AppMethodBeat.o(186206);
        return paramString;
      }
      paramRect3 = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str1 = (String)j.jn(n.b((CharSequence)paramString, new String[] { "/" }));
      b.f localf = new b.f(0);
      Object localObject1;
      if (paramRect3 != null) {
        if (this.sZV.tTO)
        {
          paramRect2 = Bitmap.createBitmap(paramRect3.getWidth(), paramRect3.getHeight(), Bitmap.Config.ARGB_8888);
          paramMatrix = new Canvas(paramRect2);
          paramMatrix.save();
          localObject1 = new Path();
          ((Path)localObject1).addCircle(paramRect3.getWidth() / 2.0F, paramRect3.getHeight() / 2.0F, paramRect3.getWidth() / 2, Path.Direction.CCW);
          paramMatrix.clipPath((Path)localObject1);
          paramMatrix.drawBitmap(paramRect3, 0.0F, 0.0F, null);
          paramMatrix.restore();
          if (paramRect2 == null) {
            break label748;
          }
          if (((p.i(paramRect2, paramRect3) ^ true)) && (!paramRect3.isRecycled())) {
            paramRect3.recycle();
          }
          paramMatrix = this.sZV.filePath;
          if (paramMatrix != null) {
            break label1206;
          }
          localObject1 = new StringBuilder().append(this.sZV.tTL);
          if (this.sZV.filename != null) {
            break label496;
          }
          paramMatrix = SystemClock.currentThreadTimeMillis() + '_' + str1;
          label393:
          paramMatrix = paramMatrix;
        }
      }
      label1168:
      label1173:
      label1179:
      label1206:
      for (;;)
      {
        int j = this.sZV.tTM;
        boolean bool = h.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
        int i = 0;
        for (;;)
        {
          if ((this.sZV.tTN > 0) && (com.tencent.mm.vfs.o.aZR(paramMatrix) > this.sZV.tTN) && (j > 0))
          {
            j -= 5;
            bool = h.a(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
            continue;
            paramRect2 = paramRect3;
            break;
            label496:
            paramMatrix = this.sZV.filename;
            break label393;
          }
        }
        ae.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.sZV.tTN + " tryCount=" + i + ' ' + "compressQuality=" + j + " isCircle=" + this.sZV.tTO + " size=" + bu.sL(com.tencent.mm.vfs.o.aZR(paramMatrix)));
        if ((this.tTU == 0) || (this.tTV == 0))
        {
          this.tTU = paramRect3.getWidth();
          this.tTV = paramRect3.getHeight();
        }
        label741:
        label748:
        label767:
        float f;
        if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIn, 1) == 1)
        {
          i = AdaptiveAdjustBitrate.getOrignalImageQuality(this.tTU, this.tTV, paramRect2.getWidth(), paramRect2.getHeight(), j / 100.0F);
          localf.quality = i;
          if (!paramRect2.isRecycled()) {
            paramRect2.recycle();
          }
          if (!bool) {
            break label1168;
          }
          paramRect2 = paramMatrix;
          if (paramMatrix == null) {
            paramRect2 = "";
          }
          if (TextUtils.isEmpty((CharSequence)paramRect2)) {
            break label1173;
          }
          i = 0;
          localf.ret = i;
          paramMatrix = com.tencent.mm.plugin.recordvideo.d.c.xWV;
          com.tencent.mm.plugin.recordvideo.d.c.eT("KEY_IMAGE_QUALITY_INT_ARRAY", localf.quality);
          localf.alR(paramRect2);
          if (localf.ret == 0)
          {
            Object localObject2 = new androidx.a.a.a(com.tencent.mm.vfs.o.k(paramString, false));
            paramString = ((androidx.a.a.a)localObject2).getAttribute("GPSLongitude");
            paramMatrix = ((androidx.a.a.a)localObject2).getAttribute("GPSLatitude");
            paramRect3 = ((androidx.a.a.a)localObject2).getAttribute("GPSLongitudeRef");
            localObject1 = ((androidx.a.a.a)localObject2).getAttribute("GPSLatitudeRef");
            String str2 = ((androidx.a.a.a)localObject2).getAttribute("GPSDestLongitude");
            localObject2 = ((androidx.a.a.a)localObject2).getAttribute("GPSDestLongitudeRef");
            androidx.a.a.a locala = new androidx.a.a.a(com.tencent.mm.vfs.o.k(paramRect2, false));
            locala.setAttribute("GPSLongitude", paramString);
            locala.setAttribute("GPSLatitude", paramMatrix);
            locala.setAttribute("GPSLongitudeRef", paramRect3);
            locala.setAttribute("GPSLatitudeRef", (String)localObject1);
            locala.setAttribute("GPSDestLongitude", str2);
            locala.setAttribute("GPSDestLongitudeRef", (String)localObject2);
            locala.saveAttributes();
            f = Math.max(1.0F * this.sZV.hYh / paramRect1.height(), 1.0F * this.sZV.hYh / paramRect1.width());
            paramMatrix = new StringBuilder().append(this.sZV.tTL);
            if (this.sZV.filename != null) {
              break label1179;
            }
          }
        }
        for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str1;; paramString = "thumb_" + this.sZV.filename)
        {
          paramString = paramString;
          localf.yY(paramString);
          h.a(paramRect2, d.h.a.cm(paramRect1.height() * f), d.h.a.cm(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.sZV.tTM, paramString);
          ae.i("MediaTailor", "createThumbNail: " + d.h.a.cm(paramRect1.height() * f) + ", " + d.h.a.cm(paramRect1.width() * f));
          AppMethodBeat.o(186206);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "", "ret", "", "(I)V", "outPath", "", "getOutPath", "()Ljava/lang/String;", "setOutPath", "(Ljava/lang/String;)V", "quality", "getQuality", "()I", "setQuality", "getRet", "setRet", "thumbPath", "getThumbPath", "setThumbPath", "token", "getToken", "setToken", "plugin-gallery_release"})
  public static class f
  {
    int quality;
    public int ret;
    public String tTW;
    public String thumbPath;
    public int token;
    
    public f(int paramInt)
    {
      this.ret = paramInt;
      this.tTW = "";
      this.thumbPath = "";
    }
    
    public final void alR(String paramString)
    {
      AppMethodBeat.i(164884);
      p.h(paramString, "<set-?>");
      this.tTW = paramString;
      AppMethodBeat.o(164884);
    }
    
    public final void yY(String paramString)
    {
      AppMethodBeat.i(164885);
      p.h(paramString, "<set-?>");
      this.thumbPath = paramString;
      AppMethodBeat.o(164885);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */