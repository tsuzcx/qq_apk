package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextViewWithBorder
  extends AppCompatTextView
{
  public TextViewWithBorder(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42630);
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(getResources().getColor(2131100433));
    paramCanvas.drawRoundRect(new RectF(2.0F, 2.0F, getWidth() - 2, getHeight() - 2), 5.0F, 5.0F, localPaint);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(42630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.TextViewWithBorder
 * JD-Core Version:    0.7.0.1
 */