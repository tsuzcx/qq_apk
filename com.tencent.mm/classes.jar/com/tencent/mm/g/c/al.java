package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class al
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjl;
  private static final int fkj;
  private static final int foC = "bitFlag".hashCode();
  private static final int fpL;
  private static final int fpM;
  private static final int fpN;
  private static final int fpO;
  private static final int fpP;
  private static final int fpQ;
  private static final int fpR;
  private static final int fpS;
  private static final int fpT;
  private static final int fpU;
  private static final int fpV;
  private static final int fpW;
  private static final int fpX;
  private static final int fpY;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
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
  private boolean fjS = true;
  private boolean fji = true;
  private boolean fop = true;
  private boolean fpA = true;
  private boolean fpB = true;
  private boolean fpC = true;
  private boolean fpD = true;
  private boolean fpE = true;
  private boolean fpF = true;
  private boolean fpG = true;
  private boolean fpH = true;
  private boolean fpI = true;
  private boolean fpJ = true;
  private boolean fpK = true;
  private boolean fpx = true;
  private boolean fpy = true;
  private boolean fpz = true;
  
  static
  {
    fkj = "appId".hashCode();
    fpL = "brandList".hashCode();
    fpM = "brandListVersion".hashCode();
    fpN = "brandListContent".hashCode();
    fpO = "brandFlag".hashCode();
    fpP = "extInfo".hashCode();
    fpQ = "brandInfo".hashCode();
    fpR = "brandIconURL".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fpS = "hadAlert".hashCode();
    fpT = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    fjl = "status".hashCode();
    fpU = "enterpriseFather".hashCode();
    fpV = "kfWorkerId".hashCode();
    fpW = "specialType".hashCode();
    fpX = "attrSyncVersion".hashCode();
    fpY = "incrementUpdateTime".hashCode();
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
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fpL == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (fpM == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (fpN == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (fpO == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (fpP == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (fpQ == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (fpR == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fpS == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (fpT == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fpU == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (fpV == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (fpW == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (fpX == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (fpY == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (foC == k) {
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
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.fpx) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.fpy) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.fpz) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.fpA) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.fpB) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.fpC) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.fpD) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fpE) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.fpF) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fpG) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.fpH) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.fpI) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.fpJ) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.fpK) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.fop) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.al
 * JD-Core Version:    0.7.0.1
 */