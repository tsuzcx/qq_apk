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

public abstract class hf
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SightDraftInfo");
  private static final int createTime_HASHCODE;
  public static final Column kXZ;
  public static final Column kYa;
  public static final Column kYb;
  public static final Column kYc;
  public static final Column kYd;
  private static final int kYj;
  private static final int kYk;
  private static final int kYl;
  private static final int kYm;
  private static final int kYn;
  public static final Column kkB;
  private static final int klJ;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<hf> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalId = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  private boolean kYe = true;
  private boolean kYf = true;
  private boolean kYg = true;
  private boolean kYh = true;
  private boolean kYi = true;
  private boolean klf = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "int", TABLE.getName(), "");
    kkB = new Column("fileName", "string", TABLE.getName(), "");
    kXZ = new Column("fileNameHash", "int", TABLE.getName(), "");
    kYa = new Column("fileMd5", "string", TABLE.getName(), "");
    kYb = new Column("fileLength", "long", TABLE.getName(), "");
    kYc = new Column("fileStatus", "int", TABLE.getName(), "");
    kYd = new Column("fileDuration", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
    localId_HASHCODE = "localId".hashCode();
    klJ = "fileName".hashCode();
    kYj = "fileNameHash".hashCode();
    kYk = "fileMd5".hashCode();
    kYl = "fileLength".hashCode();
    kYm = "fileStatus".hashCode();
    kYn = "fileDuration".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fileNameHash";
    localMAutoDBInfo.colsMap.put("fileNameHash", "INTEGER");
    localStringBuilder.append(" fileNameHash INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "fileMd5";
    localMAutoDBInfo.colsMap.put("fileMd5", "TEXT default '' ");
    localStringBuilder.append(" fileMd5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "fileLength";
    localMAutoDBInfo.colsMap.put("fileLength", "LONG default '0' ");
    localStringBuilder.append(" fileLength LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "fileStatus";
    localMAutoDBInfo.colsMap.put("fileStatus", "INTEGER default '0' ");
    localStringBuilder.append(" fileStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fileDuration";
    localMAutoDBInfo.colsMap.put("fileDuration", "INTEGER default '0' ");
    localStringBuilder.append(" fileDuration INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localMAutoDBInfo.columns[8] = "rowid";
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
      this.field_localId = paramContentValues.getAsInteger("localId").intValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("fileName"))
    {
      this.field_fileName = paramContentValues.getAsString("fileName");
      if (paramBoolean) {
        this.klf = true;
      }
    }
    if (paramContentValues.containsKey("fileNameHash"))
    {
      this.field_fileNameHash = paramContentValues.getAsInteger("fileNameHash").intValue();
      if (paramBoolean) {
        this.kYe = true;
      }
    }
    if (paramContentValues.containsKey("fileMd5"))
    {
      this.field_fileMd5 = paramContentValues.getAsString("fileMd5");
      if (paramBoolean) {
        this.kYf = true;
      }
    }
    if (paramContentValues.containsKey("fileLength"))
    {
      this.field_fileLength = paramContentValues.getAsLong("fileLength").longValue();
      if (paramBoolean) {
        this.kYg = true;
      }
    }
    if (paramContentValues.containsKey("fileStatus"))
    {
      this.field_fileStatus = paramContentValues.getAsInteger("fileStatus").intValue();
      if (paramBoolean) {
        this.kYh = true;
      }
    }
    if (paramContentValues.containsKey("fileDuration"))
    {
      this.field_fileDuration = paramContentValues.getAsInteger("fileDuration").intValue();
      if (paramBoolean) {
        this.kYi = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
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
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (klJ == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (kYj == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (kYk == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (kYl == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (kYm == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (kYn == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.klf) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.kYe) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.kYf) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.kYg) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.kYh) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.kYi) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
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
  
  public StorageObserverOwner<? extends hf> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_localId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hf
 * JD-Core Version:    0.7.0.1
 */