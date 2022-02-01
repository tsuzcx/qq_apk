package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.event.recyclerview.FinderRecyclerView;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$Presenter;II)V", "myActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "getMyActionCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "setMyActionCallback", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "getEmptyView", "Landroid/view/View;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getViewActionCallback", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onItemChange", "changeItemCount", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j$b
  extends ae.b
{
  public static final a AVc;
  private static final String TAG;
  private k AVd;
  
  static
  {
    AppMethodBeat.i(363089);
    AVc = new a((byte)0);
    TAG = "Finder.FinderFeedDetailRelUIContract.ViewCallback";
    AppMethodBeat.o(363089);
  }
  
  public j$b(MMActivity paramMMActivity, j.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (ae.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(363079);
    this.AVd = ((k)new b(this));
    AppMethodBeat.o(363079);
  }
  
  public final void ND(int paramInt)
  {
    AppMethodBeat.i(363125);
    super.ND(paramInt);
    MMActivity localMMActivity = this.lzt;
    if ((localMMActivity instanceof FinderShareFeedRelUI)) {
      ((FinderShareFeedRelUI)localMMActivity).fbX();
    }
    AppMethodBeat.o(363125);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363105);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    Object localObject = af.mU((Context)this.lzt).inflate(e.f.hot_tab_load_more_footer, null);
    s.s(localObject, "getInflater(context).inf…b_load_more_footer, null)");
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
        AppMethodBeat.o(363105);
        throw paramArrayList;
      }
      paramArrayList.a((LinearLayoutManager)localObject);
    }
    AppMethodBeat.o(363105);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(363117);
    Object localObject = this.ATx.getRecyclerView();
    ((RecyclerView)localObject).setItemAnimator((RecyclerView.f)new e());
    ((RecyclerView)localObject).setHasFixedSize(true);
    localObject = (CharSequence)this.lzt.getIntent().getStringExtra("FLOAT_BALL_KEY");
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label108;
      }
      localObject = this.ATv;
      if (!(localObject instanceof j.a)) {
        break label103;
      }
    }
    label103:
    for (localObject = (j.a)localObject;; localObject = null)
    {
      if (localObject == null) {
        break label182;
      }
      ((j.a)localObject).dUL();
      AppMethodBeat.o(363117);
      return;
      i = 0;
      break;
    }
    label108:
    localObject = (j.a)this.ATv;
    if (((j.a)localObject).AUZ != null)
    {
      Log.i(TAG, "cache exit!,show cache first");
      ArrayList localArrayList = ((j.a)localObject).ecc();
      if (localArrayList != null) {
        localArrayList.clear();
      }
      localArrayList = ((j.a)localObject).ecc();
      if (localArrayList != null)
      {
        localObject = ((j.a)localObject).AUZ;
        s.checkNotNull(localObject);
        localArrayList.add(localObject);
      }
      getAdapter().bZE.notifyChanged();
    }
    super.ebi();
    label182:
    AppMethodBeat.o(363117);
  }
  
  public final k ecd()
  {
    return this.AVd;
  }
  
  public final View getEmptyView()
  {
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback$myActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements k
  {
    b(j.b paramb)
    {
      AppMethodBeat.i(363788);
      this.AVe = this.AVf.ATx;
      AppMethodBeat.o(363788);
    }
    
    public final void onChanged() {}
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363819);
      this.AVf.ATx.onItemRangeChanged(this.AVf.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363819);
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(363826);
      this.AVf.ATx.onItemRangeChanged(this.AVf.zJM + paramInt1, paramInt2, paramObject);
      AppMethodBeat.o(363826);
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363834);
      this.AVf.ATx.onItemRangeInserted(this.AVf.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363834);
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(363843);
      this.AVf.ATx.onItemRangeRemoved(this.AVf.zJM + paramInt1, paramInt2);
      AppMethodBeat.o(363843);
    }
    
    public final void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363792);
      s.u(paramd, "reason");
      this.AVe.onPreFinishLoadMore(paramd);
      AppMethodBeat.o(363792);
    }
    
    public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363800);
      s.u(paramd, "reason");
      this.AVe.onPreFinishLoadMoreSmooth(paramd);
      AppMethodBeat.o(363800);
    }
    
    public final void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(363807);
      s.u(paramd, "reason");
      this.AVe.onPreFinishRefresh(paramd);
      AppMethodBeat.o(363807);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.j.b
 * JD-Core Version:    0.7.0.1
 */