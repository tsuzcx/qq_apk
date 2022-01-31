package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class e$3
  implements c.a
{
  e$3(e parame, c paramc) {}
  
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
  {
    AppMethodBeat.i(143163);
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.gYf) && (!bo.isNullOrNil(paramString)) && (paramString.equals(this.hty.htw)))
    {
      ab.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: %s trigger background, pause recording", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.game.g.b.a(this.htp.getAppId(), e.f(this.htp)).e(new e.3.1(this));
      AppMethodBeat.o(143163);
      return;
    }
    if ((paramb == com.tencent.mm.plugin.appbrand.b.b.gYe) && (!bo.isNullOrNil(paramString)) && (paramString.equals(this.hty.htw)))
    {
      ab.i("MicroMsg.WAGameJsApiScreenRecorderOperate", "hy: %s trigger foreground, resume recording", new Object[] { paramString });
      com.tencent.mm.plugin.appbrand.game.g.b.a(this.htp.getAppId(), e.f(this.htp)).f(new e.3.2(this));
    }
    AppMethodBeat.o(143163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.e.3
 * JD-Core Version:    0.7.0.1
 */