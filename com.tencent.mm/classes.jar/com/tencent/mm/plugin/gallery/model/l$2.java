package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class l$2
  implements Runnable
{
  l$2(l paraml, String paramString, int paramInt, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(21321);
    try
    {
      ab.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum Begin...");
      this.ndA.ndy.a(this.ndB, this.bHS, new l.2.1(this), this.hbh);
      AppMethodBeat.o(21321);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      ab.printErrStackTrace("MicroMsg.MediaQueryService", localSecurityException, "", new Object[0]);
      l.a(this.ndA, new LinkedList(), this.hbh);
      AppMethodBeat.o(21321);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21322);
    String str = super.toString() + "|queryMediaInAlbums";
    AppMethodBeat.o(21322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l.2
 * JD-Core Version:    0.7.0.1
 */