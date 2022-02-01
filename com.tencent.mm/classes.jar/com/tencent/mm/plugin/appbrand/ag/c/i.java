package com.tencent.mm.plugin.appbrand.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/thumb/ThumbContainerFormatInferer;", "Lcom/tencent/mm/plugin/appbrand/video/thumb/IThumbContainerFormatInferer;", "()V", "isHls", "", "srcHolder", "Lcom/tencent/mm/plugin/appbrand/video/thumb/SrcHolder;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i utX;
  
  static
  {
    AppMethodBeat.i(317896);
    utX = new i();
    AppMethodBeat.o(317896);
  }
  
  public static boolean a(e parame)
  {
    AppMethodBeat.i(317890);
    s.u(parame, "srcHolder");
    if (f.cwx())
    {
      localObject = c.utq;
      bool = c.a(parame);
      AppMethodBeat.o(317890);
      return bool;
    }
    Object localObject = d.utr;
    boolean bool = d.a(parame);
    AppMethodBeat.o(317890);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.c.i
 * JD-Core Version:    0.7.0.1
 */