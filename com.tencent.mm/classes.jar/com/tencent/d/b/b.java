package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private com.tencent.d.c.a.a LLA;
  private int LLw;
  private int LLx;
  private String LLy;
  private com.tencent.d.c.a.c LLz;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.LLw = -1;
    this.LLx = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.LLy = null;
    this.LLz = null;
    this.LLA = null;
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.cy(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.LLx = paramContext.versionCode;
    this.LLw = 82;
    this.mChannelId = "105901";
    this.LLy = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String aZg(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c fTJ()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.LLz == null)
    {
      this.LLz = new com.tencent.d.c.a.c();
      this.LLz.LLJ = this.LLw;
      this.LLz.LLO = this.LLx;
      this.LLz.LLH = this.mChannelId;
      this.LLz.LLG = this.LLy;
    }
    try
    {
      localObject = this.mVersionName.trim().split("[\\.]");
      if ((localObject == null) || (localObject.length < 3)) {
        break label345;
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
    this.LLz.LLK = new com.tencent.d.c.a.b();
    this.LLz.LLK.LLD = k;
    this.LLz.LLK.LLE = j;
    this.LLz.LLK.LLF = i;
    this.LLz.LLL = 0;
    this.LLz.LLN = d.getSDKVersion();
    this.LLz.imei = aZg(d.getIMEI(this.mContext));
    this.LLz.imsi = aZg(d.kW(this.mContext));
    this.LLz.FtF = aZg(Build.MODEL);
    this.LLz.zuP = aZg(d.kX(this.mContext));
    this.LLz.LLT = aZg(d.zq(true));
    this.LLz.LLU = aZg(d.zq(false));
    this.LLz.guid = null;
    this.LLz.LLM = 0;
    localObject = this.LLz;
    if (d.kY(this.mContext) == d.a.LOz) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).LLI = i;
      localObject = this.LLz;
      AppMethodBeat.o(138315);
      return localObject;
    }
  }
  
  public final byte[] a(com.tencent.d.c.b.a parama)
  {
    AppMethodBeat.i(138314);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.fUi();
      locall.aZp("viruscheck");
      locall.aZq("RiskCheck");
      locall.aZo("UTF-8");
      if (this.LLA == null)
      {
        this.LLA = new com.tencent.d.c.a.a();
        this.LLA.LLB = 2;
        this.LLA.LLC = 201;
      }
      locall.put("phonetype", this.LLA);
      locall.put("userinfo", fTJ());
      locall.put("req", parama);
      parama = com.tencent.d.f.b.compress(locall.Ls());
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
      parama = com.tencent.d.f.c.n(parama, com.tencent.d.f.c.fUd());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */