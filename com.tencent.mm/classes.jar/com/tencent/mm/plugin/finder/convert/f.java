package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.l>
{
  public static final f.a raf;
  private final CommentDrawerContract.NPresenter qZO;
  
  static
  {
    AppMethodBeat.i(178121);
    raf = new f.a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public f(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.qZO = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private final void a(View paramView, final String paramString, final com.tencent.mm.plugin.finder.model.l paraml, final boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(2131304784)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(2131304781);
    k.g(paramString, "arrowIv");
    paramString.setVisibility(0);
    final View localView = paramView.findViewById(2131304783);
    k.g(localView, "loadingView");
    localView.setVisibility(8);
    paramView.setOnClickListener((View.OnClickListener)new b(this, paramString, localView, paraml, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private final boolean csV()
  {
    AppMethodBeat.i(178117);
    if (this.qZO.cuJ() == 2)
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
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)parame.adJ(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lV(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new j(parame));
    AppMethodBeat.o(178116);
  }
  
  public final int getLayoutId()
  {
    return 2131492865;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(f paramf, View paramView1, View paramView2, com.tencent.mm.plugin.finder.model.l paraml, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178107);
      paramView = paramString;
      k.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = localView;
      k.g(paramView, "loadingView");
      paramView.setVisibility(0);
      f.a(this.rag).a(paraml, paramBoolean);
      AppMethodBeat.o(178107);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178108);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = this.qZU.ruO.getUsername();
      Object localObject = this.ojH.getContext();
      k.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.seQ;
      paramView = this.ojH.getContext();
      k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null)
      {
        localObject = d.rxr;
        d.a(1, this.qZU.ruO.field_feedId, paramView.rfR, 2, this.qZU.ruO.getUsername());
        AppMethodBeat.o(178108);
        return;
      }
      AppMethodBeat.o(178108);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178109);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = this.qZU.ruO.getUsername();
      Object localObject = this.ojH.getContext();
      k.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.seQ;
      paramView = this.ojH.getContext();
      k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.eV(paramView);
      if (paramView != null)
      {
        localObject = d.rxr;
        d.a(1, this.qZU.ruO.field_feedId, paramView.rfR, 2, this.qZU.ruO.getUsername());
        AppMethodBeat.o(178109);
        return;
      }
      AppMethodBeat.o(178109);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(f paramf, com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178110);
      paramView = a.qZF;
      paramView = this.qZU.ruO.getUsername();
      com.tencent.mm.plugin.finder.model.l locall = this.qZU;
      Context localContext = this.ojH.getContext();
      k.g(localContext, "holder.context");
      a.a(paramView, locall, localContext, f.a(this.rag).cuI());
      AppMethodBeat.o(178110);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(f paramf, com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178111);
      paramView = a.qZF;
      paramView = this.qZU.ruO.getUsername();
      com.tencent.mm.plugin.finder.model.l locall = this.qZU;
      Context localContext = this.ojH.getContext();
      k.g(localContext, "holder.context");
      a.a(paramView, locall, localContext, f.a(this.rag).cuI());
      AppMethodBeat.o(178111);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "username", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    g(f paramf, com.tencent.mm.plugin.finder.model.l paraml, e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(f paramf, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178113);
      paramView = f.a(this.rag);
      TextView localTextView = this.raa;
      k.g(localTextView, "commentFailTV");
      paramView.af((View)localTextView, this.ojH.lv());
      AppMethodBeat.o(178113);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.f
 * JD-Core Version:    0.7.0.1
 */