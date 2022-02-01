package com.tencent.mm.plugin.appbrand.jsapi.video.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"NULL_SRC_STREAM_PROVIDER", "Lkotlin/Function1;", "", "Ljava/io/InputStream;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/SrcStreamProvider;", "TAG", "value", "", "useContentInferer", "getUseContentInferer", "()Z", "setUseContentInferer", "(Z)V", "useNewInputStream", "getUseNewInputStream", "setUseNewInputStream", "SrcStreamProvider", "luggage-commons-jsapi-video-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static boolean sEV = true;
  private static boolean sEW;
  private static final b<String, InputStream> sEX = (b)f.a.sEY;
  
  public static final boolean cwx()
  {
    return sEV;
  }
  
  public static final boolean cwy()
  {
    return sEW;
  }
  
  public static final void jL(boolean paramBoolean)
  {
    AppMethodBeat.i(328657);
    Log.i("MicroMsg.AppBrand.ContainerFormatInferer", s.X("useContentInferer#set, value: ", Boolean.valueOf(paramBoolean)));
    sEV = paramBoolean;
    AppMethodBeat.o(328657);
  }
  
  public static final void jM(boolean paramBoolean)
  {
    AppMethodBeat.i(328672);
    Log.i("MicroMsg.AppBrand.ContainerFormatInferer", s.X("useNewInputStream#set, value: ", Boolean.valueOf(paramBoolean)));
    sEW = paramBoolean;
    AppMethodBeat.o(328672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.e.f
 * JD-Core Version:    0.7.0.1
 */