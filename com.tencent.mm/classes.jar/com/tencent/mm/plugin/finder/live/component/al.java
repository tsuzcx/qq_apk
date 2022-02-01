package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveMusicReportHelper;", "", "()V", "anchorActionReport", "", "liveStart", "", "type", "", "songId", "songIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
{
  public static final al CAw;
  
  static
  {
    AppMethodBeat.i(352747);
    CAw = new al();
    AppMethodBeat.o(352747);
  }
  
  public static void a(boolean paramBoolean, int paramInt, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(352742);
    s.u(paramArrayList, "songIdList");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramInt);
    localJSONObject.put("music_id", paramArrayList);
    if (!paramBoolean)
    {
      j.Dob.C(q.a.DqV.mwI, localJSONObject.toString());
      AppMethodBeat.o(352742);
      return;
    }
    j.Dob.a(q.c.DrC, localJSONObject.toString());
    AppMethodBeat.o(352742);
  }
  
  public static void j(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(352734);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt2));
    a(paramBoolean, paramInt1, localArrayList);
    AppMethodBeat.o(352734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.al
 * JD-Core Version:    0.7.0.1
 */