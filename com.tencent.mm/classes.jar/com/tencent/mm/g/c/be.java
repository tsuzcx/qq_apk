package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class be
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjl = "status".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int fmm = "modifyTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public long field_modifyTime;
  public int field_status;
  private boolean fjS = true;
  private boolean fji = true;
  private boolean flQ = true;
  
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
      if (fkj != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.fjS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fmm == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.flQ) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.be
 * JD-Core Version:    0.7.0.1
 */