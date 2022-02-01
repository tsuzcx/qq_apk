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

public abstract class ec
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GroupTools");
  public static final Column jWQ;
  private static final int jXT;
  public static final Column kCa;
  public static final Column kCb;
  public static final Column kCc;
  private static final int kCg;
  private static final int kCh;
  private static final int kCi;
  private static final StorageObserverOwner<ec> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_chatroomname;
  public int field_queryState;
  public String field_recentUseToolList;
  public String field_stickToollist;
  private boolean jXr = true;
  private boolean kCd = true;
  private boolean kCe = true;
  private boolean kCf = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jWQ = new Column("chatroomname", "string", TABLE.getName(), "");
    kCa = new Column("stickToollist", "string", TABLE.getName(), "");
    kCb = new Column("recentUseToolList", "string", TABLE.getName(), "");
    kCc = new Column("queryState", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jXT = "chatroomname".hashCode();
    kCg = "stickToollist".hashCode();
    kCh = "recentUseToolList".hashCode();
    kCi = "queryState".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatroomname";
    localMAutoDBInfo.colsMap.put("chatroomname", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" chatroomname TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatroomname";
    localMAutoDBInfo.columns[1] = "stickToollist";
    localMAutoDBInfo.colsMap.put("stickToollist", "TEXT");
    localStringBuilder.append(" stickToollist TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "recentUseToolList";
    localMAutoDBInfo.colsMap.put("recentUseToolList", "TEXT");
    localStringBuilder.append(" recentUseToolList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "queryState";
    localMAutoDBInfo.colsMap.put("queryState", "INTEGER");
    localStringBuilder.append(" queryState INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("chatroomname"))
    {
      this.field_chatroomname = paramContentValues.getAsString("chatroomname");
      if (paramBoolean) {
        this.jXr = true;
      }
    }
    if (paramContentValues.containsKey("stickToollist"))
    {
      this.field_stickToollist = paramContentValues.getAsString("stickToollist");
      if (paramBoolean) {
        this.kCd = true;
      }
    }
    if (paramContentValues.containsKey("recentUseToolList"))
    {
      this.field_recentUseToolList = paramContentValues.getAsString("recentUseToolList");
      if (paramBoolean) {
        this.kCe = true;
      }
    }
    if (paramContentValues.containsKey("queryState"))
    {
      this.field_queryState = paramContentValues.getAsInteger("queryState").intValue();
      if (paramBoolean) {
        this.kCf = true;
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
      if (jXT != k) {
        break label65;
      }
      this.field_chatroomname = paramCursor.getString(i);
      this.jXr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kCg == k) {
        this.field_stickToollist = paramCursor.getString(i);
      } else if (kCh == k) {
        this.field_recentUseToolList = paramCursor.getString(i);
      } else if (kCi == k) {
        this.field_queryState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jXr) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.kCd) {
      localContentValues.put("stickToollist", this.field_stickToollist);
    }
    if (this.kCe) {
      localContentValues.put("recentUseToolList", this.field_recentUseToolList);
    }
    if (this.kCf) {
      localContentValues.put("queryState", Integer.valueOf(this.field_queryState));
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
  
  public StorageObserverOwner<? extends ec> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_chatroomname;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ec
 * JD-Core Version:    0.7.0.1
 */