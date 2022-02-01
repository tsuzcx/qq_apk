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

public abstract class em
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("IPCallAddressItem");
  public static final Column kDZ;
  public static final Column kEa;
  public static final Column kEb;
  public static final Column kEc;
  private static final int kEh;
  private static final int kEi;
  private static final int kEj;
  private static final int kEk;
  private static final StorageObserverOwner<em> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_contactId;
  public String field_sortKey;
  public String field_systemAddressBookUsername;
  public String field_wechatUsername;
  private boolean kEd = true;
  private boolean kEe = true;
  private boolean kEf = true;
  private boolean kEg = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kDZ = new Column("wechatUsername", "string", TABLE.getName(), "");
    kEa = new Column("systemAddressBookUsername", "string", TABLE.getName(), "");
    kEb = new Column("contactId", "string", TABLE.getName(), "");
    kEc = new Column("sortKey", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kEh = "wechatUsername".hashCode();
    kEi = "systemAddressBookUsername".hashCode();
    kEj = "contactId".hashCode();
    kEk = "sortKey".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wechatUsername";
    localMAutoDBInfo.colsMap.put("wechatUsername", "TEXT");
    localStringBuilder.append(" wechatUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "systemAddressBookUsername";
    localMAutoDBInfo.colsMap.put("systemAddressBookUsername", "TEXT");
    localStringBuilder.append(" systemAddressBookUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "contactId";
    localMAutoDBInfo.colsMap.put("contactId", "TEXT");
    localStringBuilder.append(" contactId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "sortKey";
    localMAutoDBInfo.colsMap.put("sortKey", "TEXT");
    localStringBuilder.append(" sortKey TEXT");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("wechatUsername"))
    {
      this.field_wechatUsername = paramContentValues.getAsString("wechatUsername");
      if (paramBoolean) {
        this.kEd = true;
      }
    }
    if (paramContentValues.containsKey("systemAddressBookUsername"))
    {
      this.field_systemAddressBookUsername = paramContentValues.getAsString("systemAddressBookUsername");
      if (paramBoolean) {
        this.kEe = true;
      }
    }
    if (paramContentValues.containsKey("contactId"))
    {
      this.field_contactId = paramContentValues.getAsString("contactId");
      if (paramBoolean) {
        this.kEf = true;
      }
    }
    if (paramContentValues.containsKey("sortKey"))
    {
      this.field_sortKey = paramContentValues.getAsString("sortKey");
      if (paramBoolean) {
        this.kEg = true;
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
      if (kEh != k) {
        break label60;
      }
      this.field_wechatUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kEi == k) {
        this.field_systemAddressBookUsername = paramCursor.getString(i);
      } else if (kEj == k) {
        this.field_contactId = paramCursor.getString(i);
      } else if (kEk == k) {
        this.field_sortKey = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kEd) {
      localContentValues.put("wechatUsername", this.field_wechatUsername);
    }
    if (this.kEe) {
      localContentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
    }
    if (this.kEf) {
      localContentValues.put("contactId", this.field_contactId);
    }
    if (this.kEg) {
      localContentValues.put("sortKey", this.field_sortKey);
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
  
  public StorageObserverOwner<? extends em> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.em
 * JD-Core Version:    0.7.0.1
 */