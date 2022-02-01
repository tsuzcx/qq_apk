package com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.e;
import com.tencent.mm.plugin.finder.live.model.ab;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.w.a.a.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/respinterceptor/LiveMsgRespMiniGameInterceptor;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/IAfterCheckInterceptor;", "()V", "intercept", "", "respWrapper", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderGetLiveMsgCgiResp$FinderGetLiveMsgRespWrapper;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends e
{
  public final boolean a(com.tencent.mm.plugin.finder.live.component.msginterceptor.a.a parama)
  {
    AppMethodBeat.i(353226);
    s.u(parama, "respWrapper");
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject4 = parama.CBm;
      if (localObject4 != null)
      {
        localObject1 = aj.CGT;
        n localn = aj.ell();
        s.u(localObject4, "resp");
        localObject1 = localn.CFv;
        s.s(localObject1, "externalLiveCallbacks");
        for (;;)
        {
          synchronized ((Iterable)localObject1)
          {
            Iterator localIterator = ???.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            com.tencent.d.a.a.a.a locala = (com.tencent.d.a.a.a.a)localIterator.next();
            localObject1 = ab.CGy;
            localObject1 = ((azp)localObject4).PmC;
            if (localObject1 == null)
            {
              localObject1 = new LinkedList();
              localObject3 = ((azp)localObject4).ZJV;
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = new LinkedList();
              }
              localObject1 = ab.f((LinkedList)localObject1, (LinkedList)localObject2);
              Log.i(n.TAG, "onLiveInfoChanged curLikeCount:" + ((azp)localObject4).ZJZ + " participantCount:" + ((azp)localObject4).ZJU);
              if (localn.CFz.size() != 0)
              {
                ((ArrayList)localObject1).addAll((Collection)localn.CFz);
                localn.CFz.clear();
              }
              localObject1 = (List)localObject1;
              localObject2 = new dld();
              ((dld)localObject2).DFW = ((azp)localObject4).ZJZ;
              ((dld)localObject2).aaQY = ((azp)localObject4).ZJU;
              ((dld)localObject2).startTime = localn.CFw.startTime;
              ((dld)localObject2).liveId = localn.CFw.liveId;
              ((dld)localObject2).aaQZ = ((azp)localObject4).ZJN;
              localObject3 = ((azp)localObject4).liveInfo;
              if (localObject3 != null) {
                break label367;
              }
              l = 0L;
              ((dld)localObject2).aaRa = l;
              localObject3 = ah.aiuX;
              locala.a((List)localObject1, (dld)localObject2);
            }
          }
          continue;
          label367:
          long l = ((bip)localObject3).ZKy;
        }
        localObject1 = ah.aiuX;
      }
    }
    parama = parama.CBm;
    if (parama != null)
    {
      parama = parama.liveInfo;
      if (parama != null)
      {
        parama = parama.ZRO;
        if (parama != null)
        {
          localObject2 = parama.ZQg;
          if (localObject2 != null)
          {
            parama = aj.CGT;
            localObject1 = aj.ell();
            s.u(localObject2, "bs");
            parama = (com.tencent.mm.bx.a)new dih();
            localObject2 = ((b)localObject2).Op;
          }
        }
      }
    }
    try
    {
      parama.parseFrom((byte[])localObject2);
      localObject2 = (dih)parama;
      localObject3 = n.TAG;
      localObject4 = new StringBuilder("anchorStatusFlag:");
      if (localObject2 == null)
      {
        parama = null;
        Log.i((String)localObject3, parama + ' ');
        if ((localObject2 != null) && (((dih)localObject2).aaNi != null))
        {
          parama = ((dih)localObject2).aaNi;
          if (parama != null) {
            break label766;
          }
          parama = null;
          if (parama != null) {
            break label777;
          }
          i = ((n)localObject1).CFy.ZQz;
          int j = ((n)localObject1).CFy.ZQz;
          if (j != i) {
            ((n)localObject1).CFy.ZQz = i;
          }
          parama = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) && ((j == 1) || (j == 0) || (i == 1) || (i == 0)))
          {
            localObject2 = n.TAG;
            parama = ((n)localObject1).CFy;
            if (parama != null) {
              break label785;
            }
            parama = null;
            Log.i((String)localObject2, s.X("appendMiniGameTeamModeTipForExternal:", parama));
            parama = ((n)localObject1).CFy;
            if ((parama == null) || (parama.ZQz != 0)) {
              break label796;
            }
            i = 1;
            if (i == 0)
            {
              localObject2 = new dle();
              ((dle)localObject2).msgType = com.tencent.d.a.a.a.a.a.ahiF.ordinal();
              if (((n)localObject1).CFy.ZQz != 1) {
                break label801;
              }
              parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_off_for_appbrand);
              ((dle)localObject2).content = parama;
              s.u(localObject2, "msg");
              ((n)localObject1).CFz.add(localObject2);
            }
          }
        }
        AppMethodBeat.o(353226);
        return true;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { parama });
        parama = null;
        continue;
        parama = Long.valueOf(((dih)localObject2).aaNh);
        continue;
        label766:
        parama = Integer.valueOf(parama.aakL);
        continue;
        label777:
        int i = parama.intValue();
        continue;
        label785:
        parama = Integer.valueOf(parama.ZQz);
        continue;
        label796:
        i = 0;
        continue;
        label801:
        parama = MMApplicationContext.getContext().getResources().getString(a.i.finder_game_live_team_join_on_for_appbrand);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.msginterceptor.respinterceptor.i
 * JD-Core Version:    0.7.0.1
 */