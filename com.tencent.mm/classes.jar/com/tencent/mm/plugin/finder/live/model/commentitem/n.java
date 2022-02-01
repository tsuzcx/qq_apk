package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.x;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemLocalLocation;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "locationSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getLocationSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "locationSpan$delegate", "Lkotlin/Lazy;", "locationTag", "getLocationTag", "()Ljava/lang/String;", "locationTag$delegate", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "genIFinderLiveMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "msgType", "onBinderLocationMsg", "commentData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final j CLN;
  private final j CLO;
  private final String TAG;
  
  public n(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359891);
    this.CBK = parama;
    this.TAG = "CommentItemLocalLocation";
    this.CLN = k.cm((kotlin.g.a.a)new a(this));
    this.CLO = k.cm((kotlin.g.a.a)n.b.CLQ);
    AppMethodBeat.o(359891);
  }
  
  public final aq a(bke parambke)
  {
    AppMethodBeat.i(359906);
    s.u(parambke, "msg");
    boi localboi = ((e)this.CBK.business(e.class)).location;
    if (localboi == null) {}
    for (parambke = null;; parambke = new x(parambke, localboi))
    {
      parambke = (aq)parambke;
      AppMethodBeat.o(359906);
      return parambke;
    }
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359922);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    if ((paramaq instanceof x)) {
      if (paramaq != null) {
        break label63;
      }
    }
    for (paramContext = null;; paramContext = ah.aiuX)
    {
      if (paramContext == null) {
        Log.i(((n)this).TAG, "[onBinderLocationMsg]  msg is not location");
      }
      AppMethodBeat.o(359922);
      return;
      paramaq = null;
      break;
      label63:
      paramaq = (x)paramaq;
      paramaq = new q(p.b(paramContext, (CharSequence)(paramContext.getString(p.h.Cmc) + ' ' + paramaq.getContent())));
      paramaq.a((f)this.CLN.getValue(), (CharSequence)emV(), 0);
      parama.DQt.aZ((CharSequence)paramaq);
      parama.DQt.setTextSize(ejf());
      parama.DQt.setVisibility(0);
      parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
      parama.DmL.setVisibility(0);
      paramaq = parama.DQt.getParent();
      if (paramaq == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(359922);
        throw paramContext;
      }
      paramaq = (RelativeLayout)paramaq;
      paramaq.setPadding(0, paramaq.getPaddingTop(), paramaq.getPaddingRight(), paramaq.getPaddingBottom());
      parama.DQt.setMaxLines(1);
      parama.DQt.setEllipsize(TextUtils.TruncateAt.END);
      parama.DQt.setTag(p.e.BEo, paramContext.getString(p.h.Cmc));
    }
  }
  
  public final int eiV()
  {
    return 10018;
  }
  
  final String emV()
  {
    AppMethodBeat.i(359898);
    String str = (String)this.CLO.getValue();
    AppMethodBeat.o(359898);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<f>
  {
    a(n paramn)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.n
 * JD-Core Version:    0.7.0.1
 */