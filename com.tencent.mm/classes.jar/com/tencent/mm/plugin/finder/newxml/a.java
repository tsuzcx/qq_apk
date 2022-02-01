package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.l;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class a
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  public static final a skG;
  
  static
  {
    AppMethodBeat.i(203006);
    skG = new a((byte)0);
    AppMethodBeat.o(203006);
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(203005);
    d.g.b.p.h(paramMap, "values");
    d.g.b.p.h(parama, "p2");
    int i;
    int j;
    int k;
    boolean bool;
    if (d.g.b.p.i(paramString, "finderuserreinit"))
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(1279L, 25L, 1L);
      parama = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(parama, "MMKernel.storage()");
      i = parama.ajl().getInt(al.a.IIe, 0);
      j = bt.aRe((String)paramMap.get(".sysmsg.userver"));
      parama = (String)paramMap.get(".sysmsg.username");
      k = bt.aRe((String)paramMap.get(".sysmsg.usertype"));
      if (k != 1) {
        break label231;
      }
      if (!d.g.b.p.i(u.aAu(), parama)) {
        break label253;
      }
      bool = true;
    }
    for (;;)
    {
      ad.i("Finder.ReInitSysMsgConsumer", "[consumeNewXml] subType=" + paramString + " userVersion=" + j + " curUserVersion=" + i + " username=" + parama + " userType=" + k + " isValid=" + bool);
      if (bool)
      {
        paramString = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(paramString, "MMKernel.storage()");
        paramString.ajl().set(al.a.IIf, Integer.valueOf(1));
      }
      AppMethodBeat.o(203005);
      return null;
      label231:
      if ((k == 2) && (d.g.b.p.i(u.aAm(), parama))) {
        bool = true;
      } else {
        label253:
        bool = false;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.a
 * JD-Core Version:    0.7.0.1
 */