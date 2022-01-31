package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv
  extends c
{
  private static final int cFI;
  private static final int cFJ;
  private static final int cFK;
  private static final int cFL;
  private static final int cWI;
  private static final int cWJ;
  private static final int cWK;
  private static final int cWL;
  private static final int cWM;
  private static final int cWN;
  private static final int cWO;
  private static final int cWP;
  private static final int cWQ = "regionCode".hashCode();
  private static final int cWR = "snsFlag".hashCode();
  private static final int cWS = "sns_bgurl".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctA;
  private static final int ctF;
  private static final int cyS;
  private static final int czi;
  private boolean cFf = true;
  private boolean cFg = true;
  private boolean cFh = true;
  private boolean cFi = true;
  private boolean cWA = true;
  private boolean cWB = true;
  private boolean cWC = true;
  private boolean cWD = true;
  private boolean cWE = true;
  private boolean cWF = true;
  private boolean cWG = true;
  private boolean cWH = true;
  private boolean cWx = true;
  private boolean cWy = true;
  private boolean cWz = true;
  private boolean csa = true;
  private boolean ctD = true;
  private boolean cti = true;
  private boolean cyO = true;
  private boolean cyX = true;
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
    cWI = "shakeItemID".hashCode();
    ctF = "username".hashCode();
    cyS = "nickname".hashCode();
    cWJ = "province".hashCode();
    cWK = "city".hashCode();
    ctA = "signature".hashCode();
    cWL = "distance".hashCode();
    cWM = "sex".hashCode();
    cWN = "imgstatus".hashCode();
    cWO = "hasHDImg".hashCode();
    cWP = "insertBatch".hashCode();
    cFI = "reserved1".hashCode();
    cFJ = "reserved2".hashCode();
    cFK = "reserved3".hashCode();
    cFL = "reserved4".hashCode();
    csy = "type".hashCode();
    czi = "lvbuffer".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cWI != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.cWx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (cyS == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (cWJ == k) {
        this.field_province = paramCursor.getString(i);
      } else if (cWK == k) {
        this.field_city = paramCursor.getString(i);
      } else if (ctA == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (cWL == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (cWM == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (cWN == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (cWO == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (cWP == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (cFI == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (cFJ == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (cFK == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (cFL == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (czi == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (cWQ == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (cWR == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (cWS == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cWx) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cyO) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.cWy) {
      localContentValues.put("province", this.field_province);
    }
    if (this.cWz) {
      localContentValues.put("city", this.field_city);
    }
    if (this.cti) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.cWA) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.cWB) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.cWC) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.cWD) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.cWE) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.cFf) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.cFg) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.cFh) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.cFi) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cyX) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.cWF) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.cWG) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.cWH) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.dv
 * JD-Core Version:    0.7.0.1
 */