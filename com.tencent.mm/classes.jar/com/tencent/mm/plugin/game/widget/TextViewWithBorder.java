package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.b;

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
    localPaint.setColor(getResources().getColor(h.b.HSQ));
    paramCanvas.drawRoundRect(new RectF(2.0F, 2.0F, getWidth() - 2, getHeight() - 2), 5.0F, 5.0F, localPaint);
    super.onDraw(paramCanvas);
    AppMethodBeat.o(42630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.TextViewWithBorder
 * JD-Core Version:    0.7.0.1
 */