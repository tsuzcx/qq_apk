package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.f.d;
import com.tencent.e.f.d.a;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int BiR;
  private int BiS;
  private String BiT;
  private com.tencent.e.c.a.c BiU;
  private com.tencent.e.c.a.a BiV;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(114472);
    this.mContext = null;
    this.BiR = -1;
    this.BiS = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.BiT = null;
    this.BiU = null;
    this.BiV = null;
    this.mContext = paramContext;
    paramContext = com.tencent.e.f.a.cb(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.BiS = paramContext.versionCode;
    this.BiR = 82;
    this.mChannelId = "105901";
    this.BiT = "7AD75E27CD5842F6";
    AppMethodBeat.o(114472);
  }
  
  private static String awy(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.e.c.a.c dUw()
  {
    int m = 2;
    AppMethodBeat.i(114474);
    if (this.BiU == null)
    {
      this.BiU = new com.tencent.e.c.a.c();
      this.BiU.Bjf = this.BiR;
      this.BiU.Bjk = this.BiS;
      this.BiU.Bjc = this.mChannelId;
      this.BiU.Bjb = this.BiT;
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
    this.BiU.Bjg = new com.tencent.e.c.a.b();
    this.BiU.Bjg.BiY = k;
    this.BiU.Bjg.BiZ = j;
    this.BiU.Bjg.Bja = i;
    this.BiU.Bjh = 0;
    this.BiU.Bjj = d.dUQ();
    this.BiU.imei = awy(d.getIMEI(this.mContext));
    this.BiU.imsi = awy(d.jb(this.mContext));
    this.BiU.Bjd = awy(Build.MODEL);
    this.BiU.rpv = awy(d.jc(this.mContext));
    this.BiU.Bjp = awy(d.rU(true));
    this.BiU.Bjq = awy(d.rU(false));
    this.BiU.guid = null;
    this.BiU.Bji = 0;
    localObject = this.BiU;
    if (d.jd(this.mContext) == d.a.BlC) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.e.c.a.c)localObject).Bje = i;
      localObject = this.BiU;
      AppMethodBeat.o(114474);
      return localObject;
    }
  }
  
  public final byte[] a(com.tencent.e.c.b.a parama)
  {
    AppMethodBeat.i(114473);
    Object localObject = null;
    try
    {
      l locall = new l();
      locall.dUW();
      locall.awH("viruscheck");
      locall.awI("RiskCheck");
      locall.awG("UTF-8");
      if (this.BiV == null)
      {
        this.BiV = new com.tencent.e.c.a.a();
        this.BiV.BiW = 2;
        this.BiV.BiX = 201;
      }
      locall.put("phonetype", this.BiV);
      locall.put("userinfo", dUw());
      locall.put("req", parama);
      parama = com.tencent.e.f.b.compress(locall.AJ());
      if (parama == null)
      {
        parama = new RuntimeException("compress data fail");
        AppMethodBeat.o(114473);
        throw parama;
      }
    }
    catch (Exception parama)
    {
      parama = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(114473);
      return parama;
      parama = com.tencent.e.f.c.m(parama, com.tencent.e.f.c.dUP());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.b.b
 * JD-Core Version:    0.7.0.1
 */