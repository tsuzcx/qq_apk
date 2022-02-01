package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class g
  extends com.tencent.mm.view.recyclerview.b<n>
{
  public static final g.a rUJ;
  private final CommentDrawerContract.NPresenter rUq;
  
  static
  {
    AppMethodBeat.i(178121);
    rUJ = new g.a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public g(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.rUq = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private final void a(View paramView, final String paramString, final n paramn, final boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(2131304784)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(2131304781);
    p.g(paramString, "arrowIv");
    paramString.setVisibility(0);
    final View localView = paramView.findViewById(2131304783);
    p.g(localView, "loadingView");
    localView.setVisibility(8);
    paramView.setOnClickListener((View.OnClickListener)new b(this, paramString, localView, paramn, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private final boolean cAz()
  {
    AppMethodBeat.i(178117);
    if (this.rUq.cCM() == 2)
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
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)parame.GD(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.ms(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new l(parame));
    AppMethodBeat.o(178116);
  }
  
  public final int getLayoutId()
  {
    return 2131492865;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(g paramg, View paramView1, View paramView2, n paramn, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178107);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = paramString;
      p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = localView;
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      g.a(this.rUK).a(paramn, paramBoolean);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178107);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(n paramn, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178110);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.rUw.ste.getUsername();
      localObject = this.oTF.getContext();
      p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.tnG;
      paramView = this.oTF.getContext();
      p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fc(paramView);
      if (paramView != null)
      {
        localObject = i.syT;
        i.a(1, this.rUw.ste.field_feedId, paramView.sch, 2, this.rUw.ste.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178110);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(n paramn, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178111);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.rUw.ste.getUsername();
      localObject = this.oTF.getContext();
      p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.tnG;
      paramView = this.oTF.getContext();
      p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fc(paramView);
      if (paramView != null)
      {
        localObject = i.syT;
        i.a(1, this.rUw.ste.field_feedId, paramView.sch, 2, this.rUw.ste.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178111);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(g paramg, n paramn, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201747);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = a.rUe;
      paramView = this.rUw.ste.getUsername();
      localObject = this.rUw;
      Context localContext = this.oTF.getContext();
      p.g(localContext, "holder.context");
      a.a(paramView, (n)localObject, localContext, g.a(this.rUK).cCL());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201747);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(g paramg, n paramn, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201748);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = a.rUe;
      paramView = this.rUw.ste.getUsername();
      localObject = this.rUw;
      Context localContext = this.oTF.getContext();
      p.g(localContext, "holder.context");
      a.a(paramView, (n)localObject, localContext, g.a(this.rUK).cCL());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201748);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "invoke"})
  static final class j
    extends q
    implements d.g.a.b<String, z>
  {
    j(g paramg, n paramn, e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(g paramg, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201750);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = g.a(this.rUK);
      localObject = this.rUB;
      p.g(localObject, "commentFailTV");
      paramView.ag((View)localObject, this.oTF.lN());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201750);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g
 * JD-Core Version:    0.7.0.1
 */