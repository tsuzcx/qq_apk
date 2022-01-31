package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class b$a$1
  implements Runnable
{
  b$a$1(b.a parama, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(152796);
    com.tencent.mm.ipcinvoker.wx_extension.b.a locala = this.kfD.kfC.hnw;
    if (locala != null)
    {
      locala.a(this.kfE, this.kfF, this.hxS, this.kfG);
      AppMethodBeat.o(152796);
      return;
    }
    AppMethodBeat.o(152796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.a.1
 * JD-Core Version:    0.7.0.1
 */