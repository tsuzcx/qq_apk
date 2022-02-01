package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class f
{
  private static final Map<String, a> iEJ;
  public static final f iEK;
  
  static
  {
    AppMethodBeat.i(149653);
    iEK = new f();
    iEJ = (Map)new LinkedHashMap();
    AppMethodBeat.o(149653);
  }
  
  public static a II(String paramString)
  {
    AppMethodBeat.i(149651);
    p.h(paramString, "name");
    paramString = (a)iEJ.get(paramString);
    AppMethodBeat.o(149651);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(149652);
    p.h(paramString, "name");
    p.h(parama, "implement");
    iEJ.put(paramString, parama);
    AppMethodBeat.o(149652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.f
 * JD-Core Version:    0.7.0.1
 */