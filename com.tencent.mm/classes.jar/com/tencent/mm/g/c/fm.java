package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fm
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fVg = "pkgMd5".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int flv = "version".hashCode();
  private static final int flx = "pkgPath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean fUX = true;
  public String field_appId;
  public String field_pkgMd5;
  public String field_pkgPath;
  public int field_type;
  public int field_version;
  private boolean fjS = true;
  private boolean flq = true;
  private boolean fls = true;
  
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
      if (flv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fVg == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (flx == k) {
        this.field_pkgPath = paramCursor.getString(i);
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
    if (this.flq) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fUX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.fls) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fm
 * JD-Core Version:    0.7.0.1
 */