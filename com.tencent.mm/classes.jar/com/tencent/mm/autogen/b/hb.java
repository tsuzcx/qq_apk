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

public abstract class hb
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("shakeitem1");
  public static final Column TYPE;
  public static final Column USERNAME;
  public static final Column jKD;
  private static final int jLl;
  public static final Column jTD;
  public static final Column jTk;
  private static final int jTs;
  private static final int jUf;
  public static final Column kWF;
  public static final Column kWG;
  public static final Column kWH;
  public static final Column kWI;
  public static final Column kWJ;
  public static final Column kWK;
  public static final Column kWL;
  public static final Column kWM;
  public static final Column kWN;
  public static final Column kWO;
  private static final int kWZ;
  private static final int kXa;
  private static final int kXb;
  private static final int kXc;
  private static final int kXd;
  private static final int kXe;
  private static final int kXf;
  private static final int kXg;
  private static final int kXh;
  private static final int kXi;
  public static final Column keg;
  public static final Column keh;
  public static final Column kei;
  public static final Column kej;
  private static final int kfJ;
  private static final int kfK;
  private static final int kfL;
  private static final int kfM;
  private static final int kwO;
  public static final Column kwi;
  private static final StorageObserverOwner<hb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
  public String field_city;
  public String field_distance;
  public int field_hasHDImg;
  public int field_imgstatus;
  public int field_insertBatch;
  public byte[] field_lvbuffer;
  public String field_nickname;
  public String field_province;
  public String field_regionCode;
  public int field_reserved1;
  public int field_reserved2;
  public String field_reserved3;
  public String field_reserved4;
  public int field_sex;
  public int field_shakeItemID;
  public String field_signature;
  public int field_snsFlag;
  public String field_sns_bgurl;
  public int field_type;
  public String field_username;
  private boolean jKU = true;
  private boolean jTR = true;
  private boolean jTo = true;
  private boolean kWP = true;
  private boolean kWQ = true;
  private boolean kWR = true;
  private boolean kWS = true;
  private boolean kWT = true;
  private boolean kWU = true;
  private boolean kWV = true;
  private boolean kWW = true;
  private boolean kWX = true;
  private boolean kWY = true;
  private boolean keV = true;
  private boolean keW = true;
  private boolean keX = true;
  private boolean keY = true;
  private boolean kwy = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kWF = new Column("shakeItemID", "int", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kWG = new Column("province", "string", TABLE.getName(), "");
    kWH = new Column("city", "string", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    kWI = new Column("distance", "string", TABLE.getName(), "");
    kwi = new Column("sex", "int", TABLE.getName(), "");
    kWJ = new Column("imgstatus", "int", TABLE.getName(), "");
    kWK = new Column("hasHDImg", "int", TABLE.getName(), "");
    kWL = new Column("insertBatch", "int", TABLE.getName(), "");
    keg = new Column("reserved1", "int", TABLE.getName(), "");
    keh = new Column("reserved2", "int", TABLE.getName(), "");
    kei = new Column("reserved3", "string", TABLE.getName(), "");
    kej = new Column("reserved4", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jTD = new Column("lvbuffer", "byte[]", TABLE.getName(), "");
    kWM = new Column("regionCode", "string", TABLE.getName(), "");
    kWN = new Column("snsFlag", "int", TABLE.getName(), "");
    kWO = new Column("sns_bgurl", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kWZ = "shakeItemID".hashCode();
    username_HASHCODE = "username".hashCode();
    jTs = "nickname".hashCode();
    kXa = "province".hashCode();
    kXb = "city".hashCode();
    jLl = "signature".hashCode();
    kXc = "distance".hashCode();
    kwO = "sex".hashCode();
    kXd = "imgstatus".hashCode();
    kXe = "hasHDImg".hashCode();
    kXf = "insertBatch".hashCode();
    kfJ = "reserved1".hashCode();
    kfK = "reserved2".hashCode();
    kfL = "reserved3".hashCode();
    kfM = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
    jUf = "lvbuffer".hashCode();
    kXg = "regionCode".hashCode();
    kXh = "snsFlag".hashCode();
    kXi = "sns_bgurl".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "shakeItemID";
    localMAutoDBInfo.colsMap.put("shakeItemID", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" shakeItemID INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "shakeItemID";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "province";
    localMAutoDBInfo.colsMap.put("province", "TEXT");
    localStringBuilder.append(" province TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "city";
    localMAutoDBInfo.colsMap.put("city", "TEXT");
    localStringBuilder.append(" city TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "distance";
    localMAutoDBInfo.colsMap.put("distance", "TEXT");
    localStringBuilder.append(" distance TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "sex";
    localMAutoDBInfo.colsMap.put("sex", "INTEGER");
    localStringBuilder.append(" sex INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "imgstatus";
    localMAutoDBInfo.colsMap.put("imgstatus", "INTEGER");
    localStringBuilder.append(" imgstatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "hasHDImg";
    localMAutoDBInfo.colsMap.put("hasHDImg", "INTEGER");
    localStringBuilder.append(" hasHDImg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "insertBatch";
    localMAutoDBInfo.colsMap.put("insertBatch", "INTEGER");
    localStringBuilder.append(" insertBatch INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "INTEGER");
    localStringBuilder.append(" reserved2 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "TEXT");
    localStringBuilder.append(" reserved3 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "TEXT");
    localStringBuilder.append(" reserved4 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "regionCode";
    localMAutoDBInfo.colsMap.put("regionCode", "TEXT");
    localStringBuilder.append(" regionCode TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "snsFlag";
    localMAutoDBInfo.colsMap.put("snsFlag", "INTEGER");
    localStringBuilder.append(" snsFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "sns_bgurl";
    localMAutoDBInfo.colsMap.put("sns_bgurl", "TEXT");
    localStringBuilder.append(" sns_bgurl TEXT");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("shakeItemID"))
    {
      this.field_shakeItemID = paramContentValues.getAsInteger("shakeItemID").intValue();
      if (paramBoolean) {
        this.kWP = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("province"))
    {
      this.field_province = paramContentValues.getAsString("province");
      if (paramBoolean) {
        this.kWQ = true;
      }
    }
    if (paramContentValues.containsKey("city"))
    {
      this.field_city = paramContentValues.getAsString("city");
      if (paramBoolean) {
        this.kWR = true;
      }
    }
    if (paramContentValues.containsKey("signature"))
    {
      this.field_signature = paramContentValues.getAsString("signature");
      if (paramBoolean) {
        this.jKU = true;
      }
    }
    if (paramContentValues.containsKey("distance"))
    {
      this.field_distance = paramContentValues.getAsString("distance");
      if (paramBoolean) {
        this.kWS = true;
      }
    }
    if (paramContentValues.containsKey("sex"))
    {
      this.field_sex = paramContentValues.getAsInteger("sex").intValue();
      if (paramBoolean) {
        this.kwy = true;
      }
    }
    if (paramContentValues.containsKey("imgstatus"))
    {
      this.field_imgstatus = paramContentValues.getAsInteger("imgstatus").intValue();
      if (paramBoolean) {
        this.kWT = true;
      }
    }
    if (paramContentValues.containsKey("hasHDImg"))
    {
      this.field_hasHDImg = paramContentValues.getAsInteger("hasHDImg").intValue();
      if (paramBoolean) {
        this.kWU = true;
      }
    }
    if (paramContentValues.containsKey("insertBatch"))
    {
      this.field_insertBatch = paramContentValues.getAsInteger("insertBatch").intValue();
      if (paramBoolean) {
        this.kWV = true;
      }
    }
    if (paramContentValues.containsKey("reserved1"))
    {
      this.field_reserved1 = paramContentValues.getAsInteger("reserved1").intValue();
      if (paramBoolean) {
        this.keV = true;
      }
    }
    if (paramContentValues.containsKey("reserved2"))
    {
      this.field_reserved2 = paramContentValues.getAsInteger("reserved2").intValue();
      if (paramBoolean) {
        this.keW = true;
      }
    }
    if (paramContentValues.containsKey("reserved3"))
    {
      this.field_reserved3 = paramContentValues.getAsString("reserved3");
      if (paramBoolean) {
        this.keX = true;
      }
    }
    if (paramContentValues.containsKey("reserved4"))
    {
      this.field_reserved4 = paramContentValues.getAsString("reserved4");
      if (paramBoolean) {
        this.keY = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("lvbuffer"))
    {
      this.field_lvbuffer = paramContentValues.getAsByteArray("lvbuffer");
      if (paramBoolean) {
        this.jTR = true;
      }
    }
    if (paramContentValues.containsKey("regionCode"))
    {
      this.field_regionCode = paramContentValues.getAsString("regionCode");
      if (paramBoolean) {
        this.kWW = true;
      }
    }
    if (paramContentValues.containsKey("snsFlag"))
    {
      this.field_snsFlag = paramContentValues.getAsInteger("snsFlag").intValue();
      if (paramBoolean) {
        this.kWX = true;
      }
    }
    if (paramContentValues.containsKey("sns_bgurl"))
    {
      this.field_sns_bgurl = paramContentValues.getAsString("sns_bgurl");
      if (paramBoolean) {
        this.kWY = true;
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
      if (kWZ != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.kWP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kXa == k) {
        this.field_province = paramCursor.getString(i);
      } else if (kXb == k) {
        this.field_city = paramCursor.getString(i);
      } else if (jLl == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (kXc == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (kwO == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (kXd == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (kXe == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (kXf == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (kfJ == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (kfK == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (kfL == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (kfM == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jUf == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (kXg == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (kXh == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (kXi == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kWP) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.kWQ) {
      localContentValues.put("province", this.field_province);
    }
    if (this.kWR) {
      localContentValues.put("city", this.field_city);
    }
    if (this.jKU) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.kWS) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.kwy) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.kWT) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.kWU) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.kWV) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.keV) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.keW) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.keX) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.keY) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jTR) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.kWW) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.kWX) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.kWY) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
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
  
  public StorageObserverOwner<? extends hb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_shakeItemID);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hb
 * JD-Core Version:    0.7.0.1
 */