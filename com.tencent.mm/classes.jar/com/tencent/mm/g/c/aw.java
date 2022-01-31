package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhB = "appId".hashCode();
  private static final int dip = "versionType".hashCode();
  private static final int drY = "extJson".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhk = true;
  private boolean dim = true;
  private boolean drX = true;
  public String field_appId;
  public String field_extJson;
  public int field_versionType;
  
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
      if (dhB != k) {
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
      if (dip == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (drY == k) {
        this.field_extJson = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dim) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.drX) {
      localContentValues.put("extJson", this.field_extJson);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.aw
 * JD-Core Version:    0.7.0.1
 */