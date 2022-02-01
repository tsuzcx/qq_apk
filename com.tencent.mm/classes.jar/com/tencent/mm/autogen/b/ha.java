package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ha
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SelectRecord");
  public static final Column jIo;
  private static final int jIw;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kKU;
  private static final int kLf;
  public static final Column kWC;
  private static final int kWE;
  private static final StorageObserverOwner<ha> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public zd field_chatHistoryItem;
  public String field_historyId;
  public long field_msgId;
  public String field_talker;
  private boolean jIs = true;
  private boolean jTP = true;
  private boolean kLd = true;
  private boolean kWD = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kKU = new Column("historyId", "string", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    kWC = new Column("chatHistoryItem", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.ChatHistoryItem");
    INDEX_CREATE = new String[0];
    kLf = "historyId".hashCode();
    jIw = "msgId".hashCode();
    jUd = "talker".hashCode();
    kWE = "chatHistoryItem".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "historyId";
    localMAutoDBInfo.colsMap.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "chatHistoryItem";
    localMAutoDBInfo.colsMap.put("chatHistoryItem", "BLOB");
    localStringBuilder.append(" chatHistoryItem BLOB");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("historyId"))
    {
      this.field_historyId = paramContentValues.getAsString("historyId");
      if (paramBoolean) {
        this.kLd = true;
      }
    }
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("chatHistoryItem")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("chatHistoryItem");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_chatHistoryItem = ((zd)new zd().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kWD = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseSelectRecord", localIOException.getMessage());
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
      if (kLf != k) {
        break label60;
      }
      this.field_historyId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jIw == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (jUd == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (kWE == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_chatHistoryItem = ((zd)new zd().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseSelectRecord", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kLd) {
      localContentValues.put("historyId", this.field_historyId);
    }
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if ((this.kWD) && (this.field_chatHistoryItem != null)) {}
    try
    {
      localContentValues.put("chatHistoryItem", this.field_chatHistoryItem.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseSelectRecord", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends ha> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ha
 * JD-Core Version:    0.7.0.1
 */