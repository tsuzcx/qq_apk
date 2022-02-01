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
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.view.animation.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.recyclerview.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "oldVersion", "", "(Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;Z)V", "getOldVersion", "()Z", "getLayoutId", "", "isWxScene", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshAwesomeIv", "isLike", "Companion", "plugin-finder_release"})
public final class h
  extends e<s>
{
  public static final a tzo;
  private final CommentDrawerContract.NPresenter tzm;
  private final boolean tzn;
  
  static
  {
    AppMethodBeat.i(165328);
    tzo = new a((byte)0);
    AppMethodBeat.o(165328);
  }
  
  public h(CommentDrawerContract.NPresenter paramNPresenter, boolean paramBoolean)
  {
    AppMethodBeat.i(178106);
    this.tzm = paramNPresenter;
    this.tzn = paramBoolean;
    AppMethodBeat.o(178106);
  }
  
  private final boolean cZA()
  {
    AppMethodBeat.i(165325);
    if (this.tzm.dcA() == 2)
    {
      AppMethodBeat.o(165325);
      return true;
    }
    AppMethodBeat.o(165325);
    return false;
  }
  
  @SuppressLint({"ResourceType"})
  public final void a(final RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, final int paramInt)
  {
    AppMethodBeat.i(165324);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    Object localObject = paramh.Mn(2131300561);
    paramRecyclerView = new ak((View)localObject);
    p.g(localObject, "footerTouchDelegateView");
    ((View)localObject).setTouchDelegate((TouchDelegate)paramRecyclerView);
    paramInt = com.tencent.mm.cb.a.aH(paramh.getContext(), 2131165296);
    localObject = paramh.Mn(2131298957);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new n((View)localObject, paramInt, paramRecyclerView));
    }
    localObject = paramh.Mn(2131297156);
    if (localObject != null) {
      ((View)localObject).post((Runnable)new o((View)localObject, paramInt, paramRecyclerView));
    }
    paramh.Mn(2131297156).setOnClickListener((View.OnClickListener)new p(this, paramh));
    paramRecyclerView = (FinderCollapsibleTextView)paramh.Mn(2131306946);
    paramRecyclerView.setLimitLine(2);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.oV(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new l(paramh));
    localObject = paramh.getContext();
    p.g(localObject, "holder.context");
    paramRecyclerView.setTextColor(((Context)localObject).getResources().getColor(2131099662));
    paramRecyclerView = (FinderCollapsibleTextView)paramh.Mn(2131298927);
    paramRecyclerView.setLimitLine(4);
    paramRecyclerView.setCollapse(true);
    paramRecyclerView.oV(false);
    paramRecyclerView.setOnCollapse((kotlin.g.a.b)new m(paramh));
    AppMethodBeat.o(165324);
  }
  
  public final int getLayoutId()
  {
    return 2131492865;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$11$1"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh, com.tencent.mm.view.recyclerview.h paramh1, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242784);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = h.a(this.tzp);
      localObject = this.tzq.aus;
      p.g(localObject, "holder.itemView");
      paramView.a((View)localObject, this.tzr);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242784);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(s params, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165316);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
        localObject = k.vfA;
        k.a(1, this.tzs.uOf.field_feedId, paramView.tCE, 2, this.tzs.uOf.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165316);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(h paramh, View paramView1, View paramView2, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242786);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.tzu;
      p.g(paramView, "arrowIv");
      paramView.setVisibility(8);
      paramView = this.tzv;
      p.g(paramView, "loadingView");
      paramView.setVisibility(0);
      h.a(this.tzp).a(this.tzs, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242786);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(s params, com.tencent.mm.view.recyclerview.h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165317);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
        localObject = k.vfA;
        k.a(1, this.tzs.uOf.field_feedId, paramView.tCE, 2, this.tzs.uOf.getUsername());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165317);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(com.tencent.mm.view.recyclerview.h paramh, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178101);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = y.vXH;
      y.a(this.qhp, this.tzw, this.tzs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178101);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(com.tencent.mm.view.recyclerview.h paramh, String paramString, s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178102);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = y.vXH;
      y.a(this.qhp, this.tzw, this.tzs);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178102);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(h paramh, s params, com.tencent.mm.view.recyclerview.h paramh1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165318);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = d.tyZ;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.tzs;
      Context localContext = this.qhp.getContext();
      p.g(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, h.a(this.tzp).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(165318);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(h paramh, s params, com.tencent.mm.view.recyclerview.h paramh1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242787);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = d.tyZ;
      paramView = this.tzs.uOf.getUsername();
      localObject = this.tzs;
      Context localContext = this.qhp.getContext();
      p.g(localContext, "holder.context");
      d.a(paramView, (s)localObject, localContext, h.a(this.tzp).getCommentScene());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242787);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(h paramh, TextView paramTextView, com.tencent.mm.view.recyclerview.h paramh1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(178105);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = h.a(this.tzp);
      localObject = this.tzx;
      p.g(localObject, "commentFailTV");
      paramView.af((View)localObject, this.qhp.lR());
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onBindViewHolder$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(178105);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$4$1"})
  static final class l
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    l(com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "collapse", "", "invoke", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$5$1"})
  static final class m
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    m(com.tencent.mm.view.recyclerview.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$1$1"})
  static final class n
    implements Runnable
  {
    n(View paramView, int paramInt, ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(242788);
      Rect localRect = new Rect();
      this.tzy.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new al(localRect, this.tzy));
      AppMethodBeat.o(242788);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$2$1"})
  static final class o
    implements Runnable
  {
    o(View paramView, int paramInt, ak paramak) {}
    
    public final void run()
    {
      AppMethodBeat.i(242789);
      Rect localRect = new Rect();
      this.tzy.getHitRect(localRect);
      localRect.inset(-paramInt, -paramInt);
      paramRecyclerView.a(new al(localRect, this.tzy));
      AppMethodBeat.o(242789);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class p
    implements View.OnClickListener
  {
    p(h paramh, com.tencent.mm.view.recyclerview.h paramh1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242790);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      if (h.a(this.tzp).isCommentClose())
      {
        u.makeText(paramh.getContext(), 2131759592, 0).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242790);
        return;
      }
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(242790);
        throw paramView;
      }
      localObject1 = (ImageView)paramView;
      Object localObject2 = (s)paramh.hgv();
      paramView = j.vUw;
      int i;
      Context localContext;
      if (!j.dBt().a(h.a(this.tzp).dcB().field_id, ((s)localObject2).uOf, h.a(this.tzp).dcA()))
      {
        i = 1;
        if (i == 0) {
          break label405;
        }
        paramView = paramh.getContext();
        localContext = paramh.getContext();
        p.g(localContext, "holder.context");
        paramView = ar.m(paramView, 2131690436, localContext.getResources().getColor(2131099824));
        label217:
        ((ImageView)localObject1).setImageDrawable(paramView);
        h.a(this.tzp).a((ImageView)localObject1, paramh.lR());
        paramView = j.vUw;
        int j = j.dBt().b(h.a(this.tzp).dcB().field_id, ((s)localObject2).uOf, h.a(this.tzp).dcA());
        if (j <= 0) {
          break label449;
        }
        paramh.mf(2131297157, 0);
        paramh.e(2131297157, (CharSequence)String.valueOf(j));
        label319:
        if (i == 0) {
          break label479;
        }
        paramView = (TextView)paramh.Mn(2131297157);
        localObject2 = paramh.getContext();
        p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099819));
      }
      for (;;)
      {
        if (i != 0)
        {
          paramView = c.wrB;
          c.ei((View)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedCommentConvert$onCreateViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(242790);
        return;
        i = 0;
        break;
        label405:
        paramView = paramh.getContext();
        localContext = paramh.getContext();
        p.g(localContext, "holder.context");
        paramView = ar.m(paramView, 2131690453, localContext.getResources().getColor(2131100044));
        break label217;
        label449:
        paramh.mf(2131297157, 8);
        paramh.e(2131297157, (CharSequence)"");
        break label319;
        label479:
        paramView = (TextView)paramh.Mn(2131297157);
        localObject2 = paramh.getContext();
        p.g(localObject2, "holder.context");
        paramView.setTextColor(((Context)localObject2).getResources().getColor(2131099662));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.h
 * JD-Core Version:    0.7.0.1
 */