package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.akv;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.dzs;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.dzv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.a.j;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "getFinderNewTips", "handleAdd", "uniqueId", "handleCancel", "parseFinderExtInfo", "prepare", "", "Companion", "plugin-finder_release"})
public final class h
  implements l.a
{
  public static final a KMr;
  private final c qnj;
  
  static
  {
    AppMethodBeat.i(197558);
    KMr = new a((byte)0);
    AppMethodBeat.o(197558);
  }
  
  public h(c paramc)
  {
    AppMethodBeat.i(197557);
    this.qnj = paramc;
    AppMethodBeat.o(197557);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197556);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((d.CpK < i) || (d.CpK > j))
        {
          ad.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(d.CpK) });
          AppMethodBeat.o(197556);
          return false;
        }
        AppMethodBeat.o(197556);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(197553);
    paramMap = (String)paramMap.get(".sysmsg.newtips.ext_info");
    int i;
    label39:
    label67:
    label71:
    Object localObject;
    if (paramMap != null) {
      if (((CharSequence)paramMap).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label117;
        }
        if (paramMap == null) {
          break label127;
        }
        paramMap = bw.K(paramMap, "finder");
        d.g.b.k.g(paramMap, "extValues");
        if (paramMap.isEmpty()) {
          break label122;
        }
        i = 1;
        if (i == 0) {
          break label127;
        }
        if (paramMap != null)
        {
          localObject = (String)paramMap.get(".finder.reddot_type");
          if (localObject == null) {
            break label132;
          }
          localObject = n.aRf((String)localObject);
          label100:
          if (localObject != null) {
            break label138;
          }
        }
      }
    }
    label117:
    label122:
    label127:
    while ((((Integer)localObject).intValue() != 1) || ((paramLong != 40001001L) && (paramLong != 40001002L)))
    {
      AppMethodBeat.o(197553);
      return null;
      i = 0;
      break;
      paramMap = null;
      break label39;
      i = 0;
      break label67;
      paramMap = null;
      break label71;
      localObject = null;
      break label100;
    }
    label132:
    label138:
    AppMethodBeat.o(197553);
    return paramMap;
  }
  
  public final boolean a(long paramLong, String paramString, List<com.tencent.mm.plugin.newtips.b.c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197555);
    d.g.b.k.h(paramList, "tipsList");
    d.g.b.k.h(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(197555);
        return true;
      }
      paramMap = (com.tencent.mm.plugin.newtips.b.c)j.iz(paramList);
      int i;
      Iterator localIterator;
      if (paramMap != null)
      {
        i = paramMap.field_priority;
        paramMap = new akv();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label87:
        if (!localIterator.hasNext()) {
          break label490;
        }
        paramList = (com.tencent.mm.plugin.newtips.b.c)localIterator.next();
        aln localaln = new aln();
        if (paramList.field_showType != com.tencent.mm.plugin.newtips.a.k.ueu.value)
        {
          paramMap.Dmt.add(localaln);
          int j = paramList.field_showType;
          if (j == com.tencent.mm.plugin.newtips.a.k.uex.value)
          {
            localaln.title = paramList.field_title;
            localaln.rXs = 3;
            label177:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localaln.path = paramList;
            localaln.DmL = 1;
            if (paramLong != 40001002L) {
              break label433;
            }
            paramList = new dzv();
            paramList.Lyv = 2;
            localaln.LyB = 1;
            localaln.LyC = new b(paramList.toByteArray());
            paramMap.type = 1003;
            break label87;
            i = 0;
            break;
            if (j == com.tencent.mm.plugin.newtips.a.k.ueA.value)
            {
              localaln.count = 1;
              localaln.rXs = 2;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.uey.value)
            {
              localaln.odo = paramList.field_icon_url;
              localaln.rXs = 4;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.uev.value)
            {
              localaln.rXs = 1;
              break label177;
            }
            if (j != com.tencent.mm.plugin.newtips.a.k.uew.value) {
              break label177;
            }
            localaln.rXs = 100;
            break label177;
            paramList = "Discovery";
            continue;
            paramList = "FinderEntrance";
            continue;
            paramList = "TLMachineTab";
            continue;
            paramList = "TLLbsTab";
          }
          label433:
          if (paramLong == 40001001L)
          {
            paramList = new dzv();
            paramList.Lyv = 4;
            localaln.LyB = 1;
            localaln.LyC = new b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label490:
      paramMap.Dmu = paramString;
      paramMap.priority = i;
      paramString = new dzs();
      paramList = new dzt();
      paramString.Lyx.add(paramList);
      paramList.DmY = paramMap;
      this.qnj.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(197555);
      return true;
    }
    AppMethodBeat.o(197555);
    return false;
  }
  
  public final boolean a(long paramLong, List<com.tencent.mm.plugin.newtips.b.c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(197554);
    d.g.b.k.h(paramList, "tipsList");
    d.g.b.k.h(paramMap, "values");
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(197554);
        return true;
      }
      paramList = ((Iterable)paramList).iterator();
      i = 0;
      while (paramList.hasNext())
      {
        paramMap = (com.tencent.mm.plugin.newtips.b.c)paramList.next();
        if (paramMap.field_tipId == 40001002L)
        {
          i = 1003;
        }
        else
        {
          if (paramMap.field_tipId != 40001001L) {
            break label145;
          }
          i = 1004;
        }
      }
    }
    label145:
    for (;;)
    {
      break;
      this.qnj.ahg(i);
      AppMethodBeat.o(197554);
      return true;
      AppMethodBeat.o(197554);
      return false;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.h
 * JD-Core Version:    0.7.0.1
 */