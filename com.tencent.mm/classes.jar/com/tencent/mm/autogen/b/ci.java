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

public abstract class ci
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("FinderConsumeNewXmlData");
  public static final Column TYPE;
  private static final int createTime_HASHCODE;
  public static final Column kmU;
  public static final Column kmV;
  private static final int kmY;
  private static final int kmZ;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<ci> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSetsubType = true;
  private boolean __hadSettype = true;
  public long field_createTime;
  public String field_localId;
  public int field_pendingReason;
  public String field_subType;
  public int field_type;
  public String field_valuesJSON;
  private boolean kmW = true;
  private boolean kmX = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "string", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "string", TABLE.getName(), "");
    kmU = new Column("valuesJSON", "string", TABLE.getName(), "");
    kmV = new Column("pendingReason", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    localId_HASHCODE = "localId".hashCode();
    subType_HASHCODE = "subType".hashCode();
    kmY = "valuesJSON".hashCode();
    kmZ = "pendingReason".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    type_HASHCODE = "type".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "TEXT");
    localStringBuilder.append(" localId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "subType";
    localMAutoDBInfo.colsMap.put("subType", "TEXT default '' ");
    localStringBuilder.append(" subType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "valuesJSON";
    localMAutoDBInfo.colsMap.put("valuesJSON", "TEXT default '[object Object]' ");
    localStringBuilder.append(" valuesJSON TEXT default '[object Object]' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "pendingReason";
    localMAutoDBInfo.colsMap.put("pendingReason", "INTEGER");
    localStringBuilder.append(" pendingReason INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsString("localId");
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsString("subType");
      if (paramBoolean) {
        this.__hadSetsubType = true;
      }
    }
    if (paramContentValues.containsKey("valuesJSON"))
    {
      this.field_valuesJSON = paramContentValues.getAsString("valuesJSON");
      if (paramBoolean) {
        this.kmW = true;
      }
    }
    if (paramContentValues.containsKey("pendingReason"))
    {
      this.field_pendingReason = paramContentValues.getAsInteger("pendingReason").intValue();
      if (paramBoolean) {
        this.kmX = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
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
      if (localId_HASHCODE != k) {
        break label60;
      }
      this.field_localId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getString(i);
      } else if (kmY == k) {
        this.field_valuesJSON = paramCursor.getString(i);
      } else if (kmZ == k) {
        this.field_pendingReason = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.field_subType == null) {
      this.field_subType = "";
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", this.field_subType);
    }
    if (this.field_valuesJSON == null) {
      this.field_valuesJSON = "[object Object]";
    }
    if (this.kmW) {
      localContentValues.put("valuesJSON", this.field_valuesJSON);
    }
    if (this.kmX) {
      localContentValues.put("pendingReason", Integer.valueOf(this.field_pendingReason));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
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
  
  public StorageObserverOwner<? extends ci> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ci
 * JD-Core Version:    0.7.0.1
 */