package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ag.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/DefaultThumbContainerFormatInferer;", "Lcom/tencent/mm/plugin/appbrand/video/thumb/IThumbContainerFormatInferer;", "()V", "isHls", "", "srcHolder", "Lcom/tencent/mm/plugin/appbrand/video/thumb/SrcHolder;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c
{
  public static final c utq;
  
  static
  {
    AppMethodBeat.i(317891);
    utq = new c();
    AppMethodBeat.o(317891);
  }
  
  public static boolean a(e parame)
  {
    AppMethodBeat.i(317886);
    s.u(parame, "srcHolder");
    String str = parame.hqM;
    Object localObject1 = com.tencent.mm.plugin.appbrand.ag.a.c.usq;
    Object localObject3 = (com.tencent.mm.plugin.appbrand.ag.a.c)com.tencent.mm.plugin.appbrand.ag.a.c.cNM().invoke(str);
    localObject1 = (Closeable)localObject3;
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.b localb = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.sEI;
      bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.R((InputStream)localObject3);
      localObject3 = ((com.tencent.mm.plugin.appbrand.ag.a.c)localObject3).usr.usn.cNK();
      Log.i("MicroMsg.AppBrand.ThumbContainerFormatInferer", "isHls, src: " + str + ", finalUrl: " + (String)localObject3);
      s.u(localObject3, "<set-?>");
      parame.hqM = ((String)localObject3);
      kotlin.f.b.a((Closeable)localObject1, null);
      AppMethodBeat.o(317886);
      return bool;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.ThumbContainerFormatInferer", (Throwable)parame, "judge isHls fail", new Object[0]);
        parame = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.sEI;
        boolean bool = com.tencent.mm.plugin.appbrand.jsapi.video.e.b.aco(str);
      }
    }
    finally
    {
      try
      {
        AppMethodBeat.o(317886);
        throw parame;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, parame);
        AppMethodBeat.o(317886);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.c
 * JD-Core Version:    0.7.0.1
 */