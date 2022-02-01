package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  public static final a uTN;
  
  static
  {
    AppMethodBeat.i(249499);
    uTN = new a((byte)0);
    AppMethodBeat.o(249499);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(249498);
    kotlin.g.b.p.h(paramMap, "values");
    kotlin.g.b.p.h(parama, "p2");
    int i;
    int j;
    int k;
    boolean bool;
    if (kotlin.g.b.p.j(paramString, "finderuserreinit"))
    {
      h.CyF.n(1279L, 25L, 1L);
      parama = g.aAh();
      kotlin.g.b.p.g(parama, "MMKernel.storage()");
      i = parama.azQ().getInt(ar.a.OlL, 0);
      j = Util.safeParseInt((String)paramMap.get(".sysmsg.userver"));
      parama = (String)paramMap.get(".sysmsg.username");
      k = Util.safeParseInt((String)paramMap.get(".sysmsg.usertype"));
      if (k != 1) {
        break label283;
      }
      if (!kotlin.g.b.p.j(z.aUg(), parama)) {
        break label354;
      }
      bool = true;
    }
    for (;;)
    {
      Log.i("Finder.ReInitSysMsgConsumer", "[consumeNewXml] subType=" + paramString + " userVersion=" + j + " curUserVersion=" + i + " username=" + parama + " userType=" + k + " isValid=" + bool);
      if (bool)
      {
        if (k != 1) {
          break label305;
        }
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlK, "");
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlJ, Integer.valueOf(0));
      }
      for (;;)
      {
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlM, Integer.valueOf(1));
        AppMethodBeat.o(249498);
        return null;
        label283:
        if ((k != 2) || (!kotlin.g.b.p.j(z.aTY(), parama))) {
          break label354;
        }
        bool = true;
        break;
        label305:
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlK, parama);
        paramString = g.aAh();
        kotlin.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.azQ().set(ar.a.OlJ, Integer.valueOf(j));
      }
      label354:
      bool = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.a
 * JD-Core Version:    0.7.0.1
 */