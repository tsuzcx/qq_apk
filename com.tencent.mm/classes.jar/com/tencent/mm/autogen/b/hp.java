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

public abstract class hp
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsWsFoldGroup");
  public static final Column jLQ;
  private static final int jLU;
  public static final Column kee;
  private static final int kfH;
  public static final Column lbl;
  public static final Column lbm;
  private static final int lbp;
  private static final int lbq;
  private static final StorageObserverOwner<hp> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_bottom;
  public int field_size;
  public int field_state;
  public long field_top;
  private boolean jLS = true;
  private boolean keT = true;
  private boolean lbn = true;
  private boolean lbo = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lbl = new Column("top", "long", TABLE.getName(), "");
    lbm = new Column("bottom", "long", TABLE.getName(), "");
    jLQ = new Column("size", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lbp = "top".hashCode();
    lbq = "bottom".hashCode();
    jLU = "size".hashCode();
    kfH = "state".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "top";
    localMAutoDBInfo.colsMap.put("top", "LONG");
    localStringBuilder.append(" top LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "bottom";
    localMAutoDBInfo.colsMap.put("bottom", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bottom LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bottom";
    localMAutoDBInfo.columns[2] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("top"))
    {
      this.field_top = paramContentValues.getAsLong("top").longValue();
      if (paramBoolean) {
        this.lbn = true;
      }
    }
    if (paramContentValues.containsKey("bottom"))
    {
      this.field_bottom = paramContentValues.getAsLong("bottom").longValue();
      if (paramBoolean) {
        this.lbo = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsInteger("size").intValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
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
      if (lbp != k) {
        break label60;
      }
      this.field_top = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (lbq == k)
      {
        this.field_bottom = paramCursor.getLong(i);
        this.lbo = true;
      }
      else if (jLU == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (kfH == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lbn) {
      localContentValues.put("top", Long.valueOf(this.field_top));
    }
    if (this.lbo) {
      localContentValues.put("bottom", Long.valueOf(this.field_bottom));
    }
    if (this.jLS) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
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
  
  public StorageObserverOwner<? extends hp> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_bottom);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hp
 * JD-Core Version:    0.7.0.1
 */