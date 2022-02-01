package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.support.v4.content.b;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ui.ai;

public class ProgressImageView
  extends AppCompatImageView
{
  private int EI;
  private Paint mPaint;
  private boolean ojv;
  boolean ojw;
  private int ojx;
  
  public ProgressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(183821);
    this.EI = -1;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(183821);
  }
  
  public final void bRq()
  {
    AppMethodBeat.i(183823);
    this.ojv = true;
    this.ojw = false;
    if (ai.Eq())
    {
      setImageResource(2131233689);
      AppMethodBeat.o(183823);
      return;
    }
    setImageResource(2131233690);
    AppMethodBeat.o(183823);
  }
  
  public final void bRr()
  {
    AppMethodBeat.i(184793);
    this.ojw = true;
    this.ojv = false;
    setImageResource("download_wait_wifi");
    AppMethodBeat.o(184793);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(183826);
    super.onDraw(paramCanvas);
    if ((this.ojv) || (this.ojw) || (this.EI == -1) || (this.ojx == 0))
    {
      AppMethodBeat.o(183826);
      return;
    }
    float f3 = a.fromDPToPix(getContext(), 2);
    this.mPaint.setStrokeWidth(f3);
    float f1 = getWidth() / 2;
    float f2 = getHeight() / 2;
    f3 = getWidth() / 2 - f3 / 2.0F;
    this.mPaint.setColor(b.n(getContext(), 2131099736));
    paramCanvas.drawCircle(f1, f2, f3, this.mPaint);
    this.mPaint.setColor(b.n(getContext(), this.ojx));
    paramCanvas.drawArc(f1 - f3, f2 - f3, f1 + f3, f2 + f3, -90.0F, this.EI / 100.0F * 360.0F, false, this.mPaint);
    AppMethodBeat.o(183826);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(183825);
    super.setImageResource(paramInt);
    AppMethodBeat.o(183825);
  }
  
  public void setImageResource(String paramString)
  {
    AppMethodBeat.i(183824);
    String str = paramString;
    if (ai.Eq()) {
      str = paramString + "_dark";
    }
    setImageResource(getResources().getIdentifier(str, "raw", getContext().getPackageName()));
    AppMethodBeat.o(183824);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(183822);
    this.EI = paramInt;
    this.ojv = false;
    this.ojw = false;
    postInvalidate();
    AppMethodBeat.o(183822);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.ojx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.ProgressImageView
 * JD-Core Version:    0.7.0.1
 */