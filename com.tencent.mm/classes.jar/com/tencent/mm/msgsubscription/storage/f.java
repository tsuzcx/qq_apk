package com.tencent.mm.msgsubscription.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/storage/SubscribeMsgServiceFactory;", "", "()V", "NAME_BIZ", "", "NAME_WXA", "imps", "", "Lcom/tencent/mm/msgsubscription/storage/BaseSubscribeMsgService;", "getInstance", "name", "register", "", "implement", "unregister", "plugin-comm_release"})
public final class f
{
  private static final Map<String, a> iiw;
  public static final f iix;
  
  static
  {
    AppMethodBeat.i(149653);
    iix = new f();
    iiw = (Map)new LinkedHashMap();
    AppMethodBeat.o(149653);
  }
  
  public static a ES(String paramString)
  {
    AppMethodBeat.i(149651);
    k.h(paramString, "name");
    paramString = (a)iiw.get(paramString);
    AppMethodBeat.o(149651);
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(149652);
    k.h(paramString, "name");
    k.h(parama, "implement");
    iiw.put(paramString, parama);
    AppMethodBeat.o(149652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.storage.f
 * JD-Core Version:    0.7.0.1
 */