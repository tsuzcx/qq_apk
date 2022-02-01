package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.asd;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "getFinderNewTips", "handleAdd", "uniqueId", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "handleCancel", "parseFinderExtInfo", "prepare", "", "Companion", "plugin-finder_release"})
public final class b
  implements l.a
{
  public static final a rRJ;
  private final e rGr;
  
  static
  {
    AppMethodBeat.i(201597);
    rRJ = new a((byte)0);
    AppMethodBeat.o(201597);
  }
  
  public b(e parame)
  {
    AppMethodBeat.i(201596);
    this.rGr = parame;
    AppMethodBeat.o(201596);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201595);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = bt.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((d.Fnj < i) || (d.Fnj > j))
        {
          ad.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(d.Fnj) });
          AppMethodBeat.o(201595);
          return false;
        }
        AppMethodBeat.o(201595);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(201592);
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
        paramMap = bw.M(paramMap, "finder");
        p.g(paramMap, "extValues");
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
          localObject = n.bdh((String)localObject);
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
      AppMethodBeat.o(201592);
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
    AppMethodBeat.o(201592);
    return paramMap;
  }
  
  public final boolean a(final long paramLong, final String paramString, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201593);
    p.h(paramList, "tipsList");
    p.h(paramMap, "values");
    ad.w("Finder.NewTipsTransform", "[handleCancel] tipsId=" + paramLong + " uniqueId=" + paramString);
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(201593);
        return true;
      }
      if (paramLong == 40001002L) {
        i = 1003;
      }
    }
    for (;;)
    {
      if ((i != -1) && (this.rGr.a(i, (d.g.a.b)new b(this, paramLong, paramMap, paramString)))) {
        ad.i("Finder.NewTipsTransform", "[handleCancel] successfully! tipsId=" + paramLong + " uniqueId=" + paramString);
      }
      AppMethodBeat.o(201593);
      return true;
      if (paramLong == 40001001L)
      {
        i = 1004;
        continue;
        AppMethodBeat.o(201593);
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
    AppMethodBeat.i(201594);
    p.h(paramList, "tipsList");
    p.h(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(201594);
        return true;
      }
      paramMap = (c)j.jd(paramList);
      int i;
      Iterator localIterator;
      if (paramMap != null)
      {
        i = paramMap.field_priority;
        paramMap = new aqu();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label87:
        if (!localIterator.hasNext()) {
          break label491;
        }
        paramList = (c)localIterator.next();
        ase localase = new ase();
        if (paramList.field_showType != k.wsK.value)
        {
          paramMap.GoP.add(localase);
          int j = paramList.field_showType;
          if (j == k.wsN.value)
          {
            localase.title = paramList.field_title;
            localase.uda = 3;
            label177:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localase.path = paramList;
            localase.Gqr = 1;
            if (paramLong != 40001002L) {
              break label434;
            }
            paramList = new asd();
            paramList.Glz = 2;
            localase.Gqs = 1;
            localase.Gqt = new com.tencent.mm.bx.b(paramList.toByteArray());
            paramMap.type = 1003;
            break label87;
            i = 0;
            break;
            if (j == k.wsQ.value)
            {
              localase.count = 1;
              localase.uda = 2;
              break label177;
            }
            if (j == k.wsO.value)
            {
              localase.pkr = paramList.field_icon_url;
              localase.uda = 4;
              break label177;
            }
            if (j == k.wsL.value)
            {
              localase.uda = 1;
              break label177;
            }
            if (j != k.wsM.value) {
              break label177;
            }
            localase.uda = 100;
            break label177;
            paramList = "Discovery";
            continue;
            paramList = "FinderEntrance";
            continue;
            paramList = "TLMachineTab";
            continue;
            paramList = "TLLbsTab";
          }
          label434:
          if (paramLong == 40001001L)
          {
            paramList = new asd();
            paramList.Glz = 4;
            localase.Gqs = 1;
            localase.Gqt = new com.tencent.mm.bx.b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label491:
      paramMap.GoQ = paramString;
      paramMap.priority = i;
      paramString = new ary();
      paramList = new arz();
      paramString.GoV.add(paramList);
      paramList.Gqk = paramMap;
      this.rGr.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(201594);
      return true;
    }
    AppMethodBeat.o(201594);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$handleCancel$1$ret$1"})
  static final class b
    extends q
    implements d.g.a.b<i, Boolean>
  {
    b(b paramb, long paramLong, Map paramMap, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */