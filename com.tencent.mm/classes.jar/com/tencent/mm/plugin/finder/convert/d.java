package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.view.recyclerview.b<h>
{
  public static final a qqw;
  private final CommentDrawerContract.NPresenter qqh;
  
  static
  {
    AppMethodBeat.i(178121);
    qqw = new a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public d(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.qqh = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private final void a(View paramView, final String paramString, final h paramh, final boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(2131304784)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(2131304781);
    d.g.b.k.g(paramString, "arrowIv");
    paramString.setVisibility(0);
    final View localView = paramView.findViewById(2131304783);
    d.g.b.k.g(localView, "loadingView");
    localView.setVisibility(8);
    paramView.setOnClickListener((View.OnClickListener)new b(this, paramString, localView, paramh, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private final boolean clb()
  {
    AppMethodBeat.i(178117);
    if (this.qqh.clT() == 2)
    {
      AppMethodBeat.o(178117);
      return true;
    }
    AppMethodBeat.o(178117);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    AppMethodBeat.i(178116);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)parame.abq(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lk(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new j(parame));
    AppMethodBeat.o(178116);
  }
  
  public final int getLayoutId()
  {
    return 2131492865;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, View paramView1, View paramView2, h paramh, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178107);
      paramView = paramString;
      d.g.b.k.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = localView;
      d.g.b.k.g(paramView, "loadingView");
      paramView.setVisibility(0);
      d.a(this.qqx).a(paramh, paramBoolean);
      AppMethodBeat.o(178107);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178108);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramView = this.qqk.qDA.getUsername();
      Object localObject = this.nGG.getContext();
      d.g.b.k.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.Ljl;
      paramView = this.nGG.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(1, this.qqk.qDA.field_feedId, paramView.qqE, 2, this.qqk.qDA.getUsername());
        AppMethodBeat.o(178108);
        return;
      }
      AppMethodBeat.o(178108);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178109);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramView = this.qqk.qDA.getUsername();
      Object localObject = this.nGG.getContext();
      d.g.b.k.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.Ljl;
      paramView = this.nGG.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(1, this.qqk.qDA.field_feedId, paramView.qqE, 2, this.qqk.qDA.getUsername());
        AppMethodBeat.o(178109);
        return;
      }
      AppMethodBeat.o(178109);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(d paramd, h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178110);
      paramView = a.qpY;
      paramView = this.qqk.qDA.getUsername();
      h localh = this.qqk;
      Context localContext = this.nGG.getContext();
      d.g.b.k.g(localContext, "holder.context");
      a.a(paramView, localh, localContext, d.a(this.qqx).getCommentScene());
      AppMethodBeat.o(178110);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(d paramd, h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178111);
      paramView = a.qpY;
      paramView = this.qqk.qDA.getUsername();
      h localh = this.qqk;
      Context localContext = this.nGG.getContext();
      d.g.b.k.g(localContext, "holder.context");
      a.a(paramView, localh, localContext, d.a(this.qqx).getCommentScene());
      AppMethodBeat.o(178111);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "username", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    g(d paramd, h paramh, e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(d paramd, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178113);
      paramView = d.a(this.qqx);
      TextView localTextView = this.qqm;
      d.g.b.k.g(localTextView, "commentFailTV");
      paramView.ae((View)localTextView, this.nGG.ln());
      AppMethodBeat.o(178113);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d
 * JD-Core Version:    0.7.0.1
 */