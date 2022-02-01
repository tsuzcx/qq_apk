package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bo
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmotionDetailInfo");
  private static final int content_HASHCODE = "content".hashCode();
  public static final Column hFp;
  private static final int hGw;
  public static final Column hJD;
  private static final int hJF = "lan".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public byte[] field_content;
  public String field_lan;
  public String field_productID;
  private boolean hFW = true;
  private boolean hJE = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmotionDetailInfo", "");
    hFp = new Column("productid", "string", "EmotionDetailInfo", "");
    C_CONTENT = new Column("content", "byte[]", "EmotionDetailInfo", "");
    hJD = new Column("lan", "string", "EmotionDetailInfo", "");
    hGw = "productID".hashCode();
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
      if (hGw != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.hFW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (hJF == k) {
        this.field_lan = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hFW) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_lan == null) {
      this.field_lan = "";
    }
    if (this.hJE) {
      localContentValues.put("lan", this.field_lan);
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
    return "EmotionDetailInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bo
 * JD-Core Version:    0.7.0.1
 */