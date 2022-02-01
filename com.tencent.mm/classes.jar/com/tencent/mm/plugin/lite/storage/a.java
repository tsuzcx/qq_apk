package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column Kbg;
  public static final Column Kbh;
  public static final Column Kbi;
  private static final int Kbm;
  private static final int Kbn;
  private static final int Kbo;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LiteAppAuthInfo");
  public static final Column UPDATETIME;
  public static final Column llQ;
  private static final int llS;
  private static final StorageObserverOwner<a> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean Kbj = true;
  private boolean Kbk = true;
  private boolean Kbl = true;
  private boolean __hadSetupdateTime = true;
  public String field_headerMap;
  public String field_host;
  public String field_param;
  public String field_paramMap;
  public long field_updateTime;
  private boolean llR = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    llQ = new Column("host", "string", TABLE.getName(), "");
    Kbg = new Column("param", "string", TABLE.getName(), "");
    Kbh = new Column("headerMap", "string", TABLE.getName(), "");
    Kbi = new Column("paramMap", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    llS = "host".hashCode();
    Kbm = "param".hashCode();
    Kbn = "headerMap".hashCode();
    Kbo = "paramMap".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "host";
    localMAutoDBInfo.colsMap.put("host", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" host TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "host";
    localMAutoDBInfo.columns[1] = "param";
    localMAutoDBInfo.colsMap.put("param", "TEXT");
    localStringBuilder.append(" param TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "headerMap";
    localMAutoDBInfo.colsMap.put("headerMap", "TEXT");
    localStringBuilder.append(" headerMap TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "paramMap";
    localMAutoDBInfo.colsMap.put("paramMap", "TEXT");
    localStringBuilder.append(" paramMap TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("host"))
    {
      this.field_host = paramContentValues.getAsString("host");
      if (paramBoolean) {
        this.llR = true;
      }
    }
    if (paramContentValues.containsKey("param"))
    {
      this.field_param = paramContentValues.getAsString("param");
      if (paramBoolean) {
        this.Kbj = true;
      }
    }
    if (paramContentValues.containsKey("headerMap"))
    {
      this.field_headerMap = paramContentValues.getAsString("headerMap");
      if (paramBoolean) {
        this.Kbk = true;
      }
    }
    if (paramContentValues.containsKey("paramMap"))
    {
      this.field_paramMap = paramContentValues.getAsString("paramMap");
      if (paramBoolean) {
        this.Kbl = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (llS != k) {
        break label65;
      }
      this.field_host = paramCursor.getString(i);
      this.llR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (Kbm == k) {
        this.field_param = paramCursor.getString(i);
      } else if (Kbn == k) {
        this.field_headerMap = paramCursor.getString(i);
      } else if (Kbo == k) {
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
    if (this.llR) {
      localContentValues.put("host", this.field_host);
    }
    if (this.Kbj) {
      localContentValues.put("param", this.field_param);
    }
    if (this.Kbk) {
      localContentValues.put("headerMap", this.field_headerMap);
    }
    if (this.Kbl) {
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
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends a> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_host;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.a
 * JD-Core Version:    0.7.0.1
 */