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

public abstract class df
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderSnsKeyWordsJumpConfig");
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIY;
  private static final int jIZ;
  public static final Column kuE;
  public static final Column kuF;
  public static final Column kuG;
  public static final Column kuH;
  private static final int kuM;
  private static final int kuN;
  private static final int kuO;
  private static final int kuP;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<df> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetlocalId = true;
  public int field_endTime;
  public int field_jumpDest;
  public int field_jumpScene;
  public String field_keyWord;
  public long field_localId;
  public String field_passByInfo;
  public int field_startTime;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean kuI = true;
  private boolean kuJ = true;
  private boolean kuK = true;
  private boolean kuL = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    kuE = new Column("jumpScene", "int", TABLE.getName(), "");
    kuF = new Column("jumpDest", "int", TABLE.getName(), "");
    jIK = new Column("startTime", "int", TABLE.getName(), "");
    jIL = new Column("endTime", "int", TABLE.getName(), "");
    kuG = new Column("keyWord", "string", TABLE.getName(), "");
    kuH = new Column("passByInfo", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderSnsKeyWordsJumpInfo_local_index ON FinderSnsKeyWordsJumpConfig(localId)" };
    localId_HASHCODE = "localId".hashCode();
    kuM = "jumpScene".hashCode();
    kuN = "jumpDest".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    kuO = "keyWord".hashCode();
    kuP = "passByInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "jumpScene";
    localMAutoDBInfo.colsMap.put("jumpScene", "INTEGER default '-1' ");
    localStringBuilder.append(" jumpScene INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "jumpDest";
    localMAutoDBInfo.colsMap.put("jumpDest", "INTEGER default '-1' ");
    localStringBuilder.append(" jumpDest INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "INTEGER default '0' ");
    localStringBuilder.append(" startTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "INTEGER default '0' ");
    localStringBuilder.append(" endTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "keyWord";
    localMAutoDBInfo.colsMap.put("keyWord", "TEXT");
    localStringBuilder.append(" keyWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "passByInfo";
    localMAutoDBInfo.colsMap.put("passByInfo", "TEXT");
    localStringBuilder.append(" passByInfo TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsLong("localId").longValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("jumpScene"))
    {
      this.field_jumpScene = paramContentValues.getAsInteger("jumpScene").intValue();
      if (paramBoolean) {
        this.kuI = true;
      }
    }
    if (paramContentValues.containsKey("jumpDest"))
    {
      this.field_jumpDest = paramContentValues.getAsInteger("jumpDest").intValue();
      if (paramBoolean) {
        this.kuJ = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsInteger("startTime").intValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("endTime"))
    {
      this.field_endTime = paramContentValues.getAsInteger("endTime").intValue();
      if (paramBoolean) {
        this.jIS = true;
      }
    }
    if (paramContentValues.containsKey("keyWord"))
    {
      this.field_keyWord = paramContentValues.getAsString("keyWord");
      if (paramBoolean) {
        this.kuK = true;
      }
    }
    if (paramContentValues.containsKey("passByInfo"))
    {
      this.field_passByInfo = paramContentValues.getAsString("passByInfo");
      if (paramBoolean) {
        this.kuL = true;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kuM == k) {
        this.field_jumpScene = paramCursor.getInt(i);
      } else if (kuN == k) {
        this.field_jumpDest = paramCursor.getInt(i);
      } else if (jIY == k) {
        this.field_startTime = paramCursor.getInt(i);
      } else if (jIZ == k) {
        this.field_endTime = paramCursor.getInt(i);
      } else if (kuO == k) {
        this.field_keyWord = paramCursor.getString(i);
      } else if (kuP == k) {
        this.field_passByInfo = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.kuI) {
      localContentValues.put("jumpScene", Integer.valueOf(this.field_jumpScene));
    }
    if (this.kuJ) {
      localContentValues.put("jumpDest", Integer.valueOf(this.field_jumpDest));
    }
    if (this.jIR) {
      localContentValues.put("startTime", Integer.valueOf(this.field_startTime));
    }
    if (this.jIS) {
      localContentValues.put("endTime", Integer.valueOf(this.field_endTime));
    }
    if (this.kuK) {
      localContentValues.put("keyWord", this.field_keyWord);
    }
    if (this.kuL) {
      localContentValues.put("passByInfo", this.field_passByInfo);
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
  
  public StorageObserverOwner<? extends df> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.df
 * JD-Core Version:    0.7.0.1
 */