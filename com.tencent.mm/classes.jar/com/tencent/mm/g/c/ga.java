package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ga
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fIF;
  private static final int fYd = "shakeItemID".hashCode();
  private static final int fYe;
  private static final int fYf;
  private static final int fYg;
  private static final int fYh;
  private static final int fYi;
  private static final int fYj;
  private static final int fYk = "regionCode".hashCode();
  private static final int fYl = "snsFlag".hashCode();
  private static final int fYm = "sns_bgurl".hashCode();
  private static final int fkx;
  private static final int fqf;
  private static final int fqy;
  private static final int fyl;
  private static final int fym;
  private static final int fyn;
  private static final int fyo;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
  private boolean fIB = true;
  private boolean fXT = true;
  private boolean fXU = true;
  private boolean fXV = true;
  private boolean fXW = true;
  private boolean fXX = true;
  private boolean fXY = true;
  private boolean fXZ = true;
  private boolean fYa = true;
  private boolean fYb = true;
  private boolean fYc = true;
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
  private boolean fkg = true;
  private boolean fqb = true;
  private boolean fqk = true;
  private boolean fxA = true;
  private boolean fxB = true;
  private boolean fxC = true;
  private boolean fxz = true;
  
  static
  {
    fqf = "nickname".hashCode();
    fYe = "province".hashCode();
    fYf = "city".hashCode();
    fkx = "signature".hashCode();
    fYg = "distance".hashCode();
    fIF = "sex".hashCode();
    fYh = "imgstatus".hashCode();
    fYi = "hasHDImg".hashCode();
    fYj = "insertBatch".hashCode();
    fyl = "reserved1".hashCode();
    fym = "reserved2".hashCode();
    fyn = "reserved3".hashCode();
    fyo = "reserved4".hashCode();
    type_HASHCODE = "type".hashCode();
    fqy = "lvbuffer".hashCode();
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
      if (fYd != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.fXT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fYe == k) {
        this.field_province = paramCursor.getString(i);
      } else if (fYf == k) {
        this.field_city = paramCursor.getString(i);
      } else if (fkx == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fYg == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (fIF == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (fYh == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (fYi == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (fYj == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (fyl == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (fym == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (fyn == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (fyo == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fqy == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (fYk == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (fYl == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (fYm == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fXT) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fXU) {
      localContentValues.put("province", this.field_province);
    }
    if (this.fXV) {
      localContentValues.put("city", this.field_city);
    }
    if (this.fkg) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fXW) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.fIB) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.fXX) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.fXY) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.fXZ) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.fxz) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.fxA) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.fxB) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.fxC) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fqk) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.fYa) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.fYb) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.fYc) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ga
 * JD-Core Version:    0.7.0.1
 */