package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGR;
  private static final int eGY;
  private static final int eMR = "lvbuffer".hashCode();
  private static final int eMy;
  private static final int eUG;
  private static final int eUH;
  private static final int eUI;
  private static final int eUJ;
  private static final int fem;
  private static final int ftA;
  private static final int ftB = "regionCode".hashCode();
  private static final int ftC = "snsFlag".hashCode();
  private static final int ftD = "sns_bgurl".hashCode();
  private static final int ftu = "shakeItemID".hashCode();
  private static final int ftv;
  private static final int ftw;
  private static final int ftx;
  private static final int fty;
  private static final int ftz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eGA = true;
  private boolean eGV = true;
  private boolean eMD = true;
  private boolean eMu = true;
  private boolean eTU = true;
  private boolean eTV = true;
  private boolean eTW = true;
  private boolean eTX = true;
  private boolean fei = true;
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
  private boolean ftk = true;
  private boolean ftl = true;
  private boolean ftm = true;
  private boolean ftn = true;
  private boolean fto = true;
  private boolean ftp = true;
  private boolean ftq = true;
  private boolean ftr = true;
  private boolean fts = true;
  private boolean ftt = true;
  
  static
  {
    eGY = "username".hashCode();
    eMy = "nickname".hashCode();
    ftv = "province".hashCode();
    ftw = "city".hashCode();
    eGR = "signature".hashCode();
    ftx = "distance".hashCode();
    fem = "sex".hashCode();
    fty = "imgstatus".hashCode();
    ftz = "hasHDImg".hashCode();
    ftA = "insertBatch".hashCode();
    eUG = "reserved1".hashCode();
    eUH = "reserved2".hashCode();
    eUI = "reserved3".hashCode();
    eUJ = "reserved4".hashCode();
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
      if (ftu != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.ftk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (ftv == k) {
        this.field_province = paramCursor.getString(i);
      } else if (ftw == k) {
        this.field_city = paramCursor.getString(i);
      } else if (eGR == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (ftx == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (fem == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (fty == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (ftz == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (ftA == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (eUG == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eUH == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (eUI == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eUJ == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eMR == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (ftB == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (ftC == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (ftD == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ftk) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ftl) {
      localContentValues.put("province", this.field_province);
    }
    if (this.ftm) {
      localContentValues.put("city", this.field_city);
    }
    if (this.eGA) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.ftn) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.fei) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.fto) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.ftp) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.ftq) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.eTU) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eTV) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.eTW) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.eTX) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eMD) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.ftr) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.fts) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.ftt) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fr
 * JD-Core Version:    0.7.0.1
 */