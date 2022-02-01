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

public abstract class fj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("MsgQuote");
  private static final int jIF;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jIz;
  public static final Column jTA;
  private static final int jUc;
  public static final Column kLA;
  private static final int kLD;
  private static final int kLE;
  public static final Column kLz;
  private static final StorageObserverOwner<fj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_quotedMsgId;
  public long field_quotedMsgSvrId;
  public int field_status;
  private boolean jIC = true;
  private boolean jIs = true;
  private boolean jTO = true;
  private boolean kLB = true;
  private boolean kLC = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    kLz = new Column("quotedMsgId", "long", TABLE.getName(), "");
    kLA = new Column("quotedMsgSvrId", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    jUc = "msgSvrId".hashCode();
    kLD = "quotedMsgId".hashCode();
    kLE = "quotedMsgSvrId".hashCode();
    jIF = "status".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "quotedMsgId";
    localMAutoDBInfo.colsMap.put("quotedMsgId", "LONG");
    localStringBuilder.append(" quotedMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "quotedMsgSvrId";
    localMAutoDBInfo.colsMap.put("quotedMsgSvrId", "LONG");
    localStringBuilder.append(" quotedMsgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
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
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("msgSvrId"))
    {
      this.field_msgSvrId = paramContentValues.getAsLong("msgSvrId").longValue();
      if (paramBoolean) {
        this.jTO = true;
      }
    }
    if (paramContentValues.containsKey("quotedMsgId"))
    {
      this.field_quotedMsgId = paramContentValues.getAsLong("quotedMsgId").longValue();
      if (paramBoolean) {
        this.kLB = true;
      }
    }
    if (paramContentValues.containsKey("quotedMsgSvrId"))
    {
      this.field_quotedMsgSvrId = paramContentValues.getAsLong("quotedMsgSvrId").longValue();
      if (paramBoolean) {
        this.kLC = true;
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
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jUc == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (kLD == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (kLE == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
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
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.jTO) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.kLB) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.kLC) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
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
  
  public StorageObserverOwner<? extends fj> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fj
 * JD-Core Version:    0.7.0.1
 */