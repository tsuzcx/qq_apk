package com.tencent.mm.plugin.finder.video.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class f$c
  implements Runnable
{
  f$c(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(254485);
    s.deleteFile(this.mtb);
    AppMethodBeat.o(254485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.f.c
 * JD-Core Version:    0.7.0.1
 */