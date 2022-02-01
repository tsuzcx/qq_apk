package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.protocal.protobuf.ebh;
import com.tencent.mm.protocal.protobuf.gjg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "dealWithPromotion", "", "msgType", "", "dealWithRedPackFinder", "dealWithRedPackWx", "getRedDotTitleFinder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "promotion", "Lcom/tencent/mm/protocal/protobuf/FinderPromotionMsg;", "posArray", "", "transXmlToFinderPromotionMsg", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.s
{
  public static final a ESa;
  
  static
  {
    AppMethodBeat.i(329948);
    ESa = new a((byte)0);
    AppMethodBeat.o(329948);
  }
  
  private static final String a(gjg paramgjg)
  {
    AppMethodBeat.i(329944);
    if (paramgjg == null) {
      paramgjg = null;
    }
    while (paramgjg == null)
    {
      AppMethodBeat.o(329944);
      return "";
      if (!LocaleUtil.isSimplifiedChineseAppLang())
      {
        if (LocaleUtil.isTraditionalChineseAppLang())
        {
          paramgjg = paramgjg.acfA;
          continue;
        }
        if (!LocaleUtil.isChineseAppLang())
        {
          paramgjg = paramgjg.YHe;
          continue;
        }
      }
      paramgjg = paramgjg.acfz;
    }
    AppMethodBeat.o(329944);
    return paramgjg;
  }
  
  private static ArrayList<String> a(bti parambti, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(329939);
    HashMap localHashMap = new HashMap();
    parambti = parambti.aabp;
    kotlin.g.b.s.s(parambti, "promotion.path_infos");
    Iterator localIterator = ((Iterable)parambti).iterator();
    while (localIterator.hasNext())
    {
      parambti = (ebh)localIterator.next();
      Map localMap = (Map)localHashMap;
      i = parambti.abgP;
      gjg localgjg = parambti.abgQ;
      parambti = localgjg;
      if (localgjg == null) {
        parambti = new gjg();
      }
      localMap.put(Integer.valueOf(i), parambti);
    }
    parambti = new ArrayList();
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      parambti.add(a((gjg)localHashMap.get(Integer.valueOf(paramArrayOfInt[i]))));
      i += 1;
    }
    AppMethodBeat.o(329939);
    return parambti;
  }
  
  private static bti am(Map<String, String> paramMap)
  {
    AppMethodBeat.i(329931);
    bti localbti = new bti();
    localbti.priority = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.priority"));
    localbti.aabm = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
    localbti.start_time = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.start_time"));
    localbti.end_time = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.end_time"));
    localbti.msg_type = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_type"));
    localbti.aabn = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_ext"));
    Object localObject1 = new dou();
    ((dou)localObject1).aaVE = ((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_name"));
    ((dou)localObject1).YBQ = ((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_path"));
    ((dou)localObject1).YBS = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_scene"));
    Object localObject2 = ah.aiuX;
    localbti.aabo = ((dou)localObject1);
    localObject2 = new LinkedList();
    localObject1 = ".sysmsg.msg.path_info";
    int i = 1;
    while (paramMap.containsKey(localObject1))
    {
      gjg localgjg = new gjg();
      localgjg.acfz = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".wording.zh_cn")));
      localgjg.acfA = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".wording.zh_tw")));
      localgjg.YHe = ((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".wording.en")));
      Object localObject3 = ah.aiuX;
      localObject3 = new ebh();
      ((ebh)localObject3).abgQ = localgjg;
      ((ebh)localObject3).abgP = Util.safeParseInt((String)paramMap.get(kotlin.g.b.s.X((String)localObject1, ".msg_position")));
      ((LinkedList)localObject2).add(localObject3);
      localObject1 = kotlin.g.b.s.X(".sysmsg.msg.path_info", Integer.valueOf(i));
      i += 1;
    }
    paramMap = ah.aiuX;
    localbti.aabp = ((LinkedList)localObject2);
    AppMethodBeat.o(329931);
    return localbti;
  }
  
  public final g.b a(String paramString, Map<String, String> paramMap, g.a parama)
  {
    AppMethodBeat.i(329956);
    kotlin.g.b.s.u(paramMap, "values");
    kotlin.g.b.s.u(parama, "p2");
    if (kotlin.g.b.s.p(paramString, "FinderPromotion"))
    {
      Log.i("Finder.FinderPromotionConsumer", "[FinderPromotionConsumer]");
      switch (Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_type")))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(329956);
      return null;
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
      Log.i("Finder.FinderPromotionConsumer", kotlin.g.b.s.X("[dealWithRedPackFinder] msgAction:", Integer.valueOf(i)));
      Object localObject;
      i locali;
      btw localbtw;
      switch (i)
      {
      default: 
        break;
      case 1: 
        parama = am(paramMap);
        localObject = a(parama, new int[] { 2, 3 });
        locali = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
        localbtw = new btw();
        localbtw.ZYN = String.valueOf(cn.bDw());
        localbtw.priority = 0;
        localbtw.type = 1015;
        paramMap = new btx();
        paramMap.aabI = 1;
        paramString = parama.aabo;
        if (paramString == null) {}
        for (paramString = null;; paramString = paramString.toByteArray())
        {
          paramMap.aabJ = new com.tencent.mm.bx.b(paramString);
          paramString = ah.aiuX;
          localbtw.aabz = new com.tencent.mm.bx.b(paramMap.toByteArray());
          localbtw.start_time = parama.start_time;
          localbtw.wso = k.qu(parama.end_time - cn.getSyncServerTimeSecond(), 0);
          bxq localbxq1 = new bxq();
          localbxq1.show_type = 3;
          paramMap = (String)p.ae((List)localObject, 0);
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          localbxq1.title = paramString;
          localbxq1.aagq = 1;
          localbxq1.path = "ProfileEntrance";
          localbtw.aabA.add(localbxq1);
          bxq localbxq2 = new bxq();
          localbxq2.show_type = 20;
          paramMap = (String)p.ae((List)localObject, 1);
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          localbxq2.title = paramString;
          localbxq2.aagq = 1;
          localbxq2.path = "FinderProfileBanner";
          localbxq2.Nnp = "ProfileEntrance";
          localbtw.aabA.add(localbxq2);
          i.a(locali, localbtw, "checkFinderRedPackRedDot", null, true, null, null, 0L, 116);
          Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + localbtw.start_time + ", endtime" + parama.end_time + ", title1:" + localbxq1.title + " ,title2:" + localbxq2.title + ", expire_time" + localbtw.wso);
          break;
        }
      case 2: 
        ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Nv(1015);
        continue;
        i = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
        Log.i("Finder.FinderPromotionConsumer", kotlin.g.b.s.X("[dealWithRedPackWx] msgAction:", Integer.valueOf(i)));
        switch (i)
        {
        default: 
          break;
        case 1: 
          parama = am(paramMap);
          paramMap = a(parama, new int[] { 1 });
          locali = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
          localbtw = new btw();
          localbtw.ZYN = String.valueOf(cn.bDw());
          localbtw.priority = parama.priority;
          localbtw.type = 1016;
          localObject = new btx();
          ((btx)localObject).aabI = 1;
          paramString = parama.aabo;
          if (paramString == null) {}
          for (paramString = null;; paramString = paramString.toByteArray())
          {
            ((btx)localObject).aabJ = new com.tencent.mm.bx.b(paramString);
            paramString = ah.aiuX;
            localbtw.aabz = new com.tencent.mm.bx.b(((btx)localObject).toByteArray());
            localbtw.start_time = parama.start_time;
            localbtw.wso = k.qu(parama.end_time - cn.getSyncServerTimeSecond(), 0);
            localObject = new bxq();
            ((bxq)localObject).show_type = 20;
            paramMap = (String)p.ae((List)paramMap, 0);
            paramString = paramMap;
            if (paramMap == null) {
              paramString = "";
            }
            ((bxq)localObject).title = paramString;
            ((bxq)localObject).aagq = 1;
            ((bxq)localObject).path = "CreateFinderEntrance";
            localbtw.aabA.add(localObject);
            i.a(locali, localbtw, "checkFinderRedPackRedDot", null, true, null, null, 0L, 116);
            Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + localbtw.start_time + ", endtime" + parama.end_time + ", title:" + ((bxq)localObject).title + ", expire_time" + localbtw.wso);
            break;
          }
        case 2: 
          ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Nv(1016);
        }
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.b
 * JD-Core Version:    0.7.0.1
 */