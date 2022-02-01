package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class y
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int eDc = "status".hashCode();
  private static final int eEU = "appId".hashCode();
  private static final int eFG;
  private static final int eFi = "signature".hashCode();
  private static final int eGV = "appName".hashCode();
  private static final int eGW = "appDiscription".hashCode();
  private static final int eGX = "appIconUrl".hashCode();
  private static final int eGY = "appStoreUrl".hashCode();
  private static final int eGZ;
  private static final int eHa;
  private static final int eHb = "modifyTime".hashCode();
  private static final int eHc = "appName_en".hashCode();
  private static final int eHd = "appName_tw".hashCode();
  private static final int eHe = "appName_hk".hashCode();
  private static final int eHf = "appDiscription_en".hashCode();
  private static final int eHg = "appDiscription_tw".hashCode();
  private static final int eHh = "appType".hashCode();
  private static final int eHi = "openId".hashCode();
  private static final int eHj = "authFlag".hashCode();
  private static final int eHk = "appInfoFlag".hashCode();
  private static final int eHl = "lvbuff".hashCode();
  private static final int eHm = "serviceAppType".hashCode();
  private static final int eHn = "serviceAppInfoFlag".hashCode();
  private static final int eHo = "serviceShowFlag".hashCode();
  private static final int eHp = "appSupportContentType".hashCode();
  private static final int eHq = "svrAppSupportContentType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eED = true;
  private boolean eER = true;
  private boolean eFC = true;
  private boolean eGA = true;
  private boolean eGB = true;
  private boolean eGC = true;
  private boolean eGD = true;
  private boolean eGE = true;
  private boolean eGF = true;
  private boolean eGG = true;
  private boolean eGH = true;
  private boolean eGI = true;
  private boolean eGJ = true;
  private boolean eGK = true;
  private boolean eGL = true;
  private boolean eGM = true;
  private boolean eGN = true;
  private boolean eGO = true;
  public boolean eGP = true;
  private boolean eGQ = true;
  private boolean eGR = true;
  private boolean eGS = true;
  private boolean eGT = true;
  private boolean eGU = true;
  private boolean eGz = true;
  public String eHA;
  public String eHB;
  public int eHC;
  public String eHD;
  public String eHE;
  public String eHF;
  public String eHG;
  private String eHH;
  public int eHI;
  private String eHJ;
  private int eHK;
  public String eHL;
  public String eHM;
  public String eHN;
  public int eHO;
  protected String eHr;
  private String eHs;
  public String eHt;
  public int eHu;
  public int eHv;
  public String eHw;
  public String eHx;
  public String eHy;
  public String eHz;
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
    eFG = "appVersion".hashCode();
    eGZ = "appWatermarkUrl".hashCode();
    eHa = "packageName".hashCode();
  }
  
  public final String Vw()
  {
    return this.eHt;
  }
  
  public final String Vx()
  {
    return this.eHy;
  }
  
  public final String Vy()
  {
    return this.eHz;
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
          if (eEU == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.eED = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eGV == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (eGW == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (eGX == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (eGY == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (eFG == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (eGZ == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (eHa == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (eDc == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (eFi == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (eHb == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (eHc == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (eHd == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (eHe == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (eHf == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (eHg == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (eHh == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (eHi == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (eHj == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (eHk == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (eHl == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (eHm == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (eHn == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (eHo == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (eHp == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (eHq == k) {
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
            paramCursor = new aa();
            i = paramCursor.cy(this.field_lvbuff);
            if (i != 0)
            {
              ad.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ad.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.eHr = paramCursor.getString();
      this.eHs = paramCursor.getString();
      this.eHt = paramCursor.getString();
      this.eHu = paramCursor.getInt();
      this.eHv = paramCursor.getInt();
      this.eHw = paramCursor.getString();
      this.eHx = paramCursor.getString();
      this.eHy = paramCursor.getString();
      this.eHz = paramCursor.getString();
      if (!paramCursor.fki()) {
        this.eHA = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHB = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHC = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.eHD = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHE = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHF = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHG = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHH = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHI = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.eHJ = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHK = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.eHL = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHM = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eHN = paramCursor.getString();
      }
    } while (paramCursor.fki());
    this.eHO = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eGP)
      {
        localObject = new aa();
        ((aa)localObject).fkj();
        ((aa)localObject).aQp(this.eHr);
        ((aa)localObject).aQp(this.eHs);
        ((aa)localObject).aQp(this.eHt);
        ((aa)localObject).aaw(this.eHu);
        ((aa)localObject).aaw(this.eHv);
        ((aa)localObject).aQp(this.eHw);
        ((aa)localObject).aQp(this.eHx);
        ((aa)localObject).aQp(this.eHy);
        ((aa)localObject).aQp(this.eHz);
        ((aa)localObject).aQp(this.eHA);
        ((aa)localObject).aQp(this.eHB);
        ((aa)localObject).aaw(this.eHC);
        ((aa)localObject).aQp(this.eHD);
        ((aa)localObject).aQp(this.eHE);
        ((aa)localObject).aQp(this.eHF);
        ((aa)localObject).aQp(this.eHG);
        ((aa)localObject).aQp(this.eHH);
        ((aa)localObject).aaw(this.eHI);
        ((aa)localObject).aQp(this.eHJ);
        ((aa)localObject).aaw(this.eHK);
        ((aa)localObject).aQp(this.eHL);
        ((aa)localObject).aQp(this.eHM);
        ((aa)localObject).aQp(this.eHN);
        ((aa)localObject).aaw(this.eHO);
        this.field_lvbuff = ((aa)localObject).fkk();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.eED) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.eGz) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.eGA) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.eGB) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.eGC) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.eFC) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.eGD) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.eGE) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.eCZ) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.eER) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.eGF) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.eGG) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.eGH) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.eGI) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.eGJ) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.eGK) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.eGL) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.eGM) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.eGN) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.eGO) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.eGP) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.eGQ) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.eGR) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.eGS) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.eGT) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.eGU) {
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
        ad.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void jV(int paramInt)
  {
    this.eHC = paramInt;
    this.eGP = true;
  }
  
  public final void jW(int paramInt)
  {
    this.eHI = paramInt;
    this.eGP = true;
  }
  
  public final void jX(int paramInt)
  {
    this.eHO = paramInt;
    this.eGP = true;
  }
  
  public final void sA(String paramString)
  {
    this.eHw = paramString;
    this.eGP = true;
  }
  
  public final void sB(String paramString)
  {
    this.eHx = paramString;
    this.eGP = true;
  }
  
  public final void sC(String paramString)
  {
    this.eHy = paramString;
    this.eGP = true;
  }
  
  public final void sD(String paramString)
  {
    this.eHz = paramString;
    this.eGP = true;
  }
  
  public final void sE(String paramString)
  {
    this.eHA = paramString;
    this.eGP = true;
  }
  
  public final void sF(String paramString)
  {
    this.eHB = paramString;
    this.eGP = true;
  }
  
  public final void sG(String paramString)
  {
    this.eHD = paramString;
    this.eGP = true;
  }
  
  public final void sH(String paramString)
  {
    this.eHE = paramString;
    this.eGP = true;
  }
  
  public final void sI(String paramString)
  {
    this.eHF = paramString;
    this.eGP = true;
  }
  
  public final void sJ(String paramString)
  {
    this.eHG = paramString;
    this.eGP = true;
  }
  
  public final void sK(String paramString)
  {
    this.eHH = paramString;
    this.eGP = true;
  }
  
  public final void sL(String paramString)
  {
    this.eHJ = paramString;
    this.eGP = true;
  }
  
  public final void sM(String paramString)
  {
    this.eHL = paramString;
    this.eGP = true;
  }
  
  public final void sN(String paramString)
  {
    this.eHM = paramString;
    this.eGP = true;
  }
  
  public final void sO(String paramString)
  {
    this.eHN = paramString;
    this.eGP = true;
  }
  
  public final void sy(String paramString)
  {
    this.eHs = paramString;
    this.eGP = true;
  }
  
  public final void sz(String paramString)
  {
    this.eHt = paramString;
    this.eGP = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */