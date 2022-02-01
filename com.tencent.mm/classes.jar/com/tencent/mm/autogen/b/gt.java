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

public abstract class gt
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("RemittanceRecord");
  public static final Column jPQ;
  private static final int jQu;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kTV;
  public static final Column kTW;
  public static final Column kTX;
  public static final Column kTY;
  public static final Column kTZ;
  private static final int kUf;
  private static final int kUg;
  private static final int kUh;
  private static final int kUi;
  private static final int kUj;
  public static final Column kbW;
  private static final int kbY;
  private static final StorageObserverOwner<gt> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public boolean field_hasClicked;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_receiverName;
  public String field_talker;
  public String field_transferId;
  private boolean jQf = true;
  private boolean jTP = true;
  private boolean kUa = true;
  private boolean kUb = true;
  private boolean kUc = true;
  private boolean kUd = true;
  private boolean kUe = true;
  private boolean kbX = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kbW = new Column("transferId", "string", TABLE.getName(), "");
    kTV = new Column("locaMsgId", "long", TABLE.getName(), "");
    kTW = new Column("receiveStatus", "int", TABLE.getName(), "");
    jPQ = new Column("isSend", "boolean", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    kTX = new Column("invalidtime", "long", TABLE.getName(), "");
    kTY = new Column("receiverName", "string", TABLE.getName(), "");
    kTZ = new Column("hasClicked", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS remittance_record_status_index ON RemittanceRecord(receiveStatus)", "CREATE INDEX IF NOT EXISTS remittance_record_talker_index ON RemittanceRecord(talker)" };
    kbY = "transferId".hashCode();
    kUf = "locaMsgId".hashCode();
    kUg = "receiveStatus".hashCode();
    jQu = "isSend".hashCode();
    jUd = "talker".hashCode();
    kUh = "invalidtime".hashCode();
    kUi = "receiverName".hashCode();
    kUj = "hasClicked".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "transferId";
    localMAutoDBInfo.colsMap.put("transferId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" transferId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "transferId";
    localMAutoDBInfo.columns[1] = "locaMsgId";
    localMAutoDBInfo.colsMap.put("locaMsgId", "LONG");
    localStringBuilder.append(" locaMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "receiveStatus";
    localMAutoDBInfo.colsMap.put("receiveStatus", "INTEGER default '-1' ");
    localStringBuilder.append(" receiveStatus INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "invalidtime";
    localMAutoDBInfo.colsMap.put("invalidtime", "LONG");
    localStringBuilder.append(" invalidtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "receiverName";
    localMAutoDBInfo.colsMap.put("receiverName", "TEXT");
    localStringBuilder.append(" receiverName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "hasClicked";
    localMAutoDBInfo.colsMap.put("hasClicked", "INTEGER");
    localStringBuilder.append(" hasClicked INTEGER");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("transferId"))
    {
      this.field_transferId = paramContentValues.getAsString("transferId");
      if (paramBoolean) {
        this.kbX = true;
      }
    }
    if (paramContentValues.containsKey("locaMsgId"))
    {
      this.field_locaMsgId = paramContentValues.getAsLong("locaMsgId").longValue();
      if (paramBoolean) {
        this.kUa = true;
      }
    }
    if (paramContentValues.containsKey("receiveStatus"))
    {
      this.field_receiveStatus = paramContentValues.getAsInteger("receiveStatus").intValue();
      if (paramBoolean) {
        this.kUb = true;
      }
    }
    if (paramContentValues.containsKey("isSend")) {
      if (paramContentValues.getAsInteger("isSend").intValue() == 0) {
        break label280;
      }
    }
    label280:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_isSend = bool1;
      if (paramBoolean) {
        this.jQf = true;
      }
      if (paramContentValues.containsKey("talker"))
      {
        this.field_talker = paramContentValues.getAsString("talker");
        if (paramBoolean) {
          this.jTP = true;
        }
      }
      if (paramContentValues.containsKey("invalidtime"))
      {
        this.field_invalidtime = paramContentValues.getAsLong("invalidtime").longValue();
        if (paramBoolean) {
          this.kUc = true;
        }
      }
      if (paramContentValues.containsKey("receiverName"))
      {
        this.field_receiverName = paramContentValues.getAsString("receiverName");
        if (paramBoolean) {
          this.kUd = true;
        }
      }
      if (paramContentValues.containsKey("hasClicked"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("hasClicked").intValue() != 0) {
          bool1 = true;
        }
        this.field_hasClicked = bool1;
        if (paramBoolean) {
          this.kUe = true;
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
      if (kbY != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.kbX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kUf == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (kUg == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (jQu == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (jUd == k)
        {
          this.field_talker = paramCursor.getString(i);
        }
        else if (kUh == k)
        {
          this.field_invalidtime = paramCursor.getLong(i);
        }
        else if (kUi == k)
        {
          this.field_receiverName = paramCursor.getString(i);
        }
        else
        {
          if (kUj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hasClicked = bool;
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
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kbX) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.kUa) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.kUb) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.jQf) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.kUc) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.kUd) {
      localContentValues.put("receiverName", this.field_receiverName);
    }
    if (this.kUe) {
      localContentValues.put("hasClicked", Boolean.valueOf(this.field_hasClicked));
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
  
  public StorageObserverOwner<? extends gt> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_transferId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gt
 * JD-Core Version:    0.7.0.1
 */