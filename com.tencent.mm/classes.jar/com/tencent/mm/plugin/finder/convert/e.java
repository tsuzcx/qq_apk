package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.b<m>
{
  public static final a rMf;
  private final CommentDrawerContract.NPresenter rMd;
  private final boolean rMe;
  
  static
  {
    AppMethodBeat.i(165328);
    rMf = new a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public e(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.rMd = paramNPresenter;
    this.rMe = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean cyV()
  {
    AppMethodBeat.i(165325);
    if (this.rMd.cBa() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
  {
    AppMethodBeat.i(165324);
    d.g.b.p.h(paramRecyclerView, "recyclerView");
    d.g.b.p.h(parame, "holder");
    Object localObject = parame.Gd(2131299878);
    paramRecyclerView = new ah((View)localObject);
    d.g.b.p.g(localObject, "footerTouchDelegateView");
    ((View)localObject).setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cc.a.ay(parame.getContext(), 2131165289);
    localObject = parame.Gd(2131307300);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new e.n((View)localObject, paramInt, paramRecyclerView));
    }
    localObject = parame.Gd(2131297024);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new e.o((View)localObject, paramInt, paramRecyclerView));
    }
    parame.Gd(2131297024).setOnClickListener((View.OnClickListener)new p(this, parame));
    paramRecyclerView = (FinderCollapsibleTextView)parame.Gd(2131304081);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.mn(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new l(parame));
    localObject = parame.getContext();
    d.g.b.p.g(localObject, "holder.context");
    paramRecyclerView.setTextColor(((Context)localObject).getResources().getColor(2131099660));
    paramRecyclerView = (FinderCollapsibleTextView)parame.Gd(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.mn(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new m(parame));
    AppMethodBeat.o(165324);
  }
  
  public final int getLayoutId()
  {
    return 2131492864;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame, com.tencent.mm.view.recyclerview.e parame1, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201312);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = e.a(this.rMg);
      localObject = this.rMh.auu;
      d.g.b.p.g(localObject, "holder.itemView");
      paramView.a((View)localObject, this.rMi);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201312);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(m paramm, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165316);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(e parame, View paramView1, View paramView2, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201314);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.rMl;
      d.g.b.p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = this.rMm;
      d.g.b.p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      e.a(this.rMg).a(this.rMj, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201314);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(m paramm, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165317);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(com.tencent.mm.view.recyclerview.e parame, String paramString, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178101);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(this.oNd, this.rMn, this.rMj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178101);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(com.tencent.mm.view.recyclerview.e parame, String paramString, m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178102);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = com.tencent.mm.plugin.finder.utils.p.sMo;
      com.tencent.mm.plugin.finder.utils.p.a(this.oNd, this.rMn, this.rMj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178102);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(e parame, m paramm, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165318);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = a.rLR;
      paramView = this.rMj.skh.getUsername();
      localObject = this.rMj;
      Context localContext = this.oNd.getContext();
      d.g.b.p.g(localContext, "holder.context");
      a.a(paramView, (m)localObject, localContext, e.a(this.rMg).cAZ());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165318);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(e parame, m paramm, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201315);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = a.rLR;
      paramView = this.rMj.skh.getUsername();
      localObject = this.rMj;
      Context localContext = this.oNd.getContext();
      d.g.b.p.g(localContext, "holder.context");
      a.a(paramView, (m)localObject, localContext, e.a(this.rMg).cAZ());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201315);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(e parame, TextView paramTextView, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = e.a(this.rMg);
      localObject = this.rMo;
      d.g.b.p.g(localObject, "commentFailTV");
      paramView.ag((View)localObject, this.oNd.lN());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178105);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$4$1"})
  static final class l
    extends q
    implements d.g.a.b<Boolean, z>
  {
    l(com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$5$1"})
  static final class m
    extends q
    implements d.g.a.b<Boolean, z>
  {
    m(com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201318);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      if (e.a(this.rMg).isCommentClose())
      {
        t.makeText(parame.getContext(), 2131759160, 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201318);
        return;
      }
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(201318);
        throw paramView;
      }
      localObject1 = (ImageView)paramView;
      Object localObject2 = (m)parame.fQC();
      paramView = g.sKi;
      int i;
      Context localContext;
      if (!g.cKV().a(e.a(this.rMg).cBb().field_id, ((m)localObject2).skh, e.a(this.rMg).cBa()))
      {
        i = 1;
        if (i == 0) {
          break label405;
        }
        paramView = parame.getContext();
        localContext = parame.getContext();
        d.g.b.p.g(localContext, "holder.context");
        paramView = ao.k(paramView, 2131690326, localContext.getResources().getColor(2131099809));
        label217:
        ((ImageView)localObject1).setImageDrawable(paramView);
        e.a(this.rMg).a((ImageView)localObject1, parame.lN());
        paramView = g.sKi;
        int j = g.cKV().b(e.a(this.rMg).cBb().field_id, ((m)localObject2).skh, e.a(this.rMg).cBa());
        if (j <= 0) {
          break label449;
        }
        parame.kA(2131297025, 0);
        parame.d(2131297025, (CharSequence)String.valueOf(j));
        label319:
        if (i == 0) {
          break label479;
        }
        paramView = (TextView)parame.Gd(2131297025);
        localObject2 = parame.getContext();
        d.g.b.p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099804));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = c.sXx;
          c.ej((View)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201318);
        return;
        i = 0;
        break;
        label405:
        paramView = parame.getContext();
        localContext = parame.getContext();
        d.g.b.p.g(localContext, "holder.context");
        paramView = ao.k(paramView, 2131690330, localContext.getResources().getColor(2131100018));
        break label217;
        label449:
        parame.kA(2131297025, 8);
        parame.d(2131297025, (CharSequence)"");
        break label319;
        label479:
        paramView = (TextView)parame.Gd(2131297025);
        localObject2 = parame.getContext();
        d.g.b.p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099660));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */