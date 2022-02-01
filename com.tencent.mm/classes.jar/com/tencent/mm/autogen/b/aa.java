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

public abstract class aa
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AppMessage");
  public static final Column TYPE;
  public static final Column jIo;
  private static final int jIw;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jMN;
  private static final int jMX;
  public static final Column jOM;
  public static final Column jON;
  public static final Column jOO;
  private static final int jOS;
  private static final int jOT;
  private static final int jOU;
  private static final StorageObserverOwner<aa> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  private boolean jIs = true;
  private boolean jKG = true;
  private boolean jMS = true;
  private boolean jOP = true;
  private boolean jOQ = true;
  private boolean jOR = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jOM = new Column("xml", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    jOO = new Column("description", "string", TABLE.getName(), "");
    jMN = new Column("source", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    jOS = "xml".hashCode();
    jKX = "appId".hashCode();
    jOT = "title".hashCode();
    jOU = "description".hashCode();
    jMX = "source".hashCode();
    type_HASHCODE = "type".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "xml";
    localMAutoDBInfo.colsMap.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "source";
    localMAutoDBInfo.colsMap.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("xml"))
    {
      this.field_xml = paramContentValues.getAsString("xml");
      if (paramBoolean) {
        this.jOP = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("description"))
    {
      this.field_description = paramContentValues.getAsString("description");
      if (paramBoolean) {
        this.jOR = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsString("source");
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
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
      if (jIw != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.jIs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jOS == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (jOU == k) {
        this.field_description = paramCursor.getString(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.jOP) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.jOR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.jMS) {
      localContentValues.put("source", this.field_source);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
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
  
  public StorageObserverOwner<? extends aa> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.aa
 * JD-Core Version:    0.7.0.1
 */