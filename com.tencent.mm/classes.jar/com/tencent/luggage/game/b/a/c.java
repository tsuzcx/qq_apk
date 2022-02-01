package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.k.e;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/handler/imagefetcher/AppBrandNativeBufferImageStreamFetcher;", "Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa;", "Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa$INativeBufferFetcherConfig;", "bufferConfig", "(Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa$INativeBufferFetcherConfig;)V", "accept", "", "path", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "Companion", "luggage-wxa-game-ext_release"})
public final class c
  extends d<d.d>
{
  public static final a csW;
  private final d.d csV;
  
  static
  {
    AppMethodBeat.i(246996);
    csW = new a((byte)0);
    AppMethodBeat.o(246996);
  }
  
  public c(d.d paramd)
  {
    super((d.a)paramd);
    AppMethodBeat.i(246993);
    this.csV = paramd;
    AppMethodBeat.o(246993);
  }
  
  public final boolean V(Object paramObject)
  {
    AppMethodBeat.i(246990);
    if ((paramObject instanceof String))
    {
      boolean bool = n.M((String)paramObject, "nativebuffer://", false);
      AppMethodBeat.o(246990);
      return bool;
    }
    AppMethodBeat.o(246990);
    return false;
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(246991);
    paramImageDecodeConfig = new b.a();
    if (paramObject == null)
    {
      paramObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(246991);
      throw paramObject;
    }
    paramObject = n.bHC(n.a((String)paramObject, new e(15, ((String)paramObject).length() - 1)));
    if (paramObject != null)
    {
      paramObject = this.csV.OM().P(paramObject.intValue(), false);
      if (paramObject == null)
      {
        c.c.w("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: can not found buffer in buffer addon", new Object[0]);
        paramImageDecodeConfig.errorMsg = "Not found native buffer in buffer addon!";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246991);
      return paramImageDecodeConfig;
      paramObject.position(0);
      byte[] arrayOfByte = new byte[paramObject.remaining()];
      paramObject.get(arrayOfByte);
      paramImageDecodeConfig.aFw = ((InputStream)new ByteArrayInputStream(arrayOfByte));
      continue;
      c.c.w("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: not providing int as native buffer key!", new Object[0]);
      paramImageDecodeConfig.errorMsg = "Not invalid native buffer key!";
    }
  }
  
  public final String qG()
  {
    return "NativeBuffer";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/handler/imagefetcher/AppBrandNativeBufferImageStreamFetcher$Companion;", "", "()V", "DATA_HEADER", "", "TAG", "luggage-wxa-game-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */