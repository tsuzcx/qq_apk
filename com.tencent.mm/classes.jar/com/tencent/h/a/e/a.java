package com.tencent.h.a.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.g.c.g;
import com.tencent.g.c.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int ahZy;
  private com.tencent.g.d.a.b ahZz = null;
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.ahZy = 91;
  }
  
  private int getNetworkType()
  {
    AppMethodBeat.i(212068);
    try
    {
      if (g.oH(this.mContext) == 0) {
        return 2;
      }
      return 1;
    }
    finally
    {
      AppMethodBeat.o(212068);
    }
    return 2;
  }
  
  public final byte[] a(String paramString1, String paramString2, com.tencent.h.a.c.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(212078);
    if (parama == null)
    {
      AppMethodBeat.o(212078);
      return null;
    }
    try
    {
      com.tencent.g.d.a locala = new com.tencent.g.d.a();
      locala.ako();
      locala.em(paramString1);
      locala.en(paramString2);
      locala.bFC("UTF-8");
      if (this.ahZz == null)
      {
        this.ahZz = new com.tencent.g.d.a.b();
        this.ahZz.ahsy = this.ahZy;
        this.ahZz.ahsD = ((int)parama.ahXR);
        this.ahZz.ahsw = String.valueOf(parama.channelId);
        this.ahZz.ahsv = parama.ahsv;
        this.ahZz.ahsA = 0;
        this.ahZz.ahsC = parama.sdkVer;
        paramString2 = this.ahZz;
        if (TextUtils.isEmpty(parama.imei))
        {
          paramString1 = "";
          paramString2.imei = paramString1;
          this.ahZz.imsi = parama.imsi;
          this.ahZz.ahsB = 0;
        }
      }
      else
      {
        this.ahZz.ahsx = getNetworkType();
        locala.j("user", this.ahZz);
        locala.j("req", parama);
        paramString1 = com.tencent.g.c.a.compress(locala.akn());
        if (paramString1 != null) {
          break label264;
        }
        paramString1 = new RuntimeException("compress game1.data fail");
        AppMethodBeat.o(212078);
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
      AppMethodBeat.o(212078);
      return paramString1;
      paramString1 = parama.imei;
      break;
      label264:
      paramString1 = com.tencent.g.c.b.q(paramString1, com.tencent.g.c.b.jXz());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.e.a
 * JD-Core Version:    0.7.0.1
 */