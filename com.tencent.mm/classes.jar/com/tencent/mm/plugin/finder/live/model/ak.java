package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic;", "", "()V", "TAG", "", "hadTriggerShowFollowBtnCache", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$ShowBtnContext;", "checkTriggerShow", "", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "liveId", "scene", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$TriggerActionScene;", "shakeBtn", "", "hadCacheTriggerShow", "reportFollowBtnClick", "reportFollowBtnInitShow", "ShowBtnContext", "TriggerActionScene", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
{
  public static final ak CHI;
  private static final h<Long, ak.a> CHJ;
  
  static
  {
    AppMethodBeat.i(359222);
    CHI = new ak();
    CHJ = new h(10);
    AppMethodBeat.o(359222);
  }
  
  public static boolean oh(long paramLong)
  {
    AppMethodBeat.i(359199);
    boolean bool = CHJ.check(Long.valueOf(paramLong));
    Log.i("Finder.FinderLiveShowFollowBtnLogic", s.X("hadTriggerShow ", Boolean.valueOf(bool)));
    AppMethodBeat.o(359199);
    return bool;
  }
  
  public static void oi(long paramLong)
  {
    AppMethodBeat.i(359208);
    if (!CHJ.check(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(359208);
      return;
    }
    Object localObject = (ak.a)CHJ.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(359208);
      return;
    }
    j localj = j.Dob;
    q.s locals = q.s.Duj;
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("follow_icon_expose_condition_sessionid", ((ak.a)localObject).sessionId);
    localObject = ah.aiuX;
    localj.a(locals, localMap);
    AppMethodBeat.o(359208);
  }
  
  public static void oj(long paramLong)
  {
    AppMethodBeat.i(359215);
    if (!CHJ.check(Long.valueOf(paramLong)))
    {
      AppMethodBeat.o(359215);
      return;
    }
    Object localObject = (ak.a)CHJ.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(359215);
      return;
    }
    j localj = j.Dob;
    q.t localt = q.t.Dvr;
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("follow_icon_expose_condition", String.valueOf(((ak.a)localObject).CHK.ordinal()));
    localMap.put("follow_icon_expose_condition_sessionid", ((ak.a)localObject).sessionId);
    localObject = ah.aiuX;
    localj.a(localt, localMap);
    AppMethodBeat.o(359215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ak
 * JD-Core Version:    0.7.0.1
 */