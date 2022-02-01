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

public abstract class cr
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLiveDislikeBannerRecord");
  public static final Column kkd;
  private static final int kkx;
  private static final int krB;
  public static final Column krz;
  private static final StorageObserverOwner<cr> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_dislikeBannerId;
  public long field_timestamp;
  private boolean kkn = true;
  private boolean krA = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krz = new Column("dislikeBannerId", "string", TABLE.getName(), "");
    kkd = new Column("timestamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    krB = "dislikeBannerId".hashCode();
    kkx = "timestamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "dislikeBannerId";
    localMAutoDBInfo.colsMap.put("dislikeBannerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" dislikeBannerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "dislikeBannerId";
    localMAutoDBInfo.columns[1] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("dislikeBannerId"))
    {
      this.field_dislikeBannerId = paramContentValues.getAsString("dislikeBannerId");
      if (paramBoolean) {
        this.krA = true;
      }
    }
    if (paramContentValues.containsKey("timestamp"))
    {
      this.field_timestamp = paramContentValues.getAsLong("timestamp").longValue();
      if (paramBoolean) {
        this.kkn = true;
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
      if (krB != k) {
        break label65;
      }
      this.field_dislikeBannerId = paramCursor.getString(i);
      this.krA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kkx == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krA) {
      localContentValues.put("dislikeBannerId", this.field_dislikeBannerId);
    }
    if (this.kkn) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
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
  
  public StorageObserverOwner<? extends cr> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_dislikeBannerId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.cr
 * JD-Core Version:    0.7.0.1
 */