package com.tencent.mm.as;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storagebase.h;

public final class b
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS getcontactinfov2 ( username text  PRIMARY KEY , inserttime long  , type int  , lastgettime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
  h omV;
  
  public b(h paramh)
  {
    this.omV = paramh;
  }
  
  public final boolean NK(String paramString)
  {
    AppMethodBeat.i(20515);
    if (this.omV.delete("getcontactinfov2", "username= ?", new String[] { String.valueOf(paramString) }) > 0)
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
    parama.eQp = -1;
    ContentValues localContentValues = new ContentValues();
    if ((parama.eQp & 0x1) != 0) {
      localContentValues.put("username", parama.getUsername());
    }
    if ((parama.eQp & 0x2) != 0) {
      localContentValues.put("inserttime", Long.valueOf(parama.oFj));
    }
    if ((parama.eQp & 0x4) != 0) {
      localContentValues.put("type", Integer.valueOf(parama.type));
    }
    if ((parama.eQp & 0x8) != 0) {
      localContentValues.put("lastgettime", Integer.valueOf(parama.oFk));
    }
    if ((parama.eQp & 0x10) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(parama.omO));
    }
    if ((parama.eQp & 0x20) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(parama.oFl));
    }
    if ((parama.eQp & 0x40) != 0) {
      localContentValues.put("reserved3", parama.bJs());
    }
    if ((parama.eQp & 0x80) != 0) {
      localContentValues.put("reserved4", parama.bCY());
    }
    if ((int)this.omV.replace("getcontactinfov2", "username", localContentValues) != -1)
    {
      doNotify(parama.getUsername());
      AppMethodBeat.o(20514);
      return true;
    }
    AppMethodBeat.o(20514);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.b
 * JD-Core Version:    0.7.0.1
 */