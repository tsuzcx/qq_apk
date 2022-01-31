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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.f;

public class WxaScrollView
  extends FrameLayout
  implements n, o, f
{
  private float gN;
  private float hLe;
  private int hLf;
  private Paint hLg;
  private FrameLayout hLq;
  private ScrollView hLr;
  private m hLs;
  private boolean hLt;
  private boolean hLu;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126323);
    this.hLt = true;
    this.hLu = true;
    this.hLg = new Paint();
    init();
    AppMethodBeat.o(126323);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126324);
    this.hLt = true;
    this.hLu = true;
    this.hLg = new Paint();
    init();
    AppMethodBeat.o(126324);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126325);
    this.hLt = true;
    this.hLu = true;
    this.hLg = new Paint();
    init();
    AppMethodBeat.o(126325);
  }
  
  private void init()
  {
    AppMethodBeat.i(126326);
    this.hLr = new WxaScrollView.1(this, getContext());
    this.hLq = new FrameLayout(getContext());
    super.addView(this.hLr, 0, new ViewGroup.LayoutParams(-1, -1));
    this.hLr.addView(this.hLq, 0, new ViewGroup.LayoutParams(-1, -2));
    this.hLg.setStyle(Paint.Style.STROKE);
    this.hLg.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(126326);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(126329);
    this.hLq.addView(paramView, paramInt);
    AppMethodBeat.o(126329);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(126330);
    this.hLq.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(126330);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126334);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      double d1;
      float f3;
      float f4;
      double d2;
      int i;
      if (this.hLe > 0.0F)
      {
        d1 = Math.pow(this.hLe, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.hLe) {
          if (f2 < this.hLe)
          {
            d2 = Math.pow(this.hLe - f1, 2.0D);
            if (Math.pow(this.hLe - f2, 2.0D) + d2 <= d1) {
              break label325;
            }
            i = 0;
          }
        }
      }
      while (i == 0)
      {
        AppMethodBeat.o(126334);
        return false;
        if (f2 > f4 - this.hLe)
        {
          d2 = Math.pow(this.hLe - f1, 2.0D);
          if (Math.pow(this.hLe + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.hLe) {
              if (f2 < this.hLe)
              {
                d2 = Math.pow(f1 + this.hLe - f3, 2.0D);
                if (Math.pow(this.hLe - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.hLe)
              {
                d2 = Math.pow(f1 + this.hLe - f3, 2.0D);
                if (Math.pow(this.hLe + f2 - f4, 2.0D) + d2 > d1)
                {
                  i = 0;
                  continue;
                }
              }
            }
          }
        }
        label325:
        i = 1;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(126334);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(126327);
    int i;
    if (this.hLe > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.hLe, this.hLe, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.gN <= 0.0F) {
        break label303;
      }
      float f1 = this.gN / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.hLe, this.hLe, this.hLg);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.hLe > 0.0F)
      {
        f1 = f2;
        if (this.hLe - this.gN > 0.0F) {
          f1 = this.hLe - this.gN;
        }
      }
      localPath.addRoundRect(new RectF(this.gN, this.gN, getWidth() - this.gN, getHeight() - this.gN), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label303:
    for (;;)
    {
      int j = paramCanvas.save();
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      if (i != 0) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(126327);
      return;
      i = 0;
      break;
    }
  }
  
  public ViewGroup getTargetView()
  {
    return this.hLq;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(126328);
    int i = this.hLq.getChildCount();
    AppMethodBeat.o(126328);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(126331);
    this.hLq.removeView(paramView);
    AppMethodBeat.o(126331);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126335);
    this.hLr.scrollTo(paramInt1, paramInt2);
    invalidate();
    AppMethodBeat.o(126335);
  }
  
  public void setBgColor(int paramInt)
  {
    this.mBgColor = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(126332);
    this.hLf = paramInt;
    this.hLg.setColor(paramInt);
    AppMethodBeat.o(126332);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.hLe = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(126333);
    this.gN = paramFloat;
    this.hLg.setStrokeWidth(paramFloat);
    AppMethodBeat.o(126333);
  }
  
  public void setOnScrollChangedListener(m paramm)
  {
    this.hLs = paramm;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.hLu = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.hLt = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */