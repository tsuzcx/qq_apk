package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ae
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjf = "msgId".hashCode();
  private static final int fnu = "aId".hashCode();
  private static final int fnv = "exposeTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_aId;
  public long field_exposeTime;
  public long field_msgId;
  private boolean fjb = true;
  private boolean fns = true;
  private boolean fnt = true;
  
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
      if (fnu != k) {
        break label65;
      }
      this.field_aId = paramCursor.getString(i);
      this.fns = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjf == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (fnv == k) {
        this.field_exposeTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fns) {
      localContentValues.put("aId", this.field_aId);
    }
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fnt) {
      localContentValues.put("exposeTime", Long.valueOf(this.field_exposeTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ae
 * JD-Core Version:    0.7.0.1
 */