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

public abstract class eo
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("IPCallPopularCountry");
  public static final Column kEr;
  public static final Column kEs;
  public static final Column kEt;
  private static final int kEx;
  private static final int kEy;
  private static final int kEz;
  private static final StorageObserverOwner<eo> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_callTimeCount;
  public int field_countryCode;
  public long field_lastCallTime;
  private boolean kEu = true;
  private boolean kEv = true;
  private boolean kEw = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kEr = new Column("countryCode", "int", TABLE.getName(), "");
    kEs = new Column("callTimeCount", "long", TABLE.getName(), "");
    kEt = new Column("lastCallTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kEx = "countryCode".hashCode();
    kEy = "callTimeCount".hashCode();
    kEz = "lastCallTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "countryCode";
    localMAutoDBInfo.colsMap.put("countryCode", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" countryCode INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "countryCode";
    localMAutoDBInfo.columns[1] = "callTimeCount";
    localMAutoDBInfo.colsMap.put("callTimeCount", "LONG");
    localStringBuilder.append(" callTimeCount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lastCallTime";
    localMAutoDBInfo.colsMap.put("lastCallTime", "LONG");
    localStringBuilder.append(" lastCallTime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("countryCode"))
    {
      this.field_countryCode = paramContentValues.getAsInteger("countryCode").intValue();
      if (paramBoolean) {
        this.kEu = true;
      }
    }
    if (paramContentValues.containsKey("callTimeCount"))
    {
      this.field_callTimeCount = paramContentValues.getAsLong("callTimeCount").longValue();
      if (paramBoolean) {
        this.kEv = true;
      }
    }
    if (paramContentValues.containsKey("lastCallTime"))
    {
      this.field_lastCallTime = paramContentValues.getAsLong("lastCallTime").longValue();
      if (paramBoolean) {
        this.kEw = true;
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
      if (kEx != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.kEu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kEy == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (kEz == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kEu) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.kEv) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.kEw) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
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
  
  public StorageObserverOwner<? extends eo> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_countryCode);
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
 * Qualified Name:     com.tencent.mm.autogen.b.eo
 * JD-Core Version:    0.7.0.1
 */