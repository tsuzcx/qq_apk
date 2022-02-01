package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  public static final a ESb;
  
  static
  {
    AppMethodBeat.i(329921);
    ESb = new a((byte)0);
    AppMethodBeat.o(329921);
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(329934);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama, "p2");
    int j;
    boolean bool;
    if (kotlin.g.b.s.p(paramString, "finderuserreinit"))
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1279L, 25L, 1L);
      int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
      j = Util.safeParseInt((String)paramMap.get(".sysmsg.userver"));
      parama = (String)paramMap.get(".sysmsg.username");
      int k = Util.safeParseInt((String)paramMap.get(".sysmsg.usertype"));
      switch (k)
      {
      default: 
        bool = false;
        label127:
        Log.i("Finder.ReInitSysMsgConsumer", "[consumeNewXml] subType=" + paramString + " userVersion=" + j + " curUserVersion=" + i + " username=" + parama + " userType=" + k + " isValid=" + bool);
        if (bool)
        {
          if (k != 1) {
            break label293;
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adcX, "");
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adcW, Integer.valueOf(0));
        }
        break;
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcZ, Integer.valueOf(1));
      AppMethodBeat.o(329934);
      return null;
      if (!kotlin.g.b.s.p(z.bAW(), parama)) {
        break;
      }
      bool = true;
      break label127;
      if (!kotlin.g.b.s.p(z.bAM(), parama)) {
        break;
      }
      bool = true;
      break label127;
      label293:
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcX, parama);
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adcW, Integer.valueOf(j));
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderReInitSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.c
 * JD-Core Version:    0.7.0.1
 */