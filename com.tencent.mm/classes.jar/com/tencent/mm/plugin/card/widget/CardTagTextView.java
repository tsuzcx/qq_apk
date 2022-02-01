package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class CardTagTextView
  extends TextView
{
  private int fillColor;
  private RectF vtO;
  private Paint vtP;
  private int vtQ;
  private int wKI;
  private int wKJ;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.vtO = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.vtP = new Paint();
    this.vtQ = 3;
    this.wKI = 9;
    this.wKJ = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.vtO = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.vtP = new Paint();
    this.vtQ = 3;
    this.wKI = 9;
    this.wKJ = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.vtO = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.vtP = new Paint();
    this.vtQ = 3;
    this.wKI = 9;
    this.wKJ = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.vtQ = Math.round(a.getDensity(getContext()) * 0.5F);
    this.wKI = a.fromDPToPix(getContext(), 3);
    this.wKJ = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.vtO.left = this.wKI;
    this.vtO.top = this.vtQ;
    this.vtO.right = (getWidth() - this.wKI);
    this.vtO.bottom = (getHeight() - this.vtQ);
    this.vtP.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.vtP.setColor(this.fillColor);
      this.vtP.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.vtO, getHeight() / 2 - this.vtQ, getHeight() / 2 - this.vtQ, this.vtP);
    }
    this.vtP.setColor(this.wKJ);
    this.vtP.setStrokeWidth(this.vtQ);
    this.vtP.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.vtO, getHeight() / 2 - this.vtQ, getHeight() / 2 - this.vtQ, this.vtP);
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
    this.wKJ = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */