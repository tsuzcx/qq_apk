package com.tencent.d.b;

import android.content.Context;
import android.os.Build;
import com.tencent.d.f.d;
import com.tencent.d.f.d.a;
import com.tencent.d.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int IpU;
  private int IpV;
  private String IpW;
  private com.tencent.d.c.a.c IpX;
  private com.tencent.d.c.a.a IpY;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.IpU = -1;
    this.IpV = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.IpW = null;
    this.IpX = null;
    this.IpY = null;
    this.mContext = paramContext;
    paramContext = com.tencent.d.f.a.ct(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.IpV = paramContext.versionCode;
    this.IpU = 82;
    this.mChannelId = "105901";
    this.IpW = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String aND(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.d.c.a.c fmc()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.IpX == null)
    {
      this.IpX = new com.tencent.d.c.a.c();
      this.IpX.Iqi = this.IpU;
      this.IpX.Iqn = this.IpV;
      this.IpX.Iqf = this.mChannelId;
      this.IpX.Iqe = this.IpW;
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
    this.IpX.Iqj = new com.tencent.d.c.a.b();
    this.IpX.Iqj.Iqb = k;
    this.IpX.Iqj.Iqc = j;
    this.IpX.Iqj.Iqd = i;
    this.IpX.Iqk = 0;
    this.IpX.Iqm = d.fmv();
    this.IpX.imei = aND(d.getIMEI(this.mContext));
    this.IpX.imsi = aND(d.kx(this.mContext));
    this.IpX.Iqg = aND(Build.MODEL);
    this.IpX.wSi = aND(d.ky(this.mContext));
    this.IpX.Iqs = aND(d.xt(true));
    this.IpX.Iqt = aND(d.xt(false));
    this.IpX.guid = null;
    this.IpX.Iql = 0;
    localObject = this.IpX;
    if (d.kz(this.mContext) == d.a.IsW) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.d.c.a.c)localObject).Iqh = i;
      localObject = this.IpX;
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
      locall.fmA();
      locall.aNM("viruscheck");
      locall.aNN("RiskCheck");
      locall.aNL("UTF-8");
      if (this.IpY == null)
      {
        this.IpY = new com.tencent.d.c.a.a();
        this.IpY.IpZ = 2;
        this.IpY.Iqa = 201;
      }
      locall.put("phonetype", this.IpY);
      locall.put("userinfo", fmc());
      locall.put("req", parama);
      parama = com.tencent.d.f.b.compress(locall.Kj());
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
      parama = com.tencent.d.f.c.n(parama, com.tencent.d.f.c.fmu());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.b.b
 * JD-Core Version:    0.7.0.1
 */