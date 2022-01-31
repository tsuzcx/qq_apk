package com.tencent.mm.ar;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.k;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  h fnw;
  
  public b(h paramh)
  {
    this.fnw = paramh;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(16468);
    parama.bsY = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.bsY & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.bsY & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.fCI));
    }
    if ((parama.bsY & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.bsY & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.fCJ));
    }
    if ((parama.bsY & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.fns));
    }
    if ((parama.bsY & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.fCK));
    }
    if ((parama.bsY & 0x40) != 0) {
      localContentValues.put("reserved3", parama.agY());
    }
    if ((parama.bsY & 0x80) != 0) {
      localContentValues.put("reserved4", parama.agZ());
    }
    if ((int)this.fnw.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(16468);
      return true;
    }
    AppMethodBeat.o(16468);
    return false;
  }
  
  public final boolean sT(String paramString)
  {
    AppMethodBeat.i(16469);
    if (this.fnw.delete("getcontactinfov2", "username= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      doNotify(paramString);
      AppMethodBeat.o(16469);
      return true;
    }
    AppMethodBeat.o(16469);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ar.b
 * JD-Core Version:    0.7.0.1
 */