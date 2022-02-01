package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.view.recyclerview.b<n>
{
  public static final e.a rUs;
  private final CommentDrawerContract.NPresenter rUq;
  private final boolean rUr;
  
  static
  {
    AppMethodBeat.i(165328);
    rUs = new e.a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public e(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.rUq = paramNPresenter;
    this.rUr = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean cAz()
  {
    AppMethodBeat.i(165325);
    if (this.rUq.cCM() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, final int paramInt)
  {
    AppMethodBeat.i(165324);
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
    Object localObject = parame.GD(2131299878);
    paramRecyclerView = new ah((View)localObject);
    p.g(localObject, "footerTouchDelegateView");
    ((View)localObject).setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cb.a.ay(parame.getContext(), 2131165289);
    localObject = parame.GD(2131307300);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new n((View)localObject, paramInt, paramRecyclerView));
    }
    localObject = parame.GD(2131297024);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new o((View)localObject, paramInt, paramRecyclerView));
    }
    parame.GD(2131297024).setOnClickListener((View.OnClickListener)new p(this, parame));
    paramRecyclerView = (FinderCollapsibleTextView)parame.GD(2131304081);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.ms(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new l(parame));
    localObject = parame.getContext();
    p.g(localObject, "holder.context");
    paramRecyclerView.setTextColor(((Context)localObject).getResources().getColor(2131099660));
    paramRecyclerView = (FinderCollapsibleTextView)parame.GD(2131298506);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.ms(false);
    paramRecyclerView.setOnCollapse((d.g.a.b)new m(parame));
    AppMethodBeat.o(165324);
  }
  
  public final int getLayoutId()
  {
    return 2131492864;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class b
    implements View.OnClickListener
  {
    b(e parame, com.tencent.mm.view.recyclerview.e parame1, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201739);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = e.a(this.rUt);
      localObject = this.rUu.auu;
      p.g(localObject, "holder.itemView");
      paramView.a((View)localObject, this.rUv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201739);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(n paramn, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165316);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(e parame, View paramView1, View paramView2, n paramn) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201741);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.rUy;
      p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = this.rUz;
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      e.a(this.rUt).a(this.rUw, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201741);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(n paramn, com.tencent.mm.view.recyclerview.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
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
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165317);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(e parame, n paramn, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165318);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = a.rUe;
      paramView = this.rUw.ste.getUsername();
      localObject = this.rUw;
      Context localContext = this.oTF.getContext();
      p.g(localContext, "holder.context");
      a.a(paramView, (n)localObject, localContext, e.a(this.rUt).cCL());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165318);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(e parame, n paramn, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201742);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = a.rUe;
      paramView = this.rUw.ste.getUsername();
      localObject = this.rUw;
      Context localContext = this.oTF.getContext();
      p.g(localContext, "holder.context");
      a.a(paramView, (n)localObject, localContext, e.a(this.rUt).cCL());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201742);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(e parame, TextView paramTextView, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = e.a(this.rUt);
      localObject = this.rUB;
      p.g(localObject, "commentFailTV");
      paramView.ag((View)localObject, this.oTF.lN());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178105);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$4$1"})
  static final class l
    extends q
    implements d.g.a.b<Boolean, z>
  {
    l(com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$5$1"})
  static final class m
    extends q
    implements d.g.a.b<Boolean, z>
  {
    m(com.tencent.mm.view.recyclerview.e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$1$1"})
  static final class n
    implements Runnable
  {
    n(View paramView, int paramInt, ah paramah) {}
    
    public final void run()
    {
      AppMethodBeat.i(201743);
      Rect localRect = new Rect();
      this.rUC.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new ai(localRect, this.rUC));
      AppMethodBeat.o(201743);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
  static final class o
    implements Runnable
  {
    o(View paramView, int paramInt, ah paramah) {}
    
    public final void run()
    {
      AppMethodBeat.i(201744);
      Rect localRect = new Rect();
      this.rUC.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new ai(localRect, this.rUC));
      AppMethodBeat.o(201744);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(e parame, com.tencent.mm.view.recyclerview.e parame1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201745);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      if (e.a(this.rUt).isCommentClose())
      {
        t.makeText(parame.getContext(), 2131759160, 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201745);
        return;
      }
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(201745);
        throw paramView;
      }
      localObject1 = (ImageView)paramView;
      Object localObject2 = (n)parame.fUY();
      paramView = g.sVv;
      int i;
      Context localContext;
      if (!g.cNz().a(e.a(this.rUt).cCN().field_id, ((n)localObject2).ste, e.a(this.rUt).cCM()))
      {
        i = 1;
        if (i == 0) {
          break label405;
        }
        paramView = parame.getContext();
        localContext = parame.getContext();
        p.g(localContext, "holder.context");
        paramView = ao.k(paramView, 2131690326, localContext.getResources().getColor(2131099809));
        label217:
        ((ImageView)localObject1).setImageDrawable(paramView);
        e.a(this.rUt).a((ImageView)localObject1, parame.lN());
        paramView = g.sVv;
        int j = g.cNz().b(e.a(this.rUt).cCN().field_id, ((n)localObject2).ste, e.a(this.rUt).cCM());
        if (j <= 0) {
          break label449;
        }
        parame.kH(2131297025, 0);
        parame.e(2131297025, (CharSequence)String.valueOf(j));
        label319:
        if (i == 0) {
          break label479;
        }
        paramView = (TextView)parame.GD(2131297025);
        localObject2 = parame.getContext();
        p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099804));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = c.tiL;
          c.ej((View)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201745);
        return;
        i = 0;
        break;
        label405:
        paramView = parame.getContext();
        localContext = parame.getContext();
        p.g(localContext, "holder.context");
        paramView = ao.k(paramView, 2131690330, localContext.getResources().getColor(2131100018));
        break label217;
        label449:
        parame.kH(2131297025, 8);
        parame.e(2131297025, (CharSequence)"");
        break label319;
        label479:
        paramView = (TextView)parame.GD(2131297025);
        localObject2 = parame.getContext();
        p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099660));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e
 * JD-Core Version:    0.7.0.1
 */