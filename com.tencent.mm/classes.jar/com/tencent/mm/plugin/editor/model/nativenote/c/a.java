package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends View
{
  private int mPadding;
  private Paint mPaint;
  private int mType;
  private RectF ooO;
  private RectF ooP;
  private RectF ooQ;
  private RectF ooR;
  private int ooS;
  private int ooT;
  private int ooU;
  private int ooV;
  private a ooW;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(181845);
    this.mType = 2;
    this.mType = paramInt1;
    this.ooT = paramInt2;
    this.ooU = paramInt3;
    this.ooS = (this.ooT * 2 / 5);
    this.mPadding = this.ooS;
    this.ooV = (this.ooS * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.ooW = parama;
    this.ooO = new RectF(this.mPadding, this.ooT, this.mPadding + this.ooS * 2, this.ooT + this.ooS * 2);
    this.ooP = new RectF(this.ooV - this.ooS, this.ooT, this.ooV + this.ooS, this.ooT + this.ooS * 2);
    this.ooQ = new RectF(this.mPadding, this.ooT, this.mPadding + this.ooS * 2, this.ooT + this.ooS * 2);
    this.ooR = new RectF(this.mPadding + this.ooU, this.ooT, this.mPadding + this.ooU + this.ooS * 2, this.ooT + this.ooS * 2);
    AppMethodBeat.o(181845);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.ooS + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.ooT + this.ooS * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.ooS + this.ooV;
    }
    return this.ooU + (this.mPadding + this.ooS) * 2;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(181846);
    switch (this.mType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(this.mPadding + this.ooS, 0.0F, this.mPadding + this.ooS + this.ooU, this.ooT + this.ooS * 2, this.mPaint);
      paramCanvas.drawArc(this.ooQ, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.ooR, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(this.mPadding + this.ooS + this.ooV - this.ooU, 0.0F, this.mPadding + this.ooS + this.ooV, this.ooT, this.mPaint);
      paramCanvas.drawArc(this.ooO, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.ooS, this.ooT, this.mPadding + this.ooS + this.ooV, this.ooT + this.ooS * 2, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.ooU, this.ooT, this.mPaint);
      paramCanvas.drawRect(0.0F, this.ooT, this.ooV, this.ooT + this.ooS * 2, this.mPaint);
      paramCanvas.drawArc(this.ooP, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181847);
    if (this.ooW != null) {
      this.ooW.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(181847);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */