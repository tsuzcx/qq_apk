package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View ejC;
  private LoadMoreRecyclerView.a jwo;
  boolean jwp;
  
  public LoadMoreRecyclerView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(77481);
    init();
    AppMethodBeat.o(77481);
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(77482);
    init();
    AppMethodBeat.o(77482);
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(77483);
    init();
    AppMethodBeat.o(77483);
  }
  
  private void init()
  {
    AppMethodBeat.i(77485);
    LinearLayoutManager localLinearLayoutManager = aNi();
    super.setLayoutManager(localLinearLayoutManager);
    a(new LoadMoreRecyclerView.1(this, localLinearLayoutManager));
    this.jwt.a(new LoadMoreRecyclerView.2(this, localLinearLayoutManager));
    AppMethodBeat.o(77485);
  }
  
  protected LinearLayoutManager aNi()
  {
    AppMethodBeat.i(77484);
    getContext();
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
    AppMethodBeat.o(77484);
    return localLinearLayoutManager;
  }
  
  protected final boolean aSm()
  {
    AppMethodBeat.i(77490);
    if (this.ejC != null)
    {
      if ((this.jwt.getItemCount() == 1) && (this.jwt.aSl() == 1))
      {
        AppMethodBeat.o(77490);
        return true;
      }
      AppMethodBeat.o(77490);
      return false;
    }
    boolean bool = super.aSm();
    AppMethodBeat.o(77490);
    return bool;
  }
  
  public final void addFooterView(View paramView)
  {
    AppMethodBeat.i(77486);
    int i = this.jwt.aSl() - 1;
    if ((this.ejC == null) || (i < 0))
    {
      super.addFooterView(paramView);
      AppMethodBeat.o(77486);
      return;
    }
    super.b(i, paramView);
    AppMethodBeat.o(77486);
  }
  
  public final void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(77489);
    if (this.jwp == paramBoolean)
    {
      AppMethodBeat.o(77489);
      return;
    }
    this.jwp = paramBoolean;
    View localView;
    if (this.ejC != null)
    {
      localView = this.ejC;
      if (!this.jwp) {
        break label56;
      }
    }
    label56:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(77489);
      return;
    }
  }
  
  public void setLayoutManager(RecyclerView.i parami) {}
  
  public void setLoadingView(int paramInt)
  {
    AppMethodBeat.i(77488);
    setLoadingView(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
    AppMethodBeat.o(77488);
  }
  
  public void setLoadingView(View paramView)
  {
    AppMethodBeat.i(77487);
    if (this.ejC == paramView)
    {
      AppMethodBeat.o(77487);
      return;
    }
    if ((this.ejC != null) && (!this.ejC.equals(paramView))) {
      cZ(this.ejC);
    }
    this.ejC = paramView;
    if (this.ejC != null)
    {
      addFooterView(this.ejC);
      paramView = this.ejC;
      if (!this.jwp) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      AppMethodBeat.o(77487);
      return;
    }
  }
  
  public void setOnLoadingStateChangedListener(LoadMoreRecyclerView.a parama)
  {
    this.jwo = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */