package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class go
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fyq = "groupId".hashCode();
  private static final int gaE = "groupTime".hashCode();
  private static final int gaF = "groupStrcut".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_groupId;
  public byte[] field_groupStrcut;
  public int field_groupTime;
  private boolean fxE = true;
  private boolean gaC = true;
  private boolean gaD = true;
  
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
      if (fyq != k) {
        break label65;
      }
      this.field_groupId = paramCursor.getLong(i);
      this.fxE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gaE == k) {
        this.field_groupTime = paramCursor.getInt(i);
      } else if (gaF == k) {
        this.field_groupStrcut = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fxE) {
      localContentValues.put("groupId", Long.valueOf(this.field_groupId));
    }
    if (this.gaC) {
      localContentValues.put("groupTime", Integer.valueOf(this.field_groupTime));
    }
    if (this.gaD) {
      localContentValues.put("groupStrcut", this.field_groupStrcut);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.go
 * JD-Core Version:    0.7.0.1
 */