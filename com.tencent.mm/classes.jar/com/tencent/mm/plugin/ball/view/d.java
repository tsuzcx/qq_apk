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

public final class d
  extends View
{
  private Paint mGm;
  public int mHeight;
  private Bitmap mJF;
  private Path mJG;
  private Rect mJH;
  private RectF mJI;
  private int mJJ;
  public int mJK;
  public int mJL;
  public int mJM;
  public int mJN;
  public boolean mJO;
  private int mJP;
  private AnimatorListenerAdapter mJQ;
  private Paint mPaint;
  public int mWidth;
  
  public d(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.mJN = -1;
    this.mPaint = new Paint();
    this.mJG = new Path();
    this.mGm = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.mGm.setXfermode(paramContext);
    this.mJF = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.mJH = new Rect(0, 0, this.mWidth, this.mHeight);
    this.mJI = new RectF();
    this.mJI.left = 0.0F;
    this.mJI.top = 0.0F;
    this.mJI.right = this.mWidth;
    this.mJI.bottom = this.mHeight;
    ad.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.mJO) {
      paramCanvas.translate(this.mJJ, 0.0F);
    }
    for (;;)
    {
      this.mJG.reset();
      this.mJG.addRoundRect(this.mJI, this.mJK, this.mJK, Path.Direction.CW);
      paramCanvas.clipPath(this.mJG);
      paramCanvas.drawBitmap(this.mJF, this.mJH, this.mJH, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.mJP, 0, 0, 0));
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
    this.mJN = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.mJQ = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */