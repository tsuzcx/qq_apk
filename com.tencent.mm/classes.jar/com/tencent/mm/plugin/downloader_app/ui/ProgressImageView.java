package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.d;
import com.tencent.mm.ui.aw;

public class ProgressImageView
  extends AppCompatImageView
{
  private int boE;
  private Paint mPaint;
  private boolean xui;
  boolean xuj;
  private int xuk;
  
  public ProgressImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(183821);
    this.boE = -1;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    AppMethodBeat.o(183821);
  }
  
  public final void dvm()
  {
    AppMethodBeat.i(183823);
    this.xui = true;
    this.xuj = false;
    if (aw.isDarkMode())
    {
      setImageResource(e.d.xpS);
      AppMethodBeat.o(183823);
      return;
    }
    setImageResource(e.d.xpT);
    AppMethodBeat.o(183823);
  }
  
  public final void dvn()
  {
    AppMethodBeat.i(184793);
    this.xuj = true;
    this.xui = false;
    setImageResource("download_wait_wifi");
    AppMethodBeat.o(184793);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(183826);
    super.onDraw(paramCanvas);
    if ((this.xui) || (this.boE == -1) || (this.xuk == 0))
    {
      AppMethodBeat.o(183826);
      return;
    }
    float f3 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 2);
    this.mPaint.setStrokeWidth(f3);
    float f1 = getWidth() / 2;
    float f2 = getHeight() / 2;
    f3 = getWidth() / 2 - f3 / 2.0F;
    this.mPaint.setColor(androidx.core.content.a.w(getContext(), e.b.FG_3));
    paramCanvas.drawCircle(f1, f2, f3, this.mPaint);
    this.mPaint.setColor(androidx.core.content.a.w(getContext(), this.xuk));
    paramCanvas.drawArc(f1 - f3, f2 - f3, f1 + f3, f2 + f3, -90.0F, this.boE / 100.0F * 360.0F, false, this.mPaint);
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
    if (aw.isDarkMode()) {
      str = paramString + "_dark";
    }
    setImageResource(getResources().getIdentifier(str, "raw", getContext().getPackageName()));
    AppMethodBeat.o(183824);
  }
  
  public void setProgress(int paramInt)
  {
    AppMethodBeat.i(183822);
    this.boE = paramInt;
    this.xui = false;
    this.xuj = false;
    postInvalidate();
    AppMethodBeat.o(183822);
  }
  
  public void setProgressColor(int paramInt)
  {
    this.xuk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.ProgressImageView
 * JD-Core Version:    0.7.0.1
 */