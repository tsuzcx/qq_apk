package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eEU;
  private static final int eFp = "username".hashCode();
  private static final int eFq;
  private static final int eJn = "bitFlag".hashCode();
  private static final int eKA;
  private static final int eKB;
  private static final int eKC;
  private static final int eKD;
  private static final int eKE;
  private static final int eKF;
  private static final int eKG;
  private static final int eKH;
  private static final int eKI;
  private static final int eKv;
  private static final int eKw;
  private static final int eKx;
  private static final int eKy;
  private static final int eKz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eED = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eJa = true;
  private boolean eKh = true;
  private boolean eKi = true;
  private boolean eKj = true;
  private boolean eKk = true;
  private boolean eKl = true;
  private boolean eKm = true;
  private boolean eKn = true;
  private boolean eKo = true;
  private boolean eKp = true;
  private boolean eKq = true;
  private boolean eKr = true;
  private boolean eKs = true;
  private boolean eKt = true;
  private boolean eKu = true;
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
    eEU = "appId".hashCode();
    eKv = "brandList".hashCode();
    eKw = "brandListVersion".hashCode();
    eKx = "brandListContent".hashCode();
    eKy = "brandFlag".hashCode();
    eKz = "extInfo".hashCode();
    eKA = "brandInfo".hashCode();
    eKB = "brandIconURL".hashCode();
    eFq = "updateTime".hashCode();
    eKC = "hadAlert".hashCode();
    eKD = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    eDc = "status".hashCode();
    eKE = "enterpriseFather".hashCode();
    eKF = "kfWorkerId".hashCode();
    eKG = "specialType".hashCode();
    eKH = "attrSyncVersion".hashCode();
    eKI = "incrementUpdateTime".hashCode();
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eKv == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (eKw == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (eKx == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (eKy == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (eKz == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (eKA == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (eKB == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eKC == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (eKD == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eKE == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (eKF == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (eKG == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (eKH == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (eKI == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (eJn == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.eKh) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.eKi) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.eKj) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.eKk) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.eKl) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eKm) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.eKn) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eKo) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.eKp) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eKq) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.eKr) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.eKs) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.eKt) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.eKu) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.eJa) {
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