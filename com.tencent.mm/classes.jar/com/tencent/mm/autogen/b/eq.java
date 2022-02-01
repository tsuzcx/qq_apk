package com.tencent.mm.autogen.b;

import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eq
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("JsLogBlockList");
  public static final Column kEM;
  public static final Column kEN;
  private static final int kEQ;
  private static final int kER;
  private static final StorageObserverOwner<eq> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_liftTime;
  public int field_logId;
  private boolean kEO = true;
  private boolean kEP = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kEM = new Column("logId", "int", TABLE.getName(), "");
    kEN = new Column("liftTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kEQ = "logId".hashCode();
    kER = "liftTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "logId";
    localMAutoDBInfo.colsMap.put("logId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" logId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "logId";
    localMAutoDBInfo.columns[1] = "liftTime";
    localMAutoDBInfo.colsMap.put("liftTime", "LONG");
    localStringBuilder.append(" liftTime LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.eq
 * JD-Core Version:    0.7.0.1
 */