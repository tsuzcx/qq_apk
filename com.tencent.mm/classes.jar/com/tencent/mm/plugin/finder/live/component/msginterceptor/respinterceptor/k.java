package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.h;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bgz;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespSimpleUpdateVarInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "trySyncGift", "", "getTrySyncGift", "()Z", "setTrySyncGift", "(Z)V", "intercept", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "", "oriCreateInfo", "newCreateInfo", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private boolean CBQ;
  private final String TAG;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353208);
    this.CBK = parama;
    this.TAG = "LiveMsgRespSimpleUpdateVarInterceptor";
    AppMethodBeat.o(353208);
  }
  
  public final boolean a(a.a parama)
  {
    int j = 0;
    AppMethodBeat.i(353231);
    kotlin.g.b.s.u(parama, "respWrapper");
    Object localObject1 = parama.CBm;
    int i;
    boolean bool;
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcE = (((azp)localObject1).ZJZ - ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF = kotlin.k.k.bR(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcF, ((azp)localObject1).ZJZ);
      ((f)this.CBK.business(f.class)).liveInfo.DSe = ((azp)localObject1).ZJN;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcL = ((azp)localObject1).ZJU;
      localObject1 = ((azp)localObject1).liveInfo;
      if (localObject1 != null)
      {
        ((f)this.CBK.business(f.class)).liveInfo.ZKy = ((bip)localObject1).ZKy;
        ((f)this.CBK.business(f.class)).liveInfo.ZKR = ((bip)localObject1).ZKR;
        ((f)this.CBK.business(f.class)).liveInfo.ZRP = ((bip)localObject1).ZRP;
        i = ((bip)localObject1).ZRR;
        localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class);
        if ((i & 0x10) <= 0) {
          break label890;
        }
        bool = true;
        Log.i("AllowanceGiftSlice", kotlin.g.b.s.X("set isAnchorNeedShowGuide ", Boolean.valueOf(bool)));
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.a)localObject2).Ece = bool;
        if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egs)
        {
          localObject2 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class);
          if (((i & 0x1) <= 0) && ((i & 0x2) <= 0)) {
            break label896;
          }
          bool = true;
          label321:
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)localObject2).Egs = bool;
        }
        if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcR == 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcR == 1)) {
          ((f)this.CBK.business(f.class)).liveInfo.ZSc = ((bip)localObject1).ZSc;
        }
      }
    }
    localObject1 = parama.CBm;
    if (localObject1 != null)
    {
      localObject2 = ((azp)localObject1).Ayh;
      if (localObject2 != null)
      {
        localObject1 = aj.CGT;
        localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
        if (localObject1 != null) {
          break label902;
        }
        localObject1 = null;
        label434:
        if ((localObject1 != null) && (parama.CuT != ((Integer)localObject1).intValue())) {
          break label933;
        }
        ((f)this.CBK.business(f.class)).mZp = ((b)localObject2).Op;
      }
    }
    Object localObject2 = parama.CBm;
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecq = ((azp)localObject2).ZKh;
      if (((azp)localObject2).ZKb == null) {
        break label1025;
      }
      localObject1 = new StringBuilder("live_game_data.visibility:");
      parama = ((azp)localObject2).ZKb;
      if (parama != null) {
        break label1003;
      }
      parama = null;
      label533:
      localObject1 = ((StringBuilder)localObject1).append(parama).append(", update:");
      parama = ((azp)localObject2).ZKb;
      if (parama != null) {
        break label1014;
      }
      parama = null;
      label558:
      Log.i("Finder.FinderLiveService", parama);
      parama = ((azp)localObject2).ZKb;
      i = j;
      if (parama != null)
      {
        i = j;
        if (parama.ZQx == true) {
          i = 1;
        }
      }
      if (i != 0) {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edj = ((azp)localObject2).ZKb;
      }
      label620:
      parama = ((azp)localObject2).ZKc;
      if (parama != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.akgP;
        i = parama.akli;
        if (i != com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.kLn()) {
          Log.i(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.access$getTAG$cp(), "minimunShowMsgLikeCnt from " + com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.kLn() + " to " + i + '!');
        }
        com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.aNB(i);
      }
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)this.CBK.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).aD(((azp)localObject2).ZKa);
      ((h)this.CBK.business(h.class)).sn(((azp)localObject2).ZKi);
      parama = ((h)this.CBK.business(h.class)).Efg;
      if (parama != null) {
        break label1036;
      }
      parama = null;
      label755:
      localObject1 = ((azp)localObject2).ZGD;
      if (localObject1 != null) {
        break label1047;
      }
    }
    label896:
    label902:
    label1036:
    label1047:
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((bgw)localObject1).ZQo))
    {
      ((h)this.CBK.business(h.class)).a(((azp)localObject2).ZGD);
      if ((!this.CBQ) && (kotlin.g.b.s.p(parama, Boolean.FALSE)) && (kotlin.g.b.s.p(localObject1, Boolean.TRUE)))
      {
        this.CBQ = true;
        Log.i(this.TAG, "try sync gift for new club_created!");
        parama = aj.CGT;
        parama = aj.getFinderLiveAssistant();
        if (parama != null)
        {
          this.CBK.business(f.class);
          this.CBK.business(f.class);
          this.CBK.business(f.class);
          parama.m(null);
        }
      }
      AppMethodBeat.o(353231);
      return true;
      label890:
      bool = false;
      break;
      bool = false;
      break label321;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdI;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label434;
      }
      localObject1 = Integer.valueOf(((bcz)localObject1).ZNI);
      break label434;
      label933:
      localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class);
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        Log.i("Finder.FinderLiveService", kotlin.g.b.s.X("getLiveMsg wrong roleType:", localObject1));
        break;
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)localObject1).EdI;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((bcz)localObject1).ZNI);
        }
      }
      label1003:
      parama = Integer.valueOf(parama.visibility);
      break label533;
      label1014:
      parama = Boolean.valueOf(parama.ZQx);
      break label558;
      Log.i("Finder.FinderLiveService", "live_game_data is null");
      break label620;
      parama = Boolean.valueOf(parama.ZQo);
      break label755;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.k
 * JD-Core Version:    0.7.0.1
 */