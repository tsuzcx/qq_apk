package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h$b
  extends ae.b
{
  public h$b(MMActivity paramMMActivity, h.a parama, int paramInt)
  {
    super(paramMMActivity, (ae.a)parama, paramInt, 21);
    AppMethodBeat.i(363194);
    AppMethodBeat.o(363194);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363206);
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
        AppMethodBeat.o(363206);
        throw paramArrayList;
      }
      paramArrayList.a((LinearLayoutManager)localObject);
    }
    AppMethodBeat.o(363206);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.b
 * JD-Core Version:    0.7.0.1
 */