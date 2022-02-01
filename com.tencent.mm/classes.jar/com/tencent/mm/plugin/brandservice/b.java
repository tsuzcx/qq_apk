package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;

public final class b
  implements n
{
  public static m iRG;
  public static l iRH;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      h.LTJ.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    h.LTJ.f(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(209425);
    ad.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    iRG.d(paramIntent, paramContext);
    AppMethodBeat.o(209425);
  }
  
  public static void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      ad.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.ajD();
      g.ajC().ajl().set(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(l paraml)
  {
    iRH = paraml;
  }
  
  public final void a(m paramm)
  {
    iRG = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */