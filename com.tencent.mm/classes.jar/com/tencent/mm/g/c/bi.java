package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAB;
  private static final int eBC = "groupId".hashCode();
  private static final int eBr;
  private static final int eCh = "md5_lang".hashCode();
  private static final int eCi;
  private static final int eCj = "click_flag".hashCode();
  private static final int eCk = "download_flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eAQ = true;
  private boolean eAb = true;
  private boolean eCd = true;
  private boolean eCe = true;
  private boolean eCf = true;
  private boolean eCg = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    eBr = "md5".hashCode();
    eAB = "lang".hashCode();
    eCi = "desc".hashCode();
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
      if (eCh != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.eCd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBr == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eAB == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eCi == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (eBC == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eCj == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (eCk == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCd) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eAb) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eCe) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eAQ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eCf) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.eCg) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bi
 * JD-Core Version:    0.7.0.1
 */