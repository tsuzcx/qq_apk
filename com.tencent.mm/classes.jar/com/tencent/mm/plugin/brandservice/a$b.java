package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class a$b
  implements Runnable
{
  a$b(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(6443);
    if (com.tencent.mm.pluginsdk.model.app.h.cy(this.nVy, true) != null) {
      aq.f((Runnable)1.nVz);
    }
    AppMethodBeat.o(6443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.b
 * JD-Core Version:    0.7.0.1
 */