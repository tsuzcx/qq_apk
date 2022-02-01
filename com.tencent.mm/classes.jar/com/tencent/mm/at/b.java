package com.tencent.mm.at;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storagebase.h;

public final class b
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  h hpA;
  
  public b(h paramh)
  {
    this.hpA = paramh;
  }
  
  public final boolean Cb(String paramString)
  {
    AppMethodBeat.i(20515);
    if (this.hpA.delete("getcontactinfov2", "username= ?", new String[] { String.valueOf(paramString) }) > 0)
    {
      doNotify(paramString);
      AppMethodBeat.o(20515);
      return true;
    }
    AppMethodBeat.o(20515);
    return false;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(20514);
    parama.drx = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.drx & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.drx & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.hFM));
    }
    if ((parama.drx & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.drx & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.hFN));
    }
    if ((parama.drx & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.hpt));
    }
    if ((parama.drx & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.hFO));
    }
    if ((parama.drx & 0x40) != 0) {
      localContentValues.put("reserved3", parama.aES());
    }
    if ((parama.drx & 0x80) != 0) {
      localContentValues.put("reserved4", parama.azm());
    }
    if ((int)this.hpA.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(20514);
      return true;
    }
    AppMethodBeat.o(20514);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.b
 * JD-Core Version:    0.7.0.1
 */