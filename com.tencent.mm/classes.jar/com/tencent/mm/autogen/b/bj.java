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

public abstract class bj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EdgeComputingCacheDataModel");
  public static final Column jLt;
  private static final int jLz;
  public static final Column kcm;
  public static final Column kcn;
  private static final int kcq;
  private static final int kcr;
  private static final StorageObserverOwner<bj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_configID;
  public String field_data;
  public long field_reportTimeEC;
  private boolean jLw = true;
  private boolean kco = true;
  private boolean kcp = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kcm = new Column("configID", "string", TABLE.getName(), "");
    kcn = new Column("reportTimeEC", "long", TABLE.getName(), "");
    jLt = new Column("data", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kcq = "configID".hashCode();
    kcr = "reportTimeEC".hashCode();
    jLz = "data".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "configID";
    localMAutoDBInfo.colsMap.put("configID", "TEXT");
    localStringBuilder.append(" configID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "reportTimeEC";
    localMAutoDBInfo.colsMap.put("reportTimeEC", "LONG");
    localStringBuilder.append(" reportTimeEC LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "data";
    localMAutoDBInfo.colsMap.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("configID"))
    {
      this.field_configID = paramContentValues.getAsString("configID");
      if (paramBoolean) {
        this.kco = true;
      }
    }
    if (paramContentValues.containsKey("reportTimeEC"))
    {
      this.field_reportTimeEC = paramContentValues.getAsLong("reportTimeEC").longValue();
      if (paramBoolean) {
        this.kcp = true;
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsString("data");
      if (paramBoolean) {
        this.jLw = true;
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
      if (kcq != k) {
        break label60;
      }
      this.field_configID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kcr == k) {
        this.field_reportTimeEC = paramCursor.getLong(i);
      } else if (jLz == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kco) {
      localContentValues.put("configID", this.field_configID);
    }
    if (this.kcp) {
      localContentValues.put("reportTimeEC", Long.valueOf(this.field_reportTimeEC));
    }
    if (this.jLw) {
      localContentValues.put("data", this.field_data);
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
  
  public StorageObserverOwner<? extends bj> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.bj
 * JD-Core Version:    0.7.0.1
 */