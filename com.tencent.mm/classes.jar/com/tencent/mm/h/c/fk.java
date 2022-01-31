package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fk
  extends c
{
  private static final int cQA;
  private static final int cQf;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int crh = "rowid".hashCode();
  private static final int ctA;
  private static final int ctF;
  private static final int ctl;
  private static final int cyE;
  private static final int cyS;
  private static final int dfD = "usernameHash".hashCode();
  private static final int dfE;
  private static final int dfF;
  private static final int dfG;
  private static final int dfH;
  private static final int dfI;
  private static final int dfJ;
  private static final int dfK;
  private static final int dfL;
  private static final int dfM;
  private static final int dfN;
  private static final int dfO;
  private static final int dfP;
  private boolean cQa = true;
  private boolean cQu = true;
  private boolean csU = true;
  private boolean ctD = true;
  private boolean cti = true;
  private boolean cyO = true;
  private boolean cyq = true;
  private boolean dfA = true;
  private boolean dfB = true;
  private boolean dfC = true;
  private boolean dfq = true;
  private boolean dfr = true;
  private boolean dfs = true;
  private boolean dft = true;
  private boolean dfu = true;
  private boolean dfv = true;
  private boolean dfw = true;
  private boolean dfx = true;
  private boolean dfy = true;
  private boolean dfz = true;
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
    ctF = "username".hashCode();
    ctl = "appId".hashCode();
    cyS = "nickname".hashCode();
    dfE = "shortNickname".hashCode();
    cyE = "brandIconURL".hashCode();
    dfF = "roundedSquareIconURL".hashCode();
    dfG = "bigHeadURL".hashCode();
    dfH = "smallHeadURL".hashCode();
    ctA = "signature".hashCode();
    dfI = "appOpt".hashCode();
    dfJ = "registerSource".hashCode();
    dfK = "appInfo".hashCode();
    cQf = "versionInfo".hashCode();
    dfL = "bindWxaInfo".hashCode();
    dfM = "dynamicInfo".hashCode();
    cQA = "reserved".hashCode();
    dfN = "syncTimeSecond".hashCode();
    dfO = "syncVersion".hashCode();
    dfP = "bizMenu".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (dfD != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.dfq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (cyS == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (dfE == k) {
        this.field_shortNickname = paramCursor.getString(i);
      } else if (cyE == k) {
        this.field_brandIconURL = paramCursor.getString(i);
      } else if (dfF == k) {
        this.field_roundedSquareIconURL = paramCursor.getString(i);
      } else if (dfG == k) {
        this.field_bigHeadURL = paramCursor.getString(i);
      } else if (dfH == k) {
        this.field_smallHeadURL = paramCursor.getString(i);
      } else if (ctA == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (dfI == k) {
        this.field_appOpt = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_registerSource = paramCursor.getString(i);
      } else if (dfK == k) {
        this.field_appInfo = paramCursor.getString(i);
      } else if (cQf == k) {
        this.field_versionInfo = paramCursor.getString(i);
      } else if (dfL == k) {
        this.field_bindWxaInfo = paramCursor.getString(i);
      } else if (dfM == k) {
        this.field_dynamicInfo = paramCursor.getString(i);
      } else if (cQA == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (dfN == k) {
        this.field_syncTimeSecond = paramCursor.getLong(i);
      } else if (dfO == k) {
        this.field_syncVersion = paramCursor.getString(i);
      } else if (dfP == k) {
        this.field_bizMenu = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfq) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cyO) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dfr) {
      localContentValues.put("shortNickname", this.field_shortNickname);
    }
    if (this.cyq) {
      localContentValues.put("brandIconURL", this.field_brandIconURL);
    }
    if (this.dfs) {
      localContentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
    }
    if (this.dft) {
      localContentValues.put("bigHeadURL", this.field_bigHeadURL);
    }
    if (this.dfu) {
      localContentValues.put("smallHeadURL", this.field_smallHeadURL);
    }
    if (this.cti) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.dfv) {
      localContentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
    }
    if (this.dfw) {
      localContentValues.put("registerSource", this.field_registerSource);
    }
    if (this.dfx) {
      localContentValues.put("appInfo", this.field_appInfo);
    }
    if (this.cQa) {
      localContentValues.put("versionInfo", this.field_versionInfo);
    }
    if (this.dfy) {
      localContentValues.put("bindWxaInfo", this.field_bindWxaInfo);
    }
    if (this.dfz) {
      localContentValues.put("dynamicInfo", this.field_dynamicInfo);
    }
    if (this.cQu) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.dfA) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
    }
    if (this.dfB) {
      localContentValues.put("syncVersion", this.field_syncVersion);
    }
    if (this.dfC) {
      localContentValues.put("bizMenu", this.field_bizMenu);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.fk
 * JD-Core Version:    0.7.0.1
 */