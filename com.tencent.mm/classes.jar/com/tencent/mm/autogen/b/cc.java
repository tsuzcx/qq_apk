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

public abstract class cc
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FavOffline");
  public static final Column UPDATETIME;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jJJ;
  private static final int jKh;
  public static final Column jLQ;
  private static final int jLU;
  private static final int jPC;
  public static final Column jPu;
  public static final Column kjA;
  public static final Column kjB;
  public static final Column kjC;
  public static final Column kjD;
  public static final Column kjE;
  private static final int kjK;
  private static final int kjL;
  private static final int kjM;
  private static final int kjN;
  private static final int kjO;
  private static final StorageObserverOwner<cc> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public int field_failNum;
  public long field_favTime;
  public String field_imgDirPath;
  public String field_imgPaths;
  public int field_isReport;
  public String field_path;
  public long field_size;
  public int field_status;
  public long field_updateTime;
  public String field_url;
  private boolean jIC = true;
  private boolean jJV = true;
  private boolean jLS = true;
  private boolean jPy = true;
  private boolean kjF = true;
  private boolean kjG = true;
  private boolean kjH = true;
  private boolean kjI = true;
  private boolean kjJ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    kjA = new Column("imgDirPath", "string", TABLE.getName(), "");
    kjB = new Column("imgPaths", "string", TABLE.getName(), "");
    kjC = new Column("favTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kjD = new Column("failNum", "int", TABLE.getName(), "");
    kjE = new Column("isReport", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jPC = "url".hashCode();
    jLU = "size".hashCode();
    jKh = "path".hashCode();
    kjK = "imgDirPath".hashCode();
    kjL = "imgPaths".hashCode();
    kjM = "favTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jIF = "status".hashCode();
    kjN = "failNum".hashCode();
    kjO = "isReport".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "imgDirPath";
    localMAutoDBInfo.colsMap.put("imgDirPath", "TEXT");
    localStringBuilder.append(" imgDirPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "imgPaths";
    localMAutoDBInfo.colsMap.put("imgPaths", "TEXT");
    localStringBuilder.append(" imgPaths TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "favTime";
    localMAutoDBInfo.colsMap.put("favTime", "LONG");
    localStringBuilder.append(" favTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "failNum";
    localMAutoDBInfo.colsMap.put("failNum", "INTEGER");
    localStringBuilder.append(" failNum INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "isReport";
    localMAutoDBInfo.colsMap.put("isReport", "INTEGER");
    localStringBuilder.append(" isReport INTEGER");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("imgDirPath"))
    {
      this.field_imgDirPath = paramContentValues.getAsString("imgDirPath");
      if (paramBoolean) {
        this.kjF = true;
      }
    }
    if (paramContentValues.containsKey("imgPaths"))
    {
      this.field_imgPaths = paramContentValues.getAsString("imgPaths");
      if (paramBoolean) {
        this.kjG = true;
      }
    }
    if (paramContentValues.containsKey("favTime"))
    {
      this.field_favTime = paramContentValues.getAsLong("favTime").longValue();
      if (paramBoolean) {
        this.kjH = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("failNum"))
    {
      this.field_failNum = paramContentValues.getAsInteger("failNum").intValue();
      if (paramBoolean) {
        this.kjI = true;
      }
    }
    if (paramContentValues.containsKey("isReport"))
    {
      this.field_isReport = paramContentValues.getAsInteger("isReport").intValue();
      if (paramBoolean) {
        this.kjJ = true;
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
      if (jPC != k) {
        break label60;
      }
      this.field_url = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jLU == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (kjK == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (kjL == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (kjM == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kjN == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (kjO == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.kjF) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.kjG) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.kjH) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kjI) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.kjJ) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
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
  
  public StorageObserverOwner<? extends cc> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.cc
 * JD-Core Version:    0.7.0.1
 */