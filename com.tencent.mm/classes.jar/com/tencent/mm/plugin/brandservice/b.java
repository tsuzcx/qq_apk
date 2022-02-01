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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;

public final class b
  implements n
{
  public static l iUA;
  public static m iUz;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      h.MqF.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    h.MqF.f(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(208378);
    ae.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    iUz.d(paramIntent, paramContext);
    AppMethodBeat.o(208378);
  }
  
  public static void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      ae.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.ajS();
      g.ajR().ajA().set(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(l paraml)
  {
    iUA = paraml;
  }
  
  public final void a(m paramm)
  {
    iUz = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */