package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.d;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.view.recyclerview.e;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "jumpToWxProfile", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class b
  extends com.tencent.mm.view.recyclerview.b<h>
{
  public static final a qqj;
  private final CommentDrawerContract.NPresenter qqh;
  private final boolean qqi;
  
  static
  {
    AppMethodBeat.i(165328);
    qqj = new a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public b(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.qqh = paramNPresenter;
    this.qqi = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean clb()
  {
    AppMethodBeat.i(165325);
    if (this.qqh.clT() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, final e parame, int paramInt)
  {
    AppMethodBeat.i(165324);
    d.g.b.k.h(paramRecyclerView, "recyclerView");
    d.g.b.k.h(parame, "holder");
    parame.abq(2131297024).setOnClickListener((View.OnClickListener)new k(this, parame));
    paramRecyclerView = (FinderCollapsibleTextView)parame.abq(2131304081);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lk(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new i(parame));
    Context localContext = parame.getContext();
    d.g.b.k.g(localContext, "holder.context");
    paramRecyclerView.setTextColor(localContext.getResources().getColor(2131099660));
    paramRecyclerView = (FinderCollapsibleTextView)parame.abq(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lk(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new j(parame));
    AppMethodBeat.o(165324);
  }
  
  public final int getLayoutId()
  {
    return 2131492864;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
      paramView = a.qSb;
      paramView = this.qqk.qDA.getUsername();
      Object localObject = this.nGG.getContext();
      d.g.b.k.g(localObject, "holder.context");
      a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.Ljl;
      paramView = this.nGG.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(1, this.qqk.qDA.field_feedId, paramView.qqE, 2, this.qqk.qDA.getUsername());
        AppMethodBeat.o(165316);
        return;
      }
      AppMethodBeat.o(165316);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
      paramView = a.qSb;
      paramView = this.qqk.qDA.getUsername();
      Object localObject = this.nGG.getContext();
      d.g.b.k.g(localObject, "holder.context");
      a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.Ljl;
      paramView = this.nGG.getContext();
      d.g.b.k.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.lB(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.b.qFq;
        com.tencent.mm.plugin.finder.report.b.a(1, this.qqk.qDA.field_feedId, paramView.qqE, 2, this.qqk.qDA.getUsername());
        AppMethodBeat.o(165317);
        return;
      }
      AppMethodBeat.o(165317);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    public static final d KKv;
    
    static
    {
      AppMethodBeat.i(197384);
      KKv = new d();
      AppMethodBeat.o(197384);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178101);
      AppMethodBeat.o(178101);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    public static final e KKw;
    
    static
    {
      AppMethodBeat.i(197385);
      KKw = new e();
      AppMethodBeat.o(197385);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178102);
      AppMethodBeat.o(178102);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class f
    implements View.OnClickListener
  {
    f(b paramb, e parame, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(197381);
      paramView = b.a(this.qql);
      View localView = this.qqq.arI;
      d.g.b.k.g(localView, "holder.itemView");
      paramView.a(localView, this.KKu);
      AppMethodBeat.o(197381);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(b paramb, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      paramView = b.a(this.qql);
      TextView localTextView = this.qqm;
      d.g.b.k.g(localTextView, "commentFailTV");
      paramView.ae((View)localTextView, this.nGG.ln());
      AppMethodBeat.o(178105);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3$1"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(b paramb, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165322);
      if (b.a(this.qql).isCommentClose())
      {
        t.makeText(parame.getContext(), 2131759160, 0).show();
        AppMethodBeat.o(165322);
        return;
      }
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(165322);
        throw paramView;
      }
      ImageView localImageView = (ImageView)paramView;
      Object localObject = (h)parame.fjf();
      paramView = d.qRR;
      int i;
      Context localContext;
      if (!d.crL().a(b.a(this.qql).clU().field_id, ((h)localObject).qDA, b.a(this.qql).clT()))
      {
        i = 1;
        if (i == 0) {
          break label349;
        }
        paramView = parame.getContext();
        localContext = parame.getContext();
        d.g.b.k.g(localContext, "holder.context");
        paramView = am.i(paramView, 2131690326, localContext.getResources().getColor(2131099809));
        label173:
        localImageView.setImageDrawable(paramView);
        b.a(this.qql).a(localImageView, parame.ln());
        paramView = d.qRR;
        int j = d.crL().b(b.a(this.qql).clU().field_id, ((h)localObject).qDA, b.a(this.qql).clT());
        if (j <= 0) {
          break label393;
        }
        parame.jY(2131297025, 0);
        parame.d(2131297025, (CharSequence)String.valueOf(j));
        label275:
        if (i == 0) {
          break label423;
        }
        paramView = (TextView)parame.abq(2131297025);
        localObject = parame.getContext();
        d.g.b.k.g(localObject, "holder.context");
        paramView.setTextColor(((Context)localObject).getResources().getColor(2131099804));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.view.animation.b.qYv;
          com.tencent.mm.plugin.finder.view.animation.b.dU((View)localImageView);
        }
        AppMethodBeat.o(165322);
        return;
        i = 0;
        break;
        label349:
        paramView = parame.getContext();
        localContext = parame.getContext();
        d.g.b.k.g(localContext, "holder.context");
        paramView = am.i(paramView, 2131690330, localContext.getResources().getColor(2131100018));
        break label173;
        label393:
        parame.jY(2131297025, 8);
        parame.d(2131297025, (CharSequence)"");
        break label275;
        label423:
        paramView = (TextView)parame.abq(2131297025);
        localObject = parame.getContext();
        d.g.b.k.g(localObject, "holder.context");
        paramView.setTextColor(((Context)localObject).getResources().getColor(2131099660));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.b
 * JD-Core Version:    0.7.0.1
 */