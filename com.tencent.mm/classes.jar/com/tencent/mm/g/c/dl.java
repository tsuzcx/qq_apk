package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJA = "quanpin".hashCode();
  private static final int dJn;
  private static final int dJr = "appid".hashCode();
  private static final int dJx = "wordingId".hashCode();
  private static final int dJy;
  private static final int dJz;
  private static final int dhV = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJk = true;
  private boolean dJp = true;
  private boolean dJt = true;
  private boolean dJu = true;
  private boolean dJv = true;
  private boolean dJw = true;
  private boolean dhT = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  
  static
  {
    dJn = "language".hashCode();
    dJy = "wording".hashCode();
    dJz = "pinyin".hashCode();
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
      if (dJr != k) {
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
      if (dJx == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (dJn == k) {
        this.field_language = paramCursor.getString(i);
      } else if (dJy == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (dJz == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (dJA == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dJp) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.dJt) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.dJk) {
      localContentValues.put("language", this.field_language);
    }
    if (this.dJu) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.dJv) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.dJw) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.dl
 * JD-Core Version:    0.7.0.1
 */