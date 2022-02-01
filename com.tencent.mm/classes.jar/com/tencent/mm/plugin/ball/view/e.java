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
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends View
{
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private Paint vmC;
  private Bitmap vqF;
  private Path vqG;
  private Rect vqH;
  private RectF vqI;
  private int vqJ;
  public int vqK;
  public int vqL;
  public int vqM;
  public int vqN;
  public boolean vqO;
  private int vqP;
  private AnimatorListenerAdapter vqQ;
  
  public e(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.vqN = -1;
    this.mPaint = new Paint();
    this.vqG = new Path();
    this.vmC = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.vmC.setXfermode(paramContext);
    this.vqF = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.vqH = new Rect(0, 0, this.mWidth, this.mHeight);
    this.vqI = new RectF();
    this.vqI.left = 0.0F;
    this.vqI.top = 0.0F;
    this.vqI.right = this.mWidth;
    this.vqI.bottom = this.mHeight;
    Log.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.vqO) {
      paramCanvas.translate(this.vqJ, 0.0F);
    }
    for (;;)
    {
      this.vqG.reset();
      this.vqG.addRoundRect(this.vqI, this.vqK, this.vqK, Path.Direction.CW);
      paramCanvas.clipPath(this.vqG);
      paramCanvas.drawBitmap(this.vqF, this.vqH, this.vqH, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.vqP, 0, 0, 0));
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
    this.vqN = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.vqQ = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.e
 * JD-Core Version:    0.7.0.1
 */