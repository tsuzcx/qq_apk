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

public abstract class ea
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GroupSolitatire");
  public static final Column USERNAME;
  private static final int content_HASHCODE;
  public static final Column jTA;
  private static final int jUc;
  public static final Column kBh;
  public static final Column kBi;
  public static final Column kBj;
  public static final Column kBk;
  public static final Column kBl;
  private static final int kBr;
  private static final int kBs;
  private static final int kBt;
  private static final int kBu;
  private static final int kBv;
  private static final int key_HASHCODE;
  private static final StorageObserverOwner<ea> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetkey = true;
  private boolean __hadSetusername = true;
  public int field_active;
  public String field_content;
  public String field_creator;
  public long field_firstMsgId;
  public String field_key;
  public long field_lastActiveTime;
  public long field_msgSvrId;
  public int field_num;
  public String field_username;
  private boolean jTO = true;
  private boolean kBm = true;
  private boolean kBn = true;
  private boolean kBo = true;
  private boolean kBp = true;
  private boolean kBq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    kBh = new Column("creator", "string", TABLE.getName(), "");
    kBi = new Column("num", "int", TABLE.getName(), "");
    kBj = new Column("firstMsgId", "long", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    kBk = new Column("active", "int", TABLE.getName(), "");
    kBl = new Column("lastActiveTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    key_HASHCODE = "key".hashCode();
    content_HASHCODE = "content".hashCode();
    kBr = "creator".hashCode();
    kBs = "num".hashCode();
    kBt = "firstMsgId".hashCode();
    jUc = "msgSvrId".hashCode();
    kBu = "active".hashCode();
    kBv = "lastActiveTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "key";
    localMAutoDBInfo.colsMap.put("key", "TEXT");
    localStringBuilder.append(" key TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "creator";
    localMAutoDBInfo.colsMap.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "num";
    localMAutoDBInfo.colsMap.put("num", "INTEGER");
    localStringBuilder.append(" num INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "firstMsgId";
    localMAutoDBInfo.colsMap.put("firstMsgId", "LONG");
    localStringBuilder.append(" firstMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "active";
    localMAutoDBInfo.colsMap.put("active", "INTEGER default '-1' ");
    localStringBuilder.append(" active INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lastActiveTime";
    localMAutoDBInfo.colsMap.put("lastActiveTime", "LONG");
    localStringBuilder.append(" lastActiveTime LONG");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("creator"))
    {
      this.field_creator = paramContentValues.getAsString("creator");
      if (paramBoolean) {
        this.kBm = true;
      }
    }
    if (paramContentValues.containsKey("num"))
    {
      this.field_num = paramContentValues.getAsInteger("num").intValue();
      if (paramBoolean) {
        this.kBn = true;
      }
    }
    if (paramContentValues.containsKey("firstMsgId"))
    {
      this.field_firstMsgId = paramContentValues.getAsLong("firstMsgId").longValue();
      if (paramBoolean) {
        this.kBo = true;
      }
    }
    if (paramContentValues.containsKey("msgSvrId"))
    {
      this.field_msgSvrId = paramContentValues.getAsLong("msgSvrId").longValue();
      if (paramBoolean) {
        this.jTO = true;
      }
    }
    if (paramContentValues.containsKey("active"))
    {
      this.field_active = paramContentValues.getAsInteger("active").intValue();
      if (paramBoolean) {
        this.kBp = true;
      }
    }
    if (paramContentValues.containsKey("lastActiveTime"))
    {
      this.field_lastActiveTime = paramContentValues.getAsLong("lastActiveTime").longValue();
      if (paramBoolean) {
        this.kBq = true;
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
      if (username_HASHCODE != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (key_HASHCODE == k) {
        this.field_key = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kBr == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (kBs == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (kBt == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (jUc == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (kBu == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (kBv == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.kBm) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.kBn) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.kBo) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.jTO) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.kBp) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.kBq) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
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
  
  public StorageObserverOwner<? extends ea> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ea
 * JD-Core Version:    0.7.0.1
 */