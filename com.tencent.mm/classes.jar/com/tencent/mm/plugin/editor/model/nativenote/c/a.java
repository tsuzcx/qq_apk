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
  private RectF qRU;
  private RectF qRV;
  private RectF qRW;
  private RectF qRX;
  private int qRY;
  private int qRZ;
  private int qSa;
  private int qSb;
  private a qSc;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(181845);
    this.mType = 2;
    this.mType = paramInt1;
    this.qRZ = paramInt2;
    this.qSa = paramInt3;
    this.qRY = (this.qRZ * 2 / 5);
    this.mPadding = this.qRY;
    this.qSb = (this.qRY * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.qSc = parama;
    this.qRU = new RectF(this.mPadding, this.qRZ, this.mPadding + this.qRY * 2, this.qRZ + this.qRY * 2);
    this.qRV = new RectF(this.qSb - this.qRY, this.qRZ, this.qSb + this.qRY, this.qRZ + this.qRY * 2);
    this.qRW = new RectF(this.mPadding, this.qRZ, this.mPadding + this.qRY * 2, this.qRZ + this.qRY * 2);
    this.qRX = new RectF(this.mPadding + this.qSa, this.qRZ, this.mPadding + this.qSa + this.qRY * 2, this.qRZ + this.qRY * 2);
    AppMethodBeat.o(181845);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.mPadding + this.qRY + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.qRZ + this.qRY * 2 + this.mPadding;
  }
  
  public final int getViewPadding()
  {
    return this.mPadding;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.mPadding + this.qRY + this.qSb;
    }
    return this.qSa + (this.mPadding + this.qRY) * 2;
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
      paramCanvas.drawRect(this.mPadding + this.qRY, 0.0F, this.mPadding + this.qRY + this.qSa, this.qRZ + this.qRY * 2, this.mPaint);
      paramCanvas.drawArc(this.qRW, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.qRX, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(this.mPadding + this.qRY + this.qSb - this.qSa, 0.0F, this.mPadding + this.qRY + this.qSb, this.qRZ, this.mPaint);
      paramCanvas.drawArc(this.qRU, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.mPadding + this.qRY, this.qRZ, this.mPadding + this.qRY + this.qSb, this.qRZ + this.qRY * 2, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.qSa, this.qRZ, this.mPaint);
      paramCanvas.drawRect(0.0F, this.qRZ, this.qSb, this.qRZ + this.qRY * 2, this.mPaint);
      paramCanvas.drawArc(this.qRV, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181847);
    if (this.qSc != null) {
      this.qSc.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(181847);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */