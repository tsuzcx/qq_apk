package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends View
{
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private Paint nIN;
  public int nMA;
  public int nMB;
  public int nMC;
  public int nMD;
  public boolean nME;
  private int nMF;
  private AnimatorListenerAdapter nMG;
  private Bitmap nMv;
  private Path nMw;
  private Rect nMx;
  private RectF nMy;
  private int nMz;
  
  public e(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.nMD = -1;
    this.mPaint = new Paint();
    this.nMw = new Path();
    this.nIN = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.nIN.setXfermode(paramContext);
    this.nMv = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.nMx = new Rect(0, 0, this.mWidth, this.mHeight);
    this.nMy = new RectF();
    this.nMy.left = 0.0F;
    this.nMy.top = 0.0F;
    this.nMy.right = this.mWidth;
    this.nMy.bottom = this.mHeight;
    ad.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.nME) {
      paramCanvas.translate(this.nMz, 0.0F);
    }
    for (;;)
    {
      this.nMw.reset();
      this.nMw.addRoundRect(this.nMy, this.nMA, this.nMA, Path.Direction.CW);
      paramCanvas.clipPath(this.nMw);
      paramCanvas.drawBitmap(this.nMv, this.nMx, this.nMx, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.nMF, 0, 0, 0));
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106524);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    AppMethodBeat.o(106524);
  }
  
  public final void setContentStartPosX(int paramInt)
  {
    this.nMD = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.nMG = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.e
 * JD-Core Version:    0.7.0.1
 */