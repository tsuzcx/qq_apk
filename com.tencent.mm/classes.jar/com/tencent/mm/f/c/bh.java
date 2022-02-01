package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bh
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "EmojiDesignerProduct", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmojiDesignerProduct");
  public static final Column hFo = new Column("designeruin", "int", "EmojiDesignerProduct", "");
  public static final Column hFp = new Column("productid", "string", "EmojiDesignerProduct", "");
  public static final Column hFq = new Column("synctime", "int", "EmojiDesignerProduct", "");
  private static final int hFu = "designerUin".hashCode();
  private static final int hFv = "productId".hashCode();
  private static final int hFw = "syncTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_designerUin;
  public String field_productId;
  public int field_syncTime;
  private boolean hFr = true;
  private boolean hFs = true;
  private boolean hFt = true;
  
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
      if (hFu != k) {
        break label60;
      }
      this.field_designerUin = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hFv == k) {
        this.field_productId = paramCursor.getString(i);
      } else if (hFw == k) {
        this.field_syncTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hFr) {
      localContentValues.put("designerUin", Integer.valueOf(this.field_designerUin));
    }
    if (this.hFs) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.hFt) {
      localContentValues.put("syncTime", Integer.valueOf(this.field_syncTime));
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
    return "EmojiDesignerProduct";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bh
 * JD-Core Version:    0.7.0.1
 */