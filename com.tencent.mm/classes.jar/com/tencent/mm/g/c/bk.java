package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bk
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fxp;
  private static final int fyV = "md5_lang".hashCode();
  private static final int fyW;
  private static final int fyX = "click_flag".hashCode();
  private static final int fyY = "download_flag".hashCode();
  private static final int fyf = "md5".hashCode();
  private static final int fyq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  private boolean fwP = true;
  private boolean fxE = true;
  private boolean fxt = true;
  private boolean fyR = true;
  private boolean fyS = true;
  private boolean fyT = true;
  private boolean fyU = true;
  
  static
  {
    fxp = "lang".hashCode();
    fyW = "desc".hashCode();
    fyq = "groupId".hashCode();
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
      if (fyV != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.fyR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyf == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fxp == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (fyW == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (fyq == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (fyX == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (fyY == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fyR) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fwP) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.fyS) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.fxE) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.fyT) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.fyU) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.bk
 * JD-Core Version:    0.7.0.1
 */