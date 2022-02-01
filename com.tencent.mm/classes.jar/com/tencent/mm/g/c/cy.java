package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;

public abstract class cy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIJ;
  private static final int eMQ = "deviceID".hashCode();
  private static final int eMR = "brandName".hashCode();
  private static final int eMS;
  private static final int eMT;
  private static final int eMU;
  private static final int eMV;
  private static final int eMW;
  private static final int eMX;
  private static final int eMY = "sessionKey".hashCode();
  private static final int eMZ = "sessionBuf".hashCode();
  private static final int eNa = "authBuf".hashCode();
  private static final int erd;
  private static final int etZ = "lvbuffer".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  private boolean eIx = true;
  private boolean eMF = true;
  private boolean eMG = true;
  private boolean eMH = true;
  private boolean eMI = true;
  private boolean eMJ = true;
  private boolean eMK = true;
  private boolean eML = true;
  private boolean eMM = true;
  private boolean eMN = true;
  private boolean eMO = true;
  private boolean eMP = true;
  public int eNb;
  public int eNc;
  public long eNd;
  private long eNe;
  public String eNf;
  public String eNg;
  public String eNh;
  private int eNi;
  public int eNj;
  public long eNk;
  public String eNl;
  public String eNm;
  private String eNn;
  public String eNo;
  private boolean eqZ = true;
  public boolean etL = true;
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
    eIJ = "mac".hashCode();
    eMS = "deviceType".hashCode();
    eMT = "connProto".hashCode();
    eMU = "connStrategy".hashCode();
    eMV = "closeStrategy".hashCode();
    eMW = "md5Str".hashCode();
    eMX = "authKey".hashCode();
    erd = "url".hashCode();
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
          if (eMQ == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.eMF = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eMR == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (eIJ == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (eMS == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (eMT == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (eMU == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (eMV == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (eMW == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (eMX == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (erd == k) {
              this.field_url = paramCursor.getString(i);
            } else if (eMY == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (eMZ == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (eNa == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (etZ == k) {
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
            paramCursor = new z();
            i = paramCursor.cr(this.field_lvbuffer);
            if (i != 0)
            {
              ac.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ac.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.eUE()) {
        this.eNb = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eNc = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eNd = paramCursor.getLong();
      }
      if (!paramCursor.eUE()) {
        this.eNe = paramCursor.getLong();
      }
      if (!paramCursor.eUE()) {
        this.eNf = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eNg = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eNh = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eNi = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eNj = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eNk = paramCursor.getLong();
      }
      if (!paramCursor.eUE()) {
        this.eNl = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eNm = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eNn = paramCursor.getString();
      }
    } while (paramCursor.eUE());
    this.eNo = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.etL)
      {
        localObject = new z();
        ((z)localObject).eUF();
        ((z)localObject).Yr(this.eNb);
        ((z)localObject).Yr(this.eNc);
        ((z)localObject).Af(this.eNd);
        ((z)localObject).Af(this.eNe);
        ((z)localObject).aKJ(this.eNf);
        ((z)localObject).aKJ(this.iconUrl);
        ((z)localObject).aKJ(this.jumpUrl);
        ((z)localObject).aKJ(this.eNg);
        ((z)localObject).aKJ(this.eNh);
        ((z)localObject).aKJ(this.category);
        ((z)localObject).Yr(this.eNi);
        ((z)localObject).Yr(this.eNj);
        ((z)localObject).Af(this.eNk);
        ((z)localObject).aKJ(this.eNl);
        ((z)localObject).aKJ(this.eNm);
        ((z)localObject).aKJ(this.eNn);
        ((z)localObject).aKJ(this.eNo);
        this.field_lvbuffer = ((z)localObject).eUG();
      }
      Object localObject = new ContentValues();
      if (this.eMF) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.eMG) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.eIx) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.eMH) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.eMI) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.eMJ) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.eMK) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.eML) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.eMM) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.eqZ) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.eMN) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.eMO) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.eMP) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.etL) {
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
        ac.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void kb(int paramInt)
  {
    this.eNi = paramInt;
    this.etL = true;
  }
  
  public final void kc(int paramInt)
  {
    this.eNj = paramInt;
    this.etL = true;
  }
  
  public final void oy(long paramLong)
  {
    this.eNk = paramLong;
    this.etL = true;
  }
  
  public final void qV(String paramString)
  {
    this.iconUrl = paramString;
    this.etL = true;
  }
  
  public final void qW(String paramString)
  {
    this.jumpUrl = paramString;
    this.etL = true;
  }
  
  public final void qX(String paramString)
  {
    this.eNg = paramString;
    this.etL = true;
  }
  
  public final void qY(String paramString)
  {
    this.eNh = paramString;
    this.etL = true;
  }
  
  public final void qZ(String paramString)
  {
    this.category = paramString;
    this.etL = true;
  }
  
  public final void qg(String paramString)
  {
    this.eNf = paramString;
    this.etL = true;
  }
  
  public final void ra(String paramString)
  {
    this.eNl = paramString;
    this.etL = true;
  }
  
  public final void rb(String paramString)
  {
    this.eNm = paramString;
    this.etL = true;
  }
  
  public final void rc(String paramString)
  {
    this.eNn = paramString;
    this.etL = true;
  }
  
  public final void rd(String paramString)
  {
    this.eNo = paramString;
    this.etL = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cy
 * JD-Core Version:    0.7.0.1
 */