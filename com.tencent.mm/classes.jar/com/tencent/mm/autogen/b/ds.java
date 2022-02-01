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

public abstract class ds
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameResourceDownload");
  private static final int createTime_HASHCODE;
  private static final int jKX;
  public static final Column jKp;
  private static final int jNX;
  public static final Column jNf;
  public static final Column kyV;
  public static final Column kyW;
  public static final Column kyX;
  public static final Column kyY;
  public static final Column kyZ;
  private static final int kzf;
  private static final int kzg;
  private static final int kzh;
  private static final int kzi;
  private static final int kzj;
  private static final StorageObserverOwner<ds> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public String field_appId;
  public long field_checkCgiTime;
  public long field_createTime;
  public byte[] field_downloadItemList;
  public int field_expiredSeconds;
  public long field_finishDownloadTime;
  public int field_intervalSeconds;
  public String field_packageName;
  private boolean jKG = true;
  private boolean jNB = true;
  private boolean kza = true;
  private boolean kzb = true;
  private boolean kzc = true;
  private boolean kzd = true;
  private boolean kze = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jNf = new Column("packageName", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kyV = new Column("intervalSeconds", "int", TABLE.getName(), "");
    kyW = new Column("expiredSeconds", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    kyX = new Column("checkCgiTime", "long", TABLE.getName(), "");
    kyY = new Column("finishDownloadTime", "long", TABLE.getName(), "");
    kyZ = new Column("downloadItemList", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jNX = "packageName".hashCode();
    jKX = "appId".hashCode();
    kzf = "intervalSeconds".hashCode();
    kzg = "expiredSeconds".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kzh = "checkCgiTime".hashCode();
    kzi = "finishDownloadTime".hashCode();
    kzj = "downloadItemList".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "packageName";
    localMAutoDBInfo.colsMap.put("packageName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" packageName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "packageName";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "intervalSeconds";
    localMAutoDBInfo.colsMap.put("intervalSeconds", "INTEGER");
    localStringBuilder.append(" intervalSeconds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "expiredSeconds";
    localMAutoDBInfo.colsMap.put("expiredSeconds", "INTEGER");
    localStringBuilder.append(" expiredSeconds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "checkCgiTime";
    localMAutoDBInfo.colsMap.put("checkCgiTime", "LONG");
    localStringBuilder.append(" checkCgiTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "finishDownloadTime";
    localMAutoDBInfo.colsMap.put("finishDownloadTime", "LONG");
    localStringBuilder.append(" finishDownloadTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "downloadItemList";
    localMAutoDBInfo.colsMap.put("downloadItemList", "BLOB");
    localStringBuilder.append(" downloadItemList BLOB");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("packageName"))
    {
      this.field_packageName = paramContentValues.getAsString("packageName");
      if (paramBoolean) {
        this.jNB = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("intervalSeconds"))
    {
      this.field_intervalSeconds = paramContentValues.getAsInteger("intervalSeconds").intValue();
      if (paramBoolean) {
        this.kza = true;
      }
    }
    if (paramContentValues.containsKey("expiredSeconds"))
    {
      this.field_expiredSeconds = paramContentValues.getAsInteger("expiredSeconds").intValue();
      if (paramBoolean) {
        this.kzb = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("checkCgiTime"))
    {
      this.field_checkCgiTime = paramContentValues.getAsLong("checkCgiTime").longValue();
      if (paramBoolean) {
        this.kzc = true;
      }
    }
    if (paramContentValues.containsKey("finishDownloadTime"))
    {
      this.field_finishDownloadTime = paramContentValues.getAsLong("finishDownloadTime").longValue();
      if (paramBoolean) {
        this.kzd = true;
      }
    }
    if (paramContentValues.containsKey("downloadItemList"))
    {
      this.field_downloadItemList = paramContentValues.getAsByteArray("downloadItemList");
      if (paramBoolean) {
        this.kze = true;
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
      if (jNX != k) {
        break label65;
      }
      this.field_packageName = paramCursor.getString(i);
      this.jNB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (kzf == k) {
        this.field_intervalSeconds = paramCursor.getInt(i);
      } else if (kzg == k) {
        this.field_expiredSeconds = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (kzh == k) {
        this.field_checkCgiTime = paramCursor.getLong(i);
      } else if (kzi == k) {
        this.field_finishDownloadTime = paramCursor.getLong(i);
      } else if (kzj == k) {
        this.field_downloadItemList = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jNB) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.kza) {
      localContentValues.put("intervalSeconds", Integer.valueOf(this.field_intervalSeconds));
    }
    if (this.kzb) {
      localContentValues.put("expiredSeconds", Integer.valueOf(this.field_expiredSeconds));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.kzc) {
      localContentValues.put("checkCgiTime", Long.valueOf(this.field_checkCgiTime));
    }
    if (this.kzd) {
      localContentValues.put("finishDownloadTime", Long.valueOf(this.field_finishDownloadTime));
    }
    if (this.kze) {
      localContentValues.put("downloadItemList", this.field_downloadItemList);
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
  
  public StorageObserverOwner<? extends ds> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_packageName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ds
 * JD-Core Version:    0.7.0.1
 */