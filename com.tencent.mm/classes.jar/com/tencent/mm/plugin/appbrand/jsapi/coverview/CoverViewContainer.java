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
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.jsapi.x.f;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements f
{
  private View arg;
  private float jPi;
  private float jPj;
  private int jPk;
  private Paint jPl;
  private int mBgColor;
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140657);
    this.jPl = new Paint();
    init();
    AppMethodBeat.o(140657);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(140658);
    this.jPl = new Paint();
    init();
    AppMethodBeat.o(140658);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(140660);
    this.jPl = new Paint();
    setTargetView(paramView);
    init();
    AppMethodBeat.o(140660);
  }
  
  public static RectF cz(View paramView)
  {
    AppMethodBeat.i(140670);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    AppMethodBeat.o(140670);
    return paramView;
  }
  
  private void init()
  {
    AppMethodBeat.i(140661);
    this.jPl.setStyle(Paint.Style.STROKE);
    this.jPl.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(140661);
  }
  
  protected final boolean C(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(140669);
    if (this.jPi <= 0.0F)
    {
      AppMethodBeat.o(140669);
      return true;
    }
    double d1 = Math.pow(this.jPi, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.jPi)
    {
      if (paramFloat2 < this.jPi)
      {
        if (Math.pow(this.jPi - paramFloat1, 2.0D) + Math.pow(this.jPi - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.jPi)
      {
        d2 = Math.pow(this.jPi - paramFloat1, 2.0D);
        if (Math.pow(this.jPi + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.jPi) {
      if (paramFloat2 < this.jPi)
      {
        if (Math.pow(this.jPi + paramFloat1 - f1, 2.0D) + Math.pow(this.jPi - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.jPi)
      {
        d2 = Math.pow(this.jPi + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.jPi + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(140669);
          return false;
        }
      }
    }
    AppMethodBeat.o(140669);
    return true;
  }
  
  public boolean aZH()
  {
    return false;
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(140664);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1);
      AppMethodBeat.o(140664);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(140665);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1, paramLayoutParams);
      AppMethodBeat.o(140665);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public final <T> T ax(Class<T> paramClass)
  {
    AppMethodBeat.i(140663);
    try
    {
      if (paramClass.isAssignableFrom(this.arg.getClass()))
      {
        paramClass = this.arg;
        AppMethodBeat.o(140663);
        return paramClass;
      }
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(140663);
    }
    return null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140668);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cz(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!C(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
    {
      AppMethodBeat.o(140668);
      return false;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(140668);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(140662);
    int i;
    if (this.jPi > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.jPi, this.jPi, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.jPj <= 0.0F) {
        break label291;
      }
      float f1 = this.jPj / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.jPi, this.jPi, this.jPl);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.jPi > 0.0F)
      {
        f1 = f2;
        if (this.jPi - this.jPj > 0.0F) {
          f1 = this.jPi - this.jPj;
        }
      }
      localPath.addRoundRect(new RectF(this.jPj, this.jPj, getWidth() - this.jPj, getHeight() - this.jPj), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label291:
    for (;;)
    {
      super.draw(paramCanvas);
      if (i != 0) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(140662);
      return;
      i = 0;
      break;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    this.mBgColor = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(140666);
    this.jPk = paramInt;
    this.jPl.setColor(paramInt);
    AppMethodBeat.o(140666);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.jPi = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(140667);
    this.jPj = paramFloat;
    this.jPl.setStrokeWidth(paramFloat);
    AppMethodBeat.o(140667);
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(140659);
    this.arg = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(140659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */