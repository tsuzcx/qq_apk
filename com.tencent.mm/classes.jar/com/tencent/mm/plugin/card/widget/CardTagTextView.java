package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;

public class CardTagTextView
  extends TextView
{
  private int fillColor;
  private int oDL;
  private Paint oMa;
  private RectF oPP;
  private int oPQ;
  private int oPR;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.oPP = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oMa = new Paint();
    this.oDL = 3;
    this.oPQ = 9;
    this.oPR = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.oPP = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oMa = new Paint();
    this.oDL = 3;
    this.oPQ = 9;
    this.oPR = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.oPP = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oMa = new Paint();
    this.oDL = 3;
    this.oPQ = 9;
    this.oPR = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.oDL = Math.round(a.getDensity(getContext()) * 0.5F);
    this.oPQ = a.fromDPToPix(getContext(), 3);
    this.oPR = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.oPP.left = this.oPQ;
    this.oPP.top = this.oDL;
    this.oPP.right = (getWidth() - this.oPQ);
    this.oPP.bottom = (getHeight() - this.oDL);
    this.oMa.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.oMa.setColor(this.fillColor);
      this.oMa.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.oPP, getHeight() / 2 - this.oDL, getHeight() / 2 - this.oDL, this.oMa);
    }
    this.oMa.setColor(this.oPR);
    this.oMa.setStrokeWidth(this.oDL);
    this.oMa.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.oPP, getHeight() / 2 - this.oDL, getHeight() / 2 - this.oDL, this.oMa);
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
    this.oPR = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */