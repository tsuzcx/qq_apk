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

public abstract class dl
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameHaowanPublishEdition");
  private static final int createTime_HASHCODE;
  public static final Column kpG;
  private static final int kqB;
  public static final Column kxA;
  public static final Column kxB;
  public static final Column kxC;
  public static final Column kxD;
  public static final Column kxE;
  public static final Column kxF;
  public static final Column kxG;
  public static final Column kxH;
  public static final Column kxI;
  private static final int kxT;
  private static final int kxU;
  private static final int kxV;
  private static final int kxW;
  private static final int kxX;
  private static final int kxY;
  private static final int kxZ;
  public static final Column kxg;
  private static final int kxw;
  public static final Column kxz;
  private static final int kya;
  private static final int kyb;
  private static final int kyc;
  private static final StorageObserverOwner<dl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public String field_BusinessData;
  public String field_bgMixTaskId;
  public boolean field_compressImg;
  public long field_createTime;
  public String field_localIdList;
  public String field_mediaList;
  public int field_mediaType;
  public int field_mixState;
  public int field_publishSource;
  public int field_publishState;
  public int field_sourceSceneId;
  public String field_taskId;
  public int field_uploadState;
  private boolean kqd = true;
  private boolean kxJ = true;
  private boolean kxK = true;
  private boolean kxL = true;
  private boolean kxM = true;
  private boolean kxN = true;
  private boolean kxO = true;
  private boolean kxP = true;
  private boolean kxQ = true;
  private boolean kxR = true;
  private boolean kxS = true;
  private boolean kxo = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kxz = new Column("taskId", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    kxA = new Column("publishSource", "int", TABLE.getName(), "");
    kpG = new Column("mediaType", "int", TABLE.getName(), "");
    kxB = new Column("localIdList", "string", TABLE.getName(), "");
    kxC = new Column("mediaList", "string", TABLE.getName(), "");
    kxD = new Column("BusinessData", "string", TABLE.getName(), "");
    kxg = new Column("uploadState", "int", TABLE.getName(), "");
    kxE = new Column("publishState", "int", TABLE.getName(), "");
    kxF = new Column("compressImg", "boolean", TABLE.getName(), "");
    kxG = new Column("mixState", "int", TABLE.getName(), "");
    kxH = new Column("bgMixTaskId", "string", TABLE.getName(), "");
    kxI = new Column("sourceSceneId", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kxT = "taskId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kxU = "publishSource".hashCode();
    kqB = "mediaType".hashCode();
    kxV = "localIdList".hashCode();
    kxW = "mediaList".hashCode();
    kxX = "BusinessData".hashCode();
    kxw = "uploadState".hashCode();
    kxY = "publishState".hashCode();
    kxZ = "compressImg".hashCode();
    kya = "mixState".hashCode();
    kyb = "bgMixTaskId".hashCode();
    kyc = "sourceSceneId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "taskId";
    localMAutoDBInfo.colsMap.put("taskId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" taskId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "taskId";
    localMAutoDBInfo.columns[1] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "publishSource";
    localMAutoDBInfo.colsMap.put("publishSource", "INTEGER");
    localStringBuilder.append(" publishSource INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mediaType";
    localMAutoDBInfo.colsMap.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "localIdList";
    localMAutoDBInfo.colsMap.put("localIdList", "TEXT");
    localStringBuilder.append(" localIdList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "mediaList";
    localMAutoDBInfo.colsMap.put("mediaList", "TEXT");
    localStringBuilder.append(" mediaList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "BusinessData";
    localMAutoDBInfo.colsMap.put("BusinessData", "TEXT");
    localStringBuilder.append(" BusinessData TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "uploadState";
    localMAutoDBInfo.colsMap.put("uploadState", "INTEGER default '0' ");
    localStringBuilder.append(" uploadState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "publishState";
    localMAutoDBInfo.colsMap.put("publishState", "INTEGER default '0' ");
    localStringBuilder.append(" publishState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "compressImg";
    localMAutoDBInfo.colsMap.put("compressImg", "INTEGER default 'true' ");
    localStringBuilder.append(" compressImg INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "mixState";
    localMAutoDBInfo.colsMap.put("mixState", "INTEGER default '0' ");
    localStringBuilder.append(" mixState INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "bgMixTaskId";
    localMAutoDBInfo.colsMap.put("bgMixTaskId", "TEXT");
    localStringBuilder.append(" bgMixTaskId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "sourceSceneId";
    localMAutoDBInfo.colsMap.put("sourceSceneId", "INTEGER default '0' ");
    localStringBuilder.append(" sourceSceneId INTEGER default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("taskId"))
    {
      this.field_taskId = paramContentValues.getAsString("taskId");
      if (paramBoolean) {
        this.kxJ = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("publishSource"))
    {
      this.field_publishSource = paramContentValues.getAsInteger("publishSource").intValue();
      if (paramBoolean) {
        this.kxK = true;
      }
    }
    if (paramContentValues.containsKey("mediaType"))
    {
      this.field_mediaType = paramContentValues.getAsInteger("mediaType").intValue();
      if (paramBoolean) {
        this.kqd = true;
      }
    }
    if (paramContentValues.containsKey("localIdList"))
    {
      this.field_localIdList = paramContentValues.getAsString("localIdList");
      if (paramBoolean) {
        this.kxL = true;
      }
    }
    if (paramContentValues.containsKey("mediaList"))
    {
      this.field_mediaList = paramContentValues.getAsString("mediaList");
      if (paramBoolean) {
        this.kxM = true;
      }
    }
    if (paramContentValues.containsKey("BusinessData"))
    {
      this.field_BusinessData = paramContentValues.getAsString("BusinessData");
      if (paramBoolean) {
        this.kxN = true;
      }
    }
    if (paramContentValues.containsKey("uploadState"))
    {
      this.field_uploadState = paramContentValues.getAsInteger("uploadState").intValue();
      if (paramBoolean) {
        this.kxo = true;
      }
    }
    if (paramContentValues.containsKey("publishState"))
    {
      this.field_publishState = paramContentValues.getAsInteger("publishState").intValue();
      if (paramBoolean) {
        this.kxO = true;
      }
    }
    if (paramContentValues.containsKey("compressImg")) {
      if (paramContentValues.getAsInteger("compressImg").intValue() == 0) {
        break label417;
      }
    }
    label417:
    for (boolean bool = true;; bool = false)
    {
      this.field_compressImg = bool;
      if (paramBoolean) {
        this.kxP = true;
      }
      if (paramContentValues.containsKey("mixState"))
      {
        this.field_mixState = paramContentValues.getAsInteger("mixState").intValue();
        if (paramBoolean) {
          this.kxQ = true;
        }
      }
      if (paramContentValues.containsKey("bgMixTaskId"))
      {
        this.field_bgMixTaskId = paramContentValues.getAsString("bgMixTaskId");
        if (paramBoolean) {
          this.kxR = true;
        }
      }
      if (paramContentValues.containsKey("sourceSceneId"))
      {
        this.field_sourceSceneId = paramContentValues.getAsInteger("sourceSceneId").intValue();
        if (paramBoolean) {
          this.kxS = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
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
      if (kxT != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.kxJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (kxU == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (kqB == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (kxV == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (kxW == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (kxX == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (kxw == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (kxY == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (kxZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (kya == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (kyb == k) {
          this.field_bgMixTaskId = paramCursor.getString(i);
        } else if (kyc == k) {
          this.field_sourceSceneId = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kxJ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.kxK) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.kqd) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.kxL) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.kxM) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.kxN) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.kxo) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.kxO) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.kxP) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.kxQ) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.kxR) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.kxS) {
      localContentValues.put("sourceSceneId", Integer.valueOf(this.field_sourceSceneId));
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
  
  public StorageObserverOwner<? extends dl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_taskId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dl
 * JD-Core Version:    0.7.0.1
 */