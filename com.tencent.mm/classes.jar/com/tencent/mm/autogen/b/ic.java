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

public abstract class ic
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("UxCanvasInfo");
  private static final int createTime_HASHCODE;
  public static final Column jUK;
  public static final Column jUL;
  private static final int jUO;
  private static final int jUP;
  public static final Column ldH;
  private static final int ldJ;
  private static final StorageObserverOwner<ic> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public String field_canvasExt;
  public String field_canvasId;
  public String field_canvasXml;
  public long field_createTime;
  private boolean jUM = true;
  private boolean jUN = true;
  private boolean ldI = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUK = new Column("canvasId", "string", TABLE.getName(), "");
    jUL = new Column("canvasXml", "string", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    ldH = new Column("canvasExt", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jUO = "canvasId".hashCode();
    jUP = "canvasXml".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    ldJ = "canvasExt".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "canvasId";
    localMAutoDBInfo.colsMap.put("canvasId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" canvasId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "canvasId";
    localMAutoDBInfo.columns[1] = "canvasXml";
    localMAutoDBInfo.colsMap.put("canvasXml", "TEXT");
    localStringBuilder.append(" canvasXml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "canvasExt";
    localMAutoDBInfo.colsMap.put("canvasExt", "TEXT");
    localStringBuilder.append(" canvasExt TEXT");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("canvasId"))
    {
      this.field_canvasId = paramContentValues.getAsString("canvasId");
      if (paramBoolean) {
        this.jUM = true;
      }
    }
    if (paramContentValues.containsKey("canvasXml"))
    {
      this.field_canvasXml = paramContentValues.getAsString("canvasXml");
      if (paramBoolean) {
        this.jUN = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("canvasExt"))
    {
      this.field_canvasExt = paramContentValues.getAsString("canvasExt");
      if (paramBoolean) {
        this.ldI = true;
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
      if (jUO != k) {
        break label65;
      }
      this.field_canvasId = paramCursor.getString(i);
      this.jUM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jUP == k) {
        this.field_canvasXml = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (ldJ == k) {
        this.field_canvasExt = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jUM) {
      localContentValues.put("canvasId", this.field_canvasId);
    }
    if (this.jUN) {
      localContentValues.put("canvasXml", this.field_canvasXml);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ldI) {
      localContentValues.put("canvasExt", this.field_canvasExt);
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
  
  public StorageObserverOwner<? extends ic> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_canvasId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ic
 * JD-Core Version:    0.7.0.1
 */