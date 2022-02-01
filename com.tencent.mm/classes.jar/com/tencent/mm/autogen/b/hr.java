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

public abstract class hr
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SportStepItem");
  private static final int id_HASHCODE;
  private static final int kDA;
  public static final Column kDy;
  public static final Column kKp;
  private static final int kKr;
  public static final Column kkd;
  private static final int kkx;
  private static final StorageObserverOwner<hr> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetid = true;
  public String field_date;
  public int field_id;
  public int field_step;
  public long field_timestamp;
  private boolean kDz = true;
  private boolean kKq = true;
  private boolean kkn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ID = new Column("id", "int", TABLE.getName(), "");
    kKp = new Column("date", "string", TABLE.getName(), "");
    kDy = new Column("step", "int", TABLE.getName(), "");
    kkd = new Column("timestamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    id_HASHCODE = "id".hashCode();
    kKr = "date".hashCode();
    kDA = "step".hashCode();
    kkx = "timestamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" id INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "date";
    localMAutoDBInfo.colsMap.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "step";
    localMAutoDBInfo.colsMap.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsInteger("id").intValue();
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("date"))
    {
      this.field_date = paramContentValues.getAsString("date");
      if (paramBoolean) {
        this.kKq = true;
      }
    }
    if (paramContentValues.containsKey("step"))
    {
      this.field_step = paramContentValues.getAsInteger("step").intValue();
      if (paramBoolean) {
        this.kDz = true;
      }
    }
    if (paramContentValues.containsKey("timestamp"))
    {
      this.field_timestamp = paramContentValues.getAsLong("timestamp").longValue();
      if (paramBoolean) {
        this.kkn = true;
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getInt(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kKr == k) {
        this.field_date = paramCursor.getString(i);
      } else if (kDA == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (kkx == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.kKq) {
      localContentValues.put("date", this.field_date);
    }
    if (this.kDz) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.kkn) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
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
  
  public StorageObserverOwner<? extends hr> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_id);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hr
 * JD-Core Version:    0.7.0.1
 */