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

public abstract class ct
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveLastRewardInfo");
  public static final Column krn;
  private static final int krv;
  public static final Column ksm;
  private static final int kso;
  private static final StorageObserverOwner<ct> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_lastRewardInfo;
  public String field_liveId;
  private boolean krr = true;
  private boolean ksn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krn = new Column("liveId", "string", TABLE.getName(), "");
    ksm = new Column("lastRewardInfo", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderLiveLastRewardInfo_liveId_index ON FinderLiveLastRewardInfo(liveId)" };
    krv = "liveId".hashCode();
    kso = "lastRewardInfo".hashCode();
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
    localMAutoDBInfo.columns[1] = "lastRewardInfo";
    localMAutoDBInfo.colsMap.put("lastRewardInfo", "BLOB");
    localStringBuilder.append(" lastRewardInfo BLOB");
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
    if (paramContentValues.containsKey("lastRewardInfo"))
    {
      this.field_lastRewardInfo = paramContentValues.getAsByteArray("lastRewardInfo");
      if (paramBoolean) {
        this.ksn = true;
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
      if (kso == k) {
        this.field_lastRewardInfo = paramCursor.getBlob(i);
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
    if (this.ksn) {
      localContentValues.put("lastRewardInfo", this.field_lastRewardInfo);
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
  
  public StorageObserverOwner<? extends ct> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ct
 * JD-Core Version:    0.7.0.1
 */