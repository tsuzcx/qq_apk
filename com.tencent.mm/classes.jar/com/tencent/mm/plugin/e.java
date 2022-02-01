package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.z;
import com.tencent.mm.plugin.finder.live.util.n;
import com.tencent.mm.protocal.protobuf.crv;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import java.util.LinkedList;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/MMLiveService;", "Lcom/tencent/mm/plugin/IFinderLiveService;", "()V", "activateMic", "", "delay", "", "checkAcceptMicType", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "micType", "", "checkIsPreciousGift", "", "giftId", "", "createGiftQueue", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "dumpBattlePlayerInfo", "info", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/PlayerInfo;", "enterRoom", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "errCode", "isAnchor", "linkMicEnterRoomFail", "roomId", "liveId", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "notifyAudienceMicUserChange", "refreshMic", "removeBattleEndDelayTimer", "requestStopMic", "requestStopPkMic", "setForbidden", "setupSdkParam", "Lcom/tencent/mm/live/model/AcceptLiveMicInfo;", "startBattleEndDelayTimer", "battleId", "startLinkMic", "stopActivateMic", "stopRefreshMic", "plugin-finder_release"})
public final class e
  implements d
{
  public final void a(com.tencent.mm.live.b.a parama)
  {
    AppMethodBeat.i(227262);
    kotlin.g.b.p.k(parama, "info");
    Object localObject = ah.yhC;
    kotlin.g.b.p.k(parama, "info");
    try
    {
      com.tencent.mm.plugin.finder.live.viewmodel.data.business.c localc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
      if (localc == null) {
        break label337;
      }
      localObject = localc.kvS;
      if (localObject != null)
      {
        localObject = ((g)localObject).kmq;
        if (localObject != null) {
          ((TRTCCloudDef.TRTCParams)localObject).privateMapKey = parama.privateMapKey;
        }
      }
      com.tencent.mm.live.core.core.trtc.a locala = ah.kHp;
      String str;
      if (locala != null)
      {
        str = parama.privateMapKey;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        locala.Nv((String)localObject);
      }
      localObject = (com.tencent.mm.cd.a)new crx();
      parama = parama.ktI;
      try
      {
        ((com.tencent.mm.cd.a)localObject).parseFrom(parama);
        parama = (com.tencent.mm.live.b.a)localObject;
      }
      catch (Exception parama)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { parama });
          parama = null;
        }
        AppMethodBeat.o(227262);
        return;
      }
      localObject = (crx)parama;
      if (localObject != null)
      {
        parama = ((crx)localObject).Tzv.TyP;
        str = ((crx)localObject).Tzv.TyO;
        Log.i("Finder.FinderLiveService", "streamId:" + parama + ", recordId:" + str);
        if ((!Util.isNullOrNil(parama)) || (!Util.isNullOrNil(str)))
        {
          localObject = h.aGm();
          if (!Util.isNullOrNil(parama)) {
            ((com.tencent.mm.ad.c)localObject).f("userdefine_streamid_main", parama);
          }
          if (!Util.isNullOrNil(str)) {
            ((com.tencent.mm.ad.c)localObject).f("userdefine_record_id", str);
          }
          parama = new i();
          parama.h("Str_uc_params", localObject);
          localObject = localc.kvS;
          if (localObject != null)
          {
            localObject = ((g)localObject).kmq;
            if (localObject != null)
            {
              ((TRTCCloudDef.TRTCParams)localObject).businessInfo = parama.toString();
              AppMethodBeat.o(227262);
              return;
            }
          }
        }
      }
      AppMethodBeat.o(227262);
    }
    catch (Exception parama)
    {
      Log.w("Finder.FinderLiveService", "setupSdkParam fail:" + parama.getMessage());
      AppMethodBeat.o(227262);
      return;
    }
    return;
    label337:
    AppMethodBeat.o(227262);
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(227284);
    kotlin.g.b.p.k(parama, "liveData");
    ah localah = ah.yhC;
    ah.a(parama);
    AppMethodBeat.o(227284);
  }
  
  public final boolean aae(String paramString)
  {
    AppMethodBeat.i(227246);
    com.tencent.mm.plugin.finder.live.model.m localm = com.tencent.mm.plugin.finder.live.model.m.yfw;
    boolean bool = com.tencent.mm.plugin.finder.live.model.m.aCd(paramString);
    AppMethodBeat.o(227246);
    return bool;
  }
  
  public final void b(g paramg, kotlin.g.a.b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(227267);
    kotlin.g.b.p.k(paramg, "liveRoomModel");
    kotlin.g.b.p.k(paramb, "action");
    ah localah = ah.yhC;
    ah.a(null, paramg, paramb);
    AppMethodBeat.o(227267);
  }
  
  public final boolean bvS()
  {
    AppMethodBeat.i(227238);
    ah localah = ah.yhC;
    boolean bool = ah.bvS();
    AppMethodBeat.o(227238);
    return bool;
  }
  
  public final com.tencent.mm.live.core.core.trtc.a bvT()
  {
    AppMethodBeat.i(227244);
    Object localObject = ah.yhC;
    localObject = ah.getLiveCore();
    AppMethodBeat.o(227244);
    return localObject;
  }
  
  public final void bvU()
  {
    AppMethodBeat.i(227248);
    com.tencent.mm.plugin.finder.live.report.m localm = com.tencent.mm.plugin.finder.live.report.m.yCt;
    com.tencent.mm.plugin.finder.live.report.m.bvU();
    AppMethodBeat.o(227248);
  }
  
  public final com.tencent.mm.plugin.finder.live.util.p bvV()
  {
    AppMethodBeat.i(227250);
    com.tencent.mm.plugin.finder.live.util.p localp = (com.tencent.mm.plugin.finder.live.util.p)new n();
    AppMethodBeat.o(227250);
    return localp;
  }
  
  public final void bvW()
  {
    AppMethodBeat.i(227264);
    Object localObject = ah.yhC;
    if ((ah.kHp instanceof com.tencent.mm.live.core.core.c.c))
    {
      com.tencent.mm.live.core.core.trtc.a locala = ah.kHp;
      localObject = locala;
      if (!(locala instanceof com.tencent.mm.live.core.core.c.c)) {
        localObject = null;
      }
      localObject = (com.tencent.mm.live.core.core.c.c)localObject;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.c.c)localObject).aMg();
      }
      localObject = ah.kHp;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.trtc.a)localObject).eX(false);
      }
      localObject = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)ah.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject).zgs = false;
        AppMethodBeat.o(227264);
        return;
      }
    }
    AppMethodBeat.o(227264);
  }
  
  public final void bvX()
  {
    AppMethodBeat.i(227269);
    ah localah = ah.yhC;
    ah.Ll(0L);
    AppMethodBeat.o(227269);
  }
  
  public final void bvY()
  {
    AppMethodBeat.i(227271);
    ah localah = ah.yhC;
    ah.bvY();
    AppMethodBeat.o(227271);
  }
  
  public final void bvZ()
  {
    AppMethodBeat.i(227272);
    ah localah = ah.yhC;
    ah.bvZ();
    AppMethodBeat.o(227272);
  }
  
  public final void bwa()
  {
    AppMethodBeat.i(227275);
    ah localah = ah.yhC;
    ah.Lm(0L);
    AppMethodBeat.o(227275);
  }
  
  public final void bwb()
  {
    AppMethodBeat.i(227276);
    ah localah = ah.yhC;
    ah.bwb();
    AppMethodBeat.o(227276);
  }
  
  public final void bwc()
  {
    AppMethodBeat.i(227280);
    ah localah = ah.yhC;
    ah.bwc();
    AppMethodBeat.o(227280);
  }
  
  public final void bwd()
  {
    AppMethodBeat.i(227285);
    ah localah = ah.yhC;
    ah.bwd();
    AppMethodBeat.o(227285);
  }
  
  public final void i(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227288);
    z localz = z.ygx;
    z.l(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(227288);
  }
  
  public final void i(long paramLong, String paramString)
  {
    AppMethodBeat.i(227282);
    ah localah = ah.yhC;
    ah.i(paramLong, paramString);
    AppMethodBeat.o(227282);
  }
  
  public final void notifyAudienceMicUserChange()
  {
    AppMethodBeat.i(227242);
    Object localObject = ah.yhC;
    localObject = ah.dzf();
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.live.view.a)localObject).notifyAudienceMicUserChange();
      AppMethodBeat.o(227242);
      return;
    }
    AppMethodBeat.o(227242);
  }
  
  public final void s(LinkedList<dlk> paramLinkedList)
  {
    AppMethodBeat.i(227277);
    ah localah = ah.yhC;
    ah.s(paramLinkedList);
    AppMethodBeat.o(227277);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.e
 * JD-Core Version:    0.7.0.1
 */