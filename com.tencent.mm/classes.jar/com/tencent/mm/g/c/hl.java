package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hl
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttrVersionServerNotifyRecordAppVersionIndex ON WxaAttrVersionServerNotifyRecord(appVersion)" };
  private static final int eFG = "appVersion".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eGy = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFC = true;
  private boolean eFm = true;
  private boolean eGt = true;
  public int field_appVersion;
  public int field_reportId;
  public String field_username;
  
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFG == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (eGy == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eFC) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.eGt) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hl
 * JD-Core Version:    0.7.0.1
 */