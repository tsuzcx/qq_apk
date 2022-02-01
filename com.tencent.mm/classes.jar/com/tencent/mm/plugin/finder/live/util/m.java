package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.HandOffFinderLive;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/FinderLiveHandOffUtil;", "", "()V", "TAG", "", "currentHandOff", "Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;", "getCurrentHandOff", "()Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;", "setCurrentHandOff", "(Lcom/tencent/mm/plugin/handoff/model/HandOffFinderLive;)V", "addOrUpdateHandOff", "", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "canHandOffOpen", "", "checkCurrentHandOff", "newHandOff", "delHandOff", "openHandOff", "showSucToast", "context", "Landroid/content/Context;", "toHandOffFinderLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m DJb;
  private static HandOffFinderLive DJc;
  
  static
  {
    AppMethodBeat.i(351364);
    DJb = new m();
    AppMethodBeat.o(351364);
  }
  
  private static void a(HandOffFinderLive paramHandOffFinderLive)
  {
    AppMethodBeat.i(351345);
    if (paramHandOffFinderLive == null)
    {
      paramHandOffFinderLive = null;
      localObject = DJc;
      if (localObject != null) {
        break label43;
      }
    }
    label43:
    for (Object localObject = null;; localObject = ((HandOffFinderLive)localObject).getKey())
    {
      if (!s.p(paramHandOffFinderLive, localObject)) {
        break label51;
      }
      AppMethodBeat.o(351345);
      return;
      paramHandOffFinderLive = paramHandOffFinderLive.getKey();
      break;
    }
    label51:
    paramHandOffFinderLive = DJc;
    if (paramHandOffFinderLive != null)
    {
      Log.i("MicroMsg.FinderLiveHandOffUtil", s.X("delete previous handoff: ", paramHandOffFinderLive));
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).del(paramHandOffFinderLive.getKey());
    }
    DJc = null;
    AppMethodBeat.o(351345);
  }
  
  public static void eK(Context paramContext)
  {
    AppMethodBeat.i(351337);
    s.u(paramContext, "context");
    aa.y(paramContext, com.tencent.mm.cd.a.bt(paramContext, p.h.Coi), p.g.icons_outlined_colorful_handoff_success);
    AppMethodBeat.o(351337);
  }
  
  public static boolean euv()
  {
    AppMethodBeat.i(351330);
    q localq = (q)h.ax(q.class);
    if (localq == null)
    {
      AppMethodBeat.o(351330);
      return false;
    }
    if (!localq.bLQ())
    {
      Log.i("MicroMsg.FinderLiveHandOffUtil", "not wxOnline");
      AppMethodBeat.o(351330);
      return false;
    }
    if ((localq.bLN() == 1) || (localq.bLN() == 2))
    {
      Log.i("MicroMsg.FinderLiveHandOffUtil", "online type:" + localq.bLN() + " version:" + localq.bLP());
      if (localq.bLN() == 1) {}
      for (int i = 1661142272; BuildInfo.DEBUG; i = 318898176)
      {
        AppMethodBeat.o(351330);
        return true;
      }
      if (localq.bLP() < i)
      {
        AppMethodBeat.o(351330);
        return false;
      }
      Log.i("MicroMsg.FinderLiveHandOffUtil", "check pass, can show handoff");
      AppMethodBeat.o(351330);
      return true;
    }
    Log.i("MicroMsg.FinderLiveHandOffUtil", s.X("not pc/mac icon type ", Integer.valueOf(localq.bLN())));
    AppMethodBeat.o(351330);
    return false;
  }
  
  public static void k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351306);
    HandOffFinderLive localHandOffFinderLive = m(parama);
    if (localHandOffFinderLive != null)
    {
      a(localHandOffFinderLive);
      parama = DJc;
      if (parama == null) {}
      for (parama = null; s.p(parama, localHandOffFinderLive.getKey()); parama = parama.getKey())
      {
        AppMethodBeat.o(351306);
        return;
      }
      Log.i("MicroMsg.FinderLiveHandOffUtil", s.X("addOrUpdateHandOff ", localHandOffFinderLive));
      DJc = localHandOffFinderLive;
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e((HandOff)localHandOffFinderLive);
    }
    AppMethodBeat.o(351306);
  }
  
  public static void l(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351318);
    parama = m(parama);
    if (parama != null)
    {
      Log.i("MicroMsg.FinderLiveHandOffUtil", s.X("delHandOff ", parama));
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).del(parama.getKey());
    }
    a(null);
    AppMethodBeat.o(351318);
  }
  
  public static HandOffFinderLive m(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(351357);
    if (parama == null)
    {
      Log.e("MicroMsg.FinderLiveHandOffUtil", "liveContext is null");
      AppMethodBeat.o(351357);
      return null;
    }
    Object localObject = d.AwY;
    localObject = d.a.auT(((e)parama.business(e.class)).mIC);
    if (localObject == null)
    {
      Log.e("MicroMsg.FinderLiveHandOffUtil", s.X("contact is null username: ", ((e)parama.business(e.class)).mIC));
      AppMethodBeat.o(351357);
      return null;
    }
    parama = (f)parama.business(f.class);
    parama = new HandOffFinderLive(((com.tencent.mm.plugin.finder.api.m)localObject).getNickname(), ((com.tencent.mm.plugin.finder.api.m)localObject).amx(), String.valueOf(parama.hKN), parama.nonceId, String.valueOf(parama.liveInfo.liveId), 0, null, null, null, 480, null);
    AppMethodBeat.o(351357);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.m
 * JD-Core Version:    0.7.0.1
 */