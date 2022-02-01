package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellVisitorClickData;", "", "feedId", "", "liveId", "userName", "", "index", "onlineNum", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "shareType", "shareUserName", "snsFeedid", "enterIconType", "", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "(JJLjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getEnterIconType", "()I", "getFeedId", "()J", "getIndex", "getLiveId", "getOnlineNum", "getShareType", "getShareUserName", "getSnsFeedid", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class p
{
  final long feedId;
  final String kit;
  final long liveId;
  final String userName;
  private final String wmz;
  final s.t yAO;
  final String yAP;
  final String yAU;
  final String yAV;
  final String yCA;
  private final int yCB;
  final long yCx;
  final long yCy;
  final long yCz;
  
  private p(long paramLong1, long paramLong2, String paramString1, long paramLong3, long paramLong4, s.t paramt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(286298);
    this.feedId = paramLong1;
    this.liveId = paramLong2;
    this.userName = paramString1;
    this.yCx = paramLong3;
    this.yCy = paramLong4;
    this.yAO = paramt;
    this.yAP = paramString2;
    this.yCz = 0L;
    this.kit = paramString3;
    this.yCA = paramString4;
    this.yCB = 0;
    this.wmz = paramString5;
    this.yAU = paramString6;
    this.yAV = paramString7;
    AppMethodBeat.o(286298);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286303);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.feedId != paramObject.feedId) || (this.liveId != paramObject.liveId) || (!kotlin.g.b.p.h(this.userName, paramObject.userName)) || (this.yCx != paramObject.yCx) || (this.yCy != paramObject.yCy) || (!kotlin.g.b.p.h(this.yAO, paramObject.yAO)) || (!kotlin.g.b.p.h(this.yAP, paramObject.yAP)) || (this.yCz != paramObject.yCz) || (!kotlin.g.b.p.h(this.kit, paramObject.kit)) || (!kotlin.g.b.p.h(this.yCA, paramObject.yCA)) || (this.yCB != paramObject.yCB) || (!kotlin.g.b.p.h(this.wmz, paramObject.wmz)) || (!kotlin.g.b.p.h(this.yAU, paramObject.yAU)) || (!kotlin.g.b.p.h(this.yAV, paramObject.yAV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(286303);
      return true;
    }
    AppMethodBeat.o(286303);
    return false;
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    AppMethodBeat.i(286302);
    long l = this.feedId;
    int i4 = (int)(l ^ l >>> 32);
    l = this.liveId;
    int i5 = (int)(l ^ l >>> 32);
    Object localObject = this.userName;
    int i;
    int i6;
    int i7;
    int j;
    label110:
    int k;
    label127:
    int i8;
    int m;
    label162:
    int n;
    label180:
    int i9;
    int i1;
    if (localObject != null)
    {
      i = localObject.hashCode();
      l = this.yCx;
      i6 = (int)(l ^ l >>> 32);
      l = this.yCy;
      i7 = (int)(l ^ l >>> 32);
      localObject = this.yAO;
      if (localObject == null) {
        break label328;
      }
      j = localObject.hashCode();
      localObject = this.yAP;
      if (localObject == null) {
        break label333;
      }
      k = localObject.hashCode();
      l = this.yCz;
      i8 = (int)(l ^ l >>> 32);
      localObject = this.kit;
      if (localObject == null) {
        break label338;
      }
      m = localObject.hashCode();
      localObject = this.yCA;
      if (localObject == null) {
        break label344;
      }
      n = localObject.hashCode();
      i9 = this.yCB;
      localObject = this.wmz;
      if (localObject == null) {
        break label350;
      }
      i1 = localObject.hashCode();
      label204:
      localObject = this.yAU;
      if (localObject == null) {
        break label356;
      }
    }
    label328:
    label333:
    label338:
    label344:
    label350:
    label356:
    for (int i2 = localObject.hashCode();; i2 = 0)
    {
      localObject = this.yAV;
      if (localObject != null) {
        i3 = localObject.hashCode();
      }
      AppMethodBeat.o(286302);
      return (i2 + (i1 + ((n + (m + ((k + (j + (((i + (i4 * 31 + i5) * 31) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31) * 31) * 31 + i9) * 31) * 31) * 31 + i3;
      i = 0;
      break;
      j = 0;
      break label110;
      k = 0;
      break label127;
      m = 0;
      break label162;
      n = 0;
      break label180;
      i1 = 0;
      break label204;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286300);
    String str = "HellVisitorClickData(feedId=" + this.feedId + ", liveId=" + this.liveId + ", userName=" + this.userName + ", index=" + this.yCx + ", onlineNum=" + this.yCy + ", actionType=" + this.yAO + ", commentscene=" + this.yAP + ", shareType=" + this.yCz + ", shareUserName=" + this.kit + ", snsFeedid=" + this.yCA + ", enterIconType=" + this.yCB + ", clickTabContextId=" + this.wmz + ", clickSubTabContextId=" + this.yAU + ", chnlExtra=" + this.yAV + ")";
    AppMethodBeat.o(286300);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.p
 * JD-Core Version:    0.7.0.1
 */