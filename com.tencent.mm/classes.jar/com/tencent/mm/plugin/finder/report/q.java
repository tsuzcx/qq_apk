package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "", "()V", "report21673", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "eventCode", "", "eventTime", "", "index", "jumpType", "wording", "", "friendLikeCount", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJIILjava/lang/String;Ljava/lang/Integer;)V", "report21856", "Companion", "plugin-finder_release"})
public final class q
{
  private static final q zWI;
  public static final a zWJ;
  
  static
  {
    AppMethodBeat.i(250055);
    zWJ = new a((byte)0);
    zWI = new q();
    AppMethodBeat.o(250055);
  }
  
  public static void a(bid parambid, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250053);
    if (parambid != null)
    {
      Log.i("Finder.FinderShareReporter", "FinderShareReporter.report21856, sessionId = " + parambid.sessionId + ", clickTabContextId = " + parambid.wmz + ", contextId = " + parambid.wmL + ", commentScene = " + parambid.xkX + ", eventCode = " + paramInt + ", eventTime = " + paramLong);
      h.IzE.a(21856, new Object[] { parambid.sessionId, parambid.wmz, parambid.wmL, Integer.valueOf(parambid.xkX), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    }
    AppMethodBeat.o(250053);
  }
  
  public static void a(bid parambid, int paramInt1, long paramLong, int paramInt2, int paramInt3, String paramString, Integer paramInteger)
  {
    AppMethodBeat.i(250051);
    p.k(paramString, "wording");
    int i;
    StringBuilder localStringBuilder;
    if (parambid != null)
    {
      localObject = aj.AGc;
      if (!aj.eev()) {
        break label275;
      }
      i = 1;
      localStringBuilder = new StringBuilder("FinderShareReporter.report21673, sessionId = ").append(parambid.sessionId).append(", clickTabContextId = ").append(parambid.wmz).append(", contextId = ").append(parambid.wmL).append(", commentScene = ").append(parambid.xkX).append(", eventCode = ").append(paramInt1).append(", eventTime = ").append(paramLong).append(", index = ").append(paramInt2).append(", jumpType=").append(paramInt3).append(", entranceStatus=").append(i).append(", wording=").append(paramString).append(", frilikecnt=");
      if (paramInteger != null) {
        break label281;
      }
    }
    label275:
    label281:
    for (Object localObject = "null";; localObject = paramInteger)
    {
      Log.i("Finder.FinderShareReporter", localObject);
      h.IzE.a(21673, new Object[] { parambid.sessionId, parambid.wmz, parambid.wmL, Integer.valueOf(parambid.xkX), Integer.valueOf(paramInt1), Long.valueOf(paramLong), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), paramString, paramInteger });
      AppMethodBeat.o(250051);
      return;
      i = 0;
      break;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/FinderShareReporter$Companion;", "", "()V", "EVENT_CODE_CLICK", "", "EVENT_CODE_SHOW", "EVENT_EXPOSE_ANIMATION", "EVENT_EXPOSE_STATIC", "INSTANCE", "Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "getINSTANCE", "()Lcom/tencent/mm/plugin/finder/report/FinderShareReporter;", "JUMP_TYPE_CARD", "JUMP_TYPE_POPUP", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.q
 * JD-Core Version:    0.7.0.1
 */