package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bk.a;
import com.tencent.mm.protocal.protobuf.fq;
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

public abstract class fu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("OpenIMAppIdInfo");
  public static final Column UPDATETIME;
  public static final Column jKp;
  public static final Column kPR;
  public static final Column kPS;
  private static final int kPX;
  private static final int kPY;
  public static final Column kQa;
  private static final int kQd;
  private static final int kQe;
  private static final StorageObserverOwner<fu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetsubType = true;
  private boolean __hadSetupdateTime = true;
  public String field_acctTypeId;
  public fq field_appRec;
  public String field_appid;
  public String field_language;
  public int field_subType;
  public long field_updateTime;
  private boolean kPU = true;
  private boolean kPV = true;
  private boolean kQb = true;
  private boolean kQc = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appid", "string", TABLE.getName(), "");
    kPS = new Column("language", "string", TABLE.getName(), "");
    kQa = new Column("appRec", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.AppIdResource");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kPR = new Column("acctTypeId", "string", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kQd = "appid".hashCode();
    kPY = "language".hashCode();
    kQe = "appRec".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kPX = "acctTypeId".hashCode();
    subType_HASHCODE = "subType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appid";
    localMAutoDBInfo.colsMap.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "language";
    localMAutoDBInfo.colsMap.put("language", "TEXT");
    localStringBuilder.append(" language TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appRec";
    localMAutoDBInfo.colsMap.put("appRec", "BLOB");
    localStringBuilder.append(" appRec BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "acctTypeId";
    localMAutoDBInfo.colsMap.put("acctTypeId", "TEXT");
    localStringBuilder.append(" acctTypeId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "subType";
    localMAutoDBInfo.colsMap.put("subType", "INTEGER default '0' ");
    localStringBuilder.append(" subType INTEGER default '0' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  private JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a.b(localJSONObject, "appid", this.field_appid);
      a.b(localJSONObject, "language", this.field_language);
      a.b(localJSONObject, "appRec", this.field_appRec);
      a.b(localJSONObject, "updateTime", Long.valueOf(this.field_updateTime));
      a.b(localJSONObject, "acctTypeId", this.field_acctTypeId);
      a.b(localJSONObject, "subType", Integer.valueOf(this.field_subType));
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appid"))
    {
      this.field_appid = paramContentValues.getAsString("appid");
      if (paramBoolean) {
        this.kQb = true;
      }
    }
    if (paramContentValues.containsKey("language"))
    {
      this.field_language = paramContentValues.getAsString("language");
      if (paramBoolean) {
        this.kPV = true;
      }
    }
    if (paramContentValues.containsKey("appRec")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("appRec");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_appRec = ((fq)new fq().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kQc = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("acctTypeId"))
    {
      this.field_acctTypeId = paramContentValues.getAsString("acctTypeId");
      if (paramBoolean) {
        this.kPU = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsInteger("subType").intValue();
      if (paramBoolean) {
        this.__hadSetsubType = true;
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
      if (kQd != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kPY == k) {
        this.field_language = paramCursor.getString(i);
      } else if (kQe == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((fq)new fq().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kPX == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kQb) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.kPV) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.kQc) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.__hadSetupdateTime) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.kPU) {
        localContentValues.put("acctTypeId", this.field_acctTypeId);
      }
      if (this.__hadSetsubType) {
        localContentValues.put("subType", Integer.valueOf(this.field_subType));
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
        Log.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends fu> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fu
 * JD-Core Version:    0.7.0.1
 */