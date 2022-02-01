package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.ah;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveItem;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "pos", "", "feedId", "", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "liveStatus", "", "nickName", "(Lcom/tencent/mm/plugin/finder/model/FinderFollowData;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;ZLjava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getFeedId", "getLiveStatus", "()Z", "getNickName", "getPos", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class i
{
  final String feedId;
  final String nickName;
  final int pos;
  final s.t yAO;
  final String yAP;
  final ah yBb;
  final boolean yBc;
  
  public i(ah paramah, int paramInt, String paramString1, s.t paramt, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(273545);
    this.yBb = paramah;
    this.pos = paramInt;
    this.feedId = paramString1;
    this.yAO = paramt;
    this.yAP = paramString2;
    this.yBc = paramBoolean;
    this.nickName = paramString3;
    AppMethodBeat.o(273545);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(273549);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.h(this.yBb, paramObject.yBb)) || (this.pos != paramObject.pos) || (!p.h(this.feedId, paramObject.feedId)) || (!p.h(this.yAO, paramObject.yAO)) || (!p.h(this.yAP, paramObject.yAP)) || (this.yBc != paramObject.yBc) || (!p.h(this.nickName, paramObject.nickName))) {}
      }
    }
    else
    {
      AppMethodBeat.o(273549);
      return true;
    }
    AppMethodBeat.o(273549);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(273547);
    String str = "HellLiveItem(feed=" + this.yBb + ", pos=" + this.pos + ", feedId=" + this.feedId + ", actionType=" + this.yAO + ", commentscene=" + this.yAP + ", liveStatus=" + this.yBc + ", nickName=" + this.nickName + ")";
    AppMethodBeat.o(273547);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.i
 * JD-Core Version:    0.7.0.1
 */