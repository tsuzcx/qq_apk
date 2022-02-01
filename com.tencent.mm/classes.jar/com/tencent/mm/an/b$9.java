package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import java.util.Map;
import java.util.Queue;

final class b$9
  implements Runnable
{
  b$9(b paramb, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(150402);
    b.f(this.iRJ).add(this.iRN.field_mediaId);
    b.g(this.iRJ).put(this.iRN.field_mediaId, this.iRN);
    this.iRJ.fD(false);
    AppMethodBeat.o(150402);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(223551);
    String str = super.toString() + "|addSendTask";
    AppMethodBeat.o(223551);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.b.9
 * JD-Core Version:    0.7.0.1
 */