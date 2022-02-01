package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ex
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eWZ = "decryptKey".hashCode();
  private static final int eWl = "pkgMd5".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int eoB = "appVersion".hashCode();
  private static final int epp = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eWY = true;
  private boolean eWc = true;
  private boolean enx = true;
  private boolean eox = true;
  private boolean epk = true;
  public String field_appId;
  public int field_appVersion;
  public String field_decryptKey;
  public String field_pkgMd5;
  public int field_reportId;
  
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
      if (enO != k) {
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
      if (eoB == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (eWZ == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (eWl == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (epp == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eox) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.eWY) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.eWc) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.epk) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ex
 * JD-Core Version:    0.7.0.1
 */