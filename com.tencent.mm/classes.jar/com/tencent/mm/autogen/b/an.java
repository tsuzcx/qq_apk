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

public abstract class an
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizKF");
  public static final Column UPDATETIME;
  public static final Column jNn;
  private static final int jOf;
  public static final Column jPG;
  public static final Column jTj;
  public static final Column jTk;
  public static final Column jTl;
  private static final int jTq;
  private static final int jTr;
  private static final int jTs;
  private static final int jTt;
  private static final StorageObserverOwner<an> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  private boolean jNJ = true;
  private boolean jTm = true;
  private boolean jTn = true;
  private boolean jTo = true;
  private boolean jTp = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jNn = new Column("openId", "string", TABLE.getName(), "");
    jPG = new Column("brandUsername", "string", TABLE.getName(), "");
    jTj = new Column("headImgUrl", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    jTl = new Column("kfType", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jOf = "openId".hashCode();
    jTq = "brandUsername".hashCode();
    jTr = "headImgUrl".hashCode();
    jTs = "nickname".hashCode();
    jTt = "kfType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "openId";
    localMAutoDBInfo.colsMap.put("openId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "openId";
    localMAutoDBInfo.columns[1] = "brandUsername";
    localMAutoDBInfo.colsMap.put("brandUsername", "TEXT default '' ");
    localStringBuilder.append(" brandUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "headImgUrl";
    localMAutoDBInfo.colsMap.put("headImgUrl", "TEXT");
    localStringBuilder.append(" headImgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "kfType";
    localMAutoDBInfo.colsMap.put("kfType", "INTEGER");
    localStringBuilder.append(" kfType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("openId"))
    {
      this.field_openId = paramContentValues.getAsString("openId");
      if (paramBoolean) {
        this.jNJ = true;
      }
    }
    if (paramContentValues.containsKey("brandUsername"))
    {
      this.field_brandUsername = paramContentValues.getAsString("brandUsername");
      if (paramBoolean) {
        this.jTm = true;
      }
    }
    if (paramContentValues.containsKey("headImgUrl"))
    {
      this.field_headImgUrl = paramContentValues.getAsString("headImgUrl");
      if (paramBoolean) {
        this.jTn = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("kfType"))
    {
      this.field_kfType = paramContentValues.getAsInteger("kfType").intValue();
      if (paramBoolean) {
        this.jTp = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
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
      if (jOf != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.jNJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jTq == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (jTr == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (jTt == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jNJ) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.jTm) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.jTn) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.jTp) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
  
  public StorageObserverOwner<? extends an> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_openId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.an
 * JD-Core Version:    0.7.0.1
 */