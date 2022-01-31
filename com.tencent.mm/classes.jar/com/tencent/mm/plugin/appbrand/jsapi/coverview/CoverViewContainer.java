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
import com.tencent.mm.plugin.appbrand.jsapi.s.f;

public class CoverViewContainer
  extends AppBrandNativeContainerView
  implements f
{
  private View ajT;
  private float gN;
  private float hLe;
  private int hLf;
  private Paint hLg;
  private int mBgColor;
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(91049);
    this.hLg = new Paint();
    init();
    AppMethodBeat.o(91049);
  }
  
  public CoverViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(91050);
    this.hLg = new Paint();
    init();
    AppMethodBeat.o(91050);
  }
  
  public CoverViewContainer(Context paramContext, View paramView)
  {
    super(paramContext);
    AppMethodBeat.i(91052);
    this.hLg = new Paint();
    setTargetView(paramView);
    init();
    AppMethodBeat.o(91052);
  }
  
  public static RectF cp(View paramView)
  {
    AppMethodBeat.i(141795);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    AppMethodBeat.o(141795);
    return paramView;
  }
  
  private void init()
  {
    AppMethodBeat.i(91053);
    this.hLg.setStyle(Paint.Style.STROKE);
    this.hLg.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(91053);
  }
  
  protected final boolean K(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(141794);
    if (this.hLe <= 0.0F)
    {
      AppMethodBeat.o(141794);
      return true;
    }
    double d1 = Math.pow(this.hLe, 2.0D);
    float f1 = getWidth();
    float f2 = getHeight();
    double d2;
    if (paramFloat1 < this.hLe)
    {
      if (paramFloat2 < this.hLe)
      {
        if (Math.pow(this.hLe - paramFloat1, 2.0D) + Math.pow(this.hLe - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(141794);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.hLe)
      {
        d2 = Math.pow(this.hLe - paramFloat1, 2.0D);
        if (Math.pow(this.hLe + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(141794);
          return false;
        }
      }
    }
    else if (paramFloat1 > f1 - this.hLe) {
      if (paramFloat2 < this.hLe)
      {
        if (Math.pow(this.hLe + paramFloat1 - f1, 2.0D) + Math.pow(this.hLe - paramFloat2, 2.0D) > d1)
        {
          AppMethodBeat.o(141794);
          return false;
        }
      }
      else if (paramFloat2 > f2 - this.hLe)
      {
        d2 = Math.pow(this.hLe + paramFloat1 - f1, 2.0D);
        if (Math.pow(this.hLe + paramFloat2 - f2, 2.0D) + d2 > d1)
        {
          AppMethodBeat.o(141794);
          return false;
        }
      }
    }
    AppMethodBeat.o(141794);
    return true;
  }
  
  public boolean aCT()
  {
    return false;
  }
  
  public final <T> T aa(Class<T> paramClass)
  {
    AppMethodBeat.i(91055);
    try
    {
      if (paramClass.isAssignableFrom(this.ajT.getClass()))
      {
        paramClass = this.ajT;
        AppMethodBeat.o(91055);
        return paramClass;
      }
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(91055);
    }
    return null;
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(91056);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1);
      AppMethodBeat.o(91056);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(91057);
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    for (;;)
    {
      super.addView(paramView, i + 1, paramLayoutParams);
      AppMethodBeat.o(91057);
      return;
      i = paramInt;
      if (paramInt > getChildCount() - 1) {
        i = getChildCount() - 1;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(91060);
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    boolean bool = cp(this).contains(f1, f2);
    if ((paramMotionEvent.getActionMasked() == 0) && (!K(paramMotionEvent.getX(), paramMotionEvent.getY())) && (!bool))
    {
      AppMethodBeat.o(91060);
      return false;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(91060);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(91054);
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
        break label291;
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
    label291:
    for (;;)
    {
      super.draw(paramCanvas);
      if (i != 0) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(91054);
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
    AppMethodBeat.i(91058);
    this.hLf = paramInt;
    this.hLg.setColor(paramInt);
    AppMethodBeat.o(91058);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.hLe = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(91059);
    this.gN = paramFloat;
    this.hLg.setStrokeWidth(paramFloat);
    AppMethodBeat.o(91059);
  }
  
  public void setTargetView(View paramView)
  {
    AppMethodBeat.i(91051);
    this.ajT = paramView;
    super.addView(paramView, 0, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(91051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer
 * JD-Core Version:    0.7.0.1
 */