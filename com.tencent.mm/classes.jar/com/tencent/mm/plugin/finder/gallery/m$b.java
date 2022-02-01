package com.tencent.mm.plugin.finder.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "needScrollData", "", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onLoadMoreError", "onRefreshError", "smoothScrollToNextPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m$b
  extends ae.b
{
  public m$b(MMActivity paramMMActivity, m.a parama)
  {
    super(paramMMActivity, (ae.a)parama, 0, 0);
    AppMethodBeat.i(334132);
    AppMethodBeat.o(334132);
  }
  
  private static final void o(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(334142);
    s.u(paramRecyclerView, "$recyclerView");
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramRecyclerView, locala.aYi(), "com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$ViewCallback", "smoothScrollToNextPosition$lambda-0", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    paramRecyclerView.smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramRecyclerView, "com/tencent/mm/plugin/finder/gallery/FinderGalleryTimelineContract$ViewCallback", "smoothScrollToNextPosition$lambda-0", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    AppMethodBeat.o(334142);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(334163);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    Object localObject = af.mU((Context)this.lzt).inflate(e.f.load_more_footer_dark, null);
    s.s(localObject, "getInflater(context).inf…d_more_footer_dark, null)");
    paramArrayList.setLoadMoreFooter((View)localObject);
    paramArrayList = this.lzt.findViewById(e.e.profile_recycler_view);
    s.s(paramArrayList, "context.findViewById(R.id.profile_recycler_view)");
    localObject = (RecyclerView)paramArrayList;
    if (((localObject instanceof FinderRecyclerView)) && ((((FinderRecyclerView)localObject).getLayoutManager() instanceof LinearLayoutManager)))
    {
      paramArrayList = (FinderRecyclerView)localObject;
      localObject = ((FinderRecyclerView)localObject).getLayoutManager();
      if (localObject == null)
      {
        paramArrayList = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(334163);
        throw paramArrayList;
      }
      paramArrayList.a((LinearLayoutManager)localObject);
    }
    AppMethodBeat.o(334163);
  }
  
  public final boolean ebG()
  {
    return true;
  }
  
  public final View getEmptyView()
  {
    return null;
  }
  
  final void t(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(334170);
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
      AppMethodBeat.o(334170);
      throw paramRecyclerView;
    }
    int i = ((FinderLinearLayoutManager)localLayoutManager).Ju() + 1;
    if (i < ((List)getAdapter().data).size()) {
      paramRecyclerView.post(new m.b..ExternalSyntheticLambda0(paramRecyclerView, i));
    }
    AppMethodBeat.o(334170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.m.b
 * JD-Core Version:    0.7.0.1
 */