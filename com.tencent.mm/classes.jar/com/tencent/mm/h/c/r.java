package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public abstract class r
  extends c
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctA;
  private static final int ctl = "appId".hashCode();
  private static final int cuY = "appName".hashCode();
  private static final int cuZ = "appDiscription".hashCode();
  private static final int cva = "appIconUrl".hashCode();
  private static final int cvb = "appStoreUrl".hashCode();
  private static final int cvc = "appVersion".hashCode();
  private static final int cvd = "appWatermarkUrl".hashCode();
  private static final int cve = "packageName".hashCode();
  private static final int cvf;
  private static final int cvg;
  private static final int cvh;
  private static final int cvi;
  private static final int cvj;
  private static final int cvk;
  private static final int cvl;
  private static final int cvm;
  private static final int cvn;
  private static final int cvo;
  private static final int cvp;
  private static final int cvq;
  private static final int cvr;
  private static final int cvs;
  private static final int cvt;
  private static final int cvu;
  private boolean crk = true;
  private boolean csU = true;
  private boolean cti = true;
  private boolean cuB = true;
  private boolean cuC = true;
  private boolean cuD = true;
  private boolean cuE = true;
  private boolean cuF = true;
  private boolean cuG = true;
  private boolean cuH = true;
  private boolean cuI = true;
  private boolean cuJ = true;
  private boolean cuK = true;
  private boolean cuL = true;
  private boolean cuM = true;
  private boolean cuN = true;
  private boolean cuO = true;
  private boolean cuP = true;
  private boolean cuQ = true;
  private boolean cuR = true;
  public boolean cuS = true;
  private boolean cuT = true;
  private boolean cuU = true;
  private boolean cuV = true;
  private boolean cuW = true;
  private boolean cuX = true;
  public int cvA;
  public String cvB;
  public String cvC;
  public String cvD;
  public String cvE;
  public String cvF;
  public String cvG;
  public int cvH;
  public String cvI;
  public String cvJ;
  public String cvK;
  public String cvL;
  public String cvM;
  public int cvN;
  public String cvO;
  private int cvP;
  public String cvQ;
  public String cvR;
  public String cvS;
  public int cvT;
  public String cvw;
  public String cvx;
  public String cvy;
  public int cvz;
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
    crn = "status".hashCode();
    ctA = "signature".hashCode();
    cvf = "modifyTime".hashCode();
    cvg = "appName_en".hashCode();
    cvh = "appName_tw".hashCode();
    cvi = "appName_hk".hashCode();
    cvj = "appDiscription_en".hashCode();
    cvk = "appDiscription_tw".hashCode();
    cvl = "appType".hashCode();
    cvm = "openId".hashCode();
    cvn = "authFlag".hashCode();
    cvo = "appInfoFlag".hashCode();
    cvp = "lvbuff".hashCode();
    cvq = "serviceAppType".hashCode();
    cvr = "serviceAppInfoFlag".hashCode();
    cvs = "serviceShowFlag".hashCode();
    cvt = "appSupportContentType".hashCode();
    cvu = "svrAppSupportContentType".hashCode();
  }
  
  public final void cL(String paramString)
  {
    this.cvw = paramString;
    this.cuS = true;
  }
  
  public final void cM(String paramString)
  {
    this.cvx = paramString;
    this.cuS = true;
  }
  
  public final void cN(String paramString)
  {
    this.cvy = paramString;
    this.cuS = true;
  }
  
  public final void cO(String paramString)
  {
    this.cvB = paramString;
    this.cuS = true;
  }
  
  public final void cP(String paramString)
  {
    this.cvC = paramString;
    this.cuS = true;
  }
  
  public final void cQ(String paramString)
  {
    this.cvD = paramString;
    this.cuS = true;
  }
  
  public final void cR(String paramString)
  {
    this.cvE = paramString;
    this.cuS = true;
  }
  
  public final void cS(String paramString)
  {
    this.cvF = paramString;
    this.cuS = true;
  }
  
  public final void cT(String paramString)
  {
    this.cvG = paramString;
    this.cuS = true;
  }
  
  public final void cU(String paramString)
  {
    this.cvI = paramString;
    this.cuS = true;
  }
  
  public final void cV(String paramString)
  {
    this.cvJ = paramString;
    this.cuS = true;
  }
  
  public final void cW(String paramString)
  {
    this.cvK = paramString;
    this.cuS = true;
  }
  
  public final void cX(String paramString)
  {
    this.cvL = paramString;
    this.cuS = true;
  }
  
  public final void d(Cursor paramCursor)
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
          if (ctl == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.csU = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (cuY == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (cuZ == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (cva == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (cvb == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (cvc == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (cvd == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (cve == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (crn == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (ctA == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (cvf == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (cvg == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (cvh == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (cvi == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (cvj == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (cvk == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (cvl == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (cvm == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (cvn == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (cvo == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (cvp == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (cvq == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (cvr == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (cvs == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (cvt == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (cvu == k) {
              this.field_svrAppSupportContentType = paramCursor.getLong(i);
            } else if (crh == k) {
              this.ujK = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuff != null) && (this.field_lvbuff.length != 0))
          {
            paramCursor = new v();
            i = paramCursor.bA(this.field_lvbuff);
            if (i != 0)
            {
              y.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + i);
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          y.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.cvw = paramCursor.getString();
      this.cvx = paramCursor.getString();
      this.cvy = paramCursor.getString();
      this.cvz = paramCursor.getInt();
      this.cvA = paramCursor.getInt();
      this.cvB = paramCursor.getString();
      this.cvC = paramCursor.getString();
      this.cvD = paramCursor.getString();
      this.cvE = paramCursor.getString();
      if (!paramCursor.cqx()) {
        this.cvF = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvG = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvH = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cvI = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvJ = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvK = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvL = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvM = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvN = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cvO = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvP = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cvQ = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvR = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cvS = paramCursor.getString();
      }
    } while (paramCursor.cqx());
    this.cvT = paramCursor.getInt();
  }
  
  public final void fd(int paramInt)
  {
    this.cvH = paramInt;
    this.cuS = true;
  }
  
  public final void fe(int paramInt)
  {
    this.cvN = paramInt;
    this.cuS = true;
  }
  
  public ContentValues vf()
  {
    try
    {
      if (this.cuS)
      {
        localObject = new v();
        ((v)localObject).cqy();
        ((v)localObject).Zg(this.cvw);
        ((v)localObject).Zg(this.cvx);
        ((v)localObject).Zg(this.cvy);
        ((v)localObject).Fb(this.cvz);
        ((v)localObject).Fb(this.cvA);
        ((v)localObject).Zg(this.cvB);
        ((v)localObject).Zg(this.cvC);
        ((v)localObject).Zg(this.cvD);
        ((v)localObject).Zg(this.cvE);
        ((v)localObject).Zg(this.cvF);
        ((v)localObject).Zg(this.cvG);
        ((v)localObject).Fb(this.cvH);
        ((v)localObject).Zg(this.cvI);
        ((v)localObject).Zg(this.cvJ);
        ((v)localObject).Zg(this.cvK);
        ((v)localObject).Zg(this.cvL);
        ((v)localObject).Zg(this.cvM);
        ((v)localObject).Fb(this.cvN);
        ((v)localObject).Zg(this.cvO);
        ((v)localObject).Fb(this.cvP);
        ((v)localObject).Zg(this.cvQ);
        ((v)localObject).Zg(this.cvR);
        ((v)localObject).Zg(this.cvS);
        ((v)localObject).Fb(this.cvT);
        this.field_lvbuff = ((v)localObject).cqz();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.csU) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.cuB) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.cuC) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.cuD) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.cuE) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.cuF) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.cuG) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.cuH) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.crk) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.cti) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.cuI) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.cuJ) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.cuK) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.cuL) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.cuM) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.cuN) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.cuO) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.cuP) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.cuQ) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.cuR) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.cuS) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.cuT) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.cuU) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.cuV) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.cuW) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.cuX) {
        ((ContentValues)localObject).put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
      }
      if (this.ujK > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.ujK));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final String vh()
  {
    return this.cvy;
  }
  
  public final String vi()
  {
    return this.cvD;
  }
  
  public final String vj()
  {
    return this.cvE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.r
 * JD-Core Version:    0.7.0.1
 */