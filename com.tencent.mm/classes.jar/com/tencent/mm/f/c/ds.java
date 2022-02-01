package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ds
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("HardDeviceInfo");
  public static final Column hsH;
  private static final int hsP;
  public static final Column hso;
  public static final Column hwK;
  private static final int hxm = "lvbuffer".hashCode();
  private static final int idC;
  private static final int idD;
  private static final int idE;
  private static final int idF;
  private static final int idG;
  private static final int idH;
  private static final int idI;
  private static final int idJ;
  private static final int idK;
  private static final int idL;
  private static final int idM;
  private static final int idN;
  public static final Column ide;
  public static final Column idf;
  public static final Column idg;
  public static final Column idh;
  public static final Column idi;
  public static final Column idj;
  public static final Column idk;
  public static final Column idl;
  public static final Column idm;
  public static final Column idn;
  public static final Column ido;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hsL = true;
  public boolean hwY = true;
  public String iconUrl;
  private boolean idA = true;
  private boolean idB = true;
  public int idO;
  public int idP;
  public long idQ;
  private long idR;
  public String idS;
  public String idT;
  public String idU;
  public String idV;
  private int idW;
  public int idX;
  public long idY;
  public String idZ;
  private boolean idp = true;
  private boolean idq = true;
  private boolean idr = true;
  private boolean ids = true;
  private boolean idt = true;
  private boolean idu = true;
  private boolean idv = true;
  private boolean idw = true;
  private boolean idy = true;
  private boolean idz = true;
  public String iea;
  private String ieb;
  public String iec;
  public String jumpUrl;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "HardDeviceInfo", "");
    hso = new Column("deviceid", "string", "HardDeviceInfo", "");
    ide = new Column("brandname", "string", "HardDeviceInfo", "");
    idf = new Column("mac", "long", "HardDeviceInfo", "");
    idg = new Column("devicetype", "string", "HardDeviceInfo", "");
    idh = new Column("connproto", "string", "HardDeviceInfo", "");
    idi = new Column("connstrategy", "int", "HardDeviceInfo", "");
    idj = new Column("closestrategy", "int", "HardDeviceInfo", "");
    idk = new Column("md5str", "string", "HardDeviceInfo", "");
    idl = new Column("authkey", "string", "HardDeviceInfo", "");
    hsH = new Column("url", "string", "HardDeviceInfo", "");
    idm = new Column("sessionkey", "byte[]", "HardDeviceInfo", "");
    idn = new Column("sessionbuf", "byte[]", "HardDeviceInfo", "");
    ido = new Column("authbuf", "byte[]", "HardDeviceInfo", "");
    hwK = new Column("lvbuffer", "byte[]", "HardDeviceInfo", "");
    idC = "deviceID".hashCode();
    idD = "brandName".hashCode();
    idE = "mac".hashCode();
    idF = "deviceType".hashCode();
    idG = "connProto".hashCode();
    idH = "connStrategy".hashCode();
    idI = "closeStrategy".hashCode();
    idJ = "md5Str".hashCode();
    idK = "authKey".hashCode();
    hsP = "url".hashCode();
    idL = "sessionKey".hashCode();
    idM = "sessionBuf".hashCode();
    idN = "authBuf".hashCode();
  }
  
  public final void EF(long paramLong)
  {
    this.idY = paramLong;
    this.hwY = true;
  }
  
  public final void Iq(String paramString)
  {
    this.idS = paramString;
    this.hwY = true;
  }
  
  public final void Je(String paramString)
  {
    this.jumpUrl = paramString;
    this.hwY = true;
  }
  
  public final void Jf(String paramString)
  {
    this.idT = paramString;
    this.hwY = true;
  }
  
  public final void Jg(String paramString)
  {
    this.idU = paramString;
    this.hwY = true;
  }
  
  public final void Jh(String paramString)
  {
    this.idV = paramString;
    this.hwY = true;
  }
  
  public final void Ji(String paramString)
  {
    this.idZ = paramString;
    this.hwY = true;
  }
  
  public final void Jj(String paramString)
  {
    this.iea = paramString;
    this.hwY = true;
  }
  
  public final void Jk(String paramString)
  {
    this.ieb = paramString;
    this.hwY = true;
  }
  
  public final void Jl(String paramString)
  {
    this.iec = paramString;
    this.hwY = true;
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
          if (idC == k)
          {
            this.field_deviceID = paramCursor.getString(i);
            this.idp = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (idD == k) {
              this.field_brandName = paramCursor.getString(i);
            } else if (idE == k) {
              this.field_mac = paramCursor.getLong(i);
            } else if (idF == k) {
              this.field_deviceType = paramCursor.getString(i);
            } else if (idG == k) {
              this.field_connProto = paramCursor.getString(i);
            } else if (idH == k) {
              this.field_connStrategy = paramCursor.getInt(i);
            } else if (idI == k) {
              this.field_closeStrategy = paramCursor.getInt(i);
            } else if (idJ == k) {
              this.field_md5Str = paramCursor.getString(i);
            } else if (idK == k) {
              this.field_authKey = paramCursor.getString(i);
            } else if (hsP == k) {
              this.field_url = paramCursor.getString(i);
            } else if (idL == k) {
              this.field_sessionKey = paramCursor.getBlob(i);
            } else if (idM == k) {
              this.field_sessionBuf = paramCursor.getBlob(i);
            } else if (idN == k) {
              this.field_authBuf = paramCursor.getBlob(i);
            } else if (hxm == k) {
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
        this.idO = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idP = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idQ = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idR = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idS = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iconUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jumpUrl = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idT = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idU = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idV = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idW = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idX = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idY = paramCursor.getLong();
      }
      if (!paramCursor.checkGetFinish()) {
        this.idZ = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iea = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ieb = paramCursor.getString();
      }
    } while (paramCursor.checkGetFinish());
    this.iec = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.hwY)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.idO);
        ((LVBuffer)localObject).putInt(this.idP);
        ((LVBuffer)localObject).putLong(this.idQ);
        ((LVBuffer)localObject).putLong(this.idR);
        ((LVBuffer)localObject).putString(this.idS);
        ((LVBuffer)localObject).putString(this.iconUrl);
        ((LVBuffer)localObject).putString(this.jumpUrl);
        ((LVBuffer)localObject).putString(this.idT);
        ((LVBuffer)localObject).putString(this.idU);
        ((LVBuffer)localObject).putString(this.idV);
        ((LVBuffer)localObject).putInt(this.idW);
        ((LVBuffer)localObject).putInt(this.idX);
        ((LVBuffer)localObject).putLong(this.idY);
        ((LVBuffer)localObject).putString(this.idZ);
        ((LVBuffer)localObject).putString(this.iea);
        ((LVBuffer)localObject).putString(this.ieb);
        ((LVBuffer)localObject).putString(this.iec);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.idp) {
        ((ContentValues)localObject).put("deviceID", this.field_deviceID);
      }
      if (this.idq) {
        ((ContentValues)localObject).put("brandName", this.field_brandName);
      }
      if (this.idr) {
        ((ContentValues)localObject).put("mac", Long.valueOf(this.field_mac));
      }
      if (this.ids) {
        ((ContentValues)localObject).put("deviceType", this.field_deviceType);
      }
      if (this.idt) {
        ((ContentValues)localObject).put("connProto", this.field_connProto);
      }
      if (this.idu) {
        ((ContentValues)localObject).put("connStrategy", Integer.valueOf(this.field_connStrategy));
      }
      if (this.idv) {
        ((ContentValues)localObject).put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
      }
      if (this.idw) {
        ((ContentValues)localObject).put("md5Str", this.field_md5Str);
      }
      if (this.idy) {
        ((ContentValues)localObject).put("authKey", this.field_authKey);
      }
      if (this.hsL) {
        ((ContentValues)localObject).put("url", this.field_url);
      }
      if (this.idz) {
        ((ContentValues)localObject).put("sessionKey", this.field_sessionKey);
      }
      if (this.idA) {
        ((ContentValues)localObject).put("sessionBuf", this.field_sessionBuf);
      }
      if (this.idB) {
        ((ContentValues)localObject).put("authBuf", this.field_authBuf);
      }
      if (this.hwY) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "HardDeviceInfo";
  }
  
  public final void pT(int paramInt)
  {
    this.idW = paramInt;
    this.hwY = true;
  }
  
  public final void pU(int paramInt)
  {
    this.idX = paramInt;
    this.hwY = true;
  }
  
  public final void setIconUrl(String paramString)
  {
    this.iconUrl = paramString;
    this.hwY = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.ds
 * JD-Core Version:    0.7.0.1
 */