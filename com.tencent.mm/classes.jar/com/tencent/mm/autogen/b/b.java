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

public abstract class b
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AARecord");
  private static final int jID;
  private static final int jIE;
  private static final int jIF;
  public static final Column jIm;
  private static final int jIu;
  public static final Column jIx;
  public static final Column jIy;
  public static final Column jIz;
  private static final StorageObserverOwner<b> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_billNo;
  public boolean field_insertmsg;
  public long field_localMsgId;
  public int field_status;
  private boolean jIA = true;
  private boolean jIB = true;
  private boolean jIC = true;
  private boolean jIq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIx = new Column("billNo", "string", TABLE.getName(), "");
    jIm = new Column("insertmsg", "boolean", TABLE.getName(), "");
    jIy = new Column("localMsgId", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jID = "billNo".hashCode();
    jIu = "insertmsg".hashCode();
    jIE = "localMsgId".hashCode();
    jIF = "status".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "billNo";
    localMAutoDBInfo.colsMap.put("billNo", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" billNo TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "billNo";
    localMAutoDBInfo.columns[1] = "insertmsg";
    localMAutoDBInfo.colsMap.put("insertmsg", "INTEGER");
    localStringBuilder.append(" insertmsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "localMsgId";
    localMAutoDBInfo.colsMap.put("localMsgId", "LONG");
    localStringBuilder.append(" localMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("billNo"))
    {
      this.field_billNo = paramContentValues.getAsString("billNo");
      if (paramBoolean) {
        this.jIA = true;
      }
    }
    if (paramContentValues.containsKey("insertmsg")) {
      if (paramContentValues.getAsInteger("insertmsg").intValue() == 0) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      this.field_insertmsg = bool;
      if (paramBoolean) {
        this.jIq = true;
      }
      if (paramContentValues.containsKey("localMsgId"))
      {
        this.field_localMsgId = paramContentValues.getAsLong("localMsgId").longValue();
        if (paramBoolean) {
          this.jIB = true;
        }
      }
      if (paramContentValues.containsKey("status"))
      {
        this.field_status = paramContentValues.getAsInteger("status").intValue();
        if (paramBoolean) {
          this.jIC = true;
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
      if (jID != k) {
        break label65;
      }
      this.field_billNo = paramCursor.getString(i);
      this.jIA = true;
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
      if (jIE == k) {
        this.field_localMsgId = paramCursor.getLong(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIA) {
      localContentValues.put("billNo", this.field_billNo);
    }
    if (this.jIq) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.jIB) {
      localContentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
  
  public StorageObserverOwner<? extends b> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_billNo;
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
 * Qualified Name:     com.tencent.mm.autogen.b.b
 * JD-Core Version:    0.7.0.1
 */