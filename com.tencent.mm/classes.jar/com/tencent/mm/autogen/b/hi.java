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

public abstract class hi
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SNSID;
  public static final SingleTable TABLE = new SingleTable("SnsComment");
  public static final Column TYPE;
  private static final int createTime_HASHCODE;
  public static final Column jPQ;
  private static final int jQu;
  public static final Column jTB;
  public static final Column jTK;
  private static final int jUd;
  private static final int jUm;
  public static final Column kYJ;
  public static final Column kYK;
  public static final Column kYL;
  public static final Column kYM;
  public static final Column kYN;
  public static final Column kYO;
  public static final Column kYP;
  private static final int kYY;
  private static final int kYZ;
  private static final int kZa;
  private static final int kZb;
  private static final int kZc;
  private static final int kZd;
  private static final int kZe;
  private static final int kZf;
  private static final StorageObserverOwner<hi> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public String field_clientId;
  public long field_commentSvrID;
  public int field_commentflag;
  public int field_createTime;
  public byte[] field_curActionBuf;
  public short field_isRead;
  public boolean field_isSend;
  public int field_isSilence;
  public long field_parentID;
  public byte[] field_refActionBuf;
  public long field_snsID;
  public String field_talker;
  public int field_type;
  private boolean jQf = true;
  private boolean jTP = true;
  private boolean jTY = true;
  private boolean kYQ = true;
  private boolean kYR = true;
  private boolean kYS = true;
  private boolean kYT = true;
  private boolean kYU = true;
  private boolean kYV = true;
  private boolean kYW = true;
  private boolean kYX = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    SNSID = new Column("snsID", "long", TABLE.getName(), "");
    kYJ = new Column("parentID", "long", TABLE.getName(), "");
    jTK = new Column("isRead", "short", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jPQ = new Column("isSend", "boolean", TABLE.getName(), "");
    kYK = new Column("curActionBuf", "byte[]", TABLE.getName(), "");
    kYL = new Column("refActionBuf", "byte[]", TABLE.getName(), "");
    kYM = new Column("commentSvrID", "long", TABLE.getName(), "");
    kYN = new Column("clientId", "string", TABLE.getName(), "");
    kYO = new Column("commentflag", "int", TABLE.getName(), "");
    kYP = new Column("isSilence", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
    kYY = "snsID".hashCode();
    kYZ = "parentID".hashCode();
    jUm = "isRead".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    jUd = "talker".hashCode();
    type_HASHCODE = "type".hashCode();
    jQu = "isSend".hashCode();
    kZa = "curActionBuf".hashCode();
    kZb = "refActionBuf".hashCode();
    kZc = "commentSvrID".hashCode();
    kZd = "clientId".hashCode();
    kZe = "commentflag".hashCode();
    kZf = "isSilence".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "snsID";
    localMAutoDBInfo.colsMap.put("snsID", "LONG");
    localStringBuilder.append(" snsID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "parentID";
    localMAutoDBInfo.colsMap.put("parentID", "LONG");
    localStringBuilder.append(" parentID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default 'false' ");
    localStringBuilder.append(" isSend INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "curActionBuf";
    localMAutoDBInfo.colsMap.put("curActionBuf", "BLOB");
    localStringBuilder.append(" curActionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "refActionBuf";
    localMAutoDBInfo.colsMap.put("refActionBuf", "BLOB");
    localStringBuilder.append(" refActionBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "commentSvrID";
    localMAutoDBInfo.colsMap.put("commentSvrID", "LONG");
    localStringBuilder.append(" commentSvrID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "clientId";
    localMAutoDBInfo.colsMap.put("clientId", "TEXT");
    localStringBuilder.append(" clientId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "commentflag";
    localMAutoDBInfo.colsMap.put("commentflag", "INTEGER");
    localStringBuilder.append(" commentflag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "isSilence";
    localMAutoDBInfo.colsMap.put("isSilence", "INTEGER default '0' ");
    localStringBuilder.append(" isSilence INTEGER default '0' ");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("snsID"))
    {
      this.field_snsID = paramContentValues.getAsLong("snsID").longValue();
      if (paramBoolean) {
        this.kYQ = true;
      }
    }
    if (paramContentValues.containsKey("parentID"))
    {
      this.field_parentID = paramContentValues.getAsLong("parentID").longValue();
      if (paramBoolean) {
        this.kYR = true;
      }
    }
    if (paramContentValues.containsKey("isRead"))
    {
      this.field_isRead = paramContentValues.getAsShort("isRead").shortValue();
      if (paramBoolean) {
        this.jTY = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("isSend")) {
      if (paramContentValues.getAsInteger("isSend").intValue() == 0) {
        break label420;
      }
    }
    label420:
    for (boolean bool = true;; bool = false)
    {
      this.field_isSend = bool;
      if (paramBoolean) {
        this.jQf = true;
      }
      if (paramContentValues.containsKey("curActionBuf"))
      {
        this.field_curActionBuf = paramContentValues.getAsByteArray("curActionBuf");
        if (paramBoolean) {
          this.kYS = true;
        }
      }
      if (paramContentValues.containsKey("refActionBuf"))
      {
        this.field_refActionBuf = paramContentValues.getAsByteArray("refActionBuf");
        if (paramBoolean) {
          this.kYT = true;
        }
      }
      if (paramContentValues.containsKey("commentSvrID"))
      {
        this.field_commentSvrID = paramContentValues.getAsLong("commentSvrID").longValue();
        if (paramBoolean) {
          this.kYU = true;
        }
      }
      if (paramContentValues.containsKey("clientId"))
      {
        this.field_clientId = paramContentValues.getAsString("clientId");
        if (paramBoolean) {
          this.kYV = true;
        }
      }
      if (paramContentValues.containsKey("commentflag"))
      {
        this.field_commentflag = paramContentValues.getAsInteger("commentflag").intValue();
        if (paramBoolean) {
          this.kYW = true;
        }
      }
      if (paramContentValues.containsKey("isSilence"))
      {
        this.field_isSilence = paramContentValues.getAsInteger("isSilence").intValue();
        if (paramBoolean) {
          this.kYX = true;
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
      if (kYY != k) {
        break label60;
      }
      this.field_snsID = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kYZ == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (jUm == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (jUd == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (jQu == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (kZa == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (kZb == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (kZc == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (kZd == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (kZe == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (kZf == k) {
          this.field_isSilence = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kYQ) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.kYR) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.jTY) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jQf) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.kYS) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.kYT) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.kYU) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.kYV) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.kYW) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.kYX) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
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
  
  public StorageObserverOwner<? extends hi> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.hi
 * JD-Core Version:    0.7.0.1
 */