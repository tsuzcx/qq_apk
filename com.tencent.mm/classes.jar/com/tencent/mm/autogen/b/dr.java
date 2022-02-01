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

public abstract class dr
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameRawMessage");
  private static final int createTime_HASHCODE;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jJI;
  public static final Column jJd;
  public static final Column jJe;
  private static final int jJl;
  private static final int jJm;
  private static final int jKX;
  private static final int jKg;
  public static final Column jKp;
  public static final Column jPR;
  private static final int jQv;
  public static final Column jTK;
  private static final int jUm;
  private static final int kyK;
  private static final int kyL;
  private static final int kyM;
  private static final int kyN;
  private static final int kyO;
  private static final int kyP;
  private static final int kyQ;
  private static final int kyR;
  private static final int kyS;
  private static final int kyT;
  private static final int kyU;
  public static final Column kyo;
  public static final Column kyp;
  public static final Column kyq;
  public static final Column kyr;
  public static final Column kys;
  public static final Column kyt;
  public static final Column kyu;
  public static final Column kyv;
  public static final Column kyw;
  public static final Column kyx;
  public static final Column kyy;
  private static final StorageObserverOwner<dr> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public String field_appId;
  public long field_createTime;
  public long field_expireTime;
  public String field_gameMsgId;
  public int field_hasMergedCount;
  public String field_interactiveMergeId;
  public boolean field_isHidden;
  public boolean field_isRead;
  public String field_label;
  public String field_mergerId;
  public long field_msgId;
  public int field_msgType;
  public boolean field_needReport;
  public String field_rawXML;
  public long field_receiveTime;
  public long field_redDotExpireTime;
  public boolean field_showInMsgList;
  public int field_showType;
  public String field_weight;
  private boolean jIs = true;
  private boolean jJU = true;
  private boolean jJh = true;
  private boolean jJi = true;
  private boolean jKG = true;
  private boolean jQg = true;
  private boolean jTY = true;
  private boolean kyA = true;
  private boolean kyB = true;
  private boolean kyC = true;
  private boolean kyD = true;
  private boolean kyE = true;
  private boolean kyF = true;
  private boolean kyG = true;
  private boolean kyH = true;
  private boolean kyI = true;
  private boolean kyJ = true;
  private boolean kyz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    kyo = new Column("mergerId", "string", TABLE.getName(), "");
    kyp = new Column("gameMsgId", "string", TABLE.getName(), "");
    jPR = new Column("msgType", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    kyq = new Column("expireTime", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kyr = new Column("showInMsgList", "boolean", TABLE.getName(), "");
    jTK = new Column("isRead", "boolean", TABLE.getName(), "");
    kys = new Column("label", "string", TABLE.getName(), "");
    kyt = new Column("isHidden", "boolean", TABLE.getName(), "");
    kyu = new Column("weight", "string", TABLE.getName(), "");
    jJe = new Column("rawXML", "string", TABLE.getName(), "");
    kyv = new Column("receiveTime", "long", TABLE.getName(), "");
    jJI = new Column("showType", "int", TABLE.getName(), "");
    kyw = new Column("interactiveMergeId", "string", TABLE.getName(), "");
    kyx = new Column("hasMergedCount", "int", TABLE.getName(), "");
    kyy = new Column("redDotExpireTime", "long", TABLE.getName(), "");
    jJd = new Column("needReport", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    kyK = "mergerId".hashCode();
    kyL = "gameMsgId".hashCode();
    jQv = "msgType".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kyM = "expireTime".hashCode();
    jKX = "appId".hashCode();
    kyN = "showInMsgList".hashCode();
    jUm = "isRead".hashCode();
    kyO = "label".hashCode();
    kyP = "isHidden".hashCode();
    kyQ = "weight".hashCode();
    jJm = "rawXML".hashCode();
    kyR = "receiveTime".hashCode();
    jKg = "showType".hashCode();
    kyS = "interactiveMergeId".hashCode();
    kyT = "hasMergedCount".hashCode();
    kyU = "redDotExpireTime".hashCode();
    jJl = "needReport".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "mergerId";
    localMAutoDBInfo.colsMap.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "gameMsgId";
    localMAutoDBInfo.colsMap.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showInMsgList";
    localMAutoDBInfo.colsMap.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "label";
    localMAutoDBInfo.colsMap.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isHidden";
    localMAutoDBInfo.colsMap.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "weight";
    localMAutoDBInfo.colsMap.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "rawXML";
    localMAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "receiveTime";
    localMAutoDBInfo.colsMap.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "showType";
    localMAutoDBInfo.colsMap.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "interactiveMergeId";
    localMAutoDBInfo.colsMap.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "hasMergedCount";
    localMAutoDBInfo.colsMap.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "redDotExpireTime";
    localMAutoDBInfo.colsMap.put("redDotExpireTime", "LONG default '0' ");
    localStringBuilder.append(" redDotExpireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "needReport";
    localMAutoDBInfo.colsMap.put("needReport", "INTEGER default 'false' ");
    localStringBuilder.append(" needReport INTEGER default 'false' ");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("mergerId"))
    {
      this.field_mergerId = paramContentValues.getAsString("mergerId");
      if (paramBoolean) {
        this.kyz = true;
      }
    }
    if (paramContentValues.containsKey("gameMsgId"))
    {
      this.field_gameMsgId = paramContentValues.getAsString("gameMsgId");
      if (paramBoolean) {
        this.kyA = true;
      }
    }
    if (paramContentValues.containsKey("msgType"))
    {
      this.field_msgType = paramContentValues.getAsInteger("msgType").intValue();
      if (paramBoolean) {
        this.jQg = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("expireTime"))
    {
      this.field_expireTime = paramContentValues.getAsLong("expireTime").longValue();
      if (paramBoolean) {
        this.kyB = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("showInMsgList"))
    {
      if (paramContentValues.getAsInteger("showInMsgList").intValue() == 0) {
        break label621;
      }
      bool1 = true;
      this.field_showInMsgList = bool1;
      if (paramBoolean) {
        this.kyC = true;
      }
    }
    if (paramContentValues.containsKey("isRead"))
    {
      if (paramContentValues.getAsInteger("isRead").intValue() == 0) {
        break label626;
      }
      bool1 = true;
      label271:
      this.field_isRead = bool1;
      if (paramBoolean) {
        this.jTY = true;
      }
    }
    if (paramContentValues.containsKey("label"))
    {
      this.field_label = paramContentValues.getAsString("label");
      if (paramBoolean) {
        this.kyD = true;
      }
    }
    if (paramContentValues.containsKey("isHidden")) {
      if (paramContentValues.getAsInteger("isHidden").intValue() == 0) {
        break label631;
      }
    }
    label621:
    label626:
    label631:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_isHidden = bool1;
      if (paramBoolean) {
        this.kyE = true;
      }
      if (paramContentValues.containsKey("weight"))
      {
        this.field_weight = paramContentValues.getAsString("weight");
        if (paramBoolean) {
          this.kyF = true;
        }
      }
      if (paramContentValues.containsKey("rawXML"))
      {
        this.field_rawXML = paramContentValues.getAsString("rawXML");
        if (paramBoolean) {
          this.jJi = true;
        }
      }
      if (paramContentValues.containsKey("receiveTime"))
      {
        this.field_receiveTime = paramContentValues.getAsLong("receiveTime").longValue();
        if (paramBoolean) {
          this.kyG = true;
        }
      }
      if (paramContentValues.containsKey("showType"))
      {
        this.field_showType = paramContentValues.getAsInteger("showType").intValue();
        if (paramBoolean) {
          this.jJU = true;
        }
      }
      if (paramContentValues.containsKey("interactiveMergeId"))
      {
        this.field_interactiveMergeId = paramContentValues.getAsString("interactiveMergeId");
        if (paramBoolean) {
          this.kyH = true;
        }
      }
      if (paramContentValues.containsKey("hasMergedCount"))
      {
        this.field_hasMergedCount = paramContentValues.getAsInteger("hasMergedCount").intValue();
        if (paramBoolean) {
          this.kyI = true;
        }
      }
      if (paramContentValues.containsKey("redDotExpireTime"))
      {
        this.field_redDotExpireTime = paramContentValues.getAsLong("redDotExpireTime").longValue();
        if (paramBoolean) {
          this.kyJ = true;
        }
      }
      if (paramContentValues.containsKey("needReport"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("needReport").intValue() != 0) {
          bool1 = true;
        }
        this.field_needReport = bool1;
        if (paramBoolean) {
          this.jJh = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label271;
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
      if (jIw != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.jIs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kyK == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (kyL == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (jQv == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (kyM == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (jKX == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (kyN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (jUm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (kyO == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (kyP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (kyQ == k)
          {
            this.field_weight = paramCursor.getString(i);
          }
          else if (jJm == k)
          {
            this.field_rawXML = paramCursor.getString(i);
          }
          else if (kyR == k)
          {
            this.field_receiveTime = paramCursor.getLong(i);
          }
          else if (jKg == k)
          {
            this.field_showType = paramCursor.getInt(i);
          }
          else if (kyS == k)
          {
            this.field_interactiveMergeId = paramCursor.getString(i);
          }
          else if (kyT == k)
          {
            this.field_hasMergedCount = paramCursor.getInt(i);
          }
          else if (kyU == k)
          {
            this.field_redDotExpireTime = paramCursor.getLong(i);
          }
          else
          {
            if (jJl == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needReport = bool;
                break;
              }
            }
            if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.kyz) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.kyA) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.jQg) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.kyB) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.kyC) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.jTY) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.kyD) {
      localContentValues.put("label", this.field_label);
    }
    if (this.kyE) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.kyF) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.jJi) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.kyG) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.jJU) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.kyH) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.kyI) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.kyJ) {
      localContentValues.put("redDotExpireTime", Long.valueOf(this.field_redDotExpireTime));
    }
    if (this.jJh) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
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
  
  public StorageObserverOwner<? extends dr> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.dr
 * JD-Core Version:    0.7.0.1
 */