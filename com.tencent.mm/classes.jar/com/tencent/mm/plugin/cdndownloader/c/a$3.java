package com.tencent.mm.plugin.cdndownloader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(878);
    g localg = (g)a.d(this.kDz).get(this.Cq);
    if (localg == null)
    {
      ab.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", new Object[] { this.Cq });
      AppMethodBeat.o(878);
      return;
    }
    if (localg.edF != null) {
      localg.edF.a(this.Cq, this.fyV);
    }
    AppMethodBeat.o(878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.c.a.3
 * JD-Core Version:    0.7.0.1
 */