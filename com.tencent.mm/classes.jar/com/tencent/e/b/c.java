package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.f.d;
import com.tencent.e.f.d.a;
import com.tencent.e.f.i;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private int BiS;
  private com.tencent.e.c.a.c BiU;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(114475);
    this.BiU = null;
    this.mVersionName = null;
    this.BiS = -1;
    this.mContext = paramContext;
    paramContext = i.cc(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.BiS = paramContext.versionCode;
    AppMethodBeat.o(114475);
  }
  
  private com.tencent.e.c.a.c a(com.tencent.e.e.a.b.a parama)
  {
    AppMethodBeat.i(114477);
    if (this.BiU == null)
    {
      this.BiU = new com.tencent.e.c.a.c();
      this.BiU.Bjf = 82;
      this.BiU.Bjk = this.BiS;
      this.BiU.Bjc = parama.cCy;
      this.BiU.Bjb = parama.Bjb;
    }
    try
    {
      String[] arrayOfString = this.mVersionName.trim().split("[\\.]");
      if ((arrayOfString == null) || (arrayOfString.length < 3)) {
        break label334;
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
    this.BiU.Bjg = new com.tencent.e.c.a.b();
    this.BiU.Bjg.BiY = k;
    this.BiU.Bjg.BiZ = j;
    this.BiU.Bjg.Bja = i;
    this.BiU.Bjh = 0;
    this.BiU.Bjj = d.dUQ();
    this.BiU.imei = awy(parama.imei);
    this.BiU.imsi = awy(parama.imsi);
    this.BiU.Bjd = awy(Build.MODEL);
    this.BiU.rpv = awy(d.jc(this.mContext));
    this.BiU.Bjp = awy(d.rU(true));
    this.BiU.Bjq = awy(d.rU(false));
    this.BiU.Bji = 0;
    this.BiU.Bje = getNetworkType();
    this.BiU.guid = awy(d.je(this.mContext));
    parama = this.BiU;
    AppMethodBeat.o(114477);
    return parama;
  }
  
  private static String awy(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private int getNetworkType()
  {
    AppMethodBeat.i(114478);
    try
    {
      if (d.jd(this.mContext) == d.a.BlC)
      {
        AppMethodBeat.o(114478);
        return 2;
      }
      AppMethodBeat.o(114478);
      return 1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(114478);
    }
    return 2;
  }
  
  public final byte[] c(String paramString1, String paramString2, com.tencent.e.e.a.b.a parama)
  {
    AppMethodBeat.i(114476);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.dUW();
      locall.awH(paramString1);
      locall.awI(paramString2);
      locall.awG("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.e.f.b.compress(locall.AJ());
      if (paramString1 == null)
      {
        paramString1 = new RuntimeException("compress data fail");
        AppMethodBeat.o(114476);
        throw paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(114476);
      return paramString1;
      paramString1 = com.tencent.e.f.c.m(paramString1, com.tencent.e.f.c.dUP());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.b.c
 * JD-Core Version:    0.7.0.1
 */