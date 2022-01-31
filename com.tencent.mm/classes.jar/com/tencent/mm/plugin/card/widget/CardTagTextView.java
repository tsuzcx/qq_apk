package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class CardTagTextView
  extends TextView
{
  private int fillColor;
  private Paint kAn;
  private RectF kCw;
  private int kCx;
  private int kCy;
  private int krY;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(88951);
    this.kCw = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.kAn = new Paint();
    this.krY = 3;
    this.kCx = 9;
    this.kCy = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(88951);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(88952);
    this.kCw = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.kAn = new Paint();
    this.krY = 3;
    this.kCx = 9;
    this.kCy = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(88952);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(88953);
    this.kCw = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.kAn = new Paint();
    this.krY = 3;
    this.kCx = 9;
    this.kCy = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(88953);
  }
  
  private void init()
  {
    AppMethodBeat.i(88954);
    this.krY = Math.round(a.getDensity(getContext()) * 0.5F);
    this.kCx = a.fromDPToPix(getContext(), 3);
    this.kCy = getCurrentTextColor();
    AppMethodBeat.o(88954);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(88956);
    this.kCw.left = this.kCx;
    this.kCw.top = this.krY;
    this.kCw.right = (getWidth() - this.kCx);
    this.kCw.bottom = (getHeight() - this.krY);
    this.kAn.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.kAn.setColor(this.fillColor);
      this.kAn.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.kCw, getHeight() / 2 - this.krY, getHeight() / 2 - this.krY, this.kAn);
    }
    this.kAn.setColor(this.kCy);
    this.kAn.setStrokeWidth(this.krY);
    this.kAn.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.kCw, getHeight() / 2 - this.krY, getHeight() / 2 - this.krY, this.kAn);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(88956);
  }
  
  public void setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(88955);
    this.kCy = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(88955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */