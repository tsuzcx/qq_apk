package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LiveStatConstant;", "", "()V", "Companion", "LiveStage", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bb
{
  public static final bb.a GjM;
  private static final int GjN;
  private static final int GjO;
  private static final ArrayList<bb.c> GjP;
  private static final bb.c GjQ;
  private static final bb.c GjR;
  private static final bb.c GjS;
  private static final bb.c GjT;
  private static final bb.c GjU;
  private static final bb.c GjV;
  private static final bb.c GjW;
  private static final bb.c GjX;
  private static final bb.c GjY;
  private static final bb.c GjZ;
  private static final bb.c GkA;
  private static final bb.c GkB;
  private static final bb.c GkC;
  private static final bb.c GkD;
  private static final bb.c GkE;
  private static final j<HashMap<String, Integer>> GkF;
  private static final bb.c Gka;
  private static final bb.c Gkb;
  private static final bb.c Gkc;
  private static final bb.c Gkd;
  private static final bb.c Gke;
  private static final bb.c Gkf;
  private static final bb.c Gkg;
  private static final bb.c Gkh;
  private static final bb.c Gki;
  private static final bb.c Gkj;
  private static final bb.c Gkk;
  private static final bb.c Gkl;
  private static final bb.c Gkm;
  private static final bb.c Gkn;
  private static final bb.c Gko;
  private static final bb.c Gkp;
  private static final bb.c Gkq;
  private static final bb.c Gkr;
  private static final bb.c Gks;
  private static final bb.c Gkt;
  private static final bb.c Gku;
  private static final bb.c Gkv;
  private static final bb.c Gkw;
  private static final bb.c Gkx;
  private static final bb.c Gky;
  private static final bb.c Gkz;
  
  static
  {
    AppMethodBeat.i(333326);
    GjM = new bb.a((byte)0);
    GjN = 1;
    GjO = 2;
    GjP = new ArrayList();
    bb.c localc = new bb.c(10, "ViewHolderBegin");
    GjP.add(localc);
    GjQ = localc;
    localc = new bb.c(20, "ViewHolderEnd");
    GjP.add(localc);
    GjR = localc;
    localc = new bb.c(30, "ItemSelectedBegin");
    GjP.add(localc);
    GjS = localc;
    localc = new bb.c(40, "JoinLiveBegin");
    GjP.add(localc);
    GjT = localc;
    localc = new bb.c(50, "ItemSelectedEnd");
    GjP.add(localc);
    GjU = localc;
    localc = new bb.c(60, "JoinLiveCgiBack");
    GjP.add(localc);
    GjV = localc;
    localc = new bb.c(70, "JoinLiveEnd");
    GjP.add(localc);
    GjW = localc;
    localc = new bb.c(80, "StartLive");
    GjP.add(localc);
    GjX = localc;
    localc = new bb.c(90, "JoinLiveFinish");
    GjP.add(localc);
    GjY = localc;
    localc = new bb.c(100, "ConnectSucc");
    GjP.add(localc);
    GjZ = localc;
    localc = new bb.c(110, "FirstFrameEvent");
    GjP.add(localc);
    Gka = localc;
    localc = new bb.c(120, "BeginPlay");
    GjP.add(localc);
    Gkb = localc;
    localc = new bb.c(130, "EnterActivity");
    GjP.add(localc);
    Gkc = localc;
    localc = new bb.c(140, "VisitorRoleGuide");
    GjP.add(localc);
    Gkd = localc;
    localc = new bb.c(150, "NearbyRedDot");
    GjP.add(localc);
    Gke = localc;
    localc = new bb.c(160, "RestartLive");
    GjP.add(localc);
    Gkf = localc;
    localc = new bb.c(10, "AnchorDoPost");
    GjP.add(localc);
    Gkg = localc;
    localc = new bb.c(20, "AnchorCreateLive");
    GjP.add(localc);
    Gkh = localc;
    localc = new bb.c(21, "AnchorCreateLiveFailed");
    GjP.add(localc);
    Gki = localc;
    localc = new bb.c(22, "RecheckRealName");
    GjP.add(localc);
    Gkj = localc;
    localc = new bb.c(30, "AnchorJoinLive");
    GjP.add(localc);
    Gkk = localc;
    localc = new bb.c(31, "AnchorJoinLiveFailed");
    GjP.add(localc);
    Gkl = localc;
    localc = new bb.c(40, "AnchorEnterRoom");
    GjP.add(localc);
    Gkm = localc;
    localc = new bb.c(41, "AnchorEnterRoomFailed");
    GjP.add(localc);
    Gkn = localc;
    localc = new bb.c(50, "AnchorShareFeed");
    GjP.add(localc);
    Gko = localc;
    localc = new bb.c(51, "AnchorShareFeedFailed");
    GjP.add(localc);
    Gkp = localc;
    localc = new bb.c(60, "AnchorCancelCreate");
    GjP.add(localc);
    Gkq = localc;
    localc = new bb.c(70, "AnchorSuccessLive");
    GjP.add(localc);
    Gkr = localc;
    localc = new bb.c(10, "AnchorLinkSelected");
    GjP.add(localc);
    Gks = localc;
    localc = new bb.c(20, "AnchorLinkAcceptSuc");
    GjP.add(localc);
    Gkt = localc;
    localc = new bb.c(21, "AnchorLinkAcceptFail");
    GjP.add(localc);
    Gku = localc;
    localc = new bb.c(30, "AnchorLinkHangupSuc");
    GjP.add(localc);
    Gkv = localc;
    localc = new bb.c(31, "AnchorLinkHangupFail");
    GjP.add(localc);
    Gkw = localc;
    localc = new bb.c(10, "VisitorLinkApplySuc");
    GjP.add(localc);
    Gkx = localc;
    localc = new bb.c(11, "VisitorLinkApplyFail");
    GjP.add(localc);
    Gky = localc;
    localc = new bb.c(20, "VisitorLinkAccepted");
    GjP.add(localc);
    Gkz = localc;
    localc = new bb.c(30, "VisitorLinkHangupSuc");
    GjP.add(localc);
    GkA = localc;
    localc = new bb.c(31, "VisitorLinkHangupFail");
    GjP.add(localc);
    GkB = localc;
    localc = new bb.c(10, "VisitorRewardSuc");
    GjP.add(localc);
    GkC = localc;
    localc = new bb.c(11, "VisitorRewardFail");
    GjP.add(localc);
    GkD = localc;
    localc = new bb.c(12, "VisitorRewardConsumeFail");
    GjP.add(localc);
    GkE = localc;
    GkF = k.cm((a)bb.b.GkG);
    AppMethodBeat.o(333326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bb
 * JD-Core Version:    0.7.0.1
 */