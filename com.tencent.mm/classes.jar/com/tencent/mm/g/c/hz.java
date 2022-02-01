package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hz
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int fPr;
  private static final int fkB = "usernameHash".hashCode();
  private static final int fkj;
  private static final int fkx;
  private static final int fpR;
  private static final int fqW = "reserved".hashCode();
  private static final int fqf;
  private static final int gjh;
  private static final int gji;
  private static final int gjj;
  private static final int gjk;
  private static final int gjl;
  private static final int gjm;
  private static final int gjn;
  private static final int gjo;
  private static final int gjp;
  private static final int gjq;
  private static final int gjr = "syncTimeSecond".hashCode();
  private static final int gjs = "syncVersion".hashCode();
  private static final int gjt = "bizMenu".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fPm = true;
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
  private boolean fjS = true;
  private boolean fkA = true;
  private boolean fkg = true;
  private boolean fpD = true;
  private boolean fqO = true;
  private boolean fqb = true;
  private boolean giU = true;
  private boolean giV = true;
  private boolean giW = true;
  private boolean giX = true;
  private boolean giY = true;
  private boolean giZ = true;
  private boolean gja = true;
  private boolean gjb = true;
  private boolean gjc = true;
  private boolean gjd = true;
  private boolean gje = true;
  private boolean gjf = true;
  private boolean gjg = true;
  
  static
  {
    fkj = "appId".hashCode();
    fqf = "nickname".hashCode();
    gjh = "shortNickname".hashCode();
    fpR = "brandIconURL".hashCode();
    gji = "roundedSquareIconURL".hashCode();
    gjj = "bigHeadURL".hashCode();
    gjk = "smallHeadURL".hashCode();
    fkx = "signature".hashCode();
    gjl = "appOpt".hashCode();
    gjm = "registerSource".hashCode();
    gjn = "appInfo".hashCode();
    fPr = "versionInfo".hashCode();
    gjo = "passThroughInfo".hashCode();
    gjp = "bindWxaInfo".hashCode();
    gjq = "dynamicInfo".hashCode();
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
      if (fkB != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.fkA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (gjh == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (fpR == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (gji == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (gjj == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (gjk == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (fkx == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (gjl == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (gjm == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (gjn == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (fPr == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (gjo == k) {
        this.field_passThroughInfo = paramCursor.getString(i);
      } else if (gjp == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (gjq == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (fqW == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (gjr == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (gjs == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (gjt == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkA) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.giU) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.fpD) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.giV) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.giW) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.giX) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.fkg) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.giY) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.giZ) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.gja) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.fPm) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.gjb) {
      localContentValues.put("passThroughInfo", this.field_passThroughInfo);
    }
    if (this.gjc) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.gjd) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.fqO) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.gje) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.gjf) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.gjg) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hz
 * JD-Core Version:    0.7.0.1
 */