package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.ui.aw;

public class TextViewWithBottomLine
  extends AppCompatTextView
{
  private boolean CGM;
  private Paint mPaint;
  
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
    this.mPaint.setColor(getResources().getColor(g.b.normal_text_color));
    AppMethodBeat.o(41181);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(41182);
    super.onDraw(paramCanvas);
    if (this.CGM) {
      paramCanvas.drawRoundRect(0.0F, getHeight() - aw.fromDPToPix(getContext(), 2), getWidth(), getHeight(), aw.fromDPToPix(getContext(), 1), aw.fromDPToPix(getContext(), 1), this.mPaint);
    }
    AppMethodBeat.o(41182);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    AppMethodBeat.i(41183);
    this.CGM = paramBoolean;
    if (paramBoolean) {
      setTextColor(getResources().getColor(g.b.normal_text_color));
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(41183);
      return;
      setTextColor(getResources().getColor(g.b.desc_text_color));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.TextViewWithBottomLine
 * JD-Core Version:    0.7.0.1
 */