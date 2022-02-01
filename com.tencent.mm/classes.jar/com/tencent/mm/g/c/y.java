package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class y
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
  private static final int eEL = "status".hashCode();
  private static final int eGD = "appId".hashCode();
  private static final int eGR = "signature".hashCode();
  private static final int eHp;
  private static final int eIE = "appName".hashCode();
  private static final int eIF = "appDiscription".hashCode();
  private static final int eIG = "appIconUrl".hashCode();
  private static final int eIH = "appStoreUrl".hashCode();
  private static final int eII;
  private static final int eIJ;
  private static final int eIK = "modifyTime".hashCode();
  private static final int eIL = "appName_en".hashCode();
  private static final int eIM = "appName_tw".hashCode();
  private static final int eIN = "appName_hk".hashCode();
  private static final int eIO = "appDiscription_en".hashCode();
  private static final int eIP = "appDiscription_tw".hashCode();
  private static final int eIQ = "appType".hashCode();
  private static final int eIR = "openId".hashCode();
  private static final int eIS = "authFlag".hashCode();
  private static final int eIT = "appInfoFlag".hashCode();
  private static final int eIU = "lvbuff".hashCode();
  private static final int eIV = "serviceAppType".hashCode();
  private static final int eIW = "serviceAppInfoFlag".hashCode();
  private static final int eIX = "serviceShowFlag".hashCode();
  private static final int eIY = "appSupportContentType".hashCode();
  private static final int eIZ = "svrAppSupportContentType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGA = true;
  private boolean eGm = true;
  private boolean eHl = true;
  private boolean eIA = true;
  private boolean eIB = true;
  private boolean eIC = true;
  private boolean eID = true;
  private boolean eIi = true;
  private boolean eIj = true;
  private boolean eIk = true;
  private boolean eIl = true;
  private boolean eIm = true;
  private boolean eIn = true;
  private boolean eIo = true;
  private boolean eIp = true;
  private boolean eIq = true;
  private boolean eIr = true;
  private boolean eIs = true;
  private boolean eIt = true;
  private boolean eIu = true;
  private boolean eIv = true;
  private boolean eIw = true;
  private boolean eIx = true;
  public boolean eIy = true;
  private boolean eIz = true;
  protected String eJa;
  private String eJb;
  public String eJc;
  public int eJd;
  public int eJe;
  public String eJf;
  public String eJg;
  public String eJh;
  public String eJi;
  public String eJj;
  public String eJk;
  public int eJl;
  public String eJm;
  public String eJn;
  public String eJo;
  public String eJp;
  private String eJq;
  public int eJr;
  private String eJs;
  private int eJt;
  public String eJu;
  public String eJv;
  public String eJw;
  public int eJx;
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
    eHp = "appVersion".hashCode();
    eII = "appWatermarkUrl".hashCode();
    eIJ = "packageName".hashCode();
  }
  
  public final String VE()
  {
    return this.eJc;
  }
  
  public final String VF()
  {
    return this.eJh;
  }
  
  public final String VG()
  {
    return this.eJi;
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
          if (eGD == k)
          {
            this.field_appId = paramCursor.getString(i);
            this.eGm = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eIE == k) {
              this.field_appName = paramCursor.getString(i);
            } else if (eIF == k) {
              this.field_appDiscription = paramCursor.getString(i);
            } else if (eIG == k) {
              this.field_appIconUrl = paramCursor.getString(i);
            } else if (eIH == k) {
              this.field_appStoreUrl = paramCursor.getString(i);
            } else if (eHp == k) {
              this.field_appVersion = paramCursor.getInt(i);
            } else if (eII == k) {
              this.field_appWatermarkUrl = paramCursor.getString(i);
            } else if (eIJ == k) {
              this.field_packageName = paramCursor.getString(i);
            } else if (eEL == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (eGR == k) {
              this.field_signature = paramCursor.getString(i);
            } else if (eIK == k) {
              this.field_modifyTime = paramCursor.getLong(i);
            } else if (eIL == k) {
              this.field_appName_en = paramCursor.getString(i);
            } else if (eIM == k) {
              this.field_appName_tw = paramCursor.getString(i);
            } else if (eIN == k) {
              this.field_appName_hk = paramCursor.getString(i);
            } else if (eIO == k) {
              this.field_appDiscription_en = paramCursor.getString(i);
            } else if (eIP == k) {
              this.field_appDiscription_tw = paramCursor.getString(i);
            } else if (eIQ == k) {
              this.field_appType = paramCursor.getString(i);
            } else if (eIR == k) {
              this.field_openId = paramCursor.getString(i);
            } else if (eIS == k) {
              this.field_authFlag = paramCursor.getInt(i);
            } else if (eIT == k) {
              this.field_appInfoFlag = paramCursor.getInt(i);
            } else if (eIU == k) {
              this.field_lvbuff = paramCursor.getBlob(i);
            } else if (eIV == k) {
              this.field_serviceAppType = paramCursor.getInt(i);
            } else if (eIW == k) {
              this.field_serviceAppInfoFlag = paramCursor.getInt(i);
            } else if (eIX == k) {
              this.field_serviceShowFlag = paramCursor.getInt(i);
            } else if (eIY == k) {
              this.field_appSupportContentType = paramCursor.getLong(i);
            } else if (eIZ == k) {
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
            paramCursor = new ab();
            i = paramCursor.cB(this.field_lvbuff);
            if (i != 0)
            {
              ae.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ae.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
          return;
        }
      }
      this.eJa = paramCursor.getString();
      this.eJb = paramCursor.getString();
      this.eJc = paramCursor.getString();
      this.eJd = paramCursor.getInt();
      this.eJe = paramCursor.getInt();
      this.eJf = paramCursor.getString();
      this.eJg = paramCursor.getString();
      this.eJh = paramCursor.getString();
      this.eJi = paramCursor.getString();
      if (!paramCursor.foc()) {
        this.eJj = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJk = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJl = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.eJm = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJn = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJo = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJp = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJq = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJr = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.eJs = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJt = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.eJu = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJv = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eJw = paramCursor.getString();
      }
    } while (paramCursor.foc());
    this.eJx = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eIy)
      {
        localObject = new ab();
        ((ab)localObject).fod();
        ((ab)localObject).aRM(this.eJa);
        ((ab)localObject).aRM(this.eJb);
        ((ab)localObject).aRM(this.eJc);
        ((ab)localObject).abc(this.eJd);
        ((ab)localObject).abc(this.eJe);
        ((ab)localObject).aRM(this.eJf);
        ((ab)localObject).aRM(this.eJg);
        ((ab)localObject).aRM(this.eJh);
        ((ab)localObject).aRM(this.eJi);
        ((ab)localObject).aRM(this.eJj);
        ((ab)localObject).aRM(this.eJk);
        ((ab)localObject).abc(this.eJl);
        ((ab)localObject).aRM(this.eJm);
        ((ab)localObject).aRM(this.eJn);
        ((ab)localObject).aRM(this.eJo);
        ((ab)localObject).aRM(this.eJp);
        ((ab)localObject).aRM(this.eJq);
        ((ab)localObject).abc(this.eJr);
        ((ab)localObject).aRM(this.eJs);
        ((ab)localObject).abc(this.eJt);
        ((ab)localObject).aRM(this.eJu);
        ((ab)localObject).aRM(this.eJv);
        ((ab)localObject).aRM(this.eJw);
        ((ab)localObject).abc(this.eJx);
        this.field_lvbuff = ((ab)localObject).foe();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.eGm) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.eIi) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.eIj) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.eIk) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.eIl) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.eHl) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.eIm) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.eIn) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.eEI) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.eGA) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.eIo) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.eIp) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.eIq) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.eIr) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.eIs) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.eIt) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.eIu) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.eIv) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.eIw) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.eIx) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.eIy) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.eIz) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.eIA) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.eIB) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.eIC) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.eID) {
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
        ae.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void jX(int paramInt)
  {
    this.eJl = paramInt;
    this.eIy = true;
  }
  
  public final void jY(int paramInt)
  {
    this.eJr = paramInt;
    this.eIy = true;
  }
  
  public final void jZ(int paramInt)
  {
    this.eJx = paramInt;
    this.eIy = true;
  }
  
  public final void sT(String paramString)
  {
    this.eJb = paramString;
    this.eIy = true;
  }
  
  public final void sU(String paramString)
  {
    this.eJc = paramString;
    this.eIy = true;
  }
  
  public final void sV(String paramString)
  {
    this.eJf = paramString;
    this.eIy = true;
  }
  
  public final void sW(String paramString)
  {
    this.eJg = paramString;
    this.eIy = true;
  }
  
  public final void sX(String paramString)
  {
    this.eJh = paramString;
    this.eIy = true;
  }
  
  public final void sY(String paramString)
  {
    this.eJi = paramString;
    this.eIy = true;
  }
  
  public final void sZ(String paramString)
  {
    this.eJj = paramString;
    this.eIy = true;
  }
  
  public final void ta(String paramString)
  {
    this.eJk = paramString;
    this.eIy = true;
  }
  
  public final void tb(String paramString)
  {
    this.eJm = paramString;
    this.eIy = true;
  }
  
  public final void tc(String paramString)
  {
    this.eJn = paramString;
    this.eIy = true;
  }
  
  public final void td(String paramString)
  {
    this.eJo = paramString;
    this.eIy = true;
  }
  
  public final void te(String paramString)
  {
    this.eJp = paramString;
    this.eIy = true;
  }
  
  public final void tf(String paramString)
  {
    this.eJq = paramString;
    this.eIy = true;
  }
  
  public final void tg(String paramString)
  {
    this.eJs = paramString;
    this.eIy = true;
  }
  
  public final void th(String paramString)
  {
    this.eJu = paramString;
    this.eIy = true;
  }
  
  public final void ti(String paramString)
  {
    this.eJv = paramString;
    this.eIy = true;
  }
  
  public final void tj(String paramString)
  {
    this.eJw = paramString;
    this.eIy = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.y
 * JD-Core Version:    0.7.0.1
 */