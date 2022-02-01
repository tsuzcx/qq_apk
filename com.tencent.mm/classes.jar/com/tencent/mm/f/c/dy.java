package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dy
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "IPCallAddressItem", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("IPCallAddressItem");
  public static final Column ieE = new Column("wechatusername", "string", "IPCallAddressItem", "");
  public static final Column ieF = new Column("systemaddressbookusername", "string", "IPCallAddressItem", "");
  public static final Column ieG = new Column("contactid", "string", "IPCallAddressItem", "");
  public static final Column ieH = new Column("sortkey", "string", "IPCallAddressItem", "");
  private static final int ieM = "wechatUsername".hashCode();
  private static final int ieN = "systemAddressBookUsername".hashCode();
  private static final int ieO = "contactId".hashCode();
  private static final int ieP = "sortKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_contactId;
  public String field_sortKey;
  public String field_systemAddressBookUsername;
  public String field_wechatUsername;
  private boolean ieI = true;
  private boolean ieJ = true;
  private boolean ieK = true;
  private boolean ieL = true;
  
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
      if (ieM != k) {
        break label60;
      }
      this.field_wechatUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ieN == k) {
        this.field_systemAddressBookUsername = paramCursor.getString(i);
      } else if (ieO == k) {
        this.field_contactId = paramCursor.getString(i);
      } else if (ieP == k) {
        this.field_sortKey = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ieI) {
      localContentValues.put("wechatUsername", this.field_wechatUsername);
    }
    if (this.ieJ) {
      localContentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
    }
    if (this.ieK) {
      localContentValues.put("contactId", this.field_contactId);
    }
    if (this.ieL) {
      localContentValues.put("sortKey", this.field_sortKey);
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
    return "IPCallAddressItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.dy
 * JD-Core Version:    0.7.0.1
 */