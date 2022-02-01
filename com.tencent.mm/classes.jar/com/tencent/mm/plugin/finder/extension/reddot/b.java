package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.a.l.a;
import com.tencent.mm.plugin.newtips.b.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkn;
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
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform;", "Lcom/tencent/mm/plugin/newtips/model/NewTipsXMLConsumer$NewTipsHandleCallback;", "redDotManager", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;", "(Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotManager;)V", "changeNewTipsPathToCtrInfoPath", "", "pathId", "", "checkValidClientVersion", "", "tipsId", "", "values", "", "findCtrInfoType", "getFinderNewTips", "handleAdd", "uniqueId", "tipsList", "", "Lcom/tencent/mm/plugin/newtips/storage/NewTipsInfo;", "handleCancel", "init", "", "parseFinderExtInfo", "Companion", "plugin-finder_release"})
public final class b
  implements l.a
{
  public static final a xsv;
  private final f wVw;
  
  static
  {
    AppMethodBeat.i(233449);
    xsv = new a((byte)0);
    AppMethodBeat.o(233449);
  }
  
  public b(f paramf)
  {
    AppMethodBeat.i(233447);
    this.wVw = paramf;
    AppMethodBeat.o(233447);
  }
  
  private static boolean a(long paramLong, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233446);
    if (paramMap.containsKey(".sysmsg.newtips.control.android_min_clientversion")) {}
    for (int i = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_min_clientversion"), 0);; i = 0)
    {
      if (paramMap.containsKey(".sysmsg.newtips.control.android_max_clientversion")) {}
      for (int j = Util.getInt((String)paramMap.get(".sysmsg.newtips.control.android_max_clientversion"), 2147483647);; j = 0)
      {
        if ((d.RAD < i) || (d.RAD > j))
        {
          Log.w("Finder.NewTipsTransform", "tipsId=%s, checkValidClientVersion client not match(%s, %s) %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(d.RAD) });
          AppMethodBeat.o(233446);
          return false;
        }
        AppMethodBeat.o(233446);
        return true;
      }
    }
  }
  
  private static Map<String, String> b(Map<String, String> paramMap, long paramLong)
  {
    AppMethodBeat.i(233438);
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
        p.j(paramMap, "extValues");
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
          localObject = n.bHC((String)localObject);
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
      AppMethodBeat.o(233438);
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
    AppMethodBeat.o(233438);
    return paramMap;
  }
  
  public final boolean a(final long paramLong, final String paramString, List<c> paramList, Map<String, String> paramMap)
  {
    AppMethodBeat.i(233440);
    p.k(paramList, "tipsList");
    p.k(paramMap, "values");
    Log.w("Finder.NewTipsTransform", "[handleCancel] tipsId=" + paramLong + " uniqueId=" + paramString);
    int i;
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(233440);
        return true;
      }
      if (paramLong == 40001002L) {
        i = 1003;
      }
    }
    for (;;)
    {
      if ((i != -1) && (this.wVw.b(i, (kotlin.g.a.b)new b(this, paramLong, paramMap, paramString)))) {
        Log.i("Finder.NewTipsTransform", "[handleCancel] successfully! tipsId=" + paramLong + " uniqueId=" + paramString);
      }
      AppMethodBeat.o(233440);
      return true;
      if (paramLong == 40001001L)
      {
        i = 1004;
        continue;
        AppMethodBeat.o(233440);
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
    AppMethodBeat.i(233444);
    p.k(paramList, "tipsList");
    p.k(paramMap, "values");
    if (b(paramMap, paramLong) != null)
    {
      if (!a(paramLong, paramMap))
      {
        AppMethodBeat.o(233444);
        return true;
      }
      paramMap = (c)j.lp(paramList);
      int i;
      Iterator localIterator;
      if (paramMap != null)
      {
        i = paramMap.field_priority;
        paramMap = new bhw();
        localIterator = ((Iterable)paramList).iterator();
      }
      for (;;)
      {
        label87:
        if (!localIterator.hasNext()) {
          break label491;
        }
        paramList = (c)localIterator.next();
        bkn localbkn = new bkn();
        if (paramList.field_showType != k.GwJ.value)
        {
          paramMap.MFx.add(localbkn);
          int j = paramList.field_showType;
          if (j == k.GwM.value)
          {
            localbkn.title = paramList.field_title;
            localbkn.CKC = 3;
            label177:
            switch (paramList.field_path)
            {
            default: 
              paramList = "";
            }
          }
          for (;;)
          {
            localbkn.path = paramList;
            localbkn.SVs = 1;
            if (paramLong != 40001002L) {
              break label434;
            }
            paramList = new FinderTipsShowEntranceExtInfo();
            paramList.tab_type = 2;
            localbkn.SVt = 1;
            localbkn.SVu = new com.tencent.mm.cd.b(paramList.toByteArray());
            paramMap.type = 1003;
            break label87;
            i = 0;
            break;
            if (j == k.GwP.value)
            {
              localbkn.count = 1;
              localbkn.CKC = 2;
              break label177;
            }
            if (j == k.GwN.value)
            {
              localbkn.ufC = paramList.field_icon_url;
              localbkn.CKC = 4;
              break label177;
            }
            if (j == k.GwK.value)
            {
              localbkn.CKC = 1;
              break label177;
            }
            if (j != k.GwL.value) {
              break label177;
            }
            localbkn.CKC = 100;
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
            localbkn.SVt = 1;
            localbkn.SVu = new com.tencent.mm.cd.b(paramList.toByteArray());
            paramMap.type = 1004;
          }
        }
      }
      label491:
      paramMap.SQm = paramString;
      paramMap.priority = i;
      paramString = new bke();
      paramList = new bkg();
      paramString.SSJ.add(paramList);
      paramList.SVk = paramMap;
      this.wVw.a(paramString, "FinderNewTipsTransform");
      AppMethodBeat.o(233444);
      return true;
    }
    AppMethodBeat.o(233444);
    return false;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$Companion;", "", "()V", "NEW_TIPS_TIPS_ID_FINDER_TL_HOT_TAB", "", "NEW_TIPS_TIPS_ID_FINDER_TL_NEARBY_TAB", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER", "", "NEW_XML_PATH_TYPE_TIPS_EXT_INFO_FINDER_RED_DOT_TYPE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "invoke", "com/tencent/mm/plugin/finder/extension/reddot/FinderNewTipsTransform$handleCancel$1$ret$1"})
  static final class b
    extends q
    implements kotlin.g.a.b<l, Boolean>
  {
    b(b paramb, long paramLong, Map paramMap, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.b
 * JD-Core Version:    0.7.0.1
 */