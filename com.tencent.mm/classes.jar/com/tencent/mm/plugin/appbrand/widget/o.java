package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;

@TargetApi(21)
public final class o
  extends Drawable
{
  private final Paint mPaint;
  private final Rect mTempRect;
  final Rect rnW;
  private int rnX;
  public int rnY;
  
  public o()
  {
    AppMethodBeat.i(49371);
    this.rnW = new Rect();
    this.mTempRect = new Rect();
    this.mPaint = new Paint();
    this.rnX = 0;
    this.rnY = 0;
    AppMethodBeat.o(49371);
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(49372);
    if ((paramView == null) || (paramActivity == null))
    {
      AppMethodBeat.o(49372);
      return;
    }
    o localo = new o();
    final View localView = paramActivity.getWindow().getDecorView();
    paramView.setBackground(localo);
    View.OnApplyWindowInsetsListener local1 = new View.OnApplyWindowInsetsListener()
    {
      public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        AppMethodBeat.i(49370);
        this.rnZ.rnW.set(paramAnonymousWindowInsets.getSystemWindowInsetLeft(), paramAnonymousWindowInsets.getSystemWindowInsetTop(), paramAnonymousWindowInsets.getSystemWindowInsetRight(), paramAnonymousWindowInsets.getSystemWindowInsetBottom());
        w.G(paramAnonymousView);
        if (localView == paramAnonymousView)
        {
          AppMethodBeat.o(49370);
          return paramAnonymousWindowInsets;
        }
        paramAnonymousView = paramAnonymousView.onApplyWindowInsets(paramAnonymousWindowInsets);
        AppMethodBeat.o(49370);
        return paramAnonymousView;
      }
    };
    if (localView == paramView) {
      as.bt(paramActivity).a(local1);
    }
    for (;;)
    {
      localo.rnX = 0;
      localo.rnY = paramActivity.getWindow().getNavigationBarColor();
      AppMethodBeat.o(49372);
      return;
      paramView.setOnApplyWindowInsetsListener(local1);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(49373);
    Rect localRect = getBounds();
    if ((localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(49373);
      return;
    }
    int i = Math.min(localRect.top + this.rnW.top, localRect.bottom);
    int j = Math.min(localRect.left + this.rnW.left, localRect.right);
    int k = Math.max(localRect.right - this.rnW.right, localRect.left);
    int m = Math.max(localRect.bottom - this.rnW.bottom, localRect.top);
    if ((this.rnX != 0) && (this.rnW.top > 0))
    {
      this.mTempRect.set(j, localRect.top, k, i);
      this.mPaint.setColor(this.rnX);
      paramCanvas.drawRect(this.mTempRect, this.mPaint);
    }
    if (this.rnY != 0)
    {
      if (this.rnW.left > 0)
      {
        this.mTempRect.set(localRect.left, i, j, m);
        this.mPaint.setColor(this.rnY);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.rnW.right > 0)
      {
        this.mTempRect.set(k, i, localRect.right, m);
        this.mPaint.setColor(this.rnY);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.rnW.bottom > 0)
      {
        this.mTempRect.set(j, m, k, localRect.bottom);
        this.mPaint.setColor(this.rnY);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
    }
    AppMethodBeat.o(49373);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.o
 * JD-Core Version:    0.7.0.1
 */