package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFq = "updateTime".hashCode();
  private static final int fnB = "appid".hashCode();
  private static final int fnH = "wordingId".hashCode();
  private static final int fnI;
  private static final int fnJ;
  private static final int fnK;
  private static final int fnx = "language".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFn = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  private boolean fnD = true;
  private boolean fnE = true;
  private boolean fnF = true;
  private boolean fnG = true;
  private boolean fnu = true;
  private boolean fnz = true;
  
  static
  {
    fnI = "wording".hashCode();
    fnJ = "pinyin".hashCode();
    fnK = "quanpin".hashCode();
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
      if (fnB != k) {
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
      if (fnH == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (fnx == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fnI == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (fnJ == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (fnK == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnz) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.fnD) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.fnu) {
      localContentValues.put("language", this.field_language);
    }
    if (this.fnE) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.fnF) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.fnG) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.et
 * JD-Core Version:    0.7.0.1
 */