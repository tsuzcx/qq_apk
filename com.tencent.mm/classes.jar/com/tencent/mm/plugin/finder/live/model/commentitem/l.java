package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.r;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLevelUpgrade;", "Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSysInfo;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindGlobalLevelUpMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends w
{
  private final String TAG;
  
  public l(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359949);
    this.TAG = "CommentItemLevelUpgrade";
    AppMethodBeat.o(359949);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359970);
    s.u(parambdm, "msg");
    parambdm = (aq)new r(parambdm);
    AppMethodBeat.o(359970);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359990);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    Object localObject1 = paramaq.ekF();
    if (((localObject1 instanceof beh)) && (((beh)localObject1).type == 1) && (((beh)localObject1).ZOO > 0))
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label141;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label147;
      }
      paramContext = null;
      if (paramContext == null)
      {
        localObject1 = ((l)this).TAG;
        paramaq = paramaq.ekF();
        paramContext = paramaq;
        if (paramaq == null) {
          paramContext = "";
        }
        Log.i((String)localObject1, s.X("invalid GlobalLevelUpgrade:", f.dg(paramContext)));
        parama.caK.setVisibility(8);
      }
      AppMethodBeat.o(359990);
      return;
      paramInt = 0;
      break;
      label141:
      localObject1 = null;
    }
    label147:
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = com.tencent.mm.plugin.finder.live.utils.a.axR(paramaq.djQ());
    paramInt = ((beh)localObject1).ZOO;
    if (bool) {}
    int i;
    TextPaint localTextPaint;
    for (localObject1 = paramContext.getResources().getString(p.h.Cjs, new Object[] { Integer.valueOf(paramInt) });; localObject1 = ((Resources)localObject1).getString(i, new Object[] { h.a.a((com.tencent.mm.plugin.h)localObject2, paramContext, localTextPaint, (CharSequence)com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt())), Integer.valueOf(paramInt) }))
    {
      s.s(localObject1, "if (isMySelf) {\n        …), toLevel)\n            }");
      a(paramContext, parama, (String)localObject1);
      paramContext = ah.aiuX;
      break;
      localObject1 = paramContext.getResources();
      i = p.h.Cjr;
      localObject2 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
      s.s(localObject2, "service(IFinderCommonService::class.java)");
      localObject2 = (com.tencent.mm.plugin.h)localObject2;
      localTextPaint = parama.DQt.getPaint();
      s.s(localTextPaint, "holder.contentTv.paint");
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    }
  }
  
  public final int eiV()
  {
    return 20031;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.l
 * JD-Core Version:    0.7.0.1
 */