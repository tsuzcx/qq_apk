package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public class CardTagTextView
  extends TextView
{
  private int fillColor;
  private RectF shN;
  private Paint shO;
  private int shP;
  private int tHh;
  private int tHi;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.shN = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.shO = new Paint();
    this.shP = 3;
    this.tHh = 9;
    this.tHi = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.shN = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.shO = new Paint();
    this.shP = 3;
    this.tHh = 9;
    this.tHi = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.shN = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.shO = new Paint();
    this.shP = 3;
    this.tHh = 9;
    this.tHi = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.shP = Math.round(a.getDensity(getContext()) * 0.5F);
    this.tHh = a.fromDPToPix(getContext(), 3);
    this.tHi = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.shN.left = this.tHh;
    this.shN.top = this.shP;
    this.shN.right = (getWidth() - this.tHh);
    this.shN.bottom = (getHeight() - this.shP);
    this.shO.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.shO.setColor(this.fillColor);
      this.shO.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.shN, getHeight() / 2 - this.shP, getHeight() / 2 - this.shP, this.shO);
    }
    this.shO.setColor(this.tHi);
    this.shO.setStrokeWidth(this.shP);
    this.shO.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.shN, getHeight() / 2 - this.shP, getHeight() / 2 - this.shP, this.shO);
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
    this.tHi = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */