package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTn = "wallet_region".hashCode();
  private static final int dTo = "function_list".hashCode();
  private static final int dTp = "new_list".hashCode();
  private static final int dTq = "banner_list".hashCode();
  private static final int dTr = "type_name_list".hashCode();
  private static final int dTs = "isShowSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTh = true;
  private boolean dTi = true;
  private boolean dTj = true;
  private boolean dTk = true;
  private boolean dTl = true;
  private boolean dTm = true;
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
      if (dTn != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.dTh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dTo == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (dTp == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (dTq == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (dTr == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (dTs == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTh) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.dTi) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.dTj) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.dTk) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.dTl) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.dTm) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.fi
 * JD-Core Version:    0.7.0.1
 */