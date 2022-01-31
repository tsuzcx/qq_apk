package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class t
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int dfJ;
  private static final int dhB = "appId".hashCode();
  private static final int dhP;
  private static final int djA = "appInfoFlag".hashCode();
  private static final int djB = "lvbuff".hashCode();
  private static final int djC = "serviceAppType".hashCode();
  private static final int djD = "serviceAppInfoFlag".hashCode();
  private static final int djE = "serviceShowFlag".hashCode();
  private static final int djF = "appSupportContentType".hashCode();
  private static final int djG = "svrAppSupportContentType".hashCode();
  private static final int djk = "appName".hashCode();
  private static final int djl = "appDiscription".hashCode();
  private static final int djm = "appIconUrl".hashCode();
  private static final int djn = "appStoreUrl".hashCode();
  private static final int djo = "appVersion".hashCode();
  private static final int djp = "appWatermarkUrl".hashCode();
  private static final int djq = "packageName".hashCode();
  private static final int djr;
  private static final int djs;
  private static final int djt;
  private static final int dju;
  private static final int djv;
  private static final int djw;
  private static final int djx;
  private static final int djy;
  private static final int djz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfG = true;
  private boolean dhk = true;
  private boolean dhy = true;
  private boolean diN = true;
  private boolean diO = true;
  private boolean diP = true;
  private boolean diQ = true;
  private boolean diR = true;
  private boolean diS = true;
  private boolean diT = true;
  private boolean diU = true;
  private boolean diV = true;
  private boolean diW = true;
  private boolean diX = true;
  private boolean diY = true;
  private boolean diZ = true;
  protected String djH;
  private String djI;
  public String djJ;
  public int djK;
  public int djL;
  public String djM;
  public String djN;
  public String djO;
  public String djP;
  public String djQ;
  public String djR;
  public int djS;
  public String djT;
  public String djU;
  public String djV;
  public String djW;
  private String djX;
  public int djY;
  private String djZ;
  private boolean dja = true;
  private boolean djb = true;
  private boolean djc = true;
  private boolean djd = true;
  public boolean dje = true;
  private boolean djf = true;
  private boolean djg = true;
  private boolean djh = true;
  private boolean dji = true;
  private boolean djj = true;
  private int dka;
  public String dkb;
  public String dkc;
  public String dkd;
  public int dke;
  public String field_appDiscription;
  public String field_appDiscription_en;
  public String field_appDiscription_tw;
  public String field_appIconUrl;
  public String field_appId;
  public int field_appInfoFlag;
  public String field_appName;
  public String field_appName_en;
  public String field_appName_hk;
  public String field_appName_tw;
  public String field_appStoreUrl;
  public long field_appSupportContentType;
  public String field_appType;
  public int field_appVersion;
  public String field_appWatermarkUrl;
  public int field_authFlag;
  public byte[] field_lvbuff;
  public long field_modifyTime;
  public String field_openId;
  public String field_packageName;
  public int field_serviceAppInfoFlag;
  public int field_serviceAppType;
  public int field_serviceShowFlag;
  public String field_signature;
  public int field_status;
  public long field_svrAppSupportContentType;
  
  static
  {
    dfJ = "status".hashCode();
    dhP = "signature".hashCode();
    djr = "modifyTime".hashCode();
    djs = "appName_en".hashCode();
    djt = "appName_tw".hashCode();
    dju = "appName_hk".hashCode();
    djv = "appDiscription_en".hashCode();
    djw = "appDiscription_tw".hashCode();
    djx = "appType".hashCode();
    djy = "openId".hashCode();
    djz = "authFlag".hashCode();
  }
  
  public final String Hn()
  {
    return this.djJ;
  }
  
  public final String Ho()
  {
    return this.djO;
  }
  
  public final String Hp()
  {
    return this.djP;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
        int i = 0;
        int j = arrayOfString.length;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (dhB == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.dhk = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (djk == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (djl == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (djm == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (djn == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (djo == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (djp == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (djq == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (dfJ == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (dhP == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (djr == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (djs == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (djt == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (dju == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (djv == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (djw == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (djx == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (djy == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (djz == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (djA == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (djB == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (djC == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (djD == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (djE == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (djF == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (djG == k) {
              this.field_svrAppSupportContentType = paramCursor.getLong(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuff != null) && (this.field_lvbuff.length != 0))
          {
            paramCursor = new y();
            i = paramCursor.ca(this.field_lvbuff);
            if (i != 0)
            {
              ab.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ab.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.djH = paramCursor.getString();
      this.djI = paramCursor.getString();
      this.djJ = paramCursor.getString();
      this.djK = paramCursor.getInt();
      this.djL = paramCursor.getInt();
      this.djM = paramCursor.getString();
      this.djN = paramCursor.getString();
      this.djO = paramCursor.getString();
      this.djP = paramCursor.getString();
      if (!paramCursor.dsu()) {
        this.djQ = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djR = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djS = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.djT = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djU = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djV = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djW = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djX = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.djY = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.djZ = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dka = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dkb = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dkc = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dkd = paramCursor.getString();
      }
    } while (paramCursor.dsu());
    this.dke = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.dje)
      {
        localObject = new y();
        ((y)localObject).dsv();
        ((y)localObject).ape(this.djH);
        ((y)localObject).ape(this.djI);
        ((y)localObject).ape(this.djJ);
        ((y)localObject).Nd(this.djK);
        ((y)localObject).Nd(this.djL);
        ((y)localObject).ape(this.djM);
        ((y)localObject).ape(this.djN);
        ((y)localObject).ape(this.djO);
        ((y)localObject).ape(this.djP);
        ((y)localObject).ape(this.djQ);
        ((y)localObject).ape(this.djR);
        ((y)localObject).Nd(this.djS);
        ((y)localObject).ape(this.djT);
        ((y)localObject).ape(this.djU);
        ((y)localObject).ape(this.djV);
        ((y)localObject).ape(this.djW);
        ((y)localObject).ape(this.djX);
        ((y)localObject).Nd(this.djY);
        ((y)localObject).ape(this.djZ);
        ((y)localObject).Nd(this.dka);
        ((y)localObject).ape(this.dkb);
        ((y)localObject).ape(this.dkc);
        ((y)localObject).ape(this.dkd);
        ((y)localObject).Nd(this.dke);
        this.field_lvbuff = ((y)localObject).dsw();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.dhk) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.diN) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.diO) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.diP) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.diQ) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.diR) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.diS) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.diT) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.dfG) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.dhy) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.diU) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.diV) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.diW) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.diX) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.diY) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.diZ) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.dja) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.djb) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.djc) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.djd) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.dje) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.djf) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.djg) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.djh) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.dji) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.djj) {
        ((ContentValues)localObject).put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
      }
      if (this.systemRowid > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void ho(int paramInt)
  {
    this.djS = paramInt;
    this.dje = true;
  }
  
  public final void hp(int paramInt)
  {
    this.djY = paramInt;
    this.dje = true;
  }
  
  public final void hq(int paramInt)
  {
    this.dke = paramInt;
    this.dje = true;
  }
  
  public final void iU(String paramString)
  {
    this.djI = paramString;
    this.dje = true;
  }
  
  public final void iV(String paramString)
  {
    this.djJ = paramString;
    this.dje = true;
  }
  
  public final void iW(String paramString)
  {
    this.djM = paramString;
    this.dje = true;
  }
  
  public final void iX(String paramString)
  {
    this.djN = paramString;
    this.dje = true;
  }
  
  public final void iY(String paramString)
  {
    this.djO = paramString;
    this.dje = true;
  }
  
  public final void iZ(String paramString)
  {
    this.djP = paramString;
    this.dje = true;
  }
  
  public final void ja(String paramString)
  {
    this.djQ = paramString;
    this.dje = true;
  }
  
  public final void jb(String paramString)
  {
    this.djR = paramString;
    this.dje = true;
  }
  
  public final void jc(String paramString)
  {
    this.djT = paramString;
    this.dje = true;
  }
  
  public final void jd(String paramString)
  {
    this.djU = paramString;
    this.dje = true;
  }
  
  public final void je(String paramString)
  {
    this.djV = paramString;
    this.dje = true;
  }
  
  public final void jf(String paramString)
  {
    this.djW = paramString;
    this.dje = true;
  }
  
  public final void jg(String paramString)
  {
    this.djX = paramString;
    this.dje = true;
  }
  
  public final void jh(String paramString)
  {
    this.djZ = paramString;
    this.dje = true;
  }
  
  public final void ji(String paramString)
  {
    this.dkb = paramString;
    this.dje = true;
  }
  
  public final void jj(String paramString)
  {
    this.dkc = paramString;
    this.dje = true;
  }
  
  public final void jk(String paramString)
  {
    this.dkd = paramString;
    this.dje = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.t
 * JD-Core Version:    0.7.0.1
 */