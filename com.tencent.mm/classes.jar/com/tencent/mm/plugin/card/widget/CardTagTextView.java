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
  private Paint nFF;
  private RectF nJu;
  private int nJv;
  private int nJw;
  private int nxr;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.nJu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.nFF = new Paint();
    this.nxr = 3;
    this.nJv = 9;
    this.nJw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.nJu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.nFF = new Paint();
    this.nxr = 3;
    this.nJv = 9;
    this.nJw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.nJu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.nFF = new Paint();
    this.nxr = 3;
    this.nJv = 9;
    this.nJw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.nxr = Math.round(a.getDensity(getContext()) * 0.5F);
    this.nJv = a.fromDPToPix(getContext(), 3);
    this.nJw = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.nJu.left = this.nJv;
    this.nJu.top = this.nxr;
    this.nJu.right = (getWidth() - this.nJv);
    this.nJu.bottom = (getHeight() - this.nxr);
    this.nFF.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.nFF.setColor(this.fillColor);
      this.nFF.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.nJu, getHeight() / 2 - this.nxr, getHeight() / 2 - this.nxr, this.nFF);
    }
    this.nFF.setColor(this.nJw);
    this.nFF.setStrokeWidth(this.nxr);
    this.nFF.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.nJu, getHeight() / 2 - this.nxr, getHeight() / 2 - this.nxr, this.nFF);
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
    this.nJw = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */