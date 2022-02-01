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

public abstract class iq
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WebViewData");
  public static final Column VALUE;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jLQ;
  private static final int jLU;
  private static final int kIz;
  public static final Column kkd;
  private static final int kyM;
  private static final int kyQ;
  public static final Column kyq;
  public static final Column kyu;
  public static final Column llE;
  public static final Column llF;
  private static final int llI;
  private static final int llJ;
  private static final StorageObserverOwner<iq> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public String field_localFile;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  private boolean jKG = true;
  private boolean jLS = true;
  private boolean kIu = true;
  private boolean kyB = true;
  private boolean kyF = true;
  private boolean llG = true;
  private boolean llH = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    llE = new Column("appIdKey", "string", TABLE.getName(), "");
    VALUE = new Column("value", "string", TABLE.getName(), "");
    kyu = new Column("weight", "string", TABLE.getName(), "");
    kyq = new Column("expireTime", "long", TABLE.getName(), "");
    kkd = new Column("timeStamp", "long", TABLE.getName(), "");
    jLQ = new Column("size", "long", TABLE.getName(), "");
    llF = new Column("localFile", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jKX = "appId".hashCode();
    llI = "appIdKey".hashCode();
    value_HASHCODE = "value".hashCode();
    kyQ = "weight".hashCode();
    kyM = "expireTime".hashCode();
    kIz = "timeStamp".hashCode();
    jLU = "size".hashCode();
    llJ = "localFile".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appIdKey";
    localMAutoDBInfo.colsMap.put("appIdKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appIdKey";
    localMAutoDBInfo.columns[2] = "value";
    localMAutoDBInfo.colsMap.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "weight";
    localMAutoDBInfo.colsMap.put("weight", "TEXT");
    localStringBuilder.append(" weight TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG");
    localStringBuilder.append(" expireTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "size";
    localMAutoDBInfo.colsMap.put("size", "LONG");
    localStringBuilder.append(" size LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "localFile";
    localMAutoDBInfo.colsMap.put("localFile", "TEXT");
    localStringBuilder.append(" localFile TEXT");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("appIdKey"))
    {
      this.field_appIdKey = paramContentValues.getAsString("appIdKey");
      if (paramBoolean) {
        this.llG = true;
      }
    }
    if (paramContentValues.containsKey("value"))
    {
      this.field_value = paramContentValues.getAsString("value");
      if (paramBoolean) {
        this.__hadSetvalue = true;
      }
    }
    if (paramContentValues.containsKey("weight"))
    {
      this.field_weight = paramContentValues.getAsString("weight");
      if (paramBoolean) {
        this.kyF = true;
      }
    }
    if (paramContentValues.containsKey("expireTime"))
    {
      this.field_expireTime = paramContentValues.getAsLong("expireTime").longValue();
      if (paramBoolean) {
        this.kyB = true;
      }
    }
    if (paramContentValues.containsKey("timeStamp"))
    {
      this.field_timeStamp = paramContentValues.getAsLong("timeStamp").longValue();
      if (paramBoolean) {
        this.kIu = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsLong("size").longValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("localFile"))
    {
      this.field_localFile = paramContentValues.getAsString("localFile");
      if (paramBoolean) {
        this.llH = true;
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
      if (jKX != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (llI == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.llG = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (kyQ == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (kyM == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (kIz == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (jLU == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (llJ == k)
      {
        this.field_localFile = paramCursor.getString(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.llG) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.kyF) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.kyB) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.kIu) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.jLS) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.llH) {
      localContentValues.put("localFile", this.field_localFile);
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
  
  public StorageObserverOwner<? extends iq> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_appIdKey;
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
 * Qualified Name:     com.tencent.mm.autogen.b.iq
 * JD-Core Version:    0.7.0.1
 */