package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fb
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fUd;
  private static final int fUh = "appid".hashCode();
  private static final int fUn = "wordingId".hashCode();
  private static final int fUo;
  private static final int fUp;
  private static final int fUq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fUa = true;
  private boolean fUf = true;
  private boolean fUj = true;
  private boolean fUk = true;
  private boolean fUl = true;
  private boolean fUm = true;
  public String field_appid;
  public String field_language;
  public String field_pinyin;
  public String field_quanpin;
  public long field_updateTime;
  public String field_wording;
  public String field_wordingId;
  
  static
  {
    fUd = "language".hashCode();
    fUo = "wording".hashCode();
    fUp = "pinyin".hashCode();
    fUq = "quanpin".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (fUh != k) {
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
      if (fUn == k) {
        this.field_wordingId = paramCursor.getString(i);
      } else if (fUd == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fUo == k) {
        this.field_wording = paramCursor.getString(i);
      } else if (fUp == k) {
        this.field_pinyin = paramCursor.getString(i);
      } else if (fUq == k) {
        this.field_quanpin = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fUf) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.fUj) {
      localContentValues.put("wordingId", this.field_wordingId);
    }
    if (this.fUa) {
      localContentValues.put("language", this.field_language);
    }
    if (this.fUk) {
      localContentValues.put("wording", this.field_wording);
    }
    if (this.fUl) {
      localContentValues.put("pinyin", this.field_pinyin);
    }
    if (this.fUm) {
      localContentValues.put("quanpin", this.field_quanpin);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fb
 * JD-Core Version:    0.7.0.1
 */