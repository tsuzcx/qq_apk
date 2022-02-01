package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGZ = "updateTime".hashCode();
  private static final int fpC = "appid".hashCode();
  private static final int fpI = "wordingId".hashCode();
  private static final int fpJ;
  private static final int fpK;
  private static final int fpL;
  private static final int fpy = "language".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  private boolean fpA = true;
  private boolean fpE = true;
  private boolean fpF = true;
  private boolean fpG = true;
  private boolean fpH = true;
  private boolean fpv = true;
  
  static
  {
    fpJ = "wording".hashCode();
    fpK = "pinyin".hashCode();
    fpL = "quanpin".hashCode();
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
      if (fpC != k) {
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
      if (fpI == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (fpy == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fpJ == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (fpK == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (fpL == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fpA) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.fpE) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.fpv) {
      localContentValues.put("language", this.field_language);
    }
    if (this.fpF) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.fpG) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.fpH) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.et
 * JD-Core Version:    0.7.0.1
 */