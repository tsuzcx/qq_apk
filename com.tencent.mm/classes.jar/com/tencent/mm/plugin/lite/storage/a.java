package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class a
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column EgI;
  public static final Column EgJ;
  public static final Column EgK;
  private static final int EgO;
  private static final int EgP;
  private static final int EgQ;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LiteAppAuthInfo");
  public static final Column iJZ;
  private static final int iKb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean EgL = true;
  private boolean EgM = true;
  private boolean EgN = true;
  private boolean __hadSetupdateTime = true;
  public String field_headerMap;
  public String field_host;
  public String field_param;
  public String field_paramMap;
  public long field_updateTime;
  private boolean iKa = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LiteAppAuthInfo", "");
    iJZ = new Column("host", "string", "LiteAppAuthInfo", "");
    EgI = new Column("param", "string", "LiteAppAuthInfo", "");
    EgJ = new Column("headermap", "string", "LiteAppAuthInfo", "");
    EgK = new Column("parammap", "string", "LiteAppAuthInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "LiteAppAuthInfo", "");
    iKb = "host".hashCode();
    EgO = "param".hashCode();
    EgP = "headerMap".hashCode();
    EgQ = "paramMap".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (iKb != k) {
        break label65;
      }
      this.field_host = paramCursor.getString(i);
      this.iKa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (EgO == k) {
        this.field_param = paramCursor.getString(i);
      } else if (EgP == k) {
        this.field_headerMap = paramCursor.getString(i);
      } else if (EgQ == k) {
        this.field_paramMap = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iKa) {
      localContentValues.put("host", this.field_host);
    }
    if (this.EgL) {
      localContentValues.put("param", this.field_param);
    }
    if (this.EgM) {
      localContentValues.put("headerMap", this.field_headerMap);
    }
    if (this.EgN) {
      localContentValues.put("paramMap", this.field_paramMap);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
    return "LiteAppAuthInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.a
 * JD-Core Version:    0.7.0.1
 */