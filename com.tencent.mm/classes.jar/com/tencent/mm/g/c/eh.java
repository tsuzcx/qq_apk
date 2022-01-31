package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dNc = "shakeItemID".hashCode();
  private static final int dNd;
  private static final int dNe;
  private static final int dNf;
  private static final int dNg;
  private static final int dNh;
  private static final int dNi;
  private static final int dNj;
  private static final int dNk = "regionCode".hashCode();
  private static final int dNl = "snsFlag".hashCode();
  private static final int dNm = "sns_bgurl".hashCode();
  private static final int dhP;
  private static final int dhU = "username".hashCode();
  private static final int dmT = "nickname".hashCode();
  private static final int dnj;
  private static final int dud;
  private static final int due;
  private static final int duf;
  private static final int dug;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dMR = true;
  private boolean dMS = true;
  private boolean dMT = true;
  private boolean dMU = true;
  private boolean dMV = true;
  private boolean dMW = true;
  private boolean dMX = true;
  private boolean dMY = true;
  private boolean dMZ = true;
  private boolean dNa = true;
  private boolean dNb = true;
  private boolean dhS = true;
  private boolean dhy = true;
  private boolean dmP = true;
  private boolean dmY = true;
  private boolean dtq = true;
  private boolean dtr = true;
  private boolean dtt = true;
  private boolean dtu = true;
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
    dNd = "province".hashCode();
    dNe = "city".hashCode();
    dhP = "signature".hashCode();
    dNf = "distance".hashCode();
    dNg = "sex".hashCode();
    dNh = "imgstatus".hashCode();
    dNi = "hasHDImg".hashCode();
    dNj = "insertBatch".hashCode();
    dud = "reserved1".hashCode();
    due = "reserved2".hashCode();
    duf = "reserved3".hashCode();
    dug = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
    dnj = "lvbuffer".hashCode();
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
      if (dNc != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.dMR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dmT == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (dNd == k) {
        this.field_province = paramCursor.getString(i);
      } else if (dNe == k) {
        this.field_city = paramCursor.getString(i);
      } else if (dhP == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (dNf == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (dNg == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (dNh == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (dNi == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (dNj == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (dud == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (due == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (duf == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (dug == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dnj == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (dNk == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (dNl == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (dNm == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dMR) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dmP) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dMS) {
      localContentValues.put("province", this.field_province);
    }
    if (this.dMT) {
      localContentValues.put("city", this.field_city);
    }
    if (this.dhy) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.dMU) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.dMV) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.dMW) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.dMX) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.dMY) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.dtq) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.dtr) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.dtt) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.dtu) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dmY) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.dMZ) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.dNa) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.dNb) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.eh
 * JD-Core Version:    0.7.0.1
 */