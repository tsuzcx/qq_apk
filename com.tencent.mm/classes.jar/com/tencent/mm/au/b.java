package com.tencent.mm.au;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storagebase.h;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  h gPa;
  
  public b(h paramh)
  {
    this.gPa = paramh;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(20514);
    parama.dtM = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.dtM & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.dtM & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.hfj));
    }
    if ((parama.dtM & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.dtM & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.hfk));
    }
    if ((parama.dtM & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.gOT));
    }
    if ((parama.dtM & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.hfl));
    }
    if ((parama.dtM & 0x40) != 0) {
      localContentValues.put("reserved3", parama.aya());
    }
    if ((parama.dtM & 0x80) != 0) {
      localContentValues.put("reserved4", parama.asv());
    }
    if ((int)this.gPa.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(20514);
      return true;
    }
    AppMethodBeat.o(20514);
    return false;
  }
  
  public final boolean xW(String paramString)
  {
    AppMethodBeat.i(20515);
    if (this.gPa.delete("getcontactinfov2", "username= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      doNotify(paramString);
      AppMethodBeat.o(20515);
      return true;
    }
    AppMethodBeat.o(20515);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.au.b
 * JD-Core Version:    0.7.0.1
 */