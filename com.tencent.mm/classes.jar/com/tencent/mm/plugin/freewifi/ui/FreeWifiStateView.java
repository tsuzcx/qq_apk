package com.tencent.mm.plugin.freewifi.ui;

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
import com.tencent.mm.sdk.platformtools.ap;

public class FreeWifiStateView
  extends ImageView
{
  private int bottom;
  private ap gAC;
  private int left;
  private Context mContext;
  private Paint mPaint;
  int pdd;
  private int pde;
  private Runnable pdf;
  private int right;
  private int state;
  private int top;
  
  public FreeWifiStateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FreeWifiStateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(25140);
    this.pdd = 2;
    this.left = -1;
    this.top = -1;
    this.right = -1;
    this.bottom = -1;
    this.pde = -1;
    this.pdf = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25139);
        FreeWifiStateView.this.invalidate();
        AppMethodBeat.o(25139);
      }
    };
    this.mContext = paramContext;
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.left = a.fromDPToPix(this.mContext, 2);
    this.top = this.left;
    this.pde = a.fromDPToPix(this.mContext, 3);
    this.gAC = new ap(Looper.getMainLooper());
    AppMethodBeat.o(25140);
  }
  
  private void Bh(int paramInt)
  {
    AppMethodBeat.i(25143);
    this.gAC.removeCallbacks(this.pdf);
    this.gAC.postDelayed(this.pdf, paramInt);
    AppMethodBeat.o(25143);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(25142);
    super.onDraw(paramCanvas);
    if (this.state == 1)
    {
      int i = getWidth() / 2;
      this.mPaint.setARGB(255, 103, 209, 79);
      this.mPaint.setStrokeWidth(this.pde);
      if (this.right == -1) {
        this.right = (i * 2 - this.left);
      }
      if (this.bottom == -1) {
        this.bottom = this.right;
      }
      paramCanvas.drawArc(new RectF(this.left, this.top, this.right, this.bottom), 270.0F, this.pdd, false, this.mPaint);
      this.pdd += 5;
      if (this.pdd > 365) {
        this.pdd = 0;
      }
      Bh(100);
    }
    AppMethodBeat.o(25142);
  }
  
  public void setState(int paramInt)
  {
    AppMethodBeat.i(25141);
    this.state = paramInt;
    Bh(10);
    AppMethodBeat.o(25141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateView
 * JD-Core Version:    0.7.0.1
 */