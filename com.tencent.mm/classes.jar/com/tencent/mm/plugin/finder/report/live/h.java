package com.tencent.mm.plugin.finder.report.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed;", "", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "userName", "", "pos", "", "feedId", "feedIdL", "", "liveId", "actionType", "Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "commentscene", "onlineNum", "nickName", "liveStatus", "Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "isLiveCard", "", "isSingleLiveAvatar", "shareType", "(Lcom/tencent/mm/plugin/finder/model/RVFeed;Ljava/lang/String;ILjava/lang/String;JJLcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;ZZI)V", "getActionType", "()Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;", "setActionType", "(Lcom/tencent/mm/plugin/finder/report/live/LiveReportConfig$ExploreType;)V", "getCommentscene", "()Ljava/lang/String;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getFeedId", "getFeedIdL", "()J", "()Z", "getLiveId", "getLiveStatus", "()Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "getNickName", "getOnlineNum", "()I", "getPos", "getShareType", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "LIVE_STATUS", "plugin-finder_release"})
public final class h
{
  public static final a vjR;
  final String feedId;
  final long liveId;
  final String nickName;
  final int onlineNum;
  final int pos;
  final bo tIu;
  final String userName;
  final long vjK;
  s.p vjL;
  final String vjM;
  final b vjN;
  final boolean vjO;
  final boolean vjP;
  final int vjQ;
  
  static
  {
    AppMethodBeat.i(250937);
    vjR = new a((byte)0);
    AppMethodBeat.o(250937);
  }
  
  public h(bo parambo, String paramString1, int paramInt1, String paramString2, long paramLong1, long paramLong2, s.p paramp, String paramString3, int paramInt2, String paramString4, b paramb, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    AppMethodBeat.i(250935);
    this.tIu = parambo;
    this.userName = paramString1;
    this.pos = paramInt1;
    this.feedId = paramString2;
    this.vjK = paramLong1;
    this.liveId = paramLong2;
    this.vjL = paramp;
    this.vjM = paramString3;
    this.onlineNum = paramInt2;
    this.nickName = paramString4;
    this.vjN = paramb;
    this.vjO = paramBoolean1;
    this.vjP = paramBoolean2;
    this.vjQ = paramInt3;
    AppMethodBeat.o(250935);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250940);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.j(this.tIu, paramObject.tIu)) || (!p.j(this.userName, paramObject.userName)) || (this.pos != paramObject.pos) || (!p.j(this.feedId, paramObject.feedId)) || (this.vjK != paramObject.vjK) || (this.liveId != paramObject.liveId) || (!p.j(this.vjL, paramObject.vjL)) || (!p.j(this.vjM, paramObject.vjM)) || (this.onlineNum != paramObject.onlineNum) || (!p.j(this.nickName, paramObject.nickName)) || (!p.j(this.vjN, paramObject.vjN)) || (this.vjO != paramObject.vjO) || (this.vjP != paramObject.vjP) || (this.vjQ != paramObject.vjQ)) {}
      }
    }
    else
    {
      AppMethodBeat.o(250940);
      return true;
    }
    AppMethodBeat.o(250940);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250938);
    String str = "HellLiveFeed(feed=" + this.tIu + ", userName=" + this.userName + ", pos=" + this.pos + ", feedId=" + this.feedId + ", feedIdL=" + this.vjK + ", liveId=" + this.liveId + ", actionType=" + this.vjL + ", commentscene=" + this.vjM + ", onlineNum=" + this.onlineNum + ", nickName=" + this.nickName + ", liveStatus=" + this.vjN + ", isLiveCard=" + this.vjO + ", isSingleLiveAvatar=" + this.vjP + ", shareType=" + this.vjQ + ")";
    AppMethodBeat.o(250938);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$Companion;", "", "()V", "getLiveId", "Lcom/tencent/mm/vending/tuple/Tuple3;", "", "", "", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getNickName", "", "plugin-finder_release"})
  public static final class a
  {
    public static d<Long, Integer, Boolean> a(bo parambo)
    {
      long l = 0L;
      int i = 0;
      AppMethodBeat.i(250930);
      p.h(parambo, "rvFeed");
      awe localawe;
      label65:
      boolean bool;
      if ((parambo instanceof BaseFinderFeed))
      {
        localawe = ((BaseFinderFeed)parambo).feedObject.getLiveInfo();
        if (localawe != null)
        {
          l = localawe.liveId;
          parambo = ((BaseFinderFeed)parambo).feedObject.getLiveInfo();
          if (parambo == null) {
            break label103;
          }
          i = parambo.uBn;
          bool = false;
        }
      }
      for (;;)
      {
        parambo = a.i(Long.valueOf(l), Integer.valueOf(i), Boolean.valueOf(bool));
        p.g(parambo, "Tuple.make(liveId, onlineCnt, isSingleLiveAvatar)");
        AppMethodBeat.o(250930);
        return parambo;
        l = 0L;
        break;
        label103:
        i = 0;
        break label65;
        if ((parambo instanceof y))
        {
          localawe = ((y)parambo).uOo.liveInfo;
          if (localawe != null) {
            l = localawe.liveId;
          }
          parambo = ((y)parambo).uOo.liveInfo;
          if (parambo != null) {
            i = parambo.uBn;
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
    
    public static String b(bo parambo)
    {
      AppMethodBeat.i(250931);
      p.h(parambo, "rvFeed");
      Object localObject = "";
      if ((parambo instanceof BaseFinderFeed)) {
        localObject = ((BaseFinderFeed)parambo).feedObject.getNickName();
      }
      for (;;)
      {
        AppMethodBeat.o(250931);
        return localObject;
        if ((parambo instanceof y))
        {
          parambo = ((y)parambo).uOo.nickname;
          localObject = parambo;
          if (parambo == null) {
            localObject = "";
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/live/HellLiveFeed$LIVE_STATUS;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNDEFINE", "ING", "NOT", "plugin-finder_release"})
  public static enum b
  {
    private final int status;
    
    static
    {
      AppMethodBeat.i(250932);
      b localb1 = new b("UNDEFINE", 0, -1);
      vjS = localb1;
      b localb2 = new b("ING", 1, 0);
      vjT = localb2;
      b localb3 = new b("NOT", 2, 1);
      vjU = localb3;
      vjV = new b[] { localb1, localb2, localb3 };
      AppMethodBeat.o(250932);
    }
    
    private b(int paramInt)
    {
      this.status = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.live.h
 * JD-Core Version:    0.7.0.1
 */