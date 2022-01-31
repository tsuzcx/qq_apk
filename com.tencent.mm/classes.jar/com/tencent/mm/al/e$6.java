package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class e$6
  implements Runnable
{
  e$6(e parame, String paramString, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(50563);
    h localh = (h)this.fzs.fyM.remove(this.Cq);
    d locald;
    int i;
    if (localh != null)
    {
      locald = new d();
      f.afP();
      i = a.b(localh.field_mediaId, locald);
      if (i == 0) {
        e.a(this.fzu, locald, localh, false);
      }
    }
    for (;;)
    {
      this.fzs.fyL.remove(this.Cq);
      AppMethodBeat.o(50563);
      return;
      ab.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localh.field_mediaId });
      continue;
      localh = (h)this.fzs.fzq.remove(this.Cq);
      locald = (d)this.fzs.fzr.remove(this.Cq);
      if ((localh != null) && (locald != null)) {
        e.a(this.fzu, locald, localh, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.al.e.6
 * JD-Core Version:    0.7.0.1
 */