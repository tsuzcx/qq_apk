package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class f
{
  private static final Map<String, a> hHU;
  public static final f hHV;
  
  static
  {
    AppMethodBeat.i(149653);
    hHV = new f();
    hHU = (Map)new LinkedHashMap();
    AppMethodBeat.o(149653);
  }
  
  public static a AN(String paramString)
  {
    AppMethodBeat.i(149651);
    k.h(paramString, "name");
    paramString = (a)hHU.get(paramString);
    AppMethodBeat.o(149651);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(149652);
    k.h(paramString, "name");
    k.h(parama, "implement");
    hHU.put(paramString, parama);
    AppMethodBeat.o(149652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.f
 * JD-Core Version:    0.7.0.1
 */