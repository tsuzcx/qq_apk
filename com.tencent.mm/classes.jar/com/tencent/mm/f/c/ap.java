package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ap
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("CanvasInfo");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hxR;
  public static final Column hxS;
  private static final int hxV;
  private static final int hxW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  private boolean hxT = true;
  private boolean hxU = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "CanvasInfo", "");
    hxR = new Column("canvasid", "long", "CanvasInfo", "");
    hxS = new Column("canvasxml", "string", "CanvasInfo", "");
    C_CREATETIME = new Column("createtime", "long", "CanvasInfo", "");
    hxV = "canvasId".hashCode();
    hxW = "canvasXml".hashCode();
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
      if (hxV != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getLong(i);
      this.hxT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hxW == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hxT) {
      localContentValues.put("canvasId", Long.valueOf(this.field_canvasId));
    }
    if (this.hxU) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
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
    return "CanvasInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ap
 * JD-Core Version:    0.7.0.1
 */