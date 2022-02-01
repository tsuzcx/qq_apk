package com.tencent.magicbrush.internal;

import android.content.Context;
import android.graphics.Point;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.g.a;
import com.tencent.magicbrush.g.b;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"})
public final class a
{
  private static void a(f paramf, String paramString)
  {
    AppMethodBeat.i(140200);
    p.k(paramf, "$this$logIfVerbose");
    p.k(paramString, "message");
    if (paramf.cMP) {
      c.c.i("MagicBrush", paramString, new Object[0]);
    }
    AppMethodBeat.o(140200);
  }
  
  private static void c(f paramf)
  {
    AppMethodBeat.i(140201);
    p.k(paramf, "$this$processImageHandler");
    if (!paramf.cMB.cNg)
    {
      if (paramf.cMB.cNk == null)
      {
        a(paramf, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
        paramf = x.aazN;
      }
      AppMethodBeat.o(140201);
      return;
    }
    BaseImageDecodeService localBaseImageDecodeService = new BaseImageDecodeService();
    localBaseImageDecodeService.addImageStreamFetcher((com.github.henryye.nativeiv.b.b)new com.tencent.magicbrush.b.b(), false);
    Object localObject1 = paramf.cMB.cNh;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (com.github.henryye.nativeiv.b.b)localObject2;
      if (i == ((List)localObject1).size() - 1) {}
      for (boolean bool = true;; bool = false)
      {
        localBaseImageDecodeService.addImageStreamFetcher((com.github.henryye.nativeiv.b.b)localObject2, bool);
        i += 1;
        break;
      }
    }
    if (paramf.cMB.cNi != null) {
      localBaseImageDecodeService.setKvReportDelegate(paramf.cMB.cNi);
    }
    if (paramf.cMB.cNj != null)
    {
      localObject1 = paramf.cMB.cNj;
      if (localObject1 == null) {
        p.iCn();
      }
      localBaseImageDecodeService.setBitmapDecodeSlave((IImageDecodeService.a)localObject1);
    }
    paramf.cMB.cNk = localBaseImageDecodeService;
    AppMethodBeat.o(140201);
  }
  
  public static final boolean d(f paramf)
  {
    AppMethodBeat.i(140202);
    p.k(paramf, "$this$processAndAbortIfNeeded");
    int i;
    for (;;)
    {
      try
      {
        double d = paramf.Vb();
        if ((d < 0.0D) || (d > 1.0D)) {
          break label99;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        Throwable localThrowable = (Throwable)new IllegalStateException(("GcFactor must in [0, 1], but " + paramf.Vb()).toString());
        AppMethodBeat.o(140202);
        throw localThrowable;
      }
      catch (Exception localException)
      {
        if (!paramf.cMO) {
          break label674;
        }
      }
      paramf = (Throwable)localException;
      AppMethodBeat.o(140202);
      throw paramf;
      label99:
      i = 0;
    }
    if (paramf.context == null)
    {
      localObject1 = (Throwable)new IllegalStateException("AndroidContext invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (paramf.cMu == null)
    {
      localObject1 = (Throwable)new IllegalStateException("JsThreadHandler invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (paramf.cMv == null)
    {
      localObject1 = (Throwable)new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    p.k(paramf, "$this$processAssetManagerOrThrow");
    if (paramf.UZ() == null)
    {
      localObject1 = paramf.context;
      if (localObject1 == null) {
        break label681;
      }
    }
    label674:
    label681:
    for (Object localObject1 = ((Context)localObject1).getAssets();; localObject1 = null)
    {
      paramf.cMA.a(g.cMt[4], localObject1);
      if (paramf.UZ() == null)
      {
        localObject1 = (Throwable)new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      p.k(paramf, "$this$processDprWidthHeightOrThrow");
      if ((paramf.getDevicePixelRatio() <= 0.0F) && (paramf.context != null))
      {
        localObject1 = paramf.context;
        if (localObject1 == null) {
          p.iCn();
        }
        paramf.ad(com.tencent.magicbrush.utils.b.getDensity((Context)localObject1));
      }
      localObject1 = (kotlin.g.a.a)new a(paramf);
      if (!((Boolean)((kotlin.g.a.a)localObject1).invoke()).booleanValue())
      {
        if (paramf.context == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("w/h invalid. context invalid. " + paramf.UX() + '/' + paramf.UY()).toString());
          AppMethodBeat.o(140202);
          throw ((Throwable)localObject1);
        }
        if (paramf.context != null)
        {
          Object localObject2 = paramf.context;
          if (localObject2 == null) {
            p.iCn();
          }
          localObject2 = com.tencent.magicbrush.utils.b.aS((Context)localObject2);
          p.j(localObject2, "DisplayUtil.getDisplayLogicSize(context!!)");
          i = ((Point)localObject2).x;
          paramf.cMx.a(g.cMt[1], Integer.valueOf(i));
          i = ((Point)localObject2).y;
          paramf.cMy.a(g.cMt[2], Integer.valueOf(i));
          a(paramf, "w/h invalid, use context automatically. " + paramf.UX() + '/' + paramf.UY());
        }
      }
      if (!((Boolean)((kotlin.g.a.a)localObject1).invoke()).booleanValue())
      {
        localObject1 = (Throwable)new IllegalStateException(("dpr/w/h invalid. " + paramf.getDevicePixelRatio() + '/' + paramf.UX() + '/' + paramf.UY()).toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      if ((IMBFileSystem)paramf.cMz.a(g.cMt[3]) == null)
      {
        a(paramf, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
        localObject1 = x.aazN;
      }
      c(paramf);
      if (paramf.cMC == null) {
        paramf.cMC = ((IMBFontHandler)new i());
      }
      AppMethodBeat.o(140202);
      return true;
      AppMethodBeat.o(140202);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.magicbrush.internal.a
 * JD-Core Version:    0.7.0.1
 */