package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int geY = "wallet_region".hashCode();
  private static final int geZ = "function_list".hashCode();
  private static final int gfa = "new_list".hashCode();
  private static final int gfb = "banner_list".hashCode();
  private static final int gfc = "type_name_list".hashCode();
  private static final int gfd = "isShowSetting".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_banner_list;
  public String field_function_list;
  public int field_isShowSetting;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  private boolean geS = true;
  private boolean geT = true;
  private boolean geU = true;
  private boolean geV = true;
  private boolean geW = true;
  private boolean geX = true;
  
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
      if (geY != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.geS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (geZ == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (gfa == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (gfb == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (gfc == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (gfd == k) {
        this.field_isShowSetting = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.geS) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.geT) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.geU) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.geV) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.geW) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.geX) {
      localContentValues.put("isShowSetting", Integer.valueOf(this.field_isShowSetting));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hg
 * JD-Core Version:    0.7.0.1
 */