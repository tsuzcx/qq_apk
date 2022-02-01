package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int JRE;
  private int JRF;
  private String JRG;
  private com.tencent.d.c.a.c JRH;
  private com.tencent.d.c.a.a JRI;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.JRE = -1;
    this.JRF = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.JRG = null;
    this.JRH = null;
    this.JRI = null;
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.ct(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.JRF = paramContext.versionCode;
    this.JRE = 82;
    this.mChannelId = "105901";
    this.JRG = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String aTg(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c fCt()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.JRH == null)
    {
      this.JRH = new com.tencent.d.c.a.c();
      this.JRH.JRS = this.JRE;
      this.JRH.JRX = this.JRF;
      this.JRH.JRP = this.mChannelId;
      this.JRH.JRO = this.JRG;
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
    this.JRH.JRT = new com.tencent.d.c.a.b();
    this.JRH.JRT.JRL = k;
    this.JRH.JRT.JRM = j;
    this.JRH.JRT.JRN = i;
    this.JRH.JRU = 0;
    this.JRH.JRW = d.getSDKVersion();
    this.JRH.imei = aTg(d.getIMEI(this.mContext));
    this.JRH.imsi = aTg(d.kJ(this.mContext));
    this.JRH.JRQ = aTg(Build.MODEL);
    this.JRH.yeO = aTg(d.kK(this.mContext));
    this.JRH.JSc = aTg(d.yD(true));
    this.JRH.JSd = aTg(d.yD(false));
    this.JRH.guid = null;
    this.JRH.JRV = 0;
    localObject = this.JRH;
    if (d.kL(this.mContext) == d.a.JUG) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).JRR = i;
      localObject = this.JRH;
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
      locall.fCQ();
      locall.aTp("viruscheck");
      locall.aTq("RiskCheck");
      locall.aTo("UTF-8");
      if (this.JRI == null)
      {
        this.JRI = new com.tencent.d.c.a.a();
        this.JRI.JRJ = 2;
        this.JRI.JRK = 201;
      }
      locall.put("phonetype", this.JRI);
      locall.put("userinfo", fCt());
      locall.put("req", parama);
      parama = com.tencent.d.f.b.compress(locall.JT());
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
      parama = com.tencent.d.f.c.n(parama, com.tencent.d.f.c.fCL());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */