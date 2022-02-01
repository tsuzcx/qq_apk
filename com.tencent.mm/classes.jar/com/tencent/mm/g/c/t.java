package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class t
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFG = "appVersion".hashCode();
  private static final int eGa = "isSeparatedPluginsUsed".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFC = true;
  private boolean eFZ = true;
  public String field_appId;
  public int field_appVersion;
  public int field_isSeparatedPluginsUsed;
  
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
      if (eEU != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eFG == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (eGa == k) {
        this.field_isSeparatedPluginsUsed = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eFC) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.eFZ) {
      localContentValues.put("isSeparatedPluginsUsed", Integer.valueOf(this.field_isSeparatedPluginsUsed));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.t
 * JD-Core Version:    0.7.0.1
 */