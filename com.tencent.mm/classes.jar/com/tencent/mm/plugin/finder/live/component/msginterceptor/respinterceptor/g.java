package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.d.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespLayerInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "checkLayerShowInfo", "", "layerShowInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLayerShowInfo;", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "onAnchorVerificationRequired", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final String TAG;
  
  public g(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(353184);
    this.CBK = parama;
    this.TAG = "LiveMsgRespLayerInterceptor";
    AppMethodBeat.o(353184);
  }
  
  public final boolean a(a.a parama)
  {
    Object localObject1 = null;
    int j = 0;
    AppMethodBeat.i(353209);
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    Object localObject2;
    if (parama != null)
    {
      parama = parama.liveInfo;
      if (parama != null)
      {
        localObject2 = parama.ZRZ;
        if (localObject2 != null)
        {
          parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          com.tencent.mm.plugin.finder.live.utils.a.hQ(this.TAG, "checkLayerShowInfo type:" + ((bix)localObject2).show_type + ", time:" + ((bix)localObject2).ZSF);
          parama = aj.CGT;
          if ((!aj.bUB()) || (((bix)localObject2).show_type != 3)) {
            break label498;
          }
          localObject1 = (com.tencent.mm.bx.a)new biw();
          parama = ((bix)localObject2).ZSE;
          if (parama != null) {
            break label432;
          }
          parama = null;
        }
      }
    }
    int i;
    try
    {
      ((com.tencent.mm.bx.a)localObject1).parseFrom(parama);
      parama = (a.a)localObject1;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { parama });
        parama = null;
        continue;
        i = 0;
        continue;
        localObject1 = aj.CGT;
        aj.a(parama, true, b.c.nfm, null, ((f)parama.business(f.class)).liveInfo.liveId);
      }
    }
    localObject1 = (biw)parama;
    if (localObject1 != null)
    {
      Log.i(this.TAG, "onAnchorVerificationRequired: show_type:" + ((bix)localObject2).show_type + ", verify_mode:" + ((biw)localObject1).ZSr + ", verification_id:" + ((biw)localObject1).ZSt + ", remaining_seconds:" + ((biw)localObject1).ZSu);
      parama = aj.CGT;
      parama = aj.elr();
      if (parama != null)
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efj = ((biw)localObject1);
        if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efk != ((biw)localObject1).ZSr))
        {
          localObject2 = aj.CGT;
          localObject2 = aj.elk();
          if ((localObject2 == null) || (((com.tencent.mm.plugin.finder.live.view.a)localObject2).isDestroyed() != true)) {
            break label461;
          }
          i = 1;
          if (i == 0)
          {
            localObject2 = aj.CGT;
            localObject2 = aj.elk();
            if (localObject2 != null) {
              b.b.a((com.tencent.mm.live.b.b)localObject2, b.c.nfn);
            }
          }
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).Efk = ((biw)localObject1).ZSr;
        localObject1 = aj.CGT;
        localObject1 = aj.elk();
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((com.tencent.mm.plugin.finder.live.view.a)localObject1).isDestroyed() == true) {
            i = 1;
          }
        }
        if (i != 0) {
          break label466;
        }
        parama = aj.CGT;
        parama = aj.elk();
        if (parama != null) {
          b.b.a((com.tencent.mm.live.b.b)parama, b.c.nfm);
        }
        parama = aj.CGT;
        parama = aj.eln();
        if (parama != null) {
          com.tencent.mm.plugin.finder.live.model.d.a(parama);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(353209);
      return true;
      label432:
      parama = parama.toByteArray();
      break;
      label461:
      label466:
      label498:
      parama = this.CBK;
      if (parama != null) {
        break label530;
      }
      parama = (a.a)localObject1;
      label510:
      if (parama != null) {
        break label746;
      }
      Log.e(((g)this).TAG, "checkLayerShowInfo error!");
    }
    label530:
    localObject1 = aj.CGT;
    if ((aj.bUB()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag) && (((bix)localObject2).show_type == 0))
    {
      localObject1 = aj.CGT;
      aj.a(parama, true, b.c.nfn, null, ((f)parama.business(f.class)).liveInfo.liveId);
      localObject1 = aj.CGT;
      localObject1 = aj.eln();
      if ((localObject1 != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)((com.tencent.mm.plugin.finder.live.model.d)localObject1).CDN.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).qag))
      {
        Log.i("Finder.FinderLiveAnchorVerifyManager", "checkAnchorVerify: verification finish, currentVerifyMode:" + ((com.tencent.mm.plugin.finder.live.model.d)localObject1).CDP + ", currentVerifyId:" + ((com.tencent.mm.plugin.finder.live.model.d)localObject1).CDQ);
        if (((com.tencent.mm.plugin.finder.live.model.d)localObject1).CDP == 2) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d.c((com.tencent.mm.plugin.finder.live.model.d)localObject1));
        }
      }
      else
      {
        label692:
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.i)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.i.class)).reset();
      }
    }
    else
    {
      localObject1 = aj.CGT;
      if ((!aj.bUB()) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eet)) {
        break label823;
      }
      Log.i(this.TAG, "checkLayerShowInfo: it's externalPost");
    }
    for (;;)
    {
      parama = ah.aiuX;
      break label510;
      label746:
      break;
      ((com.tencent.mm.plugin.finder.live.model.d)localObject1).reset();
      localObject1 = aj.CGT;
      localObject1 = aj.elM();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).mRB;
        if ((localObject1 == null) || (((com.tencent.mm.live.core.core.model.i)localObject1).pause != true)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label821;
        }
        localObject1 = aj.CGT;
        localObject1 = aj.elM();
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.a.b)localObject1).bff();
        break;
      }
      label821:
      break label692;
      label823:
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (com.tencent.mm.plugin.finder.live.utils.a.bUC())
      {
        if (((bix)localObject2).show_type == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eep) {
          ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Eeo = ((bix)localObject2).ZSF;
        }
      }
      else {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).a((bix)localObject2, false, (m)new g.a(parama));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.g
 * JD-Core Version:    0.7.0.1
 */