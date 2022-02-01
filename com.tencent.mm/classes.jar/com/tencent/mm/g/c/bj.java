package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTK;
  private static final int eUA;
  private static final int eUL = "groupId".hashCode();
  private static final int eVq = "md5_lang".hashCode();
  private static final int eVr;
  private static final int eVs = "click_flag".hashCode();
  private static final int eVt = "download_flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTO = true;
  private boolean eTZ = true;
  private boolean eTk = true;
  private boolean eVm = true;
  private boolean eVn = true;
  private boolean eVo = true;
  private boolean eVp = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    eUA = "md5".hashCode();
    eTK = "lang".hashCode();
    eVr = "desc".hashCode();
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
      if (eVq != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.eVm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUA == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eTK == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eVr == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (eUL == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eVs == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (eVt == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVm) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eTk) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eVn) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eTZ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eVo) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.eVp) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bj
 * JD-Core Version:    0.7.0.1
 */