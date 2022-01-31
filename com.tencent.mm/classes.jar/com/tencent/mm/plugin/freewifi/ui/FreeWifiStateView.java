package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

public class FreeWifiStateView
  extends ImageView
{
  private int bottom = -1;
  private ah dPi;
  private int jCV = -1;
  private Runnable jCW = new FreeWifiStateView.1(this);
  private int left = -1;
  private Context mContext;
  private Paint mPaint;
  private int right = -1;
  int startAngle = 2;
  private int state;
  private int top = -1;
  
  public FreeWifiStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FreeWifiStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = a.fromDPToPix(this.mContext, 2);
    this.top = this.left;
    this.jCV = a.fromDPToPix(this.mContext, 3);
    this.dPi = new ah(Looper.getMainLooper());
  }
  
  private void qw(int paramInt)
  {
    this.dPi.removeCallbacks(this.jCW);
    this.dPi.postDelayed(this.jCW, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.state == 1)
    {
      int i = getWidth() / 2;
      this.mPaint.setARGB(255, 103, 209, 79);
      this.mPaint.setStrokeWidth(this.jCV);
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
      qw(100);
    }
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
    qw(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateView
 * JD-Core Version:    0.7.0.1
 */