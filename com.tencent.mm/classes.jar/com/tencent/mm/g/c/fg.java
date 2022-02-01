package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBA;
  private static final int eBx;
  private static final int eBy;
  private static final int eBz;
  private static final int eZf = "shakeItemID".hashCode();
  private static final int eZg;
  private static final int eZh;
  private static final int eZi;
  private static final int eZj;
  private static final int eZk;
  private static final int eZl;
  private static final int eZm;
  private static final int eZn = "regionCode".hashCode();
  private static final int eZo = "snsFlag".hashCode();
  private static final int eZp = "sns_bgurl".hashCode();
  private static final int eoc;
  private static final int eok = "username".hashCode();
  private static final int etG = "nickname".hashCode();
  private static final int etZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eAL = true;
  private boolean eAM = true;
  private boolean eAN = true;
  private boolean eAO = true;
  private boolean eYU = true;
  private boolean eYV = true;
  private boolean eYW = true;
  private boolean eYX = true;
  private boolean eYY = true;
  private boolean eYZ = true;
  private boolean eZa = true;
  private boolean eZb = true;
  private boolean eZc = true;
  private boolean eZd = true;
  private boolean eZe = true;
  private boolean enL = true;
  private boolean eoh = true;
  private boolean etC = true;
  private boolean etL = true;
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
    eZg = "province".hashCode();
    eZh = "city".hashCode();
    eoc = "signature".hashCode();
    eZi = "distance".hashCode();
    eZj = "sex".hashCode();
    eZk = "imgstatus".hashCode();
    eZl = "hasHDImg".hashCode();
    eZm = "insertBatch".hashCode();
    eBx = "reserved1".hashCode();
    eBy = "reserved2".hashCode();
    eBz = "reserved3".hashCode();
    eBA = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
    etZ = "lvbuffer".hashCode();
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
      if (eZf != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.eYU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eZg == k) {
        this.field_province = paramCursor.getString(i);
      } else if (eZh == k) {
        this.field_city = paramCursor.getString(i);
      } else if (eoc == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (eZi == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (eZj == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (eZk == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (eZl == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (eZm == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (eBx == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eBy == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (eBz == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eBA == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (etZ == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (eZn == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (eZo == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (eZp == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eYU) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eYV) {
      localContentValues.put("province", this.field_province);
    }
    if (this.eYW) {
      localContentValues.put("city", this.field_city);
    }
    if (this.enL) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.eYX) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.eYY) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.eYZ) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.eZa) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.eZb) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.eAL) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eAM) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.eAN) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.eAO) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.etL) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.eZc) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.eZd) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.eZe) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fg
 * JD-Core Version:    0.7.0.1
 */