package com.tencent.mm.plugin.appbrand.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class b$a
  extends a
{
  private String id;
  
  public b$a(b paramb, String paramString)
  {
    this.id = paramString;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(129958);
    String str = String.format("{id: %s}", new Object[] { this.id });
    AppMethodBeat.o(129958);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(129957);
    ab.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[] { this.id });
    this.hrJ.hrH.b(com.tencent.mm.plugin.fts.a.c.mQE, this.id);
    AppMethodBeat.o(129957);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteWeAppTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.a
 * JD-Core Version:    0.7.0.1
 */