package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.support.v4.content.b;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public class DownloadStateView
  extends AppCompatImageView
{
  private int HH;
  private Paint mPaint;
  private int qMv = -1;
  
  public DownloadStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175279);
    super.onDraw(paramCanvas);
    if (this.HH < 0)
    {
      AppMethodBeat.o(175279);
      return;
    }
    float f1 = a.fromDPToPix(getContext(), 2);
    getWidth();
    getWidth();
    float f2 = getWidth() / 2.0F;
    float f3 = getHeight() / 2.0F;
    float f4 = getWidth() - f1 / 2.0F;
    this.mPaint.setColor(b.n(getContext(), 2131099657));
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setStrokeWidth(f1);
    paramCanvas.drawCircle(f2, f3, f4, this.mPaint);
    this.mPaint.setColor(this.qMv);
    paramCanvas.drawArc(f2 - f4, f3 - f4, f2 + f4, f3 + f4, -90.0F, this.HH / 100.0F * 360.0F, false, this.mPaint);
    AppMethodBeat.o(175279);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(175278);
    this.HH = paramInt;
    postInvalidate();
    AppMethodBeat.o(175278);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.qMv = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadStateView
 * JD-Core Version:    0.7.0.1
 */