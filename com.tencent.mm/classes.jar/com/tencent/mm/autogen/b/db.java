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

public abstract class db
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderRedDotHistory");
  public static final Column jJG;
  private static final int jKe;
  public static final Column ktO;
  public static final Column ktP;
  public static final Column ktQ;
  public static final Column ktR;
  public static final Column ktS;
  private static final int ktY;
  private static final int ktZ;
  private static final int kua;
  private static final int kub;
  private static final int kuc;
  private static final StorageObserverOwner<db> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_actionMs;
  public int field_ds;
  public int field_hadFinderLiveRedDot;
  public int field_hadFinderRedDot;
  public int field_hour;
  public int field_isGoToFinderUI;
  private boolean jJS = true;
  private boolean ktT = true;
  private boolean ktU = true;
  private boolean ktV = true;
  private boolean ktW = true;
  private boolean ktX = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jJG = new Column("ds", "int", TABLE.getName(), "");
    ktO = new Column("hour", "int", TABLE.getName(), "");
    ktP = new Column("actionMs", "long", TABLE.getName(), "");
    ktQ = new Column("isGoToFinderUI", "int", TABLE.getName(), "");
    ktR = new Column("hadFinderRedDot", "int", TABLE.getName(), "");
    ktS = new Column("hadFinderLiveRedDot", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKe = "ds".hashCode();
    ktY = "hour".hashCode();
    ktZ = "actionMs".hashCode();
    kua = "isGoToFinderUI".hashCode();
    kub = "hadFinderRedDot".hashCode();
    kuc = "hadFinderLiveRedDot".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ds";
    localMAutoDBInfo.colsMap.put("ds", "INTEGER");
    localStringBuilder.append(" ds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "hour";
    localMAutoDBInfo.colsMap.put("hour", "INTEGER");
    localStringBuilder.append(" hour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "actionMs";
    localMAutoDBInfo.colsMap.put("actionMs", "LONG");
    localStringBuilder.append(" actionMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isGoToFinderUI";
    localMAutoDBInfo.colsMap.put("isGoToFinderUI", "INTEGER");
    localStringBuilder.append(" isGoToFinderUI INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "hadFinderRedDot";
    localMAutoDBInfo.colsMap.put("hadFinderRedDot", "INTEGER");
    localStringBuilder.append(" hadFinderRedDot INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hadFinderLiveRedDot";
    localMAutoDBInfo.colsMap.put("hadFinderLiveRedDot", "INTEGER");
    localStringBuilder.append(" hadFinderLiveRedDot INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("ds"))
    {
      this.field_ds = paramContentValues.getAsInteger("ds").intValue();
      if (paramBoolean) {
        this.jJS = true;
      }
    }
    if (paramContentValues.containsKey("hour"))
    {
      this.field_hour = paramContentValues.getAsInteger("hour").intValue();
      if (paramBoolean) {
        this.ktT = true;
      }
    }
    if (paramContentValues.containsKey("actionMs"))
    {
      this.field_actionMs = paramContentValues.getAsLong("actionMs").longValue();
      if (paramBoolean) {
        this.ktU = true;
      }
    }
    if (paramContentValues.containsKey("isGoToFinderUI"))
    {
      this.field_isGoToFinderUI = paramContentValues.getAsInteger("isGoToFinderUI").intValue();
      if (paramBoolean) {
        this.ktV = true;
      }
    }
    if (paramContentValues.containsKey("hadFinderRedDot"))
    {
      this.field_hadFinderRedDot = paramContentValues.getAsInteger("hadFinderRedDot").intValue();
      if (paramBoolean) {
        this.ktW = true;
      }
    }
    if (paramContentValues.containsKey("hadFinderLiveRedDot"))
    {
      this.field_hadFinderLiveRedDot = paramContentValues.getAsInteger("hadFinderLiveRedDot").intValue();
      if (paramBoolean) {
        this.ktX = true;
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
      if (jKe != k) {
        break label60;
      }
      this.field_ds = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ktY == k) {
        this.field_hour = paramCursor.getInt(i);
      } else if (ktZ == k) {
        this.field_actionMs = paramCursor.getLong(i);
      } else if (kua == k) {
        this.field_isGoToFinderUI = paramCursor.getInt(i);
      } else if (kub == k) {
        this.field_hadFinderRedDot = paramCursor.getInt(i);
      } else if (kuc == k) {
        this.field_hadFinderLiveRedDot = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jJS) {
      localContentValues.put("ds", Integer.valueOf(this.field_ds));
    }
    if (this.ktT) {
      localContentValues.put("hour", Integer.valueOf(this.field_hour));
    }
    if (this.ktU) {
      localContentValues.put("actionMs", Long.valueOf(this.field_actionMs));
    }
    if (this.ktV) {
      localContentValues.put("isGoToFinderUI", Integer.valueOf(this.field_isGoToFinderUI));
    }
    if (this.ktW) {
      localContentValues.put("hadFinderRedDot", Integer.valueOf(this.field_hadFinderRedDot));
    }
    if (this.ktX) {
      localContentValues.put("hadFinderLiveRedDot", Integer.valueOf(this.field_hadFinderLiveRedDot));
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
  
  public StorageObserverOwner<? extends db> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.db
 * JD-Core Version:    0.7.0.1
 */