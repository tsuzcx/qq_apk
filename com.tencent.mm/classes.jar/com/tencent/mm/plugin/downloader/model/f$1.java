package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.plugin.downloader.g.a;

final class f$1
  implements Runnable
{
  f$1(f paramf, a parama, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(2407);
    if ((g.RK().eHt == null) || (g.RK().eHt.ftA == null))
    {
      AppMethodBeat.o(2407);
      return;
    }
    new ae(this.kYh.field_packageName, this.kYz).doScene(g.RK().eHt.ftA, new f.1.1(this));
    AppMethodBeat.o(2407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f.1
 * JD-Core Version:    0.7.0.1
 */