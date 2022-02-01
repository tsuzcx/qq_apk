package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRY = "language".hashCode();
  private static final int eSc = "appid".hashCode();
  private static final int eSi = "wordingId".hashCode();
  private static final int eSj = "wording".hashCode();
  private static final int eSk = "pinyin".hashCode();
  private static final int eSl = "quanpin".hashCode();
  private static final int emf = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRV = true;
  private boolean eSa = true;
  private boolean eSe = true;
  private boolean eSf = true;
  private boolean eSg = true;
  private boolean eSh = true;
  private boolean emc = true;
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
      if (eSc != k) {
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
      if (eSi == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (eRY == k) {
        this.field_language = paramCursor.getString(i);
      } else if (eSj == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (eSk == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (eSl == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSa) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.eSe) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.eRV) {
      localContentValues.put("language", this.field_language);
    }
    if (this.eSf) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.eSg) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.eSh) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ef
 * JD-Core Version:    0.7.0.1
 */