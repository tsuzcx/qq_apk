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

public abstract class g
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("AddContactAntispamTicket");
  public static final Column USERNAME;
  public static final Column jJA;
  private static final int jJD;
  private static final int jJE;
  public static final Column jJz;
  private static final StorageObserverOwner<g> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public int field_scene;
  public String field_ticket;
  public String field_userName;
  private boolean jJB = true;
  private boolean jJC = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    jJA = new Column("ticket", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    userName_HASHCODE = "userName".hashCode();
    jJD = "scene".hashCode();
    jJE = "ticket".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("ticket"))
    {
      this.field_ticket = paramContentValues.getAsString("ticket");
      if (paramBoolean) {
        this.jJC = true;
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
      if (userName_HASHCODE != k) {
        break label60;
      }
      this.field_userName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (jJE == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.jJC) {
      localContentValues.put("ticket", this.field_ticket);
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
  
  public StorageObserverOwner<? extends g> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.g
 * JD-Core Version:    0.7.0.1
 */