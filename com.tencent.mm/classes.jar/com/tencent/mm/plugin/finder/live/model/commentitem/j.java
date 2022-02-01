package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.model.w;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemGameJump;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "TAG", "", "jumpFineGameSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getJumpFineGameSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "jumpFineGameSpan$delegate", "Lkotlin/Lazy;", "jumpFineGameTag", "getJumpFineGameTag", "()Ljava/lang/String;", "jumpFineGameTag$delegate", "jumpWxaGameSpan", "getJumpWxaGameSpan", "jumpWxaGameSpan$delegate", "jumpWxaGameTag", "getJumpWxaGameTag", "jumpWxaGameTag$delegate", "getLiveContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "msgType", "onBinderGameLiveJumpMsg", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends b
{
  private final com.tencent.mm.plugin.finder.live.model.context.a CBK;
  private final kotlin.j CLG;
  private final kotlin.j CLH;
  private final kotlin.j CLI;
  private final kotlin.j CLJ;
  private final String TAG;
  
  public j(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
    AppMethodBeat.i(359945);
    this.CBK = parama;
    this.TAG = "CommentItemGameJump";
    this.CLG = k.cm((kotlin.g.a.a)b.CLL);
    this.CLH = k.cm((kotlin.g.a.a)d.CLM);
    this.CLI = k.cm((kotlin.g.a.a)new a(this));
    this.CLJ = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(359945);
  }
  
  public final void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    AppMethodBeat.i(359978);
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    if ((paramaq instanceof w))
    {
      switch (((w)paramaq).CGt.aakj)
      {
      default: 
        Log.e(this.TAG, "onBinderGameLiveJumpMsg failed,wrong type");
        AppMethodBeat.o(359978);
        return;
      case 1: 
        paramaq = (CharSequence)new q(p.b(paramContext, (CharSequence)(paramContext.getString(p.h.Clc) + ' ' + paramaq.getContent())));
        ((q)paramaq).a((f)this.CLI.getValue(), (CharSequence)emT(), 0);
      }
      for (;;)
      {
        parama.DQt.aZ(paramaq);
        parama.DQt.setTextSize(ejf());
        parama.DQt.setVisibility(0);
        parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
        parama.DmL.setVisibility(0);
        paramContext = parama.DQt.getParent();
        if (paramContext != null) {
          break;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
        AppMethodBeat.o(359978);
        throw paramContext;
        paramaq = (CharSequence)new q(p.b(paramContext, (CharSequence)(paramContext.getString(p.h.Clf) + ' ' + paramaq.getContent())));
        ((q)paramaq).a((f)this.CLJ.getValue(), (CharSequence)emU(), 0);
      }
      paramContext = (RelativeLayout)paramContext;
      paramContext.setPadding(0, paramContext.getPaddingTop(), paramContext.getPaddingRight(), paramContext.getPaddingBottom());
      parama.DQt.setMaxLines(1);
      parama.DQt.setEllipsize(TextUtils.TruncateAt.END);
      AppMethodBeat.o(359978);
      return;
    }
    Log.i(this.TAG, "#onBinderGameLiveJumpMsg msg is not an gameJump info");
    AppMethodBeat.o(359978);
  }
  
  public final int eiV()
  {
    return 20040;
  }
  
  final String emT()
  {
    AppMethodBeat.i(359952);
    String str = (String)this.CLG.getValue();
    AppMethodBeat.o(359952);
    return str;
  }
  
  final String emU()
  {
    AppMethodBeat.i(359959);
    String str = (String)this.CLH.getValue();
    AppMethodBeat.o(359959);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<f>
  {
    a(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final b CLL;
    
    static
    {
      AppMethodBeat.i(359864);
      CLL = new b();
      AppMethodBeat.o(359864);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<f>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final d CLM;
    
    static
    {
      AppMethodBeat.i(359873);
      CLM = new d();
      AppMethodBeat.o(359873);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.j
 * JD-Core Version:    0.7.0.1
 */