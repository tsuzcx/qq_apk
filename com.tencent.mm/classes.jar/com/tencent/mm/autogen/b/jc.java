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

public abstract class jc
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaAppidABTestInfo");
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLD;
  private static final int jLL;
  public static final Column jNm;
  private static final int jOe;
  public static final Column lou;
  private static final int low;
  private static final StorageObserverOwner<jc> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_appType;
  public byte[] field_permissionBytes;
  public int field_versionType;
  private boolean jKG = true;
  private boolean jLH = true;
  private boolean jNI = true;
  private boolean lov = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jNm = new Column("appType", "int", TABLE.getName(), "");
    jLD = new Column("versionType", "int", TABLE.getName(), "");
    lou = new Column("permissionBytes", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    jOe = "appType".hashCode();
    jLL = "versionType".hashCode();
    low = "permissionBytes".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appType";
    localMAutoDBInfo.colsMap.put("appType", "INTEGER");
    localStringBuilder.append(" appType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "versionType";
    localMAutoDBInfo.colsMap.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "permissionBytes";
    localMAutoDBInfo.colsMap.put("permissionBytes", "BLOB");
    localStringBuilder.append(" permissionBytes BLOB");
    localMAutoDBInfo.columns[4] = "rowid";
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
    if (paramContentValues.containsKey("appType"))
    {
      this.field_appType = paramContentValues.getAsInteger("appType").intValue();
      if (paramBoolean) {
        this.jNI = true;
      }
    }
    if (paramContentValues.containsKey("versionType"))
    {
      this.field_versionType = paramContentValues.getAsInteger("versionType").intValue();
      if (paramBoolean) {
        this.jLH = true;
      }
    }
    if (paramContentValues.containsKey("permissionBytes"))
    {
      this.field_permissionBytes = paramContentValues.getAsByteArray("permissionBytes");
      if (paramBoolean) {
        this.lov = true;
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
      if (jOe == k) {
        this.field_appType = paramCursor.getInt(i);
      } else if (jLL == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (low == k) {
        this.field_permissionBytes = paramCursor.getBlob(i);
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
    if (this.jNI) {
      localContentValues.put("appType", Integer.valueOf(this.field_appType));
    }
    if (this.jLH) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.lov) {
      localContentValues.put("permissionBytes", this.field_permissionBytes);
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
  
  public StorageObserverOwner<? extends jc> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.jc
 * JD-Core Version:    0.7.0.1
 */