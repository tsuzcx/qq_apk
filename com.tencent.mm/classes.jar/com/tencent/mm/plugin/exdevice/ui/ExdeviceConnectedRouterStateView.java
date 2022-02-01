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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class ExdeviceConnectedRouterStateView
  extends ImageView
{
  private int bottom;
  private int left;
  private Context mContext;
  private Paint mPaint;
  private MMHandler mRi;
  private int right;
  int startAngle;
  private int state;
  private int top;
  private int yzQ;
  private Runnable yzR;
  
  public ExdeviceConnectedRouterStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExdeviceConnectedRouterStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23998);
    this.startAngle = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.yzQ = -1;
    this.yzR = new ExdeviceConnectedRouterStateView.1(this);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = a.fromDPToPix(this.mContext, 2);
    this.top = this.left;
    this.yzQ = a.fromDPToPix(this.mContext, 3);
    this.mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(23998);
  }
  
  private void Lm(int paramInt)
  {
    AppMethodBeat.i(24001);
    this.mRi.removeCallbacks(this.yzR);
    this.mRi.postDelayed(this.yzR, paramInt);
    AppMethodBeat.o(24001);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(24000);
    super.onDraw(paramCanvas);
    if (this.state == 1)
    {
      int i = getWidth() / 2;
      this.mPaint.setARGB(255, 103, 209, 79);
      this.mPaint.setStrokeWidth(this.yzQ);
      if (this.right == -1) {
        this.right = (i * 2 - this.left);
      }
      if (this.bottom == -1) {
        this.bottom = this.right;
      }
      paramCanvas.drawArc(new RectF(this.left, this.top, this.right, this.bottom), 270.0F, this.startAngle, false, this.mPaint);
      this.startAngle += 5;
      if (this.startAngle > 365) {
        this.startAngle = 0;
      }
      Lm(100);
    }
    AppMethodBeat.o(24000);
  }
  
  public void setState(int paramInt)
  {
    AppMethodBeat.i(23999);
    this.state = paramInt;
    Lm(10);
    AppMethodBeat.o(23999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterStateView
 * JD-Core Version:    0.7.0.1
 */