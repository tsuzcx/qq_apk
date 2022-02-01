package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ak
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR;
  private static final int elJ;
  private static final int eme = "username".hashCode();
  private static final int emf;
  private static final int eqa = "bitFlag".hashCode();
  private static final int eri;
  private static final int erj;
  private static final int erk;
  private static final int erl;
  private static final int erm;
  private static final int ern;
  private static final int ero;
  private static final int erp;
  private static final int erq;
  private static final int err;
  private static final int ers;
  private static final int ert;
  private static final int eru;
  private static final int erv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean ejO = true;
  private boolean els = true;
  private boolean emb = true;
  private boolean emc = true;
  private boolean epN = true;
  private boolean eqU = true;
  private boolean eqV = true;
  private boolean eqW = true;
  private boolean eqX = true;
  private boolean eqY = true;
  private boolean eqZ = true;
  private boolean era = true;
  private boolean erb = true;
  private boolean erc = true;
  private boolean erd = true;
  private boolean ere = true;
  private boolean erf = true;
  private boolean erg = true;
  private boolean erh = true;
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
    elJ = "appId".hashCode();
    eri = "brandList".hashCode();
    erj = "brandListVersion".hashCode();
    erk = "brandListContent".hashCode();
    erl = "brandFlag".hashCode();
    erm = "extInfo".hashCode();
    ern = "brandInfo".hashCode();
    ero = "brandIconURL".hashCode();
    emf = "updateTime".hashCode();
    erp = "hadAlert".hashCode();
    erq = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    ejR = "status".hashCode();
    err = "enterpriseFather".hashCode();
    ers = "kfWorkerId".hashCode();
    ert = "specialType".hashCode();
    eru = "attrSyncVersion".hashCode();
    erv = "incrementUpdateTime".hashCode();
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elJ == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eri == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (erj == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (erk == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (erl == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (erm == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (ern == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (ero == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (erp == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (erq == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (err == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (ers == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (ert == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (eru == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (erv == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (eqa == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.eqU) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.eqV) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.eqW) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.eqX) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.eqY) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.eqZ) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.era) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.erb) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.erc) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.erd) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.ere) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.erf) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.erg) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.erh) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.epN) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ak
 * JD-Core Version:    0.7.0.1
 */