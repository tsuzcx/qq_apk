package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class az
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ContactLabel");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hDH;
  public static final Column hDI;
  public static final Column hDJ;
  public static final Column hDK;
  public static final Column hDL;
  private static final int hDR;
  private static final int hDS;
  private static final int hDT;
  private static final int hDU;
  private static final int hDV = "isTemporary".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public boolean field_isTemporary;
  public int field_labelID;
  public String field_labelName;
  public String field_labelPYFull;
  public String field_labelPYShort;
  private boolean hDM = true;
  private boolean hDN = true;
  private boolean hDO = true;
  private boolean hDP = true;
  private boolean hDQ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ContactLabel", "");
    hDH = new Column("labelid", "int", "ContactLabel", "");
    hDI = new Column("labelname", "string", "ContactLabel", "");
    hDJ = new Column("labelpyfull", "string", "ContactLabel", "");
    hDK = new Column("labelpyshort", "string", "ContactLabel", "");
    C_CREATETIME = new Column("createtime", "long", "ContactLabel", "");
    hDL = new Column("istemporary", "boolean", "ContactLabel", "");
    hDR = "labelID".hashCode();
    hDS = "labelName".hashCode();
    hDT = "labelPYFull".hashCode();
    hDU = "labelPYShort".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (hDR != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.hDM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hDS == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (hDT == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (hDU == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (hDV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isTemporary = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hDM) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.hDN) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.hDO) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.hDP) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hDQ) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
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
    return "ContactLabel";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.az
 * JD-Core Version:    0.7.0.1
 */