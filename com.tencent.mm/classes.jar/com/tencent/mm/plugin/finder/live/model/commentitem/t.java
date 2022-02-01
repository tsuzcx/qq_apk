package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemRewardRankingNotice;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "rankNoticeImageSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getRankNoticeImageSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "rankNoticeImageSpan$delegate", "Lkotlin/Lazy;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "msgType", "onBindRewardRankNoticeMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final j CMf;
  private final String TAG;
  
  public t(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359911);
    this.CBK = parama;
    this.TAG = "CommentItemRewardRankingNotice";
    this.CMf = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(359911);
  }
  
  public final aq a(bdm parambdm)
  {
    AppMethodBeat.i(359925);
    s.u(parambdm, "msg");
    parambdm = (aq)new ah(parambdm);
    AppMethodBeat.o(359925);
    return parambdm;
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359936);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    Object localObject = paramaq.ekF();
    if (!(localObject instanceof bet))
    {
      Log.e(this.TAG, "onBindRewardRankNoticeMsg payloadContent isn't FinderLiveAppMsgRewardRankingNoticeInfo");
      AppMethodBeat.o(359936);
      return;
    }
    paramInt = ((bet)localObject).ZPc;
    Log.e(this.TAG, s.X("onBindRewardRankNoticeMsg ranking_position ", Integer.valueOf(paramInt)));
    if (paramInt <= 0)
    {
      AppMethodBeat.o(359936);
      return;
    }
    localObject = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    s.s(localObject, "service(IFinderCommonService::class.java)");
    localObject = (com.tencent.mm.plugin.h)localObject;
    TextPaint localTextPaint = parama.DQt.getPaint();
    s.s(localTextPaint, "holder.contentTv.paint");
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    paramaq = h.a.a((com.tencent.mm.plugin.h)localObject, paramContext, localTextPaint, (CharSequence)com.tencent.mm.plugin.finder.live.utils.a.hR(paramaq.djQ(), paramaq.ekt()));
    localObject = paramContext.getString(p.h.CoC, new Object[] { Integer.valueOf(paramInt) });
    s.s(localObject, "context.getString(R.stri…rd_rank_content, rankPos)");
    paramaq = new q(p.b(paramContext, (CharSequence)paramContext.getString(p.h.Civ, new Object[] { paramaq + ' ' + (String)localObject })));
    paramaq.a((f)this.CMf.getValue(), (CharSequence)ejd(), 0);
    localObject = parama.DQt.getParent();
    if (localObject == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(359936);
      throw paramContext;
    }
    localObject = (RelativeLayout)localObject;
    ((RelativeLayout)localObject).setPadding(0, ((RelativeLayout)localObject).getPaddingTop(), ((RelativeLayout)localObject).getPaddingRight(), ((RelativeLayout)localObject).getPaddingBottom());
    parama.DQt.aZ((CharSequence)paramaq);
    parama.DQt.setTextSize(ejf());
    parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
    AppMethodBeat.o(359936);
  }
  
  public final int eiV()
  {
    return 20014;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<f>
  {
    a(t paramt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.t
 * JD-Core Version:    0.7.0.1
 */