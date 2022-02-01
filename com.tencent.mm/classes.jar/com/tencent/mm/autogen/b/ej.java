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

public abstract class ej
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardIotCdnInfo");
  public static final Column jIo;
  public static final Column jLQ;
  private static final int jLU;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kDO;
  private static final int kDR;
  private static final int kDS;
  public static final Column kea;
  public static final Column ket;
  private static final int kfD;
  private static final int kfW;
  private static final StorageObserverOwner<ej> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_aeskey;
  public String field_fileid;
  public String field_md5;
  public long field_msgid;
  public int field_size;
  public String field_talker;
  private boolean jLS = true;
  private boolean jTP = true;
  private boolean kDP = true;
  private boolean kDQ = true;
  private boolean keP = true;
  private boolean kfi = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgid", "long", TABLE.getName(), "");
    kDO = new Column("fileid", "string", TABLE.getName(), "");
    ket = new Column("aeskey", "string", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    jLQ = new Column("size", "int", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kDR = "msgid".hashCode();
    kDS = "fileid".hashCode();
    kfW = "aeskey".hashCode();
    kfD = "md5".hashCode();
    jLU = "size".hashCode();
    jUd = "talker".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgid";
    localMAutoDBInfo.colsMap.put("msgid", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgid LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgid";
    localMAutoDBInfo.columns[1] = "fileid";
    localMAutoDBInfo.colsMap.put("fileid", "TEXT");
    localStringBuilder.append(" fileid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "aeskey";
    localMAutoDBInfo.colsMap.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT");
    localStringBuilder.append(" md5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgid"))
    {
      this.field_msgid = paramContentValues.getAsLong("msgid").longValue();
      if (paramBoolean) {
        this.kDP = true;
      }
    }
    if (paramContentValues.containsKey("fileid"))
    {
      this.field_fileid = paramContentValues.getAsString("fileid");
      if (paramBoolean) {
        this.kDQ = true;
      }
    }
    if (paramContentValues.containsKey("aeskey"))
    {
      this.field_aeskey = paramContentValues.getAsString("aeskey");
      if (paramBoolean) {
        this.kfi = true;
      }
    }
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsInteger("size").intValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
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
      if (kDR != k) {
        break label65;
      }
      this.field_msgid = paramCursor.getLong(i);
      this.kDP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kDS == k) {
        this.field_fileid = paramCursor.getString(i);
      } else if (kfW == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (kfD == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (jLU == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (jUd == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kDP) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.kDQ) {
      localContentValues.put("fileid", this.field_fileid);
    }
    if (this.kfi) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.jLS) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
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
  
  public StorageObserverOwner<? extends ej> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgid);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ej
 * JD-Core Version:    0.7.0.1
 */