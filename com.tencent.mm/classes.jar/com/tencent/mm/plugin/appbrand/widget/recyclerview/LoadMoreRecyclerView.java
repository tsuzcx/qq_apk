package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class LoadMoreRecyclerView
  extends MRecyclerView
{
  private View drU;
  private LoadMoreRecyclerView.a hDO;
  boolean hDP;
  
  public LoadMoreRecyclerView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public LoadMoreRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LinearLayoutManager localLinearLayoutManager = apO();
    super.setLayoutManager(localLinearLayoutManager);
    a(new LoadMoreRecyclerView.1(this, localLinearLayoutManager));
    this.hDT.a(new LoadMoreRecyclerView.2(this, localLinearLayoutManager));
  }
  
  public final void addFooterView(View paramView)
  {
    int i = this.hDT.atb() - 1;
    if ((this.drU == null) || (i < 0))
    {
      super.addFooterView(paramView);
      return;
    }
    super.a(i, paramView);
  }
  
  public LinearLayoutManager apO()
  {
    getContext();
    return new LinearLayoutManager();
  }
  
  protected final boolean atc()
  {
    if (this.drU != null) {
      return (this.hDT.getItemCount() == 1) && (this.hDT.atb() == 1);
    }
    return super.atc();
  }
  
  public final void dZ(boolean paramBoolean)
  {
    if (this.hDP == paramBoolean) {}
    do
    {
      return;
      this.hDP = paramBoolean;
    } while (this.drU == null);
    View localView = this.drU;
    if (this.hDP) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setLayoutManager(RecyclerView.i parami) {}
  
  public void setLoadingView(int paramInt)
  {
    setLoadingView(LayoutInflater.from(getContext()).inflate(paramInt, this, false));
  }
  
  public void setLoadingView(View paramView)
  {
    if (this.drU == paramView) {}
    do
    {
      return;
      if ((this.drU != null) && (!this.drU.equals(paramView))) {
        cv(this.drU);
      }
      this.drU = paramView;
    } while (this.drU == null);
    addFooterView(this.drU);
    paramView = this.drU;
    if (this.hDP) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  public void setOnLoadingStateChangedListener(LoadMoreRecyclerView.a parama)
  {
    this.hDO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView
 * JD-Core Version:    0.7.0.1
 */