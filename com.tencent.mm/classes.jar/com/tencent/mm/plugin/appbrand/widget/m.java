package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.am;

@TargetApi(21)
public final class m
  extends Drawable
{
  private final Paint mPaint;
  private final Rect mTempRect;
  final Rect mTm;
  private int mTn;
  public int mTo;
  
  public m()
  {
    AppMethodBeat.i(49371);
    this.mTm = new Rect();
    this.mTempRect = new Rect();
    this.mPaint = new Paint();
    this.mTn = 0;
    this.mTo = 0;
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
    m localm = new m();
    final View localView = paramActivity.getWindow().getDecorView();
    paramView.setBackground(localm);
    View.OnApplyWindowInsetsListener local1 = new View.OnApplyWindowInsetsListener()
    {
      public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
      {
        AppMethodBeat.i(49370);
        this.mTp.mTm.set(paramAnonymousWindowInsets.getSystemWindowInsetLeft(), paramAnonymousWindowInsets.getSystemWindowInsetTop(), paramAnonymousWindowInsets.getSystemWindowInsetRight(), paramAnonymousWindowInsets.getSystemWindowInsetBottom());
        t.W(paramAnonymousView);
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
      am.bg(paramActivity).a(local1);
    }
    for (;;)
    {
      localm.mTn = 0;
      localm.mTo = paramActivity.getWindow().getNavigationBarColor();
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
    int i = Math.min(localRect.top + this.mTm.top, localRect.bottom);
    int j = Math.min(localRect.left + this.mTm.left, localRect.right);
    int k = Math.max(localRect.right - this.mTm.right, localRect.left);
    int m = Math.max(localRect.bottom - this.mTm.bottom, localRect.top);
    if ((this.mTn != 0) && (this.mTm.top > 0))
    {
      this.mTempRect.set(j, localRect.top, k, i);
      this.mPaint.setColor(this.mTn);
      paramCanvas.drawRect(this.mTempRect, this.mPaint);
    }
    if (this.mTo != 0)
    {
      if (this.mTm.left > 0)
      {
        this.mTempRect.set(localRect.left, i, j, m);
        this.mPaint.setColor(this.mTo);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.mTm.right > 0)
      {
        this.mTempRect.set(k, i, localRect.right, m);
        this.mPaint.setColor(this.mTo);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.mTm.bottom > 0)
      {
        this.mTempRect.set(j, m, k, localRect.bottom);
        this.mPaint.setColor(this.mTo);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.m
 * JD-Core Version:    0.7.0.1
 */