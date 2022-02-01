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

public abstract class fy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OpenIMSnsFlag");
  public static final Column kQR;
  private static final int kQT;
  public static final Column kQf;
  private static final int kQj;
  private static final StorageObserverOwner<fy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_openIMSnsFlag;
  public String field_openIMUsername;
  private boolean kQS = true;
  private boolean kQh = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kQf = new Column("openIMUsername", "string", TABLE.getName(), "");
    kQR = new Column("openIMSnsFlag", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kQj = "openIMUsername".hashCode();
    kQT = "openIMSnsFlag".hashCode();
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
    localMAutoDBInfo.columns[1] = "openIMSnsFlag";
    localMAutoDBInfo.colsMap.put("openIMSnsFlag", "LONG default '0' ");
    localStringBuilder.append(" openIMSnsFlag LONG default '0' ");
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
      a.b(localJSONObject, "openIMSnsFlag", Long.valueOf(this.field_openIMSnsFlag));
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
    if (paramContentValues.containsKey("openIMSnsFlag"))
    {
      this.field_openIMSnsFlag = paramContentValues.getAsLong("openIMSnsFlag").longValue();
      if (paramBoolean) {
        this.kQS = true;
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
      if (kQT == k) {
        this.field_openIMSnsFlag = paramCursor.getLong(i);
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
    if (this.kQS) {
      localContentValues.put("openIMSnsFlag", Long.valueOf(this.field_openIMSnsFlag));
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
  
  public StorageObserverOwner<? extends fy> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fy
 * JD-Core Version:    0.7.0.1
 */