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
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "jumpToWxProfile", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class d
  extends com.tencent.mm.view.recyclerview.b<com.tencent.mm.plugin.finder.model.l>
{
  public static final d.a qZQ;
  private final CommentDrawerContract.NPresenter qZO;
  private final boolean qZP;
  
  static
  {
    AppMethodBeat.i(165328);
    qZQ = new d.a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public d(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.qZO = paramNPresenter;
    this.qZP = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean csV()
  {
    AppMethodBeat.i(165325);
    if (this.qZO.cuJ() == 2)
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
    k.h(paramRecyclerView, "recyclerView");
    k.h(parame, "holder");
    parame.adJ(2131297024).setOnClickListener((View.OnClickListener)new n(this, parame));
    paramRecyclerView = (FinderCollapsibleTextView)parame.adJ(2131304081);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lV(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new l(parame));
    Context localContext = parame.getContext();
    k.g(localContext, "holder.context");
    paramRecyclerView.setTextColor(localContext.getResources().getColor(2131099660));
    paramRecyclerView = (FinderCollapsibleTextView)parame.adJ(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.lV(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new m(parame));
    AppMethodBeat.o(165324);
  }
  
  public final int getLayoutId()
  {
    return 2131492864;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class b
    implements View.OnClickListener
  {
    b(d paramd, e parame, com.tencent.mm.plugin.finder.model.l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201256);
      paramView = d.a(this.qZR);
      View localView = this.qZS.asD;
      k.g(localView, "holder.itemView");
      paramView.a(localView, this.qZT);
      AppMethodBeat.o(201256);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
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
        localObject = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.a(1, this.qZU.ruO.field_feedId, paramView.rfR, 2, this.qZU.ruO.getUsername());
        AppMethodBeat.o(165316);
        return;
      }
      AppMethodBeat.o(165316);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(d paramd, View paramView1, View paramView2, com.tencent.mm.plugin.finder.model.l paraml) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201258);
      paramView = this.qZW;
      k.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = this.qZX;
      k.g(paramView, "loadingView");
      paramView.setVisibility(0);
      d.a(this.qZR).a(this.qZU, true);
      AppMethodBeat.o(201258);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
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
        localObject = com.tencent.mm.plugin.finder.report.d.rxr;
        com.tencent.mm.plugin.finder.report.d.a(1, this.qZU.ruO.field_feedId, paramView.rfR, 2, this.qZU.ruO.getUsername());
        AppMethodBeat.o(165317);
        return;
      }
      AppMethodBeat.o(165317);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(d paramd, com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165318);
      paramView = a.qZF;
      paramView = this.qZU.ruO.getUsername();
      com.tencent.mm.plugin.finder.model.l locall = this.qZU;
      Context localContext = this.ojH.getContext();
      k.g(localContext, "holder.context");
      a.a(paramView, locall, localContext, d.a(this.qZR).cuI());
      AppMethodBeat.o(165318);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(d paramd, com.tencent.mm.plugin.finder.model.l paraml, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201261);
      paramView = a.qZF;
      paramView = this.qZU.ruO.getUsername();
      com.tencent.mm.plugin.finder.model.l locall = this.qZU;
      Context localContext = this.ojH.getContext();
      k.g(localContext, "holder.context");
      a.a(paramView, locall, localContext, d.a(this.qZR).cuI());
      AppMethodBeat.o(201261);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(d paramd, TextView paramTextView, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      paramView = d.a(this.qZR);
      TextView localTextView = this.raa;
      k.g(localTextView, "commentFailTV");
      paramView.af((View)localTextView, this.ojH.lv());
      AppMethodBeat.o(178105);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
  static final class l
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3$1"})
  static final class m
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    m(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(d paramd, e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165322);
      if (d.a(this.qZR).isCommentClose())
      {
        com.tencent.mm.ui.base.t.makeText(parame.getContext(), 2131759160, 0).show();
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
      Object localObject = (com.tencent.mm.plugin.finder.model.l)parame.fzs();
      paramView = g.rOb;
      int i;
      Context localContext;
      if (!g.cCH().a(d.a(this.qZR).cuK().field_id, ((com.tencent.mm.plugin.finder.model.l)localObject).ruO, d.a(this.qZR).cuJ()))
      {
        i = 1;
        if (i == 0) {
          break label349;
        }
        paramView = parame.getContext();
        localContext = parame.getContext();
        k.g(localContext, "holder.context");
        paramView = am.k(paramView, 2131690326, localContext.getResources().getColor(2131099809));
        label173:
        localImageView.setImageDrawable(paramView);
        d.a(this.qZR).a(localImageView, parame.lv());
        paramView = g.rOb;
        int j = g.cCH().b(d.a(this.qZR).cuK().field_id, ((com.tencent.mm.plugin.finder.model.l)localObject).ruO, d.a(this.qZR).cuJ());
        if (j <= 0) {
          break label393;
        }
        parame.kl(2131297025, 0);
        parame.d(2131297025, (CharSequence)String.valueOf(j));
        label275:
        if (i == 0) {
          break label423;
        }
        paramView = (TextView)parame.adJ(2131297025);
        localObject = parame.getContext();
        k.g(localObject, "holder.context");
        paramView.setTextColor(((Context)localObject).getResources().getColor(2131099804));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = com.tencent.mm.plugin.finder.view.animation.b.sag;
          com.tencent.mm.plugin.finder.view.animation.b.eb((View)localImageView);
        }
        AppMethodBeat.o(165322);
        return;
        i = 0;
        break;
        label349:
        paramView = parame.getContext();
        localContext = parame.getContext();
        k.g(localContext, "holder.context");
        paramView = am.k(paramView, 2131690330, localContext.getResources().getColor(2131100018));
        break label173;
        label393:
        parame.kl(2131297025, 8);
        parame.d(2131297025, (CharSequence)"");
        break label275;
        label423:
        paramView = (TextView)parame.adJ(2131297025);
        localObject = parame.getContext();
        k.g(localObject, "holder.context");
        paramView.setTextColor(((Context)localObject).getResources().getColor(2131099660));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.d
 * JD-Core Version:    0.7.0.1
 */