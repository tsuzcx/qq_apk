package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

public final class w
  extends RecyclerView.h
{
  private static final int[] GC = { 16843284 };
  private Drawable acK;
  private int mOrientation;
  private final Rect qA = new Rect();
  
  public w(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(GC);
    this.acK = paramContext.getDrawable(0);
    paramContext.recycle();
    this.mOrientation = 1;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    if ((paramRecyclerView.getLayoutManager() == null) || (this.acK == null)) {
      return;
    }
    int j;
    int i;
    int n;
    int i1;
    if (this.mOrientation == 1)
    {
      paramCanvas.save();
      if (paramRecyclerView.getClipToPadding())
      {
        j = paramRecyclerView.getPaddingLeft();
        i = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
        paramCanvas.clipRect(j, paramRecyclerView.getPaddingTop(), i, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
      }
      for (;;)
      {
        m = paramRecyclerView.getChildCount();
        while (k < m)
        {
          params = paramRecyclerView.getChildAt(k);
          RecyclerView.d(params, this.qA);
          n = this.qA.bottom;
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.acK.getIntrinsicHeight();
          this.acK.setBounds(j, n - i1, i, n);
          this.acK.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      return;
    }
    paramCanvas.save();
    if (paramRecyclerView.getClipToPadding())
    {
      j = paramRecyclerView.getPaddingTop();
      i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
    }
    for (;;)
    {
      n = paramRecyclerView.getChildCount();
      k = m;
      while (k < n)
      {
        params = paramRecyclerView.getChildAt(k);
        paramRecyclerView.getLayoutManager();
        RecyclerView.i.d(params, this.qA);
        m = this.qA.right;
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.acK.getIntrinsicWidth();
        this.acK.setBounds(m - i1, j, m, i);
        this.acK.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    if (this.acK == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.acK.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.acK.getIntrinsicWidth(), 0);
  }
  
  public final void setDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new IllegalArgumentException("Drawable cannot be null.");
    }
    this.acK = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.w
 * JD-Core Version:    0.7.0.1
 */