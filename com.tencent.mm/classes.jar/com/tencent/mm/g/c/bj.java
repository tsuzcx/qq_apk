package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRZ;
  private static final int eSP;
  private static final int eTF = "md5_lang".hashCode();
  private static final int eTG;
  private static final int eTH = "click_flag".hashCode();
  private static final int eTI = "download_flag".hashCode();
  private static final int eTa;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRz = true;
  private boolean eSd = true;
  private boolean eSo = true;
  private boolean eTB = true;
  private boolean eTC = true;
  private boolean eTD = true;
  private boolean eTE = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    eSP = "md5".hashCode();
    eRZ = "lang".hashCode();
    eTG = "desc".hashCode();
    eTa = "groupId".hashCode();
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
      if (eTF != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.eTB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSP == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eRZ == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (eTG == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (eTa == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eTH == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (eTI == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTB) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eRz) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eSo) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eTD) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.eTE) {
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