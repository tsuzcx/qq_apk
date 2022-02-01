package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fl
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PendingCardId");
  public static final Column hPZ;
  private static final int hRb = "retryCount".hashCode();
  public static final Column iqG;
  private static final int iqI;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_cardUserId;
  public int field_retryCount;
  private boolean hQA = true;
  private boolean iqH = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PendingCardId", "");
    iqG = new Column("carduserid", "string", "PendingCardId", "");
    hPZ = new Column("retrycount", "int", "PendingCardId", "");
    iqI = "cardUserId".hashCode();
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
      if (iqI != k) {
        break label65;
      }
      this.field_cardUserId = paramCursor.getString(i);
      this.iqH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hRb == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iqH) {
      localContentValues.put("cardUserId", this.field_cardUserId);
    }
    if (this.hQA) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
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
    return "PendingCardId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fl
 * JD-Core Version:    0.7.0.1
 */