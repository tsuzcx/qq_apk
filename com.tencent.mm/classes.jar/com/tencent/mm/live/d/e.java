package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fe;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.b.a.fg;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.b.a.fi;
import com.tencent.mm.g.b.a.fj;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.g.b.a.fl;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.civ;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "liveRoomId", "", "visitorEnterLiveStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "getVisitorEnterLiveStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "setVisitorEnterLiveStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;)V", "entranceShow", "", "page", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "startTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "onlineCnt", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String hTN;
  private static fp hTO;
  public static final e hTP;
  
  static
  {
    AppMethodBeat.i(208350);
    hTP = new e();
    hTN = "";
    hTO = new fp();
    AppMethodBeat.o(208350);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(208341);
    Object localObject = x.hJf;
    if (x.aGU())
    {
      AppMethodBeat.o(208341);
      return;
    }
    localObject = x.hJf;
    x.qX(-1);
    localObject = hTO;
    x localx = x.hJf;
    ((fp)localObject).oT(x.aGV());
    hTO.sB(paramString1);
    hTO.oU(paramLong);
    hTO.oV(paramInt1);
    paramString1 = hTO;
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      paramString1.oW(paramLong);
      hTO.oX(paramInt3);
      hTO.oY(paramInt4);
      hTO.oZ(paramInt5);
      hTO.pa(paramInt6);
      hTO.pb(paramInt7);
      hTO.sC(paramString2);
      hTO.bfK();
      paramString1 = x.hJf;
      x.eM(true);
      paramString1 = x.hJf;
      x.qV(0);
      paramString1 = x.hJf;
      x.qW(0);
      paramString1 = x.hJf;
      x.qY(0);
      paramString1 = x.hJf;
      x.qZ(0);
      paramString1 = x.hJf;
      x.ra(0);
      paramString1 = x.hJf;
      x.rb(0);
      paramString1 = x.hJf;
      x.rc(0);
      hTO = new fp();
      AppMethodBeat.o(208341);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(208344);
    p.h(paramString, "roomId");
    ff localff = new ff();
    x localx = x.hJf;
    x.re(0);
    localff.sd(paramString);
    localff.nq(paramLong);
    localff.nr(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localff.ns(paramLong);
      localff.nt(paramInt2);
      localff.bfK();
      AppMethodBeat.o(208344);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(208340);
    p.h(paramString1, "roomId");
    fe localfe = new fe();
    x localx = x.hJf;
    x.qW(0);
    localx = x.hJf;
    x.qU(-1);
    localfe.afX();
    localfe.sb(paramString1);
    localfe.ng(paramLong1);
    localfe.sc(paramString2);
    localfe.ni(paramInt1);
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localfe.nj(paramLong1);
      localfe.nm(paramInt5);
      localfe.nk(paramInt3);
      localfe.nl(paramInt4);
      if (!paramBoolean) {
        break label200;
      }
    }
    label200:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localfe.nn(paramLong1);
      localfe.np(paramLong2);
      paramString2 = b.hTK;
      paramString2 = z.aTY();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localfe.nh(b.a.ax(paramString2, paramString1));
      paramString2 = b.hTK;
      localfe.no(b.a.Hd(paramString1));
      localfe.bfK();
      AppMethodBeat.o(208340);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(208342);
    p.h(paramString1, "roomId");
    p.h(paramString2, "anchorName");
    p.h(paramString3, "audienceUserName");
    fm localfm = new fm();
    localfm.sr(paramString1);
    localfm.ob(paramLong);
    localfm.of(paramInt2);
    localfm.oe(paramInt1);
    Object localObject = b.hTK;
    localObject = z.aTY();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfm.oc(b.a.ay((String)localObject, paramString2));
    localObject = b.hTK;
    localObject = z.aTY();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfm.od(b.a.ax((String)localObject, paramString1));
    localfm.og(System.currentTimeMillis());
    localfm.ss(paramString3);
    localfm.st(paramString2);
    localfm.oh(paramInt3);
    localfm.bfK();
    AppMethodBeat.o(208342);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(208346);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    fh localfh = new fh();
    localfh.sg(paramString1);
    localfh.nD(paramLong);
    localfh.si(paramString3);
    localfh.afZ();
    localfh.sh(paramString2);
    localfh.nF(paramInt);
    paramString2 = b.hTK;
    paramString2 = z.aTY();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfh.nE(b.a.ax(paramString2, paramString1));
    localfh.bfK();
    AppMethodBeat.o(208346);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(208345);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    long l = System.currentTimeMillis();
    fl localfl = new fl();
    x localx = x.hJf;
    x.eN(false);
    localfl.so(paramString1);
    localfl.nT(paramLong1);
    localfl.sq(paramString2);
    localfl.nU((l - paramLong2) / 1000L);
    localfl.nV(paramInt1);
    localfl.nW(paramInt2);
    localfl.sp(paramString3);
    localfl.nY(l);
    localfl.nX(paramLong2);
    paramString1 = x.hJf;
    localfl.nZ(x.aHb());
    paramString1 = x.hJf;
    localfl.oa(x.aGr().LIa);
    localfl.bfK();
    AppMethodBeat.o(208345);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208347);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    fi localfi = new fi();
    localfi.sj(paramString1);
    localfi.nG(paramLong);
    Object localObject = b.hTK;
    localObject = z.aTY();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfi.nI(b.a.ay((String)localObject, paramString3));
    localfi.nH(paramInt1);
    localfi.sl(paramString3);
    localfi.sk(paramString2);
    localfi.nK(paramInt2);
    localfi.nL(paramInt3);
    paramString2 = b.hTK;
    paramString2 = z.aTY();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfi.nJ(b.a.ax(paramString2, paramString1));
    localfi.bfK();
    AppMethodBeat.o(208347);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(208348);
    p.h(paramString1, "roomId");
    p.h(paramString3, "liveUserName");
    fo localfo = new fo();
    localfo.sy(paramString1);
    localfo.oO(paramLong1);
    localfo.sz(paramString2);
    localfo.sA(paramString3);
    localfo.oR(paramLong2);
    localfo.oS(paramLong3);
    paramString2 = b.hTK;
    paramString2 = z.aTY();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfo.oP(b.a.ay(paramString2, paramString3));
    paramString2 = b.hTK;
    paramString2 = z.aTY();
    p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfo.oQ(b.a.ax(paramString2, paramString1));
    localfo.bfK();
    AppMethodBeat.o(208348);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208338);
    p.h(paramString1, "roomId");
    Object localObject = x.hJf;
    if (x.aGK())
    {
      AppMethodBeat.o(208338);
      return;
    }
    localObject = x.hJf;
    x.eI(false);
    localObject = x.hJf;
    x.eJ(false);
    localObject = x.hJf;
    x.eK(true);
    localObject = x.hJf;
    x.eL(false);
    localObject = x.hJf;
    x.eH(false);
    localObject = new fg();
    ((fg)localObject).afY();
    ((fg)localObject).se(paramString1);
    long l;
    label119:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((fg)localObject).nu(l);
      if (!paramBoolean2) {
        break label292;
      }
      l = 1L;
      ((fg)localObject).nv(l);
      ((fg)localObject).sf(paramString2);
      if (!paramBoolean3) {
        break label298;
      }
      l = 1L;
      label142:
      ((fg)localObject).nw(l);
      paramString2 = a.aDC();
      p.g(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.aDG().hBp)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((fg)localObject).nx(i);
      ((fg)localObject).ny(paramInt1);
      ((fg)localObject).nz(paramInt2);
      ((fg)localObject).nA(paramInt3);
      paramString2 = b.hTK;
      paramString2 = z.aTY();
      p.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((fg)localObject).nB(b.a.ax(paramString2, paramString1));
      paramString2 = b.hTK;
      ((fg)localObject).nC(b.a.Hd(paramString1));
      ((fg)localObject).bfK();
      AppMethodBeat.o(208338);
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
  
  public static fp aIK()
  {
    return hTO;
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(208349);
    p.h(paramString1, "roomId");
    p.h(paramString2, "micId");
    p.h(paramString3, "liveUserName");
    fk localfk = new fk();
    Object localObject = b.hTK;
    localObject = z.aTY();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfk.nP(b.a.ay((String)localObject, paramString3));
    paramString3 = b.hTK;
    paramString3 = z.aTY();
    p.g(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfk.nQ(b.a.ax(paramString3, paramString1));
    localfk.nO(paramLong);
    localfk.sn(paramString2);
    localfk.nR(paramInt1);
    localfk.nS(paramInt2);
    localfk.ll(paramInt3);
    localfk.bfK();
    AppMethodBeat.o(208349);
  }
  
  public static final void rj(int paramInt)
  {
    AppMethodBeat.i(208337);
    fj localfj = new fj();
    Object localObject = b.hTK;
    localObject = z.aTY();
    p.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localfj.nM(b.a.ax((String)localObject, hTN));
    localfj.sm(hTN);
    localfj.aga();
    localfj.nN(paramInt);
    localfj.bfK();
    AppMethodBeat.o(208337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */