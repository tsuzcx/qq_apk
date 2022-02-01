package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;

public final class b
  implements n
{
  public static m jRt;
  public static l jRu;
  
  public static void a(String paramString, Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(5534);
    if (paramLong > 0L)
    {
      h.RTc.a(paramRunnable, paramLong, paramString);
      AppMethodBeat.o(5534);
      return;
    }
    h.RTc.b(paramRunnable, paramString);
    AppMethodBeat.o(5534);
  }
  
  public static void d(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(194842);
    Log.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    jRt.d(paramIntent, paramContext);
    AppMethodBeat.o(194842);
  }
  
  public static void k(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(5533);
    if (paramObject == null) {}
    for (String str = "null";; str = paramObject.toString())
    {
      Log.i("MicroMsg.BrandService.BrandServiceApplication", "set config, key[%d], value[%s]", new Object[] { Integer.valueOf(paramInt), str });
      g.aAi();
      g.aAh().azQ().set(paramInt, paramObject);
      AppMethodBeat.o(5533);
      return;
    }
  }
  
  public final void a(l paraml)
  {
    jRu = paraml;
  }
  
  public final void a(m paramm)
  {
    jRt = paramm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b
 * JD-Core Version:    0.7.0.1
 */