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

public abstract class hs
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("StoryCommentSync");
  public static final Column kKs;
  public static final Column kYO;
  public static final Column lbA;
  public static final Column lbB;
  private static final int lbI;
  private static final int lbJ;
  private static final int lbK;
  private static final int lbL;
  private static final int lbM;
  private static final int lbN;
  public static final Column lby;
  public static final Column lbz;
  private static final StorageObserverOwner<hs> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  private boolean lbC = true;
  private boolean lbD = true;
  private boolean lbE = true;
  private boolean lbF = true;
  private boolean lbG = true;
  private boolean lbH = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kKs = new Column("storyId", "long", TABLE.getName(), "");
    lby = new Column("readCommentId", "int", TABLE.getName(), "");
    lbz = new Column("syncCommentId", "int", TABLE.getName(), "");
    lbA = new Column("readCommentTime", "int", TABLE.getName(), "");
    lbB = new Column("syncCommentTime", "int", TABLE.getName(), "");
    kYO = new Column("commentFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lbI = "storyId".hashCode();
    lbJ = "readCommentId".hashCode();
    lbK = "syncCommentId".hashCode();
    lbL = "readCommentTime".hashCode();
    lbM = "syncCommentTime".hashCode();
    lbN = "commentFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyId";
    localMAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "storyId";
    localMAutoDBInfo.columns[1] = "readCommentId";
    localMAutoDBInfo.colsMap.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "syncCommentId";
    localMAutoDBInfo.colsMap.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "readCommentTime";
    localMAutoDBInfo.colsMap.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "syncCommentTime";
    localMAutoDBInfo.colsMap.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "commentFlag";
    localMAutoDBInfo.colsMap.put("commentFlag", "INTEGER");
    localStringBuilder.append(" commentFlag INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
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
    if (paramContentValues.containsKey("readCommentId"))
    {
      this.field_readCommentId = paramContentValues.getAsInteger("readCommentId").intValue();
      if (paramBoolean) {
        this.lbD = true;
      }
    }
    if (paramContentValues.containsKey("syncCommentId"))
    {
      this.field_syncCommentId = paramContentValues.getAsInteger("syncCommentId").intValue();
      if (paramBoolean) {
        this.lbE = true;
      }
    }
    if (paramContentValues.containsKey("readCommentTime"))
    {
      this.field_readCommentTime = paramContentValues.getAsInteger("readCommentTime").intValue();
      if (paramBoolean) {
        this.lbF = true;
      }
    }
    if (paramContentValues.containsKey("syncCommentTime"))
    {
      this.field_syncCommentTime = paramContentValues.getAsInteger("syncCommentTime").intValue();
      if (paramBoolean) {
        this.lbG = true;
      }
    }
    if (paramContentValues.containsKey("commentFlag"))
    {
      this.field_commentFlag = paramContentValues.getAsInteger("commentFlag").intValue();
      if (paramBoolean) {
        this.lbH = true;
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
      if (lbJ == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (lbK == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (lbL == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (lbM == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (lbN == k) {
        this.field_commentFlag = paramCursor.getInt(i);
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
    if (this.lbD) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.lbE) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.lbF) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.lbG) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.lbH) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
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
  
  public StorageObserverOwner<? extends hs> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.hs
 * JD-Core Version:    0.7.0.1
 */