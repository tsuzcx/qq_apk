package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt
  extends c
{
  private static final int cDW;
  private static final int cKb;
  private static final int cKc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private boolean cDT = true;
  private boolean cJZ = true;
  private boolean cKa = true;
  private boolean crX = true;
  public long field_createTime;
  public String field_id;
  public String field_logContent;
  public int field_protocolNumber;
  
  static
  {
    cDW = "id".hashCode();
    cKb = "protocolNumber".hashCode();
    cKc = "logContent".hashCode();
    csv = "createTime".hashCode();
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
      if (cDW != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.cDT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cKb == k) {
        this.field_protocolNumber = paramCursor.getInt(i);
      } else if (cKc == k) {
        this.field_logContent = paramCursor.getString(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDT) {
      localContentValues.put("id", this.field_id);
    }
    if (this.cJZ) {
      localContentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
    }
    if (this.cKa) {
      localContentValues.put("logContent", this.field_logContent);
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.bt
 * JD-Core Version:    0.7.0.1
 */