package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.dl;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/report/FinderLivePlayFeedEntranceLogReporter;", "", "()V", "commentScene", "", "getCommentScene", "()Ljava/lang/String;", "setCommentScene", "(Ljava/lang/String;)V", "lastClickFeedIndex", "", "getLastClickFeedIndex", "()J", "setLastClickFeedIndex", "(J)V", "report", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "index", "action", "userName", "liveID", "feedID", "enterStatus", "sessionBuffer", "onlineNum", "reportClick", "", "reportEnter", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportExpose", "reset", "plugin-finder-nearby_release"})
public final class a
{
  private static String yBr;
  public static long zIY;
  public static final a zIZ;
  
  static
  {
    AppMethodBeat.i(199919);
    zIZ = new a();
    zIY = -1L;
    yBr = "94";
    AppMethodBeat.o(199919);
  }
  
  public static void OD(int paramInt)
  {
    AppMethodBeat.i(199908);
    yBr = String.valueOf(paramInt);
    AppMethodBeat.o(199908);
  }
  
  public static void a(w paramw, int paramInt)
  {
    AppMethodBeat.i(199909);
    p.k(paramw, "feed");
    a(paramw, paramInt, 1L);
    AppMethodBeat.o(199909);
  }
  
  public static void a(w paramw, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(199913);
    String str1 = paramw.feedObject.getUserName();
    Object localObject1 = paramw.feedObject.getLiveInfo();
    if (localObject1 != null)
    {
      localObject2 = String.valueOf(((bac)localObject1).liveId);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    String str2 = b.Fw(paramw.feedObject.getFeedObject().id);
    p.j(str2, "HellhoundUtil.long2Unsig…feedObject.feedObject.id)");
    String str3 = yBr;
    Object localObject3 = paramw.feedObject.getFeedObject().sessionBuffer;
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    p.j(localObject2, "feed.feedObject.feedObject.sessionBuffer ?: \"\"");
    localObject3 = paramw.feedObject.getLiveInfo();
    long l1;
    if (localObject3 != null)
    {
      l1 = ((bac)localObject3).SFG;
      paramw = paramw.feedObject.getLiveInfo();
      if ((paramw == null) || (paramw.liveStatus != 1)) {
        break label186;
      }
    }
    label186:
    for (long l2 = 1L;; l2 = 2L)
    {
      a(str1, (String)localObject1, str2, paramLong2, str3, paramLong1, l2, (String)localObject2, l1);
      AppMethodBeat.o(199913);
      return;
      l1 = 0L;
      break;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, long paramLong4)
  {
    AppMethodBeat.i(199917);
    dl localdl = new dl();
    localdl.pX(paramString1);
    localdl.pY(paramString2);
    localdl.pZ(paramString3);
    paramString2 = ((c)h.ae(c.class)).dbr();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localdl.qa(paramString1);
    localdl.iK(cm.bfE());
    localdl.iL(paramLong1);
    localdl.qb(paramString4);
    localdl.iM(paramLong2);
    localdl.iN(paramLong3);
    localdl.qc(e.zJs.agX());
    localdl.qd("1001-" + cm.bfE());
    localdl.qe(paramString5);
    localdl.iO(paramLong4);
    localdl.bpa();
    Log.i("FinderLivePlayFeedEntranceLogReporter", localdl.agI());
    AppMethodBeat.o(199917);
  }
  
  public static void reset()
  {
    zIY = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.a
 * JD-Core Version:    0.7.0.1
 */