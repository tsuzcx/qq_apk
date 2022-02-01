package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.FinderFoldedScrollLayout.b;
import com.tencent.mm.plugin.finder.viewmodel.c;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFoldedFeed;", "()V", "foldedController", "com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1;", "getLayoutId", "", "jumpFoldedUI", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpPos", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class q
  extends e<ag>
{
  public static final a xkH;
  private final b xkG;
  
  static
  {
    AppMethodBeat.i(271339);
    xkH = new a((byte)0);
    AppMethodBeat.o(271339);
  }
  
  public q()
  {
    AppMethodBeat.i(271338);
    this.xkG = new b(this);
    AppMethodBeat.o(271338);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(271336);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView.getContext();
    Object localObject = new GridLayoutManager(3);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)parami.RD(b.f.full_item_folded_ry);
    p.j(localWxRecyclerView, "ry");
    localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localWxRecyclerView.b((RecyclerView.h)new q.c());
    localObject = g.Xox;
    paramRecyclerView = paramRecyclerView.getContext();
    p.j(paramRecyclerView, "recyclerView.context");
    localWxRecyclerView.setRecycledViewPool(((c)g.lm(paramRecyclerView).i(c.class)).Bha);
    paramRecyclerView = new ArrayList();
    localWxRecyclerView.setTag(paramRecyclerView);
    localWxRecyclerView.setAdapter((RecyclerView.a)new WxRecyclerAdapter((f)new d(this), paramRecyclerView, true));
    paramInt = ax.getStatusBarHeight(parami.getContext());
    int i = ax.ew(parami.getContext());
    paramRecyclerView = parami.RD(b.f.title_layout);
    p.j(paramRecyclerView, "holder.getView<View>(R.id.title_layout)");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if (paramRecyclerView == null)
    {
      paramRecyclerView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(271336);
      throw paramRecyclerView;
    }
    ((LinearLayout.LayoutParams)paramRecyclerView).topMargin = (paramInt + i);
    AppMethodBeat.o(271336);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_full_item_folded_layout;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$foldedController$1", "Lcom/tencent/mm/plugin/finder/view/FinderFoldedScrollLayout$FoldedController;", "getItemLayoutType", "", "getLayoutParam", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "isShowLikeInfo", "", "onItemClick", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
  public static final class b
    implements FinderFoldedScrollLayout.b
  {
    public final ConstraintLayout.LayoutParams dpx()
    {
      return null;
    }
    
    public final boolean dpy()
    {
      return false;
    }
    
    public final int dpz()
    {
      return 0;
    }
    
    public final void j(i parami)
    {
      AppMethodBeat.i(274945);
      p.k(parami, "holder");
      Object localObject = parami.getRecyclerView().getTag(b.f.full_item_folded_ry);
      if (localObject == null)
      {
        parami = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.storage.FinderItem");
        AppMethodBeat.o(274945);
        throw parami;
      }
      localObject = (FinderItem)localObject;
      Context localContext = parami.getContext();
      p.j(localContext, "holder.context");
      q.a(localContext, (FinderItem)localObject, parami.md());
      AppMethodBeat.o(274945);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderFeedFullFoldedConvert$onCreateViewHolder$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class d
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(275095);
      e locale = (e)new ap((FinderFoldedScrollLayout.b)q.a(this.xkI));
      AppMethodBeat.o(275095);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.q
 * JD-Core Version:    0.7.0.1
 */