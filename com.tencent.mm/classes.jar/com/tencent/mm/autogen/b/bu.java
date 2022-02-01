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

public abstract class bu
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("ExptItem");
  public static final Column jIK;
  public static final Column jIL;
  private static final int jIY;
  private static final int jIZ;
  public static final Column kel;
  private static final int kfO;
  public static final Column kha;
  public static final Column khb;
  public static final Column khc;
  public static final Column khd;
  public static final Column khe;
  private static final int khk;
  private static final int khl;
  private static final int khm;
  private static final int khn;
  private static final int kho;
  private static final StorageObserverOwner<bu> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int subType_HASHCODE;
  private boolean __hadSetsubType = true;
  public long field_endTime;
  public String field_exptCheckSum;
  public String field_exptContent;
  public int field_exptId;
  public int field_exptSeq;
  public int field_exptType;
  public int field_groupId;
  public long field_startTime;
  public int field_subType;
  private boolean jIR = true;
  private boolean jIS = true;
  private boolean kfa = true;
  private boolean khf = true;
  private boolean khg = true;
  private boolean khh = true;
  private boolean khi = true;
  private boolean khj = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kha = new Column("exptId", "int", TABLE.getName(), "");
    kel = new Column("groupId", "int", TABLE.getName(), "");
    khb = new Column("exptSeq", "int", TABLE.getName(), "");
    khc = new Column("exptContent", "string", TABLE.getName(), "");
    jIK = new Column("startTime", "long", TABLE.getName(), "");
    jIL = new Column("endTime", "long", TABLE.getName(), "");
    khd = new Column("exptType", "int", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "int", TABLE.getName(), "");
    khe = new Column("exptCheckSum", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    khk = "exptId".hashCode();
    kfO = "groupId".hashCode();
    khl = "exptSeq".hashCode();
    khm = "exptContent".hashCode();
    jIY = "startTime".hashCode();
    jIZ = "endTime".hashCode();
    khn = "exptType".hashCode();
    subType_HASHCODE = "subType".hashCode();
    kho = "exptCheckSum".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "exptId";
    localMAutoDBInfo.colsMap.put("exptId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" exptId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "exptId";
    localMAutoDBInfo.columns[1] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "INTEGER");
    localStringBuilder.append(" groupId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "exptSeq";
    localMAutoDBInfo.colsMap.put("exptSeq", "INTEGER");
    localStringBuilder.append(" exptSeq INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "exptContent";
    localMAutoDBInfo.colsMap.put("exptContent", "TEXT");
    localStringBuilder.append(" exptContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "startTime";
    localMAutoDBInfo.colsMap.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "endTime";
    localMAutoDBInfo.colsMap.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "exptType";
    localMAutoDBInfo.colsMap.put("exptType", "INTEGER");
    localStringBuilder.append(" exptType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "subType";
    localMAutoDBInfo.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "exptCheckSum";
    localMAutoDBInfo.colsMap.put("exptCheckSum", "TEXT");
    localStringBuilder.append(" exptCheckSum TEXT");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("exptId"))
    {
      this.field_exptId = paramContentValues.getAsInteger("exptId").intValue();
      if (paramBoolean) {
        this.khf = true;
      }
    }
    if (paramContentValues.containsKey("groupId"))
    {
      this.field_groupId = paramContentValues.getAsInteger("groupId").intValue();
      if (paramBoolean) {
        this.kfa = true;
      }
    }
    if (paramContentValues.containsKey("exptSeq"))
    {
      this.field_exptSeq = paramContentValues.getAsInteger("exptSeq").intValue();
      if (paramBoolean) {
        this.khg = true;
      }
    }
    if (paramContentValues.containsKey("exptContent"))
    {
      this.field_exptContent = paramContentValues.getAsString("exptContent");
      if (paramBoolean) {
        this.khh = true;
      }
    }
    if (paramContentValues.containsKey("startTime"))
    {
      this.field_startTime = paramContentValues.getAsLong("startTime").longValue();
      if (paramBoolean) {
        this.jIR = true;
      }
    }
    if (paramContentValues.containsKey("endTime"))
    {
      this.field_endTime = paramContentValues.getAsLong("endTime").longValue();
      if (paramBoolean) {
        this.jIS = true;
      }
    }
    if (paramContentValues.containsKey("exptType"))
    {
      this.field_exptType = paramContentValues.getAsInteger("exptType").intValue();
      if (paramBoolean) {
        this.khi = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsInteger("subType").intValue();
      if (paramBoolean) {
        this.__hadSetsubType = true;
      }
    }
    if (paramContentValues.containsKey("exptCheckSum"))
    {
      this.field_exptCheckSum = paramContentValues.getAsString("exptCheckSum");
      if (paramBoolean) {
        this.khj = true;
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
      if (khk != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.khf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfO == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (khl == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (khm == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (jIY == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (jIZ == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (khn == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (kho == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.khf) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.kfa) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.khg) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.khh) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.jIR) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.jIS) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.khi) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.khj) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
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
  
  public StorageObserverOwner<? extends bu> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_exptId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.bu
 * JD-Core Version:    0.7.0.1
 */