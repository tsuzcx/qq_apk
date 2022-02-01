package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.aj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "pos", "", "feedId", "", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "liveStatus", "", "nickName", "(Lcom/tencent/mm/plugin/finder/model/FinderFollowData;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;ZLjava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getFeedId", "getLiveStatus", "()Z", "getNickName", "getPos", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  final q.w DnM;
  final String DnN;
  final aj DnY;
  final boolean DnZ;
  final String feedId;
  final String nickName;
  final int pos;
  
  public h(aj paramaj, int paramInt, String paramString1, q.w paramw, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(351776);
    this.DnY = paramaj;
    this.pos = paramInt;
    this.feedId = paramString1;
    this.DnM = paramw;
    this.DnN = paramString2;
    this.DnZ = paramBoolean;
    this.nickName = paramString3;
    AppMethodBeat.o(351776);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351792);
    if (this == paramObject)
    {
      AppMethodBeat.o(351792);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(351792);
      return false;
    }
    paramObject = (h)paramObject;
    if (!s.p(this.DnY, paramObject.DnY))
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (this.pos != paramObject.pos)
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (!s.p(this.feedId, paramObject.feedId))
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (this.DnM != paramObject.DnM)
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (!s.p(this.DnN, paramObject.DnN))
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (this.DnZ != paramObject.DnZ)
    {
      AppMethodBeat.o(351792);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(351792);
      return false;
    }
    AppMethodBeat.o(351792);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351781);
    String str = "HellLiveItem(feed=" + this.DnY + ", pos=" + this.pos + ", feedId=" + this.feedId + ", actionType=" + this.DnM + ", commentscene=" + this.DnN + ", liveStatus=" + this.DnZ + ", nickName=" + this.nickName + ')';
    AppMethodBeat.o(351781);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.h
 * JD-Core Version:    0.7.0.1
 */