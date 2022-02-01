package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elJ = "appId".hashCode();
  private static final int emV = "version".hashCode();
  private static final int eng = "packageType".hashCode();
  private static final int enh = "packageKey".hashCode();
  private static final int eni = "source".hashCode();
  private static final int enj = "hitCount".hashCode();
  private static final int enk = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean els = true;
  private boolean emQ = true;
  private boolean ena = true;
  private boolean enb = true;
  private boolean enc = true;
  private boolean ene = true;
  private boolean enf = true;
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
      } else if (eng == k) {
        this.field_packageType = paramCursor.getInt(i);
      } else if (enh == k) {
        this.field_packageKey = paramCursor.getString(i);
      } else if (eni == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (enj == k) {
        this.field_hitCount = paramCursor.getInt(i);
      } else if (enk == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.ena) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.enb) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.enc) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.ene) {
      localContentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
    }
    if (this.enf) {
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