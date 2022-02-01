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

public abstract class cu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveLuckyMoneyInfo");
  public static final Column krn;
  private static final int krv;
  public static final Column ksp;
  private static final int ksr;
  private static final StorageObserverOwner<cu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_liveId;
  public byte[] field_luckyMoneyData;
  private boolean krr = true;
  private boolean ksq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krn = new Column("liveId", "string", TABLE.getName(), "");
    ksp = new Column("luckyMoneyData", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    krv = "liveId".hashCode();
    ksr = "luckyMoneyData".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "liveId";
    localMAutoDBInfo.colsMap.put("liveId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" liveId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "liveId";
    localMAutoDBInfo.columns[1] = "luckyMoneyData";
    localMAutoDBInfo.colsMap.put("luckyMoneyData", "BLOB");
    localStringBuilder.append(" luckyMoneyData BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
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
      this.field_liveId = paramContentValues.getAsString("liveId");
      if (paramBoolean) {
        this.krr = true;
      }
    }
    if (paramContentValues.containsKey("luckyMoneyData"))
    {
      this.field_luckyMoneyData = paramContentValues.getAsByteArray("luckyMoneyData");
      if (paramBoolean) {
        this.ksq = true;
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
      this.field_liveId = paramCursor.getString(i);
      this.krr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ksr == k) {
        this.field_luckyMoneyData = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krr) {
      localContentValues.put("liveId", this.field_liveId);
    }
    if (this.ksq) {
      localContentValues.put("luckyMoneyData", this.field_luckyMoneyData);
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
  
  public StorageObserverOwner<? extends cu> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_liveId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.cu
 * JD-Core Version:    0.7.0.1
 */