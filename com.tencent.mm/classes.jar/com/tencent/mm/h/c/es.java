package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class es
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dbV = "wallet_region".hashCode();
  private static final int dbW = "function_list".hashCode();
  private static final int dbX = "new_list".hashCode();
  private static final int dbY = "banner_list".hashCode();
  private static final int dbZ = "type_name_list".hashCode();
  private boolean dbQ = true;
  private boolean dbR = true;
  private boolean dbS = true;
  private boolean dbT = true;
  private boolean dbU = true;
  public String field_banner_list;
  public String field_function_list;
  public String field_new_list;
  public String field_type_name_list;
  public int field_wallet_region;
  
  public void d(Cursor paramCursor)
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
      if (dbV != k) {
        break label65;
      }
      this.field_wallet_region = paramCursor.getInt(i);
      this.dbQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dbW == k) {
        this.field_function_list = paramCursor.getString(i);
      } else if (dbX == k) {
        this.field_new_list = paramCursor.getString(i);
      } else if (dbY == k) {
        this.field_banner_list = paramCursor.getString(i);
      } else if (dbZ == k) {
        this.field_type_name_list = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dbQ) {
      localContentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
    }
    if (this.dbR) {
      localContentValues.put("function_list", this.field_function_list);
    }
    if (this.dbS) {
      localContentValues.put("new_list", this.field_new_list);
    }
    if (this.dbT) {
      localContentValues.put("banner_list", this.field_banner_list);
    }
    if (this.dbU) {
      localContentValues.put("type_name_list", this.field_type_name_list);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.es
 * JD-Core Version:    0.7.0.1
 */