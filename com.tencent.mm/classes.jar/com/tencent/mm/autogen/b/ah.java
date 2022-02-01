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

public abstract class ah
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizChatConversation");
  private static final int content_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column jPF;
  public static final Column jPG;
  public static final Column jPH;
  public static final Column jPI;
  public static final Column jPJ;
  public static final Column jPK;
  public static final Column jPL;
  public static final Column jPM;
  public static final Column jPN;
  public static final Column jPO;
  public static final Column jPP;
  public static final Column jPQ;
  public static final Column jPR;
  public static final Column jPS;
  public static final Column jPT;
  private static final int jQj;
  private static final int jQk;
  private static final int jQl;
  private static final int jQm;
  private static final int jQn;
  private static final int jQo;
  private static final int jQp;
  private static final int jQq;
  private static final int jQr;
  private static final int jQs;
  private static final int jQt;
  private static final int jQu;
  private static final int jQv;
  private static final int jQw;
  private static final int jQx;
  private static final StorageObserverOwner<ah> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcontent = true;
  public int field_atAll;
  public int field_atCount;
  public long field_bizChatId;
  public String field_brandUserName;
  public int field_chatType;
  public String field_content;
  public String field_digest;
  public String field_digestUser;
  public String field_editingMsg;
  public long field_flag;
  public int field_isSend;
  public long field_lastMsgID;
  public long field_lastMsgTime;
  public int field_msgCount;
  public String field_msgType;
  public int field_newUnReadCount;
  public int field_status;
  public int field_unReadCount;
  private boolean jIC = true;
  private boolean jOX = true;
  private boolean jPU = true;
  private boolean jPV = true;
  private boolean jPW = true;
  private boolean jPX = true;
  private boolean jPY = true;
  private boolean jPZ = true;
  private boolean jQa = true;
  private boolean jQb = true;
  private boolean jQc = true;
  private boolean jQd = true;
  private boolean jQe = true;
  private boolean jQf = true;
  private boolean jQg = true;
  private boolean jQh = true;
  private boolean jQi = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPF = new Column("bizChatId", "long", TABLE.getName(), "");
    jPG = new Column("brandUserName", "string", TABLE.getName(), "");
    jPH = new Column("unReadCount", "int", TABLE.getName(), "");
    jPI = new Column("newUnReadCount", "int", TABLE.getName(), "");
    jPJ = new Column("lastMsgID", "long", TABLE.getName(), "");
    jPK = new Column("lastMsgTime", "long", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    jPL = new Column("digest", "string", TABLE.getName(), "");
    jPM = new Column("digestUser", "string", TABLE.getName(), "");
    jPN = new Column("atCount", "int", TABLE.getName(), "");
    jPO = new Column("editingMsg", "string", TABLE.getName(), "");
    jPP = new Column("chatType", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jPQ = new Column("isSend", "int", TABLE.getName(), "");
    jPR = new Column("msgType", "string", TABLE.getName(), "");
    jPS = new Column("msgCount", "int", TABLE.getName(), "");
    jOV = new Column("flag", "long", TABLE.getName(), "");
    jPT = new Column("atAll", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jQj = "bizChatId".hashCode();
    jQk = "brandUserName".hashCode();
    jQl = "unReadCount".hashCode();
    jQm = "newUnReadCount".hashCode();
    jQn = "lastMsgID".hashCode();
    jQo = "lastMsgTime".hashCode();
    content_HASHCODE = "content".hashCode();
    jQp = "digest".hashCode();
    jQq = "digestUser".hashCode();
    jQr = "atCount".hashCode();
    jQs = "editingMsg".hashCode();
    jQt = "chatType".hashCode();
    jIF = "status".hashCode();
    jQu = "isSend".hashCode();
    jQv = "msgType".hashCode();
    jQw = "msgCount".hashCode();
    jOZ = "flag".hashCode();
    jQx = "atAll".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[18];
    localMAutoDBInfo.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bizChatId";
    localMAutoDBInfo.colsMap.put("bizChatId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bizChatId";
    localMAutoDBInfo.columns[1] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT");
    localStringBuilder.append(" brandUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "newUnReadCount";
    localMAutoDBInfo.colsMap.put("newUnReadCount", "INTEGER");
    localStringBuilder.append(" newUnReadCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "lastMsgID";
    localMAutoDBInfo.colsMap.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "lastMsgTime";
    localMAutoDBInfo.colsMap.put("lastMsgTime", "LONG");
    localStringBuilder.append(" lastMsgTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "atCount";
    localMAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "chatType";
    localMAutoDBInfo.colsMap.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "msgCount";
    localMAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "atAll";
    localMAutoDBInfo.colsMap.put("atAll", "INTEGER default '0' ");
    localStringBuilder.append(" atAll INTEGER default '0' ");
    localMAutoDBInfo.columns[18] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("bizChatId"))
    {
      this.field_bizChatId = paramContentValues.getAsLong("bizChatId").longValue();
      if (paramBoolean) {
        this.jPU = true;
      }
    }
    if (paramContentValues.containsKey("brandUserName"))
    {
      this.field_brandUserName = paramContentValues.getAsString("brandUserName");
      if (paramBoolean) {
        this.jPV = true;
      }
    }
    if (paramContentValues.containsKey("unReadCount"))
    {
      this.field_unReadCount = paramContentValues.getAsInteger("unReadCount").intValue();
      if (paramBoolean) {
        this.jPW = true;
      }
    }
    if (paramContentValues.containsKey("newUnReadCount"))
    {
      this.field_newUnReadCount = paramContentValues.getAsInteger("newUnReadCount").intValue();
      if (paramBoolean) {
        this.jPX = true;
      }
    }
    if (paramContentValues.containsKey("lastMsgID"))
    {
      this.field_lastMsgID = paramContentValues.getAsLong("lastMsgID").longValue();
      if (paramBoolean) {
        this.jPY = true;
      }
    }
    if (paramContentValues.containsKey("lastMsgTime"))
    {
      this.field_lastMsgTime = paramContentValues.getAsLong("lastMsgTime").longValue();
      if (paramBoolean) {
        this.jPZ = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("digest"))
    {
      this.field_digest = paramContentValues.getAsString("digest");
      if (paramBoolean) {
        this.jQa = true;
      }
    }
    if (paramContentValues.containsKey("digestUser"))
    {
      this.field_digestUser = paramContentValues.getAsString("digestUser");
      if (paramBoolean) {
        this.jQb = true;
      }
    }
    if (paramContentValues.containsKey("atCount"))
    {
      this.field_atCount = paramContentValues.getAsInteger("atCount").intValue();
      if (paramBoolean) {
        this.jQc = true;
      }
    }
    if (paramContentValues.containsKey("editingMsg"))
    {
      this.field_editingMsg = paramContentValues.getAsString("editingMsg");
      if (paramBoolean) {
        this.jQd = true;
      }
    }
    if (paramContentValues.containsKey("chatType"))
    {
      this.field_chatType = paramContentValues.getAsInteger("chatType").intValue();
      if (paramBoolean) {
        this.jQe = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("isSend"))
    {
      this.field_isSend = paramContentValues.getAsInteger("isSend").intValue();
      if (paramBoolean) {
        this.jQf = true;
      }
    }
    if (paramContentValues.containsKey("msgType"))
    {
      this.field_msgType = paramContentValues.getAsString("msgType");
      if (paramBoolean) {
        this.jQg = true;
      }
    }
    if (paramContentValues.containsKey("msgCount"))
    {
      this.field_msgCount = paramContentValues.getAsInteger("msgCount").intValue();
      if (paramBoolean) {
        this.jQh = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsLong("flag").longValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("atAll"))
    {
      this.field_atAll = paramContentValues.getAsInteger("atAll").intValue();
      if (paramBoolean) {
        this.jQi = true;
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
      if (jQj != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.jPU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jQk == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (jQl == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (jQm == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (jQn == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (jQo == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (jQp == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (jQq == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (jQr == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (jQs == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (jQt == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (jQu == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (jQv == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (jQw == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (jQx == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPU) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.jPV) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.jPW) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.jPX) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.jPY) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.jPZ) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.jQa) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.jQb) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.jQc) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.jQd) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.jQe) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.jQf) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.jQg) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.jQh) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.jOX) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.jQi) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
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
  
  public StorageObserverOwner<? extends ah> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_bizChatId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ah
 * JD-Core Version:    0.7.0.1
 */