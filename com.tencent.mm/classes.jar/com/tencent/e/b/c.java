package com.tencent.e.b;

import android.content.Context;
import com.tencent.e.f.d;
import com.tencent.e.f.d.a;
import com.tencent.e.f.i;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;

public final class c
{
  private int ahsm;
  private com.tencent.e.c.a.c ahso;
  private Context mContext;
  private String mVersionName;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(138316);
    this.ahso = null;
    this.mVersionName = null;
    this.ahsm = -1;
    this.mContext = paramContext;
    paramContext = i.jdMethod_do(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.ahsm = paramContext.versionCode;
    AppMethodBeat.o(138316);
  }
  
  private com.tencent.e.c.a.c a(com.tencent.e.e.a.b.a parama)
  {
    AppMethodBeat.i(138318);
    if (this.ahso == null)
    {
      this.ahso = new com.tencent.e.c.a.c();
      this.ahso.ahsy = 82;
      this.ahso.ahsD = this.ahsm;
      this.ahso.ahsw = parama.channel;
      this.ahso.ahsv = parama.ahsv;
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
    this.ahso.ahsz = new com.tencent.e.c.a.b();
    this.ahso.ahsz.ahss = k;
    this.ahso.ahsz.ahst = j;
    this.ahso.ahsz.ahsu = i;
    this.ahso.ahsA = 0;
    this.ahso.ahsC = d.getSDKVersion();
    this.ahso.imei = "1234567890ABCDEF";
    this.ahso.imsi = "";
    this.ahso.YDY = bFv(q.aPo());
    this.ahso.aid = "";
    this.ahso.ahsI = "";
    this.ahso.ahsJ = "";
    this.ahso.ahsB = 0;
    this.ahso.ahsx = getNetworkType();
    this.ahso.guid = bFv("");
    parama = this.ahso;
    AppMethodBeat.o(138318);
    return parama;
  }
  
  private static String bFv(String paramString)
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
      if (d.od(this.mContext) == d.a.ahvl) {
        return 2;
      }
      return 1;
    }
    finally
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
      locall.ako();
      locall.em(paramString1);
      locall.en(paramString2);
      locall.bFC("UTF-8");
      locall.j("userInfo", a(parama));
      locall.j("req", parama);
      paramString1 = com.tencent.e.f.b.compress(locall.akn());
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
      paramString1 = com.tencent.e.f.c.q(paramString1, com.tencent.e.f.c.jXz());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.b.c
 * JD-Core Version:    0.7.0.1
 */