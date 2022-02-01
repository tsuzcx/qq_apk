package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int eQt;
  private static final int eRW = "reserved".hashCode();
  private static final int enO;
  private static final int eoc;
  private static final int eoj = "usernameHash".hashCode();
  private static final int eok = "username".hashCode();
  private static final int etG;
  private static final int ets;
  private static final int fjQ;
  private static final int fjR;
  private static final int fjS;
  private static final int fjT;
  private static final int fjU;
  private static final int fjV;
  private static final int fjW;
  private static final int fjX;
  private static final int fjY;
  private static final int fjZ;
  private static final int fka = "syncTimeSecond".hashCode();
  private static final int fkb = "syncVersion".hashCode();
  private static final int fkc = "bizMenu".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQo = true;
  private boolean eRQ = true;
  private boolean enL = true;
  private boolean enx = true;
  private boolean eog = true;
  private boolean eoh = true;
  private boolean etC = true;
  private boolean ete = true;
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
  private boolean fjD = true;
  private boolean fjE = true;
  private boolean fjF = true;
  private boolean fjG = true;
  private boolean fjH = true;
  private boolean fjI = true;
  private boolean fjJ = true;
  private boolean fjK = true;
  private boolean fjL = true;
  private boolean fjM = true;
  private boolean fjN = true;
  private boolean fjO = true;
  private boolean fjP = true;
  
  static
  {
    enO = "appId".hashCode();
    etG = "nickname".hashCode();
    fjQ = "shortNickname".hashCode();
    ets = "brandIconURL".hashCode();
    fjR = "roundedSquareIconURL".hashCode();
    fjS = "bigHeadURL".hashCode();
    fjT = "smallHeadURL".hashCode();
    eoc = "signature".hashCode();
    fjU = "appOpt".hashCode();
    fjV = "registerSource".hashCode();
    fjW = "appInfo".hashCode();
    eQt = "versionInfo".hashCode();
    fjX = "passThroughInfo".hashCode();
    fjY = "bindWxaInfo".hashCode();
    fjZ = "dynamicInfo".hashCode();
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
      if (eoj != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.eog = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fjQ == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (ets == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (fjR == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (fjS == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (fjT == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (eoc == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fjU == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (fjV == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (fjW == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (eQt == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (fjX == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (fjY == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (fjZ == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (eRW == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (fka == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (fkb == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (fkc == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eog) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fjD) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.ete) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.fjE) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.fjF) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.fjG) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.enL) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fjH) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.fjI) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.fjJ) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.eQo) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.fjK) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.fjL) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.fjM) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.eRQ) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.fjN) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.fjO) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.fjP) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hc
 * JD-Core Version:    0.7.0.1
 */