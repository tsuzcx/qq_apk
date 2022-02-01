package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hm
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int eEU;
  private static final int eFi;
  private static final int eFo = "usernameHash".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eKB;
  private static final int eKP;
  private static final int eLE = "reserved".hashCode();
  private static final int fBX;
  private static final int fBY;
  private static final int fBZ;
  private static final int fCa;
  private static final int fCb;
  private static final int fCc;
  private static final int fCd;
  private static final int fCe;
  private static final int fCf;
  private static final int fCg;
  private static final int fCh = "syncTimeSecond".hashCode();
  private static final int fCi = "syncVersion".hashCode();
  private static final int fCj = "bizMenu".hashCode();
  private static final int fiQ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eER = true;
  private boolean eFl = true;
  private boolean eFm = true;
  private boolean eKL = true;
  private boolean eKn = true;
  private boolean eLw = true;
  private boolean fBK = true;
  private boolean fBL = true;
  private boolean fBM = true;
  private boolean fBN = true;
  private boolean fBO = true;
  private boolean fBP = true;
  private boolean fBQ = true;
  private boolean fBR = true;
  private boolean fBS = true;
  private boolean fBT = true;
  private boolean fBU = true;
  private boolean fBV = true;
  private boolean fBW = true;
  private boolean fiL = true;
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
  
  static
  {
    eEU = "appId".hashCode();
    eKP = "nickname".hashCode();
    fBX = "shortNickname".hashCode();
    eKB = "brandIconURL".hashCode();
    fBY = "roundedSquareIconURL".hashCode();
    fBZ = "bigHeadURL".hashCode();
    fCa = "smallHeadURL".hashCode();
    eFi = "signature".hashCode();
    fCb = "appOpt".hashCode();
    fCc = "registerSource".hashCode();
    fCd = "appInfo".hashCode();
    fiQ = "versionInfo".hashCode();
    fCe = "passThroughInfo".hashCode();
    fCf = "bindWxaInfo".hashCode();
    fCg = "dynamicInfo".hashCode();
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
      if (eFo != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.eFl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fBX == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (eKB == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (fBY == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (fBZ == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (fCa == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (eFi == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fCb == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (fCc == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (fCd == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (fiQ == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (fCe == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (fCf == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (fCg == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (eLE == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (fCh == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (fCi == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (fCj == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFl) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fBK) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.eKn) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.fBL) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.fBM) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.fBN) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.eER) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fBO) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.fBP) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.fBQ) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.fiL) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.fBR) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.fBS) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.fBT) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.eLw) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.fBU) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.fBV) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.fBW) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hm
 * JD-Core Version:    0.7.0.1
 */