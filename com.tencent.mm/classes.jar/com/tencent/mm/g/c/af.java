package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dhB;
  private static final int dhU = "username".hashCode();
  private static final int dhV;
  private static final int dlA = "bitFlag".hashCode();
  private static final int dmA;
  private static final int dmB;
  private static final int dmC;
  private static final int dmD;
  private static final int dmE;
  private static final int dmF;
  private static final int dmG;
  private static final int dmH;
  private static final int dmI;
  private static final int dmJ;
  private static final int dmK;
  private static final int dmL;
  private static final int dmM;
  private static final int dmz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dfG = true;
  private boolean dhS = true;
  private boolean dhT = true;
  private boolean dhk = true;
  private boolean dlo = true;
  private boolean dml = true;
  private boolean dmm = true;
  private boolean dmn = true;
  private boolean dmo = true;
  private boolean dmp = true;
  private boolean dmq = true;
  private boolean dmr = true;
  private boolean dms = true;
  private boolean dmt = true;
  private boolean dmu = true;
  private boolean dmv = true;
  private boolean dmw = true;
  private boolean dmx = true;
  private boolean dmy = true;
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
    dhB = "appId".hashCode();
    dmz = "brandList".hashCode();
    dmA = "brandListVersion".hashCode();
    dmB = "brandListContent".hashCode();
    dmC = "brandFlag".hashCode();
    dmD = "extInfo".hashCode();
    dmE = "brandInfo".hashCode();
    dmF = "brandIconURL".hashCode();
    dhV = "updateTime".hashCode();
    dmG = "hadAlert".hashCode();
    dmH = "acceptType".hashCode();
    type_HASHCODE = "type".hashCode();
    dfJ = "status".hashCode();
    dmI = "enterpriseFather".hashCode();
    dmJ = "kfWorkerId".hashCode();
    dmK = "specialType".hashCode();
    dmL = "attrSyncVersion".hashCode();
    dmM = "incrementUpdateTime".hashCode();
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
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dmz == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (dmA == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (dmB == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (dmC == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (dmD == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (dmE == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (dmF == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dmG == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (dmH == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dmI == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (dmJ == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (dmK == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (dmL == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (dmM == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (dlA == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.dml) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.dmm) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.dmn) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.dmo) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.dmp) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.dmq) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.dmr) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dms) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.dmt) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dmu) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.dmv) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.dmw) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.dmx) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.dmy) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.dlo) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.af
 * JD-Core Version:    0.7.0.1
 */