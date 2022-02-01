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

public abstract class gv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("RoomMuteExpt");
  public static final Column jIn;
  private static final int jIv;
  public static final Column jPH;
  private static final int jQl;
  public static final Column jTk;
  private static final int jTs;
  public static final Column kDw;
  private static final int kDx;
  public static final Column kVA;
  public static final Column kVB;
  public static final Column kVC;
  public static final Column kVD;
  private static final int kVK;
  private static final int kVL;
  private static final int kVM;
  private static final int kVN;
  private static final int kVO;
  private static final int kVP;
  public static final Column kVy;
  public static final Column kVz;
  private static final StorageObserverOwner<gv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_chatroom;
  public String field_daySec;
  public int field_disRedDotCount;
  public int field_enterCount;
  public int field_isMute;
  public String field_nickname;
  public float field_score;
  public int field_sendCount;
  public long field_stayTime;
  public int field_unReadCount;
  private boolean jIr = true;
  private boolean jPW = true;
  private boolean jTo = true;
  private boolean kDG = true;
  private boolean kVE = true;
  private boolean kVF = true;
  private boolean kVG = true;
  private boolean kVH = true;
  private boolean kVI = true;
  private boolean kVJ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIn = new Column("chatroom", "string", TABLE.getName(), "");
    kVy = new Column("daySec", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kVz = new Column("isMute", "int", TABLE.getName(), "");
    jPH = new Column("unReadCount", "int", TABLE.getName(), "");
    kVA = new Column("sendCount", "int", TABLE.getName(), "");
    kVB = new Column("enterCount", "int", TABLE.getName(), "");
    kVC = new Column("disRedDotCount", "int", TABLE.getName(), "");
    kVD = new Column("stayTime", "long", TABLE.getName(), "");
    kDw = new Column("score", "float", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIv = "chatroom".hashCode();
    kVK = "daySec".hashCode();
    jTs = "nickname".hashCode();
    kVL = "isMute".hashCode();
    jQl = "unReadCount".hashCode();
    kVM = "sendCount".hashCode();
    kVN = "enterCount".hashCode();
    kVO = "disRedDotCount".hashCode();
    kVP = "stayTime".hashCode();
    kDx = "score".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatroom";
    localMAutoDBInfo.colsMap.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "daySec";
    localMAutoDBInfo.colsMap.put("daySec", "TEXT");
    localStringBuilder.append(" daySec TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isMute";
    localMAutoDBInfo.colsMap.put("isMute", "INTEGER");
    localStringBuilder.append(" isMute INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER");
    localStringBuilder.append(" unReadCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "sendCount";
    localMAutoDBInfo.colsMap.put("sendCount", "INTEGER");
    localStringBuilder.append(" sendCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "enterCount";
    localMAutoDBInfo.colsMap.put("enterCount", "INTEGER");
    localStringBuilder.append(" enterCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "disRedDotCount";
    localMAutoDBInfo.colsMap.put("disRedDotCount", "INTEGER");
    localStringBuilder.append(" disRedDotCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "stayTime";
    localMAutoDBInfo.colsMap.put("stayTime", "LONG");
    localStringBuilder.append(" stayTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "score";
    localMAutoDBInfo.colsMap.put("score", "FLOAT");
    localStringBuilder.append(" score FLOAT");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("chatroom"))
    {
      this.field_chatroom = paramContentValues.getAsString("chatroom");
      if (paramBoolean) {
        this.jIr = true;
      }
    }
    if (paramContentValues.containsKey("daySec"))
    {
      this.field_daySec = paramContentValues.getAsString("daySec");
      if (paramBoolean) {
        this.kVE = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("isMute"))
    {
      this.field_isMute = paramContentValues.getAsInteger("isMute").intValue();
      if (paramBoolean) {
        this.kVF = true;
      }
    }
    if (paramContentValues.containsKey("unReadCount"))
    {
      this.field_unReadCount = paramContentValues.getAsInteger("unReadCount").intValue();
      if (paramBoolean) {
        this.jPW = true;
      }
    }
    if (paramContentValues.containsKey("sendCount"))
    {
      this.field_sendCount = paramContentValues.getAsInteger("sendCount").intValue();
      if (paramBoolean) {
        this.kVG = true;
      }
    }
    if (paramContentValues.containsKey("enterCount"))
    {
      this.field_enterCount = paramContentValues.getAsInteger("enterCount").intValue();
      if (paramBoolean) {
        this.kVH = true;
      }
    }
    if (paramContentValues.containsKey("disRedDotCount"))
    {
      this.field_disRedDotCount = paramContentValues.getAsInteger("disRedDotCount").intValue();
      if (paramBoolean) {
        this.kVI = true;
      }
    }
    if (paramContentValues.containsKey("stayTime"))
    {
      this.field_stayTime = paramContentValues.getAsLong("stayTime").longValue();
      if (paramBoolean) {
        this.kVJ = true;
      }
    }
    if (paramContentValues.containsKey("score"))
    {
      this.field_score = paramContentValues.getAsFloat("score").floatValue();
      if (paramBoolean) {
        this.kDG = true;
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
      if (jIv != k) {
        break label60;
      }
      this.field_chatroom = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kVK == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kVL == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (jQl == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (kVM == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (kVN == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (kVO == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (kVP == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (kDx == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIr) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.kVE) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.kVF) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.jPW) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.kVG) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.kVH) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.kVI) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.kVJ) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.kDG) {
      localContentValues.put("score", Float.valueOf(this.field_score));
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
  
  public StorageObserverOwner<? extends gv> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.gv
 * JD-Core Version:    0.7.0.1
 */