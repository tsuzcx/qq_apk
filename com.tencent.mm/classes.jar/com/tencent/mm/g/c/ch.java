package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class ch
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dCA;
  private static final int dCB;
  private static final int dCC = "sessionKey".hashCode();
  private static final int dCD = "sessionBuf".hashCode();
  private static final int dCE = "authBuf".hashCode();
  private static final int dCu = "deviceID".hashCode();
  private static final int dCv = "brandName".hashCode();
  private static final int dCw;
  private static final int dCx;
  private static final int dCy;
  private static final int dCz;
  private static final int dkC;
  private static final int dnj = "lvbuffer".hashCode();
  private static final int dzh = "mac".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  public int dCF;
  public int dCG;
  public long dCH;
  private long dCI;
  public String dCJ;
  public String dCK;
  public String dCL;
  private int dCM;
  public int dCN;
  public long dCO;
  public String dCP;
  public String dCQ;
  private String dCR;
  public String dCS;
  private boolean dCj = true;
  private boolean dCk = true;
  private boolean dCl = true;
  private boolean dCm = true;
  private boolean dCn = true;
  private boolean dCo = true;
  private boolean dCp = true;
  private boolean dCq = true;
  private boolean dCr = true;
  private boolean dCs = true;
  private boolean dCt = true;
  private boolean dky = true;
  public boolean dmY = true;
  private boolean dyV = true;
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
    dCw = "deviceType".hashCode();
    dCx = "connProto".hashCode();
    dCy = "connStrategy".hashCode();
    dCz = "closeStrategy".hashCode();
    dCA = "md5Str".hashCode();
    dCB = "authKey".hashCode();
    dkC = "url".hashCode();
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
          if (dCu == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.dCj = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (dCv == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (dzh == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (dCw == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (dCx == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (dCy == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (dCz == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (dCA == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (dCB == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (dkC == k) {
              this.field_url = paramCursor.getString(i);
            } else if (dCC == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (dCD == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (dCE == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (dnj == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new y();
            i = paramCursor.ca(this.field_lvbuffer);
            if (i != 0)
            {
              ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.dsu()) {
        this.dCF = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dCG = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dCH = paramCursor.getLong();
      }
      if (!paramCursor.dsu()) {
        this.dCI = paramCursor.getLong();
      }
      if (!paramCursor.dsu()) {
        this.dCJ = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dCK = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dCL = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dCM = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dCN = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dCO = paramCursor.getLong();
      }
      if (!paramCursor.dsu()) {
        this.dCP = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dCQ = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dCR = paramCursor.getString();
      }
    } while (paramCursor.dsu());
    this.dCS = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.dmY)
      {
        localObject = new y();
        ((y)localObject).dsv();
        ((y)localObject).Nd(this.dCF);
        ((y)localObject).Nd(this.dCG);
        ((y)localObject).nN(this.dCH);
        ((y)localObject).nN(this.dCI);
        ((y)localObject).ape(this.dCJ);
        ((y)localObject).ape(this.iconUrl);
        ((y)localObject).ape(this.jumpUrl);
        ((y)localObject).ape(this.dCK);
        ((y)localObject).ape(this.dCL);
        ((y)localObject).ape(this.category);
        ((y)localObject).Nd(this.dCM);
        ((y)localObject).Nd(this.dCN);
        ((y)localObject).nN(this.dCO);
        ((y)localObject).ape(this.dCP);
        ((y)localObject).ape(this.dCQ);
        ((y)localObject).ape(this.dCR);
        ((y)localObject).ape(this.dCS);
        this.field_lvbuffer = ((y)localObject).dsw();
      }
      Object localObject = new ContentValues();
      if (this.dCj) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.dCk) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.dyV) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.dCl) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.dCm) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.dCn) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.dCo) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.dCp) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.dCq) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.dky) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.dCr) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.dCs) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.dCt) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.dmY) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
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
        ab.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void fO(long paramLong)
  {
    this.dCO = paramLong;
    this.dmY = true;
  }
  
  public final void hS(int paramInt)
  {
    this.dCM = paramInt;
    this.dmY = true;
  }
  
  public final void hT(int paramInt)
  {
    this.dCN = paramInt;
    this.dmY = true;
  }
  
  public final void jm(String paramString)
  {
    this.dCJ = paramString;
    this.dmY = true;
  }
  
  public final void ka(String paramString)
  {
    this.iconUrl = paramString;
    this.dmY = true;
  }
  
  public final void kb(String paramString)
  {
    this.jumpUrl = paramString;
    this.dmY = true;
  }
  
  public final void kc(String paramString)
  {
    this.dCK = paramString;
    this.dmY = true;
  }
  
  public final void kd(String paramString)
  {
    this.dCL = paramString;
    this.dmY = true;
  }
  
  public final void ke(String paramString)
  {
    this.category = paramString;
    this.dmY = true;
  }
  
  public final void kf(String paramString)
  {
    this.dCP = paramString;
    this.dmY = true;
  }
  
  public final void kg(String paramString)
  {
    this.dCQ = paramString;
    this.dmY = true;
  }
  
  public final void kh(String paramString)
  {
    this.dCR = paramString;
    this.dmY = true;
  }
  
  public final void ki(String paramString)
  {
    this.dCS = paramString;
    this.dmY = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ch
 * JD-Core Version:    0.7.0.1
 */