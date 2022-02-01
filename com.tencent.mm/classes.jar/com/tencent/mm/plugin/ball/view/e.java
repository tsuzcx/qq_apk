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
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends View
{
  public int mHeight;
  private Paint mPaint;
  public int mWidth;
  private Paint nir;
  private Bitmap nlO;
  private Path nlP;
  private Rect nlQ;
  private RectF nlR;
  private int nlS;
  public int nlT;
  public int nlU;
  public int nlV;
  public int nlW;
  public boolean nlX;
  private int nlY;
  private AnimatorListenerAdapter nlZ;
  
  public e(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.nlW = -1;
    this.mPaint = new Paint();
    this.nlP = new Path();
    this.nir = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.nir.setXfermode(paramContext);
    this.nlO = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.nlQ = new Rect(0, 0, this.mWidth, this.mHeight);
    this.nlR = new RectF();
    this.nlR.left = 0.0F;
    this.nlR.top = 0.0F;
    this.nlR.right = this.mWidth;
    this.nlR.bottom = this.mHeight;
    ac.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.nlX) {
      paramCanvas.translate(this.nlS, 0.0F);
    }
    for (;;)
    {
      this.nlP.reset();
      this.nlP.addRoundRect(this.nlR, this.nlT, this.nlT, Path.Direction.CW);
      paramCanvas.clipPath(this.nlP);
      paramCanvas.drawBitmap(this.nlO, this.nlQ, this.nlQ, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.nlY, 0, 0, 0));
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
    this.nlW = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.nlZ = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.e
 * JD-Core Version:    0.7.0.1
 */