package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b.a;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.k.g;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/handler/imagefetcher/AppBrandNativeBufferImageStreamFetcher;", "Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa;", "Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa$INativeBufferFetcherConfig;", "bufferConfig", "(Lcom/tencent/luggage/game/handler/imagefetcher/BaseImageStreamFetcherWxa$INativeBufferFetcherConfig;)V", "accept", "", "path", "", "fetch", "Lcom/github/henryye/nativeiv/stream/IImageStreamFetcher$StreamFetchResult;", "config", "Lcom/github/henryye/nativeiv/ImageDecodeConfig;", "getSourceTypeName", "", "Companion", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d<d.d>
{
  public static final c.a ekQ;
  private final d.d ekR;
  
  static
  {
    AppMethodBeat.i(220125);
    ekQ = new c.a((byte)0);
    AppMethodBeat.o(220125);
  }
  
  public c(d.d paramd)
  {
    super((d.a)paramd);
    AppMethodBeat.i(220122);
    this.ekR = paramd;
    AppMethodBeat.o(220122);
  }
  
  public final String Qj()
  {
    return "NativeBuffer";
  }
  
  public final b.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    AppMethodBeat.i(220131);
    paramImageDecodeConfig = new b.a();
    if (paramObject == null)
    {
      paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(220131);
      throw paramObject;
    }
    paramObject = n.bJF(n.a((String)paramObject, new g(15, ((String)paramObject).length() - 1)));
    if (paramObject != null)
    {
      paramObject = this.ekR.aoU().ae(paramObject.intValue(), false);
      if (paramObject == null)
      {
        c.c.w("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: can not found buffer in buffer addon", new Object[0]);
        paramImageDecodeConfig.errorMsg = "Not found native buffer in buffer addon!";
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220131);
      return paramImageDecodeConfig;
      paramObject.position(0);
      byte[] arrayOfByte = new byte[paramObject.remaining()];
      paramObject.get(arrayOfByte);
      paramImageDecodeConfig.inputStream = ((InputStream)new ByteArrayInputStream(arrayOfByte));
      continue;
      c.c.w("MicroMsg.AppBrandNativeBufferImageStreamFetcher", "hy: not providing int as native buffer key!", new Object[0]);
      paramImageDecodeConfig.errorMsg = "Not invalid native buffer key!";
    }
  }
  
  public final boolean be(Object paramObject)
  {
    AppMethodBeat.i(220128);
    if ((paramObject instanceof String))
    {
      boolean bool = n.U((String)paramObject, "nativebuffer://", false);
      AppMethodBeat.o(220128);
      return bool;
    }
    AppMethodBeat.o(220128);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */