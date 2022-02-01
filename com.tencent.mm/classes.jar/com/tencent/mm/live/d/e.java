package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.gv;
import com.tencent.mm.f.b.a.gw;
import com.tencent.mm.f.b.a.gx;
import com.tencent.mm.f.b.a.gy;
import com.tencent.mm.f.b.a.gz;
import com.tencent.mm.f.b.a.ha;
import com.tencent.mm.f.b.a.hb;
import com.tencent.mm.f.b.a.hc;
import com.tencent.mm.f.b.a.he;
import com.tencent.mm.f.b.a.hg;
import com.tencent.mm.f.b.a.hh;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.crq;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "liveRoomId", "", "visitorEnterLiveStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "getVisitorEnterLiveStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "setVisitorEnterLiveStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;)V", "entranceShow", "", "page", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "startTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "onlineCnt", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String kIk;
  private static hh kIl;
  public static final e kIm;
  
  static
  {
    AppMethodBeat.i(201264);
    kIm = new e();
    kIk = "";
    kIl = new hh();
    AppMethodBeat.o(201264);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(201238);
    Object localObject = u.kwz;
    if (u.aOU())
    {
      AppMethodBeat.o(201238);
      return;
    }
    localObject = u.kwz;
    u.tM(-1);
    localObject = kIl;
    u localu = u.kwz;
    ((hh)localObject).rg(u.aOV());
    kIl.wo(paramString1);
    kIl.rh(paramLong);
    kIl.ri(paramInt1);
    paramString1 = kIl;
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      paramString1.rj(paramLong);
      kIl.rk(paramInt3);
      kIl.rl(paramInt4);
      kIl.rm(paramInt5);
      kIl.rn(paramInt6);
      kIl.ro(paramInt7);
      kIl.wp(paramString2);
      kIl.bpa();
      paramString1 = u.kwz;
      u.fs(true);
      paramString1 = u.kwz;
      u.tK(0);
      paramString1 = u.kwz;
      u.tL(0);
      paramString1 = u.kwz;
      u.tN(0);
      paramString1 = u.kwz;
      u.tO(0);
      paramString1 = u.kwz;
      u.tP(0);
      paramString1 = u.kwz;
      u.tQ(0);
      paramString1 = u.kwz;
      u.tR(0);
      kIl = new hh();
      AppMethodBeat.o(201238);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(201245);
    p.k(paramString, "roomId");
    gw localgw = new gw();
    u localu = u.kwz;
    u.tT(0);
    localgw.vO(paramString);
    localgw.pB(paramLong);
    localgw.pC(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localgw.pD(paramLong);
      localgw.pE(paramInt2);
      localgw.bpa();
      AppMethodBeat.o(201245);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(201236);
    p.k(paramString1, "roomId");
    gv localgv = new gv();
    u localu = u.kwz;
    u.tL(0);
    localu = u.kwz;
    u.tJ(-1);
    localgv.ala();
    localgv.vM(paramString1);
    localgv.pr(paramLong1);
    localgv.vN(paramString2);
    localgv.pt(paramInt1);
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localgv.pu(paramLong1);
      localgv.px(paramInt5);
      localgv.pv(paramInt3);
      localgv.pw(paramInt4);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localgv.py(paramLong1);
      localgv.pA(paramLong2);
      paramString2 = b.kIh;
      paramString2 = z.bcZ();
      p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localgv.ps(b.a.aA(paramString2, paramString1));
      paramString2 = b.kIh;
      localgv.pz(b.a.Oo(paramString1));
      localgv.bpa();
      AppMethodBeat.o(201236);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(201241);
    p.k(paramString1, "roomId");
    p.k(paramString2, "anchorName");
    p.k(paramString3, "audienceUserName");
    he localhe = new he();
    localhe.we(paramString1);
    localhe.qo(paramLong);
    localhe.qs(paramInt2);
    localhe.qr(paramInt1);
    Object localObject = b.kIh;
    localObject = z.bcZ();
    p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhe.qp(b.a.aB((String)localObject, paramString2));
    localObject = b.kIh;
    localObject = z.bcZ();
    p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhe.qq(b.a.aA((String)localObject, paramString1));
    localhe.qt(System.currentTimeMillis());
    localhe.wf(paramString3);
    localhe.wg(paramString2);
    localhe.qu(paramInt3);
    localhe.bpa();
    AppMethodBeat.o(201241);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(201250);
    p.k(paramString1, "roomId");
    p.k(paramString3, "liveUserName");
    gy localgy = new gy();
    localgy.vR(paramString1);
    localgy.pO(paramLong);
    localgy.vT(paramString3);
    localgy.alc();
    localgy.vS(paramString2);
    localgy.pQ(paramInt);
    paramString2 = b.kIh;
    paramString2 = z.bcZ();
    p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localgy.pP(b.a.aA(paramString2, paramString1));
    localgy.bpa();
    AppMethodBeat.o(201250);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(201247);
    p.k(paramString1, "roomId");
    p.k(paramString2, "micId");
    p.k(paramString3, "liveUserName");
    long l = System.currentTimeMillis();
    hc localhc = new hc();
    u localu = u.kwz;
    u.ft(false);
    localhc.vZ(paramString1);
    localhc.qe(paramLong1);
    localhc.wb(paramString2);
    localhc.qf((l - paramLong2) / 1000L);
    localhc.qg(paramInt1);
    localhc.qh(paramInt2);
    localhc.wa(paramString3);
    localhc.qj(l);
    localhc.qi(paramLong2);
    paramString1 = u.kwz;
    localhc.qk(u.aPb());
    paramString1 = u.kwz;
    localhc.ql(u.aOr().SOs);
    localhc.bpa();
    AppMethodBeat.o(201247);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201254);
    p.k(paramString1, "roomId");
    p.k(paramString3, "liveUserName");
    gz localgz = new gz();
    localgz.vU(paramString1);
    localgz.pR(paramLong);
    Object localObject = b.kIh;
    localObject = z.bcZ();
    p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localgz.pT(b.a.aB((String)localObject, paramString3));
    localgz.pS(paramInt1);
    localgz.vW(paramString3);
    localgz.vV(paramString2);
    localgz.pV(paramInt2);
    localgz.pW(paramInt3);
    paramString2 = b.kIh;
    paramString2 = z.bcZ();
    p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localgz.pU(b.a.aA(paramString2, paramString1));
    localgz.bpa();
    AppMethodBeat.o(201254);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(201258);
    p.k(paramString1, "roomId");
    p.k(paramString3, "liveUserName");
    hg localhg = new hg();
    localhg.wl(paramString1);
    localhg.rb(paramLong1);
    localhg.wm(paramString2);
    localhg.wn(paramString3);
    localhg.re(paramLong2);
    localhg.rf(paramLong3);
    paramString2 = b.kIh;
    paramString2 = z.bcZ();
    p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhg.rc(b.a.aB(paramString2, paramString3));
    paramString2 = b.kIh;
    paramString2 = z.bcZ();
    p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhg.rd(b.a.aA(paramString2, paramString1));
    localhg.bpa();
    AppMethodBeat.o(201258);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201233);
    p.k(paramString1, "roomId");
    Object localObject = u.kwz;
    if (u.aOK())
    {
      AppMethodBeat.o(201233);
      return;
    }
    localObject = u.kwz;
    u.fo(false);
    localObject = u.kwz;
    u.fp(false);
    localObject = u.kwz;
    u.fq(true);
    localObject = u.kwz;
    u.fr(false);
    localObject = u.kwz;
    u.fn(false);
    localObject = new gx();
    ((gx)localObject).alb();
    ((gx)localObject).vP(paramString1);
    long l;
    label119:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((gx)localObject).pF(l);
      if (!paramBoolean2) {
        break label292;
      }
      l = 1L;
      ((gx)localObject).pG(l);
      ((gx)localObject).vQ(paramString2);
      if (!paramBoolean3) {
        break label298;
      }
      l = 1L;
      label142:
      ((gx)localObject).pH(l);
      paramString2 = a.aLI();
      p.j(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.aLM().kpc)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((gx)localObject).pI(i);
      ((gx)localObject).pJ(paramInt1);
      ((gx)localObject).pK(paramInt2);
      ((gx)localObject).pL(paramInt3);
      paramString2 = b.kIh;
      paramString2 = z.bcZ();
      p.j(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((gx)localObject).pM(b.a.aA(paramString2, paramString1));
      paramString2 = b.kIh;
      ((gx)localObject).pN(b.a.Oo(paramString1));
      ((gx)localObject).bpa();
      AppMethodBeat.o(201233);
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
  
  public static hh aQI()
  {
    return kIl;
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(201261);
    p.k(paramString1, "roomId");
    p.k(paramString2, "micId");
    p.k(paramString3, "liveUserName");
    hb localhb = new hb();
    Object localObject = b.kIh;
    localObject = z.bcZ();
    p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhb.qa(b.a.aB((String)localObject, paramString3));
    paramString3 = b.kIh;
    paramString3 = z.bcZ();
    p.j(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localhb.qb(b.a.aA(paramString3, paramString1));
    localhb.pZ(paramLong);
    localhb.vY(paramString2);
    localhb.qc(paramInt1);
    localhb.qd(paramInt2);
    localhb.nd(paramInt3);
    localhb.bpa();
    AppMethodBeat.o(201261);
  }
  
  public static final void tX(int paramInt)
  {
    AppMethodBeat.i(201232);
    ha localha = new ha();
    Object localObject = b.kIh;
    localObject = z.bcZ();
    p.j(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localha.pX(b.a.aA((String)localObject, kIk));
    localha.vX(kIk);
    localha.ald();
    localha.pY(paramInt);
    localha.bpa();
    AppMethodBeat.o(201232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */