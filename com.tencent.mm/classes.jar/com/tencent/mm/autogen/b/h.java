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

public abstract class h
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AiFinderRedDotInfo");
  private static final int jJD;
  public static final Column jJF;
  public static final Column jJG;
  public static final Column jJH;
  public static final Column jJI;
  public static final Column jJJ;
  public static final Column jJK;
  public static final Column jJL;
  public static final Column jJM;
  public static final Column jJN;
  public static final Column jJO;
  public static final Column jJP;
  public static final Column jJQ;
  public static final Column jJz;
  private static final int jKd;
  private static final int jKe;
  private static final int jKf;
  private static final int jKg;
  private static final int jKh;
  private static final int jKi;
  private static final int jKj;
  private static final int jKk;
  private static final int jKl;
  private static final int jKm;
  private static final int jKn;
  private static final int jKo;
  private static final StorageObserverOwner<h> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_ctrlType;
  public int field_ds;
  public long field_enterBusinessMs;
  public int field_exposeCount;
  public long field_exposeDuration;
  public long field_exposeFirstMs;
  public long field_exposeLastMs;
  public String field_path;
  public long field_receTimeMs;
  public int field_scene;
  public int field_showType;
  public String field_tipsId;
  public long field_urlHash;
  private boolean jJB = true;
  private boolean jJR = true;
  private boolean jJS = true;
  private boolean jJT = true;
  private boolean jJU = true;
  private boolean jJV = true;
  private boolean jJW = true;
  private boolean jJX = true;
  private boolean jJY = true;
  private boolean jJZ = true;
  private boolean jKa = true;
  private boolean jKb = true;
  private boolean jKc = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jJF = new Column("tipsId", "string", TABLE.getName(), "");
    jJG = new Column("ds", "int", TABLE.getName(), "");
    jJH = new Column("ctrlType", "int", TABLE.getName(), "");
    jJI = new Column("showType", "int", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    jJK = new Column("urlHash", "long", TABLE.getName(), "");
    jJL = new Column("receTimeMs", "long", TABLE.getName(), "");
    jJM = new Column("exposeCount", "int", TABLE.getName(), "");
    jJN = new Column("exposeDuration", "long", TABLE.getName(), "");
    jJO = new Column("exposeFirstMs", "long", TABLE.getName(), "");
    jJP = new Column("exposeLastMs", "long", TABLE.getName(), "");
    jJQ = new Column("enterBusinessMs", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKd = "tipsId".hashCode();
    jKe = "ds".hashCode();
    jKf = "ctrlType".hashCode();
    jKg = "showType".hashCode();
    jKh = "path".hashCode();
    jJD = "scene".hashCode();
    jKi = "urlHash".hashCode();
    jKj = "receTimeMs".hashCode();
    jKk = "exposeCount".hashCode();
    jKl = "exposeDuration".hashCode();
    jKm = "exposeFirstMs".hashCode();
    jKn = "exposeLastMs".hashCode();
    jKo = "enterBusinessMs".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tipsId";
    localMAutoDBInfo.colsMap.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tipsId";
    localMAutoDBInfo.columns[1] = "ds";
    localMAutoDBInfo.colsMap.put("ds", "INTEGER");
    localStringBuilder.append(" ds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ctrlType";
    localMAutoDBInfo.colsMap.put("ctrlType", "INTEGER");
    localStringBuilder.append(" ctrlType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "showType";
    localMAutoDBInfo.colsMap.put("showType", "INTEGER");
    localStringBuilder.append(" showType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "urlHash";
    localMAutoDBInfo.colsMap.put("urlHash", "LONG");
    localStringBuilder.append(" urlHash LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "receTimeMs";
    localMAutoDBInfo.colsMap.put("receTimeMs", "LONG");
    localStringBuilder.append(" receTimeMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "exposeCount";
    localMAutoDBInfo.colsMap.put("exposeCount", "INTEGER");
    localStringBuilder.append(" exposeCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "exposeDuration";
    localMAutoDBInfo.colsMap.put("exposeDuration", "LONG");
    localStringBuilder.append(" exposeDuration LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "exposeFirstMs";
    localMAutoDBInfo.colsMap.put("exposeFirstMs", "LONG");
    localStringBuilder.append(" exposeFirstMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "exposeLastMs";
    localMAutoDBInfo.colsMap.put("exposeLastMs", "LONG");
    localStringBuilder.append(" exposeLastMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "enterBusinessMs";
    localMAutoDBInfo.colsMap.put("enterBusinessMs", "LONG");
    localStringBuilder.append(" enterBusinessMs LONG");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("tipsId"))
    {
      this.field_tipsId = paramContentValues.getAsString("tipsId");
      if (paramBoolean) {
        this.jJR = true;
      }
    }
    if (paramContentValues.containsKey("ds"))
    {
      this.field_ds = paramContentValues.getAsInteger("ds").intValue();
      if (paramBoolean) {
        this.jJS = true;
      }
    }
    if (paramContentValues.containsKey("ctrlType"))
    {
      this.field_ctrlType = paramContentValues.getAsInteger("ctrlType").intValue();
      if (paramBoolean) {
        this.jJT = true;
      }
    }
    if (paramContentValues.containsKey("showType"))
    {
      this.field_showType = paramContentValues.getAsInteger("showType").intValue();
      if (paramBoolean) {
        this.jJU = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("urlHash"))
    {
      this.field_urlHash = paramContentValues.getAsLong("urlHash").longValue();
      if (paramBoolean) {
        this.jJW = true;
      }
    }
    if (paramContentValues.containsKey("receTimeMs"))
    {
      this.field_receTimeMs = paramContentValues.getAsLong("receTimeMs").longValue();
      if (paramBoolean) {
        this.jJX = true;
      }
    }
    if (paramContentValues.containsKey("exposeCount"))
    {
      this.field_exposeCount = paramContentValues.getAsInteger("exposeCount").intValue();
      if (paramBoolean) {
        this.jJY = true;
      }
    }
    if (paramContentValues.containsKey("exposeDuration"))
    {
      this.field_exposeDuration = paramContentValues.getAsLong("exposeDuration").longValue();
      if (paramBoolean) {
        this.jJZ = true;
      }
    }
    if (paramContentValues.containsKey("exposeFirstMs"))
    {
      this.field_exposeFirstMs = paramContentValues.getAsLong("exposeFirstMs").longValue();
      if (paramBoolean) {
        this.jKa = true;
      }
    }
    if (paramContentValues.containsKey("exposeLastMs"))
    {
      this.field_exposeLastMs = paramContentValues.getAsLong("exposeLastMs").longValue();
      if (paramBoolean) {
        this.jKb = true;
      }
    }
    if (paramContentValues.containsKey("enterBusinessMs"))
    {
      this.field_enterBusinessMs = paramContentValues.getAsLong("enterBusinessMs").longValue();
      if (paramBoolean) {
        this.jKc = true;
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
      if (jKd != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.jJR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKe == k) {
        this.field_ds = paramCursor.getInt(i);
      } else if (jKf == k) {
        this.field_ctrlType = paramCursor.getInt(i);
      } else if (jKg == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (jKi == k) {
        this.field_urlHash = paramCursor.getLong(i);
      } else if (jKj == k) {
        this.field_receTimeMs = paramCursor.getLong(i);
      } else if (jKk == k) {
        this.field_exposeCount = paramCursor.getInt(i);
      } else if (jKl == k) {
        this.field_exposeDuration = paramCursor.getLong(i);
      } else if (jKm == k) {
        this.field_exposeFirstMs = paramCursor.getLong(i);
      } else if (jKn == k) {
        this.field_exposeLastMs = paramCursor.getLong(i);
      } else if (jKo == k) {
        this.field_enterBusinessMs = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jJR) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if (this.jJS) {
      localContentValues.put("ds", Integer.valueOf(this.field_ds));
    }
    if (this.jJT) {
      localContentValues.put("ctrlType", Integer.valueOf(this.field_ctrlType));
    }
    if (this.jJU) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.jJW) {
      localContentValues.put("urlHash", Long.valueOf(this.field_urlHash));
    }
    if (this.jJX) {
      localContentValues.put("receTimeMs", Long.valueOf(this.field_receTimeMs));
    }
    if (this.jJY) {
      localContentValues.put("exposeCount", Integer.valueOf(this.field_exposeCount));
    }
    if (this.jJZ) {
      localContentValues.put("exposeDuration", Long.valueOf(this.field_exposeDuration));
    }
    if (this.jKa) {
      localContentValues.put("exposeFirstMs", Long.valueOf(this.field_exposeFirstMs));
    }
    if (this.jKb) {
      localContentValues.put("exposeLastMs", Long.valueOf(this.field_exposeLastMs));
    }
    if (this.jKc) {
      localContentValues.put("enterBusinessMs", Long.valueOf(this.field_enterBusinessMs));
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
  
  public StorageObserverOwner<? extends h> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_tipsId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.h
 * JD-Core Version:    0.7.0.1
 */