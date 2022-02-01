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
  private int LLx;
  private com.tencent.d.c.a.c LLz;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.LLz = null;
    this.mVersionName = null;
    this.LLx = -1;
    this.mContext = paramContext;
    paramContext = i.cz(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.LLx = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.LLz == null)
    {
      this.LLz = new com.tencent.d.c.a.c();
      this.LLz.LLJ = 82;
      this.LLz.LLO = this.LLx;
      this.LLz.LLH = parama.channel;
      this.LLz.LLG = parama.LLG;
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
    this.LLz.LLK = new com.tencent.d.c.a.b();
    this.LLz.LLK.LLD = k;
    this.LLz.LLK.LLE = j;
    this.LLz.LLK.LLF = i;
    this.LLz.LLL = 0;
    this.LLz.LLN = d.getSDKVersion();
    this.LLz.imei = aZg(parama.imei);
    this.LLz.imsi = aZg(parama.imsi);
    this.LLz.FtF = aZg(Build.MODEL);
    this.LLz.zuP = aZg(d.kX(this.mContext));
    this.LLz.LLT = aZg(d.zq(true));
    this.LLz.LLU = aZg(d.zq(false));
    this.LLz.LLM = 0;
    this.LLz.LLI = getNetworkType();
    this.LLz.guid = aZg("");
    parama = this.LLz;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String aZg(String paramString)
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
      if (d.kY(this.mContext) == d.a.LOz)
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
      locall.fUi();
      locall.aZp(paramString1);
      locall.aZq(paramString2);
      locall.aZo("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.d.f.b.compress(locall.Ls());
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
      paramString1 = com.tencent.d.f.c.n(paramString1, com.tencent.d.f.c.fUd());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */