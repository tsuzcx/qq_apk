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

public abstract class eh
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardDeviceRankFollowInfo");
  public static final Column USERNAME;
  private static final int kDA;
  public static final Column kDn;
  public static final Column kDo;
  private static final int kDt;
  private static final int kDu;
  public static final Column kDy;
  public static final Column kcN;
  private static final int kdN;
  private static final StorageObserverOwner<eh> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  private boolean kDq = true;
  private boolean kDr = true;
  private boolean kDz = true;
  private boolean kdn = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kDo = new Column("appusername", "string", TABLE.getName(), "");
    kDn = new Column("rankID", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kDy = new Column("step", "int", TABLE.getName(), "");
    kcN = new Column("sort", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kDu = "appusername".hashCode();
    kDt = "rankID".hashCode();
    username_HASHCODE = "username".hashCode();
    kDA = "step".hashCode();
    kdN = "sort".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appusername";
    localMAutoDBInfo.colsMap.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "rankID";
    localMAutoDBInfo.colsMap.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "step";
    localMAutoDBInfo.colsMap.put("step", "INTEGER");
    localStringBuilder.append(" step INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "sort";
    localMAutoDBInfo.colsMap.put("sort", "INTEGER default '0' ");
    localStringBuilder.append(" sort INTEGER default '0' ");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appusername"))
    {
      this.field_appusername = paramContentValues.getAsString("appusername");
      if (paramBoolean) {
        this.kDr = true;
      }
    }
    if (paramContentValues.containsKey("rankID"))
    {
      this.field_rankID = paramContentValues.getAsString("rankID");
      if (paramBoolean) {
        this.kDq = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("step"))
    {
      this.field_step = paramContentValues.getAsInteger("step").intValue();
      if (paramBoolean) {
        this.kDz = true;
      }
    }
    if (paramContentValues.containsKey("sort"))
    {
      this.field_sort = paramContentValues.getAsInteger("sort").intValue();
      if (paramBoolean) {
        this.kdn = true;
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
      if (kDu != k) {
        break label60;
      }
      this.field_appusername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kDt == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (kDA == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (kdN == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kDr) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.kDq) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kDz) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.kdn) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
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
  
  public StorageObserverOwner<? extends eh> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.eh
 * JD-Core Version:    0.7.0.1
 */