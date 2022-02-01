package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "getFinderNewTips", "handleAdd", "uniqueId", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "handleCancel", "init", "", "parseFinderExtInfo", "Companion", "plugin-finder_release"})
public final class b
  implements l.a
{
  public static final a tJk;
  private final f toy;
  
  static
  {
    AppMethodBeat.i(243506);
    tJk = new a((byte)0);
    AppMethodBeat.o(243506);
  }
  
  public b(f paramf)
  {
    AppMethodBeat.i(243505);
    this.toy = paramf;
    AppMethodBeat.o(243505);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(243504);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((d.KyO < i) || (d.KyO > j))
        {
          Log.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(d.KyO) });
          AppMethodBeat.o(243504);
          return false;
        }
        AppMethodBeat.o(243504);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(243501);
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
          break label118;
        }
        if (paramMap == null) {
          break label128;
        }
        paramMap = XmlParser.parseXml(paramMap, "finder", null);
        p.g(paramMap, "extValues");
        if (paramMap.isEmpty()) {
          break label123;
        }
        i = 1;
        if (i == 0) {
          break label128;
        }
        if (paramMap != null)
        {
          localObject = (String)paramMap.get(".finder.reddot_type");
          if (localObject == null) {
            break label133;
          }
          localObject = n.buA((String)localObject);
          label101:
          if (localObject != null) {
            break label139;
          }
        }
      }
    }
    label118:
    label123:
    while ((((Integer)localObject).intValue() != 1) || ((paramLong != 40001001L) && (paramLong != 40001002L)))
    {
      AppMethodBeat.o(243501);
      return null;
      i = 0;
      break;
      paramMap = null;
      break label39;
      i = 0;
      break label68;
      paramMap = null;
      break label72;
      localObject = null;
      break label101;
    }
    label128:
    label133:
    label139:
    AppMethodBeat.o(243501);
    return paramMap;
  }
  
  public final boolean a(final long paramLong, final String paramString, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(243502);
    p.h(paramList, "tipsList");
    p.h(paramMap, "values");
    Log.w("Finder.NewTipsTransform", "[handleCancel] tipsId=" + paramLong + " uniqueId=" + paramString);
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(243502);
        return true;
      }
      if (paramLong == 40001002L) {
        i = 1003;
      }
    }
    for (;;)
    {
      if ((i != -1) && (this.toy.a(i, (kotlin.g.a.b)new b(this, paramLong, paramMap, paramString)))) {
        Log.i("Finder.NewTipsTransform", "[handleCancel] successfully! tipsId=" + paramLong + " uniqueId=" + paramString);
      }
      AppMethodBeat.o(243502);
      return true;
      if (paramLong == 40001001L)
      {
        i = 1004;
        continue;
        AppMethodBeat.o(243502);
        return false;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  public final boolean b(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(243503);
    p.h(paramList, "tipsList");
    p.h(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(243503);
        return true;
      }
      paramMap = (c)j.kt(paramList);
      int i;
      Iterator localIterator;
      if (paramMap != null)
      {
        i = paramMap.field_priority;
        paramMap = new bbi();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label87:
        if (!localIterator.hasNext()) {
          break label491;
        }
        paramList = (c)localIterator.next();
        bdo localbdo = new bdo();
        if (paramList.field_showType != com.tencent.mm.plugin.newtips.a.k.ADF.value)
        {
          paramMap.GaM.add(localbdo);
          int j = paramList.field_showType;
          if (j == com.tencent.mm.plugin.newtips.a.k.ADI.value)
          {
            localbdo.title = paramList.field_title;
            localbdo.xGz = 3;
            label177:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localbdo.path = paramList;
            localbdo.LNm = 1;
            if (paramLong != 40001002L) {
              break label434;
            }
            paramList = new FinderTipsShowEntranceExtInfo();
            paramList.tab_type = 2;
            localbdo.LNn = 1;
            localbdo.LNo = new com.tencent.mm.bw.b(paramList.toByteArray());
            paramMap.type = 1003;
            break label87;
            i = 0;
            break;
            if (j == com.tencent.mm.plugin.newtips.a.k.ADL.value)
            {
              localbdo.count = 1;
              localbdo.xGz = 2;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.ADJ.value)
            {
              localbdo.qGB = paramList.field_icon_url;
              localbdo.xGz = 4;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.ADG.value)
            {
              localbdo.xGz = 1;
              break label177;
            }
            if (j != com.tencent.mm.plugin.newtips.a.k.ADH.value) {
              break label177;
            }
            localbdo.xGz = 100;
            break label177;
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
            localbdo.LNn = 1;
            localbdo.LNo = new com.tencent.mm.bw.b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label491:
      paramMap.LKM = paramString;
      paramMap.priority = i;
      paramString = new bdh();
      paramList = new bdj();
      paramString.LKY.add(paramList);
      paramList.LNi = paramMap;
      this.toy.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(243503);
      return true;
    }
    AppMethodBeat.o(243503);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$handleCancel$1$ret$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<k, Boolean>
  {
    b(b paramb, long paramLong, Map paramMap, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */