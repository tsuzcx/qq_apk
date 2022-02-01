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
  private int oar;
  private Paint oiG;
  private RectF omu;
  private int omv;
  private int omw;
  
  public CardTagTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(113879);
    this.omu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oiG = new Paint();
    this.oar = 3;
    this.omv = 9;
    this.omw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113879);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113880);
    this.omu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oiG = new Paint();
    this.oar = 3;
    this.omv = 9;
    this.omw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113880);
  }
  
  public CardTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113881);
    this.omu = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.oiG = new Paint();
    this.oar = 3;
    this.omv = 9;
    this.omw = 0;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(113881);
  }
  
  private void init()
  {
    AppMethodBeat.i(113882);
    this.oar = Math.round(a.getDensity(getContext()) * 0.5F);
    this.omv = a.fromDPToPix(getContext(), 3);
    this.omw = getCurrentTextColor();
    AppMethodBeat.o(113882);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113884);
    this.omu.left = this.omv;
    this.omu.top = this.oar;
    this.omu.right = (getWidth() - this.omv);
    this.omu.bottom = (getHeight() - this.oar);
    this.oiG.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.oiG.setColor(this.fillColor);
      this.oiG.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.omu, getHeight() / 2 - this.oar, getHeight() / 2 - this.oar, this.oiG);
    }
    this.oiG.setColor(this.omw);
    this.oiG.setStrokeWidth(this.oar);
    this.oiG.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRoundRect(this.omu, getHeight() / 2 - this.oar, getHeight() / 2 - this.oar, this.oiG);
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
    this.omw = paramInt;
    super.setTextColor(paramInt);
    AppMethodBeat.o(113883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.CardTagTextView
 * JD-Core Version:    0.7.0.1
 */