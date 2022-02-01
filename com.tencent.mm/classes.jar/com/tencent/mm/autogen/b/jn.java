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

public abstract class jn
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxagGameInfo");
  public static final Column USERNAME;
  private static final int createTime_HASHCODE;
  public static final Column jKp;
  public static final Column jLV;
  private static final int jMJ;
  public static final Column jMz;
  public static final Column jNa;
  public static final Column kDT;
  private static final int kvf;
  public static final Column lpX;
  public static final Column lpY;
  private static final int lpZ;
  private static final int lqa;
  private static final int lqb;
  private static final int lqc;
  private static final int lqd;
  private static final int lqe;
  private static final StorageObserverOwner<jn> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_AppId;
  public String field_AppName;
  public String field_BriefIntro;
  public String field_IconUrl;
  public String field_RecordId;
  public String field_UserName;
  public long field_createTime;
  public int field_debugType;
  public boolean field_isSync;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jLV = new Column("RecordId", "string", TABLE.getName(), "");
    jKp = new Column("AppId", "string", TABLE.getName(), "");
    jNa = new Column("AppName", "string", TABLE.getName(), "");
    USERNAME = new Column("UserName", "string", TABLE.getName(), "");
    kDT = new Column("IconUrl", "string", TABLE.getName(), "");
    lpX = new Column("BriefIntro", "string", TABLE.getName(), "");
    lpY = new Column("isSync", "boolean", TABLE.getName(), "");
    jMz = new Column("debugType", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lpZ = "RecordId".hashCode();
    lqa = "AppId".hashCode();
    lqb = "AppName".hashCode();
    kvf = "UserName".hashCode();
    lqc = "IconUrl".hashCode();
    lqd = "BriefIntro".hashCode();
    lqe = "isSync".hashCode();
    jMJ = "debugType".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "RecordId";
    localMAutoDBInfo.colsMap.put("RecordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" RecordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "RecordId";
    localMAutoDBInfo.columns[1] = "AppId";
    localMAutoDBInfo.colsMap.put("AppId", "TEXT");
    localStringBuilder.append(" AppId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "AppName";
    localMAutoDBInfo.colsMap.put("AppName", "TEXT");
    localStringBuilder.append(" AppName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "UserName";
    localMAutoDBInfo.colsMap.put("UserName", "TEXT");
    localStringBuilder.append(" UserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "IconUrl";
    localMAutoDBInfo.colsMap.put("IconUrl", "TEXT");
    localStringBuilder.append(" IconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "BriefIntro";
    localMAutoDBInfo.colsMap.put("BriefIntro", "TEXT");
    localStringBuilder.append(" BriefIntro TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isSync";
    localMAutoDBInfo.colsMap.put("isSync", "INTEGER default 'false' ");
    localStringBuilder.append(" isSync INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "debugType";
    localMAutoDBInfo.colsMap.put("debugType", "INTEGER");
    localStringBuilder.append(" debugType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("RecordId"))
    {
      paramContentValues.getAsString("RecordId");
      throw null;
    }
    if (paramContentValues.containsKey("AppId"))
    {
      paramContentValues.getAsString("AppId");
      throw null;
    }
    if (paramContentValues.containsKey("AppName"))
    {
      paramContentValues.getAsString("AppName");
      throw null;
    }
    if (paramContentValues.containsKey("UserName"))
    {
      paramContentValues.getAsString("UserName");
      throw null;
    }
    if (paramContentValues.containsKey("IconUrl"))
    {
      paramContentValues.getAsString("IconUrl");
      throw null;
    }
    if (paramContentValues.containsKey("BriefIntro"))
    {
      paramContentValues.getAsString("BriefIntro");
      throw null;
    }
    if (paramContentValues.containsKey("isSync"))
    {
      paramContentValues.getAsInteger("isSync").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("debugType"))
    {
      paramContentValues.getAsInteger("debugType").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("createTime"))
    {
      paramContentValues.getAsLong("createTime").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (lpZ == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (lqa == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (lqb == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (kvf == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (lqc == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (lqd == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (lqe == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jMJ == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (createTime_HASHCODE == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends jn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    throw null;
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
 * Qualified Name:     com.tencent.mm.autogen.b.jn
 * JD-Core Version:    0.7.0.1
 */