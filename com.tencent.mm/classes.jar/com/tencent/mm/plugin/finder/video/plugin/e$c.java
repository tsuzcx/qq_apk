package com.tencent.mm.plugin.finder.video.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class e$c
  implements Runnable
{
  e$c(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(205566);
    o.deleteFile(this.tcc);
    AppMethodBeat.o(205566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e.c
 * JD-Core Version:    0.7.0.1
 */