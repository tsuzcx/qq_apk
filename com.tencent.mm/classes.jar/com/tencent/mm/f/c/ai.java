package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ai
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizChatMyUserInfo");
  public static final Column hsT;
  private static final int htx = "brandUserName".hashCode();
  private static final int huA = "userId".hashCode();
  public static final Column huy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_brandUserName;
  public String field_userId;
  private boolean hti = true;
  private boolean huz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizChatMyUserInfo", "");
    hsT = new Column("brandusername", "string", "BizChatMyUserInfo", "");
    huy = new Column("userid", "string", "BizChatMyUserInfo", "");
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
      if (htx != k) {
        break label65;
      }
      this.field_brandUserName = paramCursor.getString(i);
      this.hti = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (huA == k) {
        this.field_userId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hti) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.huz) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "BizChatMyUserInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ai
 * JD-Core Version:    0.7.0.1
 */