package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.n.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", "query", "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "reportExtStats", "searchStr", "result", "", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "Finder.FinderSearchReportLogic";
  public static final j syU;
  
  static
  {
    AppMethodBeat.i(166603);
    syU = new j();
    TAG = "Finder.FinderSearchReportLogic";
    AppMethodBeat.o(166603);
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, a> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(166601);
    p.h(paramString1, "requestId");
    p.h(paramHashMap, "exposeItemMap");
    paramString2 = bu.bI(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.h(paramString2, ",", " ", false);
    StringBuffer localStringBuffer = new StringBuffer();
    long l = 0L;
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.sDg)
      {
        locala.sDg = true;
        localStringBuffer.append(locala.position);
        localStringBuffer.append("#");
        localStringBuffer.append(locala.type);
        localStringBuffer.append("#");
        localStringBuffer.append(locala.id);
        localStringBuffer.append("#");
        localStringBuffer.append(locala.timeStamp);
        localStringBuffer.append(";");
        if (locala.timeStamp < l) {
          l = locala.timeStamp;
        }
      }
    }
    if (((CharSequence)localStringBuffer).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(166601);
      return;
    }
    paramString1 = new StringBuilder().append(paramString1).append(',').append(paramString2).append(',').append(0).append(',').append(localStringBuffer).append(',').append(paramInt).append(',').append(System.currentTimeMillis() - l).append(',');
    if (paramHashMap.isEmpty()) {}
    for (paramInt = 0;; paramInt = 1)
    {
      paramString1 = paramInt;
      ae.i(TAG, "report18691 ".concat(String.valueOf(paramString1)));
      e.ywz.kvStat(18691, paramString1);
      AppMethodBeat.o(166601);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(166600);
    p.h(paramString1, "requestId");
    paramString2 = bu.bI(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.h(paramString2, ",", " ", false);
    paramString2 = new StringBuilder().append(paramString1).append(',').append(paramString2).append(',').append(0).append(',').append(paramInt1).append(',');
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString1 = paramString1 + ',' + paramInt2 + ',' + paramInt3;
    ae.i(TAG, "report18690 %s", new Object[] { paramString1 });
    e.ywz.kvStat(18690, paramString1);
    AppMethodBeat.o(166600);
  }
  
  public static void cFv()
  {
    AppMethodBeat.i(166602);
    String str = ((c)g.ab(c.class)).cos();
    str = str + ',' + 1;
    ae.i(TAG, "report19184 ".concat(String.valueOf(str)));
    e.ywz.kvStat(19184, str);
    AppMethodBeat.o(166602);
  }
  
  public static void r(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(203854);
    p.h(paramString, "searchStr");
    p.h(paramList, "result");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203854);
      return;
    }
    Object localObject = l.szc;
    localObject = new aio();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("feedActionType", 10);
    localJSONObject.put("search_data", paramString);
    localJSONObject.put("result_list", paramList.subList(0, Math.min(paramList.size(), 50)));
    ((aio)localObject).Gyn = localJSONObject.toString();
    ((aio)localObject).sbR = v.aAK();
    l.a.a(null, (aio)localObject);
    AppMethodBeat.o(203854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.j
 * JD-Core Version:    0.7.0.1
 */