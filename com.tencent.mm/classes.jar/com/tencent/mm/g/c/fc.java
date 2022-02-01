package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVR = "shakeItemID".hashCode();
  private static final int eVS;
  private static final int eVT;
  private static final int eVU;
  private static final int eVV;
  private static final int eVW;
  private static final int eVX;
  private static final int eVY;
  private static final int eVZ = "regionCode".hashCode();
  private static final int eWa = "snsFlag".hashCode();
  private static final int eWb = "sns_bgurl".hashCode();
  private static final int elX;
  private static final int eme = "username".hashCode();
  private static final int erC = "nickname".hashCode();
  private static final int erV;
  private static final int ezd;
  private static final int eze;
  private static final int ezf;
  private static final int ezg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eVG = true;
  private boolean eVH = true;
  private boolean eVI = true;
  private boolean eVJ = true;
  private boolean eVK = true;
  private boolean eVL = true;
  private boolean eVM = true;
  private boolean eVN = true;
  private boolean eVO = true;
  private boolean eVP = true;
  private boolean eVQ = true;
  private boolean elG = true;
  private boolean emb = true;
  private boolean erH = true;
  private boolean ery = true;
  private boolean eyr = true;
  private boolean eys = true;
  private boolean eyt = true;
  private boolean eyu = true;
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
  
  static
  {
    eVS = "province".hashCode();
    eVT = "city".hashCode();
    elX = "signature".hashCode();
    eVU = "distance".hashCode();
    eVV = "sex".hashCode();
    eVW = "imgstatus".hashCode();
    eVX = "hasHDImg".hashCode();
    eVY = "insertBatch".hashCode();
    ezd = "reserved1".hashCode();
    eze = "reserved2".hashCode();
    ezf = "reserved3".hashCode();
    ezg = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
    erV = "lvbuffer".hashCode();
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
      if (eVR != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.eVG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eVS == k) {
        this.field_province = paramCursor.getString(i);
      } else if (eVT == k) {
        this.field_city = paramCursor.getString(i);
      } else if (elX == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eVU == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (eVV == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (eVW == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (eVX == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (eVY == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (ezd == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eze == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (ezf == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (ezg == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (erV == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (eVZ == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (eWa == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (eWb == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVG) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eVH) {
      localContentValues.put("province", this.field_province);
    }
    if (this.eVI) {
      localContentValues.put("city", this.field_city);
    }
    if (this.elG) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eVJ) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.eVK) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.eVL) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.eVM) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.eVN) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.eyr) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eys) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.eyt) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.eyu) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.erH) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.eVO) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.eVP) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.eVQ) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fc
 * JD-Core Version:    0.7.0.1
 */