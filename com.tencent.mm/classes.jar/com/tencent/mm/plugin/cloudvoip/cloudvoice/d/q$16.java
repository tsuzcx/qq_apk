package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class q$16
  implements Runnable
{
  q$16(q paramq, Map paramMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(203520);
    if (q.v(this.tSG) == null)
    {
      AppMethodBeat.o(203520);
      return;
    }
    q.v(this.tSG).a(0, 0, "", this.val$data);
    AppMethodBeat.o(203520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q.16
 * JD-Core Version:    0.7.0.1
 */