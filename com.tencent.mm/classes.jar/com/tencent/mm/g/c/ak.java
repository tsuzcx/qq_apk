package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elV;
  private static final int enO;
  private static final int eok = "username".hashCode();
  private static final int eol;
  private static final int ese = "bitFlag".hashCode();
  private static final int etm;
  private static final int etn;
  private static final int eto;
  private static final int etp;
  private static final int etq;
  private static final int etr;
  private static final int ets;
  private static final int ett;
  private static final int etu;
  private static final int etv;
  private static final int etw;
  private static final int etx;
  private static final int ety;
  private static final int etz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean elS = true;
  private boolean enx = true;
  private boolean eoh = true;
  private boolean eoi = true;
  private boolean erR = true;
  private boolean esY = true;
  private boolean esZ = true;
  private boolean eta = true;
  private boolean etb = true;
  private boolean etc = true;
  private boolean etd = true;
  private boolean ete = true;
  private boolean etf = true;
  private boolean etg = true;
  private boolean eth = true;
  private boolean eti = true;
  private boolean etj = true;
  private boolean etk = true;
  private boolean etl = true;
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
    enO = "appId".hashCode();
    etm = "brandList".hashCode();
    etn = "brandListVersion".hashCode();
    eto = "brandListContent".hashCode();
    etp = "brandFlag".hashCode();
    etq = "extInfo".hashCode();
    etr = "brandInfo".hashCode();
    ets = "brandIconURL".hashCode();
    eol = "updateTime".hashCode();
    ett = "hadAlert".hashCode();
    etu = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    elV = "status".hashCode();
    etv = "enterpriseFather".hashCode();
    etw = "kfWorkerId".hashCode();
    etx = "specialType".hashCode();
    ety = "attrSyncVersion".hashCode();
    etz = "incrementUpdateTime".hashCode();
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
      if (eok != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eoh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (etm == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (etn == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (eto == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (etp == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (etq == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (etr == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (ets == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ett == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (etu == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (etv == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (etw == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (etx == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (ety == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (etz == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (ese == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.esY) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.esZ) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.eta) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.etb) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.etc) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.etd) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.ete) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.etf) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.etg) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eth) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.eti) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.etj) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.etk) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.etl) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.erR) {
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