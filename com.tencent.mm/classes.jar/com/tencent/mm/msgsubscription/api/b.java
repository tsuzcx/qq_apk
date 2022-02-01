package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.b.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class b
{
  private static final Map<String, a> moF;
  public static final b moG;
  
  static
  {
    AppMethodBeat.i(212303);
    moG = new b();
    moF = (Map)new LinkedHashMap();
    AppMethodBeat.o(212303);
  }
  
  public static a YR(String paramString)
  {
    AppMethodBeat.i(212297);
    p.k(paramString, "name");
    paramString = (a)moF.get(paramString);
    AppMethodBeat.o(212297);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(212300);
    p.k(paramString, "name");
    p.k(parama, "implement");
    moF.put(paramString, parama);
    AppMethodBeat.o(212300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.b
 * JD-Core Version:    0.7.0.1
 */