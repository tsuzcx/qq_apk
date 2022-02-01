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
  private int clC;
  private Paint mPaint;
  private int mType;
  private RectF uua;
  private RectF uub;
  private RectF uuc;
  private RectF uud;
  private int uue;
  private int uuf;
  private int uug;
  private int uuh;
  private a uui;
  
  public a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(181845);
    this.mType = 2;
    this.mType = paramInt1;
    this.uuf = paramInt2;
    this.uug = paramInt3;
    this.uue = (this.uuf * 2 / 5);
    this.clC = this.uue;
    this.uuh = (this.uue * 3 / 4);
    this.mPaint = new Paint(1);
    this.mPaint.setColor(paramInt4);
    this.uui = parama;
    this.uua = new RectF(this.clC, this.uuf, this.clC + this.uue * 2, this.uuf + this.uue * 2);
    this.uub = new RectF(this.uuh - this.uue, this.uuf, this.uuh + this.uue, this.uuf + this.uue * 2);
    this.uuc = new RectF(this.clC, this.uuf, this.clC + this.uue * 2, this.uuf + this.uue * 2);
    this.uud = new RectF(this.clC + this.uug, this.uuf, this.clC + this.uug + this.uue * 2, this.uuf + this.uue * 2);
    AppMethodBeat.o(181845);
  }
  
  public final int getOffsetForCursorMid()
  {
    return this.clC + this.uue + 1;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final int getViewHeight()
  {
    return this.uuf + this.uue * 2 + this.clC;
  }
  
  public final int getViewPadding()
  {
    return this.clC;
  }
  
  public final int getViewWidth()
  {
    if ((this.mType == 3) || (this.mType == 4)) {
      return this.clC + this.uue + this.uuh;
    }
    return this.uug + (this.clC + this.uue) * 2;
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
      paramCanvas.drawRect(this.clC + this.uue, 0.0F, this.clC + this.uue + this.uug, this.uuf + this.uue * 2, this.mPaint);
      paramCanvas.drawArc(this.uuc, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawArc(this.uud, 270.0F, 180.0F, true, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(this.clC + this.uue + this.uuh - this.uug, 0.0F, this.clC + this.uue + this.uuh, this.uuf, this.mPaint);
      paramCanvas.drawArc(this.uua, 90.0F, 180.0F, true, this.mPaint);
      paramCanvas.drawRect(this.clC + this.uue, this.uuf, this.clC + this.uue + this.uuh, this.uuf + this.uue * 2, this.mPaint);
      AppMethodBeat.o(181846);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, this.uug, this.uuf, this.mPaint);
      paramCanvas.drawRect(0.0F, this.uuf, this.uuh, this.uuf + this.uue * 2, this.mPaint);
      paramCanvas.drawArc(this.uub, 270.0F, 180.0F, true, this.mPaint);
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181847);
    if (this.uui != null) {
      this.uui.a(this.mType, paramMotionEvent);
    }
    AppMethodBeat.o(181847);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.a
 * JD-Core Version:    0.7.0.1
 */