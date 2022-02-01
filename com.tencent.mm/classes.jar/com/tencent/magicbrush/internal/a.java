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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"}, k=2, mv={1, 1, 16})
public final class a
{
  private static void a(f paramf, String paramString)
  {
    AppMethodBeat.i(140200);
    s.t(paramf, "$this$logIfVerbose");
    s.t(paramString, "message");
    if (paramf.eIi) {
      c.c.i("MagicBrush", paramString, new Object[0]);
    }
    AppMethodBeat.o(140200);
  }
  
  private static void c(f paramf)
  {
    AppMethodBeat.i(140201);
    s.t(paramf, "$this$processImageHandler");
    if (!paramf.eHU.eIB)
    {
      if (paramf.eHU.eIF == null)
      {
        a(paramf, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
        paramf = ah.aiuX;
      }
      AppMethodBeat.o(140201);
      return;
    }
    BaseImageDecodeService localBaseImageDecodeService = new BaseImageDecodeService();
    localBaseImageDecodeService.addImageStreamFetcher((com.github.henryye.nativeiv.b.b)new com.tencent.magicbrush.b.b(), false);
    Object localObject1 = paramf.eHU.eIC;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        p.kkW();
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
    if (paramf.eHU.eID != null) {
      localBaseImageDecodeService.setKvReportDelegate(paramf.eHU.eID);
    }
    if (paramf.eHU.eIE != null)
    {
      localObject1 = paramf.eHU.eIE;
      if (localObject1 == null) {
        s.klw();
      }
      localBaseImageDecodeService.setBitmapDecodeSlave((IImageDecodeService.a)localObject1);
    }
    paramf.eHU.eIF = localBaseImageDecodeService;
    AppMethodBeat.o(140201);
  }
  
  public static final boolean d(f paramf)
  {
    AppMethodBeat.i(140202);
    s.t(paramf, "$this$processAndAbortIfNeeded");
    int i;
    for (;;)
    {
      try
      {
        double d = paramf.avE();
        if ((d < 0.0D) || (d > 1.0D)) {
          break label99;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        Throwable localThrowable = (Throwable)new IllegalStateException(("GcFactor must in [0, 1], but " + paramf.avE()).toString());
        AppMethodBeat.o(140202);
        throw localThrowable;
      }
      catch (Exception localException)
      {
        if (!paramf.eIh) {
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
    if (paramf.eHN == null)
    {
      localObject1 = (Throwable)new IllegalStateException("JsThreadHandler invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (paramf.eHO == null)
    {
      localObject1 = (Throwable)new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    s.t(paramf, "$this$processAssetManagerOrThrow");
    if (paramf.avC() == null)
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
      paramf.eHT.a(g.aYe[4], localObject1);
      if (paramf.avC() == null)
      {
        localObject1 = (Throwable)new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      s.t(paramf, "$this$processDprWidthHeightOrThrow");
      if ((paramf.getDevicePixelRatio() <= 0.0F) && (paramf.context != null))
      {
        localObject1 = paramf.context;
        if (localObject1 == null) {
          s.klw();
        }
        paramf.bf(com.tencent.magicbrush.utils.b.getDensity((Context)localObject1));
      }
      localObject1 = (kotlin.g.a.a)new a(paramf);
      if (!((Boolean)((kotlin.g.a.a)localObject1).invoke()).booleanValue())
      {
        if (paramf.context == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("w/h invalid. context invalid. " + paramf.avA() + '/' + paramf.avB()).toString());
          AppMethodBeat.o(140202);
          throw ((Throwable)localObject1);
        }
        if (paramf.context != null)
        {
          Object localObject2 = paramf.context;
          if (localObject2 == null) {
            s.klw();
          }
          localObject2 = com.tencent.magicbrush.utils.b.bC((Context)localObject2);
          s.r(localObject2, "DisplayUtil.getDisplayLogicSize(context!!)");
          i = ((Point)localObject2).x;
          paramf.eHQ.a(g.aYe[1], Integer.valueOf(i));
          i = ((Point)localObject2).y;
          paramf.eHR.a(g.aYe[2], Integer.valueOf(i));
          a(paramf, "w/h invalid, use context automatically. " + paramf.avA() + '/' + paramf.avB());
        }
      }
      if (!((Boolean)((kotlin.g.a.a)localObject1).invoke()).booleanValue())
      {
        localObject1 = (Throwable)new IllegalStateException(("dpr/w/h invalid. " + paramf.getDevicePixelRatio() + '/' + paramf.avA() + '/' + paramf.avB()).toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      if ((IMBFileSystem)paramf.eHS.a(g.aYe[3]) == null)
      {
        a(paramf, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
        localObject1 = ah.aiuX;
      }
      c(paramf);
      if (paramf.eHV == null) {
        paramf.eHV = ((IMBFontHandler)new i());
      }
      AppMethodBeat.o(140202);
      return true;
      AppMethodBeat.o(140202);
      return false;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.internal.a
 * JD-Core Version:    0.7.0.1
 */