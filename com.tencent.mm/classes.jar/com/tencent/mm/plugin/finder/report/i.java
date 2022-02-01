package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/FinderSearchReportLogic;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report18690", "", "requestId", "query", "requestType", "", "itemType", "itemId", "", "position", "scene", "report18691", "exposeItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "Lkotlin/collections/HashMap;", "report19184", "plugin-finder_release"})
public final class i
{
  private static final String TAG = "Finder.FinderSearchReportLogic";
  public static final i soN;
  
  static
  {
    AppMethodBeat.i(166603);
    soN = new i();
    TAG = "Finder.FinderSearchReportLogic";
    AppMethodBeat.o(166603);
  }
  
  public static void a(String paramString1, String paramString2, HashMap<String, a> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(166601);
    p.h(paramString1, "requestId");
    p.h(paramHashMap, "exposeItemMap");
    paramString2 = bt.bI(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.h(paramString2, ",", " ", false);
    StringBuffer localStringBuffer = new StringBuffer();
    long l = 0L;
    Iterator localIterator = paramHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.ssW)
      {
        locala.ssW = true;
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
      ad.i(TAG, "report18691 ".concat(String.valueOf(paramString1)));
      e.ygI.kvStat(18691, paramString1);
      AppMethodBeat.o(166601);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(166600);
    p.h(paramString1, "requestId");
    p.h(paramString3, "itemId");
    paramString2 = bt.bI(paramString2, "");
    p.g(paramString2, "Util.nullAs(query, \"\")");
    paramString2 = n.h(paramString2, ",", " ", false);
    paramString1 = paramString1 + ',' + paramString2 + ',' + 0 + ',' + paramInt1 + ',' + paramString3 + ',' + paramInt2 + ',' + paramInt3;
    ad.i(TAG, "report18690 %s", new Object[] { paramString1 });
    e.ygI.kvStat(18690, paramString1);
    AppMethodBeat.o(166600);
  }
  
  public static void cDA()
  {
    AppMethodBeat.i(166602);
    String str = ((c)g.ab(c.class)).cnc();
    str = str + ',' + 1;
    ad.i(TAG, "report19184 ".concat(String.valueOf(str)));
    e.ygI.kvStat(19184, str);
    AppMethodBeat.o(166602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */