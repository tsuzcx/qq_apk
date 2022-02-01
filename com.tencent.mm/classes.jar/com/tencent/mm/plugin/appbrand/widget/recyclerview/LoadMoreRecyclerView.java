package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View gAy;
  private a oEm;
  boolean oEn;
  
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
    final LinearLayoutManager localLinearLayoutManager = bYx();
    super.setLayoutManager(localLinearLayoutManager);
    a(new RecyclerView.l()
    {
      int oEo = 0;
      
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(131554);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (LoadMoreRecyclerView.this.oEn) && (this.oEo == LoadMoreRecyclerView.this.oEr.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).bYy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(131554);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131555);
        b localb = new b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.oEo = localLinearLayoutManager.ku();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(131555);
      }
    });
    this.oEr.a(new RecyclerView.c()
    {
      public final void onItemRangeRemoved(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131556);
        super.onItemRangeRemoved(paramAnonymousInt1, paramAnonymousInt2);
        if ((LoadMoreRecyclerView.this.oEn) && (localLinearLayoutManager.ku() == LoadMoreRecyclerView.this.oEr.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).bYy();
        }
        AppMethodBeat.o(131556);
      }
    });
    AppMethodBeat.o(131561);
  }
  
  public final void addFooterView(View paramView)
  {
    AppMethodBeat.i(131562);
    int i = this.oEr.cda() - 1;
    if ((this.gAy == null) || (i < 0))
    {
      super.addFooterView(paramView);
      AppMethodBeat.o(131562);
      return;
    }
    super.c(i, paramView);
    AppMethodBeat.o(131562);
  }
  
  protected LinearLayoutManager bYx()
  {
    AppMethodBeat.i(131560);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    AppMethodBeat.o(131560);
    return localLinearLayoutManager;
  }
  
  protected final boolean cdb()
  {
    AppMethodBeat.i(131566);
    if (this.gAy != null)
    {
      if ((this.oEr.getItemCount() == 1) && (this.oEr.cda() == 1))
      {
        AppMethodBeat.o(131566);
        return true;
      }
      AppMethodBeat.o(131566);
      return false;
    }
    boolean bool = super.cdb();
    AppMethodBeat.o(131566);
    return bool;
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
    if (this.gAy == paramView)
    {
      AppMethodBeat.o(131563);
      return;
    }
    if ((this.gAy != null) && (!this.gAy.equals(paramView))) {
      dl(this.gAy);
    }
    this.gAy = paramView;
    if (this.gAy != null)
    {
      addFooterView(this.gAy);
      paramView = this.gAy;
      if (!this.oEn) {
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
    this.oEm = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(131565);
    if (this.oEn == paramBoolean)
    {
      AppMethodBeat.o(131565);
      return;
    }
    this.oEn = paramBoolean;
    View localView;
    if (this.gAy != null)
    {
      localView = this.gAy;
      if (!this.oEn) {
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
    public abstract void bYy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */