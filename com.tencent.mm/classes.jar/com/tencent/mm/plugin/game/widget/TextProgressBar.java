package com.tencent.mm.plugin.game.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class TextProgressBar
  extends ProgressBar
{
  private int Hx;
  private Context mContext;
  private Paint mPaint;
  private String mText;
  private int mTextSize;
  
  public TextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void setText(int paramInt)
  {
    AppMethodBeat.i(42628);
    this.Hx = paramInt;
    this.mText = (String.valueOf(paramInt) + "%");
    AppMethodBeat.o(42628);
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      AppMethodBeat.i(42626);
      super.onDraw(paramCanvas);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(Color.rgb(69, 192, 26));
      this.mPaint.setTextSize(this.mTextSize);
      Object localObject = new Rect();
      this.mPaint.getTextBounds(this.mText, 0, this.mText.length(), (Rect)localObject);
      float f1 = getWidth() / 2 - ((Rect)localObject).centerX();
      float f2 = getHeight() / 2 - ((Rect)localObject).centerY();
      paramCanvas.drawText(this.mText, f1, f2, this.mPaint);
      float f3 = this.Hx / 100.0F * getWidth();
      if (f3 > f1)
      {
        localObject = new Paint();
        ((Paint)localObject).setColor(-1);
        ((Paint)localObject).setAntiAlias(true);
        ((Paint)localObject).setTextSize(this.mTextSize);
        RectF localRectF = new RectF(0.0F, 0.0F, f3, getHeight());
        paramCanvas.save();
        paramCanvas.clipRect(localRectF);
        paramCanvas.drawText(this.mText, f1, f2, (Paint)localObject);
        paramCanvas.restore();
      }
      AppMethodBeat.o(42626);
      return;
    }
    finally {}
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(42625);
    setText(paramInt);
    super.setProgress(paramInt);
    AppMethodBeat.o(42625);
  }
  
  public void setTextSize(int paramInt)
  {
    AppMethodBeat.i(42627);
    this.mTextSize = a.fromDPToPix(this.mContext, paramInt);
    AppMethodBeat.o(42627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.TextProgressBar
 * JD-Core Version:    0.7.0.1
 */