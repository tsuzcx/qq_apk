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

@d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"logIfVerbose", "", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "message", "", "processAndAbortIfNeeded", "", "processAssetManagerOrThrow", "processDprWidthHeightOrThrow", "processImageHandler", "lib-magicbrush-nano_release"})
public final class a
{
  private static void a(e parame, String paramString)
  {
    AppMethodBeat.i(140200);
    k.h(parame, "receiver$0");
    k.h(paramString, "message");
    if (parame.cmO) {
      c.c.i("MagicBrush", paramString, new Object[0]);
    }
    AppMethodBeat.o(140200);
  }
  
  private static void b(e parame)
  {
    AppMethodBeat.i(140201);
    k.h(parame, "receiver$0");
    if (!parame.cmA.cna)
    {
      if (parame.cmA.cne == null)
      {
        a(parame, "ImageHandler invalid, BindingImage can not use. BE CAUTIOUS!");
        parame = y.KTp;
      }
      AppMethodBeat.o(140201);
      return;
    }
    BaseImageDecodeService localBaseImageDecodeService = new BaseImageDecodeService();
    localBaseImageDecodeService.addImageStreamFetcher((com.github.henryye.nativeiv.b.b)new com.tencent.magicbrush.b.a(), false);
    Object localObject1 = parame.cmA.cnb;
    Iterator localIterator = ((Iterable)localObject1).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      if (i < 0) {
        j.fOc();
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
    if (parame.cmA.cnc != null) {
      localBaseImageDecodeService.setKvReportDelegate(parame.cmA.cnc);
    }
    if (parame.cmA.cnd != null)
    {
      localObject1 = parame.cmA.cnd;
      if (localObject1 == null) {
        k.fOy();
      }
      localBaseImageDecodeService.setBitmapDecodeSlave((IImageDecodeService.a)localObject1);
    }
    parame.cmA.cne = localBaseImageDecodeService;
    AppMethodBeat.o(140201);
  }
  
  public static final boolean c(e parame)
  {
    AppMethodBeat.i(140202);
    k.h(parame, "receiver$0");
    int i;
    for (;;)
    {
      try
      {
        double d = parame.FY();
        if ((d < 0.0D) || (d > 1.0D)) {
          break label99;
        }
        i = 1;
        if (i != 0) {
          break;
        }
        Throwable localThrowable = (Throwable)new IllegalStateException(("GcFactor must in [0, 1], but " + parame.FY()).toString());
        AppMethodBeat.o(140202);
        throw localThrowable;
      }
      catch (Exception localException)
      {
        if (!parame.cmN) {
          break label673;
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
    if (parame.cmt == null)
    {
      localObject1 = (Throwable)new IllegalStateException("JsThreadHandler invalid.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    if (parame.cmu == null)
    {
      localObject1 = (Throwable)new IllegalStateException("v8RawPointer invalid. Please define which JsEngine magicbrush should use.".toString());
      AppMethodBeat.o(140202);
      throw ((Throwable)localObject1);
    }
    k.h(parame, "receiver$0");
    if (parame.FW() == null)
    {
      localObject1 = parame.context;
      if (localObject1 == null) {
        break label680;
      }
    }
    label673:
    label680:
    for (Object localObject1 = ((Context)localObject1).getAssets();; localObject1 = null)
    {
      parame.cmz.a(f.$$delegatedProperties[4], localObject1);
      if (parame.FW() == null)
      {
        localObject1 = (Throwable)new IllegalStateException("AssetManager invalid. Either assetManager or context should be provided.".toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      k.h(parame, "receiver$0");
      if ((parame.getDevicePixelRatio() <= 0.0F) && (parame.context != null))
      {
        localObject1 = parame.context;
        if (localObject1 == null) {
          k.fOy();
        }
        parame.ab(com.tencent.magicbrush.utils.b.getDensity((Context)localObject1));
      }
      localObject1 = (d.g.a.a)new a(parame);
      if (!((Boolean)((d.g.a.a)localObject1).invoke()).booleanValue())
      {
        if (parame.context == null)
        {
          localObject1 = (Throwable)new IllegalStateException(("w/h invalid. context invalid. " + parame.FU() + '/' + parame.FV()).toString());
          AppMethodBeat.o(140202);
          throw ((Throwable)localObject1);
        }
        if (parame.context != null)
        {
          Object localObject2 = parame.context;
          if (localObject2 == null) {
            k.fOy();
          }
          localObject2 = com.tencent.magicbrush.utils.b.aL((Context)localObject2);
          k.g(localObject2, "DisplayUtil.getDisplayLogicSize(context!!)");
          i = ((Point)localObject2).x;
          parame.cmw.a(f.$$delegatedProperties[1], Integer.valueOf(i));
          i = ((Point)localObject2).y;
          parame.cmx.a(f.$$delegatedProperties[2], Integer.valueOf(i));
          a(parame, "w/h invalid, use context automatically. " + parame.FU() + '/' + parame.FV());
        }
      }
      if (!((Boolean)((d.g.a.a)localObject1).invoke()).booleanValue())
      {
        localObject1 = (Throwable)new IllegalStateException(("dpr/w/h invalid. " + parame.getDevicePixelRatio() + '/' + parame.FU() + '/' + parame.FV()).toString());
        AppMethodBeat.o(140202);
        throw ((Throwable)localObject1);
      }
      if ((IMBFileSystem)parame.cmy.a(f.$$delegatedProperties[3]) == null)
      {
        a(parame, "FileSystem invalid, BindingFileSystem can not use. BE CAUTIOUS!");
        localObject1 = y.KTp;
      }
      b(parame);
      if (parame.cmB == null) {
        parame.cmB = ((IMBFontHandler)new h());
      }
      AppMethodBeat.o(140202);
      return true;
      AppMethodBeat.o(140202);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 13}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.internal.a
 * JD-Core Version:    0.7.0.1
 */