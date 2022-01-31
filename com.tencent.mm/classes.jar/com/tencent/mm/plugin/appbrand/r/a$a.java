package com.tencent.mm.plugin.appbrand.r;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;

final class a$a
  extends c
{
  static final c.a gUb;
  @i(duo="$$invalid", dup=1)
  public String field_key;
  public byte[] field_value;
  
  static
  {
    AppMethodBeat.i(132771);
    gUb = initAutoDBInfo(a.class);
    AppMethodBeat.o(132771);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(132769);
    this.field_key = paramCursor.getString(0);
    this.field_value = paramCursor.getBlob(1);
    AppMethodBeat.o(132769);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(132770);
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("key", this.field_key);
    localContentValues.put("value", this.field_value);
    AppMethodBeat.o(132770);
    return localContentValues;
  }
  
  public final c.a getDBInfo()
  {
    return gUb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a
 * JD-Core Version:    0.7.0.1
 */