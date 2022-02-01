package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class BizTagTextView
  extends AppCompatTextView
{
  private int fillColor;
  private RectF vtO;
  private Paint vtP;
  private int vtQ;
  private int vtR;
  
  public BizTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(260864);
    this.vtO = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.vtP = new Paint();
    this.vtQ = 3;
    this.vtR = 9;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(260864);
  }
  
  public BizTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(260872);
    this.vtO = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.vtP = new Paint();
    this.vtQ = 3;
    this.vtR = 9;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(260872);
  }
  
  private void init()
  {
    AppMethodBeat.i(260876);
    this.vtQ = Math.round(a.getDensity(getContext()) * 1.0F);
    this.vtR = a.fromDPToPix(getContext(), 3);
    AppMethodBeat.o(260876);
  }
  
  public final void daK()
  {
    AppMethodBeat.i(260880);
    this.vtR = Math.round(getTextSize());
    AppMethodBeat.o(260880);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(260894);
    this.vtO.left = 0.0F;
    this.vtO.top = this.vtQ;
    this.vtO.right = getWidth();
    this.vtO.bottom = (getHeight() - this.vtQ);
    this.vtP.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.vtP.setColor(this.fillColor);
      this.vtP.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.vtO, this.vtR, this.vtR, this.vtP);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(260894);
  }
  
  public void setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bizui.widget.BizTagTextView
 * JD-Core Version:    0.7.0.1
 */