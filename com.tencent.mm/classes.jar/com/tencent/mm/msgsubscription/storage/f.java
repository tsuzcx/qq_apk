package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class f
{
  private static final Map<String, a> iBQ;
  public static final f iBR;
  
  static
  {
    AppMethodBeat.i(149653);
    iBR = new f();
    iBQ = (Map)new LinkedHashMap();
    AppMethodBeat.o(149653);
  }
  
  public static a Ig(String paramString)
  {
    AppMethodBeat.i(149651);
    p.h(paramString, "name");
    paramString = (a)iBQ.get(paramString);
    AppMethodBeat.o(149651);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(149652);
    p.h(paramString, "name");
    p.h(parama, "implement");
    iBQ.put(paramString, parama);
    AppMethodBeat.o(149652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.f
 * JD-Core Version:    0.7.0.1
 */