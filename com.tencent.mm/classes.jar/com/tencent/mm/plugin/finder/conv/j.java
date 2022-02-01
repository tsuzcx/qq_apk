package com.tencent.mm.plugin.finder.conv;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.Map;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "Companion", "plugin-finder_release"})
public final class j
  implements com.tencent.mm.plugin.messenger.foundation.a.p
{
  public static final a tyW;
  
  static
  {
    AppMethodBeat.i(242762);
    tyW = new a((byte)0);
    AppMethodBeat.o(242762);
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(242761);
    kotlin.g.b.p.h(paramMap, "values");
    kotlin.g.b.p.h(parama, "addMsgInfo");
    de localde;
    Object localObject;
    long l1;
    if (((parama.iMa instanceof cp)) && (parama.what == 1))
    {
      localde = parama.heO;
      parama = parama.iMa;
      if (parama == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.AddBypMsg");
        AppMethodBeat.o(242761);
        throw paramString;
      }
      parama = ((cp)parama).KGL;
      String.valueOf(paramString);
      h.hkS();
      if (localde != null) {}
      for (paramString = localde.KHn; Util.isNullOrNil(z.a(paramString)); paramString = null)
      {
        h.ez("msg content is null");
        AppMethodBeat.o(242761);
        return null;
      }
      if (localde == null) {
        break label315;
      }
      paramString = localde.KHl;
      paramString = z.a(paramString);
      localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      kotlin.g.b.p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).eiy();
      if (localde == null) {
        break label320;
      }
      l1 = localde.Brn;
      label178:
      localObject = ((i)localObject).aJ(paramString, l1);
      kotlin.g.b.p.g(localObject, "msgInfo");
      if (localde == null) {
        break label326;
      }
      l1 = localde.Brn;
      label209:
      ((ca)localObject).yF(l1);
      l1 = l2;
      if (localde != null) {
        l1 = localde.CreateTime;
      }
      ((ca)localObject).setCreateTime(bp.C(paramString, l1));
      ((ca)localObject).setType(10000);
      ((ca)localObject).setContent((String)paramMap.get(".sysmsg.SysMsgContent"));
      ((ca)localObject).nv(0);
      ((ca)localObject).Cy(parama);
      if (localde == null) {
        break label332;
      }
    }
    label315:
    label320:
    label326:
    label332:
    for (paramString = localde.KHq;; paramString = null)
    {
      ((ca)localObject).BB(paramString);
      ((ca)localObject).gDN();
      bp.x((ca)localObject);
      AppMethodBeat.o(242761);
      return null;
      paramString = null;
      break;
      l1 = 0L;
      break label178;
      l1 = 0L;
      break label209;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderPrivateSysMsgConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.j
 * JD-Core Version:    0.7.0.1
 */