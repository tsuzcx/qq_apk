package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.ac;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemOfficialAccount;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "officialAccountSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getOfficialAccountSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "officialAccountSpan$delegate", "Lkotlin/Lazy;", "officialAccountTag", "getOfficialAccountTag", "()Ljava/lang/String;", "officialAccountTag$delegate", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "msgType", "onBinderOfficialAccountMsg", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final kotlin.j CLX;
  private final kotlin.j CLY;
  private final String TAG;
  
  public p(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359882);
    this.CBK = parama;
    this.TAG = "CommentItemOfficialAccount";
    this.CLX = k.cm((kotlin.g.a.a)p.b.CMa);
    this.CLY = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(359882);
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359905);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    if ((paramaq instanceof ac))
    {
      paramaq = new q(com.tencent.mm.pluginsdk.ui.span.p.b(paramContext, (CharSequence)(paramContext.getString(p.h.Cpf) + ' ' + paramaq.getContent())));
      paramaq.a((f)this.CLY.getValue(), (CharSequence)emW(), 0);
      parama.DQt.aZ((CharSequence)paramaq);
      parama.DQt.setTextSize(ejf());
      parama.DQt.setVisibility(0);
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      parama.DmL.setVisibility(0);
      paramaq = parama.DQt.getParent();
      if (paramaq == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(359905);
        throw paramContext;
      }
      paramaq = (RelativeLayout)paramaq;
      paramaq.setPadding(0, paramaq.getPaddingTop(), paramaq.getPaddingRight(), paramaq.getPaddingBottom());
      parama.DQt.setMaxLines(1);
      parama.DQt.setEllipsize(TextUtils.TruncateAt.END);
      ce.a.a((ce)com.tencent.mm.plugin.finder.live.report.j.Dob, q.t.DvL);
      parama.DQt.setTag(p.e.BEo, paramContext.getString(p.h.Cpf));
      AppMethodBeat.o(359905);
      return;
    }
    Log.i(this.TAG, "#onBinderOfficialAccountMsg msg is not an official account");
    AppMethodBeat.o(359905);
  }
  
  public final int eiV()
  {
    return 10019;
  }
  
  final String emW()
  {
    AppMethodBeat.i(359889);
    String str = (String)this.CLX.getValue();
    AppMethodBeat.o(359889);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<f>
  {
    a(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.p
 * JD-Core Version:    0.7.0.1
 */