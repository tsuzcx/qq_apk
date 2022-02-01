package com.tencent.mm.plugin.finder.video.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class e$c
  implements Runnable
{
  e$c(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(203981);
    i.deleteFile(this.rUg);
    AppMethodBeat.o(203981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.e.c
 * JD-Core Version:    0.7.0.1
 */