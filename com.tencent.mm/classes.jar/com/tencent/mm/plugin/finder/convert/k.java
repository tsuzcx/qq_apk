package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;)V", "getLayoutId", "", "initTipsLayout", "", "tipsLayout", "Landroid/view/View;", "tip", "", "rootComment", "down", "", "isWxScene", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class k
  extends e<s>
{
  public static final a tzS;
  private final CommentDrawerContract.NPresenter tzm;
  
  static
  {
    AppMethodBeat.i(178121);
    tzS = new a((byte)0);
    AppMethodBeat.o(178121);
  }
  
  public k(CommentDrawerContract.NPresenter paramNPresenter)
  {
    AppMethodBeat.i(178120);
    this.tzm = paramNPresenter;
    AppMethodBeat.o(178120);
  }
  
  private final void a(View paramView, final String paramString, final s params, final boolean paramBoolean)
  {
    AppMethodBeat.i(178119);
    paramView.setVisibility(0);
    ((TextView)paramView.findViewById(2131307866)).setText((CharSequence)paramString);
    paramString = paramView.findViewById(2131307863);
    p.g(paramString, "arrowIv");
    paramString.setVisibility(0);
    final View localView = paramView.findViewById(2131307865);
    p.g(localView, "loadingView");
    localView.setVisibility(8);
    paramView.setOnClickListener((View.OnClickListener)new b(this, paramString, localView, params, paramBoolean));
    AppMethodBeat.o(178119);
  }
  
  private final boolean cZA()
  {
    AppMethodBeat.i(178117);
    if (this.tzm.dcA() == 2)
    {
      AppMethodBeat.o(178117);
      return true;
    }
    AppMethodBeat.o(178117);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(178116);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)paramh.Mn(2131298927);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.oV(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new l(paramh));
    AppMethodBeat.o(178116);
  }
  
  public final int getLayoutId()
  {
    return 2131492866;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(k paramk, View paramView1, View paramView2, s params, boolean paramBoolean) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178107);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = paramString;
      p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = localView;
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      k.a(this.tzT).a(params, paramBoolean);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$initTipsLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178107);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178108);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = y.vXH;
      y.a(this.qhp, this.tzw, this.tzs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178108);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(h paramh, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178109);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = y.vXH;
      y.a(this.qhp, this.tzw, this.tzs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178109);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(s params, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178110);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.wzC;
      paramView = this.qhp.getContext();
      p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, paramView.tCE, 2, this.tzs.uOf.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178110);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(s params, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178111);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.qhp.getContext();
      p.g(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.d(paramView, (Context)localObject);
      paramView = FinderReporterUIC.wzC;
      paramView = this.qhp.getContext();
      p.g(paramView, "holder.context");
      paramView = FinderReporterUIC.a.fH(paramView);
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.a(1, this.tzs.uOf.field_feedId, paramView.tCE, 2, this.tzs.uOf.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178111);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(k paramk, s params, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242811);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = d.tyZ;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.tzs;
      Context localContext = this.qhp.getContext();
      p.g(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, k.a(this.tzT).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242811);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(k paramk, s params, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242812);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = d.tyZ;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.tzs;
      Context localContext = this.qhp.getContext();
      p.g(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, k.a(this.tzT).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242812);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.b<String, x>
  {
    j(k paramk, s params, h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(k paramk, TextView paramTextView, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242814);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = k.a(this.tzT);
      localObject = this.tzx;
      p.g(localObject, "commentFailTV");
      paramView.af((View)localObject, this.qhp.lR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242814);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentLevel2Convert$onCreateViewHolder$1$1"})
  static final class l
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    l(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.k
 * JD-Core Version:    0.7.0.1
 */