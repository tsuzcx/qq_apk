package com.tencent.mm.plugin.brandservice;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/brandservice/BrandServiceImpl$preloadByInfoIdAndBuffer$2$2"})
final class c$c
  implements Runnable
{
  c$c(List paramList, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(152669);
    PreloadLogic.j(this.iRB, this.jSB);
    AppMethodBeat.o(152669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c.c
 * JD-Core Version:    0.7.0.1
 */