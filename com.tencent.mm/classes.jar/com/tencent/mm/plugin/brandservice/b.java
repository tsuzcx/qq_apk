package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

public final class b
  implements o
{
  public static n gmO;
  public static m gmP;
  
  public static void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(152624);
    a("BrandServiceWorkerThread", paramRunnable, 0L);
    AppMethodBeat.o(152624);
  }
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(13799);
    if (paramLong > 0L)
    {
      d.ysm.b(paramRunnable, paramString, paramLong);
      AppMethodBeat.o(13799);
      return;
    }
    d.ysm.b(paramRunnable, paramString);
    AppMethodBeat.o(13799);
  }
  
  public static void i(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(13798);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      ab.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.RM();
      g.RL().Ru().set(paramInt, paramObject);
      AppMethodBeat.o(13798);
      return;
    }
  }
  
  public final void a(m paramm)
  {
    gmP = paramm;
  }
  
  public final void a(n paramn)
  {
    gmO = paramn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */