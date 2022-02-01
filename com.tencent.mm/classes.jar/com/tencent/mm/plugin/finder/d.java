package com.tencent.mm.plugin.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.live.model.aa;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.view.mini.b.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.replay.k.a;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/MMLiveService;", "Lcom/tencent/mm/plugin/IFinderLiveService;", "()V", "activateMic", "", "delay", "", "checkAcceptMicType", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "micType", "", "checkIsPreciousGift", "", "giftId", "", "createGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "dumpBattlePlayerInfo", "info", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errCode", "isAnchor", "isAnchorLiveWithoutSndDevice", "linkMicEnterRoomFail", "roomId", "liveId", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "notifyAudienceMicUserChange", "notifyRoomPKMicUserChange", "forceUpdate", "refreshMic", "removeBattleEndDelayTimer", "removeBattleStartDelayTimer", "requestStopMic", "requestStopPkMic", "setForbidden", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "startBattleEndDelayTimer", "battleId", "startBattleStartDelayTimer", "startLinkMic", "stopActivateMic", "stopRefreshMic", "updateRemoteLinkMicUserInfo", "sdkUserId", "sdkLiveId", "sessionId", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.plugin.k
{
  public final boolean Sy(String paramString)
  {
    AppMethodBeat.i(329836);
    com.tencent.mm.plugin.finder.live.model.q localq = com.tencent.mm.plugin.finder.live.model.q.CFU;
    boolean bool = com.tencent.mm.plugin.finder.live.model.q.awy(paramString);
    AppMethodBeat.o(329836);
    return bool;
  }
  
  public final void a(com.tencent.mm.live.model.a parama)
  {
    AppMethodBeat.i(329856);
    kotlin.g.b.s.u(parama, "info");
    Object localObject1 = aj.CGT;
    kotlin.g.b.s.u(parama, "info");
    try
    {
      f localf = (f)aj.business(f.class);
      if (localf != null)
      {
        localObject1 = localf.mZu;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mNz)
        {
          if (localObject1 != null) {
            ((TRTCCloudDef.TRTCParams)localObject1).privateMapKey = parama.privateMapKey;
          }
          Object localObject3 = aj.getLiveCore();
          if (localObject3 != null)
          {
            localObject2 = parama.privateMapKey;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            ((com.tencent.mm.live.core.core.trtc.a)localObject3).FO((String)localObject1);
          }
          localObject1 = (com.tencent.mm.bx.a)new diy();
          parama = parama.mXB;
          try
          {
            ((com.tencent.mm.bx.a)localObject1).parseFrom(parama);
            parama = (com.tencent.mm.live.model.a)localObject1;
          }
          catch (Exception parama)
          {
            for (;;)
            {
              Log.printDebugStack("safeParser", "", new Object[] { parama });
              parama = null;
              continue;
              parama = parama.mNz;
            }
          }
          Object localObject2 = (diy)parama;
          if (localObject2 != null)
          {
            parama = ((diy)localObject2).aaOC.aaNF;
            localObject1 = ((diy)localObject2).aaOC.aaNE;
            localObject3 = ((diy)localObject2).aaOC.aaOl;
            Log.i("Finder.FinderLiveService", "streamId:" + parama + ", recordId:" + localObject1 + ", pushArg:" + localObject3);
            if ((!Util.isNullOrNil(parama)) || (!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject3)))
            {
              localObject2 = com.tencent.mm.ad.h.aZn();
              if (!Util.isNullOrNil(parama)) {
                ((c)localObject2).l("userdefine_streamid_main", parama);
              }
              if (!Util.isNullOrNil((String)localObject1)) {
                ((c)localObject2).l("userdefine_record_id", localObject1);
              }
              if (!Util.isNullOrNil((String)localObject3)) {
                ((c)localObject2).l("userdefine_push_args", localObject3);
              }
              localObject1 = new com.tencent.mm.ad.i();
              ((com.tencent.mm.ad.i)localObject1).n("Str_uc_params", localObject2);
              parama = localf.mZu;
              if (parama != null) {
                break;
              }
              parama = null;
              if (parama != null) {
                parama.businessInfo = ((com.tencent.mm.ad.i)localObject1).toString();
              }
            }
          }
          AppMethodBeat.o(329856);
          return;
        }
      }
      return;
    }
    catch (Exception parama)
    {
      Log.w("Finder.FinderLiveService", kotlin.g.b.s.X("setupSdkParam fail:", parama.getMessage()));
      AppMethodBeat.o(329856);
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.model.context.a parama, int paramInt)
  {
    AppMethodBeat.i(329912);
    kotlin.g.b.s.u(parama, "liveData");
    aj localaj = aj.CGT;
    aj.a(parama, paramInt);
    AppMethodBeat.o(329912);
  }
  
  public final boolean a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(329920);
    kotlin.g.b.s.u(paramString1, "sdkUserId");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramBoolean = com.tencent.mm.plugin.finder.live.utils.a.a(paramString1, paramInt, paramBoolean, paramString2);
    AppMethodBeat.o(329920);
    return paramBoolean;
  }
  
  public final void b(com.tencent.mm.live.core.core.model.h paramh, b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(329866);
    kotlin.g.b.s.u(paramh, "liveRoomModel");
    kotlin.g.b.s.u(paramb, "action");
    aj localaj = aj.CGT;
    aj.a(null, paramh, paramb);
    AppMethodBeat.o(329866);
  }
  
  public final boolean bUB()
  {
    AppMethodBeat.i(329820);
    aj localaj = aj.CGT;
    boolean bool = aj.bUB();
    AppMethodBeat.o(329820);
    return bool;
  }
  
  public final boolean bUC()
  {
    AppMethodBeat.i(329825);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.bUC();
    AppMethodBeat.o(329825);
    return bool;
  }
  
  public final void bUD()
  {
    AppMethodBeat.i(329827);
    Object localObject = aj.CGT;
    localObject = aj.elk();
    if (localObject != null) {
      com.tencent.mm.plugin.finder.live.view.a.notifyAudienceMicUserChange$default((com.tencent.mm.plugin.finder.live.view.a)localObject, false, 1, null);
    }
    localObject = aj.CGT;
    aj.a(2, null, false, 6);
    localObject = com.tencent.mm.plugin.finder.replay.k.Fky;
    k.a.c(2, null, true);
    AppMethodBeat.o(329827);
  }
  
  public final void bUE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(329830);
    Object localObject1 = aj.CGT;
    com.tencent.mm.plugin.finder.live.view.a locala = aj.elk();
    if (locala != null)
    {
      localObject1 = aj.CGT;
      localObject1 = aj.getLiveCore();
      if (localObject1 == null)
      {
        localObject1 = null;
        com.tencent.mm.plugin.finder.live.view.a.notifyRoomPKMicUserChange$default(locala, (JSONObject)localObject1, true, null, 4, null);
      }
    }
    else
    {
      localObject1 = aj.CGT;
      localObject1 = aj.CGT;
      localObject1 = aj.getLiveCore();
      if (localObject1 != null) {
        break label108;
      }
      localObject1 = null;
      label62:
      aj.b(3, (JSONObject)localObject1, false);
      localObject1 = com.tencent.mm.plugin.finder.replay.k.Fky;
      localObject1 = aj.CGT;
      localObject1 = aj.getLiveCore();
      if (localObject1 != null) {
        break label116;
      }
    }
    label108:
    label116:
    for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).bfi())
    {
      k.a.c(3, (JSONObject)localObject1, false);
      AppMethodBeat.o(329830);
      return;
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).bfi();
      break;
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).bfi();
      break label62;
    }
  }
  
  public final com.tencent.mm.live.core.core.trtc.a bUF()
  {
    AppMethodBeat.i(370032);
    Object localObject = aj.CGT;
    localObject = aj.getLiveCore();
    AppMethodBeat.o(370032);
    return localObject;
  }
  
  public final void bUG()
  {
    AppMethodBeat.i(329841);
    com.tencent.mm.plugin.finder.live.report.k localk = com.tencent.mm.plugin.finder.live.report.k.Doi;
    com.tencent.mm.plugin.finder.live.report.k.DoB += 1;
    Log.d("HABBYGE-MALI.HellLiveVisitorReoprter", kotlin.g.b.s.X("HABBYGE-MALI, setForbidden: ", Integer.valueOf(com.tencent.mm.plugin.finder.live.report.k.DoB)));
    AppMethodBeat.o(329841);
  }
  
  public final com.tencent.mm.plugin.finder.live.util.s bUH()
  {
    AppMethodBeat.i(329844);
    com.tencent.mm.plugin.finder.live.util.s locals = (com.tencent.mm.plugin.finder.live.util.s)new com.tencent.mm.plugin.finder.live.util.q();
    AppMethodBeat.o(329844);
    return locals;
  }
  
  public final void bUI()
  {
    AppMethodBeat.i(329861);
    Object localObject = aj.CGT;
    if ((aj.nkg instanceof com.tencent.mm.live.core.core.f.d))
    {
      localObject = aj.nkg;
      if (!(localObject instanceof com.tencent.mm.live.core.core.f.d)) {
        break label143;
      }
      localObject = (com.tencent.mm.live.core.core.f.d)localObject;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.f.d)localObject).bfF();
      }
      localObject = aj.nkg;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.a)localObject).fI(false);
      }
      localObject = (e)aj.business(e.class);
      if (localObject != null) {
        ((e)localObject).Eem = false;
      }
    }
    localObject = aj.CGT;
    localObject = aj.getLiveCore();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.live.core.core.trtc.a)localObject).mRB;
      if ((localObject == null) || (((com.tencent.mm.live.core.core.model.i)localObject).isFloatMode())) {}
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = aj.CGT;
        localObject = aj.elr();
        if (localObject != null) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b.e((com.tencent.mm.plugin.finder.live.model.context.a)localObject));
        }
      }
      AppMethodBeat.o(329861);
      return;
      label143:
      localObject = null;
      break;
    }
  }
  
  public final void bUJ()
  {
    AppMethodBeat.i(329872);
    aj localaj = aj.CGT;
    aj.od(0L);
    AppMethodBeat.o(329872);
  }
  
  public final void bUK()
  {
    AppMethodBeat.i(329877);
    aj localaj = aj.CGT;
    aj.bUK();
    AppMethodBeat.o(329877);
  }
  
  public final void bUL()
  {
    AppMethodBeat.i(329881);
    aj localaj = aj.CGT;
    aj.bUL();
    AppMethodBeat.o(329881);
  }
  
  public final void bUM()
  {
    AppMethodBeat.i(329883);
    aj localaj = aj.CGT;
    aj.oe(0L);
    AppMethodBeat.o(329883);
  }
  
  public final void bUN()
  {
    AppMethodBeat.i(329887);
    aj localaj = aj.CGT;
    aj.bUN();
    AppMethodBeat.o(329887);
  }
  
  public final void bUO()
  {
    AppMethodBeat.i(329894);
    aj localaj = aj.CGT;
    aj.bUO();
    AppMethodBeat.o(329894);
  }
  
  public final void bUP()
  {
    AppMethodBeat.i(329902);
    aj localaj = aj.CGT;
    aj.bUP();
    AppMethodBeat.o(329902);
  }
  
  public final void bUQ()
  {
    AppMethodBeat.i(329915);
    aj localaj = aj.CGT;
    aj.bUQ();
    AppMethodBeat.o(329915);
  }
  
  public final void i(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(329926);
    aa localaa = aa.CGv;
    aa.l(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(329926);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(329899);
    aj localaj = aj.CGT;
    aj.j(paramLong, paramString);
    AppMethodBeat.o(329899);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(329909);
    aj localaj = aj.CGT;
    aj.k(paramLong, paramString);
    AppMethodBeat.o(329909);
  }
  
  public final void v(LinkedList<edv> paramLinkedList)
  {
    AppMethodBeat.i(329892);
    aj localaj = aj.CGT;
    aj.v(paramLinkedList);
    AppMethodBeat.o(329892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.d
 * JD-Core Version:    0.7.0.1
 */