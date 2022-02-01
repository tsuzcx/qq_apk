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

public abstract class gb
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OrderCommonMsgXml");
  public static final Column jIo;
  private static final int jIw;
  public static final Column jTK;
  private static final int jUm;
  public static final Column kRo;
  private static final int kRq;
  private static final StorageObserverOwner<gb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_isRead;
  public String field_msgContentXml;
  public String field_msgId;
  private boolean jIs = true;
  private boolean jTY = true;
  private boolean kRp = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "string", TABLE.getName(), "");
    kRo = new Column("msgContentXml", "string", TABLE.getName(), "");
    jTK = new Column("isRead", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    kRq = "msgContentXml".hashCode();
    jUm = "isRead".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" msgId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "msgContentXml";
    localMAutoDBInfo.colsMap.put("msgContentXml", "TEXT");
    localStringBuilder.append(" msgContentXml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "TEXT");
    localStringBuilder.append(" isRead TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsString("msgId");
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("msgContentXml"))
    {
      this.field_msgContentXml = paramContentValues.getAsString("msgContentXml");
      if (paramBoolean) {
        this.kRp = true;
      }
    }
    if (paramContentValues.containsKey("isRead"))
    {
      this.field_isRead = paramContentValues.getAsString("isRead");
      if (paramBoolean) {
        this.jTY = true;
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
      if (jIw != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getString(i);
      this.jIs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kRq == k) {
        this.field_msgContentXml = paramCursor.getString(i);
      } else if (jUm == k) {
        this.field_isRead = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIs) {
      localContentValues.put("msgId", this.field_msgId);
    }
    if (this.kRp) {
      localContentValues.put("msgContentXml", this.field_msgContentXml);
    }
    if (this.jTY) {
      localContentValues.put("isRead", this.field_isRead);
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
  
  public StorageObserverOwner<? extends gb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_msgId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gb
 * JD-Core Version:    0.7.0.1
 */