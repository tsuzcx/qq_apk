package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "getFinderNewTips", "handleAdd", "uniqueId", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "handleCancel", "init", "", "parseFinderExtInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements l.a
{
  public static final a APU;
  private final i Asl;
  
  static
  {
    AppMethodBeat.i(366769);
    APU = new a((byte)0);
    AppMethodBeat.o(366769);
  }
  
  public c(i parami)
  {
    AppMethodBeat.i(366753);
    this.Asl = parami;
    AppMethodBeat.o(366753);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(366765);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((d.Yxh < i) || (d.Yxh > j))
        {
          Log.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(d.Yxh) });
          AppMethodBeat.o(366765);
          return false;
        }
        AppMethodBeat.o(366765);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(366758);
    paramMap = (String)paramMap.get(".sysmsg.newtips.ext_info");
    int i;
    label39:
    label68:
    label72:
    Object localObject;
    if (paramMap != null) {
      if (((CharSequence)paramMap).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label114;
        }
        if (paramMap == null) {
          break label124;
        }
        paramMap = XmlParser.parseXml(paramMap, "finder", null);
        s.s(paramMap, "extValues");
        if (paramMap.isEmpty()) {
          break label119;
        }
        i = 1;
        if (i == 0) {
          break label124;
        }
        if (paramMap != null)
        {
          localObject = (String)paramMap.get(".finder.reddot_type");
          if (localObject != null) {
            break label129;
          }
          localObject = null;
          label97:
          if (localObject != null) {
            break label139;
          }
        }
      }
    }
    label114:
    label119:
    label124:
    while ((((Integer)localObject).intValue() != 1) || ((paramLong != 40001001L) && (paramLong != 40001002L)))
    {
      AppMethodBeat.o(366758);
      return null;
      i = 0;
      break;
      paramMap = null;
      break label39;
      i = 0;
      break label68;
      paramMap = null;
      break label72;
      localObject = n.bJF((String)localObject);
      break label97;
    }
    label129:
    label139:
    AppMethodBeat.o(366758);
    return paramMap;
  }
  
  public final boolean a(long paramLong, String paramString, List<com.tencent.mm.plugin.newtips.b.c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(366783);
    s.u(paramList, "tipsList");
    s.u(paramMap, "values");
    Log.w("Finder.NewTipsTransform", "[handleCancel] tipsId=" + paramLong + " uniqueId=" + paramString);
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(366783);
        return true;
      }
      if (paramLong == 40001002L) {
        i = 1003;
      }
    }
    for (;;)
    {
      if ((i != -1) && (this.Asl.b(i, (kotlin.g.a.b)new c.b(paramString)))) {
        Log.i("Finder.NewTipsTransform", "[handleCancel] successfully! tipsId=" + paramLong + " uniqueId=" + paramString);
      }
      AppMethodBeat.o(366783);
      return true;
      if (paramLong == 40001001L)
      {
        i = 1004;
        continue;
        AppMethodBeat.o(366783);
        return false;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public final boolean b(long paramLong, String paramString, List<com.tencent.mm.plugin.newtips.b.c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(366793);
    s.u(paramList, "tipsList");
    s.u(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(366793);
        return true;
      }
      paramMap = (com.tencent.mm.plugin.newtips.b.c)p.oL(paramList);
      int i;
      Iterator localIterator;
      if (paramMap == null)
      {
        i = 0;
        paramMap = new btw();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label83:
        if (!localIterator.hasNext()) {
          break label491;
        }
        paramList = (com.tencent.mm.plugin.newtips.b.c)localIterator.next();
        bxq localbxq = new bxq();
        if (paramList.field_showType != k.MsJ.value)
        {
          paramMap.aabA.add(localbxq);
          int j = paramList.field_showType;
          if (j == k.MsM.value)
          {
            localbxq.title = paramList.field_title;
            localbxq.show_type = 3;
            label173:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localbxq.path = paramList;
            localbxq.aagq = 1;
            if (paramLong != 40001002L) {
              break label434;
            }
            paramList = new FinderTipsShowEntranceExtInfo();
            paramList.tab_type = 2;
            localbxq.aagr = 1;
            localbxq.aags = new com.tencent.mm.bx.b(paramList.toByteArray());
            paramMap.type = 1003;
            break label83;
            i = paramMap.field_priority;
            break;
            if (j == k.MsP.value)
            {
              localbxq.count = 1;
              localbxq.show_type = 2;
              break label173;
            }
            if (j == k.MsN.value)
            {
              localbxq.icon_url = paramList.field_icon_url;
              localbxq.show_type = 4;
              break label173;
            }
            if (j == k.MsK.value)
            {
              localbxq.show_type = 1;
              break label173;
            }
            if (j != k.MsL.value) {
              break label173;
            }
            localbxq.show_type = 100;
            break label173;
            paramList = "Discovery";
            continue;
            paramList = "FinderEntrance";
            continue;
            paramList = "finder_tl_hot_tab";
            continue;
            paramList = "finder_tl_nearby_tab";
          }
          label434:
          if (paramLong == 40001001L)
          {
            paramList = new FinderTipsShowEntranceExtInfo();
            paramList.tab_type = 4;
            localbxq.aagr = 1;
            localbxq.aags = new com.tencent.mm.bx.b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label491:
      paramMap.ZYN = paramString;
      paramMap.priority = i;
      paramString = new bxh();
      paramList = new bxi();
      paramString.aace.add(paramList);
      paramList.aagf = paramMap;
      this.Asl.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(366793);
      return true;
    }
    AppMethodBeat.o(366793);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.c
 * JD-Core Version:    0.7.0.1
 */