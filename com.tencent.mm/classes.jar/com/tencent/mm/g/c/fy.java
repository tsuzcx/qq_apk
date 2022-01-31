package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fy
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int dFZ;
  private static final int dGM = "reserved".hashCode();
  private static final int dWS = "usernameHash".hashCode();
  private static final int dWT;
  private static final int dWU;
  private static final int dWV;
  private static final int dWW;
  private static final int dWX;
  private static final int dWY;
  private static final int dWZ;
  private static final int dXa;
  private static final int dXb;
  private static final int dXc = "syncTimeSecond".hashCode();
  private static final int dXd = "syncVersion".hashCode();
  private static final int dXe = "bizMenu".hashCode();
  private static final int dhB;
  private static final int dhP;
  private static final int dhU = "username".hashCode();
  private static final int dmF;
  private static final int dmT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dFU = true;
  private boolean dGG = true;
  private boolean dWF = true;
  private boolean dWG = true;
  private boolean dWH = true;
  private boolean dWI = true;
  private boolean dWJ = true;
  private boolean dWK = true;
  private boolean dWL = true;
  private boolean dWM = true;
  private boolean dWN = true;
  private boolean dWO = true;
  private boolean dWP = true;
  private boolean dWQ = true;
  private boolean dWR = true;
  private boolean dhS = true;
  private boolean dhk = true;
  private boolean dhy = true;
  private boolean dmP = true;
  private boolean dmr = true;
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
    dhB = "appId".hashCode();
    dmT = "nickname".hashCode();
    dWT = "shortNickname".hashCode();
    dmF = "brandIconURL".hashCode();
    dWU = "roundedSquareIconURL".hashCode();
    dWV = "bigHeadURL".hashCode();
    dWW = "smallHeadURL".hashCode();
    dhP = "signature".hashCode();
    dWX = "appOpt".hashCode();
    dWY = "registerSource".hashCode();
    dWZ = "appInfo".hashCode();
    dFZ = "versionInfo".hashCode();
    dXa = "bindWxaInfo".hashCode();
    dXb = "dynamicInfo".hashCode();
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
      if (dWS != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.dWF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dmT == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (dWT == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (dmF == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (dWU == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (dWV == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (dWW == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (dhP == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (dWX == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (dWY == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (dWZ == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (dFZ == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (dXa == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (dXb == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (dGM == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (dXc == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (dXd == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (dXe == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dWF) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dmP) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dWG) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.dmr) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.dWH) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.dWI) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.dWJ) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.dhy) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.dWK) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.dWL) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.dWM) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.dFU) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.dWN) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.dWO) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.dGG) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.dWP) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.dWQ) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.dWR) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.fy
 * JD-Core Version:    0.7.0.1
 */