package com.tencent.mm.aa.c;

import android.content.Context;
import android.util.Log;
import com.tencent.mm.aa.d.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class c
{
  public c.a dIO;
  private a dIP;
  public d dIQ;
  public b dIR;
  
  public c(Context paramContext, e parame, a parama, b paramb)
  {
    this.dIO = new c.a(paramContext, parame);
    this.dIP = parama;
    this.dIR = paramb;
  }
  
  public final String d(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      Object localObject = this.dIQ;
      if (bk.bl(paramString1)) {}
      for (localObject = null; localObject == null; localObject = (com.tencent.mm.aa.b.b)((d)localObject).dIW.get(paramString1)) {
        return this.dIR.fN(paramString1);
      }
      paramString2 = this.dIR.a(this.dIO, this.dIP, (com.tencent.mm.aa.b.b)localObject, paramString2, new c.1(this, paramInt));
      return paramString2;
    }
    catch (Exception paramString2)
    {
      y.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[] { paramString1, Log.getStackTraceString(paramString2) });
      throw paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.c
 * JD-Core Version:    0.7.0.1
 */