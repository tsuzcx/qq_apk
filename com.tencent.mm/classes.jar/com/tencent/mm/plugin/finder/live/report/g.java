package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "userName", "", "pos", "", "feedId", "feedIdL", "", "liveId", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "onlineNum", "nickName", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "isLiveCard", "", "isSingleLiveAvatar", "shareType", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "fromUsername", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Ljava/lang/String;ILjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;ZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "setActionType", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;)V", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getFeedId", "getFeedIdL", "()J", "getFromUsername", "()Z", "getLiveId", "getLiveStatus", "()Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "getNickName", "getOnlineNum", "()I", "getPos", "getShareType", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "LIVE_STATUS", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a DnK;
  final cc AOm;
  final long DnL;
  q.w DnM;
  final String DnN;
  final b DnO;
  final boolean DnP;
  final boolean DnQ;
  final int DnR;
  final String DnS;
  final String DnT;
  final String feedId;
  final String hgk;
  final long liveId;
  final String nickName;
  final int onlineNum;
  final int pos;
  final String userName;
  private final String zIB;
  
  static
  {
    AppMethodBeat.i(351834);
    DnK = new g.a((byte)0);
    AppMethodBeat.o(351834);
  }
  
  private g(cc paramcc, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, q.w paramw, String paramString3, int paramInt2, String paramString4, b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(351823);
    this.AOm = paramcc;
    this.userName = paramString1;
    this.pos = paramInt1;
    this.feedId = paramString2;
    this.DnL = paramLong1;
    this.liveId = paramLong2;
    this.DnM = paramw;
    this.DnN = paramString3;
    this.onlineNum = paramInt2;
    this.nickName = paramString4;
    this.DnO = paramb;
    this.DnP = paramBoolean1;
    this.DnQ = paramBoolean2;
    this.DnR = paramInt3;
    this.zIB = paramString5;
    this.DnS = paramString6;
    this.DnT = paramString7;
    this.hgk = paramString8;
    AppMethodBeat.o(351823);
  }
  
  public final void a(q.w paramw)
  {
    AppMethodBeat.i(351843);
    s.u(paramw, "<set-?>");
    this.DnM = paramw;
    AppMethodBeat.o(351843);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351867);
    if (this == paramObject)
    {
      AppMethodBeat.o(351867);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.AOm, paramObject.AOm))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.pos != paramObject.pos)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.feedId, paramObject.feedId))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnL != paramObject.DnL)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.liveId != paramObject.liveId)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnM != paramObject.DnM)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.DnN, paramObject.DnN))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.onlineNum != paramObject.onlineNum)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnO != paramObject.DnO)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnP != paramObject.DnP)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnQ != paramObject.DnQ)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (this.DnR != paramObject.DnR)
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.zIB, paramObject.zIB))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.DnS, paramObject.DnS))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.DnT, paramObject.DnT))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    if (!s.p(this.hgk, paramObject.hgk))
    {
      AppMethodBeat.o(351867);
      return false;
    }
    AppMethodBeat.o(351867);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351850);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HellLiveFeed(feed=").append(this.AOm).append(", userName=").append(this.userName).append(", pos=").append(this.pos).append(", feedId=").append(this.feedId).append(", feedIdL=").append(this.DnL).append(", liveId=").append(this.liveId).append(", actionType=").append(this.DnM).append(", commentscene=").append(this.DnN).append(", onlineNum=").append(this.onlineNum).append(", nickName=").append(this.nickName).append(", liveStatus=").append(this.DnO).append(", isLiveCard=");
    ((StringBuilder)localObject).append(this.DnP).append(", isSingleLiveAvatar=").append(this.DnQ).append(", shareType=").append(this.DnR).append(", clickTabContextId=").append(this.zIB).append(", clickSubTabContextId=").append(this.DnS).append(", chnlExtra=").append(this.DnT).append(", fromUsername=").append(this.hgk).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(351850);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNDEFINE", "ING", "NOT", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    private final int status;
    
    static
    {
      AppMethodBeat.i(351772);
      DnU = new b("UNDEFINE", 0, -1);
      DnV = new b("ING", 1, 0);
      DnW = new b("NOT", 2, 1);
      DnX = new b[] { DnU, DnV, DnW };
      AppMethodBeat.o(351772);
    }
    
    private b(int paramInt)
    {
      this.status = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.g
 * JD-Core Version:    0.7.0.1
 */