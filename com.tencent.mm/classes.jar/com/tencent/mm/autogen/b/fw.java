package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public abstract class fw
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OpenIMFinderInfoNew");
  public static final Column kQf;
  public static final Column kQg;
  private static final int kQj;
  private static final int kQk;
  private static final StorageObserverOwner<fw> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_finder_username;
  public String field_openIMUsername;
  private boolean kQh = true;
  private boolean kQi = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kQf = new Column("openIMUsername", "string", TABLE.getName(), "");
    kQg = new Column("finder_username", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kQj = "openIMUsername".hashCode();
    kQk = "finder_username".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "openIMUsername";
    localMAutoDBInfo.colsMap.put("openIMUsername", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openIMUsername TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "openIMUsername";
    localMAutoDBInfo.columns[1] = "finder_username";
    localMAutoDBInfo.colsMap.put("finder_username", "TEXT");
    localStringBuilder.append(" finder_username TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  private JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a.b(localJSONObject, "openIMUsername", this.field_openIMUsername);
      a.b(localJSONObject, "finder_username", this.field_finder_username);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("openIMUsername"))
    {
      this.field_openIMUsername = paramContentValues.getAsString("openIMUsername");
      if (paramBoolean) {
        this.kQh = true;
      }
    }
    if (paramContentValues.containsKey("finder_username"))
    {
      this.field_finder_username = paramContentValues.getAsString("finder_username");
      if (paramBoolean) {
        this.kQi = true;
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
      if (kQj != k) {
        break label65;
      }
      this.field_openIMUsername = paramCursor.getString(i);
      this.kQh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kQk == k) {
        this.field_finder_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kQh) {
      localContentValues.put("openIMUsername", this.field_openIMUsername);
    }
    if (this.kQi) {
      localContentValues.put("finder_username", this.field_finder_username);
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
  
  public StorageObserverOwner<? extends fw> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_openIMUsername;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fw
 * JD-Core Version:    0.7.0.1
 */