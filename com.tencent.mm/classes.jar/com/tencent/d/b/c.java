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
  private int IpV;
  private com.tencent.d.c.a.c IpX;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.IpX = null;
    this.mVersionName = null;
    this.IpV = -1;
    this.mContext = paramContext;
    paramContext = i.cu(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.IpV = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.d.c.a.c a(com.tencent.d.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.IpX == null)
    {
      this.IpX = new com.tencent.d.c.a.c();
      this.IpX.Iqi = 82;
      this.IpX.Iqn = this.IpV;
      this.IpX.Iqf = parama.channel;
      this.IpX.Iqe = parama.Iqe;
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
    this.IpX.Iqj = new com.tencent.d.c.a.b();
    this.IpX.Iqj.Iqb = k;
    this.IpX.Iqj.Iqc = j;
    this.IpX.Iqj.Iqd = i;
    this.IpX.Iqk = 0;
    this.IpX.Iqm = d.fmv();
    this.IpX.imei = aND(parama.imei);
    this.IpX.imsi = aND(parama.imsi);
    this.IpX.Iqg = aND(Build.MODEL);
    this.IpX.wSi = aND(d.ky(this.mContext));
    this.IpX.Iqs = aND(d.xt(true));
    this.IpX.Iqt = aND(d.xt(false));
    this.IpX.Iql = 0;
    this.IpX.Iqh = getNetworkType();
    this.IpX.guid = aND(d.kA(this.mContext));
    parama = this.IpX;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String aND(String paramString)
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
      if (d.kz(this.mContext) == d.a.IsW)
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
      locall.fmA();
      locall.aNM(paramString1);
      locall.aNN(paramString2);
      locall.aNL("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.d.f.b.compress(locall.Kj());
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
      paramString1 = com.tencent.d.f.c.n(paramString1, com.tencent.d.f.c.fmu());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.b.c
 * JD-Core Version:    0.7.0.1
 */