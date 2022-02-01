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

public abstract class hd
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ShareCardInfo");
  public static final Column UPDATETIME;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jUT;
  public static final Column jUU;
  private static final int jVF;
  private static final int jVG;
  private static final int kXJ;
  private static final int kXK;
  private static final int kXL;
  private static final int kXM;
  private static final int kXN;
  private static final int kXO;
  private static final int kXP;
  private static final int kXQ;
  private static final int kXR;
  private static final int kXS;
  private static final int kXT;
  private static final int kXU;
  private static final int kXV;
  public static final Column kXj;
  public static final Column kXk;
  public static final Column kXl;
  public static final Column kXm;
  public static final Column kXn;
  public static final Column kXo;
  public static final Column kXp;
  public static final Column kXq;
  public static final Column kXr;
  public static final Column kXs;
  public static final Column kXt;
  public static final Column kXu;
  public static final Column kXv;
  public static final Column kek;
  private static final int kfN;
  public static final Column kiL;
  private static final int kjn;
  private static final StorageObserverOwner<hd> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_app_id;
  public long field_begin_time;
  public long field_block_mask;
  public byte[] field_cardTpInfoData;
  public String field_card_id;
  public String field_card_tp_id;
  public int field_categoryType;
  public String field_consumer;
  public byte[] field_dataInfoData;
  public long field_end_time;
  public String field_from_username;
  public int field_itemIndex;
  public long field_local_updateTime;
  public byte[] field_shareInfoData;
  public long field_share_time;
  public byte[] field_shopInfoData;
  public int field_status;
  public long field_updateSeq;
  public long field_updateTime;
  private boolean jIC = true;
  private boolean jVm = true;
  private boolean jVn = true;
  private boolean kXA = true;
  private boolean kXB = true;
  private boolean kXC = true;
  private boolean kXD = true;
  private boolean kXE = true;
  private boolean kXF = true;
  private boolean kXG = true;
  private boolean kXH = true;
  private boolean kXI = true;
  private boolean kXw = true;
  private boolean kXx = true;
  private boolean kXy = true;
  private boolean kXz = true;
  private boolean keZ = true;
  private boolean kiZ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    jUU = new Column("card_tp_id", "string", TABLE.getName(), "");
    kXj = new Column("from_username", "string", TABLE.getName(), "");
    kXk = new Column("consumer", "string", TABLE.getName(), "");
    kek = new Column("app_id", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kXl = new Column("share_time", "long", TABLE.getName(), "");
    kXm = new Column("local_updateTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kXn = new Column("begin_time", "long", TABLE.getName(), "");
    kXo = new Column("end_time", "long", TABLE.getName(), "");
    kiL = new Column("updateSeq", "long", TABLE.getName(), "");
    kXp = new Column("block_mask", "long", TABLE.getName(), "");
    kXq = new Column("dataInfoData", "byte[]", TABLE.getName(), "");
    kXr = new Column("cardTpInfoData", "byte[]", TABLE.getName(), "");
    kXs = new Column("shareInfoData", "byte[]", TABLE.getName(), "");
    kXt = new Column("shopInfoData", "byte[]", TABLE.getName(), "");
    kXu = new Column("categoryType", "int", TABLE.getName(), "");
    kXv = new Column("itemIndex", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
    jVF = "card_id".hashCode();
    jVG = "card_tp_id".hashCode();
    kXJ = "from_username".hashCode();
    kXK = "consumer".hashCode();
    kfN = "app_id".hashCode();
    jIF = "status".hashCode();
    kXL = "share_time".hashCode();
    kXM = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kXN = "begin_time".hashCode();
    kXO = "end_time".hashCode();
    kjn = "updateSeq".hashCode();
    kXP = "block_mask".hashCode();
    kXQ = "dataInfoData".hashCode();
    kXR = "cardTpInfoData".hashCode();
    kXS = "shareInfoData".hashCode();
    kXT = "shopInfoData".hashCode();
    kXU = "categoryType".hashCode();
    kXV = "itemIndex".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "card_tp_id";
    localMAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "from_username";
    localMAutoDBInfo.colsMap.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "consumer";
    localMAutoDBInfo.colsMap.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "app_id";
    localMAutoDBInfo.colsMap.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "share_time";
    localMAutoDBInfo.colsMap.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "local_updateTime";
    localMAutoDBInfo.colsMap.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "begin_time";
    localMAutoDBInfo.colsMap.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "end_time";
    localMAutoDBInfo.colsMap.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "updateSeq";
    localMAutoDBInfo.colsMap.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "block_mask";
    localMAutoDBInfo.colsMap.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "dataInfoData";
    localMAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "cardTpInfoData";
    localMAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shareInfoData";
    localMAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "shopInfoData";
    localMAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "categoryType";
    localMAutoDBInfo.colsMap.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "itemIndex";
    localMAutoDBInfo.colsMap.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("card_id"))
    {
      this.field_card_id = paramContentValues.getAsString("card_id");
      if (paramBoolean) {
        this.jVm = true;
      }
    }
    if (paramContentValues.containsKey("card_tp_id"))
    {
      this.field_card_tp_id = paramContentValues.getAsString("card_tp_id");
      if (paramBoolean) {
        this.jVn = true;
      }
    }
    if (paramContentValues.containsKey("from_username"))
    {
      this.field_from_username = paramContentValues.getAsString("from_username");
      if (paramBoolean) {
        this.kXw = true;
      }
    }
    if (paramContentValues.containsKey("consumer"))
    {
      this.field_consumer = paramContentValues.getAsString("consumer");
      if (paramBoolean) {
        this.kXx = true;
      }
    }
    if (paramContentValues.containsKey("app_id"))
    {
      this.field_app_id = paramContentValues.getAsString("app_id");
      if (paramBoolean) {
        this.keZ = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("share_time"))
    {
      this.field_share_time = paramContentValues.getAsLong("share_time").longValue();
      if (paramBoolean) {
        this.kXy = true;
      }
    }
    if (paramContentValues.containsKey("local_updateTime"))
    {
      this.field_local_updateTime = paramContentValues.getAsLong("local_updateTime").longValue();
      if (paramBoolean) {
        this.kXz = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("begin_time"))
    {
      this.field_begin_time = paramContentValues.getAsLong("begin_time").longValue();
      if (paramBoolean) {
        this.kXA = true;
      }
    }
    if (paramContentValues.containsKey("end_time"))
    {
      this.field_end_time = paramContentValues.getAsLong("end_time").longValue();
      if (paramBoolean) {
        this.kXB = true;
      }
    }
    if (paramContentValues.containsKey("updateSeq"))
    {
      this.field_updateSeq = paramContentValues.getAsLong("updateSeq").longValue();
      if (paramBoolean) {
        this.kiZ = true;
      }
    }
    if (paramContentValues.containsKey("block_mask"))
    {
      this.field_block_mask = paramContentValues.getAsLong("block_mask").longValue();
      if (paramBoolean) {
        this.kXC = true;
      }
    }
    if (paramContentValues.containsKey("dataInfoData"))
    {
      this.field_dataInfoData = paramContentValues.getAsByteArray("dataInfoData");
      if (paramBoolean) {
        this.kXD = true;
      }
    }
    if (paramContentValues.containsKey("cardTpInfoData"))
    {
      this.field_cardTpInfoData = paramContentValues.getAsByteArray("cardTpInfoData");
      if (paramBoolean) {
        this.kXE = true;
      }
    }
    if (paramContentValues.containsKey("shareInfoData"))
    {
      this.field_shareInfoData = paramContentValues.getAsByteArray("shareInfoData");
      if (paramBoolean) {
        this.kXF = true;
      }
    }
    if (paramContentValues.containsKey("shopInfoData"))
    {
      this.field_shopInfoData = paramContentValues.getAsByteArray("shopInfoData");
      if (paramBoolean) {
        this.kXG = true;
      }
    }
    if (paramContentValues.containsKey("categoryType"))
    {
      this.field_categoryType = paramContentValues.getAsInteger("categoryType").intValue();
      if (paramBoolean) {
        this.kXH = true;
      }
    }
    if (paramContentValues.containsKey("itemIndex"))
    {
      this.field_itemIndex = paramContentValues.getAsInteger("itemIndex").intValue();
      if (paramBoolean) {
        this.kXI = true;
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
      if (jVF != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.jVm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jVG == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (kXJ == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (kXK == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (kfN == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kXL == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (kXM == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kXN == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (kXO == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (kjn == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (kXP == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (kXQ == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (kXR == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (kXS == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (kXT == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (kXU == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (kXV == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.jVn) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.kXw) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.kXx) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.keZ) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kXy) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.kXz) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kXA) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.kXB) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.kiZ) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.kXC) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.kXD) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.kXE) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.kXF) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.kXG) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.kXH) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.kXI) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
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
  
  public StorageObserverOwner<? extends hd> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_card_id;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.hd
 * JD-Core Version:    0.7.0.1
 */