package com.tencent.mm.plugin.appbrand.widget;

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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ay;

public final class r
  extends Drawable
{
  private final Paint mPaint;
  private final Rect mTempRect;
  final Rect uxR;
  private int uxS;
  public int uxT;
  
  public r()
  {
    AppMethodBeat.i(49371);
    this.uxR = new Rect();
    this.mTempRect = new Rect();
    this.mPaint = new Paint();
    this.uxS = 0;
    this.uxT = 0;
    AppMethodBeat.o(49371);
  }
  
  public static void b(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(49372);
    if ((paramView == null) || (paramActivity == null))
    {
      AppMethodBeat.o(49372);
      return;
    }
    r localr = new r();
    final View localView = paramActivity.getWindow().getDecorView();
    paramView.setBackground(localr);
    View.OnApplyWindowInsetsListener local1 = new View.OnApplyWindowInsetsListener()
    {
      public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        AppMethodBeat.i(49370);
        r.this.uxR.set(paramAnonymousWindowInsets.getSystemWindowInsetLeft(), paramAnonymousWindowInsets.getSystemWindowInsetTop(), paramAnonymousWindowInsets.getSystemWindowInsetRight(), paramAnonymousWindowInsets.getSystemWindowInsetBottom());
        z.Q(paramAnonymousView);
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
      ay.bX(paramActivity).a(local1);
    }
    for (;;)
    {
      localr.uxS = 0;
      localr.uxT = paramActivity.getWindow().getNavigationBarColor();
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
    int i = Math.min(localRect.top + this.uxR.top, localRect.bottom);
    int j = Math.min(localRect.left + this.uxR.left, localRect.right);
    int k = Math.max(localRect.right - this.uxR.right, localRect.left);
    int m = Math.max(localRect.bottom - this.uxR.bottom, localRect.top);
    if ((this.uxS != 0) && (this.uxR.top > 0))
    {
      this.mTempRect.set(j, localRect.top, k, i);
      this.mPaint.setColor(this.uxS);
      paramCanvas.drawRect(this.mTempRect, this.mPaint);
    }
    if (this.uxT != 0)
    {
      if (this.uxR.left > 0)
      {
        this.mTempRect.set(localRect.left, i, j, m);
        this.mPaint.setColor(this.uxT);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.uxR.right > 0)
      {
        this.mTempRect.set(k, i, localRect.right, m);
        this.mPaint.setColor(this.uxT);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.uxR.bottom > 0)
      {
        this.mTempRect.set(j, m, k, localRect.bottom);
        this.mPaint.setColor(this.uxT);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.r
 * JD-Core Version:    0.7.0.1
 */