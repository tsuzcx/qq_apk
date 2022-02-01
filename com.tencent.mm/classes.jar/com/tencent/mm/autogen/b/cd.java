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

public abstract class cd
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("FavSearchInfo");
  public static final Column TYPE;
  private static final int content_HASHCODE;
  public static final Column jUS;
  private static final int jVE;
  public static final Column kjP;
  private static final int kjS;
  private static final int kjT;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<cd> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  public String field_content;
  public long field_localId;
  public int field_subtype;
  public String field_tagContent;
  public long field_time;
  public int field_type;
  private boolean jVl = true;
  private boolean kjQ = true;
  private boolean kjR = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    kjP = new Column("tagContent", "string", TABLE.getName(), "");
    jUS = new Column("time", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    SUBTYPE = new Column("subtype", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)" };
    localId_HASHCODE = "localId".hashCode();
    content_HASHCODE = "content".hashCode();
    kjS = "tagContent".hashCode();
    jVE = "time".hashCode();
    type_HASHCODE = "type".hashCode();
    kjT = "subtype".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "tagContent";
    localMAutoDBInfo.colsMap.put("tagContent", "TEXT");
    localStringBuilder.append(" tagContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "time";
    localMAutoDBInfo.colsMap.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "subtype";
    localMAutoDBInfo.colsMap.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    localMAutoDBInfo.columns[6] = "rowid";
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
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("tagContent"))
    {
      this.field_tagContent = paramContentValues.getAsString("tagContent");
      if (paramBoolean) {
        this.kjQ = true;
      }
    }
    if (paramContentValues.containsKey("time"))
    {
      this.field_time = paramContentValues.getAsLong("time").longValue();
      if (paramBoolean) {
        this.jVl = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("subtype"))
    {
      this.field_subtype = paramContentValues.getAsInteger("subtype").intValue();
      if (paramBoolean) {
        this.kjR = true;
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
      if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kjS == k) {
        this.field_tagContent = paramCursor.getString(i);
      } else if (jVE == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kjT == k) {
        this.field_subtype = paramCursor.getInt(i);
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
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.kjQ) {
      localContentValues.put("tagContent", this.field_tagContent);
    }
    if (this.jVl) {
      localContentValues.put("time", Long.valueOf(this.field_time));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kjR) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
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
  
  public StorageObserverOwner<? extends cd> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.cd
 * JD-Core Version:    0.7.0.1
 */