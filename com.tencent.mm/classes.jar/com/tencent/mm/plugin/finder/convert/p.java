package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.aw.a;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI5.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;)V", "foldedController", "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends com.tencent.mm.view.recyclerview.f<ai>
{
  public static final a AIX;
  private final aw.a AIY;
  private final b AIZ;
  
  static
  {
    AppMethodBeat.i(350416);
    AIX = new a((byte)0);
    AppMethodBeat.o(350416);
  }
  
  public p(aw.a parama)
  {
    AppMethodBeat.i(350404);
    this.AIY = parama;
    this.AIZ = new b(this);
    AppMethodBeat.o(350404);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350429);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView.getContext();
    Object localObject = new GridLayoutManager(2);
    paramRecyclerView = (WxRecyclerView)paramj.UH(e.e.full_item_folded_ry);
    paramRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    paramRecyclerView.a((RecyclerView.h)new c());
    localObject = new ArrayList();
    paramRecyclerView.setTag(localObject);
    paramRecyclerView.setAdapter((RecyclerView.a)new WxRecyclerAdapter((g)new d(this), (ArrayList)localObject, true));
    paramInt = bf.getStatusBarHeight(paramj.context);
    int i = bf.fs(paramj.context);
    float f = paramj.context.getResources().getDimension(e.c.Edge_2A);
    paramj = paramj.UH(e.e.title_layout).getLayoutParams();
    if (paramj == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(350429);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramj).topMargin = (paramInt + i + (int)f);
    s.s(paramRecyclerView, "ry");
    com.tencent.mm.view.f.a((View)paramRecyclerView, (e.b)new e((ArrayList)localObject));
    AppMethodBeat.o(350429);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_full_item_folded_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements FinderFoldedScrollLayout.b
  {
    b(p paramp) {}
    
    private static final void c(p paramp)
    {
      AppMethodBeat.i(350443);
      s.u(paramp, "this$0");
      paramp = p.b(paramp).ecB();
      OccupyFinderUI5.a locala = OccupyFinderUI5.Bth;
      paramp.remove(OccupyFinderUI5.egh(), true);
      AppMethodBeat.o(350443);
    }
    
    public final ConstraintLayout.LayoutParams dXB()
    {
      return null;
    }
    
    public final boolean dXC()
    {
      return false;
    }
    
    public final int dXD()
    {
      return 0;
    }
    
    public final void p(j paramj)
    {
      AppMethodBeat.i(350461);
      s.u(paramj, "holder");
      Object localObject1 = paramj.getRecyclerView().getTag();
      if (localObject1 == null)
      {
        paramj = new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.model.BaseFinderFeed>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.mm.plugin.finder.model.BaseFinderFeed> }");
        AppMethodBeat.o(350461);
        throw paramj;
      }
      Object localObject2 = (ArrayList)localObject1;
      localObject1 = p.b(this.AJa).ecB().zHB;
      BaseFinderFeed localBaseFinderFeed;
      int i;
      label131:
      int j;
      if (localObject1 == null)
      {
        localObject1 = null;
        localBaseFinderFeed = (BaseFinderFeed)paramj.CSA;
        p.b(this.AJa).ecB().insertAll((List)localObject2, 1);
        localObject2 = ((List)p.b(this.AJa).ecB().getDataListJustForAdapter()).iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break label396;
        }
        cc localcc = (cc)((Iterator)localObject2).next();
        if (localBaseFinderFeed.bZA() != localcc.bZA()) {
          break label384;
        }
        j = 1;
        label171:
        if (j == 0) {
          break label389;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "onItemClick", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "Undefined", "smoothScrollToPosition", "(I)V");
          ((RecyclerView)localObject1).smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "onItemClick", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        if (localObject1 != null) {
          ((RecyclerView)localObject1).postDelayed(new p.b..ExternalSyntheticLambda0(this.AJa), 1000L);
        }
        localObject1 = k.aeZF;
        localObject1 = paramj.context;
        s.s(localObject1, "holder.context");
        localObject1 = ((as)k.nq((Context)localObject1).q(as.class)).fou();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("feedid", d.hF(localBaseFinderFeed.bZA()));
        ((JSONObject)localObject2).put("index", paramj.KJ() + 1);
        paramj = bb.FuK;
        bb.a((bui)localObject1, "video_card_rec", 1, (JSONObject)localObject2);
        AppMethodBeat.o(350461);
        return;
        localObject1 = (RecyclerView)((WeakReference)localObject1).get();
        break;
        label384:
        j = 0;
        break label171;
        label389:
        i += 1;
        break label131;
        label396:
        i = -1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "getSpace", "()I", "space2", "getSpace2", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.h
  {
    private final int AJb;
    private final int space;
    
    c()
    {
      AppMethodBeat.i(350431);
      this.space = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5.0F);
      this.AJb = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12.0F);
      AppMethodBeat.o(350431);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(350445);
      s.u(paramRect, "outRect");
      s.u(paramView, "view");
      s.u(paramRecyclerView, "parent");
      s.u(params, "state");
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      if (paramView.getLayoutParams() == null)
      {
        paramRect = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        AppMethodBeat.o(350445);
        throw paramRect;
      }
      int i = RecyclerView.bA(paramView);
      s.checkNotNull(paramRecyclerView);
      int j = paramRecyclerView.bWl;
      if (paramRecyclerView.bWq.bh(i, j) == 0)
      {
        paramRect.bottom = this.AJb;
        paramRect.top = this.space;
      }
      paramRect.left = this.space;
      paramRect.right = this.space;
      AppMethodBeat.o(350445);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g
  {
    d(p paramp) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(350418);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new aj((FinderFoldedScrollLayout.b)p.a(this.AJa));
      AppMethodBeat.o(350418);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$3", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends e.b
  {
    e(ArrayList<BaseFinderFeed> paramArrayList) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(350414);
      s.u(paramView, "view");
      if (paramBoolean)
      {
        Object localObject1 = k.aeZF;
        paramView = paramView.getContext();
        s.s(paramView, "view.context");
        paramView = ((as)k.nq(paramView).q(as.class)).fou();
        localObject1 = ((Iterable)this.AJc).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (BaseFinderFeed)((Iterator)localObject1).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("feedid", d.hF(((BaseFinderFeed)localObject2).bZA()));
          localObject2 = bb.FuK;
          bb.a(paramView, "video_card_rec", 0, localJSONObject);
        }
      }
      AppMethodBeat.o(350414);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.p
 * JD-Core Version:    0.7.0.1
 */