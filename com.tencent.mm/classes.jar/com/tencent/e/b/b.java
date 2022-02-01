package com.tencent.e.b;

import android.content.Context;
import android.os.Build;
import com.tencent.e.f.d;
import com.tencent.e.f.d.a;
import com.tencent.e.f.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private int RKW;
  private int RKX;
  private String RKY;
  private com.tencent.e.c.a.c RKZ;
  private com.tencent.e.c.a.a RLa;
  private String mChannelId;
  private Context mContext;
  private String mVersionName;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(138313);
    this.mContext = null;
    this.RKW = -1;
    this.RKX = -1;
    this.mVersionName = null;
    this.mChannelId = null;
    this.RKY = null;
    this.RKZ = null;
    this.RLa = null;
    this.mContext = paramContext;
    paramContext = com.tencent.e.f.a.cT(paramContext, paramContext.getPackageName());
    this.mVersionName = paramContext.versionName;
    this.RKX = paramContext.versionCode;
    this.RKW = 82;
    this.mChannelId = "105901";
    this.RKY = "7AD75E27CD5842F6";
    AppMethodBeat.o(138313);
  }
  
  private static String bpY(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private com.tencent.e.c.a.c hkv()
  {
    int m = 2;
    AppMethodBeat.i(138315);
    if (this.RKZ == null)
    {
      this.RKZ = new com.tencent.e.c.a.c();
      this.RKZ.RLj = this.RKW;
      this.RKZ.RLo = this.RKX;
      this.RKZ.RLh = this.mChannelId;
      this.RKZ.RLg = this.RKY;
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
    this.RKZ.RLk = new com.tencent.e.c.a.b();
    this.RKZ.RLk.RLd = k;
    this.RKZ.RLk.RLe = j;
    this.RKZ.RLk.RLf = i;
    this.RKZ.RLl = 0;
    this.RKZ.RLn = d.getSDKVersion();
    this.RKZ.imei = bpY(d.getIMEI(this.mContext));
    this.RKZ.imsi = bpY(d.kY(this.mContext));
    this.RKZ.KFF = bpY(Build.MODEL);
    this.RKZ.aid = bpY(d.kZ(this.mContext));
    this.RKZ.RLt = bpY(d.DO(true));
    this.RKZ.RLu = bpY(d.DO(false));
    this.RKZ.guid = null;
    this.RKZ.RLm = 0;
    localObject = this.RKZ;
    if (d.la(this.mContext) == d.a.RNY) {}
    for (i = m;; i = 1)
    {
      ((com.tencent.e.c.a.c)localObject).RLi = i;
      localObject = this.RKZ;
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
      locall.IK();
      locall.cy("viruscheck");
      locall.cz("RiskCheck");
      locall.bqf("UTF-8");
      if (this.RLa == null)
      {
        this.RLa = new com.tencent.e.c.a.a();
        this.RLa.RLb = 2;
        this.RLa.RLc = 201;
      }
      locall.put("phonetype", this.RLa);
      locall.put("userinfo", hkv());
      locall.put("req", parama);
      parama = com.tencent.e.f.b.compress(locall.IJ());
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
      parama = com.tencent.e.f.c.n(parama, com.tencent.e.f.c.hkP());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.b.b
 * JD-Core Version:    0.7.0.1
 */