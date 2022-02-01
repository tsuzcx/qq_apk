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

public abstract class cp
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveChargeInfo");
  public static final Column krn;
  public static final Column kro;
  public static final Column krp;
  public static final Column krq;
  private static final int krv;
  private static final int krw;
  private static final int krx;
  private static final int kry;
  private static final StorageObserverOwner<cp> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_freeTimeForLive;
  public int field_freeTimeForReplay;
  public long field_liveId;
  public int field_payForLive;
  private boolean krr = true;
  private boolean krs = true;
  private boolean krt = true;
  private boolean kru = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krn = new Column("liveId", "long", TABLE.getName(), "");
    kro = new Column("freeTimeForLive", "int", TABLE.getName(), "");
    krp = new Column("freeTimeForReplay", "int", TABLE.getName(), "");
    krq = new Column("payForLive", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    krv = "liveId".hashCode();
    krw = "freeTimeForLive".hashCode();
    krx = "freeTimeForReplay".hashCode();
    kry = "payForLive".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "liveId";
    localMAutoDBInfo.colsMap.put("liveId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" liveId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "liveId";
    localMAutoDBInfo.columns[1] = "freeTimeForLive";
    localMAutoDBInfo.colsMap.put("freeTimeForLive", "INTEGER");
    localStringBuilder.append(" freeTimeForLive INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "freeTimeForReplay";
    localMAutoDBInfo.colsMap.put("freeTimeForReplay", "INTEGER");
    localStringBuilder.append(" freeTimeForReplay INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "payForLive";
    localMAutoDBInfo.colsMap.put("payForLive", "INTEGER");
    localStringBuilder.append(" payForLive INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("liveId"))
    {
      this.field_liveId = paramContentValues.getAsLong("liveId").longValue();
      if (paramBoolean) {
        this.krr = true;
      }
    }
    if (paramContentValues.containsKey("freeTimeForLive"))
    {
      this.field_freeTimeForLive = paramContentValues.getAsInteger("freeTimeForLive").intValue();
      if (paramBoolean) {
        this.krs = true;
      }
    }
    if (paramContentValues.containsKey("freeTimeForReplay"))
    {
      this.field_freeTimeForReplay = paramContentValues.getAsInteger("freeTimeForReplay").intValue();
      if (paramBoolean) {
        this.krt = true;
      }
    }
    if (paramContentValues.containsKey("payForLive"))
    {
      this.field_payForLive = paramContentValues.getAsInteger("payForLive").intValue();
      if (paramBoolean) {
        this.kru = true;
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
      if (krv != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.krr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (krw == k) {
        this.field_freeTimeForLive = paramCursor.getInt(i);
      } else if (krx == k) {
        this.field_freeTimeForReplay = paramCursor.getInt(i);
      } else if (kry == k) {
        this.field_payForLive = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krr) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.krs) {
      localContentValues.put("freeTimeForLive", Integer.valueOf(this.field_freeTimeForLive));
    }
    if (this.krt) {
      localContentValues.put("freeTimeForReplay", Integer.valueOf(this.field_freeTimeForReplay));
    }
    if (this.kru) {
      localContentValues.put("payForLive", Integer.valueOf(this.field_payForLive));
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
  
  public StorageObserverOwner<? extends cp> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_liveId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.cp
 * JD-Core Version:    0.7.0.1
 */