package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crQ;
  private static final int crh = "rowid".hashCode();
  private static final int crx;
  private static final int ctW = "recordId".hashCode();
  private static final int ctl = "appId".hashCode();
  private static final int der = "domin".hashCode();
  private boolean crM = true;
  private boolean crp = true;
  private boolean csU = true;
  private boolean ctT = true;
  private boolean deq = true;
  public String field_appId;
  public String field_domin;
  public String field_key;
  public int field_recordId;
  public String field_value;
  
  static
  {
    crQ = "key".hashCode();
    crx = "value".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ctW != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.ctT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (der == k) {
        this.field_domin = paramCursor.getString(i);
      } else if (crQ == k) {
        this.field_key = paramCursor.getString(i);
      } else if (crx == k) {
        this.field_value = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctT) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.deq) {
      localContentValues.put("domin", this.field_domin);
    }
    if (this.crM) {
      localContentValues.put("key", this.field_key);
    }
    if (this.crp) {
      localContentValues.put("value", this.field_value);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.fe
 * JD-Core Version:    0.7.0.1
 */