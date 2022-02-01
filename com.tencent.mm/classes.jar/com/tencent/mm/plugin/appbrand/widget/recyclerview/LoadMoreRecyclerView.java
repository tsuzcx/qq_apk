package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View fVr;
  private a nui;
  boolean nuj;
  
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
    final LinearLayoutManager localLinearLayoutManager = bBy();
    super.setLayoutManager(localLinearLayoutManager);
    a(new RecyclerView.m()
    {
      int nuk = 0;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131555);
        b localb = new b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        this.nuk = localLinearLayoutManager.ko();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(131555);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(131554);
        b localb = new b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if ((paramAnonymousInt == 0) && (LoadMoreRecyclerView.this.nuj) && (this.nuk == LoadMoreRecyclerView.this.nun.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).bBz();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(131554);
      }
    });
    this.nun.a(new RecyclerView.c()
    {
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(131556);
        super.av(paramAnonymousInt1, paramAnonymousInt2);
        if ((LoadMoreRecyclerView.this.nuj) && (localLinearLayoutManager.ko() == LoadMoreRecyclerView.this.nun.getItemCount() - 1) && (LoadMoreRecyclerView.a(LoadMoreRecyclerView.this) != null)) {
          LoadMoreRecyclerView.a(LoadMoreRecyclerView.this).bBz();
        }
        AppMethodBeat.o(131556);
      }
    });
    AppMethodBeat.o(131561);
  }
  
  public final void addFooterView(View paramView)
  {
    AppMethodBeat.i(131562);
    int i = this.nun.bGB() - 1;
    if ((this.fVr == null) || (i < 0))
    {
      super.addFooterView(paramView);
      AppMethodBeat.o(131562);
      return;
    }
    super.c(i, paramView);
    AppMethodBeat.o(131562);
  }
  
  protected LinearLayoutManager bBy()
  {
    AppMethodBeat.i(131560);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    AppMethodBeat.o(131560);
    return localLinearLayoutManager;
  }
  
  protected final boolean bGC()
  {
    AppMethodBeat.i(131566);
    if (this.fVr != null)
    {
      if ((this.nun.getItemCount() == 1) && (this.nun.bGB() == 1))
      {
        AppMethodBeat.o(131566);
        return true;
      }
      AppMethodBeat.o(131566);
      return false;
    }
    boolean bool = super.bGC();
    AppMethodBeat.o(131566);
    return bool;
  }
  
  public void setLayoutManager(RecyclerView.i parami) {}
  
  public void setLoadingView(int paramInt)
  {
    AppMethodBeat.i(131564);
    setLoadingView(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
    AppMethodBeat.o(131564);
  }
  
  public void setLoadingView(View paramView)
  {
    AppMethodBeat.i(131563);
    if (this.fVr == paramView)
    {
      AppMethodBeat.o(131563);
      return;
    }
    if ((this.fVr != null) && (!this.fVr.equals(paramView))) {
      du(this.fVr);
    }
    this.fVr = paramView;
    if (this.fVr != null)
    {
      addFooterView(this.fVr);
      paramView = this.fVr;
      if (!this.nuj) {
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
    this.nui = parama;
  }
  
  public final void showLoading(boolean paramBoolean)
  {
    AppMethodBeat.i(131565);
    if (this.nuj == paramBoolean)
    {
      AppMethodBeat.o(131565);
      return;
    }
    this.nuj = paramBoolean;
    View localView;
    if (this.fVr != null)
    {
      localView = this.fVr;
      if (!this.nuj) {
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
    public abstract void bBz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */