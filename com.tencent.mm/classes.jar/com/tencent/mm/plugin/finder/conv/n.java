package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.model.br;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  public static final n.a AHc;
  
  static
  {
    AppMethodBeat.i(335986);
    AHc = new n.a((byte)0);
    AppMethodBeat.o(335986);
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(335999);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama, "addMsgInfo");
    dl localdl;
    Object localObject;
    long l1;
    if (((parama.extra instanceof cy)) && (parama.what == 1))
    {
      localdl = parama.mpN;
      parama = parama.extra;
      if (parama == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
        AppMethodBeat.o(335999);
        throw paramString;
      }
      parama = ((cy)parama).YFh;
      String.valueOf(paramString);
      com.tencent.e.f.h.jXD();
      if (localdl == null) {}
      for (paramString = null; Util.isNullOrNil(w.a(paramString)); paramString = localdl.YFG)
      {
        com.tencent.e.f.h.hd("msg content is null");
        AppMethodBeat.o(335999);
        return null;
      }
      if (localdl != null) {
        break label273;
      }
      paramString = null;
      paramString = w.a(paramString);
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
      if (localdl != null) {
        break label282;
      }
      l1 = 0L;
      label159:
      localObject = ((i)localObject).aU(paramString, l1);
      if (localdl != null) {
        break label292;
      }
      l1 = 0L;
      label179:
      ((cc)localObject).gX(l1);
      if (localdl != null) {
        break label302;
      }
      l1 = l2;
      label195:
      ((cc)localObject).setCreateTime(br.D(paramString, l1));
      ((cc)localObject).setType(10000);
      ((cc)localObject).setContent((String)paramMap.get(".sysmsg.SysMsgContent"));
      ((cc)localObject).pI(0);
      ((cc)localObject).BS(parama);
      if (localdl != null) {
        break label313;
      }
    }
    label273:
    label282:
    label292:
    label302:
    label313:
    for (paramString = null;; paramString = localdl.YFJ)
    {
      ((cc)localObject).AU(paramString);
      ((cc)localObject).jcf();
      br.B((cc)localObject);
      AppMethodBeat.o(335999);
      return null;
      paramString = localdl.YFE;
      break;
      l1 = localdl.Njv;
      break label159;
      l1 = localdl.Njv;
      break label179;
      l1 = localdl.CreateTime;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.n
 * JD-Core Version:    0.7.0.1
 */