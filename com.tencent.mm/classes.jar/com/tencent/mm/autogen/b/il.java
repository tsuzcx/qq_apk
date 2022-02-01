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

public abstract class il
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WalletLuckyMoney");
  public static final Column jTA;
  private static final int jUc;
  public static final Column kTW;
  public static final Column kTX;
  private static final int kUg;
  private static final int kUh;
  private static final int kyR;
  public static final Column kyv;
  public static final Column liE;
  public static final Column liF;
  public static final Column liG;
  public static final Column liH;
  public static final Column liI;
  public static final Column liJ;
  public static final Column liK;
  private static final int liS;
  private static final int liT;
  private static final int liU;
  private static final int liV;
  private static final int liW;
  private static final int liX;
  private static final int liY;
  private static final StorageObserverOwner<il> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_exclusiveUsername;
  public int field_hbStatus;
  public int field_hbType;
  public int field_invalidtime;
  public String field_mNativeUrl;
  public long field_msgSvrId;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  public String field_sendId;
  public String field_sender;
  private boolean jTO = true;
  private boolean kUb = true;
  private boolean kUc = true;
  private boolean kyG = true;
  private boolean liL = true;
  private boolean liM = true;
  private boolean liN = true;
  private boolean liO = true;
  private boolean liP = true;
  private boolean liQ = true;
  private boolean liR = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    liE = new Column("mNativeUrl", "string", TABLE.getName(), "");
    liF = new Column("hbType", "int", TABLE.getName(), "");
    liG = new Column("receiveAmount", "long", TABLE.getName(), "");
    kyv = new Column("receiveTime", "long", TABLE.getName(), "");
    kTW = new Column("receiveStatus", "int", TABLE.getName(), "");
    liH = new Column("hbStatus", "int", TABLE.getName(), "");
    liI = new Column("sender", "string", TABLE.getName(), "");
    liJ = new Column("exclusiveUsername", "string", TABLE.getName(), "");
    liK = new Column("sendId", "string", TABLE.getName(), "");
    kTX = new Column("invalidtime", "int", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    liS = "mNativeUrl".hashCode();
    liT = "hbType".hashCode();
    liU = "receiveAmount".hashCode();
    kyR = "receiveTime".hashCode();
    kUg = "receiveStatus".hashCode();
    liV = "hbStatus".hashCode();
    liW = "sender".hashCode();
    liX = "exclusiveUsername".hashCode();
    liY = "sendId".hashCode();
    kUh = "invalidtime".hashCode();
    jUc = "msgSvrId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "mNativeUrl";
    localMAutoDBInfo.colsMap.put("mNativeUrl", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "mNativeUrl";
    localMAutoDBInfo.columns[1] = "hbType";
    localMAutoDBInfo.colsMap.put("hbType", "INTEGER");
    localStringBuilder.append(" hbType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "receiveAmount";
    localMAutoDBInfo.colsMap.put("receiveAmount", "LONG");
    localStringBuilder.append(" receiveAmount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "receiveTime";
    localMAutoDBInfo.colsMap.put("receiveTime", "LONG");
    localStringBuilder.append(" receiveTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "receiveStatus";
    localMAutoDBInfo.colsMap.put("receiveStatus", "INTEGER");
    localStringBuilder.append(" receiveStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hbStatus";
    localMAutoDBInfo.colsMap.put("hbStatus", "INTEGER");
    localStringBuilder.append(" hbStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "sender";
    localMAutoDBInfo.colsMap.put("sender", "TEXT");
    localStringBuilder.append(" sender TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "exclusiveUsername";
    localMAutoDBInfo.colsMap.put("exclusiveUsername", "TEXT");
    localStringBuilder.append(" exclusiveUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sendId";
    localMAutoDBInfo.colsMap.put("sendId", "TEXT");
    localStringBuilder.append(" sendId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "invalidtime";
    localMAutoDBInfo.colsMap.put("invalidtime", "INTEGER");
    localStringBuilder.append(" invalidtime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("mNativeUrl"))
    {
      this.field_mNativeUrl = paramContentValues.getAsString("mNativeUrl");
      if (paramBoolean) {
        this.liL = true;
      }
    }
    if (paramContentValues.containsKey("hbType"))
    {
      this.field_hbType = paramContentValues.getAsInteger("hbType").intValue();
      if (paramBoolean) {
        this.liM = true;
      }
    }
    if (paramContentValues.containsKey("receiveAmount"))
    {
      this.field_receiveAmount = paramContentValues.getAsLong("receiveAmount").longValue();
      if (paramBoolean) {
        this.liN = true;
      }
    }
    if (paramContentValues.containsKey("receiveTime"))
    {
      this.field_receiveTime = paramContentValues.getAsLong("receiveTime").longValue();
      if (paramBoolean) {
        this.kyG = true;
      }
    }
    if (paramContentValues.containsKey("receiveStatus"))
    {
      this.field_receiveStatus = paramContentValues.getAsInteger("receiveStatus").intValue();
      if (paramBoolean) {
        this.kUb = true;
      }
    }
    if (paramContentValues.containsKey("hbStatus"))
    {
      this.field_hbStatus = paramContentValues.getAsInteger("hbStatus").intValue();
      if (paramBoolean) {
        this.liO = true;
      }
    }
    if (paramContentValues.containsKey("sender"))
    {
      this.field_sender = paramContentValues.getAsString("sender");
      if (paramBoolean) {
        this.liP = true;
      }
    }
    if (paramContentValues.containsKey("exclusiveUsername"))
    {
      this.field_exclusiveUsername = paramContentValues.getAsString("exclusiveUsername");
      if (paramBoolean) {
        this.liQ = true;
      }
    }
    if (paramContentValues.containsKey("sendId"))
    {
      this.field_sendId = paramContentValues.getAsString("sendId");
      if (paramBoolean) {
        this.liR = true;
      }
    }
    if (paramContentValues.containsKey("invalidtime"))
    {
      this.field_invalidtime = paramContentValues.getAsInteger("invalidtime").intValue();
      if (paramBoolean) {
        this.kUc = true;
      }
    }
    if (paramContentValues.containsKey("msgSvrId"))
    {
      this.field_msgSvrId = paramContentValues.getAsLong("msgSvrId").longValue();
      if (paramBoolean) {
        this.jTO = true;
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
      if (liS != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.liL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (liT == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (liU == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (kyR == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (kUg == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (liV == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (liW == k) {
        this.field_sender = paramCursor.getString(i);
      } else if (liX == k) {
        this.field_exclusiveUsername = paramCursor.getString(i);
      } else if (liY == k) {
        this.field_sendId = paramCursor.getString(i);
      } else if (kUh == k) {
        this.field_invalidtime = paramCursor.getInt(i);
      } else if (jUc == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.liL) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.liM) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.liN) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.kyG) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.kUb) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.liO) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.liP) {
      localContentValues.put("sender", this.field_sender);
    }
    if (this.liQ) {
      localContentValues.put("exclusiveUsername", this.field_exclusiveUsername);
    }
    if (this.liR) {
      localContentValues.put("sendId", this.field_sendId);
    }
    if (this.kUc) {
      localContentValues.put("invalidtime", Integer.valueOf(this.field_invalidtime));
    }
    if (this.jTO) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
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
  
  public StorageObserverOwner<? extends il> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_mNativeUrl;
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
 * Qualified Name:     com.tencent.mm.autogen.b.il
 * JD-Core Version:    0.7.0.1
 */