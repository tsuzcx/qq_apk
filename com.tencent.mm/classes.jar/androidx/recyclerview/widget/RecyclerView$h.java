package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public abstract class RecyclerView$h
{
  public void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params) {}
  
  @Deprecated
  public void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
  {
    paramRect.set(0, 0, 0, 0);
  }
  
  public void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    a(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).bXh.KI(), paramRecyclerView);
  }
  
  public void b(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.h
 * JD-Core Version:    0.7.0.1
 */