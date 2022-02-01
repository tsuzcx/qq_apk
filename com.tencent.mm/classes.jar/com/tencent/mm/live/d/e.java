package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.b.a.cu;
import com.tencent.mm.g.b.a.cv;
import com.tencent.mm.g.b.a.cw;
import com.tencent.mm.g.b.a.cx;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.g.b.a.db;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.model.v;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "LIVE_ICON_LOCATE", "", "liveRoomId", "", "visitorEnterLiveStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "getVisitorEnterLiveStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "setVisitorEnterLiveStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;)V", "entranceShow", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "lastTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "onlineCnt", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String haU;
  private static db haV;
  public static final e haW;
  
  static
  {
    AppMethodBeat.i(216389);
    haW = new e();
    haU = "";
    haV = new db();
    AppMethodBeat.o(216389);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(216380);
    Object localObject = g.gQZ;
    if (g.aom())
    {
      AppMethodBeat.o(216380);
      return;
    }
    localObject = g.gQZ;
    g.nB(-1);
    localObject = haV;
    g localg = g.gQZ;
    ((db)localObject).jm(g.aon());
    haV.mD(paramString1);
    haV.jn(paramLong);
    haV.jo(paramInt1);
    paramString1 = haV;
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      paramString1.jp(paramLong);
      haV.jq(paramInt3);
      haV.jr(paramInt4);
      haV.js(paramInt5);
      haV.jt(paramInt6);
      haV.ju(paramInt7);
      haV.mE(paramString2);
      haV.aLH();
      paramString1 = g.gQZ;
      g.dQ(true);
      paramString1 = g.gQZ;
      g.nz(0);
      paramString1 = g.gQZ;
      g.nA(0);
      paramString1 = g.gQZ;
      g.nC(0);
      paramString1 = g.gQZ;
      g.nD(0);
      paramString1 = g.gQZ;
      g.nE(0);
      paramString1 = g.gQZ;
      g.nF(0);
      paramString1 = g.gQZ;
      g.nG(0);
      haV = new db();
      AppMethodBeat.o(216380);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(216383);
    p.h(paramString, "roomId");
    cs localcs = new cs();
    g localg = g.gQZ;
    g.nI(0);
    localcs.mj(paramString);
    localcs.iu(paramLong);
    localcs.iv(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localcs.iw(paramLong);
      localcs.ix(paramInt2);
      localcs.aLH();
      AppMethodBeat.o(216383);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(216379);
    p.h(paramString1, "roomId");
    cr localcr = new cr();
    g localg = g.gQZ;
    g.nA(0);
    localg = g.gQZ;
    g.ny(-1);
    localcr.SU();
    localcr.mh(paramString1);
    localcr.ik(paramLong1);
    localcr.mi(paramString2);
    localcr.im(paramInt1);
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localcr.in(paramLong1);
      localcr.iq(paramInt5);
      localcr.io(paramInt3);
      localcr.ip(paramInt4);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localcr.ir(paramLong1);
      localcr.it(paramLong2);
      paramString2 = b.haR;
      paramString2 = v.aAC();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localcr.il(b.a.av(paramString2, paramString1));
      paramString2 = b.haR;
      localcr.is(b.a.yE(paramString1));
      localcr.aLH();
      AppMethodBeat.o(216379);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(216381);
    p.h(paramString1, "roomId");
    p.h(paramString2, "anchorName");
    p.h(paramString3, "audienceUserName");
    cz localcz = new cz();
    localcz.mx(paramString1);
    localcz.ja(paramLong);
    localcz.je(paramInt2);
    localcz.jd(paramInt1);
    Object localObject = b.haR;
    localObject = v.aAC();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcz.jb(b.a.aw((String)localObject, paramString2));
    localObject = b.haR;
    localObject = v.aAC();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcz.jc(b.a.av((String)localObject, paramString1));
    localcz.jf(System.currentTimeMillis());
    localcz.my(paramString3);
    localcz.mz(paramString2);
    localcz.jg(paramInt3);
    localcz.aLH();
    AppMethodBeat.o(216381);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(216385);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    cu localcu = new cu();
    localcu.mm(paramString1);
    localcu.iH(paramLong);
    localcu.mo(paramString3);
    localcu.SW();
    localcu.mn(paramString2);
    localcu.iJ(paramInt);
    paramString2 = b.haR;
    paramString2 = v.aAC();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcu.iI(b.a.av(paramString2, paramString1));
    localcu.aLH();
    AppMethodBeat.o(216385);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(216384);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    cy localcy = new cy();
    g localg = g.gQZ;
    g.dR(false);
    localcy.mu(paramString1);
    localcy.iW(paramLong1);
    localcy.mw(paramString2);
    localcy.iX(paramLong2);
    localcy.iY(paramInt1);
    localcy.iZ(paramInt2);
    localcy.mv(paramString3);
    localcy.aLH();
    AppMethodBeat.o(216384);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216386);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    cv localcv = new cv();
    localcv.mp(paramString1);
    localcv.iK(paramLong);
    Object localObject = b.haR;
    localObject = v.aAC();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcv.iM(b.a.aw((String)localObject, paramString3));
    localcv.iL(paramInt1);
    localcv.mr(paramString3);
    localcv.mq(paramString2);
    localcv.iO(paramInt2);
    localcv.iP(paramInt3);
    paramString2 = b.haR;
    paramString2 = v.aAC();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcv.iN(b.a.av(paramString2, paramString1));
    localcv.aLH();
    AppMethodBeat.o(216386);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(216387);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    da localda = new da();
    localda.mA(paramString1);
    localda.jh(paramLong1);
    localda.mB(paramString2);
    localda.mC(paramString3);
    localda.jk(paramLong2);
    localda.jl(paramLong3);
    paramString2 = b.haR;
    paramString2 = v.aAC();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localda.ji(b.a.aw(paramString2, paramString3));
    paramString2 = b.haR;
    paramString2 = v.aAC();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localda.jj(b.a.av(paramString2, paramString1));
    localda.aLH();
    AppMethodBeat.o(216387);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216377);
    p.h(paramString1, "roomId");
    Object localObject = g.gQZ;
    if (g.aoc())
    {
      AppMethodBeat.o(216377);
      return;
    }
    localObject = g.gQZ;
    g.dM(false);
    localObject = g.gQZ;
    g.dN(false);
    localObject = g.gQZ;
    g.dO(true);
    localObject = g.gQZ;
    g.dP(false);
    localObject = g.gQZ;
    g.dL(false);
    localObject = new ct();
    ((ct)localObject).SV();
    ((ct)localObject).mk(paramString1);
    long l;
    label119:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((ct)localObject).iy(l);
      if (!paramBoolean2) {
        break label292;
      }
      l = 1L;
      ((ct)localObject).iz(l);
      ((ct)localObject).ml(paramString2);
      if (!paramBoolean3) {
        break label298;
      }
      l = 1L;
      label142:
      ((ct)localObject).iA(l);
      paramString2 = a.alY();
      p.g(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.amc().gLQ)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((ct)localObject).iB(i);
      ((ct)localObject).iC(paramInt1);
      ((ct)localObject).iD(paramInt2);
      ((ct)localObject).iE(paramInt3);
      paramString2 = b.haR;
      paramString2 = v.aAC();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((ct)localObject).iF(b.a.av(paramString2, paramString1));
      paramString2 = b.haR;
      ((ct)localObject).iG(b.a.yE(paramString1));
      ((ct)localObject).aLH();
      AppMethodBeat.o(216377);
      return;
      l = 0L;
      break;
      label292:
      l = 0L;
      break label119;
      label298:
      l = 0L;
      break label142;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public static final void aql()
  {
    AppMethodBeat.i(216376);
    cw localcw = new cw();
    Object localObject = b.haR;
    localObject = v.aAC();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcw.iQ(b.a.av((String)localObject, haU));
    localcw.ms(haU);
    localcw.SX();
    localcw.aLH();
    AppMethodBeat.o(216376);
  }
  
  public static db aqm()
  {
    return haV;
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216388);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    cx localcx = new cx();
    Object localObject = b.haR;
    localObject = v.aAC();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcx.iS(b.a.aw((String)localObject, paramString3));
    paramString3 = b.haR;
    paramString3 = v.aAC();
    p.g(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcx.iT(b.a.av(paramString3, paramString1));
    localcx.iR(paramLong);
    localcx.mt(paramString2);
    localcx.iU(paramInt1);
    localcx.iV(paramInt2);
    localcx.iE(paramInt3);
    localcx.aLH();
    AppMethodBeat.o(216388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */