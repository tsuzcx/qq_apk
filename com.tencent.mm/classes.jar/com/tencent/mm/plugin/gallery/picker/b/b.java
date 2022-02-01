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
import com.tencent.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.IOException;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;", "", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "imageTailor", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "getImageTailor", "()Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "setImageTailor", "(Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;)V", "videoTailor", "getVideoTailor", "setVideoTailor", "vlogTailor", "getVlogTailor", "setVlogTailor", "worker", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "destroy", "", "post", "input", "mediaType", "", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "token", "isVLogMode", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "Companion", "Config", "DefaultVideoMediaGenerateImpl", "GenerateTask", "ImageMediaGenerateImpl", "Result", "plugin-gallery_release"})
public final class b
{
  public static final b.a xkW;
  private a<String, b.f> xkS;
  private a<String, b.f> xkT;
  public a<String, b.f> xkU;
  private final com.tencent.f.b xkV;
  
  static
  {
    AppMethodBeat.i(164890);
    xkW = new b.a((byte)0);
    AppMethodBeat.o(164890);
  }
  
  public b(b.b paramb)
  {
    AppMethodBeat.i(164889);
    this.xkS = ((a)new e(paramb));
    this.xkT = ((a)new b.c(paramb));
    this.xkU = ((a)new b.c(paramb));
    this.xkV = new com.tencent.f.b("MediaTailor", 3, 3, (BlockingQueue)new LinkedBlockingQueue(), (e)g.xlj);
    AppMethodBeat.o(164889);
  }
  
  public final void a(a<String, b.f> parama)
  {
    AppMethodBeat.i(164887);
    p.h(parama, "<set-?>");
    this.xkT = parama;
    AppMethodBeat.o(164887);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(257775);
    this.xkV.shutdownNow();
    AppMethodBeat.o(257775);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$GenerateTask;", "Ljava/lang/Runnable;", "generate", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "token", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccessfully", "result", "", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor;Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;ILkotlin/jvm/functions/Function2;)V", "clipRect", "Landroid/graphics/Rect;", "getClipRect", "()Landroid/graphics/Rect;", "setClipRect", "(Landroid/graphics/Rect;)V", "contentRect", "getContentRect", "setContentRect", "input", "getInput", "()Ljava/lang/String;", "setInput", "(Ljava/lang/String;)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "getResult", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "setResult", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;)V", "viewRect", "getViewRect", "setViewRect", "run", "plugin-gallery_release"})
  public final class d
    implements Runnable
  {
    public String aWy;
    public Matrix gT;
    private final m<Boolean, b.f, x> gWp;
    int mediaType;
    public Rect rwL;
    private final int token;
    public Rect viewRect;
    public Rect xlb;
    b.f xlc;
    private final a<String, b.f> xld;
    
    public d(int paramInt, m<? super Boolean, ? super b.f, x> paramm)
    {
      AppMethodBeat.i(164881);
      this.xld = paramInt;
      this.token = paramm;
      this.gWp = localObject;
      this.xlc = new b.f(0);
      AppMethodBeat.o(164881);
    }
    
    public final void run()
    {
      AppMethodBeat.i(164880);
      try
      {
        long l = System.currentTimeMillis();
        a locala = this.xld;
        String str = this.aWy;
        if (str == null) {
          p.btv("input");
        }
        int i = this.mediaType;
        Matrix localMatrix = this.gT;
        if (localMatrix == null) {
          p.btv("matrix");
        }
        Rect localRect1 = this.xlb;
        if (localRect1 == null) {
          p.btv("clipRect");
        }
        Rect localRect2 = this.rwL;
        if (localRect2 == null) {
          p.btv("contentRect");
        }
        Rect localRect3 = this.viewRect;
        if (localRect3 == null) {
          p.btv("viewRect");
        }
        this.xlc = ((b.f)locala.a(str, i, localMatrix, localRect1, localRect2, localRect3));
        Log.i("MediaTailor", "generate image cost: " + (System.currentTimeMillis() - l));
        return;
      }
      catch (Exception localException)
      {
        this.xlc.ret = -1;
        Log.printErrStackTrace("MediaTailor", (Throwable)localException, "", new Object[0]);
        return;
      }
      catch (Error localError)
      {
        this.xlc.ret = -1;
        Log.printErrStackTrace("MediaTailor", (Throwable)localError, "", new Object[0]);
        return;
      }
      finally
      {
        this.xlc.token = this.token;
        d.h((kotlin.g.a.a)new a(this));
        AppMethodBeat.o(164880);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$ImageMediaGenerateImpl;", "Lcom/tencent/mm/plugin/gallery/picker/generator/IMediaGenerate;", "", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Result;", "config", "Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "(Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;)V", "getConfig", "()Lcom/tencent/mm/plugin/gallery/picker/generator/MediaTailor$Config;", "originHeight", "", "originWidth", "calculateInSampleSize", "reqWidth", "reqHeight", "getClipBitmap", "Landroid/graphics/Bitmap;", "input", "matrix", "Landroid/graphics/Matrix;", "clipRect", "Landroid/graphics/Rect;", "contentRect", "getClipBitmapOtherFormat", "getDefaultClipBitmap", "getDefaultContent", "Lkotlin/Pair;", "", "getRotation", "values", "", "getSafeClipRect", "width", "height", "onInput", "mediaType", "viewRect", "pointRotate", "x", "y", "degree", "Landroid/graphics/Point;", "plugin-gallery_release"})
  public static final class e
    implements a<String, b.f>
  {
    private final b.b wez;
    private int xlg;
    private int xlh;
    
    public e(b.b paramb)
    {
      AppMethodBeat.i(164883);
      this.wez = paramb;
      AppMethodBeat.o(164883);
    }
    
    private final Bitmap a(String paramString, Matrix paramMatrix, Rect paramRect1, Rect paramRect2)
    {
      AppMethodBeat.i(257773);
      Object localObject1 = new float[9];
      paramMatrix.getValues((float[])localObject1);
      label1207:
      for (;;)
      {
        try
        {
          Object localObject2 = s.k(paramString, false);
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
            this.xlg = ((Rect)localObject1).width();
            this.xlh = ((Rect)localObject1).height();
            localObject1 = k(localBitmapRegionDecoder.getWidth(), localBitmapRegionDecoder.getHeight(), (Rect)localObject1);
            localObject2 = new BitmapFactory.Options();
            i = (int)(f7 - f5);
            j = (int)(f4 - f6);
            int k = this.wez.maxWidth;
            int m = this.wez.maxHeight;
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
            f4 = this.wez.maxHeight / this.wez.maxWidth;
            if ((f3 >= f4) && (((Bitmap)localObject2).getHeight() > this.wez.maxHeight))
            {
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, kotlin.h.a.cR(this.wez.maxHeight / f3), this.wez.maxHeight, false);
              if (localObject1 == null) {
                continue;
              }
              localObject2 = localObject1;
              if (f1 - f2 != 0.0F) {
                localObject2 = BitmapUtil.rotate((Bitmap)localObject1, f1 - f2);
              }
              localBitmapRegionDecoder.recycle();
              AppMethodBeat.o(257773);
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
            if (((Bitmap)localObject2).getWidth() > this.wez.maxWidth)
            {
              f4 = this.wez.maxWidth;
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, this.wez.maxWidth, kotlin.h.a.cR(f3 * f4), false);
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
          p.g(paramMatrix, "Exif.fromFile(input)");
          f2 = paramMatrix.getOrientationInDegree();
          if (f2 % 180.0F != 0.0F)
          {
            i = localOptions.outHeight;
            localOptions.outHeight = localOptions.outWidth;
            localOptions.outWidth = i;
          }
          paramMatrix = b.xkW;
          i = this.wez.maxWidth;
          j = this.wez.maxHeight;
          p.h(paramString, "inputPath");
          paramString = s.openRead(paramString);
          p.g(paramString, "VFSFileOp.openRead(inputPath)");
          paramMatrix = b.a.a(paramString, i, j, false, true);
          Log.i("MediaTailor", "rawRotate=" + f2 + " cropRotation=" + f1 + " clipRect=" + paramRect1);
          paramString = paramMatrix;
          if (f2 - f1 != 0.0F)
          {
            paramString = BitmapUtil.rotate(paramMatrix, f2 - f1);
            p.g(paramString, "BitmapUtil.rotate(source…rawRotate - cropRotation)");
          }
          f3 = 1.0F * paramString.getHeight() / paramRect2.height();
          f4 = 1.0F * (paramRect1.left - paramRect2.left) / paramRect2.width();
          f5 = 1.0F * (paramRect1.top - paramRect2.top) / paramRect2.height();
          f4 *= 1.0F * paramString.getWidth();
          f5 *= 1.0F * paramString.getHeight();
          f6 = paramRect1.width();
          f7 = paramRect1.height();
          paramMatrix = k(paramString.getWidth(), paramString.getHeight(), new Rect(kotlin.h.a.cR(f4), kotlin.h.a.cR(f5), kotlin.h.a.cR(f6 * f3 + f4), kotlin.h.a.cR(f7 * f3 + f5)));
          Log.i("MediaTailor", "clipScale=" + f3 + " clipRect=[" + paramMatrix + " -> " + paramRect1 + "] raw=[" + localOptions.outWidth + ':' + localOptions.outHeight + "] source=[" + paramString.getWidth() + ':' + paramString.getHeight() + "] rotate=" + (f2 - f1));
          paramString = Bitmap.createBitmap(paramString, paramMatrix.left, paramMatrix.top, paramMatrix.width(), paramMatrix.height());
          AppMethodBeat.o(257773);
          return paramString;
        }
      }
    }
    
    private static Point a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
    {
      AppMethodBeat.i(257772);
      paramFloat1 -= paramInt1 / 2.0F;
      paramFloat2 -= paramInt2 / 2.0F;
      double d1 = Math.sin(paramFloat3 / 180.0F * 3.141592653589793D);
      double d2 = Math.cos(paramFloat3 / 180.0F * 3.141592653589793D);
      float f = (float)(paramFloat1 * d2 - paramFloat2 * d1);
      double d3 = paramFloat1;
      Object localObject = new o(Float.valueOf(f), Float.valueOf((float)(paramFloat2 * d2 + d1 * d3)));
      if (paramFloat3 % 180.0F != 0.0F)
      {
        localObject = new Point(kotlin.h.a.cR(((Number)((o)localObject).first).floatValue() + paramInt2 / 2.0F), kotlin.h.a.cR(((Number)((o)localObject).second).floatValue() + paramInt1 / 2.0F));
        AppMethodBeat.o(257772);
        return localObject;
      }
      localObject = new Point(kotlin.h.a.cR(((Number)((o)localObject).first).floatValue() + paramInt1 / 2.0F), kotlin.h.a.cR(((Number)((o)localObject).second).floatValue() + paramInt2 / 2.0F));
      AppMethodBeat.o(257772);
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
      AppMethodBeat.i(257770);
      p.h(paramString, "input");
      p.h(paramMatrix, "matrix");
      p.h(paramRect1, "clipRect");
      p.h(paramRect2, "contentRect");
      p.h(paramRect3, "viewRect");
      new com.tencent.mm.ac.c("MediaTailor");
      if ((paramRect2.width() == 0) || (paramRect2.height() == 0) || (paramRect1.width() == 0) || (paramRect1.height() == 0))
      {
        Log.e("MediaTailor", "Rect width or height contains zero. contentRect: " + paramRect2 + " clipRect: " + paramRect1);
        paramString = new b.f(-1);
        paramString.ayV("");
        AppMethodBeat.o(257770);
        return paramString;
      }
      paramRect3 = a(paramString, paramMatrix, paramRect1, paramRect2);
      String str = (String)j.ku(n.b((CharSequence)paramString, new String[] { "/" }));
      b.f localf = new b.f(0);
      if (paramRect3 != null) {
        if (this.wez.xla)
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
          if (((p.j(paramRect2, paramRect3) ^ true)) && (!paramRect3.isRecycled())) {
            paramRect3.recycle();
          }
          paramMatrix = this.wez.filePath;
          if (paramMatrix != null) {
            break label1066;
          }
          localObject = new StringBuilder().append(this.wez.xkX);
          if (this.wez.filename != null) {
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
        int j = this.wez.xkY;
        boolean bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
        int i = 0;
        for (;;)
        {
          if ((this.wez.xkZ > 0) && (s.boW(paramMatrix) > this.wez.xkZ) && (j > 0))
          {
            j -= 5;
            bool = BitmapUtil.saveBitmapToImage(paramRect2, j, Bitmap.CompressFormat.JPEG, paramMatrix, false);
            i += 1;
            continue;
            paramRect2 = paramRect3;
            break;
            label496:
            paramMatrix = this.wez.filename;
            break label393;
          }
        }
        Log.i("MediaTailor", "save bitmap ret=" + bool + " dest[" + paramRect2.getWidth() + ':' + paramRect2.getHeight() + "] maxFileLength=" + this.wez.xkZ + " tryCount=" + i + ' ' + "compressQuality=" + j + " isCircle=" + this.wez.xla + " size=" + Util.getSizeKB(s.boW(paramMatrix)));
        if ((this.xlg == 0) || (this.xlh == 0))
        {
          this.xlg = paramRect3.getWidth();
          this.xlh = paramRect3.getHeight();
        }
        label741:
        label748:
        label767:
        float f;
        if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.scM, 1) == 1)
        {
          i = AdaptiveAdjustBitrate.getOrignalImageQuality(this.xlg, this.xlh, paramRect2.getWidth(), paramRect2.getHeight(), j / 100.0F);
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
          paramMatrix = com.tencent.mm.plugin.recordvideo.d.c.BXI;
          com.tencent.mm.plugin.recordvideo.d.c.fl("KEY_IMAGE_QUALITY_INT_ARRAY", localf.quality);
          localf.ayV(paramRect2);
          if (localf.ret == 0)
          {
            paramMatrix = c.Uqd;
            c.lm(paramString, paramRect2);
            f = Math.max(1.0F * this.wez.iTf / paramRect1.height(), 1.0F * this.wez.iTf / paramRect1.width());
            paramMatrix = new StringBuilder().append(this.wez.xkX);
            if (this.wez.filename != null) {
              break label1039;
            }
          }
        }
        for (paramString = SystemClock.currentThreadTimeMillis() + "_thumb_" + str;; paramString = "thumb_" + this.wez.filename)
        {
          paramString = paramString;
          localf.HA(paramString);
          BitmapUtil.createThumbNail(paramRect2, kotlin.h.a.cR(paramRect1.height() * f), kotlin.h.a.cR(paramRect1.width() * f), Bitmap.CompressFormat.JPEG, this.wez.xkY, paramString);
          Log.i("MediaTailor", "createThumbNail: " + kotlin.h.a.cR(paramRect1.height() * f) + ", " + kotlin.h.a.cR(paramRect1.width() * f));
          AppMethodBeat.o(257770);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "command", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "threadPool", "Lcom/tencent/threadpool/ForkThreadPoolExecutor;", "rejectedExecution"})
  static final class g
    implements e
  {
    public static final g xlj;
    
    static
    {
      AppMethodBeat.i(164886);
      xlj = new g();
      AppMethodBeat.o(164886);
    }
    
    public final void a(Runnable paramRunnable, com.tencent.f.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.b.b
 * JD-Core Version:    0.7.0.1
 */