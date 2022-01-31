package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.i;
import com.tencent.d.f.l;

public final class c
{
  private Context mContext;
  private String mVersionName = null;
  private int wLt = -1;
  private com.tencent.d.c.a.c wLv = null;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = i.bN(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.wLt = paramContext.versionCode;
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    if (this.wLv == null)
    {
      this.wLv = new com.tencent.d.c.a.c();
      this.wLv.wLG = 82;
      this.wLv.wLL = this.wLt;
      this.wLv.wLD = parama.bUR;
      this.wLv.wLC = parama.wLC;
    }
    try
    {
      String[] arrayOfString = this.mVersionName.trim().split("[\\.]");
      if ((arrayOfString == null) || (arrayOfString.length < 3)) {
        break label322;
      }
      k = Integer.parseInt(arrayOfString[0]);
      j = Integer.parseInt(arrayOfString[1]);
      i = Integer.parseInt(arrayOfString[2]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        int i = 0;
        int j = 0;
        int k = 0;
      }
    }
    this.wLv.wLH = new com.tencent.d.c.a.b();
    this.wLv.wLH.wLz = k;
    this.wLv.wLH.wLA = j;
    this.wLv.wLH.wLB = i;
    this.wLv.wLI = 0;
    this.wLv.wLK = d.cPa();
    this.wLv.imei = afC(parama.imei);
    this.wLv.imsi = afC(parama.imsi);
    this.wLv.wLE = afC(Build.MODEL);
    this.wLv.oAl = afC(d.hB(this.mContext));
    this.wLv.wLR = afC(d.oi(true));
    this.wLv.wLS = afC(d.oi(false));
    this.wLv.wLJ = 0;
    this.wLv.wLF = getNetworkType();
    this.wLv.guid = afC(d.hD(this.mContext));
    return this.wLv;
  }
  
  private static String afC(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private int getNetworkType()
  {
    try
    {
      d.a locala1 = d.hC(this.mContext);
      d.a locala2 = d.a.wOe;
      if (locala1 == locala2) {
        return 2;
      }
      return 1;
    }
    catch (Throwable localThrowable) {}
    return 2;
  }
  
  public final byte[] c(String paramString1, String paramString2, com.tencent.d.e.a.b.a parama)
  {
    try
    {
      l locall = new l();
      locall.cPd();
      locall.afM(paramString1);
      locall.afN(paramString2);
      locall.afL("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.d.f.b.l(locall.ss());
      if (paramString1 == null) {
        throw new RuntimeException("compress data fail");
      }
      paramString1 = com.tencent.d.f.c.j(paramString1, com.tencent.d.f.c.cOZ());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */