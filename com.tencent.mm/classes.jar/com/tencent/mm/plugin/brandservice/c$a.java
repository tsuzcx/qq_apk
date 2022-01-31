package com.tencent.mm.plugin.brandservice;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$a
  implements Runnable
{
  c$a(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(14762);
    String str = this.jSw;
    int i = this.jSx;
    int j = this.jSy;
    Object[] arrayOfObject = this.jSz;
    PreloadLogic.a(str, i, j, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    AppMethodBeat.o(14762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c.a
 * JD-Core Version:    0.7.0.1
 */