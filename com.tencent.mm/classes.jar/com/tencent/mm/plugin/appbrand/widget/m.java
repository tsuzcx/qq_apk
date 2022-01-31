package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ah;

@TargetApi(21)
public final class m
  extends Drawable
{
  final Rect fa;
  private int jaJ;
  public int jaK;
  private final Paint mPaint;
  private final Rect mTempRect;
  
  public m()
  {
    AppMethodBeat.i(143622);
    this.fa = new Rect();
    this.mTempRect = new Rect();
    this.mPaint = new Paint();
    this.jaJ = 0;
    this.jaK = 0;
    AppMethodBeat.o(143622);
  }
  
  public static void a(Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(143623);
    if ((paramView == null) || (paramActivity == null))
    {
      AppMethodBeat.o(143623);
      return;
    }
    m localm = new m();
    View localView = paramActivity.getWindow().getDecorView();
    paramView.setBackground(localm);
    m.1 local1 = new m.1(localm, localView);
    if (localView == paramView) {
      ah.aB(paramActivity).a(local1);
    }
    for (;;)
    {
      localm.jaJ = 0;
      localm.jaK = paramActivity.getWindow().getNavigationBarColor();
      AppMethodBeat.o(143623);
      return;
      paramView.setOnApplyWindowInsetsListener(local1);
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(143624);
    Rect localRect = getBounds();
    if ((localRect.width() <= 0) || (localRect.height() <= 0))
    {
      AppMethodBeat.o(143624);
      return;
    }
    int i = Math.min(localRect.top + this.fa.top, localRect.bottom);
    int j = Math.min(localRect.left + this.fa.left, localRect.right);
    int k = Math.max(localRect.right - this.fa.right, localRect.left);
    int m = Math.max(localRect.bottom - this.fa.bottom, localRect.top);
    if ((this.jaJ != 0) && (this.fa.top > 0))
    {
      this.mTempRect.set(j, localRect.top, k, i);
      this.mPaint.setColor(this.jaJ);
      paramCanvas.drawRect(this.mTempRect, this.mPaint);
    }
    if (this.jaK != 0)
    {
      if (this.fa.left > 0)
      {
        this.mTempRect.set(localRect.left, i, j, m);
        this.mPaint.setColor(this.jaK);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.fa.right > 0)
      {
        this.mTempRect.set(k, i, localRect.right, m);
        this.mPaint.setColor(this.jaK);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.fa.bottom > 0)
      {
        this.mTempRect.set(j, m, k, localRect.bottom);
        this.mPaint.setColor(this.jaK);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
    }
    AppMethodBeat.o(143624);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.m
 * JD-Core Version:    0.7.0.1
 */