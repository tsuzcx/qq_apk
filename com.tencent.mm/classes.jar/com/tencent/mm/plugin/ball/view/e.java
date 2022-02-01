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
  private Paint oZj;
  private Bitmap pcQ;
  private Path pcR;
  private Rect pcS;
  private RectF pcT;
  private int pcU;
  public int pcV;
  public int pcW;
  public int pcX;
  public int pcY;
  public boolean pcZ;
  private int pda;
  private AnimatorListenerAdapter pdb;
  
  public e(Context paramContext, Bitmap paramBitmap)
  {
    super(paramContext);
    AppMethodBeat.i(106522);
    this.pcY = -1;
    this.mPaint = new Paint();
    this.pcR = new Path();
    this.oZj = new Paint();
    paramContext = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    this.oZj.setXfermode(paramContext);
    this.pcQ = paramBitmap;
    this.mWidth = paramBitmap.getWidth();
    this.mHeight = paramBitmap.getHeight();
    this.pcS = new Rect(0, 0, this.mWidth, this.mHeight);
    this.pcT = new RectF();
    this.pcT.left = 0.0F;
    this.pcT.top = 0.0F;
    this.pcT.right = this.mWidth;
    this.pcT.bottom = this.mHeight;
    Log.i("MicroMsg.TransformToFloatBallAnimationMaskView", String.format("init: mWidth:%d mHeight:%d", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) }));
    AppMethodBeat.o(106522);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(106523);
    if (this.pcZ) {
      paramCanvas.translate(this.pcU, 0.0F);
    }
    for (;;)
    {
      this.pcR.reset();
      this.pcR.addRoundRect(this.pcT, this.pcV, this.pcV, Path.Direction.CW);
      paramCanvas.clipPath(this.pcR);
      paramCanvas.drawBitmap(this.pcQ, this.pcS, this.pcS, this.mPaint);
      AppMethodBeat.o(106523);
      return;
      paramCanvas.drawColor(Color.argb(this.pda, 0, 0, 0));
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
    this.pcY = paramInt;
  }
  
  public final void setListener(AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    this.pdb = paramAnimatorListenerAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.e
 * JD-Core Version:    0.7.0.1
 */