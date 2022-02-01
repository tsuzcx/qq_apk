package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class en
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSI = "hit".hashCode();
  private static final int eSJ = "hitTimeMS".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int emV = "version".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSG = true;
  private boolean eSH = true;
  private boolean els = true;
  private boolean emQ = true;
  public String field_appId;
  public int field_hit;
  public long field_hitTimeMS;
  public int field_version;
  
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
      if (elJ != k) {
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
      if (emV == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (eSI == k) {
        this.field_hit = paramCursor.getInt(i);
      } else if (eSJ == k) {
        this.field_hitTimeMS = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emQ) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.eSG) {
      localContentValues.put("hit", Integer.valueOf(this.field_hit));
    }
    if (this.eSH) {
      localContentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.en
 * JD-Core Version:    0.7.0.1
 */