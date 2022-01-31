package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;

public final class b
{
  private String mChannelId = null;
  private Context mContext = null;
  private String mVersionName = null;
  private int wLs = -1;
  private int wLt = -1;
  private String wLu = null;
  private com.tencent.d.c.a.c wLv = null;
  private com.tencent.d.c.a.a wLw = null;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.bM(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.wLt = paramContext.versionCode;
    this.wLs = 82;
    this.mChannelId = "105901";
    this.wLu = "7AD75E27CD5842F6";
  }
  
  private static String afC(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c cOH()
  {
    int m = 2;
    if (this.wLv == null)
    {
      this.wLv = new com.tencent.d.c.a.c();
      this.wLv.wLG = this.wLs;
      this.wLv.wLL = this.wLt;
      this.wLv.wLD = this.mChannelId;
      this.wLv.wLC = this.wLu;
    }
    try
    {
      localObject = this.mVersionName.trim().split("[\\.]");
      if ((localObject == null) || (localObject.length < 3)) {
        break label331;
      }
      k = Integer.parseInt(localObject[0]);
      j = Integer.parseInt(localObject[1]);
      i = Integer.parseInt(localObject[2]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
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
    this.wLv.imei = afC(d.getIMEI(this.mContext));
    this.wLv.imsi = afC(d.hA(this.mContext));
    this.wLv.wLE = afC(Build.MODEL);
    this.wLv.oAl = afC(d.hB(this.mContext));
    this.wLv.wLR = afC(d.oi(true));
    this.wLv.wLS = afC(d.oi(false));
    this.wLv.guid = null;
    this.wLv.wLJ = 0;
    localObject = this.wLv;
    if (d.hC(this.mContext) == d.a.wOe) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).wLF = i;
      return this.wLv;
    }
  }
  
  public final byte[] a(com.tencent.d.c.b.a parama)
  {
    try
    {
      l locall = new l();
      locall.cPd();
      locall.afM("viruscheck");
      locall.afN("RiskCheck");
      locall.afL("UTF-8");
      if (this.wLw == null)
      {
        this.wLw = new com.tencent.d.c.a.a();
        this.wLw.wLx = 2;
        this.wLw.wLy = 201;
      }
      locall.put("phonetype", this.wLw);
      locall.put("userinfo", cOH());
      locall.put("req", parama);
      parama = com.tencent.d.f.b.l(locall.ss());
      if (parama == null) {
        throw new RuntimeException("compress data fail");
      }
      parama = com.tencent.d.f.c.j(parama, com.tencent.d.f.c.cOZ());
      return parama;
    }
    catch (Exception parama) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */