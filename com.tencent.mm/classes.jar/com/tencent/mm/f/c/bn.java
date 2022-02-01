package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bn
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmotionDesignerInfo");
  private static final int content_HASHCODE = "content".hashCode();
  public static final Column hJA;
  private static final int hJC;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public byte[] field_content;
  public String field_designerIDAndType;
  private boolean hJB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmotionDesignerInfo", "");
    hJA = new Column("designeridandtype", "string", "EmotionDesignerInfo", "");
    C_CONTENT = new Column("content", "byte[]", "EmotionDesignerInfo", "");
    hJC = "designerIDAndType".hashCode();
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
      if (hJC != k) {
        break label65;
      }
      this.field_designerIDAndType = paramCursor.getString(i);
      this.hJB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hJB) {
      localContentValues.put("designerIDAndType", this.field_designerIDAndType);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
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
    return "EmotionDesignerInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bn
 * JD-Core Version:    0.7.0.1
 */