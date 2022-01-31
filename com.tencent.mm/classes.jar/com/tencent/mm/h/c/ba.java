package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba
  extends c
{
  private static final int cEV;
  private static final int cFC;
  private static final int cFN = "groupId".hashCode();
  private static final int cGj;
  private static final int cGk;
  private static final int cGl = "click_flag".hashCode();
  private static final int cGm = "download_flag".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cEZ = true;
  private boolean cEv = true;
  private boolean cFk = true;
  private boolean cGf = true;
  private boolean cGg = true;
  private boolean cGh = true;
  private boolean cGi = true;
  public int field_click_flag;
  public String field_desc;
  public int field_download_flag;
  public String field_groupId;
  public String field_lang;
  public String field_md5;
  public String field_md5_lang;
  
  static
  {
    cGj = "md5_lang".hashCode();
    cFC = "md5".hashCode();
    cEV = "lang".hashCode();
    cGk = "desc".hashCode();
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
      if (cGj != k) {
        break label65;
      }
      this.field_md5_lang = paramCursor.getString(i);
      this.cGf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFC == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (cEV == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (cGk == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (cFN == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (cGl == k) {
        this.field_click_flag = paramCursor.getInt(i);
      } else if (cGm == k) {
        this.field_download_flag = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cGf) {
      localContentValues.put("md5_lang", this.field_md5_lang);
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cEv) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.cGg) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.cFk) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.cGh) {
      localContentValues.put("click_flag", Integer.valueOf(this.field_click_flag));
    }
    if (this.cGi) {
      localContentValues.put("download_flag", Integer.valueOf(this.field_download_flag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ba
 * JD-Core Version:    0.7.0.1
 */