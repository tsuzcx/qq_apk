package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.Queue;

final class b$8
  implements Runnable
{
  b$8(b paramb, int paramInt, g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(150400);
    if (this.iRM != -1) {
      b.e(this.iRJ).put(this.iRN.field_mediaId, Integer.valueOf(this.iRM));
    }
    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { this.iRN.field_mediaId });
    b.f(this.iRJ).add(this.iRN.field_mediaId);
    b.g(this.iRJ).put(this.iRN.field_mediaId, this.iRN);
    this.iRJ.fD(false);
    AppMethodBeat.o(150400);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(150401);
    String str = super.toString() + "|addRecvTask";
    AppMethodBeat.o(150401);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.an.b.8
 * JD-Core Version:    0.7.0.1
 */