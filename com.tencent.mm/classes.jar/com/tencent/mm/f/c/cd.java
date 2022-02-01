package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FileMsgInfo");
  public static final Column hHp;
  private static final int hIR = "aeskey".hashCode();
  public static final Column hPg;
  public static final Column hPh;
  private static final int hPk;
  private static final int hPl;
  public static final Column hwH;
  private static final int hxj;
  public static final Column hzC;
  private static final int hzS = "filePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_aeskey;
  public String field_cgi;
  public String field_filePath;
  public long field_msgSvrId;
  public long field_overwriteNewMsgId;
  private boolean hId = true;
  private boolean hPi = true;
  private boolean hPj = true;
  private boolean hwV = true;
  private boolean hzK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FileMsgInfo", "");
    hwH = new Column("msgsvrid", "long", "FileMsgInfo", "");
    hPg = new Column("overwritenewmsgid", "long", "FileMsgInfo", "");
    hPh = new Column("cgi", "string", "FileMsgInfo", "");
    hHp = new Column("aeskey", "string", "FileMsgInfo", "");
    hzC = new Column("filepath", "string", "FileMsgInfo", "");
    hxj = "msgSvrId".hashCode();
    hPk = "overwriteNewMsgId".hashCode();
    hPl = "cgi".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgSvrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgSvrId";
    localMAutoDBInfo.columns[1] = "overwriteNewMsgId";
    localMAutoDBInfo.colsMap.put("overwriteNewMsgId", "LONG");
    localStringBuilder.append(" overwriteNewMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "cgi";
    localMAutoDBInfo.colsMap.put("cgi", "TEXT default '' ");
    localStringBuilder.append(" cgi TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "aeskey";
    localMAutoDBInfo.colsMap.put("aeskey", "TEXT default '' ");
    localStringBuilder.append(" aeskey TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT default '' ");
    localStringBuilder.append(" filePath TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hxj != k) {
        break label65;
      }
      this.field_msgSvrId = paramCursor.getLong(i);
      this.hwV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hPk == k) {
        this.field_overwriteNewMsgId = paramCursor.getLong(i);
      } else if (hPl == k) {
        this.field_cgi = paramCursor.getString(i);
      } else if (hIR == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (hzS == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hwV) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.hPi) {
      localContentValues.put("overwriteNewMsgId", Long.valueOf(this.field_overwriteNewMsgId));
    }
    if (this.field_cgi == null) {
      this.field_cgi = "";
    }
    if (this.hPj) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.field_aeskey == null) {
      this.field_aeskey = "";
    }
    if (this.hId) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
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
    return "FileMsgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cd
 * JD-Core Version:    0.7.0.1
 */