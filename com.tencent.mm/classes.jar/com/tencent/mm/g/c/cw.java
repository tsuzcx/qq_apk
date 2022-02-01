package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class cw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFR;
  private static final int eJY = "deviceID".hashCode();
  private static final int eJZ = "brandName".hashCode();
  private static final int eKa;
  private static final int eKb;
  private static final int eKc;
  private static final int eKd;
  private static final int eKe;
  private static final int eKf;
  private static final int eKg = "sessionKey".hashCode();
  private static final int eKh = "sessionBuf".hashCode();
  private static final int eKi = "authBuf".hashCode();
  private static final int eoZ;
  private static final int erV = "lvbuffer".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  private boolean eFF = true;
  private boolean eJN = true;
  private boolean eJO = true;
  private boolean eJP = true;
  private boolean eJQ = true;
  private boolean eJR = true;
  private boolean eJS = true;
  private boolean eJT = true;
  private boolean eJU = true;
  private boolean eJV = true;
  private boolean eJW = true;
  private boolean eJX = true;
  public int eKj;
  public int eKk;
  public long eKl;
  private long eKm;
  public String eKn;
  public String eKo;
  public String eKp;
  private int eKq;
  public int eKr;
  public long eKs;
  public String eKt;
  public String eKu;
  private String eKv;
  public String eKw;
  private boolean eoV = true;
  public boolean erH = true;
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
    eFR = "mac".hashCode();
    eKa = "deviceType".hashCode();
    eKb = "connProto".hashCode();
    eKc = "connStrategy".hashCode();
    eKd = "closeStrategy".hashCode();
    eKe = "md5Str".hashCode();
    eKf = "authKey".hashCode();
    eoZ = "url".hashCode();
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
          if (eJY == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.eJN = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eJZ == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (eFR == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (eKa == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (eKb == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (eKc == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (eKd == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (eKe == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (eKf == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (eoZ == k) {
              this.field_url = paramCursor.getString(i);
            } else if (eKg == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (eKh == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (eKi == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (erV == k) {
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
            i = paramCursor.cs(this.field_lvbuffer);
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
      if (!paramCursor.eFk()) {
        this.eKj = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eKk = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eKl = paramCursor.getLong();
      }
      if (!paramCursor.eFk()) {
        this.eKm = paramCursor.getLong();
      }
      if (!paramCursor.eFk()) {
        this.eKn = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eKo = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eKp = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eKq = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eKr = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eKs = paramCursor.getLong();
      }
      if (!paramCursor.eFk()) {
        this.eKt = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eKu = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eKv = paramCursor.getString();
      }
    } while (paramCursor.eFk());
    this.eKw = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.erH)
      {
        localObject = new aa();
        ((aa)localObject).eFl();
        ((aa)localObject).Wi(this.eKj);
        ((aa)localObject).Wi(this.eKk);
        ((aa)localObject).vC(this.eKl);
        ((aa)localObject).vC(this.eKm);
        ((aa)localObject).aFs(this.eKn);
        ((aa)localObject).aFs(this.iconUrl);
        ((aa)localObject).aFs(this.jumpUrl);
        ((aa)localObject).aFs(this.eKo);
        ((aa)localObject).aFs(this.eKp);
        ((aa)localObject).aFs(this.category);
        ((aa)localObject).Wi(this.eKq);
        ((aa)localObject).Wi(this.eKr);
        ((aa)localObject).vC(this.eKs);
        ((aa)localObject).aFs(this.eKt);
        ((aa)localObject).aFs(this.eKu);
        ((aa)localObject).aFs(this.eKv);
        ((aa)localObject).aFs(this.eKw);
        this.field_lvbuffer = ((aa)localObject).eFm();
      }
      Object localObject = new ContentValues();
      if (this.eJN) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.eJO) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.eFF) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.eJP) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.eJQ) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.eJR) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.eJS) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.eJT) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.eJU) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.eoV) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.eJV) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.eJW) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.eJX) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.erH) {
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
  
  public final void kW(long paramLong)
  {
    this.eKs = paramLong;
    this.erH = true;
  }
  
  public final void kd(int paramInt)
  {
    this.eKq = paramInt;
    this.erH = true;
  }
  
  public final void ke(int paramInt)
  {
    this.eKr = paramInt;
    this.erH = true;
  }
  
  public final void nP(String paramString)
  {
    this.iconUrl = paramString;
    this.erH = true;
  }
  
  public final void nQ(String paramString)
  {
    this.jumpUrl = paramString;
    this.erH = true;
  }
  
  public final void nR(String paramString)
  {
    this.eKo = paramString;
    this.erH = true;
  }
  
  public final void nS(String paramString)
  {
    this.eKp = paramString;
    this.erH = true;
  }
  
  public final void nT(String paramString)
  {
    this.category = paramString;
    this.erH = true;
  }
  
  public final void nU(String paramString)
  {
    this.eKt = paramString;
    this.erH = true;
  }
  
  public final void nV(String paramString)
  {
    this.eKu = paramString;
    this.erH = true;
  }
  
  public final void nW(String paramString)
  {
    this.eKv = paramString;
    this.erH = true;
  }
  
  public final void nX(String paramString)
  {
    this.eKw = paramString;
    this.erH = true;
  }
  
  public final void na(String paramString)
  {
    this.eKn = paramString;
    this.erH = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */