package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhB = "appId".hashCode();
  private static final int dpP = "hit".hashCode();
  private static final int dpQ = "hitTimeMS".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dhk = true;
  private boolean dpN = true;
  private boolean dpO = true;
  public String field_appId;
  public int field_hit;
  public long field_hitTimeMS;
  public int field_type;
  
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
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dpP == k) {
        this.field_hit = paramCursor.getInt(i);
      } else if (dpQ == k) {
        this.field_hitTimeMS = paramCursor.getLong(i);
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
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dpN) {
      localContentValues.put("hit", Integer.valueOf(this.field_hit));
    }
    if (this.dpO) {
      localContentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ds
 * JD-Core Version:    0.7.0.1
 */