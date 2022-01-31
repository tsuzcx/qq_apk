package com.tencent.mm.plugin.appbrand.widget;

import android.animation.Animator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;

public final class CircleProgressDrawable
  extends Drawable
{
  private static final RectF bjX = new RectF(-21.0F, -21.0F, 21.0F, 21.0F);
  private static final RectF bjY = new RectF(-19.0F, -19.0F, 19.0F, 19.0F);
  private int bjZ = Math.round(ae.getResources().getDisplayMetrics().density * 48.0F);
  private int bka = 4;
  private boolean bkb = false;
  private int bkc = 0;
  public CircleProgressDrawable.RingPathTransform hod = new CircleProgressDrawable.RingPathTransform((byte)0);
  public CircleProgressDrawable.RingRotation hoe = new CircleProgressDrawable.RingRotation((byte)0);
  public ArrayList<Animator> mG = new ArrayList();
  private Paint mPaint;
  public int mZ = -16777216;
  
  public final void draw(Canvas paramCanvas)
  {
    Object localObject = getBounds();
    if ((((Rect)localObject).width() == 0) || (((Rect)localObject).height() == 0)) {
      return;
    }
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.bka);
      this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
      this.mPaint.setStrokeJoin(Paint.Join.MITER);
    }
    int i = paramCanvas.save();
    paramCanvas.translate(((Rect)localObject).left, ((Rect)localObject).top);
    int j = ((Rect)localObject).width();
    int k = ((Rect)localObject).height();
    localObject = this.mPaint;
    paramCanvas.scale(j / bjX.width(), k / bjX.height());
    paramCanvas.translate(bjX.width() / 2.0F, bjX.height() / 2.0F);
    if (this.bkb)
    {
      j = paramCanvas.save();
      ((Paint)localObject).setColor(this.bkc);
      paramCanvas.drawArc(bjY, 0.0F, 360.0F, false, (Paint)localObject);
      paramCanvas.restoreToCount(j);
    }
    j = paramCanvas.save();
    ((Paint)localObject).setColor(this.mZ);
    paramCanvas.rotate(CircleProgressDrawable.RingRotation.a(this.hoe));
    float f1 = this.hod.nh;
    float f2 = this.hod.nf;
    float f3 = this.hod.ng;
    float f4 = this.hod.nf;
    paramCanvas.drawArc(bjY, -90.0F + (f1 + f2) * 360.0F, 360.0F * (f3 - f4), false, (Paint)localObject);
    paramCanvas.restoreToCount(j);
    paramCanvas.restoreToCount(i);
  }
  
  public final int getIntrinsicHeight()
  {
    return this.bjZ;
  }
  
  public final int getIntrinsicWidth()
  {
    return this.bjZ;
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  public final void start()
  {
    Iterator localIterator = this.mG.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((Animator)localIterator.next()).isStarted());
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    localIterator = this.mG.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).start();
    }
    invalidateSelf();
  }
  
  public final void stop()
  {
    Iterator localIterator = this.mG.iterator();
    while (localIterator.hasNext()) {
      ((Animator)localIterator.next()).end();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable
 * JD-Core Version:    0.7.0.1
 */