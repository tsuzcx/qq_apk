package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class k$b
  implements Runnable
{
  k$b(int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(211366);
    cln localcln = (cln)((g)h.ag(g.class)).getOnlyMemory(10, "id_context");
    if (localcln != null)
    {
      localcln.Tte.addLast(Integer.valueOf(this.DDd));
      Log.d("WxIme.ImeReporter", "addInputToScreenOperation " + this.DDd);
      AppMethodBeat.o(211366);
      return;
    }
    Log.e("WxIme.ImeReporter", "getOnlyMemory(addInputToScreenOperation) 10 id_context is null");
    AppMethodBeat.o(211366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.k.b
 * JD-Core Version:    0.7.0.1
 */