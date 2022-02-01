package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;

public class TextViewWithBottomLine
  extends AppCompatTextView
{
  private Paint mPaint;
  private boolean xCM;
  
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
    this.mPaint.setColor(getResources().getColor(2131100904));
    AppMethodBeat.o(41181);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(41182);
    super.onDraw(paramCanvas);
    if (this.xCM) {
      paramCanvas.drawRoundRect(0.0F, getHeight() - at.fromDPToPix(getContext(), 2), getWidth(), getHeight(), at.fromDPToPix(getContext(), 1), at.fromDPToPix(getContext(), 1), this.mPaint);
    }
    AppMethodBeat.o(41182);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(41183);
    this.xCM = paramBoolean;
    if (paramBoolean) {
      setTextColor(getResources().getColor(2131100904));
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(41183);
      return;
      setTextColor(getResources().getColor(2131100245));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.TextViewWithBottomLine
 * JD-Core Version:    0.7.0.1
 */