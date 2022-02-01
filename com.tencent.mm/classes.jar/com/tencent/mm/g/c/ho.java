package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ho
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int fEm = "permissionDemo".hashCode();
  private static final int fEn = "versiontime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  private boolean fEk = true;
  private boolean fEl = true;
  public String field_appId;
  public boolean field_permissionDemo;
  public long field_versiontime;
  
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
      if (eGD != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eGm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fEm == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_permissionDemo = bool;
          break;
        }
      }
      if (fEn == k) {
        this.field_versiontime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fEk) {
      localContentValues.put("permissionDemo", Boolean.valueOf(this.field_permissionDemo));
    }
    if (this.fEl) {
      localContentValues.put("versiontime", Long.valueOf(this.field_versiontime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ho
 * JD-Core Version:    0.7.0.1
 */