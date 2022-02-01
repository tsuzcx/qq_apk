package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.k;
import com.tencent.mm.view.refreshLayout.WxRefreshLayout;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "reportAction", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$ActionCallback;", "getReportAction", "()Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$ActionCallback;", "setReportAction", "(Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$ActionCallback;)V", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "notifyRefreshFinish", "", "notifyRefreshStart", "isAuto", "", "ActionCallback", "BaseViewActionCallback", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderRefreshLayout
  extends WxRefreshLayout
{
  private a GCa;
  
  public FinderRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FinderRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(346113);
    AppMethodBeat.o(346113);
  }
  
  public final void flf()
  {
    AppMethodBeat.i(346149);
    a locala = this.GCa;
    if (locala != null) {
      locala.eby();
    }
    AppMethodBeat.o(346149);
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(346134);
    Object localObject = getContentView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.view.refreshLayout.b.a)localObject).getView())
    {
      localObject = (RecyclerView)localObject;
      AppMethodBeat.o(346134);
      return localObject;
    }
  }
  
  public final a getReportAction()
  {
    return this.GCa;
  }
  
  public final void setReportAction(a parama)
  {
    this.GCa = parama;
  }
  
  public final void uZ(boolean paramBoolean)
  {
    AppMethodBeat.i(346142);
    a locala = this.GCa;
    if (locala != null) {
      locala.tL(paramBoolean);
    }
    AppMethodBeat.o(346142);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$ActionCallback;", "", "()V", "onRefreshBegin", "", "isAuto", "", "onRefreshEnd", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    public void eby() {}
    
    public void tL(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout$BaseViewActionCallback;", "Lcom/tencent/mm/view/IViewActionCallback;", "rlLayout", "Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "(Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;)V", "getRlLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderRefreshLayout;", "getHeaderCount", "", "onChanged", "", "onItemRangeChanged", "positionStart", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "updateState", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class b
    implements k
  {
    public final FinderRefreshLayout GCb;
    
    public b(FinderRefreshLayout paramFinderRefreshLayout)
    {
      AppMethodBeat.i(344860);
      this.GCb = paramFinderRefreshLayout;
      AppMethodBeat.o(344860);
    }
    
    public void evt() {}
    
    public int getHeaderCount()
    {
      return 0;
    }
    
    public void onChanged()
    {
      AppMethodBeat.i(344866);
      Object localObject = this.GCb.getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
      evt();
      AppMethodBeat.o(344866);
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344870);
      Object localObject = this.GCb.getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).by(getHeaderCount() + paramInt1, paramInt2);
        }
      }
      evt();
      AppMethodBeat.o(344870);
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(344876);
      Object localObject = this.GCb.getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).e(getHeaderCount() + paramInt1, paramInt2, paramObject);
        }
      }
      evt();
      AppMethodBeat.o(344876);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344880);
      Object localObject = this.GCb.getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bA(getHeaderCount() + paramInt1, paramInt2);
        }
      }
      evt();
      AppMethodBeat.o(344880);
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(344887);
      Object localObject = this.GCb.getRecyclerView();
      if (localObject != null)
      {
        localObject = ((RecyclerView)localObject).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).bB(getHeaderCount() + paramInt1, paramInt2);
        }
      }
      evt();
      AppMethodBeat.o(344887);
    }
    
    public void onPreFinishLoadMore(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(344905);
      s.u(paramd, "reason");
      this.GCb.Oe(true);
      evt();
      AppMethodBeat.o(344905);
    }
    
    public void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(344910);
      s.u(paramd, "reason");
      this.GCb.Oe(true);
      evt();
      AppMethodBeat.o(344910);
    }
    
    public void onPreFinishRefresh(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(344897);
      s.u(paramd, "reason");
      if (paramd.agJv <= 0) {
        this.GCb.jNx();
      }
      for (;;)
      {
        paramd = this.GCb.getRecyclerView();
        if (paramd != null)
        {
          com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
          com.tencent.mm.hellhoundlib.a.a.b(paramd, locala.aYi(), "com/tencent/mm/plugin/finder/view/FinderRefreshLayout$BaseViewActionCallback", "onPreFinishRefresh", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
          paramd.scrollToPosition(((Integer)locala.sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(paramd, "com/tencent/mm/plugin/finder/view/FinderRefreshLayout$BaseViewActionCallback", "onPreFinishRefresh", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", "Undefined", "scrollToPosition", "(I)V");
        }
        evt();
        AppMethodBeat.o(344897);
        return;
        this.GCb.Od(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderRefreshLayout
 * JD-Core Version:    0.7.0.1
 */