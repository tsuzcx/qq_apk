package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class k
  implements s
{
  public static final a xgG;
  
  static
  {
    AppMethodBeat.i(271527);
    xgG = new a((byte)0);
    AppMethodBeat.o(271527);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(271524);
    p.k(paramMap, "values");
    p.k(parama, "addMsgInfo");
    db localdb;
    Object localObject;
    long l1;
    if (((parama.lCh instanceof co)) && (parama.what == 1))
    {
      localdb = parama.jQG;
      parama = parama.lCh;
      if (parama == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
        AppMethodBeat.o(271524);
        throw paramString;
      }
      parama = ((co)parama).RIf;
      String.valueOf(paramString);
      com.tencent.d.f.h.ioq();
      if (localdb != null) {}
      for (paramString = localdb.RIF; Util.isNullOrNil(z.a(paramString)); paramString = null)
      {
        com.tencent.d.f.h.eF("msg content is null");
        AppMethodBeat.o(271524);
        return null;
      }
      if (localdb == null) {
        break label315;
      }
      paramString = localdb.RID;
      paramString = z.a(paramString);
      localObject = com.tencent.mm.kernel.h.ae(n.class);
      p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((n)localObject).eSe();
      if (localdb == null) {
        break label320;
      }
      l1 = localdb.HlH;
      label178:
      localObject = ((i)localObject).aL(paramString, l1);
      p.j(localObject, "msgInfo");
      if (localdb == null) {
        break label326;
      }
      l1 = localdb.HlH;
      label209:
      ((ca)localObject).EG(l1);
      l1 = l2;
      if (localdb != null) {
        l1 = localdb.CreateTime;
      }
      ((ca)localObject).setCreateTime(bq.z(paramString, l1));
      ((ca)localObject).setType(10000);
      ((ca)localObject).setContent((String)paramMap.get(".sysmsg.SysMsgContent"));
      ((ca)localObject).pJ(0);
      ((ca)localObject).Jm(parama);
      if (localdb == null) {
        break label332;
      }
    }
    label315:
    label320:
    label326:
    label332:
    for (paramString = localdb.RII;; paramString = null)
    {
      ((ca)localObject).Ip(paramString);
      ((ca)localObject).hAb();
      bq.z((ca)localObject);
      AppMethodBeat.o(271524);
      return null;
      paramString = null;
      break;
      l1 = 0L;
      break label178;
      l1 = 0L;
      break label209;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.k
 * JD-Core Version:    0.7.0.1
 */