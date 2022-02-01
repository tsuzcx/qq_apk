package com.tencent.mm.live.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ir;
import com.tencent.mm.autogen.mmdata.rpt.is;
import com.tencent.mm.autogen.mmdata.rpt.it;
import com.tencent.mm.autogen.mmdata.rpt.iv;
import com.tencent.mm.autogen.mmdata.rpt.iw;
import com.tencent.mm.autogen.mmdata.rpt.ix;
import com.tencent.mm.autogen.mmdata.rpt.iy;
import com.tencent.mm.autogen.mmdata.rpt.iz;
import com.tencent.mm.autogen.mmdata.rpt.jb;
import com.tencent.mm.autogen.mmdata.rpt.je;
import com.tencent.mm.autogen.mmdata.rpt.jf;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a;
import com.tencent.mm.live.core.core.trtc.sdkadapter.a.a;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dio;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/report/LiveReportHappenUtil;", "", "()V", "liveRoomId", "", "visitorEnterLiveStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "getVisitorEnterLiveStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;", "setVisitorEnterLiveStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/LiveVisitorEnterLiveStruct;)V", "entranceShow", "", "page", "", "reportAnchorFinishLive", "roomId", "liveId", "", "topic", "audienceCount", "audienceCountMax", "commentCount", "heartCount", "connectCount", "allowReplay", "", "costTime", "reportEnterReplayUi", "liveUserName", "scene", "replayStatusEnd", "replayStatusBegin", "reportErrorCode", "micId", "linkStatus", "audienceMode", "errorCode", "reportLiveAnchorLinkMic", "waitCount", "allowConnect", "linkMicCount", "reportLiveComplain", "reportLiveLinkMicFinish", "startTime", "closeRole", "hasVideo", "reportLiveUserOp", "anchorName", "action", "actionResult", "audienceUserName", "onlineCnt", "reportReplayOp", "wholeTime", "viewTime", "reportVisitorEnterLive", "enterRoomCount", "exitRoomCount", "connectReqCount", "startLiveReport", "isRulePop", "isRuleCheck", "isCustomTopic", "deviceOrientation", "exitType", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e nkN;
  public static String nkO;
  private static jf nkP;
  
  static
  {
    AppMethodBeat.i(246134);
    nkN = new e();
    nkO = "";
    nkP = new jf();
    AppMethodBeat.o(246134);
  }
  
  public static final void a(String paramString1, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString2)
  {
    AppMethodBeat.i(246062);
    Object localObject = u.mZl;
    if (u.biH())
    {
      AppMethodBeat.o(246062);
      return;
    }
    localObject = u.mZl;
    u.tG(-1);
    localObject = nkP;
    u localu = u.mZl;
    ((jf)localObject).iuA = u.biI();
    localObject = nkP;
    ((jf)localObject).iNB = ((jf)localObject).F("roomid", paramString1, true);
    nkP.iFo = paramLong;
    nkP.iQP = paramInt1;
    paramString1 = nkP;
    if (paramInt2 < 0) {}
    for (paramLong = 0L;; paramLong = paramInt2)
    {
      paramString1.iSh = paramLong;
      nkP.iSi = paramInt3;
      nkP.iQA = paramInt4;
      nkP.iQB = paramInt5;
      nkP.iSj = paramInt6;
      nkP.iQC = paramInt7;
      paramString1 = nkP;
      paramString1.iQT = paramString1.F("liveusername", paramString2, true);
      nkP.bMH();
      paramString1 = u.mZl;
      u.fZ(true);
      paramString1 = u.mZl;
      u.tE(0);
      paramString1 = u.mZl;
      u.tF(0);
      paramString1 = u.mZl;
      u.tH(0);
      paramString1 = u.mZl;
      u.tI(0);
      paramString1 = u.mZl;
      u.tJ(0);
      paramString1 = u.mZl;
      u.tK(0);
      paramString1 = u.mZl;
      u.tL(0);
      nkP = new jf();
      AppMethodBeat.o(246062);
      return;
    }
  }
  
  public static final void a(String paramString, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(246092);
    s.u(paramString, "roomId");
    is localis = new is();
    u localu = u.mZl;
    u.tN(0);
    localis.iNB = localis.F("roomid", paramString, true);
    localis.iFo = paramLong;
    localis.iQG = paramInt1;
    if (paramBoolean) {}
    for (paramLong = 1L;; paramLong = 0L)
    {
      localis.iQH = paramLong;
      localis.iQJ = paramInt2;
      localis.bMH();
      AppMethodBeat.o(246092);
      return;
    }
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2)
  {
    AppMethodBeat.i(246033);
    s.u(paramString1, "roomId");
    ir localir = new ir();
    u localu = u.mZl;
    u.tF(0);
    localu = u.mZl;
    u.tD(-1);
    localir.iuA = 1L;
    localir.iNB = localir.F("roomid", paramString1, true);
    localir.iFo = paramLong1;
    localir.iCb = localir.F("topic", paramString2, true);
    localir.iQy = paramInt1;
    if (paramInt2 <= 0)
    {
      paramLong1 = paramInt1;
      localir.iQz = paramLong1;
      localir.iQC = paramInt5;
      localir.iQA = paramInt3;
      localir.iQB = paramInt4;
      if (!paramBoolean) {
        break label204;
      }
    }
    label204:
    for (paramLong1 = 1L;; paramLong1 = 0L)
    {
      localir.iQD = paramLong1;
      localir.iQF = paramLong2;
      paramString2 = b.nkK;
      paramString2 = z.bAM();
      s.s(paramString2, "getUsernameFromUserInfo()");
      localir.iQx = b.a.aJ(paramString2, paramString1);
      paramString2 = b.nkK;
      localir.iQE = b.a.GB(paramString1);
      localir.bMH();
      AppMethodBeat.o(246033);
      return;
      paramLong1 = paramInt2;
      break;
    }
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3)
  {
    AppMethodBeat.i(246077);
    s.u(paramString1, "roomId");
    s.u(paramString2, "anchorName");
    s.u(paramString3, "audienceUserName");
    jb localjb = new jb();
    localjb.iNB = localjb.F("roomid", paramString1, true);
    localjb.iFo = paramLong;
    localjb.iRs = paramInt2;
    localjb.ila = paramInt1;
    Object localObject = b.nkK;
    localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localjb.iQU = b.a.aK((String)localObject, paramString2);
    localObject = b.nkK;
    localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localjb.iQx = b.a.aJ((String)localObject, paramString1);
    localjb.inE = System.currentTimeMillis();
    localjb.iRt = localjb.F("audienceUserName", paramString3, true);
    localjb.iRu = localjb.F("anchorusername", paramString2, true);
    localjb.iRv = paramInt3;
    localjb.bMH();
    AppMethodBeat.o(246077);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(246109);
    s.u(paramString1, "roomId");
    s.u(paramString3, "liveUserName");
    iv localiv = new iv();
    localiv.iNB = localiv.F("roomid", paramString1, true);
    localiv.iFo = paramLong;
    localiv.iQT = localiv.F("liveusername", paramString3, true);
    localiv.iuA = 1L;
    localiv.iCb = localiv.F("topic", paramString2, true);
    localiv.iQy = paramInt;
    paramString2 = b.nkK;
    paramString2 = z.bAM();
    s.s(paramString2, "getUsernameFromUserInfo()");
    localiv.iQx = b.a.aJ(paramString2, paramString1);
    localiv.bMH();
    AppMethodBeat.o(246109);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, long paramLong2, int paramInt1, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(246098);
    s.u(paramString1, "roomId");
    s.u(paramString2, "micId");
    s.u(paramString3, "liveUserName");
    long l = System.currentTimeMillis();
    iz localiz = new iz();
    u localu = u.mZl;
    u.ga(false);
    localiz.iNB = localiz.F("roomid", paramString1, true);
    localiz.iFo = paramLong1;
    localiz.iRi = localiz.F("livemicid", paramString2, true);
    localiz.iku = ((l - paramLong2) / 1000L);
    localiz.iRg = paramInt1;
    localiz.iRh = paramInt2;
    localiz.iQT = localiz.F("liveusername", paramString3, true);
    localiz.iRk = l;
    localiz.iRj = paramLong2;
    paramString1 = u.mZl;
    localiz.iRl = u.biO();
    paramString1 = u.mZl;
    localiz.iRm = u.bie().ZWw;
    localiz.bMH();
    AppMethodBeat.o(246098);
  }
  
  public static final void a(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246115);
    s.u(paramString1, "roomId");
    s.u(paramString3, "liveUserName");
    iw localiw = new iw();
    localiw.iNB = localiw.F("roomid", paramString1, true);
    localiw.iFo = paramLong;
    Object localObject = b.nkK;
    localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localiw.iQU = b.a.aK((String)localObject, paramString3);
    localiw.iuA = paramInt1;
    localiw.iQT = localiw.F("liveusername", paramString3, true);
    localiw.iCb = localiw.F("topic", paramString2, true);
    localiw.iQV = paramInt2;
    localiw.iQW = paramInt3;
    paramString2 = b.nkK;
    paramString2 = z.bAM();
    s.s(paramString2, "getUsernameFromUserInfo()");
    localiw.iQx = b.a.aJ(paramString2, paramString1);
    localiw.bMH();
    AppMethodBeat.o(246115);
  }
  
  public static final void a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(246123);
    s.u(paramString1, "roomId");
    s.u(paramString3, "liveUserName");
    je localje = new je();
    localje.iNB = localje.F("roomid", paramString1, true);
    localje.iFo = paramLong1;
    localje.iCb = localje.F("topic", paramString2, true);
    localje.iQT = localje.F("liveusername", paramString3, true);
    localje.iSf = paramLong2;
    localje.iSg = paramLong3;
    paramString2 = b.nkK;
    paramString2 = z.bAM();
    s.s(paramString2, "getUsernameFromUserInfo()");
    localje.iQU = b.a.aK(paramString2, paramString3);
    paramString2 = b.nkK;
    paramString2 = z.bAM();
    s.s(paramString2, "getUsernameFromUserInfo()");
    localje.iQx = b.a.aJ(paramString2, paramString1);
    localje.bMH();
    AppMethodBeat.o(246123);
  }
  
  public static final void a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246016);
    s.u(paramString1, "roomId");
    Object localObject = u.mZl;
    if (u.bix())
    {
      AppMethodBeat.o(246016);
      return;
    }
    localObject = u.mZl;
    u.fV(false);
    localObject = u.mZl;
    u.fW(false);
    localObject = u.mZl;
    u.fX(true);
    localObject = u.mZl;
    u.fY(false);
    localObject = u.mZl;
    u.fU(false);
    localObject = new it();
    ((it)localObject).iuA = 1L;
    ((it)localObject).iNB = ((it)localObject).F("roomid", paramString1, true);
    long l;
    label125:
    int i;
    if (paramBoolean1)
    {
      l = 1L;
      ((it)localObject).iQK = l;
      if (!paramBoolean2) {
        break label286;
      }
      l = 1L;
      ((it)localObject).iQL = l;
      ((it)localObject).iCb = ((it)localObject).F("topic", paramString2, true);
      if (!paramBoolean3) {
        break label292;
      }
      l = 1L;
      label154:
      ((it)localObject).iQM = l;
      switch (a.a.bfr().bfq().cameraId)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      ((it)localObject).iQN = i;
      ((it)localObject).iQO = paramInt1;
      ((it)localObject).ipr = paramInt2;
      ((it)localObject).iQP = paramInt3;
      paramString2 = b.nkK;
      paramString2 = z.bAM();
      s.s(paramString2, "getUsernameFromUserInfo()");
      ((it)localObject).iQx = b.a.aJ(paramString2, paramString1);
      paramString2 = b.nkK;
      ((it)localObject).iQE = b.a.GB(paramString1);
      ((it)localObject).bMH();
      AppMethodBeat.o(246016);
      return;
      l = 0L;
      break;
      label286:
      l = 0L;
      break label125;
      label292:
      l = 0L;
      break label154;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  public static final void b(String paramString1, long paramLong, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(246129);
    s.u(paramString1, "roomId");
    s.u(paramString2, "micId");
    s.u(paramString3, "liveUserName");
    iy localiy = new iy();
    Object localObject = b.nkK;
    localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localiy.iQU = b.a.aK((String)localObject, paramString3);
    paramString3 = b.nkK;
    paramString3 = z.bAM();
    s.s(paramString3, "getUsernameFromUserInfo()");
    localiy.iRb = b.a.aJ(paramString3, paramString1);
    localiy.iDB = paramLong;
    localiy.iRa = localiy.F("micId", paramString2, true);
    localiy.iRc = paramInt1;
    localiy.iRd = paramInt2;
    localiy.iRe = paramInt3;
    localiy.bMH();
    AppMethodBeat.o(246129);
  }
  
  public static jf bkv()
  {
    return nkP;
  }
  
  public static final void tR(int paramInt)
  {
    AppMethodBeat.i(246001);
    ix localix = new ix();
    Object localObject = b.nkK;
    localObject = z.bAM();
    s.s(localObject, "getUsernameFromUserInfo()");
    localix.iQx = b.a.aJ((String)localObject, nkO);
    localix.iNB = localix.F("roomid", nkO, true);
    localix.iuA = 1L;
    localix.iQY = paramInt;
    localix.bMH();
    AppMethodBeat.o(246001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */