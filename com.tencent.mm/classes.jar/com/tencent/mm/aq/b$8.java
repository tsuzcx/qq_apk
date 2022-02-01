package com.tencent.mm.aq;

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
    if (this.lIe != -1) {
      b.e(this.lIb).put(this.lIf.field_mediaId, Integer.valueOf(this.lIe));
    }
    Log.i("MicroMsg.CdnTransportService", "CdnTransportService cdn thread run %s", new Object[] { this.lIf.field_mediaId });
    b.f(this.lIb).add(this.lIf.field_mediaId);
    b.g(this.lIb).put(this.lIf.field_mediaId, this.lIf);
    this.lIb.go(false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aq.b.8
 * JD-Core Version:    0.7.0.1
 */