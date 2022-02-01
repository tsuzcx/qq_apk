package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.pluginsdk.j.a.a.b;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends IListener<bp>
{
  public g()
  {
    AppMethodBeat.i(160970);
    this.__eventId = bp.class.getName().hashCode();
    AppMethodBeat.o(160970);
  }
  
  public static void bzQ()
  {
    AppMethodBeat.i(194308);
    if (MMApplicationContext.isMainProcess())
    {
      b localb = b.gnC();
      b.gnC();
      s locals = q.a.goa().beg(i.kD(38, 1));
      if (locals == null) {}
      for (int i = 0;; i = Util.getInt(locals.field_fileVersion, 0))
      {
        localb.g(38, 1, i, false);
        AppMethodBeat.o(194308);
        return;
      }
    }
    Log.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(194308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g
 * JD-Core Version:    0.7.0.1
 */