package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;

public abstract interface c<VH extends RecyclerView.v>
{
  public abstract boolean Q(VH paramVH);
  
  public abstract boolean S(VH paramVH);
  
  public abstract void T(VH paramVH);
  
  public abstract void a(RecyclerView paramRecyclerView, VH paramVH, int paramInt, boolean paramBoolean1, boolean paramBoolean2, Runnable paramRunnable);
  
  public abstract boolean a(RecyclerView paramRecyclerView, VH paramVH1, VH paramVH2, int paramInt1, int paramInt2);
  
  public abstract void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract View e(RecyclerView paramRecyclerView, VH paramVH);
  
  public abstract void f(RecyclerView paramRecyclerView, VH paramVH);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.c
 * JD-Core Version:    0.7.0.1
 */