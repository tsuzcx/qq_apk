package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ae
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int ctF = "username".hashCode();
  private static final int ctG;
  private static final int ctl = "appId".hashCode();
  private static final int cxz;
  private static final int cyA;
  private static final int cyB;
  private static final int cyC;
  private static final int cyD;
  private static final int cyE;
  private static final int cyF;
  private static final int cyG;
  private static final int cyH;
  private static final int cyI;
  private static final int cyJ;
  private static final int cyK;
  private static final int cyL;
  private static final int cyy = "brandList".hashCode();
  private static final int cyz = "brandListVersion".hashCode();
  private boolean crk = true;
  private boolean csU = true;
  private boolean csa = true;
  private boolean ctD = true;
  private boolean ctE = true;
  private boolean cxn = true;
  private boolean cyk = true;
  private boolean cyl = true;
  private boolean cym = true;
  private boolean cyn = true;
  private boolean cyo = true;
  private boolean cyp = true;
  private boolean cyq = true;
  private boolean cyr = true;
  private boolean cys = true;
  private boolean cyt = true;
  private boolean cyu = true;
  private boolean cyv = true;
  private boolean cyw = true;
  private boolean cyx = true;
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
    cyA = "brandListContent".hashCode();
    cyB = "brandFlag".hashCode();
    cyC = "extInfo".hashCode();
    cyD = "brandInfo".hashCode();
    cyE = "brandIconURL".hashCode();
    ctG = "updateTime".hashCode();
    cyF = "hadAlert".hashCode();
    cyG = "acceptType".hashCode();
    csy = "type".hashCode();
    crn = "status".hashCode();
    cyH = "enterpriseFather".hashCode();
    cyI = "kfWorkerId".hashCode();
    cyJ = "specialType".hashCode();
    cyK = "attrSyncVersion".hashCode();
    cyL = "incrementUpdateTime".hashCode();
    cxz = "bitFlag".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cyy == k) {
        this.field_brandList = paramCursor.getString(i);
      } else if (cyz == k) {
        this.field_brandListVersion = paramCursor.getString(i);
      } else if (cyA == k) {
        this.field_brandListContent = paramCursor.getString(i);
      } else if (cyB == k) {
        this.field_brandFlag = paramCursor.getInt(i);
      } else if (cyC == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (cyD == k) {
        this.field_brandInfo = paramCursor.getString(i);
      } else if (cyE == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (cyF == k) {
        this.field_hadAlert = paramCursor.getInt(i);
      } else if (cyG == k) {
        this.field_acceptType = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cyH == k) {
        this.field_enterpriseFather = paramCursor.getString(i);
      } else if (cyI == k) {
        this.field_kfWorkerId = paramCursor.getString(i);
      } else if (cyJ == k) {
        this.field_specialType = paramCursor.getInt(i);
      } else if (cyK == k) {
        this.field_attrSyncVersion = paramCursor.getString(i);
      } else if (cyL == k) {
        this.field_incrementUpdateTime = paramCursor.getLong(i);
      } else if (cxz == k) {
        this.field_bitFlag = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.field_brandList == null) {
      this.field_brandList = "";
    }
    if (this.cyk) {
      localContentValues.put("brandList", this.field_brandList);
    }
    if (this.cyl) {
      localContentValues.put("brandListVersion", this.field_brandListVersion);
    }
    if (this.cym) {
      localContentValues.put("brandListContent", this.field_brandListContent);
    }
    if (this.cyn) {
      localContentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
    }
    if (this.cyo) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.cyp) {
      localContentValues.put("brandInfo", this.field_brandInfo);
    }
    if (this.cyq) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cyr) {
      localContentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
    }
    if (this.cys) {
      localContentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cyt) {
      localContentValues.put("enterpriseFather", this.field_enterpriseFather);
    }
    if (this.cyu) {
      localContentValues.put("kfWorkerId", this.field_kfWorkerId);
    }
    if (this.cyv) {
      localContentValues.put("specialType", Integer.valueOf(this.field_specialType));
    }
    if (this.cyw) {
      localContentValues.put("attrSyncVersion", this.field_attrSyncVersion);
    }
    if (this.cyx) {
      localContentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
    }
    if (this.cxn) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ae
 * JD-Core Version:    0.7.0.1
 */