package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eGD;
  private static final int eGY = "username".hashCode();
  private static final int eGZ;
  private static final int eKW = "bitFlag".hashCode();
  private static final int eMe;
  private static final int eMf;
  private static final int eMg;
  private static final int eMh;
  private static final int eMi;
  private static final int eMj;
  private static final int eMk;
  private static final int eMl;
  private static final int eMm;
  private static final int eMn;
  private static final int eMo;
  private static final int eMp;
  private static final int eMq;
  private static final int eMr;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eGV = true;
  private boolean eGW = true;
  private boolean eGm = true;
  private boolean eKJ = true;
  private boolean eLQ = true;
  private boolean eLR = true;
  private boolean eLS = true;
  private boolean eLT = true;
  private boolean eLU = true;
  private boolean eLV = true;
  private boolean eLW = true;
  private boolean eLX = true;
  private boolean eLY = true;
  private boolean eLZ = true;
  private boolean eMa = true;
  private boolean eMb = true;
  private boolean eMc = true;
  private boolean eMd = true;
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
  
  static
  {
    eGD = "appId".hashCode();
    eMe = "brandList".hashCode();
    eMf = "brandListVersion".hashCode();
    eMg = "brandListContent".hashCode();
    eMh = "brandFlag".hashCode();
    eMi = "extInfo".hashCode();
    eMj = "brandInfo".hashCode();
    eMk = "brandIconURL".hashCode();
    eGZ = "updateTime".hashCode();
    eMl = "hadAlert".hashCode();
    eMm = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    eEL = "status".hashCode();
    eMn = "enterpriseFather".hashCode();
    eMo = "kfWorkerId".hashCode();
    eMp = "specialType".hashCode();
    eMq = "attrSyncVersion".hashCode();
    eMr = "incrementUpdateTime".hashCode();
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
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eMe == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (eMf == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (eMg == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (eMh == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (eMi == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (eMj == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (eMk == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eMl == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (eMm == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eMn == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (eMo == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (eMp == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (eMq == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (eMr == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (eKW == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.eLQ) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.eLR) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.eLS) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.eLT) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.eLU) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eLV) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.eLW) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eLX) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.eLY) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eLZ) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.eMa) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.eMb) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.eMc) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.eMd) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.eKJ) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ak
 * JD-Core Version:    0.7.0.1
 */