package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.af;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveItem;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "pos", "", "feedId", "", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "liveStatus", "", "nickName", "(Lcom/tencent/mm/plugin/finder/model/FinderFollowData;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;ZLjava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "getCommentscene", "()Ljava/lang/String;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFollowData;", "getFeedId", "getLiveStatus", "()Z", "getNickName", "getPos", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class i
{
  final String feedId;
  final String nickName;
  final int pos;
  final s.p vjL;
  final String vjM;
  final af vjW;
  final boolean vjX;
  
  public i(af paramaf, int paramInt, String paramString1, s.p paramp, String paramString2, boolean paramBoolean, String paramString3)
  {
    AppMethodBeat.i(250941);
    this.vjW = paramaf;
    this.pos = paramInt;
    this.feedId = paramString1;
    this.vjL = paramp;
    this.vjM = paramString2;
    this.vjX = paramBoolean;
    this.nickName = paramString3;
    AppMethodBeat.o(250941);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250944);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.j(this.vjW, paramObject.vjW)) || (this.pos != paramObject.pos) || (!p.j(this.feedId, paramObject.feedId)) || (!p.j(this.vjL, paramObject.vjL)) || (!p.j(this.vjM, paramObject.vjM)) || (this.vjX != paramObject.vjX) || (!p.j(this.nickName, paramObject.nickName))) {}
      }
    }
    else
    {
      AppMethodBeat.o(250944);
      return true;
    }
    AppMethodBeat.o(250944);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250942);
    String str = "HellLiveItem(feed=" + this.vjW + ", pos=" + this.pos + ", feedId=" + this.feedId + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", liveStatus=" + this.vjX + ", nickName=" + this.nickName + ")";
    AppMethodBeat.o(250942);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.i
 * JD-Core Version:    0.7.0.1
 */