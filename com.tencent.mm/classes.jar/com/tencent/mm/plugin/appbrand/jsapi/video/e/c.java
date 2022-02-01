package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/DefaultContainerFormatInferer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IContainerFormatInferer;", "srcStreamProvider", "Lkotlin/Function1;", "", "Ljava/io/InputStream;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/SrcStreamProvider;", "(Lkotlin/jvm/functions/Function1;)V", "isHls", "", "src", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final kotlin.g.a.b<String, InputStream> sEJ;
  
  public c(kotlin.g.a.b<? super String, ? extends InputStream> paramb)
  {
    AppMethodBeat.i(328651);
    this.sEJ = paramb;
    AppMethodBeat.o(328651);
  }
  
  public final boolean acp(String paramString)
  {
    AppMethodBeat.i(328667);
    s.u(paramString, "src");
    Object localObject1 = (InputStream)this.sEJ.invoke(paramString);
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      localObject1 = b.sEI;
      bool = b.aco(paramString);
      AppMethodBeat.o(328667);
      return bool;
      Closeable localCloseable = (Closeable)localObject1;
      try
      {
        b localb2 = b.sEI;
        bool = b.R((InputStream)localObject1);
        localObject1 = Boolean.valueOf(bool);
        kotlin.f.b.a(localCloseable, null);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.ContainerFormatInferer", (Throwable)localException, "judge isHls fail", new Object[0]);
          b localb1 = b.sEI;
          bool = b.aco(paramString);
        }
      }
      finally
      {
        try
        {
          AppMethodBeat.o(328667);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, paramString);
          AppMethodBeat.o(328667);
        }
      }
    }
    boolean bool = localObject2.booleanValue();
    AppMethodBeat.o(328667);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.c
 * JD-Core Version:    0.7.0.1
 */