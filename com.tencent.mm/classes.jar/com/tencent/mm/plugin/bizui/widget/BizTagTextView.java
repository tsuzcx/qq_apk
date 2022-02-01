package com.tencent.mm.plugin.bizui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public class BizTagTextView
  extends AppCompatTextView
{
  private int fillColor;
  private RectF shN;
  private Paint shO;
  private int shP;
  private int shQ;
  
  public BizTagTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195702);
    this.shN = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.shO = new Paint();
    this.shP = 3;
    this.shQ = 9;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(195702);
  }
  
  public BizTagTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195704);
    this.shN = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.shO = new Paint();
    this.shP = 3;
    this.shQ = 9;
    this.fillColor = 0;
    init();
    AppMethodBeat.o(195704);
  }
  
  private void init()
  {
    AppMethodBeat.i(195705);
    this.shP = Math.round(a.getDensity(getContext()) * 1.0F);
    this.shQ = a.fromDPToPix(getContext(), 3);
    AppMethodBeat.o(195705);
  }
  
  public final void cxS()
  {
    AppMethodBeat.i(195710);
    this.shQ = Math.round(getTextSize());
    AppMethodBeat.o(195710);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(195716);
    this.shN.left = 0.0F;
    this.shN.top = this.shP;
    this.shN.right = getWidth();
    this.shN.bottom = (getHeight() - this.shP);
    this.shO.setAntiAlias(true);
    if (this.fillColor != 0)
    {
      this.shO.setColor(this.fillColor);
      this.shO.setStyle(Paint.Style.FILL);
      paramCanvas.drawRoundRect(this.shN, this.shQ, this.shQ, this.shO);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(195716);
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