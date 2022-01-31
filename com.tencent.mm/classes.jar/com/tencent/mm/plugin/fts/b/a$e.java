package com.tencent.mm.plugin.fts.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.HashSet;

final class a$e
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private String eaX;
  private boolean ezx = false;
  
  public a$e(a parama, String paramString)
  {
    this.eaX = paramString;
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136673);
    String str = String.format("{username: %s isSkipped: %b}", new Object[] { this.eaX, Boolean.valueOf(this.ezx) });
    AppMethodBeat.o(136673);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136672);
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[] { this.eaX });
    ad localad = a.d(this.mUg).OT(this.eaX);
    if ((localad != null) && (localad.field_username.length() > 0) && (this.mUg.H(localad))) {
      this.mUg.I(localad);
    }
    for (;;)
    {
      a.b(this.mUg).remove(this.eaX);
      a.c(this.mUg).remove(this.eaX);
      AppMethodBeat.o(136672);
      return true;
      this.ezx = true;
    }
  }
  
  public final String getName()
  {
    return "InsertContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.e
 * JD-Core Version:    0.7.0.1
 */