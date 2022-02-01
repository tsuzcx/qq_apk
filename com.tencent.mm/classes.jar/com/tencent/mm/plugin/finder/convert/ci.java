package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1;", "linkLayout", "loadMoreLayout", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "reportExpose", "", "getReportExpose", "()Z", "setReportExpose", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1;", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "titleLayoutSet", "Ljava/util/LinkedList;", "viewRect", "createTitleLayout", "context", "Landroid/content/Context;", "parent", "getLayoutId", "", "isViewExposed", "view", "jumpToHotTab", "", "Lcom/tencent/mm/ui/MMActivity;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onClickTopic", "txt", "", "index", "onCreateViewHolder", "setFinderStreamTxtCard", "Companion", "plugin-finder_release"})
public final class ci
  extends e<ah>
{
  public static final a tGU;
  View aus;
  private RecyclerView hak;
  private BaseFinderFeedLoader tFM;
  private final LinkedList<View> tGN;
  private View tGO;
  private View tGP;
  private final f tGQ;
  private final d tGR;
  boolean tGS;
  private final FinderStreamCardTxtConvert.lifecycleObserver.1 tGT;
  private final Rect tGl;
  private bbn ttO;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(243348);
    tGU = new a((byte)0);
    AppMethodBeat.o(243348);
  }
  
  public ci(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(243347);
    this.tFM = paramBaseFinderFeedLoader;
    this.tGN = new LinkedList();
    this.tGQ = g.ah((kotlin.g.a.a)g.tHb);
    this.viewRect = new Rect();
    this.tGl = new Rect();
    this.tGR = new d(this);
    this.tGS = true;
    this.tGT = new FinderStreamCardTxtConvert.lifecycleObserver.1(this);
    AppMethodBeat.o(243347);
  }
  
  public final void a(RecyclerView paramRecyclerView, final h paramh, int paramInt)
  {
    AppMethodBeat.i(243345);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    this.hak = paramRecyclerView;
    paramRecyclerView.b((RecyclerView.l)this.tGR);
    paramRecyclerView.a((RecyclerView.l)this.tGR);
    Context localContext = paramRecyclerView.getContext();
    if (localContext == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243345);
      throw paramRecyclerView;
    }
    ((MMActivity)localContext).getLifecycle().removeObserver((LifecycleObserver)this.tGT);
    paramRecyclerView = paramRecyclerView.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243345);
      throw paramRecyclerView;
    }
    ((MMActivity)paramRecyclerView).getLifecycle().addObserver((LifecycleObserver)this.tGT);
    paramRecyclerView = com.tencent.mm.ui.component.a.PRN;
    paramRecyclerView = paramh.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(243345);
      throw paramRecyclerView;
    }
    this.ttO = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramRecyclerView).get(FinderReporterUIC.class)).dIx();
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131309195);
    p.g(paramRecyclerView, "holder.itemView.title");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(2131304858);
    p.g(paramRecyclerView, "holder.itemView.moreTitle");
    ao.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = paramh.aus;
    p.g(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(2131303680)).setOnClickListener((View.OnClickListener)new c(this, paramh));
    AppMethodBeat.o(243345);
  }
  
  public final int getLayoutId()
  {
    return 2131492877;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(com.tencent.mm.bw.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ci paramci, h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243337);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tGW;
      localObject = paramh.getContext();
      if (localObject == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(243337);
        throw paramView;
      }
      ci.a(paramView, (MMActivity)localObject, paramh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243337);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    boolean tGL;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(243339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(243339);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243340);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(243340);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(ci.d paramd) {}
      
      public final void run()
      {
        Object localObject2 = null;
        Object localObject1 = null;
        int j = 0;
        int i = 0;
        AppMethodBeat.i(243338);
        View localView = this.tGX.tGW.aus;
        boolean bool;
        if (localView != null)
        {
          bool = ci.a(this.tGX.tGW, localView);
          if ((!this.tGX.tGL) && (bool))
          {
            this.tGX.tGL = true;
            localObject2 = ci.a(this.tGX.tGW);
            if (localObject2 != null) {
              i = ((View)localObject2).getHeight();
            }
            if (i <= 0) {
              break label283;
            }
            localObject2 = localView.getTag();
            if ((localObject2 instanceof ah)) {
              break label298;
            }
          }
        }
        for (;;)
        {
          localObject1 = (ah)localObject1;
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.report.t.vhJ;
            com.tencent.mm.plugin.finder.report.t.a(((ah)localObject1).tQV, ((ah)localObject1).tQW, ((ah)localObject1).position, 1, ci.b(this.tGX.tGW));
            AppMethodBeat.o(243338);
            return;
            if ((this.tGX.tGL) && (!bool))
            {
              this.tGX.tGL = false;
              localObject1 = ci.c(this.tGX.tGW);
              i = j;
              if (localObject1 != null) {
                i = ((View)localObject1).getHeight();
              }
              if (i > 0)
              {
                localObject1 = localView.getTag();
                if ((localObject1 instanceof ah)) {
                  break label295;
                }
                localObject1 = localObject2;
              }
            }
          }
          label283:
          label295:
          for (;;)
          {
            localObject1 = (ah)localObject1;
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.report.t.vhJ;
              com.tencent.mm.plugin.finder.report.t.a(((ah)localObject1).tQV, ((ah)localObject1).tQW, ((ah)localObject1).position, ((ah)localObject1).tQX, "", ci.b(this.tGX.tGW));
            }
            AppMethodBeat.o(243338);
            return;
            AppMethodBeat.o(243338);
            return;
          }
          label298:
          localObject1 = localObject2;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(ci paramci, View paramView1, ah paramah, View paramView2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243341);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tGW;
      localObject = this.hCI.getContext();
      p.g(localObject, "view.context");
      ah localah = this.tGY;
      TextView localTextView = (TextView)this.tGZ.findViewById(2131309338);
      p.g(localTextView, "titleLayout.topic_2");
      ci.a(paramView, (Context)localObject, localah, localTextView.getText().toString(), this.tHa + 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243341);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(ci paramci, View paramView1, ah paramah, View paramView2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243342);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = this.tGW;
      localObject = this.hCI.getContext();
      p.g(localObject, "view.context");
      ah localah = this.tGY;
      TextView localTextView = (TextView)this.tGZ.findViewById(2131309337);
      p.g(localTextView, "titleLayout.topic_1");
      ci.a(paramView, (Context)localObject, localah, localTextView.getText().toString(), this.tHa);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(243342);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<FinderStreamCardVM>
  {
    public static final g tHb;
    
    static
    {
      AppMethodBeat.i(243344);
      tHb = new g();
      AppMethodBeat.o(243344);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ci
 * JD-Core Version:    0.7.0.1
 */