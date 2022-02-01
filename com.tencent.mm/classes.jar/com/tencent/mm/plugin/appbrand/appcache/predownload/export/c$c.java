package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.g;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.h;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.config.y;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getByUpdateVersion", "", "appId", "", "invoke"})
final class c$c
  extends q
  implements b<String, Integer>
{
  public static final c nKz;
  
  static
  {
    AppMethodBeat.i(279707);
    nKz = new c();
    AppMethodBeat.o(279707);
  }
  
  c$c()
  {
    super(1);
  }
  
  public static int adq(String paramString)
  {
    AppMethodBeat.i(279706);
    p.k(paramString, "appId");
    Object localObject = y.afk(paramString);
    CharSequence localCharSequence = (CharSequence)localObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i != 0)
      {
        localObject = t.oak;
        localObject = (String)t.bLw().get(paramString);
      }
      paramString = (CharSequence)localObject;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label91;
      }
    }
    label91:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label96;
      }
      AppMethodBeat.o(279706);
      return 0;
      i = 0;
      break;
    }
    label96:
    paramString = ((h)m.W(h.class)).adr((String)localObject);
    if (paramString != null)
    {
      i = paramString.field_appVersion;
      AppMethodBeat.o(279706);
      return i;
    }
    AppMethodBeat.o(279706);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.c.c
 * JD-Core Version:    0.7.0.1
 */