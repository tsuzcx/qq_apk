package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "userName", "", "pos", "", "feedId", "feedIdL", "", "liveId", "actionType", "Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "commentscene", "onlineNum", "nickName", "liveStatus", "Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "isLiveCard", "", "isSingleLiveAvatar", "shareType", "clickTabContextId", "clickSubTabContextId", "chnlExtra", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Ljava/lang/String;ILjava/lang/String;JJLcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;ZZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;", "setActionType", "(Lcom/tencent/mm/plugin/finder/live/report/LiveReportConfig$ExploreType;)V", "getChnlExtra", "()Ljava/lang/String;", "getClickSubTabContextId", "getClickTabContextId", "getCommentscene", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getFeedId", "getFeedIdL", "()J", "()Z", "getLiveId", "getLiveStatus", "()Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "getNickName", "getOnlineNum", "()I", "getPos", "getShareType", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "LIVE_STATUS", "plugin-finder_release"})
public final class h
{
  public static final a yAW;
  final String feedId;
  final long liveId;
  final String nickName;
  final int onlineNum;
  final int pos;
  final String userName;
  private final String wmz;
  final bu xrd;
  final long yAN;
  s.t yAO;
  final String yAP;
  final b yAQ;
  final boolean yAR;
  final boolean yAS;
  final int yAT;
  final String yAU;
  final String yAV;
  
  static
  {
    AppMethodBeat.i(290329);
    yAW = new a((byte)0);
    AppMethodBeat.o(290329);
  }
  
  private h(bu parambu, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, s.t paramt, String paramString3, int paramInt2, String paramString4, b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(290327);
    this.xrd = parambu;
    this.userName = paramString1;
    this.pos = paramInt1;
    this.feedId = paramString2;
    this.yAN = paramLong1;
    this.liveId = paramLong2;
    this.yAO = paramt;
    this.yAP = paramString3;
    this.onlineNum = paramInt2;
    this.nickName = paramString4;
    this.yAQ = paramb;
    this.yAR = paramBoolean1;
    this.yAS = paramBoolean2;
    this.yAT = paramInt3;
    this.wmz = paramString5;
    this.yAU = paramString6;
    this.yAV = paramString7;
    AppMethodBeat.o(290327);
  }
  
  public final void a(s.t paramt)
  {
    AppMethodBeat.i(290326);
    p.k(paramt, "<set-?>");
    this.yAO = paramt;
    AppMethodBeat.o(290326);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(290332);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.h(this.xrd, paramObject.xrd)) || (!p.h(this.userName, paramObject.userName)) || (this.pos != paramObject.pos) || (!p.h(this.feedId, paramObject.feedId)) || (this.yAN != paramObject.yAN) || (this.liveId != paramObject.liveId) || (!p.h(this.yAO, paramObject.yAO)) || (!p.h(this.yAP, paramObject.yAP)) || (this.onlineNum != paramObject.onlineNum) || (!p.h(this.nickName, paramObject.nickName)) || (!p.h(this.yAQ, paramObject.yAQ)) || (this.yAR != paramObject.yAR) || (this.yAS != paramObject.yAS) || (this.yAT != paramObject.yAT) || (!p.h(this.wmz, paramObject.wmz)) || (!p.h(this.yAU, paramObject.yAU)) || (!p.h(this.yAV, paramObject.yAV))) {}
      }
    }
    else
    {
      AppMethodBeat.o(290332);
      return true;
    }
    AppMethodBeat.o(290332);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(290330);
    String str = "HellLiveFeed(feed=" + this.xrd + ", userName=" + this.userName + ", pos=" + this.pos + ", feedId=" + this.feedId + ", feedIdL=" + this.yAN + ", liveId=" + this.liveId + ", actionType=" + this.yAO + ", commentscene=" + this.yAP + ", onlineNum=" + this.onlineNum + ", nickName=" + this.nickName + ", liveStatus=" + this.yAQ + ", isLiveCard=" + this.yAR + ", isSingleLiveAvatar=" + this.yAS + ", shareType=" + this.yAT + ", clickTabContextId=" + this.wmz + ", clickSubTabContextId=" + this.yAU + ", chnlExtra=" + this.yAV + ")";
    AppMethodBeat.o(290330);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$Companion;", "", "()V", "getLiveId", "Lcom/tencent/mm/vending/tuple/Tuple3;", "", "", "", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getNickName", "", "plugin-finder_release"})
  public static final class a
  {
    public static d<Long, Integer, Boolean> a(bu parambu)
    {
      long l = 0L;
      int i = 0;
      AppMethodBeat.i(282866);
      p.k(parambu, "rvFeed");
      bac localbac;
      label65:
      boolean bool;
      if ((parambu instanceof BaseFinderFeed))
      {
        localbac = ((BaseFinderFeed)parambu).feedObject.getLiveInfo();
        if (localbac != null)
        {
          l = localbac.liveId;
          parambu = ((BaseFinderFeed)parambu).feedObject.getLiveInfo();
          if (parambu == null) {
            break label103;
          }
          i = parambu.yYz;
          bool = false;
        }
      }
      for (;;)
      {
        parambu = a.h(Long.valueOf(l), Integer.valueOf(i), Boolean.valueOf(bool));
        p.j(parambu, "Tuple.make(liveId, onlineCnt, isSingleLiveAvatar)");
        AppMethodBeat.o(282866);
        return parambu;
        l = 0L;
        break;
        label103:
        i = 0;
        break label65;
        if ((parambu instanceof y))
        {
          localbac = ((y)parambu).zAF.liveInfo;
          if (localbac != null) {
            l = localbac.liveId;
          }
          parambu = ((y)parambu).zAF.liveInfo;
          if (parambu != null) {
            i = parambu.yYz;
          }
          bool = true;
        }
        else
        {
          bool = false;
          i = -1;
          l = 0L;
        }
      }
    }
    
    public static String b(bu parambu)
    {
      AppMethodBeat.i(282867);
      p.k(parambu, "rvFeed");
      Object localObject = "";
      if ((parambu instanceof BaseFinderFeed)) {
        localObject = ((BaseFinderFeed)parambu).feedObject.getNickName();
      }
      for (;;)
      {
        AppMethodBeat.o(282867);
        return localObject;
        if ((parambu instanceof y))
        {
          parambu = ((y)parambu).zAF.nickname;
          localObject = parambu;
          if (parambu == null) {
            localObject = "";
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$LIVE_STATUS;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNDEFINE", "ING", "NOT", "plugin-finder_release"})
  public static enum b
  {
    private final int status;
    
    static
    {
      AppMethodBeat.i(282624);
      b localb1 = new b("UNDEFINE", 0, -1);
      yAX = localb1;
      b localb2 = new b("ING", 1, 0);
      yAY = localb2;
      b localb3 = new b("NOT", 2, 1);
      yAZ = localb3;
      yBa = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(282624);
    }
    
    private b(int paramInt)
    {
      this.status = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.h
 * JD-Core Version:    0.7.0.1
 */