package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enO = "appId".hashCode();
  private static final int epb = "version".hashCode();
  private static final int epl = "packageType".hashCode();
  private static final int epm = "packageKey".hashCode();
  private static final int epn = "source".hashCode();
  private static final int epo = "hitCount".hashCode();
  private static final int epp = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enx = true;
  private boolean eoW = true;
  private boolean epg = true;
  private boolean eph = true;
  private boolean epi = true;
  private boolean epj = true;
  private boolean epk = true;
  public String field_appId;
  public int field_hitCount;
  public String field_packageKey;
  public int field_packageType;
  public int field_reportId;
  public int field_source;
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
      if (epb == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (epl == k) {
        this.field_packageType = paramCursor.getInt(i);
      } else if (epm == k) {
        this.field_packageKey = paramCursor.getString(i);
      } else if (epn == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (epo == k) {
        this.field_hitCount = paramCursor.getInt(i);
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
    if (this.eoW) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.epg) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.eph) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.epi) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.epj) {
      localContentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
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
 * Qualified Name:     com.tencent.mm.g.c.x
 * JD-Core Version:    0.7.0.1
 */