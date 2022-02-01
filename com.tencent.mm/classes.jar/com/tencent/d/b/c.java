package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.i;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private int Miw;
  private com.tencent.d.c.a.c Miy;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.Miy = null;
    this.mVersionName = null;
    this.Miw = -1;
    this.mContext = paramContext;
    paramContext = i.cA(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.Miw = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.Miy == null)
    {
      this.Miy = new com.tencent.d.c.a.c();
      this.Miy.MiI = 82;
      this.Miy.MiN = this.Miw;
      this.Miy.MiG = parama.channel;
      this.Miy.MiF = parama.MiF;
    }
    try
    {
      String[] arrayOfString = this.mVersionName.trim().split("[\\.]");
      if ((arrayOfString == null) || (arrayOfString.length < 3)) {
        break label329;
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
    this.Miy.MiJ = new com.tencent.d.c.a.b();
    this.Miy.MiJ.MiC = k;
    this.Miy.MiJ.MiD = j;
    this.Miy.MiJ.MiE = i;
    this.Miy.MiK = 0;
    this.Miy.MiM = d.getSDKVersion();
    this.Miy.imei = baJ(parama.imei);
    this.Miy.imsi = baJ(parama.imsi);
    this.Miy.FMd = baJ(Build.MODEL);
    this.Miy.zMk = baJ(d.le(this.mContext));
    this.Miy.MiS = baJ(d.zE(true));
    this.Miy.MiT = baJ(d.zE(false));
    this.Miy.MiL = 0;
    this.Miy.MiH = getNetworkType();
    this.Miy.guid = baJ("");
    parama = this.Miy;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String baJ(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private int getNetworkType()
  {
    AppMethodBeat.i(138319);
    try
    {
      if (d.lf(this.mContext) == d.a.Mly)
      {
        AppMethodBeat.o(138319);
        return 2;
      }
      AppMethodBeat.o(138319);
      return 1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(138319);
    }
    return 2;
  }
  
  public final byte[] c(String paramString1, String paramString2, com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138317);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.fYH();
      locall.baS(paramString1);
      locall.baT(paramString2);
      locall.baR("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.d.f.b.compress(locall.LA());
      if (paramString1 == null)
      {
        paramString1 = new RuntimeException("compress data fail");
        AppMethodBeat.o(138317);
        throw paramString1;
      }
    }
    catch (Exception paramString1)
    {
      paramString1 = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(138317);
      return paramString1;
      paramString1 = com.tencent.d.f.c.o(paramString1, com.tencent.d.f.c.fYD());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */