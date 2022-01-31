package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a.f;
import java.util.HashMap;
import java.util.LinkedList;

final class b$2
  extends e.c
{
  b$2(b paramb, i parami) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(87023);
    b localb = (b)b.Nt().remove(this.gWQ);
    if (localb != null) {
      localb.iAq.clear();
    }
    AppMethodBeat.o(87023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.2
 * JD-Core Version:    0.7.0.1
 */