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
import com.tencent.mm.ui.ap;

@TargetApi(21)
public final class l
  extends Drawable
{
  private final Paint mPaint;
  private final Rect mTempRect;
  private int olA;
  public int olB;
  final Rect olz;
  
  public l()
  {
    AppMethodBeat.i(49371);
    this.olz = new Rect();
    this.mTempRect = new Rect();
    this.mPaint = new Paint();
    this.olA = 0;
    this.olB = 0;
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
    l locall = new l();
    View localView = paramActivity.getWindow().getDecorView();
    paramView.setBackground(locall);
    l.1 local1 = new l.1(locall, localView);
    if (localView == paramView) {
      ap.bn(paramActivity).a(local1);
    }
    for (;;)
    {
      locall.olA = 0;
      locall.olB = paramActivity.getWindow().getNavigationBarColor();
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
    int i = Math.min(localRect.top + this.olz.top, localRect.bottom);
    int j = Math.min(localRect.left + this.olz.left, localRect.right);
    int k = Math.max(localRect.right - this.olz.right, localRect.left);
    int m = Math.max(localRect.bottom - this.olz.bottom, localRect.top);
    if ((this.olA != 0) && (this.olz.top > 0))
    {
      this.mTempRect.set(j, localRect.top, k, i);
      this.mPaint.setColor(this.olA);
      paramCanvas.drawRect(this.mTempRect, this.mPaint);
    }
    if (this.olB != 0)
    {
      if (this.olz.left > 0)
      {
        this.mTempRect.set(localRect.left, i, j, m);
        this.mPaint.setColor(this.olB);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.olz.right > 0)
      {
        this.mTempRect.set(k, i, localRect.right, m);
        this.mPaint.setColor(this.olB);
        paramCanvas.drawRect(this.mTempRect, this.mPaint);
      }
      if (this.olz.bottom > 0)
      {
        this.mTempRect.set(j, m, k, localRect.bottom);
        this.mPaint.setColor(this.olB);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.l
 * JD-Core Version:    0.7.0.1
 */