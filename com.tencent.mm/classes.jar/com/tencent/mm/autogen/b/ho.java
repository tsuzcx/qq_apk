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

public abstract class ho
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsTagInfo");
  public static final Column jWS;
  public static final Column kcZ;
  private static final int kdZ;
  public static final Column lbd;
  public static final Column lbe;
  private static final int lbi;
  private static final int lbj;
  private static final int lbk;
  private static final StorageObserverOwner<ho> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  private boolean kdz = true;
  private boolean lbf = true;
  private boolean lbg = true;
  private boolean lbh = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lbd = new Column("tagId", "long", TABLE.getName(), "");
    lbe = new Column("tagName", "string", TABLE.getName(), "");
    kcZ = new Column("count", "int", TABLE.getName(), "");
    jWS = new Column("memberList", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lbi = "tagId".hashCode();
    lbj = "tagName".hashCode();
    kdZ = "count".hashCode();
    lbk = "memberList".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tagId";
    localMAutoDBInfo.colsMap.put("tagId", "LONG default '0' ");
    localStringBuilder.append(" tagId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "tagName";
    localMAutoDBInfo.colsMap.put("tagName", "TEXT default '' ");
    localStringBuilder.append(" tagName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "count";
    localMAutoDBInfo.colsMap.put("count", "INTEGER default '0' ");
    localStringBuilder.append(" count INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "memberList";
    localMAutoDBInfo.colsMap.put("memberList", "TEXT default '' ");
    localStringBuilder.append(" memberList TEXT default '' ");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("tagId"))
    {
      this.field_tagId = paramContentValues.getAsLong("tagId").longValue();
      if (paramBoolean) {
        this.lbf = true;
      }
    }
    if (paramContentValues.containsKey("tagName"))
    {
      this.field_tagName = paramContentValues.getAsString("tagName");
      if (paramBoolean) {
        this.lbg = true;
      }
    }
    if (paramContentValues.containsKey("count"))
    {
      this.field_count = paramContentValues.getAsInteger("count").intValue();
      if (paramBoolean) {
        this.kdz = true;
      }
    }
    if (paramContentValues.containsKey("memberList"))
    {
      this.field_memberList = paramContentValues.getAsString("memberList");
      if (paramBoolean) {
        this.lbh = true;
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
      if (lbi != k) {
        break label60;
      }
      this.field_tagId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (lbj == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (kdZ == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (lbk == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lbf) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.lbg) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.kdz) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.lbh) {
      localContentValues.put("memberList", this.field_memberList);
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
  
  public StorageObserverOwner<? extends ho> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ho
 * JD-Core Version:    0.7.0.1
 */