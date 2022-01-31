package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.Queue;

final class b$5
  implements Runnable
{
  b$5(b paramb, int paramInt, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(78036);
    if (this.fyS != -1) {
      this.fyR.fyN.put(this.fyT.field_mediaId, Integer.valueOf(this.fyS));
    }
    ab.i("MicroMsg.CdnTransportService", "CdnTransportService replacePizzaWorkerExecute run %s", new Object[] { this.fyT.field_mediaId });
    this.fyR.fyK.add(this.fyT.field_mediaId);
    this.fyR.fyL.put(this.fyT.field_mediaId, this.fyT);
    this.fyR.cV(false);
    AppMethodBeat.o(78036);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78037);
    String str = super.toString() + "|addRecvTask";
    AppMethodBeat.o(78037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.al.b.5
 * JD-Core Version:    0.7.0.1
 */