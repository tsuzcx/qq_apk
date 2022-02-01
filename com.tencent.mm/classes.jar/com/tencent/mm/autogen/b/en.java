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

public abstract class en
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("IPCallMsg");
  private static final int content_HASHCODE;
  public static final Column jON;
  private static final int jOT;
  public static final Column jPR;
  private static final int jQv;
  public static final Column jTK;
  private static final int jUm;
  public static final Column kEl;
  public static final Column kEm;
  private static final int kEp;
  private static final int kEq;
  public static final Column keb;
  private static final int kip;
  private static final StorageObserverOwner<en> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcontent = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  private boolean jOQ = true;
  private boolean jQg = true;
  private boolean jTY = true;
  private boolean kEn = true;
  private boolean kEo = true;
  private boolean kim = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    keb = new Column("svrId", "long", TABLE.getName(), "");
    jTK = new Column("isRead", "short", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    kEl = new Column("pushTime", "long", TABLE.getName(), "");
    jPR = new Column("msgType", "int", TABLE.getName(), "");
    kEm = new Column("descUrl", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kip = "svrId".hashCode();
    jUm = "isRead".hashCode();
    jOT = "title".hashCode();
    content_HASHCODE = "content".hashCode();
    kEp = "pushTime".hashCode();
    jQv = "msgType".hashCode();
    kEq = "descUrl".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrId";
    localMAutoDBInfo.colsMap.put("svrId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" svrId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrId";
    localMAutoDBInfo.columns[1] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "SHORT default '0' ");
    localStringBuilder.append(" isRead SHORT default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "pushTime";
    localMAutoDBInfo.colsMap.put("pushTime", "LONG");
    localStringBuilder.append(" pushTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "descUrl";
    localMAutoDBInfo.colsMap.put("descUrl", "TEXT");
    localStringBuilder.append(" descUrl TEXT");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("svrId"))
    {
      this.field_svrId = paramContentValues.getAsLong("svrId").longValue();
      if (paramBoolean) {
        this.kim = true;
      }
    }
    if (paramContentValues.containsKey("isRead"))
    {
      this.field_isRead = paramContentValues.getAsShort("isRead").shortValue();
      if (paramBoolean) {
        this.jTY = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("pushTime"))
    {
      this.field_pushTime = paramContentValues.getAsLong("pushTime").longValue();
      if (paramBoolean) {
        this.kEn = true;
      }
    }
    if (paramContentValues.containsKey("msgType"))
    {
      this.field_msgType = paramContentValues.getAsInteger("msgType").intValue();
      if (paramBoolean) {
        this.jQg = true;
      }
    }
    if (paramContentValues.containsKey("descUrl"))
    {
      this.field_descUrl = paramContentValues.getAsString("descUrl");
      if (paramBoolean) {
        this.kEo = true;
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
      if (kip != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.kim = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jUm == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kEp == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (jQv == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (kEq == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kim) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.jTY) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.kEn) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.jQg) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.kEo) {
      localContentValues.put("descUrl", this.field_descUrl);
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
  
  public StorageObserverOwner<? extends en> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_svrId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.en
 * JD-Core Version:    0.7.0.1
 */