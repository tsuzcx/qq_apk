package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da
  extends c
{
  private static final int cTd;
  private static final int cTh;
  private static final int cTn;
  private static final int cTo;
  private static final int cTp;
  private static final int cTq;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private boolean cTa = true;
  private boolean cTf = true;
  private boolean cTj = true;
  private boolean cTk = true;
  private boolean cTl = true;
  private boolean cTm = true;
  private boolean ctE = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  
  static
  {
    cTh = "appid".hashCode();
    cTn = "wordingId".hashCode();
    cTd = "language".hashCode();
    cTo = "wording".hashCode();
    cTp = "pinyin".hashCode();
    cTq = "quanpin".hashCode();
    ctG = "updateTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cTh != k) {
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
      if (cTn == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (cTd == k) {
        this.field_language = paramCursor.getString(i);
      } else if (cTo == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (cTp == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (cTq == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cTf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.cTj) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.cTa) {
      localContentValues.put("language", this.field_language);
    }
    if (this.cTk) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.cTl) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.cTm) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.da
 * JD-Core Version:    0.7.0.1
 */