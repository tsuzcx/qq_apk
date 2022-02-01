package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.u;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemJoinFansClub;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSysInfo;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindJoinFansClubMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends w
{
  private final com.tencent.mm.plugin.finder.live.model.context.a buContext;
  
  public k(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359941);
    this.buContext = parama;
    AppMethodBeat.o(359941);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359955);
    s.u(parambdm, "msg");
    parambdm = (aq)new u(parambdm);
    AppMethodBeat.o(359955);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359972);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    Object localObject1;
    if ((paramaq instanceof u))
    {
      localObject1 = paramaq.ekF();
      if ((localObject1 instanceof bej))
      {
        localObject1 = (bej)localObject1;
        if (localObject1 != null) {
          break label218;
        }
        localObject1 = null;
      }
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt());
      localObject1 = paramContext.getString(p.h.Clb, new Object[] { localObject1 });
      s.s(localObject1, "context.getString(R.stri…_fans_club_msg, giftName)");
      localObject1 = s.X((String)localObject2, localObject1);
      localObject2 = new q(paramContext.getString(p.h.Civ, new Object[] { localObject1 }));
      ((q)localObject2).a(emX(), (CharSequence)ejd(), 0);
      a(paramContext, parama, (q)localObject2);
      Log.i("CommentItemJoinFansClub", "onBindJoinFansClubMsg:" + (paramaq instanceof u) + ",sysMsg:" + (String)localObject1 + ',');
      AppMethodBeat.o(359972);
      return;
      localObject1 = null;
      break;
      label218:
      localObject1 = ((bej)localObject1).ZOR;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((bim)localObject1).name;
        continue;
        localObject1 = MMApplicationContext.getContext().getResources().getString(p.h.Coy);
      }
    }
  }
  
  public final int eiV()
  {
    return 20050;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.k
 * JD-Core Version:    0.7.0.1
 */