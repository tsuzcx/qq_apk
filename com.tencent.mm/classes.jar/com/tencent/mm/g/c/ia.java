package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ia
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkj = "appId".hashCode();
  private static final int gjw = "permissionDemo".hashCode();
  private static final int gjx = "versiontime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public boolean field_permissionDemo;
  public long field_versiontime;
  private boolean fjS = true;
  private boolean gju = true;
  private boolean gjv = true;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
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
      if (gjw == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_permissionDemo = bool;
          break;
        }
      }
      if (gjx == k) {
        this.field_versiontime = paramCursor.getLong(i);
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
    if (this.gju) {
      localContentValues.put("permissionDemo", Boolean.valueOf(this.field_permissionDemo));
    }
    if (this.gjv) {
      localContentValues.put("versiontime", Long.valueOf(this.field_versiontime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ia
 * JD-Core Version:    0.7.0.1
 */