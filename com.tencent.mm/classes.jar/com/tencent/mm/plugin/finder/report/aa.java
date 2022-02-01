package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", "query", "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "reportExtStats", "searchStr", "result", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa Fsi;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(166603);
    Fsi = new aa();
    TAG = "Finder.FinderSearchReportLogic";
    AppMethodBeat.o(166603);
  }
  
  public static void b(String paramString1, String paramString2, HashMap<String, a> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(166601);
    s.u(paramString1, "requestId");
    s.u(paramHashMap, "exposeItemMap");
    paramString2 = Util.nullAs(paramString2, "");
    s.s(paramString2, "nullAs(query, \"\")");
    paramString2 = n.m(paramString2, ",", " ", false);
    StringBuffer localStringBuffer = new StringBuffer();
    long l = 0L;
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.lAr)
      {
        locala.lAr = true;
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
      Log.i(TAG, s.X("report18691 ", paramString1));
      f.Ozc.kvStat(18691, paramString1);
      AppMethodBeat.o(166601);
      return;
    }
  }
  
  public static void eMZ()
  {
    AppMethodBeat.i(166602);
    String str = ((d)h.ax(d.class)).dHN();
    str = str + ',' + 1;
    Log.i(TAG, s.X("report19184 ", str));
    f.Ozc.kvStat(19184, str);
    AppMethodBeat.o(166602);
  }
  
  public static void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(331305);
    s.u(paramString1, "requestId");
    paramString2 = Util.nullAs(paramString2, "");
    s.s(paramString2, "nullAs(query, \"\")");
    paramString2 = n.m(paramString2, ",", " ", false);
    paramString2 = new StringBuilder().append(paramString1).append(',').append(paramString2).append(',').append(0).append(',').append(1).append(',');
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString1 = paramString1 + ',' + paramInt + ',' + 2;
    Log.i(TAG, "report18690 %s", new Object[] { paramString1 });
    f.Ozc.kvStat(18690, paramString1);
    AppMethodBeat.o(331305);
  }
  
  public static void z(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(331332);
    s.u(paramString, "searchStr");
    s.u(paramList, "result");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(331332);
      return;
    }
    Object localObject = ae.Fsm;
    localObject = new aps();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("feedActionType", 10);
    localJSONObject.put("search_data", paramString);
    localJSONObject.put("result_list", paramList.subList(0, Math.min(paramList.size(), 50)));
    ((aps)localObject).ZwW = localJSONObject.toString();
    ((aps)localObject).finderUsername = z.bAW();
    paramString = ah.aiuX;
    ae.a.b(null, (aps)localObject);
    AppMethodBeat.o(331332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.aa
 * JD-Core Version:    0.7.0.1
 */