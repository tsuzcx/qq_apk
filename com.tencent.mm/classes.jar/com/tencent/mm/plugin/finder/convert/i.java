package com.tencent.mm.plugin.finder.convert;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class i
  extends e<s>
{
  public static final a xgZ;
  private final CommentDrawerContract.NPresenter xgX;
  private final boolean xgY;
  
  static
  {
    AppMethodBeat.i(165328);
    xgZ = new a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public i(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.xgX = paramNPresenter;
    this.xgY = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean dpr()
  {
    AppMethodBeat.i(165325);
    if (this.xgX.dsQ() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, final int paramInt)
  {
    AppMethodBeat.i(283269);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    Object localObject = parami.RD(b.f.feed_comment_layout);
    paramRecyclerView = new an((View)localObject);
    p.j(localObject, "footerTouchDelegateView");
    ((View)localObject).setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.ci.a.aZ(parami.getContext(), b.d.Edge_2A);
    localObject = parami.RD(b.f.comment_more_iv);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new n((View)localObject, paramInt, paramRecyclerView));
    }
    localObject = parami.RD(b.f.awesome_iv);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new o((View)localObject, paramInt, paramRecyclerView));
    }
    parami.RD(b.f.awesome_iv).setOnClickListener((View.OnClickListener)new p(this, parami));
    paramRecyclerView = (FinderCollapsibleTextView)parami.RD(b.f.reply_comment_content);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.rp(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new l(parami));
    localObject = parami.getContext();
    p.j(localObject, "holder.context");
    paramRecyclerView.setTextColor(((Context)localObject).getResources().getColor(b.c.BW_0_Alpha_0_3));
    paramRecyclerView = (FinderCollapsibleTextView)parami.RD(b.f.commend_content);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.rp(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new m(parami));
    AppMethodBeat.o(283269);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_comment_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami, com.tencent.mm.view.recyclerview.i parami1, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273000);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = i.a(this.xha);
      localObject = this.xhb.amk;
      p.j(localObject, "holder.itemView");
      paramView.a((View)localObject, this.xhc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273000);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(s params, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.xhd.zAt.getUsername();
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        localObject = n.zWF;
        n.a(1, this.xhd.zAt.field_feedId, paramView.xkX, 2, this.xhd.zAt.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165316);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(i parami, View paramView1, View paramView2, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(280258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.xhf;
      p.j(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = this.xhg;
      p.j(paramView, "loadingView");
      paramView.setVisibility(0);
      i.a(this.xha).a(this.xhd, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280258);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(s params, com.tencent.mm.view.recyclerview.i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.xhd.zAt.getUsername();
      localObject = this.tDl.getContext();
      p.j(localObject, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.e(paramView, (Context)localObject);
      paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      paramView = aj.a.fZ(paramView);
      if (paramView != null)
      {
        localObject = n.zWF;
        n.a(1, this.xhd.zAt.field_feedId, paramView.xkX, 2, this.xhd.zAt.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165317);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(com.tencent.mm.view.recyclerview.i parami, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178101);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.a(this.tDl, this.xhh, this.xhd);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178101);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(com.tencent.mm.view.recyclerview.i parami, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178102);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = com.tencent.mm.plugin.finder.utils.aj.AGc;
      com.tencent.mm.plugin.finder.utils.aj.a(this.tDl, this.xhh, this.xhd);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178102);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(i parami, s params, com.tencent.mm.view.recyclerview.i parami1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165318);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = d.xgJ;
      paramView = this.xhd.zAt.getUsername();
      localObject = this.xhd;
      Context localContext = this.tDl.getContext();
      p.j(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, i.a(this.xha).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165318);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(i parami, s params, com.tencent.mm.view.recyclerview.i parami1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289268);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = d.xgJ;
      paramView = this.xhd.zAt.getUsername();
      localObject = this.xhd;
      Context localContext = this.tDl.getContext();
      p.j(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, i.a(this.xha).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289268);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(i parami, TextView paramTextView, com.tencent.mm.view.recyclerview.i parami1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = i.a(this.xha);
      localObject = this.xhi;
      p.j(localObject, "commentFailTV");
      paramView.ai((View)localObject, this.tDl.md());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178105);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$4$1"})
  static final class l
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    l(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$5$1"})
  static final class m
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    m(com.tencent.mm.view.recyclerview.i parami)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$1$1"})
  static final class n
    implements Runnable
  {
    n(View paramView, int paramInt, an paraman) {}
    
    public final void run()
    {
      AppMethodBeat.i(278881);
      Rect localRect = new Rect();
      this.kJS.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new ao(localRect, this.kJS));
      AppMethodBeat.o(278881);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
  static final class o
    implements Runnable
  {
    o(View paramView, int paramInt, an paraman) {}
    
    public final void run()
    {
      AppMethodBeat.i(282897);
      Rect localRect = new Rect();
      this.kJS.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new ao(localRect, this.kJS));
      AppMethodBeat.o(282897);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(i parami, com.tencent.mm.view.recyclerview.i parami1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(249244);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      if (i.a(this.xha).isCommentClose())
      {
        w.makeText(parami.getContext(), b.j.finder_comment_closed_warning3, 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249244);
        return;
      }
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(249244);
        throw paramView;
      }
      localObject1 = (ImageView)paramView;
      Object localObject2 = (s)parami.ihX();
      paramView = com.tencent.mm.plugin.finder.upload.action.l.ACj;
      int i;
      int j;
      Context localContext;
      if (!com.tencent.mm.plugin.finder.upload.action.l.ecG().a(i.a(this.xha).dsR().field_id, ((s)localObject2).zAt, i.a(this.xha).dsQ()))
      {
        i = 1;
        if (i == 0) {
          break label414;
        }
        paramView = parami.getContext();
        j = b.i.icon_filled_awesome;
        localContext = parami.getContext();
        p.j(localContext, "holder.context");
        paramView = au.o(paramView, j, localContext.getResources().getColor(b.c.Red_90));
        label222:
        ((ImageView)localObject1).setImageDrawable(paramView);
        i.a(this.xha).a((ImageView)localObject1, parami.md());
        paramView = com.tencent.mm.plugin.finder.upload.action.l.ACj;
        j = com.tencent.mm.plugin.finder.upload.action.l.ecG().b(i.a(this.xha).dsR().field_id, ((s)localObject2).zAt, i.a(this.xha).dsQ());
        if (j <= 0) {
          break label462;
        }
        parami.nx(b.f.awesome_num, 0);
        parami.e(b.f.awesome_num, (CharSequence)String.valueOf(j));
        label326:
        if (i == 0) {
          break label494;
        }
        paramView = (TextView)parami.RD(b.f.awesome_num);
        localObject2 = parami.getContext();
        p.j(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(b.c.Red_100));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = c.BdF;
          c.eT((View)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249244);
        return;
        i = 0;
        break;
        label414:
        paramView = parami.getContext();
        j = b.i.icon_outlined_awesome;
        localContext = parami.getContext();
        p.j(localContext, "holder.context");
        paramView = au.o(paramView, j, localContext.getResources().getColor(b.c.black_color));
        break label222;
        label462:
        parami.nx(b.f.awesome_num, 8);
        parami.e(b.f.awesome_num, (CharSequence)"");
        break label326;
        label494:
        paramView = (TextView)parami.RD(b.f.awesome_num);
        localObject2 = parami.getContext();
        p.j(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(b.c.BW_0_Alpha_0_3));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.i
 * JD-Core Version:    0.7.0.1
 */