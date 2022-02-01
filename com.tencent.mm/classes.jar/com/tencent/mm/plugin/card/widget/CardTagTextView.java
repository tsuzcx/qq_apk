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
  private int pYb;
  private Paint qgr;
  private RectF qll;
  private int qlm;
  private int qln;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.qll = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.qgr = new Paint();
    this.pYb = 3;
    this.qlm = 9;
    this.qln = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.qll = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.qgr = new Paint();
    this.pYb = 3;
    this.qlm = 9;
    this.qln = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.qll = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.qgr = new Paint();
    this.pYb = 3;
    this.qlm = 9;
    this.qln = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.pYb = Math.round(a.getDensity(getContext()) * 0.5F);
    this.qlm = a.fromDPToPix(getContext(), 3);
    this.qln = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.qll.left = this.qlm;
    this.qll.top = this.pYb;
    this.qll.right = (getWidth() - this.qlm);
    this.qll.bottom = (getHeight() - this.pYb);
    this.qgr.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.qgr.setColor(this.fillColor);
      this.qgr.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.qll, getHeight() / 2 - this.pYb, getHeight() / 2 - this.pYb, this.qgr);
    }
    this.qgr.setColor(this.qln);
    this.qgr.setStrokeWidth(this.pYb);
    this.qgr.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.qll, getHeight() / 2 - this.pYb, getHeight() / 2 - this.pYb, this.qgr);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(113884);
  }
  
  public void setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(113883);
    this.qln = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */