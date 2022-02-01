package com.tencent.mm.plugin.finder.conv;

import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import d.v;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class i
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  public static final a rUb;
  
  static
  {
    AppMethodBeat.i(201727);
    rUb = new a((byte)0);
    AppMethodBeat.o(201727);
  }
  
  public final e.b a(String paramString, Map<String, String> paramMap, e.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(201726);
    d.g.b.p.h(paramMap, "values");
    d.g.b.p.h(parama, "addMsgInfo");
    cv localcv;
    Object localObject;
    long l1;
    if (((parama.hQS instanceof cg)) && (parama.what == 1))
    {
      localcv = parama.gte;
      parama = parama.hQS;
      if (parama == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
        AppMethodBeat.o(201726);
        throw paramString;
      }
      parama = ((cg)parama).FNg;
      String.valueOf(paramString);
      h.fYG();
      if (localcv != null) {}
      for (paramString = localcv.FNI; bu.isNullOrNil(z.a(paramString)); paramString = null)
      {
        h.ev("msg content is null");
        AppMethodBeat.o(201726);
        return null;
      }
      if (localcv == null) {
        break label315;
      }
      paramString = localcv.FNG;
      paramString = z.a(paramString);
      localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).doJ();
      if (localcv == null) {
        break label320;
      }
      l1 = localcv.xrk;
      label178:
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject).aJ(paramString, l1);
      d.g.b.p.g(localObject, "msgInfo");
      if (localcv == null) {
        break label326;
      }
      l1 = localcv.xrk;
      label209:
      ((bv)localObject).qM(l1);
      l1 = l2;
      if (localcv != null) {
        l1 = localcv.CreateTime;
      }
      ((bv)localObject).qN(bl.B(paramString, l1));
      ((bv)localObject).setType(10000);
      ((bv)localObject).setContent((String)paramMap.get(".sysmsg.SysMsgContent"));
      ((bv)localObject).kt(0);
      ((bv)localObject).ui(parama);
      if (localcv == null) {
        break label332;
      }
    }
    label315:
    label320:
    label326:
    label332:
    for (paramString = localcv.FNL;; paramString = null)
    {
      ((bv)localObject).tk(paramString);
      ((bv)localObject).fwh();
      bl.v((bv)localObject);
      AppMethodBeat.o(201726);
      return null;
      paramString = null;
      break;
      l1 = 0L;
      break label178;
      l1 = 0L;
      break label209;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.i
 * JD-Core Version:    0.7.0.1
 */