package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.f;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;)V", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "checkPostOk", "", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLayoutId", "", "handleLinkTvOnClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "link", "", "handlePoiOnClick", "poiText", "isNewsObject", "isSelfScene", "context", "Landroid/content/Context;", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAvatar", "refreshContentTime", "refreshDescContent", "refreshLink", "refreshLoadingLayout", "refreshNickName", "refreshPoi", "Companion", "plugin-finder_release"})
public final class j
  extends e<t>
{
  public static final a tzG;
  final f tzF;
  
  static
  {
    AppMethodBeat.i(242807);
    tzG = new a((byte)0);
    AppMethodBeat.o(242807);
  }
  
  public j(f paramf)
  {
    AppMethodBeat.i(242806);
    this.tzF = paramf;
    AppMethodBeat.o(242806);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
  {
    AppMethodBeat.i(242804);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)paramh.Mn(2131308992);
    paramRecyclerView.getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.h(paramRecyclerView.getContentTextView(), (View.OnTouchListener)new o(paramh.getContext())));
    NeatTextView localNeatTextView = paramRecyclerView.getContentTextView();
    paramh = paramh.getContext();
    p.g(paramh, "holder.context");
    localNeatTextView.setTextColor(paramh.getResources().getColor(2131099669));
    paramRecyclerView.setLimitLine(10);
    AppMethodBeat.o(242804);
  }
  
  public final int getLayoutId()
  {
    return 2131492864;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(t paramt, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242794);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = new Intent();
      paramView.putExtra("finder_username", this.tzI.tHo.getUserName());
      paramView.putExtra("finder_read_feed_id", this.tzI.tHo.getId());
      localObject = FinderReporterUIC.wzC;
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      FinderReporterUIC.a.a((Context)localObject, paramView, this.tzI.tHo.field_id, 1, false, 64);
      localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshAvatar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242794);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isCollapse", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    e(j paramj, t paramt, com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$1"})
  static final class f
    implements Runnable
  {
    f(TextView paramTextView, String paramString, j paramj, com.tencent.mm.view.recyclerview.h paramh, View paramView, t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(242798);
      Object localObject = this.tzN;
      p.g(localObject, "linkLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
        localObject = this.tzL;
        p.g(localObject, "linkTv");
        if (((TextView)localObject).getPaint().measureText(this.tzM) + j > i)
        {
          localObject = this.tzL;
          p.g(localObject, "linkTv");
          CharSequence localCharSequence = (CharSequence)this.tzM;
          TextView localTextView = this.tzL;
          p.g(localTextView, "linkTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(242798);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$2"})
  static final class g
    implements View.OnClickListener
  {
    g(String paramString, j paramj, com.tencent.mm.view.recyclerview.h paramh, View paramView, t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242799);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      j.a(this.tzq, this.tzO.tHo, this.nNF);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242799);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(j paramj, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void run()
    {
      AppMethodBeat.i(242800);
      Object localObject = this.tzK.tzF.tMP;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.view.builder.b)localObject).getLoadingLayout();
        if (localObject != null)
        {
          int i = ((FrameLayout)localObject).getPaddingLeft();
          View localView = this.qhp.aus;
          p.g(localView, "holder.itemView");
          ((FrameLayout)localObject).setPadding(i, localView.getHeight(), ((FrameLayout)localObject).getPaddingRight(), ((FrameLayout)localObject).getPaddingBottom());
          AppMethodBeat.o(242800);
          return;
        }
      }
      AppMethodBeat.o(242800);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$1"})
  static final class j
    implements Runnable
  {
    j(View paramView, TextView paramTextView, String paramString, j paramj, com.tencent.mm.view.recyclerview.h paramh, t paramt) {}
    
    public final void run()
    {
      AppMethodBeat.i(242802);
      Object localObject = this.tzP;
      p.g(localObject, "positionLayout");
      int i = ((View)localObject).getWidth();
      if (i > 0)
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(this.tzq.getContext(), 20);
        localObject = this.tzQ;
        p.g(localObject, "poiTv");
        if (((TextView)localObject).getPaint().measureText(this.tzR) + j > i)
        {
          localObject = this.tzQ;
          p.g(localObject, "poiTv");
          CharSequence localCharSequence = (CharSequence)this.tzR;
          TextView localTextView = this.tzQ;
          p.g(localTextView, "poiTv");
          ((TextView)localObject).setText(TextUtils.ellipsize(localCharSequence, localTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
        }
      }
      AppMethodBeat.o(242802);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$1$2"})
  static final class k
    implements View.OnClickListener
  {
    k(String paramString, j paramj, com.tencent.mm.view.recyclerview.h paramh, t paramt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242803);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      j.b(this.tzq, this.tzO.tHo, this.tzR);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshPoi$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242803);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.j
 * JD-Core Version:    0.7.0.1
 */