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

public abstract class fg
  extends IAutoDBItem
{
  public static final Column ATTRBUF;
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALFLAG;
  public static final Column POSTBUF;
  public static final Column ROWID;
  public static final Column SOURCETYPE;
  public static final SingleTable TABLE = new SingleTable("MMStoryInfo");
  public static final Column TYPE;
  public static final Column USERNAME;
  private static final int attrBuf_HASHCODE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int kKC;
  private static final int kKD;
  private static final int kKE;
  private static final int kKF;
  private static final int kKG;
  public static final Column kKs;
  public static final Column kKt;
  public static final Column kKu;
  public static final Column kKv;
  public static final Column kKw;
  private static final int localFlag_HASHCODE;
  private static final StorageObserverOwner<fg> observerOwner = new StorageObserverOwner();
  private static final int postBuf_HASHCODE;
  private static final int rowid_HASHCODE;
  private static final int sourceType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetattrBuf = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetpostBuf = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  public byte[] field_attrBuf;
  public int field_commentListCount;
  public byte[] field_content;
  public int field_createTime;
  public int field_favoriteTime;
  public int field_itemStoryFlag;
  public int field_localFlag;
  public byte[] field_postBuf;
  public int field_readCount;
  public int field_sourceType;
  public long field_storyID;
  public int field_type;
  public String field_userName;
  private boolean kKA = true;
  private boolean kKB = true;
  private boolean kKx = true;
  private boolean kKy = true;
  private boolean kKz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kKs = new Column("storyID", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    LOCALFLAG = new Column("localFlag", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    kKt = new Column("commentListCount", "int", TABLE.getName(), "");
    CONTENT = new Column("content", "byte[]", TABLE.getName(), "");
    ATTRBUF = new Column("attrBuf", "byte[]", TABLE.getName(), "");
    POSTBUF = new Column("postBuf", "byte[]", TABLE.getName(), "");
    SOURCETYPE = new Column("sourceType", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kKu = new Column("itemStoryFlag", "int", TABLE.getName(), "");
    kKv = new Column("readCount", "int", TABLE.getName(), "");
    kKw = new Column("favoriteTime", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
    kKC = "storyID".hashCode();
    userName_HASHCODE = "userName".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kKD = "commentListCount".hashCode();
    content_HASHCODE = "content".hashCode();
    attrBuf_HASHCODE = "attrBuf".hashCode();
    postBuf_HASHCODE = "postBuf".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
    kKE = "itemStoryFlag".hashCode();
    kKF = "readCount".hashCode();
    kKG = "favoriteTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyID";
    localMAutoDBInfo.colsMap.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "localFlag";
    localMAutoDBInfo.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "commentListCount";
    localMAutoDBInfo.colsMap.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "content";
    localMAutoDBInfo.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "attrBuf";
    localMAutoDBInfo.colsMap.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "postBuf";
    localMAutoDBInfo.colsMap.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sourceType";
    localMAutoDBInfo.colsMap.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "itemStoryFlag";
    localMAutoDBInfo.colsMap.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "readCount";
    localMAutoDBInfo.colsMap.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "favoriteTime";
    localMAutoDBInfo.colsMap.put("favoriteTime", "INTEGER");
    localStringBuilder.append(" favoriteTime INTEGER");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("storyID"))
    {
      this.field_storyID = paramContentValues.getAsLong("storyID").longValue();
      if (paramBoolean) {
        this.kKx = true;
      }
    }
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("localFlag"))
    {
      this.field_localFlag = paramContentValues.getAsInteger("localFlag").intValue();
      if (paramBoolean) {
        this.__hadSetlocalFlag = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("commentListCount"))
    {
      this.field_commentListCount = paramContentValues.getAsInteger("commentListCount").intValue();
      if (paramBoolean) {
        this.kKy = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsByteArray("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("attrBuf"))
    {
      this.field_attrBuf = paramContentValues.getAsByteArray("attrBuf");
      if (paramBoolean) {
        this.__hadSetattrBuf = true;
      }
    }
    if (paramContentValues.containsKey("postBuf"))
    {
      this.field_postBuf = paramContentValues.getAsByteArray("postBuf");
      if (paramBoolean) {
        this.__hadSetpostBuf = true;
      }
    }
    if (paramContentValues.containsKey("sourceType"))
    {
      this.field_sourceType = paramContentValues.getAsInteger("sourceType").intValue();
      if (paramBoolean) {
        this.__hadSetsourceType = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("itemStoryFlag"))
    {
      this.field_itemStoryFlag = paramContentValues.getAsInteger("itemStoryFlag").intValue();
      if (paramBoolean) {
        this.kKz = true;
      }
    }
    if (paramContentValues.containsKey("readCount"))
    {
      this.field_readCount = paramContentValues.getAsInteger("readCount").intValue();
      if (paramBoolean) {
        this.kKA = true;
      }
    }
    if (paramContentValues.containsKey("favoriteTime"))
    {
      this.field_favoriteTime = paramContentValues.getAsInteger("favoriteTime").intValue();
      if (paramBoolean) {
        this.kKB = true;
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
      if (kKC != k) {
        break label60;
      }
      this.field_storyID = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (kKD == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (attrBuf_HASHCODE == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (postBuf_HASHCODE == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kKE == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (kKF == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (kKG == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kKx) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.__hadSetlocalFlag) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.kKy) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetattrBuf) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.__hadSetpostBuf) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kKz) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.kKA) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.kKB) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
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
  
  public StorageObserverOwner<? extends fg> getObserverOwner()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.fg
 * JD-Core Version:    0.7.0.1
 */