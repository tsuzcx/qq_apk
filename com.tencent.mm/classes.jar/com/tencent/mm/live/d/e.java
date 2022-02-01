package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bz;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.g.b.a.cb;
import com.tencent.mm.g.b.a.cc;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.g.b.a.ce;
import com.tencent.mm.g.b.a.cf;
import com.tencent.mm.g.b.a.cg;
import com.tencent.mm.g.b.a.ch;
import com.tencent.mm.g.b.a.ci;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.model.u;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "LIVE_ICON_LOCATE", "", "liveRoomId", "", "entranceShow", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "lastTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String gEy;
  public static final e gEz;
  
  static
  {
    AppMethodBeat.i(190471);
    gEz = new e();
    gEy = "";
    AppMethodBeat.o(190471);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(190462);
    Object localObject = g.guG;
    if (g.alk())
    {
      AppMethodBeat.o(190462);
      return;
    }
    localObject = g.guG;
    g.mZ(-1);
    localObject = new cj();
    g localg = g.guG;
    ((cj)localObject).hy(g.all());
    ((cj)localObject).kp(paramString1);
    ((cj)localObject).hz(paramLong);
    ((cj)localObject).hA(paramInt1);
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      ((cj)localObject).hB(paramLong);
      ((cj)localObject).hC(paramInt3);
      ((cj)localObject).hD(paramInt4);
      ((cj)localObject).hE(paramInt5);
      ((cj)localObject).hF(paramInt6);
      ((cj)localObject).hG(paramInt7);
      ((cj)localObject).kq(paramString2);
      ((cj)localObject).aHZ();
      paramString1 = g.guG;
      g.dN(true);
      paramString1 = g.guG;
      g.mX(0);
      paramString1 = g.guG;
      g.mY(0);
      paramString1 = g.guG;
      g.na(0);
      paramString1 = g.guG;
      g.nb(0);
      paramString1 = g.guG;
      g.nc(0);
      paramString1 = g.guG;
      g.nd(0);
      paramString1 = g.guG;
      g.ne(0);
      AppMethodBeat.o(190462);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(190465);
    k.h(paramString, "roomId");
    ca localca = new ca();
    g localg = g.guG;
    g.ng(0);
    localca.jW(paramString);
    localca.gH(paramLong);
    localca.gI(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localca.gJ(paramLong);
      localca.gK(paramInt2);
      localca.aHZ();
      AppMethodBeat.o(190465);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(190461);
    k.h(paramString1, "roomId");
    bz localbz = new bz();
    g localg = g.guG;
    g.mY(0);
    localg = g.guG;
    g.mW(-1);
    localbz.QJ();
    localbz.jU(paramString1);
    localbz.gx(paramLong1);
    localbz.jV(paramString2);
    localbz.gz(paramInt1);
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localbz.gA(paramLong1);
      localbz.gD(paramInt5);
      localbz.gB(paramInt3);
      localbz.gC(paramInt4);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localbz.gE(paramLong1);
      localbz.gG(paramLong2);
      paramString2 = b.gEv;
      paramString2 = u.axw();
      k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localbz.gy(b.a.at(paramString2, paramString1));
      paramString2 = b.gEv;
      localbz.gF(b.a.ve(paramString1));
      localbz.aHZ();
      AppMethodBeat.o(190461);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(190463);
    k.h(paramString1, "roomId");
    k.h(paramString2, "anchorName");
    k.h(paramString3, "audienceUserName");
    ch localch = new ch();
    localch.kk(paramString1);
    localch.hn(paramLong);
    localch.hr(paramInt2);
    localch.hq(paramInt1);
    Object localObject = b.gEv;
    localObject = u.axw();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localch.ho(b.a.au((String)localObject, paramString2));
    paramString2 = b.gEv;
    paramString2 = u.axw();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localch.hp(b.a.at(paramString2, paramString1));
    localch.hs(System.currentTimeMillis());
    localch.kl(paramString3);
    localch.aHZ();
    AppMethodBeat.o(190463);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(190467);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    cc localcc = new cc();
    localcc.jZ(paramString1);
    localcc.gU(paramLong);
    localcc.kb(paramString3);
    localcc.QL();
    localcc.ka(paramString2);
    localcc.gW(paramInt);
    paramString2 = b.gEv;
    paramString2 = u.axw();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcc.gV(b.a.at(paramString2, paramString1));
    localcc.aHZ();
    AppMethodBeat.o(190467);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(190466);
    k.h(paramString1, "roomId");
    k.h(paramString2, "micId");
    k.h(paramString3, "liveUserName");
    cg localcg = new cg();
    g localg = g.guG;
    g.dO(false);
    localcg.kh(paramString1);
    localcg.hj(paramLong1);
    localcg.kj(paramString2);
    localcg.hk(paramLong2);
    localcg.hl(paramInt1);
    localcg.hm(paramInt2);
    localcg.ki(paramString3);
    localcg.aHZ();
    AppMethodBeat.o(190466);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190468);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    cd localcd = new cd();
    localcd.kc(paramString1);
    localcd.gX(paramLong);
    Object localObject = b.gEv;
    localObject = u.axw();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcd.gZ(b.a.au((String)localObject, paramString3));
    localcd.gY(paramInt1);
    localcd.ke(paramString3);
    localcd.kd(paramString2);
    localcd.hb(paramInt2);
    localcd.hc(paramInt3);
    paramString2 = b.gEv;
    paramString2 = u.axw();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcd.ha(b.a.at(paramString2, paramString1));
    localcd.aHZ();
    AppMethodBeat.o(190468);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(190469);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    ci localci = new ci();
    localci.km(paramString1);
    localci.ht(paramLong1);
    localci.kn(paramString2);
    localci.ko(paramString3);
    localci.hw(paramLong2);
    localci.hx(paramLong3);
    paramString2 = b.gEv;
    paramString2 = u.axw();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localci.hu(b.a.au(paramString2, paramString3));
    paramString2 = b.gEv;
    paramString2 = u.axw();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localci.hv(b.a.at(paramString2, paramString1));
    localci.aHZ();
    AppMethodBeat.o(190469);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190459);
    k.h(paramString1, "roomId");
    Object localObject = g.guG;
    if (g.ala())
    {
      AppMethodBeat.o(190459);
      return;
    }
    localObject = g.guG;
    g.dJ(false);
    localObject = g.guG;
    g.dK(false);
    localObject = g.guG;
    g.dL(true);
    localObject = g.guG;
    g.dM(false);
    localObject = g.guG;
    g.dI(false);
    localObject = new cb();
    ((cb)localObject).QK();
    ((cb)localObject).jX(paramString1);
    long l;
    label119:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((cb)localObject).gL(l);
      if (!paramBoolean2) {
        break label292;
      }
      l = 1L;
      ((cb)localObject).gM(l);
      ((cb)localObject).jY(paramString2);
      if (!paramBoolean3) {
        break label298;
      }
      l = 1L;
      label142:
      ((cb)localObject).gN(l);
      paramString2 = a.aiX();
      k.g(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.ajb().gpy)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((cb)localObject).gO(i);
      ((cb)localObject).gP(paramInt1);
      ((cb)localObject).gQ(paramInt2);
      ((cb)localObject).gR(paramInt3);
      paramString2 = b.gEv;
      paramString2 = u.axw();
      k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((cb)localObject).gS(b.a.at(paramString2, paramString1));
      paramString2 = b.gEv;
      ((cb)localObject).gT(b.a.ve(paramString1));
      ((cb)localObject).aHZ();
      AppMethodBeat.o(190459);
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
  
  public static final void ank()
  {
    AppMethodBeat.i(190458);
    ce localce = new ce();
    Object localObject = b.gEv;
    localObject = u.axw();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localce.hd(b.a.at((String)localObject, gEy));
    localce.kf(gEy);
    localce.QM();
    localce.aHZ();
    AppMethodBeat.o(190458);
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190470);
    k.h(paramString1, "roomId");
    k.h(paramString2, "micId");
    k.h(paramString3, "liveUserName");
    cf localcf = new cf();
    Object localObject = b.gEv;
    localObject = u.axw();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcf.hf(b.a.au((String)localObject, paramString3));
    paramString3 = b.gEv;
    paramString3 = u.axw();
    k.g(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localcf.hg(b.a.at(paramString3, paramString1));
    localcf.he(paramLong);
    localcf.kg(paramString2);
    localcf.hh(paramInt1);
    localcf.hi(paramInt2);
    localcf.il(paramInt3);
    AppMethodBeat.o(190470);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */