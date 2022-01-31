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
import com.tencent.mm.cb.a;

public class TextProgressBar
  extends ProgressBar
{
  private int gFm;
  private String hnV;
  private Context mContext;
  private Paint mPaint;
  private int xL;
  
  public TextProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  private void setText(int paramInt)
  {
    this.xL = paramInt;
    this.hnV = (String.valueOf(paramInt) + "%");
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(Color.rgb(69, 192, 26));
      this.mPaint.setTextSize(this.gFm);
      Object localObject = new Rect();
      this.mPaint.getTextBounds(this.hnV, 0, this.hnV.length(), (Rect)localObject);
      float f1 = getWidth() / 2 - ((Rect)localObject).centerX();
      float f2 = getHeight() / 2 - ((Rect)localObject).centerY();
      paramCanvas.drawText(this.hnV, f1, f2, this.mPaint);
      float f3 = this.xL / 100.0F * getWidth();
      if (f3 > f1)
      {
        localObject = new Paint();
        ((Paint)localObject).setColor(-1);
        ((Paint)localObject).setAntiAlias(true);
        ((Paint)localObject).setTextSize(this.gFm);
        RectF localRectF = new RectF(0.0F, 0.0F, f3, getHeight());
        paramCanvas.save();
        paramCanvas.clipRect(localRectF);
        paramCanvas.drawText(this.hnV, f1, f2, (Paint)localObject);
        paramCanvas.restore();
      }
      return;
    }
    finally {}
  }
  
  public void setProgress(int paramInt)
  {
    setText(paramInt);
    super.setProgress(paramInt);
  }
  
  public void setTextSize(int paramInt)
  {
    this.gFm = a.fromDPToPix(this.mContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.TextProgressBar
 * JD-Core Version:    0.7.0.1
 */