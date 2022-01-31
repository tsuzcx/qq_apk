package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dKW = "decryptKey".hashCode();
  private static final int dKk = "pkgMd5".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int diM = "reportId".hashCode();
  private static final int djo = "appVersion".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dKV = true;
  private boolean dKd = true;
  private boolean dhk = true;
  private boolean diJ = true;
  private boolean diR = true;
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
      if (djo == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (dKW == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (dKk == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (diM == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.diR) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.dKV) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.dKd) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.diJ) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dy
 * JD-Core Version:    0.7.0.1
 */