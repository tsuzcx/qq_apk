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

public abstract class iv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WechatSessionHistory");
  public static final Column jJG;
  private static final int jKe;
  public static final Column ktO;
  private static final int ktY;
  private static final int lmA;
  private static final int lmB;
  private static final int lmC;
  private static final int lmD;
  private static final int lmE;
  private static final int lmF;
  public static final Column lmo;
  public static final Column lmp;
  public static final Column lmq;
  public static final Column lmr;
  public static final Column lms;
  public static final Column lmt;
  private static final StorageObserverOwner<iv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_currSession;
  public int field_ds;
  public long field_enterMs;
  public int field_hour;
  public String field_lastSession;
  public String field_nextSession;
  public long field_quitMs;
  public long field_stayMs;
  private boolean jJS = true;
  private boolean ktT = true;
  private boolean lmu = true;
  private boolean lmv = true;
  private boolean lmw = true;
  private boolean lmx = true;
  private boolean lmy = true;
  private boolean lmz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jJG = new Column("ds", "int", TABLE.getName(), "");
    ktO = new Column("hour", "int", TABLE.getName(), "");
    lmo = new Column("lastSession", "string", TABLE.getName(), "");
    lmp = new Column("currSession", "string", TABLE.getName(), "");
    lmq = new Column("nextSession", "string", TABLE.getName(), "");
    lmr = new Column("enterMs", "long", TABLE.getName(), "");
    lms = new Column("quitMs", "long", TABLE.getName(), "");
    lmt = new Column("stayMs", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKe = "ds".hashCode();
    ktY = "hour".hashCode();
    lmA = "lastSession".hashCode();
    lmB = "currSession".hashCode();
    lmC = "nextSession".hashCode();
    lmD = "enterMs".hashCode();
    lmE = "quitMs".hashCode();
    lmF = "stayMs".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "ds";
    localMAutoDBInfo.colsMap.put("ds", "INTEGER");
    localStringBuilder.append(" ds INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "hour";
    localMAutoDBInfo.colsMap.put("hour", "INTEGER");
    localStringBuilder.append(" hour INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "lastSession";
    localMAutoDBInfo.colsMap.put("lastSession", "TEXT");
    localStringBuilder.append(" lastSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "currSession";
    localMAutoDBInfo.colsMap.put("currSession", "TEXT");
    localStringBuilder.append(" currSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nextSession";
    localMAutoDBInfo.colsMap.put("nextSession", "TEXT");
    localStringBuilder.append(" nextSession TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "enterMs";
    localMAutoDBInfo.colsMap.put("enterMs", "LONG");
    localStringBuilder.append(" enterMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "quitMs";
    localMAutoDBInfo.colsMap.put("quitMs", "LONG");
    localStringBuilder.append(" quitMs LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "stayMs";
    localMAutoDBInfo.colsMap.put("stayMs", "LONG");
    localStringBuilder.append(" stayMs LONG");
    localMAutoDBInfo.columns[8] = "rowid";
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
    if (paramContentValues.containsKey("lastSession"))
    {
      this.field_lastSession = paramContentValues.getAsString("lastSession");
      if (paramBoolean) {
        this.lmu = true;
      }
    }
    if (paramContentValues.containsKey("currSession"))
    {
      this.field_currSession = paramContentValues.getAsString("currSession");
      if (paramBoolean) {
        this.lmv = true;
      }
    }
    if (paramContentValues.containsKey("nextSession"))
    {
      this.field_nextSession = paramContentValues.getAsString("nextSession");
      if (paramBoolean) {
        this.lmw = true;
      }
    }
    if (paramContentValues.containsKey("enterMs"))
    {
      this.field_enterMs = paramContentValues.getAsLong("enterMs").longValue();
      if (paramBoolean) {
        this.lmx = true;
      }
    }
    if (paramContentValues.containsKey("quitMs"))
    {
      this.field_quitMs = paramContentValues.getAsLong("quitMs").longValue();
      if (paramBoolean) {
        this.lmy = true;
      }
    }
    if (paramContentValues.containsKey("stayMs"))
    {
      this.field_stayMs = paramContentValues.getAsLong("stayMs").longValue();
      if (paramBoolean) {
        this.lmz = true;
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
      } else if (lmA == k) {
        this.field_lastSession = paramCursor.getString(i);
      } else if (lmB == k) {
        this.field_currSession = paramCursor.getString(i);
      } else if (lmC == k) {
        this.field_nextSession = paramCursor.getString(i);
      } else if (lmD == k) {
        this.field_enterMs = paramCursor.getLong(i);
      } else if (lmE == k) {
        this.field_quitMs = paramCursor.getLong(i);
      } else if (lmF == k) {
        this.field_stayMs = paramCursor.getLong(i);
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
    if (this.lmu) {
      localContentValues.put("lastSession", this.field_lastSession);
    }
    if (this.lmv) {
      localContentValues.put("currSession", this.field_currSession);
    }
    if (this.lmw) {
      localContentValues.put("nextSession", this.field_nextSession);
    }
    if (this.lmx) {
      localContentValues.put("enterMs", Long.valueOf(this.field_enterMs));
    }
    if (this.lmy) {
      localContentValues.put("quitMs", Long.valueOf(this.field_quitMs));
    }
    if (this.lmz) {
      localContentValues.put("stayMs", Long.valueOf(this.field_stayMs));
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
  
  public StorageObserverOwner<? extends iv> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.iv
 * JD-Core Version:    0.7.0.1
 */