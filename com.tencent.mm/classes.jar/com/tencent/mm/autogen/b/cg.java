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

public abstract class cg
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FileMsgInfo");
  public static final Column jTA;
  private static final int jUc;
  private static final int jWL;
  public static final Column jWv;
  public static final Column ket;
  private static final int kfW;
  public static final Column kmk;
  public static final Column kml;
  private static final int kmo;
  private static final int kmp;
  private static final StorageObserverOwner<cg> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_aeskey;
  public String field_cgi;
  public String field_filePath;
  public long field_msgSvrId;
  public long field_overwriteNewMsgId;
  private boolean jTO = true;
  private boolean jWD = true;
  private boolean kfi = true;
  private boolean kmm = true;
  private boolean kmn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    kmk = new Column("overwriteNewMsgId", "long", TABLE.getName(), "");
    kml = new Column("cgi", "string", TABLE.getName(), "");
    ket = new Column("aeskey", "string", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jUc = "msgSvrId".hashCode();
    kmo = "overwriteNewMsgId".hashCode();
    kmp = "cgi".hashCode();
    kfW = "aeskey".hashCode();
    jWL = "filePath".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgSvrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgSvrId";
    localMAutoDBInfo.columns[1] = "overwriteNewMsgId";
    localMAutoDBInfo.colsMap.put("overwriteNewMsgId", "LONG");
    localStringBuilder.append(" overwriteNewMsgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "cgi";
    localMAutoDBInfo.colsMap.put("cgi", "TEXT default '' ");
    localStringBuilder.append(" cgi TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "aeskey";
    localMAutoDBInfo.colsMap.put("aeskey", "TEXT default '' ");
    localStringBuilder.append(" aeskey TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT default '' ");
    localStringBuilder.append(" filePath TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgSvrId"))
    {
      this.field_msgSvrId = paramContentValues.getAsLong("msgSvrId").longValue();
      if (paramBoolean) {
        this.jTO = true;
      }
    }
    if (paramContentValues.containsKey("overwriteNewMsgId"))
    {
      this.field_overwriteNewMsgId = paramContentValues.getAsLong("overwriteNewMsgId").longValue();
      if (paramBoolean) {
        this.kmm = true;
      }
    }
    if (paramContentValues.containsKey("cgi"))
    {
      this.field_cgi = paramContentValues.getAsString("cgi");
      if (paramBoolean) {
        this.kmn = true;
      }
    }
    if (paramContentValues.containsKey("aeskey"))
    {
      this.field_aeskey = paramContentValues.getAsString("aeskey");
      if (paramBoolean) {
        this.kfi = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
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
      if (jUc != k) {
        break label65;
      }
      this.field_msgSvrId = paramCursor.getLong(i);
      this.jTO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kmo == k) {
        this.field_overwriteNewMsgId = paramCursor.getLong(i);
      } else if (kmp == k) {
        this.field_cgi = paramCursor.getString(i);
      } else if (kfW == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (jWL == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jTO) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.kmm) {
      localContentValues.put("overwriteNewMsgId", Long.valueOf(this.field_overwriteNewMsgId));
    }
    if (this.field_cgi == null) {
      this.field_cgi = "";
    }
    if (this.kmn) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.field_aeskey == null) {
      this.field_aeskey = "";
    }
    if (this.kfi) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.field_filePath == null) {
      this.field_filePath = "";
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
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
  
  public StorageObserverOwner<? extends cg> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgSvrId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.cg
 * JD-Core Version:    0.7.0.1
 */