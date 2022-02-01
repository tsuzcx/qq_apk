package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.af;
import com.tencent.mm.plugin.finder.convert.x;
import com.tencent.mm.plugin.finder.convert.z;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.ui.MMActivity;
import d.a.j;
import d.g.a.a;
import d.g.b.k;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback$FinderProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/feed/FinderProfileUIContract$ProfileViewCallback;)V", "VT_HEADER", "", "getVT_HEADER", "()I", "VT_MEDIA", "getVT_MEDIA", "VT_PLAIN_TEXT", "getVT_PLAIN_TEXT", "bindData", "", "holder", "position", "bindImage", "", "getItemCount", "getItemViewType", "isHeader", "jumpProfileTimeline", "pos", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "plugin-finder_release"})
public final class g$b$b
  extends RecyclerView.a<RecyclerView.v>
{
  private final int qwA = 3;
  private final int qwy = 1;
  private final int qwz = 2;
  
  private void c(final RecyclerView.v paramv, boolean paramBoolean)
  {
    AppMethodBeat.i(165820);
    k.h(paramv, "holder");
    if ((paramv instanceof x))
    {
      ((x)paramv).dS(this.qwx.qwn);
      AppMethodBeat.o(165820);
      return;
    }
    Object localObject1;
    int i;
    Object localObject2;
    FinderProfileUIContract localFinderProfileUIContract;
    if ((paramv instanceof com.tencent.mm.plugin.finder.convert.y))
    {
      localObject1 = FinderProfileUIContract.ProfileViewCallback.c(this.qwx);
      i = ((com.tencent.mm.plugin.finder.convert.y)paramv).ln();
      localObject2 = FinderProfileUIContract.qvY;
      localObject1 = (BaseFinderFeed)((BaseFinderFeedLoader)localObject1).get(i - FinderProfileUIContract.cmc());
      localObject2 = (com.tencent.mm.plugin.finder.convert.y)paramv;
      if (localObject1 == null) {
        k.fvU();
      }
      localFinderProfileUIContract = FinderProfileUIContract.qvY;
      FinderProfileUIContract.cmc();
      com.tencent.mm.plugin.finder.convert.y.a((com.tencent.mm.plugin.finder.convert.y)localObject2, (BaseFinderFeed)localObject1, paramBoolean, (a)new a(this, paramv, (BaseFinderFeed)localObject1));
      AppMethodBeat.o(165820);
      return;
    }
    if ((paramv instanceof af))
    {
      localObject1 = FinderProfileUIContract.ProfileViewCallback.c(this.qwx);
      i = ((af)paramv).ln();
      localObject2 = FinderProfileUIContract.qvY;
      localObject1 = (BaseFinderFeed)((BaseFinderFeedLoader)localObject1).get(i - FinderProfileUIContract.cmc());
      localObject2 = (af)paramv;
      if (localObject1 == null) {
        k.fvU();
      }
      localFinderProfileUIContract = FinderProfileUIContract.qvY;
      FinderProfileUIContract.cmc();
      af.a((af)localObject2, (BaseFinderFeed)localObject1, (a)new b(this, paramv, (BaseFinderFeed)localObject1));
    }
    AppMethodBeat.o(165820);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(165818);
    k.h(paramViewGroup, "parent");
    if (paramInt == this.qwy)
    {
      paramViewGroup = FinderProfileUIContract.ProfileViewCallback.d(this.qwx).getLayoutInflater().inflate(2131494096, null);
      k.g(paramViewGroup, "headerLayout");
      paramViewGroup = (RecyclerView.v)new x(paramViewGroup);
      AppMethodBeat.o(165818);
      return paramViewGroup;
    }
    if (paramInt == this.qwA)
    {
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494097, paramViewGroup, false);
      k.g(paramViewGroup, "convertView");
      paramViewGroup = (RecyclerView.v)new z(paramViewGroup);
      AppMethodBeat.o(165818);
      return paramViewGroup;
    }
    paramViewGroup = this.qwx.KMT.B(paramViewGroup);
    AppMethodBeat.o(165818);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(165821);
    k.h(paramv, "holder");
    c(paramv, true);
    AppMethodBeat.o(165821);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(165819);
    k.h(paramv, "holder");
    k.h(paramList, "payloads");
    if (k.g(j.iz(paramList), Boolean.FALSE))
    {
      AppMethodBeat.o(165819);
      return;
    }
    if (paramList.size() > 0)
    {
      c(paramv, false);
      AppMethodBeat.o(165819);
      return;
    }
    super.a(paramv, paramInt, paramList);
    AppMethodBeat.o(165819);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(165815);
    int i = FinderProfileUIContract.ProfileViewCallback.c(this.qwx).getSize();
    FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.qvY;
    int j = FinderProfileUIContract.cmc();
    AppMethodBeat.o(165815);
    return i + j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(165816);
    if (paramInt == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramInt = this.qwy;
      AppMethodBeat.o(165816);
      return paramInt;
    }
    Object localObject = FinderProfileUIContract.ProfileViewCallback.c(this.qwx);
    FinderProfileUIContract localFinderProfileUIContract = FinderProfileUIContract.qvY;
    localObject = ((BaseFinderFeedLoader)localObject).get(paramInt - FinderProfileUIContract.cmc());
    if (localObject == null) {
      k.fvU();
    }
    if (((BaseFinderFeed)localObject).feedObject.getMediaType() == 1)
    {
      paramInt = this.qwA;
      AppMethodBeat.o(165816);
      return paramInt;
    }
    paramInt = this.qwz;
    AppMethodBeat.o(165816);
    return paramInt;
  }
  
  public final void k(RecyclerView.v paramv)
  {
    AppMethodBeat.i(165817);
    k.h(paramv, "holder");
    super.k(paramv);
    Object localObject = paramv.arI;
    k.g(localObject, "holder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    if ((localObject != null) && ((localObject instanceof StaggeredGridLayoutManager.LayoutParams)))
    {
      localObject = (StaggeredGridLayoutManager.LayoutParams)localObject;
      if (paramv.lp() != this.qwy) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((StaggeredGridLayoutManager.LayoutParams)localObject).aE(bool);
      AppMethodBeat.o(165817);
      return;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<d.y>
  {
    a(g.b.b paramb, RecyclerView.v paramv, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<d.y>
  {
    b(g.b.b paramb, RecyclerView.v paramv, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.b.b
 * JD-Core Version:    0.7.0.1
 */