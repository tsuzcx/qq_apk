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

public abstract class d
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ABTestItem");
  public static final Column jIH;
  public static final Column jII;
  public static final Column jIJ;
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIV;
  private static final int jIW;
  private static final int jIX;
  private static final int jIY;
  private static final int jIZ;
  public static final Column jJb;
  public static final Column jJc;
  public static final Column jJd;
  public static final Column jJe;
  private static final int jJj;
  private static final int jJk;
  private static final int jJl;
  private static final int jJm;
  private static final StorageObserverOwner<d> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  private boolean jIO = true;
  private boolean jIP = true;
  private boolean jIQ = true;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean jJf = true;
  private boolean jJg = true;
  private boolean jJh = true;
  private boolean jJi = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jJb = new Column("layerId", "string", TABLE.getName(), "");
    jJc = new Column("business", "string", TABLE.getName(), "");
    jIH = new Column("expId", "string", TABLE.getName(), "");
    jII = new Column("sequence", "long", TABLE.getName(), "");
    jIJ = new Column("prioritylevel", "int", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    jIL = new Column("endTime", "long", TABLE.getName(), "");
    jJd = new Column("needReport", "boolean", TABLE.getName(), "");
    jJe = new Column("rawXML", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jJj = "layerId".hashCode();
    jJk = "business".hashCode();
    jIV = "expId".hashCode();
    jIW = "sequence".hashCode();
    jIX = "prioritylevel".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    jJl = "needReport".hashCode();
    jJm = "rawXML".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "layerId";
    localMAutoDBInfo.colsMap.put("layerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" layerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "layerId";
    localMAutoDBInfo.columns[1] = "business";
    localMAutoDBInfo.colsMap.put("business", "TEXT");
    localStringBuilder.append(" business TEXT");
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
    localMAutoDBInfo.colsMap.put("prioritylevel", "INTEGER default '0' ");
    localStringBuilder.append(" prioritylevel INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "needReport";
    localMAutoDBInfo.colsMap.put("needReport", "INTEGER");
    localStringBuilder.append(" needReport INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "rawXML";
    localMAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("layerId"))
    {
      this.field_layerId = paramContentValues.getAsString("layerId");
      if (paramBoolean) {
        this.jJf = true;
      }
    }
    if (paramContentValues.containsKey("business"))
    {
      this.field_business = paramContentValues.getAsString("business");
      if (paramBoolean) {
        this.jJg = true;
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
    if (paramContentValues.containsKey("needReport")) {
      if (paramContentValues.getAsInteger("needReport").intValue() == 0) {
        break label296;
      }
    }
    label296:
    for (boolean bool = true;; bool = false)
    {
      this.field_needReport = bool;
      if (paramBoolean) {
        this.jJh = true;
      }
      if (paramContentValues.containsKey("rawXML"))
      {
        this.field_rawXML = paramContentValues.getAsString("rawXML");
        if (paramBoolean) {
          this.jJi = true;
        }
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
      if (jJj != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.jJf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jJk == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (jJl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (jJm == k) {
          this.field_rawXML = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jJf) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.jJg) {
      localContentValues.put("business", this.field_business);
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
    if (this.jJh) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.jJi) {
      localContentValues.put("rawXML", this.field_rawXML);
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
  
  public StorageObserverOwner<? extends d> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_layerId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.d
 * JD-Core Version:    0.7.0.1
 */