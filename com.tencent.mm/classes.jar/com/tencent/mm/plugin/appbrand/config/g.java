package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bu;
import com.tencent.mm.pluginsdk.k.a.a.b;
import com.tencent.mm.pluginsdk.k.a.a.i;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends IListener<bu>
{
  public g()
  {
    AppMethodBeat.i(160970);
    this.__eventId = bu.class.getName().hashCode();
    AppMethodBeat.o(160970);
  }
  
  public static void bLf()
  {
    AppMethodBeat.i(186211);
    if (MMApplicationContext.isMainProcess())
    {
      b localb = b.hii();
      b.hii();
      r localr = p.a.hiK().bqC(i.lW(38, 1));
      if (localr == null) {}
      for (int i = 0;; i = Util.getInt(localr.field_fileVersion, 0))
      {
        localb.g(38, 1, i, false);
        AppMethodBeat.o(186211);
        return;
      }
    }
    Log.i("MicroMsg.AppBrand.AppBrandGlobalSystemCon", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(186211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.g
 * JD-Core Version:    0.7.0.1
 */