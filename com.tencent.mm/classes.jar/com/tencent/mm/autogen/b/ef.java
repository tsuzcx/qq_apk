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

public abstract class ef
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardDeviceLikeUser");
  public static final Column USERNAME;
  public static final Column kDn;
  public static final Column kDo;
  public static final Column kDp;
  private static final int kDt;
  private static final int kDu;
  private static final int kDv;
  public static final Column kkd;
  private static final int kkx;
  private static final StorageObserverOwner<ef> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public String field_liketips;
  public String field_rankID;
  public int field_timestamp;
  public String field_username;
  private boolean kDq = true;
  private boolean kDr = true;
  private boolean kDs = true;
  private boolean kkn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kDn = new Column("rankID", "string", TABLE.getName(), "");
    kDo = new Column("appusername", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kkd = new Column("timestamp", "int", TABLE.getName(), "");
    kDp = new Column("liketips", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kDt = "rankID".hashCode();
    kDu = "appusername".hashCode();
    username_HASHCODE = "username".hashCode();
    kkx = "timestamp".hashCode();
    kDv = "liketips".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "rankID";
    localMAutoDBInfo.colsMap.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appusername";
    localMAutoDBInfo.colsMap.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "INTEGER default '0' ");
    localStringBuilder.append(" timestamp INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "liketips";
    localMAutoDBInfo.colsMap.put("liketips", "TEXT default '' ");
    localStringBuilder.append(" liketips TEXT default '' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("rankID"))
    {
      this.field_rankID = paramContentValues.getAsString("rankID");
      if (paramBoolean) {
        this.kDq = true;
      }
    }
    if (paramContentValues.containsKey("appusername"))
    {
      this.field_appusername = paramContentValues.getAsString("appusername");
      if (paramBoolean) {
        this.kDr = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("timestamp"))
    {
      this.field_timestamp = paramContentValues.getAsInteger("timestamp").intValue();
      if (paramBoolean) {
        this.kkn = true;
      }
    }
    if (paramContentValues.containsKey("liketips"))
    {
      this.field_liketips = paramContentValues.getAsString("liketips");
      if (paramBoolean) {
        this.kDs = true;
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
      if (kDt != k) {
        break label60;
      }
      this.field_rankID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kDu == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (kkx == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (kDv == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kDq) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.kDr) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kkn) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.kDs) {
      localContentValues.put("liketips", this.field_liketips);
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
  
  public StorageObserverOwner<? extends ef> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ef
 * JD-Core Version:    0.7.0.1
 */