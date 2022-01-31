package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.HashSet;

final class a$e
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private boolean dCg = false;
  private String djD;
  
  public a$e(a parama, String paramString)
  {
    this.djD = paramString;
  }
  
  public final String afJ()
  {
    return String.format("{username: %s isSkipped: %b}", new Object[] { this.djD, Boolean.valueOf(this.dCg) });
  }
  
  public final boolean execute()
  {
    y.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.djD });
    ad localad = a.d(this.kyt).DK(this.djD);
    if ((localad != null) && (localad.field_username.length() > 0) && (this.kyt.G(localad))) {
      this.kyt.H(localad);
    }
    for (;;)
    {
      a.b(this.kyt).remove(this.djD);
      a.c(this.kyt).remove(this.djD);
      return true;
      this.dCg = true;
    }
  }
  
  public final String getName()
  {
    return "InsertContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.e
 * JD-Core Version:    0.7.0.1
 */