package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.e;

final class a$1
  implements Runnable
{
  a$1(a parama, e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(52773);
    if (this.leT == null)
    {
      AppMethodBeat.o(52773);
      return;
    }
    a.a(this.leU, this.leU.a(this.leT));
    this.leU.notifyDataSetChanged();
    AppMethodBeat.o(52773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */