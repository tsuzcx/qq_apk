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

public abstract class a
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AAPayRecord");
  public static final Column jIl;
  public static final Column jIm;
  public static final Column jIn;
  public static final Column jIo;
  private static final int jIt;
  private static final int jIu;
  private static final int jIv;
  private static final int jIw;
  private static final StorageObserverOwner<a> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_chatroom;
  public boolean field_insertmsg;
  public long field_msgId;
  public String field_payMsgId;
  private boolean jIp = true;
  private boolean jIq = true;
  private boolean jIr = true;
  private boolean jIs = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIl = new Column("payMsgId", "string", TABLE.getName(), "");
    jIm = new Column("insertmsg", "boolean", TABLE.getName(), "");
    jIn = new Column("chatroom", "string", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIt = "payMsgId".hashCode();
    jIu = "insertmsg".hashCode();
    jIv = "chatroom".hashCode();
    jIw = "msgId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "payMsgId";
    localMAutoDBInfo.colsMap.put("payMsgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" payMsgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "payMsgId";
    localMAutoDBInfo.columns[1] = "insertmsg";
    localMAutoDBInfo.colsMap.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "chatroom";
    localMAutoDBInfo.colsMap.put("chatroom", "TEXT");
    localStringBuilder.append(" chatroom TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("payMsgId"))
    {
      this.field_payMsgId = paramContentValues.getAsString("payMsgId");
      if (paramBoolean) {
        this.jIp = true;
      }
    }
    if (paramContentValues.containsKey("insertmsg")) {
      if (paramContentValues.getAsInteger("insertmsg").intValue() == 0) {
        break label147;
      }
    }
    label147:
    for (boolean bool = true;; bool = false)
    {
      this.field_insertmsg = bool;
      if (paramBoolean) {
        this.jIq = true;
      }
      if (paramContentValues.containsKey("chatroom"))
      {
        this.field_chatroom = paramContentValues.getAsString("chatroom");
        if (paramBoolean) {
          this.jIr = true;
        }
      }
      if (paramContentValues.containsKey("msgId"))
      {
        this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
        if (paramBoolean) {
          this.jIs = true;
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
      if (jIt != k) {
        break label65;
      }
      this.field_payMsgId = paramCursor.getString(i);
      this.jIp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIu == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (jIv == k) {
        this.field_chatroom = paramCursor.getString(i);
      } else if (jIw == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIp) {
      localContentValues.put("payMsgId", this.field_payMsgId);
    }
    if (this.jIq) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.jIr) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
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
  
  public StorageObserverOwner<? extends a> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_payMsgId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.a
 * JD-Core Version:    0.7.0.1
 */