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

public abstract class bw
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("fmessage_conversation");
  public static final Column jTB;
  private static final int jUd;
  public static final Column jWT;
  public static final Column kee;
  private static final int kfH;
  public static final Column khA;
  public static final Column khB;
  public static final Column khC;
  public static final Column khD;
  public static final Column khE;
  public static final Column khF;
  private static final int khV;
  private static final int khW;
  private static final int khX;
  private static final int khY;
  private static final int khZ;
  public static final Column khs;
  public static final Column kht;
  public static final Column khu;
  public static final Column khv;
  public static final Column khw;
  public static final Column khx;
  public static final Column khy;
  public static final Column khz;
  private static final int kia;
  private static final int kib;
  private static final int kic;
  private static final int kid;
  private static final int kie;
  private static final int kif;
  private static final int kig;
  private static final int kih;
  private static final int kii;
  private static final int kij;
  private static final StorageObserverOwner<bw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_addScene;
  public String field_contentFromUsername;
  public String field_contentFullPhoneNumMD5;
  public String field_contentNickname;
  public String field_contentPhoneNumMD5;
  public String field_contentVerifyContent;
  public String field_displayName;
  public String field_encryptTalker;
  public String field_fmsgContent;
  public int field_fmsgIsSend;
  public long field_fmsgSysRowId;
  public int field_fmsgType;
  public int field_isNew;
  public long field_lastModifiedTime;
  public int field_recvFmsgType;
  public int field_state;
  public String field_talker;
  private boolean jTP = true;
  private boolean keT = true;
  private boolean khG = true;
  private boolean khH = true;
  private boolean khI = true;
  private boolean khJ = true;
  private boolean khK = true;
  private boolean khL = true;
  private boolean khM = true;
  private boolean khN = true;
  private boolean khO = true;
  private boolean khP = true;
  private boolean khQ = true;
  private boolean khR = true;
  private boolean khS = true;
  private boolean khT = true;
  private boolean khU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    khs = new Column("encryptTalker", "string", TABLE.getName(), "");
    jWT = new Column("displayName", "string", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kht = new Column("lastModifiedTime", "long", TABLE.getName(), "");
    khu = new Column("isNew", "int", TABLE.getName(), "");
    khv = new Column("addScene", "int", TABLE.getName(), "");
    khw = new Column("fmsgSysRowId", "long", TABLE.getName(), "");
    khx = new Column("fmsgIsSend", "int", TABLE.getName(), "");
    khy = new Column("fmsgType", "int", TABLE.getName(), "");
    khz = new Column("fmsgContent", "string", TABLE.getName(), "");
    khA = new Column("recvFmsgType", "int", TABLE.getName(), "");
    khB = new Column("contentFromUsername", "string", TABLE.getName(), "");
    khC = new Column("contentNickname", "string", TABLE.getName(), "");
    khD = new Column("contentPhoneNumMD5", "string", TABLE.getName(), "");
    khE = new Column("contentFullPhoneNumMD5", "string", TABLE.getName(), "");
    khF = new Column("contentVerifyContent", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
    jUd = "talker".hashCode();
    khV = "encryptTalker".hashCode();
    khW = "displayName".hashCode();
    kfH = "state".hashCode();
    khX = "lastModifiedTime".hashCode();
    khY = "isNew".hashCode();
    khZ = "addScene".hashCode();
    kia = "fmsgSysRowId".hashCode();
    kib = "fmsgIsSend".hashCode();
    kic = "fmsgType".hashCode();
    kid = "fmsgContent".hashCode();
    kie = "recvFmsgType".hashCode();
    kif = "contentFromUsername".hashCode();
    kig = "contentNickname".hashCode();
    kih = "contentPhoneNumMD5".hashCode();
    kii = "contentFullPhoneNumMD5".hashCode();
    kij = "contentVerifyContent".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(" talker TEXT default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "talker";
    localMAutoDBInfo.columns[1] = "encryptTalker";
    localMAutoDBInfo.colsMap.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "displayName";
    localMAutoDBInfo.colsMap.put("displayName", "TEXT default '' ");
    localStringBuilder.append(" displayName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "lastModifiedTime";
    localMAutoDBInfo.colsMap.put("lastModifiedTime", "LONG default '0' ");
    localStringBuilder.append(" lastModifiedTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isNew";
    localMAutoDBInfo.colsMap.put("isNew", "INTEGER default '0' ");
    localStringBuilder.append(" isNew INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "addScene";
    localMAutoDBInfo.colsMap.put("addScene", "INTEGER default '0' ");
    localStringBuilder.append(" addScene INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "fmsgSysRowId";
    localMAutoDBInfo.colsMap.put("fmsgSysRowId", "LONG default '0' ");
    localStringBuilder.append(" fmsgSysRowId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "fmsgIsSend";
    localMAutoDBInfo.colsMap.put("fmsgIsSend", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgIsSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "fmsgType";
    localMAutoDBInfo.colsMap.put("fmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" fmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "fmsgContent";
    localMAutoDBInfo.colsMap.put("fmsgContent", "TEXT default '' ");
    localStringBuilder.append(" fmsgContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "recvFmsgType";
    localMAutoDBInfo.colsMap.put("recvFmsgType", "INTEGER default '0' ");
    localStringBuilder.append(" recvFmsgType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "contentFromUsername";
    localMAutoDBInfo.colsMap.put("contentFromUsername", "TEXT default '' ");
    localStringBuilder.append(" contentFromUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "contentNickname";
    localMAutoDBInfo.colsMap.put("contentNickname", "TEXT default '' ");
    localStringBuilder.append(" contentNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "contentPhoneNumMD5";
    localMAutoDBInfo.colsMap.put("contentPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "contentFullPhoneNumMD5";
    localMAutoDBInfo.colsMap.put("contentFullPhoneNumMD5", "TEXT default '' ");
    localStringBuilder.append(" contentFullPhoneNumMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "contentVerifyContent";
    localMAutoDBInfo.colsMap.put("contentVerifyContent", "TEXT default '' ");
    localStringBuilder.append(" contentVerifyContent TEXT default '' ");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("encryptTalker"))
    {
      this.field_encryptTalker = paramContentValues.getAsString("encryptTalker");
      if (paramBoolean) {
        this.khG = true;
      }
    }
    if (paramContentValues.containsKey("displayName"))
    {
      this.field_displayName = paramContentValues.getAsString("displayName");
      if (paramBoolean) {
        this.khH = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("lastModifiedTime"))
    {
      this.field_lastModifiedTime = paramContentValues.getAsLong("lastModifiedTime").longValue();
      if (paramBoolean) {
        this.khI = true;
      }
    }
    if (paramContentValues.containsKey("isNew"))
    {
      this.field_isNew = paramContentValues.getAsInteger("isNew").intValue();
      if (paramBoolean) {
        this.khJ = true;
      }
    }
    if (paramContentValues.containsKey("addScene"))
    {
      this.field_addScene = paramContentValues.getAsInteger("addScene").intValue();
      if (paramBoolean) {
        this.khK = true;
      }
    }
    if (paramContentValues.containsKey("fmsgSysRowId"))
    {
      this.field_fmsgSysRowId = paramContentValues.getAsLong("fmsgSysRowId").longValue();
      if (paramBoolean) {
        this.khL = true;
      }
    }
    if (paramContentValues.containsKey("fmsgIsSend"))
    {
      this.field_fmsgIsSend = paramContentValues.getAsInteger("fmsgIsSend").intValue();
      if (paramBoolean) {
        this.khM = true;
      }
    }
    if (paramContentValues.containsKey("fmsgType"))
    {
      this.field_fmsgType = paramContentValues.getAsInteger("fmsgType").intValue();
      if (paramBoolean) {
        this.khN = true;
      }
    }
    if (paramContentValues.containsKey("fmsgContent"))
    {
      this.field_fmsgContent = paramContentValues.getAsString("fmsgContent");
      if (paramBoolean) {
        this.khO = true;
      }
    }
    if (paramContentValues.containsKey("recvFmsgType"))
    {
      this.field_recvFmsgType = paramContentValues.getAsInteger("recvFmsgType").intValue();
      if (paramBoolean) {
        this.khP = true;
      }
    }
    if (paramContentValues.containsKey("contentFromUsername"))
    {
      this.field_contentFromUsername = paramContentValues.getAsString("contentFromUsername");
      if (paramBoolean) {
        this.khQ = true;
      }
    }
    if (paramContentValues.containsKey("contentNickname"))
    {
      this.field_contentNickname = paramContentValues.getAsString("contentNickname");
      if (paramBoolean) {
        this.khR = true;
      }
    }
    if (paramContentValues.containsKey("contentPhoneNumMD5"))
    {
      this.field_contentPhoneNumMD5 = paramContentValues.getAsString("contentPhoneNumMD5");
      if (paramBoolean) {
        this.khS = true;
      }
    }
    if (paramContentValues.containsKey("contentFullPhoneNumMD5"))
    {
      this.field_contentFullPhoneNumMD5 = paramContentValues.getAsString("contentFullPhoneNumMD5");
      if (paramBoolean) {
        this.khT = true;
      }
    }
    if (paramContentValues.containsKey("contentVerifyContent"))
    {
      this.field_contentVerifyContent = paramContentValues.getAsString("contentVerifyContent");
      if (paramBoolean) {
        this.khU = true;
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
      if (jUd != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.jTP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (khV == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (khW == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (khX == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (khY == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (khZ == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (kia == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (kib == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (kic == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (kid == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (kie == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (kif == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (kig == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (kih == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (kii == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (kij == k) {
        this.field_contentVerifyContent = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_talker == null) {
      this.field_talker = "0";
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.khG) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.khH) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.khI) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.khJ) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.khK) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.khL) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.khM) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.khN) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.khO) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.khP) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.khQ) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.khR) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.khS) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.khT) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.khU) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
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
  
  public StorageObserverOwner<? extends bw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_talker;
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
 * Qualified Name:     com.tencent.mm.autogen.b.bw
 * JD-Core Version:    0.7.0.1
 */