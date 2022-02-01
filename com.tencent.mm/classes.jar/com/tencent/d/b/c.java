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
  private int JRF;
  private com.tencent.d.c.a.c JRH;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.JRH = null;
    this.mVersionName = null;
    this.JRF = -1;
    this.mContext = paramContext;
    paramContext = i.cu(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.JRF = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.JRH == null)
    {
      this.JRH = new com.tencent.d.c.a.c();
      this.JRH.JRS = 82;
      this.JRH.JRX = this.JRF;
      this.JRH.JRP = parama.channel;
      this.JRH.JRO = parama.JRO;
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
    this.JRH.JRT = new com.tencent.d.c.a.b();
    this.JRH.JRT.JRL = k;
    this.JRH.JRT.JRM = j;
    this.JRH.JRT.JRN = i;
    this.JRH.JRU = 0;
    this.JRH.JRW = d.getSDKVersion();
    this.JRH.imei = aTg(parama.imei);
    this.JRH.imsi = aTg(parama.imsi);
    this.JRH.JRQ = aTg(Build.MODEL);
    this.JRH.yeO = aTg(d.kK(this.mContext));
    this.JRH.JSc = aTg(d.yD(true));
    this.JRH.JSd = aTg(d.yD(false));
    this.JRH.JRV = 0;
    this.JRH.JRR = getNetworkType();
    this.JRH.guid = aTg(d.kM(this.mContext));
    parama = this.JRH;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String aTg(String paramString)
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
      if (d.kL(this.mContext) == d.a.JUG)
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
      locall.fCQ();
      locall.aTp(paramString1);
      locall.aTq(paramString2);
      locall.aTo("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.d.f.b.compress(locall.JT());
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
      paramString1 = com.tencent.d.f.c.n(paramString1, com.tencent.d.f.c.fCL());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */