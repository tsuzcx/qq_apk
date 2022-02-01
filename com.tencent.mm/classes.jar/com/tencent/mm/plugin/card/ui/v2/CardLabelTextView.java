package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardLabelTextView;", "Landroid/widget/TextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fillColor", "p", "Landroid/graphics/Paint;", "radius", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setFillColor", "color", "setRadius", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardLabelTextView
  extends TextView
{
  private int fillColor;
  private float radius;
  private final Paint vtP;
  
  public CardLabelTextView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(112506);
    this.radius = a.fromDPToPix(getContext(), 1);
    this.vtP = new Paint();
    AppMethodBeat.o(112506);
  }
  
  public CardLabelTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(112507);
    this.radius = a.fromDPToPix(getContext(), 1);
    this.vtP = new Paint();
    AppMethodBeat.o(112507);
  }
  
  public CardLabelTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112508);
    this.radius = a.fromDPToPix(getContext(), 1);
    this.vtP = new Paint();
    AppMethodBeat.o(112508);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112505);
    RectF localRectF = new RectF();
    localRectF.left = 0.0F;
    localRectF.right = getWidth();
    localRectF.top = 0.0F;
    localRectF.bottom = getHeight();
    this.vtP.setAntiAlias(true);
    this.vtP.setColor(this.fillColor);
    this.vtP.setStyle(Paint.Style.FILL);
    if (paramCanvas != null) {
      paramCanvas.drawRoundRect(localRectF, this.radius, this.radius, this.vtP);
    }
    super.onDraw(paramCanvas);
    AppMethodBeat.o(112505);
  }
  
  public final void setFillColor(int paramInt)
  {
    this.fillColor = paramInt;
  }
  
  public final void setRadius(float paramFloat)
  {
    this.radius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardLabelTextView
 * JD-Core Version:    0.7.0.1
 */