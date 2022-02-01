package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends RecyclerView.h
{
  private static final int[] pD = { 16843284 };
  private final Rect mBounds;
  private int mOrientation;
  private Drawable tP;
  
  public h(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(194777);
    this.mBounds = new Rect();
    paramContext = paramContext.obtainStyledAttributes(pD);
    this.tP = paramContext.getDrawable(0);
    paramContext.recycle();
    if ((paramInt != 0) && (paramInt != 1))
    {
      paramContext = new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
      AppMethodBeat.o(194777);
      throw paramContext;
    }
    this.mOrientation = paramInt;
    AppMethodBeat.o(194777);
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(194808);
    if ((paramRecyclerView.getLayoutManager() == null) || (this.tP == null))
    {
      AppMethodBeat.o(194808);
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
          i1 = this.tP.getIntrinsicHeight();
          this.tP.setBounds(j, n - i1, i, n);
          this.tP.draw(paramCanvas);
          k += 1;
        }
        i = paramRecyclerView.getWidth();
        j = 0;
      }
      paramCanvas.restore();
      AppMethodBeat.o(194808);
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
        i1 = this.tP.getIntrinsicWidth();
        this.tP.setBounds(m - i1, j, m, i);
        this.tP.draw(paramCanvas);
        k += 1;
      }
      i = paramRecyclerView.getHeight();
      j = 0;
    }
    paramCanvas.restore();
    AppMethodBeat.o(194808);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(194815);
    if (this.tP == null)
    {
      paramRect.set(0, 0, 0, 0);
      AppMethodBeat.o(194815);
      return;
    }
    if (this.mOrientation == 1)
    {
      paramRect.set(0, 0, 0, this.tP.getIntrinsicHeight());
      AppMethodBeat.o(194815);
      return;
    }
    paramRect.set(0, 0, this.tP.getIntrinsicWidth(), 0);
    AppMethodBeat.o(194815);
  }
  
  public final void w(Drawable paramDrawable)
  {
    AppMethodBeat.i(194791);
    if (paramDrawable == null)
    {
      paramDrawable = new IllegalArgumentException("Drawable cannot be null.");
      AppMethodBeat.o(194791);
      throw paramDrawable;
    }
    this.tP = paramDrawable;
    AppMethodBeat.o(194791);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.h
 * JD-Core Version:    0.7.0.1
 */