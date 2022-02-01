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

public abstract class iy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WeseeProviderInfo");
  public static final Column jUS;
  private static final int jVE;
  public static final Column lnL;
  private static final int lnN;
  private static final StorageObserverOwner<iy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_time;
  public String field_weSeeUri;
  private boolean jVl = true;
  private boolean lnM = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lnL = new Column("weSeeUri", "string", TABLE.getName(), "");
    jUS = new Column("time", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lnN = "weSeeUri".hashCode();
    jVE = "time".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "weSeeUri";
    localMAutoDBInfo.colsMap.put("weSeeUri", "TEXT");
    localStringBuilder.append(" weSeeUri TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "time";
    localMAutoDBInfo.colsMap.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("weSeeUri"))
    {
      this.field_weSeeUri = paramContentValues.getAsString("weSeeUri");
      if (paramBoolean) {
        this.lnM = true;
      }
    }
    if (paramContentValues.containsKey("time"))
    {
      this.field_time = paramContentValues.getAsLong("time").longValue();
      if (paramBoolean) {
        this.jVl = true;
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
      if (lnN != k) {
        break label60;
      }
      this.field_weSeeUri = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jVE == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lnM) {
      localContentValues.put("weSeeUri", this.field_weSeeUri);
    }
    if (this.jVl) {
      localContentValues.put("time", Long.valueOf(this.field_time));
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
  
  public StorageObserverOwner<? extends iy> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.iy
 * JD-Core Version:    0.7.0.1
 */