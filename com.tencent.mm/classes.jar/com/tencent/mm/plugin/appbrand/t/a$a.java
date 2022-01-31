package com.tencent.mm.plugin.appbrand.t;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.h;

final class a$a
  extends c
{
  static final c.a fCU = V(a.class);
  @h(csq="$$invalid", csr=1)
  public String field_key;
  public byte[] field_value;
  
  public final void d(Cursor paramCursor)
  {
    this.field_key = paramCursor.getString(0);
    this.field_value = paramCursor.getBlob(1);
  }
  
  protected final c.a rM()
  {
    return fCU;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("key", this.field_key);
    localContentValues.put("value", this.field_value);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a.a
 * JD-Core Version:    0.7.0.1
 */