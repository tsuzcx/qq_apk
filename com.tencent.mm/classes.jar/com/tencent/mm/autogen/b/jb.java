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

public abstract class jb
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaAppWebRenderingCacheAccessStatsTable");
  public static final Column UPDATETIME;
  private static final int jKX;
  public static final Column jKp;
  public static final Column lmZ;
  private static final int lnC;
  public static final Column loi;
  public static final Column loj;
  public static final Column lok;
  public static final Column lol;
  private static final int loq;
  private static final int lor;
  private static final int los;
  private static final int lot;
  private static final StorageObserverOwner<jb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  private boolean jKG = true;
  private boolean lno = true;
  private boolean lom = true;
  private boolean lon = true;
  private boolean loo = true;
  private boolean lop = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    loi = new Column("commLibVersionId", "string", TABLE.getName(), "");
    loj = new Column("appVersionId", "string", TABLE.getName(), "");
    lok = new Column("pageURL", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    lmZ = new Column("accessTime", "long", TABLE.getName(), "");
    lol = new Column("cacheFilePath", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    loq = "commLibVersionId".hashCode();
    lor = "appVersionId".hashCode();
    los = "pageURL".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    lnC = "accessTime".hashCode();
    lot = "cacheFilePath".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "commLibVersionId";
    localMAutoDBInfo.colsMap.put("commLibVersionId", "TEXT");
    localStringBuilder.append(" commLibVersionId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appVersionId";
    localMAutoDBInfo.colsMap.put("appVersionId", "TEXT");
    localStringBuilder.append(" appVersionId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pageURL";
    localMAutoDBInfo.colsMap.put("pageURL", "TEXT");
    localStringBuilder.append(" pageURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "accessTime";
    localMAutoDBInfo.colsMap.put("accessTime", "LONG");
    localStringBuilder.append(" accessTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "cacheFilePath";
    localMAutoDBInfo.colsMap.put("cacheFilePath", "TEXT");
    localStringBuilder.append(" cacheFilePath TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("commLibVersionId"))
    {
      this.field_commLibVersionId = paramContentValues.getAsString("commLibVersionId");
      if (paramBoolean) {
        this.lom = true;
      }
    }
    if (paramContentValues.containsKey("appVersionId"))
    {
      this.field_appVersionId = paramContentValues.getAsString("appVersionId");
      if (paramBoolean) {
        this.lon = true;
      }
    }
    if (paramContentValues.containsKey("pageURL"))
    {
      this.field_pageURL = paramContentValues.getAsString("pageURL");
      if (paramBoolean) {
        this.loo = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("accessTime"))
    {
      this.field_accessTime = paramContentValues.getAsLong("accessTime").longValue();
      if (paramBoolean) {
        this.lno = true;
      }
    }
    if (paramContentValues.containsKey("cacheFilePath"))
    {
      this.field_cacheFilePath = paramContentValues.getAsString("cacheFilePath");
      if (paramBoolean) {
        this.lop = true;
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
      if (jKX != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (loq == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (lor == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (los == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (lnC == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (lot == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.lom) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.lon) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.loo) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.lno) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.lop) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
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
  
  public StorageObserverOwner<? extends jb> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.jb
 * JD-Core Version:    0.7.0.1
 */