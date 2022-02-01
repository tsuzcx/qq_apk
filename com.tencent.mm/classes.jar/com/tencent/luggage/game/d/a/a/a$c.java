package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.magicbrush.d.b;
import com.tencent.magicbrush.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;

final class a$c
  implements d.b, d.d
{
  private a$c(a parama) {}
  
  public final void onConsole(String paramString)
  {
    AppMethodBeat.i(130552);
    ad.i("Luggage.AppBrandGameServiceLogicImp", "[WAGame][CONSOLE] output = [%s]", new Object[] { paramString });
    com.tencent.luggage.sdk.d.c localc = ((com.tencent.luggage.sdk.b.a.c.c)this.ckh.El()).En();
    if ((localc == null) || (localc.Fa() == null) || (localc.Fa().cmE)) {
      a.a(this.ckh, paramString);
    }
    AppMethodBeat.o(130552);
  }
  
  public final void onFirstFrame()
  {
    AppMethodBeat.i(130553);
    a.d(this.ckh);
    AppMethodBeat.o(130553);
  }
  
  public final void onJSError(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(130554);
    ad.e("Luggage.AppBrandGameServiceLogicImp", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
    Object localObject = (t)((com.tencent.luggage.sdk.b.a.c.c)this.ckh.El()).aYh().P(t.class);
    if (paramInt == ((t)localObject).bqi().bqh())
    {
      cj.a(((com.tencent.luggage.sdk.b.a.c.c)this.ckh.El()).aYh(), "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { p.Vc(paramString1), p.Vc(paramString2) }), 0);
      AppMethodBeat.o(130554);
      return;
    }
    localObject = ((t)localObject).tS(paramInt);
    if (localObject == null)
    {
      paramString1 = new IllegalStateException("j2v8 not follow the pattern");
      AppMethodBeat.o(130554);
      throw paramString1;
    }
    ck.a((i)localObject, "onError", String.format(Locale.ENGLISH, "{'message':'%s', 'stack': '%s'}", new Object[] { p.Vc(paramString1), p.Vc(paramString2) }));
    AppMethodBeat.o(130554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */