package com.tencent.magicbrush.internal;

import android.content.Context;
import android.graphics.Point;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.api.IImageDecodeService.a;
import com.tencent.magicbrush.a.c.c;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.f.b;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.handler.glfont.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"})
public final class a
{
  private static void a(e parame, String paramString)
  {
    AppMethodBeat.i(140200);
    k.h(parame, "$this$logIfVerbose");
    k.h(paramString, "message");
    if (parame.cpJ) {
      c.c.i("MagicBrush", paramString, new Object[0]);
    }
    AppMethodBeat.o(140200);
  }
  
  private static void b(e parame)
  {
    AppMethodBeat.i(140201);
    k.h(parame, "$this$processImageHandler");
    if (!parame.cpv.cpT)
    {
      if (parame.cpv.cpX == null)
      {
        a(parame, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
        parame = y.JfV;
      }
      AppMethodBeat.o(140201);
      return;
    }
    BaseImageDecodeService localBaseImageDecodeService = new BaseImageDecodeService();
    localBaseImageDecodeService.addImageStreamFetcher((com.github.henryye.nativeiv.b.b)new com.tencent.magicbrush.b.a(), false);
    Object localObject1 = parame.cpv.cpU;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        j.fvx();
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
    if (parame.cpv.cpV != null) {
      localBaseImageDecodeService.setKvReportDelegate(parame.cpv.cpV);
    }
    if (parame.cpv.cpW != null)
    {
      localObject1 = parame.cpv.cpW;
      if (localObject1 == null) {
        k.fvU();
      }
      localBaseImageDecodeService.setBitmapDecodeSlave((IImageDecodeService.a)localObject1);
    }
    parame.cpv.cpX = localBaseImageDecodeService;
    AppMethodBeat.o(140201);
  }
  
  public static final boolean c(e parame)
  {
    AppMethodBeat.i(140202);
    k.h(parame, "$this$processAndAbortIfNeeded");
    int i;
    for (;;)
    {
      try
      {
        double d = parame.Gm();
        if ((d < 0.0D) || (d > 1.0D)) {
          break label99;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        Throwable localThrowable = (Throwable)new IllegalStateException(("GcFactor must in [0, 1], but " + parame.Gm()).toString());
        AppMethodBeat.o(140202);
        throw localThrowable;
      }
      catch (Exception localException)
      {
        if (!parame.cpI) {
          break label674;
        }
      }
      parame = (Throwable)localException;
      AppMethodBeat.o(140202);
      throw parame;
      label99:
      i = 0;
    }
    if (parame.context == null)
    {
      localObject1 = (Throwable)new IllegalStateException("AndroidContext invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (parame.cpo == null)
    {
      localObject1 = (Throwable)new IllegalStateException("JsThreadHandler invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (parame.cpp == null)
    {
      localObject1 = (Throwable)new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    k.h(parame, "$this$processAssetManagerOrThrow");
    if (parame.Gk() == null)
    {
      localObject1 = parame.context;
      if (localObject1 == null) {
        break label681;
      }
    }
    label674:
    label681:
    for (Object localObject1 = ((Context)localObject1).getAssets();; localObject1 = null)
    {
      parame.cpu.a(f.$$delegatedProperties[4], localObject1);
      if (parame.Gk() == null)
      {
        localObject1 = (Throwable)new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      k.h(parame, "$this$processDprWidthHeightOrThrow");
      if ((parame.getDevicePixelRatio() <= 0.0F) && (parame.context != null))
      {
        localObject1 = parame.context;
        if (localObject1 == null) {
          k.fvU();
        }
        parame.X(com.tencent.magicbrush.utils.b.getDensity((Context)localObject1));
      }
      localObject1 = (d.g.a.a)new a(parame);
      if (!((Boolean)((d.g.a.a)localObject1).invoke()).booleanValue())
      {
        if (parame.context == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("w/h invalid. context invalid. " + parame.Gi() + '/' + parame.Gj()).toString());
          AppMethodBeat.o(140202);
          throw ((Throwable)localObject1);
        }
        if (parame.context != null)
        {
          Object localObject2 = parame.context;
          if (localObject2 == null) {
            k.fvU();
          }
          localObject2 = com.tencent.magicbrush.utils.b.aK((Context)localObject2);
          k.g(localObject2, "DisplayUtil.getDisplayLogicSize(context!!)");
          i = ((Point)localObject2).x;
          parame.cpr.a(f.$$delegatedProperties[1], Integer.valueOf(i));
          i = ((Point)localObject2).y;
          parame.cps.a(f.$$delegatedProperties[2], Integer.valueOf(i));
          a(parame, "w/h invalid, use context automatically. " + parame.Gi() + '/' + parame.Gj());
        }
      }
      if (!((Boolean)((d.g.a.a)localObject1).invoke()).booleanValue())
      {
        localObject1 = (Throwable)new IllegalStateException(("dpr/w/h invalid. " + parame.getDevicePixelRatio() + '/' + parame.Gi() + '/' + parame.Gj()).toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      if ((IMBFileSystem)parame.cpt.a(f.$$delegatedProperties[3]) == null)
      {
        a(parame, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
        localObject1 = y.JfV;
      }
      b(parame);
      if (parame.cpw == null) {
        parame.cpw = ((IMBFontHandler)new h());
      }
      AppMethodBeat.o(140202);
      return true;
      AppMethodBeat.o(140202);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<Boolean>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.internal.a
 * JD-Core Version:    0.7.0.1
 */