package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ao;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.report.x;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.d;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import java.util.LinkedList;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardTxtFeed;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "lifecycleObserver", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1;", "linkLayout", "loadMoreLayout", "rect2", "Landroid/graphics/Rect;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "reportExpose", "", "getReportExpose", "()Z", "setReportExpose", "(Z)V", "scrollListener", "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1;", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "titleLayoutSet", "Ljava/util/LinkedList;", "viewRect", "createTitleLayout", "context", "Landroid/content/Context;", "parent", "getLayoutId", "", "isViewExposed", "view", "jumpToHotTab", "", "Lcom/tencent/mm/ui/MMActivity;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onBindViewHolder", "item", "position", "type", "isHotPatch", "payloads", "", "", "onClickTopic", "txt", "", "index", "onCreateViewHolder", "setFinderStreamTxtCard", "Companion", "plugin-finder_release"})
public final class cp
  extends e<ao>
{
  public static final a xpG;
  View amk;
  private RecyclerView jLl;
  private final Rect viewRect;
  private bid xbu;
  private BaseFinderFeedLoader xnX;
  private final Rect xoY;
  private View xpA;
  private View xpB;
  private final f xpC;
  private final d xpD;
  boolean xpE;
  private final FinderStreamCardTxtConvert.lifecycleObserver.1 xpF;
  private final LinkedList<View> xpz;
  
  static
  {
    AppMethodBeat.i(282705);
    xpG = new a((byte)0);
    AppMethodBeat.o(282705);
  }
  
  public cp(BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    AppMethodBeat.i(282704);
    this.xnX = paramBaseFinderFeedLoader;
    this.xpz = new LinkedList();
    this.xpC = kotlin.g.ar((kotlin.g.a.a)g.xpN);
    this.viewRect = new Rect();
    this.xoY = new Rect();
    this.xpD = new d(this);
    this.xpE = true;
    this.xpF = new FinderStreamCardTxtConvert.lifecycleObserver.1(this);
    AppMethodBeat.o(282704);
  }
  
  public final void a(RecyclerView paramRecyclerView, final i parami, int paramInt)
  {
    AppMethodBeat.i(282702);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    this.jLl = paramRecyclerView;
    paramRecyclerView.b((RecyclerView.l)this.xpD);
    paramRecyclerView.a((RecyclerView.l)this.xpD);
    Context localContext = paramRecyclerView.getContext();
    if (localContext == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282702);
      throw paramRecyclerView;
    }
    ((MMActivity)localContext).getLifecycle().b((k)this.xpF);
    paramRecyclerView = paramRecyclerView.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282702);
      throw paramRecyclerView;
    }
    ((MMActivity)paramRecyclerView).getLifecycle().a((k)this.xpF);
    paramRecyclerView = com.tencent.mm.ui.component.g.Xox;
    paramRecyclerView = parami.getContext();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(282702);
      throw paramRecyclerView;
    }
    this.xbu = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramRecyclerView).i(aj.class)).ekY();
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.title);
    p.j(paramRecyclerView, "holder.itemView.title");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = (TextView)paramRecyclerView.findViewById(b.f.moreTitle);
    p.j(paramRecyclerView, "holder.itemView.moreTitle");
    ar.a((Paint)paramRecyclerView.getPaint(), 0.8F);
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    ((LinearLayout)paramRecyclerView.findViewById(b.f.loadMoreLayout)).setOnClickListener((View.OnClickListener)new c(this, parami));
    AppMethodBeat.o(282702);
  }
  
  public final int getLayoutId()
  {
    return b.g._finder_feed_card_txt_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(cp paramcp, i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(276401);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.xpI;
      localObject = parami.getContext();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(276401);
        throw paramView;
      }
      cp.a(paramView, (MMActivity)localObject, parami);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276401);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isExposed", "", "()Z", "setExposed", "(Z)V", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    boolean xpx;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288221);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        paramRecyclerView.post((Runnable)new a(this));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(288221);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288222);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$scrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(288222);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(cp.d paramd) {}
      
      public final void run()
      {
        Object localObject2 = null;
        Object localObject1 = null;
        int j = 0;
        int i = 0;
        AppMethodBeat.i(270394);
        View localView = this.xpJ.xpI.amk;
        boolean bool;
        if (localView != null)
        {
          bool = cp.a(this.xpJ.xpI, localView);
          if ((!this.xpJ.xpx) && (bool))
          {
            this.xpJ.xpx = true;
            localObject2 = cp.a(this.xpJ.xpI);
            if (localObject2 != null) {
              i = ((View)localObject2).getHeight();
            }
            if (i <= 0) {
              break label283;
            }
            localObject2 = localView.getTag();
            if ((localObject2 instanceof ao)) {
              break label298;
            }
          }
        }
        for (;;)
        {
          localObject1 = (ao)localObject1;
          if (localObject1 != null)
          {
            localObject2 = x.zYS;
            x.a(((ao)localObject1).xBM, ((ao)localObject1).xBN, ((ao)localObject1).position, 1, cp.b(this.xpJ.xpI));
            AppMethodBeat.o(270394);
            return;
            if ((this.xpJ.xpx) && (!bool))
            {
              this.xpJ.xpx = false;
              localObject1 = cp.c(this.xpJ.xpI);
              i = j;
              if (localObject1 != null) {
                i = ((View)localObject1).getHeight();
              }
              if (i > 0)
              {
                localObject1 = localView.getTag();
                if ((localObject1 instanceof ao)) {
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
            localObject1 = (ao)localObject1;
            if (localObject1 != null)
            {
              localObject2 = x.zYS;
              x.a(((ao)localObject1).xBM, ((ao)localObject1).xBN, ((ao)localObject1).position, ((ao)localObject1).xBO, "", cp.b(this.xpJ.xpI));
            }
            AppMethodBeat.o(270394);
            return;
            AppMethodBeat.o(270394);
            return;
          }
          label298:
          localObject1 = localObject2;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(cp paramcp, View paramView1, ao paramao, View paramView2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291715);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.xpI;
      localObject = this.kqJ.getContext();
      p.j(localObject, "view.context");
      ao localao = this.xpK;
      TextView localTextView = (TextView)this.xpL.findViewById(b.f.topic_2);
      p.j(localTextView, "titleLayout.topic_2");
      cp.a(paramView, (Context)localObject, localao, localTextView.getText().toString(), this.xpM + 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291715);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(cp paramcp, View paramView1, ao paramao, View paramView2, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286381);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = this.xpI;
      localObject = this.kqJ.getContext();
      p.j(localObject, "view.context");
      ao localao = this.xpK;
      TextView localTextView = (TextView)this.xpL.findViewById(b.f.topic_1);
      p.j(localTextView, "titleLayout.topic_1");
      cp.a(paramView, (Context)localObject, localao, localTextView.getText().toString(), this.xpM);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$setFinderStreamTxtCard$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286381);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<d>
  {
    public static final g xpN;
    
    static
    {
      AppMethodBeat.i(286008);
      xpN = new g();
      AppMethodBeat.o(286008);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cp
 * JD-Core Version:    0.7.0.1
 */