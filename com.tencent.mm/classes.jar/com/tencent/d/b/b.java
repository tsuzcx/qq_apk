package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int ZnD;
  private int ZnE;
  private String ZnF;
  private com.tencent.d.c.a.c ZnG;
  private com.tencent.d.c.a.a ZnH;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.ZnD = -1;
    this.ZnE = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.ZnF = null;
    this.ZnG = null;
    this.ZnH = null;
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.de(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.ZnE = paramContext.versionCode;
    this.ZnD = 82;
    this.mChannelId = "105901";
    this.ZnF = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String bCQ(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c inT()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.ZnG == null)
    {
      this.ZnG = new com.tencent.d.c.a.c();
      this.ZnG.ZnQ = this.ZnD;
      this.ZnG.ZnV = this.ZnE;
      this.ZnG.ZnO = this.mChannelId;
      this.ZnG.ZnN = this.ZnF;
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
    this.ZnG.ZnR = new com.tencent.d.c.a.b();
    this.ZnG.ZnR.ZnK = k;
    this.ZnG.ZnR.ZnL = j;
    this.ZnG.ZnR.ZnM = i;
    this.ZnG.ZnS = 0;
    this.ZnG.ZnU = d.getSDKVersion();
    this.ZnG.imei = bCQ(d.getIMEI(this.mContext));
    this.ZnG.imsi = bCQ(d.lW(this.mContext));
    this.ZnG.RGW = bCQ(Build.MODEL);
    this.ZnG.aid = bCQ(d.lX(this.mContext));
    this.ZnG.Zoa = bCQ(d.Ip(true));
    this.ZnG.Zob = bCQ(d.Ip(false));
    this.ZnG.guid = null;
    this.ZnG.ZnT = 0;
    localObject = this.ZnG;
    if (d.lY(this.mContext) == d.a.ZqE) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).ZnP = i;
      localObject = this.ZnG;
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
      locall.Kn();
      locall.cS("viruscheck");
      locall.cT("RiskCheck");
      locall.bCX("UTF-8");
      if (this.ZnH == null)
      {
        this.ZnH = new com.tencent.d.c.a.a();
        this.ZnH.ZnI = 2;
        this.ZnH.ZnJ = 201;
      }
      locall.c("phonetype", this.ZnH);
      locall.c("userinfo", inT());
      locall.c("req", parama);
      parama = com.tencent.d.f.b.compress(locall.Km());
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
      parama = com.tencent.d.f.c.p(parama, com.tencent.d.f.c.ion());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */