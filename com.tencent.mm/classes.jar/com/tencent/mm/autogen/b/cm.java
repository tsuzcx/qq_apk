package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cm
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALFLAG;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderDraftItem");
  private static final int createTime_HASHCODE;
  private static final int jMG;
  public static final Column jMw;
  public static final Column kpD;
  public static final Column kpQ;
  private static final int kqM;
  public static final Column kqV;
  public static final Column kqW;
  public static final Column kqX;
  public static final Column kqY;
  public static final Column kqZ;
  private static final int kqy;
  private static final int krf;
  private static final int krg;
  private static final int krh;
  private static final int kri;
  private static final int krj;
  private static final int localFlag_HASHCODE;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<cm> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalId = true;
  public int field_createTime;
  public int field_dbversion;
  public bby field_finderItem;
  public int field_localFlag;
  public long field_localId;
  public int field_markDeleted;
  public long field_objectId;
  public int field_objectType;
  public bol field_originMvInfo;
  public String field_postIntent;
  public int field_version;
  private boolean jMB = true;
  private boolean kqa = true;
  private boolean kqo = true;
  private boolean kra = true;
  private boolean krb = true;
  private boolean krc = true;
  private boolean krd = true;
  private boolean kre = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    LOCALFLAG = new Column("localFlag", "int", TABLE.getName(), "");
    kqV = new Column("finderItem", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderItemPb");
    kpQ = new Column("objectType", "int", TABLE.getName(), "");
    kqW = new Column("postIntent", "string", TABLE.getName(), "");
    kqX = new Column("originMvInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderMVInfo");
    kpD = new Column("objectId", "long", TABLE.getName(), "");
    kqY = new Column("markDeleted", "int", TABLE.getName(), "");
    jMw = new Column("version", "int", TABLE.getName(), "");
    kqZ = new Column("dbversion", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderDraftItem_local_index ON FinderDraftItem(localId)", "CREATE INDEX IF NOT EXISTS FinderDraftItem_create_time ON FinderDraftItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Local_Flag ON FinderDraftItem(localFlag)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Object_Type ON FinderDraftItem(objectType)", "CREATE INDEX IF NOT EXISTS FinderDraftItem_svr_index ON FinderDraftItem(objectId)" };
    localId_HASHCODE = "localId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
    krf = "finderItem".hashCode();
    kqM = "objectType".hashCode();
    krg = "postIntent".hashCode();
    krh = "originMvInfo".hashCode();
    kqy = "objectId".hashCode();
    kri = "markDeleted".hashCode();
    jMG = "version".hashCode();
    krj = "dbversion".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "localFlag";
    localMAutoDBInfo.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "finderItem";
    localMAutoDBInfo.colsMap.put("finderItem", "BLOB");
    localStringBuilder.append(" finderItem BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "objectType";
    localMAutoDBInfo.colsMap.put("objectType", "INTEGER");
    localStringBuilder.append(" objectType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "postIntent";
    localMAutoDBInfo.colsMap.put("postIntent", "TEXT");
    localStringBuilder.append(" postIntent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "originMvInfo";
    localMAutoDBInfo.colsMap.put("originMvInfo", "BLOB");
    localStringBuilder.append(" originMvInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "objectId";
    localMAutoDBInfo.colsMap.put("objectId", "LONG default '0' ");
    localStringBuilder.append(" objectId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "markDeleted";
    localMAutoDBInfo.colsMap.put("markDeleted", "INTEGER default '0' ");
    localStringBuilder.append(" markDeleted INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "version";
    localMAutoDBInfo.colsMap.put("version", "INTEGER default '0' ");
    localStringBuilder.append(" version INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "dbversion";
    localMAutoDBInfo.colsMap.put("dbversion", "INTEGER default '0' ");
    localStringBuilder.append(" dbversion INTEGER default '0' ");
    localMAutoDBInfo.columns[11] = "rowid";
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
      this.field_localId = paramContentValues.getAsLong("localId").longValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("localFlag"))
    {
      this.field_localFlag = paramContentValues.getAsInteger("localFlag").intValue();
      if (paramBoolean) {
        this.__hadSetlocalFlag = true;
      }
    }
    if (paramContentValues.containsKey("finderItem")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("finderItem");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_finderItem = ((bby)new bby().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kra = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("objectType"))
    {
      this.field_objectType = paramContentValues.getAsInteger("objectType").intValue();
      if (paramBoolean) {
        this.kqo = true;
      }
    }
    if (paramContentValues.containsKey("postIntent"))
    {
      this.field_postIntent = paramContentValues.getAsString("postIntent");
      if (paramBoolean) {
        this.krb = true;
      }
    }
    if (paramContentValues.containsKey("originMvInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("originMvInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_originMvInfo = ((bol)new bol().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.krc = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("objectId"))
    {
      this.field_objectId = paramContentValues.getAsLong("objectId").longValue();
      if (paramBoolean) {
        this.kqa = true;
      }
    }
    if (paramContentValues.containsKey("markDeleted"))
    {
      this.field_markDeleted = paramContentValues.getAsInteger("markDeleted").intValue();
      if (paramBoolean) {
        this.krd = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsInteger("version").intValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("dbversion"))
    {
      this.field_dbversion = paramContentValues.getAsInteger("dbversion").intValue();
      if (paramBoolean) {
        this.kre = true;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (krf == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_finderItem = ((bby)new bby().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
        }
      } else if (kqM == k) {
        this.field_objectType = paramCursor.getInt(i);
      } else if (krg == k) {
        this.field_postIntent = paramCursor.getString(i);
      } else if (krh == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_originMvInfo = ((bol)new bol().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException2.getMessage());
        }
      } else if (kqy == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (kri == k) {
        this.field_markDeleted = paramCursor.getInt(i);
      } else if (jMG == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (krj == k) {
        this.field_dbversion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.__hadSetlocalFlag) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if ((this.kra) && (this.field_finderItem != null)) {}
    try
    {
      localContentValues.put("finderItem", this.field_finderItem.toByteArray());
      if (this.kqo) {
        localContentValues.put("objectType", Integer.valueOf(this.field_objectType));
      }
      if (this.krb) {
        localContentValues.put("postIntent", this.field_postIntent);
      }
      if ((!this.krc) || (this.field_originMvInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("originMvInfo", this.field_originMvInfo.toByteArray());
        if (this.kqa) {
          localContentValues.put("objectId", Long.valueOf(this.field_objectId));
        }
        if (this.krd) {
          localContentValues.put("markDeleted", Integer.valueOf(this.field_markDeleted));
        }
        if (this.jMB) {
          localContentValues.put("version", Integer.valueOf(this.field_version));
        }
        if (this.kre) {
          localContentValues.put("dbversion", Integer.valueOf(this.field_dbversion));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException2.getMessage());
        }
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
  
  public StorageObserverOwner<? extends cm> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cm
 * JD-Core Version:    0.7.0.1
 */