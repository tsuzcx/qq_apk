package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends RecyclerView.h
{
  private static final int[] oG = { 16843284 };
  private final Rect mBounds;
  private int mOrientation;
  private Drawable sQ;
  
  public i(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(261064);
    this.mBounds = new Rect();
    paramContext = paramContext.obtainStyledAttributes(oG);
    this.sQ = paramContext.getDrawable(0);
    paramContext.recycle();
    if ((paramInt != 0) && (paramInt != 1))
    {
      paramContext = new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
      AppMethodBeat.o(261064);
      throw paramContext;
    }
    this.mOrientation = paramInt;
    AppMethodBeat.o(261064);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(261071);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.sQ == null))
    {
      AppMethodBeat.o(261071);
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
          RecyclerView.getDecoratedBoundsWithMargins(params, this.mBounds);
          n = this.mBounds.bottom;
          n = Math.round(params.getTranslationY()) + n;
          i1 = this.sQ.getIntrinsicHeight();
          this.sQ.setBounds(j, n - i1, i, n);
          this.sQ.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      AppMethodBeat.o(261071);
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
        paramRecyclerView.getLayoutManager().getDecoratedBoundsWithMargins(params, this.mBounds);
        m = this.mBounds.right;
        m = Math.round(params.getTranslationX()) + m;
        i1 = this.sQ.getIntrinsicWidth();
        this.sQ.setBounds(m - i1, j, m, i);
        this.sQ.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(261071);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(261074);
    if (this.sQ == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(261074);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.sQ.getIntrinsicHeight());
      AppMethodBeat.o(261074);
      return;
    }
    paramRect.set(0, 0, this.sQ.getIntrinsicWidth(), 0);
    AppMethodBeat.o(261074);
  }
  
  public final void t(Drawable paramDrawable)
  {
    AppMethodBeat.i(261066);
    if (paramDrawable == null)
    {
      paramDrawable = new IllegalArgumentException("Drawable cannot be null.");
      AppMethodBeat.o(261066);
      throw paramDrawable;
    }
    this.sQ = paramDrawable;
    AppMethodBeat.o(261066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.i
 * JD-Core Version:    0.7.0.1
 */