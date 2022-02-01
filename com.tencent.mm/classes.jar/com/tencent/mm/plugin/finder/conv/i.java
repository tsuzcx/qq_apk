package com.tencent.mm.plugin.finder.conv;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import d.v;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class i
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  public static final a rLO;
  
  static
  {
    AppMethodBeat.i(201300);
    rLO = new a((byte)0);
    AppMethodBeat.o(201300);
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(201299);
    d.g.b.p.h(paramMap, "values");
    d.g.b.p.h(parama, "addMsgInfo");
    cv localcv;
    Object localObject;
    long l1;
    if (((parama.hNZ instanceof cg)) && (parama.what == 1))
    {
      localcv = parama.gqE;
      parama = parama.hNZ;
      if (parama == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
        AppMethodBeat.o(201299);
        throw paramString;
      }
      parama = ((cg)parama).FuI;
      String.valueOf(paramString);
      h.fUh();
      if (localcv != null) {}
      for (paramString = localcv.Fvk; bt.isNullOrNil(z.a(paramString)); paramString = null)
      {
        h.es("msg content is null");
        AppMethodBeat.o(201299);
        return null;
      }
      if (localcv == null) {
        break label315;
      }
      paramString = localcv.Fvi;
      paramString = z.a(paramString);
      localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).dlK();
      if (localcv == null) {
        break label320;
      }
      l1 = localcv.xbt;
      label178:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject).aI(paramString, l1);
      d.g.b.p.g(localObject, "msgInfo");
      if (localcv == null) {
        break label326;
      }
      l1 = localcv.xbt;
      label209:
      ((bu)localObject).qz(l1);
      l1 = l2;
      if (localcv != null) {
        l1 = localcv.CreateTime;
      }
      ((bu)localObject).qA(bj.B(paramString, l1));
      ((bu)localObject).setType(10000);
      ((bu)localObject).setContent((String)paramMap.get(".sysmsg.SysMsgContent"));
      ((bu)localObject).kr(0);
      ((bu)localObject).tN(parama);
      if (localcv == null) {
        break label332;
      }
    }
    label315:
    label320:
    label326:
    label332:
    for (paramString = localcv.Fvn;; paramString = null)
    {
      ((bu)localObject).sP(paramString);
      ((bu)localObject).fsg();
      bj.v((bu)localObject);
      AppMethodBeat.o(201299);
      return null;
      paramString = null;
      break;
      l1 = 0L;
      break label178;
      l1 = 0L;
      break label209;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i
 * JD-Core Version:    0.7.0.1
 */