package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.e.b;

public class DownloadStateView
  extends AppCompatImageView
{
  private int boE;
  private Paint mPaint;
  private int xud = -1;
  
  public DownloadStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175279);
    super.onDraw(paramCanvas);
    if (this.boE < 0)
    {
      AppMethodBeat.o(175279);
      return;
    }
    float f1 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 2);
    getWidth();
    getWidth();
    float f2 = getWidth() / 2.0F;
    float f3 = getHeight() / 2.0F;
    float f4 = getWidth() - f1 / 2.0F;
    this.mPaint.setColor(androidx.core.content.a.w(getContext(), e.b.BW_0_Alpha_0_1));
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setStrokeWidth(f1);
    paramCanvas.drawCircle(f2, f3, f4, this.mPaint);
    this.mPaint.setColor(this.xud);
    paramCanvas.drawArc(f2 - f4, f3 - f4, f2 + f4, f3 + f4, -90.0F, this.boE / 100.0F * 360.0F, false, this.mPaint);
    AppMethodBeat.o(175279);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(175278);
    this.boE = paramInt;
    postInvalidate();
    AppMethodBeat.o(175278);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.xud = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DownloadStateView
 * JD-Core Version:    0.7.0.1
 */