package com.tencent.h.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.g.c.g;
import com.tencent.g.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int ZUZ;
  private com.tencent.g.d.a.b ZVa = null;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.ZUZ = 91;
  }
  
  private int getNetworkType()
  {
    AppMethodBeat.i(207735);
    try
    {
      if (g.mr(this.mContext) == 0)
      {
        AppMethodBeat.o(207735);
        return 2;
      }
      AppMethodBeat.o(207735);
      return 1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207735);
    }
    return 2;
  }
  
  public final byte[] a(String paramString1, String paramString2, com.tencent.h.a.c.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(207734);
    if (parama == null)
    {
      AppMethodBeat.o(207734);
      return null;
    }
    try
    {
      com.tencent.g.d.a locala = new com.tencent.g.d.a();
      locala.Kn();
      locala.cS(paramString1);
      locala.cT(paramString2);
      locala.bCX("UTF-8");
      if (this.ZVa == null)
      {
        this.ZVa = new com.tencent.g.d.a.b();
        this.ZVa.ZnQ = this.ZUZ;
        this.ZVa.ZnV = ((int)parama.ZTr);
        this.ZVa.ZnO = String.valueOf(parama.channelId);
        this.ZVa.ZnN = parama.ZnN;
        this.ZVa.ZnS = 0;
        this.ZVa.ZnU = parama.sdkVer;
        paramString2 = this.ZVa;
        if (TextUtils.isEmpty(parama.imei))
        {
          paramString1 = "";
          paramString2.imei = paramString1;
          this.ZVa.imsi = parama.imsi;
          this.ZVa.ZnT = 0;
        }
      }
      else
      {
        this.ZVa.ZnP = getNetworkType();
        locala.c("user", this.ZVa);
        locala.c("req", parama);
        paramString1 = com.tencent.g.c.a.compress(locala.Km());
        if (paramString1 != null) {
          break label264;
        }
        paramString1 = new RuntimeException("compress game1.data fail");
        AppMethodBeat.o(207734);
        throw paramString1;
      }
    }
    catch (Exception paramString1)
    {
      i.e("sensor_WupProxy", paramString1);
      paramString1 = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(207734);
      return paramString1;
      paramString1 = parama.imei;
      break;
      label264:
      paramString1 = com.tencent.g.c.b.p(paramString1, com.tencent.g.c.b.ion());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.e.a
 * JD-Core Version:    0.7.0.1
 */