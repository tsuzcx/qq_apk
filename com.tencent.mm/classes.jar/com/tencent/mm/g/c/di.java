package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class di
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJV;
  private static final int eMR = "lvbuffer".hashCode();
  private static final int fcK;
  private static final int fhj = "deviceID".hashCode();
  private static final int fhk = "brandName".hashCode();
  private static final int fhl;
  private static final int fhm;
  private static final int fhn;
  private static final int fho;
  private static final int fhp;
  private static final int fhq;
  private static final int fhr;
  private static final int fhs;
  private static final int fht;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  private boolean eJR = true;
  public boolean eMD = true;
  private boolean fcy = true;
  private boolean fgY = true;
  private boolean fgZ = true;
  public String fhA;
  private int fhB;
  public int fhC;
  public long fhD;
  public String fhE;
  public String fhF;
  private String fhG;
  public String fhH;
  private boolean fha = true;
  private boolean fhb = true;
  private boolean fhc = true;
  private boolean fhd = true;
  private boolean fhe = true;
  private boolean fhf = true;
  private boolean fhg = true;
  private boolean fhh = true;
  private boolean fhi = true;
  public int fhu;
  public int fhv;
  public long fhw;
  private long fhx;
  public String fhy;
  public String fhz;
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
    fcK = "mac".hashCode();
    fhl = "deviceType".hashCode();
    fhm = "connProto".hashCode();
    fhn = "connStrategy".hashCode();
    fho = "closeStrategy".hashCode();
    fhp = "md5Str".hashCode();
    fhq = "authKey".hashCode();
    eJV = "url".hashCode();
    fhr = "sessionKey".hashCode();
    fhs = "sessionBuf".hashCode();
    fht = "authBuf".hashCode();
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
          if (fhj == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.fgY = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (fhk == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (fcK == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (fhl == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (fhm == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (fhn == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (fho == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (fhp == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (fhq == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (eJV == k) {
              this.field_url = paramCursor.getString(i);
            } else if (fhr == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (fhs == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (fht == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (eMR == k) {
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
            paramCursor = new ab();
            i = paramCursor.cB(this.field_lvbuffer);
            if (i != 0)
            {
              ae.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ae.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.foc()) {
        this.fhu = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fhv = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fhw = paramCursor.getLong();
      }
      if (!paramCursor.foc()) {
        this.fhx = paramCursor.getLong();
      }
      if (!paramCursor.foc()) {
        this.fhy = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fhz = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fhA = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fhB = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fhC = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fhD = paramCursor.getLong();
      }
      if (!paramCursor.foc()) {
        this.fhE = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fhF = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fhG = paramCursor.getString();
      }
    } while (paramCursor.foc());
    this.fhH = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eMD)
      {
        localObject = new ab();
        ((ab)localObject).fod();
        ((ab)localObject).abc(this.fhu);
        ((ab)localObject).abc(this.fhv);
        ((ab)localObject).Dt(this.fhw);
        ((ab)localObject).Dt(this.fhx);
        ((ab)localObject).aRM(this.fhy);
        ((ab)localObject).aRM(this.iconUrl);
        ((ab)localObject).aRM(this.jumpUrl);
        ((ab)localObject).aRM(this.fhz);
        ((ab)localObject).aRM(this.fhA);
        ((ab)localObject).aRM(this.category);
        ((ab)localObject).abc(this.fhB);
        ((ab)localObject).abc(this.fhC);
        ((ab)localObject).Dt(this.fhD);
        ((ab)localObject).aRM(this.fhE);
        ((ab)localObject).aRM(this.fhF);
        ((ab)localObject).aRM(this.fhG);
        ((ab)localObject).aRM(this.fhH);
        this.field_lvbuffer = ((ab)localObject).foe();
      }
      Object localObject = new ContentValues();
      if (this.fgY) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.fgZ) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.fcy) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.fha) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.fhb) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.fhc) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.fhd) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.fhe) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.fhf) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.eJR) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.fhg) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.fhh) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.fhi) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.eMD) {
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
        ae.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void kB(int paramInt)
  {
    this.fhB = paramInt;
    this.eMD = true;
  }
  
  public final void kC(int paramInt)
  {
    this.fhC = paramInt;
    this.eMD = true;
  }
  
  public final void qL(long paramLong)
  {
    this.fhD = paramLong;
    this.eMD = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.eMD = true;
  }
  
  public final void tl(String paramString)
  {
    this.fhy = paramString;
    this.eMD = true;
  }
  
  public final void ua(String paramString)
  {
    this.jumpUrl = paramString;
    this.eMD = true;
  }
  
  public final void ub(String paramString)
  {
    this.fhz = paramString;
    this.eMD = true;
  }
  
  public final void uc(String paramString)
  {
    this.fhA = paramString;
    this.eMD = true;
  }
  
  public final void ud(String paramString)
  {
    this.category = paramString;
    this.eMD = true;
  }
  
  public final void ue(String paramString)
  {
    this.fhE = paramString;
    this.eMD = true;
  }
  
  public final void uf(String paramString)
  {
    this.fhF = paramString;
    this.eMD = true;
  }
  
  public final void ug(String paramString)
  {
    this.fhG = paramString;
    this.eMD = true;
  }
  
  public final void uh(String paramString)
  {
    this.fhH = paramString;
    this.eMD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.di
 * JD-Core Version:    0.7.0.1
 */