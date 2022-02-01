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

public abstract class hw
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("StoryVideoCacheInfo");
  private static final int jPC;
  public static final Column jPu;
  private static final int jWL;
  public static final Column jWv;
  public static final Column kKs;
  public static final Column kkI;
  private static final int klQ;
  private static final int ktA;
  public static final Column ktc;
  private static final int lbI;
  private static final StorageObserverOwner<hw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  private boolean jPy = true;
  private boolean jWD = true;
  private boolean klm = true;
  private boolean kto = true;
  private boolean lbC = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kKs = new Column("storyId", "long", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    jWv = new Column("filePath", "string", TABLE.getName(), "");
    kkI = new Column("totalSize", "int", TABLE.getName(), "");
    ktc = new Column("cacheSize", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lbI = "storyId".hashCode();
    jPC = "url".hashCode();
    jWL = "filePath".hashCode();
    klQ = "totalSize".hashCode();
    ktA = "cacheSize".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyId";
    localMAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "storyId";
    localMAutoDBInfo.columns[1] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "totalSize";
    localMAutoDBInfo.colsMap.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "cacheSize";
    localMAutoDBInfo.colsMap.put("cacheSize", "INTEGER");
    localStringBuilder.append(" cacheSize INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("storyId"))
    {
      this.field_storyId = paramContentValues.getAsLong("storyId").longValue();
      if (paramBoolean) {
        this.lbC = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("filePath"))
    {
      this.field_filePath = paramContentValues.getAsString("filePath");
      if (paramBoolean) {
        this.jWD = true;
      }
    }
    if (paramContentValues.containsKey("totalSize"))
    {
      this.field_totalSize = paramContentValues.getAsInteger("totalSize").intValue();
      if (paramBoolean) {
        this.klm = true;
      }
    }
    if (paramContentValues.containsKey("cacheSize"))
    {
      this.field_cacheSize = paramContentValues.getAsInteger("cacheSize").intValue();
      if (paramBoolean) {
        this.kto = true;
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
      if (lbI != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.lbC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jPC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (jWL == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (klQ == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (ktA == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lbC) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.jWD) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.klm) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.kto) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
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
  
  public StorageObserverOwner<? extends hw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_storyId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hw
 * JD-Core Version:    0.7.0.1
 */