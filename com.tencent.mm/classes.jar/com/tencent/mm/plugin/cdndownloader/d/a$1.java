package com.tencent.mm.plugin.cdndownloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.cdndownloader.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Set;

final class a$1
  implements b
{
  a$1(a parama) {}
  
  public final void bfV()
  {
    AppMethodBeat.i(889);
    ab.i("MicroMsg.CDNDownloadClient", "notify add");
    a.a(this.kDM);
    a.b(this.kDM);
    AppMethodBeat.o(889);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(891);
    ab.i("MicroMsg.CDNDownloadClient", "notify clear");
    a.d(this.kDM);
    a.e(this.kDM);
    AppMethodBeat.o(891);
  }
  
  public final void remove()
  {
    AppMethodBeat.i(890);
    ab.i("MicroMsg.CDNDownloadClient", "notify remove");
    if (a.c(this.kDM).size() == 0)
    {
      a.d(this.kDM);
      a.e(this.kDM);
    }
    AppMethodBeat.o(890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.d.a.1
 * JD-Core Version:    0.7.0.1
 */