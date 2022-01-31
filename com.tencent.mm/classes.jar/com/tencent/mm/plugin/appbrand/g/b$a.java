package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$a
  extends a
{
  private String id;
  
  public b$a(b paramb, String paramString)
  {
    this.id = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{id: %s}", new Object[] { this.id });
  }
  
  public final boolean execute()
  {
    y.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[] { this.id });
    this.fYv.fYt.b(com.tencent.mm.plugin.fts.a.c.kuR, this.id);
    return true;
  }
  
  public final String getName()
  {
    return "DeleteWeAppTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.a
 * JD-Core Version:    0.7.0.1
 */