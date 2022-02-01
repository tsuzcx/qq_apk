package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eGk = "version".hashCode();
  private static final int eGm = "pkgPath".hashCode();
  private static final int foA;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eED = true;
  private boolean eGf = true;
  private boolean eGh = true;
  public String field_appId;
  public String field_pkgMd5;
  public String field_pkgPath;
  public int field_type;
  public int field_version;
  private boolean jdField_for = true;
  
  static
  {
    foA = "pkgMd5".hashCode();
  }
  
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
      if (eGk == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (foA == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (eGm == k) {
        this.field_pkgPath = paramCursor.getString(i);
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
    if (this.eGf) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jdField_for) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.eGh) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fe
 * JD-Core Version:    0.7.0.1
 */