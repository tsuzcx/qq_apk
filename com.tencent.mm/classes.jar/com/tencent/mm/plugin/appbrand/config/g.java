package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandContactABTests;", "", "()V", "TAG", "", "isSupportSendVideo", "", "()Z", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g qWE;
  
  static
  {
    AppMethodBeat.i(323392);
    qWE = new g();
    AppMethodBeat.o(323392);
  }
  
  public static boolean ckz()
  {
    AppMethodBeat.i(323389);
    Object localObject = t.raH;
    boolean bool = t.bnM();
    localObject = (c)h.ax(c.class);
    if (localObject != null) {
      bool = ((c)localObject).a(c.a.yQy, bool);
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandContactABTests", s.X("isSupportSendVideo#get, ", Boolean.valueOf(bool)));
      AppMethodBeat.o(323389);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g
 * JD-Core Version:    0.7.0.1
 */