package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class g
  extends com.tencent.mm.view.recyclerview.b<m>
{
  public static final a rMw;
  private final CommentDrawerContract.NPresenter rMd;
  
  static
  {
    AppMethodBeat.i(178121);
    rMw = new a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public g(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.rMd = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private final void a(View paramView, final String paramString, final m paramm, final boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(2131304784)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(2131304781);
    d.g.b.p.g(paramString, "arrowIv");
    paramString.setVisibility(0);
    final View localView = paramView.findViewById(2131304783);
    d.g.b.p.g(localView, "loadingView");
    localView.setVisibility(8);
    paramView.setOnClickListener((View.OnClickListener)new b(this, paramString, localView, paramm, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private final boolean cyV()
  {
    AppMethodBeat.i(178117);
    if (this.rMd.cBa() == 2)
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
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)parame.Gd(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.mn(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new l(parame));
    AppMethodBeat.o(178116);
  }
  
  public final int getLayoutId()
  {
    return 2131492865;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg, View paramView1, View paramView2, m paramm, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178107);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = paramString;
      d.g.b.p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = localView;
      d.g.b.p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      g.a(this.rMx).a(paramm, paramBoolean);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178107);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(e parame, String paramString, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(this.oNd, this.rMn, this.rMj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178108);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(e parame, String paramString, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178109);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(this.oNd, this.rMn, this.rMj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178109);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178110);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = this.rMj.skh.getUsername();
      localObject = this.oNd.getContext();
      d.g.b.p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.tcM;
      paramView = this.oNd.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eY(paramView);
      if (paramView != null)
      {
        localObject = h.soM;
        h.a(1, this.rMj.skh.field_feedId, paramView.rTD, 2, this.rMj.skh.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178110);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178111);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = this.rMj.skh.getUsername();
      localObject = this.oNd.getContext();
      d.g.b.p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.tcM;
      paramView = this.oNd.getContext();
      d.g.b.p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eY(paramView);
      if (paramView != null)
      {
        localObject = h.soM;
        h.a(1, this.rMj.skh.field_feedId, paramView.rTD, 2, this.rMj.skh.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178111);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(g paramg, m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201320);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = a.rLR;
      paramView = this.rMj.skh.getUsername();
      localObject = this.rMj;
      Context localContext = this.oNd.getContext();
      d.g.b.p.g(localContext, "holder.context");
      a.a(paramView, (m)localObject, localContext, g.a(this.rMx).cAZ());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201320);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(g paramg, m paramm, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201321);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = a.rLR;
      paramView = this.rMj.skh.getUsername();
      localObject = this.rMj;
      Context localContext = this.oNd.getContext();
      d.g.b.p.g(localContext, "holder.context");
      a.a(paramView, (m)localObject, localContext, g.a(this.rMx).cAZ());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201321);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<String, z>
  {
    j(g paramg, m paramm, e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(g paramg, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201323);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = g.a(this.rMx);
      localObject = this.rMo;
      d.g.b.p.g(localObject, "commentFailTV");
      paramView.ag((View)localObject, this.oNd.lN());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201323);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
  static final class l
    extends q
    implements d.g.a.b<Boolean, z>
  {
    l(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g
 * JD-Core Version:    0.7.0.1
 */