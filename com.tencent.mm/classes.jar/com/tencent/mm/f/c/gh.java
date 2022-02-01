package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gh
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("shakeitem1");
  public static final Column hHc;
  public static final Column hHd;
  public static final Column hHe;
  public static final Column hHf;
  private static final int hIE;
  private static final int hIF;
  private static final int hIG;
  private static final int hIH;
  public static final Column hWW;
  private static final int hXC;
  public static final Column hnN;
  private static final int hov;
  private static final int hwF;
  public static final Column hwK;
  public static final Column hwx;
  private static final int hxm = "lvbuffer".hashCode();
  public static final Column ivS;
  public static final Column ivT;
  public static final Column ivU;
  public static final Column ivV;
  public static final Column ivW;
  public static final Column ivX;
  public static final Column ivY;
  public static final Column ivZ;
  public static final Column iwa;
  public static final Column iwb;
  private static final int iwm;
  private static final int iwn;
  private static final int iwo;
  private static final int iwp;
  private static final int iwq;
  private static final int iwr;
  private static final int iws;
  private static final int iwt = "regionCode".hashCode();
  private static final int iwu = "snsFlag".hashCode();
  private static final int iwv = "sns_bgurl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
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
  private boolean hHQ = true;
  private boolean hHR = true;
  private boolean hHS = true;
  private boolean hHT = true;
  private boolean hXm = true;
  private boolean hoe = true;
  private boolean hwB = true;
  private boolean hwY = true;
  private boolean iwc = true;
  private boolean iwd = true;
  private boolean iwe = true;
  private boolean iwf = true;
  private boolean iwg = true;
  private boolean iwh = true;
  private boolean iwi = true;
  private boolean iwj = true;
  private boolean iwk = true;
  private boolean iwl = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "shakeitem1", "");
    ivS = new Column("shakeitemid", "int", "shakeitem1", "");
    C_USERNAME = new Column("username", "string", "shakeitem1", "");
    hwx = new Column("nickname", "string", "shakeitem1", "");
    ivT = new Column("province", "string", "shakeitem1", "");
    ivU = new Column("city", "string", "shakeitem1", "");
    hnN = new Column("signature", "string", "shakeitem1", "");
    ivV = new Column("distance", "string", "shakeitem1", "");
    hWW = new Column("sex", "int", "shakeitem1", "");
    ivW = new Column("imgstatus", "int", "shakeitem1", "");
    ivX = new Column("hashdimg", "int", "shakeitem1", "");
    ivY = new Column("insertbatch", "int", "shakeitem1", "");
    hHc = new Column("reserved1", "int", "shakeitem1", "");
    hHd = new Column("reserved2", "int", "shakeitem1", "");
    hHe = new Column("reserved3", "string", "shakeitem1", "");
    hHf = new Column("reserved4", "string", "shakeitem1", "");
    C_TYPE = new Column("type", "int", "shakeitem1", "");
    hwK = new Column("lvbuffer", "byte[]", "shakeitem1", "");
    ivZ = new Column("regioncode", "string", "shakeitem1", "");
    iwa = new Column("snsflag", "int", "shakeitem1", "");
    iwb = new Column("sns_bgurl", "string", "shakeitem1", "");
    iwm = "shakeItemID".hashCode();
    username_HASHCODE = "username".hashCode();
    hwF = "nickname".hashCode();
    iwn = "province".hashCode();
    iwo = "city".hashCode();
    hov = "signature".hashCode();
    iwp = "distance".hashCode();
    hXC = "sex".hashCode();
    iwq = "imgstatus".hashCode();
    iwr = "hasHDImg".hashCode();
    iws = "insertBatch".hashCode();
    hIE = "reserved1".hashCode();
    hIF = "reserved2".hashCode();
    hIG = "reserved3".hashCode();
    hIH = "reserved4".hashCode();
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
      if (iwm != k) {
        break label65;
      }
      this.field_shakeItemID = paramCursor.getInt(i);
      this.iwc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (iwn == k) {
        this.field_province = paramCursor.getString(i);
      } else if (iwo == k) {
        this.field_city = paramCursor.getString(i);
      } else if (hov == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (iwp == k) {
        this.field_distance = paramCursor.getString(i);
      } else if (hXC == k) {
        this.field_sex = paramCursor.getInt(i);
      } else if (iwq == k) {
        this.field_imgstatus = paramCursor.getInt(i);
      } else if (iwr == k) {
        this.field_hasHDImg = paramCursor.getInt(i);
      } else if (iws == k) {
        this.field_insertBatch = paramCursor.getInt(i);
      } else if (hIE == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (hIF == k) {
        this.field_reserved2 = paramCursor.getInt(i);
      } else if (hIG == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (hIH == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hxm == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (iwt == k) {
        this.field_regionCode = paramCursor.getString(i);
      } else if (iwu == k) {
        this.field_snsFlag = paramCursor.getInt(i);
      } else if (iwv == k) {
        this.field_sns_bgurl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iwc) {
      localContentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.iwd) {
      localContentValues.put("province", this.field_province);
    }
    if (this.iwe) {
      localContentValues.put("city", this.field_city);
    }
    if (this.hoe) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.iwf) {
      localContentValues.put("distance", this.field_distance);
    }
    if (this.hXm) {
      localContentValues.put("sex", Integer.valueOf(this.field_sex));
    }
    if (this.iwg) {
      localContentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
    }
    if (this.iwh) {
      localContentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
    }
    if (this.iwi) {
      localContentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
    }
    if (this.hHQ) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.hHR) {
      localContentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
    }
    if (this.hHS) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.hHT) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hwY) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.iwj) {
      localContentValues.put("regionCode", this.field_regionCode);
    }
    if (this.iwk) {
      localContentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
    }
    if (this.iwl) {
      localContentValues.put("sns_bgurl", this.field_sns_bgurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "shakeitem1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.gh
 * JD-Core Version:    0.7.0.1
 */