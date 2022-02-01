package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class di
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIm;
  private static final int eLh = "lvbuffer".hashCode();
  private static final int faV;
  private static final int ffm = "deviceID".hashCode();
  private static final int ffn = "brandName".hashCode();
  private static final int ffo;
  private static final int ffp;
  private static final int ffq;
  private static final int ffr;
  private static final int ffs;
  private static final int fft;
  private static final int ffu;
  private static final int ffv;
  private static final int ffw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  private boolean eIi = true;
  public boolean eKU = true;
  private boolean faJ = true;
  private long ffA;
  public String ffB;
  public String ffC;
  public String ffD;
  private int ffE;
  public int ffF;
  public long ffG;
  public String ffH;
  public String ffI;
  private String ffJ;
  public String ffK;
  private boolean ffb = true;
  private boolean ffc = true;
  private boolean ffd = true;
  private boolean ffe = true;
  private boolean fff = true;
  private boolean ffg = true;
  private boolean ffh = true;
  private boolean ffi = true;
  private boolean ffj = true;
  private boolean ffk = true;
  private boolean ffl = true;
  public int ffx;
  public int ffy;
  public long ffz;
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
    faV = "mac".hashCode();
    ffo = "deviceType".hashCode();
    ffp = "connProto".hashCode();
    ffq = "connStrategy".hashCode();
    ffr = "closeStrategy".hashCode();
    ffs = "md5Str".hashCode();
    fft = "authKey".hashCode();
    eIm = "url".hashCode();
    ffu = "sessionKey".hashCode();
    ffv = "sessionBuf".hashCode();
    ffw = "authBuf".hashCode();
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
          if (ffm == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.ffb = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (ffn == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (faV == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (ffo == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (ffp == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (ffq == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (ffr == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (ffs == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (fft == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (eIm == k) {
              this.field_url = paramCursor.getString(i);
            } else if (ffu == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (ffv == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (ffw == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (eLh == k) {
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
            paramCursor = new aa();
            i = paramCursor.cy(this.field_lvbuffer);
            if (i != 0)
            {
              ad.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ad.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.fki()) {
        this.ffx = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.ffy = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.ffz = paramCursor.getLong();
      }
      if (!paramCursor.fki()) {
        this.ffA = paramCursor.getLong();
      }
      if (!paramCursor.fki()) {
        this.ffB = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.ffC = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.ffD = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.ffE = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.ffF = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.ffG = paramCursor.getLong();
      }
      if (!paramCursor.fki()) {
        this.ffH = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.ffI = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.ffJ = paramCursor.getString();
      }
    } while (paramCursor.fki());
    this.ffK = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eKU)
      {
        localObject = new aa();
        ((aa)localObject).fkj();
        ((aa)localObject).aaw(this.ffx);
        ((aa)localObject).aaw(this.ffy);
        ((aa)localObject).CV(this.ffz);
        ((aa)localObject).CV(this.ffA);
        ((aa)localObject).aQp(this.ffB);
        ((aa)localObject).aQp(this.iconUrl);
        ((aa)localObject).aQp(this.jumpUrl);
        ((aa)localObject).aQp(this.ffC);
        ((aa)localObject).aQp(this.ffD);
        ((aa)localObject).aQp(this.category);
        ((aa)localObject).aaw(this.ffE);
        ((aa)localObject).aaw(this.ffF);
        ((aa)localObject).CV(this.ffG);
        ((aa)localObject).aQp(this.ffH);
        ((aa)localObject).aQp(this.ffI);
        ((aa)localObject).aQp(this.ffJ);
        ((aa)localObject).aQp(this.ffK);
        this.field_lvbuffer = ((aa)localObject).fkk();
      }
      Object localObject = new ContentValues();
      if (this.ffb) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.ffc) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.faJ) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.ffd) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.ffe) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.fff) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.ffg) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.ffh) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.ffi) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.eIi) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.ffj) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.ffk) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.ffl) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.eKU) {
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
        ad.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void kA(int paramInt)
  {
    this.ffF = paramInt;
    this.eKU = true;
  }
  
  public final void kz(int paramInt)
  {
    this.ffE = paramInt;
    this.eKU = true;
  }
  
  public final void qy(long paramLong)
  {
    this.ffG = paramLong;
    this.eKU = true;
  }
  
  public final void sQ(String paramString)
  {
    this.ffB = paramString;
    this.eKU = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.eKU = true;
  }
  
  public final void tF(String paramString)
  {
    this.jumpUrl = paramString;
    this.eKU = true;
  }
  
  public final void tG(String paramString)
  {
    this.ffC = paramString;
    this.eKU = true;
  }
  
  public final void tH(String paramString)
  {
    this.ffD = paramString;
    this.eKU = true;
  }
  
  public final void tI(String paramString)
  {
    this.category = paramString;
    this.eKU = true;
  }
  
  public final void tJ(String paramString)
  {
    this.ffH = paramString;
    this.eKU = true;
  }
  
  public final void tK(String paramString)
  {
    this.ffI = paramString;
    this.eKU = true;
  }
  
  public final void tL(String paramString)
  {
    this.ffJ = paramString;
    this.eKU = true;
  }
  
  public final void tM(String paramString)
  {
    this.ffK = paramString;
    this.eKU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.di
 * JD-Core Version:    0.7.0.1
 */