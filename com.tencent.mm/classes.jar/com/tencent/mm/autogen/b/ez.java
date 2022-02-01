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

public abstract class ez
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LiveTipsBar");
  public static final Column kIm;
  public static final Column kIn;
  public static final Column kIo;
  public static final Column kIp;
  private static final int kIv;
  private static final int kIw;
  private static final int kIx;
  private static final int kIy;
  private static final int kIz;
  public static final Column keq;
  private static final int kfT;
  public static final Column kkd;
  public static final Column krn;
  private static final int krv;
  private static final StorageObserverOwner<ez> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  private boolean kIq = true;
  private boolean kIr = true;
  private boolean kIs = true;
  private boolean kIt = true;
  private boolean kIu = true;
  private boolean kff = true;
  private boolean krr = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    krn = new Column("liveId", "long", TABLE.getName(), "");
    kIm = new Column("hostRoomId", "string", TABLE.getName(), "");
    kIn = new Column("liveName", "string", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    kIo = new Column("anchorUsername", "string", TABLE.getName(), "");
    kIp = new Column("isSender", "boolean", TABLE.getName(), "");
    kkd = new Column("timeStamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    krv = "liveId".hashCode();
    kIv = "hostRoomId".hashCode();
    kIw = "liveName".hashCode();
    kfT = "thumbUrl".hashCode();
    kIx = "anchorUsername".hashCode();
    kIy = "isSender".hashCode();
    kIz = "timeStamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "liveId";
    localMAutoDBInfo.colsMap.put("liveId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" liveId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "liveId";
    localMAutoDBInfo.columns[1] = "hostRoomId";
    localMAutoDBInfo.colsMap.put("hostRoomId", "TEXT default '' ");
    localStringBuilder.append(" hostRoomId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "liveName";
    localMAutoDBInfo.colsMap.put("liveName", "TEXT default '' ");
    localStringBuilder.append(" liveName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT default '' ");
    localStringBuilder.append(" thumbUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "anchorUsername";
    localMAutoDBInfo.colsMap.put("anchorUsername", "TEXT default '' ");
    localStringBuilder.append(" anchorUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isSender";
    localMAutoDBInfo.colsMap.put("isSender", "INTEGER default 'false' ");
    localStringBuilder.append(" isSender INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG default '0' ");
    localStringBuilder.append(" timeStamp LONG default '0' ");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("liveId"))
    {
      this.field_liveId = paramContentValues.getAsLong("liveId").longValue();
      if (paramBoolean) {
        this.krr = true;
      }
    }
    if (paramContentValues.containsKey("hostRoomId"))
    {
      this.field_hostRoomId = paramContentValues.getAsString("hostRoomId");
      if (paramBoolean) {
        this.kIq = true;
      }
    }
    if (paramContentValues.containsKey("liveName"))
    {
      this.field_liveName = paramContentValues.getAsString("liveName");
      if (paramBoolean) {
        this.kIr = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("anchorUsername"))
    {
      this.field_anchorUsername = paramContentValues.getAsString("anchorUsername");
      if (paramBoolean) {
        this.kIs = true;
      }
    }
    if (paramContentValues.containsKey("isSender")) {
      if (paramContentValues.getAsInteger("isSender").intValue() == 0) {
        break label234;
      }
    }
    label234:
    for (boolean bool = true;; bool = false)
    {
      this.field_isSender = bool;
      if (paramBoolean) {
        this.kIt = true;
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
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (krv != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.krr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kIv == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (kIw == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (kfT == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (kIx == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (kIy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (kIz == k) {
          this.field_timeStamp = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.krr) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.kIq) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.kIr) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.kIs) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.kIt) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
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
  
  public StorageObserverOwner<? extends ez> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_liveId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ez
 * JD-Core Version:    0.7.0.1
 */