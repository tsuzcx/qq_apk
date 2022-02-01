package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hn
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int eGD;
  private static final int eGR;
  private static final int eGX = "usernameHash".hashCode();
  private static final int eGY = "username".hashCode();
  private static final int eMk;
  private static final int eMy;
  private static final int eNp = "reserved".hashCode();
  private static final int fDX;
  private static final int fDY;
  private static final int fDZ;
  private static final int fEa;
  private static final int fEb;
  private static final int fEc;
  private static final int fEd;
  private static final int fEe;
  private static final int fEf;
  private static final int fEg;
  private static final int fEh = "syncTimeSecond".hashCode();
  private static final int fEi = "syncVersion".hashCode();
  private static final int fEj = "bizMenu".hashCode();
  private static final int fkN;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGA = true;
  private boolean eGU = true;
  private boolean eGV = true;
  private boolean eGm = true;
  private boolean eLW = true;
  private boolean eMu = true;
  private boolean eNh = true;
  private boolean fDK = true;
  private boolean fDL = true;
  private boolean fDM = true;
  private boolean fDN = true;
  private boolean fDO = true;
  private boolean fDP = true;
  private boolean fDQ = true;
  private boolean fDR = true;
  private boolean fDS = true;
  private boolean fDT = true;
  private boolean fDU = true;
  private boolean fDV = true;
  private boolean fDW = true;
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
  private boolean fkI = true;
  
  static
  {
    eGD = "appId".hashCode();
    eMy = "nickname".hashCode();
    fDX = "shortNickname".hashCode();
    eMk = "brandIconURL".hashCode();
    fDY = "roundedSquareIconURL".hashCode();
    fDZ = "bigHeadURL".hashCode();
    fEa = "smallHeadURL".hashCode();
    eGR = "signature".hashCode();
    fEb = "appOpt".hashCode();
    fEc = "registerSource".hashCode();
    fEd = "appInfo".hashCode();
    fkN = "versionInfo".hashCode();
    fEe = "passThroughInfo".hashCode();
    fEf = "bindWxaInfo".hashCode();
    fEg = "dynamicInfo".hashCode();
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
      if (eGX != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.eGU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fDX == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (eMk == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (fDY == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (fDZ == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (fEa == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (eGR == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fEb == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (fEc == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (fEd == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (fkN == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (fEe == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (fEf == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (fEg == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (eNp == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (fEh == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (fEi == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (fEj == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGU) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fDK) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.eLW) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.fDL) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.fDM) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.fDN) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.eGA) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fDO) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.fDP) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.fDQ) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.fkI) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.fDR) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.fDS) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.fDT) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.eNh) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.fDU) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.fDV) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.fDW) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hn
 * JD-Core Version:    0.7.0.1
 */