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

public abstract class dx
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GetSysCmdMsgInfo");
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column jUA;
  public static final Column jUB;
  private static final int jUH;
  public static final Column jUz;
  public static final Column kAc;
  public static final Column kAd;
  public static final Column kAe;
  private static final int kAl;
  private static final int kAm;
  private static final int kAn;
  private static final int kAo;
  private static final int kAp;
  public static final Column keg;
  public static final Column keh;
  public static final Column kei;
  public static final Column kej;
  private static final int kfJ;
  private static final int kfK;
  private static final int kfL;
  private static final int kfM;
  private static final StorageObserverOwner<dx> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_fromUserName;
  public int field_msgSeq;
  public String field_msgSource;
  public long field_newMsgId;
  public long field_originSvrId;
  public int field_reserved1;
  public long field_reserved2;
  public String field_reserved3;
  public String field_reserved4;
  public String field_toUserName;
  private boolean jOX = true;
  private boolean kAf = true;
  private boolean kAg = true;
  private boolean kAh = true;
  private boolean kAi = true;
  private boolean kAj = true;
  private boolean kAk = true;
  private boolean keV = true;
  private boolean keW = true;
  private boolean keX = true;
  private boolean keY = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kAc = new Column("originSvrId", "long", TABLE.getName(), "");
    kAd = new Column("newMsgId", "long", TABLE.getName(), "");
    jUA = new Column("fromUserName", "string", TABLE.getName(), "");
    jUB = new Column("toUserName", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    kAe = new Column("msgSource", "string", TABLE.getName(), "");
    jUz = new Column("msgSeq", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    keg = new Column("reserved1", "int", TABLE.getName(), "");
    keh = new Column("reserved2", "long", TABLE.getName(), "");
    kei = new Column("reserved3", "string", TABLE.getName(), "");
    kej = new Column("reserved4", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kAl = "originSvrId".hashCode();
    kAm = "newMsgId".hashCode();
    kAn = "fromUserName".hashCode();
    kAo = "toUserName".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    content_HASHCODE = "content".hashCode();
    kAp = "msgSource".hashCode();
    jUH = "msgSeq".hashCode();
    jOZ = "flag".hashCode();
    kfJ = "reserved1".hashCode();
    kfK = "reserved2".hashCode();
    kfL = "reserved3".hashCode();
    kfM = "reserved4".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "originSvrId";
    localMAutoDBInfo.colsMap.put("originSvrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" originSvrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "originSvrId";
    localMAutoDBInfo.columns[1] = "newMsgId";
    localMAutoDBInfo.colsMap.put("newMsgId", "LONG");
    localStringBuilder.append(" newMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fromUserName";
    localMAutoDBInfo.colsMap.put("fromUserName", "TEXT default '' ");
    localStringBuilder.append(" fromUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "toUserName";
    localMAutoDBInfo.colsMap.put("toUserName", "TEXT default '' ");
    localStringBuilder.append(" toUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "msgSource";
    localMAutoDBInfo.colsMap.put("msgSource", "TEXT default '' ");
    localStringBuilder.append(" msgSource TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "msgSeq";
    localMAutoDBInfo.colsMap.put("msgSeq", "INTEGER");
    localStringBuilder.append(" msgSeq INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "LONG");
    localStringBuilder.append(" reserved2 LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "TEXT default '' ");
    localStringBuilder.append(" reserved3 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "TEXT default '' ");
    localStringBuilder.append(" reserved4 TEXT default '' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("originSvrId"))
    {
      this.field_originSvrId = paramContentValues.getAsLong("originSvrId").longValue();
      if (paramBoolean) {
        this.kAf = true;
      }
    }
    if (paramContentValues.containsKey("newMsgId"))
    {
      this.field_newMsgId = paramContentValues.getAsLong("newMsgId").longValue();
      if (paramBoolean) {
        this.kAg = true;
      }
    }
    if (paramContentValues.containsKey("fromUserName"))
    {
      this.field_fromUserName = paramContentValues.getAsString("fromUserName");
      if (paramBoolean) {
        this.kAh = true;
      }
    }
    if (paramContentValues.containsKey("toUserName"))
    {
      this.field_toUserName = paramContentValues.getAsString("toUserName");
      if (paramBoolean) {
        this.kAi = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("msgSource"))
    {
      this.field_msgSource = paramContentValues.getAsString("msgSource");
      if (paramBoolean) {
        this.kAj = true;
      }
    }
    if (paramContentValues.containsKey("msgSeq"))
    {
      this.field_msgSeq = paramContentValues.getAsInteger("msgSeq").intValue();
      if (paramBoolean) {
        this.kAk = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("reserved1"))
    {
      this.field_reserved1 = paramContentValues.getAsInteger("reserved1").intValue();
      if (paramBoolean) {
        this.keV = true;
      }
    }
    if (paramContentValues.containsKey("reserved2"))
    {
      this.field_reserved2 = paramContentValues.getAsLong("reserved2").longValue();
      if (paramBoolean) {
        this.keW = true;
      }
    }
    if (paramContentValues.containsKey("reserved3"))
    {
      this.field_reserved3 = paramContentValues.getAsString("reserved3");
      if (paramBoolean) {
        this.keX = true;
      }
    }
    if (paramContentValues.containsKey("reserved4"))
    {
      this.field_reserved4 = paramContentValues.getAsString("reserved4");
      if (paramBoolean) {
        this.keY = true;
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
      if (kAl != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.kAf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kAm == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (kAn == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (kAo == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kAp == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (jUH == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (kfJ == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (kfK == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (kfL == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (kfM == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kAf) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.kAg) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.kAh) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.kAi) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.kAj) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.kAk) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.keV) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.keW) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.keX) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.keY) {
      localContentValues.put("reserved4", this.field_reserved4);
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
  
  public StorageObserverOwner<? extends dx> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_originSvrId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.dx
 * JD-Core Version:    0.7.0.1
 */