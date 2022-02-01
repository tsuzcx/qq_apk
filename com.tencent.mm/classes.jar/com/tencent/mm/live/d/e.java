package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ib;
import com.tencent.mm.g.b.a.ic;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.ii;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ik;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.core.core.trtc.a.a;
import com.tencent.mm.model.u;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "LIVE_ICON_LOCATE", "", "liveRoomId", "", "entranceShow", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "lastTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"})
public final class e
{
  public static String KxY;
  public static final e KxZ;
  
  static
  {
    AppMethodBeat.i(203230);
    KxZ = new e();
    KxY = "";
    AppMethodBeat.o(203230);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(203221);
    k.h(paramString1, "roomId");
    k.h(paramString2, "liveUserName");
    Object localObject = f.rGw;
    if (f.fOu())
    {
      AppMethodBeat.o(203221);
      return;
    }
    localObject = f.rGw;
    f.li(true);
    localObject = f.rGw;
    f.agz(0);
    localObject = f.rGw;
    f.agA(0);
    localObject = f.rGw;
    f.agB(0);
    localObject = f.rGw;
    f.agC(0);
    localObject = f.rGw;
    f.agD(0);
    localObject = f.rGw;
    f.agE(0);
    localObject = f.rGw;
    f.agF(0);
    localObject = f.rGw;
    f.agG(0);
    localObject = new il();
    f localf = f.rGw;
    ((il)localObject).AH(f.fOv());
    ((il)localObject).aTo(paramString1);
    ((il)localObject).AI(paramLong);
    ((il)localObject).AJ(paramInt1);
    ((il)localObject).AK(paramInt2);
    ((il)localObject).AL(paramInt3);
    ((il)localObject).AM(paramInt4);
    ((il)localObject).AN(paramInt5);
    ((il)localObject).AO(paramInt6);
    ((il)localObject).AP(paramInt7);
    ((il)localObject).aTp(paramString2);
    ((il)localObject).aBj();
    AppMethodBeat.o(203221);
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(203224);
    k.h(paramString, "roomId");
    ic localic = new ic();
    f localf = f.rGw;
    f.agH(0);
    localic.aSV(paramString);
    localic.zQ(paramLong);
    localic.zR(paramInt1);
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localic.zS(paramLong);
      localic.zT(paramInt2);
      localic.aBj();
      AppMethodBeat.o(203224);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(203220);
    k.h(paramString1, "roomId");
    ib localib = new ib();
    f localf = f.rGw;
    f.agA(0);
    localib.bsY();
    localib.aST(paramString1);
    localib.zG(paramLong1);
    localib.aSU(paramString2);
    localib.zI(paramInt1);
    localib.zJ(paramInt2);
    localib.zM(paramInt5);
    localib.zK(paramInt3);
    localib.zL(paramInt4);
    if (paramBoolean) {}
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localib.zN(paramLong1);
      localib.zP(paramLong2);
      paramString2 = b.KxV;
      paramString2 = u.aqG();
      k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      localib.zH(b.a.cc(paramString2, paramString1));
      paramString2 = b.KxV;
      localib.zO(b.a.aUw(paramString1));
      localib.aBj();
      AppMethodBeat.o(203220);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(203222);
    k.h(paramString1, "roomId");
    k.h(paramString2, "anchorName");
    k.h(paramString3, "audienceUserName");
    ij localij = new ij();
    localij.aTj(paramString1);
    localij.Aw(paramLong);
    localij.AA(paramInt2);
    localij.Az(paramInt1);
    Object localObject = b.KxV;
    localObject = u.aqG();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localij.Ax(b.a.fR((String)localObject, paramString2));
    paramString2 = b.KxV;
    paramString2 = u.aqG();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localij.Ay(b.a.cc(paramString2, paramString1));
    localij.AB(System.currentTimeMillis());
    localij.aTk(paramString3);
    localij.aBj();
    AppMethodBeat.o(203222);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(203226);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    ie localie = new ie();
    localie.aSY(paramString1);
    localie.Ad(paramLong);
    localie.aTa(paramString3);
    localie.bta();
    localie.aSZ(paramString2);
    localie.Af(paramInt);
    paramString2 = b.KxV;
    paramString2 = u.aqG();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localie.Ae(b.a.cc(paramString2, paramString1));
    localie.aBj();
    AppMethodBeat.o(203226);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(203225);
    k.h(paramString1, "roomId");
    k.h(paramString2, "micId");
    k.h(paramString3, "liveUserName");
    ii localii = new ii();
    f localf = f.rGw;
    f.lj(false);
    localii.aTg(paramString1);
    localii.As(paramLong1);
    localii.aTi(paramString2);
    localii.At(paramLong2);
    localii.Au(paramInt1);
    localii.Av(paramInt2);
    localii.aTh(paramString3);
    localii.aBj();
    AppMethodBeat.o(203225);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203227);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    if localif = new if();
    localif.aTb(paramString1);
    localif.Ag(paramLong);
    Object localObject = b.KxV;
    localObject = u.aqG();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localif.Ai(b.a.fR((String)localObject, paramString3));
    localif.Ah(paramInt1);
    localif.aTd(paramString3);
    localif.aTc(paramString2);
    localif.Ak(paramInt2);
    localif.Al(paramInt3);
    paramString2 = b.KxV;
    paramString2 = u.aqG();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localif.Aj(b.a.cc(paramString2, paramString1));
    localif.aBj();
    AppMethodBeat.o(203227);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(203228);
    k.h(paramString1, "roomId");
    k.h(paramString3, "liveUserName");
    ik localik = new ik();
    localik.aTl(paramString1);
    localik.AC(paramLong1);
    localik.aTm(paramString2);
    localik.aTn(paramString3);
    localik.AF(paramLong2);
    localik.AG(paramLong3);
    paramString2 = b.KxV;
    paramString2 = u.aqG();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localik.AD(b.a.fR(paramString2, paramString3));
    paramString2 = b.KxV;
    paramString2 = u.aqG();
    k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localik.AE(b.a.cc(paramString2, paramString1));
    localik.aBj();
    AppMethodBeat.o(203228);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203218);
    k.h(paramString1, "roomId");
    Object localObject = f.rGw;
    if (f.fuT())
    {
      AppMethodBeat.o(203218);
      return;
    }
    localObject = f.rGw;
    f.kX(true);
    localObject = f.rGw;
    f.la(false);
    localObject = new id();
    ((id)localObject).bsZ();
    ((id)localObject).aSW(paramString1);
    long l;
    label92:
    label115:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((id)localObject).zU(l);
      if (!paramBoolean2) {
        break label264;
      }
      l = 1L;
      ((id)localObject).zV(l);
      ((id)localObject).aSX(paramString2);
      if (!paramBoolean3) {
        break label270;
      }
      l = 1L;
      ((id)localObject).zW(l);
      paramString2 = a.cpE();
      k.g(paramString2, "ConfigHelper.getInstance()");
      switch (paramString2.cpV().qGm)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((id)localObject).zX(i);
      ((id)localObject).zY(paramInt1);
      ((id)localObject).zZ(paramInt2);
      ((id)localObject).Aa(paramInt3);
      paramString2 = b.KxV;
      paramString2 = u.aqG();
      k.g(paramString2, "ConfigStorageLogic.getUsernameFromUserInfo()");
      ((id)localObject).Ab(b.a.cc(paramString2, paramString1));
      paramString2 = b.KxV;
      ((id)localObject).Ac(b.a.aUw(paramString1));
      ((id)localObject).aBj();
      AppMethodBeat.o(203218);
      return;
      l = 0L;
      break;
      label264:
      l = 0L;
      break label92;
      label270:
      l = 0L;
      break label115;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(203229);
    k.h(paramString1, "roomId");
    k.h(paramString2, "micId");
    k.h(paramString3, "liveUserName");
    ih localih = new ih();
    Object localObject = b.KxV;
    localObject = u.aqG();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localih.Ao(b.a.fR((String)localObject, paramString3));
    paramString3 = b.KxV;
    paramString3 = u.aqG();
    k.g(paramString3, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localih.Ap(b.a.cc(paramString3, paramString1));
    localih.An(paramLong);
    localih.aTf(paramString2);
    localih.Aq(paramInt1);
    localih.Ar(paramInt2);
    localih.pg(paramInt3);
    AppMethodBeat.o(203229);
  }
  
  public static final void fPY()
  {
    AppMethodBeat.i(203217);
    ig localig = new ig();
    Object localObject = b.KxV;
    localObject = u.aqG();
    k.g(localObject, "ConfigStorageLogic.getUsernameFromUserInfo()");
    localig.Am(b.a.cc((String)localObject, KxY));
    localig.aTe(KxY);
    localig.btb();
    localig.aBj();
    AppMethodBeat.o(203217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.d.e
 * JD-Core Version:    0.7.0.1
 */