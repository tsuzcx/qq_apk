package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class al
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizInfo");
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnz;
  private static final int hoh;
  public static final Column htS;
  private static final int hus = "bitFlag".hashCode();
  public static final Column hvG;
  public static final Column hvH;
  public static final Column hvI;
  public static final Column hvJ;
  public static final Column hvK;
  public static final Column hvL;
  public static final Column hvM;
  public static final Column hvN;
  public static final Column hvO;
  public static final Column hvP;
  public static final Column hvQ;
  public static final Column hvR;
  public static final Column hvS;
  public static final Column hvT;
  private static final int hwi;
  private static final int hwj;
  private static final int hwk;
  private static final int hwl;
  private static final int hwm;
  private static final int hwn;
  private static final int hwo;
  private static final int hwp;
  private static final int hwq;
  private static final int hwr;
  private static final int hws;
  private static final int hwt;
  private static final int hwu;
  private static final int hwv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean huf = true;
  private boolean hvU = true;
  private boolean hvV = true;
  private boolean hvW = true;
  private boolean hvX = true;
  private boolean hvY = true;
  private boolean hvZ = true;
  private boolean hwa = true;
  private boolean hwb = true;
  private boolean hwc = true;
  private boolean hwd = true;
  private boolean hwe = true;
  private boolean hwf = true;
  private boolean hwg = true;
  private boolean hwh = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizInfo", "");
    C_USERNAME = new Column("username", "string", "BizInfo", "");
    hnz = new Column("appid", "string", "BizInfo", "");
    hvG = new Column("brandlist", "string", "BizInfo", "");
    hvH = new Column("brandlistversion", "string", "BizInfo", "");
    hvI = new Column("brandlistcontent", "string", "BizInfo", "");
    hvJ = new Column("brandflag", "int", "BizInfo", "");
    hvK = new Column("extinfo", "string", "BizInfo", "");
    hvL = new Column("brandinfo", "string", "BizInfo", "");
    hvM = new Column("brandiconurl", "string", "BizInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "BizInfo", "");
    hvN = new Column("hadalert", "int", "BizInfo", "");
    hvO = new Column("accepttype", "int", "BizInfo", "");
    C_TYPE = new Column("type", "int", "BizInfo", "");
    hmw = new Column("status", "int", "BizInfo", "");
    hvP = new Column("enterprisefather", "string", "BizInfo", "");
    hvQ = new Column("kfworkerid", "string", "BizInfo", "");
    hvR = new Column("specialtype", "int", "BizInfo", "");
    hvS = new Column("attrsyncversion", "string", "BizInfo", "");
    hvT = new Column("incrementupdatetime", "long", "BizInfo", "");
    htS = new Column("bitflag", "int", "BizInfo", "");
    username_HASHCODE = "username".hashCode();
    hoh = "appId".hashCode();
    hwi = "brandList".hashCode();
    hwj = "brandListVersion".hashCode();
    hwk = "brandListContent".hashCode();
    hwl = "brandFlag".hashCode();
    hwm = "extInfo".hashCode();
    hwn = "brandInfo".hashCode();
    hwo = "brandIconURL".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hwp = "hadAlert".hashCode();
    hwq = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    hmC = "status".hashCode();
    hwr = "enterpriseFather".hashCode();
    hws = "kfWorkerId".hashCode();
    hwt = "specialType".hashCode();
    hwu = "attrSyncVersion".hashCode();
    hwv = "incrementUpdateTime".hashCode();
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
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hwi == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (hwj == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (hwk == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (hwl == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (hwm == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (hwn == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (hwo == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hwp == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (hwq == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (hwr == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (hws == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (hwt == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (hwu == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (hwv == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (hus == k) {
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
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.hvU) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.hvV) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.hvW) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.hvX) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.hvY) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.hvZ) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.hwa) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hwb) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.hwc) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hwd) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.hwe) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.hwf) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.hwg) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.hwh) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.huf) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "BizInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.al
 * JD-Core Version:    0.7.0.1
 */