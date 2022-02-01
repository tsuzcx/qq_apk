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
  private static final int ejR = "status".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int elX = "signature".hashCode();
  private static final int emv;
  private static final int enH = "appName".hashCode();
  private static final int enI = "appDiscription".hashCode();
  private static final int enJ = "appIconUrl".hashCode();
  private static final int enK = "appStoreUrl".hashCode();
  private static final int enL;
  private static final int enM;
  private static final int enN = "modifyTime".hashCode();
  private static final int enO = "appName_en".hashCode();
  private static final int enP = "appName_tw".hashCode();
  private static final int enQ = "appName_hk".hashCode();
  private static final int enR = "appDiscription_en".hashCode();
  private static final int enS = "appDiscription_tw".hashCode();
  private static final int enT = "appType".hashCode();
  private static final int enU = "openId".hashCode();
  private static final int enV = "authFlag".hashCode();
  private static final int enW = "appInfoFlag".hashCode();
  private static final int enX = "lvbuff".hashCode();
  private static final int enY = "serviceAppType".hashCode();
  private static final int enZ = "serviceAppInfoFlag".hashCode();
  private static final int eoa = "serviceShowFlag".hashCode();
  private static final int eob = "appSupportContentType".hashCode();
  private static final int eoc = "svrAppSupportContentType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejO = true;
  private boolean elG = true;
  private boolean els = true;
  private boolean emr = true;
  private boolean enA = true;
  public boolean enB = true;
  private boolean enC = true;
  private boolean enD = true;
  private boolean enE = true;
  private boolean enF = true;
  private boolean enG = true;
  private boolean enl = true;
  private boolean enm = true;
  private boolean enn = true;
  private boolean eno = true;
  private boolean enp = true;
  private boolean enq = true;
  private boolean enr = true;
  private boolean ens = true;
  private boolean ent = true;
  private boolean enu = true;
  private boolean env = true;
  private boolean enw = true;
  private boolean enx = true;
  private boolean eny = true;
  private boolean enz = true;
  public String eoA;
  public int eoB;
  protected String eod;
  private String eoe;
  public String eog;
  public int eoh;
  public int eoi;
  public String eoj;
  public String eok;
  public String eol;
  public String eom;
  public String eon;
  public String eoo;
  public int eop;
  public String eoq;
  public String eor;
  public String eos;
  public String eot;
  private String eou;
  public int eov;
  private String eow;
  private int eox;
  public String eoy;
  public String eoz;
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
    emv = "appVersion".hashCode();
    enL = "appWatermarkUrl".hashCode();
    enM = "packageName".hashCode();
  }
  
  public final String Sp()
  {
    return this.eog;
  }
  
  public final String Sq()
  {
    return this.eol;
  }
  
  public final String Sr()
  {
    return this.eom;
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
          if (elJ == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.els = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (enH == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (enI == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (enJ == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (enK == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (emv == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (enL == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (enM == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (ejR == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (elX == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (enN == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (enO == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (enP == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (enQ == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (enR == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (enS == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (enT == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (enU == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (enV == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (enW == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (enX == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (enY == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (enZ == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (eoa == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (eob == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (eoc == k) {
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
            i = paramCursor.cs(this.field_lvbuff);
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
      this.eod = paramCursor.getString();
      this.eoe = paramCursor.getString();
      this.eog = paramCursor.getString();
      this.eoh = paramCursor.getInt();
      this.eoi = paramCursor.getInt();
      this.eoj = paramCursor.getString();
      this.eok = paramCursor.getString();
      this.eol = paramCursor.getString();
      this.eom = paramCursor.getString();
      if (!paramCursor.eFk()) {
        this.eon = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eoo = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eop = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eoq = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eor = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eos = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eot = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eou = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eov = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eow = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eox = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eoy = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eoz = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eoA = paramCursor.getString();
      }
    } while (paramCursor.eFk());
    this.eoB = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.enB)
      {
        localObject = new aa();
        ((aa)localObject).eFl();
        ((aa)localObject).aFs(this.eod);
        ((aa)localObject).aFs(this.eoe);
        ((aa)localObject).aFs(this.eog);
        ((aa)localObject).Wi(this.eoh);
        ((aa)localObject).Wi(this.eoi);
        ((aa)localObject).aFs(this.eoj);
        ((aa)localObject).aFs(this.eok);
        ((aa)localObject).aFs(this.eol);
        ((aa)localObject).aFs(this.eom);
        ((aa)localObject).aFs(this.eon);
        ((aa)localObject).aFs(this.eoo);
        ((aa)localObject).Wi(this.eop);
        ((aa)localObject).aFs(this.eoq);
        ((aa)localObject).aFs(this.eor);
        ((aa)localObject).aFs(this.eos);
        ((aa)localObject).aFs(this.eot);
        ((aa)localObject).aFs(this.eou);
        ((aa)localObject).Wi(this.eov);
        ((aa)localObject).aFs(this.eow);
        ((aa)localObject).Wi(this.eox);
        ((aa)localObject).aFs(this.eoy);
        ((aa)localObject).aFs(this.eoz);
        ((aa)localObject).aFs(this.eoA);
        ((aa)localObject).Wi(this.eoB);
        this.field_lvbuff = ((aa)localObject).eFm();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.els) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.enl) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.enm) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.enn) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.eno) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.emr) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.enp) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.enq) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.ejO) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.elG) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.enr) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.ens) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.ent) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.enu) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.env) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.enw) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.enx) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.eny) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.enz) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.enA) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.enB) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.enC) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.enD) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.enE) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.enF) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.enG) {
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
  
  public final void jA(int paramInt)
  {
    this.eov = paramInt;
    this.enB = true;
  }
  
  public final void jB(int paramInt)
  {
    this.eoB = paramInt;
    this.enB = true;
  }
  
  public final void jz(int paramInt)
  {
    this.eop = paramInt;
    this.enB = true;
  }
  
  public final void mI(String paramString)
  {
    this.eoe = paramString;
    this.enB = true;
  }
  
  public final void mJ(String paramString)
  {
    this.eog = paramString;
    this.enB = true;
  }
  
  public final void mK(String paramString)
  {
    this.eoj = paramString;
    this.enB = true;
  }
  
  public final void mL(String paramString)
  {
    this.eok = paramString;
    this.enB = true;
  }
  
  public final void mM(String paramString)
  {
    this.eol = paramString;
    this.enB = true;
  }
  
  public final void mN(String paramString)
  {
    this.eom = paramString;
    this.enB = true;
  }
  
  public final void mO(String paramString)
  {
    this.eon = paramString;
    this.enB = true;
  }
  
  public final void mP(String paramString)
  {
    this.eoo = paramString;
    this.enB = true;
  }
  
  public final void mQ(String paramString)
  {
    this.eoq = paramString;
    this.enB = true;
  }
  
  public final void mR(String paramString)
  {
    this.eor = paramString;
    this.enB = true;
  }
  
  public final void mS(String paramString)
  {
    this.eos = paramString;
    this.enB = true;
  }
  
  public final void mT(String paramString)
  {
    this.eot = paramString;
    this.enB = true;
  }
  
  public final void mU(String paramString)
  {
    this.eou = paramString;
    this.enB = true;
  }
  
  public final void mV(String paramString)
  {
    this.eow = paramString;
    this.enB = true;
  }
  
  public final void mW(String paramString)
  {
    this.eoy = paramString;
    this.enB = true;
  }
  
  public final void mX(String paramString)
  {
    this.eoz = paramString;
    this.enB = true;
  }
  
  public final void mY(String paramString)
  {
    this.eoA = paramString;
    this.enB = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */