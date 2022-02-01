package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class y
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int fjl;
  private static final int fkR;
  private static final int fkj = "appId".hashCode();
  private static final int fkx;
  private static final int fmA = "appSupportContentType".hashCode();
  private static final int fmB = "svrAppSupportContentType".hashCode();
  private static final int fmg = "appName".hashCode();
  private static final int fmh = "appDiscription".hashCode();
  private static final int fmi = "appIconUrl".hashCode();
  private static final int fmj = "appStoreUrl".hashCode();
  private static final int fmk;
  private static final int fml;
  private static final int fmm;
  private static final int fmn;
  private static final int fmo;
  private static final int fmp;
  private static final int fmq;
  private static final int fmr;
  private static final int fms;
  private static final int fmt;
  private static final int fmu;
  private static final int fmv;
  private static final int fmw;
  private static final int fmx;
  private static final int fmy;
  private static final int fmz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean fjS = true;
  private boolean fji = true;
  private boolean fkN = true;
  private boolean fkg = true;
  private boolean flK = true;
  private boolean flL = true;
  private boolean flM = true;
  private boolean flN = true;
  private boolean flO = true;
  private boolean flP = true;
  private boolean flQ = true;
  private boolean flR = true;
  private boolean flS = true;
  private boolean flT = true;
  private boolean flU = true;
  private boolean flV = true;
  private boolean flW = true;
  private boolean flX = true;
  private boolean flY = true;
  private boolean flZ = true;
  protected String fmC;
  private String fmD;
  public String fmE;
  public int fmF;
  public int fmG;
  public String fmH;
  public String fmI;
  public String fmJ;
  public String fmK;
  public String fmL;
  public String fmM;
  public int fmN;
  public String fmO;
  public String fmP;
  public String fmQ;
  public String fmR;
  private String fmS;
  public int fmT;
  private String fmU;
  private int fmV;
  public String fmW;
  public String fmX;
  public String fmY;
  public int fmZ;
  public boolean fma = true;
  private boolean fmb = true;
  private boolean fmc = true;
  private boolean fmd = true;
  private boolean fme = true;
  private boolean fmf = true;
  
  static
  {
    fkR = "appVersion".hashCode();
    fmk = "appWatermarkUrl".hashCode();
    fml = "packageName".hashCode();
    fjl = "status".hashCode();
    fkx = "signature".hashCode();
    fmm = "modifyTime".hashCode();
    fmn = "appName_en".hashCode();
    fmo = "appName_tw".hashCode();
    fmp = "appName_hk".hashCode();
    fmq = "appDiscription_en".hashCode();
    fmr = "appDiscription_tw".hashCode();
    fms = "appType".hashCode();
    fmt = "openId".hashCode();
    fmu = "authFlag".hashCode();
    fmv = "appInfoFlag".hashCode();
    fmw = "lvbuff".hashCode();
    fmx = "serviceAppType".hashCode();
    fmy = "serviceAppInfoFlag".hashCode();
    fmz = "serviceShowFlag".hashCode();
  }
  
  public final void BA(String paramString)
  {
    this.fmY = paramString;
    this.fma = true;
  }
  
  public final void Bk(String paramString)
  {
    this.fmD = paramString;
    this.fma = true;
  }
  
  public final void Bl(String paramString)
  {
    this.fmE = paramString;
    this.fma = true;
  }
  
  public final void Bm(String paramString)
  {
    this.fmH = paramString;
    this.fma = true;
  }
  
  public final void Bn(String paramString)
  {
    this.fmI = paramString;
    this.fma = true;
  }
  
  public final void Bo(String paramString)
  {
    this.fmJ = paramString;
    this.fma = true;
  }
  
  public final void Bp(String paramString)
  {
    this.fmK = paramString;
    this.fma = true;
  }
  
  public final void Bq(String paramString)
  {
    this.fmL = paramString;
    this.fma = true;
  }
  
  public final void Br(String paramString)
  {
    this.fmM = paramString;
    this.fma = true;
  }
  
  public final void Bs(String paramString)
  {
    this.fmO = paramString;
    this.fma = true;
  }
  
  public final void Bt(String paramString)
  {
    this.fmP = paramString;
    this.fma = true;
  }
  
  public final void Bu(String paramString)
  {
    this.fmQ = paramString;
    this.fma = true;
  }
  
  public final void Bv(String paramString)
  {
    this.fmR = paramString;
    this.fma = true;
  }
  
  public final void Bw(String paramString)
  {
    this.fmS = paramString;
    this.fma = true;
  }
  
  public final void Bx(String paramString)
  {
    this.fmU = paramString;
    this.fma = true;
  }
  
  public final void By(String paramString)
  {
    this.fmW = paramString;
    this.fma = true;
  }
  
  public final void Bz(String paramString)
  {
    this.fmX = paramString;
    this.fma = true;
  }
  
  public final String ajt()
  {
    return this.fmE;
  }
  
  public final String aju()
  {
    return this.fmJ;
  }
  
  public final String ajv()
  {
    return this.fmK;
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
          if (fkj == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.fjS = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (fmg == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (fmh == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (fmi == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (fmj == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (fkR == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (fmk == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (fml == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (fjl == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (fkx == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (fmm == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (fmn == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (fmo == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (fmp == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (fmq == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (fmr == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (fms == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (fmt == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (fmu == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (fmv == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (fmw == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (fmx == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (fmy == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (fmz == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (fmA == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (fmB == k) {
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
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuff);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.fmC = paramCursor.getString();
      this.fmD = paramCursor.getString();
      this.fmE = paramCursor.getString();
      this.fmF = paramCursor.getInt();
      this.fmG = paramCursor.getInt();
      this.fmH = paramCursor.getString();
      this.fmI = paramCursor.getString();
      this.fmJ = paramCursor.getString();
      this.fmK = paramCursor.getString();
      if (!paramCursor.checkGetFinish()) {
        this.fmL = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmM = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmN = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmO = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmP = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmQ = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmR = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmS = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmT = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmU = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmV = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmW = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmX = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fmY = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.fmZ = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.fma)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.fmC);
        ((LVBuffer)localObject).putString(this.fmD);
        ((LVBuffer)localObject).putString(this.fmE);
        ((LVBuffer)localObject).putInt(this.fmF);
        ((LVBuffer)localObject).putInt(this.fmG);
        ((LVBuffer)localObject).putString(this.fmH);
        ((LVBuffer)localObject).putString(this.fmI);
        ((LVBuffer)localObject).putString(this.fmJ);
        ((LVBuffer)localObject).putString(this.fmK);
        ((LVBuffer)localObject).putString(this.fmL);
        ((LVBuffer)localObject).putString(this.fmM);
        ((LVBuffer)localObject).putInt(this.fmN);
        ((LVBuffer)localObject).putString(this.fmO);
        ((LVBuffer)localObject).putString(this.fmP);
        ((LVBuffer)localObject).putString(this.fmQ);
        ((LVBuffer)localObject).putString(this.fmR);
        ((LVBuffer)localObject).putString(this.fmS);
        ((LVBuffer)localObject).putInt(this.fmT);
        ((LVBuffer)localObject).putString(this.fmU);
        ((LVBuffer)localObject).putInt(this.fmV);
        ((LVBuffer)localObject).putString(this.fmW);
        ((LVBuffer)localObject).putString(this.fmX);
        ((LVBuffer)localObject).putString(this.fmY);
        ((LVBuffer)localObject).putInt(this.fmZ);
        this.field_lvbuff = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.fjS) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.flK) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.flL) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.flM) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.flN) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.fkN) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.flO) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.flP) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.fji) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.fkg) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.flQ) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.flR) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.flS) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.flT) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.flU) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.flV) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.flW) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.flX) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.flY) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.flZ) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.fma) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.fmb) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.fmc) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.fmd) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.fme) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.fmf) {
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
        Log.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void mZ(int paramInt)
  {
    this.fmN = paramInt;
    this.fma = true;
  }
  
  public final void na(int paramInt)
  {
    this.fmT = paramInt;
    this.fma = true;
  }
  
  public final void nb(int paramInt)
  {
    this.fmZ = paramInt;
    this.fma = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */