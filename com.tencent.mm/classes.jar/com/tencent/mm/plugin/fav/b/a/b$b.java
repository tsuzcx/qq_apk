package com.tencent.mm.plugin.fav.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.ab;

final class b$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private long muQ;
  
  public b$b(b paramb, long paramLong)
  {
    this.muQ = paramLong;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(5305);
    String str = String.format("{favItemId: %d}", new Object[] { Long.valueOf(this.muQ) });
    AppMethodBeat.o(5305);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(5304);
    ab.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
    long l = this.muQ;
    this.muL.muI.c(c.mQB, l);
    AppMethodBeat.o(5304);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteFavItemTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.a.b.b
 * JD-Core Version:    0.7.0.1
 */