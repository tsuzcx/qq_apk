package com.tencent.i.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.h.c.f;
import com.tencent.h.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int Stw;
  private com.tencent.h.d.a.b Stx = null;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.Stw = 91;
  }
  
  private int getNetworkType()
  {
    AppMethodBeat.i(214829);
    try
    {
      if (f.lt(this.mContext) == 0)
      {
        AppMethodBeat.o(214829);
        return 2;
      }
      AppMethodBeat.o(214829);
      return 1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(214829);
    }
    return 2;
  }
  
  public final byte[] a(String paramString1, String paramString2, com.tencent.i.a.c.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(214828);
    if (parama == null)
    {
      AppMethodBeat.o(214828);
      return null;
    }
    try
    {
      com.tencent.h.d.a locala = new com.tencent.h.d.a();
      locala.IK();
      locala.cy(paramString1);
      locala.cz(paramString2);
      locala.bqf("UTF-8");
      if (this.Stx == null)
      {
        this.Stx = new com.tencent.h.d.a.b();
        this.Stx.RLj = this.Stw;
        this.Stx.RLo = ((int)parama.SrO);
        this.Stx.RLh = String.valueOf(parama.channelId);
        this.Stx.RLg = parama.RLg;
        this.Stx.RLl = 0;
        this.Stx.RLn = parama.sdkVer;
        paramString2 = this.Stx;
        if (TextUtils.isEmpty(parama.imei))
        {
          paramString1 = "";
          paramString2.imei = paramString1;
          this.Stx.imsi = parama.imsi;
          this.Stx.RLm = 0;
        }
      }
      else
      {
        this.Stx.RLi = getNetworkType();
        locala.put("user", this.Stx);
        locala.put("req", parama);
        paramString1 = com.tencent.h.c.a.compress(locala.IJ());
        if (paramString1 != null) {
          break label264;
        }
        paramString1 = new RuntimeException("compress game1.data fail");
        AppMethodBeat.o(214828);
        throw paramString1;
      }
    }
    catch (Exception paramString1)
    {
      h.e("sensor_WupProxy", paramString1);
      paramString1 = localObject;
    }
    for (;;)
    {
      AppMethodBeat.o(214828);
      return paramString1;
      paramString1 = parama.imei;
      break;
      label264:
      paramString1 = com.tencent.h.c.b.n(paramString1, com.tencent.h.c.b.hkP());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.e.a
 * JD-Core Version:    0.7.0.1
 */