package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;

public final class b
  implements m
{
  public static l hYt;
  public static k hYu;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      h.Iye.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    h.Iye.f(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(192933);
    ad.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    hYt.d(paramIntent, paramContext);
    AppMethodBeat.o(192933);
  }
  
  public static void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      ad.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.afC();
      g.afB().afk().set(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(k paramk)
  {
    hYu = paramk;
  }
  
  public final void a(l paraml)
  {
    hYt = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */