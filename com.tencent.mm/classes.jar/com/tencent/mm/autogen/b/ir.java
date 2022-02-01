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

public abstract class ir
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WebViewHistory");
  public static final Column jLV;
  public static final Column jMN;
  private static final int jMX;
  private static final int jMd;
  public static final Column jON;
  private static final int jOT;
  private static final int kIz;
  public static final Column kkd;
  public static final Column llK;
  public static final Column llL;
  private static final int llO;
  private static final int llP;
  private static final StorageObserverOwner<ir> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_imgUrl;
  public String field_link;
  public String field_recordId;
  public String field_source;
  public long field_timeStamp;
  public String field_title;
  private boolean jLZ = true;
  private boolean jMS = true;
  private boolean jOQ = true;
  private boolean kIu = true;
  private boolean llM = true;
  private boolean llN = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jLV = new Column("recordId", "string", TABLE.getName(), "");
    llK = new Column("link", "string", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    jMN = new Column("source", "string", TABLE.getName(), "");
    llL = new Column("imgUrl", "string", TABLE.getName(), "");
    kkd = new Column("timeStamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jMd = "recordId".hashCode();
    llO = "link".hashCode();
    jOT = "title".hashCode();
    jMX = "source".hashCode();
    llP = "imgUrl".hashCode();
    kIz = "timeStamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "recordId";
    localMAutoDBInfo.colsMap.put("recordId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" recordId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "recordId";
    localMAutoDBInfo.columns[1] = "link";
    localMAutoDBInfo.colsMap.put("link", "TEXT");
    localStringBuilder.append(" link TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "source";
    localMAutoDBInfo.colsMap.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "imgUrl";
    localMAutoDBInfo.colsMap.put("imgUrl", "TEXT");
    localStringBuilder.append(" imgUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("recordId"))
    {
      this.field_recordId = paramContentValues.getAsString("recordId");
      if (paramBoolean) {
        this.jLZ = true;
      }
    }
    if (paramContentValues.containsKey("link"))
    {
      this.field_link = paramContentValues.getAsString("link");
      if (paramBoolean) {
        this.llM = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsString("source");
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("imgUrl"))
    {
      this.field_imgUrl = paramContentValues.getAsString("imgUrl");
      if (paramBoolean) {
        this.llN = true;
      }
    }
    if (paramContentValues.containsKey("timeStamp"))
    {
      this.field_timeStamp = paramContentValues.getAsLong("timeStamp").longValue();
      if (paramBoolean) {
        this.kIu = true;
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
      if (jMd != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getString(i);
      this.jLZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (llO == k) {
        this.field_link = paramCursor.getString(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getString(i);
      } else if (llP == k) {
        this.field_imgUrl = paramCursor.getString(i);
      } else if (kIz == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jLZ) {
      localContentValues.put("recordId", this.field_recordId);
    }
    if (this.llM) {
      localContentValues.put("link", this.field_link);
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.jMS) {
      localContentValues.put("source", this.field_source);
    }
    if (this.llN) {
      localContentValues.put("imgUrl", this.field_imgUrl);
    }
    if (this.kIu) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
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
  
  public StorageObserverOwner<? extends ir> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_recordId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ir
 * JD-Core Version:    0.7.0.1
 */