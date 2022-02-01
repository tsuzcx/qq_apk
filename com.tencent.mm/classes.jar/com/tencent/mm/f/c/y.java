package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class y
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  public static final SingleTable TABLE = new SingleTable("AppInfo");
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnN;
  public static final Column hnz;
  public static final Column hoR;
  private static final int hoZ;
  private static final int hoh;
  private static final int hov;
  public static final Column hqA;
  public static final Column hqB;
  public static final Column hqC;
  public static final Column hqD;
  public static final Column hqE;
  public static final Column hqF;
  public static final Column hqG;
  public static final Column hqH;
  public static final Column hqI;
  public static final Column hqn;
  public static final Column hqo;
  public static final Column hqp;
  public static final Column hqq;
  public static final Column hqr;
  public static final Column hqs;
  public static final Column hqt;
  public static final Column hqu;
  public static final Column hqv;
  public static final Column hqw;
  public static final Column hqx;
  public static final Column hqy;
  public static final Column hqz;
  private static final int hrA = "svrAppSupportContentType".hashCode();
  private static final int hrf;
  private static final int hrg;
  private static final int hrh;
  private static final int hri;
  private static final int hrj;
  private static final int hrk;
  private static final int hrl;
  private static final int hrm;
  private static final int hrn;
  private static final int hro;
  private static final int hrp;
  private static final int hrq;
  private static final int hrr;
  private static final int hrs;
  private static final int hrt;
  private static final int hru;
  private static final int hrv;
  private static final int hrw;
  private static final int hrx;
  private static final int hry;
  private static final int hrz;
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
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean hoV = true;
  private boolean hoe = true;
  private boolean hqJ = true;
  private boolean hqK = true;
  private boolean hqL = true;
  private boolean hqM = true;
  private boolean hqN = true;
  private boolean hqO = true;
  private boolean hqP = true;
  private boolean hqQ = true;
  private boolean hqR = true;
  private boolean hqS = true;
  private boolean hqT = true;
  private boolean hqU = true;
  private boolean hqV = true;
  private boolean hqW = true;
  private boolean hqX = true;
  private boolean hqY = true;
  public boolean hqZ = true;
  private String hrB;
  private String hrC;
  public String hrD;
  public int hrE;
  public int hrF;
  public String hrG;
  public String hrH;
  public String hrI;
  public String hrJ;
  public String hrK;
  public String hrL;
  public int hrM;
  public String hrN;
  public String hrO;
  public String hrP;
  public String hrQ;
  private String hrR;
  public int hrS;
  private String hrT;
  private int hrU;
  public String hrV;
  public String hrW;
  public String hrX;
  public int hrY;
  private boolean hra = true;
  private boolean hrb = true;
  private boolean hrc = true;
  private boolean hrd = true;
  private boolean hre = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppInfo", "");
    hnz = new Column("appid", "string", "AppInfo", "");
    hqn = new Column("appname", "string", "AppInfo", "");
    hqo = new Column("appdiscription", "string", "AppInfo", "");
    hqp = new Column("appiconurl", "string", "AppInfo", "");
    hqq = new Column("appstoreurl", "string", "AppInfo", "");
    hoR = new Column("appversion", "int", "AppInfo", "");
    hqr = new Column("appwatermarkurl", "string", "AppInfo", "");
    hqs = new Column("packagename", "string", "AppInfo", "");
    hmw = new Column("status", "int", "AppInfo", "");
    hnN = new Column("signature", "string", "AppInfo", "");
    hqt = new Column("modifytime", "long", "AppInfo", "");
    hqu = new Column("appname_en", "string", "AppInfo", "");
    hqv = new Column("appname_tw", "string", "AppInfo", "");
    hqw = new Column("appname_hk", "string", "AppInfo", "");
    hqx = new Column("appdiscription_en", "string", "AppInfo", "");
    hqy = new Column("appdiscription_tw", "string", "AppInfo", "");
    hqz = new Column("apptype", "string", "AppInfo", "");
    hqA = new Column("openid", "string", "AppInfo", "");
    hqB = new Column("authflag", "int", "AppInfo", "");
    hqC = new Column("appinfoflag", "int", "AppInfo", "");
    hqD = new Column("lvbuff", "byte[]", "AppInfo", "");
    hqE = new Column("serviceapptype", "int", "AppInfo", "");
    hqF = new Column("serviceappinfoflag", "int", "AppInfo", "");
    hqG = new Column("serviceshowflag", "int", "AppInfo", "");
    hqH = new Column("appsupportcontenttype", "long", "AppInfo", "");
    hqI = new Column("svrappsupportcontenttype", "long", "AppInfo", "");
    hoh = "appId".hashCode();
    hrf = "appName".hashCode();
    hrg = "appDiscription".hashCode();
    hrh = "appIconUrl".hashCode();
    hri = "appStoreUrl".hashCode();
    hoZ = "appVersion".hashCode();
    hrj = "appWatermarkUrl".hashCode();
    hrk = "packageName".hashCode();
    hmC = "status".hashCode();
    hov = "signature".hashCode();
    hrl = "modifyTime".hashCode();
    hrm = "appName_en".hashCode();
    hrn = "appName_tw".hashCode();
    hro = "appName_hk".hashCode();
    hrp = "appDiscription_en".hashCode();
    hrq = "appDiscription_tw".hashCode();
    hrr = "appType".hashCode();
    hrs = "openId".hashCode();
    hrt = "authFlag".hashCode();
    hru = "appInfoFlag".hashCode();
    hrv = "lvbuff".hashCode();
    hrw = "serviceAppType".hashCode();
    hrx = "serviceAppInfoFlag".hashCode();
    hry = "serviceShowFlag".hashCode();
    hrz = "appSupportContentType".hashCode();
  }
  
  public final void HX(String paramString)
  {
    this.hrB = paramString;
    this.hqZ = true;
  }
  
  public final void HY(String paramString)
  {
    this.hrC = paramString;
    this.hqZ = true;
  }
  
  public final void HZ(String paramString)
  {
    this.hrD = paramString;
    this.hqZ = true;
  }
  
  public final void Ia(String paramString)
  {
    this.hrG = paramString;
    this.hqZ = true;
  }
  
  public final void Ib(String paramString)
  {
    this.hrH = paramString;
    this.hqZ = true;
  }
  
  public final void Ic(String paramString)
  {
    this.hrI = paramString;
    this.hqZ = true;
  }
  
  public final void Id(String paramString)
  {
    this.hrJ = paramString;
    this.hqZ = true;
  }
  
  public final void Ie(String paramString)
  {
    this.hrK = paramString;
    this.hqZ = true;
  }
  
  public final void If(String paramString)
  {
    this.hrL = paramString;
    this.hqZ = true;
  }
  
  public final void Ig(String paramString)
  {
    this.hrN = paramString;
    this.hqZ = true;
  }
  
  public final void Ih(String paramString)
  {
    this.hrO = paramString;
    this.hqZ = true;
  }
  
  public final void Ii(String paramString)
  {
    this.hrP = paramString;
    this.hqZ = true;
  }
  
  public final void Ij(String paramString)
  {
    this.hrQ = paramString;
    this.hqZ = true;
  }
  
  public final void Ik(String paramString)
  {
    this.hrR = paramString;
    this.hqZ = true;
  }
  
  public final void Il(String paramString)
  {
    this.hrT = paramString;
    this.hqZ = true;
  }
  
  public final void Im(String paramString)
  {
    this.hrV = paramString;
    this.hqZ = true;
  }
  
  public final void In(String paramString)
  {
    this.hrW = paramString;
    this.hqZ = true;
  }
  
  public final void Io(String paramString)
  {
    this.hrX = paramString;
    this.hqZ = true;
  }
  
  public final String aoZ()
  {
    return this.hrD;
  }
  
  public final String apa()
  {
    return this.hrI;
  }
  
  public final String apb()
  {
    return this.hrJ;
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
          if (hoh == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.hnQ = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (hrf == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (hrg == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (hrh == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (hri == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (hoZ == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (hrj == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (hrk == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (hmC == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (hov == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (hrl == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (hrm == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (hrn == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (hro == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (hrp == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (hrq == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (hrr == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (hrs == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (hrt == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (hru == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (hrv == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (hrw == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (hrx == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (hry == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (hrz == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (hrA == k) {
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
      this.hrB = paramCursor.getString();
      this.hrC = paramCursor.getString();
      this.hrD = paramCursor.getString();
      this.hrE = paramCursor.getInt();
      this.hrF = paramCursor.getInt();
      this.hrG = paramCursor.getString();
      this.hrH = paramCursor.getString();
      this.hrI = paramCursor.getString();
      this.hrJ = paramCursor.getString();
      if (!paramCursor.checkGetFinish()) {
        this.hrK = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrL = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrM = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrN = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrO = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrP = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrQ = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrR = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrS = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrT = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrU = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrV = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrW = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hrX = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.hrY = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.hqZ)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.hrB);
        ((LVBuffer)localObject).putString(this.hrC);
        ((LVBuffer)localObject).putString(this.hrD);
        ((LVBuffer)localObject).putInt(this.hrE);
        ((LVBuffer)localObject).putInt(this.hrF);
        ((LVBuffer)localObject).putString(this.hrG);
        ((LVBuffer)localObject).putString(this.hrH);
        ((LVBuffer)localObject).putString(this.hrI);
        ((LVBuffer)localObject).putString(this.hrJ);
        ((LVBuffer)localObject).putString(this.hrK);
        ((LVBuffer)localObject).putString(this.hrL);
        ((LVBuffer)localObject).putInt(this.hrM);
        ((LVBuffer)localObject).putString(this.hrN);
        ((LVBuffer)localObject).putString(this.hrO);
        ((LVBuffer)localObject).putString(this.hrP);
        ((LVBuffer)localObject).putString(this.hrQ);
        ((LVBuffer)localObject).putString(this.hrR);
        ((LVBuffer)localObject).putInt(this.hrS);
        ((LVBuffer)localObject).putString(this.hrT);
        ((LVBuffer)localObject).putInt(this.hrU);
        ((LVBuffer)localObject).putString(this.hrV);
        ((LVBuffer)localObject).putString(this.hrW);
        ((LVBuffer)localObject).putString(this.hrX);
        ((LVBuffer)localObject).putInt(this.hrY);
        this.field_lvbuff = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.hnQ) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.hqJ) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.hqK) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.hqL) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.hqM) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.hoV) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.hqN) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.hqO) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.hmz) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.hoe) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.hqP) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.hqQ) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.hqR) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.hqS) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.hqT) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.hqU) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.hqV) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.hqW) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.hqX) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.hqY) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.hqZ) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.hra) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.hrb) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.hrc) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.hrd) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.hre) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "AppInfo";
  }
  
  public final void pm(int paramInt)
  {
    this.hrM = paramInt;
    this.hqZ = true;
  }
  
  public final void pn(int paramInt)
  {
    this.hrS = paramInt;
    this.hqZ = true;
  }
  
  public final void po(int paramInt)
  {
    this.hrY = paramInt;
    this.hqZ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.y
 * JD-Core Version:    0.7.0.1
 */