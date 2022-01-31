package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ak;

public class ExdeviceConnectedRouterStateView
  extends ImageView
{
  private int bottom;
  private ak faV;
  int lMs;
  private int lMt;
  private Runnable lMu;
  private int left;
  private Context mContext;
  private Paint mPaint;
  private int right;
  private int state;
  private int top;
  
  public ExdeviceConnectedRouterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExdeviceConnectedRouterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(19930);
    this.lMs = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.lMt = -1;
    this.lMu = new ExdeviceConnectedRouterStateView.1(this);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = a.fromDPToPix(this.mContext, 2);
    this.top = this.left;
    this.lMt = a.fromDPToPix(this.mContext, 3);
    this.faV = new ak(Looper.getMainLooper());
    AppMethodBeat.o(19930);
  }
  
  private void vd(int paramInt)
  {
    AppMethodBeat.i(19933);
    this.faV.removeCallbacks(this.lMu);
    this.faV.postDelayed(this.lMu, paramInt);
    AppMethodBeat.o(19933);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(19932);
    super.onDraw(paramCanvas);
    if (this.state == 1)
    {
      int i = getWidth() / 2;
      this.mPaint.setARGB(255, 103, 209, 79);
      this.mPaint.setStrokeWidth(this.lMt);
      if (this.right == -1) {
        this.right = (i * 2 - this.left);
      }
      if (this.bottom == -1) {
        this.bottom = this.right;
      }
      paramCanvas.drawArc(new RectF(this.left, this.top, this.right, this.bottom), 270.0F, this.lMs, false, this.mPaint);
      this.lMs += 5;
      if (this.lMs > 365) {
        this.lMs = 0;
      }
      vd(100);
    }
    AppMethodBeat.o(19932);
  }
  
  public void setState(int paramInt)
  {
    AppMethodBeat.i(19931);
    this.state = paramInt;
    vd(10);
    AppMethodBeat.o(19931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterStateView
 * JD-Core Version:    0.7.0.1
 */