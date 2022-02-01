package com.tencent.mm.plugin.finder.nearby.live.square.tab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/live/square/tab/NearbyLiveSquareTabParser;", "", "()V", "liveTabInfoMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "parseTabName", "tabName", "storeTabs", "", "liveTabList", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "plugin-finder_release"})
public final class a
{
  private static final HashMap<String, Integer> uRP;
  public static final a uRQ;
  
  static
  {
    AppMethodBeat.i(249237);
    uRQ = new a();
    uRP = new HashMap();
    AppMethodBeat.o(249237);
  }
  
  public static int aul(String paramString)
  {
    AppMethodBeat.i(249236);
    p.h(paramString, "tabName");
    paramString = (Integer)uRP.get(paramString);
    if (paramString != null)
    {
      int i = paramString.intValue();
      AppMethodBeat.o(249236);
      return i;
    }
    AppMethodBeat.o(249236);
    return -1;
  }
  
  public static void el(List<? extends axj> paramList)
  {
    AppMethodBeat.i(249235);
    p.h(paramList, "liveTabList");
    uRP.clear();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        j.hxH();
      }
      localObject = ((axj)localObject).LHR;
      if (localObject == null) {
        p.hyc();
      }
      p.g(localObject, "tab.tab_name!!");
      ((Map)uRP).put(localObject, Integer.valueOf(i + 1005));
      i += 1;
    }
    AppMethodBeat.o(249235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.square.tab.a
 * JD-Core Version:    0.7.0.1
 */