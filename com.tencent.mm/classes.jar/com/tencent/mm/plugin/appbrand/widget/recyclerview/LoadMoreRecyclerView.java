package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View lNf;
  private a uRh;
  boolean uRi;
  
  public LoadMoreRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131557);
    init();
    AppMethodBeat.o(131557);
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(131558);
    init();
    AppMethodBeat.o(131558);
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(131559);
    init();
    AppMethodBeat.o(131559);
  }
  
  private void init()
  {
    AppMethodBeat.i(131561);
    final LinearLayoutManager localLinearLayoutManager = cMG();
    super.setLayoutManager(localLinearLayoutManager);
    a(new RecyclerView.l()
    {
      int uRj = 0;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(323996);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (LoadMoreRecyclerView.this.uRi) && (this.uRj == LoadMoreRecyclerView.this.uRm.getItemCount() - 1) && (LoadMoreRecyclerView.c(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.c(LoadMoreRecyclerView.this).onLoadMore(LoadMoreRecyclerView.this, LoadMoreRecyclerView.this.uRm.bUp);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(323996);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(324000);
        b localb = new b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.uRj = localLinearLayoutManager.Jw();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(324000);
      }
    });
    this.uRm.a(new RecyclerView.c()
    {
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131556);
        super.onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        if ((LoadMoreRecyclerView.this.uRi) && (localLinearLayoutManager.Jw() == LoadMoreRecyclerView.this.uRm.getItemCount() - 1) && (LoadMoreRecyclerView.c(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.c(LoadMoreRecyclerView.this).onLoadMore(LoadMoreRecyclerView.this, LoadMoreRecyclerView.this.uRm.bUp);
        }
        AppMethodBeat.o(131556);
      }
    });
    AppMethodBeat.o(131561);
  }
  
  protected LinearLayoutManager cMG()
  {
    AppMethodBeat.i(324002);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    AppMethodBeat.o(324002);
    return localLinearLayoutManager;
  }
  
  protected final boolean cSU()
  {
    AppMethodBeat.i(131566);
    if (this.lNf != null)
    {
      if ((this.uRm.getItemCount() == 1) && (this.uRm.cST() == 1))
      {
        AppMethodBeat.o(131566);
        return true;
      }
      AppMethodBeat.o(131566);
      return false;
    }
    boolean bool = super.cSU();
    AppMethodBeat.o(131566);
    return bool;
  }
  
  public final void et(View paramView)
  {
    AppMethodBeat.i(131562);
    int i = this.uRm.cST() - 1;
    if ((this.lNf == null) || (i < 0))
    {
      super.et(paramView);
      AppMethodBeat.o(131562);
      return;
    }
    super.e(i, paramView);
    AppMethodBeat.o(131562);
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager) {}
  
  public void setLoadingView(int paramInt)
  {
    AppMethodBeat.i(131564);
    setLoadingView(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
    AppMethodBeat.o(131564);
  }
  
  public void setLoadingView(View paramView)
  {
    AppMethodBeat.i(131563);
    if (this.lNf == paramView)
    {
      AppMethodBeat.o(131563);
      return;
    }
    if ((this.lNf != null) && (!this.lNf.equals(paramView))) {
      eu(this.lNf);
    }
    this.lNf = paramView;
    if (this.lNf != null)
    {
      et(this.lNf);
      paramView = this.lNf;
      if (!this.uRi) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(131563);
      return;
    }
  }
  
  public void setOnLoadingStateChangedListener(a parama)
  {
    this.uRh = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(131565);
    if (this.uRi == paramBoolean)
    {
      AppMethodBeat.o(131565);
      return;
    }
    this.uRi = paramBoolean;
    View localView;
    if (this.lNf != null)
    {
      localView = this.lNf;
      if (!this.uRi) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(131565);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLoadMore(LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */