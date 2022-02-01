package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gs
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("RecordMessageInfo");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jIz;
  public static final Column jON;
  private static final int jOT;
  public static final Column kTM;
  public static final Column kTN;
  public static final Column kTO;
  private static final int kTS;
  private static final int kTT;
  private static final int kTU;
  private static final int kgA;
  public static final Column kgs;
  public static final Column kiQ;
  private static final int kjs;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<gs> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  public arv field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean jIC = true;
  private boolean jIs = true;
  private boolean jOQ = true;
  private boolean kTP = true;
  private boolean kTQ = true;
  private boolean kTR = true;
  private boolean kgw = true;
  private boolean kje = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "int", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    kTM = new Column("oriMsgId", "long", TABLE.getName(), "");
    kiQ = new Column("toUser", "string", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kgs = new Column("desc", "string", TABLE.getName(), "");
    kTN = new Column("dataProto", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FavProtoItem");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kTO = new Column("favFrom", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    localId_HASHCODE = "localId".hashCode();
    jIw = "msgId".hashCode();
    kTS = "oriMsgId".hashCode();
    kjs = "toUser".hashCode();
    jOT = "title".hashCode();
    kgA = "desc".hashCode();
    kTT = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
    jIF = "status".hashCode();
    kTU = "favFrom".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "oriMsgId";
    localMAutoDBInfo.colsMap.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "toUser";
    localMAutoDBInfo.colsMap.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "dataProto";
    localMAutoDBInfo.colsMap.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "favFrom";
    localMAutoDBInfo.colsMap.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsInteger("localId").intValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("oriMsgId"))
    {
      this.field_oriMsgId = paramContentValues.getAsLong("oriMsgId").longValue();
      if (paramBoolean) {
        this.kTP = true;
      }
    }
    if (paramContentValues.containsKey("toUser"))
    {
      this.field_toUser = paramContentValues.getAsString("toUser");
      if (paramBoolean) {
        this.kje = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("desc"))
    {
      this.field_desc = paramContentValues.getAsString("desc");
      if (paramBoolean) {
        this.kgw = true;
      }
    }
    if (paramContentValues.containsKey("dataProto")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("dataProto");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_dataProto = ((arv)new arv().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kTQ = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("favFrom"))
    {
      this.field_favFrom = paramContentValues.getAsString("favFrom");
      if (paramBoolean) {
        this.kTR = true;
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIw == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (kTS == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (kjs == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (kgA == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (kTT == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((arv)new arv().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kTU == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.kTP) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.kje) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kgw) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.kTQ) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.jIC) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.kTR) {
        localContentValues.put("favFrom", this.field_favFrom);
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends gs> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_localId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.gs
 * JD-Core Version:    0.7.0.1
 */