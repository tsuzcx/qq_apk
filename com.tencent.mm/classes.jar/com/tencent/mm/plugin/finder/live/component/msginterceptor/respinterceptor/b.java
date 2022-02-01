package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.model.g;
import com.tencent.mm.live.model.p;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.util.u;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgExtFlagInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "anchorAliveExpiredByLiveExtFlag", "", "value", "", "checkAnchorAlive", "", "curLiveData", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveMsgResp;", "checkGiftEnable", "checkLinkMicEnable", "checkLiveExtFlag", "enableGiftByLiveExtFlag", "enableLinkMicByLiveExtFlag", "intercept", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.live.component.msginterceptor.e
{
  private final a CBK;
  private final String TAG;
  
  public b(a parama)
  {
    AppMethodBeat.i(353229);
    this.CBK = parama;
    this.TAG = "LiveMsgExtFlagInterceptor";
    AppMethodBeat.o(353229);
  }
  
  private static boolean OJ(int paramInt)
  {
    AppMethodBeat.i(353235);
    if ((paramInt != -1) && (d.ee(paramInt, 1)))
    {
      AppMethodBeat.o(353235);
      return true;
    }
    AppMethodBeat.o(353235);
    return false;
  }
  
  public final boolean a(a.a parama)
  {
    AppMethodBeat.i(353257);
    s.u(parama, "respWrapper");
    parama = parama.CBm;
    a locala;
    Object localObject;
    if (parama != null)
    {
      locala = this.CBK;
      if ((locala != null) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK != parama.ZJS))
      {
        localObject = new StringBuilder("[heartbeat] checkAnchorAlive isAnchor:");
        aj localaj = aj.CGT;
        localObject = ((StringBuilder)localObject).append(aj.bUB()).append(" localLiveExtFlag:").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK).append(" liveExtFlag:").append(parama.ZJS).append(", filterAnchorExtFlag:");
        localaj = aj.CGT;
        Log.i("Finder.FinderLiveService", aj.elx());
        localObject = aj.CGT;
        if (!aj.elx())
        {
          localObject = aj.CGT;
          if (!aj.bUB())
          {
            if ((OJ(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK)) || (!OJ(parama.ZJS))) {
              break label821;
            }
            Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive anchor alive expired:true");
            localObject = p.mZf;
            localObject = p.bhS();
            if (localObject != null) {
              ((g)localObject).onAnchorConnectionChange(false);
            }
          }
        }
        localObject = new StringBuilder("[heartbeat] checkLinkMicEnable isAnchor:");
        localaj = aj.CGT;
        Log.i("Finder.FinderLiveService", aj.bUB() + " localLiveExtFlag:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK + " liveExtFlag:" + parama.ZJS + " localEnableLinkMicFun:" + ((j)locala.business(j.class)).EfD + " localEnableLinkMic:" + ((j)locala.business(j.class)).eyW() + " localEnableLinkMicAntispam:" + ((j)locala.business(j.class)).EfE);
        localObject = aj.CGT;
        if (!aj.bUB()) {
          break label897;
        }
        if (d.ee(parama.ZJS, 4)) {
          break label881;
        }
        Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
        ((j)locala.business(j.class)).EfE = false;
        ((j)locala.business(j.class)).EfB = 0;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp &= 0xFFFFFFBF;
        localObject = u.DJC;
        u.ey("checkLinkMicEnable", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
        localObject = aj.CGT;
        localObject = aj.getFinderLiveAssistant();
        if (localObject != null) {
          ap.a.a((ap)localObject, ((f)locala.business(f.class)).liveInfo.liveId, ((f)locala.business(f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 64L, 0, null, 48);
        }
        label488:
        localObject = new StringBuilder("[heartbeat] checkGiftEnable isAnchor:");
        localaj = aj.CGT;
        Log.i("Finder.FinderLiveService", aj.bUB() + " localLiveExtFlag:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK + " liveExtFlag:" + parama.ZJS + " localEnableGiftFun:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv + " localEnableGift:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eyr() + " localEnableGiftAntispam:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edx);
        localObject = aj.CGT;
        if (!aj.bUB()) {
          break label1009;
        }
        if (d.ee(parama.ZJS, 2)) {
          break label993;
        }
        Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edx = false;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edu = 0;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp &= 0xFFFFFF7F;
        localObject = u.DJC;
        u.ey("checkGiftEnable", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
        localObject = aj.CGT;
        localObject = aj.getFinderLiveAssistant();
        if (localObject != null) {
          ap.a.a((ap)localObject, ((f)locala.business(f.class)).liveInfo.liveId, ((f)locala.business(f.class)).hKN, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp, 128L, 0, null, 48);
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edz = d.ee(parama.ZJS, 8);
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK = parama.ZJS;
      AppMethodBeat.o(353257);
      return true;
      label821:
      if ((!OJ(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).EcK)) || (OJ(parama.ZJS))) {
        break;
      }
      Log.i(this.TAG, "[heartbeat] checkAnchorAlive anchor alive expired:false");
      localObject = p.mZf;
      localObject = p.bhS();
      if (localObject == null) {
        break;
      }
      ((g)localObject).onAnchorConnectionChange(true);
      break;
      label881:
      ((j)locala.business(j.class)).EfE = true;
      break label488;
      label897:
      if (d.ee(parama.ZJS, 4)) {
        break label488;
      }
      Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
      ((j)locala.business(j.class)).EfD = false;
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp &= 0xFFFFFFBF;
      ((j)locala.business(j.class)).EfB = 0;
      localObject = u.DJC;
      u.ey("checkLinkMicEnable2", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      break label488;
      label993:
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edx = true;
      continue;
      label1009:
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).DUe) && (!d.ee(parama.ZJS, 2)))
      {
        Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edv = false;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp &= 0xFFFFFF7F;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Edu = 0;
        localObject = u.DJC;
        u.ey("checkGiftEnable", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)locala.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).Ecp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.b
 * JD-Core Version:    0.7.0.1
 */