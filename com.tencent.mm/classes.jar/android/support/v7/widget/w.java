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
  private static final int[] Qo = { 16843284 };
  private Drawable amC;
  private final Rect mBounds = new Rect();
  private int mOrientation;
  
  public w(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(Qo);
    this.amC = paramContext.getDrawable(0);
    paramContext.recycle();
    this.mOrientation = 1;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    int m = 0;
    int k = 0;
    if ((paramRecyclerView.getLayoutManager() == null) || (this.amC == null)) {
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
          paramt = paramRecyclerView.getChildAt(k);
          RecyclerView.c(paramt, this.mBounds);
          n = this.mBounds.bottom;
          n = Math.round(paramt.getTranslationY()) + n;
          i1 = this.amC.getIntrinsicHeight();
          this.amC.setBounds(j, n - i1, i, n);
          this.amC.draw(paramCanvas);
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
        paramt = paramRecyclerView.getChildAt(k);
        paramRecyclerView.getLayoutManager();
        RecyclerView.i.c(paramt, this.mBounds);
        m = this.mBounds.right;
        m = Math.round(paramt.getTranslationX()) + m;
        i1 = this.amC.getIntrinsicWidth();
        this.amC.setBounds(m - i1, j, m, i);
        this.amC.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
  {
    if (this.amC == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.amC.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, this.amC.getIntrinsicWidth(), 0);
  }
  
  public final void setDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      throw new IllegalArgumentException("Drawable cannot be null.");
    }
    this.amC = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.w
 * JD-Core Version:    0.7.0.1
 */