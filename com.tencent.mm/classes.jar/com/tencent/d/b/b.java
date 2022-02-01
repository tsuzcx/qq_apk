package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int Miv;
  private int Miw;
  private String Mix;
  private com.tencent.d.c.a.c Miy;
  private com.tencent.d.c.a.a Miz;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.Miv = -1;
    this.Miw = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.Mix = null;
    this.Miy = null;
    this.Miz = null;
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.cz(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.Miw = paramContext.versionCode;
    this.Miv = 82;
    this.mChannelId = "105901";
    this.Mix = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String baJ(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c fYj()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.Miy == null)
    {
      this.Miy = new com.tencent.d.c.a.c();
      this.Miy.MiI = this.Miv;
      this.Miy.MiN = this.Miw;
      this.Miy.MiG = this.mChannelId;
      this.Miy.MiF = this.Mix;
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
    this.Miy.MiJ = new com.tencent.d.c.a.b();
    this.Miy.MiJ.MiC = k;
    this.Miy.MiJ.MiD = j;
    this.Miy.MiJ.MiE = i;
    this.Miy.MiK = 0;
    this.Miy.MiM = d.getSDKVersion();
    this.Miy.imei = baJ(d.getIMEI(this.mContext));
    this.Miy.imsi = baJ(d.ld(this.mContext));
    this.Miy.FMd = baJ(Build.MODEL);
    this.Miy.zMk = baJ(d.le(this.mContext));
    this.Miy.MiS = baJ(d.zE(true));
    this.Miy.MiT = baJ(d.zE(false));
    this.Miy.guid = null;
    this.Miy.MiL = 0;
    localObject = this.Miy;
    if (d.lf(this.mContext) == d.a.Mly) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).MiH = i;
      localObject = this.Miy;
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
      locall.fYH();
      locall.baS("viruscheck");
      locall.baT("RiskCheck");
      locall.baR("UTF-8");
      if (this.Miz == null)
      {
        this.Miz = new com.tencent.d.c.a.a();
        this.Miz.MiA = 2;
        this.Miz.MiB = 201;
      }
      locall.put("phonetype", this.Miz);
      locall.put("userinfo", fYj());
      locall.put("req", parama);
      parama = com.tencent.d.f.b.compress(locall.LA());
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
      parama = com.tencent.d.f.c.o(parama, com.tencent.d.f.c.fYD());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */