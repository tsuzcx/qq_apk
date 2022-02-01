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
  private int oKn;
  private Paint oSC;
  private RectF oWr;
  private int oWs;
  private int oWt;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.oWr = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oSC = new Paint();
    this.oKn = 3;
    this.oWs = 9;
    this.oWt = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.oWr = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oSC = new Paint();
    this.oKn = 3;
    this.oWs = 9;
    this.oWt = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.oWr = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oSC = new Paint();
    this.oKn = 3;
    this.oWs = 9;
    this.oWt = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.oKn = Math.round(a.getDensity(getContext()) * 0.5F);
    this.oWs = a.fromDPToPix(getContext(), 3);
    this.oWt = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.oWr.left = this.oWs;
    this.oWr.top = this.oKn;
    this.oWr.right = (getWidth() - this.oWs);
    this.oWr.bottom = (getHeight() - this.oKn);
    this.oSC.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.oSC.setColor(this.fillColor);
      this.oSC.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.oWr, getHeight() / 2 - this.oKn, getHeight() / 2 - this.oKn, this.oSC);
    }
    this.oSC.setColor(this.oWt);
    this.oSC.setStrokeWidth(this.oKn);
    this.oSC.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.oWr, getHeight() / 2 - this.oKn, getHeight() / 2 - this.oKn, this.oSC);
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
    this.oWt = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */