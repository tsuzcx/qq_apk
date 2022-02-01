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

public abstract class ep
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("IPCallRecord");
  private static final int jIF;
  public static final Column jIz;
  public static final Column kEA;
  public static final Column kEB;
  public static final Column kEC;
  public static final Column kED;
  private static final int kEI;
  private static final int kEJ;
  private static final int kEK;
  private static final int kEL;
  private static final int ktJ;
  public static final Column ktl;
  private static final StorageObserverOwner<ep> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  private boolean jIC = true;
  private boolean kEE = true;
  private boolean kEF = true;
  private boolean kEG = true;
  private boolean kEH = true;
  private boolean ktx = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kEA = new Column("phonenumber", "string", TABLE.getName(), "");
    kEB = new Column("calltime", "long", TABLE.getName(), "");
    ktl = new Column("duration", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kEC = new Column("addressId", "long", TABLE.getName(), "");
    kED = new Column("phoneType", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kEI = "phonenumber".hashCode();
    kEJ = "calltime".hashCode();
    ktJ = "duration".hashCode();
    jIF = "status".hashCode();
    kEK = "addressId".hashCode();
    kEL = "phoneType".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "phonenumber";
    localMAutoDBInfo.colsMap.put("phonenumber", "TEXT");
    localStringBuilder.append(" phonenumber TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "calltime";
    localMAutoDBInfo.colsMap.put("calltime", "LONG");
    localStringBuilder.append(" calltime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "duration";
    localMAutoDBInfo.colsMap.put("duration", "LONG");
    localStringBuilder.append(" duration LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "addressId";
    localMAutoDBInfo.colsMap.put("addressId", "LONG default '-1' ");
    localStringBuilder.append(" addressId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "phoneType";
    localMAutoDBInfo.colsMap.put("phoneType", "INTEGER default '-1' ");
    localStringBuilder.append(" phoneType INTEGER default '-1' ");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("phonenumber"))
    {
      this.field_phonenumber = paramContentValues.getAsString("phonenumber");
      if (paramBoolean) {
        this.kEE = true;
      }
    }
    if (paramContentValues.containsKey("calltime"))
    {
      this.field_calltime = paramContentValues.getAsLong("calltime").longValue();
      if (paramBoolean) {
        this.kEF = true;
      }
    }
    if (paramContentValues.containsKey("duration"))
    {
      this.field_duration = paramContentValues.getAsLong("duration").longValue();
      if (paramBoolean) {
        this.ktx = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("addressId"))
    {
      this.field_addressId = paramContentValues.getAsLong("addressId").longValue();
      if (paramBoolean) {
        this.kEG = true;
      }
    }
    if (paramContentValues.containsKey("phoneType"))
    {
      this.field_phoneType = paramContentValues.getAsInteger("phoneType").intValue();
      if (paramBoolean) {
        this.kEH = true;
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
      if (kEI != k) {
        break label60;
      }
      this.field_phonenumber = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kEJ == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (ktJ == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kEK == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (kEL == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kEE) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.kEF) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.ktx) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kEG) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.kEH) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
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
  
  public StorageObserverOwner<? extends ep> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ep
 * JD-Core Version:    0.7.0.1
 */