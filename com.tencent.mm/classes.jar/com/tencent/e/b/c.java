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
  private int RKX;
  private com.tencent.e.c.a.c RKZ;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.RKZ = null;
    this.mVersionName = null;
    this.RKX = -1;
    this.mContext = paramContext;
    paramContext = i.cU(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.RKX = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.e.c.a.c a(com.tencent.e.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.RKZ == null)
    {
      this.RKZ = new com.tencent.e.c.a.c();
      this.RKZ.RLj = 82;
      this.RKZ.RLo = this.RKX;
      this.RKZ.RLh = parama.channel;
      this.RKZ.RLg = parama.RLg;
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
    this.RKZ.RLk = new com.tencent.e.c.a.b();
    this.RKZ.RLk.RLd = k;
    this.RKZ.RLk.RLe = j;
    this.RKZ.RLk.RLf = i;
    this.RKZ.RLl = 0;
    this.RKZ.RLn = d.getSDKVersion();
    this.RKZ.imei = bpY(parama.imei);
    this.RKZ.imsi = bpY(parama.imsi);
    this.RKZ.KFF = bpY(Build.MODEL);
    this.RKZ.aid = bpY(d.kZ(this.mContext));
    this.RKZ.RLt = bpY(d.DO(true));
    this.RKZ.RLu = bpY(d.DO(false));
    this.RKZ.RLm = 0;
    this.RKZ.RLi = getNetworkType();
    this.RKZ.guid = bpY("");
    parama = this.RKZ;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String bpY(String paramString)
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
      if (d.la(this.mContext) == d.a.RNY)
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
  
  public final byte[] c(String paramString1, String paramString2, com.tencent.e.e.a.b.a parama)
  {
    AppMethodBeat.i(138317);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.IK();
      locall.cy(paramString1);
      locall.cz(paramString2);
      locall.bqf("UTF-8");
      locall.put("userInfo", a(parama));
      locall.put("req", parama);
      paramString1 = com.tencent.e.f.b.compress(locall.IJ());
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
      paramString1 = com.tencent.e.f.c.n(paramString1, com.tencent.e.f.c.hkP());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.b.c
 * JD-Core Version:    0.7.0.1
 */