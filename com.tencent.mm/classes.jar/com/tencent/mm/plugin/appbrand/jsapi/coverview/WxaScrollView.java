package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.mm.plugin.appbrand.jsapi.s.e;

public class WxaScrollView
  extends FrameLayout
  implements o, p, e
{
  private int dIk;
  private float fT;
  private boolean gqA = true;
  private float gqm;
  private int gqn;
  private Paint gqo = new Paint();
  private FrameLayout gqw;
  private ScrollView gqx;
  private m gqy;
  private boolean gqz = true;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.gqx = new WxaScrollView.1(this, getContext());
    this.gqw = new FrameLayout(getContext());
    super.addView(this.gqx, 0, new ViewGroup.LayoutParams(-1, -1));
    this.gqx.addView(this.gqw, 0, new ViewGroup.LayoutParams(-1, -2));
    this.gqo.setStyle(Paint.Style.STROKE);
    this.gqo.setAntiAlias(true);
    setWillNotDraw(false);
  }
  
  public void addView(View paramView, int paramInt)
  {
    this.gqw.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.gqw.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getActionMasked() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      double d1;
      float f3;
      float f4;
      double d2;
      int i;
      if (this.gqm > 0.0F)
      {
        d1 = Math.pow(this.gqm, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.gqm) {
          if (f2 < this.gqm)
          {
            d2 = Math.pow(this.gqm - f1, 2.0D);
            if (Math.pow(this.gqm - f2, 2.0D) + d2 <= d1) {
              break label315;
            }
            i = 0;
          }
        }
      }
      while (i == 0)
      {
        return false;
        if (f2 > f4 - this.gqm)
        {
          d2 = Math.pow(this.gqm - f1, 2.0D);
          if (Math.pow(this.gqm + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.gqm) {
              if (f2 < this.gqm)
              {
                d2 = Math.pow(f1 + this.gqm - f3, 2.0D);
                if (Math.pow(this.gqm - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.gqm)
              {
                d2 = Math.pow(f1 + this.gqm - f3, 2.0D);
                if (Math.pow(this.gqm + f2 - f4, 2.0D) + d2 > d1)
                {
                  i = 0;
                  continue;
                }
              }
            }
          }
        }
        label315:
        i = 1;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    int i;
    if (this.gqm > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.gqm, this.gqm, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.dIk != 0) {
        paramCanvas.drawColor(this.dIk);
      }
      if (this.fT <= 0.0F) {
        break label293;
      }
      float f1 = this.fT / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.gqm, this.gqm, this.gqo);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.gqm > 0.0F)
      {
        f1 = f2;
        if (this.gqm - this.fT > 0.0F) {
          f1 = this.gqm - this.fT;
        }
      }
      localPath.addRoundRect(new RectF(this.fT, this.fT, getWidth() - this.fT, getHeight() - this.fT), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label293:
    for (;;)
    {
      int j = paramCanvas.save();
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      if (i != 0) {
        paramCanvas.restore();
      }
      return;
      i = 0;
      break;
    }
  }
  
  public ViewGroup getTargetView()
  {
    return this.gqw;
  }
  
  public int getTargetViewChildCount()
  {
    return this.gqw.getChildCount();
  }
  
  public void removeView(View paramView)
  {
    this.gqw.removeView(paramView);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    this.gqx.scrollTo(paramInt1, paramInt2);
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    this.dIk = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.gqn = paramInt;
    this.gqo.setColor(paramInt);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.gqm = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    this.fT = paramFloat;
    this.gqo.setStrokeWidth(paramFloat);
  }
  
  public void setOnScrollChangedListener(m paramm)
  {
    this.gqy = paramm;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.gqA = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.gqz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */