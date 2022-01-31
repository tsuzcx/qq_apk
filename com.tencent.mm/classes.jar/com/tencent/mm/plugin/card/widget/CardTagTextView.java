package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.cb.a;

public class CardTagTextView
  extends TextView
{
  private int fillColor = 0;
  private int iqQ = 3;
  private RectF izp = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
  private Paint izq = new Paint();
  private int izr = 9;
  private int izs = 0;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.iqQ = Math.round(a.getDensity(getContext()) * 0.5F);
    this.izr = a.fromDPToPix(getContext(), 3);
    this.izs = getCurrentTextColor();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.izp.left = this.izr;
    this.izp.top = this.iqQ;
    this.izp.right = (getWidth() - this.izr);
    this.izp.bottom = (getHeight() - this.iqQ);
    if (this.fillColor != 0)
    {
      this.izq.setColor(this.fillColor);
      this.izq.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.izp, getHeight() / 2 - this.iqQ, getHeight() / 2 - this.iqQ, this.izq);
    }
    this.izq.setColor(this.izs);
    this.izq.setStrokeWidth(this.iqQ);
    this.izq.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.izp, getHeight() / 2 - this.iqQ, getHeight() / 2 - this.iqQ, this.izq);
    super.onDraw(paramCanvas);
  }
  
  public void setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    this.izs = paramInt;
    super.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */