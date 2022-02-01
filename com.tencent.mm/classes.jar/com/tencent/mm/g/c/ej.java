package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVi = "language".hashCode();
  private static final int eVm = "appid".hashCode();
  private static final int eVs = "wordingId".hashCode();
  private static final int eVt = "wording".hashCode();
  private static final int eVu = "pinyin".hashCode();
  private static final int eVv = "quanpin".hashCode();
  private static final int eol = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVf = true;
  private boolean eVk = true;
  private boolean eVo = true;
  private boolean eVp = true;
  private boolean eVq = true;
  private boolean eVr = true;
  private boolean eoi = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  
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
      if (eVm != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eVs == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (eVi == k) {
        this.field_language = paramCursor.getString(i);
      } else if (eVt == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (eVu == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (eVv == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVk) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.eVo) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.eVf) {
      localContentValues.put("language", this.field_language);
    }
    if (this.eVp) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.eVq) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.eVr) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */