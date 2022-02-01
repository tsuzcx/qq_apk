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

public abstract class c
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ABTestInfo");
  public static final Column VALUE;
  public static final Column jIG;
  public static final Column jIH;
  public static final Column jII;
  public static final Column jIJ;
  public static final Column jIK;
  public static final Column jIL;
  public static final Column jIM;
  private static final int jIU;
  private static final int jIV;
  private static final int jIW;
  private static final int jIX;
  private static final int jIY;
  private static final int jIZ;
  private static final int jJa;
  private static final StorageObserverOwner<c> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  private boolean jIN = true;
  private boolean jIO = true;
  private boolean jIP = true;
  private boolean jIQ = true;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean jIT = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIG = new Column("abtestkey", "string", TABLE.getName(), "");
    VALUE = new Column("value", "string", TABLE.getName(), "");
    jIH = new Column("expId", "string", TABLE.getName(), "");
    jII = new Column("sequence", "long", TABLE.getName(), "");
    jIJ = new Column("prioritylevel", "int", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    jIL = new Column("endTime", "long", TABLE.getName(), "");
    jIM = new Column("noReport", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIU = "abtestkey".hashCode();
    value_HASHCODE = "value".hashCode();
    jIV = "expId".hashCode();
    jIW = "sequence".hashCode();
    jIX = "prioritylevel".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    jJa = "noReport".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "abtestkey";
    localMAutoDBInfo.colsMap.put("abtestkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" abtestkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "abtestkey";
    localMAutoDBInfo.columns[1] = "value";
    localMAutoDBInfo.colsMap.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "expId";
    localMAutoDBInfo.colsMap.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sequence";
    localMAutoDBInfo.colsMap.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "prioritylevel";
    localMAutoDBInfo.colsMap.put("prioritylevel", "INTEGER");
    localStringBuilder.append(" prioritylevel INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "noReport";
    localMAutoDBInfo.colsMap.put("noReport", "INTEGER");
    localStringBuilder.append(" noReport INTEGER");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("abtestkey"))
    {
      this.field_abtestkey = paramContentValues.getAsString("abtestkey");
      if (paramBoolean) {
        this.jIN = true;
      }
    }
    if (paramContentValues.containsKey("value"))
    {
      this.field_value = paramContentValues.getAsString("value");
      if (paramBoolean) {
        this.__hadSetvalue = true;
      }
    }
    if (paramContentValues.containsKey("expId"))
    {
      this.field_expId = paramContentValues.getAsString("expId");
      if (paramBoolean) {
        this.jIO = true;
      }
    }
    if (paramContentValues.containsKey("sequence"))
    {
      this.field_sequence = paramContentValues.getAsLong("sequence").longValue();
      if (paramBoolean) {
        this.jIP = true;
      }
    }
    if (paramContentValues.containsKey("prioritylevel"))
    {
      this.field_prioritylevel = paramContentValues.getAsInteger("prioritylevel").intValue();
      if (paramBoolean) {
        this.jIQ = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsLong("startTime").longValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("endTime"))
    {
      this.field_endTime = paramContentValues.getAsLong("endTime").longValue();
      if (paramBoolean) {
        this.jIS = true;
      }
    }
    if (paramContentValues.containsKey("noReport")) {
      if (paramContentValues.getAsInteger("noReport").intValue() == 0) {
        break label268;
      }
    }
    label268:
    for (boolean bool = true;; bool = false)
    {
      this.field_noReport = bool;
      if (paramBoolean) {
        this.jIT = true;
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
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
      if (jIU != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.jIN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (jIV == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (jIW == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (jIX == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (jIY == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (jIZ == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (jJa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_noReport = bool;
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
    if (this.jIN) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.jIO) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.jIP) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.jIQ) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.jIR) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.jIS) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.jIT) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
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
  
  public StorageObserverOwner<? extends c> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_abtestkey;
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
 * Qualified Name:     com.tencent.mm.autogen.b.c
 * JD-Core Version:    0.7.0.1
 */