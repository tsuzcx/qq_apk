package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import java.util.Arrays;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class c$b
  implements Runnable
{
  c$b(String paramString, int paramInt1, int paramInt2, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(6448);
    String str = this.mkH;
    int i = this.pmn;
    int j = this.pmo;
    Object[] arrayOfObject = this.pmp;
    m.a(str, i, j, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    AppMethodBeat.o(6448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c.b
 * JD-Core Version:    0.7.0.1
 */