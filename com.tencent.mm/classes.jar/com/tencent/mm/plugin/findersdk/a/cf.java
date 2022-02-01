package com.tencent.mm.plugin.findersdk.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.finder.live.report.q.bh;
import com.tencent.mm.plugin.finder.live.report.q.bi;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.report.q.cg;
import com.tencent.mm.plugin.finder.live.report.q.ch;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/api/IHellLiveVisitorReoprter;", "Lcom/tencent/mm/kernel/service/IService;", "assignScenenote", "", "_scenenote", "", "report21158", "action", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;", "finderUsrName", "enterLiveId", "", "enterStatus", "", "commentscene", "forcePushId", "noticeType", "reportContent", "notificationId", "desc", "scene", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorNoticeAction;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportGift", "type", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorGift;", "giftid", "num", "reportRedPacket", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketType;", "src", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$RedPacketSrc;", "inLive", "", "reportShare", "username", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$VisitorShareType;", "newChnlExtra", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface cf
  extends a
{
  public abstract void a(q.bi parambi, q.bh parambh, boolean paramBoolean);
  
  public abstract void a(q.cc paramcc, String paramString, int paramInt);
  
  public abstract void a(q.cg paramcg, String paramString1, long paramLong, String paramString2, String paramString3, Long paramLong1, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void a(String paramString, q.ch paramch, Map<String, String> paramMap);
  
  public abstract void axt(String paramString);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.cf
 * JD-Core Version:    0.7.0.1
 */