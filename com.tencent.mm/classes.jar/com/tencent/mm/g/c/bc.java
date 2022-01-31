package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dtX;
  private static final int dtg;
  private static final int duN = "md5_lang".hashCode();
  private static final int duO;
  private static final int duP = "click_flag".hashCode();
  private static final int duQ = "download_flag".hashCode();
  private static final int dui;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dsG = true;
  private boolean dtk = true;
  private boolean dtw = true;
  private boolean duJ = true;
  private boolean duK = true;
  private boolean duL = true;
  private boolean duM = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    dtX = "md5".hashCode();
    dtg = "lang".hashCode();
    duO = "desc".hashCode();
    dui = "groupId".hashCode();
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
      if (duN != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.duJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dtX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (dtg == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (duO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (dui == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (duP == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (duQ == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.duJ) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dsG) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.duK) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.dtw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.duL) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.duM) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.bc
 * JD-Core Version:    0.7.0.1
 */