package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;

public class TextViewWithBottomLine
  extends AppCompatTextView
{
  private Paint mPaint;
  private boolean tbB;
  
  public TextViewWithBottomLine(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41179);
    init();
    AppMethodBeat.o(41179);
  }
  
  public TextViewWithBottomLine(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41180);
    init();
    AppMethodBeat.o(41180);
  }
  
  private void init()
  {
    AppMethodBeat.i(41181);
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.FILL);
    this.mPaint.setColor(getResources().getColor(2131100711));
    AppMethodBeat.o(41181);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(41182);
    super.onDraw(paramCanvas);
    if (this.tbB) {
      paramCanvas.drawRoundRect(0.0F, getHeight() - ao.fromDPToPix(getContext(), 2), getWidth(), getHeight(), ao.fromDPToPix(getContext(), 1), ao.fromDPToPix(getContext(), 1), this.mPaint);
    }
    AppMethodBeat.o(41182);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(41183);
    this.tbB = paramBoolean;
    if (paramBoolean) {
      setTextColor(getResources().getColor(2131100711));
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(41183);
      return;
      setTextColor(getResources().getColor(2131100212));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.TextViewWithBottomLine
 * JD-Core Version:    0.7.0.1
 */