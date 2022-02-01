package com.tencent.mm.plugin.finder.feed.flow;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;

public final class f
  extends RecyclerView.h
{
  private final int horizontalSpacing;
  private final int verticalSpacing;
  
  public f(int paramInt1, int paramInt2)
  {
    this.horizontalSpacing = paramInt1;
    this.verticalSpacing = paramInt2;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    paramRect.left = (this.horizontalSpacing / 2);
    paramRect.right = (this.horizontalSpacing / 2);
    paramRect.top = (this.verticalSpacing / 2);
    paramRect.bottom = (this.verticalSpacing / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.f
 * JD-Core Version:    0.7.0.1
 */