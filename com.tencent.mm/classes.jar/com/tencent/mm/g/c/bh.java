package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eyX;
  private static final int eyh;
  private static final int ezN = "md5_lang".hashCode();
  private static final int ezO;
  private static final int ezP = "click_flag".hashCode();
  private static final int ezQ = "download_flag".hashCode();
  private static final int ezi;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean exG = true;
  private boolean eyl = true;
  private boolean eyw = true;
  private boolean ezJ = true;
  private boolean ezK = true;
  private boolean ezL = true;
  private boolean ezM = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    eyX = "md5".hashCode();
    eyh = "lang".hashCode();
    ezO = "desc".hashCode();
    ezi = "groupId".hashCode();
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
      if (ezN != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.ezJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eyX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eyh == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (ezO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (ezi == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (ezP == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (ezQ == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ezJ) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.exG) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.ezK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eyw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.ezL) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.ezM) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bh
 * JD-Core Version:    0.7.0.1
 */