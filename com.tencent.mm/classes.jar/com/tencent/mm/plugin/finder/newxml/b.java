package com.tencent.mm.plugin.finder.newxml;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.fmo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer;", "Lcom/tencent/mm/plugin/messenger/foundation/api/INewXmlConsumer;", "()V", "consumeNewXml", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgReturn;", "subType", "", "values", "", "p2", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "dealWithPromotion", "", "msgType", "", "dealWithRedPackFinder", "dealWithRedPackWx", "getRedDotTitleFinder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "promotion", "Lcom/tencent/mm/protocal/protobuf/FinderPromotionMsg;", "posArray", "", "transXmlToFinderPromotionMsg", "Companion", "plugin-finder_release"})
public final class b
  implements s
{
  public static final a zKb;
  
  static
  {
    AppMethodBeat.i(275343);
    zKb = new a((byte)0);
    AppMethodBeat.o(275343);
  }
  
  private static bhk Z(Map<String, String> paramMap)
  {
    AppMethodBeat.i(275338);
    bhk localbhk = new bhk();
    localbhk.priority = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.priority"));
    localbhk.SRY = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
    localbhk.SRZ = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.start_time"));
    localbhk.end_time = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.end_time"));
    localbhk.msg_type = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_type"));
    localbhk.SSa = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_ext"));
    Object localObject = new cxp();
    ((cxp)localObject).TFY = ((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_name"));
    ((cxp)localObject).RFo = ((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_path"));
    ((cxp)localObject).RFq = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.miniapp_msg.miniapp_scene"));
    localbhk.SSb = ((cxp)localObject);
    localObject = ".sysmsg.msg.path_info";
    LinkedList localLinkedList = new LinkedList();
    int i = 1;
    while (paramMap.containsKey(localObject))
    {
      fmo localfmo = new fmo();
      localfmo.ULm = ((String)paramMap.get((String)localObject + ".wording.zh_cn"));
      localfmo.ULn = ((String)paramMap.get((String)localObject + ".wording.zh_tw"));
      localfmo.RJK = ((String)paramMap.get((String)localObject + ".wording.en"));
      dix localdix = new dix();
      localdix.TQr = localfmo;
      localdix.TQq = Util.safeParseInt((String)paramMap.get((String)localObject + ".msg_position"));
      localLinkedList.add(localdix);
      localObject = (String)localObject + i;
      i += 1;
    }
    localbhk.SSc = localLinkedList;
    AppMethodBeat.o(275338);
    return localbhk;
  }
  
  private final ArrayList<String> a(bhk parambhk, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(275340);
    HashMap localHashMap = new HashMap();
    parambhk = parambhk.SSc;
    p.j(parambhk, "promotion.path_infos");
    Iterator localIterator = ((Iterable)parambhk).iterator();
    while (localIterator.hasNext())
    {
      parambhk = (dix)localIterator.next();
      Map localMap = (Map)localHashMap;
      i = parambhk.TQq;
      fmo localfmo = parambhk.TQr;
      parambhk = localfmo;
      if (localfmo == null) {
        parambhk = new fmo();
      }
      localMap.put(Integer.valueOf(i), parambhk);
    }
    parambhk = new ArrayList();
    new b(this);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      parambhk.add(b.a((fmo)localHashMap.get(Integer.valueOf(paramArrayOfInt[i]))));
      i += 1;
    }
    AppMethodBeat.o(275340);
    return parambhk;
  }
  
  public final h.b a(String paramString, Map<String, String> paramMap, h.a parama)
  {
    AppMethodBeat.i(275335);
    p.k(paramMap, "values");
    p.k(parama, "p2");
    if (p.h(paramString, "FinderPromotion"))
    {
      Log.i("Finder.FinderPromotionConsumer", "[FinderPromotionConsumer]");
      switch (Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_type")))
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(275335);
      return null;
      int i = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
      Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] msgAction:".concat(String.valueOf(i)));
      Object localObject;
      f localf;
      bhw localbhw;
      switch (i)
      {
      default: 
        break;
      case 1: 
        parama = Z(paramMap);
        localObject = a(parama, new int[] { 2, 3 });
        localf = ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager();
        localbhw = new bhw();
        localbhw.SQm = String.valueOf(cm.bfE());
        localbhw.priority = 0;
        localbhw.type = 1015;
        paramMap = new bhx();
        paramMap.SSt = 1;
        paramString = parama.SSb;
        if (paramString != null) {}
        for (paramString = paramString.toByteArray();; paramString = null)
        {
          paramMap.SSu = new com.tencent.mm.cd.b(paramString);
          localbhw.SSl = new com.tencent.mm.cd.b(paramMap.toByteArray());
          localbhw.SRZ = parama.SRZ;
          localbhw.tnN = i.ov(parama.end_time - cm.bfF(), 0);
          bkn localbkn1 = new bkn();
          localbkn1.CKC = 3;
          paramMap = (String)j.M((List)localObject, 0);
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          localbkn1.title = paramString;
          localbkn1.SVs = 1;
          localbkn1.path = "ProfileEntrance";
          localbhw.MFx.add(localbkn1);
          bkn localbkn2 = new bkn();
          localbkn2.CKC = 20;
          paramMap = (String)j.M((List)localObject, 1);
          paramString = paramMap;
          if (paramMap == null) {
            paramString = "";
          }
          localbkn2.title = paramString;
          localbkn2.SVs = 1;
          localbkn2.path = "FinderProfileBanner";
          localbkn2.HpB = "ProfileEntrance";
          localbhw.MFx.add(localbkn2);
          f.a(localf, localbhw, "checkFinderRedPackRedDot", null, true, null, null, 52);
          Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + localbhw.SRZ + ", endtime" + parama.end_time + ", title1:" + localbkn1.title + " ,title2:" + localbkn2.title + ", expire_time" + localbhw.tnN);
          break;
        }
      case 2: 
        ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager().Mp(1015);
        continue;
        i = Util.safeParseInt((String)paramMap.get(".sysmsg.msg.msg_action"));
        Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackWx] msgAction:".concat(String.valueOf(i)));
        switch (i)
        {
        default: 
          break;
        case 1: 
          parama = Z(paramMap);
          paramMap = a(parama, new int[] { 1 });
          localf = ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager();
          localbhw = new bhw();
          localbhw.SQm = String.valueOf(cm.bfE());
          localbhw.priority = parama.priority;
          localbhw.type = 1016;
          localObject = new bhx();
          ((bhx)localObject).SSt = 1;
          paramString = parama.SSb;
          if (paramString != null) {}
          for (paramString = paramString.toByteArray();; paramString = null)
          {
            ((bhx)localObject).SSu = new com.tencent.mm.cd.b(paramString);
            localbhw.SSl = new com.tencent.mm.cd.b(((bhx)localObject).toByteArray());
            localbhw.SRZ = parama.SRZ;
            localbhw.tnN = i.ov(parama.end_time - cm.bfF(), 0);
            localObject = new bkn();
            ((bkn)localObject).CKC = 20;
            paramMap = (String)j.M((List)paramMap, 0);
            paramString = paramMap;
            if (paramMap == null) {
              paramString = "";
            }
            ((bkn)localObject).title = paramString;
            ((bkn)localObject).SVs = 1;
            ((bkn)localObject).path = "CreateFinderEntrance";
            localbhw.MFx.add(localObject);
            f.a(localf, localbhw, "checkFinderRedPackRedDot", null, true, null, null, 52);
            Log.i("Finder.FinderPromotionConsumer", "[dealWithRedPackFinder] starttime" + localbhw.SRZ + ", endtime" + parama.end_time + ", title:" + ((bkn)localObject).title + ", expire_time" + localbhw.tnN);
            break;
          }
        case 2: 
          ((PluginFinder)h.ag(PluginFinder.class)).getRedDotManager().Mp(1016);
        }
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/newxml/FinderPromotionConsumer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"getWordingAcLocale", "", "wording", "Lcom/tencent/mm/protocal/protobuf/Wording;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<fmo, String>
  {
    b(b paramb)
    {
      super();
    }
    
    public static String a(fmo paramfmo)
    {
      AppMethodBeat.i(282514);
      if (paramfmo != null)
      {
        if (LocaleUtil.isSimplifiedChineseAppLang()) {
          break label56;
        }
        if (!LocaleUtil.isTraditionalChineseAppLang()) {
          break label42;
        }
        paramfmo = paramfmo.ULn;
      }
      for (;;)
      {
        Object localObject = paramfmo;
        if (paramfmo == null) {
          localObject = "";
        }
        AppMethodBeat.o(282514);
        return localObject;
        label42:
        if (!LocaleUtil.isChineseAppLang()) {
          paramfmo = paramfmo.RJK;
        } else {
          label56:
          paramfmo = paramfmo.ULm;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.newxml.b
 * JD-Core Version:    0.7.0.1
 */