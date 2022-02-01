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
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ap;

public class ExdeviceConnectedRouterStateView
  extends ImageView
{
  private int bottom;
  private ap gIf;
  private int left;
  private Context mContext;
  private Paint mPaint;
  int qjT;
  private int qjU;
  private Runnable qjV;
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
    AppMethodBeat.i(23998);
    this.qjT = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.qjU = -1;
    this.qjV = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23997);
        ExdeviceConnectedRouterStateView.this.invalidate();
        AppMethodBeat.o(23997);
      }
    };
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = a.fromDPToPix(this.mContext, 2);
    this.top = this.left;
    this.qjU = a.fromDPToPix(this.mContext, 3);
    this.gIf = new ap(Looper.getMainLooper());
    AppMethodBeat.o(23998);
  }
  
  private void CI(int paramInt)
  {
    AppMethodBeat.i(24001);
    this.gIf.removeCallbacks(this.qjV);
    this.gIf.postDelayed(this.qjV, paramInt);
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
      this.mPaint.setStrokeWidth(this.qjU);
      if (this.right == -1) {
        this.right = (i * 2 - this.left);
      }
      if (this.bottom == -1) {
        this.bottom = this.right;
      }
      paramCanvas.drawArc(new RectF(this.left, this.top, this.right, this.bottom), 270.0F, this.qjT, false, this.mPaint);
      this.qjT += 5;
      if (this.qjT > 365) {
        this.qjT = 0;
      }
      CI(100);
    }
    AppMethodBeat.o(24000);
  }
  
  public void setState(int paramInt)
  {
    AppMethodBeat.i(23999);
    this.state = paramInt;
    CI(10);
    AppMethodBeat.o(23999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterStateView
 * JD-Core Version:    0.7.0.1
 */