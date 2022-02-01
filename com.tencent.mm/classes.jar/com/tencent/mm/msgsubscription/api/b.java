package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.b.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b piw;
  private static final Map<String, a> pix;
  
  static
  {
    AppMethodBeat.i(236672);
    piw = new b();
    pix = (Map)new LinkedHashMap();
    AppMethodBeat.o(236672);
  }
  
  public static a QW(String paramString)
  {
    AppMethodBeat.i(236661);
    s.u(paramString, "name");
    paramString = (a)pix.get(paramString);
    AppMethodBeat.o(236661);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(236668);
    s.u(paramString, "name");
    s.u(parama, "implement");
    pix.put(paramString, parama);
    AppMethodBeat.o(236668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.api.b
 * JD-Core Version:    0.7.0.1
 */