package com.tencent.e.b;

import android.content.Context;
import com.tencent.e.f.d;
import com.tencent.e.f.d.a;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;

public final class b
{
  private int ahsl;
  private int ahsm;
  private String ahsn;
  private com.tencent.e.c.a.c ahso;
  private com.tencent.e.c.a.a ahsp;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.ahsl = -1;
    this.ahsm = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.ahsn = null;
    this.ahso = null;
    this.ahsp = null;
    this.mContext = paramContext;
    paramContext = com.tencent.e.f.a.dn(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.ahsm = paramContext.versionCode;
    this.ahsl = 82;
    this.mChannelId = "105901";
    this.ahsn = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String bFv(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.e.c.a.c jXe()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.ahso == null)
    {
      this.ahso = new com.tencent.e.c.a.c();
      this.ahso.ahsy = this.ahsl;
      this.ahso.ahsD = this.ahsm;
      this.ahso.ahsw = this.mChannelId;
      this.ahso.ahsv = this.ahsn;
    }
    try
    {
      localObject = this.mVersionName.trim().split("[\\.]");
      if ((localObject == null) || (localObject.length < 3)) {
        break label341;
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
    this.ahso.ahsz = new com.tencent.e.c.a.b();
    this.ahso.ahsz.ahss = k;
    this.ahso.ahsz.ahst = j;
    this.ahso.ahsz.ahsu = i;
    this.ahso.ahsA = 0;
    this.ahso.ahsC = d.getSDKVersion();
    this.ahso.imei = bFv(d.getIMEI(this.mContext));
    this.ahso.imsi = bFv(d.oc(this.mContext));
    this.ahso.YDY = bFv(q.aPo());
    this.ahso.aid = bFv(d.jXA());
    this.ahso.ahsI = bFv(d.Or(true));
    this.ahso.ahsJ = bFv(d.Or(false));
    this.ahso.guid = null;
    this.ahso.ahsB = 0;
    localObject = this.ahso;
    if (d.od(this.mContext) == d.a.ahvl) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.e.c.a.c)localObject).ahsx = i;
      localObject = this.ahso;
      AppMethodBeat.o(138315);
      return localObject;
    }
  }
  
  public final byte[] a(com.tencent.e.c.b.a parama)
  {
    AppMethodBeat.i(138314);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.ako();
      locall.em("viruscheck");
      locall.en("RiskCheck");
      locall.bFC("UTF-8");
      if (this.ahsp == null)
      {
        this.ahsp = new com.tencent.e.c.a.a();
        this.ahsp.ahsq = 2;
        this.ahsp.ahsr = 201;
      }
      locall.j("phonetype", this.ahsp);
      locall.j("userinfo", jXe());
      locall.j("req", parama);
      parama = com.tencent.e.f.b.compress(locall.akn());
      if (parama == null)
      {
        parama = new RuntimeException("compress data fail");
        AppMethodBeat.o(138314);
        throw parama;
      }
    }
    catch (Exception parama)
    {
      parama = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(138314);
      return parama;
      parama = com.tencent.e.f.c.q(parama, com.tencent.e.f.c.jXz());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.b.b
 * JD-Core Version:    0.7.0.1
 */