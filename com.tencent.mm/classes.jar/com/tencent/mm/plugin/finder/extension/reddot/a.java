package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import d.a.j;
import d.l;
import d.n.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "getFinderNewTips", "handleAdd", "uniqueId", "handleCancel", "parseFinderExtInfo", "prepare", "", "Companion", "plugin-finder_release"})
public final class a
  implements l.a
{
  public static final a reg;
  private final d qVO;
  
  static
  {
    AppMethodBeat.i(201440);
    reg = new a((byte)0);
    AppMethodBeat.o(201440);
  }
  
  public a(d paramd)
  {
    AppMethodBeat.i(201439);
    this.qVO = paramd;
    AppMethodBeat.o(201439);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201438);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = bs.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((com.tencent.mm.protocal.d.DIc < i) || (com.tencent.mm.protocal.d.DIc > j))
        {
          ac.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(com.tencent.mm.protocal.d.DIc) });
          AppMethodBeat.o(201438);
          return false;
        }
        AppMethodBeat.o(201438);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(201435);
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
        paramMap = bv.L(paramMap, "finder");
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
          localObject = n.aXe((String)localObject);
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
      AppMethodBeat.o(201435);
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
    AppMethodBeat.o(201435);
    return paramMap;
  }
  
  public final boolean a(long paramLong, String paramString, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201437);
    d.g.b.k.h(paramList, "tipsList");
    d.g.b.k.h(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(201437);
        return true;
      }
      paramMap = (c)j.iP(paramList);
      int i;
      Iterator localIterator;
      if (paramMap != null)
      {
        i = paramMap.field_priority;
        paramMap = new ani();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label87:
        if (!localIterator.hasNext()) {
          break label490;
        }
        paramList = (c)localIterator.next();
        aon localaon = new aon();
        if (paramList.field_showType != com.tencent.mm.plugin.newtips.a.k.vns.value)
        {
          paramMap.EGs.add(localaon);
          int j = paramList.field_showType;
          if (j == com.tencent.mm.plugin.newtips.a.k.vnv.value)
          {
            localaon.title = paramList.field_title;
            localaon.tfk = 3;
            label177:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localaon.path = paramList;
            localaon.EHC = 1;
            if (paramLong != 40001002L) {
              break label433;
            }
            paramList = new aom();
            paramList.EHv = 2;
            localaon.EHD = 1;
            localaon.EHE = new b(paramList.toByteArray());
            paramMap.type = 1003;
            break label87;
            i = 0;
            break;
            if (j == com.tencent.mm.plugin.newtips.a.k.vny.value)
            {
              localaon.count = 1;
              localaon.tfk = 2;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.vnw.value)
            {
              localaon.oGN = paramList.field_icon_url;
              localaon.tfk = 4;
              break label177;
            }
            if (j == com.tencent.mm.plugin.newtips.a.k.vnt.value)
            {
              localaon.tfk = 1;
              break label177;
            }
            if (j != com.tencent.mm.plugin.newtips.a.k.vnu.value) {
              break label177;
            }
            localaon.tfk = 100;
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
            paramList = new aom();
            paramList.EHv = 4;
            localaon.EHD = 1;
            localaon.EHE = new b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label490:
      paramMap.EGt = paramString;
      paramMap.priority = i;
      paramString = new aoj();
      paramList = new aok();
      paramString.EHx.add(paramList);
      paramList.EHy = paramMap;
      this.qVO.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(201437);
      return true;
    }
    AppMethodBeat.o(201437);
    return false;
  }
  
  public final boolean a(long paramLong, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(201436);
    d.g.b.k.h(paramList, "tipsList");
    d.g.b.k.h(paramMap, "values");
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(201436);
        return true;
      }
      paramList = ((Iterable)paramList).iterator();
      i = 0;
      while (paramList.hasNext())
      {
        paramMap = (c)paramList.next();
        if (paramMap.field_tipId == 40001002L)
        {
          i = 1003;
        }
        else
        {
          if (paramMap.field_tipId != 40001001L) {
            break label146;
          }
          i = 1004;
        }
      }
    }
    label146:
    for (;;)
    {
      break;
      this.qVO.Dy(i);
      AppMethodBeat.o(201436);
      return true;
      AppMethodBeat.o(201436);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.a
 * JD-Core Version:    0.7.0.1
 */