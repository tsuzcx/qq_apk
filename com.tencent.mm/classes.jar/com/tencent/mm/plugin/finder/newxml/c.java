package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class c
  implements s
{
  public static final a zKd;
  
  static
  {
    AppMethodBeat.i(288653);
    zKd = new a((byte)0);
    AppMethodBeat.o(288653);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(288651);
    p.k(paramMap, "values");
    p.k(parama, "p2");
    int i;
    int j;
    int k;
    boolean bool;
    if (p.h(paramString, "finderuserreinit"))
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(1279L, 25L, 1L);
      parama = com.tencent.mm.kernel.h.aHG();
      p.j(parama, "MMKernel.storage()");
      i = parama.aHp().getInt(ar.a.VAG, 0);
      j = Util.safeParseInt((String)paramMap.get(".sysmsg.userver"));
      parama = (String)paramMap.get(".sysmsg.username");
      k = Util.safeParseInt((String)paramMap.get(".sysmsg.usertype"));
      if (k != 1) {
        break label283;
      }
      if (!p.h(z.bdh(), parama)) {
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
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAF, "");
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAE, Integer.valueOf(0));
      }
      for (;;)
      {
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAH, Integer.valueOf(1));
        AppMethodBeat.o(288651);
        return null;
        label283:
        if ((k != 2) || (!p.h(z.bcZ(), parama))) {
          break label354;
        }
        bool = true;
        break;
        label305:
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAF, parama);
        paramString = com.tencent.mm.kernel.h.aHG();
        p.j(paramString, "MMKernel.storage()");
        paramString.aHp().set(ar.a.VAE, Integer.valueOf(j));
      }
      label354:
      bool = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.c
 * JD-Core Version:    0.7.0.1
 */