package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.c;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveMusicReportHelper;", "", "()V", "anchorActionReport", "", "liveStart", "", "type", "", "songId", "songIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
public final class x
{
  public static final x ych;
  
  static
  {
    AppMethodBeat.i(279650);
    ych = new x();
    AppMethodBeat.o(279650);
  }
  
  public static void a(boolean paramBoolean, int paramInt, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(279649);
    p.k(paramArrayList, "songIdList");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt);
    localJSONObject.put("music_id", paramArrayList);
    if (!paramBoolean)
    {
      paramArrayList = k.yBj;
      k.t(s.a.yEa.jWO, localJSONObject.toString());
      AppMethodBeat.o(279649);
      return;
    }
    paramArrayList = k.yBj;
    k.a(s.c.yEE, localJSONObject.toString());
    AppMethodBeat.o(279649);
  }
  
  public static void h(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(279647);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramBoolean, paramInt1, localArrayList);
    AppMethodBeat.o(279647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.x
 * JD-Core Version:    0.7.0.1
 */