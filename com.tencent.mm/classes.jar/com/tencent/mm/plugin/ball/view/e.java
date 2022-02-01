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
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends View
{
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private Paint nOq;
  private Bitmap nSa;
  private Path nSb;
  private Rect nSc;
  private RectF nSd;
  private int nSe;
  public int nSf;
  public int nSg;
  public int nSh;
  public int nSi;
  public boolean nSj;
  private int nSk;
  private AnimatorListenerAdapter nSl;
  
  public e(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.nSi = -1;
    this.mPaint = new Paint();
    this.nSb = new Path();
    this.nOq = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.nOq.setXfermode(paramContext);
    this.nSa = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.nSc = new Rect(0, 0, this.mWidth, this.mHeight);
    this.nSd = new RectF();
    this.nSd.left = 0.0F;
    this.nSd.top = 0.0F;
    this.nSd.right = this.mWidth;
    this.nSd.bottom = this.mHeight;
    ae.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.nSj) {
      paramCanvas.translate(this.nSe, 0.0F);
    }
    for (;;)
    {
      this.nSb.reset();
      this.nSb.addRoundRect(this.nSd, this.nSf, this.nSf, Path.Direction.CW);
      paramCanvas.clipPath(this.nSb);
      paramCanvas.drawBitmap(this.nSa, this.nSc, this.nSc, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.nSk, 0, 0, 0));
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
    this.nSi = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.nSl = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.e
 * JD-Core Version:    0.7.0.1
 */