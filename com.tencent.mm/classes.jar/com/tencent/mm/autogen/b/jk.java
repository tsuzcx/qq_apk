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

public abstract class jk
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaUpdateableMsg");
  private static final int content_HASHCODE;
  public static final Column kRh;
  private static final int kRn;
  public static final Column lpF;
  public static final Column lpG;
  public static final Column lpH;
  public static final Column lpI;
  private static final int lpN;
  private static final int lpO;
  private static final int lpP;
  private static final int lpQ;
  private static final StorageObserverOwner<jk> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcontent = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  private boolean kRk = true;
  private boolean lpJ = true;
  private boolean lpK = true;
  private boolean lpL = true;
  private boolean lpM = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lpF = new Column("shareKeyHash", "int", TABLE.getName(), "");
    lpG = new Column("btnState", "int", TABLE.getName(), "");
    kRh = new Column("msgState", "int", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    lpH = new Column("contentColor", "string", TABLE.getName(), "");
    lpI = new Column("updatePeroid", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lpN = "shareKeyHash".hashCode();
    lpO = "btnState".hashCode();
    kRn = "msgState".hashCode();
    content_HASHCODE = "content".hashCode();
    lpP = "contentColor".hashCode();
    lpQ = "updatePeroid".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "shareKeyHash";
    localMAutoDBInfo.colsMap.put("shareKeyHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" shareKeyHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "shareKeyHash";
    localMAutoDBInfo.columns[1] = "btnState";
    localMAutoDBInfo.colsMap.put("btnState", "INTEGER");
    localStringBuilder.append(" btnState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "msgState";
    localMAutoDBInfo.colsMap.put("msgState", "INTEGER");
    localStringBuilder.append(" msgState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "contentColor";
    localMAutoDBInfo.colsMap.put("contentColor", "TEXT");
    localStringBuilder.append(" contentColor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updatePeroid";
    localMAutoDBInfo.colsMap.put("updatePeroid", "INTEGER");
    localStringBuilder.append(" updatePeroid INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("shareKeyHash"))
    {
      this.field_shareKeyHash = paramContentValues.getAsInteger("shareKeyHash").intValue();
      if (paramBoolean) {
        this.lpJ = true;
      }
    }
    if (paramContentValues.containsKey("btnState"))
    {
      this.field_btnState = paramContentValues.getAsInteger("btnState").intValue();
      if (paramBoolean) {
        this.lpK = true;
      }
    }
    if (paramContentValues.containsKey("msgState"))
    {
      this.field_msgState = paramContentValues.getAsInteger("msgState").intValue();
      if (paramBoolean) {
        this.kRk = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("contentColor"))
    {
      this.field_contentColor = paramContentValues.getAsString("contentColor");
      if (paramBoolean) {
        this.lpL = true;
      }
    }
    if (paramContentValues.containsKey("updatePeroid"))
    {
      this.field_updatePeroid = paramContentValues.getAsInteger("updatePeroid").intValue();
      if (paramBoolean) {
        this.lpM = true;
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
      if (lpN != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.lpJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lpO == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (kRn == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (lpP == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (lpQ == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.lpJ) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.lpK) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.kRk) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.lpL) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.lpM) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
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
  
  public StorageObserverOwner<? extends jk> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_shareKeyHash);
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
 * Qualified Name:     com.tencent.mm.autogen.b.jk
 * JD-Core Version:    0.7.0.1
 */