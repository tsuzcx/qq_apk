package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFi;
  private static final int eFp;
  private static final int eKP;
  private static final int eLh = "lvbuffer".hashCode();
  private static final int eSV;
  private static final int eSW;
  private static final int eSX;
  private static final int eSY;
  private static final int fcx;
  private static final int frA;
  private static final int frB = "regionCode".hashCode();
  private static final int frC = "snsFlag".hashCode();
  private static final int frD = "sns_bgurl".hashCode();
  private static final int fru = "shakeItemID".hashCode();
  private static final int frv;
  private static final int frw;
  private static final int frx;
  private static final int fry;
  private static final int frz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eER = true;
  private boolean eFm = true;
  private boolean eKL = true;
  private boolean eKU = true;
  private boolean eSj = true;
  private boolean eSk = true;
  private boolean eSl = true;
  private boolean eSm = true;
  private boolean fct = true;
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
  private boolean frk = true;
  private boolean frl = true;
  private boolean frm = true;
  private boolean frn = true;
  private boolean fro = true;
  private boolean frp = true;
  private boolean frq = true;
  private boolean frr = true;
  private boolean frs = true;
  private boolean frt = true;
  
  static
  {
    eFp = "username".hashCode();
    eKP = "nickname".hashCode();
    frv = "province".hashCode();
    frw = "city".hashCode();
    eFi = "signature".hashCode();
    frx = "distance".hashCode();
    fcx = "sex".hashCode();
    fry = "imgstatus".hashCode();
    frz = "hasHDImg".hashCode();
    frA = "insertBatch".hashCode();
    eSV = "reserved1".hashCode();
    eSW = "reserved2".hashCode();
    eSX = "reserved3".hashCode();
    eSY = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (fru != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.frk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (frv == k) {
        this.field_province = paramCursor.getString(i);
      } else if (frw == k) {
        this.field_city = paramCursor.getString(i);
      } else if (eFi == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (frx == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (fcx == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (fry == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (frz == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (frA == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (eSV == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eSW == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (eSX == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eSY == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eLh == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (frB == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (frC == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (frD == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.frk) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.frl) {
      localContentValues.put("province", this.field_province);
    }
    if (this.frm) {
      localContentValues.put("city", this.field_city);
    }
    if (this.eER) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.frn) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.fct) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.fro) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.frp) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.frq) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.eSj) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eSk) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.eSl) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.eSm) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eKU) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.frr) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.frs) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.frt) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */