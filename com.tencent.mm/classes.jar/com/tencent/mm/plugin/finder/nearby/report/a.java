package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.es;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/FinderLivePlayFeedEntranceLogReporter;", "", "()V", "commentScene", "", "getCommentScene", "()Ljava/lang/String;", "setCommentScene", "(Ljava/lang/String;)V", "lastClickFeedIndex", "", "getLastClickFeedIndex", "()J", "setLastClickFeedIndex", "(J)V", "report", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "index", "action", "userName", "liveID", "feedID", "enterStatus", "sessionBuffer", "onlineNum", "reportClick", "", "reportEnter", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportExpose", "reset", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static String Dol;
  public static final a EQq;
  private static long EQr;
  
  static
  {
    AppMethodBeat.i(339763);
    EQq = new a();
    EQr = -1L;
    Dol = "94";
    AppMethodBeat.o(339763);
  }
  
  public static void Ra(int paramInt)
  {
    AppMethodBeat.i(339714);
    Dol = String.valueOf(paramInt);
    AppMethodBeat.o(339714);
  }
  
  public static void a(x paramx, int paramInt)
  {
    AppMethodBeat.i(339724);
    s.u(paramx, "feed");
    a(paramx, paramInt, 1L);
    AppMethodBeat.o(339724);
  }
  
  private static void a(x paramx, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(339742);
    String str1 = paramx.feedObject.getUserName();
    Object localObject1 = paramx.feedObject.getLiveInfo();
    String str2;
    String str3;
    Object localObject3;
    Object localObject2;
    long l1;
    label101:
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      str2 = b.hF(paramx.feedObject.getFeedObject().id);
      s.s(str2, "long2UnsignedString(feed.feedObject.feedObject.id)");
      str3 = Dol;
      localObject3 = paramx.feedObject.getFeedObject().sessionBuffer;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      localObject3 = paramx.feedObject.getLiveInfo();
      if (localObject3 != null) {
        break label186;
      }
      l1 = 0L;
      paramx = paramx.feedObject.getLiveInfo();
      if ((paramx == null) || (paramx.liveStatus != 1)) {
        break label197;
      }
      i = 1;
      label124:
      if (i == 0) {
        break label203;
      }
    }
    label186:
    label197:
    label203:
    for (long l2 = 1L;; l2 = 2L)
    {
      a(str1, (String)localObject1, str2, paramLong2, str3, paramLong1, l2, (String)localObject2, l1);
      AppMethodBeat.o(339742);
      return;
      localObject2 = Long.valueOf(((bip)localObject1).liveId).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      l1 = ((bip)localObject3).EOg;
      break label101;
      i = 0;
      break label124;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, long paramLong3, String paramString5, long paramLong4)
  {
    AppMethodBeat.i(339754);
    es locales = new es();
    locales.pg(paramString1);
    locales.ph(paramString2);
    locales.pi(paramString3);
    paramString2 = ((d)h.ax(d.class)).dHN();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    locales.pj(paramString1);
    locales.iwW = cn.bDw();
    locales.ikE = paramLong1;
    locales.pk(paramString4);
    locales.ikr = paramLong2;
    locales.iwV = paramLong3;
    locales.pl(g.ERj.eeL());
    locales.pm(s.X("1001-", Long.valueOf(cn.bDw())));
    locales.pn(paramString5);
    locales.iEd = paramLong4;
    locales.bMH();
    Log.i("FinderLivePlayFeedEntranceLogReporter", locales.aIF());
    AppMethodBeat.o(339754);
  }
  
  public static void b(x paramx, int paramInt)
  {
    AppMethodBeat.i(339733);
    s.u(paramx, "feed");
    EQr = paramInt;
    a(paramx, paramInt, 2L);
    AppMethodBeat.o(339733);
  }
  
  public static void reset()
  {
    EQr = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.a
 * JD-Core Version:    0.7.0.1
 */