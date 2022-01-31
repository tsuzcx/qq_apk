package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appstorage.a.a;
import com.tencent.mm.plugin.appbrand.appstorage.f;
import com.tencent.mm.plugin.appbrand.appstorage.f.a;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.a.i;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  implements com.tencent.luggage.sdk.customize.b
{
  public final f cc(String paramString)
  {
    AppMethodBeat.i(143450);
    f.a locala = f.gZx;
    paramString = f.a.hr(new p(((a)com.tencent.mm.kernel.g.E(a.class)).zt(paramString)).longValue());
    AppMethodBeat.o(143450);
    return paramString;
  }
  
  public final <T> T w(Class<T> paramClass)
  {
    AppMethodBeat.i(132096);
    paramClass = com.tencent.mm.plugin.appbrand.app.g.w(paramClass);
    AppMethodBeat.o(132096);
    return paramClass;
  }
  
  public final ay we()
  {
    AppMethodBeat.i(132097);
    ay localay = ((d)com.tencent.mm.kernel.g.E(d.class)).we();
    AppMethodBeat.o(132097);
    return localay;
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.b wf()
  {
    AppMethodBeat.i(132098);
    com.tencent.mm.plugin.appbrand.appstorage.b localb = com.tencent.mm.plugin.appbrand.app.g.wf();
    AppMethodBeat.o(132098);
    return localb;
  }
  
  public final com.tencent.mm.plugin.appbrand.config.c wg()
  {
    AppMethodBeat.i(132099);
    com.tencent.mm.plugin.appbrand.config.c localc = com.tencent.mm.plugin.appbrand.app.g.wg();
    AppMethodBeat.o(132099);
    return localc;
  }
  
  public final void wh()
  {
    AppMethodBeat.i(132100);
    com.tencent.mm.pluginsdk.g.a.a.b localb = b.c.dmg();
    b.c.dmg();
    s locals = q.a.dmz().alQ(i.hd(38, 1));
    if (locals == null) {}
    for (int i = 0;; i = bo.getInt(locals.field_fileVersion, 0))
    {
      localb.e(38, 1, i, false);
      AppMethodBeat.o(132100);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */