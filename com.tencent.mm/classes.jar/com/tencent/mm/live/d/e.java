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
import com.tencent.mm.model.u;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "LIVE_ICON_LOCATE", "", "liveRoomId", "", "entranceShow", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "lastTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String gYi;
  public static final e gYj;
  
  static
  {
    AppMethodBeat.i(212761);
    gYj = new e();
    gYi = "";
    AppMethodBeat.o(212761);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(212752);
    Object localObject = g.gOr;
    if (g.anX())
    {
      AppMethodBeat.o(212752);
      return;
    }
    localObject = g.gOr;
    g.ny(-1);
    localObject = new db();
    g localg = g.gOr;
    ((db)localObject).jg(g.anY());
    ((db)localObject).ml(paramString1);
    ((db)localObject).jh(paramLong);
    ((db)localObject).ji(paramInt1);
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      ((db)localObject).jj(paramLong);
      ((db)localObject).jk(paramInt3);
      ((db)localObject).jl(paramInt4);
      ((db)localObject).jm(paramInt5);
      ((db)localObject).jn(paramInt6);
      ((db)localObject).jo(paramInt7);
      ((db)localObject).mm(paramString2);
      ((db)localObject).aLk();
      paramString1 = g.gOr;
      g.dP(true);
      paramString1 = g.gOr;
      g.nw(0);
      paramString1 = g.gOr;
      g.nx(0);
      paramString1 = g.gOr;
      g.nz(0);
      paramString1 = g.gOr;
      g.nA(0);
      paramString1 = g.gOr;
      g.nB(0);
      paramString1 = g.gOr;
      g.nC(0);
      paramString1 = g.gOr;
      g.nD(0);
      AppMethodBeat.o(212752);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(212755);
    p.h(paramString, "roomId");
    cs localcs = new cs();
    g localg = g.gOr;
    g.nF(0);
    localcs.lS(paramString);
    localcs.ip(paramLong);
    localcs.iq(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localcs.ir(paramLong);
      localcs.is(paramInt2);
      localcs.aLk();
      AppMethodBeat.o(212755);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(212751);
    p.h(paramString1, "roomId");
    cr localcr = new cr();
    g localg = g.gOr;
    g.nx(0);
    localg = g.gOr;
    g.nv(-1);
    localcr.SQ();
    localcr.lQ(paramString1);
    localcr.jdMethod_if(paramLong1);
    localcr.lR(paramString2);
    localcr.ih(paramInt1);
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localcr.ii(paramLong1);
      localcr.il(paramInt5);
      localcr.ij(paramInt3);
      localcr.ik(paramInt4);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localcr.im(paramLong1);
      localcr.io(paramLong2);
      paramString2 = b.gYf;
      paramString2 = u.aAm();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localcr.ig(b.a.au(paramString2, paramString1));
      paramString2 = b.gYf;
      localcr.in(b.a.xU(paramString1));
      localcr.aLk();
      AppMethodBeat.o(212751);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(212753);
    p.h(paramString1, "roomId");
    p.h(paramString2, "anchorName");
    p.h(paramString3, "audienceUserName");
    cz localcz = new cz();
    localcz.mg(paramString1);
    localcz.iV(paramLong);
    localcz.iZ(paramInt2);
    localcz.iY(paramInt1);
    Object localObject = b.gYf;
    localObject = u.aAm();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcz.iW(b.a.av((String)localObject, paramString2));
    paramString2 = b.gYf;
    paramString2 = u.aAm();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcz.iX(b.a.au(paramString2, paramString1));
    localcz.ja(System.currentTimeMillis());
    localcz.mh(paramString3);
    localcz.aLk();
    AppMethodBeat.o(212753);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(212757);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    cu localcu = new cu();
    localcu.lV(paramString1);
    localcu.iC(paramLong);
    localcu.lX(paramString3);
    localcu.SS();
    localcu.lW(paramString2);
    localcu.iE(paramInt);
    paramString2 = b.gYf;
    paramString2 = u.aAm();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcu.iD(b.a.au(paramString2, paramString1));
    localcu.aLk();
    AppMethodBeat.o(212757);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(212756);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    cy localcy = new cy();
    g localg = g.gOr;
    g.dQ(false);
    localcy.md(paramString1);
    localcy.iR(paramLong1);
    localcy.mf(paramString2);
    localcy.iS(paramLong2);
    localcy.iT(paramInt1);
    localcy.iU(paramInt2);
    localcy.me(paramString3);
    localcy.aLk();
    AppMethodBeat.o(212756);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212758);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    cv localcv = new cv();
    localcv.lY(paramString1);
    localcv.iF(paramLong);
    Object localObject = b.gYf;
    localObject = u.aAm();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcv.iH(b.a.av((String)localObject, paramString3));
    localcv.iG(paramInt1);
    localcv.ma(paramString3);
    localcv.lZ(paramString2);
    localcv.iJ(paramInt2);
    localcv.iK(paramInt3);
    paramString2 = b.gYf;
    paramString2 = u.aAm();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcv.iI(b.a.au(paramString2, paramString1));
    localcv.aLk();
    AppMethodBeat.o(212758);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(212759);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    da localda = new da();
    localda.mi(paramString1);
    localda.jb(paramLong1);
    localda.mj(paramString2);
    localda.mk(paramString3);
    localda.je(paramLong2);
    localda.jf(paramLong3);
    paramString2 = b.gYf;
    paramString2 = u.aAm();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localda.jc(b.a.av(paramString2, paramString3));
    paramString2 = b.gYf;
    paramString2 = u.aAm();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localda.jd(b.a.au(paramString2, paramString1));
    localda.aLk();
    AppMethodBeat.o(212759);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212749);
    p.h(paramString1, "roomId");
    Object localObject = g.gOr;
    if (g.anN())
    {
      AppMethodBeat.o(212749);
      return;
    }
    localObject = g.gOr;
    g.dL(false);
    localObject = g.gOr;
    g.dM(false);
    localObject = g.gOr;
    g.dN(true);
    localObject = g.gOr;
    g.dO(false);
    localObject = g.gOr;
    g.dK(false);
    localObject = new ct();
    ((ct)localObject).SR();
    ((ct)localObject).lT(paramString1);
    long l;
    label119:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((ct)localObject).it(l);
      if (!paramBoolean2) {
        break label292;
      }
      l = 1L;
      ((ct)localObject).iu(l);
      ((ct)localObject).lU(paramString2);
      if (!paramBoolean3) {
        break label298;
      }
      l = 1L;
      label142:
      ((ct)localObject).iv(l);
      paramString2 = a.alJ();
      p.g(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.alN().gJh)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((ct)localObject).iw(i);
      ((ct)localObject).ix(paramInt1);
      ((ct)localObject).iy(paramInt2);
      ((ct)localObject).iz(paramInt3);
      paramString2 = b.gYf;
      paramString2 = u.aAm();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((ct)localObject).iA(b.a.au(paramString2, paramString1));
      paramString2 = b.gYf;
      ((ct)localObject).iB(b.a.xU(paramString1));
      ((ct)localObject).aLk();
      AppMethodBeat.o(212749);
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
  
  public static final void apX()
  {
    AppMethodBeat.i(212748);
    cw localcw = new cw();
    Object localObject = b.gYf;
    localObject = u.aAm();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcw.iL(b.a.au((String)localObject, gYi));
    localcw.mb(gYi);
    localcw.ST();
    localcw.aLk();
    AppMethodBeat.o(212748);
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(212760);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    cx localcx = new cx();
    Object localObject = b.gYf;
    localObject = u.aAm();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcx.iN(b.a.av((String)localObject, paramString3));
    paramString3 = b.gYf;
    paramString3 = u.aAm();
    p.g(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcx.iO(b.a.au(paramString3, paramString1));
    localcx.iM(paramLong);
    localcx.mc(paramString2);
    localcx.iP(paramInt1);
    localcx.iQ(paramInt2);
    localcx.iC(paramInt3);
    localcx.aLk();
    AppMethodBeat.o(212760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */