package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import java.util.Map;
import java.util.Queue;

final class b$6
  implements Runnable
{
  b$6(b paramb, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(78038);
    this.fyR.fyK.add(this.fyT.field_mediaId);
    this.fyR.fyL.put(this.fyT.field_mediaId, this.fyT);
    this.fyR.cV(false);
    AppMethodBeat.o(78038);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78039);
    String str = super.toString() + "|addSendTask";
    AppMethodBeat.o(78039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.b.6
 * JD-Core Version:    0.7.0.1
 */