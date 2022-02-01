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

public abstract class bt
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmotionRewardTipInfo");
  private static final int jNY;
  public static final Column jNg;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column kgL;
  public static final Column kgM;
  public static final Column kgN;
  public static final Column kgO;
  public static final Column kgP;
  private static final int kgV;
  private static final int kgW;
  private static final int kgX;
  private static final int kgY;
  private static final int kgZ;
  private static final StorageObserverOwner<bt> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  private boolean jNC = true;
  private boolean jOX = true;
  private boolean kgQ = true;
  private boolean kgR = true;
  private boolean kgS = true;
  private boolean kgT = true;
  private boolean kgU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kgL = new Column("prodcutID", "string", TABLE.getName(), "");
    kgM = new Column("totalCount", "int", TABLE.getName(), "");
    kgN = new Column("continuCount", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    jNg = new Column("modifyTime", "long", TABLE.getName(), "");
    kgO = new Column("showTipsTime", "long", TABLE.getName(), "");
    kgP = new Column("setFlagTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kgV = "prodcutID".hashCode();
    kgW = "totalCount".hashCode();
    kgX = "continuCount".hashCode();
    jOZ = "flag".hashCode();
    jNY = "modifyTime".hashCode();
    kgY = "showTipsTime".hashCode();
    kgZ = "setFlagTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "prodcutID";
    localMAutoDBInfo.colsMap.put("prodcutID", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" prodcutID TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "prodcutID";
    localMAutoDBInfo.columns[1] = "totalCount";
    localMAutoDBInfo.colsMap.put("totalCount", "INTEGER");
    localStringBuilder.append(" totalCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "continuCount";
    localMAutoDBInfo.colsMap.put("continuCount", "INTEGER");
    localStringBuilder.append(" continuCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG");
    localStringBuilder.append(" modifyTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "showTipsTime";
    localMAutoDBInfo.colsMap.put("showTipsTime", "LONG");
    localStringBuilder.append(" showTipsTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "setFlagTime";
    localMAutoDBInfo.colsMap.put("setFlagTime", "LONG");
    localStringBuilder.append(" setFlagTime LONG");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("prodcutID"))
    {
      this.field_prodcutID = paramContentValues.getAsString("prodcutID");
      if (paramBoolean) {
        this.kgQ = true;
      }
    }
    if (paramContentValues.containsKey("totalCount"))
    {
      this.field_totalCount = paramContentValues.getAsInteger("totalCount").intValue();
      if (paramBoolean) {
        this.kgR = true;
      }
    }
    if (paramContentValues.containsKey("continuCount"))
    {
      this.field_continuCount = paramContentValues.getAsInteger("continuCount").intValue();
      if (paramBoolean) {
        this.kgS = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("modifyTime"))
    {
      this.field_modifyTime = paramContentValues.getAsLong("modifyTime").longValue();
      if (paramBoolean) {
        this.jNC = true;
      }
    }
    if (paramContentValues.containsKey("showTipsTime"))
    {
      this.field_showTipsTime = paramContentValues.getAsLong("showTipsTime").longValue();
      if (paramBoolean) {
        this.kgT = true;
      }
    }
    if (paramContentValues.containsKey("setFlagTime"))
    {
      this.field_setFlagTime = paramContentValues.getAsLong("setFlagTime").longValue();
      if (paramBoolean) {
        this.kgU = true;
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
      if (kgV != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.kgQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kgW == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (kgX == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (jNY == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (kgY == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (kgZ == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kgQ) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.kgR) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.kgS) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.jNC) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.kgT) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.kgU) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
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
  
  public StorageObserverOwner<? extends bt> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_prodcutID;
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
 * Qualified Name:     com.tencent.mm.autogen.b.bt
 * JD-Core Version:    0.7.0.1
 */