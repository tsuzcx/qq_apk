package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import org.json.JSONObject;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", "query", "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "reportExtStats", "searchStr", "result", "", "plugin-finder_release"})
public final class l
{
  private static final String TAG = "Finder.FinderSearchReportLogic";
  public static final l vfB;
  
  static
  {
    AppMethodBeat.i(166603);
    vfB = new l();
    TAG = "Finder.FinderSearchReportLogic";
    AppMethodBeat.o(166603);
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, a> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(166601);
    p.h(paramString1, "requestId");
    p.h(paramHashMap, "exposeItemMap");
    paramString2 = Util.nullAs(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.j(paramString2, ",", " ", false);
    StringBuffer localStringBuffer = new StringBuffer();
    long l = 0L;
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.vtY)
      {
        locala.vtY = true;
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
      e.Cxv.kvStat(18691, paramString1);
      AppMethodBeat.o(166601);
      return;
    }
  }
  
  public static void doe()
  {
    AppMethodBeat.i(166602);
    String str = ((c)g.af(c.class)).cMD();
    str = str + ',' + 1;
    Log.i(TAG, "report19184 ".concat(String.valueOf(str)));
    e.Cxv.kvStat(19184, str);
    AppMethodBeat.o(166602);
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(250708);
    p.h(paramString1, "requestId");
    paramString2 = Util.nullAs(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.j(paramString2, ",", " ", false);
    paramString2 = new StringBuilder().append(paramString1).append(',').append(paramString2).append(',').append(0).append(',').append(1).append(',');
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString1 = paramString1 + ',' + paramInt + ',' + 2;
    Log.i(TAG, "report18690 %s", new Object[] { paramString1 });
    e.Cxv.kvStat(18690, paramString1);
    AppMethodBeat.o(250708);
  }
  
  public static void t(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(250709);
    p.h(paramString, "searchStr");
    p.h(paramList, "result");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(250709);
      return;
    }
    Object localObject = o.vfN;
    localObject = new alc();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("feedActionType", 10);
    localJSONObject.put("search_data", paramString);
    localJSONObject.put("result_list", paramList.subList(0, Math.min(paramList.size(), 50)));
    ((alc)localObject).Lub = localJSONObject.toString();
    ((alc)localObject).finderUsername = z.aUg();
    o.a.a(null, (alc)localObject);
    AppMethodBeat.o(250709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.l
 * JD-Core Version:    0.7.0.1
 */