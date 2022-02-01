package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.secdata.g;
import com.tencent.mm.protocal.protobuf.cln;
import com.tencent.mm.protocal.protobuf.clp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class k$c
  implements Runnable
{
  k$c(int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(216784);
    cln localcln = (cln)((g)h.ag(g.class)).getOnlyMemory(10, "id_context");
    if (localcln != null)
    {
      clp localclp = new clp();
      localclp.Ttf = this.DDe;
      localclp.Ttg = this.DDf;
      localclp.Tth = this.DDg;
      localcln.Ttd.addLast(localclp);
      Log.d("WxIme.ImeReporter", "addOperation " + localclp.Ttf + ' ' + localclp.Ttg + ' ' + localclp.Tth);
      AppMethodBeat.o(216784);
      return;
    }
    Log.e("WxIme.ImeReporter", "getOnlyMemory(addOperation) 10 id_context is null");
    AppMethodBeat.o(216784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.k.c
 * JD-Core Version:    0.7.0.1
 */