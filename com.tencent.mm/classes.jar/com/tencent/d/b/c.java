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
  private int ZnE;
  private com.tencent.d.c.a.c ZnG;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.ZnG = null;
    this.mVersionName = null;
    this.ZnE = -1;
    this.mContext = paramContext;
    paramContext = i.df(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.ZnE = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.ZnG == null)
    {
      this.ZnG = new com.tencent.d.c.a.c();
      this.ZnG.ZnQ = 82;
      this.ZnG.ZnV = this.ZnE;
      this.ZnG.ZnO = parama.channel;
      this.ZnG.ZnN = parama.ZnN;
    }
    try
    {
      parama = this.mVersionName.trim().split("[\\.]");
      if ((parama == null) || (parama.length < 3)) {
        break label294;
      }
      k = Integer.parseInt(parama[0]);
      j = Integer.parseInt(parama[1]);
      i = Integer.parseInt(parama[2]);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        continue;
        int i = 0;
        int j = 0;
        int k = 0;
      }
    }
    this.ZnG.ZnR = new com.tencent.d.c.a.b();
    this.ZnG.ZnR.ZnK = k;
    this.ZnG.ZnR.ZnL = j;
    this.ZnG.ZnR.ZnM = i;
    this.ZnG.ZnS = 0;
    this.ZnG.ZnU = d.getSDKVersion();
    this.ZnG.imei = "1234567890ABCDEF";
    this.ZnG.imsi = "";
    this.ZnG.RGW = bCQ(Build.MODEL);
    this.ZnG.aid = "";
    this.ZnG.Zoa = "";
    this.ZnG.Zob = "";
    this.ZnG.ZnT = 0;
    this.ZnG.ZnP = getNetworkType();
    this.ZnG.guid = bCQ("");
    parama = this.ZnG;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String bCQ(String paramString)
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
      if (d.lY(this.mContext) == d.a.ZqE)
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
      locall.Kn();
      locall.cS(paramString1);
      locall.cT(paramString2);
      locall.bCX("UTF-8");
      locall.c("userInfo", a(parama));
      locall.c("req", parama);
      paramString1 = com.tencent.d.f.b.compress(locall.Km());
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
      paramString1 = com.tencent.d.f.c.p(paramString1, com.tencent.d.f.c.ion());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */