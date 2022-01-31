package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;

public abstract interface b<VH extends RecyclerView.v>
{
  public abstract boolean J(VH paramVH);
  
  public abstract boolean L(VH paramVH);
  
  public abstract boolean M(VH paramVH);
  
  public abstract void a(RecyclerView paramRecyclerView, VH paramVH, int paramInt, Runnable paramRunnable);
  
  public abstract void a(View paramView, float paramFloat1, float paramFloat2, RecyclerView.v paramv);
  
  public abstract boolean a(RecyclerView paramRecyclerView, VH paramVH1, VH paramVH2, int paramInt1, int paramInt2);
  
  public abstract View c(RecyclerView paramRecyclerView, VH paramVH);
  
  public abstract void d(RecyclerView paramRecyclerView, VH paramVH);
  
  public abstract void i(RecyclerView paramRecyclerView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.b
 * JD-Core Version:    0.7.0.1
 */