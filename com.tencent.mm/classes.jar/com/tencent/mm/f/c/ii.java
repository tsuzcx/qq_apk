package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ii
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  public static final SingleTable TABLE = new SingleTable("WxaAttributesTable");
  public static final Column hnN;
  public static final Column hnz;
  private static final int hoA;
  private static final int hoh;
  private static final int hov;
  public static final Column hoy;
  public static final Column hvM;
  private static final int hwF;
  private static final int hwo;
  public static final Column hwx;
  public static final Column hxC;
  private static final int hxK = "reserved".hashCode();
  public static final Column iMD;
  public static final Column iME;
  public static final Column iMF;
  public static final Column iMG;
  public static final Column iMH;
  public static final Column iMI;
  public static final Column iMJ;
  public static final Column iMK;
  public static final Column iML;
  public static final Column iMM;
  public static final Column iMN;
  public static final Column iMO;
  public static final Column iMP;
  private static final int iNd;
  private static final int iNe;
  private static final int iNf;
  private static final int iNg;
  private static final int iNh;
  private static final int iNi;
  private static final int iNj;
  private static final int iNk;
  private static final int iNl;
  private static final int iNm;
  private static final int iNn = "syncTimeSecond".hashCode();
  private static final int iNo = "syncVersion".hashCode();
  private static final int iNp = "bizMenu".hashCode();
  private static final int iiJ;
  public static final Column iiz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_appInfo;
  public int field_appOpt;
  public String field_bigHeadURL;
  public String field_bindWxaInfo;
  public String field_bizMenu;
  public String field_brandIconURL;
  public String field_dynamicInfo;
  public String field_nickname;
  public String field_passThroughInfo;
  public String field_registerSource;
  public String field_reserved;
  public String field_roundedSquareIconURL;
  public String field_shortNickname;
  public String field_signature;
  public String field_smallHeadURL;
  public long field_syncTimeSecond;
  public String field_syncVersion;
  public String field_username;
  public int field_usernameHash;
  public String field_versionInfo;
  private boolean hnQ = true;
  private boolean hoe = true;
  private boolean hoz = true;
  private boolean hwB = true;
  private boolean hwa = true;
  private boolean iMQ = true;
  private boolean iMR = true;
  private boolean iMS = true;
  private boolean iMT = true;
  private boolean iMU = true;
  private boolean iMV = true;
  private boolean iMW = true;
  private boolean iMX = true;
  private boolean iMY = true;
  private boolean iMZ = true;
  private boolean iNa = true;
  private boolean iNb = true;
  private boolean iNc = true;
  private boolean iiE = true;
  private boolean ikX = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaAttributesTable", "");
    hoy = new Column("usernamehash", "int", "WxaAttributesTable", "");
    C_USERNAME = new Column("username", "string", "WxaAttributesTable", "");
    hnz = new Column("appid", "string", "WxaAttributesTable", "");
    hwx = new Column("nickname", "string", "WxaAttributesTable", "");
    iMD = new Column("shortnickname", "string", "WxaAttributesTable", "");
    hvM = new Column("brandiconurl", "string", "WxaAttributesTable", "");
    iME = new Column("roundedsquareiconurl", "string", "WxaAttributesTable", "");
    iMF = new Column("bigheadurl", "string", "WxaAttributesTable", "");
    iMG = new Column("smallheadurl", "string", "WxaAttributesTable", "");
    hnN = new Column("signature", "string", "WxaAttributesTable", "");
    iMH = new Column("appopt", "int", "WxaAttributesTable", "");
    iMI = new Column("registersource", "string", "WxaAttributesTable", "");
    iMJ = new Column("appinfo", "string", "WxaAttributesTable", "");
    iiz = new Column("versioninfo", "string", "WxaAttributesTable", "");
    iMK = new Column("passthroughinfo", "string", "WxaAttributesTable", "");
    iML = new Column("bindwxainfo", "string", "WxaAttributesTable", "");
    iMM = new Column("dynamicinfo", "string", "WxaAttributesTable", "");
    hxC = new Column("reserved", "string", "WxaAttributesTable", "");
    iMN = new Column("synctimesecond", "long", "WxaAttributesTable", "");
    iMO = new Column("syncversion", "string", "WxaAttributesTable", "");
    iMP = new Column("bizmenu", "string", "WxaAttributesTable", "");
    hoA = "usernameHash".hashCode();
    username_HASHCODE = "username".hashCode();
    hoh = "appId".hashCode();
    hwF = "nickname".hashCode();
    iNd = "shortNickname".hashCode();
    hwo = "brandIconURL".hashCode();
    iNe = "roundedSquareIconURL".hashCode();
    iNf = "bigHeadURL".hashCode();
    iNg = "smallHeadURL".hashCode();
    hov = "signature".hashCode();
    iNh = "appOpt".hashCode();
    iNi = "registerSource".hashCode();
    iNj = "appInfo".hashCode();
    iiJ = "versionInfo".hashCode();
    iNk = "passThroughInfo".hashCode();
    iNl = "bindWxaInfo".hashCode();
    iNm = "dynamicInfo".hashCode();
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
      if (hoA != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.hoz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (iNd == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (hwo == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (iNe == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (iNf == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (iNg == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (hov == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (iNh == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (iNi == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (iNj == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (iiJ == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (iNk == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (iNl == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (iNm == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (hxK == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (iNn == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (iNo == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (iNp == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hoz) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.iMQ) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.hwa) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.iMR) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.iMS) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.iMT) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.hoe) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.iMU) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.iMV) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.iMW) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.iiE) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.iMX) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.iMY) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.iMZ) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.ikX) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.iNa) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.iNb) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.iNc) {
      localContentValues.put("bizMenu", this.field_bizMenu);
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
    return "WxaAttributesTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.ii
 * JD-Core Version:    0.7.0.1
 */