package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fyg = "wallet_region".hashCode();
  private static final int fyh = "function_list".hashCode();
  private static final int fyi = "new_list".hashCode();
  private static final int fyj = "banner_list".hashCode();
  private static final int fyk = "type_name_list".hashCode();
  private static final int fyl = "isShowSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_banner_list;
  public String field_function_list;
  public int field_isShowSetting;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  private boolean fya = true;
  private boolean fyb = true;
  private boolean fyc = true;
  private boolean fyd = true;
  private boolean fye = true;
  private boolean fyf = true;
  
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
      if (fyg != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.fya = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyh == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (fyi == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (fyj == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (fyk == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (fyl == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fya) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.fyb) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.fyc) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.fyd) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.fye) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.fyf) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gu
 * JD-Core Version:    0.7.0.1
 */