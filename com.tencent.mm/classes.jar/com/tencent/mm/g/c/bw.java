package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgM = "createTime".hashCode();
  private static final int dsg = "id".hashCode();
  private static final int dzl = "protocolNumber".hashCode();
  private static final int dzm = "logContent".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgp = true;
  private boolean dsd = true;
  private boolean dzj = true;
  private boolean dzk = true;
  public long field_createTime;
  public String field_id;
  public String field_logContent;
  public int field_protocolNumber;
  
  public void convertFrom(Cursor paramCursor)
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
      if (dsg != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.dsd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dzl == k) {
        this.field_protocolNumber = paramCursor.getInt(i);
      } else if (dzm == k) {
        this.field_logContent = paramCursor.getString(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dsd) {
      localContentValues.put("id", this.field_id);
    }
    if (this.dzj) {
      localContentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
    }
    if (this.dzk) {
      localContentValues.put("logContent", this.field_logContent);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.bw
 * JD-Core Version:    0.7.0.1
 */