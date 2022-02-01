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

public abstract class am
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizInfo");
  public static final Column TYPE;
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  private static final int jIF;
  public static final Column jIz;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jQF;
  private static final int jRf;
  public static final Column jSA;
  public static final Column jSB;
  public static final Column jSC;
  public static final Column jSD;
  public static final Column jSE;
  public static final Column jSF;
  public static final Column jSG;
  private static final int jSV;
  private static final int jSW;
  private static final int jSX;
  private static final int jSY;
  private static final int jSZ;
  public static final Column jSt;
  public static final Column jSu;
  public static final Column jSv;
  public static final Column jSw;
  public static final Column jSx;
  public static final Column jSy;
  public static final Column jSz;
  private static final int jTa;
  private static final int jTb;
  private static final int jTc;
  private static final int jTd;
  private static final int jTe;
  private static final int jTf;
  private static final int jTg;
  private static final int jTh;
  private static final int jTi;
  private static final StorageObserverOwner<am> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public int field_acceptType;
  public String field_appId;
  public String field_attrSyncVersion;
  public int field_bitFlag;
  public int field_brandFlag;
  public String field_brandIconURL;
  public String field_brandInfo;
  public String field_brandList;
  public String field_brandListContent;
  public String field_brandListVersion;
  public String field_enterpriseFather;
  public String field_extInfo;
  public int field_hadAlert;
  public long field_incrementUpdateTime;
  public String field_kfWorkerId;
  public int field_specialType;
  public int field_status;
  public int field_type;
  public long field_updateTime;
  public String field_username;
  private boolean jIC = true;
  private boolean jKG = true;
  private boolean jQS = true;
  private boolean jSH = true;
  private boolean jSI = true;
  private boolean jSJ = true;
  private boolean jSK = true;
  private boolean jSL = true;
  private boolean jSM = true;
  private boolean jSN = true;
  private boolean jSO = true;
  private boolean jSP = true;
  private boolean jSQ = true;
  private boolean jSR = true;
  private boolean jSS = true;
  private boolean jST = true;
  private boolean jSU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    jSt = new Column("brandList", "string", TABLE.getName(), "");
    jSu = new Column("brandListVersion", "string", TABLE.getName(), "");
    jSv = new Column("brandListContent", "string", TABLE.getName(), "");
    jSw = new Column("brandFlag", "int", TABLE.getName(), "");
    jSx = new Column("extInfo", "string", TABLE.getName(), "");
    jSy = new Column("brandInfo", "string", TABLE.getName(), "");
    jSz = new Column("brandIconURL", "string", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jSA = new Column("hadAlert", "int", TABLE.getName(), "");
    jSB = new Column("acceptType", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jSC = new Column("enterpriseFather", "string", TABLE.getName(), "");
    jSD = new Column("kfWorkerId", "string", TABLE.getName(), "");
    jSE = new Column("specialType", "int", TABLE.getName(), "");
    jSF = new Column("attrSyncVersion", "string", TABLE.getName(), "");
    jSG = new Column("incrementUpdateTime", "long", TABLE.getName(), "");
    jQF = new Column("bitFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    username_HASHCODE = "username".hashCode();
    jKX = "appId".hashCode();
    jSV = "brandList".hashCode();
    jSW = "brandListVersion".hashCode();
    jSX = "brandListContent".hashCode();
    jSY = "brandFlag".hashCode();
    jSZ = "extInfo".hashCode();
    jTa = "brandInfo".hashCode();
    jTb = "brandIconURL".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jTc = "hadAlert".hashCode();
    jTd = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    jIF = "status".hashCode();
    jTe = "enterpriseFather".hashCode();
    jTf = "kfWorkerId".hashCode();
    jTg = "specialType".hashCode();
    jTh = "attrSyncVersion".hashCode();
    jTi = "incrementUpdateTime".hashCode();
    jRf = "bitFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "brandList";
    localMAutoDBInfo.colsMap.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "brandListVersion";
    localMAutoDBInfo.colsMap.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "brandListContent";
    localMAutoDBInfo.colsMap.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "brandFlag";
    localMAutoDBInfo.colsMap.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "brandInfo";
    localMAutoDBInfo.colsMap.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "brandIconURL";
    localMAutoDBInfo.colsMap.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "hadAlert";
    localMAutoDBInfo.colsMap.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "acceptType";
    localMAutoDBInfo.colsMap.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "enterpriseFather";
    localMAutoDBInfo.colsMap.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "kfWorkerId";
    localMAutoDBInfo.colsMap.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "specialType";
    localMAutoDBInfo.colsMap.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "attrSyncVersion";
    localMAutoDBInfo.colsMap.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "incrementUpdateTime";
    localMAutoDBInfo.colsMap.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("brandList"))
    {
      this.field_brandList = paramContentValues.getAsString("brandList");
      if (paramBoolean) {
        this.jSH = true;
      }
    }
    if (paramContentValues.containsKey("brandListVersion"))
    {
      this.field_brandListVersion = paramContentValues.getAsString("brandListVersion");
      if (paramBoolean) {
        this.jSI = true;
      }
    }
    if (paramContentValues.containsKey("brandListContent"))
    {
      this.field_brandListContent = paramContentValues.getAsString("brandListContent");
      if (paramBoolean) {
        this.jSJ = true;
      }
    }
    if (paramContentValues.containsKey("brandFlag"))
    {
      this.field_brandFlag = paramContentValues.getAsInteger("brandFlag").intValue();
      if (paramBoolean) {
        this.jSK = true;
      }
    }
    if (paramContentValues.containsKey("extInfo"))
    {
      this.field_extInfo = paramContentValues.getAsString("extInfo");
      if (paramBoolean) {
        this.jSL = true;
      }
    }
    if (paramContentValues.containsKey("brandInfo"))
    {
      this.field_brandInfo = paramContentValues.getAsString("brandInfo");
      if (paramBoolean) {
        this.jSM = true;
      }
    }
    if (paramContentValues.containsKey("brandIconURL"))
    {
      this.field_brandIconURL = paramContentValues.getAsString("brandIconURL");
      if (paramBoolean) {
        this.jSN = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("hadAlert"))
    {
      this.field_hadAlert = paramContentValues.getAsInteger("hadAlert").intValue();
      if (paramBoolean) {
        this.jSO = true;
      }
    }
    if (paramContentValues.containsKey("acceptType"))
    {
      this.field_acceptType = paramContentValues.getAsInteger("acceptType").intValue();
      if (paramBoolean) {
        this.jSP = true;
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
    if (paramContentValues.containsKey("enterpriseFather"))
    {
      this.field_enterpriseFather = paramContentValues.getAsString("enterpriseFather");
      if (paramBoolean) {
        this.jSQ = true;
      }
    }
    if (paramContentValues.containsKey("kfWorkerId"))
    {
      this.field_kfWorkerId = paramContentValues.getAsString("kfWorkerId");
      if (paramBoolean) {
        this.jSR = true;
      }
    }
    if (paramContentValues.containsKey("specialType"))
    {
      this.field_specialType = paramContentValues.getAsInteger("specialType").intValue();
      if (paramBoolean) {
        this.jSS = true;
      }
    }
    if (paramContentValues.containsKey("attrSyncVersion"))
    {
      this.field_attrSyncVersion = paramContentValues.getAsString("attrSyncVersion");
      if (paramBoolean) {
        this.jST = true;
      }
    }
    if (paramContentValues.containsKey("incrementUpdateTime"))
    {
      this.field_incrementUpdateTime = paramContentValues.getAsLong("incrementUpdateTime").longValue();
      if (paramBoolean) {
        this.jSU = true;
      }
    }
    if (paramContentValues.containsKey("bitFlag"))
    {
      this.field_bitFlag = paramContentValues.getAsInteger("bitFlag").intValue();
      if (paramBoolean) {
        this.jQS = true;
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (jSV == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (jSW == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (jSX == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (jSY == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (jSZ == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (jTa == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (jTb == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jTc == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (jTd == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (jTe == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (jTf == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (jTg == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (jTh == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (jTi == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (jRf == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.jSH) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.jSI) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.jSJ) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.jSK) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.jSL) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.jSM) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.jSN) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.jSO) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.jSP) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.jSQ) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.jSR) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.jSS) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.jST) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.jSU) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.jQS) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
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
  
  public StorageObserverOwner<? extends am> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.am
 * JD-Core Version:    0.7.0.1
 */