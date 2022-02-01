package com.tencent.mm.plugin.finder.live.model.commentitem;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan.Standard;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.finder.live.component.msginterceptor.b;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.k.a;
import com.tencent.mm.plugin.finder.live.view.span.f;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pluginsdk.ui.span.q;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.MMNeat7extView;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/commentitem/CommentItemSysInfo;", "Lcom/tencent/mm/plugin/finder/live/component/msginterceptor/FinderLiveCommentItem;", "liveContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "sysAnnoucementImageSpan", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "getSysAnnoucementImageSpan", "()Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;", "sysAnnoucementImageSpan$delegate", "Lkotlin/Lazy;", "fillItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter$LiveCommentItemHolder;", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "msgPosition", "", "onBindSysMsg", "userMessage", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpannableString;", "sysMsg", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class w
  extends b
{
  private final j CMi = k.cm((kotlin.g.a.a)new a(this));
  
  public w(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    super(parama);
  }
  
  private static final void a(k.a parama, ah.f paramf, q paramq)
  {
    s.u(parama, "$holder");
    s.u(paramf, "$parent");
    s.u(paramq, "$userMessage");
    if (parama.DQt.getLineCount() > 1)
    {
      ((RelativeLayout)paramf.aqH).setPadding(0, ((RelativeLayout)paramf.aqH).getPaddingTop(), 0, ((RelativeLayout)paramf.aqH).getPaddingBottom());
      parama.DQt.setSpacingAdd(5);
      paramf = SpannableStringBuilder.valueOf((CharSequence)paramq);
      paramf.setSpan(new LeadingMarginSpan.Standard(0, bd.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, paramq.length(), 33);
      parama.DQt.aZ((CharSequence)paramf);
      return;
    }
    ((RelativeLayout)paramf.aqH).setPadding(0, ((RelativeLayout)paramf.aqH).getPaddingTop(), ((RelativeLayout)paramf.aqH).getPaddingRight(), ((RelativeLayout)paramf.aqH).getPaddingBottom());
  }
  
  public void a(Context paramContext, k.a parama, aq paramaq, int paramInt)
  {
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramaq, "msg");
    a(paramContext, parama, paramaq.getContent());
  }
  
  public final void a(Context paramContext, k.a parama, q paramq)
  {
    s.u(paramContext, "context");
    s.u(parama, "holder");
    s.u(paramq, "userMessage");
    ah.f localf = new ah.f();
    ViewParent localViewParent = parama.DQt.getParent();
    if (localViewParent == null) {
      throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }
    localf.aqH = ((RelativeLayout)localViewParent);
    parama.DQt.aZ((CharSequence)paramq);
    parama.DQt.setTextSize(ejf());
    parama.DQt.post(new w..ExternalSyntheticLambda0(parama, localf, paramq));
    parama.AhP.setBackground(paramContext.getResources().getDrawable(p.d.finder_live_comment_bg));
    parama.DQt.setTag(p.e.BEo, ejd());
  }
  
  public final void a(Context paramContext, k.a parama, String paramString)
  {
    s.u(paramContext, "context");
    s.u(parama, "holder");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    paramString = new q(p.b(paramContext, (CharSequence)paramContext.getString(p.h.Civ, new Object[] { paramString })));
    paramString.a(emX(), (CharSequence)ejd(), 0);
    a(paramContext, parama, paramString);
  }
  
  public final f emX()
  {
    return (f)this.CMi.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/view/span/FinderLiveRoundImageSpan;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<f>
  {
    a(w paramw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.commentitem.w
 * JD-Core Version:    0.7.0.1
 */