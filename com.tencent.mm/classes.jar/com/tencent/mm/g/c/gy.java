package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gy
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int eNB;
  private static final int eOO = "reserved".hashCode();
  private static final int elJ;
  private static final int elX;
  private static final int emd = "usernameHash".hashCode();
  private static final int eme = "username".hashCode();
  private static final int erC;
  private static final int ero;
  private static final int fgA;
  private static final int fgB;
  private static final int fgC;
  private static final int fgD;
  private static final int fgE;
  private static final int fgF = "syncTimeSecond".hashCode();
  private static final int fgG = "syncVersion".hashCode();
  private static final int fgH = "bizMenu".hashCode();
  private static final int fgw;
  private static final int fgx;
  private static final int fgy;
  private static final int fgz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNw = true;
  private boolean eOI = true;
  private boolean elG = true;
  private boolean els = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean era = true;
  private boolean ery = true;
  private boolean fgk = true;
  private boolean fgl = true;
  private boolean fgm = true;
  private boolean fgn = true;
  private boolean fgo = true;
  private boolean fgp = true;
  private boolean fgq = true;
  private boolean fgr = true;
  private boolean fgs = true;
  private boolean fgt = true;
  private boolean fgu = true;
  private boolean fgv = true;
  public String field_appId;
  public String field_appInfo;
  public int field_appOpt;
  public String field_bigHeadURL;
  public String field_bindWxaInfo;
  public String field_bizMenu;
  public String field_brandIconURL;
  public String field_dynamicInfo;
  public String field_nickname;
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
    elJ = "appId".hashCode();
    erC = "nickname".hashCode();
    fgw = "shortNickname".hashCode();
    ero = "brandIconURL".hashCode();
    fgx = "roundedSquareIconURL".hashCode();
    fgy = "bigHeadURL".hashCode();
    fgz = "smallHeadURL".hashCode();
    elX = "signature".hashCode();
    fgA = "appOpt".hashCode();
    fgB = "registerSource".hashCode();
    fgC = "appInfo".hashCode();
    eNB = "versionInfo".hashCode();
    fgD = "bindWxaInfo".hashCode();
    fgE = "dynamicInfo".hashCode();
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
      if (emd != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.ema = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (elJ == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fgw == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (ero == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (fgx == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (fgy == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (fgz == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (elX == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (fgA == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (fgB == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (fgC == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (eNB == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (fgD == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (fgE == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (eOO == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (fgF == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (fgG == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (fgH == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ema) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fgk) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.era) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.fgl) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.fgm) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.fgn) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.elG) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.fgo) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.fgp) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.fgq) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.eNw) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.fgr) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.fgs) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.eOI) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.fgt) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.fgu) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.fgv) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gy
 * JD-Core Version:    0.7.0.1
 */