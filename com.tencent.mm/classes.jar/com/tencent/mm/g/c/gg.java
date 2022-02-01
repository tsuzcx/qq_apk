package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fcG = "wallet_region".hashCode();
  private static final int fcH = "function_list".hashCode();
  private static final int fcI = "new_list".hashCode();
  private static final int fcJ = "banner_list".hashCode();
  private static final int fcK = "type_name_list".hashCode();
  private static final int fcL = "isShowSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fcA = true;
  private boolean fcB = true;
  private boolean fcC = true;
  private boolean fcD = true;
  private boolean fcE = true;
  private boolean fcF = true;
  public String field_banner_list;
  public String field_function_list;
  public int field_isShowSetting;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  
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
      if (fcG != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.fcA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fcH == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (fcI == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (fcJ == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (fcK == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (fcL == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fcA) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.fcB) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.fcC) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.fcD) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.fcE) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.fcF) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gg
 * JD-Core Version:    0.7.0.1
 */