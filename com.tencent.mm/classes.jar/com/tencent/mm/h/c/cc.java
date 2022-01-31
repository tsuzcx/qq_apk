package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public abstract class cc
  extends c
{
  private static final int cJX;
  private static final int cME;
  private static final int cMF;
  private static final int cMG;
  private static final int cMH;
  private static final int cMI;
  private static final int cMJ;
  private static final int cMK;
  private static final int cML;
  private static final int cMM;
  private static final int cMN;
  private static final int cMO;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwu;
  private static final int czi;
  private boolean cJK = true;
  private boolean cMA = true;
  private boolean cMB = true;
  private boolean cMC = true;
  private boolean cMD = true;
  public int cMP;
  public int cMQ;
  public long cMR;
  private long cMS;
  public String cMT;
  public String cMU;
  public String cMV;
  private int cMW;
  public int cMX;
  public long cMY;
  public String cMZ;
  private boolean cMt = true;
  private boolean cMu = true;
  private boolean cMv = true;
  private boolean cMw = true;
  private boolean cMx = true;
  private boolean cMy = true;
  private boolean cMz = true;
  public String cNa;
  private String cNb;
  public String cNc;
  public String category;
  private boolean cwp = true;
  public boolean cyX = true;
  public byte[] field_authBuf;
  public String field_authKey;
  public String field_brandName;
  public int field_closeStrategy;
  public String field_connProto;
  public int field_connStrategy;
  public String field_deviceID;
  public String field_deviceType;
  public byte[] field_lvbuffer;
  public long field_mac;
  public String field_md5Str;
  public byte[] field_sessionBuf;
  public byte[] field_sessionKey;
  public String field_url;
  public String iconUrl;
  public String jumpUrl;
  
  static
  {
    cME = "deviceID".hashCode();
    cMF = "brandName".hashCode();
    cJX = "mac".hashCode();
    cMG = "deviceType".hashCode();
    cMH = "connProto".hashCode();
    cMI = "connStrategy".hashCode();
    cMJ = "closeStrategy".hashCode();
    cMK = "md5Str".hashCode();
    cML = "authKey".hashCode();
    cwu = "url".hashCode();
    cMM = "sessionKey".hashCode();
    cMN = "sessionBuf".hashCode();
    cMO = "authBuf".hashCode();
    czi = "lvbuffer".hashCode();
  }
  
  public final void be(long paramLong)
  {
    this.cMY = paramLong;
    this.cyX = true;
  }
  
  public final void cZ(String paramString)
  {
    this.cMT = paramString;
    this.cyX = true;
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
          if (cME == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.cMt = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (cMF == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (cJX == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (cMG == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (cMH == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (cMI == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (cMJ == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (cMK == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (cML == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (cwu == k) {
              this.field_url = paramCursor.getString(i);
            } else if (cMM == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (cMN == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (cMO == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (czi == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (crh == k) {
              this.ujK = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new v();
            i = paramCursor.bA(this.field_lvbuffer);
            if (i != 0)
            {
              y.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + i);
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          y.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.cqx()) {
        this.cMP = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cMQ = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cMR = paramCursor.getLong();
      }
      if (!paramCursor.cqx()) {
        this.cMS = paramCursor.getLong();
      }
      if (!paramCursor.cqx()) {
        this.cMT = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cMU = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cMV = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cMW = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cMX = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cMY = paramCursor.getLong();
      }
      if (!paramCursor.cqx()) {
        this.cMZ = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cNa = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cNb = paramCursor.getString();
      }
    } while (paramCursor.cqx());
    this.cNc = paramCursor.getString();
  }
  
  public final void dU(String paramString)
  {
    this.jumpUrl = paramString;
    this.cyX = true;
  }
  
  public final void dV(String paramString)
  {
    this.cMU = paramString;
    this.cyX = true;
  }
  
  public final void dW(String paramString)
  {
    this.cMV = paramString;
    this.cyX = true;
  }
  
  public final void dX(String paramString)
  {
    this.category = paramString;
    this.cyX = true;
  }
  
  public final void dY(String paramString)
  {
    this.cMZ = paramString;
    this.cyX = true;
  }
  
  public final void dZ(String paramString)
  {
    this.cNa = paramString;
    this.cyX = true;
  }
  
  public final void ea(String paramString)
  {
    this.cNb = paramString;
    this.cyX = true;
  }
  
  public final void eb(String paramString)
  {
    this.cNc = paramString;
    this.cyX = true;
  }
  
  public final void fH(int paramInt)
  {
    this.cMW = paramInt;
    this.cyX = true;
  }
  
  public final void fI(int paramInt)
  {
    this.cMX = paramInt;
    this.cyX = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.cyX = true;
  }
  
  public final ContentValues vf()
  {
    try
    {
      if (this.cyX)
      {
        localObject = new v();
        ((v)localObject).cqy();
        ((v)localObject).Fb(this.cMP);
        ((v)localObject).Fb(this.cMQ);
        ((v)localObject).ho(this.cMR);
        ((v)localObject).ho(this.cMS);
        ((v)localObject).Zg(this.cMT);
        ((v)localObject).Zg(this.iconUrl);
        ((v)localObject).Zg(this.jumpUrl);
        ((v)localObject).Zg(this.cMU);
        ((v)localObject).Zg(this.cMV);
        ((v)localObject).Zg(this.category);
        ((v)localObject).Fb(this.cMW);
        ((v)localObject).Fb(this.cMX);
        ((v)localObject).ho(this.cMY);
        ((v)localObject).Zg(this.cMZ);
        ((v)localObject).Zg(this.cNa);
        ((v)localObject).Zg(this.cNb);
        ((v)localObject).Zg(this.cNc);
        this.field_lvbuffer = ((v)localObject).cqz();
      }
      Object localObject = new ContentValues();
      if (this.cMt) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.cMu) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.cJK) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.cMv) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.cMw) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.cMx) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.cMy) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.cMz) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.cMA) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.cwp) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.cMB) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.cMC) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.cMD) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.cyX) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
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
        y.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.cc
 * JD-Core Version:    0.7.0.1
 */