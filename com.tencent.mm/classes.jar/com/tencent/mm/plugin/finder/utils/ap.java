package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant;", "", "()V", "Companion", "LiveStage", "plugin-finder_release"})
public final class ap
{
  private static final ap.c AHA;
  private static final ap.c AHB;
  private static final ap.c AHC;
  private static final ap.c AHD;
  private static final ap.c AHE;
  private static final ap.c AHF;
  private static final ap.c AHG;
  private static final ap.c AHH;
  private static final ap.c AHI;
  private static final ap.c AHJ;
  private static final ap.c AHK;
  private static final ap.c AHL;
  private static final ap.c AHM;
  private static final ap.c AHN;
  private static final ap.c AHO;
  private static final ap.c AHP;
  private static final ap.c AHQ;
  private static final ap.c AHR;
  private static final ap.c AHS;
  private static final ap.c AHT;
  private static final ap.c AHU;
  private static final ap.c AHV;
  private static final ap.c AHW;
  private static final ap.c AHX;
  private static final ap.c AHY;
  private static final ap.c AHZ;
  private static final int AHo = 1;
  private static final int AHp = 2;
  private static final ArrayList<ap.c> AHq;
  private static final ap.c AHr;
  private static final ap.c AHs;
  private static final ap.c AHt;
  private static final ap.c AHu;
  private static final ap.c AHv;
  private static final ap.c AHw;
  private static final ap.c AHx;
  private static final ap.c AHy;
  private static final ap.c AHz;
  private static final ap.c AIa;
  private static final ap.c AIb;
  private static final ap.c AIc;
  private static final ap.c AId;
  private static final ap.c AIe;
  private static final ap.c AIf;
  private static final f<HashMap<String, Integer>> AIg;
  public static final a AIh;
  
  static
  {
    AppMethodBeat.i(282348);
    AIh = new a((byte)0);
    AHo = 1;
    AHp = 2;
    AHq = new ArrayList();
    ap.c localc = new ap.c(10, "ViewHolderBegin");
    AHq.add(localc);
    AHr = localc;
    localc = new ap.c(20, "ViewHolderEnd");
    AHq.add(localc);
    AHs = localc;
    localc = new ap.c(30, "ItemSelectedBegin");
    AHq.add(localc);
    AHt = localc;
    localc = new ap.c(40, "JoinLiveBegin");
    AHq.add(localc);
    AHu = localc;
    localc = new ap.c(50, "ItemSelectedEnd");
    AHq.add(localc);
    AHv = localc;
    localc = new ap.c(60, "JoinLiveCgiBack");
    AHq.add(localc);
    AHw = localc;
    localc = new ap.c(70, "JoinLiveEnd");
    AHq.add(localc);
    AHx = localc;
    localc = new ap.c(80, "StartLive");
    AHq.add(localc);
    AHy = localc;
    localc = new ap.c(90, "JoinLiveFinish");
    AHq.add(localc);
    AHz = localc;
    localc = new ap.c(100, "ConnectSucc");
    AHq.add(localc);
    AHA = localc;
    localc = new ap.c(110, "FirstFrameEvent");
    AHq.add(localc);
    AHB = localc;
    localc = new ap.c(120, "BeginPlay");
    AHq.add(localc);
    AHC = localc;
    localc = new ap.c(130, "EnterActivity");
    AHq.add(localc);
    AHD = localc;
    localc = new ap.c(140, "VisitorRoleGuide");
    AHq.add(localc);
    AHE = localc;
    localc = new ap.c(150, "NearbyRedDot");
    AHq.add(localc);
    AHF = localc;
    localc = new ap.c(160, "RestartLive");
    AHq.add(localc);
    AHG = localc;
    localc = new ap.c(10, "AnchorDoPost");
    AHq.add(localc);
    AHH = localc;
    localc = new ap.c(20, "AnchorCreateLive");
    AHq.add(localc);
    AHI = localc;
    localc = new ap.c(21, "AnchorCreateLiveFailed");
    AHq.add(localc);
    AHJ = localc;
    localc = new ap.c(22, "RecheckRealName");
    AHq.add(localc);
    AHK = localc;
    localc = new ap.c(30, "AnchorJoinLive");
    AHq.add(localc);
    AHL = localc;
    localc = new ap.c(31, "AnchorJoinLiveFailed");
    AHq.add(localc);
    AHM = localc;
    localc = new ap.c(40, "AnchorEnterRoom");
    AHq.add(localc);
    AHN = localc;
    localc = new ap.c(41, "AnchorEnterRoomFailed");
    AHq.add(localc);
    AHO = localc;
    localc = new ap.c(50, "AnchorShareFeed");
    AHq.add(localc);
    AHP = localc;
    localc = new ap.c(51, "AnchorShareFeedFailed");
    AHq.add(localc);
    AHQ = localc;
    localc = new ap.c(60, "AnchorCancelCreate");
    AHq.add(localc);
    AHR = localc;
    localc = new ap.c(70, "AnchorSuccessLive");
    AHq.add(localc);
    AHS = localc;
    localc = new ap.c(10, "AnchorLinkSelected");
    AHq.add(localc);
    AHT = localc;
    localc = new ap.c(20, "AnchorLinkAcceptSuc");
    AHq.add(localc);
    AHU = localc;
    localc = new ap.c(21, "AnchorLinkAcceptFail");
    AHq.add(localc);
    AHV = localc;
    localc = new ap.c(30, "AnchorLinkHangupSuc");
    AHq.add(localc);
    AHW = localc;
    localc = new ap.c(31, "AnchorLinkHangupFail");
    AHq.add(localc);
    AHX = localc;
    localc = new ap.c(10, "VisitorLinkApplySuc");
    AHq.add(localc);
    AHY = localc;
    localc = new ap.c(11, "VisitorLinkApplyFail");
    AHq.add(localc);
    AHZ = localc;
    localc = new ap.c(20, "VisitorLinkAccepted");
    AHq.add(localc);
    AIa = localc;
    localc = new ap.c(30, "VisitorLinkHangupSuc");
    AHq.add(localc);
    AIb = localc;
    localc = new ap.c(31, "VisitorLinkHangupFail");
    AHq.add(localc);
    AIc = localc;
    localc = new ap.c(10, "VisitorRewardSuc");
    AHq.add(localc);
    AId = localc;
    localc = new ap.c(11, "VisitorRewardFail");
    AHq.add(localc);
    AIe = localc;
    localc = new ap.c(12, "VisitorRewardConsumeFail");
    AHq.add(localc);
    AIf = localc;
    AIg = g.ar((a)ap.b.AIi);
    AppMethodBeat.o(282348);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$Companion;", "", "()V", "AnchorCancelCreate", "Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "getAnchorCancelCreate", "()Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant$LiveStage;", "AnchorCreateLive", "getAnchorCreateLive", "AnchorCreateLiveFailed", "getAnchorCreateLiveFailed", "AnchorDoPost", "getAnchorDoPost", "AnchorEnterRoom", "getAnchorEnterRoom", "AnchorEnterRoomFailed", "getAnchorEnterRoomFailed", "AnchorJoinLive", "getAnchorJoinLive", "AnchorJoinLiveFailed", "getAnchorJoinLiveFailed", "AnchorLinkAcceptFail", "getAnchorLinkAcceptFail", "AnchorLinkAcceptSuc", "getAnchorLinkAcceptSuc", "AnchorLinkHangupFail", "getAnchorLinkHangupFail", "AnchorLinkHangupSuc", "getAnchorLinkHangupSuc", "AnchorLinkSelected", "getAnchorLinkSelected", "AnchorShareFeed", "getAnchorShareFeed", "AnchorShareFeedFailed", "getAnchorShareFeedFailed", "AnchorSuccessLive", "getAnchorSuccessLive", "BeginPlay", "getBeginPlay", "ConnectSucc", "getConnectSucc", "EnterActivity", "getEnterActivity", "FirstFrameEvent", "getFirstFrameEvent", "ItemSelectedBegin", "getItemSelectedBegin", "ItemSelectedEnd", "getItemSelectedEnd", "JoinLiveBegin", "getJoinLiveBegin", "JoinLiveCgiBack", "getJoinLiveCgiBack", "JoinLiveEnd", "getJoinLiveEnd", "JoinLiveFinish", "getJoinLiveFinish", "NearbyRedDot", "getNearbyRedDot", "RecheckRealName", "getRecheckRealName", "RestartLive", "getRestartLive", "StartLive", "getStartLive", "TYPE_END", "", "getTYPE_END", "()I", "TYPE_START", "getTYPE_START", "ViewHolderBegin", "getViewHolderBegin", "ViewHolderEnd", "getViewHolderEnd", "VisitorLinkAccepted", "getVisitorLinkAccepted", "VisitorLinkApplyFail", "getVisitorLinkApplyFail", "VisitorLinkApplySuc", "getVisitorLinkApplySuc", "VisitorLinkHangupFail", "getVisitorLinkHangupFail", "VisitorLinkHangupSuc", "getVisitorLinkHangupSuc", "VisitorRewardConsumeFail", "getVisitorRewardConsumeFail", "VisitorRewardFail", "getVisitorRewardFail", "VisitorRewardSuc", "getVisitorRewardSuc", "VisitorRoleGuide", "getVisitorRoleGuide", "stageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stageNameIdMap", "Lkotlin/Lazy;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ap
 * JD-Core Version:    0.7.0.1
 */