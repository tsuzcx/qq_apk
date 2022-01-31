package com.tencent.mm.ak;

import com.tencent.mm.j.d;
import com.tencent.mm.j.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class e$4
  implements Runnable
{
  e$4(e parame, String paramString, Object[] paramArrayOfObject) {}
  
  public final void run()
  {
    g localg = (g)this.ejo.eiI.remove(this.BF);
    d locald;
    int i;
    if (localg != null)
    {
      locald = new d();
      f.Ne();
      i = a.b(localg.field_mediaId, locald);
      if (i == 0) {
        e.a(this.ejq, locald, localg, false);
      }
    }
    for (;;)
    {
      this.ejo.eiH.remove(this.BF);
      return;
      y.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", new Object[] { Integer.valueOf(i), localg.field_mediaId });
      continue;
      localg = (g)this.ejo.ejm.remove(this.BF);
      locald = (d)this.ejo.ejn.remove(this.BF);
      if ((localg != null) && (locald != null)) {
        e.a(this.ejq, locald, localg, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.e.4
 * JD-Core Version:    0.7.0.1
 */