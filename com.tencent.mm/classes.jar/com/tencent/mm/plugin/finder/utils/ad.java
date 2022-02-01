package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant;", "", "()V", "Companion", "LiveStage", "plugin-finder_release"})
public final class ad
{
  private static final int vYG = 1;
  private static final int vYH = 2;
  private static final ArrayList<c> vYI;
  private static final c vYJ;
  private static final c vYK;
  private static final c vYL;
  private static final c vYM;
  private static final c vYN;
  private static final c vYO;
  private static final c vYP;
  private static final c vYQ;
  private static final c vYR;
  private static final c vYS;
  private static final c vYT;
  private static final c vYU;
  private static final c vYV;
  private static final c vYW;
  private static final c vYX;
  private static final c vYY;
  private static final c vYZ;
  private static final c vZa;
  private static final c vZb;
  private static final c vZc;
  private static final c vZd;
  private static final c vZe;
  private static final c vZf;
  private static final c vZg;
  private static final c vZh;
  private static final c vZi;
  private static final c vZj;
  private static final c vZk;
  private static final c vZl;
  private static final c vZm;
  private static final c vZn;
  private static final c vZo;
  private static final c vZp;
  private static final c vZq;
  private static final c vZr;
  private static final c vZs;
  private static final f<HashMap<String, Integer>> vZt;
  public static final a vZu;
  
  static
  {
    AppMethodBeat.i(253761);
    vZu = new a((byte)0);
    vYG = 1;
    vYH = 2;
    vYI = new ArrayList();
    c localc = new c(10, "ViewHolderBegin");
    vYI.add(localc);
    vYJ = localc;
    localc = new c(20, "ViewHolderEnd");
    vYI.add(localc);
    vYK = localc;
    localc = new c(30, "ItemSelectedBegin");
    vYI.add(localc);
    vYL = localc;
    localc = new c(40, "JoinLiveBegin");
    vYI.add(localc);
    vYM = localc;
    localc = new c(50, "ItemSelectedEnd");
    vYI.add(localc);
    vYN = localc;
    localc = new c(60, "JoinLiveCgiBack");
    vYI.add(localc);
    vYO = localc;
    localc = new c(70, "JoinLiveEnd");
    vYI.add(localc);
    vYP = localc;
    localc = new c(80, "StartLive");
    vYI.add(localc);
    vYQ = localc;
    localc = new c(90, "JoinLiveFinish");
    vYI.add(localc);
    vYR = localc;
    localc = new c(100, "ConnectSucc");
    vYI.add(localc);
    vYS = localc;
    localc = new c(110, "FirstFrameEvent");
    vYI.add(localc);
    vYT = localc;
    localc = new c(10, "AnchorDoPost");
    vYI.add(localc);
    vYU = localc;
    localc = new c(20, "AnchorCreateLive");
    vYI.add(localc);
    vYV = localc;
    localc = new c(21, "AnchorCreateLiveFailed");
    vYI.add(localc);
    vYW = localc;
    localc = new c(22, "RecheckRealName");
    vYI.add(localc);
    vYX = localc;
    localc = new c(30, "AnchorJoinLive");
    vYI.add(localc);
    vYY = localc;
    localc = new c(31, "AnchorJoinLiveFailed");
    vYI.add(localc);
    vYZ = localc;
    localc = new c(40, "AnchorEnterRoom");
    vYI.add(localc);
    vZa = localc;
    localc = new c(41, "AnchorEnterRoomFailed");
    vYI.add(localc);
    vZb = localc;
    localc = new c(50, "AnchorShareFeed");
    vYI.add(localc);
    vZc = localc;
    localc = new c(51, "AnchorShareFeedFailed");
    vYI.add(localc);
    vZd = localc;
    localc = new c(60, "AnchorCancelCreate");
    vYI.add(localc);
    vZe = localc;
    localc = new c(70, "AnchorSuccessLive");
    vYI.add(localc);
    vZf = localc;
    localc = new c(10, "AnchorLinkSelected");
    vYI.add(localc);
    vZg = localc;
    localc = new c(20, "AnchorLinkAcceptSuc");
    vYI.add(localc);
    vZh = localc;
    localc = new c(21, "AnchorLinkAcceptFail");
    vYI.add(localc);
    vZi = localc;
    localc = new c(30, "AnchorLinkHangupSuc");
    vYI.add(localc);
    vZj = localc;
    localc = new c(31, "AnchorLinkHangupFail");
    vYI.add(localc);
    vZk = localc;
    localc = new c(10, "VisitorLinkApplySuc");
    vYI.add(localc);
    vZl = localc;
    localc = new c(11, "VisitorLinkApplyFail");
    vYI.add(localc);
    vZm = localc;
    localc = new c(20, "VisitorLinkAccepted");
    vYI.add(localc);
    vZn = localc;
    localc = new c(30, "VisitorLinkHangupSuc");
    vYI.add(localc);
    vZo = localc;
    localc = new c(31, "VisitorLinkHangupFail");
    vYI.add(localc);
    vZp = localc;
    localc = new c(10, "VisitorRewardSuc");
    vYI.add(localc);
    vZq = localc;
    localc = new c(11, "VisitorRewardFail");
    vYI.add(localc);
    vZr = localc;
    localc = new c(12, "VisitorRewardConsumeFail");
    vYI.add(localc);
    vZs = localc;
    vZt = g.ah((a)b.vZv);
    AppMethodBeat.o(253761);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$Companion;", "", "()V", "AnchorCancelCreate", "Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "getAnchorCancelCreate", "()Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "AnchorCreateLive", "getAnchorCreateLive", "AnchorCreateLiveFailed", "getAnchorCreateLiveFailed", "AnchorDoPost", "getAnchorDoPost", "AnchorEnterRoom", "getAnchorEnterRoom", "AnchorEnterRoomFailed", "getAnchorEnterRoomFailed", "AnchorJoinLive", "getAnchorJoinLive", "AnchorJoinLiveFailed", "getAnchorJoinLiveFailed", "AnchorLinkAcceptFail", "getAnchorLinkAcceptFail", "AnchorLinkAcceptSuc", "getAnchorLinkAcceptSuc", "AnchorLinkHangupFail", "getAnchorLinkHangupFail", "AnchorLinkHangupSuc", "getAnchorLinkHangupSuc", "AnchorLinkSelected", "getAnchorLinkSelected", "AnchorShareFeed", "getAnchorShareFeed", "AnchorShareFeedFailed", "getAnchorShareFeedFailed", "AnchorSuccessLive", "getAnchorSuccessLive", "ConnectSucc", "getConnectSucc", "FirstFrameEvent", "getFirstFrameEvent", "ItemSelectedBegin", "getItemSelectedBegin", "ItemSelectedEnd", "getItemSelectedEnd", "JoinLiveBegin", "getJoinLiveBegin", "JoinLiveCgiBack", "getJoinLiveCgiBack", "JoinLiveEnd", "getJoinLiveEnd", "JoinLiveFinish", "getJoinLiveFinish", "RecheckRealName", "getRecheckRealName", "StartLive", "getStartLive", "TYPE_END", "", "getTYPE_END", "()I", "TYPE_START", "getTYPE_START", "ViewHolderBegin", "getViewHolderBegin", "ViewHolderEnd", "getViewHolderEnd", "VisitorLinkAccepted", "getVisitorLinkAccepted", "VisitorLinkApplyFail", "getVisitorLinkApplyFail", "VisitorLinkApplySuc", "getVisitorLinkApplySuc", "VisitorLinkHangupFail", "getVisitorLinkHangupFail", "VisitorLinkHangupSuc", "getVisitorLinkHangupSuc", "VisitorRewardConsumeFail", "getVisitorRewardConsumeFail", "VisitorRewardFail", "getVisitorRewardFail", "VisitorRewardSuc", "getVisitorRewardSuc", "stageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stageNameIdMap", "Lkotlin/Lazy;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
  static final class b
    extends q
    implements a<HashMap<String, Integer>>
  {
    public static final b vZv;
    
    static
    {
      AppMethodBeat.i(253756);
      vZv = new b();
      AppMethodBeat.o(253756);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "", "id", "", "name", "", "(ILjava/lang/String;)V", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class c
  {
    final int id;
    public final String name;
    
    public c(int paramInt, String paramString)
    {
      AppMethodBeat.i(253757);
      this.id = paramInt;
      this.name = paramString;
      AppMethodBeat.o(253757);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(253760);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.id != paramObject.id) || (!p.j(this.name, paramObject.name))) {}
        }
      }
      else
      {
        AppMethodBeat.o(253760);
        return true;
      }
      AppMethodBeat.o(253760);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(253759);
      int j = this.id;
      String str = this.name;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        AppMethodBeat.o(253759);
        return i + j * 31;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(253758);
      String str = "LiveStage(id=" + this.id + ", name=" + this.name + ")";
      AppMethodBeat.o(253758);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ad
 * JD-Core Version:    0.7.0.1
 */