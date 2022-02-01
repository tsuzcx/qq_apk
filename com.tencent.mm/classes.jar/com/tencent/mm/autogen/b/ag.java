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

public abstract class ag
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizAppMsgReportContext");
  private static final int jPB;
  private static final int jPC;
  private static final int jPD;
  private static final int jPE;
  public static final Column jPt;
  public static final Column jPu;
  public static final Column jPv;
  public static final Column jPw;
  private static final StorageObserverOwner<ag> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_aScene;
  public long field_appMsgReportContextId;
  public long field_reportTime;
  public String field_url;
  private boolean jPA = true;
  private boolean jPx = true;
  private boolean jPy = true;
  private boolean jPz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPt = new Column("appMsgReportContextId", "long", TABLE.getName(), "");
    jPu = new Column("url", "string", TABLE.getName(), "");
    jPv = new Column("reportTime", "long", TABLE.getName(), "");
    jPw = new Column("aScene", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jPB = "appMsgReportContextId".hashCode();
    jPC = "url".hashCode();
    jPD = "reportTime".hashCode();
    jPE = "aScene".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appMsgReportContextId";
    localMAutoDBInfo.colsMap.put("appMsgReportContextId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appMsgReportContextId";
    localMAutoDBInfo.columns[1] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "reportTime";
    localMAutoDBInfo.colsMap.put("reportTime", "LONG");
    localStringBuilder.append(" reportTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "aScene";
    localMAutoDBInfo.colsMap.put("aScene", "INTEGER");
    localStringBuilder.append(" aScene INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appMsgReportContextId"))
    {
      this.field_appMsgReportContextId = paramContentValues.getAsLong("appMsgReportContextId").longValue();
      if (paramBoolean) {
        this.jPx = true;
      }
    }
    if (paramContentValues.containsKey("url"))
    {
      this.field_url = paramContentValues.getAsString("url");
      if (paramBoolean) {
        this.jPy = true;
      }
    }
    if (paramContentValues.containsKey("reportTime"))
    {
      this.field_reportTime = paramContentValues.getAsLong("reportTime").longValue();
      if (paramBoolean) {
        this.jPz = true;
      }
    }
    if (paramContentValues.containsKey("aScene"))
    {
      this.field_aScene = paramContentValues.getAsInteger("aScene").intValue();
      if (paramBoolean) {
        this.jPA = true;
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
      if (jPB != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.jPx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jPC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (jPD == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (jPE == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPx) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.jPy) {
      localContentValues.put("url", this.field_url);
    }
    if (this.jPz) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.jPA) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
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
  
  public StorageObserverOwner<? extends ag> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_appMsgReportContextId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ag
 * JD-Core Version:    0.7.0.1
 */