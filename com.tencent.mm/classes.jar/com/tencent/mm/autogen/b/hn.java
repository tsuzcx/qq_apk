package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hn
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsReportKv");
  public static final Column VALUE;
  public static final Column jKv;
  private static final int jLd;
  public static final Column laU;
  public static final Column laV;
  public static final Column laW;
  private static final int lba;
  private static final int lbb;
  private static final int lbc;
  private static final StorageObserverOwner<hn> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  private boolean jKM = true;
  private boolean laX = true;
  private boolean laY = true;
  private boolean laZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    laU = new Column("logtime", "long", TABLE.getName(), "");
    jKv = new Column("offset", "int", TABLE.getName(), "");
    laV = new Column("logsize", "int", TABLE.getName(), "");
    laW = new Column("errorcount", "int", TABLE.getName(), "");
    VALUE = new Column("value", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
    lba = "logtime".hashCode();
    jLd = "offset".hashCode();
    lbb = "logsize".hashCode();
    lbc = "errorcount".hashCode();
    value_HASHCODE = "value".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "logtime";
    localMAutoDBInfo.colsMap.put("logtime", "LONG");
    localStringBuilder.append(" logtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER default '0' ");
    localStringBuilder.append(" offset INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "logsize";
    localMAutoDBInfo.colsMap.put("logsize", "INTEGER");
    localStringBuilder.append(" logsize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "errorcount";
    localMAutoDBInfo.colsMap.put("errorcount", "INTEGER");
    localStringBuilder.append(" errorcount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "value";
    localMAutoDBInfo.colsMap.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("logtime"))
    {
      this.field_logtime = paramContentValues.getAsLong("logtime").longValue();
      if (paramBoolean) {
        this.laX = true;
      }
    }
    if (paramContentValues.containsKey("offset"))
    {
      this.field_offset = paramContentValues.getAsInteger("offset").intValue();
      if (paramBoolean) {
        this.jKM = true;
      }
    }
    if (paramContentValues.containsKey("logsize"))
    {
      this.field_logsize = paramContentValues.getAsInteger("logsize").intValue();
      if (paramBoolean) {
        this.laY = true;
      }
    }
    if (paramContentValues.containsKey("errorcount"))
    {
      this.field_errorcount = paramContentValues.getAsInteger("errorcount").intValue();
      if (paramBoolean) {
        this.laZ = true;
      }
    }
    if (paramContentValues.containsKey("value"))
    {
      this.field_value = paramContentValues.getAsByteArray("value");
      if (paramBoolean) {
        this.__hadSetvalue = true;
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
      if (lba != k) {
        break label60;
      }
      this.field_logtime = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jLd == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (lbb == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (lbc == k) {
        this.field_errorcount = paramCursor.getInt(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.laX) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.jKM) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.laY) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.laZ) {
      localContentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
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
  
  public StorageObserverOwner<? extends hn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hn
 * JD-Core Version:    0.7.0.1
 */