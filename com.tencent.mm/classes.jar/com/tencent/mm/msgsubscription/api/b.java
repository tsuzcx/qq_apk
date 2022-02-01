package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.b.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class b
{
  private static final Map<String, a> jyZ;
  public static final b jza;
  
  static
  {
    AppMethodBeat.i(223231);
    jza = new b();
    jyZ = (Map)new LinkedHashMap();
    AppMethodBeat.o(223231);
  }
  
  public static a Ru(String paramString)
  {
    AppMethodBeat.i(223229);
    p.h(paramString, "name");
    paramString = (a)jyZ.get(paramString);
    AppMethodBeat.o(223229);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(223230);
    p.h(paramString, "name");
    p.h(parama, "implement");
    jyZ.put(paramString, parama);
    AppMethodBeat.o(223230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.b
 * JD-Core Version:    0.7.0.1
 */