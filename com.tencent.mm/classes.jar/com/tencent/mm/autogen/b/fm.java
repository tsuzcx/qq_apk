package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bk.a;
import com.tencent.mm.kernel.mvvm.b;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public abstract class fm
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("MultiTaskInfo");
  public static final Column TYPE;
  public static final Column UPDATETIME;
  private static final int createTime_HASHCODE;
  private static final int id_HASHCODE;
  public static final Column jLt;
  private static final int jLz;
  public static final Column kMd;
  private static final int kMf;
  public static final b kMg = new b();
  private static final StorageObserverOwner<fm> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public long field_createTime;
  public byte[] field_data;
  public String field_id;
  public drz field_showData;
  public int field_type;
  public long field_updateTime;
  private boolean jLw = true;
  private boolean kMe = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ID = new Column("id", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kMd = new Column("showData", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.MultiTaskShowData");
    jLt = new Column("data", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    id_HASHCODE = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kMf = "showData".hashCode();
    jLz = "data".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "showData";
    localMAutoDBInfo.colsMap.put("showData", "BLOB");
    localStringBuilder.append(" showData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "data";
    localMAutoDBInfo.colsMap.put("data", "BLOB default '' ");
    localStringBuilder.append(" data BLOB default '' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsString("id");
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("showData")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("showData");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_showData = ((drz)new drz().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kMe = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseMultiTaskInfo", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("data"))
    {
      this.field_data = paramContentValues.getAsByteArray("data");
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kMf == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_showData = ((drz)new drz().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseMultiTaskInfo", localIOException.getMessage());
        }
      } else if (jLz == k) {
        this.field_data = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.kMe) && (this.field_showData != null)) {}
    try
    {
      localContentValues.put("showData", this.field_showData.toByteArray());
      if (this.jLw) {
        localContentValues.put("data", this.field_data);
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseMultiTaskInfo", localIOException.getMessage());
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends fm> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_id;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a.b(localJSONObject, "id", this.field_id);
      a.b(localJSONObject, "type", Integer.valueOf(this.field_type));
      a.b(localJSONObject, "createTime", Long.valueOf(this.field_createTime));
      a.b(localJSONObject, "updateTime", Long.valueOf(this.field_updateTime));
      a.b(localJSONObject, "showData", this.field_showData);
      a.b(localJSONObject, "data", this.field_data);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.fm
 * JD-Core Version:    0.7.0.1
 */