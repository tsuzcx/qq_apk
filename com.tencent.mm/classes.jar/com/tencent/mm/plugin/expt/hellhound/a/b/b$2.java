package com.tencent.mm.plugin.expt.hellhound.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.e.c;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class b$2
  implements Runnable
{
  b$2(ava paramava, aux paramaux) {}
  
  public final void run()
  {
    AppMethodBeat.i(152319);
    b.a(this.maN);
    ava localava = this.maN;
    aux localaux = this.maQ;
    if ((localava == null) || (localaux == null))
    {
      AppMethodBeat.o(152319);
      return;
    }
    if (((!localava.xkm.isEmpty()) || (!localava.xkk.isEmpty())) && (!localaux.fjy.isEmpty()))
    {
      ab.i("HellSessionReport", "HABBYGE-MALI, reportWhenEvent8");
      c.a(localaux, localava, false);
      c.a(localava, (auy)localaux.fjy.getFirst());
      c.e(localava, localaux);
    }
    AppMethodBeat.o(152319);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.2
 * JD-Core Version:    0.7.0.1
 */