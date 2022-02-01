package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;

public abstract class y
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int elV = "status".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int eoB;
  private static final int eoc = "signature".hashCode();
  private static final int epM = "appName".hashCode();
  private static final int epN = "appDiscription".hashCode();
  private static final int epO = "appIconUrl".hashCode();
  private static final int epP = "appStoreUrl".hashCode();
  private static final int epQ;
  private static final int epR;
  private static final int epS = "modifyTime".hashCode();
  private static final int epT = "appName_en".hashCode();
  private static final int epU = "appName_tw".hashCode();
  private static final int epV = "appName_hk".hashCode();
  private static final int epW = "appDiscription_en".hashCode();
  private static final int epX = "appDiscription_tw".hashCode();
  private static final int epY = "appType".hashCode();
  private static final int epZ = "openId".hashCode();
  private static final int eqa = "authFlag".hashCode();
  private static final int eqb = "appInfoFlag".hashCode();
  private static final int eqc = "lvbuff".hashCode();
  private static final int eqd = "serviceAppType".hashCode();
  private static final int eqe = "serviceAppInfoFlag".hashCode();
  private static final int eqf = "serviceShowFlag".hashCode();
  private static final int eqg = "appSupportContentType".hashCode();
  private static final int eqh = "svrAppSupportContentType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elS = true;
  private boolean enL = true;
  private boolean enx = true;
  private boolean eox = true;
  private boolean epA = true;
  private boolean epB = true;
  private boolean epC = true;
  private boolean epD = true;
  private boolean epE = true;
  private boolean epF = true;
  public boolean epG = true;
  private boolean epH = true;
  private boolean epI = true;
  private boolean epJ = true;
  private boolean epK = true;
  private boolean epL = true;
  private boolean epq = true;
  private boolean epr = true;
  private boolean eps = true;
  private boolean ept = true;
  private boolean epu = true;
  private boolean epv = true;
  private boolean epw = true;
  private boolean epx = true;
  private boolean epy = true;
  private boolean epz = true;
  private String eqA;
  private int eqB;
  public String eqC;
  public String eqD;
  public String eqE;
  public int eqF;
  protected String eqi;
  private String eqj;
  public String eqk;
  public int eql;
  public int eqm;
  public String eqn;
  public String eqo;
  public String eqp;
  public String eqq;
  public String eqr;
  public String eqs;
  public int eqt;
  public String equ;
  public String eqv;
  public String eqw;
  public String eqx;
  private String eqy;
  public int eqz;
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
    eoB = "appVersion".hashCode();
    epQ = "appWatermarkUrl".hashCode();
    epR = "packageName".hashCode();
  }
  
  public final String Ti()
  {
    return this.eqk;
  }
  
  public final String Tj()
  {
    return this.eqp;
  }
  
  public final String Tk()
  {
    return this.eqq;
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
          if (enO == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.enx = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (epM == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (epN == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (epO == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (epP == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (eoB == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (epQ == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (epR == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (elV == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (eoc == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (epS == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (epT == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (epU == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (epV == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (epW == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (epX == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (epY == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (epZ == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (eqa == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (eqb == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (eqc == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (eqd == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (eqe == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (eqf == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (eqg == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (eqh == k) {
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
            paramCursor = new z();
            i = paramCursor.cr(this.field_lvbuff);
            if (i != 0)
            {
              ac.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ac.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.eqi = paramCursor.getString();
      this.eqj = paramCursor.getString();
      this.eqk = paramCursor.getString();
      this.eql = paramCursor.getInt();
      this.eqm = paramCursor.getInt();
      this.eqn = paramCursor.getString();
      this.eqo = paramCursor.getString();
      this.eqp = paramCursor.getString();
      this.eqq = paramCursor.getString();
      if (!paramCursor.eUE()) {
        this.eqr = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqs = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqt = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.equ = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqv = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqw = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqx = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqy = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqz = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eqA = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqB = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eqC = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqD = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eqE = paramCursor.getString();
      }
    } while (paramCursor.eUE());
    this.eqF = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.epG)
      {
        localObject = new z();
        ((z)localObject).eUF();
        ((z)localObject).aKJ(this.eqi);
        ((z)localObject).aKJ(this.eqj);
        ((z)localObject).aKJ(this.eqk);
        ((z)localObject).Yr(this.eql);
        ((z)localObject).Yr(this.eqm);
        ((z)localObject).aKJ(this.eqn);
        ((z)localObject).aKJ(this.eqo);
        ((z)localObject).aKJ(this.eqp);
        ((z)localObject).aKJ(this.eqq);
        ((z)localObject).aKJ(this.eqr);
        ((z)localObject).aKJ(this.eqs);
        ((z)localObject).Yr(this.eqt);
        ((z)localObject).aKJ(this.equ);
        ((z)localObject).aKJ(this.eqv);
        ((z)localObject).aKJ(this.eqw);
        ((z)localObject).aKJ(this.eqx);
        ((z)localObject).aKJ(this.eqy);
        ((z)localObject).Yr(this.eqz);
        ((z)localObject).aKJ(this.eqA);
        ((z)localObject).Yr(this.eqB);
        ((z)localObject).aKJ(this.eqC);
        ((z)localObject).aKJ(this.eqD);
        ((z)localObject).aKJ(this.eqE);
        ((z)localObject).Yr(this.eqF);
        this.field_lvbuff = ((z)localObject).eUG();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.enx) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.epq) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.epr) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.eps) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.ept) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.eox) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.epu) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.epv) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.elS) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.enL) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.epw) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.epx) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.epy) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.epz) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.epA) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.epB) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.epC) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.epD) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.epE) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.epF) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.epG) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.epH) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.epI) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.epJ) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.epK) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.epL) {
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
        ac.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void jx(int paramInt)
  {
    this.eqt = paramInt;
    this.epG = true;
  }
  
  public final void jy(int paramInt)
  {
    this.eqz = paramInt;
    this.epG = true;
  }
  
  public final void jz(int paramInt)
  {
    this.eqF = paramInt;
    this.epG = true;
  }
  
  public final void pO(String paramString)
  {
    this.eqj = paramString;
    this.epG = true;
  }
  
  public final void pP(String paramString)
  {
    this.eqk = paramString;
    this.epG = true;
  }
  
  public final void pQ(String paramString)
  {
    this.eqn = paramString;
    this.epG = true;
  }
  
  public final void pR(String paramString)
  {
    this.eqo = paramString;
    this.epG = true;
  }
  
  public final void pS(String paramString)
  {
    this.eqp = paramString;
    this.epG = true;
  }
  
  public final void pT(String paramString)
  {
    this.eqq = paramString;
    this.epG = true;
  }
  
  public final void pU(String paramString)
  {
    this.eqr = paramString;
    this.epG = true;
  }
  
  public final void pV(String paramString)
  {
    this.eqs = paramString;
    this.epG = true;
  }
  
  public final void pW(String paramString)
  {
    this.equ = paramString;
    this.epG = true;
  }
  
  public final void pX(String paramString)
  {
    this.eqv = paramString;
    this.epG = true;
  }
  
  public final void pY(String paramString)
  {
    this.eqw = paramString;
    this.epG = true;
  }
  
  public final void pZ(String paramString)
  {
    this.eqx = paramString;
    this.epG = true;
  }
  
  public final void qa(String paramString)
  {
    this.eqy = paramString;
    this.epG = true;
  }
  
  public final void qb(String paramString)
  {
    this.eqA = paramString;
    this.epG = true;
  }
  
  public final void qc(String paramString)
  {
    this.eqC = paramString;
    this.epG = true;
  }
  
  public final void qd(String paramString)
  {
    this.eqD = paramString;
    this.epG = true;
  }
  
  public final void qe(String paramString)
  {
    this.eqE = paramString;
    this.epG = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */