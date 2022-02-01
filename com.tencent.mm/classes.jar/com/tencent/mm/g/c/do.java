package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class do
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fHb;
  private static final int fLM = "deviceID".hashCode();
  private static final int fLN = "brandName".hashCode();
  private static final int fLO;
  private static final int fLP;
  private static final int fLQ;
  private static final int fLR;
  private static final int fLS;
  private static final int fLT;
  private static final int fLU = "sessionKey".hashCode();
  private static final int fLV = "sessionBuf".hashCode();
  private static final int fLW = "authBuf".hashCode();
  private static final int fnB;
  private static final int fqy = "lvbuffer".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String category;
  private boolean fGQ = true;
  private boolean fLB = true;
  private boolean fLC = true;
  private boolean fLD = true;
  private boolean fLE = true;
  private boolean fLF = true;
  private boolean fLG = true;
  private boolean fLH = true;
  private boolean fLI = true;
  private boolean fLJ = true;
  private boolean fLK = true;
  private boolean fLL = true;
  public int fLX;
  public int fLY;
  public long fLZ;
  private long fMa;
  public String fMb;
  public String fMc;
  public String fMd;
  private int fMe;
  public int fMf;
  public long fMg;
  public String fMh;
  public String fMi;
  private String fMj;
  public String fMk;
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
  private boolean fnx = true;
  public boolean fqk = true;
  public String iconUrl;
  public String jumpUrl;
  
  static
  {
    fHb = "mac".hashCode();
    fLO = "deviceType".hashCode();
    fLP = "connProto".hashCode();
    fLQ = "connStrategy".hashCode();
    fLR = "closeStrategy".hashCode();
    fLS = "md5Str".hashCode();
    fLT = "authKey".hashCode();
    fnB = "url".hashCode();
  }
  
  public final void BC(String paramString)
  {
    this.fMb = paramString;
    this.fqk = true;
  }
  
  public final void Cq(String paramString)
  {
    this.jumpUrl = paramString;
    this.fqk = true;
  }
  
  public final void Cr(String paramString)
  {
    this.fMc = paramString;
    this.fqk = true;
  }
  
  public final void Cs(String paramString)
  {
    this.fMd = paramString;
    this.fqk = true;
  }
  
  public final void Ct(String paramString)
  {
    this.category = paramString;
    this.fqk = true;
  }
  
  public final void Cu(String paramString)
  {
    this.fMh = paramString;
    this.fqk = true;
  }
  
  public final void Cv(String paramString)
  {
    this.fMi = paramString;
    this.fqk = true;
  }
  
  public final void Cw(String paramString)
  {
    this.fMj = paramString;
    this.fqk = true;
  }
  
  public final void Cx(String paramString)
  {
    this.fMk = paramString;
    this.fqk = true;
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
          if (fLM == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.fLB = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (fLN == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (fHb == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (fLO == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (fLP == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (fLQ == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (fLR == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (fLS == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (fLT == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (fnB == k) {
              this.field_url = paramCursor.getString(i);
            } else if (fLU == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (fLV == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (fLW == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (fqy == k) {
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
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuffer);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.fLX = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fLY = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fLZ = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMa = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMb = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMc = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMd = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.category = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMe = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMf = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMg = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMh = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMi = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fMj = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.fMk = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.fqk)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.fLX);
        ((LVBuffer)localObject).putInt(this.fLY);
        ((LVBuffer)localObject).putLong(this.fLZ);
        ((LVBuffer)localObject).putLong(this.fMa);
        ((LVBuffer)localObject).putString(this.fMb);
        ((LVBuffer)localObject).putString(this.iconUrl);
        ((LVBuffer)localObject).putString(this.jumpUrl);
        ((LVBuffer)localObject).putString(this.fMc);
        ((LVBuffer)localObject).putString(this.fMd);
        ((LVBuffer)localObject).putString(this.category);
        ((LVBuffer)localObject).putInt(this.fMe);
        ((LVBuffer)localObject).putInt(this.fMf);
        ((LVBuffer)localObject).putLong(this.fMg);
        ((LVBuffer)localObject).putString(this.fMh);
        ((LVBuffer)localObject).putString(this.fMi);
        ((LVBuffer)localObject).putString(this.fMj);
        ((LVBuffer)localObject).putString(this.fMk);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.fLB) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.fLC) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.fGQ) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.fLD) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.fLE) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.fLF) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.fLG) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.fLH) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.fLI) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.fnx) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.fLJ) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.fLK) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.fLL) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.fqk) {
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
        Log.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void nE(int paramInt)
  {
    this.fMe = paramInt;
    this.fqk = true;
  }
  
  public final void nF(int paramInt)
  {
    this.fMf = paramInt;
    this.fqk = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.fqk = true;
  }
  
  public final void yE(long paramLong)
  {
    this.fMg = paramLong;
    this.fqk = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.do
 * JD-Core Version:    0.7.0.1
 */