package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.h.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ax
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ChatroomMsgSeq");
  public static final Column USERNAME;
  private static final int jYF;
  private static final int jYG;
  private static final int jYH;
  private static final int jYI;
  private static final int jYJ;
  public static final Column jYv;
  public static final Column jYw;
  public static final Column jYx;
  public static final Column jYy;
  public static final Column jYz;
  private static final StorageObserverOwner<ax> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public long field_lastLocalCreateTime;
  public long field_lastLocalSeq;
  public long field_lastPushCreateTime;
  public long field_lastPushSeq;
  public d field_seqBlockInfo;
  public String field_username;
  private boolean jYA = true;
  private boolean jYB = true;
  private boolean jYC = true;
  private boolean jYD = true;
  private boolean jYE = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jYv = new Column("lastPushSeq", "long", TABLE.getName(), "");
    jYw = new Column("lastLocalSeq", "long", TABLE.getName(), "");
    jYx = new Column("lastPushCreateTime", "long", TABLE.getName(), "");
    jYy = new Column("lastLocalCreateTime", "long", TABLE.getName(), "");
    jYz = new Column("seqBlockInfo", "proto", TABLE.getName(), "com.tencent.mm.clientproto.chatroom.protobuf.SeqBlockInfo");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    jYF = "lastPushSeq".hashCode();
    jYG = "lastLocalSeq".hashCode();
    jYH = "lastPushCreateTime".hashCode();
    jYI = "lastLocalCreateTime".hashCode();
    jYJ = "seqBlockInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "lastPushSeq";
    localMAutoDBInfo.colsMap.put("lastPushSeq", "LONG");
    localStringBuilder.append(" lastPushSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lastLocalSeq";
    localMAutoDBInfo.colsMap.put("lastLocalSeq", "LONG");
    localStringBuilder.append(" lastLocalSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "lastPushCreateTime";
    localMAutoDBInfo.colsMap.put("lastPushCreateTime", "LONG");
    localStringBuilder.append(" lastPushCreateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "lastLocalCreateTime";
    localMAutoDBInfo.colsMap.put("lastLocalCreateTime", "LONG");
    localStringBuilder.append(" lastLocalCreateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "seqBlockInfo";
    localMAutoDBInfo.colsMap.put("seqBlockInfo", "BLOB");
    localStringBuilder.append(" seqBlockInfo BLOB");
    localMAutoDBInfo.columns[6] = "rowid";
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
    if (paramContentValues.containsKey("lastPushSeq"))
    {
      this.field_lastPushSeq = paramContentValues.getAsLong("lastPushSeq").longValue();
      if (paramBoolean) {
        this.jYA = true;
      }
    }
    if (paramContentValues.containsKey("lastLocalSeq"))
    {
      this.field_lastLocalSeq = paramContentValues.getAsLong("lastLocalSeq").longValue();
      if (paramBoolean) {
        this.jYB = true;
      }
    }
    if (paramContentValues.containsKey("lastPushCreateTime"))
    {
      this.field_lastPushCreateTime = paramContentValues.getAsLong("lastPushCreateTime").longValue();
      if (paramBoolean) {
        this.jYC = true;
      }
    }
    if (paramContentValues.containsKey("lastLocalCreateTime"))
    {
      this.field_lastLocalCreateTime = paramContentValues.getAsLong("lastLocalCreateTime").longValue();
      if (paramBoolean) {
        this.jYD = true;
      }
    }
    if (paramContentValues.containsKey("seqBlockInfo")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("seqBlockInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_seqBlockInfo = ((d)new d().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.jYE = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jYF == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (jYG == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (jYH == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (jYI == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (jYJ == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_seqBlockInfo = ((d)new d().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jYA) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.jYB) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.jYC) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.jYD) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.jYE) && (this.field_seqBlockInfo != null)) {}
    try
    {
      localContentValues.put("seqBlockInfo", this.field_seqBlockInfo.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends ax> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ax
 * JD-Core Version:    0.7.0.1
 */