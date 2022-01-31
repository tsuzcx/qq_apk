package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class b$c$1
  implements Runnable
{
  b$c$1(b.c paramc, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(152799);
    b.a locala = this.kfH.kfC.hnw;
    if (locala != null)
    {
      locala.a(this.kfE, this.kfF, this.hxS, this.kfG);
      AppMethodBeat.o(152799);
      return;
    }
    AppMethodBeat.o(152799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.c.1
 * JD-Core Version:    0.7.0.1
 */