package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View jkB;
  private a rFV;
  boolean rFW;
  
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
    final LinearLayoutManager localLinearLayoutManager = cli();
    super.setLayoutManager(localLinearLayoutManager);
    a(new RecyclerView.l()
    {
      int rFX = 0;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(229403);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (LoadMoreRecyclerView.this.rFW) && (this.rFX == LoadMoreRecyclerView.this.rGa.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).clj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(229403);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(229406);
        b localb = new b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.rFX = localLinearLayoutManager.kL();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(229406);
      }
    });
    this.rGa.a(new RecyclerView.c()
    {
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131556);
        super.onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        if ((LoadMoreRecyclerView.this.rFW) && (localLinearLayoutManager.kL() == LoadMoreRecyclerView.this.rGa.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).clj();
        }
        AppMethodBeat.o(131556);
      }
    });
    AppMethodBeat.o(131561);
  }
  
  protected LinearLayoutManager cli()
  {
    AppMethodBeat.i(230689);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    AppMethodBeat.o(230689);
    return localLinearLayoutManager;
  }
  
  protected final boolean cqn()
  {
    AppMethodBeat.i(131566);
    if (this.jkB != null)
    {
      if ((this.rGa.getItemCount() == 1) && (this.rGa.cqm() == 1))
      {
        AppMethodBeat.o(131566);
        return true;
      }
      AppMethodBeat.o(131566);
      return false;
    }
    boolean bool = super.cqn();
    AppMethodBeat.o(131566);
    return bool;
  }
  
  public final void dG(View paramView)
  {
    AppMethodBeat.i(131562);
    int i = this.rGa.cqm() - 1;
    if ((this.jkB == null) || (i < 0))
    {
      super.dG(paramView);
      AppMethodBeat.o(131562);
      return;
    }
    super.c(i, paramView);
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
    if (this.jkB == paramView)
    {
      AppMethodBeat.o(131563);
      return;
    }
    if ((this.jkB != null) && (!this.jkB.equals(paramView))) {
      dH(this.jkB);
    }
    this.jkB = paramView;
    if (this.jkB != null)
    {
      dG(this.jkB);
      paramView = this.jkB;
      if (!this.rFW) {
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
    this.rFV = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(131565);
    if (this.rFW == paramBoolean)
    {
      AppMethodBeat.o(131565);
      return;
    }
    this.rFW = paramBoolean;
    View localView;
    if (this.jkB != null)
    {
      localView = this.jkB;
      if (!this.rFW) {
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
    public abstract void clj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */