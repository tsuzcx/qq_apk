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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;

public final class b
  implements m
{
  public static l iyx;
  public static k iyy;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      h.JZN.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    h.JZN.f(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(198629);
    ac.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    iyx.d(paramIntent, paramContext);
    AppMethodBeat.o(198629);
  }
  
  public static void j(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      ac.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.agS();
      g.agR().agA().set(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(k paramk)
  {
    iyy = paramk;
  }
  
  public final void a(l paraml)
  {
    iyx = paraml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */