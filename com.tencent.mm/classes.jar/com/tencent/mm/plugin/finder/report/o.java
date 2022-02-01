package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", "query", "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "reportExtStats", "searchStr", "result", "", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "Finder.FinderSearchReportLogic";
  public static final o zWG;
  
  static
  {
    AppMethodBeat.i(166603);
    zWG = new o();
    TAG = "Finder.FinderSearchReportLogic";
    AppMethodBeat.o(166603);
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, a> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(166601);
    p.k(paramString1, "requestId");
    p.k(paramHashMap, "exposeItemMap");
    paramString2 = Util.nullAs(paramString2, "");
    p.j(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.l(paramString2, ",", " ", false);
    StringBuffer localStringBuffer = new StringBuffer();
    long l = 0L;
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.Aaj)
      {
        locala.Aaj = true;
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
      Log.i(TAG, "report18691 ".concat(String.valueOf(paramString1)));
      f.Iyx.kvStat(18691, paramString1);
      AppMethodBeat.o(166601);
      return;
    }
  }
  
  public static void dPE()
  {
    AppMethodBeat.i(166602);
    String str = ((c)h.ae(c.class)).dbr();
    str = str + ',' + 1;
    Log.i(TAG, "report19184 ".concat(String.valueOf(str)));
    f.Iyx.kvStat(19184, str);
    AppMethodBeat.o(166602);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(274653);
    p.k(paramString1, "requestId");
    paramString2 = Util.nullAs(paramString2, "");
    p.j(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.l(paramString2, ",", " ", false);
    paramString2 = new StringBuilder().append(paramString1).append(',').append(paramString2).append(',').append(0).append(',').append(1).append(',');
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString1 = paramString1 + ',' + paramInt + ',' + 2;
    Log.i(TAG, "report18690 %s", new Object[] { paramString1 });
    f.Iyx.kvStat(18690, paramString1);
    AppMethodBeat.o(274653);
  }
  
  public static void u(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(274654);
    p.k(paramString, "searchStr");
    p.k(paramList, "result");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(274654);
      return;
    }
    Object localObject = s.zWV;
    localObject = new amd();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("feedActionType", 10);
    localJSONObject.put("search_data", paramString);
    localJSONObject.put("result_list", paramList.subList(0, Math.min(paramList.size(), 50)));
    ((amd)localObject).Swz = localJSONObject.toString();
    ((amd)localObject).finderUsername = z.bdh();
    s.a.a(null, (amd)localObject);
    AppMethodBeat.o(274654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.o
 * JD-Core Version:    0.7.0.1
 */